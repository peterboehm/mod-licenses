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

export TARGET="http://localhost:8081"

# echo get licenses config
# curl --header "X-Okapi-Tenant: diku" -H "Content-Type: application/json" -X GET http://localhost:8080/licenses/kiwt/config
echo "Load JSON file"

# Because of the template placeholders in the file now, we load passing in empty object as substitutions.
json_data_file=`cat license_properties.jq`
json_data=`echo '{}' | jq "$json_data_file"`
json_result="$json_data"
IFS=$'\n'       # make newlines the only separator

echo "Load test refdata"
yesNo=$(echo "$json_result" | jq -rc ".yesno" )
echo "Posting ${yesNo}"
result=$(curl -sSL -H 'Accept:application/json' -H 'Content-Type: application/json' -H 'X-OKAPI-TENANT: diku' -XPOST "$TARGET/licenses/refdata" -d "${yesNo}")
echo $result | jq

# Write the yes no value returned from the server to the json data internally for substitution, and reload from the file.
json_data=`echo "$json_data" | jq ".yesno=$result"`
json_result=`echo "$json_data" | jq "$json_data_file"`

echo "Load prop defs"
count=0
for row in $(echo "$json_result" | jq -rc ".propertyDefinitions[]" ); do
  echo "Posting ${row}"
  result=$(curl -sSL -H 'Accept:application/json' -H 'Content-Type: application/json' -H 'X-OKAPI-TENANT: diku' -XPOST "$TARGET/licenses/custprops" -d "${row}")
  echo $result | jq
  json_data=`echo "$json_data" | jq ".propertyDefinitions[$count] = $result"`
  count=$((count+1)) 
done

# Reload JSON result with any returned vals above.
json_result=`echo "$json_data" | jq "$json_data_file"`

# Load the licenses.
echo "Load licenses"
count=0
for row in $(echo "$json_result" | jq -rc ".licenseDefs[]"); do
  echo "Posting ${row}"
  result=$(curl -sSL -H 'Accept:application/json' -H 'Content-Type: application/json' -H 'X-OKAPI-TENANT: diku' -XPOST "$TARGET/licenses/licenses" -d "${row}")
  echo $result | jq
  json_data=`echo "$json_data" | jq ".licenseDefs[$count] = $result"`
  count=$((count+1))
done

echo "Final JSON data"
echo "$json_data" | jq

echo Run a search for licenses
./okapi-cmd /licenses/licenses
