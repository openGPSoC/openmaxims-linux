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
 * Linked to clinical.CorrespondenceRecipients business object (ID: 1072100030).
 */
public class ClinicalCorrespondenceRecipientsVo extends ims.clinical.vo.CorrespondenceRecipientsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalCorrespondenceRecipientsVo()
	{
	}
	public ClinicalCorrespondenceRecipientsVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicalCorrespondenceRecipientsVo(ims.clinical.vo.beans.ClinicalCorrespondenceRecipientsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.generalpractitioner = bean.getGeneralPractitioner() == null ? null : bean.getGeneralPractitioner().buildVo();
		this.memberofstaff = bean.getMemberOfStaff() == null ? null : bean.getMemberOfStaff().buildVo();
		this.patient = bean.getPatient();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.ClinicalCorrespondenceRecipientsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.generalpractitioner = bean.getGeneralPractitioner() == null ? null : bean.getGeneralPractitioner().buildVo(map);
		this.memberofstaff = bean.getMemberOfStaff() == null ? null : bean.getMemberOfStaff().buildVo(map);
		this.patient = bean.getPatient();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.ClinicalCorrespondenceRecipientsVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.ClinicalCorrespondenceRecipientsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.ClinicalCorrespondenceRecipientsVoBean();
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
		if(fieldName.equals("GENERALPRACTITIONER"))
			return getGeneralPractitioner();
		if(fieldName.equals("MEMBEROFSTAFF"))
			return getMemberOfStaff();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getGeneralPractitionerIsNotNull()
	{
		return this.generalpractitioner != null;
	}
	public ims.core.vo.GpShortVo getGeneralPractitioner()
	{
		return this.generalpractitioner;
	}
	public void setGeneralPractitioner(ims.core.vo.GpShortVo value)
	{
		this.isValidated = false;
		this.generalpractitioner = value;
	}
	public boolean getMemberOfStaffIsNotNull()
	{
		return this.memberofstaff != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getMemberOfStaff()
	{
		return this.memberofstaff;
	}
	public void setMemberOfStaff(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.memberofstaff = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public Boolean getPatient()
	{
		return this.patient;
	}
	public void setPatient(Boolean value)
	{
		this.isValidated = false;
		this.patient = value;
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
		if(this.generalpractitioner != null)
		{
			if(!this.generalpractitioner.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.memberofstaff != null)
		{
			if(!this.memberofstaff.isValidated())
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
		if(this.generalpractitioner != null)
		{
			String[] listOfOtherErrors = this.generalpractitioner.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.memberofstaff != null)
		{
			String[] listOfOtherErrors = this.memberofstaff.validate();
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
	
		ClinicalCorrespondenceRecipientsVo clone = new ClinicalCorrespondenceRecipientsVo(this.id, this.version);
		
		if(this.generalpractitioner == null)
			clone.generalpractitioner = null;
		else
			clone.generalpractitioner = (ims.core.vo.GpShortVo)this.generalpractitioner.clone();
		if(this.memberofstaff == null)
			clone.memberofstaff = null;
		else
			clone.memberofstaff = (ims.core.vo.MemberOfStaffLiteVo)this.memberofstaff.clone();
		clone.patient = this.patient;
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
		if (!(ClinicalCorrespondenceRecipientsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalCorrespondenceRecipientsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ClinicalCorrespondenceRecipientsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ClinicalCorrespondenceRecipientsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.generalpractitioner != null)
			count++;
		if(this.memberofstaff != null)
			count++;
		if(this.patient != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.GpShortVo generalpractitioner;
	protected ims.core.vo.MemberOfStaffLiteVo memberofstaff;
	protected Boolean patient;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
