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

package ims.therapies.forms.rehab;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.therapies.domain.Rehab.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.therapies.domain.Rehab domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbIndependenceValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetail().cmbIndependence().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RehabIndependenceLevel existingInstance = (ims.spinalinjuries.vo.lookups.RehabIndependenceLevel)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbIndependenceLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.RehabIndependenceLevel)
		{
			ims.spinalinjuries.vo.lookups.RehabIndependenceLevel instance = (ims.spinalinjuries.vo.lookups.RehabIndependenceLevel)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbIndependenceLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RehabIndependenceLevel existingInstance = (ims.spinalinjuries.vo.lookups.RehabIndependenceLevel)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetail().cmbIndependence().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbIndependenceLookup()
	{
		this.form.ctnDetail().cmbIndependence().clear();
		ims.spinalinjuries.vo.lookups.RehabIndependenceLevelCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getRehabIndependenceLevel(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetail().cmbIndependence().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbIndependenceLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.RehabIndependenceLevel instance = ims.spinalinjuries.vo.lookups.LookupHelper.getRehabIndependenceLevelInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetail().cmbIndependence().setValue(instance);
	}
	protected final void defaultcmbIndependenceLookupValue()
	{
		this.form.ctnDetail().cmbIndependence().setValue((ims.spinalinjuries.vo.lookups.RehabIndependenceLevel)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.RehabIndependenceLevel.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.RehabIndependenceLevel.TYPE_ID));
	}
	protected final void oncmbPurposeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetail().cmbPurpose().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RehabPurpose existingInstance = (ims.spinalinjuries.vo.lookups.RehabPurpose)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPurposeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.RehabPurpose)
		{
			ims.spinalinjuries.vo.lookups.RehabPurpose instance = (ims.spinalinjuries.vo.lookups.RehabPurpose)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPurposeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RehabPurpose existingInstance = (ims.spinalinjuries.vo.lookups.RehabPurpose)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetail().cmbPurpose().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPurposeLookup()
	{
		this.form.ctnDetail().cmbPurpose().clear();
		ims.spinalinjuries.vo.lookups.RehabPurposeCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getRehabPurpose(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetail().cmbPurpose().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPurposeLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.RehabPurpose instance = ims.spinalinjuries.vo.lookups.LookupHelper.getRehabPurposeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetail().cmbPurpose().setValue(instance);
	}
	protected final void defaultcmbPurposeLookupValue()
	{
		this.form.ctnDetail().cmbPurpose().setValue((ims.spinalinjuries.vo.lookups.RehabPurpose)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.RehabPurpose.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.RehabPurpose.TYPE_ID));
	}
	protected final void oncmbLocationValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetail().cmbLocation().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RehabLocation existingInstance = (ims.spinalinjuries.vo.lookups.RehabLocation)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbLocationLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.RehabLocation)
		{
			ims.spinalinjuries.vo.lookups.RehabLocation instance = (ims.spinalinjuries.vo.lookups.RehabLocation)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbLocationLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RehabLocation existingInstance = (ims.spinalinjuries.vo.lookups.RehabLocation)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetail().cmbLocation().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbLocationLookup()
	{
		this.form.ctnDetail().cmbLocation().clear();
		ims.spinalinjuries.vo.lookups.RehabLocationCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getRehabLocation(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetail().cmbLocation().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbLocationLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.RehabLocation instance = ims.spinalinjuries.vo.lookups.LookupHelper.getRehabLocationInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetail().cmbLocation().setValue(instance);
	}
	protected final void defaultcmbLocationLookupValue()
	{
		this.form.ctnDetail().cmbLocation().setValue((ims.spinalinjuries.vo.lookups.RehabLocation)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.RehabLocation.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.RehabLocation.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.therapies.domain.Rehab domain;
}
