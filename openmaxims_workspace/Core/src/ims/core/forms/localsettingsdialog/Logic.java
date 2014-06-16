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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.71 build 3931.23803)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.core.forms.localsettingsdialog;

import ims.framework.enumerations.DialogResult;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		String path = engine.getLocalSettings().getWordEditorPath();
		
		if(path != null && path.length() > 0)
			path = path.replace("\\\\", "\\");
					
		form.txtPath().setValue(path);
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	@Override
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		String path = validatePath(form.txtPath().getValue());
		
		if(path != null && path.length() > 0)
		{
			path = path.replace("\\", "\\\\");
			
			engine.getLocalSettings().setWordEditorPath(path);
			engine.close(DialogResult.OK);
		}
	}
	
	private String validatePath(String path) 
	{
		if(path == null || path.length() == 0)
			return null;
		
		int dotIndex = path.lastIndexOf('.');
		if(dotIndex == -1)
		{
			engine.showErrors(new String[] {"Editor path provided is not correct."});
			return null;
		}
		
		String fileExtension = path.substring(dotIndex + 1);
		
		if(fileExtension == null || fileExtension.length() == 0)
		{
			engine.showErrors(new String[] {"Editor path provided is not correct."});
			return null;
		}
		
		String fileExtensionLowerCase = fileExtension.toLowerCase();
		
		if(!fileExtensionLowerCase.equals("exe"))
		{
			engine.showErrors(new String[] {"Editor path provided is not correct."});
			return null;
		}
		
		String executableName = path.substring(0, dotIndex);
		
		if(executableName == null || executableName.length() == 0)
		{
			engine.showErrors(new String[] {"Editor path provided is not correct."});
			return null;
		}
		
		return path.substring(0, dotIndex) + "." + fileExtensionLowerCase;
	}
}
