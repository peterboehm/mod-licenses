package org.olf.licenses
import grails.gorm.MultiTenant

class LicenseFile implements MultiTenant<LicenseFile> {
  String id
  byte[] fileContentBytes
  String fileContentType
  Date lastModified

  static constraints = {
    fileContentBytes nullable: true
    fileContentType nullable: true
    lastModified nullable: true
  }

  static mapping = {
                  id column: 'lf_id', generator: 'uuid2', length: 36
    fileContentBytes column: 'lf_bytes', sqlType: 'longblob'
        lastModified column: 'lf_last_mod' 
  }
}
