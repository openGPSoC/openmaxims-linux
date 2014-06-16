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
// This code was generated by Billy Mahon using IMS Development Environment (version 1.45 build 2382.21900)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.domain.impl.SupportNetworkFamilyImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.CareContextLiteVo;
import ims.core.vo.DiagLiteVoCollection;
import ims.core.vo.PatientDiagnosisShortVoCollection;
import ims.core.vo.PatientProcedureShortVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.SupportNetworkFamilyCollection;
import ims.core.vo.domain.PatientDiagnosisShortVoAssembler;
import ims.core.vo.domain.PatientProcedureShortVoAssembler;
import ims.core.vo.domain.SupportNetworkFamilyAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.nursing.domain.base.impl.BaseNursingAdmissionImpl;
import ims.nursing.domain.objects.AdmissionDetails;
import ims.nursing.vo.AdmissionDetailsVo;
import ims.nursing.vo.AdmissionDetailsVoCollection;
import ims.nursing.vo.domain.AdmissionDetailsVoAssembler;

public class NursingAdmissionImpl extends BaseNursingAdmissionImpl
{
	private static final long serialVersionUID = 1L;

	public AdmissionDetailsVo getNursingAdmission(CareContextLiteVo voCareContextLite) 
 	{
		if(voCareContextLite == null)
			throw new CodingRuntimeException("Contact not Provided");
		
		DomainFactory factory = getDomainFactory();

		//the following query retrievs the one and only contact of type spinalmedicaladmission if it has been instantiated
		List admisDetails =   factory.find(" from AdmissionDetails ad where ad.careContext.id = :idCareContext )",
				new String[]{"idCareContext" },
				new Object[]{ voCareContextLite.getID_CareContext()});

		AdmissionDetailsVoCollection voAdmisDetails = AdmissionDetailsVoAssembler.createAdmissionDetailsVoCollectionFromAdmissionDetails(admisDetails); 
		
		if(voAdmisDetails.size()>0)
			return voAdmisDetails.get(0);
		else 
			return null;
	}

	public SupportNetworkFamilyCollection listSupportNetworkFamily(Boolean active, PatientShort voPatient) 
	{
		ims.core.domain.SupportNetworkFamily famNetwork = (ims.core.domain.SupportNetworkFamily) getDomainImpl(SupportNetworkFamilyImpl.class);
		return famNetwork.listSupportNetworkFamily(active, voPatient, null); //WDEV-15479
	}

	public DiagLiteVoCollection listDiagnosis(String filter) 
	{
		return null;
	}
	
	public PatientDiagnosisShortVoCollection listPatientDiagnoses(PatientRefVo patrefvo)
	{
		return listDiagnosesForPatient(patrefvo, true, false);
	}
	
	private PatientDiagnosisShortVoCollection listDiagnosesForPatient(PatientRefVo patrefvo, boolean boolDiagnosis, boolean boolComplication)
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = new String();
		hql = " from PatientDiagnosis patdiag ";
 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		condStr.append(andStr + " patdiag.careContext.episodeOfCare.careSpell.patient.id = :patientId");
		markers.add("patientId");
		values.add(patrefvo.getID_Patient());
		andStr = " and ";			

		if ( (!boolComplication) && (boolDiagnosis) )//List all Diagnosis 
		{
			condStr.append(andStr + " patdiag.isComplication = :complication");
			markers.add("complication");
			values.add(Boolean.FALSE);
		}
		else if ( (boolComplication) && (!boolDiagnosis) )//List all Complications 
		{
			condStr.append(andStr + " patdiag.isComplication = :complication");
			markers.add("complication");
			values.add(Boolean.TRUE);
		}

		hql += " where ";

