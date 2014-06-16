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
// This code was generated by Calin Perebiceanu using IMS Development Environment (version 1.71 build 3740.24416)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.acutepainreferral;

import ims.clinical.forms.acutepainreferral.GenForm.lyrPainLayer.tabPageACutePainRefDetContainer.GroupPCAEpiduralEnumeration;
import ims.core.vo.PatientIdCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.lookups.PatIdType;
import ims.framework.Control;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
		
	}
	private void populateDemoData()
	{
		
		DynamicGridColumn columnDescription = form.lyrPain().tabPagePainAssessment().dyngrdPain().getColumns().newColumn("Pain Nurse Check",new Integer(1));
		columnDescription.setWidth(350);
		DynamicGridColumn columnDate1 = form.lyrPain().tabPagePainAssessment().dyngrdPain().getColumns().newColumn("20/02/2010",new Integer(2));
		columnDate1.setWidth(80);
		DynamicGridColumn columnDate2 = form.lyrPain().tabPagePainAssessment().dyngrdPain().getColumns().newColumn("17/03/2010",new Integer(3));
		columnDate2.setWidth(80);
		DynamicGridColumn columnDate3 = form.lyrPain().tabPagePainAssessment().dyngrdPain().getColumns().newColumn("30/03/2010",new Integer(4));
		columnDate3.setWidth(80);
		//DynamicGridColumn columnDate4 = form.lyrPain().tabPagePainAssessment().dyngrdPain().getColumns().newColumn("Datix Report",new Integer(4));
		//columnDate3.setWidth(80);
		
		DynamicGridRow newRow = form.lyrPain().tabPagePainAssessment().dyngrdPain().getRows().newRow();
		newRow.setSelectable(false);
		newRow.setExpanded(true);
		DynamicGridCell newCell = newRow.getCells().newCell(columnDescription,DynamicCellType.STRING);
		newCell.setValue("Problems");
		DynamicGridRow newChild = newRow.getRows().newRow();
		newChild.setSelectable(false);
		newCell = newChild.getCells().newCell(columnDescription, DynamicCellType.STRING);
		newCell.setValue("Nausea/Vomiting");
		newCell.setTooltip("Nausea comment 1");
		newCell = newChild.getCells().newCell(columnDate1,DynamicCellType.BOOL);
		newCell.setValue(true);
		newCell.setTooltip("Nausea comment 1");
		newCell = newChild.getCells().newCell(columnDate2,DynamicCellType.BOOL);
		newCell = newChild.getCells().newCell(columnDate3,DynamicCellType.BOOL);
		
		newChild = newRow.getRows().newRow();
		newChild.setSelectable(false);
		newCell = newChild.getCells().newCell(columnDescription, DynamicCellType.STRING);
		newCell.setValue("Hypotension");
		newCell = newChild.getCells().newCell(columnDate1,DynamicCellType.BOOL);
		
		newCell = newChild.getCells().newCell(columnDate2,DynamicCellType.BOOL);
		newCell.setValue(true);
		newCell = newChild.getCells().newCell(columnDate3,DynamicCellType.BOOL);
		newCell.setValue(true);
		
	
		newRow = form.lyrPain().tabPagePainAssessment().dyngrdPain().getRows().newRow();
		newRow.setSelectable(false);
		newCell = newRow.getCells().newCell(columnDescription,DynamicCellType.STRING);
		newCell.setValue("Interventions");
		
		newChild = newRow.getRows().newRow();
		newChild.setSelectable(false);
		newCell = newChild.getCells().newCell(columnDescription, DynamicCellType.STRING);
		newCell.setValue("Antiemetic");
		newCell = newChild.getCells().newCell(columnDate1,DynamicCellType.BOOL);
		newCell.setValue(true);
		newCell = newChild.getCells().newCell(columnDate2,DynamicCellType.BOOL);
		newCell.setValue(true);
		newCell = newChild.getCells().newCell(columnDate3,DynamicCellType.BOOL);
		
		
		/*newRow = form.lyrPain().tabPagePainAssessment().dyngrdPain().getRows().newRow();
		newRow.setSelectable(false);
		newCell = newRow.getCells().newCell(columnDescription,DynamicCellType.STRING);
		newCell.setValue("Pain Nurse Checks");
		
		newChild = newRow.getRows().newRow();
		newChild.setSelectable(false);
		newCell = newChild.getCells().newCell(columnDescription, DynamicCellType.STRING);
		newCell.setValue("Datix Report");
		newCell = newChild.getCells().newCell(columnDate1,DynamicCellType.BOOL);
		newCell.setValue(true);
		newCell = newChild.getCells().newCell(columnDate2,DynamicCellType.BOOL);
		newCell.setValue(true);
		newCell = newChild.getCells().newCell(columnDate3,DynamicCellType.BOOL);*/
		
		
		
		
		form.lyrPain().tabPageACutePainRefDet().chklistPcaMorphine().newRow("1", "Pca Morphine 1");
		form.lyrPain().tabPageACutePainRefDet().chklistPcaMorphine().newRow("2", "Pca Morphine 2");
		form.lyrPain().tabPageACutePainRefDet().chklistPcaMorphine().newRow("3", "Pca Morphine 3");
		
		
		
		form.lyrPain().tabPagePainAssessment().cmbSelected().newRow("20/02/2010", "20/02/2010");
		form.lyrPain().tabPagePainAssessment().cmbSelected().newRow("17/03/2010", "17/03/2010");
		form.lyrPain().tabPagePainAssessment().cmbSelected().newRow("30/03/2010", "30/03/2010");
		
		
	}
	protected void initialize()
	{
		form.lyrPain().tabPageACutePainRefDet().setHeaderVisible(true);
		form.lyrPain().tabPagePainAssessment().setHeaderVisible(true);
		form.lyrPain().tabPageACutePainRefDet().setHeaderEnabled(true);
		form.lyrPain().tabPagePainAssessment().setHeaderEnabled(true);
		form.lyrPain().tabPageACutePainRefDet().GroupPCAEpidural().setValue(GroupPCAEpiduralEnumeration.rdoEpidural);	
		form.lyrPain().tabPageACutePainRefDet().ccAuthoring().initializeComponent();
		
	}
	
	protected void open()
	{
		populateDemoData();
		PatientShort patientShort = form.getGlobalContext().Core.getPatientShort();
		form.lyrPain().tabPageACutePainRefDet().txtName().setValue(patientShort.getName().toString());
		form.lyrPain().tabPageACutePainRefDet().txtAddress().setValue(patientShort.getAddressIsNotNull() ? patientShort.getAddress().toDisplayString(): null);
		form.lyrPain().tabPageACutePainRefDet().txtDOB().setValue(patientShort.getDobIsNotNull() ? patientShort.getDob().toString() : null);	
		form.lyrPain().tabPageACutePainRefDet().txtWard().setValue(patientShort.getWardIsNotNull() ? patientShort.getWard().getName() : null);
		PatientIdCollection identifiers = patientShort.getIdentifiers();
		
		for (int i = 0 ; identifiers!= null && i<identifiers.size() ; i++)
		{
			if (PatIdType.NHSN.equals(identifiers.get(i).getType()))
					{
						form.lyrPain().tabPageACutePainRefDet().txtNhs().setValue(identifiers.get(i).getValue());
					}
			else
				if (PatIdType.CHARTNUM.equals(identifiers.get(i).getType()))
				{
					form.lyrPain().tabPageACutePainRefDet().txtCr().setValue(identifiers.get(i).getValue());
				}
		}
		form.setMode(FormMode.VIEW);
	}
	
	@Override
	protected void onRadioButtonGroupPCAEpiduralValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{	
		updatePcaEpiduralSpinalControlState();
	}
	private void updateControlState()
	{
		boolean isEditMode = FormMode.EDIT.equals(form.getMode());
		form.getContextMenus().Clinical.getPainTeamAssessmentAddItem().setVisible(isEditMode);
		updatePcaEpiduralSpinalControlState();
		form.lyrPain().tabPageACutePainRefDet().chk1().setEnabled(isEditMode);
	}
	
	private void updatePcaEpiduralSpinalControlState()
	{
		
		boolean isEpiduralSelected = form.lyrPain().tabPageACutePainRefDet().GroupPCAEpidural().getValue().equals(GroupPCAEpiduralEnumeration.rdoEpidural);
		boolean isEpiSpinalSelected = form.lyrPain().tabPageACutePainRefDet().GroupPCAEpidural().getValue().equals(GroupPCAEpiduralEnumeration.rdoEpiSpinal);
		boolean isPCASelected = form.lyrPain().tabPageACutePainRefDet().GroupPCAEpidural().getValue().equals(GroupPCAEpiduralEnumeration.rdoPCA);
		boolean isSpinalSelected = form.lyrPain().tabPageACutePainRefDet().GroupPCAEpidural().getValue().equals(GroupPCAEpiduralEnumeration.rdoSpinal);
		boolean editMode = FormMode.EDIT.equals(form.getMode());
		
		// epidural
		
		form.lyrPain().tabPageACutePainRefDet().txtLevelInserted().setEnabled((isEpiduralSelected ||isEpiSpinalSelected ) && editMode);

		form.lyrPain().tabPageACutePainRefDet().intCathInSpace().setEnabled((isEpiduralSelected ||isEpiSpinalSelected ) && editMode);

		form.lyrPain().tabPageACutePainRefDet().intCathToSkin().setEnabled((isEpiduralSelected ||isEpiSpinalSelected ) && editMode);

		form.lyrPain().tabPageACutePainRefDet().cmbMixType().setEnabled((isEpiduralSelected ||isEpiSpinalSelected ) && editMode);
		
		//spinal
		
		form.lyrPain().tabPageACutePainRefDet().cmbSpinalMix().setEnabled((isSpinalSelected || isEpiSpinalSelected) && editMode);
		
		//PCA
		form.lyrPain().tabPageACutePainRefDet().chklistPcaMorphine().setEnabled(isPCASelected && editMode);
		
		form.lyrPain().tabPageACutePainRefDet().cmbPcaOtherOpiate().setEnabled(isPCASelected && editMode);

		form.lyrPain().tabPageACutePainRefDet().txtRegionalBlock().setEnabled(isPCASelected && editMode);

		form.lyrPain().tabPageACutePainRefDet().txtPainBuster().setEnabled(isPCASelected && editMode);
		
	}
	
	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
	
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
	}
	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.ClinicalNamespace.PainTeamAssessment.Add:
				engine.open(form.getForms().Clinical.PainTeamDialog);
				break;

			default:
				break;
		}
		
	}
	@Override
	protected void onFormModeChanged()
	{
		updateControlState();
		
	}
}
