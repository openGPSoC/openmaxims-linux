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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.specialinterestdialog;

import ims.emergency.vo.SpecialInterestDetailsVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(	form.dtimStartDate().getValue() == null)
		{
			engine.showErrors(new String[]{"Start Date is mandatory."});	
			return;
		}
		if( form.dtimStartDate().getValue() != null && form.dtimEndDate().getValue() != null)
		{

			if(	form.dtimStartDate().getValue().getDate().isGreaterThan(form.dtimEndDate().getValue().getDate()) || (form.dtimStartDate().getValue().getDate().isLessOrEqualThan(form.dtimEndDate().getValue().getDate()) && form.dtimStartDate().getValue().getTime().isGreaterThan(form.dtimEndDate().getValue().getTime())))
			{
				engine.showErrors(new String[]{"Start Date cannot be greater than End Date."});
				return;
			}
		}
		SpecialInterestDetailsVo tempVo = form.getGlobalContext().Emergency.getSpecialInterestDetails();
		tempVo.setCompletedDateTime(form.dtimEndDate().getValue());
		tempVo.setStartDateTime(form.dtimStartDate().getValue());
		tempVo.setSpecialInterestCategory(form.cmbSpecialInterestCategory().getValue());
		form.getGlobalContext().Emergency.setSpecialInterestDetails(tempVo);
		engine.close(DialogResult.OK);
			
	}

	
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{
		SpecialInterestDetailsVo tempVo = form.getGlobalContext().Emergency.getSpecialInterestDetails();
		
		Boolean addEditMode = form.getGlobalContext().Emergency.getADDEDITMode();
		if(	tempVo != null)
		{
			if(Boolean.TRUE.equals(addEditMode))			//Edit mode
			{
				form.dtimStartDate().setValue(tempVo.getStartDateTime());
				form.dtimEndDate().setValue(tempVo.getCompletedDateTime());
				form.cmbSpecialInterestCategory().setValue(tempVo.getSpecialInterestCategory());
			
			}
			else											//Add Mode	
			{
				form.dtimStartDate().setValue(new DateTime());
			}
			
		}
		else
		{
			form.dtimStartDate().setValue(new DateTime());
			tempVo = new SpecialInterestDetailsVo();
			form.getGlobalContext().Emergency.setSpecialInterestDetails(tempVo);
		}
		
		
		
	}
}
