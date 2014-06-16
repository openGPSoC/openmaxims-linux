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

package ims.clinical.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseEDischargePatientReadyToLeaveSTHKComponentImpl extends DomainImpl implements ims.clinical.domain.EDischargePatientReadyToLeaveSTHKComponent, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetHintByLookupID(ims.clinicaladmin.vo.lookups.EDischargeHINT voLookup)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistActiveWardsForHospitalLite(ims.core.resource.place.vo.LocationRefVo hospital)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveReadyToLeave(ims.clinical.vo.DischargeReadyToLeaveVo voReady, ims.edischarge.vo.SummaryRefVo voSummary)
	{
	}

	@SuppressWarnings("unused")
	public void validategetReadyToLeave(ims.core.admin.vo.CareContextRefVo careContextRefvo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHcp(ims.core.resource.people.vo.HcpRefVo voRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetDischargeDetails(ims.core.admin.vo.CareContextRefVo careContextRefvo)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistComorbidity(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistComplications(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSystemReportAndTemplate(Integer imsId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetMedication(ims.core.admin.vo.CareContextRefVo careContextRefvo)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveDischargeDetails(ims.clinical.vo.DischargeDetailsVo dischargeDetail)
	{
	}

	@SuppressWarnings("unused")
	public void validategetNurseEnabledInstructions(ims.core.admin.vo.CareContextRefVo careContextRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveDischargeReportDetails(ims.clinical.vo.DischargeReportDetailVo dischargeReportDetail)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAdmissionDateTimeFromAdmissionDetail(ims.core.admin.vo.CareContextRefVo ccRefVo, ims.core.patient.vo.PatientRefVo voPatRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetDischargedEpisodeDetails(ims.core.admin.vo.CareContextRefVo ccRefVo, ims.core.patient.vo.PatientRefVo voPatRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientsGP(ims.core.patient.vo.PatientRefVo patRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCurrentSummary(ims.core.admin.vo.CareContextRefVo ccRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetDisplayStringAfterSave(ims.edischarge.vo.SummaryRefVo summaryId)
	{
	}
}
