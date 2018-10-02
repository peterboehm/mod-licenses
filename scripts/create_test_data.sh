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


echo Create test licenses
TEST_LICENSE_1=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X POST http://localhost:8080/licenses/licenses -d '
{
  name: "Test License 001",
  description: "This is a test licenses"
} ' | jq -r ".id"`

TEST_LICENSE_2=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X POST http://localhost:8080/licenses/licenses -d '
{
  name: "Test License 002"
} ' | jq -r ".id"`

TEST_LICENSE_3=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X POST http://localhost:8080/licenses/licenses -d '
{
  name: "Test License 003"
} ' | jq -r ".id"`

TEST_LICENSE_4=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X POST http://localhost:8080/licenses/licenses -d '
{
  name: "BMJ Journals Online 2011-2012 NESLi2"
} ' | jq -r ".id"`

TEST_LICENSE_5=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X POST http://localhost:8080/licenses/licenses -d '
{
  name: "Academic Rights Press/Test Consortium/InteLex Collections - Perpetual Purchase Agreement"
} ' | jq -r ".id"`

TEST_LICENSE_6=`curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X POST http://localhost:8080/licenses/licenses -d '
{
  name: "American Association for the Advancement of Science/NESLi2/Science Classic/2014-2114",
  description: "AAA/NESLi2 consortial license. DIKU University is a signatory to this consortial license"
} ' | jq -r ".id"`
