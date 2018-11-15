package org.olf.licenses

import grails.gorm.multitenancy.CurrentTenant
import groovy.util.logging.Slf4j

@Slf4j
@CurrentTenant
class RefdataController extends com.k_int.web.toolkit.RefdataController {}