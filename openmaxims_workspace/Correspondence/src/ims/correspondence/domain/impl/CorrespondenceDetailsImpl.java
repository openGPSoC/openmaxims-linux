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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.25 build 1948.28680)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.configuration.gen.ConfigFlag;
import ims.correspondence.domain.CorrespondenceHeadersAdmin;
import ims.correspondence.domain.ProcessReport;
import ims.correspondence.domain.impl.ProcessReportImpl;
import ims.correspondence.domain.TemplateSelect;
import ims.correspondence.domain.impl.TemplateSelectImpl;
import ims.core.admin.domain.objects.UserEmailAccount;
import ims.core.admin.pas.domain.objects.PASEvent;
import ims.core.admin.pas.vo.PASEventRefVo;
import ims.core.domain.impl.ADTImpl;
import ims.core.domain.impl.DemographicsImpl;
import ims.core.domain.ADT;
import ims.core.domain.Demographics;
import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.admin.vo.ReportTemplateVo;
import ims.admin.vo.ReportTemplateVoCollection;
import ims.admin.vo.UserEmailAccountVo;
import ims.admin.vo.domain.UserEmailAccountVoAssembler;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.DocumentVo;
import ims.core.vo.GP;
import ims.core.vo.GpShortVoCollection;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.PasEventLiteVo;
import ims.core.vo.PasEventVo;
import ims.core.vo.Patient;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.PasEventLiteVoAssembler;
import ims.core.vo.domain.GpShortVoAssembler;
import ims.core.vo.domain.PasEventVoAssembler;
import ims.correspondence.domain.objects.CorrespondenceDetails;
import ims.correspondence.vo.CorrespondenceDetailsRefVo;
import ims.correspondence.vo.CorrespondenceStatusHistoryVoCollection;
import ims.correspondence.vo.DocReportVo;
import ims.correspondence.vo.CorrespondenceDetailsVo;
import ims.correspondence.vo.TemplateCategoryVo;
import ims.correspondence.vo.domain.CorrespondenceStatusHistoryVoAssembler;
import ims.correspondence.vo.domain.CorrespondenceDetailsVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;

import ims.dto.Result;
import ims.dto.client.Inpatientlist;
import ims.dto.client.Outpatientlist;
import ims.dto.client.Patientcontacts;
import ims.dto.client.Patientcontacts.PatientcontactsRecord;
import ims.framework.exceptions.CodingRuntimeException;
import ims.vo.LookupInstVo;
import ims.dto.DTODomainImplementation;
import ims.core.vo.lookups.PasEventType;

