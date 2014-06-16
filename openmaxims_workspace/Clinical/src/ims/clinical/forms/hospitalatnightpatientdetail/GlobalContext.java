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

package ims.clinical.forms.hospitalatnightpatientdetail;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Clinical = new ClinicalContext(context);
		Core = new CoreContext(context);
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getHospitalAtNightNotesIsNotNull()
		{
			return !cx_ClinicalHospitalAtNightNotes.getValueIsNull(context);
		}
		public ims.clinical.vo.HospitalAtNightNotesVo getHospitalAtNightNotes()
		{
			return (ims.clinical.vo.HospitalAtNightNotesVo)cx_ClinicalHospitalAtNightNotes.getValue(context);
		}
		public void setHospitalAtNightNotes(ims.clinical.vo.HospitalAtNightNotesVo value)
		{
			cx_ClinicalHospitalAtNightNotes.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalHospitalAtNightNotes = new ims.framework.ContextVariable("Clinical.HospitalAtNightNotes", "_cv_Clinical.HospitalAtNightNotes");
		public boolean getHospitalAtNightPatientDetailsIsNotNull()
		{
			return !cx_ClinicalHospitalAtNightPatientDetails.getValueIsNull(context);
		}
		public ims.clinical.vo.HospitalAtNightPatientDetailRefVo getHospitalAtNightPatientDetails()
		{
			return (ims.clinical.vo.HospitalAtNightPatientDetailRefVo)cx_ClinicalHospitalAtNightPatientDetails.getValue(context);
		}
		public void setHospitalAtNightPatientDetails(ims.clinical.vo.HospitalAtNightPatientDetailRefVo value)
		{
			cx_ClinicalHospitalAtNightPatientDetails.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalHospitalAtNightPatientDetails = new ims.framework.ContextVariable("Clinical.HospitalAtNightPatientDetails", "_cv_Clinical.HospitalAtNightPatientDetails");
		public boolean getClinicalTasksIsNotNull()
		{
			return !cx_ClinicalClinicalTasks.getValueIsNull(context);
		}
		public ims.clinical.vo.lookups.HospitalAtNightClinicalTaskCollection getClinicalTasks()
		{
			return (ims.clinical.vo.lookups.HospitalAtNightClinicalTaskCollection)cx_ClinicalClinicalTasks.getValue(context);
		}
		public void setClinicalTasks(ims.clinical.vo.lookups.HospitalAtNightClinicalTaskCollection value)
		{
			cx_ClinicalClinicalTasks.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalClinicalTasks = new ims.framework.ContextVariable("Clinical.ClinicalTasks", "_cv_Clinical.ClinicalTasks");
		public boolean getRemoveFromHospitalAtNightIsNotNull()
		{
			return !cx_ClinicalRemoveFromHospitalAtNight.getValueIsNull(context);
		}
		public Boolean getRemoveFromHospitalAtNight()
		{
			return (Boolean)cx_ClinicalRemoveFromHospitalAtNight.getValue(context);
		}
		public void setRemoveFromHospitalAtNight(Boolean value)
		{
			cx_ClinicalRemoveFromHospitalAtNight.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalRemoveFromHospitalAtNight = new ims.framework.ContextVariable("Clinical.RemoveFromHospitalAtNight", "_cv_Clinical.RemoveFromHospitalAtNight");

		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");

		private ims.framework.Context context;
	}

	public ClinicalContext Clinical;
	public CoreContext Core;
}
