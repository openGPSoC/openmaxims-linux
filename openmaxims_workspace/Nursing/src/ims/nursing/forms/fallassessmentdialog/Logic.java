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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.20 build 40813.1400)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.fallassessmentdialog;

import ims.nursing.forms.fallassessmentdialog.GenForm.grdRiskAssessmentRow;
import ims.coe.vo.RiskAssessment;
import ims.coe.vo.RiskAssessmentCollection;
import ims.coe.vo.RiskDescription;
import ims.coe.vo.AssessmentMobility;
import ims.coe.vo.FallAssessment;
import ims.coe.vo.FallAssessmentDetails;
import ims.coe.vo.FallAssessmentDetailsCollection;
import ims.core.vo.HcpLiteVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;
import ims.nursing.vo.AssessmentComponent;


public class Logic extends BaseLogic
{
	protected void onBtnCancelClick() throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	protected void onBtnSaveClick() throws PresentationLogicException
	{
		if(bCheckData() == false)
			return;
		
		FallAssessment record = form.getGlobalContext().COE.getCurrentFallRiskAssessment();
		
		if(record == null)
		{
			//new
			record = populateDataFromScreen();
		}
		else
		{
			//update
			record = populateDataFromScreen(record);
		}	

		if(record == null)
			return;
		
		record.setAssessmentDetails(new FallAssessmentDetailsCollection());
		
		for (int i = 0; i < form.grdRiskAssessment().getRows().size(); i++)
		{
			GenForm.grdRiskAssessmentRow row = form.grdRiskAssessment().getRows().get(i);
			
			for (int j = 0; j < row.getRows().size(); j++)
			{
				GenForm.grdRiskAssessmentRow child = row.getRows().get(j);

				FallAssessmentDetails detail = new FallAssessmentDetails();
				detail.setAssessment(new Integer(child.getValue()));
				detail.setSelect(new Boolean(child.getSelect()));

				record.getAssessmentDetails().add(detail);
			}
		}
		
		if (record.getClinicalContact() == null)
			record.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		if (record.getCareContext() == null)
			record.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		String[] errors = record.validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return;
		}	

		try
		{
			AssessmentMobility comp = form.getGlobalContext().COE.getAssessmentMobility();
			comp = domain.saveRecord(record, comp);
			if(comp!=null){
				form.getGlobalContext().COE.setAssessmentMobility(comp);
			}
		}
		catch (StaleObjectException e) 
		{
			form.getGlobalContext().Core.setYesNoDialogMessage("The fall assessment record was updated by another user. Screen will be refreshed.");
			engine.open(form.getForms().Core.OkDialog, "Data Warning");			
			return;
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return;
		}
		
		if(form.getGlobalContext().COE.getDisplayScoreIsNotNull() && form.getGlobalContext().COE.getDisplayScore().equals(Boolean.TRUE))
		{
			float fScore = getAssessmentScore();
			form.getGlobalContext().COE.setAssessmentScore(new Float(fScore));
		}
		
