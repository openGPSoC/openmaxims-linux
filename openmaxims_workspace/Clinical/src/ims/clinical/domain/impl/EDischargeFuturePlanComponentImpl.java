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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.70 build 3341.28572)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.clinical.domain.impl;

import ims.admin.domain.EDischargeHINTConfig;
import ims.admin.domain.HcpAdmin;
import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.EDischargeHINTConfigImpl;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.clinical.domain.EDischargeDiagnosisEtcComponent;
import ims.clinical.domain.EDischargeList;
import ims.clinical.domain.base.impl.BaseEDischargeFuturePlanComponentImpl;
import ims.clinical.vo.DischargeDetailsVo;
import ims.clinical.vo.DischargeFuturePlanVo;
import ims.clinical.vo.DischargeFuturePlanVoCollection;
import ims.clinical.vo.NurseEnabledInstructionsVo;
import ims.clinical.vo.NurseEnabledInstructionsVoCollection;
import ims.clinical.vo.domain.DischargeFuturePlanVoAssembler;
import ims.clinical.vo.domain.NurseEnabledInstructionsVoAssembler;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.HcpFilter;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.edischarge.domain.objects.FuturePlan;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.ocrr.vo.OrderInvestigationBookingVoCollection;
import ims.ocrr.vo.domain.OrderInvestigationBookingVoAssembler;
import ims.ocrr.vo.lookups.OrderInvStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EDischargeFuturePlanComponentImpl extends BaseEDischargeFuturePlanComponentImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.FieldHelpVo getHintByLookupID(ims.clinicaladmin.vo.lookups.EDischargeHINT voLookup)
	{
		EDischargeHINTConfig impl = (EDischargeHINTConfig)getDomainImpl(EDischargeHINTConfigImpl.class);
		return impl.getHintByLookupID(voLookup);
	}

	public DischargeFuturePlanVo saveFuturePlan(DischargeFuturePlanVo voFuturePlan) throws DomainInterfaceException, StaleObjectException 
	{
		if(voFuturePlan == null)
			throw new CodingRuntimeException("DischargeFuturePlanVo is null");
		
		if(!voFuturePlan.isValidated())
			throw new CodingRuntimeException("DischargeFuturePlanVo Value Object has not been validated");

		DomainFactory factory = getDomainFactory();
		FuturePlan doFP = DischargeFuturePlanVoAssembler.extractFuturePlan(factory, voFuturePlan);

		factory.save(doFP);
		return DischargeFuturePlanVoAssembler.create(doFP);
	}

	public DischargeFuturePlanVo getFuturePlan(CareContextRefVo careContextRefvo) 
	{
		if(careContextRefvo == null)
			throw new CodingRuntimeException("careContextRefVo Filter not provided for list call. ");

		if(careContextRefvo != null)
		{
			DomainFactory factory = getDomainFactory();
			StringBuffer hql = new StringBuffer(" from FuturePlan fp where "); 
			String andStr = " ";
		
			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
		
			hql.append(andStr + " fp.careContext.id = :careContextId");
 			markers.add("careContextId");
			values.add(careContextRefvo.getID_CareContext());
			andStr = " and ";	

			List list = factory.find(hql.toString(), markers,values);
			if(list != null && list.size() > 0)
			{ 
				DischargeFuturePlanVoCollection voColl = DischargeFuturePlanVoAssembler.createDischargeFuturePlanVoCollectionFromFuturePlan(list);
				if(voColl != null && voColl.size() > 0)
					return voColl.get(0);
			}
		}
		return null;
	}

	public DischargeDetailsVo getDischargeDetails(CareContextRefVo careContextRefvo) 
	{
		EDischargeDiagnosisEtcComponent impl = (EDischargeDiagnosisEtcComponent)getDomainImpl(EDischargeDiagnosisEtcComponentImpl.class);
		return impl.getDischargeDetails(careContextRefvo);
	}

	public OrderInvestigationBookingVoCollection listResultsAwaited(PatientRefVo patientRefVo, Integer numDays) 
	{
		if(numDays == null)
			throw new CodingRuntimeException("Invalid numDays");
		
		if(patientRefVo == null)
			throw new CodingRuntimeException("Invalid patientRefVo");
		
		Date dtFrom = new Date().addDay(-numDays);
						
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();		
		StringBuffer sb = new StringBuffer(" from OrderInvestigation as oi where ");
		
		sb.append(" oi.systemInformation.creationDateTime >= :fromDate");
		markers.add("fromDate");			
		values.add(dtFrom.getDate());
		
		sb.append(" and oi.ordInvCurrentStatus.ordInvStatus in (:id1, :id2)");
		markers.add("id1");			
		values.add(getDomLookup(OrderInvStatus.ORDERED));
		markers.add("id2");			
		values.add(getDomLookup(OrderInvStatus.SENT));
			
		sb.append(" and ");
		sb.append(" oi.orderDetails.patient.id = :pat ");
		markers.add("pat");
		values.add(patientRefVo.getID_Patient());
		
		sb.append(" order by oi.repDateTime desc, oi.ordInvSeq asc");
		
		List result = getDomainFactory().find(sb.toString(), markers, values);
		return OrderInvestigationBookingVoAssembler.createOrderInvestigationBookingVoCollectionFromOrderInvestigation(result);
	}

	public LocationLiteVoCollection listActiveWardsForHospitalLite(LocationRefVo hospital) 
	{
		EDischargeList impl = (EDischargeList)getDomainImpl(EDischargeListImpl.class);
		return impl.listActiveWardsForHospitalLite(hospital);
	}

	public HcpLiteVoCollection listHCPs(HcpFilter filter) 
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		if (filter != null && filter.getQueryNameIsNotNull())
			return hcpAdmin.listHcpLiteByName(filter.getQueryName().getSurname());
		else 
			return null;
	}

	public LocationLiteVoCollection listWards(String location) 
	{
		OrganisationAndLocation impl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);		
		return impl.listActiveLocationsByName(location);
	}

	public HcpLiteVo getHcp(HcpRefVo voRef) 
	{
		if(voRef == null || voRef.getID_Hcp() == null)
			throw new CodingRuntimeException("HcpRefVo is null or id not provided for getHcp");
		
		return HcpLiteVoAssembler.create((Hcp)getDomainFactory().getDomainObject(voRef));
	}

	public NurseEnabledInstructionsVo getNurseEnabledInstructions(CareContextRefVo careContextRef)
	{
		if(careContextRef == null)
			throw new CodingRuntimeException("careContextRefVo Filter not provided for list call. ");

		if(careContextRef != null)
		{
			DomainFactory factory = getDomainFactory();
			List list = factory.find("from NurseEnabledInstructions as n1_1	where (n1_1.careContext.id = :ID) " , new String[] {"ID"}, new Object[] {careContextRef.getID_CareContext()}); 
			if(list != null && list.size() > 0)
			{ 
				NurseEnabledInstructionsVoCollection  voColl = NurseEnabledInstructionsVoAssembler.createNurseEnabledInstructionsVoCollectionFromNurseEnabledInstructions(list);
				if(voColl != null && voColl.size() > 0)
					return voColl.get(0);
			}
		}
		return null;
	}

}
