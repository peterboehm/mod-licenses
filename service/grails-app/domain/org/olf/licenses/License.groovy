package org.olf.licenses

import grails.gorm.MultiTenant


class License implements MultiTenant<License> {

  String id
  String name

  static constraints = {
  }

  static mapping = {
         id column: 'lic_id', generator: 'uuid', length:36
       name column: 'lic_name'
    version column: 'lic_version'

  }

}
