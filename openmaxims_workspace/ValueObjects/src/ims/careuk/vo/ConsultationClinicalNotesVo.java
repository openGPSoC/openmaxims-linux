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
 * Linked to CAREUK.ConsultationClinicalNotes business object (ID: 1096100029).
 */
public class ConsultationClinicalNotesVo extends ims.careuk.vo.ConsultationClinicalNotesLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ConsultationClinicalNotesVo()
	{
	}
	public ConsultationClinicalNotesVo(Integer id, int version)
	{
		super(id, version);
	}
	public ConsultationClinicalNotesVo(ims.careuk.vo.beans.ConsultationClinicalNotesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo();
		this.lastupdatinghcp = bean.getLastUpdatingHCP() == null ? null : bean.getLastUpdatingHCP().buildVo();
		this.initiallyseenby = bean.getInitiallySeenBy() == null ? null : bean.getInitiallySeenBy().buildVo();
		this.historypresentingcomplaint = bean.getHistoryPresentingComplaint();
		this.relevantpmh = bean.getRelevantPMH();
		this.otherrelevanthistory = bean.getOtherRelevantHistory();
		this.relevantmedication = bean.getRelevantMedication();
		this.examination = bean.getExamination();
		this.hasnoknownallergies = bean.getHasNoKnownAllergies();
		this.allergies = ims.core.vo.PatientAllergyCollection.buildFromBeanCollection(bean.getAllergies());
		this.seescannednotes = bean.getSeeScannedNotes();
		this.notesdictated = bean.getNotesDictated();
		this.includenotesingpreport = bean.getIncludeNotesInGpReport();
		this.clinicalimpression = bean.getClinicalImpression();
		this.healthquestionnairecompleted = bean.getHealthQuestionnaireCompleted();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.ConsultationClinicalNotesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo(map);
		this.lastupdatinghcp = bean.getLastUpdatingHCP() == null ? null : bean.getLastUpdatingHCP().buildVo(map);
		this.initiallyseenby = bean.getInitiallySeenBy() == null ? null : bean.getInitiallySeenBy().buildVo(map);
		this.historypresentingcomplaint = bean.getHistoryPresentingComplaint();
		this.relevantpmh = bean.getRelevantPMH();
		this.otherrelevanthistory = bean.getOtherRelevantHistory();
		this.relevantmedication = bean.getRelevantMedication();
		this.examination = bean.getExamination();
		this.hasnoknownallergies = bean.getHasNoKnownAllergies();
		this.allergies = ims.core.vo.PatientAllergyCollection.buildFromBeanCollection(bean.getAllergies());
		this.seescannednotes = bean.getSeeScannedNotes();
		this.notesdictated = bean.getNotesDictated();
		this.includenotesingpreport = bean.getIncludeNotesInGpReport();
		this.clinicalimpression = bean.getClinicalImpression();
		this.healthquestionnairecompleted = bean.getHealthQuestionnaireCompleted();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.ConsultationClinicalNotesVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.ConsultationClinicalNotesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.ConsultationClinicalNotesVoBean();
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
		if(fieldName.equals("HISTORYPRESENTINGCOMPLAINT"))
			return getHistoryPresentingComplaint();
		if(fieldName.equals("RELEVANTPMH"))
			return getRelevantPMH();
		if(fieldName.equals("OTHERRELEVANTHISTORY"))
			return getOtherRelevantHistory();
		if(fieldName.equals("RELEVANTMEDICATION"))
			return getRelevantMedication();
		if(fieldName.equals("EXAMINATION"))
			return getExamination();
		if(fieldName.equals("HASNOKNOWNALLERGIES"))
			return getHasNoKnownAllergies();
		if(fieldName.equals("ALLERGIES"))
			return getAllergies();
		if(fieldName.equals("SEESCANNEDNOTES"))
			return getSeeScannedNotes();
		if(fieldName.equals("NOTESDICTATED"))
			return getNotesDictated();
		if(fieldName.equals("INCLUDENOTESINGPREPORT"))
			return getIncludeNotesInGpReport();
		if(fieldName.equals("CLINICALIMPRESSION"))
			return getClinicalImpression();
		if(fieldName.equals("HEALTHQUESTIONNAIRECOMPLETED"))
			return getHealthQuestionnaireCompleted();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getHistoryPresentingComplaintIsNotNull()
	{
		return this.historypresentingcomplaint != null;
	}
	public String getHistoryPresentingComplaint()
	{
		return this.historypresentingcomplaint;
	}
	public static int getHistoryPresentingComplaintMaxLength()
	{
		return 5000;
	}
	public void setHistoryPresentingComplaint(String value)
	{
		this.isValidated = false;
		this.historypresentingcomplaint = value;
	}
	public boolean getRelevantPMHIsNotNull()
	{
		return this.relevantpmh != null;
	}
	public String getRelevantPMH()
	{
		return this.relevantpmh;
	}
	public static int getRelevantPMHMaxLength()
	{
		return 5000;
	}
	public void setRelevantPMH(String value)
	{
		this.isValidated = false;
		this.relevantpmh = value;
	}
	public boolean getOtherRelevantHistoryIsNotNull()
	{
		return this.otherrelevanthistory != null;
	}
	public String getOtherRelevantHistory()
	{
		return this.otherrelevanthistory;
	}
	public static int getOtherRelevantHistoryMaxLength()
	{
		return 5000;
	}
	public void setOtherRelevantHistory(String value)
	{
		this.isValidated = false;
		this.otherrelevanthistory = value;
	}
	public boolean getRelevantMedicationIsNotNull()
	{
		return this.relevantmedication != null;
	}
	public String getRelevantMedication()
	{
		return this.relevantmedication;
	}
	public static int getRelevantMedicationMaxLength()
	{
		return 5000;
	}
	public void setRelevantMedication(String value)
	{
		this.isValidated = false;
		this.relevantmedication = value;
	}
	public boolean getExaminationIsNotNull()
	{
		return this.examination != null;
	}
	public String getExamination()
	{
		return this.examination;
	}
	public static int getExaminationMaxLength()
	{
		return 5000;
	}
	public void setExamination(String value)
	{
		this.isValidated = false;
		this.examination = value;
	}
	public boolean getHasNoKnownAllergiesIsNotNull()
	{
		return this.hasnoknownallergies != null;
	}
	public Boolean getHasNoKnownAllergies()
	{
		return this.hasnoknownallergies;
	}
	public void setHasNoKnownAllergies(Boolean value)
	{
		this.isValidated = false;
		this.hasnoknownallergies = value;
	}
	public boolean getAllergiesIsNotNull()
	{
		return this.allergies != null;
	}
	public ims.core.vo.PatientAllergyCollection getAllergies()
	{
		return this.allergies;
	}
	public void setAllergies(ims.core.vo.PatientAllergyCollection value)
	{
		this.isValidated = false;
		this.allergies = value;
	}
	public boolean getSeeScannedNotesIsNotNull()
	{
		return this.seescannednotes != null;
	}
	public Boolean getSeeScannedNotes()
	{
		return this.seescannednotes;
	}
	public void setSeeScannedNotes(Boolean value)
	{
		this.isValidated = false;
		this.seescannednotes = value;
	}
	public boolean getNotesDictatedIsNotNull()
	{
		return this.notesdictated != null;
	}
	public Boolean getNotesDictated()
	{
		return this.notesdictated;
	}
	public void setNotesDictated(Boolean value)
	{
		this.isValidated = false;
		this.notesdictated = value;
	}
	public boolean getIncludeNotesInGpReportIsNotNull()
	{
		return this.includenotesingpreport != null;
	}
	public Boolean getIncludeNotesInGpReport()
	{
		return this.includenotesingpreport;
	}
	public void setIncludeNotesInGpReport(Boolean value)
	{
		this.isValidated = false;
		this.includenotesingpreport = value;
	}
	public boolean getClinicalImpressionIsNotNull()
	{
		return this.clinicalimpression != null;
	}
	public String getClinicalImpression()
	{
		return this.clinicalimpression;
	}
	public static int getClinicalImpressionMaxLength()
	{
		return 5000;
	}
	public void setClinicalImpression(String value)
	{
		this.isValidated = false;
		this.clinicalimpression = value;
	}
	public boolean getHealthQuestionnaireCompletedIsNotNull()
	{
		return this.healthquestionnairecompleted != null;
	}
	public Boolean getHealthQuestionnaireCompleted()
	{
		return this.healthquestionnairecompleted;
	}
	public void setHealthQuestionnaireCompleted(Boolean value)
	{
		this.isValidated = false;
		this.healthquestionnairecompleted = value;
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
		if(this.recordinginformation != null)
		{
			if(!this.recordinginformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.lastupdatinghcp != null)
		{
			if(!this.lastupdatinghcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.initiallyseenby != null)
		{
			if(!this.initiallyseenby.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.allergies != null)
		{
			if(!this.allergies.isValidated())
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
		if(this.recordinginformation == null)
			listOfErrors.add("RecordingInformation is mandatory");
		if(this.recordinginformation != null)
		{
			String[] listOfOtherErrors = this.recordinginformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.lastupdatinghcp == null)
			listOfErrors.add("LastUpdatingHCP is mandatory");
		if(this.lastupdatinghcp != null)
		{
			String[] listOfOtherErrors = this.lastupdatinghcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.initiallyseenby == null)
			listOfErrors.add("InitiallySeenBy is mandatory");
		if(this.initiallyseenby != null)
		{
			String[] listOfOtherErrors = this.initiallyseenby.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.allergies != null)
		{
			String[] listOfOtherErrors = this.allergies.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
	
		ConsultationClinicalNotesVo clone = new ConsultationClinicalNotesVo(this.id, this.version);
		
		clone.catsreferral = this.catsreferral;
		if(this.recordinginformation == null)
			clone.recordinginformation = null;
		else
			clone.recordinginformation = (ims.core.vo.AuthoringInformationVo)this.recordinginformation.clone();
		if(this.lastupdatinghcp == null)
			clone.lastupdatinghcp = null;
		else
			clone.lastupdatinghcp = (ims.core.vo.AuthoringInformationVo)this.lastupdatinghcp.clone();
		if(this.initiallyseenby == null)
			clone.initiallyseenby = null;
		else
			clone.initiallyseenby = (ims.core.vo.AuthoringInformationVo)this.initiallyseenby.clone();
		clone.historypresentingcomplaint = this.historypresentingcomplaint;
		clone.relevantpmh = this.relevantpmh;
		clone.otherrelevanthistory = this.otherrelevanthistory;
		clone.relevantmedication = this.relevantmedication;
		clone.examination = this.examination;
		clone.hasnoknownallergies = this.hasnoknownallergies;
		if(this.allergies == null)
			clone.allergies = null;
		else
			clone.allergies = (ims.core.vo.PatientAllergyCollection)this.allergies.clone();
		clone.seescannednotes = this.seescannednotes;
		clone.notesdictated = this.notesdictated;
		clone.includenotesingpreport = this.includenotesingpreport;
		clone.clinicalimpression = this.clinicalimpression;
		clone.healthquestionnairecompleted = this.healthquestionnairecompleted;
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
		if (!(ConsultationClinicalNotesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ConsultationClinicalNotesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ConsultationClinicalNotesVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ConsultationClinicalNotesVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.historypresentingcomplaint != null)
			count++;
		if(this.relevantpmh != null)
			count++;
		if(this.otherrelevanthistory != null)
			count++;
		if(this.relevantmedication != null)
			count++;
		if(this.examination != null)
			count++;
		if(this.hasnoknownallergies != null)
			count++;
		if(this.allergies != null)
			count++;
		if(this.seescannednotes != null)
			count++;
		if(this.notesdictated != null)
			count++;
		if(this.includenotesingpreport != null)
			count++;
		if(this.clinicalimpression != null)
			count++;
		if(this.healthquestionnairecompleted != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 12;
	}
	protected String historypresentingcomplaint;
	protected String relevantpmh;
	protected String otherrelevanthistory;
	protected String relevantmedication;
	protected String examination;
	protected Boolean hasnoknownallergies;
	protected ims.core.vo.PatientAllergyCollection allergies;
	protected Boolean seescannednotes;
	protected Boolean notesdictated;
	protected Boolean includenotesingpreport;
	protected String clinicalimpression;
	protected Boolean healthquestionnairecompleted;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
