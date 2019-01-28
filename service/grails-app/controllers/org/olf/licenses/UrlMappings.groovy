package org.olf.licenses

class UrlMappings {

  static mappings = {

    "/"(controller: 'application', action:'index')
    "/licenses/licenses"(resources:'license')
    "/licenses/licenseLinks"(resources:'licenseLink')

    '/licenses/refdata'(resources: 'refdata') {
      collection {
        "/$domain/$property" (controller: 'refdata', action: 'lookup')
      }
    }

    '/licenses/custprops'(resources: 'customPropertyDefinition')

    "500"(view: '/error')
    "404"(view: '/notFound')
  }
}
