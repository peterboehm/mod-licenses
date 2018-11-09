package org.olf.licenses

import geb.spock.GebSpec
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class TestControllerSpec extends GebSpec implements ControllerUnitTest<TestController> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
        true == false
    }
}