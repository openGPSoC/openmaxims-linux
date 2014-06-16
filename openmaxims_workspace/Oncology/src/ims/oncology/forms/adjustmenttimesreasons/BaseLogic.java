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

package ims.oncology.forms.adjustmenttimesreasons;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.oncology.domain.AdjustmentTimesReasons.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.oncology.domain.AdjustmentTimesReasons domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbReason1ValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbReason1().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.DateReferralDateFirstSeenReason existingInstance = (ims.oncology.vo.lookups.DateReferralDateFirstSeenReason)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReason1Lookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.DateReferralDateFirstSeenReason)
		{
			ims.oncology.vo.lookups.DateReferralDateFirstSeenReason instance = (ims.oncology.vo.lookups.DateReferralDateFirstSeenReason)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReason1Lookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.DateReferralDateFirstSeenReason existingInstance = (ims.oncology.vo.lookups.DateReferralDateFirstSeenReason)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbReason1().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReason1Lookup()
	{
		this.form.cmbReason1().clear();
		ims.oncology.vo.lookups.DateReferralDateFirstSeenReasonCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getDateReferralDateFirstSeenReason(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbReason1().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReason1LookupValue(int id)
	{
		ims.oncology.vo.lookups.DateReferralDateFirstSeenReason instance = ims.oncology.vo.lookups.LookupHelper.getDateReferralDateFirstSeenReasonInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbReason1().setValue(instance);
	}
	protected final void defaultcmbReason1LookupValue()
	{
		this.form.cmbReason1().setValue((ims.oncology.vo.lookups.DateReferralDateFirstSeenReason)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.DateReferralDateFirstSeenReason.class, engine.getFormName().getID(), ims.oncology.vo.lookups.DateReferralDateFirstSeenReason.TYPE_ID));
	}
	protected final void oncmbReason2ValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbReason2().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.DateFirstSeenDateDecTreatReas existingInstance = (ims.oncology.vo.lookups.DateFirstSeenDateDecTreatReas)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReason2Lookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.DateFirstSeenDateDecTreatReas)
		{
			ims.oncology.vo.lookups.DateFirstSeenDateDecTreatReas instance = (ims.oncology.vo.lookups.DateFirstSeenDateDecTreatReas)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReason2Lookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.DateFirstSeenDateDecTreatReas existingInstance = (ims.oncology.vo.lookups.DateFirstSeenDateDecTreatReas)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbReason2().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReason2Lookup()
	{
		this.form.cmbReason2().clear();
		ims.oncology.vo.lookups.DateFirstSeenDateDecTreatReasCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getDateFirstSeenDateDecTreatReas(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbReason2().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReason2LookupValue(int id)
	{
		ims.oncology.vo.lookups.DateFirstSeenDateDecTreatReas instance = ims.oncology.vo.lookups.LookupHelper.getDateFirstSeenDateDecTreatReasInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbReason2().setValue(instance);
	}
	protected final void defaultcmbReason2LookupValue()
	{
		this.form.cmbReason2().setValue((ims.oncology.vo.lookups.DateFirstSeenDateDecTreatReas)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.DateFirstSeenDateDecTreatReas.class, engine.getFormName().getID(), ims.oncology.vo.lookups.DateFirstSeenDateDecTreatReas.TYPE_ID));
	}
	protected final void oncmbReason3ValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbReason3().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.ReasDateDecTreatTreatment existingInstance = (ims.oncology.vo.lookups.ReasDateDecTreatTreatment)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReason3Lookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.ReasDateDecTreatTreatment)
		{
			ims.oncology.vo.lookups.ReasDateDecTreatTreatment instance = (ims.oncology.vo.lookups.ReasDateDecTreatTreatment)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReason3Lookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.ReasDateDecTreatTreatment existingInstance = (ims.oncology.vo.lookups.ReasDateDecTreatTreatment)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbReason3().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReason3Lookup()
	{
		this.form.cmbReason3().clear();
		ims.oncology.vo.lookups.ReasDateDecTreatTreatmentCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getReasDateDecTreatTreatment(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbReason3().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReason3LookupValue(int id)
	{
		ims.oncology.vo.lookups.ReasDateDecTreatTreatment instance = ims.oncology.vo.lookups.LookupHelper.getReasDateDecTreatTreatmentInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbReason3().setValue(instance);
	}
	protected final void defaultcmbReason3LookupValue()
	{
		this.form.cmbReason3().setValue((ims.oncology.vo.lookups.ReasDateDecTreatTreatment)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.ReasDateDecTreatTreatment.class, engine.getFormName().getID(), ims.oncology.vo.lookups.ReasDateDecTreatTreatment.TYPE_ID));
	}
	protected final void oncmbRefTreatmentValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbRefTreatment().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.DelayReasReferralTreat existingInstance = (ims.oncology.vo.lookups.DelayReasReferralTreat)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbRefTreatmentLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.DelayReasReferralTreat)
		{
			ims.oncology.vo.lookups.DelayReasReferralTreat instance = (ims.oncology.vo.lookups.DelayReasReferralTreat)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbRefTreatmentLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.DelayReasReferralTreat existingInstance = (ims.oncology.vo.lookups.DelayReasReferralTreat)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbRefTreatment().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbRefTreatmentLookup()
	{
		this.form.cmbRefTreatment().clear();
		ims.oncology.vo.lookups.DelayReasReferralTreatCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getDelayReasReferralTreat(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbRefTreatment().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbRefTreatmentLookupValue(int id)
	{
		ims.oncology.vo.lookups.DelayReasReferralTreat instance = ims.oncology.vo.lookups.LookupHelper.getDelayReasReferralTreatInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbRefTreatment().setValue(instance);
	}
	protected final void defaultcmbRefTreatmentLookupValue()
	{
		this.form.cmbRefTreatment().setValue((ims.oncology.vo.lookups.DelayReasReferralTreat)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.DelayReasReferralTreat.class, engine.getFormName().getID(), ims.oncology.vo.lookups.DelayReasReferralTreat.TYPE_ID));
	}
	protected final void oncmbDecisionToTreatValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbDecisionToTreat().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.DelayReasDecTreatTreat existingInstance = (ims.oncology.vo.lookups.DelayReasDecTreatTreat)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDecisionToTreatLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.oncology.vo.lookups.DelayReasDecTreatTreat)
		{
			ims.oncology.vo.lookups.DelayReasDecTreatTreat instance = (ims.oncology.vo.lookups.DelayReasDecTreatTreat)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDecisionToTreatLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.oncology.vo.lookups.DelayReasDecTreatTreat existingInstance = (ims.oncology.vo.lookups.DelayReasDecTreatTreat)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbDecisionToTreat().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDecisionToTreatLookup()
	{
		this.form.cmbDecisionToTreat().clear();
		ims.oncology.vo.lookups.DelayReasDecTreatTreatCollection lookupCollection = ims.oncology.vo.lookups.LookupHelper.getDelayReasDecTreatTreat(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbDecisionToTreat().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDecisionToTreatLookupValue(int id)
	{
		ims.oncology.vo.lookups.DelayReasDecTreatTreat instance = ims.oncology.vo.lookups.LookupHelper.getDelayReasDecTreatTreatInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbDecisionToTreat().setValue(instance);
	}
	protected final void defaultcmbDecisionToTreatLookupValue()
	{
		this.form.cmbDecisionToTreat().setValue((ims.oncology.vo.lookups.DelayReasDecTreatTreat)domain.getLookupService().getDefaultInstance(ims.oncology.vo.lookups.DelayReasDecTreatTreat.class, engine.getFormName().getID(), ims.oncology.vo.lookups.DelayReasDecTreatTreat.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.oncology.domain.AdjustmentTimesReasons domain;
}