public class CorrespondenceDetailsImpl extends DTODomainImplementation implements ims.correspondence.domain.CorrespondenceDetails, ims.domain.impl.Transactional
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public boolean dtoOnly() 
	{
		return false;
	}

	public Class getLookupServiceClass()
	{
		return ims.domain.lookups.impl.LookupServiceImpl.class;
	}

	/* (non-Javadoc)
	 * @see ims.correspondence.domain.GenerateDischargeLetter#saveDocumentDetails(ims.correspondence.vo.CorrespondenceDetailsVo)
	 */
	public CorrespondenceDetailsVo saveCorrespondenceDetails(CorrespondenceDetailsVo voDocDetail, LookupInstVo pasEventType) throws DomainInterfaceException, StaleObjectException, UniqueKeyViolationException 
	{

		if (!voDocDetail.isValidated())
		{
			throw new DomainRuntimeException("CorrespondenceDetailsVo not validated.");
		}

		DomainFactory factory = getDomainFactory();
		CorrespondenceDetails domDocDetails = null;
		
		domDocDetails = CorrespondenceDetailsVoAssembler.extractCorrespondenceDetails(factory,voDocDetail);
		
		try
		{
			factory.save(domDocDetails);
		}
		catch (UnqViolationUncheckedException e) 
		{
			throw new UniqueKeyViolationException("A Correspondence details already exists for the chosen PASEvent. Duplicates not allowed.", e);
		}
		
		saveCurrentDocStatus(voDocDetail,pasEventType);
		
		return CorrespondenceDetailsVoAssembler.create(domDocDetails);
		
	}
	
	private void saveCurrentDocStatus(CorrespondenceDetailsVo voDocDetail,LookupInstVo pasEventType) throws StaleObjectException
	{
		savePasEventDocumentStatus(voDocDetail);
		
		if (ConfigFlag.UI.DEMOGRAPHICS_TYPE.equals("IRISH"))
			savePasDocumentStatus(voDocDetail,pasEventType);			
	}
	
	private void savePasEventDocumentStatus(CorrespondenceDetailsVo voDocDetail) throws StaleObjectException
	{
		if (voDocDetail != null && voDocDetail.getCurrentStatusIsNotNull())
		{
			DomainFactory factory = getDomainFactory();
			PASEvent domPas = (PASEvent) factory.getDomainObject(PASEvent.class, voDocDetail.getPasEvent().getID_PASEvent());
			PasEventVo voPasEvent = PasEventVoAssembler.create(domPas);
						
			voPasEvent.setCspDocumentStatus(voDocDetail.getCurrentStatus());
			
			domPas = PasEventVoAssembler.extractPASEvent(factory,voPasEvent);
			
			factory.save(domPas);						
		}		
	}
	
	private String savePasDocumentStatus(CorrespondenceDetailsVo voDocDetail,LookupInstVo pasEventType) 
	{
		if (voDocDetail != null && voDocDetail.getCurrentStatusIsNotNull())
		{
			DomainFactory factory = getDomainFactory();
			PASEvent domPas = (PASEvent) factory.getDomainObject(PASEvent.class, voDocDetail.getPasEvent().getID_PASEvent());
			PasEventLiteVo voPasEvent = PasEventLiteVoAssembler.create(domPas);
			Result dtoResult;
			String strStatus = "";
			
			if (pasEventType != null)
			{
				if (pasEventType.equals(PasEventType.INPATIENT))
				{
					Inpatientlist inpat = (Inpatientlist)getDTOInstance(Inpatientlist.class);
					inpat.Filter.clear();
		
					strStatus = "" + voDocDetail.getCurrentStatus().getId();
		
					// Update impatient list
					inpat.Filter.Contactno = voPasEvent.getPasEventId();
					dtoResult = inpat.get();
					if (null  != dtoResult)
						return new String(dtoResult.toString());
					
					inpat.DataCollection.get(0).Documentstatus = strStatus;
					dtoResult = inpat.update();
					if (null != dtoResult)
						return new String(dtoResult.toString());
				}
				else if (pasEventType.equals(PasEventType.OUTPATIENT))
				{
					Outpatientlist outpat = (Outpatientlist)getDTOInstance(Outpatientlist.class);
					outpat.Filter.clear();
		
					strStatus = "" + voDocDetail.getCurrentStatus().getId();
					
					// Update outpatient list
					outpat.Filter.Contactno = voPasEvent.getPasEventId();					
					dtoResult = outpat.get();
					if (null  != dtoResult)
						return new String(dtoResult.toString());
					
					outpat.DataCollection.get(0).Documentstatus = strStatus;					
					
					dtoResult = outpat.update();
					if (null != dtoResult)
						return new String(dtoResult.toString());				
				}
			}
			else
				return ("No PAS event type found");
			
			Patientcontacts patientContacts = (Patientcontacts)getDTOInstance(Patientcontacts.class);
			patientContacts.Filter.clear();			
						
			PatientcontactsRecord patientContactsRecord = patientContacts.new PatientcontactsRecord();
			patientContactsRecord.Contactno = voPasEvent.getPasEventId();
			patientContactsRecord.Documentstatus = strStatus;
			
			patientContacts.Filter.Contactno = voPasEvent.getPasEventId();
			dtoResult = patientContacts.get();
			
			if (null != dtoResult)
				return new String (dtoResult.toString());

			patientContacts.DataCollection.get(0).Documentstatus = strStatus;
			dtoResult = patientContacts.update();
			if (null != dtoResult)
				return new String(dtoResult.toString());
									
		}
		
		return new String();		
	}
	
	/* (non-Javadoc)
	 * @see ims.correspondence.domain.GenerateDischargeLetter#getReportAndTemplate(java.lang.Integer, java.lang.Integer)
	 */
	public String[] getReportAndTemplate(Integer nReportId, Integer nTemplateId) throws ims.domain.exceptions.DomainInterfaceException
	{
		ProcessReport impl = (ProcessReport)getDomainImpl(ProcessReportImpl.class);
		return impl.getReportAndTemplate(nReportId,nTemplateId);
	}
	
	/* (non-Javadoc)
	 * @see ims.correspondence.domain.GenerateDischargeLetter#getReport(java.lang.Integer)
	 */
	public DocReportVo getReport(Integer nReportQueryId) 
	{
		ProcessReport impl = (ProcessReport)getDomainImpl(ProcessReportImpl.class);
		return impl.getReport(nReportQueryId);
	}

	/* (non-Javadoc)
	 * @see ims.correspondence.domain.GenerateDischargeLetter#listTemplateDischargeCategories(ims.admin.vo.ReportTemplateVo)
	 */
	public TemplateCategoryVo listTemplateDischargeCategories(ReportTemplateVo templateFilterVo) 
	{
		CorrespondenceHeadersAdmin impl = (CorrespondenceHeadersAdmin)getDomainImpl(CorrespondenceHeadersAdminImpl.class);
		return impl.getTemplateCategories(templateFilterVo);
		
		
	}
	
	/* (non-Javadoc)
	 * @see ims.correspondence.domain.GenerateDischargeLetter#getPatient(ims.core.vo.PatientShort)
	 */
	public ims.core.vo.Patient getPatient(PatientShort voPatient) throws ims.domain.exceptions.StaleObjectException
	{
		Demographics implDemographics = (Demographics)getDomainImpl(DemographicsImpl.class);
		return implDemographics.getPatient(voPatient);
	}

	public DocumentVo getDocument(DocumentVo filter)
	{
		ProcessReport impl = (ProcessReport) getDomainImpl(ProcessReportImpl.class);
		return impl.getDocument(filter);
	}

	public GpShortVoCollection listReferralGps(GP voGpFilter) 
	{
		DomainFactory factory = getDomainFactory();
		String andStr = " ";
		StringBuffer clause = new StringBuffer();
 
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		if (voGpFilter.getNameIsNotNull())
		{
			if (voGpFilter.getName().getForenameIsNotNull())
			{
				clause.append(" gp.name.upperForename like :forename");
				names.add("forename");
				values.add("%" + voGpFilter.getName().getForename().toUpperCase() + "%");		
				andStr = " and ";
			}
	
			if (voGpFilter.getName().getSurnameIsNotNull())
			{
				clause.append(andStr + " gp.name.upperSurname like :surname");
				names.add("surname");
				values.add("%" + voGpFilter.getName().getSurname().toUpperCase() + "%");		
				andStr = " and ";
			}
		}
		
		if (voGpFilter.getPracticesIsNotNull())
 		{
	  		if (voGpFilter.getPractices() != null)
			{
				if (voGpFilter.getPractices().get(0).getPractice().getAddress().getLine1() != null && voGpFilter.getPractices().get(0).getPractice().getAddress().getLine1().length() > 0)
				{
					clause.append(andStr + " gp.id = Pract.gp.id and (upper(Pract.practice.address.line1) like :partialAddress ");
					clause.append(" or upper(Pract.practice.address.line2) like :partialAddress");
					clause.append(" or upper(Pract.practice.address.line3) like :partialAddress");
					clause.append(" or upper(Pract.practice.address.line4) like :partialAddress");
					clause.append(" or upper(Pract.practice.address.line5) like :partialAddress )");
					//clause.append(" gp.id = Pract.gp.id and Pract.practice.address.line1 like :partialAddress ");

					names.add("partialAddress");
					values.add("%" + voGpFilter.getPractices().get(0).getPractice().getAddress().getLine1().toUpperCase() + "%");
					andStr = " and ";
				}
			}
        }
 
		String hql = "select distinct gp from Gp gp, GpToPractice Pract where ";
		
		hql += clause.toString();
		List gps = factory.find(hql,names,values);
		

		return GpShortVoAssembler.createGpShortVoCollectionFromGp(gps).sort();
	}
	
	
	public PasEventVo getPasEvent(PASEventRefVo pasEventRefVo) 
	{
		if (pasEventRefVo == null)
			throw new CodingRuntimeException("Mandatory Argument - PAS Event Required");
		
		ADT impl = (ADT)getDomainImpl(ADTImpl.class);
		return impl.getPasEvent(pasEventRefVo);
	}
	
	public CorrespondenceDetailsVo getCorrespondenceDetails(CorrespondenceDetailsRefVo voCorrespDetRefVo) 
	{
		if (voCorrespDetRefVo == null)
			throw new CodingRuntimeException("Mandatory Argument - Correspondence Details Required");
		
		DomainFactory factory = getDomainFactory();
		CorrespondenceDetails domCspDet = (CorrespondenceDetails) factory.getDomainObject(CorrespondenceDetails.class, voCorrespDetRefVo.getID_CorrespondenceDetails());
		return CorrespondenceDetailsVoAssembler.create(domCspDet);		
	}
	
	public CorrespondenceDetailsVo getCorrespondenceDetailsByPasEvent(PASEventRefVo voPasEventRef) 
	{
		if (voPasEventRef == null)
			throw new CodingRuntimeException("Mandatory Argument - PAS Event Required");
		DomainFactory factory = getDomainFactory();
		CorrespondenceDetails domCspDet = CorrespondenceDetails.getCorrespondenceDetailsFromPasEvent(factory, voPasEventRef.getID_PASEvent());
		return CorrespondenceDetailsVoAssembler.create(domCspDet);
	}
	
	public CorrespondenceStatusHistoryVoCollection getCorrespondenceStatusHistory(CorrespondenceDetailsRefVo voCorrespDetRef) 
	{
		if (voCorrespDetRef == null)
			throw new CodingRuntimeException("Mandatory Argument - Correspondence Details Required");
		DomainFactory factory = getDomainFactory();
		CorrespondenceDetails domCspDet = (CorrespondenceDetails) factory.getDomainObject(CorrespondenceDetails.class, voCorrespDetRef.getID_CorrespondenceDetails());
		return CorrespondenceStatusHistoryVoAssembler.createCorrespondenceStatusHistoryVoCollectionFromCorrespondenceStatusHistory(domCspDet.getCspStatusHistory());
	}

	public Patient getPatientLocal(PatientRefVo patientRefVo) 
	{
		Demographics implDemographics = (Demographics)getDomainImpl(DemographicsImpl.class);
		return implDemographics.getPatient(patientRefVo);
	}

	public DocumentVo getCurrentDocument(CorrespondenceDetailsRefVo voRefCorrecpondenceDetail) 
	{
		if (voRefCorrecpondenceDetail == null)
			throw new CodingRuntimeException("Mandatory Argument - Correspondence Details Required");
		
		CorrespondenceDetailsVo voCorrDet = getCorrespondenceDetails(voRefCorrecpondenceDetail);
		
		return voCorrDet.getCurrentDocument();
	}

	public ReportTemplateVoCollection listTemplates(Boolean activeOnly, Integer voMedicId, Integer voLocationId, Integer voServiceId) 
	{
		TemplateSelect implTemplateSelect = (TemplateSelect)getDomainImpl(TemplateSelectImpl.class);
		return implTemplateSelect.listTemplates(activeOnly,voMedicId,voLocationId,voServiceId);
	}

	public MedicLiteVoCollection listSignatories(String medicName) 
	{
		HcpAdmin impl = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return impl.listActiveMedics(medicName);
	}

	public UserEmailAccountVo getEmailAppUser(Integer appUserId) 
	{
		if (appUserId == null)
			throw new CodingRuntimeException("Mandatory Argument - Application User Id");

		DomainFactory factory = getDomainFactory();
		String hql = "select u1_1 from UserEmailAccount as u1_1 left join u1_1.appUser as a1_1 where (u1_1.appUser.id = :appUserId)";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		 
		markers.add("appUserId");
		values.add(appUserId);
		
		List UserEmailAcountList = factory.find(hql, markers, values);
		
		if (UserEmailAcountList != null && UserEmailAcountList.size() > 0)
		{
			UserEmailAccountVo voUserEmail = UserEmailAccountVoAssembler.createUserEmailAccountVoCollectionFromUserEmailAccount(UserEmailAcountList).get(0);
			return voUserEmail;
		}		 
		return null;
	}
	
}
