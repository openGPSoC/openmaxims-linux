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

package ims.clinical.forms.patientproblems;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbSourceLookup();
	abstract protected void defaultcmbSourceLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormClosing(CancelArgs args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkRemoveResolvedValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnAssociationsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbResolvedByTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkResolvedValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbSourceValueSet(Object value);
	abstract protected void onCustomControlCodingItemValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroup1ValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdProblemListSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
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
		this.form.setFormClosingEvent(new FormClosing()
		{
			private static final long serialVersionUID = 1L;
			public void handle(CancelArgs args) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormClosing(args);
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
		this.form.chkRemoveResolved().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkRemoveResolvedValueChanged();
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
		this.form.ctnDetails().btnAssociations().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnAssociationsClick();
			}
		});
		this.form.ctnDetails().qmbResolvedBy().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbResolvedByTextSubmited(value);
			}
		});
		this.form.ctnDetails().chkResolved().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkResolvedValueChanged();
			}
		});
		this.form.ctnDetails().cmbSource().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSourceValueSet(value);
			}
		});
		this.form.ctnDetails().setcustomControlCodingItemValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCustomControlCodingItemValueChanged();
			}
		});
		this.form.ctnDetails().Group1().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroup1ValueChanged();
			}
		});
		this.form.grdProblemList().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdProblemListSelectionChanged();
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
		this.form.getContextMenus().getPatientProblemNewItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatientProblem.New, sender);
			}
		});
		this.form.getContextMenus().getPatientProblemUpdateItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatientProblem.Update, sender);
			}
		});
		this.form.getContextMenus().getPatientProblemMarkAsPrimaryItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatientProblem.MarkAsPrimary, sender);
			}
		});
		this.form.getContextMenus().getPatientProblemViewAssociationsItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatientProblem.ViewAssociations, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbSourceLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbSourceLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbSourceLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
