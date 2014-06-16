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

package ims.spinalinjuries.forms.nurassessmentbreathing;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbTracheostomyAccessoriesLookup();
	abstract protected void defaultcmbTracheostomyAccessoriesLookupValue();
	abstract protected void bindcmbTracheostomyTypeLookup();
	abstract protected void defaultcmbTracheostomyTypeLookupValue();
	abstract protected void bindcmbVentilationModeLookup();
	abstract protected void defaultcmbVentilationModeLookupValue();
	abstract protected void bindcmbVentilatorTypeLookup();
	abstract protected void defaultcmbVentilatorTypeLookupValue();
	abstract protected void bindansRequiresTrachyLookup();
	abstract protected void defaultansRequiresTrachyLookupValue();
	abstract protected void bindansPatientVentilatedLookup();
	abstract protected void defaultansPatientVentilatedLookupValue();
	abstract protected void bindansBreathsSpontaneouslyLookup();
	abstract protected void defaultansBreathsSpontaneouslyLookupValue();
	abstract protected void bindansPatientIntubatedLookup();
	abstract protected void defaultansPatientIntubatedLookupValue();
	abstract protected void bindcmbDysAcuteChronicLookup();
	abstract protected void defaultcmbDysAcuteChronicLookupValue();
	abstract protected void bindansDifficultyBreathingLookup();
	abstract protected void defaultansDifficultyBreathingLookupValue();
	abstract protected void bindcmbSmokingStatusLookup();
	abstract protected void defaultcmbSmokingStatusLookupValue();
	abstract protected void bindgrdSmokingColStatusLookup();
	abstract protected void bindgrdSmokingColWhatLookup();
	abstract protected void bindgrdMedicationColRouteLookup();
	abstract protected void bindgrdMedicationColFrequencyLookup();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTracheostomyAccessoriesValueSet(Object value);
	abstract protected void oncmbTracheostomyTypeValueSet(Object value);
	abstract protected void oncmbVentilationModeValueSet(Object value);
	abstract protected void oncmbVentilatorTypeValueSet(Object value);
	abstract protected void onansRequiresTrachyValueSet(Object value);
	abstract protected void onansPatientVentilatedValueSet(Object value);
	abstract protected void onansBreathsSpontaneouslyValueSet(Object value);
	abstract protected void onansPatientIntubatedValueSet(Object value);
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbDysAcuteChronicValueSet(Object value);
	abstract protected void onansDifficultyBreathingValueSet(Object value);
	abstract protected void onAnsDifficultyBreathingValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbSmokingStatusValueSet(Object value);
	abstract protected void onCmbSmokingStatusValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdSmokingSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdSmokingGridComboBoxSelectionChanged(int column, GenForm.ctnBreathingContainer.grdSmokingRow row, Object value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdMedicationSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdMedicationGridQueryComboBoxTextSubmited(int column, GenForm.ctnBreathingContainer.grdMedicationRow row, String text) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkInfoClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkCopyValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormModeChangedEvent(new FormModeChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle()
			{
				onFormModeChanged();
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen();
			}
		});
		this.form.ctnBreathing().cmbTracheostomyAccessories().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTracheostomyAccessoriesValueSet(value);
			}
		});
		this.form.ctnBreathing().cmbTracheostomyType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTracheostomyTypeValueSet(value);
			}
		});
		this.form.ctnBreathing().cmbVentilationMode().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbVentilationModeValueSet(value);
			}
		});
		this.form.ctnBreathing().cmbVentilatorType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbVentilatorTypeValueSet(value);
			}
		});
		this.form.ctnBreathing().ansRequiresTrachy().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onansRequiresTrachyValueSet(value);
			}
		});
		this.form.ctnBreathing().ansPatientVentilated().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onansPatientVentilatedValueSet(value);
			}
		});
		this.form.ctnBreathing().ansBreathsSpontaneously().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onansBreathsSpontaneouslyValueSet(value);
			}
		});
		this.form.ctnBreathing().ansPatientIntubated().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onansPatientIntubatedValueSet(value);
			}
		});
		this.form.ctnBreathing().btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClick();
			}
		});
		this.form.ctnBreathing().btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveClick();
			}
		});
		this.form.ctnBreathing().cmbDysAcuteChronic().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDysAcuteChronicValueSet(value);
			}
		});
		this.form.ctnBreathing().ansDifficultyBreathing().setValueSetEvent(new AnswerBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onansDifficultyBreathingValueSet(value);
			}
		});
		this.form.ctnBreathing().ansDifficultyBreathing().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onAnsDifficultyBreathingValueChanged();
			}
		});
		this.form.ctnBreathing().cmbSmokingStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSmokingStatusValueSet(value);
			}
		});
		this.form.ctnBreathing().cmbSmokingStatus().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbSmokingStatusValueChanged();
			}
		});
		this.form.ctnBreathing().grdSmoking().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdSmokingSelectionChanged();
			}
		});
		this.form.ctnBreathing().grdSmoking().setGridComboBoxSelectionChangedEvent(new GridComboBoxSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, Object value) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdSmokingGridComboBoxSelectionChanged(column, new GenForm.ctnBreathingContainer.grdSmokingRow(row), value);
			}
		});
		this.form.ctnBreathing().grdMedication().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdMedicationSelectionChanged();
			}
		});
		this.form.ctnBreathing().grdMedication().setGridQueryComboBoxTextSubmitedEvent(new GridQueryComboBoxTextSubmited()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, String text) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdMedicationGridQueryComboBoxTextSubmited(column, new GenForm.ctnBreathingContainer.grdMedicationRow(row), text);
			}
		});
		this.form.lnkInfo().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkInfoClick();
			}
		});
		this.form.chkCopy().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkCopyValueChanged();
			}
		});
		this.form.getContextMenus().getSmokingGridADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SmokingGrid.ADD, sender);
			}
		});
		this.form.getContextMenus().getSmokingGridREMOVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.SmokingGrid.REMOVE, sender);
			}
		});
		this.form.getContextMenus().getMedicationGridADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.MedicationGrid.ADD, sender);
			}
		});
		this.form.getContextMenus().getMedicationGridREMOVEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.MedicationGrid.REMOVE, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbTracheostomyAccessoriesLookup();
		bindcmbTracheostomyTypeLookup();
		bindcmbVentilationModeLookup();
		bindcmbVentilatorTypeLookup();
		bindansRequiresTrachyLookup();
		bindansPatientVentilatedLookup();
		bindansBreathsSpontaneouslyLookup();
		bindansPatientIntubatedLookup();
		bindcmbDysAcuteChronicLookup();
		bindansDifficultyBreathingLookup();
		bindcmbSmokingStatusLookup();
		bindgrdSmokingColStatusLookup();
		bindgrdSmokingColWhatLookup();
		bindgrdMedicationColRouteLookup();
		bindgrdMedicationColFrequencyLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbTracheostomyAccessoriesLookup();
		bindcmbTracheostomyTypeLookup();
		bindcmbVentilationModeLookup();
		bindcmbVentilatorTypeLookup();
		bindansRequiresTrachyLookup();
		bindansPatientVentilatedLookup();
		bindansBreathsSpontaneouslyLookup();
		bindansPatientIntubatedLookup();
		bindcmbDysAcuteChronicLookup();
		bindansDifficultyBreathingLookup();
		bindcmbSmokingStatusLookup();
		bindgrdSmokingColStatusLookup();
		bindgrdSmokingColWhatLookup();
		bindgrdMedicationColRouteLookup();
		bindgrdMedicationColFrequencyLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbTracheostomyAccessoriesLookupValue();
		defaultcmbTracheostomyTypeLookupValue();
		defaultcmbVentilationModeLookupValue();
		defaultcmbVentilatorTypeLookupValue();
		defaultansRequiresTrachyLookupValue();
		defaultansPatientVentilatedLookupValue();
		defaultansBreathsSpontaneouslyLookupValue();
		defaultansPatientIntubatedLookupValue();
		defaultcmbDysAcuteChronicLookupValue();
		defaultansDifficultyBreathingLookupValue();
		defaultcmbSmokingStatusLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
