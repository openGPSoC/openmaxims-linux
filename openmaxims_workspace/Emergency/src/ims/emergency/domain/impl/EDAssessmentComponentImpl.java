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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4785.23502)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.clinical.configuration.domain.objects.ClinicalProblem;
import ims.clinical.vo.domain.ClinicalProblemShortVoAssembler;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.domain.objects.EmergencyAttendance;
import ims.core.admin.domain.objects.EpisodeOfCare;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.EmergencyAttendanceRefVo;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.EpisodeofCareShortVoAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.PatIdType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.configuration.domain.objects.AttendanceKPIConfig;
import ims.emergency.domain.Triage;
import ims.emergency.domain.base.impl.BaseEDAssessmentComponentImpl;
import ims.emergency.domain.objects.AttendanceRequiringContracting;
import ims.emergency.domain.objects.PatientMedicationOnAttendance;
import ims.emergency.domain.objects.SeenByHCP;
import ims.emergency.domain.objects.Tracking;
import ims.emergency.domain.objects.TrackingAttendanceStatus;
import ims.emergency.vo.EmergencyAttendanceForTriageLiteVo;
import ims.emergency.vo.HistoryOfPatientMedsVo;
import ims.emergency.vo.HistoryOfPatientMedsVoCollection;
import ims.emergency.vo.PatientMedsVo;
import ims.emergency.vo.SeenByHCPVo;
import ims.emergency.vo.TrackingAttendanceStatusVo;
import ims.emergency.vo.TrackingForClinicianWorklistAndTriageVo;
import ims.emergency.vo.TrackingListForClinicianWorklistVo;
import ims.emergency.vo.TrackingListForClinicianWorklistVoCollection;
import ims.emergency.vo.TrackingRefVo;
import ims.emergency.vo.TriageForClinicianWorklistVo;
import ims.emergency.vo.domain.AttendanceKPIConfigForClinicianWorklistVoAssembler;
import ims.emergency.vo.domain.EmergencyAttendanceForTriageLiteVoAssembler;
import ims.emergency.vo.domain.EpisodeOfcareLiteVoAssembler;
import ims.emergency.vo.domain.HistoryOfPatientMedsVoAssembler;
import ims.emergency.vo.domain.PatientMedsVoAssembler;
import ims.emergency.vo.domain.SeenByHCPVoAssembler;
import ims.emergency.vo.domain.TrackingAttendanceStatusVoAssembler;
import ims.emergency.vo.domain.TrackingForClinicianWorklistAndTriageVoAssembler;
import ims.emergency.vo.domain.TrackingListForClinicianWorklistVoAssembler;
import ims.emergency.vo.domain.TriageForClinicianWorklistVoAssembler;
import ims.emergency.vo.lookups.TrackingStatus;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EDAssessmentComponentImpl extends BaseEDAssessmentComponentImpl
{

	private static final long serialVersionUID = 1L;

	public ims.emergency.vo.EmergencyEpisodeForTriageVoCollection listAttendanceHistory(ims.core.patient.vo.PatientRefVo patient)
	{
		Triage triage = (Triage)getDomainImpl(TriageImpl.class);
		return triage.listAttendanceHistory(patient);
	}

	public ims.clinical.vo.ClinicalProblemShortVoCollection listClinicalProblems(String searchText)
	{
		Triage triage = (Triage)getDomainImpl(TriageImpl.class);
		return triage.listClinicalProblems(searchText);
	}

	public ims.emergency.vo.TrackingForClinicianWorklistAndTriageVo getTrackingForTriage(ims.emergency.vo.TrackingRefVo trackingId)
	{
		if(trackingId == null || trackingId.getID_Tracking() == null)
			throw new CodingRuntimeException("Cannot get Tracking record for a null Tracking Id.");
		
		return TrackingForClinicianWorklistAndTriageVoAssembler.create((Tracking) getDomainFactory().getDomainObject(Tracking.class, trackingId.getID_Tracking()));
	}

	public ims.emergency.vo.TrackingListForClinicianWorklistVoCollection listPatientsWaiting(ims.framework.interfaces.ILocation edLocation, ims.emergency.vo.lookups.TrackingStatus trackingStatus, ims.core.resource.people.vo.HcpRefVo allocatedHcp)
	{
		
		DomainFactory factory = getDomainFactory();
		
		StringBuilder hqlJoins = new StringBuilder("select tr , (select count (alert.id) from PatientAlert as alert where ( alert.isRIE = false or alert.isRIE is null ) and alert.isCurrentlyActiveAlert = true and alert.patient.id = p.id), (select count (allergy.id) from PatientAllergy as allergy where ( allergy.isRIE = false or allergy.isRIE is null ) and allergy.isCurrentlyActiveAllergy = true and allergy.patient.id = p.id) from Tracking as tr left join tr.patient as p left join tr.attendance as att ");
		StringBuilder hqlConditions = new StringBuilder(" where ((tr.isDischarged is null or tr.isDischarged = 0) and att.outcome is null) ");
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		String and = " and ";
		
		if(edLocation != null)
		{
			hqlJoins.append(" left join tr.eDLocation as loc ");
			
			hqlConditions.append(and);
			hqlConditions.append("loc.id = :locId");
			paramNames.add("locId");
			paramValues.add(edLocation.getID());
			and = " and ";
		}
		
		if(trackingStatus != null)
		{
			hqlJoins.append(" left join tr.currentStatus as cs left join cs.status as s ");
			
			hqlConditions.append(and);
			hqlConditions.append("s.id = :statusId");
			paramNames.add("statusId");
			paramValues.add(trackingStatus.getID());
			and = " and ";
		}
		
		//WDEV-16816
		if(allocatedHcp != null && allocatedHcp.getID_Hcp() != null)
		{
			HcpLiteVo tempHcpLiteVo = HcpLiteVoAssembler.create((Hcp) factory.getDomainObject(Hcp.class, allocatedHcp.getID_Hcp()));
			
			if (tempHcpLiteVo!=null && HcpDisType.MEDICAL.equals(tempHcpLiteVo.getHcpType()))
			{
				String[] allocatedHcpJoin = {" left join tr.seenBy as seenByHcp left join seenByHcp.allocatedMedic  as medic "};
			
			
    			for(int a=0; a<allocatedHcpJoin.length; a++)
    			{
    				if(hqlJoins.indexOf(allocatedHcpJoin[a]) < 0)
    				{
    					hqlJoins.append(allocatedHcpJoin[a]);
    				}
    			}
    			
    			hqlConditions.append(" and medic.id = :HcpId " );
    			paramNames.add("HcpId");
    			paramValues.add(allocatedHcp.getID_Hcp());
			}
			else if (tempHcpLiteVo!=null && HcpDisType.NURSING.equals(tempHcpLiteVo.getHcpType()))
			{
				String[] allocatedNurseJoin = {" left join tr.seenBy as seenByHcp left join seenByHcp.allocatedNurse as nurse "};
			
    			for(int a=0; a<allocatedNurseJoin.length; a++)
    			{
    				if(hqlJoins.indexOf(allocatedNurseJoin[a]) < 0)
    				{
    					hqlJoins.append(allocatedNurseJoin[a]);
    				}
    			}
    			
    			hqlConditions.append(" and nurse.id = :HcpId ");
    			paramNames.add("HcpId");
    			paramValues.add(allocatedHcp.getID_Hcp());
			}
			
		}
		
		//hqlConditions.append(" order by inpat.admissionDateTime desc");
		
		List<?> patients = factory.find(hqlJoins.append(hqlConditions.toString()).toString(), paramNames, paramValues);
		
		if(patients == null || patients.size() == 0)
			return null;
		
		TrackingListForClinicianWorklistVoCollection coll = new TrackingListForClinicianWorklistVoCollection();
		
		for(int i=0; i<patients.size(); i++)
		{
			Object[] items = (Object[]) patients.get(i);
			TrackingListForClinicianWorklistVo tracking = null;
			
			if(items[0] instanceof Tracking)
			{
				tracking = TrackingListForClinicianWorklistVoAssembler.create((Tracking) items[0]);
			}
			
			if(items[1] instanceof Long)
			{
				if(tracking != null && tracking.getPatient() != null)
				{
					tracking.getPatient().setHasAlerts(((Long) items[1]) > 0 ? Boolean.TRUE : Boolean.FALSE);
				}
			}
			
			if(items[2] instanceof Long)
			{
				if(tracking != null && tracking.getPatient() != null)
					
				{
					tracking.getPatient().setHasAllergies(((Long) items[2]) > 0 ? Boolean.TRUE : Boolean.FALSE);
				}
			}
			
			coll.add(tracking);
		}
		
		return coll;

	}

	public ims.emergency.vo.AttendanceKPIConfigForClinicianWorklistVo getAttendanceKPIConfigForClinicianWorklist(ims.framework.interfaces.ILocation edLocation)
	{
		if(edLocation == null)
			throw new CodingRuntimeException("Cannot get AttendanceKPIConfig for a null EDLocation Id.");
		
		DomainFactory factory = getDomainFactory();
		String query = "select kpi from AttendanceKPIConfig as kpi left join kpi.eDLocation as loc where loc.id = :EDLoc";
		
		List<?> list = factory.find(query, new String[] {"EDLoc"}, new Object[] {edLocation.getID()});
		
		if(list == null || list.size() == 0)
			return null;
		
		return AttendanceKPIConfigForClinicianWorklistVoAssembler.create((AttendanceKPIConfig) list.get(0));
	}

	public ims.emergency.vo.TrackingForClinicianWorklistAndTriageVo saveMedicStartTime(ims.emergency.vo.TrackingForClinicianWorklistAndTriageVo tracking) throws ims.domain.exceptions.StaleObjectException
	{
		if(tracking == null)
			throw new CodingRuntimeException("Cannot save a null Tracking record.");
		
		if(!tracking.isValidated())
			throw new CodingRuntimeException("Tracking record is not validated.");
		
		DomainFactory factory = getDomainFactory();
		Tracking doTracking = TrackingForClinicianWorklistAndTriageVoAssembler.extractTracking(factory, tracking);
		if( doTracking != null )
		{
			doTracking.getTriageDetails().setMedicInterventionStartDateTime(tracking.getTriageDetails().getMedicInterventionStartDateTime().getJavaDate());
			factory.save(doTracking);
		}
		
		
		
		return TrackingForClinicianWorklistAndTriageVoAssembler.create(doTracking);
	}

	public ims.emergency.vo.TriageProtocolAssessmentForTriageVoCollection listOtherProblems(ims.core.admin.vo.CareContextRefVo careContext)
	{
		Triage triage = (Triage)getDomainImpl(TriageImpl.class);
		return triage.listOtherProblems(careContext);
	}

	public ims.emergency.vo.TrackingForClinicianWorklistAndTriageVo getTrackingForClinicianWorklistByCareContext(ims.core.admin.vo.CareContextRefVo careContext)
	{
		if(careContext == null || careContext.getID_CareContext() == null)
			throw new CodingRuntimeException("Cannot get Tracking record for a null Care Context Id.");
		
		DomainFactory factory = getDomainFactory();
		String query = "select tr from Tracking as tr left join tr.attendance as att left join att.careContext as cc where cc.id = :CareContextId";
		
		List<?> trackingList = factory.find(query, new String[] {"CareContextId"}, new Object[] {careContext.getID_CareContext()});
		
		if(trackingList == null || trackingList.size() == 0)
			return null;
		
		return TrackingForClinicianWorklistAndTriageVoAssembler.create((Tracking) trackingList.get(0));
	}

	public ims.emergency.vo.TrackingForClinicianWorklistAndTriageVo geTrackingForTriageByAttendanceId(ims.core.admin.vo.EmergencyAttendanceRefVo attendanceId)
	{
		if(attendanceId == null || attendanceId.getID_EmergencyAttendance() == null)
			throw new CodingRuntimeException("Cannot get Tracking record for a null Attendance Id.");
		
		DomainFactory factory = getDomainFactory();
		String query = "select tr from Tracking as tr left join tr.attendance as att where att.id = :AttendanceId";
		
		List<?> list = factory.find(query, new String[] {"AttendanceId"}, new Object[] {attendanceId.getID_EmergencyAttendance()});
		
		if(list == null || list.size() == 0)
			return null;
		
		return TrackingForClinicianWorklistAndTriageVoAssembler.create((Tracking) list.get(0));
	}

	public ims.core.vo.EpisodeofCareShortVo getEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCare)
	{
		if(episodeOfCare == null || episodeOfCare.getID_EpisodeOfCare() == null)
			throw new CodingRuntimeException("Cannnot get EOC for a null Id.");
		
		return EpisodeofCareShortVoAssembler.create((EpisodeOfCare) getDomainFactory().getDomainObject(EpisodeOfCare.class, episodeOfCare.getID_EpisodeOfCare()));
	}

	public ims.core.vo.CareContextShortVo getCareContext(ims.core.admin.vo.CareContextRefVo careContext)
	{
		if(careContext == null || careContext.getID_CareContext() == null)
			throw new CodingRuntimeException("Cannot get CC for a null Id.");
	
		return CareContextShortVoAssembler.create((CareContext) getDomainFactory().getDomainObject(CareContext.class, careContext.getID_CareContext()));
	}

	public ims.core.vo.PatientShort getPatientShort(ims.core.patient.vo.PatientRefVo patientRefVo)
	{
		if(patientRefVo == null || patientRefVo.getID_Patient() == null)
			throw new CodingRuntimeException("Cannnot get EOC for a null Id.");
		
		return PatientShortAssembler.create((Patient) getDomainFactory().getDomainObject(Patient.class, patientRefVo.getID_Patient()));
	}

	public ims.emergency.vo.TrackingForClinicianWorklistAndTriageVo getTrackingForClinicianByActiveCareContext(ims.core.patient.vo.PatientRefVo patientRef)
	{
		if(patientRef == null)
			throw new CodingRuntimeException("Cannot get Tracking record for a null Patient Id.");
		
		DomainFactory factory = getDomainFactory();
		String query = "select tr from Tracking as tr left join tr.attendance as att left join att.careContext as cc left join cc.episodeOfCare as EOC left join EOC.careSpell as CS  left join CS.patient as PAT where cc.endDateTime is null and PAT.id = :PatientId";
		
		List<?> trackingList = factory.find(query, new String[] {"PatientId"}, new Object[] {patientRef.getID_Patient()});
		
		if(trackingList == null || trackingList.size() == 0)
			return null;
		
		return TrackingForClinicianWorklistAndTriageVoAssembler.create((Tracking) trackingList.get(0));
	}

	//WDEV-16816
	public TrackingForClinicianWorklistAndTriageVo saveTrackingSeenByHcp(TrackingForClinicianWorklistAndTriageVo tracking, SeenByHCPVo seenByHcp) throws StaleObjectException
	{
		if (tracking == null || tracking.getID_Tracking() == null)
			throw new CodingRuntimeException("Major logical erros - tracking record can not be null");
		
		DomainFactory factory = getDomainFactory();
		
		// Get latest tracking domain object
		Tracking doTracking = (Tracking) factory.getDomainObject(Tracking.class, tracking.getID_Tracking());
		
		if (doTracking == null || doTracking.getSeenBy() != null)
		{
			throw new StaleObjectException(doTracking);
		}

		// Create status for the Tracking bo
		TrackingAttendanceStatusVo updatedStatus = new TrackingAttendanceStatusVo();
		updatedStatus.setPatient(seenByHcp.getPatient());
		updatedStatus.setEpisode(seenByHcp.getEpisode());
		updatedStatus.setAttendance(seenByHcp.getAttendance());
		
		if (seenByHcp.getAllocatedMedic()!=null )
		{
			updatedStatus.setCreatedBy(seenByHcp.getAllocatedMedic().getMos());
		}
		else if (seenByHcp.getAllocatedNurse()!=null)
		{
			updatedStatus.setCreatedBy(seenByHcp.getAllocatedNurse().getMos());
		}
		
		updatedStatus.setTrackingArea(seenByHcp.getTrackingArea());
		updatedStatus.setStatusDatetime(new DateTime());
		updatedStatus.setStatus(TrackingStatus.BEING_ATTENDED_TO);
		
		// Extract domain object for Tracking status
		TrackingAttendanceStatus doStatus = TrackingAttendanceStatusVoAssembler.extractTrackingAttendanceStatus(factory, updatedStatus);
		// Extract domain object for Current Allocated status
		SeenByHCP doSeenBy = SeenByHCPVoAssembler.extractSeenByHCP(factory, seenByHcp);

		doTracking.setCurrentStatus(doStatus);
		doTracking.setSeenBy(doSeenBy);
		
		factory.save(doTracking);

		return TrackingForClinicianWorklistAndTriageVoAssembler.create(doTracking);
	}

	public ims.emergency.vo.EmergencyAttendanceForTriageLiteVo getEmergencyAttendance(ims.core.admin.vo.EmergencyAttendanceRefVo attendanceRef)
	{
		if(attendanceRef == null)
			throw new CodingRuntimeException("Cannot get Attendance on null Id.");
		
		return EmergencyAttendanceForTriageLiteVoAssembler.create((EmergencyAttendance) getDomainFactory().getDomainObject(EmergencyAttendance.class, attendanceRef.getID_EmergencyAttendance()));
	
	}

	public ims.emergency.vo.EpisodeOfcareLiteVo getEpisodeOfCareLite(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRef)
	{
		if( episodeOfCareRef == null )
			throw new CodingRuntimeException("EpisodeOfCareRefVo not provided");
		
		DomainFactory factory = getDomainFactory();
		EpisodeOfCare doEpisodeOfCare = (EpisodeOfCare) factory.getDomainObject(EpisodeOfCare.class, episodeOfCareRef.getID_EpisodeOfCare());
		return EpisodeOfcareLiteVoAssembler.create(doEpisodeOfCare);
	}

	public ims.clinical.vo.ClinicalProblemShortVo getClinicalProblemShortVo(ims.clinical.configuration.vo.ClinicalProblemRefVo clinicalRef)
	{
		if(	clinicalRef == null )
			throw new CodingRuntimeException("TrackingRefVo cannot be null");
	
		return ClinicalProblemShortVoAssembler.create((ClinicalProblem) getDomainFactory().getDomainObject(ClinicalProblem.class, clinicalRef.getID_ClinicalProblem()));
	
	}

	//WDEV-16816
	public TrackingForClinicianWorklistAndTriageVo saveTracking(TrackingForClinicianWorklistAndTriageVo tracking, SeenByHCPVo seenByHcp, PatientMedsVo patmed) throws StaleObjectException
	{
		if(tracking == null)
			throw new CodingRuntimeException("Cannot save a null Tracking record.");
		
		if(!tracking.isValidated())
			throw new CodingRuntimeException("Tracking record is not validated.");
		
		DomainFactory factory = getDomainFactory();
		//wdev-15930
		SeenByHCP doSeenBy = null;
		if( seenByHcp != null )
		{
			doSeenBy = SeenByHCPVoAssembler.extractSeenByHCP(factory, seenByHcp);
			if( doSeenBy != null )
			{
				factory.save(doSeenBy);
				
			}
		}
			
		//-------------wdev-15930------------
		TriageForClinicianWorklistVo triagedetails = tracking.getTriageDetails();
		
		ims.emergency.domain.objects.Triage doTriage = TriageForClinicianWorklistVoAssembler.extractTriage(factory, triagedetails);
		if( doTriage != null )
		{
			factory.save(doTriage);
		}
		Tracking doTracking = TrackingForClinicianWorklistAndTriageVoAssembler.extractTracking(factory, tracking);
		if( doSeenBy != null ) 
		{
			doTracking.setSeenBy(doSeenBy);
		}
		else if (seenByHcp == null && patmed==null  && tracking.getCurrentStatusIsNotNull() && TrackingStatus.WAITING_TO_BE_SEEN_BY_A_MEDIC.equals(tracking.getCurrentStatus().getStatus()))//WDEV-18278
		{
    		//on Move,when setting the status to WAITING_TO_BE_SEEN_BY_A_MEDIC, mark currentSeenByAsCompleted and set SeenBy from Tracking to null
    		SeenByHCP doSeenByHcp = doTracking.getSeenBy();
    		if (doSeenByHcp!=null)
    		{
    			doSeenByHcp.setCompletedDateTime(new Date());
    			factory.save(doSeenByHcp);
    			doTracking.setSeenBy(null);
    		}
		}
		
		if( doTriage != null) 
		{
			doTracking.setTriageDetails(doTriage);
		}
		
		factory.save(doTracking);
		
		//wdev-17825
		if( patmed != null)
		{
			PatientMedicationOnAttendance doPatientMedicationOnAttendance = PatientMedsVoAssembler.extractPatientMedicationOnAttendance(factory, patmed);
			if( doPatientMedicationOnAttendance != null )
				factory.save(doPatientMedicationOnAttendance);
		}
		
		return TrackingForClinicianWorklistAndTriageVoAssembler.create(doTracking);
	}

	
	public TrackingForClinicianWorklistAndTriageVo getTrackingForClinicianWorklistAndTriageVo(TrackingRefVo trackingRef)
	{
		if(trackingRef == null )
			throw new CodingRuntimeException("TrackingRefVo cannot be null");
	
		return TrackingForClinicianWorklistAndTriageVoAssembler.create((Tracking) getDomainFactory().getDomainObject(Tracking.class, trackingRef.getID_Tracking()));
	
	}

	//wdev-17645
	public SeenByHCPVo getFirstSeenByHCP(CareContextRefVo careContextRef) 
	{
		if (careContextRef == null || careContextRef.getID_CareContext() == null)
		{
			throw new CodingRuntimeException("Cannot get SeenByHCPVoCollection on null Id for CareContext ");
		}

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();
		hql.append("select allSeenBy from SeenByHCP as allSeenBy where (allSeenBy.attendance.id = :attID and allSeenBy.allocatedMedic is not null) order by allSeenBy.seenDateTime asc");

		List<?> list = factory.find(hql.toString(), new String[] { "attID" }, new Object[] { careContextRef.getID_CareContext() });
		if( list != null && list.size() >  0)
		{
			return SeenByHCPVoAssembler.create((SeenByHCP) list.get(0));
			
		}

		return null;
	}


	//wdev-17825
	public HistoryOfPatientMedsVo getHistoryOfPatientMedsVo(String nHSNumber) 
	{
		if( nHSNumber == null )
			return null;
			
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		
		hql.append("select h1_1 from HistoryOfPatientMeds as h1_1 where	(h1_1.nHSNumber = :nhsnumber) order by h1_1.systemInformation.creationDateTime desc");
	
		List<?> list = factory.find(hql.toString(), new String[] {"nhsnumber"}, new Object[] {nHSNumber});
		if( list != null && list.size() > 0)
		{
			HistoryOfPatientMedsVoCollection tempColl = HistoryOfPatientMedsVoAssembler.createHistoryOfPatientMedsVoCollectionFromHistoryOfPatientMeds(list);
			if( tempColl != null && tempColl.size() == 1)	
				return tempColl.get(0);
			
		}

		return null;
	}

	//wdev-17825
	public String getNHSNumber(PatientRefVo patientRef) 
	{
		if( patientRef == null )
			throw new CodingRuntimeException("PatientRefVo is null.");
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		
		
		hql.append("select p2_1.value from Patient as p1_1 left join p1_1.identifiers as p2_1 left join p2_1.type as l1_1 where (p1_1.id  = :patientId and l1_1.id = :nhsnumber ) ");
	
		List<?> list = factory.find(hql.toString(), new String[] {"patientId","nhsnumber"}, new Object[] {patientRef.getID_Patient(),PatIdType.NHSN.getID()});
		if( list != null && list.size() > 0)
			return (String) list.get(0);
		
		return null;
	}

	//WDEV-17839
	public void refreshCoding(EmergencyAttendanceForTriageLiteVo attendanceToSave) throws StaleObjectException
	{
		// Check parameter to save
		if (attendanceToSave == null)
			throw new CodingRuntimeException("Can not save null record to data base.");
		
		if (!attendanceToSave.isValidated())
			throw new CodingRuntimeException("Can not save record not validated to data base.");
		
		// Extract domain object
		EmergencyAttendance domEmergencyAtt = EmergencyAttendanceForTriageLiteVoAssembler.extractEmergencyAttendance(getDomainFactory(), attendanceToSave);
		
		getDomainFactory().save(domEmergencyAtt);
		
		
		AttendanceRequiringContracting tempAttReqContracting = attendanceFoundInAttendanceReqContracting(attendanceToSave);
		if (tempAttReqContracting==null )
		{
			AttendanceRequiringContracting doAttendanceRequiringContracting=new AttendanceRequiringContracting();
			doAttendanceRequiringContracting.setPatient(domEmergencyAtt.getPatient());
			doAttendanceRequiringContracting.setAttendance(domEmergencyAtt);
			
			getDomainFactory().save(doAttendanceRequiringContracting);
		}
		else //if found, set the status to null
		{
			tempAttReqContracting.setStatus(null);
			getDomainFactory().save(tempAttReqContracting);
		}
		
		return;
	}

	//WDEV-17839
    private AttendanceRequiringContracting attendanceFoundInAttendanceReqContracting(EmergencyAttendanceRefVo attendance)
    {
    	if(attendance == null || attendance.getID_EmergencyAttendance() == null)
    		throw new CodingRuntimeException("Cannot list Attendance Requiring Contracting for a null attendance Id.");
    	
    	String query = "select attReqContr from AttendanceRequiringContracting as attReqContr where attReqContr.attendance.id = :attId ";
    	
    	List list=getDomainFactory().find(query, new String[] {"attId"}, new Object[] {attendance.getID_EmergencyAttendance()});
    	if (list!=null && list.size()>0)
    	{
    		//return true;
    		return (AttendanceRequiringContracting)list.get(0);
    	}
    	//return false;
    	return null;
    }

}
