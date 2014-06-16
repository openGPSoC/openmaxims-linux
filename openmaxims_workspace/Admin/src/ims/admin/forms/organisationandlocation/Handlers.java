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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.admin.forms.organisationandlocation;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode, ims.framework.interfaces.IClearInfo
{
	abstract protected void bindgrdOrgMappingscolExtCodeTypeLookup();
	abstract protected void bindcmbOrgCountyLookup();
	abstract protected void defaultcmbOrgCountyLookupValue();
	abstract protected void bindcmbOrgTypeLookup();
	abstract protected void defaultcmbOrgTypeLookupValue();
	abstract protected void bindgrdLocMappingscolExtCodeTypeLookup();
	abstract protected void bindcmbLocCountyLookup();
	abstract protected void defaultcmbLocCountyLookupValue();
	abstract protected void bindcmbLocTypeLookup();
	abstract protected void defaultcmbLocTypeLookupValue();
	abstract protected void bindgrdSiteMappingscolExtCodeTypeLookup();
	abstract protected void bindcmbLocSiteCountyLookup();
	abstract protected void defaultcmbLocSiteCountyLookupValue();
	abstract protected void bindcmbLocSiteTypeLookup();
	abstract protected void defaultcmbLocSiteTypeLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkActiveOnlyValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdOrgMappingsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbOrgCountyValueSet(Object value);
	abstract protected void oncmbOrgTypeValueSet(Object value);
	abstract protected void onBtnLocPrinterSelectClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdLocMappingsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbLocCountyValueSet(Object value);
	abstract protected void oncmbLocTypeValueSet(Object value);
	abstract protected void onCmbLocTypeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnLsPrinterSelectClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdSiteMappingsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbLocSiteCountyValueSet(Object value);
	abstract protected void oncmbLocSiteTypeValueSet(Object value);
	abstract protected void onCmbLocSiteTypeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTreOrgLocTreeViewNodeDropped(ims.framework.controls.TreeNode node, ims.framework.controls.TreeNode previousParentNode) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTreOrgLocTreeViewNodeExpandCollapse(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTreOrgLocTreeViewNodeEdited(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTreOrgLocTreeViewSelectionCleared() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTreOrgLocTreeViewSelectionChanged(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormModeChangedEvent(new FormModeChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle()
			{
				onFormModeChanged();
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen();
			}
		});
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.chkActiveOnly().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkActiveOnlyValueChanged();
			}
		});
		this.form.ctn1().lyr1().tabOrg().grdOrgMappings().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdOrgMappingsSelectionChanged();
			}
		});
		this.form.ctn1().lyr1().tabOrg().cmbOrgCounty().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbOrgCountyValueSet(value);
			}
		});
		this.form.ctn1().lyr1().tabOrg().cmbOrgType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbOrgTypeValueSet(value);
			}
		});
		this.form.ctn1().lyr1().tabLoc().btnLocPrinterSelect().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnLocPrinterSelectClick();
			}
		});
		this.form.ctn1().lyr1().tabLoc().grdLocMappings().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdLocMappingsSelectionChanged();
			}
		});
		this.form.ctn1().lyr1().tabLoc().cmbLocCounty().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbLocCountyValueSet(value);
			}
		});
		this.form.ctn1().lyr1().tabLoc().cmbLocType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbLocTypeValueSet(value);
			}
		});
		this.form.ctn1().lyr1().tabLoc().cmbLocType().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbLocTypeValueChanged();
			}
		});
		this.form.ctn1().lyr1().tabLocSite().btnLsPrinterSelect().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnLsPrinterSelectClick();
			}
		});
		this.form.ctn1().lyr1().tabLocSite().grdSiteMappings().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdSiteMappingsSelectionChanged();
			}
		});
		this.form.ctn1().lyr1().tabLocSite().cmbLocSiteCounty().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbLocSiteCountyValueSet(value);
			}
		});
		this.form.ctn1().lyr1().tabLocSite().cmbLocSiteType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbLocSiteTypeValueSet(value);
			}
		});
		this.form.ctn1().lyr1().tabLocSite().cmbLocSiteType().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbLocSiteTypeValueChanged();
			}
		});
		this.form.treOrgLoc().setTreeViewNodeDroppedEvent(new TreeViewNodeDropped()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.TreeNode node, ims.framework.controls.TreeNode previousParentNode) throws ims.framework.exceptions.PresentationLogicException
			{
				onTreOrgLocTreeViewNodeDropped(node, previousParentNode);
			}
		});
		this.form.treOrgLoc().setTreeViewNodeExpandedCollapsedEvent(new TreeViewNodeExpandedCollapsed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException
			{
				onTreOrgLocTreeViewNodeExpandCollapse(node);
			}
		});
		this.form.treOrgLoc().setTreeViewNodeEditedEvent(new TreeViewNodeEdited()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException
			{
				onTreOrgLocTreeViewNodeEdited(node);
			}
		});
		this.form.treOrgLoc().setTreeViewSelectionClearedEvent(new TreeViewSelectionCleared()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onTreOrgLocTreeViewSelectionCleared();
			}
		});
		this.form.treOrgLoc().setTreeViewSelectionChangedEvent(new TreeViewSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException
			{
				onTreOrgLocTreeViewSelectionChanged(node);
			}
		});
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveClick();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClick();
			}
		});
		this.form.getContextMenus().getGenericGridAddItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Add, sender);
			}
		});
		this.form.getContextMenus().getGenericGridUpdateItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Update, sender);
			}
		});
		this.form.getContextMenus().getGenericGridRemoveItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Remove, sender);
			}
		});
		this.form.getContextMenus().getGenericGridViewItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.View, sender);
			}
		});
		this.form.getContextMenus().getGenericGridMoveUpItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.MoveUp, sender);
			}
		});
		this.form.getContextMenus().getGenericGridMoveDownItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.MoveDown, sender);
			}
		});
		this.form.getContextMenus().getGenericGridReplaceItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Replace, sender);
			}
		});
		this.form.getContextMenus().getGenericGridConfirmItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Confirm, sender);
			}
		});
		this.form.getContextMenus().getGenericGridEDIT_VIEW_ICP_ACTIONSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.EDIT_VIEW_ICP_ACTIONS, sender);
			}
		});
		this.form.getContextMenus().getOrganisationLocationCREATEROOTORGItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OrganisationLocation.CREATEROOTORG, sender);
			}
		});
		this.form.getContextMenus().getOrganisationLocationCREATEORGHEREItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OrganisationLocation.CREATEORGHERE, sender);
			}
		});
		this.form.getContextMenus().getOrganisationLocationCREATELOCItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OrganisationLocation.CREATELOC, sender);
			}
		});
		this.form.getContextMenus().getOrganisationLocationEDITItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OrganisationLocation.EDIT, sender);
			}
		});
		this.form.getContextMenus().getOrganisationLocationRENAMEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OrganisationLocation.RENAME, sender);
			}
		});
		this.form.getContextMenus().getOrganisationLocationACTIVATEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OrganisationLocation.ACTIVATE, sender);
			}
		});
		this.form.getContextMenus().getOrganisationLocationREMOVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OrganisationLocation.REMOVE, sender);
			}
		});
		this.form.getContextMenus().getOrganisationLocationINACTIVATEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OrganisationLocation.INACTIVATE, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindgrdOrgMappingscolExtCodeTypeLookup();
		bindcmbOrgCountyLookup();
		bindcmbOrgTypeLookup();
		bindgrdLocMappingscolExtCodeTypeLookup();
		bindcmbLocCountyLookup();
		bindcmbLocTypeLookup();
		bindgrdSiteMappingscolExtCodeTypeLookup();
		bindcmbLocSiteCountyLookup();
		bindcmbLocSiteTypeLookup();
	}
	protected void rebindAllLookups()
	{
		bindgrdOrgMappingscolExtCodeTypeLookup();
		bindcmbOrgCountyLookup();
		bindcmbOrgTypeLookup();
		bindgrdLocMappingscolExtCodeTypeLookup();
		bindcmbLocCountyLookup();
		bindcmbLocTypeLookup();
		bindgrdSiteMappingscolExtCodeTypeLookup();
		bindcmbLocSiteCountyLookup();
		bindcmbLocSiteTypeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbOrgCountyLookupValue();
		defaultcmbOrgTypeLookupValue();
		defaultcmbLocCountyLookupValue();
		defaultcmbLocTypeLookupValue();
		defaultcmbLocSiteCountyLookupValue();
		defaultcmbLocSiteTypeLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	public abstract void clearContextInformation();
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
