package mod.license

class License {

  String id
  String name

  static constraints = {
  }

  static mapping = {
         id column: 'lic_id', generator: 'uuid', length:36
       name column: 'lic_name'
    version column: 'ali_version'

  }

}
