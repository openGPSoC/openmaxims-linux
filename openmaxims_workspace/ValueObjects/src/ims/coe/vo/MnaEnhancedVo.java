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

package ims.coe.vo;


public class MnaEnhancedVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MnaEnhancedVo()
	{
	}
	public MnaEnhancedVo(ims.coe.vo.beans.MnaEnhancedVoBean bean)
	{
		this.mnarecord = bean.getMnaRecord() == null ? null : bean.getMnaRecord().buildVo();
		this.aedrecord = bean.getAedRecord() == null ? null : bean.getAedRecord().buildVo();
		this.vsrecord = bean.getVsRecord() == null ? null : bean.getVsRecord().buildVo();
		this.ashrecord = bean.getAshRecord() == null ? null : bean.getAshRecord().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.beans.MnaEnhancedVoBean bean)
	{
		this.mnarecord = bean.getMnaRecord() == null ? null : bean.getMnaRecord().buildVo(map);
		this.aedrecord = bean.getAedRecord() == null ? null : bean.getAedRecord().buildVo(map);
		this.vsrecord = bean.getVsRecord() == null ? null : bean.getVsRecord().buildVo(map);
		this.ashrecord = bean.getAshRecord() == null ? null : bean.getAshRecord().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.beans.MnaEnhancedVoBean bean = null;
		if(map != null)
			bean = (ims.coe.vo.beans.MnaEnhancedVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.coe.vo.beans.MnaEnhancedVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getMnaRecordIsNotNull()
	{
		return this.mnarecord != null;
	}
	public ims.nursing.vo.MiniNutritionalAssessment getMnaRecord()
	{
		return this.mnarecord;
	}
	public void setMnaRecord(ims.nursing.vo.MiniNutritionalAssessment value)
	{
		this.isValidated = false;
		this.mnarecord = value;
	}
	public boolean getAedRecordIsNotNull()
	{
		return this.aedrecord != null;
	}
	public ims.coe.vo.AssessmentEatingAndDrinking getAedRecord()
	{
		return this.aedrecord;
	}
	public void setAedRecord(ims.coe.vo.AssessmentEatingAndDrinking value)
	{
		this.isValidated = false;
		this.aedrecord = value;
	}
	public boolean getVsRecordIsNotNull()
	{
		return this.vsrecord != null;
	}
	public ims.core.vo.VitalSignsVo getVsRecord()
	{
		return this.vsrecord;
	}
	public void setVsRecord(ims.core.vo.VitalSignsVo value)
	{
		this.isValidated = false;
		this.vsrecord = value;
	}
	public boolean getAshRecordIsNotNull()
	{
		return this.ashrecord != null;
	}
	public ims.nursing.vo.AssessmentHeaderInfo getAshRecord()
	{
		return this.ashrecord;
	}
	public void setAshRecord(ims.nursing.vo.AssessmentHeaderInfo value)
	{
		this.isValidated = false;
		this.ashrecord = value;
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
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof MnaEnhancedVo))
			return false;
		MnaEnhancedVo compareObj = (MnaEnhancedVo)obj;
		if(this.getMnaRecord() == null && compareObj.getMnaRecord() != null)
			return false;
		if(this.getMnaRecord() != null && compareObj.getMnaRecord() == null)
			return false;
		if(this.getMnaRecord() != null && compareObj.getMnaRecord() != null)
			return this.getMnaRecord().equals(compareObj.getMnaRecord());
		return super.equals(obj);
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
		if(this.mnarecord != null)
		{
			if(!this.mnarecord.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.aedrecord != null)
		{
			if(!this.aedrecord.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.vsrecord != null)
		{
			if(!this.vsrecord.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.ashrecord != null)
		{
			if(!this.ashrecord.isValidated())
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
		if(this.mnarecord != null)
		{
			String[] listOfOtherErrors = this.mnarecord.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.aedrecord != null)
		{
			String[] listOfOtherErrors = this.aedrecord.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.vsrecord != null)
		{
			String[] listOfOtherErrors = this.vsrecord.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ashrecord != null)
		{
			String[] listOfOtherErrors = this.ashrecord.validate();
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
	
		MnaEnhancedVo clone = new MnaEnhancedVo();
		
		if(this.mnarecord == null)
			clone.mnarecord = null;
		else
			clone.mnarecord = (ims.nursing.vo.MiniNutritionalAssessment)this.mnarecord.clone();
		if(this.aedrecord == null)
			clone.aedrecord = null;
		else
			clone.aedrecord = (ims.coe.vo.AssessmentEatingAndDrinking)this.aedrecord.clone();
		if(this.vsrecord == null)
			clone.vsrecord = null;
		else
			clone.vsrecord = (ims.core.vo.VitalSignsVo)this.vsrecord.clone();
		if(this.ashrecord == null)
			clone.ashrecord = null;
		else
			clone.ashrecord = (ims.nursing.vo.AssessmentHeaderInfo)this.ashrecord.clone();
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
		if (!(MnaEnhancedVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MnaEnhancedVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MnaEnhancedVo compareObj = (MnaEnhancedVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getMnaRecord() == null && compareObj.getMnaRecord() != null)
				return -1;
			if(this.getMnaRecord() != null && compareObj.getMnaRecord() == null)
				return 1;
			if(this.getMnaRecord() != null && compareObj.getMnaRecord() != null)
				retVal = this.getMnaRecord().compareTo(compareObj.getMnaRecord());
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
		if(this.mnarecord != null)
			count++;
		if(this.aedrecord != null)
			count++;
		if(this.vsrecord != null)
			count++;
		if(this.ashrecord != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.nursing.vo.MiniNutritionalAssessment mnarecord;
	protected ims.coe.vo.AssessmentEatingAndDrinking aedrecord;
	protected ims.core.vo.VitalSignsVo vsrecord;
	protected ims.nursing.vo.AssessmentHeaderInfo ashrecord;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
