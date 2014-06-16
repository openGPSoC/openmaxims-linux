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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 3947.28740)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.admin.domain.ClinicAdmin;
import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.ClinicAdminImpl;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.admin.vo.ReportTemplateVo;
import ims.admin.vo.domain.ReportTemplateVoAssembler;
import ims.clinical.vo.PatientSummaryNoteByHcpShortVo;
import ims.clinical.vo.PatientSummaryNoteByHcpShortVoCollection;
import ims.clinical.vo.domain.PatientSummaryNoteByHcpShortVoAssembler;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.domain.objects.TemplateBo;
import ims.core.admin.pas.vo.PASEventRefVo;
import ims.core.admin.vo.TemplateBoRefVo;
import ims.core.documents.domain.objects.PatientDocument;
import ims.core.documents.vo.PatientDocumentRefVo;
import ims.core.domain.base.impl.BaseClinicLetterBatchCreateImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.place.vo.ClinicRefVo;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.CareContextMinVo;
import ims.core.vo.ClinicLiteVoCollection;
import ims.core.vo.DocumentCategoryConfigShortVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.OutPatientListVoCollection;
import ims.core.vo.PatientDocumentVo;
import ims.core.vo.TemplateForPatientDocumentVoCollection;
import ims.core.vo.domain.CareContextMinVoAssembler;
import ims.core.vo.domain.DocumentCategoryConfigShortVoAssembler;
import ims.core.vo.domain.OutPatientListVoAssembler;
import ims.core.vo.domain.PatientDocumentVoAssembler;
import ims.core.vo.domain.TemplateForPatientDocumentVoAssembler;
import ims.core.vo.lookups.DocumentCategory;
import ims.core.vo.lookups.Specialty;
import ims.domain.DomainFactory;
import ims.domain.DomainObject;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.ILocation;
import ims.framework.utils.Date;

public class ClinicLetterBatchCreateImpl extends BaseClinicLetterBatchCreateImpl
{
	private static final long serialVersionUID = 1L;

	public ILocation[] listLocations()
	{
		OrganisationAndLocation orgLoc = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		
		LocationLiteVoCollection locations = orgLoc.listActiveHospitalsLite();
		return locations != null ? locations.toILocationArray() : null;
	}

	public ClinicLiteVoCollection listClinicsforLocation(Integer locationId, String strClinicName) 
	{
		if(locationId == null)
			throw new CodingRuntimeException("Cannot list Clinics an null Location Id.");
			
		ClinicAdmin clinicAdmin = (ClinicAdmin)getDomainImpl(ClinicAdminImpl.class);
		return clinicAdmin.listClinicsForLocationByClinicName(new LocationRefVo(locationId, 0) ,strClinicName,true);//WDEV-12511
		
	}

	public OutPatientListVoCollection listOutPatients(ClinicRefVo clinic, Date clinicDate) 
	{
		DomainFactory factory = getDomainFactory();
		String hql;
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		hql = " from OutpatientAttendance op "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " and ";
		
		condStr.append(" op.isActive = :isActive");
		markers.add("isActive");
		values.add(Boolean.TRUE);
	
		if (clinic != null)
		{
			condStr.append(andStr + " op.clinic.id = :clinic");
			markers.add("clinic");
			values.add(clinic.getID_Clinic());
		}
		
		if (clinicDate != null)
		{
			condStr.append(andStr + " op.appointmentDateTime >= :startdate");
			condStr.append(andStr + " op.appointmentDateTime < :enddate");
			markers.add("startdate");
			markers.add("enddate");
			values.add(clinicDate.getDate());
			values.add(clinicDate.copy().addDay(1).getDate());
		}
	
		hql += " where ";
		
		hql += condStr.toString();
		List<?> ops = factory.find(hql, markers, values);
		
		return OutPatientListVoAssembler.createOutPatientListVoCollectionFromOutpatientAttendance(ops).sort();
	}

	public TemplateForPatientDocumentVoCollection searchReports(String templateName, String listOfMandatorySeeds, DocumentCategory documentType, Specialty specialty) 
	{
		DomainFactory factory = getDomainFactory();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		String subHql = "";
		
		if(listOfMandatorySeeds != null && listOfMandatorySeeds.length() > 0)
		{
			subHql = " and r21.bOName not in (" + listOfMandatorySeeds + ")";
		}
			
		String mainHql = "select t from DocumentCategoryConfig as d left join d.template as t left join t.report as r";
		String whereHql = " where t.id not in (select t11.id from TemplateBo as t11 left join t11.report as r11 left join r11.seeds as r21  where (r21.canBeNull = 0" + subHql + ")) and r.reportXml is not null  and t.templateXml is not null and r.isActive = 1 and t.isActive = 1";//WDEV-13547
		
		if(templateName != null && templateName.length() > 0)
		{
			whereHql += " and upper(t.name) like :templateName";//WDEV-13750
			markers.add("templateName");
			values.add(templateName.toUpperCase() + "%");//WDEV-13750
		}
		
		if(documentType != null)
		{
			whereHql += " and d.category.id = :catId";
			markers.add("catId");
			values.add(documentType.getID());
		}
		
		if(specialty != null)
		{
			mainHql += " left join d.specialty as s left join s.instance as i";
			whereHql += " and i.id = :specialtyId";
			markers.add("specialtyId");
			values.add(specialty.getID());
		}
		
		String hql = mainHql + whereHql + " order by upper(r.reportName) asc, upper(t.name) asc";//WDEV-13547
		List<?> list = factory.find(hql, markers, values);
		
		return TemplateForPatientDocumentVoAssembler.createTemplateForPatientDocumentVoCollectionFromTemplateBo(list);//WDEV-13547
	}

