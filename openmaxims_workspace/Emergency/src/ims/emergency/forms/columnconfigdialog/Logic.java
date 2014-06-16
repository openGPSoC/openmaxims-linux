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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.columnconfigdialog;

import ims.emergency.vo.ColumnDetailVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		initialise();
		onChkSelectValueChanged();
	}

	private void initialise()
	{
		if (form.getGlobalContext().Emergency.getAreaColumnIsNotNull())
		{
			ColumnDetailVo areaColum = form.getGlobalContext().Emergency.getAreaColumn();
			form.txtColumnHeader().setValue(areaColum.getColHeader());
			form.txtForColumn().setValue(areaColum.getColHeader());
			form.chkSelect().setValue(areaColum.getIsChecked());
			form.chkMaskInPublicArea().setValue(areaColum.getMaskInPublicArea());//WDEV-17966
			form.intColWidth().setValue(areaColum.getColWidth());
			if (areaColum.getColumn() != null && areaColum.getColumn().getImage() != null)
			{
				form.imgImage().setValue(areaColum.getColumn().getIItemImage());
			}
			else
			{
				form.imgImage().setVisible(false);
			}
		}
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (!validateUIRules())
			return;

		form.getGlobalContext().Emergency.setAreaColumn(getAreaValues());
		engine.close(DialogResult.OK);

	}

	private boolean validateUIRules()
	{
		ArrayList<String> listOfErrors = new ArrayList<String>();

		if (form.chkSelect().getValue() == true)
		{
			if (form.txtColumnHeader().getValue() == null)
			{
				listOfErrors.add("Column Header is mandatory.");
			}
			if (form.intColWidth().getValue() == null)
			{
				listOfErrors.add("Column width is mandatory.");
			}
			else if (form.intColWidth().getValue() <= 0)
			{
				listOfErrors.add("Column width must be a positive number.");
			}
		}

		int errorCount = listOfErrors.size();
		String[] result = new String[errorCount];

		for (int x = 0; x < errorCount; x++)
			result[x] = (String) listOfErrors.get(x);

		if (result != null && result.length > 0)
		{
			engine.showErrors(result);
			return false;
		}

		return true;
	}

	private ColumnDetailVo getAreaValues()
	{
		ColumnDetailVo columnDetail = form.getGlobalContext().Emergency.getAreaColumn();
		columnDetail.setColHeader(form.txtColumnHeader().getValue());
		columnDetail.setIsChecked(form.chkSelect().getValue());
		columnDetail.setColWidth(form.intColWidth().getValue());
		columnDetail.setMaskInPublicArea(form.chkMaskInPublicArea().getValue());//WDEV-17966
		
		return columnDetail;
	}

	@Override
	protected void onChkSelectValueChanged() throws PresentationLogicException
	{
		if (form.chkSelect().getValue() == true)
		{
			form.txtColumnHeader().setRequired(true);
			form.intColWidth().setRequired(true);
		}
		else
		{
			form.txtColumnHeader().setRequired(false);
			form.intColWidth().setRequired(false);
		}

	}

}
