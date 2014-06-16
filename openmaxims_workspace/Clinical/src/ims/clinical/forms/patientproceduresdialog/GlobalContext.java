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

package ims.clinical.forms.patientproceduresdialog;

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
		public void setCurrentCareContext(ims.core.vo.CareContextShortVo value)
		{
			cx_CoreCurrentCareContext.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getEpisodeofCareShortIsNotNull()
		{
			return !cx_CoreEpisodeofCareShort.getValueIsNull(context);
		}
		public ims.core.vo.EpisodeofCareShortVo getEpisodeofCareShort()
		{
			return (ims.core.vo.EpisodeofCareShortVo)cx_CoreEpisodeofCareShort.getValue(context);
		}
		public void setEpisodeofCareShort(ims.core.vo.EpisodeofCareShortVo value)
		{
			cx_CoreEpisodeofCareShort.setValue(context, value);
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

		public boolean getSelectedPatientProcedureFromSurgicalAuditIsNotNull()
		{
			return !cx_ClinicalSelectedPatientProcedureFromSurgicalAudit.getValueIsNull(context);
		}
		public ims.clinical.vo.PatientProcedureForSurgicalAuditPreOpChecksVo getSelectedPatientProcedureFromSurgicalAudit()
		{
			return (ims.clinical.vo.PatientProcedureForSurgicalAuditPreOpChecksVo)cx_ClinicalSelectedPatientProcedureFromSurgicalAudit.getValue(context);
		}
		public void setSelectedPatientProcedureFromSurgicalAudit(ims.clinical.vo.PatientProcedureForSurgicalAuditPreOpChecksVo value)
		{
			cx_ClinicalSelectedPatientProcedureFromSurgicalAudit.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalSelectedPatientProcedureFromSurgicalAudit = new ims.framework.ContextVariable("Clinical.SelectedPatientProcedureFromSurgicalAudit", "_cv_Clinical.SelectedPatientProcedureFromSurgicalAudit");
		public boolean getPatientProcedureMarkedAsPrimaryIsNotNull()
		{
			return !cx_ClinicalPatientProcedureMarkedAsPrimary.getValueIsNull(context);
		}
		public ims.clinical.vo.PatientProcedureForSurgicalAuditPreOpChecksVo getPatientProcedureMarkedAsPrimary()
		{
			return (ims.clinical.vo.PatientProcedureForSurgicalAuditPreOpChecksVo)cx_ClinicalPatientProcedureMarkedAsPrimary.getValue(context);
		}
		public void setPatientProcedureMarkedAsPrimary(ims.clinical.vo.PatientProcedureForSurgicalAuditPreOpChecksVo value)
		{
			cx_ClinicalPatientProcedureMarkedAsPrimary.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalPatientProcedureMarkedAsPrimary = new ims.framework.ContextVariable("Clinical.PatientProcedureMarkedAsPrimary", "_cv_Clinical.PatientProcedureMarkedAsPrimary");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public ClinicalContext Clinical;
}
