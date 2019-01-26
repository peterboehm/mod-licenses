# mod-licenses

Copyright (C) 2018,2019 The Open Library Foundation

This software is distributed under the terms of the Apache License,
Version 2.0. See the file "[LICENSE](LICENSE)" for more information.

## Introduction

FOLIO service module - licenses.

The licenses module provides services to document licenses and their terms, and to link those licenses to arbitrary resources on the folio service platform. The actual license metadata 
is minimal, but mod-licenses then provides a user-extensible set of custom properties where librarians can define and document the terms of their license in a machine readable way. This readme
is split into two sections: The first gives information for developers wanting to use the services that mod-licenses exposes to the FOLIO LSP. The latter sections are intended for developers
looking to maintain and extend mod-licenses.

# For developers wanting to use mod-license resources

If you are a folio module developer looking to use mod-license services the following URL patterns may help you interact with the service:

## Create a license

Post a json document that takes properties as defined in the [license domain class](https://github.com/folio-org/mod-licenses/blob/master/service/grails-app/domain/org/olf/licenses/License.groovy) and creates a new license.

The newly created license is returned, with its id property set so you can extract and reuse the id in other calls.

the status field is a refdata field, but the string is being silently converted into a lookup to make the API more usable. This is also true, in this case, for the licenseEndAdvanceNoticeRequired refdata property "Yes".

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

More detailed examples can be found in the scripts directory - in particular, the [create_test_data.sh](scripts/create_test_data.sh) script which imports data defined in [license_properties.jq](scripts/license_properties.jq)

## Retrieve a license

Use HTTP get against /licenses/licenses/{UUID} for example

    curl -sSL -H 'Accept:application/json' \
              -H "X-Okapi-Token: ${AUTH_TOKEN}" \
              -H 'Content-Type: application/json' \
              -H 'X-OKAPI-TENANT: diku' -XGET \
               "http://OKAPI_HOST:9130/licenses/licenses/ff80818168857f38016885800597003a"

An example of the data returned can be found [here](docs/example_license.json)

## Update a license

Use the Retrieve operation above, then HTTP-PUT the JSON back to /licenses/licenses/{UUID}. Simples.

You can update individual fields by providing just a single property, so to update the description, PUT a JSON document containing only { name : 'value' }. Yes, you are right: this isn't proper PUT semantics. Grails is treating PUT and PATCH as synonyms - expect this to be corrected in the future.

## Delete a license

Well - you *can* execute HTTP-DELETE, but we would PREFER you to post an update to the status of "Deleted". It's not easy to know when it's safe to do a hard delete in a multi tenant environment,
so we suggest you use the status code, and leave the hard-delete operation for a background task that can make sure referential integrity is maintained over the system.

## Search Licenses

Starting with some list everythig queries

### List all licenses and return a count

Use HTTP GET against /licenses/licenses to list all licenses. The URL supports pagination, and adding stats=true will return information about the number of pages, number of hits and records per page.

    curl -sSL -H 'Accept:application/json' \
              -H "X-Okapi-Token: ${AUTH_TOKEN}" \
              -H 'Content-Type: application/json' \
              -H 'X-OKAPI-TENANT: diku' -XGET \
              "http://OKAPI_HOST:9130/licenses/licenses?stats=true"


### List all licenses with a status of Active

Some simple filtering:

mod-licenses uses an existing trait to expose a filter mechanism which automatically exposes domain class properties for filtering. Use filters= to add restrictions.
Multiple filters= parameters are ANDed together, you can use the || syntax to create a logical disjunction. Here we use the 

    curl -sSL -H 'Accept:application/json' \
              -H "X-Okapi-Token: ${AUTH_TOKEN}" \
              -H 'Content-Type: application/json' \
              -H 'X-OKAPI-TENANT: diku' -XGET \
              "http://OKAPI_HOST:9130/licenses/licenses?stats=true&filters=status.value%3Dcurrent"

N.B. searching for lowercase current here as values are normalised for refdata.

### List all the licenses that apply to the package 12-334 as it is defined in eholdings

    curl -sSL -H 'Accept:application/json' \
              -H "X-Okapi-Token: ${AUTH_TOKEN}" \
              -H 'Content-Type: application/json' \
              -H 'X-OKAPI-TENANT: diku' -XGET \
              "http://OKAPI_HOST:9130/licenses/licenses?stats=true&filters=links.linkId%3D12-334"

Actually, this query will just return everything that has a linkId of 12-334 we really should be more specific by saying we want links where the linkId is our FK (12-334) AND the linked record type is kb-ebsco.package:

    curl -sSL -H 'Accept:application/json' \
              -H "X-Okapi-Token: ${AUTH_TOKEN}" \
              -H 'Content-Type: application/json' \
              -H 'X-OKAPI-TENANT: diku' -XGET \
              "http://OKAPI_HOST:9130/licenses/licenses?stats=true&filters=links.linkId%3D12-334&filters=links.linkType%3Dkb-ebsco.package"

### Form a new link with Object 5534-2343-2224-2223 as it's defined in my-new-super-module

To create a new link, you can simply post an update to the license, for example

    curl -sSL -H 'Accept:application/json' \
              -H "X-Okapi-Token: ${AUTH_TOKEN}" \
              -H 'Content-Type: application/json' \
              -H 'X-OKAPI-TENANT: diku' -XPUT \
              "http://OKAPI_HOST:9130/licenses/licenses/UUID-OF-LICENSE-TO-UPDATE" -d ' {
      links:[
        "linkType": "my-new-super-module",
	"linkLabel": "An example link to item 5534-2343-2224-2223 in my-new-super-module",
	"direction": "out",
	"relation": "describes",
        "linkId": "5534-2343-2224-2223"
      ]
    }
    '

