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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.18 build 40623.1500)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.clinicalnotes;

import ims.clinical.vo.lookups.ClinicalNoteClassification;
import ims.clinical.vo.lookups.ClinicalNoteClassificationCollection;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.ClinicalNoteStatusVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.lookups.ClinicalNoteType;
import ims.core.vo.lookups.HcpDisType;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.lookups.LookupService;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.nursing.forms.clinicalnotes.GenForm.gridCarePlanRow;
import ims.nursing.vo.CarePlan;
import ims.nursing.vo.CarePlanTitle;
import ims.nursing.vo.CarePlanTitleCollection;
import ims.nursing.vo.NursingClinicalNotesVo;
import ims.vo.LookupInstVo;
import ims.vo.LookupMappingVo;
import ims.vo.LookupMappingVoCollection;

public class Logic extends BaseLogic
{

	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		// List Careplans for the root clinical contact
		form.getLocalContext().setCarePlans(domain.listCarePlans(form.getGlobalContext().Core.getCurrentCareContext()));
		loadCarePlans();
		
		form.btnUpdateActions().setVisible(ConfigFlag.GEN.CARE_PLAN_FUNCTIONALITY_TYPE.getValue().toString().equals("CCO"));
		form.btnUpdateActions().setEnabled(areCarePlansSelected());