	public ReportTemplateVo getTemplate(TemplateBoRefVo templateBoRefVo) 
	{
		if (templateBoRefVo == null)
			throw new CodingRuntimeException("Cannot get ReportTemplateVo for null TemplateBoRefVo");

		DomainFactory factory = getDomainFactory();

		TemplateBo boTemplate = (TemplateBo) factory.getDomainObject(TemplateBo.class, templateBoRefVo.getID_TemplateBo());
		return ReportTemplateVoAssembler.create(boTemplate);
	}

	public CareContextMinVo getCareContextByPasEvent(PASEventRefVo pasEvent) 
	{
		if(pasEvent == null || !pasEvent.getID_PASEventIsNotNull())
			throw new CodingRuntimeException("Cannot get Care Context on null Pas Event.");
		
		DomainFactory factory = getDomainFactory();
		
		List<?> careContext = factory.find("from CareContext as cc where cc.pasEvent.id = :PasEventId order by cc.systemInformation.creationDateTime desc ", new String[] {"PasEventId"}, new Object[] {pasEvent.getID_PASEvent()});
		
		if(careContext == null || careContext.size() == 0)
			return null;
		
		return CareContextMinVoAssembler.create((CareContext) careContext.get(0));	
	}

	public PatientDocumentVo savePatientDocument(PatientDocumentVo document) throws StaleObjectException 
	{
		if(document == null)
			throw new CodingRuntimeException("Can not save a null PatientDocumentVo.");
		
		if(!document.isValidated())
			throw new CodingRuntimeException("PatientDocumentVo not validated");
		
		DomainFactory factory = getDomainFactory();
		PatientDocument doc = PatientDocumentVoAssembler.extractPatientDocument(factory, document);
		factory.save(doc);	
		
		return PatientDocumentVoAssembler.create(doc);
	}

	public DocumentCategoryConfigShortVo getDocCatConfig(TemplateBoRefVo template) 
	{
		if (!template.getID_TemplateBoIsNotNull())
			throw new DomainRuntimeException("Unable to retrive document category config for template with null id!");

		String hql = "select dcc from DocumentCategoryConfig as dcc left join dcc.template as temp where dcc.isRIE is null and temp.id=:idTemp";
		
		List<?> dos = getDomainFactory().find(hql, "idTemp", template.getID_TemplateBo());
		
		if (dos == null || dos.size() == 0)
			return null;
		
		return DocumentCategoryConfigShortVoAssembler.createDocumentCategoryConfigShortVoCollectionFromDocumentCategoryConfig(dos).get(0);
	}

	public void deletePatientDocument(PatientDocumentRefVo patDocRef)
	{
		if (patDocRef == null || !patDocRef.getID_PatientDocumentIsNotNull())
		{
			throw new DomainRuntimeException("Invalid patient document provided in delete");
		}
		DomainObject dom = getDomainFactory().getDomainObject(PatientDocument.class, patDocRef.getID_PatientDocument());
		try
		{
			getDomainFactory().delete(dom);
		}
		catch (ForeignKeyViolationException e)
		{
			//How to handle this ????
			e.printStackTrace();
		}
		
	}

	//wdev-14230
	public PatientSummaryNoteByHcpShortVoCollection listSummaryNotes(PatientRefVo patient) 
	{
		if (patient == null || !patient.getID_PatientIsNotNull())
			throw new DomainRuntimeException("Can not search after null patient");

		String query = " from PatientSummaryNoteByHCP as sumNote where sumNote.patient.id = :ID order by sumNote.authoringInformation.authoringDateTime desc";

		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();

		paramNames.add("ID");
		paramValues.add(patient.getID_Patient());

		return PatientSummaryNoteByHcpShortVoAssembler.createPatientSummaryNoteByHcpShortVoCollectionFromPatientSummaryNoteByHCP(getDomainFactory().find(query, paramNames, paramValues));

	}

	//wdev-14230
	public PatientSummaryNoteByHcpShortVo getLastSummaryNote(PatientRefVo patient) 
	{
		if (patient == null || !patient.getID_PatientIsNotNull())
			throw new DomainRuntimeException("Can not search after null patient");

		String query = " from PatientSummaryNoteByHCP as sumNote where sumNote.patient.id = :ID order by sumNote.authoringInformation.authoringDateTime desc";

		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();

		paramNames.add("ID");
		paramValues.add(patient.getID_Patient());
		List summarynotes = getDomainFactory().find(query, paramNames, paramValues);
		if(summarynotes != null && summarynotes.size() > 0)
		{
			PatientSummaryNoteByHcpShortVoCollection coll = PatientSummaryNoteByHcpShortVoAssembler.createPatientSummaryNoteByHcpShortVoCollectionFromPatientSummaryNoteByHCP(summarynotes);
			if(coll != null && coll.size() > 0)
				return coll.get(0);
		}
		return null;
	}
}
