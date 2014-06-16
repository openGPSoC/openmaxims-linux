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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4738.16294)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.domain.objects.CareSpell;
import ims.core.admin.domain.objects.EpisodeOfCare;
import ims.core.admin.pas.domain.objects.DischargedEpisode;
import ims.core.admin.pas.domain.objects.InpatientEpisode;
import ims.core.admin.pas.vo.AdmissionDetailRefVo;
import ims.core.admin.pas.vo.PASEventRefVo;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.CareSpellRefVo;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.domain.ADT;
import ims.core.domain.ADTPatientAdmission;
import ims.core.domain.base.impl.BaseADTAdmissionDetailsComponentImpl;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.resource.place.domain.objects.Location;
import ims.core.vo.AdmissionDetailVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.CareContextVo;
import ims.core.vo.CareContextVoCollection;
import ims.core.vo.CareSpellShortVo;
import ims.core.vo.CareSpellVo;
import ims.core.vo.EpisodeofCareShortVoCollection;
import ims.core.vo.EpisodeofCareVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.InpatientEpisodeVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.MedicVo;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.CareContextVoAssembler;
import ims.core.vo.domain.CareSpellShortVoAssembler;
import ims.core.vo.domain.CareSpellVoAssembler;
import ims.core.vo.domain.DischargedEpisodeVoAssembler;
import ims.core.vo.domain.EpisodeofCareShortVoAssembler;
import ims.core.vo.domain.EpisodeofCareVoAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.InpatientEpisodeVoAssembler;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.domain.MedicVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.AdmissionType;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.Specialty;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;

import java.util.List;

public class ADTAdmissionDetailsComponentImpl extends BaseADTAdmissionDetailsComponentImpl
{

	private static final long serialVersionUID = 1L;

	public AdmissionDetailVo getAdmissionDetail(PatientRefVo patientRef)
	{
		 ADTPatientAdmission implLoc = (ADTPatientAdmission)getDomainImpl(ADTPatientAdmissionImpl.class);
		 return implLoc.getAdmissionDetail(patientRef);
	}

	
	public LocationLiteVoCollection listWards()
	{
		StringBuffer hql = new StringBuffer();
		
		hql.append("select loc from Location as loc left join loc.parentLocation as parentLoc ");
		hql.append("where (loc.isActive = :isActive and loc.isVirtual= :isVirtual and loc.type = :locType ) order by loc.name asc");
		
		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find(hql.toString(), new String[] {"isActive","isVirtual","locType"}, new Object[] {true,false,getDomLookup(LocationType.WARD)});
		
		return LocationLiteVoAssembler.createLocationLiteVoCollectionFromLocation(list);
	}

	public HcpLiteVo getHcp(Integer hcpId)
	{
		DomainFactory factory = getDomainFactory();
		Hcp domHcp = (Hcp)factory.getDomainObject(Hcp.class, hcpId);
		return HcpLiteVoAssembler.create(domHcp);
	}

	public CareContextShortVo admitPatient(PatientShort patVo, InpatientEpisodeVo episVo, CareContextVo careContext, EpisodeofCareVo episodeOfCare, CareSpellVo careSpell) throws DomainInterfaceException, StaleObjectException, ForeignKeyViolationException, UniqueKeyViolationException
	{
		ADT implLoc = (ADT)getDomainImpl(ADTImpl.class);
		
		if (patVo!=null)
			patVo.validate();
		
		if (careSpell!=null)
			careSpell.validate();
		
		DomainFactory factory = getDomainFactory();

		InpatientEpisodeVo voIP = implLoc.admitPatient(patVo, episVo, null);
		
		if ( !voIP.getAdmissionDateTime().equals(episVo.getAdmissionDateTime()))
		{
			throw new DomainInterfaceException("Patient is already an inpatient. Cannot Admit.");
		}
		
		CareContextVo tempCareContext=null;
		
		if (careSpell!=null && careSpell.getID_CareSpell()==null)
		{
			CareSpell domCareSpell=CareSpellVoAssembler.extractCareSpell(factory, careSpell);
			factory.save(domCareSpell);
			
			CareSpellVo tempCareSpell = CareSpellVoAssembler.create(domCareSpell);
			
			tempCareContext = tempCareSpell.getEpisodes().get(0).getCareContexts().get(0);
		
			tempCareContext.setPasEvent(voIP.getPasEvent());
			tempCareContext.validate();
			CareContext domCareContext = CareContextVoAssembler.extractCareContext(factory, tempCareContext);
			factory.save(domCareContext);
			
			return CareContextShortVoAssembler.create(domCareContext);
			
		}
		else if (episodeOfCare!=null && careContext!=null)
		{
			careContext.setPasEvent(voIP.getPasEvent());
			CareContext domCareContext = CareContextVoAssembler.extractCareContext(factory, careContext);
			factory.save(domCareContext);
			
			tempCareContext=CareContextVoAssembler.create(domCareContext);//
			
			CareContextVoCollection voCollCareContexts = episodeOfCare.getCareContexts();
			
			if (voCollCareContexts==null)
				voCollCareContexts=new CareContextVoCollection();
		
			voCollCareContexts.add(tempCareContext);
			episodeOfCare.setCareContexts(voCollCareContexts);
			
			EpisodeOfCare domEpisodeOfCare = EpisodeofCareVoAssembler.extractEpisodeOfCare(factory, episodeOfCare);
			factory.save(domEpisodeOfCare);
			
			return CareContextShortVoAssembler.create(domCareContext);
		}
		
		return null;
	}

