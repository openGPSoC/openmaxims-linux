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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;


import ims.core.admin.domain.objects.EmergencyAttendance;
import ims.core.admin.domain.objects.EmergencyEpisode;
import ims.core.admin.domain.objects.EpisodeOfCare;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.domain.DomainFactory;
import ims.emergency.domain.base.impl.BaseEmergencyAttendancesDialogImpl;
import ims.emergency.vo.AttendanceDetailsVo;
import ims.emergency.vo.AttendanceDetailsVoCollection;
import ims.emergency.vo.EpisodeDetailsVo;
import ims.emergency.vo.EpisodeDetailsVoCollection;
import ims.emergency.vo.EpisodeDetailsWithoutAttendancesVo;
import ims.emergency.vo.EpisodeOfcareLiteVo;
import ims.emergency.vo.domain.AttendanceDetailsVoAssembler;
import ims.emergency.vo.domain.EpisodeDetailsVoAssembler;
import ims.emergency.vo.domain.EpisodeDetailsWithoutAttendancesVoAssembler;
import ims.emergency.vo.domain.EpisodeOfcareLiteVoAssembler;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;

import java.util.List;

public class EmergencyAttendancesDialogImpl extends BaseEmergencyAttendancesDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ims.emergency.vo.EpisodeDetailsVoCollection listEmergencyEpisodeByPatient(PatientRefVo patientRef, Date startDate, Date endDate)
	{
		if(patientRef == null || patientRef.getID_Patient() == null)
			throw new CodingRuntimeException("Patient not provided");
		
		DomainFactory factory = getDomainFactory();
		
		
		String hsql = "select e1_1,e3_1 from EmergencyEpisode as e1_1 left join e1_1.episodeOfCare as e2_1 left join e2_1.careSpell as c1_1 left join c1_1.patient as p1_1 left join e1_1.emergencyAttendances as e3_1 where e1_1.isRIE is null and p1_1.id = :idPatient"; 


		
		List episodeDetails = null;
		
		if(startDate == null && endDate == null)
		{
			String hsql1 = "select e1_1 from EmergencyEpisode as e1_1 left join e1_1.episodeOfCare as e2_1 left join e2_1.careSpell as c1_1 left join c1_1.patient as p1_1 left join e1_1.emergencyAttendances as e3_1 where e1_1.isRIE is null and p1_1.id = :idPatient";
			episodeDetails = factory.find(hsql1, new String[] {"idPatient"}, new Object[] {patientRef.getID_Patient()});
			if (episodeDetails != null && episodeDetails.size() > 0)
				return EpisodeDetailsVoAssembler.createEpisodeDetailsVoCollectionFromEmergencyEpisode(episodeDetails).sort(SortOrder.DESCENDING);
			else
				return null;
			
		}
		else if(startDate != null && endDate == null)
		{
			java.util.Date javaStartDate = startDate.getDate();
			hsql += " and e3_1.arrivalDateTime > :StartDate";
			episodeDetails = factory.find(hsql, new String[] {"idPatient","StartDate"}, new Object[] {patientRef.getID_Patient(),javaStartDate});
			if(episodeDetails != null && episodeDetails.size() > 0)
			{
				return populateEpisodeAndAttendances(episodeDetails).sort(SortOrder.DESCENDING);
			}
			else
				return null;
				
		}
		else if(startDate == null && endDate != null)
		{
			java.util.Date javaEndDate = endDate.getDate();
			hsql += " and e3_1.arrivalDateTime < :EndDate";
			episodeDetails = factory.find(hsql, new String[] {"idPatient","EndDate"}, new Object[] {patientRef.getID_Patient(),javaEndDate});
			if(episodeDetails != null && episodeDetails.size() > 0)
			{
				return populateEpisodeAndAttendances(episodeDetails).sort(SortOrder.DESCENDING);
			}
			else
				return null;
		}
		else
		{
			java.util.Date javaStartDate = startDate.getDate();
			endDate.addDay(1);
			java.util.Date javaEndDate = endDate.getDate();
			hsql += " and e3_1.arrivalDateTime between :StartDate and :EndDate";
			episodeDetails = factory.find(hsql, new String[] {"idPatient","StartDate","EndDate"}, new Object[] {patientRef.getID_Patient(),javaStartDate,javaEndDate});
			if(episodeDetails != null && episodeDetails.size() > 0)
			{
				return populateEpisodeAndAttendances(episodeDetails).sort(SortOrder.DESCENDING);
			}
			else
				return null;
		}
			
			
				
	}
	private EpisodeDetailsVo copyEpisodeDetails(EpisodeDetailsWithoutAttendancesVo epWithoutVo)
	{
		if(epWithoutVo == null)
			return null;
		EpisodeDetailsVo tempVo = new EpisodeDetailsVo(epWithoutVo.getID_EmergencyEpisode(),epWithoutVo.getVersion_EmergencyEpisode());
		tempVo.setCategory(epWithoutVo.getCategory());
		tempVo.setElapsedPeriod(epWithoutVo.getElapsedPeriod());
		tempVo.setElapsedTime(epWithoutVo.getElapsedTime());
		
		tempVo.setEpisodeOfCare(epWithoutVo.getEpisodeOfCare());
		tempVo.setIncidentLocation(epWithoutVo.getIncidentLocation());
		tempVo.setInjuryDateTime(epWithoutVo.getInjuryDateTime());
		tempVo.setIsRIE(epWithoutVo.getIsRIE());
		tempVo.setLocationDetails(epWithoutVo.getLocationDetails());
		tempVo.setMobility(epWithoutVo.getMobility());
		tempVo.setOccupation(epWithoutVo.getOccupation());
		tempVo.setOccupationStatus(epWithoutVo.getOccupationStatus());
		tempVo.setPlaceofEmployment(epWithoutVo.getPlaceofEmployment());
		tempVo.setPresentingComplaint(epWithoutVo.getPresentingComplaint());
		tempVo.setReferringGP(epWithoutVo.getReferringGP());
		tempVo.setSchool(epWithoutVo.getSchool());
		tempVo.setSourceOfReferral(epWithoutVo.getSourceOfReferral());
		tempVo.setTriageCategoryType(epWithoutVo.getTriageCategoryType());
		tempVo.setSpecialInterestDetails(epWithoutVo.getSpecialInterestDetails());
		tempVo.setRTADetails(epWithoutVo.getRTADetails());
		tempVo.setTiig(epWithoutVo.getTiig());
				
		return tempVo;
	}
	private EpisodeDetailsVoCollection populateEpisodeAndAttendances(List episodeDetails)
	{
		if(episodeDetails == null || episodeDetails.size() == 0)
			return null;
		EpisodeDetailsVoCollection tempEpisodeColl = new EpisodeDetailsVoCollection();
		EpisodeDetailsVo tempEpVo = null;
		AttendanceDetailsVoCollection tempAttCol = null;
		AttendanceDetailsVo tempAttVo = null;
		for(int i = 0; i < episodeDetails.size();i++)
		{
			Object[] temp = (Object[]) episodeDetails.get(i);
			EpisodeDetailsWithoutAttendancesVo epWithoutVo = EpisodeDetailsWithoutAttendancesVoAssembler.create((EmergencyEpisode) temp[0]);
			
			if(tempEpVo == null)
			{
				tempEpVo = copyEpisodeDetails(epWithoutVo);
				tempAttCol = new AttendanceDetailsVoCollection();
				tempEpisodeColl.add(tempEpVo);
			}
			else
			{
				tempEpVo = copyEpisodeDetails(epWithoutVo);
				if(!tempEpisodeColl.contains(tempEpVo))
				{
					tempEpisodeColl.add(tempEpVo);
					tempAttCol = new AttendanceDetailsVoCollection();
				}
				else
				{
					if(	tempEpisodeColl != null )
					{
						tempEpVo = tempEpisodeColl.get(tempEpisodeColl.indexOf(tempEpVo));
						if(	tempEpVo != null)
							tempAttCol = tempEpVo.getEmergencyAttendances();
					}
				}
			
			}
			tempAttVo = AttendanceDetailsVoAssembler.create((EmergencyAttendance) temp[1]);
			if(tempAttVo != null)
			{
				if( tempAttCol != null)
					tempAttCol.add(tempAttVo);
				else
				{
					tempAttCol = new AttendanceDetailsVoCollection();
					tempAttCol.add(tempAttVo);
				}
			}
			if(	tempEpVo != null)
				tempEpVo.setEmergencyAttendances(tempAttCol);
		}
		return tempEpisodeColl;
	}
	//wdev-16070
	public EpisodeOfcareLiteVo getEpisodeOfCareLite(EpisodeOfCareRefVo episodeOfCareRef)
	{
		if( episodeOfCareRef == null )
			throw new CodingRuntimeException("EpisodeOfCareRefVo not provided");
		
		DomainFactory factory = getDomainFactory();
		EpisodeOfCare doEpisodeOfCare = (EpisodeOfCare) factory.getDomainObject(EpisodeOfCare.class, episodeOfCareRef.getID_EpisodeOfCare());
		return EpisodeOfcareLiteVoAssembler.create(doEpisodeOfCare);
	}
}
