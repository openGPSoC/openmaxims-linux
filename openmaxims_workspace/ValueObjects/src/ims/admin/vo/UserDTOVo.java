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

package ims.admin.vo;


public class UserDTOVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public UserDTOVo()
	{
	}
	public UserDTOVo(ims.admin.vo.beans.UserDTOVoBean bean)
	{
		this.username = bean.getUserName();
		this.effectiveto = bean.getEffectiveTo() == null ? null : bean.getEffectiveTo().buildDateTime();
		this.effectivefrom = bean.getEffectiveFrom() == null ? null : bean.getEffectiveFrom().buildDateTime();
		this.passwordexpirydate = bean.getPasswordExpiryDate() == null ? null : bean.getPasswordExpiryDate().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.UserDTOVoBean bean)
	{
		this.username = bean.getUserName();
		this.effectiveto = bean.getEffectiveTo() == null ? null : bean.getEffectiveTo().buildDateTime();
		this.effectivefrom = bean.getEffectiveFrom() == null ? null : bean.getEffectiveFrom().buildDateTime();
		this.passwordexpirydate = bean.getPasswordExpiryDate() == null ? null : bean.getPasswordExpiryDate().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.UserDTOVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.UserDTOVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.UserDTOVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getUserNameIsNotNull()
	{
		return this.username != null;
	}
	public String getUserName()
	{
		return this.username;
	}
	public static int getUserNameMaxLength()
	{
		return 255;
	}
	public void setUserName(String value)
	{
		this.isValidated = false;
		this.username = value;
	}
	public boolean getEffectiveToIsNotNull()
	{
		return this.effectiveto != null;
	}
	public ims.framework.utils.DateTime getEffectiveTo()
	{
		return this.effectiveto;
	}
	public void setEffectiveTo(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.effectiveto = value;
	}
	public boolean getEffectiveFromIsNotNull()
	{
		return this.effectivefrom != null;
	}
	public ims.framework.utils.DateTime getEffectiveFrom()
	{
		return this.effectivefrom;
	}
	public void setEffectiveFrom(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.effectivefrom = value;
	}
	public boolean getPasswordExpiryDateIsNotNull()
	{
		return this.passwordexpirydate != null;
	}
	public ims.framework.utils.Date getPasswordExpiryDate()
	{
		return this.passwordexpirydate;
	}
	public void setPasswordExpiryDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.passwordexpirydate = value;
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
		if(!(obj instanceof UserDTOVo))
			return false;
		UserDTOVo compareObj = (UserDTOVo)obj;
		if(this.getUserName() == null && compareObj.getUserName() != null)
			return false;
		if(this.getUserName() != null && compareObj.getUserName() == null)
			return false;
		if(this.getUserName() != null && compareObj.getUserName() != null)
			return this.getUserName().equals(compareObj.getUserName());
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
	
		UserDTOVo clone = new UserDTOVo();
		
		clone.username = this.username;
		if(this.effectiveto == null)
			clone.effectiveto = null;
		else
			clone.effectiveto = (ims.framework.utils.DateTime)this.effectiveto.clone();
		if(this.effectivefrom == null)
			clone.effectivefrom = null;
		else
			clone.effectivefrom = (ims.framework.utils.DateTime)this.effectivefrom.clone();
		if(this.passwordexpirydate == null)
			clone.passwordexpirydate = null;
		else
			clone.passwordexpirydate = (ims.framework.utils.Date)this.passwordexpirydate.clone();
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
		if (!(UserDTOVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A UserDTOVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		UserDTOVo compareObj = (UserDTOVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getUserName() == null && compareObj.getUserName() != null)
				return -1;
			if(this.getUserName() != null && compareObj.getUserName() == null)
				return 1;
			if(this.getUserName() != null && compareObj.getUserName() != null)
			{
				if(caseInsensitive)
					retVal = this.getUserName().toLowerCase().compareTo(compareObj.getUserName().toLowerCase());
				else
					retVal = this.getUserName().compareTo(compareObj.getUserName());
			}
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
		if(this.username != null)
			count++;
		if(this.effectiveto != null)
			count++;
		if(this.effectivefrom != null)
			count++;
		if(this.passwordexpirydate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String username;
	protected ims.framework.utils.DateTime effectiveto;
	protected ims.framework.utils.DateTime effectivefrom;
	protected ims.framework.utils.Date passwordexpirydate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
