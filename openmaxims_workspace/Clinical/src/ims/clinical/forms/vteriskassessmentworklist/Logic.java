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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.vteriskassessmentworklist;

import ims.clinical.forms.vteriskassessmentworklist.GenForm.grdPatientsRow;
import ims.clinical.vo.VTERiskAssessmentWorklistCriteriaVo;
import ims.clinical.vo.WasVTERiskAssessmentStatusChangedVo;
import ims.clinical.vo.lookups.VTEAsessmentStatus;
import ims.clinical.vo.lookups.VTEAsessmentStatusCollection;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.LocSiteLiteVo;
import ims.core.vo.LocSiteLiteVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.PatientForVTERiskAssessmentVo;
import ims.core.vo.PatientShort;
import ims.core.vo.WardStayVo;
import ims.core.vo.WardStayVoCollection;
import ims.core.vo.enums.MosType;
import ims.core.vo.lookups.PatIdType;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.controls.Timer;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.ILocation;
import ims.framework.utils.DateTime;
import ims.vo.interfaces.IVTERiskAssessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	private static final int DOB_COLUMN = 3;
	private static final int CONSULTANT_COLUMN = 6;
	private static final int ADMISSION_DATE_COLUMN = 8;
	private static final int VTE_STATUS_COLUMN = 9;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}

	private void initialize() 
	{
		populateHospitalCombo();
		
		ILocation currentLocation = engine.getCurrentLocation();
		LocSiteLiteVo currentHospiptal = domain.getCurrentHospital(currentLocation);
		
		form.cmbHospital().setValue(currentHospiptal);
		if(form.cmbHospital().getValue() != null && currentLocation instanceof LocationLiteVo)
		{
			listCurrentWards(form.cmbHospital().getValue(), null, false);
			form.qmbCurrentWard().setValue((LocationLiteVo) currentLocation);
		}
		
		form.ccConsultant().initialize(MosType.MEDIC);
		
		bindVTEAssessmentStatusCombo();
		
		PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue());
		form.cmbIDType().setValue(dispIdType);
		
		form.getLocalContext().setWasTimerOn(false);
		form.getTimers().gettimerRefresh().setInterval(ConfigFlag.UI.VTE_RISK_ASSESSMENT_AUTO_REFRESH_TIME_SECONDS.getValue());
	}

	private void bindVTEAssessmentStatusCombo() 
	{
		form.cmbVTEStatus().clear();
		
		VTEAsessmentStatusCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getVTEAsessmentStatus(this.domain.getLookupService());
		for(int i = 0; i < lookupCollection.size(); i++)
		{
			if(VTEAsessmentStatus.COMPLETED.equals(lookupCollection.get(i)))
				continue;
			
			form.cmbVTEStatus().newRow(lookupCollection.get(i), lookupCollection.get(i).getText(), lookupCollection.get(i).getImage(), lookupCollection.get(i).getTextColor());
		}
	}

	private void open() 
	{
		if(form.getGlobalContext().Clinical.getVTERiskAssessmentWorklistCriteriaIsNotNull())
		{
			populateSearchCriteriaScreenFromData(form.getGlobalContext().Clinical.getVTERiskAssessmentWorklistCriteria());
			
			if(form.getGlobalContext().Clinical.getVTERiskAssessmentWorklistCriteria().getWasTimerOnIsNotNull() && form.getGlobalContext().Clinical.getVTERiskAssessmentWorklistCriteria().getWasTimerOn())
			{
				form.getLocalContext().setWasTimerOn(true);
				toggleTimer(false);
			}
		}
		
		if(search())
		{
			form.getGlobalContext().Clinical.setVTERiskAssessmentWorklistCriteria(populateSearchCriteriaDataFromScreen());
		}
		
		updateControlsState();
	}
	
	private void populateSearchCriteriaScreenFromData(VTERiskAssessmentWorklistCriteriaVo criteria) 
	{
		clearScreen();
		
		if(criteria == null)
			return;
		
		form.cmbHospital().setValue(criteria.getHospital());
		
		if(criteria.getWardIsNotNull())
		{
			form.qmbWard().newRow(criteria.getWard(), criteria.getWard().getName());
		}
		form.qmbWard().setValue(criteria.getWard());
		
		if(criteria.getCurrentWardIsNotNull())
		{
			form.qmbCurrentWard().newRow(criteria.getCurrentWard(), criteria.getCurrentWard().getName());
		}
		form.qmbCurrentWard().setValue(criteria.getCurrentWard());
		
		form.dtimFrom().setValue(criteria.getAdmissionDateFrom());
		form.dtimTo().setValue(criteria.getAdmissionDateTo());
		form.ccConsultant().setValue(criteria.getConsultant());
		form.cmbSpecialty().setValue(criteria.getSpecialty());
		form.cmbVTEStatus().setValue(criteria.getVTEStatus());
		form.txtSurname().setValue(criteria.getSurname());
		form.txtForename().setValue(criteria.getForename());
		form.cmbIDType().setValue(criteria.getPatIdType() != null ? criteria.getPatIdType() : PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue()));
		form.txtIDValue().setValue(criteria.getPatIdValue());
		form.pdtDOB().setValue(criteria.getDOB());
		form.chkOver24Hours().setValue(criteria.getOver24Hours());
		
		form.grdPatients().getRows().clear();
	}

	private void clearScreen() 
	{
		form.cmbHospital().setValue(null);
		form.qmbWard().clear();
		form.qmbCurrentWard().clear();
		form.dtimFrom().setValue(null);
		form.dtimTo().setValue(null);
		form.ccConsultant().clear();
		form.cmbSpecialty().setValue(null);
		form.cmbVTEStatus().setValue(null);
		form.txtSurname().setValue(null);
		form.txtForename().setValue(null);
		form.cmbIDType().setValue(PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue()));
		form.txtIDValue().setValue(null);
		form.pdtDOB().setValue(null);
		form.chkOver24Hours().setValue(null);
		
		form.grdPatients().getRows().clear();
	}

	private void populateHospitalCombo() 
	{
		LocSiteLiteVoCollection hospitals = domain.listHospitals();
		
		if(hospitals == null || hospitals.size() == 0)
			return;
		
		for(LocSiteLiteVo hospital : hospitals)
		{
			if(hospital == null)
				continue;
			
			form.cmbHospital().newRow(hospital, hospital.getName());
		}
	}

	@Override
	protected void onGrdPatientsSelectionChanged() throws PresentationLogicException 
	{
		form.getLocalContext().setSelectedInstance(form.grdPatients().getValue());
		updateControlsState();
	}

	@Override
	protected void onImbClearClick() throws PresentationLogicException 
	{
		clearScreen();
		
		form.getLocalContext().setSelectedInstance(null);
		form.getGlobalContext().Clinical.setVTERiskAssessmentWorklistCriteria(null);
		
		updateControlsState();
	}

	@Override
	protected void onImbSearchClick() throws PresentationLogicException 
	{
		form.getLocalContext().setSelectedInstance(null);
		
		if(search())
		{
			form.getGlobalContext().Clinical.setVTERiskAssessmentWorklistCriteria(populateSearchCriteriaDataFromScreen());
		}
		
		updateControlsState();
	}
	
	private VTERiskAssessmentWorklistCriteriaVo populateSearchCriteriaDataFromScreen() 
	{
		VTERiskAssessmentWorklistCriteriaVo criteria = new VTERiskAssessmentWorklistCriteriaVo();
		
		criteria.setHospital(form.cmbHospital().getValue());
		criteria.setWard(form.qmbWard().getValue());
		criteria.setCurrentWard(form.qmbCurrentWard().getValue());
		criteria.setAdmissionDateFrom(form.dtimFrom().getValue());
		criteria.setAdmissionDateTo(form.dtimTo().getValue());
		criteria.setConsultant(form.ccConsultant().getValue());
		criteria.setSpecialty(form.cmbSpecialty().getValue());
		criteria.setVTEStatus(form.cmbVTEStatus().getValue());
		criteria.setSurname(form.txtSurname().getValue());
		criteria.setForename(form.txtForename().getValue());
		
		if(form.txtIDValue().getValue() != null)
		{
			criteria.setPatIdType(form.cmbIDType().getValue());
			criteria.setPatIdValue(form.txtIDValue().getValue());
		}
		
		criteria.setDOB(form.pdtDOB().getValue());
		criteria.setOver24Hours(form.chkOver24Hours().getValue());
		criteria.setWasTimerOn(form.getLocalContext().getWasTimerOn());
		
		return criteria;
	}

	private boolean search() 
	{
		form.grdPatients().getRows().clear();
		
		if(isSearchCriteriaValid())
		{
			form.getLocalContext().setConsultantSortOrder(SortOrder.DESCENDING);
			form.getLocalContext().setAdmissionDateSortOrder(SortOrder.ASCENDING);//WDEV-15414 
			
			List<IVTERiskAssessment> list = domain.listPatients(populateSearchCriteriaDataFromScreen());//WDEV-15414 
			Collections.sort(list, new VTEAssessmentAdmissionDateComparator(form.getLocalContext().getAdmissionDateSortOrder()));//WDEV-15414 
			populateScreenFromData(list);//WDEV-15414 
			
			if(form.grdPatients().getRows().size() == 0)
			{
				engine.showMessage("No records found.");
			}
			
			return true;
		}
		
		return false;
	}

	private boolean isSearchCriteriaValid() 
	{
		DateTime dateFrom = form.dtimFrom().getValue();
		DateTime dateTo = form.dtimTo().getValue();
		
		if (dateFrom != null && dateTo != null && dateTo.isLessThan(dateFrom))
		{
			engine.showMessage("Admission Date From cannot be greater than Admission Date To", "Validation error", MessageButtons.OK, MessageIcon.ERROR);
			return false;
		}
		
		if(isAtLeastOneSearchFieldCompleted())
			return true;
		
		engine.showMessage("Complete at least one search field.", "Validation error", MessageButtons.OK, MessageIcon.ERROR);
		
		return false;
	}

	private boolean isAtLeastOneSearchFieldCompleted() 
	{
		return form.cmbHospital().getValue() != null || form.qmbWard().getValue() != null || form.qmbCurrentWard().getValue() != null || form.dtimFrom().getValue() != null || form.dtimTo().getValue() != null
				|| form.ccConsultant().getValue() != null || form.cmbSpecialty().getValue() != null || form.cmbVTEStatus().getValue() != null || form.txtSurname().getValue() != null
				|| form.txtForename().getValue() != null || form.txtIDValue().getValue() != null || form.pdtDOB().getValue() != null || Boolean.TRUE.equals(form.chkOver24Hours().getValue());
	}

	private void populateScreenFromData(List<IVTERiskAssessment> list) //WDEV-15414 
	{
		form.grdPatients().getRows().clear();
		
		if(list == null || list.size() == 0)//WDEV-15414 
			return;
		
		for(int i=0; i<list.size(); i++)//WDEV-15414 
		{
			if(list.get(i) == null)//WDEV-15414 
				continue;
			
			addEpisodeRow(list.get(i));//WDEV-15414 
		}
		
		form.grdPatients().setValue(form.getLocalContext().getSelectedInstance());
	}

	private void addEpisodeRow(IVTERiskAssessment ivteRiskAssessments) //WDEV-15414 
	{
		if(ivteRiskAssessments == null)
			return;
		
		grdPatientsRow row = form.grdPatients().getRows().newRow();
		
		if(ivteRiskAssessments.getPasEvent() != null)//WDEV-15414 
		{
			row.setColHospNumber(ivteRiskAssessments.getPasEvent().getPatient().getHospNum() != null ? ivteRiskAssessments.getPasEvent().getPatient().getHospNum().getValue() : null);//WDEV-15414 
			row.setTooltipForColHospNumber(row.getColHospNumber());
			
			row.setColSurname(ivteRiskAssessments.getPasEvent().getPatient().getName().getSurname());//WDEV-15414 
			row.setTooltipForColSurname(row.getColSurname());
			
			row.setColForename(ivteRiskAssessments.getPasEvent().getPatient().getName().getForename());//WDEV-15414 
			row.setTooltipForColForename(row.getColForename());
			
			row.setColDOB(ivteRiskAssessments.getPasEvent().getPatient().getDobIsNotNull() ? ivteRiskAssessments.getPasEvent().getPatient().getDob().toString() : null);//WDEV-15414 
			row.setTooltipForColDOB(row.getColDOB());
			
			WardStayVo admWard =  getMinById(ivteRiskAssessments.getWardStays()); //wdev-14992, WDEV-15414 
			//row.setColAdWard(inpatient.getPasEvent().getLocationIsNotNull() ? inpatient.getPasEvent().getLocation().getName() : null);
			row.setColAdWard(admWard != null && admWard.getWardIsNotNull() ? admWard.getWard().getName() : null); //wdev-14492
			row.setTooltipForColAdWard(row.getColAdWard());
			
			row.setColWard(ivteRiskAssessments.getPasEvent().getPatient().getWardIsNotNull() ? ivteRiskAssessments.getPasEvent().getPatient().getWard().getName() : null);//WDEV-15414 
			row.setTooltipForColWard(row.getColWard());
			
			row.setColConsultant(ivteRiskAssessments.getPasEvent().getConsultantIsNotNull() ? ivteRiskAssessments.getPasEvent().getConsultant().getIHcpName() : null);//WDEV-15414 
			row.setTooltipForColConsultant(row.getColConsultant());
			
			row.setColSpecialty(ivteRiskAssessments.getPasEvent().getSpecialtyIsNotNull() ? ivteRiskAssessments.getPasEvent().getSpecialty().getText() : null);//WDEV-15414 
			row.setTooltipForColSpecialty(row.getColSpecialty());
		}
		
		row.setColAdmissionDate(ivteRiskAssessments.getAdmissionDateTime() != null ? ivteRiskAssessments.getAdmissionDateTime().toString() : null);//WDEV-15414 
		row.setTooltipForColAdmissionDate(row.getColAdmissionDate());
		
		row.setColVTEStatus(VTEAsessmentStatus.REQUIRED.equals(ivteRiskAssessments.getVTEAssessmentStatus()) ? form.getImages().OCRR.Requested : (VTEAsessmentStatus.INPROGRESS.equals(ivteRiskAssessments.getVTEAssessmentStatus()) ? form.getImages().OCRR.InProgress : null));//WDEV-15414 
		row.setTooltipForColVTEStatus(ivteRiskAssessments.getVTEAssessmentStatus() != null ? ivteRiskAssessments.getVTEAssessmentStatus().getText() : null);//WDEV-15414 
		
		row.setValue(ivteRiskAssessments);//WDEV-15414 
		
		if(ivteRiskAssessments.getAdmissionDateTime() != null)//WDEV-15414 
		{
			DateTime admissionDate = (DateTime) ivteRiskAssessments.getAdmissionDateTime().clone();//WDEV-15414 
			DateTime kpi = admissionDate.addHours(ConfigFlag.UI.VTE_RISK_ASSESSMENT_KPI_EXCEEDED_PERIOD.getValue());
		
			if(kpi.isLessThan(new DateTime()) && !VTEAsessmentStatus.COMPLETED.equals(ivteRiskAssessments.getVTEAssessmentStatus()))//WDEV-15414 
			{
				row.setBackColor(ConfigFlag.UI.VTE_RISK_ASSESSMENT_EXCEEDED_KPI_COLOR.getValue());
				return;
			}
			
			DateTime currentDate = new DateTime();
			DateTime breachWarning = ((DateTime) kpi.clone()).addHours(-ConfigFlag.UI.VTE_RISK_ASSESSMENT_BREACH_WARNING_PERIOD.getValue());
			if(currentDate.isGreaterOrEqualThan(breachWarning) && currentDate.isLessOrEqualThan(kpi))
			{	
				row.setBackColor(ConfigFlag.UI.VTE_RISK_ASSESSMENT_BREACH_WARNING_COLOR.getValue());
			}
		}	
	}
	//wdev-14992
	private WardStayVo getMinById(WardStayVoCollection coll)
	{
		WardStayVo tempVo = null;
		if(	coll == null || coll.size() == 0 )
			return null;
		for(int i = 0; i < coll.size();i++)
		{
			if( i == 0)
				tempVo = coll.get(i);
			else if( i > 0 )
			{
				if( tempVo != null && coll.get(i) != null && tempVo.getID_WardStay() > coll.get(i).getID_WardStay())
					tempVo = coll.get(i); 
			}
		}
		
		return tempVo;
	}
	//-----------

	@Override
	protected void onCmbHospitalValueChanged() throws PresentationLogicException 
	{
		form.qmbWard().clear();
		updateControlsState();
	}
	
	private void updateControlsState() 
	{
		boolean enableControls = !form.getTimers().gettimerRefresh().isEnabled();
		
		form.cmbHospital().setEnabled(enableControls);
		form.qmbWard().setEnabled(form.cmbHospital().getValue() != null && enableControls);
		
		form.dtimFrom().setEnabled(enableControls);
		form.dtimTo().setEnabled(enableControls);
		
		form.ccConsultant().setEnabled(enableControls);
		form.cmbSpecialty().setEnabled(enableControls);
		form.cmbVTEStatus().setEnabled(enableControls);
		
		form.txtSurname().setEnabled(enableControls);
		form.txtForename().setEnabled(enableControls);
		form.cmbIDType().setEnabled(enableControls);
		form.txtIDValue().setEnabled(enableControls);
		form.pdtDOB().setEnabled(enableControls);
		form.chkOver24Hours().setEnabled(enableControls);
		
		form.imbSearch().setEnabled(enableControls);
		form.imbClear().setEnabled(enableControls);
		
		form.getContextMenus().Clinical.getVTERiskAssessmentWorklistMenuCREATE_VTEASSESSMENTItem().setVisible(form.grdPatients().getValue() != null && VTEAsessmentStatus.REQUIRED.equals(form.grdPatients().getValue().getVTEAssessmentStatus()));
		form.getContextMenus().Clinical.getVTERiskAssessmentWorklistMenuVIEW_EDIT_VTEASSESSMENTItem().setVisible(form.grdPatients().getValue() != null && VTEAsessmentStatus.INPROGRESS.equals(form.grdPatients().getValue().getVTEAssessmentStatus()));
		form.getContextMenus().Clinical.getVTERiskAssessmentWorklistMenuREMOVEItem().setVisible(form.grdPatients().getValue() != null);
	}

	private void listWards(LocSiteLiteVo locSiteLiteVo, String wardName, boolean showOpened) 
	{
		form.qmbWard().clear();
		
		if(locSiteLiteVo == null || locSiteLiteVo.getID_Location() == null)
			return;
		
		LocationLiteVoCollection wards = domain.listWards(locSiteLiteVo, wardName);
		
		if(wards == null || wards.size() == 0)
			return;
		
		for(LocationLiteVo ward : wards)
		{
			if(ward == null)
				continue;
			
			form.qmbWard().newRow(ward, ward.getName());
		}
		
		if(showOpened)
		{
			if(wards.size() == 1)
			{
				form.qmbWard().setValue(wards.get(0));
				return;
			}
		
			form.qmbWard().showOpened();
		}
	}

	@Override
	protected void onQmbWardTextSubmited(String value) throws PresentationLogicException 
	{
		if(form.cmbHospital().getValue() == null)
		{
			engine.showMessage("Please select a Hospital");
			form.cmbHospital().setFocus();
			return;
		}
		
		listWards(form.cmbHospital().getValue(), value, true);
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		disableRefreshTemporarily();
		
		switch(menuItemID)
		{
			case GenForm.ContextMenus.ClinicalNamespace.VTERiskAssessmentWorklistMenu.CREATE_VTEASSESSMENT:
				createOrViewVTEAssessment(FormMode.EDIT);
			break;
			
			case GenForm.ContextMenus.ClinicalNamespace.VTERiskAssessmentWorklistMenu.VIEW_EDIT_VTEASSESSMENT:
				createOrViewVTEAssessment(FormMode.VIEW);
			break;
			
			case GenForm.ContextMenus.ClinicalNamespace.VTERiskAssessmentWorklistMenu.REMOVE:
			{
				if(saveVTEAssessment())
				{
					if(search())
					{
						form.getGlobalContext().Clinical.setVTERiskAssessmentWorklistCriteria(populateSearchCriteriaDataFromScreen());
					}
				}
			}
			break;
		}
		
		toggleTimer(false);
		updateControlsState();
	}

	private boolean saveVTEAssessment() 
	{
		if(form.grdPatients().getValue() == null || form.grdPatients().getValue().getId() ==  null)//WDEV-15414 
			return false;
		
		IVTERiskAssessment vteAssessment = form.grdPatients().getValue();//WDEV-15414 
//		String[] errors = null;//WDEV-15414 
//		if(vteAssessment instanceof VTERiskAssessmentWorklistVo)//WDEV-15414 
//		{
//			((VTERiskAssessmentWorklistVo) vteAssessment).setVTEAssessmentStatus(null);
//			errors = ((VTERiskAssessmentWorklistVo) vteAssessment).validate();
//		}
//		else if(vteAssessment instanceof DischargedEpisodeForVTERiskAssessmentWorklistVo)//WDEV-15414 
//		{
//			((DischargedEpisodeForVTERiskAssessmentWorklistVo) vteAssessment).setVTEAssessmentStatus(null);
//			errors = ((DischargedEpisodeForVTERiskAssessmentWorklistVo) vteAssessment).validate();
//		}
//		
//		if(errors != null && errors.length > 0)
//		{
//			engine.showErrors(errors);
//			return false;
//		}
		
		try 
		{
			domain.saveEpisode(vteAssessment);//WDEV-15414 
		} 
		catch (StaleObjectException e) 
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			if(search())
			{
				form.getGlobalContext().Clinical.setVTERiskAssessmentWorklistCriteria(populateSearchCriteriaDataFromScreen());
			}
			return false;
		}
		
		return true;
	}

	private void createOrViewVTEAssessment(FormMode dialogMode) 
	{
		if(form.grdPatients().getValue() == null)
			return;
		
		//WDEV-15986 - starts here
		WasVTERiskAssessmentStatusChangedVo wasChanged = domain.wasStatusChanged(form.grdPatients().getValue(), form.grdPatients().getValue().getVTEAssessmentStatus());
		
		if(wasChanged != null && wasChanged.getWasStatusChanged())
		{
			String message = "";
			
			if(wasChanged.getVTEStatus() == null)
			{
				message = "Selected Episode has been removed from VTE Worklist";
			}
			else if(VTEAsessmentStatus.REQUIRED.equals(form.grdPatients().getValue().getVTEAssessmentStatus()))
			{
				message = "A new VTE Assessment has been created for this Episode";
			}
			else if(VTEAsessmentStatus.INPROGRESS.equals(form.grdPatients().getValue().getVTEAssessmentStatus()))
			{
				if(VTEAsessmentStatus.COMPLETED.equals(wasChanged.getVTEStatus()))
				{
					message = "The VTE Assessment linked to this Episode has been completed";
				}
				else if(VTEAsessmentStatus.REQUIRED.equals(wasChanged.getVTEStatus()))
				{
					message = "The VTE Assessment linked to this Episode has been marked as Recorded in Error";
				}
			}
			
			if(message.length() > 0)
				engine.showMessage(message);
			
			if(wasChanged.getVTEStatus() == null || VTEAsessmentStatus.REQUIRED.equals(form.grdPatients().getValue().getVTEAssessmentStatus()))
			{
				open();
				return;
			}
		}
		//WDEV-15986 - ends here
		
		selectPatient();
		
		form.getGlobalContext().Core.setInpatientEpisodeForVTERiskAssessmentWorklistVo(form.grdPatients().getValue());
		engine.open(form.getForms().Clinical.VTERiskAssessmentDialog, new Object[] {dialogMode});
	}

	private void selectPatient() 
	{
		if(form.grdPatients().getValue() == null || form.grdPatients().getValue().getPasEvent() == null)
			return;
		
		PatientForVTERiskAssessmentVo patient = form.grdPatients().getValue().getPasEvent().getPatient();
		PatientShort patientShort = new PatientShort(patient.getID_Patient(), patient.getVersion_Patient());
		form.getGlobalContext().Core.setPatientShort(patientShort);
	}

	private void disableRefreshTemporarily() 
	{
		if(form.getTimers().gettimerRefresh().isEnabled())
		{
			form.getTimers().gettimerRefresh().setEnabled(false);
			form.imbRefresh().setEnabledImage(form.getImages().Core.TimerStartEnabled24);
			form.imbRefresh().setTooltip("Click button to start the automatic refresh");	
			form.getLocalContext().setWasTimerOn(true);
		}
		else
			form.getLocalContext().setWasTimerOn(false);
	}

	@Override
	protected void onTimer(Timer timer) throws PresentationLogicException 
	{
		if(search())
		{
			form.getGlobalContext().Clinical.setVTERiskAssessmentWorklistCriteria(populateSearchCriteriaDataFromScreen());
		}
		
		updateControlsState();
	}

	@Override
	protected void onImbRefreshClick() throws PresentationLogicException 
	{
		toggleTimer(true);
		updateControlsState();
	}

	private void toggleTimer(boolean fromButton) 
	{
		if(fromButton && !form.getTimers().gettimerRefresh().isEnabled())
		{
			if(!isSearchCriteriaValid())
				return;
		}
		
		boolean reinstateTimer = form.getLocalContext().getWasTimerOn();
		
		if(form.getTimers().gettimerRefresh().isEnabled())
		{
			form.getTimers().gettimerRefresh().setEnabled(false);
			
			form.imbRefresh().setEnabledImage(form.getImages().Core.TimerStartEnabled24);
			form.imbRefresh().setTooltip("Click button to start the automatic refresh");
			
			form.getLocalContext().setWasTimerOn(false);
			if(form.getGlobalContext().Clinical.getVTERiskAssessmentWorklistCriteriaIsNotNull())
				form.getGlobalContext().Clinical.getVTERiskAssessmentWorklistCriteria().setWasTimerOn(false);
		}
		else if(!form.getTimers().gettimerRefresh().isEnabled())
		{
			if(fromButton || reinstateTimer)
			{
				form.getTimers().gettimerRefresh().setEnabled(true);
				
				form.imbRefresh().setTooltip("Click button to stop the automatic refresh");
				form.imbRefresh().setEnabledImage(form.getImages().Core.TimerStopEnabled24);
				form.imbRefresh().setEnabled(true);
				
				form.getLocalContext().setWasTimerOn(true);
				if(form.getGlobalContext().Clinical.getVTERiskAssessmentWorklistCriteriaIsNotNull())
					form.getGlobalContext().Clinical.getVTERiskAssessmentWorklistCriteria().setWasTimerOn(true);
			}
		}
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		form.getGlobalContext().Core.setPatientShort(null);
		
		search();
		updateControlsState();
	}

	@Override
	protected void onGrdPatientsGridHeaderClicked(int column) throws PresentationLogicException 
	{
		List<IVTERiskAssessment> values = getValuesFromGrid();//WDEV-15414 
		
		if (values == null) //WDEV-18160
			return;
		
		switch(column)
		{
			case DOB_COLUMN:
				form.getLocalContext().setDOBSortOrder(SortOrder.ASCENDING.equals(form.getLocalContext().getDOBSortOrder())? SortOrder.DESCENDING : SortOrder.ASCENDING);
				Collections.sort(values, new VTEAssessmentDOBComparator(form.getLocalContext().getDOBSortOrder()));//WDEV-15414 
			break;
			
			case CONSULTANT_COLUMN:
				Collections.sort(values, new VTEAssessmentConsultantComparator(form.getLocalContext().getConsultantSortOrder()));//WDEV-15414 
				form.getLocalContext().setConsultantSortOrder(SortOrder.ASCENDING.equals(form.getLocalContext().getConsultantSortOrder())? SortOrder.DESCENDING : SortOrder.ASCENDING);
			break;
			
			case ADMISSION_DATE_COLUMN:
				form.getLocalContext().setAdmissionDateSortOrder(SortOrder.ASCENDING.equals(form.getLocalContext().getAdmissionDateSortOrder())? SortOrder.DESCENDING : SortOrder.ASCENDING);
				Collections.sort(values, new VTEAssessmentAdmissionDateComparator(form.getLocalContext().getAdmissionDateSortOrder()));//WDEV-15414 
			break;
			
			case VTE_STATUS_COLUMN:
				form.getLocalContext().setVTEStatusSortOrder(SortOrder.ASCENDING.equals(form.getLocalContext().getVTEStatusSortOrder())? SortOrder.DESCENDING : SortOrder.ASCENDING);
				Collections.sort(values, new VTEAssessmentVTEStatusComparator(form.getLocalContext().getVTEStatusSortOrder()));//WDEV-15414 
			break;
		}
		
		populateScreenFromData(values);
	}
	
	//WDEV-15414 
	private List<IVTERiskAssessment> getValuesFromGrid() 
	{
		if(form.grdPatients().getRows().size() == 0)
			return null;
		
		List<IVTERiskAssessment> values = new ArrayList<IVTERiskAssessment>();
		
		for(int i=0; i<form.grdPatients().getRows().size(); i++)
		{
			values.add(form.grdPatients().getRows().get(i).getValue());
		}
		
		return values;
	}

	class VTEAssessmentAdmissionDateComparator implements Comparator<IVTERiskAssessment>//WDEV-15414 
	{
		private int order =1;
		public VTEAssessmentAdmissionDateComparator()
		{
			order = 1;
		}
		public VTEAssessmentAdmissionDateComparator(SortOrder order)
		{
			this.order = SortOrder.DESCENDING.equals(order)?-1:1;
		}
		public int compare(IVTERiskAssessment o1, IVTERiskAssessment o2)//WDEV-15414 
		{
			if (o1 != null && o1.getAdmissionDateTime() != null && o2!=null && o2.getAdmissionDateTime() != null)//WDEV-15414 
			{
				return order*o1.getAdmissionDateTime().compareTo(o2.getAdmissionDateTime());
			}
			if (o1 == null || !(o1.getAdmissionDateTime() != null))//WDEV-15414 
				return -1*order;
			if (o2 == null || !(o2.getAdmissionDateTime() != null))//WDEV-15414 
				return order;
			
			return 0;
		}	
	}
	
	class VTEAssessmentConsultantComparator implements Comparator<IVTERiskAssessment>//WDEV-15414 
	{
		private int order = 1;
		public VTEAssessmentConsultantComparator()
		{
			order = 1;
		}
		public VTEAssessmentConsultantComparator(SortOrder order)
		{
			this.order = SortOrder.DESCENDING.equals(order) ? -1 : 1;
		}
		public int compare(IVTERiskAssessment o1, IVTERiskAssessment o2)//WDEV-15414 
		{
			if(o1 != null && o1.getPasEvent() != null && o1.getPasEvent().getConsultantIsNotNull() && o2 != null && o2.getPasEvent() != null && o2.getPasEvent().getConsultantIsNotNull())//WDEV-15414 
				return order*o1.getPasEvent().getConsultant().compareTo(o2.getPasEvent().getConsultant());
			
			if (o1 == null || !(o1.getPasEvent() != null) || !o1.getPasEvent().getConsultantIsNotNull())//WDEV-15414 
				return -1 * order;
			
			if (o2 == null || !(o2.getPasEvent() != null) || !o2.getPasEvent().getConsultantIsNotNull())//WDEV-15414 
				return order;
			
			return 0;
		}	
	}
	
	public class VTEAssessmentDOBComparator implements Comparator<IVTERiskAssessment>//WDEV-15414 
	{
		private int order = 1;
		
		public VTEAssessmentDOBComparator()
		{
			order = 1;
		}
		
		public VTEAssessmentDOBComparator(SortOrder order)
		{
			this.order = SortOrder.DESCENDING.equals(order) ? -1 : 1;
		}
		
		public int compare(IVTERiskAssessment o1, IVTERiskAssessment o2) //WDEV-15414 
		{
			if(o1 != null && o1.getPasEvent() != null && o1.getPasEvent().getPatient().getDobIsNotNull() && o2 != null && o2.getPasEvent() != null && o2.getPasEvent().getPatient().getDobIsNotNull())//WDEV-15414 
				return order*o1.getPasEvent().getPatient().getDob().compareTo(o2.getPasEvent().getPatient().getDob());
			
			if (o1 == null || !(o1.getPasEvent() != null) || !o1.getPasEvent().getPatient().getDobIsNotNull())//WDEV-15414 
				return -1 * order;
			
			if (o2 == null || !(o2.getPasEvent() != null) || !o2.getPasEvent().getPatient().getDobIsNotNull())//WDEV-15414 
				return order;
			
			return 0;
		}
	}
	
	class VTEAssessmentVTEStatusComparator implements Comparator<IVTERiskAssessment>//WDEV-15414 
	{
		private int order =1;
		public VTEAssessmentVTEStatusComparator()
		{
			order = 1;
		}
		public VTEAssessmentVTEStatusComparator(SortOrder order)
		{
			this.order = SortOrder.DESCENDING.equals(order)?-1:1;
		}
		public int compare(IVTERiskAssessment o1, IVTERiskAssessment o2)//WDEV-15414 
		{
			if (o1 != null && o1.getVTEAssessmentStatus() != null && o2!=null && o2.getVTEAssessmentStatus() != null)//WDEV-15414 
			{
				return order*o1.getVTEAssessmentStatus().getText().compareToIgnoreCase(o2.getVTEAssessmentStatus().getText());
			}
			if (o1 == null || !(o1.getVTEAssessmentStatus() != null))//WDEV-15414 
				return -1*order;
			if (o2 == null || !(o2.getVTEAssessmentStatus() != null))//WDEV-15414 
				return order;
			
			return 0;
		}	
	}

	@Override
	protected void onQmbCurrentWardTextSubmited(String value) throws PresentationLogicException 
	{
		if(form.cmbHospital().getValue() == null)
		{
			engine.showMessage("Please select a Hospital");
			form.cmbHospital().setFocus();
			return;
		}
		
		listCurrentWards(form.cmbHospital().getValue(), value, true);
	}
	
	private void listCurrentWards(LocSiteLiteVo locSiteLiteVo, String wardName, boolean showOpened) 
	{
		form.qmbCurrentWard().clear();
		
		if(locSiteLiteVo == null || locSiteLiteVo.getID_Location() == null)
			return;
		
		LocationLiteVoCollection wards = domain.listWards(locSiteLiteVo, wardName);
		
		if(wards == null || wards.size() == 0)
			return;
		
		for(LocationLiteVo ward : wards)
		{
			if(ward == null)
				continue;
			
			form.qmbCurrentWard().newRow(ward, ward.getName());
		}
		
		if(showOpened)
		{
			if(wards.size() == 1)
			{
				form.qmbCurrentWard().setValue(wards.get(0));
				return;
			}
		
			form.qmbCurrentWard().showOpened();
		}
	}
}
