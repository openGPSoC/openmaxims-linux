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
// This code was generated by Callum Wells using IMS Development Environment (version 1.20 build 40813.900)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.urinalysis;

import java.util.ArrayList;

import ims.core.forms.urinalysis.GenForm.grpAscorbicEnumeration;
import ims.core.forms.urinalysis.GenForm.grpBilEnumeration;
import ims.core.forms.urinalysis.GenForm.grpBloodEnumeration;
import ims.core.forms.urinalysis.GenForm.grpGluEnumeration;
import ims.core.forms.urinalysis.GenForm.grpKetonesEnumeration;
import ims.core.forms.urinalysis.GenForm.grpLeucocytesEnumeration;
import ims.core.forms.urinalysis.GenForm.grpNitrateEnumeration;
import ims.core.forms.urinalysis.GenForm.grpProteinEnumeration;
import ims.core.forms.urinalysis.GenForm.grpUbgEnumeration;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.RecordingUserInformationVo;
import ims.core.vo.Urinalysis;
import ims.core.vo.UrinalysisCollection;
import ims.core.vo.lookups.UrinalysisResults;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;


public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		initiliaze();
//		form.grpFilterBy().setValue(GenForm.grpFilterByEnumeration.rdoActive);
		
		open();
	}
	 
	private void initiliaze()
	{
		form.customControlAuthoringInfo().setIsRequiredPropertyToControls(FormMode.EDIT.equals(form.getMode()));//WDEV-17261
		
		if (Boolean.TRUE.equals(form.getLocalContext().getActiveOnly()) || form.getLocalContext().getActiveOnly() == null)
		{
			form.grpFilterBy().setValue(GenForm.grpFilterByEnumeration.rdoActive);
		}
		else
		{
			form.grpFilterBy().setValue(GenForm.grpFilterByEnumeration.rdoInactive);
		}
	}

	private void open() 
	{
		form.getLocalContext().setVoUrinanalysis(null);
		clearScreen();
		form.chkNoSample().setValue(false);
		setMode(false);
		
		UrinalysisCollection voCollUrinanalysis = new UrinalysisCollection();
				
		Urinalysis voUrinalysis = new Urinalysis();
		voUrinalysis.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		voUrinalysis.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		if (form.grpFilterBy().getValue() != null && form.grpFilterBy().getValue().equals(GenForm.grpFilterByEnumeration.rdoActive))
			voUrinalysis.setIsActive(Boolean.TRUE);
		
		try 
		{
			voCollUrinanalysis = domain.listUrinanalysis(voUrinalysis);	
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage("DomainInterfaceException occurred listing Urinanalysis " + e.getMessage());
			return;
		}
			
		
		form.btnUpdate().setEnabled(false);
		
		if (voCollUrinanalysis == null)
			return;
		
		int nCount = voCollUrinanalysis.size();
		
		if(form.getLocalContext().getIndex() == null)
			form.getLocalContext().setIndex(new Integer(0));
		
		if (nCount == 0)
		{
			setPrevNextBtnStatus(nCount, form.getLocalContext().getIndex().intValue());
			return;
		}
		
		if (nCount > form.getLocalContext().getIndex().intValue())
		{
			populateScreen(voCollUrinanalysis.get(form.getLocalContext().getIndex().intValue()));	
			setPrevNextBtnStatus(nCount, form.getLocalContext().getIndex().intValue());
		}
		else
		{
			populateScreen(voCollUrinanalysis.get(nCount - 1));
			setPrevNextBtnStatus(nCount, nCount - 1);
		}
		
		
		form.getLocalContext().setVoCollUrinanalysis(voCollUrinanalysis);
		form.btnUpdate().setEnabled(true);
	}


	private void setPrevNextBtnStatus(int nCount, int nIndex)
	{	
		if (nIndex < nCount-1 && nIndex > 0)
		{
			form.btnNext().setEnabled(true);
			form.btnPrevious().setEnabled(true);
		}
		else if (nIndex < nCount-1 && nCount > 1)
		{	
			form.btnNext().setEnabled(true);
			form.btnPrevious().setEnabled(false);
		}
		else if (nIndex == nCount-1 && nCount > 1)
		{
			form.btnNext().setEnabled(false);
			form.btnPrevious().setEnabled(true);
		}
		else
		{
			form.btnNext().setEnabled(false);
			form.btnPrevious().setEnabled(false);
		}
	}

	private void populateScreen(Urinalysis voUrinalysis)
	{
		//WDEV-15285
		clearDetails();
		form.chkNoSample().setValue(null);
		
		form.getLocalContext().setVoUrinanalysis(voUrinalysis);
		
		form.grpLeucocytes().setValue(populateLeucocytes(voUrinalysis.getLeucocytes()));
		form.grpProtein().setValue(populateProtein(voUrinalysis.getProtein()));
		form.grpBlood().setValue(populateBlood(voUrinalysis.getBlood()));
		form.grpKetones().setValue(populateKetones(voUrinalysis.getKetones()));
		form.grpGlu().setValue(populateGlucose(voUrinalysis.getGlucose()));
		form.grpAscorbic().setValue(populateAscorbicAcid(voUrinalysis.getAscorbicAcid()));
		form.grpBil().setValue(populateBilirubin(voUrinalysis.getBilirubin()));
		form.grpUbg().setValue(populateUrobilinogen(voUrinalysis.getUrobilinogen()));
		form.grpNitrate().setValue(populateNitrate(voUrinalysis.getNitrate()));		
		form.cmbPH().setValue(voUrinalysis.getPH());
		if(voUrinalysis.getNoAbnormalityDetected() != null)
			form.chkNoAbnormality().setValue(voUrinalysis.getNoAbnormalityDetected().booleanValue());
		form.chkInactive().setValue(!voUrinalysis.getIsActive().booleanValue());
		if(voUrinalysis.getNoSample()!= null)
			form.chkNoSample().setValue(voUrinalysis.getNoSample().booleanValue());
		form.decSpecificGravity().setValue(voUrinalysis.getSpecificGravity());
		if(voUrinalysis.getAuthoringInformationIsNotNull())
			form.customControlAuthoringInfo().setValue(voUrinalysis.getAuthoringInformation());
		else
			form.customControlAuthoringInfo().setValue(null);
		
		form.cmbRecordingHCP().setValue(null);	
		form.dtimRecordingDateTime().setValue(null);
		if(voUrinalysis.getRecordingInformationIsNotNull()){
			MemberOfStaffLiteVo mos = voUrinalysis.getRecordingInformation().getRecordingUser();
			if(mos!=null){
				form.cmbRecordingHCP().newRow(mos, mos.toString());
				form.cmbRecordingHCP().setValue(mos);	
			}
			form.dtimRecordingDateTime().setValue(voUrinalysis.getRecordingInformation().getRecordingDateTime());
		}
				
		DateTime datim = voUrinalysis.getSysInfo().getCreationDateTime();
		
		if (datim != null)
		{
			Date date = datim.getDate();
			Time time = datim.getTime();
			form.dteRecords().setValue(date);
			form.timRecords().setValue(time);
		}
	}

	private grpGluEnumeration populateGlucose(UrinalysisResults voLookupResults)
	{
		if (voLookupResults == null)
			return GenForm.grpGluEnumeration.None;
		
		if (voLookupResults.equals(UrinalysisResults.NEGATIVE))
			return GenForm.grpGluEnumeration.rdoGLUNeg; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSONE))
			return GenForm.grpGluEnumeration.rdoGLUPlus1; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSTWO))
			return GenForm.grpGluEnumeration.rdoGLUPlus2; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSTHREE))
			return GenForm.grpGluEnumeration.rdoGLUPlus3; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSFOUR))
			return GenForm.grpGluEnumeration.rdoGLUPlus4; 
		
		if (voLookupResults.equals(UrinalysisResults.TRACE))
			return GenForm.grpGluEnumeration.rdoGLUTrace; 

		return GenForm.grpGluEnumeration.None;
	}
	
	private grpAscorbicEnumeration populateAscorbicAcid(UrinalysisResults voLookupResults)
	{
		if (voLookupResults == null)
			return GenForm.grpAscorbicEnumeration.None;
		
		if (voLookupResults.equals(UrinalysisResults.NEGATIVE))
			return GenForm.grpAscorbicEnumeration.rdoAscorbicNeg; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSONE))
			return GenForm.grpAscorbicEnumeration.rdoAscorbicPlus; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSTWO))
			return GenForm.grpAscorbicEnumeration.rdoAscorbicPlus2; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSTHREE))
			return GenForm.grpAscorbicEnumeration.rdoAscorbicPlus3; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSFOUR))
			return GenForm.grpAscorbicEnumeration.rdoAscorbicPlus4; 
		
		if (voLookupResults.equals(UrinalysisResults.TRACE))
			return GenForm.grpAscorbicEnumeration.rdoAscorbicTrace; 

		return GenForm.grpAscorbicEnumeration.None;
	}

	private grpBilEnumeration populateBilirubin(UrinalysisResults voLookupResults)
	{
		if (voLookupResults == null)
			return GenForm.grpBilEnumeration.None;
		
		if (voLookupResults.equals(UrinalysisResults.NEGATIVE))
			return GenForm.grpBilEnumeration.rdoBILNeg; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSONE))
			return GenForm.grpBilEnumeration.rdoBILPlus; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSTWO))
			return GenForm.grpBilEnumeration.rdoBILPlus2; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSTHREE))
			return GenForm.grpBilEnumeration.rdoBILPlus3; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSFOUR))
			return GenForm.grpBilEnumeration.rdoBILPlus4; 
		
		if (voLookupResults.equals(UrinalysisResults.TRACE))
			return GenForm.grpBilEnumeration.rdoBILTrace; 

		return GenForm.grpBilEnumeration.None;
	}
	
	private grpUbgEnumeration populateUrobilinogen(UrinalysisResults voLookupResults)
	{
		if (voLookupResults == null)
			return GenForm.grpUbgEnumeration.None;
		
		if (voLookupResults.equals(UrinalysisResults.NEGATIVE))
			return GenForm.grpUbgEnumeration.rdoUBGNeg; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSONE))
			return GenForm.grpUbgEnumeration.rdoUBGPlus1; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSTWO))
			return GenForm.grpUbgEnumeration.rdoUBGPlus2; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSTHREE))
			return GenForm.grpUbgEnumeration.rdoUBGPlus3; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSFOUR))
			return GenForm.grpUbgEnumeration.rdoUBGPlus4; 
		
		if (voLookupResults.equals(UrinalysisResults.TRACE))
			return GenForm.grpUbgEnumeration.rdoUBGTrace; 

		return GenForm.grpUbgEnumeration.None;
	}

	private grpKetonesEnumeration populateKetones(UrinalysisResults voLookupResults)
	{
		if (voLookupResults == null)
			return GenForm.grpKetonesEnumeration.None;
		
		if (voLookupResults.equals(UrinalysisResults.NEGATIVE))
			return GenForm.grpKetonesEnumeration.rdoKetonesNeg; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSONE))
			return GenForm.grpKetonesEnumeration.rdoKetonesPlus1; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSTWO))
			return GenForm.grpKetonesEnumeration.rdoKetonesPlus2; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSTHREE))
			return GenForm.grpKetonesEnumeration.rdoKetonesPlus3; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSFOUR))
			return GenForm.grpKetonesEnumeration.rdoKetonesPlus4; 
		
		if (voLookupResults.equals(UrinalysisResults.TRACE))
			return GenForm.grpKetonesEnumeration.rdoKetonesTrace; 

		return GenForm.grpKetonesEnumeration.None;
	}

	private grpBloodEnumeration populateBlood(UrinalysisResults voLookupResults)
	{
		if (voLookupResults == null)
			return GenForm.grpBloodEnumeration.None;
		
		if (voLookupResults.equals(UrinalysisResults.NEGATIVE))
			return GenForm.grpBloodEnumeration.rdoBloodNeg; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSONE))
			return GenForm.grpBloodEnumeration.rdoBloodPlus1; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSTWO))
			return GenForm.grpBloodEnumeration.rdoBloodPlus2; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSTHREE))
			return GenForm.grpBloodEnumeration.rdoBloodPlus3; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSFOUR))
			return GenForm.grpBloodEnumeration.rdoBloodPlus4; 
		
		if (voLookupResults.equals(UrinalysisResults.TRACE))
			return GenForm.grpBloodEnumeration.rdoBloodTrace; 

		return GenForm.grpBloodEnumeration.None;
	}

	private grpProteinEnumeration populateProtein(UrinalysisResults voLookupResults)
	{
		if (voLookupResults == null)
			return GenForm.grpProteinEnumeration.None;
		
		if (voLookupResults.equals(UrinalysisResults.NEGATIVE))
			return GenForm.grpProteinEnumeration.rdoProteinNeg; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSONE))
			return GenForm.grpProteinEnumeration.rdoProteinPlus1; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSTWO))
			return GenForm.grpProteinEnumeration.rdoProteinPlus2; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSTHREE))
			return GenForm.grpProteinEnumeration.rdoProteinPlus3; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSFOUR))
			return GenForm.grpProteinEnumeration.rdoProteinPlus4; 
		
		if (voLookupResults.equals(UrinalysisResults.TRACE))
			return GenForm.grpProteinEnumeration.rdoProteinTrace; 

		return GenForm.grpProteinEnumeration.None;
	}

	private GenForm.grpLeucocytesEnumeration populateLeucocytes(UrinalysisResults voLookupResults)
	{
		if (voLookupResults == null)
			return GenForm.grpLeucocytesEnumeration.None;
			
		if (voLookupResults.equals(UrinalysisResults.NEGATIVE))
			return GenForm.grpLeucocytesEnumeration.rdoLeucocytesNeg; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSONE))
			return GenForm.grpLeucocytesEnumeration.rdoLeucocytesPlus1; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSTWO))
			return GenForm.grpLeucocytesEnumeration.rdoLeucocytesPlus2; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSTHREE))
			return GenForm.grpLeucocytesEnumeration.rdoLeucocytesPlus3; 
		
		if (voLookupResults.equals(UrinalysisResults.PLUSFOUR))
			return GenForm.grpLeucocytesEnumeration.rdoLeucocytesPlus4; 
		
		if (voLookupResults.equals(UrinalysisResults.TRACE))
			return GenForm.grpLeucocytesEnumeration.rdoLeucocytesTrace; 

		return GenForm.grpLeucocytesEnumeration.None;
	}
	
	private grpNitrateEnumeration populateNitrate(Boolean bStatus)
	{
		if (bStatus == null)
			return GenForm.grpNitrateEnumeration.None;
		
		if (bStatus.equals(Boolean.TRUE))
			return GenForm.grpNitrateEnumeration.rdoNitratePos;
		else if (bStatus.equals(Boolean.FALSE))
			return GenForm.grpNitrateEnumeration.rdoNitrateNeg;
		
		return null;
	}
	
	private void setRadioGroupDefaults()
	{
		form.grpLeucocytes().setValue(null);
		form.grpProtein().setValue(null);
		form.grpBlood().setValue(null);
		form.grpKetones().setValue(null);
		form.grpGlu().setValue(null);
		form.grpAscorbic().setValue(null);
		form.grpBil().setValue(null);
		form.grpUbg().setValue(null);	
		form.grpNitrate().setValue(null);
	}

	protected void onRadioButtongrpFilterByValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		rdoValueChanged();
	}

	private void rdoValueChanged() 
	{
		// Keep the selection
		if (GenForm.grpFilterByEnumeration.rdoActive.equals(form.grpFilterBy().getValue()))
		{
			form.getLocalContext().setActiveOnly(Boolean.TRUE);
		}
		else
		{
			form.getLocalContext().setActiveOnly(Boolean.FALSE);
		}
		
		//List the Urinalysis records based on the filter selected
		UrinalysisCollection voUrinalysisColl;
		
		try {
			Urinalysis voUrinalysis= new Urinalysis();
			voUrinalysis.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
			voUrinalysis.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			if (form.grpFilterBy().getValue().equals(GenForm.grpFilterByEnumeration.rdoActive))
				voUrinalysis.setIsActive(Boolean.TRUE);
			else
				voUrinalysis.setIsActive(null);
			
			voUrinalysisColl = domain.listUrinanalysis(voUrinalysis);
		} catch (DomainInterfaceException e) {
			engine.showMessage("DomainInterfaceException occurred listing referrals " + e.getMessage());
			return;
		}
		form.getLocalContext().setVoUrinanalysis(null);
		clearScreen();
		form.chkNoSample().setValue(false);
		setMode(false);
		
		int nCount = voUrinalysisColl.size();
		form.getLocalContext().setIndex(new Integer(0));
		
		if (nCount == 0)
		{
			setPrevNextBtnStatus(nCount, form.getLocalContext().getIndex().intValue());
			form.btnUpdate().setEnabled(false);
			return;
		}
		
		populateScreen(voUrinalysisColl.get(0)); 
		setPrevNextBtnStatus(nCount, form.getLocalContext().getIndex().intValue());
		
		form.getLocalContext().setVoCollUrinanalysis(voUrinalysisColl);
		
		form.btnUpdate().setEnabled(true);
		//open();
	}
	
	protected void onBtnNextClick() throws PresentationLogicException
	{
		if (form.getLocalContext().getVoCollUrinanalysis() == null)
			return;
	
		populateScreen(form.getLocalContext().getVoCollUrinanalysis().get(getIndex(true)));	
		setPrevNextBtnStatus(form.getLocalContext().getVoCollUrinanalysis().size(), form.getLocalContext().getIndex().intValue());
	}

	protected void onBtnPreviousClick() throws PresentationLogicException
	{
		if (form.getLocalContext().getVoCollUrinanalysis() == null)
			return;
		
		populateScreen(form.getLocalContext().getVoCollUrinanalysis().get(getIndex(false)));
		setPrevNextBtnStatus(form.getLocalContext().getVoCollUrinanalysis().size(), form.getLocalContext().getIndex().intValue());
	}
	
	private int getIndex(boolean bIncrement)
	{
		int nIndex = form.getLocalContext().getIndex().intValue();
		
		if (bIncrement)
		{
			if (nIndex < form.getLocalContext().getVoCollUrinanalysis().size()-1)	
				nIndex++;
		}
		else // decrement
		{
			if (nIndex >= 0)
				nIndex--;
		}
		
		form.getLocalContext().setIndex(new Integer(nIndex));
		
		return nIndex;
	}

	protected void onChkNoAbnormalityValueChanged() throws PresentationLogicException 
	{
		enableScreen();
		
		setRadioGroupDefaults();
		
		form.chkNoSample().setValue(false);
	}
	
	
	private void enableScreen()
	{
		boolean b = form.chkNoAbnormality().getValue();
		
		form.grpLeucocytes().setEnabled(!b);
		form.grpProtein().setEnabled(!b);
		form.grpBlood().setEnabled(!b);
		form.grpKetones().setEnabled(!b);
		form.grpGlu().setEnabled(!b);
		form.grpAscorbic().setEnabled(!b);
		form.grpBil().setEnabled(!b);
		form.grpUbg().setEnabled(!b);
		form.grpNitrate().setEnabled(!b);
		form.chkNoSample().setEnabled(!b);
	}

	protected void onBtnSaveClick() throws PresentationLogicException
	{
		Urinalysis voUrinalysis = null;
		
		if (form.getLocalContext().getVoUrinanalysis() == null)//insert
		{	
			voUrinalysis = new Urinalysis();
		}
		else//update
		{	
			voUrinalysis = form.getLocalContext().getVoUrinanalysis();
		}
		
		voUrinalysis.setAuthoringInformation(form.customControlAuthoringInfo().getValue());
		
		//WDEV-12901 set Recording Information
		if(voUrinalysis.getRecordingInformation()==null){
			RecordingUserInformationVo voRecordingUserInformation = new RecordingUserInformationVo();
			voRecordingUserInformation.setRecordingUser(form.cmbRecordingHCP().getValue());
			voRecordingUserInformation.setRecordingDateTime(new DateTime());
			voUrinalysis.setRecordingInformation(voRecordingUserInformation);
		}
		
		voUrinalysis.setIsActive(new Boolean(!form.chkInactive().getValue()));
		if(form.chkNoSample().getValue())
			voUrinalysis.setNoSample(new Boolean(form.chkNoSample().getValue()));
		else
			voUrinalysis.setNoSample(null);
		
		if(form.chkNoAbnormality().getValue())
			voUrinalysis.setNoAbnormalityDetected(new Boolean(form.chkNoAbnormality().getValue()));
		else
			voUrinalysis.setNoAbnormalityDetected(null);

		if (form.grpLeucocytes() != null)
			voUrinalysis.setLeucocytes(getLeucocytesID(form.grpLeucocytes().getValue()));
		
		if (form.grpProtein() != null)
			voUrinalysis.setProtein(getProteinID(form.grpProtein().getValue()));
		
		if (form.grpBlood() != null)
			voUrinalysis.setBlood(getBloodID(form.grpBlood().getValue()));
		
		if (form.grpKetones() != null)
			voUrinalysis.setKetones(getKetonesID(form.grpKetones().getValue()));
		
		if (form.grpGlu() != null)
			voUrinalysis.setGlucose(getGluID(form.grpGlu().getValue()));
		
		if (form.grpAscorbic() != null)
			voUrinalysis.setAscorbicAcid(getAscorbicID(form.grpAscorbic().getValue()));
		
		if (form.grpBil() != null)
			voUrinalysis.setBilirubin(getBilID(form.grpBil().getValue()));
		
		if (form.grpUbg() != null)
			voUrinalysis.setUrobilinogen(getUbgID(form.grpUbg().getValue()));
		
		if (form.cmbPH() != null)
			voUrinalysis.setPH(form.cmbPH().getValue());
		
		if (form.decSpecificGravity() != null)
			voUrinalysis.setSpecificGravity(form.decSpecificGravity().getValue());
		
		if (form.grpNitrate().getValue() != null)
		{	
			if (form.grpNitrate().getValue() == GenForm.grpNitrateEnumeration.rdoNitratePos)
				voUrinalysis.setNitrate(Boolean.TRUE);
			else if (form.grpNitrate().getValue() == GenForm.grpNitrateEnumeration.rdoNitrateNeg)
				voUrinalysis.setNitrate(Boolean.FALSE);
			else  //if 'No Abnormality Detected' is selected Nitrate must be cleared
				voUrinalysis.setNitrate(null);
		}
		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
			voUrinalysis.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		if(form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
			voUrinalysis.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			
		String[] errors = voUrinalysis.validate(validateUI());

		if(errors != null)
		{	
			engine.showErrors("Validation Errors", errors);
			return;
		}
		
		try 
		{
			voUrinalysis = domain.saveUrinanalysis(voUrinalysis);
		} 
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
		}
		
		open();
		
		form.setMode(FormMode.VIEW);
	}

	/**
	 *	WDEV-13134
	 *	Function used to validate UI rules
	 */
	private String[] validateUI()
	{
		ArrayList<String> errors = new ArrayList<String>();
		
		if (form.customControlAuthoringInfo().getValue()== null || !form.customControlAuthoringInfo().getValue().getAuthoringHcpIsNotNull())
			errors.add("Authoring HCP is mandatory.");
		
		if (form.customControlAuthoringInfo().getValue()== null || !form.customControlAuthoringInfo().getValue().getAuthoringDateTimeIsNotNull())
			errors.add("Authoring Date Time is mandatory.");
		
		return errors.toArray(new String[errors.size()]);
	}

	private void setMode(boolean b)
	{
		form.chkNoSample().setEnabled(b);
	
		if (b) 
		{	
			// scroll facility only avaiable when in view mode	
			form.btnNext().setEnabled(!b);
			form.btnPrevious().setEnabled(!b);
		}
		else
			form.customControlAuthoringInfo().setValue(null);
		
		form.grpFilterBy().setEnabled(!b);
	}

	private UrinalysisResults getUbgID(grpUbgEnumeration enumUbg)
	{
		if (enumUbg == null)
			return null;
		
		if (enumUbg == GenForm.grpUbgEnumeration.rdoUBGNeg)
			return UrinalysisResults.NEGATIVE;
		
		if (enumUbg == GenForm.grpUbgEnumeration.rdoUBGPlus1)
			return UrinalysisResults.PLUSONE;
		
		if (enumUbg == GenForm.grpUbgEnumeration.rdoUBGPlus2)
			return UrinalysisResults.PLUSTWO;
		
		if (enumUbg == GenForm.grpUbgEnumeration.rdoUBGPlus3)
			return UrinalysisResults.PLUSTHREE;
		
		if (enumUbg == GenForm.grpUbgEnumeration.rdoUBGPlus4)
			return UrinalysisResults.PLUSFOUR;
		
		if (enumUbg == GenForm.grpUbgEnumeration.rdoUBGTrace)
			return UrinalysisResults.TRACE;
		
		return null;
	}

	private UrinalysisResults getBilID(grpBilEnumeration enumBil)
	{
		if (enumBil == null)
			return null;
		
		if (enumBil == GenForm.grpBilEnumeration.rdoBILNeg)
			return UrinalysisResults.NEGATIVE;
		
		if (enumBil == GenForm.grpBilEnumeration.rdoBILPlus)
			return UrinalysisResults.PLUSONE;
		
		if (enumBil == GenForm.grpBilEnumeration.rdoBILPlus2)
			return UrinalysisResults.PLUSTWO;
		
		if (enumBil == GenForm.grpBilEnumeration.rdoBILPlus3)
			return UrinalysisResults.PLUSTHREE;
		
		if (enumBil == GenForm.grpBilEnumeration.rdoBILPlus4)
			return UrinalysisResults.PLUSFOUR;
		
		if (enumBil == GenForm.grpBilEnumeration.rdoBILTrace)
			return UrinalysisResults.TRACE;
		
		return null;
	}

	private UrinalysisResults getAscorbicID(grpAscorbicEnumeration enumAscorbic)
	{
		if (enumAscorbic == null)
			return null;
		
		if (enumAscorbic == GenForm.grpAscorbicEnumeration.rdoAscorbicNeg)
			return UrinalysisResults.NEGATIVE;
		
		if (enumAscorbic == GenForm.grpAscorbicEnumeration.rdoAscorbicPlus)
			return UrinalysisResults.PLUSONE;
		
		if (enumAscorbic == GenForm.grpAscorbicEnumeration.rdoAscorbicPlus2)
			return UrinalysisResults.PLUSTWO;
		
		if (enumAscorbic == GenForm.grpAscorbicEnumeration.rdoAscorbicPlus3)
			return UrinalysisResults.PLUSTHREE;
		
		if (enumAscorbic == GenForm.grpAscorbicEnumeration.rdoAscorbicPlus4)
			return UrinalysisResults.PLUSFOUR;
		
		if (enumAscorbic == GenForm.grpAscorbicEnumeration.rdoAscorbicTrace)
			return UrinalysisResults.TRACE;
		
		return null;
	}

	private UrinalysisResults getGluID(grpGluEnumeration enumGlu)
	{
		if (enumGlu == null)
			return null;
		
		if (enumGlu == GenForm.grpGluEnumeration.rdoGLUNeg)
			return UrinalysisResults.NEGATIVE;
		
		if (enumGlu == GenForm.grpGluEnumeration.rdoGLUPlus1)
			return UrinalysisResults.PLUSONE;
		
		if (enumGlu == GenForm.grpGluEnumeration.rdoGLUPlus2)
			return UrinalysisResults.PLUSTWO;
		
		if (enumGlu == GenForm.grpGluEnumeration.rdoGLUPlus3)
			return UrinalysisResults.PLUSTHREE;
		
		if (enumGlu == GenForm.grpGluEnumeration.rdoGLUPlus4)
			return UrinalysisResults.PLUSFOUR;
		
		if (enumGlu == GenForm.grpGluEnumeration.rdoGLUTrace)
			return UrinalysisResults.TRACE;
		
		return null;
	}

	private UrinalysisResults getKetonesID(grpKetonesEnumeration enumKetones)
	{
		if (enumKetones == null)
			return null;
		
		if (enumKetones == GenForm.grpKetonesEnumeration.rdoKetonesNeg)
			return UrinalysisResults.NEGATIVE;
		
		if (enumKetones == GenForm.grpKetonesEnumeration.rdoKetonesPlus1)
			return UrinalysisResults.PLUSONE;
		
		if (enumKetones == GenForm.grpKetonesEnumeration.rdoKetonesPlus2)
			return UrinalysisResults.PLUSTWO;
		
		if (enumKetones == GenForm.grpKetonesEnumeration.rdoKetonesPlus3)
			return UrinalysisResults.PLUSTHREE;
		
		if (enumKetones == GenForm.grpKetonesEnumeration.rdoKetonesPlus4)
			return UrinalysisResults.PLUSFOUR;
		
		if (enumKetones == GenForm.grpKetonesEnumeration.rdoKetonesTrace)
			return UrinalysisResults.TRACE;
		
		return null;
	}

	private UrinalysisResults getBloodID(grpBloodEnumeration enumBlood)
	{
		if (enumBlood == null)
			return null;
		
		if (enumBlood == GenForm.grpBloodEnumeration.rdoBloodNeg)
			return UrinalysisResults.NEGATIVE;
		
		if (enumBlood == GenForm.grpBloodEnumeration.rdoBloodPlus1)
			return UrinalysisResults.PLUSONE;
		
		if (enumBlood == GenForm.grpBloodEnumeration.rdoBloodPlus2)
			return UrinalysisResults.PLUSTWO;
		
		if (enumBlood == GenForm.grpBloodEnumeration.rdoBloodPlus3)
			return UrinalysisResults.PLUSTHREE;
		
		if (enumBlood == GenForm.grpBloodEnumeration.rdoBloodPlus4)
			return UrinalysisResults.PLUSFOUR;
		
		if (enumBlood == GenForm.grpBloodEnumeration.rdoBloodTrace)
			return UrinalysisResults.TRACE;
		
		return null;
	}

	private UrinalysisResults getProteinID(grpProteinEnumeration enumProtein)
	{
		if (enumProtein == null)
			return null;
		
		if (enumProtein == GenForm.grpProteinEnumeration.rdoProteinNeg)
			return UrinalysisResults.NEGATIVE;
		
		if (enumProtein == GenForm.grpProteinEnumeration.rdoProteinPlus1)
			return UrinalysisResults.PLUSONE;
		
		if (enumProtein == GenForm.grpProteinEnumeration.rdoProteinPlus2)
			return UrinalysisResults.PLUSTWO;
		
		if (enumProtein == GenForm.grpProteinEnumeration.rdoProteinPlus3)
			return UrinalysisResults.PLUSTHREE;
		
		if (enumProtein == GenForm.grpProteinEnumeration.rdoProteinPlus4)
			return UrinalysisResults.PLUSFOUR;
		
		if (enumProtein == GenForm.grpProteinEnumeration.rdoProteinTrace)
			return UrinalysisResults.TRACE;
		
		return null;
	}

	private UrinalysisResults getLeucocytesID(grpLeucocytesEnumeration enumLeucocytes)
	{
		if (enumLeucocytes == null)
			return null;
		
		if (enumLeucocytes == GenForm.grpLeucocytesEnumeration.rdoLeucocytesNeg)
			return UrinalysisResults.NEGATIVE;
		
		if (enumLeucocytes == GenForm.grpLeucocytesEnumeration.rdoLeucocytesPlus1)
			return UrinalysisResults.PLUSONE;
	
		if (enumLeucocytes == GenForm.grpLeucocytesEnumeration.rdoLeucocytesPlus2)
			return UrinalysisResults.PLUSTWO;
		
		if (enumLeucocytes == GenForm.grpLeucocytesEnumeration.rdoLeucocytesPlus3)
			return UrinalysisResults.PLUSTHREE;
		
		if (enumLeucocytes == GenForm.grpLeucocytesEnumeration.rdoLeucocytesPlus4)
			return UrinalysisResults.PLUSFOUR;
		
		if (enumLeucocytes == GenForm.grpLeucocytesEnumeration.rdoLeucocytesTrace)
			return UrinalysisResults.TRACE;
		
		return null;
	}

	protected void onBtnCancelClick() throws PresentationLogicException
	{
		open();
		
		form.setMode(FormMode.VIEW);
	}
	
	protected void onBtnUpdateClick() throws PresentationLogicException
	{
		form.chkInactive().setEnabled(true);
		form.setMode(FormMode.EDIT);
		form.btnUpdate().setEnabled(false);
		enableScreen();
		form.setcustomControlAuthoringInfoEnabled(false);
		
		if(form.chkNoSample().getValue() == true)
		{
			form.chkNoSample().setEnabled(false);
			onChkNoSampleValueChanged();
		}
		setMode(true);
			
	}
	
	protected void onBtnNewClick() throws PresentationLogicException
	{
		clearScreen();
		form.customControlAuthoringInfo().initializeComponent();

		form.grpFilterBy().setValue(GenForm.grpFilterByEnumeration.rdoActive);
		
		form.getLocalContext().setVoUrinanalysis(null);
		form.chkNoSample().setValue(false);
		enableScreen();
		
		form.setMode(FormMode.EDIT);
		form.btnUpdate().setEnabled(false);

		form.setcustomControlAuthoringInfoEnabled(true);
		Object mos = domain.getMosUser();
		if(mos != null){
			form.cmbRecordingHCP().newRow((MemberOfStaffLiteVo)mos, mos.toString());
			form.cmbRecordingHCP().setValue((MemberOfStaffLiteVo)mos);
		}
		form.dtimRecordingDateTime().setValue(new DateTime());
	
		setMode(true);
	}

	private void clearScreen()
	{
		clearDetails();	//wdev-13304
		
		form.customControlAuthoringInfo().setValue(null);
		form.dtimRecordingDateTime().setValue(null);//WDEV-12901 
		form.cmbRecordingHCP().setValue(null);//WDEV-12901
	}

	//WDEV-13304
	private void clearDetails() 
	{
		setRadioGroupDefaults();
		
		form.chkInactive().setValue(false);
		form.chkNoAbnormality().setValue(false);
		form.cmbPH().setValue(null);
		form.decSpecificGravity().setValue(null);
		form.timRecords().setValue(null);
		form.dteRecords().setValue(null);
		
		// disable inactive button
		form.chkInactive().setEnabled(false);
	}

	protected void onChkNoSampleValueChanged()
	{
		boolean b = form.chkNoSample().getValue();
		
		clearDetails();
		
		form.grpLeucocytes().setEnabled(!b);
		form.grpProtein().setEnabled(!b);
		form.grpBlood().setEnabled(!b);
		form.grpKetones().setEnabled(!b);
		form.grpGlu().setEnabled(!b);
		form.grpAscorbic().setEnabled(!b);
		form.grpBil().setEnabled(!b);
		form.grpUbg().setEnabled(!b);
		form.grpNitrate().setEnabled(!b);
		form.cmbPH().setEnabled(!b);
		form.decSpecificGravity().setEnabled(!b);
		form.chkInactive().setEnabled(!b);		
		form.chkNoAbnormality().setEnabled(!b);
	}

	protected void onFormModeChanged() 
	{
		boolean bEnabled = false;
		
		if(form.getMode().equals(FormMode.EDIT))
			bEnabled = true;
		else if(form.getMode().equals(FormMode.VIEW))
			bEnabled = false;
		
		form.customControlAuthoringInfo().setIsRequiredPropertyToControls(bEnabled);//WDEV-17261
		
		form.grpLeucocytes().setEnabled(bEnabled);
		form.grpProtein().setEnabled(bEnabled);
		form.grpBlood().setEnabled(bEnabled);
		form.grpKetones().setEnabled(bEnabled);
		form.grpGlu().setEnabled(bEnabled);
		form.grpAscorbic().setEnabled(bEnabled);
		form.grpBil().setEnabled(bEnabled);
		form.grpUbg().setEnabled(bEnabled);
		form.grpNitrate().setEnabled(bEnabled);

		form.cmbPH().setEnabled(bEnabled);
		form.decSpecificGravity().setEnabled(bEnabled);
		form.chkInactive().setEnabled(bEnabled);
		form.chkNoAbnormality().setEnabled(bEnabled);		
	}
}
