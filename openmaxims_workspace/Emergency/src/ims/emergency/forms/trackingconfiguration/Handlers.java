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

package ims.emergency.forms.trackingconfiguration;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode, ims.framework.interfaces.IClearInfo
{
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyr1TabChanged(ims.framework.LayerBridge tab);
	abstract protected void onCcAreaDefinitionValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcSendToConfigValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcAreaWorkspaceConfigValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCcCubicleRoomBedValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbEmergDepartValueChanged() throws ims.framework.exceptions.PresentationLogicException;

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
				onFormOpen(args);
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
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveClick();
			}
		});
		this.form.btnEdit().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditClick();
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
		this.form.lyr1().tabAreaDefinition().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabAreaDefinitionActivated();
			}
		});
		this.form.lyr1().tabSendToConfig().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabSendToConfigActivated();
			}
		});
		this.form.lyr1().tabAreaWorkspace().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabAreaWorkspaceActivated();
			}
		});
		this.form.lyr1().tabCubiclesRoomsBeds().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabCubiclesRoomsBedsActivated();
			}
		});
		this.form.lyr1().tabAreaDefinition().setccAreaDefinitionValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcAreaDefinitionValueChanged();
			}
		});
		this.form.lyr1().tabSendToConfig().setccSendToConfigValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcSendToConfigValueChanged();
			}
		});
		this.form.lyr1().tabAreaWorkspace().setccAreaWorkspaceConfigValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcAreaWorkspaceConfigValueChanged();
			}
		});
		this.form.lyr1().tabCubiclesRoomsBeds().setccCubicleRoomBedValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcCubicleRoomBedValueChanged();
			}
		});
		this.form.cmbEmergDepart().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbEmergDepartValueChanged();
			}
		});
	}
	private void onlyr1tabAreaDefinitionActivated()
	{
		this.form.lyr1().showtabAreaDefinition();
		onlyr1TabChanged(this.form.lyr1().tabAreaDefinition());
	}
	private void onlyr1tabSendToConfigActivated()
	{
		this.form.lyr1().showtabSendToConfig();
		onlyr1TabChanged(this.form.lyr1().tabSendToConfig());
	}
	private void onlyr1tabAreaWorkspaceActivated()
	{
		this.form.lyr1().showtabAreaWorkspace();
		onlyr1TabChanged(this.form.lyr1().tabAreaWorkspace());
	}
	private void onlyr1tabCubiclesRoomsBedsActivated()
	{
		this.form.lyr1().showtabCubiclesRoomsBeds();
		onlyr1TabChanged(this.form.lyr1().tabCubiclesRoomsBeds());
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
