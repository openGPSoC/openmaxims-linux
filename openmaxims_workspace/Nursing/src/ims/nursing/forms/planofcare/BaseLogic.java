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

package ims.nursing.forms.planofcare;

public abstract class BaseLogic extends Handlers
{
	private java.util.ArrayList lookupUsageErrors;

	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.nursing.domain.PlanOfCare.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.nursing.domain.PlanOfCare domain)
	{
		setContext(engine, form);
		this.domain = domain;
		if(domain.getLookupService().countLookupInstances(ims.nursing.vo.lookups.PlanOfCareLevelOfInterventionCollection.class, ims.nursing.vo.lookups.PlanOfCareLevelOfIntervention.class, 1001080, true) == 0)
		{
			if(lookupUsageErrors == null)
				lookupUsageErrors = new java.util.ArrayList();
			lookupUsageErrors.add("The lookup type 'PlanOfCareLevelOfIntervention' (ID: 1001080) must have at least one active instance configured.");
		}
		if(domain.getLookupService().countLookupInstances(ims.nursing.vo.lookups.PlanOfCareGroupCollection.class, ims.nursing.vo.lookups.PlanOfCareGroup.class, 1001081, true) == 0)
		{
			if(lookupUsageErrors == null)
				lookupUsageErrors = new java.util.ArrayList();
			lookupUsageErrors.add("The lookup type 'PlanOfCareGroup' (ID: 1001081) must have at least one active instance configured.");
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
	protected final void oncmbStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrPOC().tabPocList().cmbStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.PlanOfCareStatus existingInstance = (ims.nursing.vo.lookups.PlanOfCareStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.PlanOfCareStatus)
		{
			ims.nursing.vo.lookups.PlanOfCareStatus instance = (ims.nursing.vo.lookups.PlanOfCareStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.PlanOfCareStatus existingInstance = (ims.nursing.vo.lookups.PlanOfCareStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrPOC().tabPocList().cmbStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbStatusLookup()
	{
		this.form.lyrPOC().tabPocList().cmbStatus().clear();
		ims.nursing.vo.lookups.PlanOfCareStatusCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getPlanOfCareStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrPOC().tabPocList().cmbStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbStatusLookupValue(int id)
	{
		ims.nursing.vo.lookups.PlanOfCareStatus instance = ims.nursing.vo.lookups.LookupHelper.getPlanOfCareStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrPOC().tabPocList().cmbStatus().setValue(instance);
	}
	protected final void defaultcmbStatusLookupValue()
	{
		this.form.lyrPOC().tabPocList().cmbStatus().setValue((ims.nursing.vo.lookups.PlanOfCareStatus)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.PlanOfCareStatus.class, engine.getFormName().getID(), ims.nursing.vo.lookups.PlanOfCareStatus.TYPE_ID));
	}
	protected final void oncmbGroupValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrPOC().tabPocDetails().cmbGroup().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.PlanOfCareGroupings existingInstance = (ims.clinical.vo.lookups.PlanOfCareGroupings)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbGroupLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.PlanOfCareGroupings)
		{
			ims.clinical.vo.lookups.PlanOfCareGroupings instance = (ims.clinical.vo.lookups.PlanOfCareGroupings)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbGroupLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.PlanOfCareGroupings existingInstance = (ims.clinical.vo.lookups.PlanOfCareGroupings)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrPOC().tabPocDetails().cmbGroup().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbGroupLookup()
	{
		this.form.lyrPOC().tabPocDetails().cmbGroup().clear();
		ims.clinical.vo.lookups.PlanOfCareGroupingsCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getPlanOfCareGroupings(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrPOC().tabPocDetails().cmbGroup().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbGroupLookupValue(int id)
	{
		ims.clinical.vo.lookups.PlanOfCareGroupings instance = ims.clinical.vo.lookups.LookupHelper.getPlanOfCareGroupingsInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrPOC().tabPocDetails().cmbGroup().setValue(instance);
	}
	protected final void defaultcmbGroupLookupValue()
	{
		this.form.lyrPOC().tabPocDetails().cmbGroup().setValue((ims.clinical.vo.lookups.PlanOfCareGroupings)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.PlanOfCareGroupings.class, engine.getFormName().getID(), ims.clinical.vo.lookups.PlanOfCareGroupings.TYPE_ID));
	}
	protected final void oncmbStatusPOCValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrPOC().tabPocDetails().cmbStatusPOC().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.PlanOfCareStatus existingInstance = (ims.nursing.vo.lookups.PlanOfCareStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbStatusPOCLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.PlanOfCareStatus)
		{
			ims.nursing.vo.lookups.PlanOfCareStatus instance = (ims.nursing.vo.lookups.PlanOfCareStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbStatusPOCLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.PlanOfCareStatus existingInstance = (ims.nursing.vo.lookups.PlanOfCareStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrPOC().tabPocDetails().cmbStatusPOC().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbStatusPOCLookup()
	{
		this.form.lyrPOC().tabPocDetails().cmbStatusPOC().clear();
		ims.nursing.vo.lookups.PlanOfCareStatusCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getPlanOfCareStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrPOC().tabPocDetails().cmbStatusPOC().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbStatusPOCLookupValue(int id)
	{
		ims.nursing.vo.lookups.PlanOfCareStatus instance = ims.nursing.vo.lookups.LookupHelper.getPlanOfCareStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrPOC().tabPocDetails().cmbStatusPOC().setValue(instance);
	}
	protected final void defaultcmbStatusPOCLookupValue()
	{
		this.form.lyrPOC().tabPocDetails().cmbStatusPOC().setValue((ims.nursing.vo.lookups.PlanOfCareStatus)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.PlanOfCareStatus.class, engine.getFormName().getID(), ims.nursing.vo.lookups.PlanOfCareStatus.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.nursing.domain.PlanOfCare domain;
}
