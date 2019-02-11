databaseChangeLog = {
  changeSet(author: "Ian Ibbotson", id: "2019-02-11-0001") {
    addColumn(tableName: "license") {
      column(name: "lic_end_date_semantics_fk", type: "VARCHAR(36)")
    }
  }
}
