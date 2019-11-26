package org.olf.general

import com.k_int.web.toolkit.files.SingleFileAttachment
import com.k_int.web.toolkit.refdata.Defaults
import com.k_int.web.toolkit.refdata.RefdataValue

import grails.gorm.MultiTenant

class DocumentAttachment extends SingleFileAttachment implements MultiTenant<DocumentAttachment> {

  String name
  String location
  String url
  String note
  Date dateCreated
  Date lastUpdated

  //	@Defaults(['License', 'Misc', 'Consortium Negotiation Document'])
  @Defaults(['Consortium authorization statement', 'Product data sheet', 'Vendor terms and conditions'])
  RefdataValue atType

  static mapping = {
             id column: 'da_id'
           name column: 'da_name'
       location column: 'da_location'
            url column: 'da_url'
           note column: 'da_note', type:'text'
         atType column: 'da_type_rdv_fk'
    dateCreated column: 'da_date_created'
    lastUpdated column: 'da_last_updated'
  }

  static constraints = {
           name(nullable:true, blank:false)
       location(nullable:true, blank:false)
            url(nullable:true, blank:false)
           note(nullable:true, blank:false)
         atType(nullable:true, blank:false)
    dateCreated(nullable:true, blank:false)
    lastUpdated(nullable:true, blank:false)
  }

}
