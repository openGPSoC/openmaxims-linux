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

package ims.core.forms.vitalsignspupils;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.core.domain.VitalSignsPupils.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.core.domain.VitalSignsPupils domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbReactionRightValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbReactionRight().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.VSPupilReaction existingInstance = (ims.core.vo.lookups.VSPupilReaction)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReactionRightLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.VSPupilReaction)
		{
			ims.core.vo.lookups.VSPupilReaction instance = (ims.core.vo.lookups.VSPupilReaction)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReactionRightLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.VSPupilReaction existingInstance = (ims.core.vo.lookups.VSPupilReaction)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbReactionRight().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReactionRightLookup()
	{
		this.form.cmbReactionRight().clear();
		ims.core.vo.lookups.VSPupilReactionCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getVSPupilReaction(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbReactionRight().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReactionRightLookupValue(int id)
	{
		ims.core.vo.lookups.VSPupilReaction instance = ims.core.vo.lookups.LookupHelper.getVSPupilReactionInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbReactionRight().setValue(instance);
	}
	protected final void defaultcmbReactionRightLookupValue()
	{
		this.form.cmbReactionRight().setValue((ims.core.vo.lookups.VSPupilReaction)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.VSPupilReaction.class, engine.getFormName().getID(), ims.core.vo.lookups.VSPupilReaction.TYPE_ID));
	}
	protected final void oncmbReactionLeftValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbReactionLeft().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.VSPupilReaction existingInstance = (ims.core.vo.lookups.VSPupilReaction)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReactionLeftLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.VSPupilReaction)
		{
			ims.core.vo.lookups.VSPupilReaction instance = (ims.core.vo.lookups.VSPupilReaction)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReactionLeftLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.VSPupilReaction existingInstance = (ims.core.vo.lookups.VSPupilReaction)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbReactionLeft().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReactionLeftLookup()
	{
		this.form.cmbReactionLeft().clear();
		ims.core.vo.lookups.VSPupilReactionCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getVSPupilReaction(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbReactionLeft().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReactionLeftLookupValue(int id)
	{
		ims.core.vo.lookups.VSPupilReaction instance = ims.core.vo.lookups.LookupHelper.getVSPupilReactionInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbReactionLeft().setValue(instance);
	}
	protected final void defaultcmbReactionLeftLookupValue()
	{
		this.form.cmbReactionLeft().setValue((ims.core.vo.lookups.VSPupilReaction)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.VSPupilReaction.class, engine.getFormName().getID(), ims.core.vo.lookups.VSPupilReaction.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.core.domain.VitalSignsPupils domain;
}
