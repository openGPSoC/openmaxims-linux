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

package ims.clinical.forms.clinicalnotedrawing;

import java.io.Serializable;
import ims.framework.Context;
import ims.framework.FormName;
import ims.framework.FormAccessLogic;

public class BaseAccessLogic extends FormAccessLogic implements Serializable
{
	private static final long serialVersionUID = 1L;

	public final void setContext(Context context, FormName formName)
	{
		form = new CurrentForm(new GlobalContext(context), new CurrentForms());
		engine = new CurrentEngine(formName);
	}
	public boolean isAccessible()
	{
		if(!form.getGlobalContext().Core.getPatientShortIsNotNull())
			return false;
		if(!form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
			return false;
		if(!form.getGlobalContext().Core.getEpisodeofCareShortIsNotNull())
			return false;

		return true;
	}
	public boolean isReadOnly()
	{
		return false;
	}

	public CurrentEngine engine;
	public CurrentForm form;

	public final static class CurrentForm implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentForm(GlobalContext globalcontext, CurrentForms forms)
		{
			this.globalcontext = globalcontext;
			this.forms = forms;
		}
		public final GlobalContext getGlobalContext()
		{
			return globalcontext;
		}
		public final CurrentForms getForms()
		{
			return forms;
		}
		private GlobalContext globalcontext;
		private CurrentForms forms;
	}
	public final static class CurrentEngine implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentEngine(FormName formName)
		{
			this.formName = formName;
		}
		public final FormName getFormName()
		{
			return formName;
		}
		private FormName formName;
	}
	public static final class CurrentForms implements Serializable
	{
		private static final long serialVersionUID = 1L;

		protected final class LocalFormName extends FormName
		{
			private static final long serialVersionUID = 1L;
		
			protected LocalFormName(int value)
			{
				super(value);
			}
		}

		private CurrentForms()
		{
			Nursing = new NursingForms();
			COE = new COEForms();
			SpinalInjuries = new SpinalInjuriesForms();
			ProtoTemp = new ProtoTempForms();
			Clinical = new ClinicalForms();
			Assessment = new AssessmentForms();
			OCRR = new OCRRForms();
		}
		public final class NursingForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private NursingForms()
			{
				SkinReviewDialog = new LocalFormName(101143);
				SkinReview = new LocalFormName(101142);
			}
			public final FormName SkinReviewDialog;
			public final FormName SkinReview;
		}
		public final class COEForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private COEForms()
			{
				AssessSkin = new LocalFormName(101112);
			}
			public final FormName AssessSkin;
		}
		public final class SpinalInjuriesForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private SpinalInjuriesForms()
			{
				NurAssessmentSkin = new LocalFormName(105114);
			}
			public final FormName NurAssessmentSkin;
		}
		public final class ProtoTempForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private ProtoTempForms()
			{
				Diagnosis = new LocalFormName(122100);
				ProblemList = new LocalFormName(122105);
				Procedure = new LocalFormName(122101);
				ReferralServices = new LocalFormName(122110);
			}
			public final FormName Diagnosis;
			public final FormName ProblemList;
			public final FormName Procedure;
			public final FormName ReferralServices;
		}
		public final class ClinicalForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private ClinicalForms()
			{
				ClinicalNoteDrawing = new LocalFormName(102177);
				DiagnosisComplications = new LocalFormName(123117);
				PatientProblems = new LocalFormName(123120);
				Procedures = new LocalFormName(123119);
				MedicationOnAdmission = new LocalFormName(122126);
				OutPatientsTreatmentPlan = new LocalFormName(122120);
				DiagnosisComplications_Dialog = new LocalFormName(123130);
				Procedures_Dialog = new LocalFormName(123134);
				PatientProblems_Dialog = new LocalFormName(123129);
				MedicationOnAdmission_Dialog = new LocalFormName(122178);
				MedicationMultipleDoses_Dialog = new LocalFormName(122179);
			}
			public final FormName ClinicalNoteDrawing;
			public final FormName DiagnosisComplications;
			public final FormName PatientProblems;
			public final FormName Procedures;
			public final FormName MedicationOnAdmission;
			public final FormName OutPatientsTreatmentPlan;
			public final FormName DiagnosisComplications_Dialog;
			public final FormName Procedures_Dialog;
			public final FormName PatientProblems_Dialog;
			public final FormName MedicationOnAdmission_Dialog;
			public final FormName MedicationMultipleDoses_Dialog;
		}
		public final class AssessmentForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private AssessmentForms()
			{
				UserAssessmentInstantiationWithComponent = new LocalFormName(127108);
				UserDefinedFormSelect = new LocalFormName(102208);
				GraphicAssessmentInstantiation = new LocalFormName(102211);
			}
			public final FormName UserAssessmentInstantiationWithComponent;
			public final FormName UserDefinedFormSelect;
			public final FormName GraphicAssessmentInstantiation;
		}
		public final class OCRRForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private OCRRForms()
			{
				MyOrder = new LocalFormName(116111);
			}
			public final FormName MyOrder;
		}

		public NursingForms Nursing;
		public COEForms COE;
		public SpinalInjuriesForms SpinalInjuries;
		public ProtoTempForms ProtoTemp;
		public ClinicalForms Clinical;
		public AssessmentForms Assessment;
		public OCRRForms OCRR;
	}
}
