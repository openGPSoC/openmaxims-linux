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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4828.20158)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.systemsreviewcc;

import ims.emergency.vo.SystemReviewVo;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		
	}

	public void initialise()
	{
		form.ccAuthoring().initializeComponent();
		form.ccAuthoring().setIsRequiredPropertyToControls(Boolean.TRUE);
	}

	public void setValue(SystemReviewVo systemReview)
	{
		form.getLocalContext().setSystemReview(systemReview);
	}

	public SystemReviewVo getValue()
	{
		if (form.getLocalContext().getSystemReview() == null)
			return null;
		
		form.getLocalContext().getSystemReview().setAuthoringInformation(form.ccAuthoring().getValue());
		form.getLocalContext().getSystemReview().setSystemReviewNote(form.richTextSystemReviewNotes().getText().equals("") ? null : form.richTextSystemReviewNotes().getValue()); //WDEV-17190
		
		return form.getLocalContext().getSystemReview();
	}
}
