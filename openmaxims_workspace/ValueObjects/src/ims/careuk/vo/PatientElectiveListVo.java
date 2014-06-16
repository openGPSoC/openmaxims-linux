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

package ims.careuk.vo;

/**
 * Linked to CAREUK.PatientElectiveList business object (ID: 1014100020).
 */
public class PatientElectiveListVo extends ims.careuk.vo.PatientElectiveListRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientElectiveListVo()
	{
	}
	public PatientElectiveListVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientElectiveListVo(ims.careuk.vo.beans.PatientElectiveListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.electivelist = bean.getElectiveList() == null ? null : bean.getElectiveList().buildVo();
		this.electiveliststatus = bean.getElectiveListStatus() == null ? null : bean.getElectiveListStatus().buildVo();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.referral = bean.getReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getReferral().getId()), bean.getReferral().getVersion());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo();
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo();
		this.dateonlist = bean.getDateOnList() == null ? null : bean.getDateOnList().buildDate();
		this.originaldecisiondate = bean.getOriginalDecisionDate() == null ? null : bean.getOriginalDecisionDate().buildDate();
		this.intendedmanagement = bean.getIntendedManagement() == null ? null : ims.core.vo.lookups.ManagementIntention.buildLookup(bean.getIntendedManagement());
		this.anticipatedstay = bean.getAnticipatedStay();
		this.priority = bean.getPriority() == null ? null : ims.careuk.vo.lookups.ReferralUrgency.buildLookup(bean.getPriority());
		this.suspensions = ims.careuk.vo.SuspensionDetailsForPatientElectiveListVoCollection.buildFromBeanCollection(bean.getSuspensions());
		this.operativeprocedurestatus = bean.getOperativeProcedureStatus();
		this.primaryprocedure = bean.getPrimaryProcedure() == null ? null : bean.getPrimaryProcedure().buildVo();
		this.otherprocedures = ims.core.vo.ProcedureLiteVoCollection.buildFromBeanCollection(bean.getOtherProcedures());
		this.tcihistory = ims.careuk.vo.PatientElectiveListElectiveTCIVoCollection.buildFromBeanCollection(bean.getTCIHistory());
		this.interpretatorrequired = bean.getInterpretatorRequired();
		this.transport = bean.getTransport() == null ? null : ims.scheduling.vo.lookups.ApptTransportType.buildLookup(bean.getTransport());
		this.notes = ims.careuk.vo.PatientElectiveListNotesVoCollection.buildFromBeanCollection(bean.getNotes());
		this.electiveadmissiontype = bean.getElectiveAdmissionType() == null ? null : ims.careuk.vo.lookups.ElectiveAdmissionType.buildLookup(bean.getElectiveAdmissionType());
		this.erod = bean.getEROD() == null ? null : new ims.careuk.vo.ReferralERODRefVo(new Integer(bean.getEROD().getId()), bean.getEROD().getVersion());
		this.tcidetails = bean.getTCIDetails() == null ? null : bean.getTCIDetails().buildVo();
		this.electiveliststatushistory = ims.careuk.vo.ElectiveListStatusVoCollection.buildFromBeanCollection(bean.getElectiveListStatusHistory());
		this.electivelistreason = bean.getElectiveListReason() == null ? null : ims.emergency.vo.lookups.ElectiveListReason.buildLookup(bean.getElectiveListReason());
		this.pathwayclock = bean.getPathwayClock() == null ? null : new ims.pathways.vo.PathwayClockRefVo(new Integer(bean.getPathwayClock().getId()), bean.getPathwayClock().getVersion());
		if(bean.getERODHistory() != null)
		{
			this.erodhistory = new ims.careuk.vo.ReferralERODRefVoCollection();
			for(int erodhistory_i = 0; erodhistory_i < bean.getERODHistory().length; erodhistory_i++)
			{
				this.erodhistory.add(new ims.careuk.vo.ReferralERODRefVo(new Integer(bean.getERODHistory()[erodhistory_i].getId()), bean.getERODHistory()[erodhistory_i].getVersion()));
			}
		}
		this.tcicancelledbyprovider = bean.getTCICancelledByProvider();
		this.bed = bean.getBed();
		this.transportrequired = bean.getTransportRequired();
		this.proceduredescription = bean.getProcedureDescription();
		this.language = bean.getLanguage() == null ? null : ims.core.vo.lookups.Language.buildLookup(bean.getLanguage());
		this.canbeused = bean.getCanBeUsed();
		this.patientstatus = bean.getPatientStatus() == null ? null : ims.careuk.vo.lookups.CatsReferralCategory.buildLookup(bean.getPatientStatus());
		this.requirestciby = bean.getRequiresTCIBy() == null ? null : bean.getRequiresTCIBy().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.PatientElectiveListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.electivelist = bean.getElectiveList() == null ? null : bean.getElectiveList().buildVo(map);
		this.electiveliststatus = bean.getElectiveListStatus() == null ? null : bean.getElectiveListStatus().buildVo(map);
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.referral = bean.getReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getReferral().getId()), bean.getReferral().getVersion());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo(map);
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo(map);
		this.dateonlist = bean.getDateOnList() == null ? null : bean.getDateOnList().buildDate();
		this.originaldecisiondate = bean.getOriginalDecisionDate() == null ? null : bean.getOriginalDecisionDate().buildDate();
		this.intendedmanagement = bean.getIntendedManagement() == null ? null : ims.core.vo.lookups.ManagementIntention.buildLookup(bean.getIntendedManagement());
		this.anticipatedstay = bean.getAnticipatedStay();
		this.priority = bean.getPriority() == null ? null : ims.careuk.vo.lookups.ReferralUrgency.buildLookup(bean.getPriority());
		this.suspensions = ims.careuk.vo.SuspensionDetailsForPatientElectiveListVoCollection.buildFromBeanCollection(bean.getSuspensions());
		this.operativeprocedurestatus = bean.getOperativeProcedureStatus();
		this.primaryprocedure = bean.getPrimaryProcedure() == null ? null : bean.getPrimaryProcedure().buildVo(map);
		this.otherprocedures = ims.core.vo.ProcedureLiteVoCollection.buildFromBeanCollection(bean.getOtherProcedures());
		this.tcihistory = ims.careuk.vo.PatientElectiveListElectiveTCIVoCollection.buildFromBeanCollection(bean.getTCIHistory());
		this.interpretatorrequired = bean.getInterpretatorRequired();
		this.transport = bean.getTransport() == null ? null : ims.scheduling.vo.lookups.ApptTransportType.buildLookup(bean.getTransport());
		this.notes = ims.careuk.vo.PatientElectiveListNotesVoCollection.buildFromBeanCollection(bean.getNotes());
		this.electiveadmissiontype = bean.getElectiveAdmissionType() == null ? null : ims.careuk.vo.lookups.ElectiveAdmissionType.buildLookup(bean.getElectiveAdmissionType());
		this.erod = bean.getEROD() == null ? null : new ims.careuk.vo.ReferralERODRefVo(new Integer(bean.getEROD().getId()), bean.getEROD().getVersion());
		this.tcidetails = bean.getTCIDetails() == null ? null : bean.getTCIDetails().buildVo(map);
		this.electiveliststatushistory = ims.careuk.vo.ElectiveListStatusVoCollection.buildFromBeanCollection(bean.getElectiveListStatusHistory());
		this.electivelistreason = bean.getElectiveListReason() == null ? null : ims.emergency.vo.lookups.ElectiveListReason.buildLookup(bean.getElectiveListReason());
		this.pathwayclock = bean.getPathwayClock() == null ? null : new ims.pathways.vo.PathwayClockRefVo(new Integer(bean.getPathwayClock().getId()), bean.getPathwayClock().getVersion());
		if(bean.getERODHistory() != null)
		{
			this.erodhistory = new ims.careuk.vo.ReferralERODRefVoCollection();
			for(int erodhistory_i = 0; erodhistory_i < bean.getERODHistory().length; erodhistory_i++)
			{
				this.erodhistory.add(new ims.careuk.vo.ReferralERODRefVo(new Integer(bean.getERODHistory()[erodhistory_i].getId()), bean.getERODHistory()[erodhistory_i].getVersion()));
			}
		}
		this.tcicancelledbyprovider = bean.getTCICancelledByProvider();
		this.bed = bean.getBed();
		this.transportrequired = bean.getTransportRequired();
		this.proceduredescription = bean.getProcedureDescription();
		this.language = bean.getLanguage() == null ? null : ims.core.vo.lookups.Language.buildLookup(bean.getLanguage());
		this.canbeused = bean.getCanBeUsed();
		this.patientstatus = bean.getPatientStatus() == null ? null : ims.careuk.vo.lookups.CatsReferralCategory.buildLookup(bean.getPatientStatus());
		this.requirestciby = bean.getRequiresTCIBy() == null ? null : bean.getRequiresTCIBy().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.PatientElectiveListVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.PatientElectiveListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.PatientElectiveListVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("ELECTIVELIST"))
			return getElectiveList();
		if(fieldName.equals("ELECTIVELISTSTATUS"))
			return getElectiveListStatus();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("REFERRAL"))
			return getReferral();
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		if(fieldName.equals("WARD"))
			return getWard();
		if(fieldName.equals("CONSULTANT"))
			return getConsultant();
		if(fieldName.equals("DATEONLIST"))
			return getDateOnList();
		if(fieldName.equals("ORIGINALDECISIONDATE"))
			return getOriginalDecisionDate();
		if(fieldName.equals("INTENDEDMANAGEMENT"))
			return getIntendedManagement();
		if(fieldName.equals("ANTICIPATEDSTAY"))
			return getAnticipatedStay();
		if(fieldName.equals("PRIORITY"))
			return getPriority();
		if(fieldName.equals("SUSPENSIONS"))
			return getSuspensions();
		if(fieldName.equals("OPERATIVEPROCEDURESTATUS"))
			return getOperativeProcedureStatus();
		if(fieldName.equals("PRIMARYPROCEDURE"))
			return getPrimaryProcedure();
		if(fieldName.equals("OTHERPROCEDURES"))
			return getOtherProcedures();
		if(fieldName.equals("TCIHISTORY"))
			return getTCIHistory();
		if(fieldName.equals("INTERPRETATORREQUIRED"))
			return getInterpretatorRequired();
		if(fieldName.equals("TRANSPORT"))
			return getTransport();
		if(fieldName.equals("NOTES"))
			return getNotes();
		if(fieldName.equals("ELECTIVEADMISSIONTYPE"))
			return getElectiveAdmissionType();
		if(fieldName.equals("EROD"))
			return getEROD();
		if(fieldName.equals("TCIDETAILS"))
			return getTCIDetails();
		if(fieldName.equals("ELECTIVELISTSTATUSHISTORY"))
			return getElectiveListStatusHistory();
		if(fieldName.equals("ELECTIVELISTREASON"))
			return getElectiveListReason();
		if(fieldName.equals("PATHWAYCLOCK"))
			return getPathwayClock();
		if(fieldName.equals("ERODHISTORY"))
			return getERODHistory();
		if(fieldName.equals("TCICANCELLEDBYPROVIDER"))
			return getTCICancelledByProvider();
		if(fieldName.equals("BED"))
			return getBed();
		if(fieldName.equals("TRANSPORTREQUIRED"))
			return getTransportRequired();
		if(fieldName.equals("PROCEDUREDESCRIPTION"))
			return getProcedureDescription();
		if(fieldName.equals("LANGUAGE"))
			return getLanguage();
		if(fieldName.equals("CANBEUSED"))
			return getCanBeUsed();
		if(fieldName.equals("PATIENTSTATUS"))
			return getPatientStatus();
		if(fieldName.equals("REQUIRESTCIBY"))
			return getRequiresTCIBy();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getElectiveListIsNotNull()
	{
		return this.electivelist != null;
	}
	public ims.admin.vo.ElectiveListConfigurationVo getElectiveList()
	{
		return this.electivelist;
	}
	public void setElectiveList(ims.admin.vo.ElectiveListConfigurationVo value)
	{
		this.isValidated = false;
		this.electivelist = value;
	}
	public boolean getElectiveListStatusIsNotNull()
	{
		return this.electiveliststatus != null;
	}
	public ims.careuk.vo.ElectiveListStatusVo getElectiveListStatus()
	{
		return this.electiveliststatus;
	}
	public void setElectiveListStatus(ims.careuk.vo.ElectiveListStatusVo value)
	{
		this.isValidated = false;
		this.electiveliststatus = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getReferralIsNotNull()
	{
		return this.referral != null;
	}
	public ims.careuk.vo.CatsReferralRefVo getReferral()
	{
		return this.referral;
	}
	public void setReferral(ims.careuk.vo.CatsReferralRefVo value)
	{
		this.isValidated = false;
		this.referral = value;
	}
	public boolean getEpisodeOfCareIsNotNull()
	{
		return this.episodeofcare != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episodeofcare = value;
	}
	public boolean getWardIsNotNull()
	{
		return this.ward != null;
	}
	public ims.core.vo.LocationLiteVo getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.ward = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.vo.HcpMinVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.HcpMinVo value)
	{
		this.isValidated = false;
		this.consultant = value;
	}
	public boolean getDateOnListIsNotNull()
	{
		return this.dateonlist != null;
	}
	public ims.framework.utils.Date getDateOnList()
	{
		return this.dateonlist;
	}
	public void setDateOnList(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateonlist = value;
	}
	public boolean getOriginalDecisionDateIsNotNull()
	{
		return this.originaldecisiondate != null;
	}
	public ims.framework.utils.Date getOriginalDecisionDate()
	{
		return this.originaldecisiondate;
	}
	public void setOriginalDecisionDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.originaldecisiondate = value;
	}
	public boolean getIntendedManagementIsNotNull()
	{
		return this.intendedmanagement != null;
	}
	public ims.core.vo.lookups.ManagementIntention getIntendedManagement()
	{
		return this.intendedmanagement;
	}
	public void setIntendedManagement(ims.core.vo.lookups.ManagementIntention value)
	{
		this.isValidated = false;
		this.intendedmanagement = value;
	}
	public boolean getAnticipatedStayIsNotNull()
	{
		return this.anticipatedstay != null;
	}
	public Integer getAnticipatedStay()
	{
		return this.anticipatedstay;
	}
	public void setAnticipatedStay(Integer value)
	{
		this.isValidated = false;
		this.anticipatedstay = value;
	}
	public boolean getPriorityIsNotNull()
	{
		return this.priority != null;
	}
	public ims.careuk.vo.lookups.ReferralUrgency getPriority()
	{
		return this.priority;
	}
	public void setPriority(ims.careuk.vo.lookups.ReferralUrgency value)
	{
		this.isValidated = false;
		this.priority = value;
	}
	public boolean getSuspensionsIsNotNull()
	{
		return this.suspensions != null;
	}
	public ims.careuk.vo.SuspensionDetailsForPatientElectiveListVoCollection getSuspensions()
	{
		return this.suspensions;
	}
	public void setSuspensions(ims.careuk.vo.SuspensionDetailsForPatientElectiveListVoCollection value)
	{
		this.isValidated = false;
		this.suspensions = value;
	}
	public boolean getOperativeProcedureStatusIsNotNull()
	{
		return this.operativeprocedurestatus != null;
	}
	public Boolean getOperativeProcedureStatus()
	{
		return this.operativeprocedurestatus;
	}
	public void setOperativeProcedureStatus(Boolean value)
	{
		this.isValidated = false;
		this.operativeprocedurestatus = value;
	}
	public boolean getPrimaryProcedureIsNotNull()
	{
		return this.primaryprocedure != null;
	}
	public ims.core.vo.ProcedureLiteVo getPrimaryProcedure()
	{
		return this.primaryprocedure;
	}
	public void setPrimaryProcedure(ims.core.vo.ProcedureLiteVo value)
	{
		this.isValidated = false;
		this.primaryprocedure = value;
	}
	public boolean getOtherProceduresIsNotNull()
	{
		return this.otherprocedures != null;
	}
	public ims.core.vo.ProcedureLiteVoCollection getOtherProcedures()
	{
		return this.otherprocedures;
	}
	public void setOtherProcedures(ims.core.vo.ProcedureLiteVoCollection value)
	{
		this.isValidated = false;
		this.otherprocedures = value;
	}
	public boolean getTCIHistoryIsNotNull()
	{
		return this.tcihistory != null;
	}
	public ims.careuk.vo.PatientElectiveListElectiveTCIVoCollection getTCIHistory()
	{
		return this.tcihistory;
	}
	public void setTCIHistory(ims.careuk.vo.PatientElectiveListElectiveTCIVoCollection value)
	{
		this.isValidated = false;
		this.tcihistory = value;
	}
	public boolean getInterpretatorRequiredIsNotNull()
	{
		return this.interpretatorrequired != null;
	}
	public Boolean getInterpretatorRequired()
	{
		return this.interpretatorrequired;
	}
	public void setInterpretatorRequired(Boolean value)
	{
		this.isValidated = false;
		this.interpretatorrequired = value;
	}
	public boolean getTransportIsNotNull()
	{
		return this.transport != null;
	}
	public ims.scheduling.vo.lookups.ApptTransportType getTransport()
	{
		return this.transport;
	}
	public void setTransport(ims.scheduling.vo.lookups.ApptTransportType value)
	{
		this.isValidated = false;
		this.transport = value;
	}
	public boolean getNotesIsNotNull()
	{
		return this.notes != null;
	}
	public ims.careuk.vo.PatientElectiveListNotesVoCollection getNotes()
	{
		return this.notes;
	}
	public void setNotes(ims.careuk.vo.PatientElectiveListNotesVoCollection value)
	{
		this.isValidated = false;
		this.notes = value;
	}
	public boolean getElectiveAdmissionTypeIsNotNull()
	{
		return this.electiveadmissiontype != null;
	}
	public ims.careuk.vo.lookups.ElectiveAdmissionType getElectiveAdmissionType()
	{
		return this.electiveadmissiontype;
	}
	public void setElectiveAdmissionType(ims.careuk.vo.lookups.ElectiveAdmissionType value)
	{
		this.isValidated = false;
		this.electiveadmissiontype = value;
	}
	public boolean getERODIsNotNull()
	{
		return this.erod != null;
	}
	public ims.careuk.vo.ReferralERODRefVo getEROD()
	{
		return this.erod;
	}
	public void setEROD(ims.careuk.vo.ReferralERODRefVo value)
	{
		this.isValidated = false;
		this.erod = value;
	}
	public boolean getTCIDetailsIsNotNull()
	{
		return this.tcidetails != null;
	}
	public ims.careuk.vo.PatientElectiveListElectiveTCIVo getTCIDetails()
	{
		return this.tcidetails;
	}
	public void setTCIDetails(ims.careuk.vo.PatientElectiveListElectiveTCIVo value)
	{
		this.isValidated = false;
		this.tcidetails = value;
	}
	public boolean getElectiveListStatusHistoryIsNotNull()
	{
		return this.electiveliststatushistory != null;
	}
	public ims.careuk.vo.ElectiveListStatusVoCollection getElectiveListStatusHistory()
	{
		return this.electiveliststatushistory;
	}
	public void setElectiveListStatusHistory(ims.careuk.vo.ElectiveListStatusVoCollection value)
	{
		this.isValidated = false;
		this.electiveliststatushistory = value;
	}
	public boolean getElectiveListReasonIsNotNull()
	{
		return this.electivelistreason != null;
	}
	public ims.emergency.vo.lookups.ElectiveListReason getElectiveListReason()
	{
		return this.electivelistreason;
	}
	public void setElectiveListReason(ims.emergency.vo.lookups.ElectiveListReason value)
	{
		this.isValidated = false;
		this.electivelistreason = value;
	}
	public boolean getPathwayClockIsNotNull()
	{
		return this.pathwayclock != null;
	}
	public ims.pathways.vo.PathwayClockRefVo getPathwayClock()
	{
		return this.pathwayclock;
	}
	public void setPathwayClock(ims.pathways.vo.PathwayClockRefVo value)
	{
		this.isValidated = false;
		this.pathwayclock = value;
	}
	public boolean getERODHistoryIsNotNull()
	{
		return this.erodhistory != null;
	}
	public ims.careuk.vo.ReferralERODRefVoCollection getERODHistory()
	{
		return this.erodhistory;
	}
	public void setERODHistory(ims.careuk.vo.ReferralERODRefVoCollection value)
	{
		this.isValidated = false;
		this.erodhistory = value;
	}
	public boolean getTCICancelledByProviderIsNotNull()
	{
		return this.tcicancelledbyprovider != null;
	}
	public Boolean getTCICancelledByProvider()
	{
		return this.tcicancelledbyprovider;
	}
	public void setTCICancelledByProvider(Boolean value)
	{
		this.isValidated = false;
		this.tcicancelledbyprovider = value;
	}
	public boolean getBedIsNotNull()
	{
		return this.bed != null;
	}
	public String getBed()
	{
		return this.bed;
	}
	public static int getBedMaxLength()
	{
		return 50;
	}
	public void setBed(String value)
	{
		this.isValidated = false;
		this.bed = value;
	}
	public boolean getTransportRequiredIsNotNull()
	{
		return this.transportrequired != null;
	}
	public Boolean getTransportRequired()
	{
		return this.transportrequired;
	}
	public void setTransportRequired(Boolean value)
	{
		this.isValidated = false;
		this.transportrequired = value;
	}
	public boolean getProcedureDescriptionIsNotNull()
	{
		return this.proceduredescription != null;
	}
	public String getProcedureDescription()
	{
		return this.proceduredescription;
	}
	public static int getProcedureDescriptionMaxLength()
	{
		return 255;
	}
	public void setProcedureDescription(String value)
	{
		this.isValidated = false;
		this.proceduredescription = value;
	}
	public boolean getLanguageIsNotNull()
	{
		return this.language != null;
	}
	public ims.core.vo.lookups.Language getLanguage()
	{
		return this.language;
	}
	public void setLanguage(ims.core.vo.lookups.Language value)
	{
		this.isValidated = false;
		this.language = value;
	}
	public boolean getCanBeUsedIsNotNull()
	{
		return this.canbeused != null;
	}
	public Boolean getCanBeUsed()
	{
		return this.canbeused;
	}
	public void setCanBeUsed(Boolean value)
	{
		this.isValidated = false;
		this.canbeused = value;
	}
	public boolean getPatientStatusIsNotNull()
	{
		return this.patientstatus != null;
	}
	public ims.careuk.vo.lookups.CatsReferralCategory getPatientStatus()
	{
		return this.patientstatus;
	}
	public void setPatientStatus(ims.careuk.vo.lookups.CatsReferralCategory value)
	{
		this.isValidated = false;
		this.patientstatus = value;
	}
	public boolean getRequiresTCIByIsNotNull()
	{
		return this.requirestciby != null;
	}
	public ims.framework.utils.Date getRequiresTCIBy()
	{
		return this.requirestciby;
	}
	public void setRequiresTCIBy(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.requirestciby = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.electiveliststatus != null)
		{
			if(!this.electiveliststatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.suspensions != null)
		{
			if(!this.suspensions.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.tcihistory != null)
		{
			if(!this.tcihistory.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.notes != null)
		{
			if(!this.notes.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.tcidetails != null)
		{
			if(!this.tcidetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.electiveliststatushistory != null)
		{
			if(!this.electiveliststatushistory.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.electivelist == null)
			listOfErrors.add("ElectiveList is mandatory");
		if(this.electiveliststatus == null)
			listOfErrors.add("ElectiveListStatus is mandatory");
		if(this.electiveliststatus != null)
		{
			String[] listOfOtherErrors = this.electiveliststatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.referral == null)
			listOfErrors.add("Referral is mandatory");
		if(this.dateonlist == null)
			listOfErrors.add("DateOnList is mandatory");
		if(this.suspensions != null)
		{
			String[] listOfOtherErrors = this.suspensions.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.operativeprocedurestatus == null)
			listOfErrors.add("OperativeProcedureStatus is mandatory");
		if(this.tcihistory != null)
		{
			String[] listOfOtherErrors = this.tcihistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.notes != null)
		{
			String[] listOfOtherErrors = this.notes.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.electiveadmissiontype == null)
			listOfErrors.add("ElectiveAdmissionType is mandatory");
		if(this.tcidetails != null)
		{
			String[] listOfOtherErrors = this.tcidetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.electiveliststatushistory != null)
		{
			String[] listOfOtherErrors = this.electiveliststatushistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.electivelistreason == null)
			listOfErrors.add("ElectiveListReason is mandatory");
		if(this.bed != null)
			if(this.bed.length() > 50)
				listOfErrors.add("The length of the field [bed] in the value object [ims.careuk.vo.PatientElectiveListVo] is too big. It should be less or equal to 50");
		if(this.proceduredescription != null)
			if(this.proceduredescription.length() > 255)
				listOfErrors.add("The length of the field [proceduredescription] in the value object [ims.careuk.vo.PatientElectiveListVo] is too big. It should be less or equal to 255");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		PatientElectiveListVo clone = new PatientElectiveListVo(this.id, this.version);
		
		if(this.electivelist == null)
			clone.electivelist = null;
		else
			clone.electivelist = (ims.admin.vo.ElectiveListConfigurationVo)this.electivelist.clone();
		if(this.electiveliststatus == null)
			clone.electiveliststatus = null;
		else
			clone.electiveliststatus = (ims.careuk.vo.ElectiveListStatusVo)this.electiveliststatus.clone();
		clone.patient = this.patient;
		clone.referral = this.referral;
		clone.episodeofcare = this.episodeofcare;
		if(this.ward == null)
			clone.ward = null;
		else
			clone.ward = (ims.core.vo.LocationLiteVo)this.ward.clone();
		if(this.consultant == null)
			clone.consultant = null;
		else
			clone.consultant = (ims.core.vo.HcpMinVo)this.consultant.clone();
		if(this.dateonlist == null)
			clone.dateonlist = null;
		else
			clone.dateonlist = (ims.framework.utils.Date)this.dateonlist.clone();
		if(this.originaldecisiondate == null)
			clone.originaldecisiondate = null;
		else
			clone.originaldecisiondate = (ims.framework.utils.Date)this.originaldecisiondate.clone();
		if(this.intendedmanagement == null)
			clone.intendedmanagement = null;
		else
			clone.intendedmanagement = (ims.core.vo.lookups.ManagementIntention)this.intendedmanagement.clone();
		clone.anticipatedstay = this.anticipatedstay;
		if(this.priority == null)
			clone.priority = null;
		else
			clone.priority = (ims.careuk.vo.lookups.ReferralUrgency)this.priority.clone();
		if(this.suspensions == null)
			clone.suspensions = null;
		else
			clone.suspensions = (ims.careuk.vo.SuspensionDetailsForPatientElectiveListVoCollection)this.suspensions.clone();
		clone.operativeprocedurestatus = this.operativeprocedurestatus;
		if(this.primaryprocedure == null)
			clone.primaryprocedure = null;
		else
			clone.primaryprocedure = (ims.core.vo.ProcedureLiteVo)this.primaryprocedure.clone();
		if(this.otherprocedures == null)
			clone.otherprocedures = null;
		else
			clone.otherprocedures = (ims.core.vo.ProcedureLiteVoCollection)this.otherprocedures.clone();
		if(this.tcihistory == null)
			clone.tcihistory = null;
		else
			clone.tcihistory = (ims.careuk.vo.PatientElectiveListElectiveTCIVoCollection)this.tcihistory.clone();
		clone.interpretatorrequired = this.interpretatorrequired;
		if(this.transport == null)
			clone.transport = null;
		else
			clone.transport = (ims.scheduling.vo.lookups.ApptTransportType)this.transport.clone();
		if(this.notes == null)
			clone.notes = null;
		else
			clone.notes = (ims.careuk.vo.PatientElectiveListNotesVoCollection)this.notes.clone();
		if(this.electiveadmissiontype == null)
			clone.electiveadmissiontype = null;
		else
			clone.electiveadmissiontype = (ims.careuk.vo.lookups.ElectiveAdmissionType)this.electiveadmissiontype.clone();
		clone.erod = this.erod;
		if(this.tcidetails == null)
			clone.tcidetails = null;
		else
			clone.tcidetails = (ims.careuk.vo.PatientElectiveListElectiveTCIVo)this.tcidetails.clone();
		if(this.electiveliststatushistory == null)
			clone.electiveliststatushistory = null;
		else
			clone.electiveliststatushistory = (ims.careuk.vo.ElectiveListStatusVoCollection)this.electiveliststatushistory.clone();
		if(this.electivelistreason == null)
			clone.electivelistreason = null;
		else
			clone.electivelistreason = (ims.emergency.vo.lookups.ElectiveListReason)this.electivelistreason.clone();
		clone.pathwayclock = this.pathwayclock;
		clone.erodhistory = this.erodhistory;
		clone.tcicancelledbyprovider = this.tcicancelledbyprovider;
		clone.bed = this.bed;
		clone.transportrequired = this.transportrequired;
		clone.proceduredescription = this.proceduredescription;
		if(this.language == null)
			clone.language = null;
		else
			clone.language = (ims.core.vo.lookups.Language)this.language.clone();
		clone.canbeused = this.canbeused;
		if(this.patientstatus == null)
			clone.patientstatus = null;
		else
			clone.patientstatus = (ims.careuk.vo.lookups.CatsReferralCategory)this.patientstatus.clone();
		if(this.requirestciby == null)
			clone.requirestciby = null;
		else
			clone.requirestciby = (ims.framework.utils.Date)this.requirestciby.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(PatientElectiveListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientElectiveListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientElectiveListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientElectiveListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.electivelist != null)
			count++;
		if(this.electiveliststatus != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.referral != null)
			count++;
		if(this.episodeofcare != null)
			count++;
		if(this.ward != null)
			count++;
		if(this.consultant != null)
			count++;
		if(this.dateonlist != null)
			count++;
		if(this.originaldecisiondate != null)
			count++;
		if(this.intendedmanagement != null)
			count++;
		if(this.anticipatedstay != null)
			count++;
		if(this.priority != null)
			count++;
		if(this.suspensions != null)
			count++;
		if(this.operativeprocedurestatus != null)
			count++;
		if(this.primaryprocedure != null)
			count++;
		if(this.otherprocedures != null)
			count++;
		if(this.tcihistory != null)
			count++;
		if(this.interpretatorrequired != null)
			count++;
		if(this.transport != null)
			count++;
		if(this.notes != null)
			count++;
		if(this.electiveadmissiontype != null)
			count++;
		if(this.erod != null)
			count++;
		if(this.tcidetails != null)
			count++;
		if(this.electiveliststatushistory != null)
			count++;
		if(this.electivelistreason != null)
			count++;
		if(this.pathwayclock != null)
			count++;
		if(this.erodhistory != null)
			count++;
		if(this.tcicancelledbyprovider != null)
			count++;
		if(this.bed != null)
			count++;
		if(this.transportrequired != null)
			count++;
		if(this.proceduredescription != null)
			count++;
		if(this.language != null)
			count++;
		if(this.canbeused != null)
			count++;
		if(this.patientstatus != null)
			count++;
		if(this.requirestciby != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 35;
	}
	protected ims.admin.vo.ElectiveListConfigurationVo electivelist;
	protected ims.careuk.vo.ElectiveListStatusVo electiveliststatus;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.careuk.vo.CatsReferralRefVo referral;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episodeofcare;
	protected ims.core.vo.LocationLiteVo ward;
	protected ims.core.vo.HcpMinVo consultant;
	protected ims.framework.utils.Date dateonlist;
	protected ims.framework.utils.Date originaldecisiondate;
	protected ims.core.vo.lookups.ManagementIntention intendedmanagement;
	protected Integer anticipatedstay;
	protected ims.careuk.vo.lookups.ReferralUrgency priority;
	protected ims.careuk.vo.SuspensionDetailsForPatientElectiveListVoCollection suspensions;
	protected Boolean operativeprocedurestatus;
	protected ims.core.vo.ProcedureLiteVo primaryprocedure;
	protected ims.core.vo.ProcedureLiteVoCollection otherprocedures;
	protected ims.careuk.vo.PatientElectiveListElectiveTCIVoCollection tcihistory;
	protected Boolean interpretatorrequired;
	protected ims.scheduling.vo.lookups.ApptTransportType transport;
	protected ims.careuk.vo.PatientElectiveListNotesVoCollection notes;
	protected ims.careuk.vo.lookups.ElectiveAdmissionType electiveadmissiontype;
	protected ims.careuk.vo.ReferralERODRefVo erod;
	protected ims.careuk.vo.PatientElectiveListElectiveTCIVo tcidetails;
	protected ims.careuk.vo.ElectiveListStatusVoCollection electiveliststatushistory;
	protected ims.emergency.vo.lookups.ElectiveListReason electivelistreason;
	protected ims.pathways.vo.PathwayClockRefVo pathwayclock;
	protected ims.careuk.vo.ReferralERODRefVoCollection erodhistory;
	protected Boolean tcicancelledbyprovider;
	protected String bed;
	protected Boolean transportrequired;
	protected String proceduredescription;
	protected ims.core.vo.lookups.Language language;
	protected Boolean canbeused;
	protected ims.careuk.vo.lookups.CatsReferralCategory patientstatus;
	protected ims.framework.utils.Date requirestciby;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
