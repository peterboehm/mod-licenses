databaseChangeLog = {
  changeSet(author: "efreestone (manual)", id: "202003171414-1") {
      modifyDataType( 
        tableName: "custom_property_definition", 
        columnName: "pd_description", 
        newDataType: "CLOB",
        confirm: "Successfully updated the pd_description column."
      )
  }
}
