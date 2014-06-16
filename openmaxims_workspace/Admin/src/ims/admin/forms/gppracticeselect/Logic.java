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
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.21 build 41020.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.gppracticeselect;

import ims.admin.vo.enums.PracticeSearch;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
 
public class Logic extends BaseLogic
{
	
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{
		//wdev-10649
		form.getLocalContext().setEnableSelectButton(null);
		if ( args != null && args.length > 0 && args[0] instanceof Boolean )
			form.getLocalContext().setEnableSelectButton((Boolean)args[0]);
			
		//----------
		enableSelectButton(false);
		setVisibleUpdateButton(false);
		form.customControlPracticeSearch().setSearchButtonAsDefault();
		form.customControlPracticeSearch().setVisibleContextMenus(Boolean.TRUE);
		form.customControlPracticeSearch().setInvisibleSurgeryContextMenu();
	}

	protected void onBtnSelectClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Admin.setPractice(form.customControlPracticeSearch().getSelectedPractice()); 
		engine.close(DialogResult.OK);
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}

	private void newInstance()
	{
		form.getGlobalContext().Admin.setPractice(form.customControlPracticeSearch().getNewPracticeBasedOnSearchCriteria());
		engine.open(form.getForms().Admin.PracticeAdminDialog);
	}
	
	private void editInstance()
	{
		form.getGlobalContext().Admin.setPractice(form.customControlPracticeSearch().getSelectedPractice());
		engine.open(form.getForms().Admin.PracticeAdminDialog);
	}

	protected void onCustomControlPracticeSearchValueChanged() throws PresentationLogicException
	{
		PracticeSearch val = form.customControlPracticeSearch().getActionEvent();
		if(val != null)
		{
			if(val.equals( PracticeSearch.SELECT))
			{
				//wdev-10649
				if(form.getLocalContext().getEnableSelectButtonIsNotNull() && form.getLocalContext().getEnableSelectButton().equals(Boolean.FALSE))
					enableSelectButton(false);
				else 
					enableSelectButton(true);
				//-----------------
				
				setVisibleUpdateButton(true);
			}
			else if(val.equals( PracticeSearch.CLEAR))
			{
				enableSelectButton(false);
				setVisibleUpdateButton(false);
			}	
			else if(val.equals(PracticeSearch.NEWPRACTICE))
			{
				newInstance();
			}
			else if(val.equals(PracticeSearch.EDITPRACTICE))
			{
				editInstance();
			}
			else
			{
				enableSelectButton(false);
				setVisibleUpdateButton(false);
			}
		}
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		engine.close(result);
	}

	protected void onBtnUpdateClick() throws PresentationLogicException
	{
		editInstance();
	}
	
	private void enableSelectButton(boolean enable)
	{
		form.btnSelect().setEnabled(enable);
	}
	
	private void setVisibleUpdateButton(boolean visible)
	{
		form.btnUpdate().setVisible(visible);
	}

	
}
