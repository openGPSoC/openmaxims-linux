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

package ims.scheduling.forms.profilesslotgeneric;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.scheduling.domain.ProfilesSlotGeneric.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.scheduling.domain.ProfilesSlotGeneric domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.SchedCABSlotType existingInstance = (ims.scheduling.vo.lookups.SchedCABSlotType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.scheduling.vo.lookups.SchedCABSlotType)
		{
			ims.scheduling.vo.lookups.SchedCABSlotType instance = (ims.scheduling.vo.lookups.SchedCABSlotType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.SchedCABSlotType existingInstance = (ims.scheduling.vo.lookups.SchedCABSlotType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTypeLookup()
	{
		this.form.cmbType().clear();
		ims.scheduling.vo.lookups.SchedCABSlotTypeCollection lookupCollection = ims.scheduling.vo.lookups.LookupHelper.getSchedCABSlotType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTypeLookupValue(int id)
	{
		ims.scheduling.vo.lookups.SchedCABSlotType instance = ims.scheduling.vo.lookups.LookupHelper.getSchedCABSlotTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbType().setValue(instance);
	}
	protected final void defaultcmbTypeLookupValue()
	{
		this.form.cmbType().setValue((ims.scheduling.vo.lookups.SchedCABSlotType)domain.getLookupService().getDefaultInstance(ims.scheduling.vo.lookups.SchedCABSlotType.class, engine.getFormName().getID(), ims.scheduling.vo.lookups.SchedCABSlotType.TYPE_ID));
	}
	protected final void oncmbPriorityValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbPriority().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.SchedulingPriority existingInstance = (ims.scheduling.vo.lookups.SchedulingPriority)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPriorityLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.scheduling.vo.lookups.SchedulingPriority)
		{
			ims.scheduling.vo.lookups.SchedulingPriority instance = (ims.scheduling.vo.lookups.SchedulingPriority)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPriorityLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.SchedulingPriority existingInstance = (ims.scheduling.vo.lookups.SchedulingPriority)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbPriority().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPriorityLookup()
	{
		this.form.cmbPriority().clear();
		ims.scheduling.vo.lookups.SchedulingPriorityCollection lookupCollection = ims.scheduling.vo.lookups.LookupHelper.getSchedulingPriority(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbPriority().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPriorityLookupValue(int id)
	{
		ims.scheduling.vo.lookups.SchedulingPriority instance = ims.scheduling.vo.lookups.LookupHelper.getSchedulingPriorityInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbPriority().setValue(instance);
	}
	protected final void defaultcmbPriorityLookupValue()
	{
		this.form.cmbPriority().setValue((ims.scheduling.vo.lookups.SchedulingPriority)domain.getLookupService().getDefaultInstance(ims.scheduling.vo.lookups.SchedulingPriority.class, engine.getFormName().getID(), ims.scheduling.vo.lookups.SchedulingPriority.TYPE_ID));
	}
	protected void clearScreen()
	{
		this.form.cmbSlotResp().setValue(null);
		this.form.cmbType().setValue(null);
		this.form.intDeallocateNumber().setValue(null);
		this.form.chkActive().setValue(false);
		this.form.intSlotInterval().setValue(null);
		this.form.timStart().setValue(null);
		this.form.cmbActivity().setValue(null);
		this.form.intNoSlots().setValue(null);
		this.form.cmbPriority().setValue(null);
		this.form.intNoInst().setValue(null);
	}
	protected void populateScreenFromData(ims.scheduling.vo.Profile_SlotGenericVo value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.cmbSlotResp().setValue(value.getSlotRespIsNotNull() ? value.getSlotResp() : null);
		this.form.cmbType().setValue(value.getTypeIsNotNull() ? value.getType() : null);
		this.form.intDeallocateNumber().setValue(value.getDeallocNoOfDaysIsNotNull() ? value.getDeallocNoOfDays() : null);
		if(value.getIsActiveIsNotNull())
			this.form.chkActive().setValue(value.getIsActive().booleanValue());
		this.form.intSlotInterval().setValue(value.getDurationIsNotNull() ? value.getDuration() : null);
		this.form.timStart().setValue(value.getStartTmIsNotNull() ? value.getStartTm() : null);
		this.form.cmbActivity().setValue(value.getActivityIsNotNull() ? value.getActivity() : null);
		this.form.intNoSlots().setValue(value.getNumberSlotsReqIsNotNull() ? value.getNumberSlotsReq() : null);
		this.form.cmbPriority().setValue(value.getPriorityIsNotNull() ? value.getPriority() : null);
		this.form.intNoInst().setValue(value.getNoOfInstancesIsNotNull() ? value.getNoOfInstances() : null);
	}
	protected ims.scheduling.vo.Profile_SlotGenericVo populateDataFromScreen(ims.scheduling.vo.Profile_SlotGenericVo value)
	{
		if(value == null)
			value = new ims.scheduling.vo.Profile_SlotGenericVo();

		value.setSlotResp(this.form.cmbSlotResp().getValue());
		value.setType(this.form.cmbType().getValue());
		value.setDeallocNoOfDays(this.form.intDeallocateNumber().getValue());
		value.setIsActive(new Boolean(this.form.chkActive().getValue()));
		value.setDuration(this.form.intSlotInterval().getValue());
		value.setStartTm(this.form.timStart().getValue());
		value.setActivity(this.form.cmbActivity().getValue());
		value.setNumberSlotsReq(this.form.intNoSlots().getValue());
		value.setPriority(this.form.cmbPriority().getValue());
		value.setNoOfInstances(this.form.intNoInst().getValue());

		return value;
	}
	protected ims.scheduling.vo.Profile_SlotGenericVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.scheduling.vo.Profile_SlotGenericVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.scheduling.domain.ProfilesSlotGeneric domain;
}