	public EpisodeofCareShortVoCollection listEpisodesOfCare(PatientRefVo patientRef, Date admissionDate)
	{
		if(patientRef == null || patientRef.getID_Patient()==null)
			throw new CodingRuntimeException("Cannot get Patient value on null patientRef.");
		
		
		StringBuffer hql = new StringBuffer("select epCare from EpisodeOfCare as epCare left join epCare.careSpell as careSpell left join careSpell.patient as patient ");
		hql.append(" where (patient.id=:patID and  epCare.startDate <= :admDate )order by epCare.startDate desc ");
		
		DomainFactory factory = getDomainFactory();
		java.util.Date tempDate=new java.util.Date(admissionDate.toString());
		
		List<?> list = factory.find(hql.toString(), new String[] {"patID","admDate"}, new Object[] {patientRef.getID_Patient(),tempDate});
		
		return EpisodeofCareShortVoAssembler.createEpisodeofCareShortVoCollectionFromEpisodeOfCare(list);
	}

	public Specialty getSpecialtyForConsultant(Integer mosID)
	{
		
		StringBuffer hql = new StringBuffer("select medic from Medic as medic left join medic.mos as mos where mos.id= :mosID ");
		
		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find(hql.toString(), new String[] {"mosID"}, new Object[] {mosID});
		
		if (list!=null && list.size()>0)
		{	
			MedicVo tempMedic = (MedicVoAssembler.createMedicVoCollectionFromMedic(list)).get(0);
			return tempMedic.getSpecialty();
		}
		
		return null;
	}

	public EpisodeofCareVo getEpisodeOfCare(EpisodeOfCareRefVo episodeOfCareRef)
	{
		if(episodeOfCareRef == null || episodeOfCareRef.getID_EpisodeOfCare()==null)
			throw new CodingRuntimeException("Cannot get EpisodeOfCare value on null episodeOfCareRef.");
		
		DomainFactory factory = getDomainFactory();
		EpisodeOfCare doEpisodeOfcare = (EpisodeOfCare) factory.getDomainObject(EpisodeOfCare.class, episodeOfCareRef.getID_EpisodeOfCare());
		return EpisodeofCareVoAssembler.create(doEpisodeOfcare);
	}

	public InpatientEpisodeVo getInpatientEpisode(PASEventRefVo pasEventRef)
	{
		if(pasEventRef == null || pasEventRef.getID_PASEvent()==null)
			throw new CodingRuntimeException("Cannot get PasEvent value on null pasEventRef.");
		
		StringBuffer hql = new StringBuffer("select inpEpisode from InpatientEpisode as inpEpisode left join inpEpisode.pasEvent as pasEvent where pasEvent.id= :pasEventID ");
		
		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find(hql.toString(), new String[] {"pasEventID"}, new Object[] {pasEventRef.getID_PASEvent()});
		
		if (list!=null && list.size()>0)
		{	
			return InpatientEpisodeVoAssembler.create((InpatientEpisode) list.get(0));
		}
		
		return null;
	}


	public AdmissionType getAdmissionTypeFromInpatientEpisode(PASEventRefVo pasEventRef)
	{
		if(pasEventRef == null || pasEventRef.getID_PASEvent()==null)
			throw new CodingRuntimeException("Cannot get PasEvent value on null pasEventRef.");
		
		StringBuffer hql = new StringBuffer("select inpEpisode from InpatientEpisode as inpEpisode left join inpEpisode.pasEvent as pasEvent where pasEvent.id= :pasEventID ");
		
		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find(hql.toString(), new String[] {"pasEventID"}, new Object[] {pasEventRef.getID_PASEvent()});
		
		if (list!=null && list.size()>0)
		{	
			return (InpatientEpisodeVoAssembler.create((InpatientEpisode) list.get(0))).getAdmissionType();
		}
		
		return null;
	}

