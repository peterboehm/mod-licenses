package mod.license

class UrlMappings {

  static mappings = {

    "/"(controller: 'application', action:'index')
    "/_/tenant"(controller: 'okapi', action:'tenant')

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