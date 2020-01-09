package org.olf.licenses;

import grails.testing.mixin.integration.Integration
import groovy.util.logging.Slf4j
import spock.lang.Shared
import spock.lang.Stepwise
import spock.lang.Unroll

@Slf4j
@Integration
@Stepwise
class LookupSpec extends LicenseLifecycleSpec {
  
  @Shared
  int total = 0
  
  void 'Check we have licenses' () {
    given: 'Lookup licence'
      Map httpResult = doGet('/licenses/licenses', [
        stats: true, // Returns object with metadata instead of list
      ])
    expect:
      (total = httpResult.totalRecords) > 0
  }
  
  @Unroll
  void 'Lookup by #propertyName = #value' (final String propertyName, final def value, final int expect) {
    
    given: 'Lookup licence'
      Map httpResult = doGet('/licenses/licenses', [
        stats: true, // Returns object with metadata instead of list
        filters: [
          "customProperties.${propertyName}==${value}"
        ]
      ])
    expect:
      httpResult.totalRecords == expect
      
    where:
      propertyName                    | value       || expect
      'remoteAccess.value.value'      | 'yes'       || 1
      'concurrentAccess.value'        | 20          || 1
      'remoteAccess.value.value'      | 'no'        || 1
      'concurrentAccess.value'        | 32          || 0
      'remoteAccess'                  | 'no'        || total
      'concurrentAccess'              | 32          || total
  }
}