databaseChangeLog = {
  changeSet(author: "Steve Osguthorpe", id: "2019-05-08-ERM-6") {
    createTable(tableName: "internal_contact") {
        column(name: "custom_property", type: "TEXT")
    }
  }
}
