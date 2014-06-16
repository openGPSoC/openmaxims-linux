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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.30 build 2042.15859)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.forms.orderentrytemplateedit;

import java.util.ArrayList;

import ims.configuration.gen.ConfigFlag;
import ims.admin.vo.AppRoleShortVo;
import ims.admin.vo.AppRoleShortVoCollection;
import ims.core.vo.LocSiteShortVo;
import ims.core.vo.LocSiteShortVoCollection;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.ocrr.vo.InvestShortVo;
import ims.ocrr.vo.InvestShortVoCollection;
import ims.ocrr.vo.OrderEntryTemplateColumnVo;
import ims.ocrr.vo.OrderEntryTemplateComponentShortVo;
import ims.ocrr.vo.OrderEntryTemplateVo;
import ims.ocrr.vo.OrderSetShortVo;
import ims.ocrr.vo.OrderSetShortVoCollection;
import ims.ocrr.vo.TemplateLocationShortVo;
import ims.ocrr.vo.TemplateLocationShortVoCollection;
import ims.ocrr.vo.TemplateRoleShortVo;
import ims.ocrr.vo.TemplateRoleShortVoCollection;
import ims.ocrr.vo.lookups.ItemSelectionType;
import ims.ocrr.vo.lookups.TemplateDividerType;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		initialize();
		open();
	}
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if(result.equals(DialogResult.OK) && formName.equals(form.getForms().OCRR.ItemSelection))
		{
			addSelectedItems();
		}
	}
	protected void onLnkReturnClick() throws PresentationLogicException 
	{
		returnToList();
	}
	protected void onBtnPreviewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		previewSelected();
	}
	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			returnToList();
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		returnToList();
	}
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.OCRROrderEntryTemplateEdit.ADDCOLUMNSEPARATOR:
				addColumnSeparator();
				break;
			case GenForm.ContextMenus.OCRROrderEntryTemplateEdit.ADDSEPARATOR:
				addSeparator();
				break;
			case GenForm.ContextMenus.OCRROrderEntryTemplateEdit.ADDINVESTIGATION:
				addInvestigations();
				break;
			case GenForm.ContextMenus.OCRROrderEntryTemplateEdit.ADDPROFILES:
				addProfiles();
				break;
			case GenForm.ContextMenus.OCRROrderEntryTemplateEdit.ADDORDERSETS:
				addOrderSets();
				break;
			case GenForm.ContextMenus.OCRROrderEntryTemplateEdit.REMOVE:
				removeSelectedComponent();
				break;
			case GenForm.ContextMenus.OCRROrderEntryTemplateEdit.MOVEUP:
				moveUp();
				break;
			case GenForm.ContextMenus.OCRROrderEntryTemplateEdit.MOVEDOWN:
				moveDown();
				break;
		}
		setComponentsContextMenuState();
	}
	protected void onFormModeChanged() 
	{
		setComponentsContextMenuState();
		setSeparatorControlProperties();
	}
	protected void onGrdComponentsSelectionChanged() throws PresentationLogicException 
	{
		setComponentsContextMenuState();
		setSeparatorControlProperties();
	}
	protected void onChkSeparatorIsBoldValueChanged() throws PresentationLogicException 
	{
		updateSeparatorComponentData();
	}
	protected void onCmbColorSeparatorValueChanged() throws PresentationLogicException 
	{
		updateSeparatorComponentData();
	}
	protected void onTxtTextSeparatorValueChanged() throws PresentationLogicException 
	{
		updateSeparatorComponentData();
	}
	private void initialize()
	{
		if(form.getGlobalContext().OCRR.getOrderEntryTemplateEditorReadOnlyIsNotNull())
		{
			form.setMode(form.getGlobalContext().OCRR.getOrderEntryTemplateEditorReadOnly().booleanValue() ? FormMode.VIEW : FormMode.EDIT);			
		}
		
		populateSeparatorColors();
		setComponentsContextMenuState();
	}
	private void setComponentsContextMenuState()
	{
		boolean editable = form.getMode() == FormMode.EDIT;		
		boolean selected = editable && form.lyrDetails().tabComponents().grdComponents().getSelectedRowIndex() >= 0;
		boolean canMoveUp = selected && form.lyrDetails().tabComponents().grdComponents().canMoveCurrentUp();
		boolean canMoveDown = selected && form.lyrDetails().tabComponents().grdComponents().canMoveCurrentDown();
		
		form.getContextMenus().getOCRROrderEntryTemplateEditADDINVESTIGATIONItem().setVisible(editable);
		form.getContextMenus().getOCRROrderEntryTemplateEditADDPROFILESItem().setVisible(editable);
		form.getContextMenus().getOCRROrderEntryTemplateEditADDORDERSETSItem().setVisible(editable);
		form.getContextMenus().getOCRROrderEntryTemplateEditADDSEPARATORItem().setVisible(editable);
		form.getContextMenus().getOCRROrderEntryTemplateEditADDCOLUMNSEPARATORItem().setVisible(editable);
		form.getContextMenus().getOCRROrderEntryTemplateEditMOVEUPItem().setVisible(canMoveUp);
		form.getContextMenus().getOCRROrderEntryTemplateEditMOVEDOWNItem().setVisible(canMoveDown);
		form.getContextMenus().getOCRROrderEntryTemplateEditREMOVEItem().setVisible(selected);
	}
	private void open()
	{
		if(form.getGlobalContext().OCRR.getSelectedOrderEntryTemplateIDIsNotNull())
		{
			OrderEntryTemplateVo record = domain.getOrderEntryTemplate(form.getGlobalContext().OCRR.getSelectedOrderEntryTemplateID());
			if(record != null)
			{
				form.getLocalContext().setEditedRecord(record);
				populateScreenFromData(record);
				processComponentColumns();
			}
			else
				engine.showMessage("Order entry template not found");
		}
		else
		{
			form.cmbStatus().setValue(PreActiveActiveInactiveStatus.PREACTIVE);
			loadLocations();
			loadRoles();
			processComponentColumns();
		}
	}
	private void loadLocations()
	{
		LocSiteShortVoCollection locations = domain.getLocations();
		form.lyrDetails().tabLocations().grdLocations().getRows().clear();
		
		if(locations == null)
			return;
		
		locations.sort();		
		for(int x = 0; x < locations.size(); x++)
		{
			addLocationSite(locations.get(x));
		}
	}	
	private void addLocationSite(LocSiteShortVo location)
	{
		if(location == null)
			return;
		if(location.getID_LocationIsNotNull() && location.getID_Location().intValue() == 0)
			return;
		
		GenForm.lyrDetailsLayer.tabLocationsContainer.grdLocationsRow row = form.lyrDetails().tabLocations().grdLocations().getRows().newRow();
		TemplateLocationShortVo templateLocation = new TemplateLocationShortVo();
		templateLocation.setLocation(location);
		templateLocation.setIsActive(Boolean.TRUE);		
		row.setcolImage(form.getImages().Admin.LocationSite);
		row.setcolName(location.getName());
		row.setValue(templateLocation);
	}
	private void loadRoles()
	{
		AppRoleShortVoCollection roles = domain.listRolesShort();
		form.lyrDetails().tabRoles().grdRoles().getRows().clear();
		if(roles == null)
			return;
		
		roles.sort();
		for(int i = 0; i < roles.size(); i++)
		{
			addRole(roles.get(i));
		}
		
	}
	private void addRole(AppRoleShortVo role)
	{
		if(role == null)
			return;
		
		GenForm.lyrDetailsLayer.tabRolesContainer.grdRolesRow row = form.lyrDetails().tabRoles().grdRoles().getRows().newRow();
		TemplateRoleShortVo voTemplateRole = new TemplateRoleShortVo();
		voTemplateRole.setIsActive(Boolean.TRUE);
		voTemplateRole.setAppRole(role);
		row.setcolImage(form.getImages().OCRR.Role);
		row.setcolRole(role.getName());
		row.setValue(voTemplateRole);
	}
	
	private void previewSelected()
	{		
		OrderEntryTemplateVo record = form.getLocalContext().getEditedRecord();
		if(record == null)
			record = new OrderEntryTemplateVo();
		
		record = populateDataFromScreen(record);
		
		form.getGlobalContext().OCRR.setPreviewedOrderEntryTemplate(record);		
		engine.open(form.getForms().OCRR.OrderEntryTemplatePreviewDialog);
	}	
	
	private boolean save()
	{
		OrderEntryTemplateVo record = form.getLocalContext().getEditedRecord();
		if(record == null)
			record = new OrderEntryTemplateVo();
		
		record = populateDataFromScreen(record);
		if(!record.getActiveStatusIsNotNull())
			record.setActiveStatus(PreActiveActiveInactiveStatus.PREACTIVE);
		
		String[] errors = record.validate(validateData(record));
		if(errors != null)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try 
		{
			record = domain.saveOrderEntryTemplate(record);
		} 
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			return false;
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return false;
		}
		
		if(record != null && record.getID_OrderEntryTemplateIsNotNull())
			form.getGlobalContext().OCRR.setSelectedOrderEntryTemplateID(record.getID_OrderEntryTemplate());
		
		return true;
	}
	private String[] validateData(OrderEntryTemplateVo record) 
	{
		if(record == null)
			throw new CodingRuntimeException("Invalid template record");
		
		if(record.getActiveStatus() == null || !record.getActiveStatus().equals(PreActiveActiveInactiveStatus.ACTIVE))
			return null;
		
		ArrayList errors = new ArrayList();
		
		if(record.getComponents() == null || record.getComponents().size() == 0)
		{
			errors.add("No template components configured");
		}
		else
		{
			boolean exist = false;
			for(int x = 0; x < record.getComponents().size(); x++)
			{
				OrderEntryTemplateComponentShortVo component = record.getComponents().get(x);
				if(component == null || (component.getInvestigation() == null && component.getOrderSet() == null && component.getDivider() == null))
				{
					errors.add("Invalid template component at position #" + String.valueOf(x + 1));
				}				
				else if(component.getInvestigation() != null || component.getOrderSet() != null)
				{
					exist = true;
					break;
				}
			}
			
			if(!exist)
				errors.add("No template components configured");
		}
		
		if (record.getTemplatesLocations() == null || record.getTemplatesLocations().size() == 0)
		{
			errors.add("No location(s) configured for Template");
		}
		else
		{
			boolean exist = false;
			for(int x = 0; x < record.getTemplatesLocations().size(); x++)
			{
				TemplateLocationShortVo templLocVo = record.getTemplatesLocations().get(x);			
				if(templLocVo.getIsActive().booleanValue())
				{
					exist = true;
					break;
				}
			}
			
			if(!exist)
				errors.add("No location(s) configured for Template");
		}
		if (record.getTemplateRoles() == null || record.getTemplateRoles().size() == 0)
		{
			errors.add("No role(s) configured for Template");
		}
		else
		{
			boolean exist = false;
			for(int x = 0; x < record.getTemplateRoles().size(); x++)
			{
				TemplateRoleShortVo templRoleVo = record.getTemplateRoles().get(x);			
				if(templRoleVo.getIsActive().booleanValue())
				{
					exist = true;
					break;
				}
			}
			
			if(!exist)
				errors.add("No role(s) configured for Template");
		}
		if(errors.size() == 0)
			return null;
		
		String[] err = new String[errors.size()];
		for(int x = 0; x < errors.size(); x++)
		{
			err[x] = (String)errors.get(x);
		}
		
		return err;
	}
	private void returnToList()
	{
		engine.open(form.getForms().OCRR.OrderEntryTemplateList);
	}	
	private void addColumnSeparator()
	{		
		OrderEntryTemplateComponentShortVo component = new OrderEntryTemplateComponentShortVo();
		component.setDivider(TemplateDividerType.COLUMNSEPARATOR);
		addComponent(component, true);
		processComponentColumns();
	}
	private void addSeparator()
	{		
		OrderEntryTemplateComponentShortVo component = new OrderEntryTemplateComponentShortVo();
		component.setDivider(TemplateDividerType.SEPARATOR);
		addComponent(component, true);
	}
	private void addInvestigations()
	{		
		selectItems(ItemSelectionType.INVESTIGATION);
	}
	private void addProfiles()
	{
		selectItems(ItemSelectionType.PROFILE);
	}
	private void addOrderSets()
	{
		selectItems(ItemSelectionType.ORDERSET);
	}
	private void selectItems(ItemSelectionType type)
	{
		form.getGlobalContext().OCRR.setSelectedInvestigations(null);
		form.getGlobalContext().OCRR.setSelectedProfiles(null);
		form.getGlobalContext().OCRR.setSelectedOrderSets(null);
		form.getGlobalContext().OCRR.setItemSelectionType(type);
		engine.open(form.getForms().OCRR.ItemSelection);
	}
	private void removeSelectedComponent()
	{		
		if(form.lyrDetails().tabComponents().grdComponents().getValue() != null)
		{
			OrderEntryTemplateComponentShortVo component = form.lyrDetails().tabComponents().grdComponents().getValue();
			if(component.getDividerIsNotNull() && component.getDivider().equals(TemplateDividerType.COLUMNSEPARATOR))
				removeCorrectColumnName();
			form.lyrDetails().tabComponents().grdComponents().removeSelectedRow();
			processComponentColumns();
		}
	}
	private void moveUp()
	{		
		form.lyrDetails().tabComponents().grdComponents().moveUp();
	}
	private void moveDown()
	{	
		form.lyrDetails().tabComponents().grdComponents().moveDown();
	}
	private GenForm.lyrDetailsLayer.tabComponentsContainer.grdComponentsRow addComponentRowAfterSelection(boolean select)
	{
		int curentSelectionIndex = form.lyrDetails().tabComponents().grdComponents().getSelectedRowIndex();
		if(curentSelectionIndex < 0 || curentSelectionIndex == form.lyrDetails().tabComponents().grdComponents().getRows().size())
		{
			return form.lyrDetails().tabComponents().grdComponents().getRows().newRow(select);
		}
		
		return form.lyrDetails().tabComponents().grdComponents().getRows().newRowAt(curentSelectionIndex, select);				
	}
	private void addComponent(OrderEntryTemplateComponentShortVo component, boolean select)
	{
		if(component == null)
			return;
		
		GenForm.lyrDetailsLayer.tabComponentsContainer.grdComponentsRow row = addComponentRowAfterSelection(select);
		row.setValue(component);
		
		//divider (column or row)
		if(component.getDividerIsNotNull())
		{
			if(component.getDivider().equals(TemplateDividerType.COLUMNSEPARATOR))
			{
				row.setcolImage(form.getImages().OCRR.ColumnSeparator);
				row.setcolName("[Column Separator]");
			}
			if(component.getDivider().equals(TemplateDividerType.SEPARATOR))
			{
				row.setcolImage(form.getImages().OCRR.Separator);
				row.setcolName("[Separator]");
			}
		}		
		// investigation or profile
		else if(component.getInvestigationIsNotNull())
		{
			InvestShortVo item = component.getInvestigation();
		
			if(item.getInvestigationIndexIsNotNull())
			{
				row.setcolName(item.getNameWithLocationInfo());
				
				if(item.getInvestigationIndex().getIsProfileIsNotNull() && item.getInvestigationIndex().getIsProfile().booleanValue())	
					row.setcolImage(form.getImages().OCRR.Profile);				
				else
					row.setcolImage(form.getImages().OCRR.Investigation);		
			}
			
			row.setcolStatus(item.getActiveStatus());
		}
		// order set
		else if(component.getOrderSetIsNotNull())
		{
			OrderSetShortVo item = component.getOrderSet();
			row.setcolName(item.getName());
			row.setcolImage(form.getImages().OCRR.OrderSet);
			row.setcolStatus(item.getActiveStatus());
		}
		
		setSeparatorControlProperties();
	}
	private void addSelectedItems()
	{
		// investigations
		if(form.getGlobalContext().OCRR.getSelectedInvestigationsIsNotNull())
		{
			InvestShortVoCollection selectedInvestigations = form.getGlobalContext().OCRR.getSelectedInvestigations();  
			for(int x = 0; x < selectedInvestigations.size(); x++)
			{
				InvestShortVo item = selectedInvestigations.get(x);
				OrderEntryTemplateComponentShortVo component = new OrderEntryTemplateComponentShortVo();
				component.setInvestigation(item);
				addComponent(component, false);
			}		
		}
		
		// profiles
		if(form.getGlobalContext().OCRR.getSelectedProfilesIsNotNull())
		{
			InvestShortVoCollection selectedProfiles = form.getGlobalContext().OCRR.getSelectedProfiles();  
			for(int x = 0; x < selectedProfiles.size(); x++)
			{
				InvestShortVo item = selectedProfiles.get(x);
				OrderEntryTemplateComponentShortVo component = new OrderEntryTemplateComponentShortVo();
				component.setInvestigation(item);
				addComponent(component, false);
			}		
		}
		
		//	order sets
		if(form.getGlobalContext().OCRR.getSelectedOrderSetsIsNotNull())
		{
			OrderSetShortVoCollection selectedOrderSets = form.getGlobalContext().OCRR.getSelectedOrderSets();  
			for(int x = 0; x < selectedOrderSets.size(); x++)
			{
				OrderSetShortVo item = selectedOrderSets.get(x);
				OrderEntryTemplateComponentShortVo component = new OrderEntryTemplateComponentShortVo();
				component.setOrderSet(domain.getOrderSet(item));
				addComponent(component, false);
			}		
		}
	}
	private void processComponentColumns()
	{
		int columnCount = countColumnSeparators();
		int existingColumnCount = form.lyrDetails().tabComponents().grdColumnNames().getRows().size();
		String[] exisingColumnNames = new String[existingColumnCount];
		for(int x = 0; x < form.lyrDetails().tabComponents().grdColumnNames().getRows().size(); x++)
		{
			exisingColumnNames[x] = form.lyrDetails().tabComponents().grdColumnNames().getRows().get(x).getcolName();
		}
		
		form.lyrDetails().tabComponents().grdColumnNames().getRows().clear();
		for(int x = 0; x < columnCount; x++)
		{
			GenForm.lyrDetailsLayer.tabComponentsContainer.grdColumnNamesRow row = form.lyrDetails().tabComponents().grdColumnNames().getRows().newRow();
			if(x + 1 > existingColumnCount)
				row.setcolName("Untitled (" + (x + 1) + ")");
			else
				row.setcolName(exisingColumnNames[x]);
			row.setcolImage(form.getImages().OCRR.ColumnSeparator);
		}
	}
	private int countColumnSeparators()
	{
		int count = 0;
		for(int x = 0; x < form.lyrDetails().tabComponents().grdComponents().getRows().size(); x++)
		{
			GenForm.lyrDetailsLayer.tabComponentsContainer.grdComponentsRow row = form.lyrDetails().tabComponents().grdComponents().getRows().get(x);
			OrderEntryTemplateComponentShortVo component = row.getValue();
			if(component != null && component.getDividerIsNotNull() && component.getDivider().equals(TemplateDividerType.COLUMNSEPARATOR))
				count++;
		}
		return count + 1;
	}
	private void clearScreen()
	{
		this.form.cmbCategory().setValue(null);
		this.form.txtDescription().setValue("");
		this.form.txtMenuName().setValue("");
		this.form.txtFormName().setValue("");
		this.form.cmbStatus().setValue(null);
		this.form.lyrDetails().tabComponents().grdComponents().getRows().clear();
		this.form.lyrDetails().tabComponents().grdColumnNames().getRows().clear();
		this.form.lyrDetails().tabLocations().grdLocations().getRows().clear();
		this.form.lyrDetails().tabRoles().grdRoles().getRows().clear();
	}
	private void populateScreenFromData(ims.ocrr.vo.OrderEntryTemplateVo value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.cmbCategory().setValue(value.getTemplateCategoryIsNotNull() ? value.getTemplateCategory() : null);
		this.form.txtDescription().setValue(value.getDescriptionIsNotNull() ? value.getDescription(): null);
		this.form.txtMenuName().setValue(value.getMenuNameIsNotNull() ? value.getMenuName(): null);
		this.form.txtFormName().setValue(value.getFormNameIsNotNull() ? value.getFormName(): null);
		this.form.cmbStatus().setValue(value.getActiveStatusIsNotNull() ? value.getActiveStatus() : null);
		this.form.lyrDetails().tabText().richFormText().setValue(value.getFormTextIsNotNull()? value.getFormText() : null);

		// ----- Start of grdComponents Grid --------------------------
		ims.ocrr.vo.OrderEntryTemplateComponentShortVoCollection fieldgrdComponents = value.getComponentsIsNotNull() ? value.getComponents() : null;
		if(fieldgrdComponents != null)
		{
			fieldgrdComponents.sort();
			for(int x = 0; x < fieldgrdComponents.size(); x++)
			{
				if(fieldgrdComponents.get(x) != null)
				{
					this.addComponent(fieldgrdComponents.get(x), false);
				}
			}
		}
		// ----- End of grdComponents Grid ----------------------------
		
		// ----- Start of grdColumnNames Grid --------------------------
		ims.ocrr.vo.OrderEntryTemplateColumnVoCollection fieldgrdColumnNames = value.getColumnsIsNotNull() ? value.getColumns() : null;
		if(fieldgrdColumnNames != null)
		{
			fieldgrdColumnNames.sort();
			
			GenForm.lyrDetailsLayer.tabComponentsContainer.grdColumnNamesRow rowgrdColumnNames;
			for(int x = 0; x < fieldgrdColumnNames.size(); x++)
			{
				if(fieldgrdColumnNames.get(x) != null)
				{
					rowgrdColumnNames = this.form.lyrDetails().tabComponents().grdColumnNames().getRows().newRow();
					rowgrdColumnNames.setcolImage(form.getImages().OCRR.ColumnSeparator);
					rowgrdColumnNames.setcolName(fieldgrdColumnNames.get(x).getColName());					
				}
			}
		}
		// ----- End of grdColumnNames Grid ----------------------------
		
		// Start Locations --------------	
		loadLocations();
				
		if(value.getTemplatesLocationsIsNotNull())
		{
			for(int x = 0; x < value.getTemplatesLocations().size(); x++)
			{				
				TemplateLocationShortVo tlItem = value.getTemplatesLocations().get(x); 
				if(tlItem != null && tlItem.getIsActiveIsNotNull() && tlItem.getIsActive().booleanValue())
					selectLocation(value.getTemplatesLocations().get(x).getLocation());
			}
		}		
		// End Locations ----------------
		
		// Start Roles -------------------
		loadRoles();
		
		if(value.getTemplateRolesIsNotNull())
		{
			for(int i = 0; i < value.getTemplateRoles().size(); i++)
			{
				TemplateRoleShortVo voTemplateShort = value.getTemplateRoles().get(i);
				if(voTemplateShort != null && voTemplateShort.getIsActiveIsNotNull() && voTemplateShort.getIsActive().booleanValue())
				{
					selectRole(voTemplateShort.getAppRole());
				}
			}
		}
		// End Roles ---------------------
	}

	private boolean isSelected(LocSiteShortVo location)
	{
		if(location == null)
			return false;
		
		for(int x = 0; x < form.lyrDetails().tabLocations().grdLocations().getRows().size(); x++)
		{
			GenForm.lyrDetailsLayer.tabLocationsContainer.grdLocationsRow row = form.lyrDetails().tabLocations().grdLocations().getRows().get(x);
			if(row.getValue() != null && row.getValue().getLocationIsNotNull() && row.getValue().getLocation().equals(location))
				return row.getcolSelection();		
		}
		
		return false;
	}
	

	private boolean isRoleSelected(AppRoleShortVo appRoleVo)
	{
		if(appRoleVo == null)
			return false;
		
		for(int i = 0; i < form.lyrDetails().tabRoles().grdRoles().getRows().size(); i++)
		{
			GenForm.lyrDetailsLayer.tabRolesContainer.grdRolesRow row = form.lyrDetails().tabRoles().grdRoles().getRows().get(i);
			if(row.getValue() != null && row.getValue().getAppRoleIsNotNull() && row.getValue().getAppRole().equals(appRoleVo))
				return row.getcolSelect();
		}
		
		return false;
	}
	
	private boolean selectLocation(LocSiteShortVo location)
	{
		if(location == null)
			return false;
		
		for(int x = 0; x < form.lyrDetails().tabLocations().grdLocations().getRows().size(); x++)
		{
			GenForm.lyrDetailsLayer.tabLocationsContainer.grdLocationsRow row = form.lyrDetails().tabLocations().grdLocations().getRows().get(x);
			if(row.getValue() != null && row.getValue().getLocationIsNotNull() && row.getValue().getLocation().equals(location))
			{
				row.setcolSelection(true);
				return true;
			}
		}
		
		return false;
	}
	
	
	private void selectRole(AppRoleShortVo appRoleShortVo)
	{
		if(appRoleShortVo == null)
			return;
		
		for(int i = 0; i < form.lyrDetails().tabRoles().grdRoles().getRows().size(); i++)
		{
			GenForm.lyrDetailsLayer.tabRolesContainer.grdRolesRow row = form.lyrDetails().tabRoles().grdRoles().getRows().get(i);
			if(row.getValue() != null && row.getValue().getAppRoleIsNotNull() && row.getValue().getAppRole().equals(appRoleShortVo))
			{
				row.setcolSelect(true);
				return;
			}
		}
		
	}
	private ims.ocrr.vo.OrderEntryTemplateVo populateDataFromScreen(ims.ocrr.vo.OrderEntryTemplateVo value)
	{
		if(value == null)
			value = new ims.ocrr.vo.OrderEntryTemplateVo();

		value.setTemplateCategory(this.form.cmbCategory().getValue());
		value.setDescription(this.form.txtDescription().getValue());
		value.setMenuName(this.form.txtMenuName().getValue());
		value.setFormName(this.form.txtFormName().getValue());
		value.setActiveStatus(this.form.cmbStatus().getValue());
		value.setFormText(this.form.lyrDetails().tabText().richFormText().getValue());
		
		// ----- Start of grdComponents Grid --------------------------
		value.setComponents(new ims.ocrr.vo.OrderEntryTemplateComponentShortVoCollection());
		for(int x = 0; x < this.form.lyrDetails().tabComponents().grdComponents().getRows().size(); x++)
		{
			ims.ocrr.vo.OrderEntryTemplateComponentShortVo rowValue = this.form.lyrDetails().tabComponents().grdComponents().getRows().get(x).getValue();
			if(rowValue == null)
				rowValue = new ims.ocrr.vo.OrderEntryTemplateComponentShortVo();

			rowValue.setSequence(new Integer(x + 1));
			if(value.getComponentsIsNotNull())
				value.getComponents().add(rowValue);
		}
		// ----- End of grdComponents Grid ----------------------------
		
		// ----- Start of grdColumnNames Grid --------------------------
		value.setColumns(new ims.ocrr.vo.OrderEntryTemplateColumnVoCollection());
		for(int x = 0; x < this.form.lyrDetails().tabComponents().grdColumnNames().getRows().size(); x++)
		{
			ims.ocrr.vo.OrderEntryTemplateColumnVo rowValue = new OrderEntryTemplateColumnVo();
			rowValue.setColIndex(new Integer(x + 1));
			rowValue.setColName(this.form.lyrDetails().tabComponents().grdColumnNames().getRows().get(x).getcolName());
			if(value.getColumnsIsNotNull())
				value.getColumns().add(rowValue);
		}
		// ----- End of grdColumnNames Grid ----------------------------

		// Start Locations --------------
		TemplateLocationShortVoCollection locations = value.getTemplatesLocations();
		if(locations == null)
			locations = new TemplateLocationShortVoCollection();
		
		//scan previously selected locations and inactivate them if needed
		for(int x = 0; x < locations.size(); x++)
		{
			TemplateLocationShortVo tlItem = locations.get(x);
			tlItem.setIsActive(new Boolean(isSelected(tlItem.getLocation())));
			tlItem.setOETemplate(value);
		}
		//add new selected locations
		for(int x = 0; x < this.form.lyrDetails().tabLocations().grdLocations().getRows().size(); x++)
		{
			if(this.form.lyrDetails().tabLocations().grdLocations().getRows().get(x).getcolSelection())
			{
				TemplateLocationShortVo item = this.form.lyrDetails().tabLocations().grdLocations().getRows().get(x).getValue();				
				if(item != null && !locationExists(locations, item.getLocation()))
				{
					item.setOETemplate(value);
					item.setIsActive(Boolean.TRUE);
					locations.add(item);
				}
			}
		}				
		value.setTemplatesLocations(locations);
		// End Locations ----------------
		
		//Start Roles
		TemplateRoleShortVoCollection roles = value.getTemplateRoles();
		if(roles == null)
			roles = new TemplateRoleShortVoCollection();
				
		//scan previously selected roles and activate/inactivate them
		for(int i=0; i < roles.size(); i++)
		{
			TemplateRoleShortVo voTRole = roles.get(i);
			voTRole.setIsActive(new Boolean(isRoleSelected(voTRole.getAppRole())));
			voTRole.setOETemplate(value);
		}

		for(int i = 0; i < this.form.lyrDetails().tabRoles().grdRoles().getRows().size(); i++)
		{
			if(this.form.lyrDetails().tabRoles().grdRoles().getRows().get(i).getcolSelect())
			{
				TemplateRoleShortVo voTemplateShort = form.lyrDetails().tabRoles().grdRoles().getRows().get(i).getValue();
				if(voTemplateShort != null && !roleExists(roles, voTemplateShort.getAppRole()))
				{
					voTemplateShort.setOETemplate(value);
					voTemplateShort.setIsActive(Boolean.TRUE);
					roles.add(voTemplateShort);
				}
			}
		}
		
		value.setTemplateRoles(roles);
		// End Roles ---------------------
		return value;
	}
	private boolean locationExists(TemplateLocationShortVoCollection templateLocations, LocSiteShortVo location)
	{
		if(templateLocations == null || location == null)
			return false;
		
		for(int x = 0; x < templateLocations.size(); x++)
		{
			TemplateLocationShortVo item = templateLocations.get(x);
			if(item != null && item.getLocationIsNotNull() && item.getLocation().equals(location))
				return true;
		}
		
		return false;
	}
	private boolean roleExists(TemplateRoleShortVoCollection roles, AppRoleShortVo appRoleVo)
	{
		if(roles == null || appRoleVo == null)
			return false;
		
		for(int i = 0; i < roles.size(); i++)
		{
			TemplateRoleShortVo voTemplateRoleShort = roles.get(i);
			if(voTemplateRoleShort != null && voTemplateRoleShort.getAppRoleIsNotNull() && voTemplateRoleShort.getAppRole().equals(appRoleVo))
				return true;
		}
		return false;
	}
	private void removeCorrectColumnName()
	{
		int colNameIndex = 0;
		OrderEntryTemplateComponentShortVo component = null;
		if(form.lyrDetails().tabComponents().grdComponents().getValue() != null)
		{
			component = form.lyrDetails().tabComponents().grdComponents().getValue();			
			if(component != null && component.getDividerIsNotNull() && component.getDivider().equals(TemplateDividerType.COLUMNSEPARATOR))
			{
				for(int x = 0; x < form.lyrDetails().tabComponents().grdComponents().getRows().size(); x++)
				{
					OrderEntryTemplateComponentShortVo item = form.lyrDetails().tabComponents().grdComponents().getRows().get(x).getValue();
					if(item != null && item.getDividerIsNotNull() && item.getDivider().equals(TemplateDividerType.COLUMNSEPARATOR))
					{
						if(item.equals(component) && form.lyrDetails().tabComponents().grdColumnNames().getRows().size() - 1 >= colNameIndex + 1)
						{
							form.lyrDetails().tabComponents().grdColumnNames().getRows().remove(colNameIndex + 1);
							return;
						}
						else
						{
							colNameIndex++;
						}
					}
				}
			}
		}
	}	
	void updateSeparatorComponentData()
	{
		OrderEntryTemplateComponentShortVo component = form.lyrDetails().tabComponents().grdComponents().getValue();
		
		if(component != null && component.getDivider().equals(TemplateDividerType.SEPARATOR))
		{
			component.setDividerColour(form.lyrDetails().tabComponents().cmbColorSeparator().getValue());
			component.setDividerText(form.lyrDetails().tabComponents().txtTextSeparator().getValue());
			component.setDividerIsBold(new Boolean(form.lyrDetails().tabComponents().chkSeparatorIsBold().getValue()));
		}
	}
	void setSeparatorControlProperties()
	{
		OrderEntryTemplateComponentShortVo component = form.lyrDetails().tabComponents().grdComponents().getValue();
		
		boolean updateable = component != null && component.getDivider() != null && component.getDivider().equals(TemplateDividerType.SEPARATOR);
		boolean editable = updateable && form.getMode() == FormMode.EDIT;
			
		form.lyrDetails().tabComponents().txtTextSeparator().setEnabled(editable);
		form.lyrDetails().tabComponents().cmbColorSeparator().setEnabled(editable);
		form.lyrDetails().tabComponents().chkSeparatorIsBold().setEnabled(editable);
		
		if(updateable)
		{
			form.lyrDetails().tabComponents().txtTextSeparator().setValue(component.getDividerText());
			form.lyrDetails().tabComponents().cmbColorSeparator().setValue(component.getDividerColour());
			form.lyrDetails().tabComponents().chkSeparatorIsBold().setValue(component.getDividerIsBold() == null ? false : component.getDividerIsBold().booleanValue());
		}		
		else
		{
			form.lyrDetails().tabComponents().txtTextSeparator().setValue(null);
			form.lyrDetails().tabComponents().cmbColorSeparator().setValue(null);
			form.lyrDetails().tabComponents().chkSeparatorIsBold().setValue(false);
		}
	}
	void populateSeparatorColors()
	{
		Color[] ca = Color.getColors();
		for (int i = 0; i < ca.length; i++)
		{
			form.lyrDetails().tabComponents().cmbColorSeparator().newRow(ca[i], ca[i].getName(), ca[i].getImage());
		}
	}
	@Override
	protected void onGrdComponentsSelectionCleared() throws PresentationLogicException
	{
		setComponentsContextMenuState();
		setSeparatorControlProperties();
	}
}
