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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.20 build 40806.900)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.vitalsignsrespiration;

import ims.core.vo.VSRespirations;
import ims.core.vo.VitalSignsVo;
import ims.core.vo.VitalSignsVoCollection;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateFormat;
import ims.framework.utils.graphing.GraphingPoint;
import ims.framework.utils.graphing.GraphingPointType;
import ims.framework.utils.graphing.GraphingRespiration;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		//WDEV-14429
		if(isVitalSignsRespirationForTriage())
		{
			form.setMode(FormMode.VIEW);
		}
		
		form.grpShowBy().setValue(GenForm.grpShowByEnumeration.rdoDay); 
		form.btnUpdate().setEnabled(false);
		//form.btnPrint().setEnabled(false);

		//WDEV-7526
		if(form.getGlobalContext().Core.getIdForm() != null && form.getGlobalContext().Core.getIdForm().equals(form.getForms().Core.BaselineObservations.getID()))
		{
			form.lnkReturn().setTooltip("Return to Baseline Observations");
		}
		else
		{
			form.lnkReturn().setTooltip("Return to Vital Signs");
		}
		//ends here 
		
		if(form.getGlobalContext().Core.getVitalSign() != null  && form.getGlobalContext().Core.getVitalSign().getRespiratory() != null)
		{
			form.dteShowByDay().setValue(form.getGlobalContext().Core.getVitalSign().getVitalsTakenDateTime() != null ? form.getGlobalContext().Core.getVitalSign().getVitalsTakenDateTime().getDate() : null);//	WDEV-13117
			form.getLocalContext().setvitalSign(form.getGlobalContext().Core.getVitalSign());
			displayRecord(form.getGlobalContext().Core.getVitalSign());
			form.btnUpdate().setEnabled(true);
			//form.btnPrint().setEnabled(true);
			listRespirations();	
		}
		else
		{
			try {
				onRadioButtongrpShowByValueChanged();
			} catch (PresentationLogicException e) {
				throw new DomainRuntimeException();
			}
		}

		updatePrevNextButtons();
		dateIntervalStatus();//	WDEV-13117
	}
	
	private void listRespirations() 
	{
		VitalSignsVoCollection voCollVitals = null;
		String subTitle = "";
		
		if(form.grpShowBy().getValue().equals(GenForm.grpShowByEnumeration.rdoDay))
		{
			voCollVitals = domain.listRespiration(form.dteShowByDay().getValue(),form.getGlobalContext().Core.getCurrentCareContext()); 
			subTitle = "Respirations for " + form.dteShowByDay().getValue().toString(DateFormat.STANDARD);
		}
		else
		{
			voCollVitals = domain.listRespiration(form.dteFrom().getValue(),form.dteTo().getValue(),form.getGlobalContext().Core.getCurrentCareContext());
			subTitle = "Respirations between " + form.dteFrom().getValue().toString(DateFormat.STANDARD) + " - " +  form.dteTo().getValue().toString(DateFormat.STANDARD);
		}
 
		form.lblRespiration().setValue(subTitle);
		form.grhRespiration().clearAllPoints();
		
		form.grhRespiration().showYAxisValues();
		
		form.grhRespiration().setPrintHeaderInfo(subTitle + "\r\n" + form.getGlobalContext().Core.getPatientShort().getPatientInfo());

		VitalSignsVo voVitalSign;
		GraphingRespiration point;
		if(voCollVitals != null)
		{
			voCollVitals.sort(SortOrder.ASCENDING);
			
			int nIndex = voCollVitals.size() - 1;

			for(int i=0;i<voCollVitals.size();i++)
			{
				voVitalSign = voCollVitals.get(i);
				point = new GraphingRespiration(voVitalSign.getVitalsTakenDateTime(),  voVitalSign.getRespiratory().getRespRate(),  voVitalSign);
				form.grhRespiration().addPoint(point);		
				
				if(form.getGlobalContext().Core.getVitalSignIsNotNull() && //WDEV-12943
						form.getGlobalContext().Core.getVitalSign().getID_VitalSignsIsNotNull() &&//WDEV-12943
					voVitalSign.getID_VitalSigns().intValue() == form.getGlobalContext().Core.getVitalSign().getID_VitalSigns().intValue())
					nIndex = i;
			}
						
			form.getLocalContext().setRespirations(voCollVitals);
			form.getLocalContext().setCurrentIndex(new Integer(nIndex));
			displayCurrentRespiration();
		}
		else
		{
			form.btnNext().setEnabled(false);
			form.btnPrev().setEnabled(false);
			form.getLocalContext().setRespirations(null);
			form.btnUpdate().setEnabled(false);
			//form.btnPrint().setEnabled(false);
		}
		
	}
	
	private void displayCurrentRespiration()
	{
		VitalSignsVoCollection voMetrics = form.getLocalContext().getRespirations();
		Integer nIndex = form.getLocalContext().getCurrentIndex();
		
		if(voMetrics == null || nIndex == null || nIndex.intValue() == -1 || nIndex.intValue() >= voMetrics.size())
			return;

		form.getLocalContext().setvitalSign(voMetrics.get(nIndex.intValue()));
		displayRecord(voMetrics.get(nIndex.intValue()));
		
		updatePrevNextButtons();
	}

	private void updatePrevNextButtons()
	{
		VitalSignsVoCollection voMetrics = form.getLocalContext().getRespirations();
		Integer nIndex = form.getLocalContext().getCurrentIndex();

		form.btnNext().setEnabled(true);
		form.btnPrev().setEnabled(true);
		
		if(voMetrics == null || nIndex == null)
		{
			form.btnNext().setEnabled(false);
			form.btnPrev().setEnabled(false);
			return;
		}
		
		if(nIndex.intValue() <= 0)
			form.btnPrev().setEnabled(false);

		if(nIndex.intValue() >= voMetrics.size() - 1)
			form.btnNext().setEnabled(false);
	}

	protected void onBtnUpdateClick() throws PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		form.btnUpdate().setEnabled(false);	
		//form.btnPrint().setEnabled(false);
		form.dteShowByDay().setEnabled(false);
		form.dteFrom().setEnabled(false);
		form.dteTo().setEnabled(false);
		
		form.btnPrev().setEnabled(false);
		form.btnNext().setEnabled(false);
	}

	protected void onBtnCancelClick() throws PresentationLogicException
	{
		displayRecord(form.getLocalContext().getvitalSign());
		form.setMode(FormMode.VIEW);
		
		dateIntervalStatus();
		updatePrevNextButtons();
	}

	private void dateIntervalStatus()
	{
		form.dteShowByDay().setEnabled(GenForm.grpShowByEnumeration.rdoDay.equals(form.grpShowBy().getValue()));	//WDEV-13117
		
		form.dteFrom().setEnabled(!GenForm.grpShowByEnumeration.rdoDay.equals(form.grpShowBy().getValue()));	//WDEV-13117
		form.dteTo().setEnabled(!GenForm.grpShowByEnumeration.rdoDay.equals(form.grpShowBy().getValue()));	//WDEV-13117
	}

	protected void onBtnSaveClick() throws PresentationLogicException 
	{
		VitalSignsVo voVitalSign = form.getLocalContext().getvitalSign();

		VSRespirations voResp = new VSRespirations();

		voResp.setRespRate(form.intResRate().getValue());

		voVitalSign.setRespiratory(voResp);
		
		String[] arrErrors = voVitalSign.validate();
		if(arrErrors == null)
		{
			try {
				domain.modifyRespiration(voVitalSign);
			} catch (StaleObjectException e) {
				engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				refresh();
				return;
			}
		}
		else
		{
			engine.showErrors("Validation Errors", arrErrors);
			return;	
		}

		form.setMode(FormMode.VIEW);
		
		listRespirations();
		//form.btnUpdate().setEnabled(false);
		
		form.getLocalContext().setvitalSign(voVitalSign);
		displayRecord(form.getLocalContext().getvitalSign());
		
		dateIntervalStatus();
	}

	private void clearFields() 
	{
		form.intResRate().setValue(null);
		form.dteTaken().setValue(null);
		form.timTaken().setValue(null);
		form.txtHCP().setValue("");
	}

	protected void onRadioButtongrpShowByValueChanged() throws PresentationLogicException 
	{
		if(form.grpShowBy().getValue().equals(GenForm.grpShowByEnumeration.rdoDay))
		{
			form.dteShowByDay().setEnabled(true);
			form.dteShowByDay().setValue(new Date());
			form.dteFrom().setEnabled(false);
			form.dteTo().setEnabled(false);
			form.dteFrom().setValue(null);
			form.dteTo().setValue(null);
		}
		else
		{
			form.dteShowByDay().setEnabled(false);
			form.dteShowByDay().setValue(null);
			form.dteFrom().setEnabled(true);
			form.dteTo().setEnabled(true);
			form.dteFrom().setValue(new Date());
			form.dteTo().setValue(new Date());
		}
		
		onBtnViewClick();
	}


	protected void onBtnPrintClick() throws PresentationLogicException 
	{
		
	}

	protected void onBtnViewClick() throws PresentationLogicException
	{
		if(form.grpShowBy().getValue().equals(GenForm.grpShowByEnumeration.rdoDay))
		{
			if(form.dteShowByDay().getValue() == null)
			{
				engine.showMessage("Please enter a date to show by");
				return;
			}
		}
		else
		{
			if(form.dteFrom().getValue() == null || form.dteTo().getValue() == null)
			{
				engine.showMessage("Please enter a date range (From and To) to show by");
				return;				
			}
			if(form.dteFrom().getValue().isGreaterThan(form.dteTo().getValue()))
			{
				engine.showMessage("The date From entered cannot be greater than the date To entered");
				return;
			}
		}

		clearFields();
		listRespirations();			
	}

	private void displayRecord(VitalSignsVo voVitalSign)
	{
		clearFields();
		form.intResRate().setValue(voVitalSign.getRespiratory().getRespRate());
		form.dteTaken().setValue(voVitalSign.getVitalsTakenDateTime().getDate());
		form.timTaken().setValue(voVitalSign.getVitalsTakenDateTime().getTime());
		form.txtHCP().setValue(voVitalSign.getAuthoringInformation().getAuthoringHcp().toString());
		
		form.btnUpdate().setEnabled(true);
		//form.btnPrint().setEnabled(true);
	}
	
	private void refresh()
	{
		clearFields();
		listRespirations();
		form.setMode(FormMode.VIEW);
	}
	
	protected void onGrhRespirationPointClicked(GraphingPoint point) 
	{
		if(point.getType() == GraphingPointType.RESPIRATION)
		{ 			
			GraphingRespiration pointResp = (GraphingRespiration)point;
			form.getLocalContext().setvitalSign((VitalSignsVo)pointResp.getTag());
			displayRecord((VitalSignsVo)pointResp.getTag());
			form.btnUpdate().setEnabled(true);
			//form.btnPrint().setEnabled(true);
			
			//update the Prev/Next buttons
			VitalSignsVoCollection voTemperatures = form.getLocalContext().getRespirations();
			for(int i = 0; i < voTemperatures.size(); i++)
			{
				if(form.getLocalContext().getvitalSign().getID_VitalSigns().intValue() == voTemperatures.get(i).getID_VitalSigns().intValue())
				{
					form.getLocalContext().setCurrentIndex(new Integer(i));
					updatePrevNextButtons();
					break;
				}
			}
		}	
	}
	
	
	protected void onBtnNextClick() throws PresentationLogicException
	{
		Integer nIndex = form.getLocalContext().getCurrentIndex();
		form.getLocalContext().setCurrentIndex(new Integer(nIndex.intValue() + 1));
		displayCurrentRespiration();
	}
	protected void onBtnPrevClick() throws PresentationLogicException
	{
		Integer nIndex = form.getLocalContext().getCurrentIndex();
		form.getLocalContext().setCurrentIndex(new Integer(nIndex.intValue() - 1));
		displayCurrentRespiration();
	}
	
	protected void onLnkReturnClick() throws PresentationLogicException 
	{
		//WDEV-14429
		if(isVitalSignsRespirationForTriage())
		{
			engine.close(DialogResult.OK);
			return;
		}
		
		//WDEV-7526
		if(form.getGlobalContext().Core.getIdForm() != null && form.getGlobalContext().Core.getIdForm().equals(form.getForms().Core.BaselineObservations.getID()))
		{
			engine.open(form.getForms().Core.BaselineObservations);
			
		}
		//ends here
		
		else if(form.getGlobalContext().Core.getIdForm() != null && form.getGlobalContext().Core.getIdForm().equals(form.getForms().Core.VitalSignsBaselineAndAll.getID()))
			engine.open(form.getForms().Core.VitalSignsBaselineAndAll);
		else
			engine.open(form.getForms().Core.VitalSignsAll);
	}

	//WDEV-14429
	private boolean isVitalSignsRespirationForTriage()
	{
		if(engine.getFormName().equals(form.getForms().Core.VitalSignsRespirationForTriage))
			return true;
		
		return false;
	}
}
