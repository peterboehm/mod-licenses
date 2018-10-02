package org.olf.licenses

import grails.gorm.MultiTenant


class License implements MultiTenant<License> {

  String id
  String name

// allRightsReserved 
// applicabaleCopyrightLaw 
// archivingAllowed 
// archivingFormat 
// authorizedUsers 
// concurrentUsers 
// confidentialityofAgreementRequired 
// confidentialityofUserInformationProtected 
// copyDigital 
// copyPrint 
// coursePackElectronic 
// coursePackPrint 
// distanceEducation 
// fairUseClause 
// governingJurisdiction 
// governingLaw 
// illElectronic 
// illPrint 
// illSecureElectronic 
// indemnificationbyLicensee 
// indemnificationbyLicensor 
// licenseDuration 
// licenseEndAdvanceNoticeRequired 
// licenseEndDate 
// licenseLocation 
// licenseNotes 
// licenseStartDate 
// licenseStatus 
// licenseType 
// linkElectronic 
// otherRestrictions 
// perpetualAccess 
// publisherAcceptsSERU 
// reservesElectronic 
// reservesPrint 
// reviewer 
// reviewerNotes 
// scholarlySharing 
// walkIns 


  static hasMany = [
    props:LicenseCustomProperty
  ]

  static mappedBy = [
    props:'owner'
  ] 

  static constraints = {
  }

  static mapping = {
         id column: 'lic_id', generator: 'uuid', length:36
       name column: 'lic_name'
    version column: 'lic_version'

  }

}
