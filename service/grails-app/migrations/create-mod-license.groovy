databaseChangeLog = {

    changeSet(author: "ibbo (generated)", id: "1538475867240-1") {
        createSequence(sequenceName: "hibernate_sequence")
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-2") {
        createTable(tableName: "license") {
            column(name: "lic_id", type: "VARCHAR(36)") {
                constraints(nullable: "false")
            }

            column(name: "lic_version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "lic_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "lic_description", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-3") {
        createTable(tableName: "license_custom_property") {
            column(name: "lcp_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "lcp_version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "ref_value_id", type: "BIGINT")

            column(name: "int_value", type: "INT")

            column(name: "dec_value", type: "NUMBER(19, 2)")

            column(name: "lcp_owner", type: "VARCHAR(36)") {
                constraints(nullable: "false")
            }

            column(name: "string_value", type: "VARCHAR(255)")

            column(name: "lcp_type", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "note", type: "CLOB")
        }
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-4") {
        createTable(tableName: "object_property") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "object_propertyPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "prop_type", type: "INT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-5") {
        createTable(tableName: "property_definition") {
            column(autoIncrement: "true", name: "pd_id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "property_definitionPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "pd_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "pd_type", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "pd_rdc", type: "VARCHAR(255)")

            column(name: "pd_description", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-6") {
        createTable(tableName: "property_value") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "property_valuePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-7") {
        createTable(tableName: "refdata_category") {
            column(autoIncrement: "true", name: "rdc_id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "refdata_categoryPK")
            }

            column(name: "rdc_version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "rdc_description", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "rdc_label", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-8") {
        createTable(tableName: "refdata_value") {
            column(autoIncrement: "true", name: "rdv_id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "refdata_valuePK")
            }

            column(name: "rdv_version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "rdv_use_instead", type: "BIGINT")

            column(name: "rdv_icon", type: "VARCHAR(255)")

            column(name: "rdv_value", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "rdv_owner", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "rdv_desc", type: "VARCHAR(64)")

            column(name: "rdv_sortkey", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-9") {
        createTable(tableName: "refdata_value_label") {
            column(autoIncrement: "true", name: "rdvl_id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "refdata_value_labelPK")
            }

            column(name: "rdvl_version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "rdvl_locale", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "rdvl_owner", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "label", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-10") {
        addPrimaryKey(columnNames: "lic_id", constraintName: "licensePK", tableName: "license")
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-11") {
        addPrimaryKey(columnNames: "lcp_id", constraintName: "license_custom_propertyPK", tableName: "license_custom_property")
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-12") {
        addUniqueConstraint(columnNames: "pd_name", constraintName: "UC_PROPERTY_DEFINITIONPD_NAME_COL", tableName: "property_definition")
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-13") {
        createIndex(indexName: "rdc_description_idx", tableName: "refdata_category") {
            column(name: "rdc_description")
        }
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-14") {
        createIndex(indexName: "rdv_entry_idx", tableName: "refdata_value") {
            column(name: "rdv_value")

            column(name: "rdv_owner")
        }
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-15") {
        createIndex(indexName: "rdvl_entry_idx", tableName: "refdata_value_label") {
            column(name: "rdvl_locale")

            column(name: "rdvl_owner")
        }
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-16") {
        createIndex(indexName: "td_type_idx", tableName: "property_definition") {
            column(name: "pd_type")

            column(name: "pd_rdc")
        }
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-17") {
        addForeignKeyConstraint(baseColumnNames: "ref_value_id", baseTableName: "license_custom_property", constraintName: "FKa06xkp9kqh4ldae6svxk62uqd", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "rdv_id", referencedTableName: "refdata_value")
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-18") {
        addForeignKeyConstraint(baseColumnNames: "rdvl_owner", baseTableName: "refdata_value_label", constraintName: "FKclotewcgrrbmoy8gcyakn3u93", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "rdv_id", referencedTableName: "refdata_value")
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-19") {
        addForeignKeyConstraint(baseColumnNames: "rdv_owner", baseTableName: "refdata_value", constraintName: "FKh4fon2a7k4y8b2sicjm0i6oy8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "rdc_id", referencedTableName: "refdata_category")
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-20") {
        addForeignKeyConstraint(baseColumnNames: "lcp_type", baseTableName: "license_custom_property", constraintName: "FKhltbuif2p9dko3qky5k0fx4l1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "pd_id", referencedTableName: "property_definition")
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-21") {
        addForeignKeyConstraint(baseColumnNames: "lcp_owner", baseTableName: "license_custom_property", constraintName: "FKiun8uoio1qhrb9pf8fd6nqgwd", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "lic_id", referencedTableName: "license")
    }

    changeSet(author: "ibbo (generated)", id: "1538475867240-22") {
        addForeignKeyConstraint(baseColumnNames: "rdv_use_instead", baseTableName: "refdata_value", constraintName: "FKpk86botisjrgyfd5aqljbwla", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "rdv_id", referencedTableName: "refdata_value")
    }
}
