package org.olf.licenses

import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory
import org.springframework.context.annotation.Bean

import com.k_int.okapi.OkapiTenantAdminService

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import grails.core.GrailsClass
import groovy.util.logging.Slf4j

import com.k_int.web.toolkit.refdata.GrailsDomainRefdataHelpers;


@Slf4j
class Application extends GrailsAutoConfiguration {

  static void main(String[] args) {
    GrailsApp.run(Application, args)
  }

  @Override
  void doWithDynamicMethods() {
    // Bind extra methods to the class.
    log.debug("Extending Domain classes.")
    (grailsApplication.getArtefacts("Domain")).each {GrailsClass gc ->
      GrailsDomainRefdataHelpers.addMethods(gc)
    }
  }

}
