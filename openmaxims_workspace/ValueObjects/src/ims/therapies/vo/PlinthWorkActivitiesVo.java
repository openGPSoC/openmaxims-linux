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

package ims.therapies.vo;

/**
 * Linked to therapies.treatment.PlinthWorkActivities business object (ID: 1044100004).
 */
public class PlinthWorkActivitiesVo extends ims.therapies.treatment.vo.PlinthWorkActivitiesRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PlinthWorkActivitiesVo()
	{
	}
	public PlinthWorkActivitiesVo(Integer id, int version)
	{
		super(id, version);
	}
	public PlinthWorkActivitiesVo(ims.therapies.vo.beans.PlinthWorkActivitiesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.position = bean.getPosition() == null ? null : ims.therapies.vo.lookups.PlinthWorkActivity.buildLookup(bean.getPosition());
		this.activity = bean.getActivity();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.PlinthWorkActivitiesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.position = bean.getPosition() == null ? null : ims.therapies.vo.lookups.PlinthWorkActivity.buildLookup(bean.getPosition());
		this.activity = bean.getActivity();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.PlinthWorkActivitiesVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.PlinthWorkActivitiesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.PlinthWorkActivitiesVoBean();
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
		if(fieldName.equals("POSITION"))
			return getPosition();
		if(fieldName.equals("ACTIVITY"))
			return getActivity();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPositionIsNotNull()
	{
		return this.position != null;
	}
	public ims.therapies.vo.lookups.PlinthWorkActivity getPosition()
	{
		return this.position;
	}
	public void setPosition(ims.therapies.vo.lookups.PlinthWorkActivity value)
	{
		this.isValidated = false;
		this.position = value;
	}
	public boolean getActivityIsNotNull()
	{
		return this.activity != null;
	}
	public String getActivity()
	{
		return this.activity;
	}
	public static int getActivityMaxLength()
	{
		return 255;
	}
	public void setActivity(String value)
	{
		this.isValidated = false;
		this.activity = value;
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
		if(this.activity != null)
			if(this.activity.length() > 255)
				listOfErrors.add("The length of the field [activity] in the value object [ims.therapies.vo.PlinthWorkActivitiesVo] is too big. It should be less or equal to 255");
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
	
		PlinthWorkActivitiesVo clone = new PlinthWorkActivitiesVo(this.id, this.version);
		
		if(this.position == null)
			clone.position = null;
		else
			clone.position = (ims.therapies.vo.lookups.PlinthWorkActivity)this.position.clone();
		clone.activity = this.activity;
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
		if (!(PlinthWorkActivitiesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PlinthWorkActivitiesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PlinthWorkActivitiesVo compareObj = (PlinthWorkActivitiesVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPosition() == null && compareObj.getPosition() != null)
				return -1;
			if(this.getPosition() != null && compareObj.getPosition() == null)
				return 1;
			if(this.getPosition() != null && compareObj.getPosition() != null)
				retVal = this.getPosition().compareTo(compareObj.getPosition());
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
		if(this.position != null)
			count++;
		if(this.activity != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.therapies.vo.lookups.PlinthWorkActivity position;
	protected String activity;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
