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

package ims.spinalinjuries.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseMedNeuroSensationImpl extends DomainImpl implements ims.spinalinjuries.domain.MedNeuroSensation, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetNeuroSensationRecord(ims.core.vo.ClinicalContactShortVo voClinicalContact, ims.generalmedical.vo.NeuroSensationFindingsShortVo voNeuroSensation)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveNeuroSensationRecord(ims.generalmedical.vo.NeuroSensationExaminationVo exam)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistVertebralLevel(Boolean activeOnly)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistByCareContext(ims.core.vo.CareContextLiteVo voCareContext)
	{
	}

	@SuppressWarnings("unused")
	public void validategetNeuroSensationByCareContext(ims.core.admin.vo.CareContextRefVo voCareContext, ims.generalmedical.vo.NeuroSensationFindingsShortVo voNeuroSensation)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSpinalMedicalAdmissionSensationByCareContext(ims.core.admin.vo.CareContextRefVo voCareContextRef)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHCPs(String strHcpName)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientProblemByClinicalContact(ims.core.vo.ClinicalContactShortVo voClinicalContact)
	{
	}

	@SuppressWarnings("unused")
	public void validategetNeuroSensationRecordCollByClinCont(ims.core.vo.ClinicalContactShortVo voClinicalContact, ims.generalmedical.vo.NeuroSensationFindingsShortVo voNeuroSens)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientProblemByCareContext(ims.core.admin.vo.CareContextRefVo voCareContext)
	{
	}

	@SuppressWarnings("unused")
	public void validategetNeuroSensationCollByCareContext(ims.core.admin.vo.CareContextRefVo voCareContext, ims.generalmedical.vo.NeuroSensationFindingsShortVo voNeuroSensation)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSpinalMedicalAdmissionSensationByCareContextColl(ims.core.admin.vo.CareContextRefVo voCareContextRef)
	{
	}
}
