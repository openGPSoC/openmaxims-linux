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
// This code was generated by Peter Martin using IMS Development Environment (version 1.39 build 2173.22508)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.homevisitgeneral;

import java.util.ArrayList;
import java.util.List;

import ims.core.vo.ClinicalContactShortVo;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.spinalinjuries.vo.lookups.EnvironmentalHomeVisitComponentType;
import ims.therapies.vo.BathingFacilityVo;
import ims.therapies.vo.BathingFacilityVoCollection;
import ims.therapies.vo.HomeDetailsVo;
import ims.therapies.vo.HomeVisitVo;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		open();
	}

	private void open() 
	{
		clearInstanceControls();
		form.getLocalContext().setUpdatingInstance(new Boolean(false));
		
		populateScreen(domain.getHomeVisit(form.getGlobalContext().Therapies.getHomeVisit()));
		form.setMode(FormMode.VIEW);
		showButtonsForRecord();
	}

	private void showButtonsForRecord()
	{
		if(isRecordCurrent())
			setButtonsForRecord();
		else
			displayButtons(false, false);
	}

	private boolean isRecordCurrent()
	{
		ClinicalContactShortVo voCurrentClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		HomeVisitVo voHomeVisit = form.getLocalContext().getHomeVisitVo();
		
		if (voHomeVisit== null){
			engine.showMessage("Active Home Visit Access record is required to use this screen. ");
			return false;
		}
		
		if((voHomeVisit.getClinicalContactIsNotNull() && voCurrentClinicalContact != null && voCurrentClinicalContact.getID_ClinicalContactIsNotNull() 
		&& voCurrentClinicalContact.getID_ClinicalContact().equals(voHomeVisit.getClinicalContact().getID_ClinicalContact()))
		|| (voHomeVisit.getClinicalContact()== null && voCurrentClinicalContact == null))
		{
			return true;
		}
		return false;
	}

	private void setButtonsForRecord()
	{
		if(form.getLocalContext().getUpdatingInstance().booleanValue())
			displayButtons(false,true);
		else
			displayButtons(true, false);
	}
	private void displayButtons(boolean newVisible, boolean updateVisible)
	{
		if (form.getMode().equals(FormMode.VIEW))
		{
			form.New().setVisible(newVisible);
			form.Update().setVisible(updateVisible);
		}
	}

	private void populateScreen(HomeVisitVo voHomeVisit) 
	{
		if(voHomeVisit == null) return;
		
		form.customControlAuthoring().setValue(voHomeVisit.getAuthoringInformation());
				
		if(voHomeVisit.getHouseDetailsIsNotNull() && voHomeVisit.getHouseDetails().getAddressIsNotNull())
			form.txtAddress().setValue(voHomeVisit.getHouseDetails().getAddress());
		
		BathingFacilityVoCollection collBathingFacilityVo = voHomeVisit.getHomeAssessmentComponent();
		
		boolean generalDataFound = false;
		for(int i=0; i<collBathingFacilityVo.size(); i++)
		{
			BathingFacilityVo voVisitAssessmentComponent = collBathingFacilityVo.get(i);
			if(voVisitAssessmentComponent.getType().equals(EnvironmentalHomeVisitComponentType.BATHINGANDTOILETFACILITIES))
			{
				generalDataFound = true;
				form.txtBathingToilet().setValue(voVisitAssessmentComponent.getDetails());
				form.txtBathShortTerm().setValue(voVisitAssessmentComponent.getShortTermPlan());
				form.txtBathLongTerm().setValue(voVisitAssessmentComponent.getLongTermPlan());
				if(voVisitAssessmentComponent.getBathHeightIsNotNull() && voVisitAssessmentComponent.getBathHeight()>0)
					form.intBathHeight().setValue(voVisitAssessmentComponent.getBathHeight());
				else
					form.intBathHeight().setValue(null);
				if(voVisitAssessmentComponent.getBathWidthIsNotNull() && voVisitAssessmentComponent.getBathWidth()>0)
					form.intBathWidth().setValue(voVisitAssessmentComponent.getBathWidth());
				else
					form.intBathWidth().setValue(null);
			}
			else if(voVisitAssessmentComponent.getType().equals(EnvironmentalHomeVisitComponentType.HEATING))
			{
				generalDataFound = true;
				form.txtHeating().setValue(voVisitAssessmentComponent.getDetails());
				form.txtHeatingShortTerm().setValue(voVisitAssessmentComponent.getShortTermPlan());
				form.txtHeatingLongTerm().setValue(voVisitAssessmentComponent.getLongTermPlan());
			}
			else if(voVisitAssessmentComponent.getType().equals(EnvironmentalHomeVisitComponentType.STAIRCASE))
			{
				generalDataFound = true;
				form.txtStaircase().setValue(voVisitAssessmentComponent.getDetails());
				form.txtStairShortTerm().setValue(voVisitAssessmentComponent.getShortTermPlan());
				form.txtStairLongTerm().setValue(voVisitAssessmentComponent.getLongTermPlan());
			}
		}
		form.getLocalContext().setUpdatingInstance(new Boolean(generalDataFound));
		form.getLocalContext().setHomeVisitVo(voHomeVisit);
	}

	private void clearInstanceControls() 
	{
		form.customControlAuthoring().setValue(null);
		form.txtAddress().setValue(null);
		form.txtBathingToilet().setValue(null);
		form.txtBathShortTerm().setValue(null);
		form.txtBathLongTerm().setValue(null);
		form.txtHeating().setValue(null);
		form.txtHeatingShortTerm().setValue(null);
		form.txtHeatingLongTerm().setValue(null);
		form.txtStaircase().setValue(null);
		form.txtStairShortTerm().setValue(null);
		form.txtStairLongTerm().setValue(null);
	}

	protected void onNewClick() throws PresentationLogicException 
	{
		form.setMode(FormMode.EDIT);
	}
	protected void onUpdateClick() throws PresentationLogicException 
	{
		form.setMode(FormMode.EDIT);	
	}

	protected void onSaveClick() throws PresentationLogicException
	{
		HomeVisitVo voHomeVisitVo = form.getLocalContext().getHomeVisitVo();
		if (voHomeVisitVo == null)
			voHomeVisitVo = new HomeVisitVo();
		
		voHomeVisitVo = populateDataFromScreen(voHomeVisitVo);
		
		String[] messages = voHomeVisitVo.validate(validateUIRules());
		if (messages != null)
		{
			engine.showErrors("Validation Errors", messages);
			return;
		}
	
		//save and update local context
		try 
		{
			form.getLocalContext().setHomeVisitVo(domain.saveHomeVisitAccess(voHomeVisitVo));
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return;
		}
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage("A meeting with the same criteria already exists.   " + e.getMessage());
			open();
			return;
		}
		form.getGlobalContext().Therapies.setHomeVisit(form.getLocalContext().getHomeVisitVo());
		open(); 
	}

	public String[] validateUIRules()
	{
		List<String> uiErrors = new ArrayList<String>();
		
		if(form.intBathHeight() != null && form.intBathHeight().getValue() != null && form.intBathHeight().getValue() < 0)
		{
			uiErrors.add("Bath Height can't be a negative number");					
		}
		if(form.intBathWidth() != null && form.intBathWidth().getValue() != null && form.intBathWidth().getValue() < 0)
		{
			uiErrors.add("Bath Width can't be a negative number");					
		}
		
		String[] result = new String[uiErrors.size()];
		uiErrors.toArray(result);
		return result;
	}
	
	private HomeVisitVo populateDataFromScreen(HomeVisitVo voHomeVisitVo)
	{	
		HomeDetailsVo voHomeDetails = voHomeVisitVo.getHouseDetails();
		if(voHomeDetails == null)
			voHomeDetails = new HomeDetailsVo();
			
		voHomeDetails.setAddress(form.txtAddress().getValue());
		voHomeVisitVo.setHouseDetails(voHomeDetails);
		
		BathingFacilityVoCollection collBathingFacilityVo = voHomeVisitVo.getHomeAssessmentComponent();
		if(collBathingFacilityVo==null)
			collBathingFacilityVo = new BathingFacilityVoCollection();
		
		BathingFacilityVo voBathingComponent = null;
		voBathingComponent = getComponent(collBathingFacilityVo, EnvironmentalHomeVisitComponentType.BATHINGANDTOILETFACILITIES);
		
		if(voBathingComponent == null)
			voBathingComponent = new BathingFacilityVo();
		voBathingComponent.setType(EnvironmentalHomeVisitComponentType.BATHINGANDTOILETFACILITIES);
		voBathingComponent.setDetails(form.txtBathingToilet().getValue());
		voBathingComponent.setShortTermPlan(form.txtBathShortTerm().getValue());
		voBathingComponent.setLongTermPlan(form.txtBathLongTerm().getValue());
		voBathingComponent.setBathHeight(form.intBathHeight().getValue());
		voBathingComponent.setBathWidth(form.intBathWidth().getValue());
		if(voBathingComponent.getID_VisitAssessmentComponent()==null)
			collBathingFacilityVo.add(voBathingComponent);
		
		BathingFacilityVo voHeatingComponent = null;
		voHeatingComponent = getComponent(collBathingFacilityVo, EnvironmentalHomeVisitComponentType.HEATING);
		
		if(voHeatingComponent == null)
			voHeatingComponent = new BathingFacilityVo();
		voHeatingComponent.setType(EnvironmentalHomeVisitComponentType.HEATING);
		voHeatingComponent.setDetails(form.txtHeating().getValue());
		voHeatingComponent.setShortTermPlan(form.txtHeatingShortTerm().getValue());
		voHeatingComponent.setLongTermPlan(form.txtHeatingLongTerm().getValue());
		if(voHeatingComponent.getID_VisitAssessmentComponent()==null)
			collBathingFacilityVo.add(voHeatingComponent);
		
		BathingFacilityVo voStaircaseComponent = null;
		voStaircaseComponent = getComponent(collBathingFacilityVo, EnvironmentalHomeVisitComponentType.STAIRCASE);
		
		if(voStaircaseComponent == null)
			voStaircaseComponent = new BathingFacilityVo();
		voStaircaseComponent.setType(EnvironmentalHomeVisitComponentType.STAIRCASE);
		voStaircaseComponent.setDetails(form.txtStaircase().getValue());
		voStaircaseComponent.setShortTermPlan(form.txtStairShortTerm().getValue());
		voStaircaseComponent.setLongTermPlan(form.txtStairLongTerm().getValue());
		if(voStaircaseComponent.getID_VisitAssessmentComponent()==null)
			collBathingFacilityVo.add(voStaircaseComponent);
		
		voHomeVisitVo.setHomeAssessmentComponent(collBathingFacilityVo);
		
		return voHomeVisitVo;
	}

	private BathingFacilityVo getComponent(BathingFacilityVoCollection collComponents, EnvironmentalHomeVisitComponentType componentType)
	{
		for(int i=0; i<collComponents.size(); i++)
		{
			if(collComponents.get(i).getType().equals(componentType))
				return collComponents.get(i);
		}
		return null;
	}

	protected void onCancelClick() throws PresentationLogicException 
	{
		open();
	}


}
