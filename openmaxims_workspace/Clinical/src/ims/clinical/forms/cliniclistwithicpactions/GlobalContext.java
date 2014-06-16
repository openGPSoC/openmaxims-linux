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

package ims.clinical.forms.cliniclistwithicpactions;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Scheduling = new SchedulingContext(context);
		CareUk = new CareUkContext(context);
		Core = new CoreContext(context);
		ICP = new ICPContext(context);
	}
	public final class SchedulingContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private SchedulingContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getBookingAppointmentRefIsNotNull()
		{
			return !cx_SchedulingBookingAppointmentRef.getValueIsNull(context);
		}
		public ims.scheduling.vo.Booking_AppointmentRefVo getBookingAppointmentRef()
		{
			return (ims.scheduling.vo.Booking_AppointmentRefVo)cx_SchedulingBookingAppointmentRef.getValue(context);
		}
		public void setBookingAppointmentRef(ims.scheduling.vo.Booking_AppointmentRefVo value)
		{
			cx_SchedulingBookingAppointmentRef.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingBookingAppointmentRef = new ims.framework.ContextVariable("Scheduling.BookingAppointmentRef", "_cv_Scheduling.BookingAppointmentRef");

		private ims.framework.Context context;
	}
	public final class CareUkContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CareUkContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getDayCaseAdmApptDateIsNotNull()
		{
			return !cx_CareUkDayCaseAdmApptDate.getValueIsNull(context);
		}
		public ims.framework.utils.Date getDayCaseAdmApptDate()
		{
			return (ims.framework.utils.Date)cx_CareUkDayCaseAdmApptDate.getValue(context);
		}
		public void setDayCaseAdmApptDate(ims.framework.utils.Date value)
		{
			cx_CareUkDayCaseAdmApptDate.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CareUkDayCaseAdmApptDate = new ims.framework.ContextVariable("CareUk.DayCaseAdmApptDate", "_cv_CareUk.DayCaseAdmApptDate");
		public boolean getDayCaseAdmApptTimeIsNotNull()
		{
			return !cx_CareUkDayCaseAdmApptTime.getValueIsNull(context);
		}
		public String getDayCaseAdmApptTime()
		{
			return (String)cx_CareUkDayCaseAdmApptTime.getValue(context);
		}
		public void setDayCaseAdmApptTime(String value)
		{
			cx_CareUkDayCaseAdmApptTime.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CareUkDayCaseAdmApptTime = new ims.framework.ContextVariable("CareUk.DayCaseAdmApptTime", "_cv_CareUk.DayCaseAdmApptTime");
		public boolean getDayCaseAdmClinicNameIsNotNull()
		{
			return !cx_CareUkDayCaseAdmClinicName.getValueIsNull(context);
		}
		public String getDayCaseAdmClinicName()
		{
			return (String)cx_CareUkDayCaseAdmClinicName.getValue(context);
		}
		public void setDayCaseAdmClinicName(String value)
		{
			cx_CareUkDayCaseAdmClinicName.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CareUkDayCaseAdmClinicName = new ims.framework.ContextVariable("CareUk.DayCaseAdmClinicName", "_cv_CareUk.DayCaseAdmClinicName");
		public boolean getCatsReferralIsNotNull()
		{
			return !cx_CareUkCatsReferral.getValueIsNull(context);
		}
		public ims.careuk.vo.CatsReferralRefVo getCatsReferral()
		{
			return (ims.careuk.vo.CatsReferralRefVo)cx_CareUkCatsReferral.getValue(context);
		}
		public void setCatsReferral(ims.careuk.vo.CatsReferralRefVo value)
		{
			cx_CareUkCatsReferral.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CareUkCatsReferral = new ims.framework.ContextVariable("CareUk.CatsReferral", "_cvp_CareUk.CatsReferral");
		public boolean getChosenTimeIsNotNull()
		{
			return !cx_CareUkChosenTime.getValueIsNull(context);
		}
		public ims.framework.utils.Time getChosenTime()
		{
			return (ims.framework.utils.Time)cx_CareUkChosenTime.getValue(context);
		}
		public void setChosenTime(ims.framework.utils.Time value)
		{
			cx_CareUkChosenTime.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CareUkChosenTime = new ims.framework.ContextVariable("CareUk.ChosenTime", "_cv_CareUk.ChosenTime");

		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getHospitalLocIsNotNull()
		{
			return !cx_CoreHospitalLoc.getValueIsNull(context);
		}
		public ims.core.vo.LocShortVo getHospitalLoc()
		{
			return (ims.core.vo.LocShortVo)cx_CoreHospitalLoc.getValue(context);
		}
		public void setHospitalLoc(ims.core.vo.LocShortVo value)
		{
			cx_CoreHospitalLoc.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreHospitalLoc = new ims.framework.ContextVariable("Core.HospitalLoc", "_cv_Core.HospitalLoc");
		public boolean getSelectingPatientFormIsNotNull()
		{
			return !cx_CoreSelectingPatientForm.getValueIsNull(context);
		}
		public ims.framework.FormName getSelectingPatientForm()
		{
			return (ims.framework.FormName)cx_CoreSelectingPatientForm.getValue(context);
		}
		public void setSelectingPatientForm(ims.framework.FormName value)
		{
			cx_CoreSelectingPatientForm.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectingPatientForm = new ims.framework.ContextVariable("Core.SelectingPatientForm", "_cvp_Core.SelectingPatientForm");
		public boolean getSelectedLocationForOrderingIsNotNull()
		{
			return !cx_CoreSelectedLocationForOrdering.getValueIsNull(context);
		}
		public ims.core.vo.LocShortVo getSelectedLocationForOrdering()
		{
			return (ims.core.vo.LocShortVo)cx_CoreSelectedLocationForOrdering.getValue(context);
		}
		public void setSelectedLocationForOrdering(ims.core.vo.LocShortVo value)
		{
			cx_CoreSelectedLocationForOrdering.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectedLocationForOrdering = new ims.framework.ContextVariable("Core.SelectedLocationForOrdering", "_cv_Core.SelectedLocationForOrdering");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}
		public void setCurrentCareContext(ims.core.vo.CareContextShortVo value)
		{
			cx_CoreCurrentCareContext.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");

		private ims.framework.Context context;
	}
	public final class ICPContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ICPContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientICPRecordIsNotNull()
		{
			return !cx_ICPPatientICPRecord.getValueIsNull(context);
		}
		public ims.icps.instantiation.vo.PatientICPRefVo getPatientICPRecord()
		{
			return (ims.icps.instantiation.vo.PatientICPRefVo)cx_ICPPatientICPRecord.getValue(context);
		}
		public void setPatientICPRecord(ims.icps.instantiation.vo.PatientICPRefVo value)
		{
			cx_ICPPatientICPRecord.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ICPPatientICPRecord = new ims.framework.ContextVariable("ICP.PatientICPRecord", "_cv_ICP.PatientICPRecord");

		private ims.framework.Context context;
	}
	public boolean getUKSHOutPatientWardViewSearchCriteriaIsNotNull()
	{
		return !cx_UKSHOutPatientWardViewSearchCriteria.getValueIsNull(context);
	}
	public ims.core.vo.IPandOPSearchCriteriaVo getUKSHOutPatientWardViewSearchCriteria()
	{
		return (ims.core.vo.IPandOPSearchCriteriaVo)cx_UKSHOutPatientWardViewSearchCriteria.getValue(context);
	}
		public void setUKSHOutPatientWardViewSearchCriteria(ims.core.vo.IPandOPSearchCriteriaVo value)
		{
		cx_UKSHOutPatientWardViewSearchCriteria.setValue(context, value);
		}

	private ims.framework.ContextVariable cx_UKSHOutPatientWardViewSearchCriteria = new ims.framework.ContextVariable("UKSHOutPatientWardViewSearchCriteria", "_cvp_UKSHOutPatientWardViewSearchCriteria");

	public SchedulingContext Scheduling;
	public CareUkContext CareUk;
	public CoreContext Core;
	public ICPContext ICP;
}
