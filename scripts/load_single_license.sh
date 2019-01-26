export TARGET="http://localhost:8081"

curl -sSL -H 'Accept:application/json' -H 'Content-Type: application/json' -H 'X-OKAPI-TENANT: diku' -XPOST "$TARGET/licenses/licenses" -d '
{
      "name": "Academic Rights Press/Test Consortium/InteLex Collections - Perpetual Purchase Agreementi 2",
      "type": "Actual",
      "status": "Current",
      "description": "This is a test licenses",
      "customProperties": {
        "licenseEndAdvanceNoticeRequired": ["Yes"]
      },
      "links":[
        { 
          "linkType":"kb-ebsco.package", "linkId":"12-334", "linkLabel":"An example link to an EKB or eholdings defined package", "relation":"describes"
	}
      ]
} 
'
