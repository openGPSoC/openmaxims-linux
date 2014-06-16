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
// This code was generated by John Pearson using IMS Development Environment (version 1.18 build 40630.1415)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.careplanevaluation;
import ims.nursing.vo.CarePlan;
import ims.nursing.vo.CarePlanEvaluationNote;
import ims.nursing.vo.CarePlanStatus;
import ims.nursing.vo.CarePlanStatusCollection;
import ims.nursing.vo.lookups.LookupHelper;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.NurseVo;
import ims.core.vo.PersonName;
import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.lookups.HcpDisType;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		form.dDate().setValue(new Date());
		form.tTime().setValue(new Time());

		ims.nursing.vo.lookups.CarePlanStatusCollection careplanlookupColl = LookupHelper.getCarePlanStatus(domain.getLookupService());
		ims.nursing.vo.lookups.CarePlanStatus careplanStatusLookup;
		for(int x=0; x<careplanlookupColl.size(); x++)
		{
			careplanStatusLookup = careplanlookupColl.get(x); 
			
			if(!careplanStatusLookup.equals(ims.nursing.vo.lookups.CarePlanStatus.ALL)
					&& !careplanStatusLookup.equals(ims.nursing.vo.lookups.CarePlanStatus.ALL_ADMISSIONS))//	WDEV-13535
			{
				form.cmbCarePlanStatus().newRow(careplanStatusLookup,careplanStatusLookup.toString());
			}
		}

		MemberOfStaffShortVo memStaffShortVo = (MemberOfStaffShortVo)domain.getMosUser();
		if (memStaffShortVo != null) 
			form.textEvaluatedBy().setValue((memStaffShortVo).toString());
			
		form.cmbCarePlanStatus().setValue(form.getGlobalContext().COE.getCarePlan().getCurrentCarePlanStatus().getStatus());
		
		//Default ConfirmForStudentNurse local context value
		form.getLocalContext().setConfirmForStudentNurse(Boolean.FALSE);
		
		//By default hide the Care as Planned check box
		if(ConfigFlag.UI.CAREPLAN_CARE_AS_PLANNED.getValue())
		{
			form.chkCareAsPlanned().setVisible(true);
			form.chkCareAsPlanned().setEnabled(true);
		}
		else
		{
			form.chkCareAsPlanned().setVisible(false);
			form.chkCareAsPlanned().setEnabled(false);
		}
		
		if (form.cmbCarePlanStatus().getValue().equals(ims.nursing.vo.lookups.CarePlanStatus.ACTIVE)) 
			form.dateNextEvaluation().setRequired(true);
		
		form.textEvaluationNotes().setRequired(ConfigFlag.GEN.CARE_PLAN_FUNCTIONALITY_TYPE.getValue().toString().equals("CCO") ? false : true);//wdev-13781

		//all specific to Middlesborough
		if(ims.configuration.gen.ConfigFlag.UI.CONFIRM_FOR_STUDENT_NURSE.getValue())
		{
			boolean bShow = false;
			
			if (memStaffShortVo != null && memStaffShortVo.getHcp() != null) 
			{
				ims.core.vo.Hcp nurse;
				
				HcpFilter filter = new HcpFilter();
				filter.setID_Hcp(memStaffShortVo.getHcp().getID_Hcp());
				nurse = domain.getHcp(filter);
				
				if(nurse instanceof NurseVo)
				{
					if(((NurseVo)nurse).getNurseType() != null)
					{
						if(((NurseVo)nurse).getNurseType().equals(HcpDisType.STUDENTNURSE))
						{	
							bShow = true;
							form.getLocalContext().setConfirmForStudentNurse(Boolean.TRUE);
						}
					}
				}	
			}	
			else
			{
				bShow = false;
				form.getLocalContext().setConfirmForStudentNurse(Boolean.FALSE);
			}
			
			form.qmbConfirmedBy().setVisible(bShow);
			form.dateConfirmed().setVisible(bShow);
			form.timeConfirmed().setVisible(bShow);
			form.labelConfirmedBy().setVisible(bShow);
			form.labelConfirmedDateTime().setVisible(bShow);
			
			/*if (bShow)
			{
				form.dateConfirmed().setValue(new Date());
				form.timeConfirmed().setValue(new Time());
			}*/
			
		}
		if (ims.configuration.gen.ConfigFlag.UI.CAREPLAN_CONFIRMED_BY_DETAILS.getValue())
		{
			form.dateConfirmed().setVisible(true);
			form.qmbConfirmedBy().setVisible(true);
			form.timeConfirmed().setVisible(true);
			form.labelConfirmedDateTime().setVisible(true);
			form.labelConfirmedBy().setVisible(true);
		}
		else
		{
			form.dateConfirmed().setVisible(false);
			form.qmbConfirmedBy().setVisible(false);
			form.timeConfirmed().setVisible(false);
			form.labelConfirmedDateTime().setVisible(false);
			form.labelConfirmedBy().setVisible(false);
		}
	}
	
	protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().COE.setCarePlanEvaluation(null);
		engine.close(DialogResult.CANCEL);		
	}
	
	protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		Object Object = domain.getHcpLiteUser();
		HcpLiteVo hcpLiteVo = Object!=null?(HcpLiteVo)Object:null;
		
		if(!validateUserInput())
			return;
		
		CarePlanEvaluationNote eval = form.getLocalContext().getEvaluation();
		if (eval == null)
		{
			eval = new CarePlanEvaluationNote();	
			if(hcpLiteVo != null)
				eval.setRecordedBy(hcpLiteVo);
		}
		eval.setRecordedDateTime(new DateTime(form.dDate().getValue(),form.tTime().getValue()));
		if (form.getLocalContext().getConfirmForStudentNurse().booleanValue())
			eval.setNextEvaluationDate(form.dateNextEvaluation().getValue());
		else
			eval.setNextEvaluationDate(form.dateNextEvaluation().getValue());
		
		eval.setNote(form.textEvaluationNotes().getValue());
		eval.setActive(new Boolean(true));
		form.getGlobalContext().COE.setCarePlanEvaluation(eval);
		eval.setCarePlan(form.getGlobalContext().COE.getCarePlan());
		
		if (form.getLocalContext().getConfirmForStudentNurse().booleanValue())
		{
			eval.setConfirmedBy(form.qmbConfirmedBy().getValue());
			
			eval.setConfirmedDateTime(new DateTime(form.dateConfirmed().getValue(), form.timeConfirmed().getValue()));
		}
			
		CarePlanStatus status = new CarePlanStatus();
		status.setHCP(hcpLiteVo);
		
		status.setDateTime(new DateTime(form.dDate().getValue(),form.tTime().getValue()));
		status.setStatus(form.cmbCarePlanStatus().getValue());
		
		CarePlan voCarePlan = form.getGlobalContext().COE.getCarePlan();
		if(voCarePlan != null)
		{
			voCarePlan.setNextEvaluationDate(eval.getNextEvaluationDate());
			
			//WDEV-15133 - starts here
			if(voCarePlan.getCurrentCarePlanStatus() == null || (voCarePlan.getCurrentCarePlanStatus().getStatus() != null && !voCarePlan.getCurrentCarePlanStatus().getStatus().equals(status.getStatus())))//	WDEV-15220
			{
				voCarePlan.setCurrentCarePlanStatus(status);
			
				CarePlanStatusCollection statusHistory = voCarePlan.getCarePlanStatus();
			
				if(statusHistory == null)
					statusHistory = new CarePlanStatusCollection();
			
				statusHistory.add(status);
				voCarePlan.setCarePlanStatus(statusHistory);
			}
			//WDEV-15133 - ends here
			
			form.getGlobalContext().COE.setCarePlan(voCarePlan);
		}
	
		String[] arrErrors = voCarePlan.validate();
		if (arrErrors != null)
		{
			engine.showErrors("Validation Errors", arrErrors);
			return;
		}
		
		arrErrors = eval.validate();
		if (arrErrors != null)
		{
			engine.showErrors("Validation Errors", arrErrors);
			return;
		}
		
		try 
		{
			domain.saveEvaluationNote(eval);
			form.getGlobalContext().COE.setCarePlan(domain.saveCarePlan(voCarePlan));
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.CANCEL);
			return;
		}
			
		engine.close(DialogResult.OK);
	}
	
	boolean validateUserInput()
	{
		if(form.dDate().getValue() == null)
		{
			engine.showMessage("Please enter the Date.");
			return false;
		}
		//wdev-14915
		if(	ims.configuration.gen.ConfigFlag.DOM.CAREPLAN_NEXT_EVALUTION_DATE_VALIDATION.getValue() != 0 )
		{
			Date dateT = new Date();
			dateT.addDay(ims.configuration.gen.ConfigFlag.DOM.CAREPLAN_NEXT_EVALUTION_DATE_VALIDATION.getValue());
			if( form.dateNextEvaluation().getValue() != null && form.dateNextEvaluation().getValue().isGreaterThan(dateT))
			{
				engine.showMessage("Next Evaluation Date exceeds " +ims.configuration.gen.ConfigFlag.DOM.CAREPLAN_NEXT_EVALUTION_DATE_VALIDATION.getValue()+" day policy!" ); //WDEV-15275
				return false;
			}
		}
		//---------------
		if(form.tTime().getValue() == null)
		{
			engine.showMessage("Please enter the Time.");
			return false;
		}	

		if (form.cmbCarePlanStatus().getValue() == null )
		{
			engine.showMessage("Please enter the Care Plan Status.");
			return false;			
		}
		
		if (form.cmbCarePlanStatus().getValue().equals(ims.nursing.vo.lookups.CarePlanStatus.ACTIVE) && form.dateNextEvaluation().getValue() == null)
		{
			engine.showMessage("Please enter the Next Evaluation Date.");
			return false;
		}	
		
		if(form.dateNextEvaluation().getValue() != null)
		{
			Date today = new Date();
			if(form.dateNextEvaluation().getValue().isLessThan(today))
			{
				engine.showMessage("The Next Evaluation Date cannot be in the past.");
				return false;
			}
		}

		if (form.textEvaluationNotes().getValue() == null
			&& ! ConfigFlag.GEN.CARE_PLAN_FUNCTIONALITY_TYPE.getValue().toString().equals("CCO"))//wdev-13781
		{
			engine.showMessage("Please enter an Evaluation Note.");
			return false;
		}
		
		if(form.qmbConfirmedBy().getVisible())
		{
			if(form.qmbConfirmedBy().getValue() == null)
			{
				Hcp voHcp = (Hcp) domain.getHcpUser();
				if(voHcp != null)
				{
					if(HcpDisType.NURSING.equals(voHcp.getHcpType())) //WDEV-17953
					{
						NurseVo voNurse  = (NurseVo) voHcp;
						if (voNurse.getNurseTypeIsNotNull())
							if(voNurse.getNurseType().equals(HcpDisType.STUDENTNURSE))
							{
								engine.showMessage("'Confirmed by' is a mandatory field as you are logged in as a student nurse");
								return false;
							}
					}
				}
			}
		}
		return true;
	}

	protected void onQmbConfirmedByTextSubmited(String value) throws PresentationLogicException 
	{
		if(value == null)
			return;
		
		form.qmbConfirmedBy().clear();
		
		HcpFilter filter = new HcpFilter();
		PersonName name = new PersonName();
		name.setSurname(value);
		filter.setQueryName(name);
		
		HcpCollection coll = domain.listMedics(filter);
		for (int i = 0; i < coll.size(); i++)
		{
			Hcp med = coll.get(i);
			form.qmbConfirmedBy().newRow(med, med.toString());			
		}
		if (coll.size() == 1)
		{
			form.qmbConfirmedBy().setValue(coll.get(0));
			populateConfirmedData();
		}
		else if (coll.size() > 1)
		{
			form.qmbConfirmedBy().showOpened();		
		}	
	}

	private void populateConfirmedData()
	{
		form.dateConfirmed().setValue(new Date());
		form.timeConfirmed().setValue(new Time());
	}

	protected void onChkCareAsPlannedValueChanged() throws PresentationLogicException 
	{
		if (form.chkCareAsPlanned().getValue())
		{
			CarePlanEvaluationNote eval = new CarePlanEvaluationNote();
			eval.setNote(form.textEvaluationNotes().getValue());
			
			if (eval.getNoteIsNotNull())
				form.textEvaluationNotes().setValue("Care as planned. " + eval.getNote());
			else
				form.textEvaluationNotes().setValue("Care as planned.");
		}
	}

	protected void onQmbConfirmedByValueChanged() throws PresentationLogicException
	{
		if(form.qmbConfirmedBy().getValue() != null)
			populateConfirmedData();
	}

	//WDEV-14473
	@Override
	protected void onCmbCarePlanStatusValueChanged() throws PresentationLogicException
	{

		if (form.cmbCarePlanStatus().getValue() == null)
		{
			return;
		}
		
		if (form.cmbCarePlanStatus().getValue().equals(ims.nursing.vo.lookups.CarePlanStatus.ACTIVE))
		{
			form.dateNextEvaluation().setRequired(true);
		}
		else
		{
			form.dateNextEvaluation().setRequired(false);
		}
	}
}
