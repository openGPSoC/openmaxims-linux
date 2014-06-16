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

package ims.core.vo;

/**
 * Linked to core.clinical.PatientNoAllergyInfo business object (ID: 1003100085).
 */
public class PatientNoAllergyInfoForTriageVo extends ims.core.clinical.vo.PatientNoAllergyInfoRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientNoAllergyInfoForTriageVo()
	{
	}
	public PatientNoAllergyInfoForTriageVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientNoAllergyInfoForTriageVo(ims.core.vo.beans.PatientNoAllergyInfoForTriageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.allergystatus = bean.getAllergyStatus() == null ? null : ims.core.vo.lookups.PatientAllergyStatus.buildLookup(bean.getAllergyStatus());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.whenidentified = bean.getWhenIdentified() == null ? null : bean.getWhenIdentified().buildPartialDate();
		this.sourceofinformation = bean.getSourceofInformation() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getSourceofInformation());
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientNoAllergyInfoForTriageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.allergystatus = bean.getAllergyStatus() == null ? null : ims.core.vo.lookups.PatientAllergyStatus.buildLookup(bean.getAllergyStatus());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.whenidentified = bean.getWhenIdentified() == null ? null : bean.getWhenIdentified().buildPartialDate();
		this.sourceofinformation = bean.getSourceofInformation() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getSourceofInformation());
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientNoAllergyInfoForTriageVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientNoAllergyInfoForTriageVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientNoAllergyInfoForTriageVoBean();
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
		if(fieldName.equals("ALLERGYSTATUS"))
			return getAllergyStatus();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("WHENIDENTIFIED"))
			return getWhenIdentified();
		if(fieldName.equals("SOURCEOFINFORMATION"))
			return getSourceofInformation();
		if(fieldName.equals("RECORDINGINFORMATION"))
			return getRecordingInformation();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getAllergyStatusIsNotNull()
	{
		return this.allergystatus != null;
	}
	public ims.core.vo.lookups.PatientAllergyStatus getAllergyStatus()
	{
		return this.allergystatus;
	}
	public void setAllergyStatus(ims.core.vo.lookups.PatientAllergyStatus value)
	{
		this.isValidated = false;
		this.allergystatus = value;
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInfoForTriageVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInfoForTriageVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getWhenIdentifiedIsNotNull()
	{
		return this.whenidentified != null;
	}
	public ims.framework.utils.PartialDate getWhenIdentified()
	{
		return this.whenidentified;
	}
	public void setWhenIdentified(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.whenidentified = value;
	}
	public boolean getSourceofInformationIsNotNull()
	{
		return this.sourceofinformation != null;
	}
	public ims.core.vo.lookups.SourceofInformation getSourceofInformation()
	{
		return this.sourceofinformation;
	}
	public void setSourceofInformation(ims.core.vo.lookups.SourceofInformation value)
	{
		this.isValidated = false;
		this.sourceofinformation = value;
	}
	public boolean getRecordingInformationIsNotNull()
	{
		return this.recordinginformation != null;
	}
	public ims.core.vo.RecordingUserInformationForTriageVo getRecordingInformation()
	{
		return this.recordinginformation;
	}
	public void setRecordingInformation(ims.core.vo.RecordingUserInformationForTriageVo value)
	{
		this.isValidated = false;
		this.recordinginformation = value;
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
		if(this.recordinginformation != null)
		{
			if(!this.recordinginformation.isValidated())
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
		if(this.allergystatus == null)
			listOfErrors.add("AllergyStatus is mandatory");
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
		if(this.sourceofinformation == null)
			listOfErrors.add("SourceofInformation is mandatory");
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
	
		PatientNoAllergyInfoForTriageVo clone = new PatientNoAllergyInfoForTriageVo(this.id, this.version);
		
		clone.patient = this.patient;
		if(this.allergystatus == null)
			clone.allergystatus = null;
		else
			clone.allergystatus = (ims.core.vo.lookups.PatientAllergyStatus)this.allergystatus.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInfoForTriageVo)this.authoringinformation.clone();
		if(this.whenidentified == null)
			clone.whenidentified = null;
		else
			clone.whenidentified = (ims.framework.utils.PartialDate)this.whenidentified.clone();
		if(this.sourceofinformation == null)
			clone.sourceofinformation = null;
		else
			clone.sourceofinformation = (ims.core.vo.lookups.SourceofInformation)this.sourceofinformation.clone();
		if(this.recordinginformation == null)
			clone.recordinginformation = null;
		else
			clone.recordinginformation = (ims.core.vo.RecordingUserInformationForTriageVo)this.recordinginformation.clone();
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
		if (!(PatientNoAllergyInfoForTriageVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientNoAllergyInfoForTriageVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientNoAllergyInfoForTriageVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientNoAllergyInfoForTriageVo)obj).getBoId());
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
		if(this.allergystatus != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.whenidentified != null)
			count++;
		if(this.sourceofinformation != null)
			count++;
		if(this.recordinginformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.vo.lookups.PatientAllergyStatus allergystatus;
	protected ims.core.vo.AuthoringInfoForTriageVo authoringinformation;
	protected ims.framework.utils.PartialDate whenidentified;
	protected ims.core.vo.lookups.SourceofInformation sourceofinformation;
	protected ims.core.vo.RecordingUserInformationForTriageVo recordinginformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