		form.labelFlag().setVisible( ! ConfigFlag.GEN.CARE_PLAN_FUNCTIONALITY_TYPE.getValue().toString().equals("CCO"));//wdev-13781
		form.chkHospitalReport().setVisible( ! ConfigFlag.GEN.CARE_PLAN_FUNCTIONALITY_TYPE.getValue().toString().equals("CCO"));//wdev-13781
		
		
		if (form.getGlobalContext().COE.getClinicalNotesVo() != null)
		{
			NursingClinicalNotesVo notes = domain.getClinicalNotes(form.getGlobalContext().COE.getClinicalNotesVo());
			if (notes != null)
			{
				if (notes.getIsCorrectedIsNotNull())
					form.checkBoxCorrection().setValue(notes.getIsCorrected());
				
				form.chkHospitalReport().setValue(notes.getInHospitalReport().booleanValue());
				
				if (notes.getAuthoringInfoIsNotNull())
				{
					if (notes.getAuthoringInfo().getAuthoringDateTimeIsNotNull())
					{
						form.dateNote().setValue(notes.getAuthoringInfo().getAuthoringDateTime().getDate());
						form.timeNote().setValue(notes.getAuthoringInfo().getAuthoringDateTime().getTime());
					}
					
					if (notes.getAuthoringInfo().getAuthoringHcpIsNotNull())
					{
						form.textBoxHCP().setValue(notes.getAuthoringInfo().getAuthoringHcp().toString());
						form.getLocalContext().setCurrentHcp(notes.getAuthoringInfo().getAuthoringHcp());
					}
				}
				
				form.textBoxClinicalNotes().setValue(notes.getClinicalNote());
				ClinicalNoteStatusVo  voClinicalNoteStatus = notes.getCurrentStatus();
				if(voClinicalNoteStatus!=null &&  voClinicalNoteStatus.getCorrectionReason() != null && voClinicalNoteStatus.getCorrectionConfirmed()!= null)
				{
					form.textBoxCorrectionReason().setValue(voClinicalNoteStatus.getCorrectionReason());
					form.checkBoxCorrection().setValue(voClinicalNoteStatus.getCorrectionConfirmed());
				}
				
				form.getLocalContext().setClinicalNote(notes);
				populateCarePlans();
				setButtonsViewMode();
			}
			else
				setButtonsViewMode(); //WDEV-15066
		}
		else{
			//WDEV-11531
			newClinicalNote();
			setButtonsNewMode();
		}
		
		
	}

	protected void onBNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newClinicalNote();

		loadCarePlans();

		setButtonsNewMode();

	}
	

	private void newClinicalNote() {
		form.setMode(FormMode.EDIT);

		form.getLocalContext().setClinicalNote(null);
		form.checkBoxCorrection().setValue(false);
		form.chkHospitalReport().setValue(false);
		form.dateNote().setValue(new ims.framework.utils.Date());
		form.textBoxClinicalNotes().setValue(null);
		form.textBoxCorrectionReason().setValue(null);
		
		MemberOfStaffShortVo memStaffShortVo = (MemberOfStaffShortVo) domain.getMosUser();
		if (memStaffShortVo != null && memStaffShortVo.getHcp() != null)
		{
			form.getLocalContext().setCurrentHcp(domain.getHcpLite(memStaffShortVo.getHcp().getID_Hcp()));
			form.textBoxHCP().setValue((memStaffShortVo).toString());
		}
		else
			form.getLocalContext().setCurrentHcp(null);

		form.timeNote().setValue(new ims.framework.utils.Time());		
	}

	private void setButtonsViewMode()
	{
		form.setMode(FormMode.VIEW);
		form.checkBoxCorrection().setEnabled(false);
		form.labelCorrectionConfirmed().setEnabled(false);
		form.chkHospitalReport().setEnabled(false);
		form.labelCorrectionReason().setEnabled(false);
		form.textBoxClinicalNotes().setEnabled(false);
		form.textBoxCorrectionReason().setEnabled(false);

		if (form.checkBoxCorrection().getValue() == true)
		{
			form.bCorrection().setEnabled(false);
			form.labelCorrectionReason().setVisible(true);
			form.textBoxCorrectionReason().setVisible(true);
			form.checkBoxCorrection().setVisible(true);
			form.labelCorrectionConfirmed().setVisible(true);
		}
		else
		{
			form.bCorrection().setEnabled(form.getLocalContext().getClinicalNoteIsNotNull()); //WDEV-15066
			form.labelCorrectionReason().setVisible(false);
			form.textBoxCorrectionReason().setVisible(false);
			form.checkBoxCorrection().setVisible(false);
			form.labelCorrectionConfirmed().setVisible(false);
		}
		
		if (domain.getHcpLiteUser() == null)//WDEV-15037
		{
			form.bNew().setEnabled(false);
			form.bCorrection().setEnabled(false);
		}
		else
		{
			form.bNew().setEnabled(true);
		}

		form.bSave().setVisible(false);//WDEV-14976
		form.bSave().setEnabled(false);
		form.bCancel().setEnabled(true);

	}

	private void setButtonsNewMode()
	{
		form.checkBoxCorrection().setVisible(false);
		form.labelCorrectionConfirmed().setVisible(false);
		form.chkHospitalReport().setEnabled(true);
		form.labelCorrectionReason().setVisible(false);
		form.textBoxClinicalNotes().setEnabled(true);
		form.textBoxCorrectionReason().setVisible(false);
		form.bCorrection().setVisible(false);
		form.bNew().setVisible(false);
		form.bSave().setVisible(true);//WDEV-14976
		form.bSave().setEnabled(true);
		form.bCancel().setEnabled(true);

	}

	private void setButtonsCorrectMode()
	{
		form.setMode(FormMode.EDIT);

		form.labelCorrectionReason().setVisible(true);
		form.textBoxCorrectionReason().setVisible(true);
		form.checkBoxCorrection().setVisible(true);
		form.labelCorrectionConfirmed().setVisible(true);
		form.checkBoxCorrection().setEnabled(true);
		form.labelCorrectionConfirmed().setEnabled(true);
		form.chkHospitalReport().setEnabled(false);
		form.labelCorrectionReason().setVisible(true);
		form.textBoxClinicalNotes().setEnabled(false);
		form.textBoxCorrectionReason().setEnabled(true);
		form.bCorrection().setVisible(false);
		form.bNew().setVisible(false);
		form.bSave().setVisible(true);//WDEV-14976
		form.bSave().setEnabled(true);
		form.bCancel().setEnabled(true);

		form.dateNote().setValue(new ims.framework.utils.Date());

		MemberOfStaffShortVo memStaffShortVo = (MemberOfStaffShortVo) domain.getMosUser();
		if (memStaffShortVo != null && memStaffShortVo.getHcp() != null)
		{
			form.getLocalContext().setCurrentHcp(domain.getHcpLite(memStaffShortVo.getHcp().getID_Hcp()));
			form.textBoxHCP().setValue((memStaffShortVo).toString());
		}
		else
			form.getLocalContext().setCurrentHcp(null);

		form.timeNote().setValue(new ims.framework.utils.Time());
	}

	private void loadCarePlans()
	{
		CarePlanTitleCollection coll = form.getLocalContext().getCarePlans();

		if (coll != null)
		{
			form.gridCarePlan().getRows().clear();
			GenForm.gridCarePlanRow row;
			for (int i = 0; i < coll.size(); i++)
			{
				CarePlanTitle title = coll.get(i);
				row = form.gridCarePlan().getRows().newRow();
				row.setcolCarePlan(title.getTitle());
				
				if(isClinicalNotesCarePlanDetailsAlias() && form.getGlobalContext().COE.getCarePlanIsNotNull())
				{
					if(title.equals(form.getGlobalContext().COE.getCarePlan()))
					{
						row.setcolSelect(true);
					}
				}
				row.setValue(title);
			}

		}
	}

	private void populateCarePlans()
	{
		// Populate the careplan selected column with data from database
		if (form.getLocalContext().getClinicalNote().getCarePlans() != null)
		{
			CarePlanTitleCollection dataColl = form.getLocalContext().getClinicalNote().getCarePlans();
			if (dataColl != null)
			{
				GenForm.gridCarePlanRow row;
				for (int i = 0; i < dataColl.size(); i++)
				{
					CarePlanTitle title = dataColl.get(i);
					row = form.gridCarePlan().getRowByValue(title);
					if (row != null)
						row.setcolSelect(true);
				}
			}
		}
	}

	protected void onBCorrectionClick() throws ims.framework.exceptions.PresentationLogicException
	{
		setButtonsCorrectMode();
	}

	protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);

		// If the form opened from PainReview or SkinReview - go back in these
		// screens
		if (form.getGlobalContext().COE.ClinicalNotes.getCallingForm() != null)
			engine.open(form.getGlobalContext().COE.ClinicalNotes.getCallingForm());
		if(isClinicalNotesCarePlanDetailsAlias())
			engine.open(form.getForms().Nursing.ClinicalNotesViewCarePlanDetails);
		else
			engine.open(form.getForms().Nursing.ClinicalNotesView);
	}

	protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.textBoxCorrectionReason().getValue() != null && !form.textBoxCorrectionReason().getValue().equals("") && form.checkBoxCorrection().getValue() == false)
		{
			engine.showMessage("Please Confirm Correction");
			return;
		}

		NursingClinicalNotesVo notes = form.getLocalContext().getClinicalNote();
		if (notes == null)
		{
			notes = new NursingClinicalNotesVo();
			
			AuthoringInformationVo voAuthoring = new AuthoringInformationVo();	
			voAuthoring.setAuthoringDateTime(new DateTime(form.dateNote().getValue(), form.timeNote().getValue()));
			voAuthoring.setAuthoringHcp(form.getLocalContext().getCurrentHcp());	
			notes.setAuthoringInfo(voAuthoring);
		}
	//	else if (form.checkBoxCorrection().getValue() == true)
	//	{
	//		notes.setDateTimeCorrection(new DateTime(form.dateNote().getValue(), form.timeNote().getValue()));
	//		notes.setHCPCorrection(form.getLocalContext().getCurrentHcp());
	//	}
		notes.setIsCorrected(form.checkBoxCorrection().getValue());
		
		notes.setInHospitalReport(new Boolean(form.chkHospitalReport().getValue()));
		notes.setClinicalNote(form.textBoxClinicalNotes().getValue());
		
		ClinicalNoteStatusVo  voClinicalNoteStatus = new ClinicalNoteStatusVo();
		if (form.checkBoxCorrection().getValue() == false)
		{
			voClinicalNoteStatus.setCorrectionConfirmed(Boolean.FALSE);//TRUE);
			voClinicalNoteStatus.setStatus(ims.core.vo.lookups.ClinicalNotesStatus.ACTIVE);//WDEV-14960
		}
		else
		{
			voClinicalNoteStatus.setCorrectionConfirmed(Boolean.TRUE); //FALSE);
			voClinicalNoteStatus.setStatus(ims.core.vo.lookups.ClinicalNotesStatus.CORRECTED);//
			voClinicalNoteStatus.setCorrectedBy(form.getLocalContext().getCurrentHcp() != null ? form.getLocalContext().getCurrentHcp().getMos() : null);//WDEV-14960	
		}

		voClinicalNoteStatus.setCorrectionReason(form.textBoxCorrectionReason().getValue());
