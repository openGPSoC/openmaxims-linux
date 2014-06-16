//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.icp.domain;

// Generated from form domain impl
public interface ICPReports extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* getReportAndTemplateByImsId
	*/
	public String[] getReportAndTemplateByImsId(Integer imsId) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* existsRecordsForType
	*/
	public Boolean existsRecordsForType(ims.icps.instantiation.vo.PatientICPRefVo patientIcpRef, java.lang.Object objType) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* getCareContext
	*/
	public ims.core.admin.vo.CareContextRefVo getCareContext(ims.icps.instantiation.vo.PatientICPRefVo patientIcpRef) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.core.vo.PatientDocumentForICPReportsVoCollection getPatientDocuments(ims.icps.instantiation.vo.PatientICPRefVo patientICPRef);

	// Generated from form domain interface definition
	/**
	* listOrderSpecimens
	*/
	public Integer[] listOrderSpecimens(ims.icps.instantiation.vo.PatientICPRefVo patientIcpRef) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* listOrderInvestigations
	*/
	public Integer[] listOrderInvestigations(ims.icps.instantiation.vo.PatientICPRefVo patientIcpRef) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* listPatientAssessments
	*/
	public ims.icp.vo.ICPAssessmentVoCollection listPatientAssessments(ims.icps.instantiation.vo.PatientICPRefVo patientIcpRef) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* listPrinters against current location
	*/
	public String[] listPrinters(Integer locationId) throws ims.domain.exceptions.DomainInterfaceException;
}
