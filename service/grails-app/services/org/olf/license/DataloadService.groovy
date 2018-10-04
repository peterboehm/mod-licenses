package org.olf.license

import grails.gorm.transactions.Transactional
import com.k_int.refdata.*;
import com.k_int.custprops.PropertyDefinition

@Transactional
class DataloadService {

  def upsertConfigResource(String resource_path) {
    log.debug("upsertConfigResource(${resource_path})");
    InputStream cfg_is = this.class.classLoader.getResourceAsStream(resource_path)
    if ( cfg_is ) {
      upsertConfigIS(cfg_is)
    }
    else {
      log.error("Unable to locate config resource ${resource_path}");
    }
  }

  def upsertConfigIS(InputStream config) {
    log.debug("upsertConfigIS(is)");
    if ( config ) {
      def parsed_config = new groovy.json.JsonSlurper().parse(config)
      upsertConfigJson(parsed_config)
    }
  }

  def upsertConfigJson(config) {
    log.debug("upsertConfigJson(...)");
    config.refdata.each { rdc ->
      upsertRefdataCategory(rdc);
    }

    config.propertyDefinitions.each { pd ->
      upsertPropertyDefinition(pd);
    }
  }

  // "refdata":[
  //    {
  //      "catname":"YNO",
  //      "description":"Yes/No/Other",
  //      "values":[
  //         { "value":"Yes", "label":"Yes", "style":"" },
  //         { "value":"No", "label":"No", "style":"" },
  //         { "value":"Other", "label":"Other (see notes)", "style":"" }
  //      ]
  //    }
  // ],
  def upsertRefdataCategory(rdc) {
    log.debug("upsertRefdataCategory(${rdc})");

    def cat = RefdataCategory.findByDesc(rdc.catname) ?: new RefdataCategory(desc:rdc.catname, label:rdc.description).save(flush:true, failOnError:true);

    rdc.values.each { rdcv ->
      def val = RefdataValue.findByOwnerAndValue(cat, rdcv.value) ?: new RefdataValue(owner:cat, 
                                                                                      value:rdcv.value, 
                                                                                      description:rdcv.description, 
                                                                                      sortKey:rdcv.sortKey, 
                                                                                      icon:rdcv.style).save(flush:true, failOnError:true);
    }
  }

  def upsertPropertyDefinition(pd) {
    log.debug("upsertPropertyDefinition(${pd})");
    PropertyDefinition dbpd = PropertyDefinition.findByName(pd.propname)
    if ( dbpd == null ) {
      dbpd = new PropertyDefinition(name:pd.propname, descr:pd.desc, type:pd.type, refdataCategory:pd.category).save(flush:true, failOnError:true);
    }
  }
}
