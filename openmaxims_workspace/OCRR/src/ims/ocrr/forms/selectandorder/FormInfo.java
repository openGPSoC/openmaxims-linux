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

package ims.ocrr.forms.selectandorder;

public final class FormInfo extends ims.framework.FormInfo
{
	private static final long serialVersionUID = 1L;
	public FormInfo(Integer formId)
	{
		super(formId);
	}
	public String getNamespaceName()
	{
		return "OCRR";
	}
	public String getFormName()
	{
		return "SelectandOrder";
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
		return new String[] { "_cv_OCRR.MyOrderComponents", "_cv_OCRR.MyOrderInformations", "_cv_OCRR.MyOrderQuestions", "_cv_Core.HideCancelButton", "_cv_OCRR.SelectAndOrder.LaunchYesNoGenderDialog", "_cv_OCRR.SelectAndOrder.LaunchYesNoReOrderDialog", "_cv_Core.SecondYesNoDialogMessage", "_cv_Core.YesNoDialogLaunchedFromSelf", "_cv_Core.CareContextSelectDialog.ChosenCareContext", "_cv_OCRR.QuestionTooltips", "_cv_Core.YesNoDialogMessage", "_cv_OCRR.SelectAndOrder.LaunchMyOrderInfoDialog", "_cv_OCRR.OrderInvestigationToAmend", "_cv_Core.OutpatientAttendanceForOrder", "_cv_OCRR.ReasonForReOrder", "_cv_OCRR.GenderInvestigations", "_cv_Core.SelectedLocationForOrdering", "_cv_Rotherham.AppointmentToLink", "_cv_OCRR.YesNoDialogWithReasonMessage", "_cv_OCRR.RefusedInvestigation" };
	}
	public String getLocalVariablesPrefix()
	{
		return "_lv_OCRR.SelectandOrder.__internal_x_context__" + String.valueOf(getFormId());
	}
	public ims.framework.FormInfo[] getComponentsFormInfo()
	{
		ims.framework.FormInfo[] componentsInfo = new ims.framework.FormInfo[0];
		return componentsInfo;
	}
	public String getImagePath()
	{
		return "Images/OCRR/templates_preview_48.png";
	}
}
