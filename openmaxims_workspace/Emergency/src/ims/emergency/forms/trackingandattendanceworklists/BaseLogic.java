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

package ims.emergency.forms.trackingandattendanceworklists;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.emergency.domain.TrackingAndAttendanceWorklists.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.emergency.domain.TrackingAndAttendanceWorklists domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbPresentingProblemValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbPresentingProblem().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.PresentingComplaint existingInstance = (ims.emergency.vo.lookups.PresentingComplaint)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPresentingProblemLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.emergency.vo.lookups.PresentingComplaint)
		{
			ims.emergency.vo.lookups.PresentingComplaint instance = (ims.emergency.vo.lookups.PresentingComplaint)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPresentingProblemLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.PresentingComplaint existingInstance = (ims.emergency.vo.lookups.PresentingComplaint)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbPresentingProblem().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPresentingProblemLookup()
	{
		this.form.cmbPresentingProblem().clear();
		ims.emergency.vo.lookups.PresentingComplaintCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getPresentingComplaint(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbPresentingProblem().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPresentingProblemLookupValue(int id)
	{
		ims.emergency.vo.lookups.PresentingComplaint instance = ims.emergency.vo.lookups.LookupHelper.getPresentingComplaintInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbPresentingProblem().setValue(instance);
	}
	protected final void defaultcmbPresentingProblemLookupValue()
	{
		this.form.cmbPresentingProblem().setValue((ims.emergency.vo.lookups.PresentingComplaint)domain.getLookupService().getDefaultInstance(ims.emergency.vo.lookups.PresentingComplaint.class, engine.getFormName().getID(), ims.emergency.vo.lookups.PresentingComplaint.TYPE_ID));
	}
	protected final void oncmbSourceOfReferralValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSourceOfReferral().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.ReferredBy existingInstance = (ims.emergency.vo.lookups.ReferredBy)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSourceOfReferralLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.emergency.vo.lookups.ReferredBy)
		{
			ims.emergency.vo.lookups.ReferredBy instance = (ims.emergency.vo.lookups.ReferredBy)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSourceOfReferralLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.ReferredBy existingInstance = (ims.emergency.vo.lookups.ReferredBy)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSourceOfReferral().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSourceOfReferralLookup()
	{
		this.form.cmbSourceOfReferral().clear();
		ims.emergency.vo.lookups.ReferredByCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getReferredBy(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSourceOfReferral().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSourceOfReferralLookupValue(int id)
	{
		ims.emergency.vo.lookups.ReferredBy instance = ims.emergency.vo.lookups.LookupHelper.getReferredByInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSourceOfReferral().setValue(instance);
	}
	protected final void defaultcmbSourceOfReferralLookupValue()
	{
		this.form.cmbSourceOfReferral().setValue((ims.emergency.vo.lookups.ReferredBy)domain.getLookupService().getDefaultInstance(ims.emergency.vo.lookups.ReferredBy.class, engine.getFormName().getID(), ims.emergency.vo.lookups.ReferredBy.TYPE_ID));
	}
	protected final void oncmbOutcomeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbOutcome().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.AttendanceOutcome existingInstance = (ims.emergency.vo.lookups.AttendanceOutcome)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbOutcomeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.emergency.vo.lookups.AttendanceOutcome)
		{
			ims.emergency.vo.lookups.AttendanceOutcome instance = (ims.emergency.vo.lookups.AttendanceOutcome)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbOutcomeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.AttendanceOutcome existingInstance = (ims.emergency.vo.lookups.AttendanceOutcome)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbOutcome().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbOutcomeLookup()
	{
		this.form.cmbOutcome().clear();
		ims.emergency.vo.lookups.AttendanceOutcomeCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getAttendanceOutcome(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbOutcome().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbOutcomeLookupValue(int id)
	{
		ims.emergency.vo.lookups.AttendanceOutcome instance = ims.emergency.vo.lookups.LookupHelper.getAttendanceOutcomeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbOutcome().setValue(instance);
	}
	protected final void defaultcmbOutcomeLookupValue()
	{
		this.form.cmbOutcome().setValue((ims.emergency.vo.lookups.AttendanceOutcome)domain.getLookupService().getDefaultInstance(ims.emergency.vo.lookups.AttendanceOutcome.class, engine.getFormName().getID(), ims.emergency.vo.lookups.AttendanceOutcome.TYPE_ID));
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
					ims.emergency.vo.lookups.TriagePriority existingInstance = (ims.emergency.vo.lookups.TriagePriority)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPriorityLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.emergency.vo.lookups.TriagePriority)
		{
			ims.emergency.vo.lookups.TriagePriority instance = (ims.emergency.vo.lookups.TriagePriority)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPriorityLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.TriagePriority existingInstance = (ims.emergency.vo.lookups.TriagePriority)listOfValues.get(x);
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
		ims.emergency.vo.lookups.TriagePriorityCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getTriagePriority(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbPriority().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPriorityLookupValue(int id)
	{
		ims.emergency.vo.lookups.TriagePriority instance = ims.emergency.vo.lookups.LookupHelper.getTriagePriorityInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbPriority().setValue(instance);
	}
	protected final void defaultcmbPriorityLookupValue()
	{
		this.form.cmbPriority().setValue((ims.emergency.vo.lookups.TriagePriority)domain.getLookupService().getDefaultInstance(ims.emergency.vo.lookups.TriagePriority.class, engine.getFormName().getID(), ims.emergency.vo.lookups.TriagePriority.TYPE_ID));
	}
	protected final void oncmbConsultantSpecialtyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbConsultantSpecialty().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam existingInstance = (ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbConsultantSpecialtyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam)
		{
			ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam instance = (ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbConsultantSpecialtyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam existingInstance = (ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbConsultantSpecialty().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbConsultantSpecialtyLookup()
	{
		this.form.cmbConsultantSpecialty().clear();
		ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeamCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getReferralSpecialtyConsultantOrTeam(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbConsultantSpecialty().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbConsultantSpecialtyLookupValue(int id)
	{
		ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam instance = ims.emergency.vo.lookups.LookupHelper.getReferralSpecialtyConsultantOrTeamInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbConsultantSpecialty().setValue(instance);
	}
	protected final void defaultcmbConsultantSpecialtyLookupValue()
	{
		this.form.cmbConsultantSpecialty().setValue((ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam)domain.getLookupService().getDefaultInstance(ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam.class, engine.getFormName().getID(), ims.emergency.vo.lookups.ReferralSpecialtyConsultantOrTeam.TYPE_ID));
	}
	protected final void oncmbSpecialtyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSpecialty().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Specialty existingInstance = (ims.core.vo.lookups.Specialty)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSpecialtyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.Specialty)
		{
			ims.core.vo.lookups.Specialty instance = (ims.core.vo.lookups.Specialty)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSpecialtyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Specialty existingInstance = (ims.core.vo.lookups.Specialty)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSpecialty().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSpecialtyLookup()
	{
		this.form.cmbSpecialty().clear();
		ims.core.vo.lookups.SpecialtyCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSpecialty(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSpecialty().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSpecialtyLookupValue(int id)
	{
		ims.core.vo.lookups.Specialty instance = ims.core.vo.lookups.LookupHelper.getSpecialtyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSpecialty().setValue(instance);
	}
	protected final void defaultcmbSpecialtyLookupValue()
	{
		this.form.cmbSpecialty().setValue((ims.core.vo.lookups.Specialty)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.Specialty.class, engine.getFormName().getID(), ims.core.vo.lookups.Specialty.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.emergency.domain.TrackingAndAttendanceWorklists domain;
}
