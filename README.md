# mod-licenses

Copyright (C) 2018 The Open Library Foundation

This software is distributed under the terms of the Apache License,

## Introduction

FOLIO service module - licenses

## Regenerating the liquibase migrations script

grails -Dgrails.env=dbGen dbm-generate-gorm-changelog my-new-changelog.groovy

## Troubleshooting

This module runs on port 8081 when run from the run_external_reg.sh script, and this port is the assumed default for the deployment descriptor. This is so that
module developers can run mod_erm and mod_licenses side by side in development mode.
