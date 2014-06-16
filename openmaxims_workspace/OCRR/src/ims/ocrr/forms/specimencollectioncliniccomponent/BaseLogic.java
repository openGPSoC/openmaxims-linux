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

package ims.ocrr.forms.specimencollectioncliniccomponent;

public abstract class BaseLogic extends Handlers implements IComponent
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.ocrr.domain.SpecimenCollectionClinicComponent.class;
	}
	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form, ims.ocrr.domain.SpecimenCollectionClinicComponent domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void setMode(ims.framework.enumerations.FormMode mode)
	{
		form.setMode(mode);
	}
	public ims.framework.enumerations.FormMode getMode()
	{
		return form.getMode();
	}
	protected final void oncmbSexValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSex().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Sex existingInstance = (ims.core.vo.lookups.Sex)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSexLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.Sex)
		{
			ims.core.vo.lookups.Sex instance = (ims.core.vo.lookups.Sex)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSexLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Sex existingInstance = (ims.core.vo.lookups.Sex)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSex().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSexLookup()
	{
		this.form.cmbSex().clear();
		ims.core.vo.lookups.SexCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSex(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSex().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSexLookupValue(int id)
	{
		ims.core.vo.lookups.Sex instance = ims.core.vo.lookups.LookupHelper.getSexInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSex().setValue(instance);
	}
	protected final void defaultcmbSexLookupValue()
	{
		this.form.cmbSex().setValue((ims.core.vo.lookups.Sex)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.Sex.class, engine.getFormName().getID(), ims.core.vo.lookups.Sex.TYPE_ID));
	}
	protected final void oncmbTitleValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTitle().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PersonTitle existingInstance = (ims.core.vo.lookups.PersonTitle)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTitleLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.PersonTitle)
		{
			ims.core.vo.lookups.PersonTitle instance = (ims.core.vo.lookups.PersonTitle)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTitleLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PersonTitle existingInstance = (ims.core.vo.lookups.PersonTitle)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTitle().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTitleLookup()
	{
		this.form.cmbTitle().clear();
		ims.core.vo.lookups.PersonTitleCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPersonTitle(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTitle().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTitleLookupValue(int id)
	{
		ims.core.vo.lookups.PersonTitle instance = ims.core.vo.lookups.LookupHelper.getPersonTitleInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTitle().setValue(instance);
	}
	protected final void defaultcmbTitleLookupValue()
	{
		this.form.cmbTitle().setValue((ims.core.vo.lookups.PersonTitle)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PersonTitle.class, engine.getFormName().getID(), ims.core.vo.lookups.PersonTitle.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.ocrr.domain.SpecimenCollectionClinicComponent domain;
}
