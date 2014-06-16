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
// This code was generated by Peter Martin using IMS Development Environment (version 1.30 build 2012.21169)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.forms.specimencontaineraddedit;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.TaxonomyMap;
import ims.core.vo.TaxonomyMapCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.ocrr.vo.PathSpecimenContainerVo;
import ims.ocrr.vo.lookups.PathContainerAdditiveCollection;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		loadAdditives();
		//Default OK button behaviour to save
		form.getLocalContext().setSaveRecord(Boolean.TRUE);
		
		if(form.getGlobalContext().OCRR.getPathSpecimenContainerVoIsNotNull()){
			
			populateContainerData(form.getGlobalContext().OCRR.getPathSpecimenContainerVo());
			
			if(form.getGlobalContext().OCRR.getUpdatePathSpecimenContainer().booleanValue()){
				form.setMode(FormMode.EDIT);
			}
			else{
				form.setMode(FormMode.VIEW);
				form.getLocalContext().setSaveRecord(Boolean.FALSE);
			}
		}
		else{
			form.chkActive().setValue(true);
			form.setMode(FormMode.EDIT);
		}
		updateContexMenuState();
	}

	private void populateContainerData(PathSpecimenContainerVo voPathSpecimenContainer) {
		populateScreenFromData(voPathSpecimenContainer);
		populateTaxonomyGrid(voPathSpecimenContainer);
		if(voPathSpecimenContainer.getColourIsNotNull()){
			form.cmbColour().setValue(voPathSpecimenContainer.getColour());
		}
		if(voPathSpecimenContainer.getAdditiveIsNotNull())
			setAdditives(voPathSpecimenContainer.getAdditive());
		
	}
	private void populateTaxonomyGrid(PathSpecimenContainerVo voPathSpecimenContainer)
	{
		form.grdTaxonomy().getRows().clear();
		if (voPathSpecimenContainer != null && voPathSpecimenContainer.getTaxonomyMapIsNotNull())
		{
			voPathSpecimenContainer.getTaxonomyMap().sort();
			for (int i = 0; i < voPathSpecimenContainer.getTaxonomyMap().size(); i++)
			{
				addTaxonomyRow(voPathSpecimenContainer.getTaxonomyMap().get(i));
			}
		}
	}
	private void setAdditives(PathContainerAdditiveCollection additives) 
	{
		for(int x = 0; x < form.grdAdditive().getRows().size(); x++)
		{
			for(int y = 0; y < additives.size(); y++){
				if(additives.get(y).equals(form.grdAdditive().getRows().get(x).getValue()))
					form.grdAdditive().getRows().get(x).setSelect(true);
			}
		}
	}
	
	private void loadAdditives() 
	{
		form.grdAdditive().getRows().clear();
		ims.ocrr.vo.lookups.PathContainerAdditiveCollection lookupCollection = ims.ocrr.vo.lookups.LookupHelper.getPathContainerAdditive(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			GenForm.grdAdditiveRow row = form.grdAdditive().getRows().newRow();
			row.setAdditive(lookupCollection.get(x).toString()); //added toString
			row.setValue(lookupCollection.get(x));
		}
		
	}
	
	protected void onBtnSaveClick() throws PresentationLogicException
	{
		if(form.getLocalContext().getSaveRecord().booleanValue())
		{
			PathSpecimenContainerVo voPathSpecimenContainer = new PathSpecimenContainerVo();
			
			if(form.getGlobalContext().OCRR.getPathSpecimenContainerVoIsNotNull())
				voPathSpecimenContainer = form.getGlobalContext().OCRR.getPathSpecimenContainerVo();
			
			voPathSpecimenContainer = populateDataFromScreen(voPathSpecimenContainer);
			voPathSpecimenContainer.setColour(form.cmbColour().getValue());
			
			PathContainerAdditiveCollection collPathContainerAdditive = new PathContainerAdditiveCollection();
			for(int i=0; i<form.grdAdditive().getRows().size(); i++){
				if(form.grdAdditive().getRows().get(i).getSelect())
					collPathContainerAdditive.add(form.grdAdditive().getRows().get(i).getValue());
			}
			voPathSpecimenContainer.setAdditive(collPathContainerAdditive);
			
			TaxonomyMapCollection taxColl = voPathSpecimenContainer.getTaxonomyMap();
			
			if (taxColl == null)
				taxColl = new TaxonomyMapCollection();
			else
				taxColl.clear();

			for (int i = 0; i < form.grdTaxonomy().getRows().size(); i++)
			{
				taxColl.add(form.grdTaxonomy().getRows().get(i).getValue());
			}
			voPathSpecimenContainer.setTaxonomyMap(taxColl);

			
			
			
			if(!save(voPathSpecimenContainer))
				return;
		}
		
		engine.close(DialogResult.OK);
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	protected void onBtnUpdateClick() throws PresentationLogicException 
	{
		form.setMode(FormMode.EDIT);	
		form.getLocalContext().setSaveRecord(Boolean.TRUE);		
		updateContexMenuState();
	}
	
	private boolean save(PathSpecimenContainerVo voPathSpecimenContainer)
	{
		String[] arrErrors = voPathSpecimenContainer.validate();
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		try {
			voPathSpecimenContainer = domain.savePathSpecimenContainer(voPathSpecimenContainer);
		} catch (StaleObjectException e) {
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return false;
		}
		
		form.getGlobalContext().OCRR.setPathSpecimenContainerVo(voPathSpecimenContainer);
		return true;
	}

	
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		
		switch (menuItemID)
		{
			case GenForm.ContextMenus.OCRRTaxonomy.ADD_TAXONOMY :
				addTaxonomy();
				break;
			case GenForm.ContextMenus.OCRRTaxonomy.REMOVE_TAXONOMY :
				removeTaxonomy();
				break;
		}
		
	}
	private void removeTaxonomy()
	{

		if (form.grdTaxonomy().getSelectedRowIndex() > -1)
		{
			form.grdTaxonomy().removeSelectedRow();
			form.grdTaxonomy().setValue(null);
			updateContexMenuState();
			
		}
	}

	private void addTaxonomy()
	{
		form.getGlobalContext().Core.setTaxonomyMap(null);
		engine.open(form.getForms().Core.TaxonomySearch);
	}

	
	protected void onFormDialogClosed(FormName formName, DialogResult result)  throws PresentationLogicException 
	{
		if (result.equals(DialogResult.OK))
		{
			if (formName.equals(form.getForms().Core.TaxonomySearch))
			{
				if (form.getGlobalContext().Core.getTaxonomyMapIsNotNull())
				{
					TaxonomyMap tax = form.getGlobalContext().Core.getTaxonomyMap();
					// WDEV-4338 07/04/08 code below Checks for duplicate
					// taxonomies used by investigations
					if (domain.checkDuplicateTaxonomyMapping(tax))
					{
						if(!checkDuplicateTaxonomyMappingInGrid(tax))
							addTaxonomyRow(tax);
						else
							engine.showMessage("The taxonomy code " + tax.getTaxonomyCode() +  " is already in use");
					}
					else
						engine.showMessage("The " + tax.getTaxonomyName() + " taxonomy " + tax.getDescription() + " is already in use by another container");
				}
			}
		}
		
	}
	private void addTaxonomyRow(TaxonomyMap tax)
	{
		GenForm.grdTaxonomyRow row = form.grdTaxonomy().getRows().newRow();
		if (tax.getTaxonomyNameIsNotNull())
		{
			row.setcolTaxonomy(tax.getTaxonomyName().getText());
			// row.setTooltip("<b>" + tax.getTaxonomyName().getText() + " : " +
			// (tax.getDescription() != null ? tax.getDescription() : "") +
			// "</b>");
		}
		row.setcolCode(tax.getTaxonomyCode());
		row.setValue(tax);
	}
	private void updateContexMenuState()
	{
		if(form.getMode().equals(FormMode.EDIT))
		{
			form.getContextMenus().getOCRRTaxonomyADD_TAXONOMYItem().setVisible(true);
			if (form.grdTaxonomy().getSelectedRowIndex() > -1)
				form.getContextMenus().getOCRRTaxonomyREMOVE_TAXONOMYItem().setVisible(true);
			else
				form.getContextMenus().getOCRRTaxonomyREMOVE_TAXONOMYItem().setVisible(false);
		}
		else
		{
			form.getContextMenus().getOCRRTaxonomyADD_TAXONOMYItem().setVisible(false);
			form.getContextMenus().getOCRRTaxonomyREMOVE_TAXONOMYItem().setVisible(false);
		}
	}

	protected void onGrdTaxonomySelectionChanged() throws PresentationLogicException 
	{
		updateContexMenuState();
		
	}
	private boolean checkDuplicateTaxonomyMappingInGrid(TaxonomyMap tax)
	{
		if(tax == null)
			return false;
		for (int i = 0; i < form.grdTaxonomy().getRows().size(); i++)
		{
			if(form.grdTaxonomy().getRows().get(i).getcolCode() != null && form.grdTaxonomy().getRows().get(i).getcolCode().toUpperCase().equals((tax.getTaxonomyCode() == null ) ?  null :tax.getTaxonomyCode().toUpperCase()))
				return true;
		}
		return false;
	}

	//WDEV-17774
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	private void updateControlsState()
	{
		form.btnSave().setVisible(FormMode.EDIT.equals(form.getMode()));
		form.btnCancel().setText(FormMode.EDIT.equals(form.getMode()) ? "Cancel" : "Close");
		form.btnCancel().setVisible(true);
		form.btnUpdate().setVisible(FormMode.VIEW.equals(form.getMode()));
	}

}
