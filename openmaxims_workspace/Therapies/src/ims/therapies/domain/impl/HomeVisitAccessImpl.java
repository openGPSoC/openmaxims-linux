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
// This code was generated by Peter Martin using IMS Development Environment (version 1.39 build 2173.22508)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.therapies.domain.impl;

import java.util.List;

import ims.therapies.domain.HomeVisitGeneral;
import ims.therapies.domain.HomeVisitRooms;
import ims.therapies.domain.HomeVisitSummary;
import ims.therapies.homeandenvironmentalvisit.domain.objects.HomeVisit;
import ims.therapies.homeandenvironmentalvisit.vo.HomeVisitRefVo;
import ims.therapies.vo.domain.HomeVisitVoAssembler;
import ims.therapies.vo.domain.HomeVisitShortVoAssembler;
import ims.therapies.vo.domain.RoomDetailsVoAssembler;
import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.ClinicalContactRefVo;
import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpLiteVoCollection;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.impl.DomainImpl;
import ims.framework.exceptions.CodingRuntimeException;
import ims.therapies.vo.HomeVisitShortVoCollection;
import ims.therapies.vo.HomeVisitVo;
import ims.therapies.vo.HomeVisitVoCollection;
import ims.therapies.vo.RoomDetailsVoCollection;

public class HomeVisitAccessImpl extends DomainImpl implements ims.therapies.domain.HomeVisitAccess, 
																					HomeVisitGeneral, 
																					HomeVisitRooms, 
																					HomeVisitSummary, ims.domain.impl.Transactional
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeVisitVo getHomeVisit(HomeVisitRefVo voHomeVisitRef)
	{
		if(voHomeVisitRef == null)
			throw new DomainRuntimeException("Invalid Home Visit record to get");

		return HomeVisitVoAssembler.create((HomeVisit) getDomainFactory().getDomainObject(HomeVisit.class, voHomeVisitRef.getID_HomeVisit()));		
	}

	public HomeVisitVo saveHomeVisitAccess(HomeVisitVo homeVisitVo) throws StaleObjectException, UniqueKeyViolationException {
		DomainFactory factory = getDomainFactory();	
		
		if (!homeVisitVo.isValidated())
		{
			throw new DomainRuntimeException("This HomeVisitVo has not been validated");
		}
		
		if(homeVisitVo.getID_HomeVisit() == null)
		{
			if(homeVisitVo.getCareContextIsNotNull())
			{
				HomeVisitVoCollection coll = getHomeVisitVoByCareContext(homeVisitVo.getCareContext());
				if(coll != null && coll.size()>0)
					throw new UniqueKeyViolationException("A Home Visit record already exists for this CareContext. ");
			}
		}
		HomeVisit domHomeVisit = HomeVisitVoAssembler.extractHomeVisit(factory, homeVisitVo);
		
		factory.save(domHomeVisit);
			
		return HomeVisitVoAssembler.create(domHomeVisit);
	}
	
	public HomeVisitVoCollection getHomeVisitVoByCareContext(CareContextRefVo voCareContext)
	{
		String hql = new String("from HomeVisit hv where hv.careContext.id = :CARECONTEXT_ID");

		java.util.List list = getDomainFactory().find(hql, "CARECONTEXT_ID", voCareContext.getID_CareContext());

		return HomeVisitVoAssembler.createHomeVisitVoCollectionFromHomeVisit(list);
	}
	
	public HcpCollection listHcps(Hcp filter) 
	{
		HcpAdmin hcpAdmin = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHCPs(filter);
	}
	
	public HcpLiteVoCollection listHcpLiteByDisciplineType(ims.core.vo.lookups.HcpDisType hcpDisciplineType)
	{
		HcpAdmin hcpAdmin = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHcpLiteByDisciplineType(hcpDisciplineType);
	}

	public HomeVisitShortVoCollection listHomeVisitAccContacts(Integer idCareContext) 
	{
		if (idCareContext != null)
		{
			DomainFactory factory = getDomainFactory();
			List RespTrList  = factory.find(" from HomeVisit hv where hv.careContext.id = :ccId order by hv.authoringInformation",
					new String[]{"ccId"},
					new Object[]{idCareContext});
	
			return HomeVisitShortVoAssembler.createHomeVisitShortVoCollectionFromHomeVisit(RespTrList);
		}
		
		return null;
		
	}

	public HomeVisitVo getHomeVisitAccByClinicalContact(ClinicalContactRefVo voClinicalContactRef)
	{
		if(voClinicalContactRef == null || voClinicalContactRef.getID_ClinicalContact() == null)
			throw new DomainRuntimeException("Contact not provided for get call. ");

		DomainFactory factory = getDomainFactory();
		
		java.util.List home = factory.find("from HomeVisit hv where hv.clinicalContact.id = :contactId", new String[]{"contactId"}, new Object[]{voClinicalContactRef.getID_ClinicalContact()});
		
		if  ((home != null) && (home.size()>0)){
			HomeVisitVoCollection collHomeVisit  = HomeVisitVoAssembler.createHomeVisitVoCollectionFromHomeVisit(home);
			if(collHomeVisit!=null && collHomeVisit.size()!=0)
				return collHomeVisit.get(0);
		}
	
		return null;
	}
	
	public HomeVisitVo getHomeVisitAccByCareContext(CareContextRefVo voCareContextRef)
	{
		if(voCareContextRef == null || voCareContextRef.getID_CareContext() == null)
			throw new DomainRuntimeException("Context not provided for get call. ");

		DomainFactory factory = getDomainFactory();
		
		java.util.List home = factory.find("from HomeVisit hv where hv.careContext.id = :id and hv.clinicalContact is null", new String[]{"id"}, new Object[]{voCareContextRef.getID_CareContext()});
		
		//WDEV-13700
		if  (home == null || home.size() == 0)
			return null;
		
		HomeVisitVoCollection collection = HomeVisitVoAssembler.createHomeVisitVoCollectionFromHomeVisit(home);
		
		if (collection != null && collection.size() > 0) 
			return collection.get(0);

		return null;
	}

	//WDEV-13649
	public RoomDetailsVoCollection listRooms(HomeVisitRefVo homeVisit)
	{
		if(homeVisit == null || homeVisit.getID_HomeVisit() == null)
			throw new CodingRuntimeException("Cannot get Rooms on null HomeVisit Id.");
		
		DomainFactory factory = getDomainFactory();
		String query = "select r from HomeVisit as hv left join hv.rooms as r where hv.id = :HomeVisit";
		
		List<?> list = factory.find(query, new String[] {"HomeVisit"}, new Object[] {homeVisit.getID_HomeVisit()});
		
		return RoomDetailsVoAssembler.createRoomDetailsVoCollectionFromRoomDetails(list);
	}
}
