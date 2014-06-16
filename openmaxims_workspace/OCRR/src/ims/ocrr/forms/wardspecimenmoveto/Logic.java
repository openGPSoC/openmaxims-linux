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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.45 build 2400.16317)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.forms.wardspecimenmoveto;

import java.util.ArrayList;

import ims.core.resource.place.vo.LocationRefVo;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.ocrr.helper.PhlebotomyHelper;
import ims.ocrr.vo.OrderSpecimenListVo;
import ims.ocrr.vo.PhlebotomyRoundShortVoCollection;
import ims.ocrr.vo.SpecimenCollectionListConfigDetailsVoCollection;
import ims.ocrr.vo.SpecimenWorkListItemListVo;
import ims.ocrr.vo.lookups.LookupHelper;
import ims.ocrr.vo.lookups.OrderInvStatus;
import ims.ocrr.vo.lookups.OutPatientDurationCollection;
import ims.ocrr.vo.lookups.SpecimenCollectionMethod;
import ims.ocrr.vo.lookups.SpecimenCollectionStatus;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(saveWorkListItem())
			engine.close(DialogResult.OK);
	}

	private boolean saveWorkListItem()
	{
		SpecimenCollectionMethod  colMethod = form.cmbCollection().getValue();
		if(colMethod != null)
		{
			//WDEV-16747
			if (! validateUiRules())
				return false;
			
			//Patient Assessment
			//WDEV-2990 
			SpecimenWorkListItemListVo previousWorkListItemVo = (SpecimenWorkListItemListVo)form.getGlobalContext().OCRR.getSpecimenWorkListItemList().clone();
			previousWorkListItemVo.setCollectionStatus(SpecimenCollectionStatus.MOVEDTOPHLEBOTOMY);
			
			//Newly created Patient Assessment
			SpecimenWorkListItemListVo voItem = new SpecimenWorkListItemListVo();
			//Common info
			voItem.setSpecimen(previousWorkListItemVo.getSpecimen());
			//Update the comment - !!! Any change to the Specimen should be done also in the impl!!!!
			String commentCollected = "Moved to Phlebotomy";
			commentCollected = getPhlebotomistComment(voItem.getSpecimen().getCollectorComment(), engine.getLoggedInUser().getUserRealName(), new DateTime(), commentCollected);
			voItem.getSpecimen().setCollectorComment(commentCollected);
			//------------------
			voItem.setListType(colMethod);
			voItem.setCollectionStatus(SpecimenCollectionStatus.FORCOLLECTION);
			
			if(colMethod.equals(SpecimenCollectionMethod.INPATIENT))
			{
				voItem.setDateToCollect(form.dteDate().getValue());
				voItem.setRoundToCollect(form.cmbRound().getValue());
				updateRequiredByDateField(previousWorkListItemVo, form.dteDate().getValue());//WDEV-16898
				
				return saveVos(voItem, previousWorkListItemVo);
			}
			else if(colMethod.equals(SpecimenCollectionMethod.OUTPATIENT))
			{
				Date outpatientDate = calculateOutpatientDate();
				voItem.setDateToCollect(outpatientDate);
				updateRequiredByDateField(previousWorkListItemVo, outpatientDate);//WDEV-16898
				
				return saveVos(voItem, previousWorkListItemVo);
			}
		}
		else
		{
			engine.showMessage("Please select a Collection");
			form.cmbCollection().setFocus();
			return false;
		}
		
		return true;
	}
	
	//WDEV-16898
	private void updateRequiredByDateField(SpecimenWorkListItemListVo previousWorkListItemVo, Date date)
	{
		OrderSpecimenListVo item = previousWorkListItemVo.getSpecimen(); 

		for (int j = 0; item.getInvestigationsIsNotNull() && j < item.getInvestigations().size(); j++)
		{
			// cancelled investigations will not be modified
			if (item.getInvestigations().get(j).getInvestigationIsNotNull() && item.getInvestigations().get(j).getOrdInvCurrentStatusIsNotNull() && item.getInvestigations().get(j).getOrdInvCurrentStatus().getOrdInvStatusIsNotNull() && (!item.getInvestigations().get(j).getOrdInvCurrentStatus().getOrdInvStatus().equals(OrderInvStatus.CANCEL_REQUEST) && !item.getInvestigations().get(j).getOrdInvCurrentStatus().getOrdInvStatus().equals(OrderInvStatus.CANCELLED)))
			{
				item.getInvestigations().get(j).setRequiredByDate(new DateTime(date));
			}
		}
	}
	
	//WDEV-16747
	private boolean validateUiRules()
	{
		ArrayList<String> listOfErrors = new ArrayList<String>();

		if (form.cmbRound().getValue() == null && Boolean.TRUE.equals(form.cmbRound().getVisible()))
		{
			listOfErrors.add("Round is mandatory.");
		}
		
		if (form.intQuantity().getValue() == null && Boolean.TRUE.equals(form.intQuantity().isVisible()))
		{
			listOfErrors.add("Number is mandatory.");
		}
		
		if (form.cmbValues().getValue() == null && Boolean.TRUE.equals(form.cmbValues().getVisible()))
		{
			listOfErrors.add("Period is mandatory.");
		}

		int errorCount = listOfErrors.size();
		String[] result = new String[errorCount];

		for (int x = 0; x < errorCount; x++)
			result[x] = (String) listOfErrors.get(x);

		if (result != null && result.length > 0)
		{
			engine.showErrors(result);
			return false;
		}

		return true;
	}
	
	private String getPhlebotomistComment(String existingComment, String phlebotomistString, DateTime dateTimeCollected, String commentCollected)
	{
		return new ims.ocrr.helper.PhlebotomyHelper().getPhlebotomistComment(existingComment, phlebotomistString, dateTimeCollected, commentCollected);
	}
	private boolean saveVos(SpecimenWorkListItemListVo voItem, SpecimenWorkListItemListVo voPrevItem)
	{
		String[] errors = voPrevItem.validate(voItem.validate(getUiErrors(voItem.getListType(), voItem)));
		if(errors != null)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try
		{
			SpecimenWorkListItemListVo voPrevItemSaved = domain.saveWorkListItem(voItem, voPrevItem);
			form.getGlobalContext().OCRR.setSpecimenWorkListItemList(voPrevItemSaved);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());	
			return true;//WDEV-16708
		}
		
		return true;
	}
	private Date calculateOutpatientDate()
	{
		return new PhlebotomyHelper().calculateDateToCollect(form.intQuantity().getValue(), form.cmbValues().getValue());
	}
	private String[] getUiErrors(SpecimenCollectionMethod colMethod, SpecimenWorkListItemListVo voItem)
	{
		if(colMethod != null)
		{
			ArrayList errors = new ArrayList();
			if(colMethod.equals(SpecimenCollectionMethod.INPATIENT))
			{
				if(form.dteDate() == null)
					errors.add("Please select " + form.lblDate().toString().replaceAll(":",""));
				
				if(form.cmbRound() == null)
					errors.add("Please select " + form.lblRound().toString().replaceAll(":",""));
				
				String closedWardMessage = getClosedRoundsMessage(voItem);
				if(closedWardMessage != null)
					errors.add(closedWardMessage);
			}
			else if(colMethod.equals(SpecimenCollectionMethod.OUTPATIENT))
			{
				if(form.intQuantity() == null)
					errors.add("Please add " + form.lblQuantity().toString().replaceAll(":",""));
				
				if(form.cmbValues() == null)
					errors.add("Please select " + form.lblValue().toString().replaceAll(":",""));
			}
			
			if(errors.size() > 0)
			{
				String[] errorsUI = new String[errors.size()];
				errors.toArray(errorsUI);
				return errorsUI;
			}
		}
		
		return null;
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	private void initialize()
	{
		//Add only Inpatient and Outpatient
		form.cmbCollection().newRow(SpecimenCollectionMethod.INPATIENT, SpecimenCollectionMethod.INPATIENT.toString());	
		form.cmbCollection().newRow(SpecimenCollectionMethod.OUTPATIENT, SpecimenCollectionMethod.OUTPATIENT.toString());
		enableControls(null);
	}
	
	protected void onCmbCollectionValueChanged() throws PresentationLogicException
	{
		SpecimenCollectionMethod value = form.cmbCollection().getValue();
		clearControls(); //WDEV-15648
		enableControls(value);
		populateControls(value);
	}

	private void clearControls()
	{
		form.cmbRound().setValue(null);
		form.cmbValues().setValue(null);
		form.intQuantity().setValue(null);
		form.dteDate().setValue(null);
	}
	
	private void enableControls(SpecimenCollectionMethod value)
	{
		boolean enableInpatient = value != null && value.equals(SpecimenCollectionMethod.INPATIENT)?true:false; 
		boolean enableOutpatient= value != null && value.equals(SpecimenCollectionMethod.OUTPATIENT)?true:false;
		
		form.lblDate().setVisible(enableInpatient);
		form.dteDate().setVisible(enableInpatient);
		form.lblRound().setVisible(enableInpatient);
		form.cmbRound().setVisible(enableInpatient);
		form.cmbRound().setRequired(enableInpatient);
		
		form.lblQuantity().setVisible(enableOutpatient);
		form.intQuantity().setVisible(enableOutpatient);
		form.intQuantity().setRequired(enableOutpatient);
		form.lblValue().setVisible(enableOutpatient);
		form.cmbValues().setVisible(enableOutpatient);
		form.cmbValues().setRequired(enableOutpatient);
	}
	
	private void populateControls(SpecimenCollectionMethod value)
	{
		if(value != null)
		{
			if (value.equals(SpecimenCollectionMethod.OUTPATIENT))
			{
				OutPatientDurationCollection collDuration = LookupHelper.getOutPatientDuration(domain.getLookupService());
				if (form.cmbValues().getValues().size() == 0)
				{
					for (int i = 0; i < collDuration.size(); i++)
					{
						form.cmbValues().newRow(collDuration.get(i), collDuration.get(i).toString());
					}
				}
			}
			else if (value.equals(SpecimenCollectionMethod.INPATIENT))//WDEV-16964
			{
				form.dteDate().setValue(new Date());
				dateChanged();
			}
			
		}
	}
	protected void onDteDateValueChanged() throws PresentationLogicException
	{
		dateChanged();
	}
	
	private void dateChanged()
	{
		Date date = form.dteDate().getValue();
		form.cmbRound().clear();

		if (date == null)
			return;

		if (date.isLessThan(new Date()))
		{
			engine.showMessage("Date cannot be in the past");
			form.dteDate().setValue(null);
			return;
		}

		SpecimenCollectionListConfigDetailsVoCollection voCollCfg = domain.listSpecimenCollectionDetails(SpecimenCollectionMethod.INPATIENT, date);
		if (voCollCfg != null)
		{
			for (int i = 0; i < voCollCfg.size(); i++)
				form.cmbRound().newRow(voCollCfg.get(i).getTime(), voCollCfg.get(i).getTime().getText());
		}
	}
	
	private String getClosedRoundsMessage(SpecimenWorkListItemListVo voItem)
	{
		LocationRefVo ward = null;
		if(voItem != null && voItem.getSpecimenIsNotNull() && voItem.getSpecimen().getOrderIsNotNull() && voItem.getSpecimen().getOrder().getPatientIsNotNull())
			ward = voItem.getSpecimen().getOrder().getPatient().getWard();
		//build up a list of closed rounds
		if(ward != null)
		{
			PhlebotomyRoundShortVoCollection voCollClosedRounds = domain.listClosedRounds(form.dteDate().getValue(), form.cmbRound().getValue(), ward );
			StringBuffer message = new StringBuffer();
			if (voCollClosedRounds != null && voCollClosedRounds.size() > 0)
			{
				message.append("You cannot place this order as the following inpatient phlebotomy rounds are closed: ");
				for (int i = 0; i < voCollClosedRounds.size(); i++)
				{
					message.append(voCollClosedRounds.get(i).getDate().toString());
					message.append("  ");
					message.append(voCollClosedRounds.get(i).getRoundToCollect().getText());
					if (voCollClosedRounds.size() - i == 2)
					{
						message.append("\n");
					}
				}
			}
			return message.length() > 0 ? message.toString() : null;
		}
		
		return null;
	}
}
