databaseChangeLog = {
  changeSet(author: "sosguthorpe (generated)", id: "1559723235562-1") {
    createTable(tableName: "file_upload") {
      column(name: "fu_id", type: "VARCHAR(36)") {
        constraints(nullable: "false")
      }

      column(name: "version", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "fu_filesize", type: "BIGINT") {
        constraints(nullable: "false")
      }

      column(name: "fu_last_mod", type: "TIMESTAMP WITHOUT TIME ZONE")

      column(name: "file_content_type", type: "VARCHAR(255)")

      column(name: "fu_owner", type: "VARCHAR(36)") {
        constraints(nullable: "false")
      }

      column(name: "fu_filename", type: "VARCHAR(255)") {
        constraints(nullable: "false")
      }

      column(name: "fu_bytes", type: "BYTEA")
    }
  }

  changeSet(author: "sosguthorpe (generated)", id: "1559723235562-2") {
    addPrimaryKey(columnNames: "fu_id", constraintName: "file_uploadPK", tableName: "file_upload")
  }

}
