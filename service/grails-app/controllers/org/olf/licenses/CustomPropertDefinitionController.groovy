package org.olf.licenses

import grails.gorm.multitenancy.CurrentTenant
import groovy.util.logging.Slf4j

@Slf4j
@CurrentTenant
class CustomPropertyDefinitionController extends com.k_int.web.toolkit.CustomPropertyDefinitionController {}