	public AdmissionType getAdmissionTypeFromDischargedEpisode(PASEventRefVo pasEventRef)
	{
		if(pasEventRef == null || pasEventRef.getID_PASEvent()==null)
			throw new CodingRuntimeException("Cannot get PasEvent value on null pasEventRef.");
		
		StringBuffer hql = new StringBuffer("select dischEpisode from DischargedEpisode as dischEpisode left join dischEpisode.pasEvent as pasEvent where pasEvent.id= :pasEventID ");
		
		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find(hql.toString(), new String[] {"pasEventID"}, new Object[] {pasEventRef.getID_PASEvent()});
		
		if (list!=null && list.size()>0)
		{	
			return (DischargedEpisodeVoAssembler.create((DischargedEpisode) list.get(0))).getAdmissionType();
		}
		
		return null;
	}

	public LocationLiteVo getAdmissionWard(PASEventRefVo pasEventRef)
	{
		if(pasEventRef == null || pasEventRef.getID_PASEvent()==null)
			throw new CodingRuntimeException("Cannot get PasEvent value on null pasEventRef.");
		
		StringBuffer hql = new StringBuffer("select admDet.pasEvent.location from AdmissionDetail as admDet left join admDet.pasEvent as pasEvent where pasEvent.id= :pasEventID ");
		
		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find(hql.toString(), new String[] {"pasEventID"}, new Object[] {pasEventRef.getID_PASEvent()});
		
		if (list!=null && list.size()>0)
		{	
			return LocationLiteVoAssembler.create((Location) list.get(0));
		}
		
		return null;
		
	}
	
	public CareContextVo getCareContext(CareContextRefVo careContextRef)
	{
		if(careContextRef == null || careContextRef.getID_CareContext()==null)
			throw new CodingRuntimeException("Cannot get CareContext value on null careContextRef.");
		
		DomainFactory factory = getDomainFactory();
		CareContext domCareContext=(CareContext) factory.getDomainObject(CareContext.class, careContextRef.getID_CareContext());
		return CareContextVoAssembler.create(domCareContext);
	}

	public Boolean isPatientDischarged(AdmissionDetailRefVo admissionDetRef)
	{
		if( admissionDetRef == null || admissionDetRef.getID_AdmissionDetail()==null)
			throw new CodingRuntimeException("Cannot get AdmissionDetail on null admissionDetRef.");
	
		DomainFactory factory = getDomainFactory();
		String hql = " select count(dischEpisode.id) from DischargedEpisode as dischEpisode left join dischEpisode.admissionDetail as admDet  where (admDet.id = :idAdmissionDet )";
		
		Object[] count = factory.find(hql.toString(), new String[] { "idAdmissionDet" }, new Object[] { admissionDetRef.getID_AdmissionDetail() }).toArray();

		if (count != null && count.length > 0)
			if (((Long) count[0]).intValue() > 0)
				return true;
		
		return false;
	}

	public CareSpellShortVo getCareSpell(CareSpellRefVo careSpellRef)
	{
		if(careSpellRef == null || careSpellRef.getID_CareSpell()==null)
			throw new CodingRuntimeException("Cannot get CareSpell value on null careSpellRef.");
		
		DomainFactory factory = getDomainFactory();
		CareSpell domCareSpell=(CareSpell) factory.getDomainObject(CareSpell.class, careSpellRef.getID_CareSpell());
		return CareSpellShortVoAssembler.create(domCareSpell);
	}

	public PatientShort getPatient(PatientRefVo patientRef)
	{
		if(patientRef == null || patientRef.getID_Patient()==null)
			throw new CodingRuntimeException("Cannot get Patient value on null patientRef.");
		
		DomainFactory factory = getDomainFactory();
		Patient domPatient=(Patient) factory.getDomainObject(Patient.class, patientRef.getID_Patient());
		return PatientShortAssembler.create(domPatient);
	}

	public CareContextShortVo updateAdmissionDetails(InpatientEpisodeVo episVo, CareContextShortVo careContextVo) throws StaleObjectException
	{
		if (episVo == null )
		{
			throw new CodingRuntimeException("episVo is null on Save");
		}
		
		if (careContextVo == null )
		{
			throw new CodingRuntimeException("careContextVo is null on Save");
		}
		
		ADT implLoc = (ADT)getDomainImpl(ADTImpl.class);
		DomainFactory factory = getDomainFactory();
		
		CareContext domCareContext = CareContextShortVoAssembler.extractCareContext(factory, careContextVo);
		factory.save(domCareContext);
		
		implLoc.updateInpatient(episVo, null);
		
		return CareContextShortVoAssembler.create(domCareContext);
		
	}

}
