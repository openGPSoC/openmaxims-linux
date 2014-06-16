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

package ims.scheduling.domain;

// Generated from form domain impl
public interface GenerateSessions extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.scheduling.vo.DirectoryOfServiceVoCollection listDos();

	// Generated from form domain interface definition
	public ims.scheduling.vo.ProfileShortVoCollection listProfile(ims.scheduling.vo.DirectoryOfServiceVo directoryOfService, ims.core.vo.ServiceFunctionVo function);

	// Generated from form domain interface definition
	/**
	* Generates session slots for the given directory of service, from date and to date.  Used by the ICAB gateway
	*/
	public Integer generateSessionSlots(String directoryOfService, ims.framework.utils.Date fromDate, ims.framework.utils.Date toDate) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection loadLocations();

	// Generated from form domain interface definition
	public ims.scheduling.vo.ProfileShortVoCollection loadProfiles(ims.core.resource.place.vo.LocationRefVo location, String name);

	// Generated from form domain interface definition
	public ims.scheduling.vo.ProfileShortVoCollection listProfiles(ims.core.resource.place.vo.LocationRefVo location, ims.scheduling.vo.Sch_ProfileRefVo profile, ims.core.clinical.vo.ServiceRefVo service, Boolean isActive);

	// Generated from form domain interface definition
	/**
	* listActiveServiceByName
	*/
	public ims.core.vo.ServiceLiteVoCollection listActiveServiceByName(String name);

	// Generated from form domain interface definition
	/**
	* getProfile
	*/
	public ims.scheduling.vo.ProfileShortVo getProfile(ims.scheduling.vo.Sch_ProfileRefVo profile);

	// Generated from form domain interface definition
	/**
	* WDEV-12664 - count the number of generated sessions for a Profile
	*/
	public Integer countSessionsForProfile(ims.scheduling.vo.Sch_ProfileRefVo profile);

	// Generated from form domain interface definition
	public Boolean createAdHocSession(ims.scheduling.vo.ProfileShortVo profile, ims.framework.utils.Date date) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;
}
