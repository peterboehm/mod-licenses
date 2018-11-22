#!/bin/bash

QTEST=`echo '{  "value":"one" }' | jq -r ".value"`

if [ $JQREST="one" ]
then
  echo JQ installed and working
else
  echo Please install JQ
  exit 1
fi

echo Running

echo get licenses config
curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X GET http://localhost:8080/licenses/kiwt/config

echo Load test config
curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X POST http://localhost:8080/config -d @license_properties.json

echo Fetch value list for YNO
## This will retrieve a JSON document describing the YNO category and all it's values
YNO_CAT_VALUES=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X GET http://localhost:8080/licenses/refdataValues?filters='owner.desc%3D%3DYNO'\&sort=value`
YNO_CAT_ID=`echo $YNO_CAT_VALUES | jq -r ".[0].owner.id" | tr -d '\r'`
YNO_NO_ID=`echo $YNO_CAT_VALUES | jq -r ".[0].id" | tr -d '\r'`
YNO_OTHER_ID=`echo $YNO_CAT_VALUES | jq -r ".[1].id" | tr -d '\r'`
YNO_YES_ID=`echo $YNO_CAT_VALUES | jq -r ".[2].id" | tr -d '\r'`
echo KEYS for refdata - YNO Category $YNO_CAT_ID - No=$YNO_NO_ID Yes=$YNO_YES_ID Other=$YNO_OTHER_ID

echo Looking up WalkInAccess property
PROP_WIA=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X GET http://localhost:8080/licenses/custprops?filters='name%3D%3DWalkInAccess' | jq -r ".[0].id"`
PROP_LIC_LOC=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X GET http://localhost:8080/licenses/custprops?filters='name%3D%3DlicenseLocation' | jq -r ".[0].id"`
PROP_INT=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X GET http://localhost:8080/licenses/custprops?filters='name%3D%3DaIntegerProp' | jq -r ".[0].id"`
PROP_DEC=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X GET http://localhost:8080/licenses/custprops?filters='name%3D%3DaDecimalProp' | jq -r ".[0].id"`

echo Create test licenses
TEST_LICENSE_1=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X POST http://localhost:8080/licenses/licenses -d '
{
  name: "Test License 001",
  description: "This is a test licenses",
  licenseProps:[
    { type: "'"$PROP_WIA"'", refValue:"'"$YNO_YES_ID"'", note:"This is a refdata property"  },
    { type: "'"$PROP_LIC_LOC"'", stringValue:"sent in, sent back, queried, lost, found, subjected to public inquiry, lost again, and finally buried in soft peat for three months and recycled as firelighters.", note:"This is a string property" },
    { type: "'"$PROP_INT"'", intValue:34, note:"This is an int property" },
    { type: "'"$PROP_DEC"'", decValue:1.23, note:"This is a dec property" }
  ],
  tags: [
    {value: "Legacy"},
    "Other value",
    "legacy"
  ]
} ' | jq -r ".id"`

TEST_LICENSE_2=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X POST http://localhost:8080/licenses/licenses -d '
{
  name: "Test License 002",
  tags: [
    "legacy"
  ]
} ' | jq -r ".id"`

TEST_LICENSE_3=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X POST http://localhost:8080/licenses/licenses -d '
{
  name: "Test License 003",
  tags: [
    "Test4"
  ]
} ' | jq -r ".id"`

TEST_LICENSE_4=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X POST http://localhost:8080/licenses/licenses -d '
{
  name: "BMJ Journals Online 2011-2012 NESLi2",
  tags: [
    "Test5"
  ]
} ' | jq -r ".id"`

TEST_LICENSE_5=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X POST http://localhost:8080/licenses/licenses -d '
{
  name: "Academic Rights Press/Test Consortium/InteLex Collections - Perpetual Purchase Agreement",
  tags: [
    "Test6"
  ]
} ' | jq -r ".id"`

TEST_LICENSE_6=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X POST http://localhost:8080/licenses/licenses -d '
{
  name: "American Association for the Advancement of Science/NESLi2/Science Classic/2014-2114",
  description: "AAA/NESLi2 consortial license. DIKU University is a signatory to this consortial license",
  tags: [
    "Test7"
  ]
} ' | jq -r ".id"`

echo Retrieve license 1
curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X GET http://localhost:8080/licenses/licenses/$TEST_LICENSE_1
