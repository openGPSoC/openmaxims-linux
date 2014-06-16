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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.18 build 40701.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.contactinput;

import ims.framework.FormName;
import ims.framework.cn.data.TreeNode;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.core.vo.ClinicalNotesVo;
import ims.framework.enumerations.FormMode;
import ims.framework.utils.DateTime;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.ClinicalNoteStatusVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.PersonName;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.HcpDisTypeCollection;
import ims.core.vo.lookups.LookupHelper;
import ims.domain.exceptions.StaleObjectException;
import ims.core.vo.lookups.ClinicalNotesStatus;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		//Only do this once, as domain.getMosUser() is a database call.
		MemberOfStaffShortVo memStaffShortVo = (MemberOfStaffShortVo)domain.getMosUser();
		if(memStaffShortVo != null && memStaffShortVo.getHcp() != null)
			form.getLocalContext().setCurrentHcp(memStaffShortVo.getHcp());
		
		//RootNodes are the Discipline instances
		HcpDisTypeCollection coll = LookupHelper.getHcpDisType(domain.getLookupService());
		TreeNode[] rootNodes = coll.getRootNodes();
		for (int i = 0; i < rootNodes.length; i++)
		{
			HcpDisType lk = (HcpDisType)rootNodes[i];
			if (!lk.equals(HcpDisType.NURSING))
				form.cmbDiscipline().newRow(lk,lk.getText());
		}

		if (form.getGlobalContext().COE.getClinicalNotesVo() != null)
		{			
			ClinicalNotesVo contactRecord = domain.getClinicalNotes(form.getGlobalContext().COE.getClinicalNotesVo());
			if (contactRecord != null)
			{
				
				form.dtRecorded().setValue(contactRecord.getRecordingDateTime().getDate());
				form.timRecorded().setValue(contactRecord.getRecordingDateTime().getTime());
				if (contactRecord.getAuthoringInfoIsNotNull())
				{
					if (contactRecord.getAuthoringInfo().getAuthoringHcpIsNotNull())
					{
						form.cmbHCP().newRow(contactRecord.getAuthoringInfo().getAuthoringHcp(), contactRecord.getAuthoringInfo().getAuthoringHcp().toString());
						form.cmbHCP().setValue(contactRecord.getAuthoringInfo().getAuthoringHcp());
					}
				}
				
				form.cmbDiscipline().setValue(contactRecord.getDiscipline());
				
				if (contactRecord.getRecordingUserIsNotNull())
					form.txtBoxBy().setValue(contactRecord.getRecordingUser().toString());
				
				form.txtNote().setValue(contactRecord.getClinicalNote());
				
				if (contactRecord.getCurrentStatusIsNotNull())
					form.txtCorrectionReason().setValue(contactRecord.getCurrentStatus().getCorrectionReason());
				
				if(memStaffShortVo != null && memStaffShortVo.getHcp() != null)	
					form.txtCorrectedBy().setValue(memStaffShortVo.getHcp().toString());
	
				// If active, correction has not been set 
				if (contactRecord.getIsCorrectedIsNotNull())
				{
					if (contactRecord.getIsCorrected())
					{
						form.chkCorrection().setValue(true);
						form.btnSave().setEnabled(false);
						form.chkCorrection().setEnabled(false);
						form.txtCorrectionReason().setEnabled(false);				
					}
					else
					{
						form.chkCorrection().setValue(false);
						form.btnSave().setEnabled(true);
						form.chkCorrection().setEnabled(true);
						form.txtCorrectionReason().setEnabled(true);
					}
				}
				
				form.setMode(FormMode.VIEW);
				
				form.getLocalContext().setContactToUpdate(contactRecord);
			}
		}
		else
		{
			form.dtRecorded().setValue(new DateTime().getDate());
			form.timRecorded().setValue(new DateTime().getTime());
			if (form.getLocalContext().getCurrentHcp() != null)
			{
				form.txtBoxBy().setValue(form.getLocalContext().getCurrentHcp().toString());
			}
		}
		
		form.txtCorrectedBy().setEnabled(false);
		
		if (form.getGlobalContext().COE.getContactCorrection().booleanValue())
		{
			form.cmbHCP().setEnabled(false);
			form.cmbDiscipline().setEnabled(false);
			//form.txtCorrectionReason().setEnabled(true);
			//form.chkCorrection().setEnabled(true);
			form.txtCorrectedBy().setVisible(true);
			form.chkCorrection().setVisible(true);
			form.lblCorrection().setVisible(true);
			form.lblCorrectionConfirmed().setVisible(true);
			form.lblCorrectedByHcp().setVisible(true);
			
		}
		else
		{
			form.cmbHCP().setEnabled(true);
			form.cmbDiscipline().setEnabled(true);
			form.txtCorrectionReason().setVisible(false);
			form.txtCorrectedBy().setVisible(false);
			form.chkCorrection().setVisible(false);
			form.lblCorrection().setVisible(false);
			form.lblCorrectionConfirmed().setVisible(false);
			form.lblCorrectedByHcp().setVisible(false);
		}
		
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.txtCorrectionReason().getValue() != null && !form.txtCorrectionReason().getValue().equals("") &&
				form.chkCorrection().getValue() == false)
		{
			engine.showMessage("Please Confirm Correction");
			return;
		}
		
		if (form.cmbDiscipline().getValue() == null)
		{
			engine.showMessage("Please select a Discipline");
			return;
		}
		
		ClinicalNotesVo contact = form.getLocalContext().getContactToUpdate();
		if (contact == null)
		{
			contact = new ClinicalNotesVo();
			contact.setRecordingDateTime((new DateTime(form.dtRecorded().getValue(), form.timRecorded().getValue())));
						
			if (form.cmbHCP().getValue() != null)
				contact.setAuthoringInfo(getAuthoringHCP());
			if (form.cmbDiscipline().getValue() != null)
				contact.setDiscipline(form.cmbDiscipline().getValue());
		}
		
		MemberOfStaffLiteVo memStaffLiteVo = (MemberOfStaffLiteVo)domain.getMosUser();
		
		ClinicalNoteStatusVo clinNoteStatus = new ClinicalNoteStatusVo();
		clinNoteStatus.setDateTime(new DateTime(form.dtRecorded().getValue(), form.timRecorded().getValue()));
		clinNoteStatus.setClinicalNote(form.txtNote().getValue());
		
		if (form.chkCorrection().getValue() == true)
		{
			clinNoteStatus.setCorrectionReason(form.txtCorrectionReason().getValue());
			clinNoteStatus.setCorrectionConfirmed(Boolean.TRUE);
			clinNoteStatus.setStatus(ClinicalNotesStatus.CORRECTED);
			
			if(memStaffLiteVo != null)
			{
				clinNoteStatus.setCorrectedBy(memStaffLiteVo);
				clinNoteStatus.setMOS(memStaffLiteVo);
			}
			
			contact.getStatusHistory().add(clinNoteStatus);
			contact.setCurrentStatus(clinNoteStatus);
		}
		else
		{
			// only set recording user when inserting
			if(memStaffLiteVo != null)
				contact.setRecordingUser(memStaffLiteVo);
			
			clinNoteStatus.setStatus(ClinicalNotesStatus.ACTIVE);
		}
			
		contact.setClinicalNote(form.txtNote().getValue());
		contact.setIsDerivedNote(Boolean.FALSE);
		
		if (form.chkCorrection().getValue() == false)
			contact.setIsCorrected(new Boolean(false));
		else
			contact.setIsCorrected(new Boolean(true));
		
		if (contact.getClinicalContact() == null)
			contact.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		if (contact.getCareContext() == null)
			contact.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		String[] errors = contact.validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return;
		}	

		try 
		{
			domain.saveClinicalNotes(contact);
		} 
		catch (StaleObjectException sox)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.CANCEL);					
			return;
		}
		engine.close(DialogResult.OK);
	}

	protected void onCmbDisciplineValueChanged() throws PresentationLogicException 
	{
		if (form.cmbDiscipline().getValue() != null)
		{	
			form.cmbHCP().clear();
		}
	}
	protected void onCmbHCPTextSubmited(String value) throws PresentationLogicException 
	{
		if (form.cmbDiscipline().getValue() != null)
		{	
			PersonName voPname = new PersonName();
			voPname.setSurname(value);
			
			HcpDisType voHCPDisciplineInstance = form.cmbDiscipline().getValue();
			
			HcpLiteVoCollection  hcpLiteColl = domain.listHcpLiteByNameAndDisciplineType(voPname.getSurname(), voHCPDisciplineInstance);
			
			if (hcpLiteColl != null)
			{
				form.cmbHCP().clear();
				for (int i = 0; i < hcpLiteColl.size(); i++)
				{
					form.cmbHCP().newRow(hcpLiteColl.get(i), hcpLiteColl.get(i).getName().toString());
				}			
				if (hcpLiteColl.size() == 1)
					form.cmbHCP().setValue(hcpLiteColl.get(0));
				else if (hcpLiteColl.size() > 1)
					form.cmbHCP().showOpened();
			}
		}
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		engine.close(DialogResult.CANCEL);		
	}
	
	private AuthoringInformationVo getAuthoringHCP()
	{
		AuthoringInformationVo voAuthoring = new AuthoringInformationVo();
		voAuthoring.setAuthoringDateTime(new DateTime());
		voAuthoring.setAuthoringHcp((HcpLiteVo) domain.getHcpLiteUser());
		return voAuthoring;
	}
}
