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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.80 build 4198.17562)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.scheduling.forms.movesessiondialog;

import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.scheduling.vo.SessionShortVo;

import java.util.ArrayList;
import java.util.List;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		SessionShortVo voSession = null;
		if(args != null && args.length > 0)
		{
			if(args[0] instanceof SessionShortVo)
			{
				voSession = (SessionShortVo) args[0];
			}
		}
		
		form.getLocalContext().setSelectedSession(voSession);
		open();
	}

	/**
	 * @param voSession
	 */
	private void open()
	{
		form.dteSessionFrom().setValue(null);
		form.dteSessionTo().setValue(null);
		
		SessionShortVo voSession = form.getLocalContext().getSelectedSession();
		
		if(voSession != null)
			form.dteSessionFrom().setValue(voSession.getSessionDate());
		
		//WDEV-12918 - only show the cancel appt options if appts exist for session that we are moving
		boolean apptsExistForSession = domain.countNonCancelledAppointmentsForSession(voSession) > 0;
		form.lblAppts().setVisible(apptsExistForSession);
		form.lblreason().setVisible(apptsExistForSession);
		form.lblComment().setVisible(apptsExistForSession);
		form.cmbReason().setVisible(apptsExistForSession);
		form.txtComments().setVisible(apptsExistForSession);
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setSelectedSession( populateDataFromScreen(form.getLocalContext().getSelectedSession()));
		
		String[] arrErrors = getUIValidation();
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return;
		}
		
		try
		{
			domain.moveSessionToDate(form.getLocalContext().getSelectedSession(), form.dteSessionTo().getValue());
		}
		catch (StaleObjectException e)
		{
			form.getLocalContext().setSelectedSession(domain.getSession(form.getLocalContext().getSelectedSession()));
			open();
			return;
		}
		
		if(form.dteSessionTo().getValue().isGreaterThan(new Date()))
		{
			form.getGlobalContext().Scheduling.setAppointmentIds(getAppointmentIdsForSession(form.getLocalContext().getSelectedSession()));
			if(form.getGlobalContext().Scheduling.getAppointmentIdsIsNotNull())
				engine.open(form.getForms().Scheduling.PrintAppointment, "Reprint Letters");
			else
				engine.close(DialogResult.OK);
		}
		else
			engine.close(DialogResult.OK);
	}
	
	@Override
	protected SessionShortVo populateDataFromScreen(SessionShortVo value)
	{
		value = super.populateDataFromScreen(value);
		value.setWasSessionMoved(true);
		
		return value;
	}

	private ArrayList<Integer> getAppointmentIdsForSession(SessionShortVo selectedSession)
	{
		if (selectedSession == null)
			throw new CodingRuntimeException("selectedSession cannot be null in method getAppointmentIdsForSession");
		
		Integer[] arrIds = domain.getBookedAppointmentIdsForSession(selectedSession);
		ArrayList<Integer> ids = null;
		if(arrIds != null)
		{
			ids = new ArrayList<Integer>();
			for (Integer integer : arrIds)
			{
				ids.add(integer);
			}
		}

		return ids;
	}

	private String[] getUIValidation()
	{
		List<String> errors = new ArrayList<String>();
		
		if(form.dteSessionTo().getValue() == null)
			errors.add("'To' date is mandatory");
		else
		{
			if(form.dteSessionTo().getValue().isLessOrEqualThan(new Date()))
				errors.add("'To' date must be in the future");
			
			// WDEV-13220
			// A session must be moved on a different date than the one it's currently set 
			if (form.dteSessionTo().getValue().equals(form.dteSessionFrom().getValue()))
				errors.add("'To' date must be different than 'From' date");
		}
		
		return errors.size() > 0 ? errors.toArray(new String[0]) : null;	
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if(formName != null)
		{
			if(formName.equals(form.getForms().Scheduling.PrintAppointment))
			{
				form.getGlobalContext().Scheduling.setAppointmentIds(null);
				engine.close(DialogResult.OK);
			}
		}
	}
}
