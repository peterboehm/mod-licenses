package org.olf.licenses

import grails.gorm.multitenancy.CurrentTenant
import groovy.util.logging.Slf4j

import org.olf.licenses.License

import com.k_int.okapi.OkapiTenantAwareController

import grails.converters.JSON
import groovy.util.logging.Slf4j


@Slf4j
@CurrentTenant
class LicenseFileController {
   static allowedMethods = [
    uploadLicenseFile: 'POST',
    delete: 'DELETE'
  ]

  LicenseFileDataService licenseFileDataService

  public LicenseFileController() {

   
  }

  def postLicenseFileRaw() {
    log.debug("Called postLicenseFileRaw")
    def f = request.getFile('upload')
    if(f == null) {
      log.debug("No file found")
      notFound()
      return
    }
    LicenseFile licenseFile = licenseFileDataService.save(
      f.contentType,
      f.inputStream.bytes
    )

    if(licenseFile == null) {
      log.debug("unable to create license file")
      notFound()
      return
    }

    if(licenseFile.hasErrors()) {
      log.debug("licenseFile has errors")
      respond(licenseFile.hasErrors())
      return
    }

    log.debug("Returning responseMap")
    log.debug("id is " + licenseFile.id)
    def responseMap = [ id: licenseFile.id, contentType: licenseFile.fileContentType ]
    response.status = 201
    respond responseMap
  }

  def getLicenseFileList() {
    log.debug("Called getLicenseFileList")
    respond licenseFileDataService.list()
  }

  def getLicenseFile() {
    log.debug("Called getLicense file")
    LicenseFile licenseFile = licenseFileDataService.get(params.id)
    if(!licenseFile || licenseFile.fileContentBytes == null) {
      notFound()
      return
    }
    render file: licenseFile.fileContentBytes, contentType: licenseFile.fileContentType
  }

  def deleteLicenseFile() {
    log.debug("Called deleteLicenseFile")
    if(params.id == null) {
      notFound()
      return
    }

    licenseFileDataService.delete(params.id)
    response.status = 204
    render ""
  }

}
