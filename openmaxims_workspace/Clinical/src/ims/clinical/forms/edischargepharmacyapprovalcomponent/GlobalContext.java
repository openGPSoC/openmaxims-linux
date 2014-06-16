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

package ims.clinical.forms.edischargepharmacyapprovalcomponent;

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

		public boolean getEDischargeMedsIsNotNull()
		{
			return !cx_ClinicalEDischargeMeds.getValueIsNull(context);
		}
		public ims.clinical.vo.TTAMedicationDetailVo getEDischargeMeds()
		{
			return (ims.clinical.vo.TTAMedicationDetailVo)cx_ClinicalEDischargeMeds.getValue(context);
		}
		public void setEDischargeMeds(ims.clinical.vo.TTAMedicationDetailVo value)
		{
			cx_ClinicalEDischargeMeds.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalEDischargeMeds = new ims.framework.ContextVariable("Clinical.EDischargeMeds", "_cv_Clinical.EDischargeMeds");
		public boolean geteDischargePharmacyApprovalSuspendedReasonIsNotNull()
		{
			return !cx_ClinicaleDischargePharmacyApprovalSuspendedReason.getValueIsNull(context);
		}
		public String geteDischargePharmacyApprovalSuspendedReason()
		{
			return (String)cx_ClinicaleDischargePharmacyApprovalSuspendedReason.getValue(context);
		}
		public void seteDischargePharmacyApprovalSuspendedReason(String value)
		{
			cx_ClinicaleDischargePharmacyApprovalSuspendedReason.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicaleDischargePharmacyApprovalSuspendedReason = new ims.framework.ContextVariable("Clinical.eDischargePharmacyApprovalSuspendedReason", "_cv_Clinical.eDischargePharmacyApprovalSuspendedReason");
		public boolean geteDischargePharmacyApprovalRejectReasonIsNotNull()
		{
			return !cx_ClinicaleDischargePharmacyApprovalRejectReason.getValueIsNull(context);
		}
		public String geteDischargePharmacyApprovalRejectReason()
		{
			return (String)cx_ClinicaleDischargePharmacyApprovalRejectReason.getValue(context);
		}
		public void seteDischargePharmacyApprovalRejectReason(String value)
		{
			cx_ClinicaleDischargePharmacyApprovalRejectReason.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicaleDischargePharmacyApprovalRejectReason = new ims.framework.ContextVariable("Clinical.eDischargePharmacyApprovalRejectReason", "_cv_Clinical.eDischargePharmacyApprovalRejectReason");
		public boolean geteDischargePharmacyApprovalTTADockedPrintedIsNotNull()
		{
			return !cx_ClinicaleDischargePharmacyApprovalTTADockedPrinted.getValueIsNull(context);
		}
		public ims.clinical.vo.TTAStatusVo geteDischargePharmacyApprovalTTADockedPrinted()
		{
			return (ims.clinical.vo.TTAStatusVo)cx_ClinicaleDischargePharmacyApprovalTTADockedPrinted.getValue(context);
		}
		public void seteDischargePharmacyApprovalTTADockedPrinted(ims.clinical.vo.TTAStatusVo value)
		{
			cx_ClinicaleDischargePharmacyApprovalTTADockedPrinted.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicaleDischargePharmacyApprovalTTADockedPrinted = new ims.framework.ContextVariable("Clinical.eDischargePharmacyApprovalTTADockedPrinted", "_cv_Clinical.eDischargePharmacyApprovalTTADockedPrinted");
		public boolean geteDischargePharmacyApprovalTTADispenseIsNotNull()
		{
			return !cx_ClinicaleDischargePharmacyApprovalTTADispense.getValueIsNull(context);
		}
		public ims.clinical.vo.TTAStatusVo geteDischargePharmacyApprovalTTADispense()
		{
			return (ims.clinical.vo.TTAStatusVo)cx_ClinicaleDischargePharmacyApprovalTTADispense.getValue(context);
		}
		public void seteDischargePharmacyApprovalTTADispense(ims.clinical.vo.TTAStatusVo value)
		{
			cx_ClinicaleDischargePharmacyApprovalTTADispense.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicaleDischargePharmacyApprovalTTADispense = new ims.framework.ContextVariable("Clinical.eDischargePharmacyApprovalTTADispense", "_cv_Clinical.eDischargePharmacyApprovalTTADispense");
		public boolean geteDischargePharmacyApprovalTTAPharmacySystemDetailsIsNotNull()
		{
			return !cx_ClinicaleDischargePharmacyApprovalTTAPharmacySystemDetails.getValueIsNull(context);
		}
		public ims.clinical.vo.TTAStatusVo geteDischargePharmacyApprovalTTAPharmacySystemDetails()
		{
			return (ims.clinical.vo.TTAStatusVo)cx_ClinicaleDischargePharmacyApprovalTTAPharmacySystemDetails.getValue(context);
		}
		public void seteDischargePharmacyApprovalTTAPharmacySystemDetails(ims.clinical.vo.TTAStatusVo value)
		{
			cx_ClinicaleDischargePharmacyApprovalTTAPharmacySystemDetails.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicaleDischargePharmacyApprovalTTAPharmacySystemDetails = new ims.framework.ContextVariable("Clinical.eDischargePharmacyApprovalTTAPharmacySystemDetails", "_cv_Clinical.eDischargePharmacyApprovalTTAPharmacySystemDetails");

		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

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

		private ims.framework.Context context;
	}

	public ClinicalContext Clinical;
	public CoreContext Core;
}
