# mod-licenses

Copyright (C) 2018 The Open Library Foundation

This software is distributed under the terms of the Apache License,
Version 2.0. See the file "[LICENSE](LICENSE)" for more information.

## Introduction

FOLIO service module - licenses

# For FOLIO service users

If you are a folio module developer looking to use mod-license services the following URL patterns may help you. If you are a developer of mod-licenses, see lower.

## Create a license

Post a json document that takes properties as defined in the [license domain class](https://github.com/folio-org/mod-licenses/blob/master/service/grails-app/domain/org/olf/licenses/License.groovy) and creates a new license.

The newly created license is returned, with its id property set so you can extract and reuse the id in other calls.

the status field is a refdata field, but the string is being silently converted into a lookup to make the API more usable

    curl -sSL -H 'Accept:application/json' \
              -H "X-Okapi-Token: ${AUTH_TOKEN}" \
              -H 'Content-Type: application/json' \
              -H 'X-OKAPI-TENANT: diku' -XPOST \
              "http://OKAPI_HOST:9130/licenses/licenses" -d ' {
    "name": "Academic Rights Press/Test Consortium/InteLex Collections - Perpetual Purchase Agreement 2",
    "description": "This is a test licenses",
    "status": "Current",
    "customProperties": { 
       "licenseEndAdvanceNoticeRequired": ["Yes"] }
    }
    '

Be aware that the Taggable and CustomProperties traits mean the domain class has additional fields.

## Search Licenses

### List all licenses and return a count

Use HTTP GET against /licenses/licenses to list all licenses. The URL supports pagination, and adding stats=true will return information about the number of pages, number of hits and records per page.

    curl -sSL -H 'Accept:application/json' \
              -H "X-Okapi-Token: ${AUTH_TOKEN}" \
              -H 'Content-Type: application/json' \
              -H 'X-OKAPI-TENANT: diku' -XGET \
              "http://OKAPI_HOST:9130/licenses/licenses?stats=true"


### List all licenses with a status of Active

mod-licenses uses an existing trait to expose a filter mechanism which automatically exposes domain class properties for filtering. Use filters= to add restrictions.
Multiple filters= parameters are ANDed together, you can use the || syntax to create a logical disjunction. Here we use the 

    curl -sSL -H 'Accept:application/json' \
              -H "X-Okapi-Token: ${AUTH_TOKEN}" \
              -H 'Content-Type: application/json' \
              -H 'X-OKAPI-TENANT: diku' -XGET \
              "http://OKAPI_HOST:9130/licenses/licenses?stats=true&filters=status.value%3Dcurrent"

N.B. searching for lowercase current here as values are normalised for refdata.

### List all licenses with a name that starts "ASC"

   curl -sSL -H 'Accept:application/json' \
              -H "X-Okapi-Token: ${AUTH_TOKEN}" \
              -H 'Content-Type: application/json' \
              -H 'X-OKAPI-TENANT: diku' -XGET \
              "http://OKAPI_HOST:9130/licenses/licenses?stats=true&filters=name%3DAcademic"

### List all licenses with a custom property licenseEndAdvanceNoticeRequired == Yes

   curl -sSL -H 'Accept:application/json' \
              -H "X-Okapi-Token: ${AUTH_TOKEN}" \
              -H 'Content-Type: application/json' \
              -H 'X-OKAPI-TENANT: diku' -XGET \
              "http://OKAPI_HOST:9130/licenses/licenses?stats=true&filters=customProperties.licenseEndAdvanceNoticeRequired.value%3DYes"

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

