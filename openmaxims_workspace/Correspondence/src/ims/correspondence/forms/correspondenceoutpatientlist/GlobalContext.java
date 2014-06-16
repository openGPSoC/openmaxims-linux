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

package ims.correspondence.forms.correspondenceoutpatientlist;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		Correspondence = new CorrespondenceContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPasEventIsNotNull()
		{
			return !cx_CorePasEvent.getValueIsNull(context);
		}
		public ims.core.admin.pas.vo.PASEventRefVo getPasEvent()
		{
			return (ims.core.admin.pas.vo.PASEventRefVo)cx_CorePasEvent.getValue(context);
		}
		public void setPasEvent(ims.core.admin.pas.vo.PASEventRefVo value)
		{
			cx_CorePasEvent.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePasEvent = new ims.framework.ContextVariable("Core.PasEvent", "_cvp_Core.PasEvent");
		public boolean getPatientToBeDisplayedIsNotNull()
		{
			return !cx_CorePatientToBeDisplayed.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientToBeDisplayed()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientToBeDisplayed.getValue(context);
		}
		public void setPatientToBeDisplayed(ims.core.vo.PatientShort value)
		{
			cx_CorePatientToBeDisplayed.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientToBeDisplayed = new ims.framework.ContextVariable("Core.PatientToBeDisplayed", "_cv_Core.PatientToBeDisplayed");
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
		public boolean getOutPatientSearchCriteriaIsNotNull()
		{
			return !cx_CoreOutPatientSearchCriteria.getValueIsNull(context);
		}
		public ims.core.vo.OutPatientListSearchCriteriaVo getOutPatientSearchCriteria()
		{
			return (ims.core.vo.OutPatientListSearchCriteriaVo)cx_CoreOutPatientSearchCriteria.getValue(context);
		}
		public void setOutPatientSearchCriteria(ims.core.vo.OutPatientListSearchCriteriaVo value)
		{
			cx_CoreOutPatientSearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreOutPatientSearchCriteria = new ims.framework.ContextVariable("Core.OutPatientSearchCriteria", "_cvp_Core.OutPatientSearchCriteria");

		private ims.framework.Context context;
	}
	public final class CorrespondenceContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CorrespondenceContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getCorrespondenceDetailsIsNotNull()
		{
			return !cx_CorrespondenceCorrespondenceDetails.getValueIsNull(context);
		}
		public ims.correspondence.vo.CorrespondenceDetailsRefVo getCorrespondenceDetails()
		{
			return (ims.correspondence.vo.CorrespondenceDetailsRefVo)cx_CorrespondenceCorrespondenceDetails.getValue(context);
		}
		public void setCorrespondenceDetails(ims.correspondence.vo.CorrespondenceDetailsRefVo value)
		{
			cx_CorrespondenceCorrespondenceDetails.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorrespondenceCorrespondenceDetails = new ims.framework.ContextVariable("Correspondence.CorrespondenceDetails", "_cvp_Correspondence.CorrespondenceDetails");
		public boolean getPatientListsBatchUpdateTypeIsNotNull()
		{
			return !cx_CorrespondencePatientListsBatchUpdateType.getValueIsNull(context);
		}
		public ims.core.vo.lookups.DocumentStatus getPatientListsBatchUpdateType()
		{
			return (ims.core.vo.lookups.DocumentStatus)cx_CorrespondencePatientListsBatchUpdateType.getValue(context);
		}
		public void setPatientListsBatchUpdateType(ims.core.vo.lookups.DocumentStatus value)
		{
			cx_CorrespondencePatientListsBatchUpdateType.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorrespondencePatientListsBatchUpdateType = new ims.framework.ContextVariable("Correspondence.PatientListsBatchUpdateType", "_cv_Correspondence.PatientListsBatchUpdateType");
		public boolean getcurrentCspStatusHistoryIsNotNull()
		{
			return !cx_CorrespondencecurrentCspStatusHistory.getValueIsNull(context);
		}
		public ims.correspondence.vo.CorrespondenceStatusHistoryVoCollection getcurrentCspStatusHistory()
		{
			return (ims.correspondence.vo.CorrespondenceStatusHistoryVoCollection)cx_CorrespondencecurrentCspStatusHistory.getValue(context);
		}
		public void setcurrentCspStatusHistory(ims.correspondence.vo.CorrespondenceStatusHistoryVoCollection value)
		{
			cx_CorrespondencecurrentCspStatusHistory.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorrespondencecurrentCspStatusHistory = new ims.framework.ContextVariable("Correspondence.currentCspStatusHistory", "_cv_Correspondence.currentCspStatusHistory");
		public boolean getPatientListSearchCriteriaIsNotNull()
		{
			return !cx_CorrespondencePatientListSearchCriteria.getValueIsNull(context);
		}
		public ims.core.vo.PatientListsFilterVo getPatientListSearchCriteria()
		{
			return (ims.core.vo.PatientListsFilterVo)cx_CorrespondencePatientListSearchCriteria.getValue(context);
		}
		public void setPatientListSearchCriteria(ims.core.vo.PatientListsFilterVo value)
		{
			cx_CorrespondencePatientListSearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorrespondencePatientListSearchCriteria = new ims.framework.ContextVariable("Correspondence.PatientListSearchCriteria", "_cvp_Correspondence.PatientListSearchCriteria");
		public boolean getGenerateFormModeIsNotNull()
		{
			return !cx_CorrespondenceGenerateFormMode.getValueIsNull(context);
		}
		public ims.framework.enumerations.FormMode getGenerateFormMode()
		{
			return (ims.framework.enumerations.FormMode)cx_CorrespondenceGenerateFormMode.getValue(context);
		}
		public void setGenerateFormMode(ims.framework.enumerations.FormMode value)
		{
			cx_CorrespondenceGenerateFormMode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorrespondenceGenerateFormMode = new ims.framework.ContextVariable("Correspondence.GenerateFormMode", "_cv_Correspondence.GenerateFormMode");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public CorrespondenceContext Correspondence;
}
