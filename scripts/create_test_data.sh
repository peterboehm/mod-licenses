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

TEST_LICENSE_1=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X POST http://localhost:8080/licenses/licenses -d '
{
  name: "Test License 001"
} ' | jq -r ".id"`

TEST_LICENSE_2=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X POST http://localhost:8080/licenses/licenses -d '
{
  name: "Test License 002"
} ' | jq -r ".id"`

TEST_LICENSE_3=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X POST http://localhost:8080/licenses/licenses -d '
{
  name: "Test License 003"
} ' | jq -r ".id"`

