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

package ims.oncology.domain;

// Generated from form domain impl
public interface CarePlanDetails extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Return a list of HCPs
	*/
	public ims.core.vo.HcpLiteVoCollection listHcps(String name);

	// Generated from form domain interface definition
	/**
	* Return a collection of cancercareplan records
	*/
	public ims.oncology.vo.CancerCarePlanShortVoCollection listCancerCarePlanByEpisdoeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo episodeRefVo);

	// Generated from form domain interface definition
	/**
	* Save a cancer care plan record - second optional parameter is to mark existing record as isCurrent = false when revising the care plan
	*/
	public ims.oncology.vo.CancerCarePlanVo saveCancerCarePlan(ims.oncology.vo.CancerCarePlanVo voCancerCarePlan) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Get a Cancer Care Plan record.
	*/
	public ims.oncology.vo.CancerCarePlanVo getCancerCarePlanByCareContext(ims.core.vo.CareContextShortVo voCareContextShort, ims.oncology.vo.CancerCarePlanShortVo voCancerCarePlanShort);

	// Generated from form domain interface definition
	/**
	* Get a Cancer Care Plan record by Clinical Contact
	*/
	public ims.oncology.vo.CancerCarePlanVo getCancerCarePlanByClinicalContact(ims.core.vo.ClinicalContactShortVo voClinicalContactShort, ims.oncology.vo.CancerCarePlanShortVo voCancerCarePlan);

	// Generated from form domain interface definition
	/**
	* listCancerCarePlans
	*/
	public ims.oncology.vo.CancerCarePlanLiteVoCollection listCancerCarePlans(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRef);

	// Generated from form domain interface definition
	/**
	* getCancerCarePlan
	*/
	public ims.oncology.vo.CancerCarePlanVo getCancerCarePlan(ims.oncology.vo.CancerCarePlanLiteVo voCancerCarePlanLite);

	// Generated from form domain interface definition
	/**
	* listCancerMDTMeeting
	*/
	public ims.oncology.vo.CancerMDTMeetingVoCollection listCancerMDTMeeting(ims.core.admin.vo.EpisodeOfCareRefVo eocRef);

	// Generated from form domain interface definition
	public ims.oncology.vo.CancerCarePlanShortVoCollection listCancerCarePlanByCareContext(ims.core.admin.vo.CareContextRefVo voCareContextRef);
}
