package org.olf.licenses

import grails.gorm.services.Service

@Service(LicenseFile)
interface LicenseFileDataService {
  LicenseFile get(String id)
  List<LicenseFile> list(Map args)
  Number count()
  void delete(Serializable id)
  LicenseFile save(String fileContentType, String fileName, Long fileSize, Date lastModified,  byte[] fileContentBytes)
}
