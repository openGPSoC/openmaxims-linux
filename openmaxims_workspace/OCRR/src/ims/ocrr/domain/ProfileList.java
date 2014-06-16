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

package ims.ocrr.domain;

// Generated from form domain impl
public interface ProfileList extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listInvestigationIndex
	*/
	public ims.ocrr.vo.InvestigationIndexShortVoCollection listInvestigationIndex(String name, ims.core.vo.ServiceShortVo service, ims.ocrr.vo.lookups.Category categoryLookup, ims.core.vo.lookups.PreActiveActiveInactiveStatus status, Boolean isProfile);

	// Generated from form domain interface definition
	/**
	* getInvestigationIndex
	*/
	public ims.ocrr.vo.InvestigationIndexVo getInvestigationIndex(Integer recordId);

	// Generated from form domain interface definition
	/**
	* Retrieves a distinct list of services for a set of locations by LocationType
	*/
	public ims.core.vo.ServiceShortVoCollection listServiceforLocationByType(ims.core.vo.lookups.LocationType locationType);
}
