package org.olf.general

import grails.gorm.MultiTenant

class SingleFileAttachment implements MultiTenant<SingleFileAttachment>{
  
  String id
  FileUpload fileUpload
  
  static hasOne = [fileUpload: FileUpload]
  
  static mapping = {
    tablePerHierarchy false
    id generator: 'uuid2', length:36
    fileUpload  column: 'file_upload', cascade: 'all'
  }

  static constraints = {
     fileUpload(nullable:true, blank:false)
  }
}
