package org.olf

class UrlMappings {

  static mappings = {

    "/"(controller: 'application', action:'index')
    "/_/tenant"(controller: 'okapi', action:'tenant')

    "/licenses/licenses"(resources:'license')

    "/licenses/kiwt/config/$extended?" (controller: 'config' , action: "resources")
    "/licenses/kiwt/config/schema/$type" (controller: 'config' , action: "schema")
    "/licenses/kiwt/config/schema/embedded/$type" (controller: 'config' , action: "schemaEmbedded")

    "/licenses/ref/blank/$domain/$prop" (controller: 'ref', action: 'blank')


    delete "/$controller/$id(.$format)?"(action:"delete")
    get "/$controller(.$format)?"(action:"index")
    get "/$controller/$id(.$format)?"(action:"show")
    post "/$controller(.$format)?"(action:"save")
    put "/$controller/$id(.$format)?"(action:"update")
    patch "/$controller/$id(.$format)?"(action:"patch")
    "500"(view: '/error')
    "404"(view: '/notFound')
  }
}
