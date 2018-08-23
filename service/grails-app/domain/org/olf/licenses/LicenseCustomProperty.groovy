package org.olf.licenses;

import com.k_int.custprops.PropertyDefinition
import com.k_int.custprops.CustomProperty
import javax.persistence.Transient

class LicenseCustomProperty extends CustomProperty {

  @Transient
  def grailsApplication

  @Transient
  def messageSource


  static auditable = true

  static belongsTo = [
      type : PropertyDefinition,
      owner: License
  ]

  PropertyDefinition type
  License owner

  @Transient
  def onSave = {
    log.debug("LicenseCustomProperty inserted")
  }
}
