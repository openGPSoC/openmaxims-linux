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

package ims.coe.forms.assesspainmedication;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.coe.domain.AssessPainMedication.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.coe.domain.AssessPainMedication domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncomboBoxFreqValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.comboBoxFreq().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MedicationFrequency existingInstance = (ims.core.vo.lookups.MedicationFrequency)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxFreqLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.MedicationFrequency)
		{
			ims.core.vo.lookups.MedicationFrequency instance = (ims.core.vo.lookups.MedicationFrequency)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxFreqLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MedicationFrequency existingInstance = (ims.core.vo.lookups.MedicationFrequency)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.comboBoxFreq().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxFreqLookup()
	{
		this.form.comboBoxFreq().clear();
		ims.core.vo.lookups.MedicationFrequencyCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getMedicationFrequency(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.comboBoxFreq().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxFreqLookupValue(int id)
	{
		ims.core.vo.lookups.MedicationFrequency instance = ims.core.vo.lookups.LookupHelper.getMedicationFrequencyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.comboBoxFreq().setValue(instance);
	}
	protected final void defaultcomboBoxFreqLookupValue()
	{
		this.form.comboBoxFreq().setValue((ims.core.vo.lookups.MedicationFrequency)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.MedicationFrequency.class, engine.getFormName().getID(), ims.core.vo.lookups.MedicationFrequency.TYPE_ID));
	}
	protected final void oncomboBoxRouteValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.comboBoxRoute().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MedicationRoute existingInstance = (ims.core.vo.lookups.MedicationRoute)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxRouteLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.MedicationRoute)
		{
			ims.core.vo.lookups.MedicationRoute instance = (ims.core.vo.lookups.MedicationRoute)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxRouteLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MedicationRoute existingInstance = (ims.core.vo.lookups.MedicationRoute)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.comboBoxRoute().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxRouteLookup()
	{
		this.form.comboBoxRoute().clear();
		ims.core.vo.lookups.MedicationRouteCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getMedicationRoute(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.comboBoxRoute().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxRouteLookupValue(int id)
	{
		ims.core.vo.lookups.MedicationRoute instance = ims.core.vo.lookups.LookupHelper.getMedicationRouteInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.comboBoxRoute().setValue(instance);
	}
	protected final void defaultcomboBoxRouteLookupValue()
	{
		this.form.comboBoxRoute().setValue((ims.core.vo.lookups.MedicationRoute)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.MedicationRoute.class, engine.getFormName().getID(), ims.core.vo.lookups.MedicationRoute.TYPE_ID));
	}
	protected final void oncomboBoxMedValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.comboBoxMed().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.PainMedication existingInstance = (ims.coe.vo.lookups.PainMedication)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxMedLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.coe.vo.lookups.PainMedication)
		{
			ims.coe.vo.lookups.PainMedication instance = (ims.coe.vo.lookups.PainMedication)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxMedLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.PainMedication existingInstance = (ims.coe.vo.lookups.PainMedication)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.comboBoxMed().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxMedLookup()
	{
		this.form.comboBoxMed().clear();
		ims.coe.vo.lookups.PainMedicationCollection lookupCollection = ims.coe.vo.lookups.LookupHelper.getPainMedication(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.comboBoxMed().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxMedLookupValue(int id)
	{
		ims.coe.vo.lookups.PainMedication instance = ims.coe.vo.lookups.LookupHelper.getPainMedicationInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.comboBoxMed().setValue(instance);
	}
	protected final void defaultcomboBoxMedLookupValue()
	{
		this.form.comboBoxMed().setValue((ims.coe.vo.lookups.PainMedication)domain.getLookupService().getDefaultInstance(ims.coe.vo.lookups.PainMedication.class, engine.getFormName().getID(), ims.coe.vo.lookups.PainMedication.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.coe.domain.AssessPainMedication domain;
}
