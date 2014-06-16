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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.65 build 3198.21681)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.systemlog;

import ims.admin.vo.SystemLogVoCollection;
import ims.framework.Control;
import ims.framework.enumerations.SystemLogType;
import ims.framework.enumerations.SystemLogLevel;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.ISystemLog;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.DateTimeFormat;
import ims.framework.utils.Image;
import ims.framework.utils.Time;

public class Logic extends BaseLogic
{ 
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
	}
	@Override
	protected void onBtnSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		search();
	}
	@Override
	protected void onBtnSearchByIdClick() throws PresentationLogicException 
	{
		searchById();
	}
	@Override
	protected void onGrdDetailsSelectionChanged() throws PresentationLogicException 
	{
		updateContextMenuState();
		displayDetails();		
	}
	@Override
	protected void onBtnClearClick() throws PresentationLogicException 
	{
		clearSearch();
	}
	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.AdminNamespace.SystemLog.TRACKSESSION:
				trackSession();
				break;
			case GenForm.ContextMenus.AdminNamespace.SystemLog.TRACKCURRENTSESSION:
				trackCurrentSession();
				break;
		}
	}	
	private void initialize()
	{		
		initializeDates();		
		initializeEventType();
		initializeLevel();
		form.ctnDetails().setCollapsed(true);
		updateContextMenuState();
	}
	private void clearSearch()
	{
		initializeDates();
		form.lyrSearch().tabSeach().txtUser().setValue(null);
		form.lyrSearch().tabSeach().txtComputer().setValue(null);
		form.lyrSearch().tabSeach().cmbLevel().setValue(null);
		form.lyrSearch().tabSeach().cmbType().setValue(null);
		form.lyrSearch().tabSearchById().intEventId().setValue(null);
		form.grdDetails().getRows().clear();
		form.ctnDetails().setCollapsed(true);
		clearDetails();
		updateContextMenuState();
	}
	private void initializeDates()
	{
		form.lyrSearch().tabSeach().dtimStart().setValue(new DateTime(new Date(), new Time()).addHours(-1));
		form.lyrSearch().tabSeach().dtimEnd().setValue(new DateTime(new Date(), new Time()));
	}
	private void initializeEventType()
	{
		form.lyrSearch().tabSeach().cmbType().clear();
		for(int x = 0; x < SystemLogType.ALL.length; x++)
		{
			form.lyrSearch().tabSeach().cmbType().newRow(SystemLogType.ALL[x], SystemLogType.ALL[x].getText(), form.getImages().Core.Organizer);
		}
	}
	private void initializeLevel()
	{	
		form.lyrSearch().tabSeach().cmbLevel().clear();
		for(int x = 0; x < SystemLogLevel.ALL.length; x++)
		{
			form.lyrSearch().tabSeach().cmbLevel().newRow(SystemLogLevel.ALL[x], SystemLogLevel.ALL[x].getText(), getLevelImage(SystemLogLevel.ALL[x]));
		}
	}
	private Image getLevelImage(SystemLogLevel systemLogLevel) 
	{
		if(systemLogLevel == null)
			return null;
		
		if(systemLogLevel.equals(SystemLogLevel.INFORMATION))
			return form.getImages().Admin.LogInformation;
		else if(systemLogLevel.equals(SystemLogLevel.WARNING))
			return form.getImages().Admin.LogWarning;
		else if(systemLogLevel.equals(SystemLogLevel.ERROR))
			return form.getImages().Admin.LogError;
		else if(systemLogLevel.equals(SystemLogLevel.FATALERROR))
			return form.getImages().Admin.LogFatalError;			
			
		return null;
	}
	private void search()
	{		
		if(!validateSeach())
			return;
		populate(domain.getEntries(form.lyrSearch().tabSeach().dtimStart().getValue(), form.lyrSearch().tabSeach().dtimEnd().getValue(), form.lyrSearch().tabSeach().txtUser().getValue(), form.lyrSearch().tabSeach().txtComputer().getValue(), form.lyrSearch().tabSeach().cmbType().getValue(), form.lyrSearch().tabSeach().cmbLevel().getValue()));
	}
	private void searchById()
	{	
		SystemLogVoCollection entries = new SystemLogVoCollection();		
		
		if(form.lyrSearch().tabSearchById().intEventId().getValue() != null)
		{
			entries.add(domain.getEntry(form.lyrSearch().tabSearchById().intEventId().getValue()));
		}
		
		populate(entries);
		
		if(form.grdDetails().getRows().size() > 0)
		{
			form.grdDetails().setValue(form.grdDetails().getRows().get(0).getValue());
			updateContextMenuState();
			displayDetails();
		}
	}
	private boolean validateSeach() 
	{
		if(form.lyrSearch().tabSeach().dtimStart().getValue() == null)
		{
			engine.showMessage("Invalid start date");
			return false;
		}
		if(form.lyrSearch().tabSeach().dtimEnd().getValue() == null)
		{
			engine.showMessage("Invalid end date");
			return false;
		}
		
		return true;
	}
	private void populate(SystemLogVoCollection entries) 
	{				
		form.grdDetails().getRows().clear();
		form.grdDetails().resetScrollPosition();
		form.ctnDetails().setCollapsed(true);
		clearDetails();
		
		if(entries == null)
			return;
		
		for(int x = 0; x < entries.size(); x++)
		{
			populate(entries.get(x));
		}
		
		updateContextMenuState();
	}
	private void populate(ISystemLog entry) 
	{
		if(entry == null)
			return;
		
		GenForm.grdDetailsRow row = form.grdDetails().getRows().newRow();
		
		row.setValue(entry);
		
		if(entry.getSystemLogEventLevel() == SystemLogLevel.INFORMATION)
			row.setcolImage(form.getImages().Admin.LogInformation);
		else if(entry.getSystemLogEventLevel() == SystemLogLevel.WARNING)
			row.setcolImage(form.getImages().Admin.LogWarning);
		else if(entry.getSystemLogEventLevel() == SystemLogLevel.ERROR)
			row.setcolImage(form.getImages().Admin.LogError);
		else if(entry.getSystemLogEventLevel() == SystemLogLevel.FATALERROR)
			row.setcolImage(form.getImages().Admin.LogFatalError);
		
		row.setcolDateTime(entry.getSystemLogEventDateTime().toString(true));
		row.setcolLevel(entry.getSystemLogEventLevel().toString());
		row.setcolType(entry.getSystemLogEventType().getText());		
		row.setcolUser(entry.getSystemLogEventUser());
		
		String message = entry.getSystemLogEventMessage();
		if(message.length() > 120)
			message = message.substring(0, 120) + "...";
		
		row.setcolMessage(message);				
	}
	private void clearDetails()
	{		
		form.ctnDetails().txtDetailsId().setValue(null);
		form.ctnDetails().txtDetailsDateTime().setValue(null);
		form.ctnDetails().txtDetailsUser().setValue(null);
		form.ctnDetails().txtDetailsComputer().setValue(null);
		form.ctnDetails().txtDetailsLevel().setValue(null);
		form.ctnDetails().txtDetailsSource().setValue(null);
		form.ctnDetails().txtDetailsEventType().setValue(null);
		form.ctnDetails().txtDetailsUserAgent().setValue(null);
		form.ctnDetails().txtDetailsMessage().setValue(null);		
		form.ctnDetails().txtDetailsServer().setValue(null);
		
		form.getLocalContext().setSelectedEntry(null);
	}
	private void displayDetails()
	{
		displayDetails(form.grdDetails().getValue());		
	}
	private void displayDetails(ISystemLog entry) 
	{
		clearDetails();
		
		if(entry == null)
			return;
		
		form.getLocalContext().setSelectedEntry(entry);
		
		form.ctnDetails().txtDetailsId().setValue(String.valueOf(entry.getSystemLogEventId()));
		form.ctnDetails().txtDetailsDateTime().setValue(entry.getSystemLogEventDateTime().toString(DateTimeFormat.STANDARD_SECS));
		form.ctnDetails().txtDetailsUser().setValue(entry.getSystemLogEventUser());
		form.ctnDetails().txtDetailsComputer().setValue(entry.getSystemLogEventComputer());
		form.ctnDetails().txtDetailsLevel().setValue(entry.getSystemLogEventLevel().toString());
		form.ctnDetails().txtDetailsSource().setValue(entry.getSystemLogEventSource());
		form.ctnDetails().txtDetailsEventType().setValue(entry.getSystemLogEventType().toString());
		form.ctnDetails().txtDetailsUserAgent().setValue(entry.getSystemLogEventUserAgent());
		form.ctnDetails().txtDetailsMessage().setValue(entry.getSystemLogEventMessage());
		form.ctnDetails().txtDetailsServer().setValue(entry.getSystemLogEventApplicationServer());
		
		form.ctnDetails().setCollapsed(false);
	}
	private void trackSession()
	{		
		if(form.grdDetails().getValue() != null && form.grdDetails().getValue().getSystemLogEventSessionId() != null)
		{
			populate(domain.getEntries(form.grdDetails().getValue().getSystemLogEventSessionId()));
		}
	}
	private void trackCurrentSession()
	{		
		populate(domain.getEntries(engine.getSessionId()));
	}
	private void updateContextMenuState()
	{
		boolean visible = form.grdDetails().getValue() != null && form.grdDetails().getValue().getSystemLogEventSessionId() != null && form.grdDetails().getValue().getSystemLogEventSessionId().trim().length() > 0;
		form.getContextMenus().Admin.getSystemLogTRACKSESSIONItem().setVisible(visible);
		form.getContextMenus().Admin.getSystemLogTRACKCURRENTSESSIONItem().setVisible(true);
	}	
}
