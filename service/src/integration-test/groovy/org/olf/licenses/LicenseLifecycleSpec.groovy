package org.olf.licenses

import static groovyx.net.http.ContentTypes.*
import static groovyx.net.http.HttpBuilder.configure
import static org.springframework.http.HttpStatus.*

import com.k_int.okapi.OkapiHeaders
import geb.spock.GebSpec
import grails.gorm.multitenancy.Tenants
import grails.plugins.rest.client.RestBuilder
import grails.testing.mixin.integration.Integration
import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j
import groovyx.net.http.ChainedHttpConfig
import groovyx.net.http.FromServer
import groovyx.net.http.HttpBuilder
import groovyx.net.http.HttpVerb
import spock.lang.IgnoreRest
import spock.lang.Shared
import spock.lang.Stepwise
import spock.lang.Unroll



/**
 * unlike the other integration tests, this test is about simulating the end to end process of creating and managing licenses.
 *
 * The aim of the test is
 *   Load some licenses
 */
@Slf4j
@Integration
@Stepwise
class LicenseLifecycleSpec extends GebSpec {

  final Closure authHeaders = {
    header OkapiHeaders.TOKEN, 'dummy'
    header OkapiHeaders.USER_ID, 'dummy'
    header OkapiHeaders.PERMISSIONS, '[ "license.admin", "license.user", "license.own.read", "license.any.read"]'
  }

  def setup() {
  }

  def cleanup() {
  }
  
  void "Set up test tenants "(tenantid, name) {
    when:"We post a new tenant request to the OKAPI controller"

      log.debug("Post new tenant request for ${tenantid} to ${baseUrl}_/tenant");

      // Lets call delete on this tenant before we call create - this will clean up any prior test runs.
      // We don't care if this fails
      def delete_resp = restBuilder().delete("$baseUrl/_/tenant") {
        header 'X-Okapi-Tenant', tenantid
        authHeaders.rehydrate(delegate, owner, thisObject)()
      }

      // Now post to the _tenant interface to create the tenant
      def resp = restBuilder().post("${baseUrl}_/tenant") {
        header 'X-Okapi-Tenant', tenantid
        authHeaders.rehydrate(delegate, owner, thisObject)()
      }

    then:"The response is correct"
      resp.status == OK.value()

    // Important NOTE:: hibernateDatastore does not currently provide mirror method to addTenantForSchema. Hence when we delete
    // a tenant in the TenantTest we remove the schema, but are unable to remove it from the pool. Re-Adding a tenant added in a
    // previous test will find the old tenant name in the cache, but find the actual schema gone. Until a method is provided in 
    // hibernateDatastore, we will just use a new tenantId in each separate test.
    where:
      tenantid | name
      'LicTestTenantA' | 'LicTestTenantA'
  }

  private RestBuilder restBuilder() {
    new RestBuilder()
  }

}

