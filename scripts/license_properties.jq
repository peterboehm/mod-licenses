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
    { "name":"walkInAccess", "type":"Refdata", "category": .yesno.id, "description":"Is Walk In Access Allowed" },
    { "name":"walkInAccess_NOTE", "type":"Text" },
    { "name":"annualOptOut", "type":"Refdata", "category": .yesno.id },
    { "name":"ILL", "type":"Refdata", "category": .yesno.id },
    { "name":"partnerAccess", "type":"Refdata", "category": .yesno.id },
    { "name":"includeInCoursepacks", "type":"Refdata", "category": .yesno.id },
    { "name":"includeInCoursepacks_NOTE", "type":"Text" },
    { "name":"APCAndOffsetting", "type":"Refdata", "category": .yesno.id },
    { "name":"authorisedAccess", "type":"Refdata", "category": .yesno.id },
    { "name":"concurrentAccess", "type":"Refdata", "category": .yesno.id },
    { "name":"remoteAccess", "type":"Refdata", "category": .yesno.id },
    { "name":"PCA", "type":"Refdata", "category": .yesno.id },
    { "name":"multiSite", "type":"Refdata", "category": .yesno.id },
    { "name":"includeInVLE", "type":"Refdata", "category": .yesno.id },
    { "name":"enterpriseAccess", "type":"Refdata", "category": .yesno.id },
    { "name":"alumniAccess", "type":"Refdata", "category": .yesno.id },
    { "name":"textAndDatMining", "type":"Refdata", "category": .yesno.id },
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
    { "name":"anIntegerProp", "type":"Integer" },
    { "name":"aDecimalProp", "type":"Decimal" },
    { "name":"testingBoolean", "type":"Boolean" }
  ],
  "licenseDefs": [
    {
      name: "American Association for the Advancement of Science/NESLi2/Science Classic/2014-2114",
      description: "License for the AAAS Science Classic Agreement",
      customProperties: {
        "walkInAccess": ["Yes"],
        "walkInAccess_NOTE": [ "Walk-In Users may be given access to the Licensed Material by any wireless Secure Network. Walk-In Users are not allowed off-site access to the Licensed Material."],
        "includeInCoursepacks": ["Yes"],
        "includeInCoursepacks_NOTE": ["Authorised Users must specify the title and copyright owner of the Licensed Material used in the course packs. Course packs in other formats, such as Braille, may also be offered to Authorised Users. Furthermore"],
        "ILL": ["Yes"],
        "includeInVLE": ["Yes"],
        "remoteAccess": ["Yes"],
        "alumniAccess": ["Yes"],
        "enterpriseAccess": ["No"],
        "APCAndOffsetting": ["Yes"],
        "concurrentAccess": ["Yes"]
      }
    },
    {
      name: "Test License 001",
      description: "This is a test licenses",
      customProperties: {
        "walkInAccess": ["Yes"],
        "licenseLocation": ["sent in, sent back, queried, lost, found, subjected to public inquiry, lost again, and finally buried in soft peat for three months and recycled as firelighters."],
        "anIntegerProp": [34],
        "aDecimalProp": [1.23]
      },
      tags: [
        "legacy"
      ]
    },
    {
      name: "Test License 002",
      tags: [
        "legacy"
      ]
    },
    {
      name: "Test License 003",
      tags: [
        "Test4"
      ]
    },
    {
      name: "BMJ Journals Online 2011-2012 NESLi2",
      tags: [
        "Test5"
      ]
    },
    {
      name: "Academic Rights Press/Test Consortium/InteLex Collections - Perpetual Purchase Agreement",
      tags: [
        "Test6"
      ]
    }
  ]
}
