package org.olf.licenses

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import groovy.util.logging.Slf4j


@Slf4j
class Application extends GrailsAutoConfiguration {

  static void main(String[] args) {

    // Ensure we have force UTC to be the local application TZ.
    final TimeZone utcTz = TimeZone.getTimeZone("UTC")
    if (TimeZone.default != utcTz) {
      log.info "Timezone default is ${TimeZone.default.displayName}. Setting to UTC"
      TimeZone.default = utcTz
    }

    GrailsApp.run(Application, args)
  }

}
