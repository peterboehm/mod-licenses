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

    '/licenses/custprops'(resources: 'customPropertyDefinition') {
      collection {
        "/" (controller: 'customPropertyDefinition', action: 'index') {
          perPage = { params.perPage ?: 100 }
          sort = ['weight;asc', 'id;asc']
        }
      }
    }

    '/licenses/org'(resources: 'org') {
      collection {
        "/find/$id"(controller:'org', action:'find')
      }
    }

    "500"(view: '/error')
    "404"(view: '/notFound')
  }
}
