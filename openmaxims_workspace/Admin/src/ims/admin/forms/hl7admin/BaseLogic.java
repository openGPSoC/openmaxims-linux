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

package ims.admin.forms.hl7admin;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.admin.domain.Hl7Admin.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.admin.domain.Hl7Admin domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbPatIdTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrHL7().tabQuery().cmbPatIdType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatIdType existingInstance = (ims.core.vo.lookups.PatIdType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPatIdTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.PatIdType)
		{
			ims.core.vo.lookups.PatIdType instance = (ims.core.vo.lookups.PatIdType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPatIdTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatIdType existingInstance = (ims.core.vo.lookups.PatIdType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrHL7().tabQuery().cmbPatIdType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPatIdTypeLookup()
	{
		this.form.lyrHL7().tabQuery().cmbPatIdType().clear();
		ims.core.vo.lookups.PatIdTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPatIdType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrHL7().tabQuery().cmbPatIdType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPatIdTypeLookupValue(int id)
	{
		ims.core.vo.lookups.PatIdType instance = ims.core.vo.lookups.LookupHelper.getPatIdTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrHL7().tabQuery().cmbPatIdType().setValue(instance);
	}
	protected final void defaultcmbPatIdTypeLookupValue()
	{
		this.form.lyrHL7().tabQuery().cmbPatIdType().setValue((ims.core.vo.lookups.PatIdType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PatIdType.class, engine.getFormName().getID(), ims.core.vo.lookups.PatIdType.TYPE_ID));
	}
	protected final void oncmbPatIdValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrHL7().tabDemographicFeed().cmbPatId().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatIdType existingInstance = (ims.core.vo.lookups.PatIdType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPatIdLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.PatIdType)
		{
			ims.core.vo.lookups.PatIdType instance = (ims.core.vo.lookups.PatIdType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPatIdLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatIdType existingInstance = (ims.core.vo.lookups.PatIdType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrHL7().tabDemographicFeed().cmbPatId().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPatIdLookup()
	{
		this.form.lyrHL7().tabDemographicFeed().cmbPatId().clear();
		ims.core.vo.lookups.PatIdTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPatIdType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrHL7().tabDemographicFeed().cmbPatId().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPatIdLookupValue(int id)
	{
		ims.core.vo.lookups.PatIdType instance = ims.core.vo.lookups.LookupHelper.getPatIdTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrHL7().tabDemographicFeed().cmbPatId().setValue(instance);
	}
	protected final void defaultcmbPatIdLookupValue()
	{
		this.form.lyrHL7().tabDemographicFeed().cmbPatId().setValue((ims.core.vo.lookups.PatIdType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PatIdType.class, engine.getFormName().getID(), ims.core.vo.lookups.PatIdType.TYPE_ID));
	}
	protected final void oncmbMsgTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrHL7().tabDemographicFeed().cmbMsgType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MsgEventType existingInstance = (ims.core.vo.lookups.MsgEventType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbMsgTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.MsgEventType)
		{
			ims.core.vo.lookups.MsgEventType instance = (ims.core.vo.lookups.MsgEventType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbMsgTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MsgEventType existingInstance = (ims.core.vo.lookups.MsgEventType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrHL7().tabDemographicFeed().cmbMsgType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbMsgTypeLookup()
	{
		this.form.lyrHL7().tabDemographicFeed().cmbMsgType().clear();
		ims.core.vo.lookups.MsgEventTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getMsgEventType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrHL7().tabDemographicFeed().cmbMsgType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbMsgTypeLookupValue(int id)
	{
		ims.core.vo.lookups.MsgEventType instance = ims.core.vo.lookups.LookupHelper.getMsgEventTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrHL7().tabDemographicFeed().cmbMsgType().setValue(instance);
	}
	protected final void defaultcmbMsgTypeLookupValue()
	{
		this.form.lyrHL7().tabDemographicFeed().cmbMsgType().setValue((ims.core.vo.lookups.MsgEventType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.MsgEventType.class, engine.getFormName().getID(), ims.core.vo.lookups.MsgEventType.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.admin.domain.Hl7Admin domain;
}
