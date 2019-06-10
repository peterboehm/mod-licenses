package org.olf.general

import grails.gorm.MultiTenant

class SingleFileAttachment implements MultiTenant<SingleFileAttachment> {
  
  // Add transient peroperty for flagging file removal. Transients are ignored by the persistence
  // layer.
  static transients = ['fileUploadRemoved']
  FileUpload fileUploadRemoved = null
  
  String id
  FileUpload fileUpload
  static hasOne = [fileUpload: FileUpload]
  
  // Simply flag if the file was updated to null
  void setFileUpload(FileUpload fileUpload) {
    
    fileUploadRemoved = (fileUpload == null && this.fileUpload) ? this.fileUpload : null
    
    this.fileUpload = fileUpload
  }
  
  def afterUpdate() {
    if (fileUploadRemoved) {
      fileUploadRemoved.delete()
    }
  }
  
  static mapping = {
    tablePerHierarchy false
    id generator: 'uuid2', length:36
    fileUpload cascade: 'all'
  }
  
  static constraints = {
    fileUpload nullable: true
  }
}
