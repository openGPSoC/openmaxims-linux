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

package ims.ocrr.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseNonInpatientSpecimenCollectionImpl extends DomainImpl implements ims.ocrr.domain.NonInpatientSpecimenCollection, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistWorkListItems(ims.ocrr.vo.lookups.SpecimenCollectionStatus specimenStatus, ims.ocrr.vo.lookups.SpecimenCollectionStatus secondSpecimenStatus, ims.framework.utils.Date fromDate, ims.framework.utils.Time fromTime, ims.framework.utils.Date toDate, ims.framework.utils.Time toTime)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistMembersOfStaff(ims.core.vo.MemberOfStaffShortVo filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveWorkListItem(ims.ocrr.vo.SpecimenWorkListItemListVo orderSpecimenVo)
	{
	}

	@SuppressWarnings("unused")
	public void validateisAtLeastOneActivePhlebMayCollect(ims.ocrr.orderingresults.vo.SpecimenWorkListItemRefVo specimenWorkListItemRefVo)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatient(ims.core.patient.vo.PatientRefVo patientRefVo)
	{
	}
}
