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


public class LogFileVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public LogFileVo()
	{
	}
	public LogFileVo(ims.admin.vo.beans.LogFileVoBean bean)
	{
		this.filename = bean.getFileName();
		this.location = bean.getLocation();
		this.size = bean.getSize();
		this.logcontent = bean.getLogContent();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.LogFileVoBean bean)
	{
		this.filename = bean.getFileName();
		this.location = bean.getLocation();
		this.size = bean.getSize();
		this.logcontent = bean.getLogContent();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.LogFileVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.LogFileVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.LogFileVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getFileNameIsNotNull()
	{
		return this.filename != null;
	}
	public String getFileName()
	{
		return this.filename;
	}
	public static int getFileNameMaxLength()
	{
		return 255;
	}
	public void setFileName(String value)
	{
		this.isValidated = false;
		this.filename = value;
	}
	public boolean getLocationIsNotNull()
	{
		return this.location != null;
	}
	public String getLocation()
	{
		return this.location;
	}
	public static int getLocationMaxLength()
	{
		return 255;
	}
	public void setLocation(String value)
	{
		this.isValidated = false;
		this.location = value;
	}
	public boolean getSizeIsNotNull()
	{
		return this.size != null;
	}
	public Integer getSize()
	{
		return this.size;
	}
	public void setSize(Integer value)
	{
		this.isValidated = false;
		this.size = value;
	}
	public boolean getLogContentIsNotNull()
	{
		return this.logcontent != null;
	}
	public String getLogContent()
	{
		return this.logcontent;
	}
	public static int getLogContentMaxLength()
	{
		return 255;
	}
	public void setLogContent(String value)
	{
		this.isValidated = false;
		this.logcontent = value;
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
		if(!(obj instanceof LogFileVo))
			return false;
		LogFileVo compareObj = (LogFileVo)obj;
		if(this.getFileName() == null && compareObj.getFileName() != null)
			return false;
		if(this.getFileName() != null && compareObj.getFileName() == null)
			return false;
		if(this.getFileName() != null && compareObj.getFileName() != null)
			return this.getFileName().equals(compareObj.getFileName());
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
	
		LogFileVo clone = new LogFileVo();
		
		clone.filename = this.filename;
		clone.location = this.location;
		clone.size = this.size;
		clone.logcontent = this.logcontent;
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
		if (!(LogFileVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A LogFileVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		LogFileVo compareObj = (LogFileVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getFileName() == null && compareObj.getFileName() != null)
				return -1;
			if(this.getFileName() != null && compareObj.getFileName() == null)
				return 1;
			if(this.getFileName() != null && compareObj.getFileName() != null)
			{
				if(caseInsensitive)
					retVal = this.getFileName().toLowerCase().compareTo(compareObj.getFileName().toLowerCase());
				else
					retVal = this.getFileName().compareTo(compareObj.getFileName());
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
		if(this.filename != null)
			count++;
		if(this.location != null)
			count++;
		if(this.size != null)
			count++;
		if(this.logcontent != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String filename;
	protected String location;
	protected Integer size;
	protected String logcontent;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
