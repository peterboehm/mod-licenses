package org.olf.licenses

import com.k_int.web.toolkit.custprops.CustomPropertyDefinition
import com.k_int.web.toolkit.refdata.GrailsDomainRefdataHelpers
import com.k_int.web.toolkit.refdata.RefdataCategory
import com.k_int.web.toolkit.rest.RestfulController
import com.k_int.web.toolkit.utils.DomainUtils

import grails.gorm.multitenancy.CurrentTenant
import grails.web.Controller
import groovy.util.logging.Slf4j

@Slf4j
@CurrentTenant
class CustomPropertyDefinitionController extends com.k_int.web.toolkit.CustomPropertyDefinitionController {
  CustomPropertyDefinitionController() {
    super(CustomPropertyDefinition)
  }
}
