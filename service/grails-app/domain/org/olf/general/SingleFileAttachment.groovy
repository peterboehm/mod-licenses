package org.olf.general

import grails.gorm.MultiTenant

class SingleFileAttachment implements MultiTenant<SingleFileAttachment>{
  
  String id
  
  static hasOne = [fileUpload: FileUpload]
  
  static mapping = {
    tablePerHierarchy false
    id generator: 'uuid2', length:36
    fileUpload cascade: 'all'
  }
}
