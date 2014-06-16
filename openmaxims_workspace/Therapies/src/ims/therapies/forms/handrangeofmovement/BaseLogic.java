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

package ims.therapies.forms.handrangeofmovement;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.therapies.domain.HandRangeOfMovement.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.therapies.domain.HandRangeOfMovement domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbDominantHandValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().lyrDetails().tabHeader().cmbDominantHand().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.therapies.vo.lookups.DominantHand existingInstance = (ims.therapies.vo.lookups.DominantHand)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDominantHandLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.therapies.vo.lookups.DominantHand)
		{
			ims.therapies.vo.lookups.DominantHand instance = (ims.therapies.vo.lookups.DominantHand)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDominantHandLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.therapies.vo.lookups.DominantHand existingInstance = (ims.therapies.vo.lookups.DominantHand)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().lyrDetails().tabHeader().cmbDominantHand().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDominantHandLookup()
	{
		this.form.ctnDetails().lyrDetails().tabHeader().cmbDominantHand().clear();
		ims.therapies.vo.lookups.DominantHandCollection lookupCollection = ims.therapies.vo.lookups.LookupHelper.getDominantHand(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().lyrDetails().tabHeader().cmbDominantHand().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDominantHandLookupValue(int id)
	{
		ims.therapies.vo.lookups.DominantHand instance = ims.therapies.vo.lookups.LookupHelper.getDominantHandInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().lyrDetails().tabHeader().cmbDominantHand().setValue(instance);
	}
	protected final void defaultcmbDominantHandLookupValue()
	{
		this.form.ctnDetails().lyrDetails().tabHeader().cmbDominantHand().setValue((ims.therapies.vo.lookups.DominantHand)domain.getLookupService().getDefaultInstance(ims.therapies.vo.lookups.DominantHand.class, engine.getFormName().getID(), ims.therapies.vo.lookups.DominantHand.TYPE_ID));
	}
	protected final void oncmbActionValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().lyrDetails().tabDetails().cmbAction().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RangeOfMovementAction existingInstance = (ims.spinalinjuries.vo.lookups.RangeOfMovementAction)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbActionLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.RangeOfMovementAction)
		{
			ims.spinalinjuries.vo.lookups.RangeOfMovementAction instance = (ims.spinalinjuries.vo.lookups.RangeOfMovementAction)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbActionLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RangeOfMovementAction existingInstance = (ims.spinalinjuries.vo.lookups.RangeOfMovementAction)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().lyrDetails().tabDetails().cmbAction().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbActionLookup()
	{
		this.form.ctnDetails().lyrDetails().tabDetails().cmbAction().clear();
		ims.spinalinjuries.vo.lookups.RangeOfMovementActionCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getRangeOfMovementAction(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().lyrDetails().tabDetails().cmbAction().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbActionLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.RangeOfMovementAction instance = ims.spinalinjuries.vo.lookups.LookupHelper.getRangeOfMovementActionInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().lyrDetails().tabDetails().cmbAction().setValue(instance);
	}
	protected final void defaultcmbActionLookupValue()
	{
		this.form.ctnDetails().lyrDetails().tabDetails().cmbAction().setValue((ims.spinalinjuries.vo.lookups.RangeOfMovementAction)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.RangeOfMovementAction.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.RangeOfMovementAction.TYPE_ID));
	}
	protected final void oncmbLateralityValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().lyrDetails().tabDetails().cmbLaterality().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.LateralityLRonly existingInstance = (ims.core.vo.lookups.LateralityLRonly)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbLateralityLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.LateralityLRonly)
		{
			ims.core.vo.lookups.LateralityLRonly instance = (ims.core.vo.lookups.LateralityLRonly)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbLateralityLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.LateralityLRonly existingInstance = (ims.core.vo.lookups.LateralityLRonly)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().lyrDetails().tabDetails().cmbLaterality().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbLateralityLookup()
	{
		this.form.ctnDetails().lyrDetails().tabDetails().cmbLaterality().clear();
		ims.core.vo.lookups.LateralityLRonlyCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getLateralityLRonly(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().lyrDetails().tabDetails().cmbLaterality().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbLateralityLookupValue(int id)
	{
		ims.core.vo.lookups.LateralityLRonly instance = ims.core.vo.lookups.LookupHelper.getLateralityLRonlyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().lyrDetails().tabDetails().cmbLaterality().setValue(instance);
	}
	protected final void defaultcmbLateralityLookupValue()
	{
		this.form.ctnDetails().lyrDetails().tabDetails().cmbLaterality().setValue((ims.core.vo.lookups.LateralityLRonly)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.LateralityLRonly.class, engine.getFormName().getID(), ims.core.vo.lookups.LateralityLRonly.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.therapies.domain.HandRangeOfMovement domain;
}
