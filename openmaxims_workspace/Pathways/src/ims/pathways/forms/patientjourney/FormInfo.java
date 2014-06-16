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

package ims.pathways.forms.patientjourney;

public final class FormInfo extends ims.framework.FormInfo
{
	private static final long serialVersionUID = 1L;
	public FormInfo(Integer formId)
	{
		super(formId);
	}
	public String getNamespaceName()
	{
		return "Pathways";
	}
	public String getFormName()
	{
		return "PatientJourney";
	}
	public int getWidth()
	{
		return 848;
	}
	public int getHeight()
	{
		return 632;
	}
	public String[] getContextVariables()
	{
		return new String[] { "_cv_Pathways.SelectedPatientPathwayJourney", "_cv_Pathways.SelectedPatientJourneyTargets", "_cv_Pathways.WorkListSearchCriteria", "_cv_Pathways.SelectedPathway", "_cv_Pathways.SelectedPatientJourneyTarget", "_cv_Pathways.PatientJourneySelected", "_cv_Pathways.TargetReadjustments", "_cv_Pathways.TargetReadjustmentsAction", "_cv_Pathways.PatientJourneyComments", "_cv_Core.GenericDate" };
	}
	public String getLocalVariablesPrefix()
	{
		return "_lv_Pathways.PatientJourney.__internal_x_context__" + String.valueOf(getFormId());
	}
	public ims.framework.FormInfo[] getComponentsFormInfo()
	{
		ims.framework.FormInfo[] componentsInfo = new ims.framework.FormInfo[1];
		componentsInfo[0] = new ims.core.forms.patientjourney.FormInfo(102244);
		return componentsInfo;
	}
	public String getImagePath()
	{
		return "Images/Pathways/patient_journey_48.png";
	}
}