		engine.close(DialogResult.OK);
	}

	private boolean bCheckData()
	{
		for (int i = 0; i < form.grdRiskAssessment().getRows().size(); i++)
		{
			GenForm.grdRiskAssessmentRow row = form.grdRiskAssessment().getRows().get(i);
			
			if(row.getValue().equalsIgnoreCase("N"))
			{
				int nFound = 0;
				for (int j = 0; j < row.getRows().size(); j++)
				{
					GenForm.grdRiskAssessmentRow child = row.getRows().get(j);
					
					if(child.getSelect() == true)
						nFound++;
				}
				
				if(nFound > 1)
				{
					engine.showMessage("The answers for risk factor '" + row.getRisk() + "' are mutually exclusive. Please select only one answer.");
					return false;
				}
			}
		}
		
		return true;
	}
	protected void onFormOpen() throws FormOpenException
	{
		RiskAssessmentCollection risks = form.getGlobalContext().COE.getFallRiskAssessments();
		
		if(risks == null)
		{
			engine.showMessage("Could not retrieve the Fall Assessments !");
			return;
		}
		
		FallAssessment fall = form.getGlobalContext().COE.getCurrentFallRiskAssessment();
		
		form.grdRiskAssessment().getRows().clear();
		for(int i = 0; i < risks.size(); i++)
		{
			RiskAssessment risk = risks.get(i);
			
			GenForm.grdRiskAssessmentRow row = form.grdRiskAssessment().getRows().newRow();
			
			row.setRisk(risk.getName());
			row.setBold(true);
			row.setBackColor(Color.Beige);
			row.setValue(risk.getMultiple().booleanValue() == true ? "Y" : "N");
			
			for (int j = 0; j < risk.getRiskFactors().size(); j++)
			{
				GenForm.grdRiskAssessmentRow child = row.getRows().newRow();
				
				RiskDescription descr = risk.getRiskFactors().get(j);
				
				child.setRisk(descr.getName());
				child.setValue(descr.getId());
				
				if(risk.getName().equalsIgnoreCase("Sex"))
				{
					if(descr.getId().equals("1") && form.getGlobalContext().Core.getPatientShort().getSex()!= null && form.getGlobalContext().Core.getPatientShort().getSex().getText().startsWith("M"))
						child.setSelect(true); //male
					else
					if(descr.getId().equals("2") && form.getGlobalContext().Core.getPatientShort().getSex()!= null && form.getGlobalContext().Core.getPatientShort().getSex().getText().startsWith("F"))
						child.setSelect(true); //female
				}
				else
				if(risk.getName().equalsIgnoreCase("Age"))
				{
					if(descr.getId().equals("3") && form.getGlobalContext().Core.getPatientShort().getAgeIsNotNull()
							&& form.getGlobalContext().Core.getPatientShort().getAge().intValue() >= 60  && form.getGlobalContext().Core.getPatientShort().getAge().intValue() < 71)
						child.setSelect(true); //60-70
					else if(descr.getId().equals("4") && form.getGlobalContext().Core.getPatientShort().getAgeIsNotNull()
							&& form.getGlobalContext().Core.getPatientShort().getAge().intValue() >= 71  && form.getGlobalContext().Core.getPatientShort().getAge().intValue() < 81)
						child.setSelect(true); //71-80
					else if(descr.getId().equals("5") && form.getGlobalContext().Core.getPatientShort().getAgeIsNotNull()
							&& form.getGlobalContext().Core.getPatientShort().getAge().intValue() >= 81)
						child.setSelect(true); //81+
				}
				
				if(fall != null)
				{
					//update mode
					for(int k = 0; k < fall.getAssessmentDetails().size(); k++)
					{
						if(descr.getId().equals(fall.getAssessmentDetails().get(k).getAssessment().toString()))
						{
							child.setSelect(fall.getAssessmentDetails().get(k).getSelect().booleanValue());
							break;
						}
					}
				}
			}
			
			row.setExpanded(true);
		}
		
		form.grdRiskAssessment().setReadOnly(false);
		
		if(fall == null)
		{
			form.dteDate().setValue(new Date());
			form.timTime().setValue(new Time());

			Object hcpLite = domain.getHcpLiteUser();
			form.getLocalContext().setHcp(hcpLite != null ? ((HcpLiteVo)hcpLite) : null);
			
			if(form.getLocalContext().getHcp() != null)
				form.txtHcp().setValue(form.getLocalContext().getHcp().getName().toString());
		}
		else
		{
			form.dteDate().setValue(fall.getDateTimeInitiated().getDate());
			form.timTime().setValue(fall.getDateTimeInitiated().getTime());
			
			if(fall.getHcpInitiated() != null && fall.getHcpInitiated().getName() != null)
				form.txtHcp().setValue(fall.getHcpInitiated().getName().toString());
		}
		
		// If there is an associated mobility component for this assessment that is complete
		// we want to disable the save button
		AssessmentComponent comp = form.getGlobalContext().COE.getAssessmentMobility();
		if (comp != null && comp.getIsComplete().booleanValue() == true)
		{
			form.btnSave().setEnabled(false);
			form.grdRiskAssessment().setReadOnly(true);
		}

		//if age is already set then we disable all Age grid checkboxes
		disableAgeTree();
		
		//we can update a Fall record which belongs to an Mobility assessment via Mobility assessment page only  
		if(form.getGlobalContext().COE.getCurrentFallRiskAssessmentIsNotNull() && comp == null)
		{
			Boolean bIsPart = null;
			
			try
			{
				bIsPart = domain.isPartOfMobilityAssessment(form.getGlobalContext().COE.getCurrentFallRiskAssessment());
			} catch (DomainInterfaceException e1)
			{
				engine.showMessage("Error retrieving mobility assessment record: " + e1.getMessage());
				return;
			}

			if(bIsPart == Boolean.TRUE)
			{
				form.btnSave().setEnabled(false);
				form.grdRiskAssessment().setReadOnly(true);
			}
		}
	
	}
	protected void onGrdRiskAssessmentGridCheckBoxClicked(int column,
			grdRiskAssessmentRow row, boolean isChecked)
	{
		if(isChecked == true)
		{
			if(row.getParentRow().getValue().equals("N"))
			{
				for(int i = 0; i < row.getParentRow().getRows().size(); i++)
				{
					if(row.getParentRow().getRows().get(i).getValue().equals(row.getValue()) == false)
						row.getParentRow().getRows().get(i).setSelect(false);
				}
			}
		}
	}
	
	protected void populateScreenFromData(ims.coe.vo.FallAssessment value)
	{
		super.populateScreenFromData(value);
	}
	
	protected void clearScreen()
	{
		super.clearScreen();
	}

	protected FallAssessment populateDataFromScreen()
	{
		FallAssessment record = super.populateDataFromScreen();
		
		if(form.getLocalContext().getHcp() != null)
			record.setHcpInitiated(form.getLocalContext().getHcp());
		
		if (record.getClinicalContact() == null)
			record.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		if (record.getCareContext() == null)
			record.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		record.setDateTimeInitiated(new DateTime(form.dteDate().getValue(), form.timTime().getValue()));

		return record;
	}
	
	protected FallAssessment populateDataFromScreen(FallAssessment value)
	{
		FallAssessment record = super.populateDataFromScreen(value);

		//we keep the original HCP
		//if(form.getLocalContext().getHcp() != null)
			//record.setHcpInitiated(form.getLocalContext().getHcp());
		
		record.setDateTimeInitiated(new DateTime(form.dteDate().getValue(), form.timTime().getValue()));
		
		return record;
	}
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if (formName.equals(form.getForms().Core.OkDialog))
			engine.close(DialogResult.OK);		
	}

	private float getAssessmentScore()
	{
		float nScore = 0;

		RiskAssessment risk = null;
		RiskDescription descr = null;

		float partScore;
		for (int i = 0; i < form.grdRiskAssessment().getRows().size(); i++)
		{
			GenForm.grdRiskAssessmentRow row = form.grdRiskAssessment().getRows().get(i);

			risk = null;
			partScore = 0;
			
			for (int j = 0; j < row.getRows().size(); j++)
			{
				GenForm.grdRiskAssessmentRow child = row.getRows().get(j);
				
				for(int k = 0; k < form.getGlobalContext().COE.getFallRiskAssessments().size(); k++)
				{
					risk = form.getGlobalContext().COE.getFallRiskAssessments().get(k);
					
					for(int m = 0; m < risk.getRiskFactors().size(); m++)
					{
						descr = risk.getRiskFactors().get(m);
						
						if(child.getValue().toString().equals(descr.getId()) && child.getSelect() == true)
						{
							partScore += Float.valueOf(descr.getScore()).floatValue();
						}
					}
				}
			}
			
			nScore += partScore;
		}
		
		return nScore;
	}
	
	private void disableAgeTree()
	{
		for (int i = 0; i < form.grdRiskAssessment().getRows().size(); i++)
		{
			GenForm.grdRiskAssessmentRow row = form.grdRiskAssessment().getRows().get(i);

			boolean bFound = false;
			for (int j = 0; j < row.getRows().size(); j++)
			{
				GenForm.grdRiskAssessmentRow child = row.getRows().get(j);
			
				if(child.getValue().equals("3") && child.getSelect())
				{
					bFound = true;
					break;
				}
				if(child.getValue().equals("4") && child.getSelect())
				{
					bFound = true;
					break;
				}
				if(child.getValue().equals("5") && child.getSelect())
				{
					bFound = true;
					break;
				}
			}
			
			if(bFound == true)
			{
				for (int j = 0; j < row.getRows().size(); j++)
				{
					GenForm.grdRiskAssessmentRow child = row.getRows().get(j);
					child.setReadOnly(true);
				}	
				
				break;
			}
		}
	}
	
}
