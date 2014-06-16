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

package ims.clinical.domain;

// Generated from form domain impl
public interface EDischarge extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* get Discharge Details
	*/
	public ims.clinical.vo.DischargeDetailsVo getDischargeDetails(ims.core.admin.vo.CareContextRefVo careContextRefvo);

	// Generated from form domain interface definition
	/**
	* saveDischargeDetails
	*/
	public ims.clinical.vo.DischargeDetailsVo saveDischargeDetails(ims.clinical.vo.DischargeDetailsVo voDischargeDetails) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.clinical.vo.DischargeReadyToLeaveVo getReadyToLeave(ims.core.admin.vo.CareContextRefVo careContextRefvo);

	// Generated from form domain interface definition
	public ims.clinical.vo.DischargeSupplementaryNotesVo saveSupplementaryAndDD(ims.clinical.vo.DischargeSupplementaryNotesVo voDischSupp, ims.clinical.vo.DischargeDetailsVo voDD) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.clinical.vo.DischargeSupplementaryNotesVo getSupplementary(ims.core.admin.vo.CareContextRefVo voCareContextRefVo);

	// Generated from form domain interface definition
	/**
	* getSystemReportAndTemplate
	*/
	public String[] getSystemReportAndTemplate(Integer imsId);

	// Generated from form domain interface definition
	public ims.clinical.vo.DischargeReportDetailVo getDischargeReportDetailsForCareContext(ims.core.admin.vo.CareContextRefVo careContext);
}
