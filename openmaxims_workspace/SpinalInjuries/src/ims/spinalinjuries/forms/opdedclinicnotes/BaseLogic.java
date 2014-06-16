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

package ims.spinalinjuries.forms.opdedclinicnotes;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.spinalinjuries.domain.OPDEDClinicNotes.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.spinalinjuries.domain.OPDEDClinicNotes domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void bindgrdTreatmentcolTriedLookup()
	{
		this.form.grdTreatment().colTriedComboBox().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdTreatment().colTriedComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgrdTreatmentcolScoreLookup()
	{
		this.form.grdTreatment().colScoreComboBox().clear();
		ims.core.vo.lookups.ErectDysTreatScoreCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getErectDysTreatScore(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdTreatment().colScoreComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void oncmbMaritalStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbMaritalStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MaritalStatus existingInstance = (ims.core.vo.lookups.MaritalStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbMaritalStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.MaritalStatus)
		{
			ims.core.vo.lookups.MaritalStatus instance = (ims.core.vo.lookups.MaritalStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbMaritalStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MaritalStatus existingInstance = (ims.core.vo.lookups.MaritalStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbMaritalStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbMaritalStatusLookup()
	{
		this.form.cmbMaritalStatus().clear();
		ims.core.vo.lookups.MaritalStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getMaritalStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbMaritalStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbMaritalStatusLookupValue(int id)
	{
		ims.core.vo.lookups.MaritalStatus instance = ims.core.vo.lookups.LookupHelper.getMaritalStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbMaritalStatus().setValue(instance);
	}
	protected final void defaultcmbMaritalStatusLookupValue()
	{
		this.form.cmbMaritalStatus().setValue((ims.core.vo.lookups.MaritalStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.MaritalStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.MaritalStatus.TYPE_ID));
	}
	protected final void oncmbErectionValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbErection().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.ErectDysfxnErectQual existingInstance = (ims.spinalinjuries.vo.lookups.ErectDysfxnErectQual)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbErectionLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.ErectDysfxnErectQual)
		{
			ims.spinalinjuries.vo.lookups.ErectDysfxnErectQual instance = (ims.spinalinjuries.vo.lookups.ErectDysfxnErectQual)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbErectionLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.ErectDysfxnErectQual existingInstance = (ims.spinalinjuries.vo.lookups.ErectDysfxnErectQual)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbErection().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbErectionLookup()
	{
		this.form.cmbErection().clear();
		ims.spinalinjuries.vo.lookups.ErectDysfxnErectQualCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getErectDysfxnErectQual(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbErection().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbErectionLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.ErectDysfxnErectQual instance = ims.spinalinjuries.vo.lookups.LookupHelper.getErectDysfxnErectQualInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbErection().setValue(instance);
	}
	protected final void defaultcmbErectionLookupValue()
	{
		this.form.cmbErection().setValue((ims.spinalinjuries.vo.lookups.ErectDysfxnErectQual)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.ErectDysfxnErectQual.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.ErectDysfxnErectQual.TYPE_ID));
	}
	protected final void oncmbConsentSgnValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbConsentSgn().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbConsentSgnLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbConsentSgnLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbConsentSgn().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbConsentSgnLookup()
	{
		this.form.cmbConsentSgn().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbConsentSgn().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbConsentSgnLookupValue(int id)
	{
		ims.core.vo.lookups.YesNoUnknown instance = ims.core.vo.lookups.LookupHelper.getYesNoUnknownInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbConsentSgn().setValue(instance);
	}
	protected final void defaultcmbConsentSgnLookupValue()
	{
		this.form.cmbConsentSgn().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void oncmbTxOptionsDiscValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTxOptionsDisc().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTxOptionsDiscLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTxOptionsDiscLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTxOptionsDisc().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTxOptionsDiscLookup()
	{
		this.form.cmbTxOptionsDisc().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTxOptionsDisc().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTxOptionsDiscLookupValue(int id)
	{
		ims.core.vo.lookups.YesNoUnknown instance = ims.core.vo.lookups.LookupHelper.getYesNoUnknownInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTxOptionsDisc().setValue(instance);
	}
	protected final void defaultcmbTxOptionsDiscLookupValue()
	{
		this.form.cmbTxOptionsDisc().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void oncmbAdviceLitGivenValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbAdviceLitGiven().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAdviceLitGivenLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAdviceLitGivenLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbAdviceLitGiven().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAdviceLitGivenLookup()
	{
		this.form.cmbAdviceLitGiven().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAdviceLitGiven().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAdviceLitGivenLookupValue(int id)
	{
		ims.core.vo.lookups.YesNoUnknown instance = ims.core.vo.lookups.LookupHelper.getYesNoUnknownInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAdviceLitGiven().setValue(instance);
	}
	protected final void defaultcmbAdviceLitGivenLookupValue()
	{
		this.form.cmbAdviceLitGiven().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.spinalinjuries.domain.OPDEDClinicNotes domain;
}
