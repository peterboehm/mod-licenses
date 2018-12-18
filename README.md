# mod-licenses

Copyright (C) 2018 The Open Library Foundation

This software is distributed under the terms of the Apache License,

## Introduction

FOLIO service module - licenses

## Regenerating the liquibase migrations script

grails -Dgrails.env=dbGen dbm-generate-gorm-changelog my-new-changelog.groovy

## Running using grails run-app with the vagrant provided postgres

grails -port 8081 -Dgrails.env=vagrant-db run-app

## Troubleshooting

This module runs on port 8081 when run from the run_external_reg.sh script, and this port is the assumed default for the deployment descriptor. This is so that
module developers can run mod_erm and mod_licenses side by side in development mode.

## Additional information

### Issue tracker

See project [MODLIC](https://issues.folio.org/browse/MODLIC)
at the [FOLIO issue tracker](https://dev.folio.org/guidelines/issue-tracker).