//		voClinicalNoteStatus.setCorrectedBy(notes.getAuthoringInfo().getAuthoringHcp() != null  ? notes.getAuthoringInfo().getAuthoringHcp().getMos() : null);
		voClinicalNoteStatus.setDateTime(new DateTime());
		
		notes.setCurrentStatus(voClinicalNoteStatus);
		
		if (form.getGlobalContext().Core.getPatientShortIsNotNull())
			notes.setWard(form.getGlobalContext().Core.getPatientShort().getWard());

		if (notes.getClinicalContact() == null)
			notes.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		if (notes.getCareContext() == null)
			notes.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());

		// HcpDisType voInstance = new HcpDisType();
		// voInstance.id = HcpDisType.NURSING.id;

		//WDEV-12236 
		// WDEV-15055 notes.setDiscipline(HcpDisType.NURSING);
		
		notes.setNoteClassification(getMappedClassificationLookup());

		// Save the Careplans too
		CarePlanTitleCollection cpColl = null;
		if(isClinicalNotesCarePlanDetailsAlias() && form.getGlobalContext().COE.getCarePlanIsNotNull())
		{
			CarePlan voCarePlan = form.getGlobalContext().COE.getCarePlan();
			cpColl = notes.getCarePlans();
			if(cpColl == null)
				cpColl = new CarePlanTitleCollection();
			
			cpColl.add(voCarePlan);
		}
		else
		{
			GenForm.gridCarePlanRow row;
			cpColl = new CarePlanTitleCollection();
			for (int i = 0; i < form.gridCarePlan().getRows().size(); i++)
			{
				row = form.gridCarePlan().getRows().get(i);
				if (row.getcolSelect())
				{
					cpColl.add(row.getValue());
				}
			}
		}
		
		notes.setCarePlans(cpColl);
		
		if (form.getLocalContext().getCurrentHcpIsNotNull() && form.getLocalContext().getCurrentHcp().getHcpTypeIsNotNull()) //WDEV-15055
		{
			notes.setDiscipline(form.getLocalContext().getCurrentHcp().getHcpType());
		}
		else
		// Clinical notes default to nursing type
		notes.setDiscipline(HcpDisType.NURSING);
		
		if ( ! notes.getNoteTypeIsNotNull())
			notes.setNoteType(ClinicalNoteType.CLINICALNOTE);	
		
		if (notes.getClinicalContact() == null)
			notes.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		if (notes.getCareContext() == null)
			notes.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		notes.setIsDerivedNote(Boolean.FALSE);			
		notes.setRecordingDateTime(new DateTime(form.dateNote().getValue(), form.timeNote().getValue()));
		//ClinicalNoteStatusVo clinicalNoteStatusVo = new ClinicalNoteStatusVo();
		
		//notes.setCurrentStatus(clinicalNoteStatusVo);
		
		String[] errors = notes.validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return;
		}

		try
		{
			domain.saveClinicalNotes(notes);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			onFormOpen();
			return;
		}
		
		form.setMode(FormMode.VIEW);

		// If the form opened from PainReview or SkinReview - go back in these
		// screens
		if (form.getGlobalContext().COE.ClinicalNotes.getCallingForm() != null)
			engine.open(form.getGlobalContext().COE.ClinicalNotes.getCallingForm());
		if(isClinicalNotesCarePlanDetailsAlias())
			engine.open(form.getForms().Nursing.ClinicalNotesViewCarePlanDetails);
		else
			engine.open(form.getForms().Nursing.ClinicalNotesView);
	}
	
	//WDEV-12236 
	public ClinicalNoteClassification getMappedClassificationLookup()
	{
		ClinicalNoteClassificationCollection coll = ims.clinical.vo.lookups.LookupHelper.getClinicalNoteClassification(domain.getLookupService());
	
		for (int i = 0; i < coll.size(); i++)
		{
			LookupInstVo instMap = domain.getMappings(coll.get(i));
			LookupMappingVoCollection mapColl = instMap.getMappings();
			for (int j = 0; j < mapColl.size(); j++)
			{
				LookupMappingVo valueObject = mapColl.get(j);
		
				if(valueObject.getExtCode()!=null && valueObject.getExtCode().equals("CAREPLANNOTE"))
					return coll.get(i);
			}
		}
		return null;
	}
	
	private boolean isClinicalNotesCarePlanDetailsAlias() 
	{
		return engine.getFormName().equals(form.getForms().Nursing.ClinicalNotesCarePlanDetails);
	}
	// BW Not used - here as a sample on how to mark an object as recorded in
	// error
	/*
	 * protected void onBtnRIEClick() throws PresentationLogicException { try {
	 * domain.markAsRecordedInError(form.getLocalContext().getClinicalNote().getID_ClinicalNotes(),
	 * "ClinicalNotes"); } catch (StaleObjectException e) {
	 * engine.showMessage("Notes record has been updated by another user. Screen
	 * will be refreshed."); onFormOpen(); return; } }
	 */

	@Override
	protected void onBtnUpdateActionsClick() throws PresentationLogicException
	{
		if (areCarePlansSelected())
			engine.open(form.getForms().Nursing.ClinicalNotesUpdateActionsDialog,new Object[]{listCarePlans()});
	}

	private CarePlanTitleCollection listCarePlans() 
	{
		CarePlanTitleCollection voColl = new CarePlanTitleCollection();
		
		for (int i = 0 ; i < form.gridCarePlan().getRows().size() ; i++)
		{
			if (form.gridCarePlan().getRows().get(i).getcolSelect())
				voColl.add(form.gridCarePlan().getRows().get(i).getValue());
		}
		return voColl;
	}

	private boolean areCarePlansSelected() 
	{
		boolean bSelected = false;
		
		for (int i = 0 ; i < form.gridCarePlan().getRows().size() ; i++)
		{
			if (form.gridCarePlan().getRows().get(i).getcolSelect())
				bSelected = true;
		}
		return bSelected;
	}

	@Override
	protected void onGridCarePlanSelectionChanged() throws PresentationLogicException 
	{
	}

	@Override
	protected void onGridCarePlanGridCheckBoxClicked(int column, gridCarePlanRow row, boolean isChecked) throws PresentationLogicException
	{
		if (ConfigFlag.GEN.CARE_PLAN_FUNCTIONALITY_TYPE.getValue().toString().equals("CCO"))
		{
			form.btnUpdateActions().setVisible(true);
			form.btnUpdateActions().setEnabled(areCarePlansSelected());
		}
		
	}

	
	@Override //WDEV-15066
	protected void onRIEDialogClosed(DialogResult result) throws PresentationLogicException 
	{
		clearScreen();
		form.getLocalContext().setClinicalNote(null);
	}
	
	private void clearScreen() 
	{
		form.dateNote().setValue(null);
		form.timeNote().setValue(null);
		form.textBoxHCP().setValue(null);
		form.textBoxClinicalNotes().setValue(null);
		form.chkHospitalReport().setValue(false);
		form.textBoxCorrectionReason().setValue(null);
		form.checkBoxCorrection().setValue(false);
	}
}
