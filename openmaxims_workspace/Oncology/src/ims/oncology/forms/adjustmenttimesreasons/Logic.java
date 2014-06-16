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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.53 build 2643.26724)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.oncology.forms.adjustmenttimesreasons;

import java.util.ArrayList;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.EpisodeofCareShortVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.oncology.vo.WaitingTimesAdjustmentsAndReasonsVo;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static final String NEW	 = "New";
	private static final String EDIT = "Edit";
	
	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
		
		form.setMode(FormMode.VIEW);				

	}
	
	private void clear() 
	{
		form.cmbReason1().setValue(null);
		form.cmbReason2().setValue(null);
		form.cmbReason3().setValue(null);
		form.cmbRefTreatment().setValue(null);
		form.cmbDecisionToTreat().setValue(null);
		form.ibDecisionToTreat().setValue(null);
		form.ibDateReferral().setValue(null);
		form.ibFirstSeen().setValue(null);
		form.tbxNotesReferral().setValue(null);
		form.tbxNotesDecisionToTreat().setValue(null);

	}
	
	private void statusButtons(String action) 
	{
		if (form.getMode().equals(FormMode.VIEW))
		{
			if(action.equals(NEW))
			{
				form.bNew().setVisible(true);
				form.bUpdate().setVisible(false);	
			}
		
			if(action.equals(EDIT))
			{
				form.bNew().setVisible(false);
				form.bUpdate().setVisible(true);
			}
		}
	}

	private void open() 
	{
		form.setMode(FormMode.VIEW);				
		clear();
		WaitingTimesAdjustmentsAndReasonsVo voList = domain.getRecord(form.getGlobalContext().Core.getEpisodeofCareShort());
	
		if (voList != null)				
		{
			populateScreenFromData(voList);
			form.getLocalContext().seteditedRecord(voList);
			statusButtons(EDIT);
		}
		else
		{
			statusButtons(NEW);
		}
	}

	protected void populateScreenFromData(ims.oncology.vo.WaitingTimesAdjustmentsAndReasonsVo value)
	{
		clear();
		
		if(value == null)
			return;
				
		form.ibDateReferral().setValue(value.getAdjReferralFirstSeenIsNotNull() ? value.getAdjReferralFirstSeen() : null);
		form.cmbReason1().setValue(value.getReasReferralFirstSeenIsNotNull() ? value.getReasReferralFirstSeen() : null);		
		
		form.ibFirstSeen().setValue(value.getAdjFirstSeenDecTreatIsNotNull() ? value.getAdjFirstSeenDecTreat() : null);
		form.cmbReason2().setValue(value.getReasFirstSeenDecTreatIsNotNull() ?  value.getReasFirstSeenDecTreat() : null);
		
		form.ibDecisionToTreat().setValue(value.getAdjDecTreatTreatmentIsNotNull() ? value.getAdjDecTreatTreatment() : null);
		form.cmbReason3().setValue(value.getReasDecTreatTreatmentIsNotNull() ? value.getReasDecTreatTreatment() : null);
		
		form.cmbDecisionToTreat().setValue(value.getDelayReasDecTreatTreatIsNotNull() ? value.getDelayReasDecTreatTreat() : null);
		form.tbxNotesDecisionToTreat().setValue(value.getNotesDecTreatTreatIsNotNull() ? value.getNotesDecTreatTreat(): null);
				
		form.cmbRefTreatment().setValue(value.getDelayReasReferralTreatIsNotNull() ? value.getDelayReasReferralTreat() : null);
		form.tbxNotesReferral().setValue(value.getNotesReferralTreatIsNotNull() ? value.getNotesReferralTreat(): null);		
	}
	
	protected void onBNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}
	
	private void newInstance() 
	{
		form.getLocalContext().seteditedRecord(null);
		form.setMode(FormMode.EDIT);
		clear();
	}

	protected void onBUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
	
	protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}
	
	private boolean save()
	{
		WaitingTimesAdjustmentsAndReasonsVo record = populateDataFromScreen(); 
				
		String[] uiErrors = getUiErrors();	
		
		String[] errors = record.validate(uiErrors);
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		try
		{
			record = domain.saveRecord(record);
		}
		catch(StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			WaitingTimesAdjustmentsAndReasonsVo updatedRecord = getAndDisplayRecord(form.getGlobalContext().Core.getEpisodeofCareShort());
			updateRowRecord(updatedRecord);
			return false;
		} 
		catch (DomainInterfaceException e)
		{
			e.printStackTrace();
			return false;
		}
		
		form.getLocalContext().seteditedRecord(record);
		return true;
	}
	
	private void updateRowRecord(WaitingTimesAdjustmentsAndReasonsVo record) 
	{
		populateScreenFromData(record);	
	}
	
	private String[] getUiErrors() 
	{
		ArrayList<String> errors = new ArrayList<String>();
		
		if (form.ibDateReferral().getValue() == null && 
				form.cmbReason1().getValue() == null && 
					form.ibFirstSeen().getValue() == null && 
						form.cmbReason2().getValue() == null && 
							form.ibDecisionToTreat().getValue() == null && 
								form.cmbReason3().getValue() == null &&
									form.cmbRefTreatment().getValue() == null && 
										(form.tbxNotesReferral().getValue() == null ||
											form.tbxNotesReferral().getValue().trim().length() == 0) && 
												form.cmbDecisionToTreat().getValue() == null && 
													(form.tbxNotesDecisionToTreat().getValue() == null ||
														form.tbxNotesDecisionToTreat().getValue().trim().length() == 0))
														{
															errors.add("At least one field is mandatory!");
														}
		
		if (errors.size() > 0) 
		{
			String[] searchErrors = new String[errors.size()];
			errors.toArray(searchErrors);
			engine.showErrors("Invalid WaitingTimesAdjustmentsAndReasons record", searchErrors);
			return searchErrors;
		}
		
		return null;
	}

	private WaitingTimesAdjustmentsAndReasonsVo getAndDisplayRecord()
	{
		return getAndDisplayRecord(form.getGlobalContext().Core.getEpisodeofCareShort());
	}
	
	private WaitingTimesAdjustmentsAndReasonsVo getAndDisplayRecord(EpisodeofCareShortVo voEpisodeofCareShort) 
	{
		clear();
		
		if(voEpisodeofCareShort == null)
			return null;
		
		WaitingTimesAdjustmentsAndReasonsVo record = domain.getRecord(voEpisodeofCareShort);
		form.getLocalContext().seteditedRecord(record);
		
		populateScreenFromData(record);	
			
		return record;	
	}
	
	protected WaitingTimesAdjustmentsAndReasonsVo populateDataFromScreen()
	{
		return populateDataFromScreen(form.getLocalContext().geteditedRecord());
	}
	
	protected WaitingTimesAdjustmentsAndReasonsVo populateDataFromScreen(WaitingTimesAdjustmentsAndReasonsVo value)
	{
		if(value == null)
		{
			value = new WaitingTimesAdjustmentsAndReasonsVo();
		
			value.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			value.setEpisodeofCare(form.getGlobalContext().Core.getEpisodeofCareShort());
		}
		
		value.setAdjReferralFirstSeen(form.ibDateReferral().getValue());
		value.setReasReferralFirstSeen(form.cmbReason1().getValue());
		
		value.setAdjFirstSeenDecTreat(form.ibFirstSeen().getValue());
		value.setReasFirstSeenDecTreat(form.cmbReason2().getValue());
		
		value.setAdjDecTreatTreatment(form.ibDecisionToTreat().getValue());
		value.setReasDecTreatTreatment(form.cmbReason3().getValue());
		
		value.setDelayReasReferralTreat(form.cmbRefTreatment().getValue());
		value.setNotesReferralTreat(form.tbxNotesReferral().getValue());
		
		value.setDelayReasDecTreatTreat(form.cmbDecisionToTreat().getValue());
		value.setNotesDecTreatTreat(form.tbxNotesDecisionToTreat().getValue());
		
		return value;
	}

	protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		getAndDisplayRecord();
		statusButtons(form.getLocalContext().geteditedRecordIsNotNull() ? EDIT : NEW); 
	}
}
