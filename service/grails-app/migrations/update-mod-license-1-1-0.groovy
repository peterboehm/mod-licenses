databaseChangeLog = {
  changeSet(author: "Ian Ibbotson", id: "2019-02-11-0001") {
    addColumn(tableName: "license") {
      column(name: "lic_end_date_semantics_fk", type: "VARCHAR(36)")
    }
  }
  
  changeSet(author: "Steve Osguthorpe", id: "2019-02-13-ERM-6") {
    addColumn(tableName: "custom_property_definition") {
      column (name: "pd_label", type: "VARCHAR(255)") 
      column(name: "pd_weight", type: "INT")
    }
    
    // Set all labels.
    grailsChange {
      change {
        // Create default values for the labels.
        sql.execute("UPDATE ${database.defaultSchemaName}.custom_property_definition SET pd_label = REGEXP_REPLACE(pd_name,'([a-z0-9A-Z])([A-Z][a-z])','\\1 \\2','g');".toString())
      }
    }
    
    // Add the constraints after adding the data.
    addNotNullConstraint (tableName: "custom_property_definition", columnName: "pd_label" )
    addNotNullConstraint (tableName: "custom_property_definition", columnName: "pd_weight", defaultNullValue: 0)
  }

}
