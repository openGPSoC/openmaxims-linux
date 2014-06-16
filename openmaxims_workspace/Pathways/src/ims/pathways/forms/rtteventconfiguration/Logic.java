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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.60 build 2833.15418)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.pathways.forms.rtteventconfiguration;

import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.ocrr.vo.ProviderSystemVoCollection;
import ims.pathways.forms.rtteventconfiguration.GenForm.grdDetailsRow;
import ims.pathways.vo.RTTEventVo;
import ims.pathways.vo.RTTEventVoCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		clearSearchControls();
		clearScreen();
		
		form.btnEdit().setVisible(false);
		form.btnEdit().setEnabled(false);

		loadProviderSystems();
		form.ctnDetails().setCollapsed(true);
		updateContextMenus();
		
		open(null);

	}

	private void open(RTTEventVo rttVo) 
	{
		clearScreen();
		updateContextMenus();
		form.getLocalContext().setSelectedRecord(null);
		
		RTTEventVoCollection voColl = domain.listRTTEvents(getSearchCriteria());
		if (voColl == null || voColl.size() == 0)
			engine.showMessage("No Matching records found.");
			
			
		fillGrid(voColl, rttVo);
		
		form.btnEdit().setVisible(false);
		updateContextMenus();
		form.ctnDetails().setCollapsed(true);

		openSelectedRecord();
	}

	private void loadProviderSystems()
	{
		ProviderSystemVoCollection voColl = domain.listProviderSystems();
		for (int i = 0 ; voColl != null && i < voColl.size() ; i++)
			form.ctnDetails().cmbProviderSystem().newRow(voColl.get(i), voColl.get(i).getSystemName());
	}
	
	private RTTEventVo getSearchCriteria()
	{
		RTTEventVo voSearchRTT = new RTTEventVo();
		
		voSearchRTT.setName(form.txtRTTNameSearch().getValue());
		voSearchRTT.setAction(form.cmbActionSearch().getValue());
		voSearchRTT.setNationalCode(form.txtNationalCodeSearch().getValue());
		voSearchRTT.setPASCode(form.txtExtSysSearch().getValue());
		
		return voSearchRTT;
	}

	private void updateContextMenus() 
	{
		if(form.getMode().equals(FormMode.VIEW))
		{
			form.getContextMenus().getLIPNewItem().setEnabled(true);
			form.getContextMenus().getLIPNewItem().setVisible(true);
			form.getContextMenus().getLIPUpdateItem().setEnabled(form.grdDetails().getSelectedRow() != null);
			form.getContextMenus().getLIPUpdateItem().setVisible(true);
		}
		else
		{
			form.getContextMenus().getLIPNewItem().setVisible(false);
			form.getContextMenus().getLIPUpdateItem().setVisible(false);
		}
			
	}

	private void fillGrid(RTTEventVoCollection voColl, RTTEventVo rttVo) 
	{
		form.grdDetails().getRows().clear();
		
		for (int i = 0 ; i < voColl.size() ; i++)
		{
			grdDetailsRow row = form.grdDetails().getRows().newRow();
			row.setValue(voColl.get(i));
//			row.setBackColor((form.grdDetails().getRows().size() % 2) == 0 ? Color.Beige : Color.Default);
			
			row.setColRTTName(voColl.get(i).getNameIsNotNull() ? voColl.get(i).getName().toString() : "");
			row.setColNatCode(voColl.get(i).getNationalCodeIsNotNull() ? voColl.get(i).getNationalCode().toString() : "");
			row.setColExtCode(voColl.get(i).getPASCodeIsNotNull() ? voColl.get(i).getPASCode() : "");
			row.setColAction(voColl.get(i).getActionIsNotNull() ? voColl.get(i).getAction().toString() : "");
			row.setColProviderSys(voColl.get(i).getProviderSystemIsNotNull() ? voColl.get(i).getProviderSystem().getSystemName().toString() : "");
		}
		
		form.grdDetails().setValue(rttVo);
		
		form.grdDetails().setFooterValue("Total : " + form.grdDetails().getRows().size());
	}

	private void clearScreen() 
	{
		form.ctnDetails().txtRTTName().setValue(null);
		form.ctnDetails().cmbAction().setValue(null);
		form.ctnDetails().cmbProviderSystem().setValue(null);
		form.ctnDetails().txtNationalCode().setValue(null);
		form.ctnDetails().txtExternalSysCode().setValue(null);
	}
	
	
	private void clearSearchControls() 
	{
		form.txtRTTNameSearch().setValue(null);
		form.cmbActionSearch().setValue(null);
		form.txtNationalCodeSearch().setValue(null);
		form.txtExtSysSearch().setValue(null);
	}

	
	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearSearchControls();

		clearScreen();
		form.grdDetails().getRows().clear();
		form.grdDetails().setFooterValue(null);
		
		updateContextMenus();
		
		form.btnEdit().setVisible(false);
		form.btnEdit().setEnabled(false);
	}
	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open(null);
	}
	
	@Override
	protected void onGrdDetailsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		openSelectedRecord();
	}
	
	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}

	private void newInstance() 
	{
		clearScreen();

		form.setMode(FormMode.EDIT);
		form.ctnDetails().setCollapsed(false);

		form.getLocalContext().setSelectedRecord(new RTTEventVo());
		updateContextMenus();
	}

	private RTTEventVo populateDataFromScreen(RTTEventVo rttVo) 
	{
		rttVo.setName(form.ctnDetails().txtRTTName().getValue());
		rttVo.setAction(form.ctnDetails().cmbAction().getValue());
		rttVo.setProviderSystem(form.ctnDetails().cmbProviderSystem().getValue());
		rttVo.setNationalCode(form.ctnDetails().txtNationalCode().getValue());
		rttVo.setPASCode(form.ctnDetails().txtExternalSysCode().getValue());

		return rttVo;
	}
	
	private void populateScreenFromData(RTTEventVo rttVo) 
	{
		if(rttVo == null)
			throw new CodingRuntimeException("No RTTEventVo provided");
		
		form.ctnDetails().txtRTTName().setValue(rttVo.getName());
		form.ctnDetails().cmbAction().setValue(rttVo.getAction());
		form.ctnDetails().cmbProviderSystem().setValue(rttVo.getProviderSystem());
		if (form.ctnDetails().cmbProviderSystem().getValue() == null && rttVo.getProviderSystemIsNotNull())
		{
			form.ctnDetails().cmbProviderSystem().newRow(rttVo.getProviderSystem(), rttVo.getProviderSystem().getSystemName());
			form.ctnDetails().cmbProviderSystem().setValue(rttVo.getProviderSystem());
		}
		form.ctnDetails().txtNationalCode().setValue(rttVo.getNationalCode());
		form.ctnDetails().txtExternalSysCode().setValue(rttVo.getPASCode());
	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
		
	}

	private void updateInstance() 
	{
		form.setMode(FormMode.EDIT);
		form.ctnDetails().setCollapsed(false);
		updateContextMenus();
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		RTTEventVo rttVo = form.getLocalContext().getSelectedRecord();
		if (rttVo == null)
			rttVo = new RTTEventVo();
		
		rttVo = populateDataFromScreen(rttVo);

		try 
		{
			String[] errors = rttVo.validate();
			if (errors != null)
			{
				engine.showErrors(errors);
				return;
			}
			
			rttVo = domain.saveRTTEvent(rttVo);
			
			form.getLocalContext().setSelectedRecord(rttVo);
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
		} 
		catch (UniqueKeyViolationException e) 
		{
			engine.showErrors(new String[]{e.getMessage().toString()});
			return;
		}
		form.setMode(FormMode.VIEW);
		open(rttVo);
	
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		openSelectedRecord();
		
	}
	private void openSelectedRecord()
	{
		clearScreen();
		form.getLocalContext().setSelectedRecord(null);
		if (form.grdDetails().getSelectedRow() != null)
		{
			form.getLocalContext().setSelectedRecord((RTTEventVo) form.grdDetails().getSelectedRow().getValue().clone());
			populateScreenFromData(form.getLocalContext().getSelectedRecord());
			
		}
		
		form.ctnDetails().setCollapsed(!form.getLocalContext().getSelectedRecordIsNotNull());
		
		form.btnEdit().setVisible(form.getLocalContext().getSelectedRecordIsNotNull() && form.getLocalContext().getSelectedRecord().getID_RTTEventIsNotNull());
		form.btnEdit().setEnabled(form.getLocalContext().getSelectedRecordIsNotNull() && form.getLocalContext().getSelectedRecord().getID_RTTEventIsNotNull());
		updateContextMenus();
		
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.LIP.New:
				newInstance();
			break;
			case GenForm.ContextMenus.LIP.Update:
				updateInstance();
			break;
		}
	}
}
