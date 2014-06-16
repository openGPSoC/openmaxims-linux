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


public class BaseListVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public BaseListVo()
	{
	}
	public BaseListVo(ims.core.vo.beans.BaseListVoBean bean)
	{
		this.compositeid = bean.getCompositeID();
		this.name = bean.getName();
		this.boolvalue = bean.getBoolValue();
		this.singleid = bean.getSingleID();
		this.description = bean.getDescription();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.BaseListVoBean bean)
	{
		this.compositeid = bean.getCompositeID();
		this.name = bean.getName();
		this.boolvalue = bean.getBoolValue();
		this.singleid = bean.getSingleID();
		this.description = bean.getDescription();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.BaseListVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.BaseListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.BaseListVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getCompositeIDIsNotNull()
	{
		return this.compositeid != null;
	}
	public Integer getCompositeID()
	{
		return this.compositeid;
	}
	public void setCompositeID(Integer value)
	{
		this.isValidated = false;
		this.compositeid = value;
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 255;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getBoolValueIsNotNull()
	{
		return this.boolvalue != null;
	}
	public Boolean getBoolValue()
	{
		return this.boolvalue;
	}
	public void setBoolValue(Boolean value)
	{
		this.isValidated = false;
		this.boolvalue = value;
	}
	public boolean getSingleIDIsNotNull()
	{
		return this.singleid != null;
	}
	public Integer getSingleID()
	{
		return this.singleid;
	}
	public void setSingleID(Integer value)
	{
		this.isValidated = false;
		this.singleid = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 255;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
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
		if(!(obj instanceof BaseListVo))
			return false;
		BaseListVo compareObj = (BaseListVo)obj;
		if(this.getCompositeID() == null && compareObj.getCompositeID() != null)
			return false;
		if(this.getCompositeID() != null && compareObj.getCompositeID() == null)
			return false;
		if(this.getCompositeID() != null && compareObj.getCompositeID() != null)
			return this.getCompositeID().equals(compareObj.getCompositeID());
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
	
		BaseListVo clone = new BaseListVo();
		
		clone.compositeid = this.compositeid;
		clone.name = this.name;
		clone.boolvalue = this.boolvalue;
		clone.singleid = this.singleid;
		clone.description = this.description;
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
		if (!(BaseListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A BaseListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		BaseListVo compareObj = (BaseListVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getCompositeID() == null && compareObj.getCompositeID() != null)
				return -1;
			if(this.getCompositeID() != null && compareObj.getCompositeID() == null)
				return 1;
			if(this.getCompositeID() != null && compareObj.getCompositeID() != null)
				retVal = this.getCompositeID().compareTo(compareObj.getCompositeID());
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
		if(this.compositeid != null)
			count++;
		if(this.name != null)
			count++;
		if(this.boolvalue != null)
			count++;
		if(this.singleid != null)
			count++;
		if(this.description != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected Integer compositeid;
	protected String name;
	protected Boolean boolvalue;
	protected Integer singleid;
	protected String description;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
