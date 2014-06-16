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
public class PatientElevectiveListManagementVo extends ims.careuk.vo.PatientElectiveListRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientElevectiveListManagementVo()
	{
	}
	public PatientElevectiveListManagementVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientElevectiveListManagementVo(ims.careuk.vo.beans.PatientElevectiveListManagementVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.referral = bean.getReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getReferral().getId()), bean.getReferral().getVersion());
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo();
		this.dateonlist = bean.getDateOnList() == null ? null : bean.getDateOnList().buildDate();
		this.electiveadmissiontype = bean.getElectiveAdmissionType() == null ? null : ims.careuk.vo.lookups.ElectiveAdmissionType.buildLookup(bean.getElectiveAdmissionType());
		this.intendedmanagement = bean.getIntendedManagement() == null ? null : ims.core.vo.lookups.ManagementIntention.buildLookup(bean.getIntendedManagement());
		this.anticipatedstay = bean.getAnticipatedStay();
		if(bean.getSuspensions() != null)
		{
			this.suspensions = new ims.careuk.vo.SuspensionDetailsForPatientElectiveListRefVoCollection();
			for(int suspensions_i = 0; suspensions_i < bean.getSuspensions().length; suspensions_i++)
			{
				this.suspensions.add(new ims.careuk.vo.SuspensionDetailsForPatientElectiveListRefVo(new Integer(bean.getSuspensions()[suspensions_i].getId()), bean.getSuspensions()[suspensions_i].getVersion()));
			}
		}
		this.operativeprocedurestatus = bean.getOperativeProcedureStatus();
		this.primaryprocedure = bean.getPrimaryProcedure() == null ? null : bean.getPrimaryProcedure().buildVo();
		if(bean.getOtherProcedures() != null)
		{
			this.otherprocedures = new ims.core.clinical.vo.ProcedureRefVoCollection();
			for(int otherprocedures_i = 0; otherprocedures_i < bean.getOtherProcedures().length; otherprocedures_i++)
			{
				this.otherprocedures.add(new ims.core.clinical.vo.ProcedureRefVo(new Integer(bean.getOtherProcedures()[otherprocedures_i].getId()), bean.getOtherProcedures()[otherprocedures_i].getVersion()));
			}
		}
		if(bean.getTCIHistory() != null)
		{
			this.tcihistory = new ims.careuk.vo.TCIForPatientElectiveListRefVoCollection();
			for(int tcihistory_i = 0; tcihistory_i < bean.getTCIHistory().length; tcihistory_i++)
			{
				this.tcihistory.add(new ims.careuk.vo.TCIForPatientElectiveListRefVo(new Integer(bean.getTCIHistory()[tcihistory_i].getId()), bean.getTCIHistory()[tcihistory_i].getVersion()));
			}
		}
		this.interpretatorrequired = bean.getInterpretatorRequired();
		if(bean.getNotes() != null)
		{
			this.notes = new ims.careuk.vo.NotesForPatientElectiveListRefVoCollection();
			for(int notes_i = 0; notes_i < bean.getNotes().length; notes_i++)
			{
				this.notes.add(new ims.careuk.vo.NotesForPatientElectiveListRefVo(new Integer(bean.getNotes()[notes_i].getId()), bean.getNotes()[notes_i].getVersion()));
			}
		}
		this.erod = bean.getEROD() == null ? null : new ims.careuk.vo.ReferralERODRefVo(new Integer(bean.getEROD().getId()), bean.getEROD().getVersion());
		if(bean.getERODHistory() != null)
		{
			this.erodhistory = new ims.careuk.vo.ReferralERODRefVoCollection();
			for(int erodhistory_i = 0; erodhistory_i < bean.getERODHistory().length; erodhistory_i++)
			{
				this.erodhistory.add(new ims.careuk.vo.ReferralERODRefVo(new Integer(bean.getERODHistory()[erodhistory_i].getId()), bean.getERODHistory()[erodhistory_i].getVersion()));
			}
		}
		this.tcidetails = bean.getTCIDetails() == null ? null : bean.getTCIDetails().buildVo();
		this.electivelist = bean.getElectiveList() == null ? null : bean.getElectiveList().buildVo();
		this.electiveliststatus = bean.getElectiveListStatus() == null ? null : bean.getElectiveListStatus().buildVo();
		this.patientstatus = bean.getPatientStatus() == null ? null : ims.careuk.vo.lookups.CatsReferralCategory.buildLookup(bean.getPatientStatus());
		this.requirestciby = bean.getRequiresTCIBy() == null ? null : bean.getRequiresTCIBy().buildDate();
		this.electivelistreason = bean.getElectiveListReason() == null ? null : ims.emergency.vo.lookups.ElectiveListReason.buildLookup(bean.getElectiveListReason());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.PatientElevectiveListManagementVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.referral = bean.getReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getReferral().getId()), bean.getReferral().getVersion());
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo(map);
		this.dateonlist = bean.getDateOnList() == null ? null : bean.getDateOnList().buildDate();
		this.electiveadmissiontype = bean.getElectiveAdmissionType() == null ? null : ims.careuk.vo.lookups.ElectiveAdmissionType.buildLookup(bean.getElectiveAdmissionType());
		this.intendedmanagement = bean.getIntendedManagement() == null ? null : ims.core.vo.lookups.ManagementIntention.buildLookup(bean.getIntendedManagement());
		this.anticipatedstay = bean.getAnticipatedStay();
		if(bean.getSuspensions() != null)
		{
			this.suspensions = new ims.careuk.vo.SuspensionDetailsForPatientElectiveListRefVoCollection();
			for(int suspensions_i = 0; suspensions_i < bean.getSuspensions().length; suspensions_i++)
			{
				this.suspensions.add(new ims.careuk.vo.SuspensionDetailsForPatientElectiveListRefVo(new Integer(bean.getSuspensions()[suspensions_i].getId()), bean.getSuspensions()[suspensions_i].getVersion()));
			}
		}
		this.operativeprocedurestatus = bean.getOperativeProcedureStatus();
		this.primaryprocedure = bean.getPrimaryProcedure() == null ? null : bean.getPrimaryProcedure().buildVo(map);
		if(bean.getOtherProcedures() != null)
		{
			this.otherprocedures = new ims.core.clinical.vo.ProcedureRefVoCollection();
			for(int otherprocedures_i = 0; otherprocedures_i < bean.getOtherProcedures().length; otherprocedures_i++)
			{
				this.otherprocedures.add(new ims.core.clinical.vo.ProcedureRefVo(new Integer(bean.getOtherProcedures()[otherprocedures_i].getId()), bean.getOtherProcedures()[otherprocedures_i].getVersion()));
			}
		}
		if(bean.getTCIHistory() != null)
		{
			this.tcihistory = new ims.careuk.vo.TCIForPatientElectiveListRefVoCollection();
			for(int tcihistory_i = 0; tcihistory_i < bean.getTCIHistory().length; tcihistory_i++)
			{
				this.tcihistory.add(new ims.careuk.vo.TCIForPatientElectiveListRefVo(new Integer(bean.getTCIHistory()[tcihistory_i].getId()), bean.getTCIHistory()[tcihistory_i].getVersion()));
			}
		}
		this.interpretatorrequired = bean.getInterpretatorRequired();
		if(bean.getNotes() != null)
		{
			this.notes = new ims.careuk.vo.NotesForPatientElectiveListRefVoCollection();
			for(int notes_i = 0; notes_i < bean.getNotes().length; notes_i++)
			{
				this.notes.add(new ims.careuk.vo.NotesForPatientElectiveListRefVo(new Integer(bean.getNotes()[notes_i].getId()), bean.getNotes()[notes_i].getVersion()));
			}
		}
		this.erod = bean.getEROD() == null ? null : new ims.careuk.vo.ReferralERODRefVo(new Integer(bean.getEROD().getId()), bean.getEROD().getVersion());
		if(bean.getERODHistory() != null)
		{
			this.erodhistory = new ims.careuk.vo.ReferralERODRefVoCollection();
			for(int erodhistory_i = 0; erodhistory_i < bean.getERODHistory().length; erodhistory_i++)
			{
				this.erodhistory.add(new ims.careuk.vo.ReferralERODRefVo(new Integer(bean.getERODHistory()[erodhistory_i].getId()), bean.getERODHistory()[erodhistory_i].getVersion()));
			}
		}
		this.tcidetails = bean.getTCIDetails() == null ? null : bean.getTCIDetails().buildVo(map);
		this.electivelist = bean.getElectiveList() == null ? null : bean.getElectiveList().buildVo(map);
		this.electiveliststatus = bean.getElectiveListStatus() == null ? null : bean.getElectiveListStatus().buildVo(map);
		this.patientstatus = bean.getPatientStatus() == null ? null : ims.careuk.vo.lookups.CatsReferralCategory.buildLookup(bean.getPatientStatus());
		this.requirestciby = bean.getRequiresTCIBy() == null ? null : bean.getRequiresTCIBy().buildDate();
		this.electivelistreason = bean.getElectiveListReason() == null ? null : ims.emergency.vo.lookups.ElectiveListReason.buildLookup(bean.getElectiveListReason());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.PatientElevectiveListManagementVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.PatientElevectiveListManagementVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.PatientElevectiveListManagementVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("REFERRAL"))
			return getReferral();
		if(fieldName.equals("CONSULTANT"))
			return getConsultant();
		if(fieldName.equals("DATEONLIST"))
			return getDateOnList();
		if(fieldName.equals("ELECTIVEADMISSIONTYPE"))
			return getElectiveAdmissionType();
		if(fieldName.equals("INTENDEDMANAGEMENT"))
			return getIntendedManagement();
		if(fieldName.equals("ANTICIPATEDSTAY"))
			return getAnticipatedStay();
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
		if(fieldName.equals("NOTES"))
			return getNotes();
		if(fieldName.equals("EROD"))
			return getEROD();
		if(fieldName.equals("ERODHISTORY"))
			return getERODHistory();
		if(fieldName.equals("TCIDETAILS"))
			return getTCIDetails();
		if(fieldName.equals("ELECTIVELIST"))
			return getElectiveList();
		if(fieldName.equals("ELECTIVELISTSTATUS"))
			return getElectiveListStatus();
		if(fieldName.equals("PATIENTSTATUS"))
			return getPatientStatus();
		if(fieldName.equals("REQUIRESTCIBY"))
			return getRequiresTCIBy();
		if(fieldName.equals("ELECTIVELISTREASON"))
			return getElectiveListReason();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientLite_IdentifiersVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientLite_IdentifiersVo value)
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
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.vo.HcpLiteVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.HcpLiteVo value)
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
	public boolean getSuspensionsIsNotNull()
	{
		return this.suspensions != null;
	}
	public ims.careuk.vo.SuspensionDetailsForPatientElectiveListRefVoCollection getSuspensions()
	{
		return this.suspensions;
	}
	public void setSuspensions(ims.careuk.vo.SuspensionDetailsForPatientElectiveListRefVoCollection value)
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
	public ims.core.clinical.vo.ProcedureRefVoCollection getOtherProcedures()
	{
		return this.otherprocedures;
	}
	public void setOtherProcedures(ims.core.clinical.vo.ProcedureRefVoCollection value)
	{
		this.isValidated = false;
		this.otherprocedures = value;
	}
	public boolean getTCIHistoryIsNotNull()
	{
		return this.tcihistory != null;
	}
	public ims.careuk.vo.TCIForPatientElectiveListRefVoCollection getTCIHistory()
	{
		return this.tcihistory;
	}
	public void setTCIHistory(ims.careuk.vo.TCIForPatientElectiveListRefVoCollection value)
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
	public boolean getNotesIsNotNull()
	{
		return this.notes != null;
	}
	public ims.careuk.vo.NotesForPatientElectiveListRefVoCollection getNotes()
	{
		return this.notes;
	}
	public void setNotes(ims.careuk.vo.NotesForPatientElectiveListRefVoCollection value)
	{
		this.isValidated = false;
		this.notes = value;
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
	public boolean getTCIDetailsIsNotNull()
	{
		return this.tcidetails != null;
	}
	public ims.careuk.vo.PatientElectiveListTCIVo getTCIDetails()
	{
		return this.tcidetails;
	}
	public void setTCIDetails(ims.careuk.vo.PatientElectiveListTCIVo value)
	{
		this.isValidated = false;
		this.tcidetails = value;
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
		if(this.primaryprocedure != null)
		{
			if(!this.primaryprocedure.isValidated())
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
		if(this.electivelist != null)
		{
			if(!this.electivelist.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.electiveliststatus != null)
		{
			if(!this.electiveliststatus.isValidated())
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.referral == null)
			listOfErrors.add("Referral is mandatory");
		if(this.dateonlist == null)
			listOfErrors.add("DateOnList is mandatory");
		if(this.electiveadmissiontype == null)
			listOfErrors.add("ElectiveAdmissionType is mandatory");
		if(this.operativeprocedurestatus == null)
			listOfErrors.add("OperativeProcedureStatus is mandatory");
		if(this.primaryprocedure != null)
		{
			String[] listOfOtherErrors = this.primaryprocedure.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
		if(this.electivelist == null)
			listOfErrors.add("ElectiveList is mandatory");
		if(this.electivelist != null)
		{
			String[] listOfOtherErrors = this.electivelist.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
		if(this.electivelistreason == null)
			listOfErrors.add("ElectiveListReason is mandatory");
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
	
		PatientElevectiveListManagementVo clone = new PatientElevectiveListManagementVo(this.id, this.version);
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientLite_IdentifiersVo)this.patient.clone();
		clone.referral = this.referral;
		if(this.consultant == null)
			clone.consultant = null;
		else
			clone.consultant = (ims.core.vo.HcpLiteVo)this.consultant.clone();
		if(this.dateonlist == null)
			clone.dateonlist = null;
		else
			clone.dateonlist = (ims.framework.utils.Date)this.dateonlist.clone();
		if(this.electiveadmissiontype == null)
			clone.electiveadmissiontype = null;
		else
			clone.electiveadmissiontype = (ims.careuk.vo.lookups.ElectiveAdmissionType)this.electiveadmissiontype.clone();
		if(this.intendedmanagement == null)
			clone.intendedmanagement = null;
		else
			clone.intendedmanagement = (ims.core.vo.lookups.ManagementIntention)this.intendedmanagement.clone();
		clone.anticipatedstay = this.anticipatedstay;
		clone.suspensions = this.suspensions;
		clone.operativeprocedurestatus = this.operativeprocedurestatus;
		if(this.primaryprocedure == null)
			clone.primaryprocedure = null;
		else
			clone.primaryprocedure = (ims.core.vo.ProcedureLiteVo)this.primaryprocedure.clone();
		clone.otherprocedures = this.otherprocedures;
		clone.tcihistory = this.tcihistory;
		clone.interpretatorrequired = this.interpretatorrequired;
		clone.notes = this.notes;
		clone.erod = this.erod;
		clone.erodhistory = this.erodhistory;
		if(this.tcidetails == null)
			clone.tcidetails = null;
		else
			clone.tcidetails = (ims.careuk.vo.PatientElectiveListTCIVo)this.tcidetails.clone();
		if(this.electivelist == null)
			clone.electivelist = null;
		else
			clone.electivelist = (ims.admin.vo.ElectiveListConfigurationVo)this.electivelist.clone();
		if(this.electiveliststatus == null)
			clone.electiveliststatus = null;
		else
			clone.electiveliststatus = (ims.careuk.vo.ElectiveListStatusVo)this.electiveliststatus.clone();
		if(this.patientstatus == null)
			clone.patientstatus = null;
		else
			clone.patientstatus = (ims.careuk.vo.lookups.CatsReferralCategory)this.patientstatus.clone();
		if(this.requirestciby == null)
			clone.requirestciby = null;
		else
			clone.requirestciby = (ims.framework.utils.Date)this.requirestciby.clone();
		if(this.electivelistreason == null)
			clone.electivelistreason = null;
		else
			clone.electivelistreason = (ims.emergency.vo.lookups.ElectiveListReason)this.electivelistreason.clone();
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
		if (!(PatientElevectiveListManagementVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientElevectiveListManagementVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientElevectiveListManagementVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientElevectiveListManagementVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.referral != null)
			count++;
		if(this.consultant != null)
			count++;
		if(this.dateonlist != null)
			count++;
		if(this.electiveadmissiontype != null)
			count++;
		if(this.intendedmanagement != null)
			count++;
		if(this.anticipatedstay != null)
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
		if(this.notes != null)
			count++;
		if(this.erod != null)
			count++;
		if(this.erodhistory != null)
			count++;
		if(this.tcidetails != null)
			count++;
		if(this.electivelist != null)
			count++;
		if(this.electiveliststatus != null)
			count++;
		if(this.patientstatus != null)
			count++;
		if(this.requirestciby != null)
			count++;
		if(this.electivelistreason != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 22;
	}
	protected ims.core.vo.PatientLite_IdentifiersVo patient;
	protected ims.careuk.vo.CatsReferralRefVo referral;
	protected ims.core.vo.HcpLiteVo consultant;
	protected ims.framework.utils.Date dateonlist;
	protected ims.careuk.vo.lookups.ElectiveAdmissionType electiveadmissiontype;
	protected ims.core.vo.lookups.ManagementIntention intendedmanagement;
	protected Integer anticipatedstay;
	protected ims.careuk.vo.SuspensionDetailsForPatientElectiveListRefVoCollection suspensions;
	protected Boolean operativeprocedurestatus;
	protected ims.core.vo.ProcedureLiteVo primaryprocedure;
	protected ims.core.clinical.vo.ProcedureRefVoCollection otherprocedures;
	protected ims.careuk.vo.TCIForPatientElectiveListRefVoCollection tcihistory;
	protected Boolean interpretatorrequired;
	protected ims.careuk.vo.NotesForPatientElectiveListRefVoCollection notes;
	protected ims.careuk.vo.ReferralERODRefVo erod;
	protected ims.careuk.vo.ReferralERODRefVoCollection erodhistory;
	protected ims.careuk.vo.PatientElectiveListTCIVo tcidetails;
	protected ims.admin.vo.ElectiveListConfigurationVo electivelist;
	protected ims.careuk.vo.ElectiveListStatusVo electiveliststatus;
	protected ims.careuk.vo.lookups.CatsReferralCategory patientstatus;
	protected ims.framework.utils.Date requirestciby;
	protected ims.emergency.vo.lookups.ElectiveListReason electivelistreason;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
