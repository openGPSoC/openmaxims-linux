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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.emergency.domain;

// Generated from form domain impl
public interface DischargeDetails_Outcome extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.emergency.vo.TrackingAttendanceOutcomeVo getTrackingAttendanceOutcomeVo(ims.core.admin.vo.CareContextRefVo careContext);

	// Generated from form domain interface definition
	public void saveTrackingAttendanceOutcome(ims.emergency.vo.TrackingAttendanceOutcomeVo trackingAttendance, ims.emergency.vo.enums.Discharge_Action action) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.emergency.vo.EmergencyAttendanceOutcomeVo getLatestEmergencyAttendance(ims.core.patient.vo.PatientRefVo patientRef);

	// Generated from form domain interface definition
	public ims.core.vo.PatientShort getPatientShort(ims.core.patient.vo.PatientRefVo patRef);

	// Generated from form domain interface definition
	public ims.emergency.vo.TrackingForClinicianWorklistAndTriageVo getTrackingForClinicianWorklistAndTriageVo(ims.emergency.vo.TrackingRefVo trackRef);

	// Generated from form domain interface definition
	public Boolean hasDiagnosesTreatmentsInterventionsOrInvestigations(ims.core.patient.vo.PatientRefVo patient, ims.core.admin.vo.CareContextRefVo careContext);

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVo getCurrentHospital(ims.framework.interfaces.ILocation currentLocation);

	// Generated from form domain interface definition
	public Boolean dischargePlanningAdviceHasComments(ims.core.admin.vo.CareContextRefVo careContextRef);
}
