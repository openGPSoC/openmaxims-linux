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

package ims.clinical.forms.chronicpainreferral;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.ChronicPainReferral.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.clinical.domain.ChronicPainReferral domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void onansCurrentValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyr1().tabReferralDetails().ansCurrent().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansCurrentLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNo)
		{
			ims.core.vo.lookups.YesNo instance = (ims.core.vo.lookups.YesNo)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansCurrentLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyr1().tabReferralDetails().ansCurrent().addOption(instance);
		}
	}
	protected final void bindansCurrentLookup()
	{
		this.form.lyr1().tabReferralDetails().ansCurrent().clear();
		ims.core.vo.lookups.YesNoCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNo(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyr1().tabReferralDetails().ansCurrent().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansCurrentLookupValue()
	{
		this.form.lyr1().tabReferralDetails().ansCurrent().setValue((ims.core.vo.lookups.YesNo)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNo.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNo.TYPE_ID));
	}
	protected final void onansPatientKnownPainServiceValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyr1().tabReferralDetails().ansPatientKnownPainService().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansPatientKnownPainServiceLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNo)
		{
			ims.core.vo.lookups.YesNo instance = (ims.core.vo.lookups.YesNo)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansPatientKnownPainServiceLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyr1().tabReferralDetails().ansPatientKnownPainService().addOption(instance);
		}
	}
	protected final void bindansPatientKnownPainServiceLookup()
	{
		this.form.lyr1().tabReferralDetails().ansPatientKnownPainService().clear();
		ims.core.vo.lookups.YesNoCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNo(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyr1().tabReferralDetails().ansPatientKnownPainService().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansPatientKnownPainServiceLookupValue()
	{
		this.form.lyr1().tabReferralDetails().ansPatientKnownPainService().setValue((ims.core.vo.lookups.YesNo)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNo.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNo.TYPE_ID));
	}
	protected final void onansInappropriateReferralValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyr1().tabActionPlan().ansInappropriateReferral().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansInappropriateReferralLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNo)
		{
			ims.core.vo.lookups.YesNo instance = (ims.core.vo.lookups.YesNo)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansInappropriateReferralLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyr1().tabActionPlan().ansInappropriateReferral().addOption(instance);
		}
	}
	protected final void bindansInappropriateReferralLookup()
	{
		this.form.lyr1().tabActionPlan().ansInappropriateReferral().clear();
		ims.core.vo.lookups.YesNoCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNo(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyr1().tabActionPlan().ansInappropriateReferral().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansInappropriateReferralLookupValue()
	{
		this.form.lyr1().tabActionPlan().ansInappropriateReferral().setValue((ims.core.vo.lookups.YesNo)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNo.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNo.TYPE_ID));
	}
	protected final void onansReferAsOutPatientValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyr1().tabActionPlan().ansReferAsOutPatient().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansReferAsOutPatientLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNo)
		{
			ims.core.vo.lookups.YesNo instance = (ims.core.vo.lookups.YesNo)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansReferAsOutPatientLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyr1().tabActionPlan().ansReferAsOutPatient().addOption(instance);
		}
	}
	protected final void bindansReferAsOutPatientLookup()
	{
		this.form.lyr1().tabActionPlan().ansReferAsOutPatient().clear();
		ims.core.vo.lookups.YesNoCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNo(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyr1().tabActionPlan().ansReferAsOutPatient().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansReferAsOutPatientLookupValue()
	{
		this.form.lyr1().tabActionPlan().ansReferAsOutPatient().setValue((ims.core.vo.lookups.YesNo)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNo.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNo.TYPE_ID));
	}
	protected final void onansSeeOnWardRouondValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyr1().tabActionPlan().ansSeeOnWardRouond().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansSeeOnWardRouondLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNo)
		{
			ims.core.vo.lookups.YesNo instance = (ims.core.vo.lookups.YesNo)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansSeeOnWardRouondLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyr1().tabActionPlan().ansSeeOnWardRouond().addOption(instance);
		}
	}
	protected final void bindansSeeOnWardRouondLookup()
	{
		this.form.lyr1().tabActionPlan().ansSeeOnWardRouond().clear();
		ims.core.vo.lookups.YesNoCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNo(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyr1().tabActionPlan().ansSeeOnWardRouond().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansSeeOnWardRouondLookupValue()
	{
		this.form.lyr1().tabActionPlan().ansSeeOnWardRouond().setValue((ims.core.vo.lookups.YesNo)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNo.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNo.TYPE_ID));
	}
	protected final void onansWrittenReferralValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyr1().tabActionPlan().ansWrittenReferral().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansWrittenReferralLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNo)
		{
			ims.core.vo.lookups.YesNo instance = (ims.core.vo.lookups.YesNo)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansWrittenReferralLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyr1().tabActionPlan().ansWrittenReferral().addOption(instance);
		}
	}
	protected final void bindansWrittenReferralLookup()
	{
		this.form.lyr1().tabActionPlan().ansWrittenReferral().clear();
		ims.core.vo.lookups.YesNoCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNo(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyr1().tabActionPlan().ansWrittenReferral().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansWrittenReferralLookupValue()
	{
		this.form.lyr1().tabActionPlan().ansWrittenReferral().setValue((ims.core.vo.lookups.YesNo)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNo.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNo.TYPE_ID));
	}
	protected final void onansFollowUpValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyr1().tabActionPlan().ansFollowUp().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansFollowUpLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNo)
		{
			ims.core.vo.lookups.YesNo instance = (ims.core.vo.lookups.YesNo)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansFollowUpLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyr1().tabActionPlan().ansFollowUp().addOption(instance);
		}
	}
	protected final void bindansFollowUpLookup()
	{
		this.form.lyr1().tabActionPlan().ansFollowUp().clear();
		ims.core.vo.lookups.YesNoCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNo(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyr1().tabActionPlan().ansFollowUp().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansFollowUpLookupValue()
	{
		this.form.lyr1().tabActionPlan().ansFollowUp().setValue((ims.core.vo.lookups.YesNo)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNo.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNo.TYPE_ID));
	}
	protected final void onansTelephoneValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyr1().tabActionPlan().ansTelephone().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansTelephoneLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNo)
		{
			ims.core.vo.lookups.YesNo instance = (ims.core.vo.lookups.YesNo)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansTelephoneLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyr1().tabActionPlan().ansTelephone().addOption(instance);
		}
	}
	protected final void bindansTelephoneLookup()
	{
		this.form.lyr1().tabActionPlan().ansTelephone().clear();
		ims.core.vo.lookups.YesNoCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNo(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyr1().tabActionPlan().ansTelephone().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansTelephoneLookupValue()
	{
		this.form.lyr1().tabActionPlan().ansTelephone().setValue((ims.core.vo.lookups.YesNo)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNo.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNo.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinical.domain.ChronicPainReferral domain;
}
