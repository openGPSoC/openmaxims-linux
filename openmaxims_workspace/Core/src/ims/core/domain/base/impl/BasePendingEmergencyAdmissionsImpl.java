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

package ims.core.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BasePendingEmergencyAdmissionsImpl extends DomainImpl implements ims.core.domain.PendingEmergencyAdmissions, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistPendingEmergencyAdmissions(ims.core.vo.PendingEmergencyAdmissionsDataVo data)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistWards(Integer hospitalID, String searchName)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatientShort(ims.core.patient.vo.PatientRefVo patientRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHCP(Integer idHCP)
	{
	}

	@SuppressWarnings("unused")
	public void validategetWard(ims.core.resource.place.vo.LocationRefVo voWardRef)
	{
	}

	@SuppressWarnings("unused")
	public void validategetHospital(ims.core.resource.place.vo.LocationRefVo locationRefvo)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHCPs(ims.core.vo.HcpFilter filter)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLocation(ims.core.resource.place.vo.LocationRefVo voLocRef)
	{
	}

	@SuppressWarnings("unused")
	public void validateremoveFromPendingEmergency(ims.core.vo.PendingEmergencyAdmissionLiteVo pendingEmergency)
	{
		if(pendingEmergency == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'pendingEmergency' of type 'ims.core.vo.PendingEmergencyAdmissionLiteVo' cannot be null.");
	}
}
