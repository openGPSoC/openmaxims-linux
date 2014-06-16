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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.62 build 3023.13950)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.assessment.forms.screenprofileconfigurationnew;

import ims.assessment.forms.screenprofileconfigurationnew.GenForm.grdUserDefinedFormRow;
import ims.assessment.forms.userdefinedformnew.GenForm;
import ims.assessment.vo.GraphicAssessmentShortVo;
import ims.assessment.vo.ScreeningProfileComponentVo;
import ims.assessment.vo.ScreeningProfileComponentVoCollection;
import ims.assessment.vo.ScreeningProfileVo;
import ims.assessment.vo.UserAssessmentShortVo;
import ims.assessment.vo.UserDefinedObjectComponentVo;
import ims.assessment.vo.UserDefinedObjectComponentVoCollection;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.lookups.LookupHelper;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.PreActiveActiveInactiveStatusCollection;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.utils.textile.Textile;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private final static String	CR	 = "\n";
	private final static String NBSP = "&nbsp;"; 
	

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.getContextMenus().getGenericGridAddItem().setText("Add Assessment");
		form.getContextMenus().getGenericGridUpdateItem().setText("Update Assessment");
		form.getContextMenus().getGenericGridRemoveItem().setText("Remove Assessment");
		
		open();
	}
	private void open()
	{
		if(form.getGlobalContext().Assessment.getCurrentProfile() == null)
		{
			form.setMode(FormMode.EDIT);
			form.cmbType().setValue(form.getGlobalContext().Assessment.getContextType());
		}
		else
		{
			displayProfile(form.getGlobalContext().Assessment.getCurrentProfile());
		}
		
		enableContextMenu();
		form.setMode(getFormMode());
	}
	private void displayProfile(ScreeningProfileVo currentProfile)
	{
		form.grdUserDefinedForm().getRows().clear();
		
		if(currentProfile == null)
			return;
		
		form.txtName().setValue(currentProfile.getProfileName());
		form.cmbStatus().setValue(currentProfile.getActiveStatus());
		form.cmbType().setValue(currentProfile.getContextType());
		
		for (int i = 0; i < currentProfile.getProfileComponents().size(); i++)
		{
			ScreeningProfileComponentVo item = currentProfile.getProfileComponents().get(i);
			
			grdUserDefinedFormRow row = form.grdUserDefinedForm().getRows().newRow();
			
			row.setcolClassification(item.getGraphicIsNotNull() ? "Graphic assessment" : "Assessment");
			if(item.getUserAssessmentIsNotNull())
			{
				row.setcolName(item.getUserAssessment().getName());
				row.setTooltip(getUserAssessmentTooltip(item.getUserAssessment()));
			}
			else
			{
				row.setcolName(item.getGraphic().getName());
				row.setTooltip(getGraphicTooltip(item.getGraphic()));
			}
			row.setColActive(item.getActiveStatus());
			
			row.setValue(item);
		}
	}
	private FormMode getFormMode()
	{
		FormMode formMode = form.getGlobalContext().Core.getUserDefinedFormMode();
		if(formMode != null)
			return formMode;
		return FormMode.EDIT;
	}
	
	@Override
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (formName.equals(form.getForms().Assessment.UserDefinedFormSearch) && result.equals(DialogResult.OK))
		{
			UserDefinedObjectComponentVoCollection voColl = form.getGlobalContext().Core.getUserDefinedObjectComponents();
			populateUserDefinedGrid(voColl);
		}
		
	}
	private void populateUserDefinedGrid(UserDefinedObjectComponentVoCollection voColl)
	{
		if (voColl == null)
			return;

		voColl.sort();

		for (int i = 0; i < voColl.size(); i++)
		{
			UserDefinedObjectComponentVo voUserDefinedObjComp = voColl.get(i);
			grdUserDefinedFormRow row = getGridRow(voUserDefinedObjComp);

			row.setColActive(voUserDefinedObjComp.getActiveStatus());
			if (voUserDefinedObjComp.getUserAssessmentIsNotNull())
			{
				row.setcolName(voUserDefinedObjComp.getUserAssessment().getName());
				row.setTooltip(getUserAssessmentTooltip(voUserDefinedObjComp.getUserAssessment()));
				row.setcolClassification(voUserDefinedObjComp.getUserAssessment().getAssessmentTypeIsNotNull() ? voUserDefinedObjComp.getUserAssessment().getAssessmentType().toString() : "");
			}
			if (voUserDefinedObjComp.getGraphicIsNotNull())
			{
				row.setcolName(voUserDefinedObjComp.getGraphic().getName());
				row.setTooltip(getGraphicTooltip(voUserDefinedObjComp.getGraphic()));
				row.setcolClassification(voUserDefinedObjComp.getGraphic().getAssessmentTypeIsNotNull() ? voUserDefinedObjComp.getGraphic().getAssessmentType().toString() : "");
			}
			
			if(row.getValue() == null)
			{
				ScreeningProfileComponentVo profileComponent = new ScreeningProfileComponentVo();
				
				profileComponent.setActiveStatus(voUserDefinedObjComp.getActiveStatus());
				profileComponent.setGraphic(voUserDefinedObjComp.getGraphic());
				profileComponent.setUserAssessment(voUserDefinedObjComp.getUserAssessment());
				
				row.setValue(profileComponent);
			}
		}
	}

	private grdUserDefinedFormRow getGridRow(UserDefinedObjectComponentVo voUDOC)
	{
		for (int i = 0; i < form.grdUserDefinedForm().getRows().size(); i++)
		{
			ScreeningProfileComponentVo profileComponent = form.grdUserDefinedForm().getRows().get(i).getValue();
			
			if (profileComponent != null)
			{
				grdUserDefinedFormRow row = form.grdUserDefinedForm().getRows().get(i);
				// User Assessment
				if (voUDOC.getUserAssessmentIsNotNull() && profileComponent.getUserAssessmentIsNotNull())
				{
					if (profileComponent.getUserAssessment().equals(voUDOC.getUserAssessment()))
						return row;
				}

				// Graphic
				if (voUDOC.getGraphicIsNotNull() && profileComponent.getGraphicIsNotNull())
				{
					if (profileComponent.getGraphic().equals(voUDOC.getGraphic()))
						return row;
				}
			}
		}

		return form.grdUserDefinedForm().getRows().newRow();
	}
	
	@Override
	protected void onFormModeChanged()
	{
		boolean isStatusActive = isStatusActiveOrInactive();
		if(form.getMode().equals(FormMode.EDIT))
		{
			if(isStatusActive)
			{
				enableControls(false);
				removePreactiveOrActiveLookup(form.cmbStatus().getValue());
			}
			else
			{
				enableControls(true);
			}
		}
		
		enableContextMenu();
	}
	private void removePreactiveOrActiveLookup(PreActiveActiveInactiveStatus status)
	{
		form.cmbStatus().clear();
		PreActiveActiveInactiveStatusCollection  lookupColl = LookupHelper.getPreActiveActiveInactiveStatus(domain.getLookupService());
		for(int i=0; lookupColl  != null && i<lookupColl.size(); i++)
		{
			if(isStatusActive() && lookupColl.get(i).equals(PreActiveActiveInactiveStatus.PREACTIVE))
				continue;
			if(isStatusInactive() && (lookupColl.get(i).equals(PreActiveActiveInactiveStatus.PREACTIVE) || lookupColl.get(i).equals(PreActiveActiveInactiveStatus.ACTIVE)))
				continue;

			form.cmbStatus().newRow(lookupColl.get(i), lookupColl.get(i).toString(), lookupColl.get(i).getImage(), lookupColl.get(i).getColor());
		}
		form.cmbStatus().setValue(status);
	}	
	private boolean isStatusInactive()
	{
		ScreeningProfileVo currentProfile = form.getGlobalContext().Assessment.getCurrentProfile();
		if(currentProfile != null && currentProfile.getActiveStatusIsNotNull() && currentProfile.getActiveStatus().equals(PreActiveActiveInactiveStatus.INACTIVE))
			return true;
		
		return false;
	}

	private boolean isStatusActive()
	{
		ScreeningProfileVo currentProfile = form.getGlobalContext().Assessment.getCurrentProfile();
		if(currentProfile != null && currentProfile.getActiveStatusIsNotNull() && currentProfile.getActiveStatus().equals(PreActiveActiveInactiveStatus.ACTIVE))
			return true;
		
		return false;
	}	
	private void enableControls(boolean value)
	{
		form.txtName().setEnabled(value);
		form.grdUserDefinedForm().setReadOnly(!value);
	}
	@Override
	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
	@Override
	protected void onGrdUserDefinedFormSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		enableContextMenu();
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.getGlobalContext().Assessment.getCurrentProfile() == null)
		{
			engine.open(form.getForms().Assessment.ScreeningProfileConfiguration);
		}
		else
		{
			form.setMode(FormMode.VIEW);
		}	
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (doSave() == false)
			return;
		
		open();
		form.grdUserDefinedForm().setValue(null);
		form.setMode(FormMode.VIEW);
	}
	@Override
	protected void onLnkReturnToListClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Assessment.setContextType(form.getGlobalContext().Assessment.getContextType());
		engine.open(form.getForms().Assessment.ScreeningProfileConfiguration);
	}
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add :
				addObjectComponent();
			break;

			case GenForm.ContextMenus.GenericGrid.Remove :
				removeObjectComponent();
			break;

			case GenForm.ContextMenus.GenericGrid.MoveUp :
				moveUpObjectComponent();
			break;

			case GenForm.ContextMenus.GenericGrid.MoveDown :
				moveDownObjectComponent();
			break;
		}		
	}
	private void moveDownObjectComponent()
	{
		form.grdUserDefinedForm().moveDown();
		enableContextMenu();
	}
	private void moveUpObjectComponent()
	{
		form.grdUserDefinedForm().moveUp();
		enableContextMenu();
	}
	private void removeObjectComponent()
	{
		form.grdUserDefinedForm().removeSelectedRow();
		enableContextMenu();
	}
	private void enableContextMenu()
	{
		boolean isRowSelected = form.grdUserDefinedForm().getSelectedRowIndex() >= 0;
		boolean editMode 	  = form.getMode().equals(FormMode.EDIT) && !isStatusActiveOrInactive();
		form.getContextMenus().getGenericGridAddItem().setVisible(editMode);
		form.getContextMenus().getGenericGridRemoveItem().setVisible(isRowSelected && editMode);
		form.getContextMenus().getGenericGridMoveUpItem().setVisible(form.grdUserDefinedForm().canMoveCurrentUp() && editMode);
		form.getContextMenus().getGenericGridMoveDownItem().setVisible(form.grdUserDefinedForm().canMoveCurrentDown() && editMode);
	}
	private void addObjectComponent()
	{
		engine.open(form.getForms().Assessment.UserDefinedFormSearch);
	}
	private boolean isStatusActiveOrInactive()
	{
		ScreeningProfileVo currentProfile = form.getGlobalContext().Assessment.getCurrentProfile();
		
		if(currentProfile != null && currentProfile.getActiveStatusIsNotNull() && 
		   (currentProfile.getActiveStatus().equals(PreActiveActiveInactiveStatus.ACTIVE) || currentProfile.getActiveStatus().equals(PreActiveActiveInactiveStatus.INACTIVE)))
			return true;
		
		return false;
	}
	private String getUserAssessmentTooltip(UserAssessmentShortVo voUserAssessments)
	{
		StringBuffer tooltip = new StringBuffer();
		if (voUserAssessments.getAssessmentTypeIsNotNull())
		{

			tooltip.append("*" + "Assessment Type: " + "*");
			tooltip.append(voUserAssessments.getAssessmentType().toString());
			tooltip.append(CR);
		}

		if (voUserAssessments.getScoringMethodIsNotNull())
		{

			tooltip.append("*" + "Scoring Method: " + "*" + NBSP + NBSP + NBSP + NBSP);
			tooltip.append(voUserAssessments.getScoringMethod().toString());
			tooltip.append(CR);
		}
		
		if (voUserAssessments.getActiveStatusIsNotNull())
		{

			tooltip.append("*" + "Status: " + "*" + NBSP + NBSP + NBSP + NBSP + NBSP + NBSP);
			tooltip.append(voUserAssessments.getActiveStatus().toString());
			tooltip.append(CR);
		}

		boolean isMultipleGrp = voUserAssessments.getIsMultipleGroupIsNotNull() ? voUserAssessments.getIsMultipleGroup().booleanValue() : false;
		boolean isFlatView = voUserAssessments.getIsFlatViewIsNotNull() ? voUserAssessments.getIsFlatView().booleanValue() : false;

		if (isMultipleGrp || isFlatView)
		{
			tooltip.append("*" + "Type and Display: " + "*" + NBSP + NBSP);

			if (!isMultipleGrp && isFlatView)
				tooltip.append("Single Group");
			if (isMultipleGrp && !isFlatView)
				tooltip.append("Multiple Group, Hierarchical View");
			if (isMultipleGrp && isFlatView)
				tooltip.append("Multiple Groups, Flat View");

			tooltip.append(CR);
		}

		return new Textile().process(tooltip.toString());
	}

	private String getGraphicTooltip(GraphicAssessmentShortVo voGraphicAssessment)
	{
		StringBuffer tooltip = new StringBuffer();
		if(voGraphicAssessment.getActiveStatusIsNotNull())
		{
			tooltip.append("*Status: *");
			tooltip.append(voGraphicAssessment.getActiveStatus().toString());
			tooltip.append(CR);
		}
	
		return new Textile().process(tooltip.toString());
	}
	private boolean doSave()
	{
		ScreeningProfileVo currentProfile = form.getGlobalContext().Assessment.getCurrentProfile();
		
		if(currentProfile == null)
			currentProfile = new ScreeningProfileVo();
		
		populateDataFromScreen(currentProfile);

		String[] errors = currentProfile.validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return false;
		}

		try
		{
			currentProfile = domain.saveProfile(currentProfile);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			form.getGlobalContext().Assessment.setCurrentProfile(domain.getProfile((currentProfile)));
			open();
			form.setMode(FormMode.VIEW);
			return false;
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		
		form.getGlobalContext().Assessment.setCurrentProfile(currentProfile);
		return true;
	}
	private void populateDataFromScreen(ScreeningProfileVo currentProfile)
	{
		ScreeningProfileComponentVoCollection voColl = form.grdUserDefinedForm().getRows().size() > 0 ? new ScreeningProfileComponentVoCollection() : null;
		for (int i = 0; i < form.grdUserDefinedForm().getRows().size(); i++)
		{
			ScreeningProfileComponentVo item = form.grdUserDefinedForm().getRows().get(i).getValue();
			item.setActiveStatus(form.grdUserDefinedForm().getRows().get(i).getColActive());
			voColl.add(item);
		}

		currentProfile.setProfileComponents(voColl);
		currentProfile.setActiveStatus(form.cmbStatus().getValue());
		currentProfile.setProfileName(form.txtName().getValue());
		currentProfile.setContextType(form.cmbType().getValue());
	}
	
}
