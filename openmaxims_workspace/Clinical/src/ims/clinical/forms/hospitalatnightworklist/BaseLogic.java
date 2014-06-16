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

package ims.clinical.forms.hospitalatnightworklist;

public abstract class BaseLogic extends Handlers
{
	private java.util.ArrayList lookupUsageErrors;

	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.HospitalAtNightWorklist.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.clinical.domain.HospitalAtNightWorklist domain)
	{
		setContext(engine, form);
		this.domain = domain;
		if(domain.getLookupService().countLookupInstances(ims.clinical.vo.lookups.HospitalAtNightRequestTypeCollection.class, ims.clinical.vo.lookups.HospitalAtNightRequestType.class, 1231119, true) == 0)
		{
			if(lookupUsageErrors == null)
				lookupUsageErrors = new java.util.ArrayList();
			lookupUsageErrors.add("The lookup type 'HospitalAtNightRequestType' (ID: 1231119) must have at least one active instance configured.");
		}
		if(domain.getLookupService().countLookupInstances(ims.clinical.vo.lookups.HospitalAtNightPatientStatusCollection.class, ims.clinical.vo.lookups.HospitalAtNightPatientStatus.class, 1231121, true) == 0)
		{
			if(lookupUsageErrors == null)
				lookupUsageErrors = new java.util.ArrayList();
			lookupUsageErrors.add("The lookup type 'HospitalAtNightPatientStatus' (ID: 1231121) must have at least one active instance configured.");
		}
	}
	public final String[] getLookupUsageErrors()
	{
		if(lookupUsageErrors == null)
			return null;
		String[] errors = new String[lookupUsageErrors.size()];
		for(int x = 0; x < lookupUsageErrors.size(); x++)
		{
			errors[x] = (String)lookupUsageErrors.get(x);
		}
		return errors;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbTypeOfRequestValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTypeOfRequest().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.HospitalAtNightRequestType existingInstance = (ims.clinical.vo.lookups.HospitalAtNightRequestType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTypeOfRequestLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.HospitalAtNightRequestType)
		{
			ims.clinical.vo.lookups.HospitalAtNightRequestType instance = (ims.clinical.vo.lookups.HospitalAtNightRequestType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTypeOfRequestLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.HospitalAtNightRequestType existingInstance = (ims.clinical.vo.lookups.HospitalAtNightRequestType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTypeOfRequest().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTypeOfRequestLookup()
	{
		this.form.cmbTypeOfRequest().clear();
		ims.clinical.vo.lookups.HospitalAtNightRequestTypeCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getHospitalAtNightRequestType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTypeOfRequest().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTypeOfRequestLookupValue(int id)
	{
		ims.clinical.vo.lookups.HospitalAtNightRequestType instance = ims.clinical.vo.lookups.LookupHelper.getHospitalAtNightRequestTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTypeOfRequest().setValue(instance);
	}
	protected final void defaultcmbTypeOfRequestLookupValue()
	{
		this.form.cmbTypeOfRequest().setValue((ims.clinical.vo.lookups.HospitalAtNightRequestType)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.HospitalAtNightRequestType.class, engine.getFormName().getID(), ims.clinical.vo.lookups.HospitalAtNightRequestType.TYPE_ID));
	}
	public void initialize() throws ims.framework.exceptions.FormOpenException
	{
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinical.domain.HospitalAtNightWorklist domain;
}
