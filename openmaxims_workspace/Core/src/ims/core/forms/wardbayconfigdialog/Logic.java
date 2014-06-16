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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.70 build 3341.28572)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.wardbayconfigdialog;

import ims.configuration.gen.ConfigFlag;
import ims.core.forms.wardbayconfigdialog.GenForm.grdLayoutsRow;
import ims.core.forms.wardbayconfigdialog.GenForm.grdSpecialtiesRow;
import ims.core.vo.BayConfigVo;
import ims.core.vo.BayConfigVoCollection;
import ims.core.vo.BedSpaceStateStatusLiteVo;
import ims.core.vo.BedSpaceVoCollection;
import ims.core.vo.FloorBedSpaceLayoutLiteVo;
import ims.core.vo.FloorBedSpaceLayoutLiteVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.WardBayConfigVo;
import ims.core.vo.lookups.BedStatus;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.LookupHelper;
import ims.core.vo.lookups.Specialty;
import ims.core.vo.lookups.SpecialtyCollection;
import ims.core.vo.lookups.YesNo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;

import java.util.ArrayList;
import java.util.List;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
		populateScreenFromData();
	}

	private void initialise()
	{
		form.grdLayouts().setEnabled(false);
		form.getContextMenus().Core.getWardBayConfigDialogADDItem().setVisible(false);
		form.getContextMenus().Core.getWardBayConfigDialogREMOVEItem().setVisible(false);
		
		prepopulateSpecialties();
		
		//available floor layouts
		form.getLocalContext().setActiveLayouts(domain.listFloorBedLayouts());
		
		//load templates combo
		if(form.getLocalContext().getActiveLayoutsIsNotNull())
		{
			form.cmbTemplates().clear();
			for(FloorBedSpaceLayoutLiteVo voItem : form.getLocalContext().getActiveLayouts())
			{
				form.cmbTemplates().newRow(voItem, voItem.getName());
			}
		}
	}

	private void prepopulateSpecialties()
	{
		//Specialty
		form.grdSpecialties().getRows().clear();
		
		SpecialtyCollection collSpec = LookupHelper.getSpecialty(domain.getLookupService());
		if(collSpec == null)
			return;
		
		for (int i=0;i<collSpec.size();i++)
		{
			Specialty specInst = collSpec.get(i);
			grdSpecialtiesRow row = form.grdSpecialties().getRows().newRow();
			row.setSpecialty(specInst);
		}
	}

	private void populateScreenFromData()
	{
		WardBayConfigVo voWardBayConf = form.getGlobalContext().STHK.getWardBayConfigVo();
		if(voWardBayConf == null)
			throw new CodingRuntimeException("voWardBayConf is null in method populateScreenFromData");
		
		form.getLocalContext().setSelectedBay(null);
		form.getLocalContext().setSelectedBayConfig(null);
		
		form.lblWard().setValue(voWardBayConf.getWard() != null ? voWardBayConf.getWard().getName() : "");
		form.chkWaiting().setValue(voWardBayConf.getIsWaitingArea());
		if(voWardBayConf.getID_WardBayConfig() == null)
			form.chkWaiting().setValue(true);
		
		form.ansYesNo().setValue(voWardBayConf.getBays() != null &&  voWardBayConf.getBays().size() > 1 ? YesNo.YES : YesNo.NO);
		ansBoxValueChanged();
		
		populateBayConfigsGridFromData(voWardBayConf.getBays());
		populateSpecialtiesGridFromData(voWardBayConf.getSpecialties(), voWardBayConf.getMainSpecialty());
		
		if(form.ansYesNo().getValue() != null)
		{
			if(form.ansYesNo().getValue().equals(YesNo.NO))
			{
				if(voWardBayConf.getID_WardBayConfigIsNotNull() && voWardBayConf.getBays().size() > 0)				//wdev-13279					
				{
					form.cmbTemplates().newRow(voWardBayConf.getBays().get(0).getFloorBedSpaceLayout(), voWardBayConf.getBays().get(0).getFloorBedSpaceLayout().getName());
					form.cmbTemplates().setValue(voWardBayConf.getBays().get(0).getFloorBedSpaceLayout());
					form.getLocalContext().setSelectedBay(voWardBayConf.getBays().get(0).getBay());
					form.getLocalContext().setSelectedBayConfig(voWardBayConf.getBays().get(0));
				}
			}
			if(voWardBayConf.getID_WardBayConfigIsNotNull())
			{
				form.ansYesNo().setEnabled(true);
				form.cmbTemplates().setEnabled(false);
			}
			
			if(form.grdLayouts().getRows().size() > 1)
				form.ansYesNo().setEnabled(false);
		}
	}

	private void populateSpecialtiesGridFromData(SpecialtyCollection specialties, Specialty mainSpecialty)
	{
		if(specialties == null)
			return;
		
		for(int i=0;i<form.grdSpecialties().getRows().size();i++)
		{
			if(specialties.contains(form.grdSpecialties().getRows().get(i).getSpecialty()))
				form.grdSpecialties().getRows().get(i).setSelect(true);
			else
				form.grdSpecialties().getRows().get(i).setSelect(false);
			
			if(mainSpecialty != null)
				if(form.grdSpecialties().getRows().get(i).getSpecialty().equals(mainSpecialty))
					form.grdSpecialties().getRows().get(i).setMain(true);
		}
	}

	private void populateBayConfigsGridFromData(BayConfigVoCollection voCollBayConf)
	{
		form.grdLayouts().getRows().clear();
		
		if(voCollBayConf == null)
			return;
		
		for (BayConfigVo voBayConfig : voCollBayConf)
		{
			grdLayoutsRow row = form.grdLayouts().getRows().newRow();
		
			if(voBayConfig.getBayIsNotNull())
			{
				row.setBayValue(voBayConfig.getBay());
				row.setBay(voBayConfig.getBay().getName());
				
				//WDEV-13964
				row.setActive(voBayConfig.getBay().getIsActive());
			}
			if(voBayConfig.getFloorBedSpaceLayoutIsNotNull())
			{
				row.getBayBedSpaceLayout().newRow(voBayConfig.getFloorBedSpaceLayout(), voBayConfig.getFloorBedSpaceLayout().getName());
				row.getBayBedSpaceLayout().setValue(voBayConfig.getFloorBedSpaceLayout());			
				row.setBayBedSpaceLayoutReadOnly(true);
			}
			addAvailableFloorLayouts(row);
			row.setValue(voBayConfig);
		}
	}

	@Override
	protected void onGrdSpecialtiesGridCheckBoxClicked(int column, GenForm.grdSpecialtiesRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
	{
		//allow only one item to be checked as main and main has to be selected
		if(column == 1)
		{
			if(isChecked)
			{
				for(int i=0;i<form.grdSpecialties().getRows().size();i++)
					form.grdSpecialties().getRows().get(i).setMain(false);

				row.setMain(isChecked);
				row.setSelect(isChecked);
			}
		}
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		WardBayConfigVo voWardBayConfig = form.getGlobalContext().STHK.getWardBayConfigVo();
		if (voWardBayConfig == null)
			throw new CodingRuntimeException("voWardBayConfig cannot be null in method onBtnSaveClick");
				
		voWardBayConfig = populateDataFromScreen(voWardBayConfig);
		
		String[] errors = voWardBayConfig.validate(getUIValidationErrors());
		if(errors != null)
		{
			engine.showErrors(errors);
			return;
		}
		
		try
		{
			domain.saveWardBayConfig(voWardBayConfig);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			populateScreenFromData();
			
			return;
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			return;
		}
		
		engine.close(DialogResult.OK);
	}
	
	private String[] getUIValidationErrors()
	{
		List<String> errors = new ArrayList<String>();
		
		if(form.ansYesNo().getValue() == null)
			errors.add("'Multiple Bays' is mandatory");
		//one specialty selected
		if(getSelectedSpecialties() == null || getSelectedSpecialties().size() == 0)
			errors.add("One Specialty is mandatory");
		
		//each layout row has a location name and floorbedlayout selected
		for(int i=0;i<form.grdLayouts().getRows().size();i++)
		{
			grdLayoutsRow lRow = form.grdLayouts().getRows().get(i);
			/* WDEV-16066
			  if(lRow.getBay() == null || lRow.getBay().equals("")) 
				errors.add("Bay Name is mandatory"); 
			*/
			if(lRow.getBayBedSpaceLayout() == null)
				errors.add("Bed Space Layout is mandatory");
		}
			
		return (errors.size() > 0 ? errors.toArray(new String[0]) : null);
	}

	private WardBayConfigVo populateDataFromScreen(WardBayConfigVo voWardBayConfig)
	{
		if (voWardBayConfig == null)
			throw new CodingRuntimeException("voWardBayConfig cannot be null in method populateDataFromScreen");
		
		voWardBayConfig.setIsWaitingArea(form.chkWaiting().getValue());
		voWardBayConfig.setSpecialties(getSelectedSpecialties());
		voWardBayConfig.setMainSpecialty(getMainSpecialty());
		voWardBayConfig.setBays(getSelectedBays());
		
		return voWardBayConfig;
	}

	private BayConfigVoCollection getSelectedBays()
	{
		BayConfigVoCollection voCollBayConfig = new BayConfigVoCollection();
		
		if(form.ansYesNo().getValue() != null)
		{
			if(form.ansYesNo().getValue().equals(YesNo.YES))
			{
				for(int i=0; i<form.grdLayouts().getRows().size(); i++)
				{
					grdLayoutsRow row = form.grdLayouts().getRows().get(i);
					BayConfigVo voBayConfig = row.getValue();
					
					voBayConfig.setBay(getBay(row));
					voBayConfig.setFloorBedSpaceLayout((FloorBedSpaceLayoutLiteVo) row.getBayBedSpaceLayout().getValue());
					//WDEV-13964
					voBayConfig.setIsActive(row.getActive());
					
					if(!isThisRecordDuplicate(voBayConfig, voCollBayConfig))
						voCollBayConfig.add(voBayConfig);
				}
			}
			else
			{
				BayConfigVo voBayConfig = getSelectedBayConfig();
				voBayConfig.setBay(getBay(null));
				voBayConfig.setFloorBedSpaceLayout(form.cmbTemplates().getValue());
				//WDEV-13964 Latest Change 02/02/2012
				voBayConfig.setIsActive(true);
				voCollBayConfig.add(voBayConfig);
			}
		}
		
		return voCollBayConfig;
	}

	private boolean isThisRecordDuplicate(BayConfigVo voBayConfig, BayConfigVoCollection voCollBayConfig)
	{
		if (voCollBayConfig == null)
			throw new CodingRuntimeException("voCollBayConfig cannot be null in method isThisRecordDuplicate");
		if (voBayConfig == null)
			throw new CodingRuntimeException("voCollBayConfig cannot be null in method isThisRecordDuplicate");
		
		for (BayConfigVo voBayConfiglstItem : voCollBayConfig)
		{
			if(voBayConfiglstItem.getBayIsNotNull() &&  voBayConfiglstItem.getBay().getNameIsNotNull() && voBayConfiglstItem.getBayIsNotNull() &&  voBayConfiglstItem.getBayIsNotNull() &&  voBayConfiglstItem.getBay().getNameIsNotNull())
			{
				if(voBayConfiglstItem.getBay().getName().equals(voBayConfig.getBay().getName()))
				{
					return true;
				}
			}	
		}
		
		return false;
	}

	/**
	 * if there was a previously instantiated BayConfig record for this one use it
	 * else create new
	 * @return
	 */
	private BayConfigVo getSelectedBayConfig()
	{
		if(form.getLocalContext().getSelectedBayConfigIsNotNull())
			return form.getLocalContext().getSelectedBayConfig();
		
		return new BayConfigVo();
	}

	/**
	 * custom method here to create locationlites if needed
	 * caused by the fact that javacustomvalue type attribute for grid column in devenv
	 * doesnt allow you to have editable string value
	 * if row is null then create a dummy bay or use selected bay
	 * @param row
	 * @return
	 */
	private LocationLiteVo getBay(grdLayoutsRow row)
	{
		LocationLiteVo voBay = null;
		if(row != null)
		{
			voBay = row.getBayValue();
			voBay.setName(row.getBay());
		}
		else
		{
			if(!form.cmbTemplates().isEnabled())
				voBay = form.getLocalContext().getSelectedBay();
			else
			{
				voBay = new LocationLiteVo();
				voBay.setName("Bay 1 (" + form.getGlobalContext().STHK.getWardBayConfigVo().getWard().getName() + ")");
			}
		}	
		
		if(voBay != null)	//wdev-13279				
		{
			voBay.setIsVirtual(false);
			voBay.setType(LocationType.BAY);
		}
		return voBay;
	}

	private Specialty getMainSpecialty()
	{
		Specialty mainSpecialty = null; 
		for(int i=0; i< form.grdSpecialties().getRows().size(); i++)
		{
			if(form.grdSpecialties().getRows().get(i).getMain())
				mainSpecialty = form.grdSpecialties().getRows().get(i).getSpecialty();
		}
		
		return mainSpecialty;
	}

	private SpecialtyCollection getSelectedSpecialties()
	{
		SpecialtyCollection collSpec = new SpecialtyCollection(); 
		for(int i=0; i< form.grdSpecialties().getRows().size(); i++)
		{
			if(form.grdSpecialties().getRows().get(i).getSelect())
				collSpec.add(form.grdSpecialties().getRows().get(i).getSpecialty());
		}
		return collSpec;
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onAnsYesNoValueChanged() throws PresentationLogicException
	{
		ansBoxValueChanged();
	}

	private void ansBoxValueChanged()
	{
		if(form.ansYesNo().getValue() != null)
		{
			if(form.ansYesNo().getValue().equals(YesNo.YES))
			{
				form.cmbTemplates().setVisible(false);
				form.lblLayout().setVisible(false);
				form.grdLayouts().setEnabled(true);
				form.grdLayouts().setReadOnly(false);
				form.grdLayouts().setVisible(true);
				form.getContextMenus().Core.getWardBayConfigDialogADDItem().setVisible(true);
			}
			else if(form.ansYesNo().getValue().equals(YesNo.NO))
			{
				form.grdLayouts().setVisible(false);
				form.cmbTemplates().setVisible(true);
				form.lblLayout().setVisible(true);
			}
		}
		else
		{
			form.grdLayouts().setVisible(false);
			form.cmbTemplates().setVisible(false);
			form.lblLayout().setVisible(false);
		}
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.CoreNamespace.WardBayConfigDialog.ADD:
				grdLayoutsRow row = form.grdLayouts().getRows().newRow();
				row.setBayValue(new LocationLiteVo());
				row.setValue(new BayConfigVo());
				addAvailableFloorLayouts(row);
			break;
			case GenForm.ContextMenus.CoreNamespace.WardBayConfigDialog.REMOVE:
				grdLayoutsRow lRow = form.grdLayouts().getSelectedRow();
				if(lRow != null)
				{
					form.grdLayouts().removeSelectedRow();
					//form.getContextMenus().Core.getWardBayConfigDialogREMOVEItem().setVisible(false);
				}
			break;
			default:
		}
	}

	private void addAvailableFloorLayouts(grdLayoutsRow row)
	{
		FloorBedSpaceLayoutLiteVoCollection voCollLayout = form.getLocalContext().getActiveLayouts();
		if(voCollLayout != null)
		{
			for (FloorBedSpaceLayoutLiteVo voFloorBedSpace : voCollLayout)
			{
				if(voFloorBedSpace != null)
					row.getBayBedSpaceLayout().newRow(voFloorBedSpace, voFloorBedSpace.getName());
			}
		}
	}


	@Override
	protected void onGrdLayoutsSelectionChanged() throws PresentationLogicException
	{
		//form.getContextMenus().Core.getWardBayConfigDialogREMOVEItem().setVisible(form.grdLayouts().getSelectedRow() != null && form.getMode().equals(FormMode.EDIT)&& domain.getOccupiedBedsForBay(form.grdLayouts().getSelectedRow().getValue().getBay())==0);
		
	}

	//WDEV-18064
	@Override
	protected void onGrdLayoutsGridCheckBoxClicked(int column, grdLayoutsRow row, boolean isChecked) throws PresentationLogicException
	{
		if (Boolean.FALSE.equals(isChecked) && row.getValue().getFloorBedSpaceLayout() != null && row.getValue().getID_BayConfig() != null)
		{
			if (row.getValue().getID_BayConfig() != null)
			{
				BedSpaceVoCollection getBedSpaces = domain.getBedSpacesForLayout(row.getValue().getFloorBedSpaceLayout());
				
				if (areOccupiedBeds(getBedSpaces))
				{
					row.setActive(Boolean.TRUE);
					engine.showMessage("Bay cannot be Inactivated as there are occupied beds on the Ward.", "Warning", MessageButtons.OK, MessageIcon.WARNING);
				}
			}
		}
		
	}

	private Boolean areOccupiedBeds(BedSpaceVoCollection getBedSpaces)
	{
		if (getBedSpaces == null)
			return false;
		
		for (int i=0; i < getBedSpaces.size(); i++)
		{
			BedSpaceStateStatusLiteVo bedSpaceState = domain.getBedSpaceStateStatus(getBedSpaces.get(i));
			
			if (BedStatus.OCCUPIED.equals(bedSpaceState.getBedStatus()))
				return true;
		}
		
		return false;
	}
}
