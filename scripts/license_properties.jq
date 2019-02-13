{
  refdataCategories": {
    "yesno":{
      "desc":"Yes/No/Other", 
      "values":[
        { "value":"Yes", "label":"Yes" },
        { "value":"No", "label":"No" },
        { "value":"Other", "label":"Other (see notes)" }
      ]
    },
    .refdataCategories.permittedprohibited": {
      "desc": "Permitted/Prohibited",
      "values": [
        { "value": "Permitted (explicit)" },
        { "value": "Permitted (explicit) under conditions" },
        { "value": "Permitted (interpreted)" },
        { "value": "Prohibited (explicit)" },
        { "value": "Prohibited (interpreted)" },
        { "value": "Unmentioned" },
        { "value": "Not applicable" }
      ]
    }
  },
  "propertyDefinitions" : [
    {
      "name" : "authorisedUsers",
      "type" : "Text",
      "label" : "Definition of authorised user",
      "description" : "The definition of an authorised user for a resource"
    },{
      "name" : "concurrentAccess",
      "type" : "Integer",
      "label" : "Number of concurrent users allowed",
      "description" : "The number of concurrent users allowed by the resource"
    },{
      "name" : "walkInAccess",
      "category" : .refdataCategories.yesno.id,
      "type" : "Refdata",
      "label" : "Walk-in access permitted?",
      "description" : "Can non-members of the library/instittuion use the resource when in the library"
    },{
      "name" : "remoteAccess",
      "category" : .refdataCategories.yesno.id,
      "type" : "Refdata",
      "label" : "Access restricted to on-campus/campus network?",
      "description" : "Can access to the resource be provided from outside the library or institutional location / network"
    },{
      "name" : "illElectronic",
      "category" : .refdataCategories.permittedprohibited.id,
      "type" : "Refdata",
      "label" : "Electronic ILL",
      "description" : "The right to provide the licensed materials via interlibrary loan by way of electronic copies"
    },{
      "name" : "illSecureElectronic",
      "category" : .refdataCategories.permittedprohibited.id,
      "type" : "Refdata",
      "label" : "Secure Electronic ILL",
      "description" : "The right to provide the licensed materials via interlibrary loan by way of secure electronic transmission"
    },{
      "name" : "illPrint",
      "category" : .refdataCategories.permittedprohibited.id,
      "type" : "Refdata",
      "label" : "Print ILL",
      "description" : "The right to provide the licensed materials via interlibrary loan by way of print copies or facsimile transmission"
    },{
      "name" : "reservesElectronic",
      "category" : .refdataCategories.permittedprohibited.id,
      "type" : "Refdata",
      "label" : "Storage of electronic copies on secure network",
      "description" : "The right to make electronic copies of the licensed materials and store them on a secure network"
    },{
      "name" : "coursePackElectronic",
      "category" : .refdataCategories.permittedprohibited.id,
      "type" : "Refdata",
      "label" : "Use in electronic coursepacks",
      "description" : "The right to use licensed materials in collections or compilations of materials assembled in an electronic format by faculty members for use by students in a class for purposes of instruction"
    },{
      "name" : "coursePackPrint",
      "category" : .refdataCategories.permittedprohibited.id,
      "type" : "Refdata",
      "label" : "Use in print course packs",
      "description" : "The right to use licensed materials in collections or compilations of materials assembled in a print format by faculty members for use by students in a class for purposes of instruction"
    },{
      "name" : "copyDigital",
      "category" : .refdataCategories.permittedprohibited.id,
      "type" : "Refdata",
      "label" : "Making digital copies",
      "description" : "The right of the licensee and authorized users to download and digitally copy a reasonable portion of the licensed materials"
    },{
      "name" : "copyPrint",
      "category" : .refdataCategories.permittedprohibited.id,
      "type" : "Refdata",
      "label" : "Making print copies",
      "description" : "The right of the licensee and authorized users to print a reasonable portion of the licensed materials"
    },{
      "name" : "scholarlySharing",
      "category" : .refdataCategories.permittedprohibited.id,
      "type" : "Refdata",
      "label" : "Sharing for scholarly use",
      "description" : "The right of authorized users and/or licensee to transmit hard copy or electronic copy of reasonable amounts of licensed materials to a third party for personal, scholarly, educational, scientific or professional use"
    },{
      "name" : "otherRestrictions",
      "type" : "Text",
      "label" : "Other restrictions",
      "description" : "Other restrictions expressed in the license"
    },{
      "name" : "textAndDataMining",
      "category" : .refdataCategories.permittedprohibited.id,
      "type" : "Refdata",
      "label" : "Text and Data mining",
      "description" : "Whether it is permitted to use text and data mining processes on the content of the resource"
    },{
      "name" : "metadataUsage",
      "type" : "Text",
      "label" : "Metadata usage",
      "description" : "Any restrictions expressed related to the use of metadata in the platforms"
    },{
      "name" : "authIP",
      "category" : .refdataCategories.yesno.id,
      "type" : "Refdata",
      "label" : "IP authentication supported?",
      "description" : "Whether authentication via IP range is supported"
    },{
      "name" : "authProxy",
      "category" : .refdataCategories.yesno.id,
      "type" : "Refdata",
      "label" : "Access via a proxy supported?",
      "description" : "Whether authentication via a reverse proxy is supported"
    },{
      "name" : "authSAML",
      "category" : .refdataCategories.yesno.id,
      "type" : "Refdata",
      "label" : "SAML compliant authentication supported?",
      "description" : "Whether authentication via SAML compliant method is supported"
    },{
      "name" : "annualOptOut",
      "category" : .refdataCategories.yesno.id,
      "type" : "Refdata",
      "label" : "Annual opt-out clause included?",
      "description" : "Whether the license includes an 'annual opt-out' clause within a multi-year agreement"
    },{
      "name" : "APCAndOffsetting",
      "type" : "Text",
      "label" : "Whether the resource is subject to an APC discount or subscription cost offsetting agreement",
      "description" : "Whether the resource is subject to an APC discount or subscription cost offsetting agreement"
    },{
      "name" : "postCancellationAccess",
      "category" : .refdataCategories.yesno.id,
      "type" : "Refdata",
      "label" : "Post-cancellation terms included?",
      "description" : "Does the license include post-cancellation terms?"
    }
  ],
  "licenseDefs": [
    {
      name: "American Association for the Advancement of Science/NESLi2/Science Classic/2014-2114",
      description: "License for the AAAS Science Classic Agreement",
      status: "Active",
      type: "Actual",
      startDate:"2019-01-01",
      openEnded:true,
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
      status: "Active",
      type: "Actual",
      description: "This is a test licenses",
      startDate:"2019-01-1",
      endDate:"2020-01-01",
      endDateSemantics:"Explicit",
      customProperties: {
        "walkInAccess": ["Yes"],
        "licenseLocation": ["sent in, sent back, queried, lost, found, subjected to public inquiry, lost again, and finally buried in soft peat for three months and recycled as firelighters."],
        "anIntegerProp": [34],
        "aDecimalProp": [1.23]
      },
      "tags": [
        "legacy"
      ],
      "links": [
        {
          "linkType": "kb-ebsco.package", 
          "linkId": "12-334", 
          "linkLabel": "An example link to an EKB or eholdings defined package", 
          "relation": "describes",
          "direction": "out"
        }
      ]
    },
    {
      name: "Test License 002",
      status: "Active",
      type: "Actual",
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
      status: "Deleted",
      type: "Consortial Template",
      openEnded: false,
      endDate: "2019-12-31",
      tags: [
        "Test5"
      ]
    },
    {
      name: "Academic Rights Press/Test Consortium/InteLex Collections - Perpetual Purchase Agreement",
      tags: [
        "Test6"
      ],
      description: "This is a test case for a really long description. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
    }
  ]
}
