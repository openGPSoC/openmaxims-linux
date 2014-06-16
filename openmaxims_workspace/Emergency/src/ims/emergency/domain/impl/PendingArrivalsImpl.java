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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4471.18200)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.domain.objects.EmergencyAttendance;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.domain.base.impl.BasePendingArrivalsImpl;
import ims.emergency.domain.objects.Tracking;
import ims.emergency.vo.EmergencyAttendanceForPendingArrivalsVo;
import ims.emergency.vo.EmergencyAttendanceForPendingArrivalsVoCollection;
import ims.emergency.vo.TrackingForQuickRegistrationVo;
import ims.emergency.vo.domain.EmergencyAttendanceForPendingArrivalsVoAssembler;
import ims.emergency.vo.domain.TrackingForQuickRegistrationVoAssembler;
import ims.emergency.vo.lookups.ReferredBy;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class PendingArrivalsImpl extends BasePendingArrivalsImpl
{

	private static final long serialVersionUID = 1L;

	public PatientShort getPatientShort(PatientRefVo patientRef)
	{
		if (patientRef == null || patientRef.getID_Patient() == null)
		{
			throw new CodingRuntimeException("Cannot get PatientShort on null Id ");
		}

		DomainFactory factory = getDomainFactory();
		Patient domainPatient = (Patient) factory.getDomainObject(Patient.class, patientRef.getID_Patient());

		return PatientShortAssembler.create(domainPatient);
	}

	public EmergencyAttendanceForPendingArrivalsVoCollection listPendingArrivals(LocationRefVo location, String surnameSearchText, String forenameSearchText, ReferredBy sourceOfReferral)
	{

		if (location == null || location.getID_Location() == null)
		{
			throw new CodingRuntimeException("Cannot get EmergencyAttendanceForPendingArrivalsVoCollection on null Id for Location ");
		}

		String hql = "select emergAtt from EmergencyAttendance as emergAtt left join emergAtt.emergencyEpisode as emergEpisode left join emergAtt.patient as patient where emergAtt.dischargeDateTime is null and emergAtt.expectedArrivalDateTime is not null ";
		StringBuilder hqlConditions = new StringBuilder(" ");

		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		String andStr = "and";

		hqlConditions.append(andStr);
		hqlConditions.append(" emergAtt.registrationLocation.id = :locID ");
		markers.add("locID");
		values.add(location.getID_Location());
		andStr = " and ";

		hqlConditions.append(andStr);
		hqlConditions.append(" emergAtt.isExpectedArrival = :isExpectedArrival ");
		markers.add("isExpectedArrival");
		values.add(Boolean.TRUE);
		andStr = " and ";

		if (surnameSearchText != null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" patient.name.upperSurname like :surname ");
			markers.add("surname");
			values.add(surnameSearchText.toUpperCase() + "%");
			andStr = " and ";
		}

		if (forenameSearchText != null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" patient.name.upperForename like :forename ");
			markers.add("forename");
			values.add(forenameSearchText.toUpperCase() + "%");
			andStr = " and ";
		}

		if (sourceOfReferral != null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append("  emergEpisode.sourceOfReferral.id = :source  ");
			markers.add("source");
			values.add(sourceOfReferral.getID());
			andStr = " and ";
		}

		hqlConditions.append(" ) order by emergAtt.arrivalDateTime asc ");

		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find((hql + hqlConditions.toString()).toString(), markers, values);

		EmergencyAttendanceForPendingArrivalsVoCollection collection = EmergencyAttendanceForPendingArrivalsVoAssembler.createEmergencyAttendanceForPendingArrivalsVoCollectionFromEmergencyAttendance(list);

		return collection;

	}

	public Boolean isStale(TrackingForQuickRegistrationVo trackingToSave)
	{
		if (trackingToSave == null || trackingToSave.getID_Tracking() == null)
		{
			throw new CodingRuntimeException("Cannot get TrackingForQuickRegistrationVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();
		Tracking domainTracking = (Tracking) factory.getDomainObject(Tracking.class, trackingToSave.getID_Tracking());

		if (domainTracking == null)
		{
			return true;
		}

		if (domainTracking.getVersion() > trackingToSave.getVersion_Tracking())
		{
			return true;
		}

		return false;
	}

	public EmergencyAttendanceForPendingArrivalsVo save(TrackingForQuickRegistrationVo trackingToSave, EmergencyAttendanceForPendingArrivalsVo emergencyAttendanceToSave) throws StaleObjectException
	{
		if (trackingToSave == null && emergencyAttendanceToSave == null)
			throw new CodingRuntimeException("Cannot save null AllocatedMedic or TrackingForAllocatedMedicVo ");

		if (!trackingToSave.isValidated())
			throw new DomainRuntimeException("TrackingForQuickRegistrationVo Not Validated.");

		if (!emergencyAttendanceToSave.isValidated())
			throw new DomainRuntimeException("EmergencyAttendanceForPendingArrivalsVo Not Validated.");

		DomainFactory factory = getDomainFactory();

		Tracking domainTracking = TrackingForQuickRegistrationVoAssembler.extractTracking(factory, trackingToSave);
		factory.save(domainTracking);

		EmergencyAttendance domainEmergencyAtt = EmergencyAttendanceForPendingArrivalsVoAssembler.extractEmergencyAttendance(factory, emergencyAttendanceToSave);
		factory.save(domainEmergencyAtt);

		return EmergencyAttendanceForPendingArrivalsVoAssembler.create(domainEmergencyAtt);

	}

	public Boolean isStaleEmergencyAttendance(EmergencyAttendanceForPendingArrivalsVo emergencyAtt)
	{
		if (emergencyAtt == null || emergencyAtt.getID_EmergencyAttendance() == null)
		{
			throw new CodingRuntimeException("Cannot get EmergencyAttendanceForPendingArrivalsVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();
		EmergencyAttendance domainEmergencyAtt = (EmergencyAttendance) factory.getDomainObject(EmergencyAttendance.class, emergencyAtt.getID_EmergencyAttendance());

		if (domainEmergencyAtt == null)
		{
			return true;
		}

		if (domainEmergencyAtt.getVersion() > emergencyAtt.getVersion_EmergencyAttendance())
		{
			return true;
		}

		return false;
	}

	//WDEV-17396
	public CareContextShortVo getCareContext(CareContextRefVo careContextRef)
	{
		if (careContextRef == null || careContextRef.getID_CareContext() == null)
		{
			throw new CodingRuntimeException("Cannot get CareContextShort on null Id ");
		}

		DomainFactory factory = getDomainFactory();
		CareContext domainCareContext = (CareContext) factory.getDomainObject(CareContext.class, careContextRef.getID_CareContext());

		return CareContextShortVoAssembler.create(domainCareContext);
	}

}
