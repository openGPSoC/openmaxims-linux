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

package ims.correspondence.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseCorrespondenceDetailImpl extends DomainImpl implements ims.correspondence.domain.CorrespondenceDetail, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetPatient(ims.core.vo.PatientShort voPatient)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientLocal(ims.core.patient.vo.PatientRefVo voRefPatient)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCorrespondenceDetails(ims.correspondence.vo.CorrespondenceDetailsRefVo voCorrespDetRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCorrespondenceDetailsByPasEvent(ims.core.admin.pas.vo.PASEventRefVo voPasEventRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCorrespondenceStatusHistory(ims.correspondence.vo.CorrespondenceDetailsRefVo voCorrespDetRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCurrentDocument(ims.correspondence.vo.CorrespondenceDetailsRefVo voRefCorrecpondenceDetail)
	{
	}

	@SuppressWarnings("unused")
	public void validategetDocument(ims.core.vo.DocumentVo filter)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPasEvent(ims.core.admin.pas.vo.PASEventRefVo pasEventRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetReport(Integer nReportQueryId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetReportAndTemplate(Integer nReportId, Integer nTemplateIs)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistReferralGps(ims.core.vo.GP voGpFilter)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistSignatories(String medicName)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistTemplateDischargeCategories(ims.admin.vo.ReportTemplateVo templateFilterVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistTemplates(Boolean activeOnly, Integer voMedicId, Integer voLocationId, Integer voServiceId)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveCorrespondenceDetails(ims.correspondence.vo.CorrespondenceDetailsVo voDocDetail, ims.vo.LookupInstVo pasEventType)
	{
	}

	@SuppressWarnings("unused")
	public void validategetEmailAppUser(Integer appUserId)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveDocument(ims.core.vo.DocumentVo document)
	{
	}

	@SuppressWarnings("unused")
	public void validategetMos(String mosName)
	{
	}
}
