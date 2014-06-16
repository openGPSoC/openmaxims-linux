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
 * Linked to CAREUK.DischargeSummaryPacuAndWard business object (ID: 1096100034).
 */
public class DischargeSummaryPacuAndWardVo extends ims.careuk.vo.DischargeSummaryPacuAndWardLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DischargeSummaryPacuAndWardVo()
	{
	}
	public DischargeSummaryPacuAndWardVo(Integer id, int version)
	{
		super(id, version);
	}
	public DischargeSummaryPacuAndWardVo(ims.careuk.vo.beans.DischargeSummaryPacuAndWardVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.dischargedate = bean.getDischargeDate() == null ? null : bean.getDischargeDate().buildDate();
		this.dischargetype = bean.getDischargeType() == null ? null : ims.careuk.vo.lookups.DischargeType.buildLookup(bean.getDischargeType());
		this.dischargeepisode = bean.getDischargeEpisode() == null ? null : new ims.core.admin.pas.vo.DischargedEpisodeRefVo(new Integer(bean.getDischargeEpisode().getId()), bean.getDischargeEpisode().getVersion());
		this.iscurrent = bean.getIsCurrent();
		this.admissionsummary = bean.getAdmissionSummary();
		this.diagnosis = ims.core.vo.PatientDiagnosisLiteVoCollection.buildFromBeanCollection(bean.getDiagnosis());
		this.medicationondischarge = ims.core.vo.PatientMedicationVoCollection.buildFromBeanCollection(bean.getMedicationOnDischarge());
		this.problemsandneeds = bean.getProblemsAndNeeds();
		this.additionalcomments = bean.getAdditionalComments();
		this.dressingsandaids = ims.clinical.vo.DressingAndAidsVoCollection.buildFromBeanCollection(bean.getDressingsAndAids());
		this.followuptype = bean.getFollowupType() == null ? null : ims.careuk.vo.lookups.FollowupManagementType.buildLookup(bean.getFollowupType());
		this.furthermanagementinstructions = bean.getFurtherManagementInstructions();
		this.medicallyincomplete = bean.getMedicallyIncomplete() == null ? null : ims.careuk.vo.lookups.MedicallyIncomplete.buildLookup(bean.getMedicallyIncomplete());
		this.incompletenoofdays = bean.getIncompleteNoOfDays();
		this.currentonwardreferral = bean.getCurrentOnwardReferral() == null ? null : new ims.careuk.vo.OnwardReferralRefVo(new Integer(bean.getCurrentOnwardReferral().getId()), bean.getCurrentOnwardReferral().getVersion());
		if(bean.getOnwardReferrals() != null)
		{
			this.onwardreferrals = new ims.careuk.vo.OnwardReferralRefVoCollection();
			for(int onwardreferrals_i = 0; onwardreferrals_i < bean.getOnwardReferrals().length; onwardreferrals_i++)
			{
				this.onwardreferrals.add(new ims.careuk.vo.OnwardReferralRefVo(new Integer(bean.getOnwardReferrals()[onwardreferrals_i].getId()), bean.getOnwardReferrals()[onwardreferrals_i].getVersion()));
			}
		}
		this.actionsforgpandcommunity = bean.getActionsforGPandCommunity();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.DischargeSummaryPacuAndWardVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.dischargedate = bean.getDischargeDate() == null ? null : bean.getDischargeDate().buildDate();
		this.dischargetype = bean.getDischargeType() == null ? null : ims.careuk.vo.lookups.DischargeType.buildLookup(bean.getDischargeType());
		this.dischargeepisode = bean.getDischargeEpisode() == null ? null : new ims.core.admin.pas.vo.DischargedEpisodeRefVo(new Integer(bean.getDischargeEpisode().getId()), bean.getDischargeEpisode().getVersion());
		this.iscurrent = bean.getIsCurrent();
		this.admissionsummary = bean.getAdmissionSummary();
		this.diagnosis = ims.core.vo.PatientDiagnosisLiteVoCollection.buildFromBeanCollection(bean.getDiagnosis());
		this.medicationondischarge = ims.core.vo.PatientMedicationVoCollection.buildFromBeanCollection(bean.getMedicationOnDischarge());
		this.problemsandneeds = bean.getProblemsAndNeeds();
		this.additionalcomments = bean.getAdditionalComments();
		this.dressingsandaids = ims.clinical.vo.DressingAndAidsVoCollection.buildFromBeanCollection(bean.getDressingsAndAids());
		this.followuptype = bean.getFollowupType() == null ? null : ims.careuk.vo.lookups.FollowupManagementType.buildLookup(bean.getFollowupType());
		this.furthermanagementinstructions = bean.getFurtherManagementInstructions();
		this.medicallyincomplete = bean.getMedicallyIncomplete() == null ? null : ims.careuk.vo.lookups.MedicallyIncomplete.buildLookup(bean.getMedicallyIncomplete());
		this.incompletenoofdays = bean.getIncompleteNoOfDays();
		this.currentonwardreferral = bean.getCurrentOnwardReferral() == null ? null : new ims.careuk.vo.OnwardReferralRefVo(new Integer(bean.getCurrentOnwardReferral().getId()), bean.getCurrentOnwardReferral().getVersion());
		if(bean.getOnwardReferrals() != null)
		{
			this.onwardreferrals = new ims.careuk.vo.OnwardReferralRefVoCollection();
			for(int onwardreferrals_i = 0; onwardreferrals_i < bean.getOnwardReferrals().length; onwardreferrals_i++)
			{
				this.onwardreferrals.add(new ims.careuk.vo.OnwardReferralRefVo(new Integer(bean.getOnwardReferrals()[onwardreferrals_i].getId()), bean.getOnwardReferrals()[onwardreferrals_i].getVersion()));
			}
		}
		this.actionsforgpandcommunity = bean.getActionsforGPandCommunity();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.DischargeSummaryPacuAndWardVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.DischargeSummaryPacuAndWardVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.DischargeSummaryPacuAndWardVoBean();
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
		if(fieldName.equals("ADMISSIONSUMMARY"))
			return getAdmissionSummary();
		if(fieldName.equals("DIAGNOSIS"))
			return getDiagnosis();
		if(fieldName.equals("MEDICATIONONDISCHARGE"))
			return getMedicationOnDischarge();
		if(fieldName.equals("PROBLEMSANDNEEDS"))
			return getProblemsAndNeeds();
		if(fieldName.equals("ADDITIONALCOMMENTS"))
			return getAdditionalComments();
		if(fieldName.equals("DRESSINGSANDAIDS"))
			return getDressingsAndAids();
		if(fieldName.equals("FOLLOWUPTYPE"))
			return getFollowupType();
		if(fieldName.equals("FURTHERMANAGEMENTINSTRUCTIONS"))
			return getFurtherManagementInstructions();
		if(fieldName.equals("MEDICALLYINCOMPLETE"))
			return getMedicallyIncomplete();
		if(fieldName.equals("INCOMPLETENOOFDAYS"))
			return getIncompleteNoOfDays();
		if(fieldName.equals("CURRENTONWARDREFERRAL"))
			return getCurrentOnwardReferral();
		if(fieldName.equals("ONWARDREFERRALS"))
			return getOnwardReferrals();
		if(fieldName.equals("ACTIONSFORGPANDCOMMUNITY"))
			return getActionsforGPandCommunity();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAdmissionSummaryIsNotNull()
	{
		return this.admissionsummary != null;
	}
	public String getAdmissionSummary()
	{
		return this.admissionsummary;
	}
	public static int getAdmissionSummaryMaxLength()
	{
		return 3000;
	}
	public void setAdmissionSummary(String value)
	{
		this.isValidated = false;
		this.admissionsummary = value;
	}
	public boolean getDiagnosisIsNotNull()
	{
		return this.diagnosis != null;
	}
	public ims.core.vo.PatientDiagnosisLiteVoCollection getDiagnosis()
	{
		return this.diagnosis;
	}
	public void setDiagnosis(ims.core.vo.PatientDiagnosisLiteVoCollection value)
	{
		this.isValidated = false;
		this.diagnosis = value;
	}
	public boolean getMedicationOnDischargeIsNotNull()
	{
		return this.medicationondischarge != null;
	}
	public ims.core.vo.PatientMedicationVoCollection getMedicationOnDischarge()
	{
		return this.medicationondischarge;
	}
	public void setMedicationOnDischarge(ims.core.vo.PatientMedicationVoCollection value)
	{
		this.isValidated = false;
		this.medicationondischarge = value;
	}
	public boolean getProblemsAndNeedsIsNotNull()
	{
		return this.problemsandneeds != null;
	}
	public String getProblemsAndNeeds()
	{
		return this.problemsandneeds;
	}
	public static int getProblemsAndNeedsMaxLength()
	{
		return 3000;
	}
	public void setProblemsAndNeeds(String value)
	{
		this.isValidated = false;
		this.problemsandneeds = value;
	}
	public boolean getAdditionalCommentsIsNotNull()
	{
		return this.additionalcomments != null;
	}
	public String getAdditionalComments()
	{
		return this.additionalcomments;
	}
	public static int getAdditionalCommentsMaxLength()
	{
		return 3000;
	}
	public void setAdditionalComments(String value)
	{
		this.isValidated = false;
		this.additionalcomments = value;
	}
	public boolean getDressingsAndAidsIsNotNull()
	{
		return this.dressingsandaids != null;
	}
	public ims.clinical.vo.DressingAndAidsVoCollection getDressingsAndAids()
	{
		return this.dressingsandaids;
	}
	public void setDressingsAndAids(ims.clinical.vo.DressingAndAidsVoCollection value)
	{
		this.isValidated = false;
		this.dressingsandaids = value;
	}
	public boolean getFollowupTypeIsNotNull()
	{
		return this.followuptype != null;
	}
	public ims.careuk.vo.lookups.FollowupManagementType getFollowupType()
	{
		return this.followuptype;
	}
	public void setFollowupType(ims.careuk.vo.lookups.FollowupManagementType value)
	{
		this.isValidated = false;
		this.followuptype = value;
	}
	public boolean getFurtherManagementInstructionsIsNotNull()
	{
		return this.furthermanagementinstructions != null;
	}
	public String getFurtherManagementInstructions()
	{
		return this.furthermanagementinstructions;
	}
	public static int getFurtherManagementInstructionsMaxLength()
	{
		return 3000;
	}
	public void setFurtherManagementInstructions(String value)
	{
		this.isValidated = false;
		this.furthermanagementinstructions = value;
	}
	public boolean getMedicallyIncompleteIsNotNull()
	{
		return this.medicallyincomplete != null;
	}
	public ims.careuk.vo.lookups.MedicallyIncomplete getMedicallyIncomplete()
	{
		return this.medicallyincomplete;
	}
	public void setMedicallyIncomplete(ims.careuk.vo.lookups.MedicallyIncomplete value)
	{
		this.isValidated = false;
		this.medicallyincomplete = value;
	}
	public boolean getIncompleteNoOfDaysIsNotNull()
	{
		return this.incompletenoofdays != null;
	}
	public Integer getIncompleteNoOfDays()
	{
		return this.incompletenoofdays;
	}
	public void setIncompleteNoOfDays(Integer value)
	{
		this.isValidated = false;
		this.incompletenoofdays = value;
	}
	public boolean getCurrentOnwardReferralIsNotNull()
	{
		return this.currentonwardreferral != null;
	}
	public ims.careuk.vo.OnwardReferralRefVo getCurrentOnwardReferral()
	{
		return this.currentonwardreferral;
	}
	public void setCurrentOnwardReferral(ims.careuk.vo.OnwardReferralRefVo value)
	{
		this.isValidated = false;
		this.currentonwardreferral = value;
	}
	public boolean getOnwardReferralsIsNotNull()
	{
		return this.onwardreferrals != null;
	}
	public ims.careuk.vo.OnwardReferralRefVoCollection getOnwardReferrals()
	{
		return this.onwardreferrals;
	}
	public void setOnwardReferrals(ims.careuk.vo.OnwardReferralRefVoCollection value)
	{
		this.isValidated = false;
		this.onwardreferrals = value;
	}
	public boolean getActionsforGPandCommunityIsNotNull()
	{
		return this.actionsforgpandcommunity != null;
	}
	public String getActionsforGPandCommunity()
	{
		return this.actionsforgpandcommunity;
	}
	public static int getActionsforGPandCommunityMaxLength()
	{
		return 3500;
	}
	public void setActionsforGPandCommunity(String value)
	{
		this.isValidated = false;
		this.actionsforgpandcommunity = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.medicationondischarge != null)
		{
			if(!this.medicationondischarge.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.dressingsandaids != null)
		{
			if(!this.dressingsandaids.isValidated())
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
		if(this.catsreferral == null)
			listOfErrors.add("CatsReferral is mandatory");
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.dischargedate == null)
			listOfErrors.add("DischargeDate is mandatory");
		if(this.dischargetype == null)
			listOfErrors.add("DischargeType is mandatory");
		if(this.admissionsummary != null)
			if(this.admissionsummary.length() > 3000)
				listOfErrors.add("The length of the field [admissionsummary] in the value object [ims.careuk.vo.DischargeSummaryPacuAndWardVo] is too big. It should be less or equal to 3000");
		if(this.medicationondischarge != null)
		{
			String[] listOfOtherErrors = this.medicationondischarge.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.problemsandneeds != null)
			if(this.problemsandneeds.length() > 3000)
				listOfErrors.add("The length of the field [problemsandneeds] in the value object [ims.careuk.vo.DischargeSummaryPacuAndWardVo] is too big. It should be less or equal to 3000");
		if(this.additionalcomments != null)
			if(this.additionalcomments.length() > 3000)
				listOfErrors.add("The length of the field [additionalcomments] in the value object [ims.careuk.vo.DischargeSummaryPacuAndWardVo] is too big. It should be less or equal to 3000");
		if(this.dressingsandaids != null)
		{
			String[] listOfOtherErrors = this.dressingsandaids.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.furthermanagementinstructions != null)
			if(this.furthermanagementinstructions.length() > 3000)
				listOfErrors.add("The length of the field [furthermanagementinstructions] in the value object [ims.careuk.vo.DischargeSummaryPacuAndWardVo] is too big. It should be less or equal to 3000");
		if(this.actionsforgpandcommunity != null)
			if(this.actionsforgpandcommunity.length() > 3500)
				listOfErrors.add("The length of the field [actionsforgpandcommunity] in the value object [ims.careuk.vo.DischargeSummaryPacuAndWardVo] is too big. It should be less or equal to 3500");
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
	
		DischargeSummaryPacuAndWardVo clone = new DischargeSummaryPacuAndWardVo(this.id, this.version);
		
		clone.catsreferral = this.catsreferral;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.dischargedate == null)
			clone.dischargedate = null;
		else
			clone.dischargedate = (ims.framework.utils.Date)this.dischargedate.clone();
		if(this.dischargetype == null)
			clone.dischargetype = null;
		else
			clone.dischargetype = (ims.careuk.vo.lookups.DischargeType)this.dischargetype.clone();
		clone.dischargeepisode = this.dischargeepisode;
		clone.iscurrent = this.iscurrent;
		clone.admissionsummary = this.admissionsummary;
		if(this.diagnosis == null)
			clone.diagnosis = null;
		else
			clone.diagnosis = (ims.core.vo.PatientDiagnosisLiteVoCollection)this.diagnosis.clone();
		if(this.medicationondischarge == null)
			clone.medicationondischarge = null;
		else
			clone.medicationondischarge = (ims.core.vo.PatientMedicationVoCollection)this.medicationondischarge.clone();
		clone.problemsandneeds = this.problemsandneeds;
		clone.additionalcomments = this.additionalcomments;
		if(this.dressingsandaids == null)
			clone.dressingsandaids = null;
		else
			clone.dressingsandaids = (ims.clinical.vo.DressingAndAidsVoCollection)this.dressingsandaids.clone();
		if(this.followuptype == null)
			clone.followuptype = null;
		else
			clone.followuptype = (ims.careuk.vo.lookups.FollowupManagementType)this.followuptype.clone();
		clone.furthermanagementinstructions = this.furthermanagementinstructions;
		if(this.medicallyincomplete == null)
			clone.medicallyincomplete = null;
		else
			clone.medicallyincomplete = (ims.careuk.vo.lookups.MedicallyIncomplete)this.medicallyincomplete.clone();
		clone.incompletenoofdays = this.incompletenoofdays;
		clone.currentonwardreferral = this.currentonwardreferral;
		clone.onwardreferrals = this.onwardreferrals;
		clone.actionsforgpandcommunity = this.actionsforgpandcommunity;
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
		if (!(DischargeSummaryPacuAndWardVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DischargeSummaryPacuAndWardVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DischargeSummaryPacuAndWardVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DischargeSummaryPacuAndWardVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.admissionsummary != null)
			count++;
		if(this.diagnosis != null)
			count++;
		if(this.medicationondischarge != null)
			count++;
		if(this.problemsandneeds != null)
			count++;
		if(this.additionalcomments != null)
			count++;
		if(this.dressingsandaids != null)
			count++;
		if(this.followuptype != null)
			count++;
		if(this.furthermanagementinstructions != null)
			count++;
		if(this.medicallyincomplete != null)
			count++;
		if(this.incompletenoofdays != null)
			count++;
		if(this.currentonwardreferral != null)
			count++;
		if(this.onwardreferrals != null)
			count++;
		if(this.actionsforgpandcommunity != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 13;
	}
	protected String admissionsummary;
	protected ims.core.vo.PatientDiagnosisLiteVoCollection diagnosis;
	protected ims.core.vo.PatientMedicationVoCollection medicationondischarge;
	protected String problemsandneeds;
	protected String additionalcomments;
	protected ims.clinical.vo.DressingAndAidsVoCollection dressingsandaids;
	protected ims.careuk.vo.lookups.FollowupManagementType followuptype;
	protected String furthermanagementinstructions;
	protected ims.careuk.vo.lookups.MedicallyIncomplete medicallyincomplete;
	protected Integer incompletenoofdays;
	protected ims.careuk.vo.OnwardReferralRefVo currentonwardreferral;
	protected ims.careuk.vo.OnwardReferralRefVoCollection onwardreferrals;
	protected String actionsforgpandcommunity;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
