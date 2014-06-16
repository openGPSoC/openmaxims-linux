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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.71 build 3625.26452)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.core.forms.inactivationcomment;

import ims.framework.enumerations.DialogResult;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}

	protected void onBtnYesClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Core.setInactivationComment(form.txtComment().getValue());
		
		engine.close(DialogResult.YES);
	}

	protected void onBtnNoClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.NO);
	}
	

	private void initialize()
	{
		form.getGlobalContext().Core.setInactivationComment(null);
	}

	private void open()
	{
		form.txtComment().setValue(form.getGlobalContext().Core.getInactivationComment());
	}
}
