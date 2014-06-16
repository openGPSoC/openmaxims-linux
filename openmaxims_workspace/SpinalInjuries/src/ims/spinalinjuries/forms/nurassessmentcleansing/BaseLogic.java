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

package ims.spinalinjuries.forms.nurassessmentcleansing;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.spinalinjuries.domain.NurAssessmentCleansing.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.spinalinjuries.domain.NurAssessmentCleansing domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbBathingPatternValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbBathingPattern().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.BathingPattern existingInstance = (ims.nursing.vo.lookups.BathingPattern)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbBathingPatternLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.BathingPattern)
		{
			ims.nursing.vo.lookups.BathingPattern instance = (ims.nursing.vo.lookups.BathingPattern)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbBathingPatternLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.BathingPattern existingInstance = (ims.nursing.vo.lookups.BathingPattern)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbBathingPattern().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbBathingPatternLookup()
	{
		this.form.cmbBathingPattern().clear();
		ims.nursing.vo.lookups.BathingPatternCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getBathingPattern(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbBathingPattern().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbBathingPatternLookupValue(int id)
	{
		ims.nursing.vo.lookups.BathingPattern instance = ims.nursing.vo.lookups.LookupHelper.getBathingPatternInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbBathingPattern().setValue(instance);
	}
	protected final void defaultcmbBathingPatternLookupValue()
	{
		this.form.cmbBathingPattern().setValue((ims.nursing.vo.lookups.BathingPattern)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.BathingPattern.class, engine.getFormName().getID(), ims.nursing.vo.lookups.BathingPattern.TYPE_ID));
	}
	protected final void bindgrdHygienecolAbilityLookup()
	{
		this.form.grdHygiene().colAbilityComboBox().clear();
		ims.nursing.vo.lookups.AbilityCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getAbility(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdHygiene().colAbilityComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgrdDressingcolAbilityLookup()
	{
		this.form.grdDressing().colAbilityComboBox().clear();
		ims.nursing.vo.lookups.AbilityCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getAbility(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdDressing().colAbilityComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected void clearScreen()
	{
		this.form.chkSectionComplete().setValue(false);
		this.form.cmbBathingPattern().setValue(null);
		this.form.txtFrequency().setValue("");
		this.form.chkCopy().setValue(false);
	}
	protected void populateScreenFromData(ims.spinalinjuries.vo.NurAssessmentCleansingDressingVo value)
	{
		clearScreen();
		if(value == null)
			return;

		if(value.getIsCompleteIsNotNull())
			this.form.chkSectionComplete().setValue(value.getIsComplete().booleanValue());
		this.form.cmbBathingPattern().setValue(value.getBathingPatternIsNotNull() ? value.getBathingPattern() : null);
		this.form.txtFrequency().setValue(value.getFrequencyIsNotNull() ? value.getFrequency(): null);
		if(value.getCopyIsNotNull())
			this.form.chkCopy().setValue(value.getCopy().booleanValue());
	}
	protected ims.spinalinjuries.vo.NurAssessmentCleansingDressingVo populateDataFromScreen(ims.spinalinjuries.vo.NurAssessmentCleansingDressingVo value)
	{
		if(value == null)
			value = new ims.spinalinjuries.vo.NurAssessmentCleansingDressingVo();

		value.setIsComplete(new Boolean(this.form.chkSectionComplete().getValue()));
		value.setBathingPattern(this.form.cmbBathingPattern().getValue());
		value.setFrequency(this.form.txtFrequency().getValue());
		value.setCopy(new Boolean(this.form.chkCopy().getValue()));

		return value;
	}
	protected ims.spinalinjuries.vo.NurAssessmentCleansingDressingVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.spinalinjuries.vo.NurAssessmentCleansingDressingVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.spinalinjuries.domain.NurAssessmentCleansing domain;
}
