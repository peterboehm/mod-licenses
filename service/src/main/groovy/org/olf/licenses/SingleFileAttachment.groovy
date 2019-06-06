package org.olf.licenses

import grails.gorm.MultiTenant
import grails.gorm.annotation.Entity
import javax.persistence.MappedSuperclass
import org.olf.general.FileUpload

@MappedSuperclass
abstract class SingleFileAttachment {
  
  String id
  FileUpload fileUpload
  
  static hasOne = [fileUpload: FileUpload]
  
  static mapping = {
    fileUpload  column: 'file_upload', cascade: 'all'
  }
  
  static mappedBy = [fileUpload: 'owner']

  static constraints = {
     fileUpload(nullable:true, blank:false)
  }
}
