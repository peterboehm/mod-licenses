package org.olf.licenses

import com.k_int.web.toolkit.custprops.CustomProperties
import com.k_int.web.toolkit.custprops.types.CustomPropertyContainer
import com.k_int.web.toolkit.tags.Tag
import grails.gorm.MultiTenant
import org.olf.general.Org
import org.olf.general.DocumentAttachment
import com.k_int.web.toolkit.refdata.RefdataValue;
import com.k_int.web.toolkit.refdata.Defaults;

class LicenseAmendment extends LicenseCore implements CustomProperties,MultiTenant<LicenseAmendment> {  
  License owner

  static belongsTo = [
    owner: License
  ]
  
  static constraints = {
    owner (nullable:false, blank:false)
  }

  static mapping = {
    owner column: 'am_owning_license_fk'
  }
}