		hql += condStr.toString();
		return PatientDiagnosisShortVoAssembler.createPatientDiagnosisShortVoCollectionFromPatientDiagnosis(factory.find(hql,markers,values)).sort();		
	}
	
	public PatientProcedureShortVoCollection listPatientProcedures(PatientRefVo patrefvo)
	{
		return listProceduresForPatient(patrefvo, true);
	}
	
	private PatientProcedureShortVoCollection listProceduresForPatient(PatientRefVo patrefvo, boolean boolDiagnosis)
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = new String();
		hql = " from PatientProcedure patproc ";
 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		condStr.append(andStr + " patproc.careContext.episodeOfCare.careSpell.patient.id = :patientId");
		markers.add("patientId");
		values.add(patrefvo.getID_Patient());
		andStr = " and ";			

		//if ( (boolDiagnosis) )//List all Diagnosis 
		//{
		//	condStr.append(andStr + " patproc.isComplication = :complication");
		//	markers.add("complication");
		//	values.add(Boolean.FALSE);
		//}
		//else if ( (boolComplication) && (!boolDiagnosis) )//List all Complications 
		//{
		//	condStr.append(andStr + " patproc.isComplication = :complication");
		//	markers.add("complication");
		//	values.add(Boolean.TRUE);
		//}
		hql += " where ";

		hql += condStr.toString();
		return PatientProcedureShortVoAssembler.createPatientProcedureShortVoCollectionFromPatientProcedure(factory.find(hql,markers,values)).sort();		
	}

	public AdmissionDetailsVo saveNursingAdmission(AdmissionDetailsVo voAdmissionDetails) throws StaleObjectException 
	{
		if (!voAdmissionDetails.isValidated())
		{
			throw new DomainRuntimeException("AdmissionDetails has not been validated");
		}
		DomainFactory factory = getDomainFactory();
		
		AdmissionDetails domAdmisDetails = AdmissionDetailsVoAssembler.extractAdmissionDetails(factory, voAdmissionDetails);
		
		factory.save(domAdmisDetails);
		
		AdmissionDetailsVo voAdmisDetails = AdmissionDetailsVoAssembler.create(domAdmisDetails); 
		
		return voAdmisDetails;
	}

	public void saveSupportNetworkFamily(SupportNetworkFamilyCollection voSupportNetworkFamily) throws StaleObjectException 
	{
		//Ensure the value object has been validated
		if (!voSupportNetworkFamily.isValidated())
			throw new DomainRuntimeException("Problems on Admission has not been validated");
		
		DomainFactory factory = getDomainFactory();
		for(int i=0; i<voSupportNetworkFamily.size(); i++)
		{
			ims.core.clinical.domain.objects.SupportNetworkFamily doSupportNetworkFamily = SupportNetworkFamilyAssembler.extractSupportNetworkFamily(factory, voSupportNetworkFamily.get(i));
			factory.save(doSupportNetworkFamily);
		}

		return;

	}
	
	public PatientDiagnosisShortVoCollection listEpisodeOfCareDiagnoses(EpisodeOfCareRefVo episodeOfCareRefVo) 
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = new String();
		hql = " from PatientDiagnosis patdiag ";

		StringBuffer condStr = new StringBuffer();
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";
		
		condStr.append(andStr + " patdiag.careContext.episodeOfCare.id = :episodeId");
		markers.add("episodeId");
		values.add(episodeOfCareRefVo.getID_EpisodeOfCare());
		andStr = " and ";			

		hql += " where ";
		hql += condStr.toString();
		return PatientDiagnosisShortVoAssembler.createPatientDiagnosisShortVoCollectionFromPatientDiagnosis(factory.find(hql,markers,values)).sort();		
	}

	public PatientProcedureShortVoCollection listProceduresByEpisodeOfCare(EpisodeOfCareRefVo episodeOfCareRefVo) 
	{
		if(episodeOfCareRefVo == null)
			throw new DomainRuntimeException("Invalid Episode Context Ref");
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("from PatientProcedure p ");
		hql.append(" where p.careContext.episodeOfCare.id = " + episodeOfCareRefVo.getID_EpisodeOfCare());
		return PatientProcedureShortVoAssembler.createPatientProcedureShortVoCollectionFromPatientProcedure(factory.find(hql.toString()));
	}
}
