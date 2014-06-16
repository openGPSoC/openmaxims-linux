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

package ims.assessment.forms.userassessmentnew;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.assessment.domain.UserAssessmentNew.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.assessment.domain.UserAssessmentNew domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbCopyLastValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbCopyLast().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.assessment.vo.lookups.CopyLastAssessmentContextType existingInstance = (ims.assessment.vo.lookups.CopyLastAssessmentContextType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCopyLastLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.assessment.vo.lookups.CopyLastAssessmentContextType)
		{
			ims.assessment.vo.lookups.CopyLastAssessmentContextType instance = (ims.assessment.vo.lookups.CopyLastAssessmentContextType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCopyLastLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.assessment.vo.lookups.CopyLastAssessmentContextType existingInstance = (ims.assessment.vo.lookups.CopyLastAssessmentContextType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbCopyLast().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCopyLastLookup()
	{
		this.form.cmbCopyLast().clear();
		ims.assessment.vo.lookups.CopyLastAssessmentContextTypeCollection lookupCollection = ims.assessment.vo.lookups.LookupHelper.getCopyLastAssessmentContextType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbCopyLast().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCopyLastLookupValue(int id)
	{
		ims.assessment.vo.lookups.CopyLastAssessmentContextType instance = ims.assessment.vo.lookups.LookupHelper.getCopyLastAssessmentContextTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbCopyLast().setValue(instance);
	}
	protected final void defaultcmbCopyLastLookupValue()
	{
		this.form.cmbCopyLast().setValue((ims.assessment.vo.lookups.CopyLastAssessmentContextType)domain.getLookupService().getDefaultInstance(ims.assessment.vo.lookups.CopyLastAssessmentContextType.class, engine.getFormName().getID(), ims.assessment.vo.lookups.CopyLastAssessmentContextType.TYPE_ID));
	}
	protected final void bindgrdGroupscolStatusLookup()
	{
		this.form.lyrTabs().tabGroups().grdGroups().colStatusComboBox().clear();
		ims.core.vo.lookups.PreActiveActiveInactiveStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrTabs().tabGroups().grdGroups().colStatusComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void oncmbActiveStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbActiveStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PreActiveActiveInactiveStatus existingInstance = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbActiveStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.PreActiveActiveInactiveStatus)
		{
			ims.core.vo.lookups.PreActiveActiveInactiveStatus instance = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbActiveStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PreActiveActiveInactiveStatus existingInstance = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbActiveStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbActiveStatusLookup()
	{
		this.form.cmbActiveStatus().clear();
		ims.core.vo.lookups.PreActiveActiveInactiveStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbActiveStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbActiveStatusLookupValue(int id)
	{
		ims.core.vo.lookups.PreActiveActiveInactiveStatus instance = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbActiveStatus().setValue(instance);
	}
	protected final void defaultcmbActiveStatusLookupValue()
	{
		this.form.cmbActiveStatus().setValue((ims.core.vo.lookups.PreActiveActiveInactiveStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PreActiveActiveInactiveStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.PreActiveActiveInactiveStatus.TYPE_ID));
	}
	protected final void oncmbScoringMethodValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbScoringMethod().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.UserAssessmentScoringMethod existingInstance = (ims.core.vo.lookups.UserAssessmentScoringMethod)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbScoringMethodLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.UserAssessmentScoringMethod)
		{
			ims.core.vo.lookups.UserAssessmentScoringMethod instance = (ims.core.vo.lookups.UserAssessmentScoringMethod)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbScoringMethodLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.UserAssessmentScoringMethod existingInstance = (ims.core.vo.lookups.UserAssessmentScoringMethod)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbScoringMethod().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbScoringMethodLookup()
	{
		this.form.cmbScoringMethod().clear();
		ims.core.vo.lookups.UserAssessmentScoringMethodCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getUserAssessmentScoringMethod(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbScoringMethod().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbScoringMethodLookupValue(int id)
	{
		ims.core.vo.lookups.UserAssessmentScoringMethod instance = ims.core.vo.lookups.LookupHelper.getUserAssessmentScoringMethodInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbScoringMethod().setValue(instance);
	}
	protected final void defaultcmbScoringMethodLookupValue()
	{
		this.form.cmbScoringMethod().setValue((ims.core.vo.lookups.UserAssessmentScoringMethod)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.UserAssessmentScoringMethod.class, engine.getFormName().getID(), ims.core.vo.lookups.UserAssessmentScoringMethod.TYPE_ID));
	}
	protected final void oncmbCategoryValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbCategory().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.UserAssessmentCategory existingInstance = (ims.core.vo.lookups.UserAssessmentCategory)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCategoryLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.UserAssessmentCategory)
		{
			ims.core.vo.lookups.UserAssessmentCategory instance = (ims.core.vo.lookups.UserAssessmentCategory)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCategoryLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.UserAssessmentCategory existingInstance = (ims.core.vo.lookups.UserAssessmentCategory)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbCategory().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCategoryLookup()
	{
		this.form.cmbCategory().clear();
		ims.core.vo.lookups.UserAssessmentCategoryCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getUserAssessmentCategory(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbCategory().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCategoryLookupValue(int id)
	{
		ims.core.vo.lookups.UserAssessmentCategory instance = ims.core.vo.lookups.LookupHelper.getUserAssessmentCategoryInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbCategory().setValue(instance);
	}
	protected final void defaultcmbCategoryLookupValue()
	{
		this.form.cmbCategory().setValue((ims.core.vo.lookups.UserAssessmentCategory)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.UserAssessmentCategory.class, engine.getFormName().getID(), ims.core.vo.lookups.UserAssessmentCategory.TYPE_ID));
	}
	protected void clearScreen()
	{
		this.form.chkStorePrintedAssessment().setValue(false);
		this.form.chkCanCopy().setValue(false);
		this.form.cmbCopyLast().setValue(null);
		this.form.txtURL().setValue("");
		this.form.lyrTabs().tabHeaderText().intMaxHeaderHeight().setValue(null);
		this.form.lyrTabs().tabHeaderText().richTextHeaderInfo().setValue(null);
		this.form.lyrTabs().tabFooterText().intMaxFooterHeight().setValue(null);
		this.form.lyrTabs().tabFooterText().richTextFooterInfo().setValue(null);
		this.form.chkIsMultirole().setValue(false);
		this.form.intCustomWidth().setValue(null);
		this.form.chkMultipleGroup().setValue(false);
		this.form.chkFlatView().setValue(false);
		this.form.cmbActiveStatus().setValue(null);
		this.form.cmbScoringMethod().setValue(null);
		this.form.txtDescription().setValue("");
		this.form.cmbCategory().setValue(null);
		this.form.txtName().setValue("");
	}
	protected void populateScreenFromData(ims.assessment.vo.UserAssessmentVo value)
	{
		clearScreen();
		if(value == null)
			return;

		if(value.getStorePrintedAssessmentIsNotNull())
			this.form.chkStorePrintedAssessment().setValue(value.getStorePrintedAssessment().booleanValue());
		if(value.getCanCopyLastIsNotNull())
			this.form.chkCanCopy().setValue(value.getCanCopyLast().booleanValue());
		this.form.cmbCopyLast().setValue(value.getCopyLastFromContextIsNotNull() ? value.getCopyLastFromContext() : null);
		this.form.txtURL().setValue(value.getHelpURLIsNotNull() ? value.getHelpURL(): null);
		this.form.lyrTabs().tabHeaderText().intMaxHeaderHeight().setValue(value.getMaxHeaderHeightIsNotNull() ? value.getMaxHeaderHeight() : null);
		this.form.lyrTabs().tabHeaderText().richTextHeaderInfo().setValue(value.getHeaderTextIsNotNull() ? value.getHeaderText(): null);
		this.form.lyrTabs().tabFooterText().intMaxFooterHeight().setValue(value.getMaxFooterHeightIsNotNull() ? value.getMaxFooterHeight() : null);
		this.form.lyrTabs().tabFooterText().richTextFooterInfo().setValue(value.getFooterTextIsNotNull() ? value.getFooterText(): null);
		if(value.getIsMultiRoleIsNotNull())
			this.form.chkIsMultirole().setValue(value.getIsMultiRole().booleanValue());
		this.form.intCustomWidth().setValue(value.getGroupQuestionWidthIsNotNull() ? value.getGroupQuestionWidth() : null);
		if(value.getIsMultipleGroupIsNotNull())
			this.form.chkMultipleGroup().setValue(value.getIsMultipleGroup().booleanValue());
		if(value.getIsFlatViewIsNotNull())
			this.form.chkFlatView().setValue(value.getIsFlatView().booleanValue());
		this.form.cmbActiveStatus().setValue(value.getActiveStatusIsNotNull() ? value.getActiveStatus() : null);
		this.form.cmbScoringMethod().setValue(value.getScoringMethodIsNotNull() ? value.getScoringMethod() : null);
		this.form.txtDescription().setValue(value.getDescriptionIsNotNull() ? value.getDescription(): null);
		this.form.cmbCategory().setValue(value.getCategoryIsNotNull() ? value.getCategory() : null);
		this.form.txtName().setValue(value.getNameIsNotNull() ? value.getName(): null);
	}
	protected ims.assessment.vo.UserAssessmentVo populateDataFromScreen(ims.assessment.vo.UserAssessmentVo value)
	{
		if(value == null)
			value = new ims.assessment.vo.UserAssessmentVo();

		value.setStorePrintedAssessment(new Boolean(this.form.chkStorePrintedAssessment().getValue()));
		value.setCanCopyLast(new Boolean(this.form.chkCanCopy().getValue()));
		value.setCopyLastFromContext(this.form.cmbCopyLast().getValue());
		value.setHelpURL(this.form.txtURL().getValue());
		value.setMaxHeaderHeight(this.form.lyrTabs().tabHeaderText().intMaxHeaderHeight().getValue());
		value.setHeaderText(this.form.lyrTabs().tabHeaderText().richTextHeaderInfo().getValue());
		value.setMaxFooterHeight(this.form.lyrTabs().tabFooterText().intMaxFooterHeight().getValue());
		value.setFooterText(this.form.lyrTabs().tabFooterText().richTextFooterInfo().getValue());
		value.setIsMultiRole(new Boolean(this.form.chkIsMultirole().getValue()));
		value.setGroupQuestionWidth(this.form.intCustomWidth().getValue());
		value.setIsMultipleGroup(new Boolean(this.form.chkMultipleGroup().getValue()));
		value.setIsFlatView(new Boolean(this.form.chkFlatView().getValue()));
		value.setActiveStatus(this.form.cmbActiveStatus().getValue());
		value.setScoringMethod(this.form.cmbScoringMethod().getValue());
		value.setDescription(this.form.txtDescription().getValue());
		value.setCategory(this.form.cmbCategory().getValue());
		value.setName(this.form.txtName().getValue());

		return value;
	}
	protected ims.assessment.vo.UserAssessmentVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.assessment.vo.UserAssessmentVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.assessment.domain.UserAssessmentNew domain;
}
