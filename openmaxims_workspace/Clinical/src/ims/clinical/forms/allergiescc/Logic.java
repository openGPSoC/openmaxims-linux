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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.allergiescc;

import ims.clinical.forms.allergiescc.GenForm.grdAllergiesRow;
import ims.configuration.gen.ConfigFlag;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.vo.AuthoringInfoForTriageVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.PatientAllergyForTriageVo;
import ims.core.vo.PatientAllergyForTriageVoCollection;
import ims.core.vo.PatientNoAllergyInfoForTriageVo;
import ims.core.vo.RecordingUserInformationForTriageVo;
import ims.core.vo.lookups.PatientAllergyStatus;
import ims.core.vo.lookups.SourceofInformation;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.emergency.vo.enums.EdAssessment_CustomControlsEvents;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		refresh();
		
		//WDEV-17337
		form.getLocalContext().setSelectedEvent(EdAssessment_CustomControlsEvents.CANCEL);
		form.fireCustomControlValueChanged();
		
	}
	
	@Override
	protected void onChkNoAllergiesValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if(saveNoAllergy())
			refresh();
		
		//WDEV-17337
		form.getLocalContext().setSelectedEvent(EdAssessment_CustomControlsEvents.SAVE);
		form.fireCustomControlValueChanged();
	}
	
	private boolean saveNoAllergy() 
	{
		PatientNoAllergyInfoForTriageVo patientNoAllergy = populatePatientNoAllergyInfo();
		
		String[] errros = patientNoAllergy.validate();
		
		if(errros != null && errros.length > 0)
		{
			engine.showErrors(errros);
			return false;
		}
		
		try 
		{
			domain.savePatientNoAllergyInfo(patientNoAllergy);
		} 
		catch (StaleObjectException e) 
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			refresh();
			return false;
		} 
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage(e.getMessage());
			refresh();
			return false;
		}
		
		return true;
	}

	private PatientNoAllergyInfoForTriageVo populatePatientNoAllergyInfo() 
	{
		PatientNoAllergyInfoForTriageVo noAllergy = form.getLocalContext().getNoAllergy();
		
		if(noAllergy == null)
			noAllergy = new PatientNoAllergyInfoForTriageVo();
		
		noAllergy.setPatient(form.getGlobalContext().Core.getPatientShort());
		noAllergy.setSourceofInformation(SourceofInformation.CLINICALCONTACT);
		
		AuthoringInfoForTriageVo authoringInfo = new AuthoringInfoForTriageVo();
		
		Object user = domain.getHcpLiteUser();
		
		if(user instanceof HcpRefVo)
		{
			authoringInfo.setAuthoringHcp((HcpRefVo) user);
			authoringInfo.setAuthoringDateTime(new DateTime());
		}
		
		noAllergy.setAuthoringInformation(authoringInfo);
		
		if(!noAllergy.getRecordingInformationIsNotNull())
		{
			RecordingUserInformationForTriageVo recordingInformation = new RecordingUserInformationForTriageVo();
			
			if(user instanceof HcpLiteVo)
			{
				recordingInformation.setRecordingUser(((HcpLiteVo)user).getMos());
				recordingInformation.setRecordingDateTime(new DateTime());
			}
			
			noAllergy.setRecordingInformation(recordingInformation);
		}
		
		noAllergy.setAllergyStatus(PatientAllergyStatus.NOKNOWNALLERGIES);
		
		return noAllergy;
	}

	@Override
	protected void onGrdAllergiesSelectionChanged()
	{
		form.getLocalContext().setselectedAllergy(form.grdAllergies().getValue());//WDEV-16176
		updateControlsState();
	}
	
	public void refresh()
	{
		if(form.getGlobalContext().Core.getPatientShort() == null)
			return;
		
		form.getLocalContext().setNoAllergy(domain.getPatientNoAllergyInfo(form.getGlobalContext().Core.getPatientShort()));
		form.chkNoAllergies().setValue(form.getLocalContext().getNoAllergyIsNotNull() && PatientAllergyStatus.NOKNOWNALLERGIES.equals((form.getLocalContext().getNoAllergy().getAllergyStatus())));
		
		populateAllergiesGrid(domain.listAllergies(form.getGlobalContext().Core.getPatientShort()));
		
		updateControlsState();
	}
	
	private void populateAllergiesGrid(PatientAllergyForTriageVoCollection listAllergies) 
	{
		form.grdAllergies().getRows().clear();
		
		if(listAllergies == null)
			return;
		
		for(PatientAllergyForTriageVo allergy : listAllergies)
		{
			addAllergyRow(allergy);
		}
		
		form.grdAllergies().setValue(form.getLocalContext().getselectedAllergy());//WDEV-16176
	}

	private void addAllergyRow(PatientAllergyForTriageVo allergy) 
	{
		if(allergy == null)
			return;
		
		grdAllergiesRow row = form.grdAllergies().getRows().newRow();
		row.setColAllergy(allergy.getAllergenDescription());
		row.setTextColor(ConfigFlag.UI.ALLERGIES_COMPONENT_TEXT_COLOUR.getValue());		//wdev-16133
		row.setTooltipForColAllergy(allergy.getAllergenDescription());//WDEV-15092
		row.setValue(allergy);
	}

	public void setEnabled(Boolean value) 
	{
		form.getLocalContext().setIsEnabled(value);
		
		updateControlsState();
	}

	private void updateControlsState() 
	{
		form.imbNew().setEnabled(Boolean.TRUE.equals(form.getLocalContext().getIsEnabled()));
		form.imbEdit().setEnabled(Boolean.TRUE.equals(form.getLocalContext().getIsEnabled()) && form.grdAllergies().getValue() != null);
		//WDEV-17686
		form.chkNoAllergies().setEnabled((Boolean.TRUE.equals(form.getLocalContext().getIsEnabled()) || (!Boolean.TRUE.equals(form.getLocalContext().getIsHidden()) && FormMode.VIEW.equals(form.getMode()))) && form.grdAllergies().getRows().size() == 0 && !form.chkNoAllergies().getValue());//WDEV-17605
		
		form.getContextMenus().Clinical.getAllergiesCcMenuADDItem().setVisible(Boolean.TRUE.equals(form.getLocalContext().getIsEnabled()) || (!Boolean.TRUE.equals(form.getLocalContext().getIsHidden()) && FormMode.VIEW.equals(form.getMode())));//WDEV-17605
		form.getContextMenus().Clinical.getAllergiesCcMenuEDITItem().setVisible((Boolean.TRUE.equals(form.getLocalContext().getIsEnabled()) || (!Boolean.TRUE.equals(form.getLocalContext().getIsHidden()) && FormMode.VIEW.equals(form.getMode()))) && form.grdAllergies().getValue() != null);//WDEV-17605
		
		//WDEV-17605
		form.imbNew().setVisible(!Boolean.TRUE.equals(form.getLocalContext().getIsHidden()));
		form.imbEdit().setVisible(!Boolean.TRUE.equals(form.getLocalContext().getIsHidden()));
	}

	@Override
	protected void onImbEditClick() throws PresentationLogicException 
	{
		if(form.grdAllergies().getValue() == null)
			return;
		
		engine.open(form.getForms().Clinical.AllergiesForTriage, new Object[] {form.grdAllergies().getValue().getID_PatientAllergy()});
	}

	@Override
	protected void onImbNewClick() throws PresentationLogicException 
	{
		form.getLocalContext().setselectedAllergy(null);//WDEV-16176
		engine.open(form.getForms().Clinical.AllergiesForTriage);
	}

	public void clear() 
	{
		form.getLocalContext().setNoAllergy(null);
		form.grdAllergies().getRows().clear();
		
		updateControlsState();
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.ClinicalNamespace.AllergiesCcMenu.ADD:
				form.getLocalContext().setselectedAllergy(null);//WDEV-16176
				engine.open(form.getForms().Clinical.AllergiesForTriage);
			break;
			
			case GenForm.ContextMenus.ClinicalNamespace.AllergiesCcMenu.EDIT:
				if(form.grdAllergies().getValue() == null)
					return;
				
				engine.open(form.getForms().Clinical.AllergiesForTriage, new Object[] {form.grdAllergies().getValue().getID_PatientAllergy()});
			break;
		}
		
		updateControlsState();
	}
	
	//WDEV-17337
	public EdAssessment_CustomControlsEvents getSelectedEvent()
	{
		return form.getLocalContext().getSelectedEvent();
	}
	
	//WDEV-17337
	public void resetSelectedEvent()
	{
		form.getLocalContext().setSelectedEvent(null);
	}

	//WDEV-17605
	public void hideButtons(Boolean value)
	{
		form.getLocalContext().setIsHidden(value);
		
		updateControlsState();
	}
}
