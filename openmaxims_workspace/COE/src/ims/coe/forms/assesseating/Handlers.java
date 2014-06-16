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

package ims.coe.forms.assesseating;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcomboBoxAppetiteLookup();
	abstract protected void defaultcomboBoxAppetiteLookupValue();
	abstract protected void bindanswerBoxSpecialDietLookup();
	abstract protected void defaultanswerBoxSpecialDietLookupValue();
	abstract protected void bindanswerBoxRequireAssistanceLookup();
	abstract protected void defaultanswerBoxRequireAssistanceLookupValue();
	abstract protected void bindanswerBoxDifficultySwallowingLookup();
	abstract protected void defaultanswerBoxDifficultySwallowingLookupValue();
	abstract protected void bindcomboBoxDietLookup();
	abstract protected void defaultcomboBoxDietLookupValue();
	abstract protected void bindgridSwallowColStatusLookup();
	abstract protected void bindgridOralColStatusLookup();
	abstract protected void bindgridDexerityColStatusLookup();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncomboBoxAppetiteValueSet(Object value);
	abstract protected void onLinkMNAClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onanswerBoxSpecialDietValueSet(Object value);
	abstract protected void onAnswerBoxSpecialDietValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onanswerBoxRequireAssistanceValueSet(Object value);
	abstract protected void onanswerBoxDifficultySwallowingValueSet(Object value);
	abstract protected void oncomboBoxDietValueSet(Object value);
	abstract protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCopyPrevAssessmentValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onInfoLinkClick() throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen();
			}
		});
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.container1().comboBoxAppetite().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncomboBoxAppetiteValueSet(value);
			}
		});
		this.form.container1().linkMNA().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLinkMNAClick();
			}
		});
		this.form.container1().answerBoxSpecialDiet().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onanswerBoxSpecialDietValueSet(value);
			}
		});
		this.form.container1().answerBoxSpecialDiet().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onAnswerBoxSpecialDietValueChanged();
			}
		});
		this.form.container1().answerBoxRequireAssistance().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onanswerBoxRequireAssistanceValueSet(value);
			}
		});
		this.form.container1().answerBoxDifficultySwallowing().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onanswerBoxDifficultySwallowingValueSet(value);
			}
		});
		this.form.container1().comboBoxDiet().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncomboBoxDietValueSet(value);
			}
		});
		this.form.container1().bSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBSaveClick();
			}
		});
		this.form.container1().bCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBCancelClick();
			}
		});
		this.form.checkBoxCopy().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCopyPrevAssessmentValueChanged();
			}
		});
		this.form.linkInfo().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onInfoLinkClick();
			}
		});
	}
	protected void bindLookups()
	{
		bindcomboBoxAppetiteLookup();
		bindanswerBoxSpecialDietLookup();
		bindanswerBoxRequireAssistanceLookup();
		bindanswerBoxDifficultySwallowingLookup();
		bindcomboBoxDietLookup();
		bindgridSwallowColStatusLookup();
		bindgridOralColStatusLookup();
		bindgridDexerityColStatusLookup();
	}
	protected void rebindAllLookups()
	{
		bindcomboBoxAppetiteLookup();
		bindanswerBoxSpecialDietLookup();
		bindanswerBoxRequireAssistanceLookup();
		bindanswerBoxDifficultySwallowingLookup();
		bindcomboBoxDietLookup();
		bindgridSwallowColStatusLookup();
		bindgridOralColStatusLookup();
		bindgridDexerityColStatusLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcomboBoxAppetiteLookupValue();
		defaultanswerBoxSpecialDietLookupValue();
		defaultanswerBoxRequireAssistanceLookupValue();
		defaultanswerBoxDifficultySwallowingLookupValue();
		defaultcomboBoxDietLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
