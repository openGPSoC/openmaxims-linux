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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.30 build 2011.19815)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.scheduling.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.careuk.vo.ContractConfigShortVoCollection;
import ims.careuk.vo.domain.ContractConfigShortVoAssembler;
import ims.core.clinical.domain.objects.Service;
import ims.core.resource.place.vo.OrganisationRefVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.OrganisationLiteVoCollection;
import ims.core.vo.ServiceFunctionVoCollection;
import ims.core.vo.ServiceShortVo;
import ims.core.vo.ServiceShortVoCollection;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.domain.OrganisationLiteVoAssembler;
import ims.core.vo.domain.ServiceFunctionVoAssembler;
import ims.core.vo.domain.ServiceShortVoAssembler;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.OrganisationType;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.impl.DomainImpl;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.CodingRuntimeException;
import ims.scheduling.domain.objects.DirectoryofService;
import ims.scheduling.vo.DirectoryOfServiceVo;
import ims.scheduling.vo.DirectoryOfServiceVoCollection;
import ims.scheduling.vo.domain.DirectoryOfServiceVoAssembler;

import java.util.ArrayList;
import java.util.List;

public class DirectoryOfServiceAdminImpl extends DomainImpl implements ims.scheduling.domain.DirectoryOfServiceAdmin, ims.domain.impl.Transactional
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DirectoryOfServiceVoCollection listDirectoryOfService(DirectoryOfServiceVo directoryOfService) 
	{
		DomainFactory factory = getDomainFactory();

		if(directoryOfService == null) //no filter return all
			return DirectoryOfServiceVoAssembler.createDirectoryOfServiceVoCollectionFromDirectoryofService(factory.listDomainObjects(DirectoryofService.class));

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		StringBuffer condStr = new StringBuffer();
		String hql = " from DirectoryofService dos "; 
		String andStr = " ";
		
	
		if (directoryOfService.getDoSName() != null)
		{
			condStr.append(andStr + " upper(dos.doSName) like :dosName" );
			markers.add("dosName");
			values.add("%" + directoryOfService.getDoSName().toUpperCase() + "%");		
			andStr = " and ";
		}
		if (directoryOfService.getService() != null)
		{
			condStr.append(andStr + " dos.service.id = :serviceId");
			markers.add("serviceId");
			values.add( directoryOfService.getService().getID_Service());		
			andStr = " and ";
		}
		if (directoryOfService.getLocation() != null)
		{
			condStr.append(andStr + " dos.location.id = :locId");
			markers.add("locId");
			values.add( directoryOfService.getLocation().getID_Location());		
			andStr = " and ";
		}
		if (directoryOfService.getIsActiveIsNotNull())
		{
			condStr.append(andStr + " dos.isActive = :isActive" );
			markers.add("isActive");
			values.add(directoryOfService.getIsActive());		
			andStr = " and ";
		}
		
		if(andStr.equals(" and "))
			hql += " where ";
		
		hql += condStr.toString();
		
		hql += " order by upper(dos.doSName) asc ";

		List<?> dosList = factory.find(hql,markers,values, 500);
		
		return DirectoryOfServiceVoAssembler.createDirectoryOfServiceVoCollectionFromDirectoryofService(dosList);
	}

	public ServiceShortVoCollection listService(ServiceShortVo serviceShort) 
	{
		DomainFactory factory = getDomainFactory();
		
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		StringBuffer condStr = new StringBuffer();
		String hql = " from Service service "; 
		String andStr = " ";
		
		if(serviceShort == null) //no filter return all
			return ServiceShortVoAssembler.createServiceShortVoCollectionFromService(factory.listDomainObjects(Service.class));
	
		if (serviceShort.getServiceNameIsNotNull())
		{
			condStr.append(andStr + " upper(service.serviceName) like :serviceName" );
			markers.add("serviceName");
			values.add("%" +  serviceShort.getServiceName().toUpperCase() + "%");		
			andStr = " and ";
		}
		if (serviceShort.getSpecialtyIsNotNull())
		{
			condStr.append(andStr + " service.specialty = :specialty" );
			markers.add("specialty");
			values.add(getDomLookup(serviceShort.getSpecialty()));		
			andStr = " and ";
		}
		if (serviceShort.getIsActiveIsNotNull())
		{
			condStr.append(andStr + " service.isActive = :isActive" );
			markers.add("isActive");
			values.add(serviceShort.getIsActive());		
			andStr = " and ";
		}
		
		if(andStr.equals(" and "))
			hql += " where ";
		
		hql += condStr.toString();
		hql += " order by upper(service.serviceName) asc ";//WDEV-15178
		List<?> services = factory.find(hql,markers,values);
		return ServiceShortVoAssembler.createServiceShortVoCollectionFromService(services);
	}

	public DirectoryOfServiceVo saveDirectoryOfService(DirectoryOfServiceVo directoryOfService) throws StaleObjectException, UniqueKeyViolationException
	{
		if(directoryOfService == null)
			throw new CodingRuntimeException("directoryOfService param is null in method saveDirectoryOfService");
		
		if(!directoryOfService.isValidated())
			throw new DomainRuntimeException("ActivitySchedVo not validated");
		
		DomainFactory factory = getDomainFactory();
		
		//TODO this implementation is not ideal - the recordExistForDoSIdAndIsActive should really take the record id attemptimg to be saved if applicable(update) as a param
		//instead of calling getDirectoryofServiceFromdos_unq1 to check that the conflict is not with this record itself(update)		
		if(DirectoryofService.recordExistForDoSIdAndIsActive(factory, directoryOfService.getDoSId(), directoryOfService.getIsActive()))
		{
			if(directoryOfService.getID_DirectoryofServiceIsNotNull())
			{
				DirectoryofService doConflictingDos = DirectoryofService.getDirectoryofServiceFromdos_unq1(factory,directoryOfService.getDoSId(), directoryOfService.getIsActive());
				if(!doConflictingDos.getId().equals(directoryOfService.getID_DirectoryofService()))
					throw new UniqueKeyViolationException("An " + (directoryOfService.getIsActive() ? "active" : "inactive") + " Directory Of Service with this ID already exists");
			}
			else
				throw new UniqueKeyViolationException("An " + (directoryOfService.getIsActive() ? "active" : "inactive") + " Directory Of Service with this ID already exists");
		}
			
		DirectoryofService doDirService = DirectoryOfServiceVoAssembler.extractDirectoryofService(factory, directoryOfService);
		factory.save(doDirService);
		
		return DirectoryOfServiceVoAssembler.create(doDirService);
	}

	/**
	 * retrieve a list of functions for this service from ServiceFunction
	 */
	public ServiceFunctionVoCollection listServiceFunctions(ServiceShortVo serviceShort) 
	{
		DomainFactory factory = getDomainFactory();
		
		List<?> funcs = factory.find("from ServiceFunction serviceFunc where serviceFunc.service.id = :serviceId",new String[]{"serviceId"},new Object[]{serviceShort.getID_Service()});
		return ServiceFunctionVoAssembler.createServiceFunctionVoCollectionFromServiceFunction(funcs);
	}

	/**
	 * list active locations by name excluding the following types ( 'Pathology Laboratory','Radiology' & 'Surgery')
	 */
	public LocationLiteVoCollection listLocationLiteByName(String name)
	{	
		DomainFactory factory = getDomainFactory();
		String hql = "from Location loc where loc.isActive = :active and loc.type.id not in (:path,:rad,:surgery) ";
		if(name != null)
		{
			name = name.replaceAll("%","");
			hql += " and loc.upperName like '" + name.toUpperCase() + "%'";	
		}
		
		hql += " order by loc.upperName asc";
		
		List<?> locs = factory.find(hql, new String[]{"active","path","rad","surgery"}, new Object[]{Boolean.TRUE,LocationType.PATHOLOGYLABORATORY.getID(),LocationType.CLINICALIMAGINGDEPARTMENT.getID(),LocationType.SURGERY.getID()});
		return LocationLiteVoAssembler.createLocationLiteVoCollectionFromLocation(locs);
	}

	

	/* (non-Javadoc)
	 * @see ims.scheduling.domain.DirectoryOfServiceAdmin#listLocationLiteByNameAndOrganisation(java.lang.String, ims.core.resource.place.vo.OrganisationRefVo)
	 */
	public LocationLiteVoCollection listLocationLiteByNameAndOrganisation(String name, OrganisationRefVo organisation) {
		OrganisationAndLocation domainImpl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return domainImpl.listLocationByOrganisation(organisation, name);
	}
	

	public OrganisationLiteVoCollection listOrganisations() {
		String hql = "from Organisation as org where  (org.type is not null  and org.type.id not in (:gpp,:supp,:pct) and org.isActive = 1 and org.parentOrganisation is null) order by org.upperName asc ";
		List<?> list = getDomainFactory().find(hql,new String[]{"gpp","supp","pct"},new Object[]{OrganisationType.GPP.getId(),OrganisationType.SUPPLIER.getId(),OrganisationType.NHS_PCT.getId()});
		if (list == null || list.size() == 0)
			return null;
		return OrganisationLiteVoAssembler.createOrganisationLiteVoCollectionFromOrganisation(list);
	}
	//WDEV-11662
	public ContractConfigShortVoCollection listActiveContracts() 
	{
		String hql = "from ContractConfig as cc where (cc.status.id = :status and cc.isRIE is null) order by upper(cc.contractName) asc";
		List<?> dos = getDomainFactory().find(hql,new String[]{"status"},new Object[]{PreActiveActiveInactiveStatus.ACTIVE.getID()});
		if (dos == null || dos.size() == 0)
			return null;
		return ContractConfigShortVoAssembler.createContractConfigShortVoCollectionFromContractConfig(dos);
	}
}
