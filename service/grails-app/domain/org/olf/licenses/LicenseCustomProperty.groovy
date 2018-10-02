package org.olf.licenses;

import com.k_int.custprops.PropertyDefinition
import com.k_int.custprops.CustomProperty
import javax.persistence.Transient
import grails.gorm.MultiTenant

/**
 * The setup of this class is slightly unusual :: see /src/main/groovy/com/k_int/custprops/CustomProperty.groovy
 * for the definition of CustomProperty - it is not an abstract domain class used for polymorphic inheritance at the database
 * level, but instead a template or different kinds of custom property.
 */
class LicenseCustomProperty extends CustomProperty implements MultiTenant<LicenseCustomProperty> {

  static auditable = true

  static belongsTo = [
      type : PropertyDefinition,
      owner: License
  ]

  PropertyDefinition type
  License owner

  static mapping = {
             id column: 'lcp_id', generator: 'uuid', length:36
           type column: 'lcp_type'
          owner column: 'lcp_owner'
        version column: 'lcp_version'
  }

}
