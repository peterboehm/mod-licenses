{
  "yesno":{
    "desc":"Yes/No/Other", 
    "values":[
      { "value":"Yes", "label":"Yes" },
      { "value":"No", "label":"No" },
      { "value":"Other", "label":"Other (see notes)" }
    ]
  },
  "propertyDefinitions":[
    { "name":"WalkInAccess", "type":"Refdata", "category": .yesno.id, "description":"Is Walk In Access Allowed" },
    { "name":"AnnualOptOut", "type":"Refdata", "category": .yesno.id },
    { "name":"ILL", "type":"Refdata", "category": .yesno.id },
    { "name":"PartnerAccess", "type":"Refdata", "category": .yesno.id },
    { "name":"IncludeInCoursepacks", "type":"Refdata", "category": .yesno.id },
    { "name":"APCAndOffsetting", "type":"Refdata", "category": .yesno.id },
    { "name":"AuthorisedAccess", "type":"Refdata", "category": .yesno.id },
    { "name":"ConcurrentAccess", "type":"Refdata", "category": .yesno.id },
    { "name":"RemoteAccess", "type":"Refdata", "category": .yesno.id },
    { "name":"PCA", "type":"Refdata", "category": .yesno.id },
    { "name":"MultiSite", "type":"Refdata", "category": .yesno.id },
    { "name":"IncludeInVLE", "type":"Refdata", "category": .yesno.id },
    { "name":"EnterpriseAccess", "type":"Refdata", "category": .yesno.id },
    { "name":"AlumniAccess", "type":"Refdata", "category": .yesno.id },
    { "name":"TextAndDatMining", "type":"Refdata", "category": .yesno.id },
    { "name":"allRightsReserved", "type":"Text" },
    { "name":"applicabaleCopyrightLaw", "type":"Text" },
    { "name":"archivingAllowed", "type":"Refdata", "category": .yesno.id },
    { "name":"archivingFormat", "type":"Text" },
    { "name":"confidentialityofAgreementRequired", "type":"Refdata", "category": .yesno.id },
    { "name":"confidentialityofUserInformationProtected", "type":"Refdata", "category": .yesno.id },
    { "name":"copyDigital", "type":"Refdata", "category": .yesno.id },
    { "name":"copyPrint", "type":"Refdata", "category": .yesno.id },
    { "name":"coursePackElectronic", "type":"Refdata", "category": .yesno.id },
    { "name":"coursePackPrint", "type":"Refdata", "category": .yesno.id },
    { "name":"distanceEducation", "type":"Refdata", "category": .yesno.id },
    { "name":"fairUseClause", "type":"Text" },
    { "name":"governingJurisdiction", "type":"Text" },
    { "name":"governingLaw", "type":"Text" },
    { "name":"illElectronic", "type":"Refdata", "category": .yesno.id },
    { "name":"illPrint", "type":"Refdata", "category": .yesno.id },
    { "name":"illSecureElectronic", "type":"Refdata" , "category": .yesno.id},
    { "name":"indemnificationbyLicensee", "type":"Refdata", "category": .yesno.id },
    { "name":"indemnificationbyLicensor", "type":"Refdata", "category": .yesno.id },
    { "name":"licenseEndAdvanceNoticeRequired", "type":"Refdata", "category": .yesno.id },
    { "name":"licenseLocation", "type":"Text" },
    { "name":"otherRestrictions", "type":"Text" },
    { "name":"perpetualAccess", "type":"Refdata", "category": .yesno.id },
    { "name":"publisherAcceptsSERU", "type":"Refdata", "category": .yesno.id },
    { "name":"reservesElectronic", "type":"Refdata", "category": .yesno.id },
    { "name":"reservesPrint", "type":"Refdata", "category": .yesno.id },
    { "name":"scholarlySharing", "type":"Refdata", "category": .yesno.id },
    { "name":"aIntegerProp", "type":"Integer" },
    { "name":"aDecimalProp", "type":"Decimal" },
    { "name":"testingBoolean", "type":"Boolean" }
  ],
  "licenseDefs": [
    {
      "name": "Test License 001",
      "description": "This is a test licenses",
      "tags": ["New license"],
      "customProperties": {
        "WalkInAccess" :[{"value": .yesno.values[0].id }],
        "IncludeInCoursepacks"  :[{ "value": .yesno.values[1].id }],
        "distanceEducation"  :["Yes"],
        "scholarlySharing"  :[{ "value": "No" }],
        "aDecimalProp"  :[{ "value": 1.2 },{ "value": 1.4 }],
        "aIntegerProp"  :[2,4,6,8],
        "allRightsReserved"  :[{ "value": "Arbitrary text" }],
        "testingBoolean"  :[{ "value": true }]
      }
    }
  ]
}
