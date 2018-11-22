package org.olf.licenses

import com.k_int.web.toolkit.custprops.CustomProperties
import com.k_int.web.toolkit.custprops.types.CustomPropertyContainer
import com.k_int.web.toolkit.tags.Tag
import com.k_int.web.toolkit.tags.Taggable
import grails.gorm.MultiTenant

class License implements CustomProperties,Taggable,MultiTenant<License> {

  String id
  String name
  String description
//  CustomPropertyContainer customProperties
//  
//  static hasMany = [
//    tags: Tag
//  ]

  static constraints = {
           name(nullable:false, blank:false)
    description(nullable:true, blank:false)
  }

  static mapping = {
             id column: 'lic_id', generator: 'uuid', length:36
           name column: 'lic_name'
    description column: 'lic_description'
        version column: 'lic_version'
  }

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

}
