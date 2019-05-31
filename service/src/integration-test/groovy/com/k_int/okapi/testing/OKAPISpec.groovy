package com.k_int.okapi.testing

import static groovyx.net.http.ContentTypes.*
import static org.springframework.http.HttpStatus.*

import org.junit.Assume
import org.springframework.beans.factory.annotation.Autowired

import com.k_int.okapi.OkapiClient
import com.k_int.okapi.OkapiHeaders

import geb.spock.GebSpec
import grails.util.Holders
import grails.web.http.HttpHeaders
import groovyx.net.http.FromServer
import groovyx.net.http.FromServer.Header
import spock.lang.Shared

abstract class OKAPISpec extends GebSpec {
  
  @Shared
  private final Map<String,String> loginDetails = [
    username:'diku_admin',
    password: 'admin'
  ]
  
  @Shared
  private final Map<String,String> headers = [
    (OkapiHeaders.TENANT):      'diku',
    (HttpHeaders.CONTENT_TYPE): 'application/json',
    (HttpHeaders.ACCEPT):       'application/json'
  ]
  
  protected void setLoginDetails(final String username, final String password) {
    loginDetails.putAll (
      username: username,
      password: password
    )
  }
  
  protected void setTenant(final String tenant) {
    headers[(OkapiHeaders.TENANT)] = tenant
  }

  @Autowired
  private OkapiClient okapiClient
  
  @Shared
  private boolean okapiPresent = false
  protected void assumeOkapiPresent() {
    Assume.assumeTrue( okapiPresent )
  }
  protected void assumeOkapiNotPresent() {
    Assume.assumeFalse( okapiPresent )
  }
  
  @Shared
  private boolean okapiSignedIn = false
  protected void assumeOkapiSignedIn() {
    Assume.assumeTrue( okapiSignedIn ) 
  }
  protected void assumeOkapiNotSignedIn() {
    Assume.assumeFalse( okapiSignedIn ) 
  }
  
  /**
   * The below methods handle all the OKAPI interaction. You should use these inside your spec to communicate with OKAPI. 
   */
  protected def doOkapiGet (final String uri, final Map params = null, final Closure expand = null) {
    okapiClient.getSync(uri, params) {
      request.headers = headers
      if (expand) {
        expand.rehydrate(delegate, expand.owner, thisObject)()
      }
    }
  }
  
  protected def doOkapiPost (final String uri, final def jsonData, final Map params = null, final Closure expand = null) {
    okapiClient.post(uri, jsonData, params) {
      request.headers = headers
      if (expand) {
        expand.rehydrate(delegate, expand.owner, thisObject)()
      }
    }
  }
  
  protected def doOkapiPut (final String uri, final def jsonData, final Map params = null, final Closure expand = null) {
    okapiClient.put(uri, jsonData, params) {
      request.headers = headers
      if (expand) {
        expand.rehydrate(delegate, expand.owner, thisObject)()
      }
    }
  }
  
  protected def doOkapiDelete (final String uri, final Map params = null, final Closure expand = null) {
    okapiClient.delete(uri, params) {
      request.headers = headers
      if (expand) {
        expand.rehydrate(delegate, expand.owner, thisObject)()
      }
    }
  }
  
  @Shared Closure cleanupClosure
  @Shared boolean setupSpecDone = false

  def setup() {
    if (!setupSpecDone) {
      setupSpecWithSpring()
      setupSpecDone = true
    }

    cleanupClosure = this.&cleanupSpecWithSpring
  }

  def cleanupSpec() {
    cleanupClosure?.run()
  }

  def setupSpecWithSpring() {
    
    try {
      okapiClient.post('/authn/login', loginDetails, [:]) {
        request.setHeaders(headers)
        response.success { FromServer fs ->
          okapiPresent = true
  
          fs.getHeaders().each { Header h ->
            if (h.key.toLowerCase() == OkapiHeaders.TOKEN.toLowerCase()) {
              headers.put(h.key, h.value)
              okapiSignedIn = true
            }
          }
        }
      }
    } catch (RuntimeException ex) {
      // Suppress the none connectivity of OKAPI.
      if (!(ex.cause instanceof ConnectException)) {
        // Any other error should be thrown so that the specs fail.
        throw ex
      }
      okapiPresent = false
      okapiSignedIn = false 
    }
  }

  def cleanupSpecWithSpring() {
    // Nothing.
  }
}
