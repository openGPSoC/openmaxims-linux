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

package ims.emergency.forms.tracking;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnPublicPrivateAreaClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnDTAClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroupDisplayValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSeenCompleteHCPClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnAssessmentDetailsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkAllSitesValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnAllocatedCubicleClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdTrackingCountSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroupViewValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbFormLayoutClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnRefreshClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnWhiteBoardClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnMoveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnReferClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnXrayClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnDNWAddClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnViewHistoryClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEventHistoryClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnPatStatusClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnTransferClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnResultClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnOrderClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnDNWMinusClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdTrackCellButtonClicked(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onDyngrdTrackRowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdTrackColumnHeaderClicked(ims.framework.controls.DynamicGridColumn column);
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTimer(ims.framework.controls.Timer timer) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setMessageBoxClosedEvent(new MessageBoxClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onMessageBoxClosed(messageBoxId, result);
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
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.btnPublicPrivateArea().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnPublicPrivateAreaClick();
			}
		});
		this.form.btnDTA().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnDTAClick();
			}
		});
		this.form.GroupDisplay().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupDisplayValueChanged();
			}
		});
		this.form.btnSeenCompleteHCP().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSeenCompleteHCPClick();
			}
		});
		this.form.btnAssessmentDetails().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnAssessmentDetailsClick();
			}
		});
		this.form.chkAllSites().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkAllSitesValueChanged();
			}
		});
		this.form.btnAllocatedCubicle().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnAllocatedCubicleClick();
			}
		});
		this.form.grdTrackingCount().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTrackingCountSelectionChanged();
			}
		});
		this.form.GroupView().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupViewValueChanged();
			}
		});
		this.form.imbFormLayout().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbFormLayoutClick();
			}
		});
		this.form.btnRefresh().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnRefreshClick();
			}
		});
		this.form.btnWhiteBoard().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnWhiteBoardClick();
			}
		});
		this.form.btnMove().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnMoveClick();
			}
		});
		this.form.btnRefer().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnReferClick();
			}
		});
		this.form.btnXray().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnXrayClick();
			}
		});
		this.form.btnDNWAdd().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnDNWAddClick();
			}
		});
		this.form.btnViewHistory().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnViewHistoryClick();
			}
		});
		this.form.btnEventHistory().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEventHistoryClick();
			}
		});
		this.form.btnPatStatus().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnPatStatusClick();
			}
		});
		this.form.btnTransfer().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnTransferClick();
			}
		});
		this.form.btnResult().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnResultClick();
			}
		});
		this.form.btnOrder().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnOrderClick();
			}
		});
		this.form.btnDNWMinus().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnDNWMinusClick();
			}
		});
		this.form.dyngrdTrack().setDynamicGridCellButtonClickedEvent(new DynamicGridCellButtonClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdTrackCellButtonClicked(cell);
			}
		});
		this.form.dyngrdTrack().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdTrackRowSelectionChanged(row);
			}
		});
		this.form.dyngrdTrack().setDynamicGridColumnHeaderClickedEvent(new DynamicGridColumnHeaderClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridColumn column) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdTrackColumnHeaderClicked(column);
			}
		});
		this.form.setTimerElapsedEvent(new ims.framework.delegates.TimerElapsed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.Timer timer) throws ims.framework.exceptions.PresentationLogicException
			{
				onTimer(timer);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuWHITE_BOARDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.WHITE_BOARD, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuASSESSMENT_DETAILSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.ASSESSMENT_DETAILS, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuMOVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.MOVE, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuALLOCATE_CUBICLEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.ALLOCATE_CUBICLE, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuTRANSFERItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.TRANSFER, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuEVENT_HISTORYItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.EVENT_HISTORY, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuVIEW_HISTORYItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.VIEW_HISTORY, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuPAT_STATUSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.PAT_STATUS, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuREFER_TOItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.REFER_TO, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuSEEN_COMPLETE_HCPItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.SEEN_COMPLETE_HCP, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuDTAItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.DTA, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuXRAYItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.XRAY, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuORDERItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.ORDER, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuRESULTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.RESULT, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuREFRESHItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.REFRESH, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuDNW_ADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.DNW_ADD, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuDNW_MINUSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.DNW_MINUS, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuTriageItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.Triage, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuEDITTRIAGEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.EDITTRIAGE, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuVIEW_TRIAGEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.VIEW_TRIAGE, sender);
			}
		});
		this.form.getContextMenus().Emergency.getTrackingTriageMenuBED_STATUSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.EmergencyNamespace.TrackingTriageMenu.BED_STATUS, sender);
			}
		});
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
