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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4471.18200)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.nursing.forms.enterevaluationdateforcareplandialog;

import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.nursing.vo.NextEvaluationDateTimeVo;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		String[] uiErrors = getUIErrors();
		if (uiErrors != null)
		{
			engine.showErrors(uiErrors);
			return;
		}

		NextEvaluationDateTimeVo newNextEvaluationDateTime = new NextEvaluationDateTimeVo();

		newNextEvaluationDateTime.setNextEvaluationDate(form.dteNextEvaluationDate().getValue());

		form.getGlobalContext().Nursing.setNewNextEvaluationDateEntered(newNextEvaluationDateTime);

		engine.close(DialogResult.OK);
	}

	private String[] getUIErrors()
	{
		ArrayList<String> errors = new ArrayList<String>();

		if (form.dteNextEvaluationDate().getValue() == null)
		{
			errors.add("Next Evaluation Date is mandatory!");
		}
		else
		{
			if (form.dteNextEvaluationDate().getValue().isLessThan(new Date()))
			{
				errors.add("The Next Evaluation Date cannot be in the past!");
			}
		}

		if(	ims.configuration.gen.ConfigFlag.DOM.CAREPLAN_NEXT_EVALUTION_DATE_VALIDATION.getValue() != 0 )
		{
			Date dateT = new Date();
			dateT.addDay(ims.configuration.gen.ConfigFlag.DOM.CAREPLAN_NEXT_EVALUTION_DATE_VALIDATION.getValue());
			if( form.dteNextEvaluationDate().getValue() != null && form.dteNextEvaluationDate().getValue().isGreaterThan(dateT))
			{
				errors.add("Next Evaluation Date exceeds " +ims.configuration.gen.ConfigFlag.DOM.CAREPLAN_NEXT_EVALUTION_DATE_VALIDATION.getValue()+" day policy!" ); //WDEV-15275
			}
		}

		if (errors.size() > 0)
		{
			String[] UIErrors = new String[errors.size()];
			errors.toArray(UIErrors);
			return UIErrors;
		}

		return null;
	}

	@Override
	protected void onBtnCancelClick() throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
}
