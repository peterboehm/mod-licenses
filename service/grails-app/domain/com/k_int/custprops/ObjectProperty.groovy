package com.k_int.custprops

import grails.gorm.MultiTenant

class ObjectProperty implements MultiTenant<ObjectProperty> {

  def propName

  // 0 = Object property, link round to TypeDefinition
  // 1 = String
  // 2 = Int
  // 3 = Refdata
  int propType
  

  static constraints = {
  }

}
