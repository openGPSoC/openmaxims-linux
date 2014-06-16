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

package ims.clinical.forms.intraoperativecarerecord;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		Clinical = new ClinicalContext(context);
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

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getRieMessageIsNotNull()
		{
			return !cx_CoreRieMessage.getValueIsNull(context);
		}
		public String getRieMessage()
		{
			return (String)cx_CoreRieMessage.getValue(context);
		}
		public void setRieMessage(String value)
		{
			cx_CoreRieMessage.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreRieMessage = new ims.framework.ContextVariable("Core.RieMessage", "_cv_Core.RieMessage");
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
		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");
		public boolean getEpisodeofCareShortIsNotNull()
		{
			return !cx_CoreEpisodeofCareShort.getValueIsNull(context);
		}
		public ims.core.vo.EpisodeofCareShortVo getEpisodeofCareShort()
		{
			return (ims.core.vo.EpisodeofCareShortVo)cx_CoreEpisodeofCareShort.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreEpisodeofCareShort = new ims.framework.ContextVariable("Core.EpisodeofCareShort", "_cvp_Core.EpisodeofCareShort");

		private ims.framework.Context context;
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPackageAndConsumableItemsIsNotNull()
		{
			return !cx_ClinicalPackageAndConsumableItems.getValueIsNull(context);
		}
		public java.util.ArrayList<String> getPackageAndConsumableItems()
		{
			return (java.util.ArrayList<String>)cx_ClinicalPackageAndConsumableItems.getValue(context);
		}
		public void setPackageAndConsumableItems(java.util.ArrayList<String> value)
		{
			cx_ClinicalPackageAndConsumableItems.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalPackageAndConsumableItems = new ims.framework.ContextVariable("Clinical.PackageAndConsumableItems", "_cv_Clinical.PackageAndConsumableItems");
		public boolean getPatientProcedureForIntraOperativeDialogIsNotNull()
		{
			return !cx_ClinicalPatientProcedureForIntraOperativeDialog.getValueIsNull(context);
		}
		public ims.core.vo.PatientProcedureVo getPatientProcedureForIntraOperativeDialog()
		{
			return (ims.core.vo.PatientProcedureVo)cx_ClinicalPatientProcedureForIntraOperativeDialog.getValue(context);
		}
		public void setPatientProcedureForIntraOperativeDialog(ims.core.vo.PatientProcedureVo value)
		{
			cx_ClinicalPatientProcedureForIntraOperativeDialog.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalPatientProcedureForIntraOperativeDialog = new ims.framework.ContextVariable("Clinical.PatientProcedureForIntraOperativeDialog", "_cv_Clinical.PatientProcedureForIntraOperativeDialog");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public ClinicalContext Clinical;
}
