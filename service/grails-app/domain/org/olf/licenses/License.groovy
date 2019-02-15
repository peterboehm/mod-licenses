package org.olf.licenses

import com.k_int.web.toolkit.custprops.CustomProperties
import com.k_int.web.toolkit.custprops.types.CustomPropertyContainer
import com.k_int.web.toolkit.tags.Tag
import grails.gorm.MultiTenant
import org.olf.general.Org
import com.k_int.web.toolkit.refdata.RefdataValue;
import com.k_int.web.toolkit.refdata.Defaults;

class License implements CustomProperties,MultiTenant<License> {

  String id
  String name
  String description
  Date dateCreated
  Date lastUpdated
  Date startDate
  Date endDate


  @Defaults(['Local', 'Consortial', 'National', 'Alliance' ])
  RefdataValue type

  @Defaults(['In Negotiation','Not Yet Active', 'Active', 'Rejected', 'Expired'])
  RefdataValue status

  @Defaults(['Explicit', 'Open Ended'])
  RefdataValue endDateSemantics

  static hasMany = [
    links:LicenseLink,
    tags:Tag,
    orgs:LicenseOrg
  ]

  static mappedBy = [
    links:'owner',
    orgs: 'owner'
  ]

  static constraints = {
                name(nullable:false, blank:false)
         description(nullable:true, blank:false)
                type(nullable:true, blank:false)
              status(nullable:true, blank:false)
         dateCreated(nullable:true, blank: true)
         lastUpdated(nullable:true, blank: true)
           startDate(nullable:true, blank: true)
             endDate(nullable:true, blank: true)
    endDateSemantics(nullable:true, blank: true)
  }

  static mapping = {
                  id column: 'lic_id', generator: 'uuid', length:36
                name column: 'lic_name'
         description column: 'lic_description', type:'text'
                type column: 'lic_type_rdv_fk'
              status column: 'lic_status_rdv_fk'
             version column: 'lic_version'
         dateCreated column: 'lic_date_created'
         lastUpdated column: 'lic_last_updated'
           startDate column: 'lic_start_date'
             endDate column: 'lic_end_date'
    endDateSemantics column: 'lic_end_date_semantics_fk'
                tags cascade: 'all-delete-orphan'
               links cascade: 'all-delete-orphan'
  }

  static transients = ['openEnded']

  public boolean isOpenEnded() {
    boolean result = false;
    if ( endDateSemantics?.value?.equalsIgnoreCase('open_ended') ) 
      result = true;
 
    return result;
  }

  public void setOpenEnded(boolean value) {
    if ( value ) {
      setEndDateSemanticsFromString('Open Ended')
    }
    else {
      setEndDateSemanticsFromString('Explicit')
    }
  }
}
