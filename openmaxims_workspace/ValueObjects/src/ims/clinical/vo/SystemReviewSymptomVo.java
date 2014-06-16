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

package ims.clinical.vo;

/**
 * Linked to clinical.SystemReviewSymptoms business object (ID: 1072100004).
 */
public class SystemReviewSymptomVo extends ims.clinical.vo.SystemReviewSymptomsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SystemReviewSymptomVo()
	{
	}
	public SystemReviewSymptomVo(Integer id, int version)
	{
		super(id, version);
	}
	public SystemReviewSymptomVo(ims.clinical.vo.beans.SystemReviewSymptomVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.symptom = bean.getSymptom() == null ? null : ims.clinical.vo.lookups.Symptoms.buildLookup(bean.getSymptom());
		this.absentpresent = bean.getAbsentPresent() == null ? null : ims.clinical.vo.lookups.AbsentPresent.buildLookup(bean.getAbsentPresent());
		this.durationvalue = bean.getDurationValue();
		this.durationunit = bean.getDurationUnit() == null ? null : ims.core.vo.lookups.TimeDaystoYears.buildLookup(bean.getDurationUnit());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.SystemReviewSymptomVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.symptom = bean.getSymptom() == null ? null : ims.clinical.vo.lookups.Symptoms.buildLookup(bean.getSymptom());
		this.absentpresent = bean.getAbsentPresent() == null ? null : ims.clinical.vo.lookups.AbsentPresent.buildLookup(bean.getAbsentPresent());
		this.durationvalue = bean.getDurationValue();
		this.durationunit = bean.getDurationUnit() == null ? null : ims.core.vo.lookups.TimeDaystoYears.buildLookup(bean.getDurationUnit());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.SystemReviewSymptomVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.SystemReviewSymptomVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.SystemReviewSymptomVoBean();
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
		if(fieldName.equals("SYMPTOM"))
			return getSymptom();
		if(fieldName.equals("ABSENTPRESENT"))
			return getAbsentPresent();
		if(fieldName.equals("DURATIONVALUE"))
			return getDurationValue();
		if(fieldName.equals("DURATIONUNIT"))
			return getDurationUnit();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSymptomIsNotNull()
	{
		return this.symptom != null;
	}
	public ims.clinical.vo.lookups.Symptoms getSymptom()
	{
		return this.symptom;
	}
	public void setSymptom(ims.clinical.vo.lookups.Symptoms value)
	{
		this.isValidated = false;
		this.symptom = value;
	}
	public boolean getAbsentPresentIsNotNull()
	{
		return this.absentpresent != null;
	}
	public ims.clinical.vo.lookups.AbsentPresent getAbsentPresent()
	{
		return this.absentpresent;
	}
	public void setAbsentPresent(ims.clinical.vo.lookups.AbsentPresent value)
	{
		this.isValidated = false;
		this.absentpresent = value;
	}
	public boolean getDurationValueIsNotNull()
	{
		return this.durationvalue != null;
	}
	public Integer getDurationValue()
	{
		return this.durationvalue;
	}
	public void setDurationValue(Integer value)
	{
		this.isValidated = false;
		this.durationvalue = value;
	}
	public boolean getDurationUnitIsNotNull()
	{
		return this.durationunit != null;
	}
	public ims.core.vo.lookups.TimeDaystoYears getDurationUnit()
	{
		return this.durationunit;
	}
	public void setDurationUnit(ims.core.vo.lookups.TimeDaystoYears value)
	{
		this.isValidated = false;
		this.durationunit = value;
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
		if(this.symptom == null)
			listOfErrors.add("Symptom is mandatory");
		if(this.absentpresent == null)
			listOfErrors.add("AbsentPresent is mandatory");
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
	
		SystemReviewSymptomVo clone = new SystemReviewSymptomVo(this.id, this.version);
		
		if(this.symptom == null)
			clone.symptom = null;
		else
			clone.symptom = (ims.clinical.vo.lookups.Symptoms)this.symptom.clone();
		if(this.absentpresent == null)
			clone.absentpresent = null;
		else
			clone.absentpresent = (ims.clinical.vo.lookups.AbsentPresent)this.absentpresent.clone();
		clone.durationvalue = this.durationvalue;
		if(this.durationunit == null)
			clone.durationunit = null;
		else
			clone.durationunit = (ims.core.vo.lookups.TimeDaystoYears)this.durationunit.clone();
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
		if (!(SystemReviewSymptomVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SystemReviewSymptomVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		SystemReviewSymptomVo compareObj = (SystemReviewSymptomVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_SystemReviewSymptoms() == null && compareObj.getID_SystemReviewSymptoms() != null)
				return -1;
			if(this.getID_SystemReviewSymptoms() != null && compareObj.getID_SystemReviewSymptoms() == null)
				return 1;
			if(this.getID_SystemReviewSymptoms() != null && compareObj.getID_SystemReviewSymptoms() != null)
				retVal = this.getID_SystemReviewSymptoms().compareTo(compareObj.getID_SystemReviewSymptoms());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.symptom != null)
			count++;
		if(this.absentpresent != null)
			count++;
		if(this.durationvalue != null)
			count++;
		if(this.durationunit != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.clinical.vo.lookups.Symptoms symptom;
	protected ims.clinical.vo.lookups.AbsentPresent absentpresent;
	protected Integer durationvalue;
	protected ims.core.vo.lookups.TimeDaystoYears durationunit;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
