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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4471.18200)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.quickregistration;

import ims.clinical.vo.lookups.DischargeLetterStatus;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.CareContextVo;
import ims.core.vo.CareContextVoCollection;
import ims.core.vo.CareSpellVo;
import ims.core.vo.EpisodeofCareVo;
import ims.core.vo.EpisodeofCareVoCollection;
import ims.core.vo.LocSiteLiteVo;
import ims.core.vo.LocSiteShortVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.PatientFilter;
import ims.core.vo.PatientLiteVo;
import ims.core.vo.PatientShort;
import ims.core.vo.PersonName;
import ims.core.vo.lookups.ContextType;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.Specialty;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.vo.AttendanceDetailsVo;
import ims.emergency.vo.EmergencyAttendanceForQuickRegistrationVo;
import ims.emergency.vo.EmergencyAttendanceForQuickRegistrationVoCollection;
import ims.emergency.vo.EmergencyEpisodeForQuickRegistrationVo;
import ims.emergency.vo.TrackingAttendanceStatusVo;
import ims.emergency.vo.TrackingForQuickRegistrationVo;
import ims.emergency.vo.lookups.AttendanceType;
import ims.emergency.vo.lookups.QuickRegistrationType;
import ims.emergency.vo.lookups.TrackingStatus;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.PartialDate;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{

		if (getLocation() == null)
		{
			form.setMode(FormMode.VIEW);
			engine.showMessage("The current location should be of type Emergency.");
			return;
		}

		form.getGlobalContext().Emergency.setSelectedPatient(null);
		form.cmbRegistrationType().setValue(QuickRegistrationType.QUICK_REG);		//wdev-17136
		form.dtimArrival().setValue(new DateTime());//WDEV-17249
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (QuickRegistrationType.EXP_ARRIVAL.equals(form.cmbRegistrationType().getValue()))//WDEV-15959
		{
			if (validateSave())
			{
				if (save())
				{
					form.setMode(FormMode.VIEW);
				}
			}
		}
		else
		{
			if (validateSave())
			{
				engine.open(form.getForms().Emergency.SendToAreaDialog, new Object[] {Boolean.FALSE}); //WDEV-17249
			}
		}

	}

	private boolean validateSave()
	{

		MemberOfStaffShortVo memberVo = null;
		if (domain.getMosUser() instanceof MemberOfStaffShortVo)
		{
			memberVo = (MemberOfStaffShortVo) domain.getMosUser();
		}
		if (memberVo == null)
		{
			engine.showMessage("User must be Member Of Staff.");
			return false;
		}

		if (!validateUIRules())
			return false;
		
		//WDEV-15958
		//PatientLiteVo patient = populatePatient();
	
		PatientLiteVo patient = null;
		if (form.getGlobalContext().Emergency.getSelectedPatientIsNotNull())
		{
			patient=domain.getPatient(form.getGlobalContext().Emergency.getSelectedPatient());
			form.getLocalContext().setpatientToSave(patient);
		}
		else
		{
			patient = populatePatient();
		}
		
		String[] patientErrors = patient.validate();
		if (patientErrors != null && patientErrors.length > 0)
		{
			engine.showErrors(patientErrors);
			return false;
		}

		EmergencyEpisodeForQuickRegistrationVo emergencyEpisode = populateDataFromScreen();

		CareSpellVo careSpell = form.getLocalContext().getcareSpellToSave();

		String[] careSpellErrors = careSpell.validate();
		if (careSpellErrors != null && careSpellErrors.length > 0)
		{
			engine.showErrors(careSpellErrors);
			return false;
		}

		String[] emergencyEpisodeErrors = emergencyEpisode.validate();
		if (emergencyEpisodeErrors != null && emergencyEpisodeErrors.length > 0)
		{
			engine.showErrors(emergencyEpisodeErrors);
			return false;
		}

		return true;
	}

	private boolean validateUIRules()
	{
		ArrayList<String> listOfErrors = new ArrayList<String>();

		//WDEV-15959
		if (form.cmbRegistrationType().getValue()==null)
		{
			listOfErrors.add("Registration Type is mandatory.");
		}
		
		
		if (form.txtSurname().getValue() == null)
		{
			listOfErrors.add("Surname is mandatory.");
		}

		if (form.cmbSourceOfReferral().getValue() == null)
		{
			listOfErrors.add("Source of Referral is mandatory.");
		}

		if( form.dtimInjury().getValue() != null && form.dtimInjury().getValue().isGreaterThan(new DateTime())) //wdev-17045
		{
			listOfErrors.add("Incident Time cannot be in the future.");
		}
		
		if (form.dtimArrival().getValue() == null)
		{
			listOfErrors.add("Arrival Time is mandatory.");
		}
		
		if( form.dtimInjury().getValue() != null && form.dtimArrival().getValue() != null && form.dtimInjury().getValue().isGreaterThan(form.dtimArrival().getValue()))
		{
			listOfErrors.add("Arrival Time cannot be less than Incident Time");
		}
		if( !QuickRegistrationType.EXP_ARRIVAL.equals(form.cmbRegistrationType().getValue()) &&  form.dtimArrival().getValue() != null && form.dtimArrival().getValue().isGreaterThan(new DateTime())) //wdev-17461
		{
			listOfErrors.add("Arrival Time cannot be in the future.");
		}


		int errorCount = listOfErrors.size();
		String[] result = new String[errorCount];

		for (int x = 0; x < errorCount; x++)
			result[x] = (String) listOfErrors.get(x);

		if (result != null && result.length > 0)
		{
			engine.showErrors(result);
			return false;
		}

		return true;
	}

	private TrackingForQuickRegistrationVo populateTracking()
	{
		TrackingForQuickRegistrationVo trackingVo = new TrackingForQuickRegistrationVo();

		trackingVo.setPatient(form.getLocalContext().getpatientToSave());
		trackingVo.setAttendance(new AttendanceDetailsVo());
		trackingVo.setEpisode(form.getLocalContext().getemergencyEpisodeToSave());

		trackingVo.setEDLocation(getLocation());

		trackingVo.setCurrentArea(form.getGlobalContext().Emergency.getTrackingAreaForSendToAreaVo());

		if (QuickRegistrationType.UNC_UNK_PATIENT.equals(form.cmbRegistrationType().getValue()))//WDEV-15959
		{
			trackingVo.setIsUnknownPatient(true);
		}

		TrackingAttendanceStatusVo trStatusVo = new TrackingAttendanceStatusVo();
		trStatusVo.setPatient(form.getLocalContext().getpatientToSave());
		trStatusVo.setAttendance(form.getLocalContext().getcareContextToSave());
		trStatusVo.setEpisode(form.getLocalContext().getepisodeToSave());
		trStatusVo.setTrackingArea(form.getGlobalContext().Emergency.getTrackingAreaForSendToAreaVo());
		trStatusVo.setStatusDatetime(new DateTime());
		MemberOfStaffShortVo memberVo = null;

		if (domain.getMosUser() instanceof MemberOfStaffShortVo)
		{
			memberVo = (MemberOfStaffShortVo) domain.getMosUser();
		}

		trStatusVo.setCreatedBy(memberVo);
		trStatusVo.setStatus(TrackingStatus.WAITING_TO_BE_TRIAGED);
		trStatusVo.setPrevStatus(null); //WDEV-16777

		trackingVo.setCurrentStatus(trStatusVo);
		trackingVo.setDischargeLetterStatus(DischargeLetterStatus.IN_PROGRESS);  //wdev-17110
		return trackingVo;
	}

	private PatientLiteVo populatePatient()
	{
		PatientLiteVo patient = new PatientLiteVo();

		PersonName name = new PersonName();
		name.setSurname(form.txtSurname().getValue());
		name.setForename(form.txtForename().getValue());
		name.setUppers();

		patient.setName(name);
		patient.setSex(form.cmbGender().getValue());
		patient.setDob(form.pdtDOB().getValue());
		patient.setIsActive(true);

		form.getLocalContext().setpatientToSave(patient);

		return patient;
	}

	private EmergencyEpisodeForQuickRegistrationVo populateDataFromScreen()
	{
		EmergencyEpisodeForQuickRegistrationVo voEmergencyEpisode = new EmergencyEpisodeForQuickRegistrationVo();
		EmergencyAttendanceForQuickRegistrationVo voEmergencyAttendance = new EmergencyAttendanceForQuickRegistrationVo();
		EmergencyAttendanceForQuickRegistrationVoCollection voCollEmergencyAttendance = new EmergencyAttendanceForQuickRegistrationVoCollection();

		createNewCareSpell();

		// Populate EmergencyDetails
		voEmergencyEpisode.setInjuryDateTime(form.dtimInjury().getValue());
		voEmergencyEpisode.setSourceOfReferral(form.cmbSourceOfReferral().getValue());
		voEmergencyEpisode.setEpisodeOfCare(form.getLocalContext().getepisodeToSave());
		voEmergencyEpisode.setPatient(form.getLocalContext().getpatientToSave());

		// Populate EmergencyAttendance
		voEmergencyAttendance.setArrivalDateTime(form.dtimArrival().getValue());
		voEmergencyAttendance.setRegistrationDateTime(form.dtimArrival().getValue());
		voEmergencyAttendance.setEmergencyEpisode(voEmergencyEpisode);
		voEmergencyAttendance.setCareContext(form.getLocalContext().getcareContextToSave());
		voEmergencyAttendance.setEpisode(voEmergencyEpisode);
		voEmergencyAttendance.setPatient(form.getLocalContext().getpatientToSave());
		voEmergencyAttendance.setAttendanceType(AttendanceType.FIRST);
		voEmergencyAttendance.setAgeAtAttendance(calculateAge());
		voEmergencyAttendance.setRegistrationLocation(getLocation());
		voEmergencyAttendance.setComments(form.txtComments().getValue());	//wdev-17463
		//wdev-16070
		if( domain.getMosUser() instanceof MemberOfStaffLiteVo )
		{
			MemberOfStaffLiteVo tempVo = (MemberOfStaffLiteVo) domain.getMosUser();
			voEmergencyAttendance.setRegisteringMOS(tempVo);
		}

		//WDEV-15959
		
		if (QuickRegistrationType.UNC_UNK_PATIENT.equals(form.cmbRegistrationType().getValue()) )
		{
			voEmergencyAttendance.setIsUnknownPatient(true);
		}
		else if (QuickRegistrationType.QUICK_REG.equals(form.cmbRegistrationType().getValue()))
		{
			voEmergencyAttendance.setIsQuickRegistration(true);
		}
		else if (QuickRegistrationType.EXP_ARRIVAL.equals(form.cmbRegistrationType().getValue()))
		{
			voEmergencyAttendance.setExpectedArrivalDateTime(form.dtimArrival().getValue());
			voEmergencyAttendance.setIsExpectedArrival(true);
		}
		else if (QuickRegistrationType.MAJ_INCIDENT.equals(form.cmbRegistrationType().getValue()))
		{
			voEmergencyAttendance.setIsMajorIncident(true);
		}
		
		voCollEmergencyAttendance.add(voEmergencyAttendance);
		voEmergencyEpisode.setEmergencyAttendances(voCollEmergencyAttendance);

		form.getLocalContext().setemergencyEpisodeToSave(voEmergencyEpisode);
		form.getLocalContext().setemergencyAttendanceToSave(voEmergencyAttendance);

		return voEmergencyEpisode;
	}

	private LocationLiteVo getLocation()
	{
		LocationLiteVo loc = null;
		LocSiteLiteVo locsite = null;

		if (domain.getCurrentLocation() instanceof LocationLiteVo)
		{
			loc = (LocationLiteVo) domain.getCurrentLocation();

		}
		else if (domain.getCurrentLocation() instanceof LocSiteLiteVo)
		{
			locsite = (LocSiteLiteVo) domain.getCurrentLocation();
			if (locsite != null)
			{
				loc = new LocationLiteVo(locsite.getID_Location(), locsite.getVersion_Location());
				LocSiteShortVo locShortVo = domain.getTypeOfLocSite(loc);
				loc.setType(locShortVo.getType());
			}
		}

		if (loc != null && loc.getTypeIsNotNull() && loc.getType().equals(LocationType.ANE))
			return loc;
		else
			return null;
	}

	private Integer calculateAge()
	{
		if (form.getLocalContext().getpatientToSaveIsNotNull())
		{
			PartialDate dob = form.pdtDOB().getValue();
			Date arrival = form.dtimArrival().getValue() != null ? form.dtimArrival().getValue().getDate() : null;
			int patAge = 0;
			if (dob != null)
			{
				patAge = new ims.framework.utils.Age(dob, arrival).getYears();
			}
			return new Integer(patAge);
		}
		return null;
	}

	private void createNewCareSpell()
	{
		CareSpellVo voCareSpell = new CareSpellVo();

		voCareSpell.setStartDate(form.dtimArrival().getValue().getDate());
		voCareSpell.setPatient(form.getLocalContext().getpatientToSave());
		voCareSpell.setEpisodes(createNewEpisodeOfCare(voCareSpell));

		form.getLocalContext().setcareSpellToSave(voCareSpell);
	}

	private EpisodeofCareVoCollection createNewEpisodeOfCare(CareSpellVo voCareSpell)
	{
		EpisodeofCareVoCollection voCollEpisodeOfCare = new EpisodeofCareVoCollection();
		EpisodeofCareVo voEpisodeOfCare = new EpisodeofCareVo();

		if (form.dtimArrival().getValue() != null)
		{
			voEpisodeOfCare.setStartDate(form.dtimArrival().getValue().getDate());
		}
		voEpisodeOfCare.setSpecialty(Specialty.EMERGENCY);
		voEpisodeOfCare.setCareSpell(voCareSpell);
		voEpisodeOfCare.setCareContexts(createNewCareContext(voEpisodeOfCare));
		voCollEpisodeOfCare.add(voEpisodeOfCare);

		form.getLocalContext().setepisodeToSave(voEpisodeOfCare);

		return voCollEpisodeOfCare;
	}

	private CareContextVoCollection createNewCareContext(EpisodeofCareVo voEpisodeOfCare)
	{
		CareContextVoCollection voCollCareContext = new CareContextVoCollection();
		CareContextVo voCareContext = new CareContextVo();

		voCareContext.setContext(ContextType.EMERGENCY_FIRST_VISIT);
		voCareContext.setStartDateTime(form.dtimArrival().getValue());
		voCareContext.setEpisodeOfCare(voEpisodeOfCare);
		voCollCareContext.add(voCareContext);

		form.getLocalContext().setcareContextToSave(voCareContext);

		return voCollCareContext;
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearControls();
		form.setMode(FormMode.VIEW);
	}

	private void updateControlsState()
	{
		form.btnNew().setVisible(form.getMode().equals(FormMode.VIEW) && getLocation() != null);
		form.btnNew().setEnabled(form.getMode().equals(FormMode.VIEW));
		
		//WDEV-15959
		form.txtSurname().setEnabled(form.getMode().equals(FormMode.EDIT));
		form.txtForename().setEnabled(form.getMode().equals(FormMode.EDIT));
		form.pdtDOB().setEnabled(form.getMode().equals(FormMode.EDIT));
		form.cmbGender().setEnabled(form.getMode().equals(FormMode.EDIT));

		if (form.getMode().equals(FormMode.EDIT))
		{
			//WDEV-15959
			form.btnPatSearch().setVisible(form.cmbRegistrationType().getValue() != null &&  !QuickRegistrationType.MAJ_INCIDENT.equals(form.cmbRegistrationType().getValue()) &&  !QuickRegistrationType.UNC_UNK_PATIENT.equals(form.cmbRegistrationType().getValue())); //wdev-17136
			// WDEV-17543 - Addition of comments is only allowed for Expected Arrivals
			form.txtComments().setEnabled(QuickRegistrationType.EXP_ARRIVAL.equals(form.cmbRegistrationType().getValue()));
		}
	}

	private void clearControls()
	{
		form.cmbRegistrationType().setValue(null);//WDEV-15959
		form.txtSurname().setValue(null);
		form.txtForename().setValue(null);
		form.cmbGender().setValue(null);
		form.pdtDOB().setValue(null);
		form.cmbSourceOfReferral().setValue(null);
		form.dtimInjury().setValue(null);
		form.dtimArrival().setValue(null);
		form.txtComments().setValue(null);			//wdev-17463
	}

	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearControls();
		form.cmbRegistrationType().setValue(QuickRegistrationType.QUICK_REG);
		form.dtimArrival().setValue(new DateTime());
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (formName.equals(form.getForms().Emergency.SendToAreaDialog) && result.equals(DialogResult.OK))
		{
			if (save())
			{
				form.setMode(FormMode.VIEW);
				engine.open(form.getForms().Core.PrintReport);//WDEV-17428
			}
		}
		//WDEV-15958
		else if (formName.equals(form.getForms().Emergency.QuickRegistrationPatientSearchDialog))
		{
			if (result.equals(DialogResult.OK) && form.getGlobalContext().Emergency.getSelectedPatient() != null)
			{
				//WDEV-16556
				if (domain.checkIsAlreadyAdmitted(form.getGlobalContext().Emergency.getSelectedPatient().getID_Patient()))
				{
					engine.showMessage("Selected Patient is already an Inpatient.");
					// WDEV-17608
					resetScreen();
					updateControlsState();
					
					//WDEV-17588 clear the ExcludeDeceasedPatients as the GC is persistent and may affect other forms
					if (form.getGlobalContext().Core.getPatientFilter() != null)
						form.getGlobalContext().Core.getPatientFilter().setExcludeDeceasedPatients(Boolean.FALSE);
					
					return;
				}

				populateAndDisablePatientDetailsControls(form.getGlobalContext().Emergency.getSelectedPatient());
				disablePatientDetailsControls(true);
			}

			//WDEV-17588 clear the ExcludeDeceasedPatients as the GC is persistent and may affect other forms
			if (form.getGlobalContext().Core.getPatientFilter() != null)
				form.getGlobalContext().Core.getPatientFilter().setExcludeDeceasedPatients(Boolean.FALSE);
		}
	}

	//WDEV-17608
	private void resetScreen()
	{
		form.txtSurname().setValue(null);
		form.txtForename().setValue(null);
		form.cmbGender().setValue(null);
		form.pdtDOB().setValue(null);
		form.cmbSourceOfReferral().setValue(null);
		form.dtimInjury().setValue(null);
		form.dtimArrival().setValue(new DateTime());
		form.txtComments().setValue(null);
		form.getGlobalContext().Emergency.setSelectedPatient(null);//WDEV-17570
	}

	//WDEV-15958
	private void populateAndDisablePatientDetailsControls(PatientShort patient)
	{
		if (patient==null)
			return;
		
		form.txtSurname().setValue(patient.getNameIsNotNull() && patient.getName().getSurnameIsNotNull()? patient.getName().getSurname() :null);
		form.txtForename().setValue(patient.getNameIsNotNull() && patient.getName().getForenameIsNotNull() ? patient.getName().getForename() :null);
		form.pdtDOB().setValue(patient.getDobIsNotNull() ? patient.getDob() :null);
		form.cmbGender().setValue(patient.getSexIsNotNull() ? patient.getSex() :null);
	}
	
	//WDEV-15958
	private void disablePatientDetailsControls(boolean value)
	{
		form.txtSurname().setEnabled(!value);
		form.txtForename().setEnabled(!value);
		form.pdtDOB().setEnabled(!value);
		form.cmbGender().setEnabled(!value);
	}

	private boolean save()
	{		
		TrackingForQuickRegistrationVo tracking = null;
		//wdev-17110
		if( form.getLocalContext().getpatientToSaveIsNotNull())
		{
			//wdev-17293
			if (form.getGlobalContext().Emergency.getSelectedPatient() == null)
				form.getLocalContext().getpatientToSave().setIsQuickRegistrationPatient(Boolean.TRUE);
			else
				form.getLocalContext().getpatientToSave().setIsQuickRegistrationPatient(Boolean.FALSE);
			
			PatientLiteVo patient = form.getLocalContext().getpatientToSave();
			String[] patientErrors = patient.validate();
			if (patientErrors != null && patientErrors.length > 0)
			{
				engine.showErrors(patientErrors);
				return false;
			}
		}
		//--------------
		
		if (!QuickRegistrationType.EXP_ARRIVAL.equals(form.cmbRegistrationType().getValue()))//WDEV-15959
		{

			tracking = populateTracking();

			String[] trackingErrors = tracking.validate();
			if (trackingErrors != null && trackingErrors.length > 0)
			{
				engine.showErrors(trackingErrors);
				return false;
			}
		}

		try
		{
			domain.save(form.getLocalContext().getpatientToSave(), form.getLocalContext().getcareSpellToSave(), form.getLocalContext().getemergencyEpisodeToSave(), tracking, form.getLocalContext().getcareContextToSave(), form.getLocalContext().getemergencyAttendanceToSave());
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return false;
		}

		form.getGlobalContext().Emergency.setSelectedPatient(null);

		return true;
	}

	//WDEV-15958
	protected void onBtnPatSearchClick() throws PresentationLogicException
	{
		form.getGlobalContext().Emergency.setSelectedPatient(null);
		engine.open(form.getForms().Emergency.QuickRegistrationPatientSearchDialog);
		form.getGlobalContext().Core.setPatientFilter(populatePatientFilter());
	}

	private PatientFilter populatePatientFilter()
	{
		PatientFilter patFilter = new PatientFilter();
		patFilter.setSurname(form.txtSurname().getValue());
		patFilter.setForename(form.txtForename().getValue());
		patFilter.setSex(form.cmbGender().getValue());
		patFilter.setDob(form.pdtDOB().getValue());
		patFilter.setExcludeDeceasedPatients(Boolean.TRUE);//WDEV-17588
		
		return patFilter;
	}

	//wdev-17037
	protected void onCmbRegistrationTypeValueChanged() throws PresentationLogicException 
	{
		resetScreen();
		updateControlsState();
	}
}
