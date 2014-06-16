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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.54 build 2691.18959)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.oncology.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.MosAdmin;
import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.admin.domain.impl.MosAdminImpl;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.assessment.vo.UserAssessmentVo;
import ims.assessment.vo.UserAssessmentVoCollection;
import ims.assessment.vo.domain.UserAssessmentVoAssembler;
import ims.clinical.domain.objects.SurgeryDetails;
import ims.clinical.vo.SurgeryDetailsListVoCollection;
import ims.clinical.vo.domain.SurgeryDetailsListVoAssembler;
import ims.clinical.vo.domain.SurgeryDetailsVoAssembler;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.UserDefinedAssessmentType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.oncology.domain.base.impl.BaseSurgeryDetailsImpl;

public class TheatreSessionImpl extends BaseSurgeryDetailsImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* saveSurgeryDetails
	*/
	public ims.clinical.vo.SurgeryDetailsVo saveSurgeryDetails(ims.clinical.vo.SurgeryDetailsVo surgVo) throws ims.domain.exceptions.StaleObjectException
	{
		DomainFactory factory = getDomainFactory();
		SurgeryDetails doSD = SurgeryDetailsVoAssembler.extractSurgeryDetails(factory, surgVo);
		factory.save(doSD);
		return SurgeryDetailsVoAssembler.create(doSD);
	}

	/**
	* getSurgeryDetails
	*/
	public ims.clinical.vo.SurgeryDetailsVo getSurgeryDetails(ims.clinical.vo.SurgeryDetailsRefVo sdRefVo)
	{
		return SurgeryDetailsVoAssembler.create((SurgeryDetails)getDomainFactory().getDomainObject(SurgeryDetails.class, sdRefVo.getID_SurgeryDetails()));
	}

	/**
	* listSurgeryDetails
	*/

	public SurgeryDetailsListVoCollection listSurgeryDetails(EpisodeOfCareRefVo episodeOfCare)
	{
		if (episodeOfCare == null || !episodeOfCare.getID_EpisodeOfCareIsNotNull())
			throw new DomainRuntimeException("Can not search for surgery details after a null or invalid episode of care");
		
		DomainFactory factory = getDomainFactory();
		String hql = "from SurgeryDetails sd where sd.episodeOfCare.id = " + episodeOfCare.getID_EpisodeOfCare();
		
		return SurgeryDetailsListVoAssembler.createSurgeryDetailsListVoCollectionFromSurgeryDetails((factory.find(hql))).sort();
	}

	/**
	* Returns a MosList based on the search criteria in the passed in filter
	*/
	public ims.core.vo.MemberOfStaffShortVoCollection listMembersOfStaff(ims.core.vo.MemberOfStaffShortVo filter)
	{
		MosAdmin mosAdminIml = (MosAdmin)getDomainImpl(MosAdminImpl.class);
		return mosAdminIml.listMembersOfStaff(filter);
	}

	/**
	* List Oraganisations
	*/
	public ims.core.vo.OrganisationVoCollection listOrganisation(ims.core.vo.OrganisationVo organisation)
	{
		OrganisationAndLocation org = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return org.listOrganisation(organisation, Boolean.TRUE, Boolean.TRUE);
	}

	public ims.core.vo.HcpLiteVoCollection listHcpLiteByName(String hcpName)
	{
		HcpAdmin impl = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return impl.listHcpLiteByName(hcpName);
	}

	public UserAssessmentVo getAssessment(PreActiveActiveInactiveStatus status, UserDefinedAssessmentType assessmentType) 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" ");
		String query = "from UserAssessment u ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if (status != null)
		{
			hql.append(andStr + " u.activeStatus =:status");
			markers.add("status");
			values.add(getDomLookup(status));
			andStr = " and ";
		}

		if (andStr != " ")
			hql.append(andStr);
		
		hql.append(" u.assessmentType.id =:assessmentType" );
		markers.add("assessmentType");
		values.add(new Integer(assessmentType.getId()));
		andStr = " or ";

		if (markers.size() > 0)
			query += " where ";

		query += hql.toString();

		List list = factory.find(query, markers, values);
		UserAssessmentVoCollection coll = UserAssessmentVoAssembler.createUserAssessmentVoCollectionFromUserAssessment(list);
		if(coll != null && coll.size() > 0)
			return coll.get(0);

		return null;
	}
}
