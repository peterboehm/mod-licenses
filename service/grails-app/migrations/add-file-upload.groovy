databaseChangeLog = {
  changeSet(author: "Kurt Nordstrom", id: "2019-05-14-0001") {
    addColumn(tableName: "document_attachment") {
      column(name: "da_license_file_id", type: "VARCHAR(255)")
    }
  
  }

  changeSet(author: "Kurt Nordstrom", id: "2019-05-14-0002") {
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

            column(name: "fu_last_mod", type: "timestamp")

            column(name: "file_content_type", type: "VARCHAR(255)")

            column(name: "fu_filename", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "fu_bytes", type: "bytea")
        }

    }
}
