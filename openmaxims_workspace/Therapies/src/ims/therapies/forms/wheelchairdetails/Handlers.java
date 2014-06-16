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

package ims.therapies.forms.wheelchairdetails;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbTypeLookup();
	abstract protected void defaultcmbTypeLookupValue();
	abstract protected void bindcmbFootplatesLookup();
	abstract protected void defaultcmbFootplatesLookupValue();
	abstract protected void bindcmbFrameLookup();
	abstract protected void defaultcmbFrameLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbHCPTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTypeValueSet(Object value);
	abstract protected void onCmbTypeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbFootplatesValueSet(Object value);
	abstract protected void oncmbFrameValueSet(Object value);
	abstract protected void onGrdDetailsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException;
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
		this.form.btnClose().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCloseClick();
			}
		});
		this.form.ctnDetails().qmbHCP().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbHCPTextSubmited(value);
			}
		});
		this.form.ctnDetails().cmbType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTypeValueSet(value);
			}
		});
		this.form.ctnDetails().cmbType().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbTypeValueChanged();
			}
		});
		this.form.ctnDetails().cmbFootplates().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbFootplatesValueSet(value);
			}
		});
		this.form.ctnDetails().cmbFrame().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbFrameValueSet(value);
			}
		});
		this.form.grdDetails().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdDetailsSelectionChanged();
			}
		});
		this.form.btnNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewClick();
			}
		});
		this.form.btnUpdate().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnUpdateClick();
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
		this.form.getContextMenus().getLIPNewItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.LIP.New, sender);
			}
		});
		this.form.getContextMenus().getLIPUpdateItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.LIP.Update, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbTypeLookup();
		bindcmbFootplatesLookup();
		bindcmbFrameLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbTypeLookup();
		bindcmbFootplatesLookup();
		bindcmbFrameLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbTypeLookupValue();
		defaultcmbFootplatesLookupValue();
		defaultcmbFrameLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
