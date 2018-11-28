package org.olf.licenses

import com.k_int.web.toolkit.custprops.CustomProperties
import com.k_int.web.toolkit.custprops.types.CustomPropertyContainer
import com.k_int.web.toolkit.tags.Tag
import com.k_int.web.toolkit.tags.Taggable
import grails.gorm.MultiTenant
import com.k_int.web.toolkit.refdata.RefdataValue;
import com.k_int.web.toolkit.refdata.Defaults;

class License implements CustomProperties,Taggable,MultiTenant<License> {

  String id
  String name
  String description

  @Defaults(['Actual','Consortial Template'])
  RefdataValue type

  @Defaults(['Current','Deleted'])
  RefdataValue status

  static constraints = {
           name(nullable:false, blank:false)
    description(nullable:true, blank:false)
           type(nullable:true, blank:false)
         status(nullable:true, blank:false)
  }

  static mapping = {
             id column: 'lic_id', generator: 'uuid', length:36
           name column: 'lic_name'
    description column: 'lic_description'
           type column: 'lic_type_rdv_fk'
         status column: 'lic_status_rdv_fk'
        version column: 'lic_version'
  }

}
