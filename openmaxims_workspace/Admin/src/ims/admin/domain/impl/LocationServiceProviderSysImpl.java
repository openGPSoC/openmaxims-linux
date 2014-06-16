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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.44 build 2244.18931)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import java.util.List;
import ims.admin.domain.LocationService;
import ims.admin.domain.impl.LocationServiceImpl;
import ims.core.resource.place.vo.LocationRefVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.ocrr.configuration.domain.objects.LocSvcProviderSys;
import ims.core.admin.domain.objects.ProviderSystem;
import ims.core.admin.vo.ProviderSystemRefVo;
import ims.admin.domain.base.impl.BaseLocationServiceProviderSysImpl;
import ims.ocrr.vo.LocSvcProviderSysVoCollection;
import ims.ocrr.vo.ProviderSystemVo;
import ims.ocrr.vo.ProviderSystemVoCollection;
import ims.ocrr.vo.domain.LocSvcProviderSysVoAssembler;
import ims.ocrr.vo.domain.ProviderSystemVoAssembler;

public class LocationServiceProviderSysImpl extends BaseLocationServiceProviderSysImpl implements ims.admin.domain.ProviderSystem
{
	public ims.core.vo.OrganisationVoCollection listOrganisation(ims.core.vo.OrganisationVo organisation)
	{
		LocationService impl = (LocationService) getDomainImpl(LocationServiceImpl.class);
		return impl.listOrganisation(organisation);
	}

	/**
	* list services associated with a location
	*/
	public ims.core.vo.LocationServiceVoCollection listLocationService(LocationRefVo voLocation)
	{
		LocationService impl = (LocationService) getDomainImpl(LocationServiceImpl.class);
		return impl.listLocationService(voLocation);
	}
	
	public ims.ocrr.vo.LocSvcProviderSysVoCollection listLocationServiceProvider(Integer locationServiceId)
	{
		if(locationServiceId == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		String hql = new String(" from LocSvcProviderSys lsp where lsp.locationService.id  = :locId");
		List list = factory.find(hql, "locId", locationServiceId);
		return LocSvcProviderSysVoAssembler.createLocSvcProviderSysVoCollectionFromLocSvcProviderSys(list).sort();
	}
	
	public ims.ocrr.vo.LocSvcProviderSysVoCollection listProviderSystemById(ProviderSystemRefVo voRef)
	{
		if(voRef == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		String hql = new String(" from LocSvcProviderSys as l1_1 where l1_1.providerSystem.id = :id");
		List list = factory.find(hql, "id", voRef.getID_ProviderSystem());
		
		if (list.size() != 0)
			return LocSvcProviderSysVoAssembler.createLocSvcProviderSysVoCollectionFromLocSvcProviderSys(list).sort();
		else
			return null;
	}
	
	/**
	* save LocationServiceProvider
	 * @throws StaleObjectException 
	*/
	public ims.ocrr.vo.LocSvcProviderSysVo saveLocationServiceProvider(ims.ocrr.vo.LocSvcProviderSysVo voLoSvcProviderSys) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException
	{
		if(voLoSvcProviderSys == null)
			throw new RuntimeException("Cannot save null value for LocSvcProviderSysVo");
		if(voLoSvcProviderSys.getProviderSystem() == null)
			throw new RuntimeException("Cannot save null value for ProviderSystemVo");
		
		if(voLoSvcProviderSys.isValidated() == false)
			throw new CodingRuntimeException("LocSvcProviderSysVo should be validated");

		//wdev-11759 -- //per service must be only one provider 
		if(voLoSvcProviderSys.getID_LocSvcProviderSys() == null)
		{
			if(CheckifProviderExists(voLoSvcProviderSys) == false)
			{
				throw new StaleObjectException(null);
			}
		}
		//----
		DomainFactory factory = getDomainFactory();
		//Save Location Provider System
		LocSvcProviderSys	doLocSvcProviderSys = LocSvcProviderSysVoAssembler.extractLocSvcProviderSys(factory, voLoSvcProviderSys);
		factory.save(doLocSvcProviderSys);			
		
		return LocSvcProviderSysVoAssembler.create(doLocSvcProviderSys);
	}
	//wdev-11759
	private Boolean CheckifProviderExists(ims.ocrr.vo.LocSvcProviderSysVo voLoSvcProviderSys)
	{
		LocSvcProviderSysVoCollection voLocSvcProviderSystem = null;
		voLocSvcProviderSystem = listLocationServiceProvider(voLoSvcProviderSys.getLocationService().getID_LocationService());
		if (voLocSvcProviderSystem.size() < 1)
			return true;
		for(int i = 0;i < voLocSvcProviderSystem.size();i++)
		{
			if(voLocSvcProviderSystem.get(i).getProviderSystem().equals(voLoSvcProviderSys.getProviderSystem()))
			{
				return true;
				
			}
			
		}
		return false;
	}
	//------------
	public ProviderSystemVoCollection listProviderSystems() 
	{
		DomainFactory factory = getDomainFactory();
		return ProviderSystemVoAssembler.createProviderSystemVoCollectionFromProviderSystem(factory.listDomainObjects(ProviderSystem.class)).sort();
	}

	public ProviderSystemVo saveProviderSystem(ProviderSystemVo voProviderSystem) throws StaleObjectException, UniqueKeyViolationException 
	{
		if(voProviderSystem == null)
			throw new RuntimeException("Cannot save null value for ProviderSystemVo");
		if(!voProviderSystem.isValidated())
		{
			throw new CodingRuntimeException("Provider System Value Object has not been validated");
		}
		DomainFactory factory = getDomainFactory();
		ProviderSystem doProviderSystem = ProviderSystemVoAssembler.extractProviderSystem(factory, voProviderSystem);			
		try
		{
			factory.save(doProviderSystem);
		}
		catch(UnqViolationUncheckedException e)
		{
			throw new ims.domain.exceptions.UniqueKeyViolationException("A System called " + (voProviderSystem.getSystemNameIsNotNull()?voProviderSystem.getSystemName():"") + "or an HL7 Application called " + (voProviderSystem.getHl7ApplicationIsNotNull()?voProviderSystem.getHl7Application():"") + " already exists. Duplicates not allowed.", e);
		}
		return ProviderSystemVoAssembler.create(doProviderSystem);
	}
}
