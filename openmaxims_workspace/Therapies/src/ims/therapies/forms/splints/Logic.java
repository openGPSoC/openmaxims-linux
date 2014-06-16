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
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.40 build 2181.23522)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.splints;

import java.util.ArrayList;

import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.ConsentGivenVo;
import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.PersonName;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.spinalinjuries.vo.lookups.SplintCategory;
import ims.therapies.forms.splints.GenForm.grdSummaryRow;
import ims.therapies.forms.splints.GenForm.ctnDetailsContainer.grdWearRegimeRow;
import ims.therapies.vo.SplintAdditionalFeaturesVo;
import ims.therapies.vo.SplintAdditionalFeaturesVoCollection;
import ims.therapies.vo.SplintDetailsVo;
import ims.therapies.vo.SplintDetailsVoCollection;
import ims.therapies.vo.SplintsInstructionDetailsVo;
import ims.therapies.vo.SplintsInstructionDetailsVoCollection;
import ims.therapies.vo.SplintsWearRegimeVo;
import ims.therapies.vo.SplintsWearRegimeVoCollection;
import ims.spinalinjuries.vo.lookups.LookupHelper;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws PresentationLogicException
	{
		initialize();
		open();
	}
	private void initialize() throws PresentationLogicException 
	{
		StringBuffer exceptions = new StringBuffer();	
		if (LookupHelper.getSplintArea(domain.getLookupService()).size() == 0)
		{
			exceptions.append("Please configure SplintArea lookup");	//w2dev-13540
			exceptions.append("\n");
		}
		
		if (ims.core.vo.lookups.LookupHelper.getLateralityLRonly(domain.getLookupService()).size() == 0)
		{
			exceptions.append("Please configure LateralityLRonly lookup");
			exceptions.append("\n");
		}
		
		if (LookupHelper.getSplintCategory(domain.getLookupService()).size() == 0)
		{
			exceptions.append("Please configure SplintCategory lookup");
			exceptions.append("\n");
		}
		
		if (LookupHelper.getSplintType(domain.getLookupService()).size() == 0)
		{
			exceptions.append("Please configure SplintType lookup");
			exceptions.append("\n");
		}
		
		if (LookupHelper.getSplintMaterial(domain.getLookupService()).size() == 0)
		{
			exceptions.append("Please configure SplintMaterial lookup");
			exceptions.append("\n");
		}
		
		if (LookupHelper.getSplintBase(domain.getLookupService()).size() == 0)
		{
			exceptions.append("Please configure SplintBase lookup");
			exceptions.append("\n");
		}
		
		if (LookupHelper.getSplintProduct(domain.getLookupService()).size() == 0)
		{
			exceptions.append("Please configure SplintProduct lookup");
			exceptions.append("\n");
		}
		
		if (LookupHelper.getSplintSize(domain.getLookupService()).size() == 0)
		{
			exceptions.append("Please configure SplintSize lookup");
			exceptions.append("\n");
		}
		
		
		if(exceptions.length() > 0)
			throw new PresentationLogicException(exceptions.toString());		
	}
	
	private void open()
	{
		form.getLocalContext().setSelectedClinicalContact(new Boolean(false));
		SplintDetailsVoCollection voSplintsDetailsColl = domain.listSplintDetails(form.getGlobalContext().Core.getCurrentCareContext());
		disableCombos();
		form.grdSummary().getRows().clear();
		clearControls();
		setGrids(true);
		if(voSplintsDetailsColl != null)
		{
			populateSummaryGrid(voSplintsDetailsColl);
			populateAllControls(form.grdSummary().getValue());
			form.ctnDetails().setCollapsed(false);
		}
		else
			form.ctnDetails().setCollapsed(true);
		
		form.grdSummary().setEnabled(true);
		
		SplintDetailsVo voSplint = form.grdSummary().getValue();
		form.getLocalContext().setupdateVoSplintDetails(voSplint);
		if (voSplint != null)
			isRecordEditable(voSplint);
		
		updateAllGridMenus();		
	}
	
	private void disableCombos()
	{
		form.ctnDetails().cmbType().setEnabled(false);
		form.ctnDetails().cmbMaterial().setEnabled(false);
		form.ctnDetails().cmbBased().setEnabled(false);
		form.ctnDetails().cmbProduct().setEnabled(false);
		form.ctnDetails().cmbSize().setEnabled(false);
	}
	
	private void populateSummaryGrid(SplintDetailsVoCollection voSplintsDetailsColl)
	{
		GenForm.grdSummaryRow row = null;
		if(voSplintsDetailsColl != null)
		{
			for(int x=0; x<voSplintsDetailsColl.size(); x++)
			{
				SplintDetailsVo voSplint = voSplintsDetailsColl.get(x);
				row = form.grdSummary().getRows().newRow();
				row.setColStartDate(voSplint.getStartDate());
				if(voSplint.getArea() != null)
					row.setColArea(voSplint.getArea().toString());
				if(voSplint.getSplintCategory() != null)
					row.setColCategory(voSplint.getSplintCategory().toString());
				if(voSplint.getMaterial() != null)
					row.setColMaterial(voSplint.getMaterial().toString());
				if(voSplint.getProduct() != null)
					row.setColProduct(voSplint.getProduct().toString());
				if(voSplint.getLaterality() != null)
					row.setColLaterality(voSplint.getLaterality().toString());
				row.setColEndDate(voSplint.getEndDate());
				isGoldenInstanceFound(voSplint, row);
				row.setValue(voSplint);
				form.grdSummary().setValue(voSplint);
			}
		}
		if(form.getLocalContext().getupdateVoSplintDetailsIsNotNull())
			form.grdSummary().setValue(form.getLocalContext().getupdateVoSplintDetails());
	}

	private void isGoldenInstanceFound(SplintDetailsVo voSplint, grdSummaryRow row) 
	{
		ClinicalContactShortVo voClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		if(voClinicalContact != null)
		{
			if(voClinicalContact.getID_ClinicalContact().equals(voSplint.getClinicalContact().getID_ClinicalContact()))
				row.setBackColor(Color.Beige);
		}
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		open();
	}
	private void clearControls()
	{
		form.ctnDetails().dtimAuthoring().setValue(null);
		form.ctnDetails().qmbAuthoringCP().setValue(null);
		form.ctnDetails().dteStart().setValue(null);
		form.ctnDetails().cmbArea().setValue(null);
		form.ctnDetails().cmbCategory().setValue(null);
		form.ctnDetails().cmbMaterial().setValue(null);
		form.ctnDetails().cmbProduct().setValue(null);
		form.ctnDetails().cmbLaterality().setValue(null);
		form.ctnDetails().cmbType().setValue(null);
		form.ctnDetails().cmbBased().setValue(null);
		form.ctnDetails().cmbSize().setValue(null);
		form.ctnDetails().dteEnd().setValue(null);
		form.ctnDetails().dteConsent().setValue(null);
		form.ctnDetails().chkConsent().setValue(false);
		form.ctnDetails().grdFeatures().getRows().clear();
		form.ctnDetails().grdInstructions().getRows().clear();
		form.ctnDetails().grdWearRegime().getRows().clear();
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		ArrayList <String> errors2=new ArrayList<String>();
		if (form.ctnDetails().dteEnd().getValue()!=null)
		{
			if (form.ctnDetails().dteStart()==null)
				errors2.add("If an End Date is introduced, Start Date is mandatory");
			else
				if (form.ctnDetails().dteEnd().getValue().compareTo(form.ctnDetails().dteStart().getValue())<0)
					errors2.add("Start Date cannot be further than End Date");
		}
		if (form.ctnDetails().qmbAuthoringCP().getValue()==null)
			errors2.add("Authoring HCP is mandatory");
		if (form.ctnDetails().grdWearRegime().getRows().size()>0)
		{
			for (int i=0;i<form.ctnDetails().grdWearRegime().getRows().size();i++)
			{
				grdWearRegimeRow aRow;
				
					aRow=form.ctnDetails().grdWearRegime().getRows().get(i);
					if (aRow.getColWearRegimeTime()!=null)
					{
						if (aRow.getColEndDate()!=null)
						{
							if (aRow.getColStartDate()!=null)
							{
								if (aRow.getColStartDate().compareTo(aRow.getColEndDate())>0)
								{
									errors2.add("Start Date cannot be further than End Date in " + aRow.getColWearRegimeTime());
								}
							}
							else
								errors2.add("Start Date cannot be null if End Date is not null");
						}
					}
					else 
						errors2.add("Wear Regime/Time is a mandatory field");
			}
		}
		if (errors2.size()>0)
		{
			engine.showErrors(errors2.toArray(new String[0]));
			return;
		}
		SplintDetailsVo voSplintDetails = form.getLocalContext().getupdateVoSplintDetails();
		 if(voSplintDetails == null)
			 voSplintDetails = new SplintDetailsVo();
		voSplintDetails.setAuthoringDateTime(form.ctnDetails().dtimAuthoring().getValue());
		voSplintDetails.setAuthoringCP(form.ctnDetails().qmbAuthoringCP().getValue());
		voSplintDetails.setStartDate(form.ctnDetails().dteStart().getValue());
		voSplintDetails.setArea(form.ctnDetails().cmbArea().getValue());
		voSplintDetails.setSplintCategory(form.ctnDetails().cmbCategory().getValue());
		voSplintDetails.setMaterial(form.ctnDetails().cmbMaterial().getValue());
		voSplintDetails.setProduct(form.ctnDetails().cmbProduct().getValue());
		voSplintDetails.setLaterality(form.ctnDetails().cmbLaterality().getValue());
		voSplintDetails.setSplintType(form.ctnDetails().cmbType().getValue());
		voSplintDetails.setSplintBase(form.ctnDetails().cmbBased().getValue());
		voSplintDetails.setSplintSize(form.ctnDetails().cmbSize().getValue());
		voSplintDetails.setEndDate(form.ctnDetails().dteEnd().getValue());
		
		ConsentGivenVo voConsentGiven = null;
		if(form.getLocalContext().getupdateVoSplintDetails() != null && form.getLocalContext().getupdateVoSplintDetails().getConsentGivenIsNotNull())
		    voConsentGiven = form.getLocalContext().getupdateVoSplintDetails().getConsentGiven();
		else
			voConsentGiven = new ConsentGivenVo();
		voConsentGiven.setConsentGiven(new Boolean(form.ctnDetails().chkConsent().getValue()));
		voConsentGiven.setDateConsentGiven(form.ctnDetails().dteConsent().getValue());
		voSplintDetails.setConsentGiven(voConsentGiven);
		
		voSplintDetails.setSplintAdditionalFeatures(populateDataFromFeatureGrid());
		voSplintDetails.setSplintInstructions(populateDataFromInstructionsGrid());
		voSplintDetails.setSplintsWearRegime(populateDataFromWearsGrid());
		
		voSplintDetails.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		String[] errors = voSplintDetails.validate();
		if (errors != null)
		{
			engine.showErrors("Validation Errors", errors);
			return;
		}
		try
		{
			form.getLocalContext().setupdateVoSplintDetails(domain.saveSplintDetails(voSplintDetails));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());			
		}
		
		form.setMode(FormMode.VIEW);
		open();
		
	}

	private SplintsWearRegimeVoCollection populateDataFromWearsGrid()
	{
		SplintsWearRegimeVoCollection voWearRegimeColl = new SplintsWearRegimeVoCollection();
		GenForm.ctnDetailsContainer.grdWearRegimeRow rowWear = null;
		
		for(int x=0; x<form.ctnDetails().grdWearRegime().getRows().size(); x++)
		{
			rowWear = form.ctnDetails().grdWearRegime().getRows().get(x);
			SplintsWearRegimeVo voWearRegime = form.ctnDetails().grdWearRegime().getRows().get(x).getValue();
			if(voWearRegime == null)
				voWearRegime = new SplintsWearRegimeVo();
			voWearRegime.setEndDate(rowWear.getColEndDate());
			voWearRegime.setStartDate(rowWear.getColStartDate());
			voWearRegime.setWearTimeRegime(rowWear.getColWearRegimeTime());
			voWearRegimeColl.add(voWearRegime);
		}
		return voWearRegimeColl;
	}
	private SplintsInstructionDetailsVoCollection populateDataFromInstructionsGrid()
	{
		SplintsInstructionDetailsVoCollection voInstructionColl = new SplintsInstructionDetailsVoCollection();
		GenForm.ctnDetailsContainer.grdInstructionsRow rowInst = null;
		for(int x=0; x<form.ctnDetails().grdInstructions().getRows().size(); x++)
		{
			rowInst = form.ctnDetails().grdInstructions().getRows().get(x);
			SplintsInstructionDetailsVo voInstruction = form.ctnDetails().grdInstructions().getRows().get(x).getValue();
			if(voInstruction == null)
				voInstruction = new SplintsInstructionDetailsVo();
			voInstruction.setDateGiven(rowInst.getColDate());
			voInstruction.setInstructionLeaflet(rowInst.getColInstructionDetails());
			voInstructionColl.add(voInstruction);
		}
		return voInstructionColl;
	}
	private SplintAdditionalFeaturesVoCollection populateDataFromFeatureGrid()
	{
		SplintAdditionalFeaturesVoCollection voFeatureColl = new SplintAdditionalFeaturesVoCollection();
		GenForm.ctnDetailsContainer.grdFeaturesRow rowFeat = null;
		for(int x=0; x<form.ctnDetails().grdFeatures().getRows().size(); x++)
		{
			rowFeat = form.ctnDetails().grdFeatures().getRows().get(x);
			SplintAdditionalFeaturesVo voFeature = form.ctnDetails().grdFeatures().getRows().get(x).getValue();
			if(voFeature == null)
				voFeature = new SplintAdditionalFeaturesVo();
			voFeature.setFeature(rowFeat.getColAdditionalFeatures());
			voFeature.setComment(rowFeat.getColComments());
			voFeatureColl.add(voFeature);
		}
		return voFeatureColl;
	}
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				menuNewSummary();
				break;
			case GenForm.ContextMenus.GenericGrid.Update:
				menuEditSummary();
				break;
			case GenForm.ContextMenus.MedicationGrid.ADD:
				menuNewWear();
				break;
			case GenForm.ContextMenus.MedicationGrid.REMOVE:
				menuRemoveWear();
				break;		
			case GenForm.ContextMenus.SmokingGrid.ADD:
				menuNewFeatures();
				break;
			case GenForm.ContextMenus.SmokingGrid.REMOVE:
				menuRemoveFeatures();
				break;
			case GenForm.ContextMenus.AddUpDown.ADD:
				menuNewInstructions();
				break;
			case GenForm.ContextMenus.AddUpDown.MOVEDOWN:
				menuRemoveInstructions();
				break;
		}
	}
	private void menuRemoveInstructions()
	{
		form.ctnDetails().grdInstructions().removeSelectedRow();
		updateInstructionsGridMenu();
	}
	private void menuRemoveFeatures()
	{
		form.ctnDetails().grdFeatures().removeSelectedRow();
		updateFeaturesGridMenu();
	}
	private void menuRemoveWear()
	{
		form.ctnDetails().grdWearRegime().removeSelectedRow();
		updateWearGridMenu();
	}
	private void menuEditSummary()
	{
		setGrids(false);
		clearControls();
		form.setMode(FormMode.EDIT);
		onCmbCategoryValueChanged();
		form.grdSummary().setEnabled(false);
		form.ctnDetails().setCollapsed(false);
		form.getLocalContext().setupdateVoSplintDetails(form.grdSummary().getValue());
		populateAllControls(form.getLocalContext().getupdateVoSplintDetails());
		onCmbCategoryValueRead();
		updateAllGridMenus();
	}
	
	private void onCmbCategoryValueRead() 
	{
		if (form.grdSummary().getSelectedRowIndex() >=0 && form.ctnDetails().cmbCategory().getValue() != null)
		{
			if (form.ctnDetails().cmbCategory().getValue().equals(SplintCategory.COMMERCIAL))
			{
				form.ctnDetails().cmbType().setEnabled(false);
				form.ctnDetails().cmbMaterial().setEnabled(false);
				form.ctnDetails().cmbBased().setEnabled(false);
				form.ctnDetails().cmbProduct().setEnabled(true);
				form.ctnDetails().cmbSize().setEnabled(true);
			}
			if (form.ctnDetails().cmbCategory().getValue().equals(SplintCategory.CUSTOMISED))
			{
				form.ctnDetails().cmbType().setEnabled(true);
				form.ctnDetails().cmbMaterial().setEnabled(true);
				form.ctnDetails().cmbBased().setEnabled(true);
				form.ctnDetails().cmbProduct().setEnabled(false);
				form.ctnDetails().cmbSize().setEnabled(false);
			}
		
			if (form.ctnDetails().cmbCategory().getValue().equals(SplintCategory.COMBINED))
			{
				form.ctnDetails().cmbType().setEnabled(true);
				form.ctnDetails().cmbMaterial().setEnabled(true);
				form.ctnDetails().cmbBased().setEnabled(true);
				form.ctnDetails().cmbProduct().setEnabled(true);
				form.ctnDetails().cmbSize().setEnabled(true);
			}
		
		}
	}
	
	private void menuNewSummary()
	{
		setGrids(false);
		clearControls();
		form.setMode(FormMode.EDIT);
		form.ctnDetails().qmbAuthoringCP().setEnabled(true);
		form.ctnDetails().dtimAuthoring().setEnabled(true);
		form.ctnDetails().dtimAuthoring().setValue(new DateTime());
		form.getLocalContext().setupdateVoSplintDetails(null);
		loadHcps();
		form.grdSummary().setEnabled(false);
		
		form.ctnDetails().setCollapsed(false);
		updateAllGridMenus();	
	}
	private void menuNewInstructions()
	{
		form.ctnDetails().grdInstructions().getRows().newRow();
	}
	private void menuNewWear()
	{
		form.ctnDetails().grdWearRegime().getRows().newRow();
	}
	private void menuNewFeatures()
	{
		form.ctnDetails().grdFeatures().getRows().newRow();
	}
	private void loadHcps()
	{
		form.ctnDetails().qmbAuthoringCP().setValue(null);

		Hcp hcp = (Hcp) domain.getHcpUser();
		if(hcp != null)
		{
			form.ctnDetails().qmbAuthoringCP().newRow(hcp, hcp.toString());
			form.ctnDetails().qmbAuthoringCP().setValue(hcp);
		}
	}
	private void updateSummaryGridMenu() 
	{
		
		form.getContextMenus().getGenericGridAddItem().setText("New");
		form.getContextMenus().getGenericGridAddItem().setVisible(form.grdSummary().isEnabled() && form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull());
			
		form.getContextMenus().getGenericGridUpdateItem().setText("Edit");
		form.getContextMenus().getGenericGridUpdateItem().setVisible(form.grdSummary().isEnabled() && form.grdSummary().getSelectedRowIndex()>=0 && form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() && form.getLocalContext().getSelectedClinicalContact().booleanValue());
		
		form.getContextMenus().getGenericGridRemoveItem().setVisible(false);
		form.getContextMenus().getGenericGridMoveDownItem().setVisible(false);
		form.getContextMenus().getGenericGridMoveUpItem().setVisible(false);
		form.getContextMenus().getGenericGridViewItem().setVisible(false);
	
		if(form.getMode().equals(FormMode.VIEW)){
			form.btnNew().setVisible(form.grdSummary().isEnabled() && form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull());
			form.btnUpdate().setVisible(form.grdSummary().isEnabled() && form.grdSummary().getSelectedRowIndex()>=0 && form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() && form.getLocalContext().getSelectedClinicalContact().booleanValue());
		}
	}
	private void updateWearGridMenu()
	{
		form.getContextMenus().getMedicationGridADDItem().setText("New");
		form.getContextMenus().getMedicationGridADDItem().setVisible(form.ctnDetails().grdWearRegime().isEnabled() && form.getMode().equals(FormMode.EDIT));
		form.getContextMenus().getMedicationGridREMOVEItem().setVisible(form.ctnDetails().grdWearRegime().isEnabled() && form.ctnDetails().grdWearRegime().getRows().size()>0 && form.ctnDetails().grdWearRegime().getSelectedRowIndex()>=0 && form.getMode().equals(FormMode.EDIT));
	}
	private void updateFeaturesGridMenu()
	{
		form.getContextMenus().getSmokingGridADDItem().setText("New");
		form.getContextMenus().getSmokingGridADDItem().setVisible(form.ctnDetails().grdFeatures().isEnabled() && form.getMode().equals(FormMode.EDIT));
		form.getContextMenus().getSmokingGridREMOVEItem().setVisible(form.ctnDetails().grdFeatures().isEnabled() && form.ctnDetails().grdFeatures().getRows().size()>0 && form.ctnDetails().grdFeatures().getSelectedRowIndex()>=0 && form.getMode().equals(FormMode.EDIT));
	}
	private void updateInstructionsGridMenu()
	{
		form.getContextMenus().getAddUpDownADDItem().setText("New");
		form.getContextMenus().getAddUpDownADDItem().setVisible(form.ctnDetails().grdInstructions().isEnabled() && form.getMode().equals(FormMode.EDIT));
		form.getContextMenus().getAddUpDownMOVEDOWNItem().setText("Remove");
		form.getContextMenus().getAddUpDownMOVEDOWNItem().setIcon(form.getImages().Core.Delete);
		form.getContextMenus().getAddUpDownMOVEDOWNItem().setVisible(form.ctnDetails().grdInstructions().isEnabled() && form.ctnDetails().grdInstructions().getRows().size()>0 && form.ctnDetails().grdInstructions().getSelectedRowIndex()>=0 && form.getMode().equals(FormMode.EDIT));
		form.getContextMenus().getAddUpDownMOVEUPItem().setVisible(false);
	}
	private void updateAllGridMenus()
	{
		updateSummaryGridMenu();
		updateWearGridMenu();
		updateFeaturesGridMenu();
		updateInstructionsGridMenu();		
	}
	protected void onGrdSummarySelectionChanged() throws PresentationLogicException
	{
		SplintDetailsVo voSplint = form.grdSummary().getValue();
		isRecordEditable(voSplint);
		clearControls();
		populateAllControls(voSplint);
		updateSummaryGridMenu();
	}
	private void isRecordEditable(SplintDetailsVo voSplint) 
	{
		ClinicalContactShortVo voClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		if(voClinicalContact != null)
		{
			ClinicalContactShortVo voCurrentClinicalContact = voSplint.getClinicalContact();
			
			if(voClinicalContact.getID_ClinicalContact().equals(voCurrentClinicalContact.getID_ClinicalContact()))
				form.getLocalContext().setSelectedClinicalContact(new Boolean(true));
			else
				form.getLocalContext().setSelectedClinicalContact(new Boolean(false));
		}
		
	}
	private void populateAllControls(SplintDetailsVo voDetails)
	{
		if(voDetails != null)
		{
			populateControls(voDetails);
			if(voDetails.getSplintsWearRegimeIsNotNull())
				populateWearGrid(voDetails.getSplintsWearRegime());
			if(voDetails.getSplintAdditionalFeaturesIsNotNull())
				populateFeaturesGrid(voDetails.getSplintAdditionalFeatures());
			if(voDetails.getSplintInstructionsIsNotNull())
				populateInstructionsGrid(voDetails.getSplintInstructions());
		}
	}
	private void populateInstructionsGrid(SplintsInstructionDetailsVoCollection voInstructionsColl)
	{
		for(int x=0; x<voInstructionsColl.size(); x++)
		{
			SplintsInstructionDetailsVo voSID = voInstructionsColl.get(x);
			GenForm.ctnDetailsContainer.grdInstructionsRow row = form.ctnDetails().grdInstructions().getRows().newRow();
			row.setColInstructionDetails(voSID.getInstructionLeaflet());
			row.setColDate(voSID.getDateGiven());
			row.setValue(voSID);
		}
	}
	private void populateWearGrid(SplintsWearRegimeVoCollection voWearRegimeColl)
	{
		form.ctnDetails().grdWearRegime().getRows().clear();
		for(int x=0; x<voWearRegimeColl.size(); x++)
		{
			SplintsWearRegimeVo voWear = voWearRegimeColl.get(x);
			GenForm.ctnDetailsContainer.grdWearRegimeRow row = form.ctnDetails().grdWearRegime().getRows().newRow();
			row.setColWearRegimeTime(voWear.getWearTimeRegime());
			row.setColStartDate(voWear.getStartDate());
			row.setColEndDate(voWear.getEndDate());
			row.setValue(voWear);
		}
	}
	private void populateFeaturesGrid(SplintAdditionalFeaturesVoCollection voFeaturesColl)
	{
		for(int x=0; x<voFeaturesColl.size(); x++)
		{
			SplintAdditionalFeaturesVo voAddFeat = voFeaturesColl.get(x);
			GenForm.ctnDetailsContainer.grdFeaturesRow row = form.ctnDetails().grdFeatures().getRows().newRow();
			row.setColAdditionalFeatures(voAddFeat.getFeature());
			row.setColComments(voAddFeat.getComment());
			row.setValue(voAddFeat);
		}
	}
	private void populateControls(SplintDetailsVo voSplint)
	{
		form.ctnDetails().dtimAuthoring().setValue(voSplint.getAuthoringDateTime());
		Hcp med = voSplint.getAuthoringCP();
		if(med != null)
			form.ctnDetails().qmbAuthoringCP().newRow(med, med.toString());
		form.ctnDetails().qmbAuthoringCP().setValue(med);
		form.ctnDetails().dteStart().setValue(voSplint.getStartDate());
		form.ctnDetails().cmbArea().setValue(voSplint.getArea());
		form.ctnDetails().cmbCategory().setValue(voSplint.getSplintCategory());
		form.ctnDetails().cmbMaterial().setValue(voSplint.getMaterial());
		form.ctnDetails().cmbProduct().setValue(voSplint.getProduct());
		form.ctnDetails().cmbLaterality().setValue(voSplint.getLaterality());
		form.ctnDetails().cmbType().setValue(voSplint.getSplintType());
		form.ctnDetails().cmbBased().setValue(voSplint.getSplintBase());
		form.ctnDetails().cmbSize().setValue(voSplint.getSplintSize());
		form.ctnDetails().dteEnd().setValue(voSplint.getEndDate());
		form.ctnDetails().dteConsent().setValue(voSplint.getConsentGiven().getDateConsentGiven());
		form.ctnDetails().chkConsent().setValue(voSplint.getConsentGiven().getConsentGiven().booleanValue());
		
	}
	protected void onQmbAuthoringCPTextSubmited(String value) throws PresentationLogicException
	{
		form.ctnDetails().qmbAuthoringCP().clear();
		HcpFilter filter = new HcpFilter();
		PersonName name = new PersonName();
		name.setSurname(value);
		filter.setQueryName(name);
		
		HcpCollection coll = domain.listHCPs(filter);
		for (int i = 0; i < coll.size(); i++)
		{
			Hcp med = coll.get(i);
			form.ctnDetails().qmbAuthoringCP().newRow(med, med.toString());			
		}
		if (coll.size() == 1)
		{
			form.ctnDetails().qmbAuthoringCP().setValue(coll.get(0));
		}
		else if (coll.size() > 1)
		{
			form.ctnDetails().qmbAuthoringCP().showOpened();		
		}			
	}
	private void setGrids(boolean state)
	{
		form.ctnDetails().grdFeatures().setReadOnly(state);
		form.ctnDetails().grdInstructions().setReadOnly(state);
		form.ctnDetails().grdWearRegime().setReadOnly(state);
	}
	protected void onCmbCategoryValueChanged()
	{
		if(form.ctnDetails().cmbCategory().getValue() != null)
		{
			if(form.ctnDetails().cmbCategory().getValue().equals(SplintCategory.CUSTOMISED))
			{
				form.ctnDetails().cmbType().setEnabled(true);
				form.ctnDetails().cmbMaterial().setEnabled(true);
				form.ctnDetails().cmbBased().setEnabled(true);
				form.ctnDetails().cmbProduct().setEnabled(false);
				form.ctnDetails().cmbSize().setEnabled(false);
				form.ctnDetails().cmbProduct().setValue(null);
				form.ctnDetails().cmbSize().setValue(null);
			}
			else if(form.ctnDetails().cmbCategory().getValue().equals(SplintCategory.COMBINED))
			{
				form.ctnDetails().cmbType().setEnabled(true);
				form.ctnDetails().cmbMaterial().setEnabled(true);
				form.ctnDetails().cmbBased().setEnabled(true);
				form.ctnDetails().cmbProduct().setEnabled(true);
				form.ctnDetails().cmbSize().setEnabled(true);
			}
			else if(form.ctnDetails().cmbCategory().getValue().equals(SplintCategory.COMMERCIAL))
			{
				form.ctnDetails().cmbType().setEnabled(false);
				form.ctnDetails().cmbMaterial().setEnabled(false);
				form.ctnDetails().cmbBased().setEnabled(false);
				form.ctnDetails().cmbType().setValue(null);
				form.ctnDetails().cmbMaterial().setValue(null);
				form.ctnDetails().cmbBased().setValue(null);
				form.ctnDetails().cmbProduct().setEnabled(true);
				form.ctnDetails().cmbSize().setEnabled(true);
			}
		}
		else
			clearCombos();
		
	}
	private void clearCombos()
	{
		form.ctnDetails().cmbType().setValue(null);
		form.ctnDetails().cmbMaterial().setValue(null);
		form.ctnDetails().cmbBased().setValue(null);
		form.ctnDetails().cmbProduct().setValue(null);
		form.ctnDetails().cmbSize().setValue(null);	
	}
	protected void onGrdInstructionsSelectionChanged() throws PresentationLogicException
	{
		updateInstructionsGridMenu();
	}
	protected void onGrdFeaturesSelectionChanged() throws PresentationLogicException
	{
		updateFeaturesGridMenu();
	}
	protected void onGrdWearRegimeSelectionChanged() throws PresentationLogicException
	{
		updateWearGridMenu();
	}
	protected void onBtnNewClick() throws PresentationLogicException {
		menuNewSummary();
		
	}
	protected void onBtnUpdateClick() throws PresentationLogicException {
		menuEditSummary();
		
	}
}
