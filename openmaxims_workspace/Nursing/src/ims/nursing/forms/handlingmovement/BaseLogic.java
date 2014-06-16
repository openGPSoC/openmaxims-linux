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

package ims.nursing.forms.handlingmovement;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.nursing.domain.HandlingMovement.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.nursing.domain.HandlingMovement domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void bindchklistMechEquipLookup()
	{
		this.form.ctnHandling().lyrDetails().tabDetails().chklistMechEquip().clear();
		ims.nursing.vo.lookups.MechanicalEquipCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getMechanicalEquip(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnHandling().lyrDetails().tabDetails().chklistMechEquip().newRow(lookupCollection.get(x));
		}
	}
	protected final void oncmbMovementValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnHandling().lyrDetails().tabDetails().cmbMovement().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.PatientHandlingMovement existingInstance = (ims.nursing.vo.lookups.PatientHandlingMovement)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbMovementLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.PatientHandlingMovement)
		{
			ims.nursing.vo.lookups.PatientHandlingMovement instance = (ims.nursing.vo.lookups.PatientHandlingMovement)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbMovementLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.PatientHandlingMovement existingInstance = (ims.nursing.vo.lookups.PatientHandlingMovement)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnHandling().lyrDetails().tabDetails().cmbMovement().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbMovementLookup()
	{
		this.form.ctnHandling().lyrDetails().tabDetails().cmbMovement().clear();
		ims.nursing.vo.lookups.PatientHandlingMovementCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getPatientHandlingMovement(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnHandling().lyrDetails().tabDetails().cmbMovement().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbMovementLookupValue(int id)
	{
		ims.nursing.vo.lookups.PatientHandlingMovement instance = ims.nursing.vo.lookups.LookupHelper.getPatientHandlingMovementInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnHandling().lyrDetails().tabDetails().cmbMovement().setValue(instance);
	}
	protected final void defaultcmbMovementLookupValue()
	{
		this.form.ctnHandling().lyrDetails().tabDetails().cmbMovement().setValue((ims.nursing.vo.lookups.PatientHandlingMovement)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.PatientHandlingMovement.class, engine.getFormName().getID(), ims.nursing.vo.lookups.PatientHandlingMovement.TYPE_ID));
	}
	public void initialize() throws ims.framework.exceptions.FormOpenException
	{
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.nursing.domain.HandlingMovement domain;
}
