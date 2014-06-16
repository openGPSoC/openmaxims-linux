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


public class InPatientListSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InPatientListSearchCriteriaVo()
	{
	}
	public InPatientListSearchCriteriaVo(ims.core.vo.beans.InPatientListSearchCriteriaVoBean bean)
	{
		this.hospital = bean.getHospital() == null ? null : bean.getHospital().buildVo();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo();
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.InPatientListSearchCriteriaVoBean bean)
	{
		this.hospital = bean.getHospital() == null ? null : bean.getHospital().buildVo(map);
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo(map);
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.InPatientListSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.InPatientListSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.InPatientListSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getHospitalIsNotNull()
	{
		return this.hospital != null;
	}
	public ims.core.vo.LocShortMappingsVo getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.core.vo.LocShortMappingsVo value)
	{
		this.isValidated = false;
		this.hospital = value;
	}
	public boolean getWardIsNotNull()
	{
		return this.ward != null;
	}
	public ims.core.vo.LocShortMappingsVo getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.LocShortMappingsVo value)
	{
		this.isValidated = false;
		this.ward = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.vo.MedicLiteVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.MedicLiteVo value)
	{
		this.isValidated = false;
		this.consultant = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
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
		if(this.hospital != null)
		{
			if(!this.hospital.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.ward != null)
		{
			if(!this.ward.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.consultant != null)
		{
			if(!this.consultant.isValidated())
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
		if(this.hospital != null)
		{
			String[] listOfOtherErrors = this.hospital.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ward != null)
		{
			String[] listOfOtherErrors = this.ward.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.consultant != null)
		{
			String[] listOfOtherErrors = this.consultant.validate();
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		InPatientListSearchCriteriaVo clone = new InPatientListSearchCriteriaVo();
		
		if(this.hospital == null)
			clone.hospital = null;
		else
			clone.hospital = (ims.core.vo.LocShortMappingsVo)this.hospital.clone();
		if(this.ward == null)
			clone.ward = null;
		else
			clone.ward = (ims.core.vo.LocShortMappingsVo)this.ward.clone();
		if(this.consultant == null)
			clone.consultant = null;
		else
			clone.consultant = (ims.core.vo.MedicLiteVo)this.consultant.clone();
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
		if (!(InPatientListSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InPatientListSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		InPatientListSearchCriteriaVo compareObj = (InPatientListSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getHospital() == null && compareObj.getHospital() != null)
				return -1;
			if(this.getHospital() != null && compareObj.getHospital() == null)
				return 1;
			if(this.getHospital() != null && compareObj.getHospital() != null)
				retVal = this.getHospital().compareTo(compareObj.getHospital());
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
		if(this.hospital != null)
			count++;
		if(this.ward != null)
			count++;
		if(this.consultant != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.LocShortMappingsVo hospital;
	protected ims.core.vo.LocShortMappingsVo ward;
	protected ims.core.vo.MedicLiteVo consultant;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
