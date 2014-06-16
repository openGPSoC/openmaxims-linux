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

package ims.scheduling.domain;

// Generated from form domain impl
public interface PatientAppointmentManagement extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* searchPatients
	*/
	public ims.core.vo.PatientShortCollection searchPatients(ims.core.vo.PatientFilter filter) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* listBookingAppointmentByPatientAndDate
	*/
	public ims.scheduling.vo.Booking_AppointmentShortVoCollection listBookingAppointmentByPatientAndDate(ims.core.patient.vo.PatientRefVo patient, ims.framework.utils.Date apptDate);

	// Generated from form domain interface definition
	/**
	* saveBookingAppt
	*/
	public ims.scheduling.vo.Booking_AppointmentVo saveBookingAppt(ims.scheduling.vo.Booking_AppointmentShortVo appt, Boolean bUndoArrival, Boolean bUndoDNA) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* getServiceAndActivityByAppt
	*/
	public ims.scheduling.vo.SessionServiceAndSlotActivityVo getServiceAndActivityByAppt(ims.scheduling.vo.Booking_AppointmentRefVo appt, Boolean isFlexible);

	// Generated from form domain interface definition
	/**
	* getCatsReferralForAppointment
	*/
	public ims.careuk.vo.CatsReferralListVo getCatsReferralForAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt);

	// Generated from form domain interface definition
	/**
	* updateCatsReferralAdditionalInvStatus
	*/
	public void updateCatsReferralAdditionalInvStatus(ims.careuk.vo.CatsReferralRefVo catsReferral) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* getServiceAndProcedureByAppt
	*/
	public ims.scheduling.vo.SessionServiceProcedureConsultantVo getServiceProcedureConsultantByAppt(ims.scheduling.vo.Booking_AppointmentShortVo appt);

	// Generated from form domain interface definition
	/**
	* updateCatsReferralCancelStatus
	*/
	public void updateCatsReferralCancelStatus(ims.careuk.vo.CatsReferralRefVo catsReferral) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.scheduling.vo.Booking_AppointmentVo getBookingAppointmet(ims.scheduling.vo.Booking_AppointmentRefVo bookingApptRef);

	// Generated from form domain interface definition
	/**
	* saveBookingApptFull
	*/
	public ims.scheduling.vo.Booking_AppointmentVo saveBookingApptFull(ims.scheduling.vo.Booking_AppointmentVo bookingApptFull, Boolean isProcessedForRTT) throws ims.domain.exceptions.StaleObjectException;
}
