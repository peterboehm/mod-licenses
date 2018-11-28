export TARGET="http://localhost:8081"

curl -sSL -H 'Accept:application/json' -H 'Content-Type: application/json' -H 'X-OKAPI-TENANT: diku' -XPOST "$TARGET/licenses/licenses" -d '
{
      "name": "Academic Rights Press/Test Consortium/InteLex Collections - Perpetual Purchase Agreementi 2",
      "description": "This is a test licenses",
      "customProperties": {
        "licenseEndAdvanceNoticeRequired": ["Yes"]
      }
} 
'
