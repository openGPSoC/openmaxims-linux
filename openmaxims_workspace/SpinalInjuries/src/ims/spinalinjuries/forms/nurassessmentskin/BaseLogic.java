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

package ims.spinalinjuries.forms.nurassessmentskin;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.spinalinjuries.domain.NurAssessmentSkin.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.spinalinjuries.domain.NurAssessmentSkin domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void bindgrdTurnsColDurationLookup()
	{
		this.form.grdTurns().ColDurationComboBox().clear();
		ims.nursing.vo.lookups.TurnsDurationCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getTurnsDuration(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdTurns().ColDurationComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgrdTurnsColPositionLookup()
	{
		this.form.grdTurns().ColPositionComboBox().clear();
		ims.core.vo.lookups.PatientPositionCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPatientPosition(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdTurns().ColPositionComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void oncmbTurnsPreformedByValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTurnsPreformedBy().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.TurnsPerformedBy existingInstance = (ims.nursing.vo.lookups.TurnsPerformedBy)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTurnsPreformedByLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.TurnsPerformedBy)
		{
			ims.nursing.vo.lookups.TurnsPerformedBy instance = (ims.nursing.vo.lookups.TurnsPerformedBy)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTurnsPreformedByLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.TurnsPerformedBy existingInstance = (ims.nursing.vo.lookups.TurnsPerformedBy)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTurnsPreformedBy().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTurnsPreformedByLookup()
	{
		this.form.cmbTurnsPreformedBy().clear();
		ims.nursing.vo.lookups.TurnsPerformedByCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getTurnsPerformedBy(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTurnsPreformedBy().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTurnsPreformedByLookupValue(int id)
	{
		ims.nursing.vo.lookups.TurnsPerformedBy instance = ims.nursing.vo.lookups.LookupHelper.getTurnsPerformedByInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTurnsPreformedBy().setValue(instance);
	}
	protected final void defaultcmbTurnsPreformedByLookupValue()
	{
		this.form.cmbTurnsPreformedBy().setValue((ims.nursing.vo.lookups.TurnsPerformedBy)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.TurnsPerformedBy.class, engine.getFormName().getID(), ims.nursing.vo.lookups.TurnsPerformedBy.TYPE_ID));
	}
	protected final void oncmbTypeOfTurnValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTypeOfTurn().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.TurnType existingInstance = (ims.nursing.vo.lookups.TurnType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTypeOfTurnLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.TurnType)
		{
			ims.nursing.vo.lookups.TurnType instance = (ims.nursing.vo.lookups.TurnType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTypeOfTurnLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.TurnType existingInstance = (ims.nursing.vo.lookups.TurnType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTypeOfTurn().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTypeOfTurnLookup()
	{
		this.form.cmbTypeOfTurn().clear();
		ims.nursing.vo.lookups.TurnTypeCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getTurnType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTypeOfTurn().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTypeOfTurnLookupValue(int id)
	{
		ims.nursing.vo.lookups.TurnType instance = ims.nursing.vo.lookups.LookupHelper.getTurnTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTypeOfTurn().setValue(instance);
	}
	protected final void defaultcmbTypeOfTurnLookupValue()
	{
		this.form.cmbTypeOfTurn().setValue((ims.nursing.vo.lookups.TurnType)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.TurnType.class, engine.getFormName().getID(), ims.nursing.vo.lookups.TurnType.TYPE_ID));
	}
	protected final void oncmbCushionTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbCushionType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.CushionType existingInstance = (ims.nursing.vo.lookups.CushionType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCushionTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.CushionType)
		{
			ims.nursing.vo.lookups.CushionType instance = (ims.nursing.vo.lookups.CushionType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCushionTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.CushionType existingInstance = (ims.nursing.vo.lookups.CushionType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbCushionType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCushionTypeLookup()
	{
		this.form.cmbCushionType().clear();
		ims.nursing.vo.lookups.CushionTypeCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getCushionType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbCushionType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCushionTypeLookupValue(int id)
	{
		ims.nursing.vo.lookups.CushionType instance = ims.nursing.vo.lookups.LookupHelper.getCushionTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbCushionType().setValue(instance);
	}
	protected final void defaultcmbCushionTypeLookupValue()
	{
		this.form.cmbCushionType().setValue((ims.nursing.vo.lookups.CushionType)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.CushionType.class, engine.getFormName().getID(), ims.nursing.vo.lookups.CushionType.TYPE_ID));
	}
	protected final void oncmbChairTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbChairType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.ChairType existingInstance = (ims.nursing.vo.lookups.ChairType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbChairTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.ChairType)
		{
			ims.nursing.vo.lookups.ChairType instance = (ims.nursing.vo.lookups.ChairType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbChairTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.ChairType existingInstance = (ims.nursing.vo.lookups.ChairType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbChairType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbChairTypeLookup()
	{
		this.form.cmbChairType().clear();
		ims.nursing.vo.lookups.ChairTypeCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getChairType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbChairType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbChairTypeLookupValue(int id)
	{
		ims.nursing.vo.lookups.ChairType instance = ims.nursing.vo.lookups.LookupHelper.getChairTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbChairType().setValue(instance);
	}
	protected final void defaultcmbChairTypeLookupValue()
	{
		this.form.cmbChairType().setValue((ims.nursing.vo.lookups.ChairType)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.ChairType.class, engine.getFormName().getID(), ims.nursing.vo.lookups.ChairType.TYPE_ID));
	}
	protected final void oncmbBedTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbBedType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.BedType existingInstance = (ims.nursing.vo.lookups.BedType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbBedTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.BedType)
		{
			ims.nursing.vo.lookups.BedType instance = (ims.nursing.vo.lookups.BedType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbBedTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.BedType existingInstance = (ims.nursing.vo.lookups.BedType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbBedType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbBedTypeLookup()
	{
		this.form.cmbBedType().clear();
		ims.nursing.vo.lookups.BedTypeCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getBedType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbBedType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbBedTypeLookupValue(int id)
	{
		ims.nursing.vo.lookups.BedType instance = ims.nursing.vo.lookups.LookupHelper.getBedTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbBedType().setValue(instance);
	}
	protected final void defaultcmbBedTypeLookupValue()
	{
		this.form.cmbBedType().setValue((ims.nursing.vo.lookups.BedType)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.BedType.class, engine.getFormName().getID(), ims.nursing.vo.lookups.BedType.TYPE_ID));
	}
	protected final void oncmbMatressTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbMatressType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.MattressType existingInstance = (ims.nursing.vo.lookups.MattressType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbMatressTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.MattressType)
		{
			ims.nursing.vo.lookups.MattressType instance = (ims.nursing.vo.lookups.MattressType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbMatressTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.MattressType existingInstance = (ims.nursing.vo.lookups.MattressType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbMatressType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbMatressTypeLookup()
	{
		this.form.cmbMatressType().clear();
		ims.nursing.vo.lookups.MattressTypeCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getMattressType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbMatressType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbMatressTypeLookupValue(int id)
	{
		ims.nursing.vo.lookups.MattressType instance = ims.nursing.vo.lookups.LookupHelper.getMattressTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbMatressType().setValue(instance);
	}
	protected final void defaultcmbMatressTypeLookupValue()
	{
		this.form.cmbMatressType().setValue((ims.nursing.vo.lookups.MattressType)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.MattressType.class, engine.getFormName().getID(), ims.nursing.vo.lookups.MattressType.TYPE_ID));
	}
	protected void clearScreen()
	{
		this.form.cmbTurnsPreformedBy().setValue(null);
		this.form.cmbTypeOfTurn().setValue(null);
		this.form.chkSectionComplete().setValue(false);
		this.form.txtNotes().setValue("");
		this.form.cmbCushionType().setValue(null);
		this.form.cmbChairType().setValue(null);
		this.form.cmbBedType().setValue(null);
		this.form.cmbMatressType().setValue(null);
		this.form.chkCopy().setValue(false);
	}
	protected void populateScreenFromData(ims.spinalinjuries.vo.NurAssessmentSkinVo value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.cmbTurnsPreformedBy().setValue(value.getTurnsPerformedByIsNotNull() ? value.getTurnsPerformedBy() : null);
		this.form.cmbTypeOfTurn().setValue(value.getTurnTypeIsNotNull() ? value.getTurnType() : null);
		if(value.getIsCompleteIsNotNull())
			this.form.chkSectionComplete().setValue(value.getIsComplete().booleanValue());
		this.form.txtNotes().setValue(value.getNotesIsNotNull() ? value.getNotes(): null);
		this.form.cmbCushionType().setValue(value.getCushionTypeIsNotNull() ? value.getCushionType() : null);
		this.form.cmbChairType().setValue(value.getChairTypeIsNotNull() ? value.getChairType() : null);
		this.form.cmbBedType().setValue(value.getBedTypeIsNotNull() ? value.getBedType() : null);
		this.form.cmbMatressType().setValue(value.getMattressTypeIsNotNull() ? value.getMattressType() : null);
		if(value.getCopyIsNotNull())
			this.form.chkCopy().setValue(value.getCopy().booleanValue());
	}
	protected ims.spinalinjuries.vo.NurAssessmentSkinVo populateDataFromScreen(ims.spinalinjuries.vo.NurAssessmentSkinVo value)
	{
		if(value == null)
			value = new ims.spinalinjuries.vo.NurAssessmentSkinVo();

		value.setTurnsPerformedBy(this.form.cmbTurnsPreformedBy().getValue());
		value.setTurnType(this.form.cmbTypeOfTurn().getValue());
		value.setIsComplete(new Boolean(this.form.chkSectionComplete().getValue()));
		value.setNotes(this.form.txtNotes().getValue());
		value.setCushionType(this.form.cmbCushionType().getValue());
		value.setChairType(this.form.cmbChairType().getValue());
		value.setBedType(this.form.cmbBedType().getValue());
		value.setMattressType(this.form.cmbMatressType().getValue());
		value.setCopy(new Boolean(this.form.chkCopy().getValue()));

		return value;
	}
	protected ims.spinalinjuries.vo.NurAssessmentSkinVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.spinalinjuries.vo.NurAssessmentSkinVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.spinalinjuries.domain.NurAssessmentSkin domain;
}
