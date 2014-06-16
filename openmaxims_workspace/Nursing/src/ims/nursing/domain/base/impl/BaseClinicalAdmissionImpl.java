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

package ims.nursing.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseClinicalAdmissionImpl extends DomainImpl implements ims.nursing.domain.ClinicalAdmission, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetClinicalAdmission(ims.core.admin.vo.CareContextRefVo careContextRefvo)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveClinicalAdmission(ims.nursing.vo.ClinicalAdmissionVo clinAdmVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAdmissionDetail(Integer pasEventId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPreviousClinicalAdmission(Integer patientId)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCareplans(ims.core.admin.vo.CareContextRefVo careContextrefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistClinicalAdmissions(ims.core.patient.vo.PatientRefVo patientRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetCareContextShort(ims.core.admin.vo.CareContextRefVo careContexxtRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetNurse(ims.core.resource.people.vo.HcpRefVo id)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPASAdmissionDetails(ims.core.admin.pas.vo.PASEventRefVo pasEvent)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPASEvent(ims.core.admin.pas.vo.PASEventRefVo pasEvent)
	{
	}

	@SuppressWarnings("unused")
	public void validategetClinicalAdmissionById(ims.core.clinical.vo.ClinicalAdmissionRefVo clinicalAdmissionId)
	{
	}
}
