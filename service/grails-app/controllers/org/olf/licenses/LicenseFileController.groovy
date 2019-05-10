package org.olf.licenses

import grails.gorm.multitenancy.CurrentTenant
import groovy.util.logging.Slf4j

import org.olf.licenses.License

import com.k_int.okapi.OkapiTenantAwareController

import grails.converters.JSON

@CurrentTenant
class LicenseFileController {
  public LicenseFileController() {
  }

  def uploadLicenseFile(LicenseFileCommand cmd) {
    if(cmd == null) {
      notFound()
      return
    }

    if(cmd.hasErrors()) {
      respond(cmd.hasErrors())
      return
    }

    LicenseFile licenseFile = licenseFileDataService.update(
      cmd.id,
      cmd.version,
      cmd.licenseFile.bytes,
      cmd.licenseFile.contentType)

    if(licenseFile == null) {
      notFound()
      return
    }

    if(licenseFile.hasErrors()) {
      respond(licenseFile.hasErrors())
      return
    }

    def responseMap = [ id: cmd.id, version: cmd.version, contentType: cmd.contentType ]
    respond responseMap

    //return json
  }
}
