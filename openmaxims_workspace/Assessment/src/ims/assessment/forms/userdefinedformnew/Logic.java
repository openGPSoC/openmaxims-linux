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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.45 build 2389.16953)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.assessment.forms.userdefinedformnew;
import ims.configuration.gen.ConfigFlag;
import ims.assessment.forms.userdefinedformnew.GenForm.grdUserDefinedFormRow;
import ims.assessment.vo.GraphicAssessmentVo;
import ims.assessment.vo.UserAssessmentShortVo;
import ims.assessment.vo.UserDefinedObjectComponentVo;
import ims.assessment.vo.UserDefinedObjectComponentVoCollection;
import ims.assessment.vo.UserDefinedObjectShortVo;
import ims.assessment.vo.UserDefinedObjectVo;
import ims.core.vo.lookups.LookupHelper;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.PreActiveActiveInactiveStatusCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.utils.textile.Textile;

public class Logic extends BaseLogic
{
	private final static String	CR	 = "\n";
	private final static String NBSP = "&nbsp;"; 

	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		open();
	}

	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (formName.equals(form.getForms().Assessment.UserDefinedFormSearch) && result.equals(DialogResult.OK))
		{
			UserDefinedObjectComponentVoCollection voColl = form.getGlobalContext().Core.getUserDefinedObjectComponents();
			populateUserDefinedGrid(voColl);
		}
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(isNewRecord())
		{
			engine.open(form.getForms().Assessment.UserDefinedForm);
		}
		else
		{
			open();
			form.setMode(FormMode.VIEW);
		}
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		doSave();
	}

	protected void onBtnUpdateClick() throws PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}

	protected void onLnkReturnToListClick() throws PresentationLogicException
	{
		engine.open(form.getForms().Assessment.UserDefinedForm);
	}

	protected void onGrdUserDefinedFormSelectionChanged() throws PresentationLogicException
	{
		enableContextMenu();
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
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
	
	private boolean isStatusActiveOrInactive()
	{
		UserDefinedObjectVo voUserDefObj = form.getGlobalContext().Core.getUserDefinedObject();
		if(voUserDefObj != null && voUserDefObj.getActiveStatusIsNotNull() && 
		   (voUserDefObj.getActiveStatus().equals(PreActiveActiveInactiveStatus.ACTIVE) || voUserDefObj.getActiveStatus().equals(PreActiveActiveInactiveStatus.INACTIVE)))
			return true;
		
		return false;
	}

	private void enableControls(boolean value)
	{
		form.txtName().setEnabled(value);
		form.cmbType().setEnabled(value);
		form.grdUserDefinedForm().setReadOnly(!value);
	}

	// -------- Private Methods ------------
	private void open()
	{
		setContextMenu();
		clearScreen();
		initialiseScreen();
		enableContextMenu();
		form.getLocalContext().setIsInactive(isStatusInactive());
		populateScreenFromData();
	}

	private void populateScreenFromData()
	{
		UserDefinedObjectVo voUserDefinedObject = form.getGlobalContext().Core.getUserDefinedObject();
		super.populateScreenFromData(voUserDefinedObject);
		populateUserDefinedGrid(voUserDefinedObject.getComponents());
	}

	private void populateUserDefinedGrid(UserDefinedObjectComponentVoCollection voColl)
	{
		if (voColl == null)
			return;

		voColl.sort();

		for (int i = 0; i < voColl.size(); i++)
		{
			UserDefinedObjectComponentVo voUserDefinedObjComp = voColl.get(i);
			GenForm.grdUserDefinedFormRow row = getGridRow(voUserDefinedObjComp);

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
			row.setValue(voUserDefinedObjComp);
		}
	}

	private grdUserDefinedFormRow getGridRow(UserDefinedObjectComponentVo voUDOC)
	{
		for (int i = 0; i < form.grdUserDefinedForm().getRows().size(); i++)
		{
			UserDefinedObjectComponentVo voUserDefinedObjectComponent = form.grdUserDefinedForm().getRows().get(i).getValue();
			if (voUserDefinedObjectComponent != null)
			{
				grdUserDefinedFormRow row = form.grdUserDefinedForm().getRows().get(i);
				// User Assessment
				if (voUDOC.getUserAssessmentIsNotNull() && voUserDefinedObjectComponent.getUserAssessmentIsNotNull())
				{
					if (voUserDefinedObjectComponent.getUserAssessment().equals(voUDOC.getUserAssessment()))
						return row;
				}

				// Graphic
				if (voUDOC.getGraphicIsNotNull() && voUserDefinedObjectComponent.getGraphicIsNotNull())
				{
					if (voUserDefinedObjectComponent.getGraphic().equals(voUDOC.getGraphic()))
						return row;
				}
			}
		}

		return form.grdUserDefinedForm().getRows().newRow();
	}

	private void doSave()
	{
		if (!validateAndPopulate())
			return;
		
		if (isStatusInactive() && !form.getLocalContext().getIsInactive())
		{
			engine.showMessage("Are you sure you want to inactivate this assessment ?", "Inactive Assessment", MessageButtons.YESNO, MessageIcon.QUESTION);
			return;
		}

		performSave();
	}

	private void performSave()
	{
		if (save())
		{
			open();
			form.grdUserDefinedForm().setValue(null);
			form.setMode(FormMode.VIEW);
		}
	}

	private boolean save()
	{
		UserDefinedObjectVo voUserDefinedObject = form.getGlobalContext().Core.getUserDefinedObject();
		
		try
		{
			voUserDefinedObject = domain.saveUserDefinedObjects(voUserDefinedObject);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			form.getGlobalContext().Core.setUserDefinedObject(domain.getUserDefinedObject(voUserDefinedObject.getID_UserDefinedObject()));
			open();
			form.setMode(FormMode.VIEW);
			return false;
		}
		
		form.getGlobalContext().Core.setUserDefinedObject(voUserDefinedObject);
		form.getGlobalContext().Core.setUserDefinedObjectShort(voUserDefinedObject);
		return true;
	}

	private boolean validateAndPopulate()
	{
		UserDefinedObjectVo voUserDefinedObject = form.getGlobalContext().Core.getUserDefinedObject();
		populateDataFromScreen(voUserDefinedObject);

		String[] errors = voUserDefinedObject.validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return false;
		}
		form.getGlobalContext().Core.setUserDefinedObject(voUserDefinedObject);
		return true;
	}

	protected UserDefinedObjectVo populateDataFromScreen(UserDefinedObjectVo voUserDefinedObject)
	{
		UserDefinedObjectComponentVoCollection voColl = form.grdUserDefinedForm().getRows().size() > 0 ? new UserDefinedObjectComponentVoCollection() : null;
		for (int i = 0; i < form.grdUserDefinedForm().getRows().size(); i++)
		{
			UserDefinedObjectComponentVo voUserDefinedObjectComponent = form.grdUserDefinedForm().getRows().get(i).getValue();
			voUserDefinedObjectComponent.setActiveStatus(form.grdUserDefinedForm().getRows().get(i).getColActive());
			voUserDefinedObjectComponent.setSeqNo(new Integer(i));
			voColl.add(voUserDefinedObjectComponent);
		}

		voUserDefinedObject.setComponents(voColl);
		return super.populateDataFromScreen(voUserDefinedObject);
	}

	private void initialiseScreen()
	{
		UserDefinedObjectShortVo voUserDefinedObjectShort = form.getGlobalContext().Core.getUserDefinedObjectShort();
		UserDefinedObjectVo voUserDefinedObject = new UserDefinedObjectVo(); 
		if(voUserDefinedObjectShort != null)
		{
			if(voUserDefinedObjectShort.getID_UserDefinedObjectIsNotNull())
				voUserDefinedObject = domain.getUserDefinedObject(voUserDefinedObjectShort.getID_UserDefinedObject());
			else
			{
				//Set the default value passed from the Search form.
				voUserDefinedObject.setName(voUserDefinedObjectShort.getName());
			}
		}
		form.getGlobalContext().Core.setUserDefinedObject(voUserDefinedObject);		
		if (voUserDefinedObject == null || voUserDefinedObject.getID_UserDefinedObject() == null)
			form.txtName().setFocus();
		form.setMode(getFormMode());
	}

	private FormMode getFormMode()
	{
		FormMode formMode = form.getGlobalContext().Core.getUserDefinedFormMode();
		if(formMode != null)
			return formMode;
		return FormMode.EDIT;
	}

	private void addObjectComponent()
	{
		engine.open(form.getForms().Assessment.UserDefinedFormSearch);
	}

	private void removeObjectComponent()
	{
		form.grdUserDefinedForm().removeSelectedRow();
		enableContextMenu();
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

	private String getGraphicTooltip(GraphicAssessmentVo voGraphicAssessment)
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

	private void enableContextMenu()
	{
		boolean isRowSelected = form.grdUserDefinedForm().getSelectedRowIndex() >= 0;
		boolean editMode 	  = form.getMode().equals(FormMode.EDIT) && !isStatusActiveOrInactive();
		form.getContextMenus().getGenericGridAddItem().setVisible(editMode);
		form.getContextMenus().getGenericGridRemoveItem().setVisible(isRowSelected && editMode);
		form.getContextMenus().getGenericGridMoveUpItem().setVisible(form.grdUserDefinedForm().canMoveCurrentUp() && editMode);
		form.getContextMenus().getGenericGridMoveDownItem().setVisible(form.grdUserDefinedForm().canMoveCurrentDown() && editMode);
	}

	private void setContextMenu()
	{
		form.getContextMenus().getGenericGridAddItem().setText("Add Component");
		form.getContextMenus().getGenericGridUpdateItem().setText("Update Component");
		form.getContextMenus().getGenericGridRemoveItem().setText("Remove Component");
	}

	protected void clearScreen()
	{
		form.grdUserDefinedForm().getRows().clear();
		super.clearScreen();
	}
	
	private boolean isNewRecord()
	{
		return form.getGlobalContext().Core.getUserDefinedObject() == null || form.getGlobalContext().Core.getUserDefinedObject().getID_UserDefinedObject() == null;  
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
		UserDefinedObjectVo voUserDefObj = form.getGlobalContext().Core.getUserDefinedObject();
		if(voUserDefObj != null && voUserDefObj.getActiveStatusIsNotNull() && voUserDefObj.getActiveStatus().equals(PreActiveActiveInactiveStatus.INACTIVE))
			return true;
		
		return false;
	}

	private boolean isStatusActive()
	{
		UserDefinedObjectVo voUserDefObj = form.getGlobalContext().Core.getUserDefinedObject();
		if(voUserDefObj != null && voUserDefObj.getActiveStatusIsNotNull() && voUserDefObj.getActiveStatus().equals(PreActiveActiveInactiveStatus.ACTIVE))
			return true;
		
		return false;
	}
	// -------- End Private Methods --------

	@Override
	protected void onMessageBoxClosed(int messageBoxId, DialogResult result) throws PresentationLogicException
	{
		if (DialogResult.YES.equals(result))
		{
			performSave();
		}
		
	}
}
