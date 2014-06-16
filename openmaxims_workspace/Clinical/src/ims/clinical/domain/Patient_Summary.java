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

package ims.clinical.domain;

// Generated from form domain impl
public interface Patient_Summary extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.CareSpellVoCollection listCareSpellsByPatient(ims.core.patient.vo.PatientRefVo patientRefVo);

	// Generated from form domain interface definition
	/**
	* listProcedureByClinicalContact
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProcedureByClinicalContact(ims.core.admin.vo.ClinicalContactRefVo clinicalContactRefVo);

	// Generated from form domain interface definition
	/**
	* listProcedureByPatient
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProcedureByPatient(ims.core.patient.vo.PatientRefVo patientRefVo);

	// Generated from form domain interface definition
	/**
	* listByClinicalContact
	*/
	public ims.core.vo.PatientProblemVoCollection listProblemsByClinicalContact(ims.core.admin.vo.ClinicalContactRefVo clinicalcontact);

	// Generated from form domain interface definition
	/**
	* listByPatient
	*/
	public ims.core.vo.PatientProblemVoCollection listProblemsByPatient(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	/**
	* List all Patient Complications
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listPatientComplications(ims.core.patient.vo.PatientRefVo patrefvo);

	// Generated from form domain interface definition
	/**
	* List all Patient Diagnoses
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listPatientDiagnoses(ims.core.patient.vo.PatientRefVo patrefvo);

	// Generated from form domain interface definition
	/**
	* List all Complications for a Contact
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listContactComplications(ims.core.admin.vo.ClinicalContactRefVo clinicalcontactrefVo);

	// Generated from form domain interface definition
	/**
	* List Diagnoses for a contact
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listContactDiagnoses(ims.core.admin.vo.ClinicalContactRefVo clinicalcontactrefVo);

	// Generated from form domain interface definition
	/**
	* Retrieves a list of Diagnosis / COmplication records for Clinical contact
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listDiagnosisComplicationsContact(ims.core.admin.vo.ClinicalContactRefVo clinicalcontactrefVo);

	// Generated from form domain interface definition
	/**
	* List all Diagnosis Complications for a Patient
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listDiagnosisComplicationsPatient(ims.core.patient.vo.PatientRefVo patrefVo);

	// Generated from form domain interface definition
	public ims.clinical.vo.ClinicalDIAssociationVoCollection listClinicalDiAssociationByPatientDiagnosis(ims.core.clinical.vo.PatientDiagnosisRefVo voRefPatDiag);

	// Generated from form domain interface definition
	public ims.clinical.vo.ClinicalDIAssociationVoCollection listClinicalDiAssociationByPatientProcedure(ims.core.clinical.vo.PatientProcedureRefVo voRefPatProc);

	// Generated from form domain interface definition
	public ims.clinical.vo.ClinicalDIAssociationVoCollection listClinicalDiAssociationByPatientProblem(ims.core.clinical.vo.PatientProblemRefVo voRefPatProb);

	// Generated from form domain interface definition
	/**
	* listCareContextComplications
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listCareContextComplications(ims.core.admin.vo.CareContextRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* listCareContextDiagnoses
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listCareContextDiagnoses(ims.core.admin.vo.CareContextRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* listEpisodeOfCareComplications
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listEpisodeOfCareComplications(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo);

	// Generated from form domain interface definition
	/**
	* listEpisodeOfCareDiagnoses
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listEpisodeOfCareDiagnoses(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo);

	// Generated from form domain interface definition
	/**
	* listProblemsByCareContext
	*/
	public ims.core.vo.PatientProblemVoCollection listProblemsByCareContext(ims.core.admin.vo.CareContextRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* listProblemsByEpisodeOfCare
	*/
	public ims.core.vo.PatientProblemVoCollection listProblemsByEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo);

	// Generated from form domain interface definition
	/**
	* Diagnosis / Complications for a Care Context
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listDiagnosisComplicationsCareContext(ims.core.admin.vo.CareContextRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* listDiagnosisComplicationEpisodeOfCare
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listDiagnosisComplicationEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo);

	// Generated from form domain interface definition
	/**
	* listDiagnosisComplicationCareSpell
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listDiagnosisComplicationCareSpell(ims.core.admin.vo.CareSpellRefVo careSpellRefVo);

	// Generated from form domain interface definition
	/**
	* listCareSpellDiagnoses
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listCareSpellDiagnoses(ims.core.admin.vo.CareSpellRefVo careSpellRefVo);

	// Generated from form domain interface definition
	/**
	* listCareSpellComplications
	*/
	public ims.core.vo.PatientDiagnosisShortVoCollection listCareSpellComplications(ims.core.admin.vo.CareSpellRefVo careSpellRefVo);

	// Generated from form domain interface definition
	/**
	* listProceduresByEpisodeOfCare
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProceduresByEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo);

	// Generated from form domain interface definition
	/**
	* listProceduresByCareSpell
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProceduresByCareSpell(ims.core.admin.vo.CareSpellRefVo careSpellRefVo);

	// Generated from form domain interface definition
	/**
	* listProceduresByCareContextPatientSummary
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProceduresByCareContextPatientSummary(ims.core.admin.vo.CareContextRefVo careContextRefVo);

	// Generated from form domain interface definition
	/**
	* listProblemsByCareSpell
	*/
	public ims.core.vo.PatientProblemVoCollection listProblemsByCareSpell(ims.core.admin.vo.CareSpellRefVo careSpellRefVo);

	// Generated from form domain interface definition
	public ims.core.vo.ClinicalContactShortVoCollection listClinicalContacts(ims.core.vo.ClinicalContactFilterVo filter, Boolean bOnlyRootClinicalContacts);

	// Generated from form domain interface definition
	public ims.core.vo.ClinicalContactShortVoCollection listClinicalContactsShort(ims.core.vo.PatientShort voPatientShort, ims.core.vo.ClinicalContactFilterVo voClinicalContactFilter, Boolean bOnlyRootClinicalContacts);

	// Generated from form domain interface definition
	/**
	* list Procedure by Patient and Status
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProcedureByPatientAndStatus(ims.core.patient.vo.PatientRefVo patientRefVo, ims.core.vo.lookups.PatientProcedureStatus status);

	// Generated from form domain interface definition
	/**
	* listProcedureByClinalContactAndStatus
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProcedureByClinicalContactAndStatus(ims.core.admin.vo.ClinicalContactRefVo clinicalContactRefVo, ims.core.vo.lookups.PatientProcedureStatus status);

	// Generated from form domain interface definition
	/**
	* listProceduresByCareContextPatientSummaryAndStatus
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProceduresByCareContextPatientSummaryAndStatus(ims.core.admin.vo.CareContextRefVo careContextRefVo, ims.core.vo.lookups.PatientProcedureStatus status);

	// Generated from form domain interface definition
	/**
	* listProceduresByEpisodeOfCareAndStatus
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProceduresByEpisodeOfCareAndStatus(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCareRefVo, ims.core.vo.lookups.PatientProcedureStatus status);

	// Generated from form domain interface definition
	/**
	* listProceduresByCareSpell
	*/
	public ims.core.vo.PatientProcedureShortVoCollection listProceduresByCareSpellAndStatus(ims.core.admin.vo.CareSpellRefVo careSpellRefVo, ims.core.vo.lookups.PatientProcedureStatus status);

	// Generated from form domain interface definition
	/**
	* get the primary Diagnosis and Procedures
	*/
	public ims.clinical.vo.CSPrimaryDiagnosisAndPoceduresVo listPrimaryDiagnosisAndProblems(ims.core.admin.vo.CareSpellRefVo careSpellRefVo);

	// Generated from form domain interface definition
	/**
	* getClinicalNotesForContact
	*/
	public ims.core.vo.ClinicalNotesVo getClinicalNotesForContact(ims.core.admin.vo.ClinicalContactRefVo clinicalContactRefId);

	// Generated from form domain interface definition
	/**
	* getClinicalNote
	*/
	public ims.core.vo.ClinicalNotesVo getClinicalNote(ims.core.clinical.vo.ClinicalNotesRefVo clinicalNoteRefVo);

	// Generated from form domain interface definition
	/**
	* getClinicalNotesShort
	*/
	public ims.core.vo.ClinicalNotesShortVo getClinicalNotesShort(Integer id);

	// Generated from form domain interface definition
	/**
	* This method will record a read audit for the patient passed
	*/
	public void recordReadAudit(ims.core.patient.vo.PatientRefVo patient) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.admin.pas.vo.PASEventRefVo getPASEvent(String eventID);

	// Generated from form domain interface definition
	public ims.core.vo.lookups.WorklistContactType getWorklistContactTypeByExternalCode(ims.core.vo.lookups.ContactType contactType);

	// Generated from form domain interface definition
	/**
	* WDEV-11661
	* Retrieves the service configured for the specialty of the Episode of Care.
	*/
	public ims.core.clinical.vo.ServiceRefVo getServiceForEpisodeOfCareSpecialty(ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCare);

	// Generated from form domain interface definition
	public ims.core.vo.CareSpellVoCollection listCareSpellsByPatientAndCriteria(ims.core.patient.vo.PatientRefVo patientRef, ims.framework.utils.Date dateFrom, ims.framework.utils.Date dateTo, Integer context, Boolean showCancelled);

	// Generated from form domain interface definition
	public ims.core.vo.CareSpellVo getCareSpellById(ims.core.admin.vo.CareSpellRefVo careSpellRef);

	// Generated from form domain interface definition
	public ims.core.vo.EpisodeofCareShortVo getEpisodeOfCareShort(ims.core.admin.vo.EpisodeOfCareRefVo episodeRef);

	// Generated from form domain interface definition
	public ims.core.vo.CareContextVo saveCareContext(ims.core.vo.CareContextVo careContext) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.ClinicalContactShortVo saveClinicalContact(ims.core.vo.ClinicalContactShortVo clinicalContact) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.admin.vo.CareContextRefVoCollection getCareContextThatHasHistoryId(ims.core.admin.vo.CareContextRefVoCollection refVoColl);

	// Generated from form domain interface definition
	public ims.core.admin.vo.EpisodeOfCareRefVoCollection getEpisodeOfCareIdThatHasHistory(ims.core.admin.vo.EpisodeOfCareRefVoCollection refVoColl);

	// Generated from form domain interface definition
	public ims.core.vo.EpisodeOfCareSmallVo getEpisodeOfCareWithHistory(ims.core.admin.vo.EpisodeOfCareRefVo refVo);

	// Generated from form domain interface definition
	public ims.core.vo.CareContextSmallVo getCareContextWithHistory(ims.core.admin.vo.CareContextRefVo refVo);

	// Generated from form domain interface definition
	public ims.core.vo.CareSpellVo saveCareSpell(ims.core.vo.CareSpellVo careSpell) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.EpisodeofCareVo saveEpisodeOfCare(ims.core.vo.EpisodeofCareVo episodeOfCare) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.CareContextVo getCareContextById(ims.core.admin.vo.CareContextRefVo careRef);

	// Generated from form domain interface definition
	public ims.core.vo.EpisodeofCareVo getEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo episodeRef);

	// Generated from form domain interface definition
	public String getPIDDiagnosisInfo(ims.core.admin.vo.CareContextRefVo careContextRefVo, ims.core.admin.vo.EpisodeOfCareRefVo episodeRefVo, ims.core.admin.vo.CareSpellRefVo careSpell);

	// Generated from form domain interface definition
	public Boolean hasActiveClinicalContacts(ims.core.admin.vo.CareContextRefVo careContext);

	// Generated from form domain interface definition
	public Boolean hasActiveCareContexts(ims.core.admin.vo.EpisodeOfCareRefVo episode);

	// Generated from form domain interface definition
	public Boolean hasActiveEpisodeOfCare(ims.core.admin.vo.CareSpellRefVo careSpell);
}
