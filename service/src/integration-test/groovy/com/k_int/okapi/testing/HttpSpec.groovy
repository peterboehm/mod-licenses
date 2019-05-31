package com.k_int.okapi.testing

import static groovyx.net.http.ContentTypes.JSON
import static groovyx.net.http.HttpBuilder.configure

import java.util.concurrent.Executors
import org.junit.Before
import com.k_int.okapi.OkapiHeaders

import geb.spock.GebSpec
import grails.web.http.HttpHeaders
import groovy.json.StreamingJsonBuilder
import groovy.util.logging.Slf4j
import groovyx.net.http.FromServer
import groovyx.net.http.HttpBuilder
import groovyx.net.http.HttpConfig
import groovyx.net.http.NativeHandlers
import spock.lang.Shared

@Slf4j
abstract class HttpSpec extends GebSpec {
  
  private static final List<String> EXTRA_JSON_TYPES = [
    'application/vnd.api+json'
  ]
  
  @Shared
  private Map<String, String> defaultHeaders = [
    (OkapiHeaders.TENANT): 'http_tests',
    (OkapiHeaders.USER_ID): 'http_test_user',
    (HttpHeaders.CONTENT_TYPE): 'application/json',
    (HttpHeaders.ACCEPT):       'application/json'
  ]
  
  @Shared
  private HttpBuilder httpClient
  
  Map<String, String> headersOverride = [:]
  protected Map<String, String> setHeaders (Map<String,String> vals) {
    headersOverride.putAll(vals)
  }
  
  private String cleanUri (String uri) {
    if (uri.startsWith('//')) {
      uri = uri.substring(1)
    }
    
    uri
  }
  
  private def buildJson (def jsonObj) {
    if (!(jsonObj instanceof Closure)) {
      return jsonObj
    }
    log.debug "JsonObj is Closure"
    StringWriter sw = new StringWriter()
    def json = new StreamingJsonBuilder(sw)
    json ( jsonObj )
    
    sw.toString()
  }
  
  protected def doGet (final String uri, final Map params = null, final Closure expand = null) {
    httpClient.get({
      request.uri = cleanUri(uri)
      request.uri.query = params
      request.headers = (defaultHeaders + headersOverride)
      
      if (expand) {
        expand.rehydrate(delegate, expand.owner, thisObject)()
      }
    })
  }
  
  protected def doPost (final String uri, final def jsonData, final Map params = null, final Closure expand = null) {
    httpClient.post({
      request.uri = cleanUri(uri)
      request.uri.query = params
      request.body = buildJson(jsonData)
      request.headers = (defaultHeaders + headersOverride)
      
      if (expand) {
        expand.rehydrate(delegate, expand.owner, thisObject)()
      }
    })
  }
  
  protected def doPut (final String uri, final def jsonData, final Map params = null, final Closure expand = null) {
    httpClient.put({
      request.uri = cleanUri(uri)
      request.uri.query = params
      request.body = buildJson(jsonData)
      request.headers = (defaultHeaders + headersOverride)
      
      if (expand) {
        expand.rehydrate(delegate, expand.owner, thisObject)()
      }
    })
  }
  
  protected def doPatch (final String uri, final def jsonData, final Map params = null, final Closure expand = null) {
    httpClient.patch({
      request.uri = cleanUri(uri)
      request.uri.query = params
      request.body = buildJson(jsonData)
      request.headers = (defaultHeaders + headersOverride)
      
      if (expand) {
        expand.rehydrate(delegate, expand.owner, thisObject)()
      }
    })
  }
  
  protected def doDelete (final String uri, final Map params = null, final Closure expand = null) {
    httpClient.delete({
      request.uri = cleanUri(uri)
      request.uri.query = params
      request.headers = (defaultHeaders + headersOverride)
      
      if (expand) {
        expand.rehydrate(delegate, expand.owner, thisObject)()
      }
    })
  }
  
  // Below is a workaround to be able to access spring beans in setupSpec-type methods.
  @Shared private boolean setupSpecDone = false
  @Shared private Closure cleanupClosure = null
  
  @Before
  def setupSpecWithSpringWorkaround() {
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
    
    final String root = "${baseUrl}"
    httpClient = configure {
      
      // Default root as specified in config.
      if (root) {
                 
        log.info "Using default location for okapi at: ${root}"
        request.uri = root
      } else {
        log.info "No config options specifying okapiHost and okapiPort found on startup."
      }
      execution.executor = Executors.newSingleThreadExecutor()

      // Default sending type.
      request.contentType = JSON[0]
      
      // Register vnd.api+json as parsable json.
      response.parser(HttpSpec.EXTRA_JSON_TYPES) { HttpConfig cfg, FromServer fs ->
        NativeHandlers.Parsers.json(cfg, fs)
      }
      
      // Add timeouts.
      client.clientCustomizer { HttpURLConnection conn ->
        conn.connectTimeout = 2000
        conn.readTimeout = 3000
      }
    }
  }
  
}
