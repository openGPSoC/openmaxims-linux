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

package ims.clinical.forms.patientassessmentlistandsearch;

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

			PatientAssessment = new PatientAssessmentContext(context);
		}
		public final class PatientAssessmentContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private PatientAssessmentContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getSelectedAssessmentIsNotNull()
			{
				return !cx_ClinicalPatientAssessmentSelectedAssessment.getValueIsNull(context);
			}
			public ims.assessment.instantiation.vo.PatientAssessmentRefVo getSelectedAssessment()
			{
				return (ims.assessment.instantiation.vo.PatientAssessmentRefVo)cx_ClinicalPatientAssessmentSelectedAssessment.getValue(context);
			}
		public void setSelectedAssessment(ims.assessment.instantiation.vo.PatientAssessmentRefVo value)
		{
				cx_ClinicalPatientAssessmentSelectedAssessment.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_ClinicalPatientAssessmentSelectedAssessment = new ims.framework.ContextVariable("Clinical.PatientAssessment.SelectedAssessment", "_cv_Clinical.PatientAssessment.SelectedAssessment");
			private ims.framework.Context context;
		}

		public boolean getReturnToFormNameIsNotNull()
		{
			return !cx_ClinicalReturnToFormName.getValueIsNull(context);
		}
		public ims.framework.FormName getReturnToFormName()
		{
			return (ims.framework.FormName)cx_ClinicalReturnToFormName.getValue(context);
		}
		public void setReturnToFormName(ims.framework.FormName value)
		{
			cx_ClinicalReturnToFormName.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalReturnToFormName = new ims.framework.ContextVariable("Clinical.ReturnToFormName", "_cv_Clinical.ReturnToFormName");
		public boolean getPatientAssessmentListAndSearchCriteriaVoIsNotNull()
		{
			return !cx_ClinicalPatientAssessmentListAndSearchCriteriaVo.getValueIsNull(context);
		}
		public ims.clinical.vo.PatientAssessmentListAndSearchCriteriaVo getPatientAssessmentListAndSearchCriteriaVo()
		{
			return (ims.clinical.vo.PatientAssessmentListAndSearchCriteriaVo)cx_ClinicalPatientAssessmentListAndSearchCriteriaVo.getValue(context);
		}
		public void setPatientAssessmentListAndSearchCriteriaVo(ims.clinical.vo.PatientAssessmentListAndSearchCriteriaVo value)
		{
			cx_ClinicalPatientAssessmentListAndSearchCriteriaVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalPatientAssessmentListAndSearchCriteriaVo = new ims.framework.ContextVariable("Clinical.PatientAssessmentListAndSearchCriteriaVo", "_cvp_Clinical.PatientAssessmentListAndSearchCriteriaVo");

		public PatientAssessmentContext PatientAssessment;
		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

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
		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}
		public void setCurrentClinicalContact(ims.core.vo.ClinicalContactShortVo value)
		{
			cx_CoreCurrentClinicalContact.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
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

	public ClinicalContext Clinical;
	public CoreContext Core;
}