### In my-new-super-module List all licenses attached to my resource 5534-2343-2224-2223

    curl -sSL -H 'Accept:application/json' \
              -H "X-Okapi-Token: ${AUTH_TOKEN}" \
              -H 'Content-Type: application/json' \
              -H 'X-OKAPI-TENANT: diku' -XGET \
              "http://OKAPI_HOST:9130/licenses/licenses?stats=true&filters=links.linkId%3D5534-2343-2224-2223&filters=links.linkType%3Dmy-new-super-module"

### List all licenses with a name that starts "ASC"

There are 2 different restruction mechanisms supported, these are provided to mirror the SearchAndSort UI - we looked at the filter method above. Filters are normally 
exact match restrictions and used as a result of facet lists or other hard-coded reference values. In order to provide more traditional left anchored phrase search type functons,
use term and match:

    curl -sSL -H 'Accept:application/json' \
              -H "X-Okapi-Token: ${AUTH_TOKEN}" \
              -H 'Content-Type: application/json' \
              -H 'X-OKAPI-TENANT: diku' -XGET \
              "http://OKAPI_HOST:9130/licenses/licenses?stats=true&term=Academic&match=name"

Match can be repeated to look in multiple fields for term

    curl -sSL -H 'Accept:application/json' \
              -H "X-Okapi-Token: ${AUTH_TOKEN}" \
              -H 'Content-Type: application/json' \
              -H 'X-OKAPI-TENANT: diku' -XGET \
              "http://OKAPI_HOST:9130/licenses/licenses?stats=true&term=Academic&match=name&match=description"

### List all licenses with a custom property licenseEndAdvanceNoticeRequired == Yes

    curl -sSL -H 'Accept:application/json' \
              -H "X-Okapi-Token: ${AUTH_TOKEN}" \
              -H 'Content-Type: application/json' \
              -H 'X-OKAPI-TENANT: diku' -XGET \
              "http://OKAPI_HOST:9130/licenses/licenses?stats=true&filters=customProperties.licenseEndAdvanceNoticeRequired.value%3DYes"

## Listing all the custom properties

List all custom property definitions with the following. The usual CRUD semantics apply

    curl -sSL -H 'Accept:application/json' \
              -H "X-Okapi-Token: ${AUTH_TOKEN}" \
              -H 'Content-Type: application/json' \
              -H 'X-OKAPI-TENANT: diku' -XGET \
              "http://OKAPI_HOST:9130/licenses/custprops?stats=true"

## List all values for a refdata category License.Type

Get a specific refdata category as below. The usual CRUD semantics apply

    curl -sSL -H 'Accept:application/json' \
              -H "X-Okapi-Token: ${AUTH_TOKEN}" \
              -H 'Content-Type: application/json' \
              -H 'X-OKAPI-TENANT: diku' -XGET \
              "http://OKAPI_HOST:9130/licenses/refdata?filter=desc%3dLicense.Type"

# For developers wanting to maintain and extend mod-licenses

## Regenerating the liquibase migrations script

grails -Dgrails.env=vagrant-db dbm-generate-gorm-changelog my-new-changelog.groovy

## Running using grails run-app with the vagrant provided postgres

grails -port 8081 -Dgrails.env=vagrant-db run-app

## Troubleshooting

This module runs on port 8081 when run from the run_external_reg.sh script, and this port is the assumed default for the deployment descriptor. This is so that
module developers can run mod_erm and mod_licenses side by side in development mode.

## Additional information

### Issue tracker

See project [MODLIC](https://issues.folio.org/browse/MODLIC)
at the [FOLIO issue tracker](https://dev.folio.org/guidelines/issue-tracker).

