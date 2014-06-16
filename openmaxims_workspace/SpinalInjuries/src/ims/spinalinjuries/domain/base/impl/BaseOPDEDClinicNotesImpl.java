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

public abstract class BaseOPDEDClinicNotesImpl extends DomainImpl implements ims.spinalinjuries.domain.OPDEDClinicNotes, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatesaveOPDEDVo(ims.generalmedical.vo.OPDErectDysfxnVo voOPDED)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOPDEDVo(ims.core.vo.ClinicalContactShortVo voClinicalContact)
	{
	}

	@SuppressWarnings("unused")
	public void validategetMedSocialHistory(ims.core.vo.ClinicalContactShortVo voClinicalContactShort)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveMedSocialHistory(ims.core.vo.SocialHistoryVo voSocialHistory)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOPDErectDysfxnByCareContext(ims.core.vo.CareContextLiteVo voCareContext)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistByCareContext(ims.core.vo.CareContextLiteVo voCareContext)
	{
	}

	@SuppressWarnings("unused")
	public void validategetMedSocialHistoryByCareContext(ims.core.vo.CareContextLiteVo voCareContext)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistOPEDCareContextsByEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo refEpisodeOfCare)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHcpLiteByName(String hcpName)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSocialHistoryByPatient(ims.core.patient.vo.PatientRefVo patient)
	{
	}
}
