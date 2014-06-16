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

package ims.ocs_if.vo;


public class QueuedEventVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public QueuedEventVo()
	{
	}
	public QueuedEventVo(ims.ocs_if.vo.beans.QueuedEventVoBean bean)
	{
		this.id = bean.getID();
		this.queuetype = bean.getQueueType() == null ? null : ims.core.vo.lookups.QueueType.buildLookup(bean.getQueueType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocs_if.vo.beans.QueuedEventVoBean bean)
	{
		this.id = bean.getID();
		this.queuetype = bean.getQueueType() == null ? null : ims.core.vo.lookups.QueueType.buildLookup(bean.getQueueType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocs_if.vo.beans.QueuedEventVoBean bean = null;
		if(map != null)
			bean = (ims.ocs_if.vo.beans.QueuedEventVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocs_if.vo.beans.QueuedEventVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getIDIsNotNull()
	{
		return this.id != null;
	}
	public Integer getID()
	{
		return this.id;
	}
	public void setID(Integer value)
	{
		this.isValidated = false;
		this.id = value;
	}
	public boolean getQueueTypeIsNotNull()
	{
		return this.queuetype != null;
	}
	public ims.core.vo.lookups.QueueType getQueueType()
	{
		return this.queuetype;
	}
	public void setQueueType(ims.core.vo.lookups.QueueType value)
	{
		this.isValidated = false;
		this.queuetype = value;
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
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if(this.id != null)
			sb.append(this.id);
		if(this.queuetype != null)
			sb.append(this.queuetype);
		return sb.toString();
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof QueuedEventVo))
			return false;
		QueuedEventVo compareObj = (QueuedEventVo)obj;
		if(this.getID() == null && compareObj.getID() != null)
			return false;
		if(this.getID() != null && compareObj.getID() == null)
			return false;
		if(this.getID() != null && compareObj.getID() != null)
			if(!this.getID().equals(compareObj.getID()))
				return false;
		if(this.getQueueType() == null && compareObj.getQueueType() != null)
			return false;
		if(this.getQueueType() != null && compareObj.getQueueType() == null)
			return false;
		if(this.getQueueType() != null && compareObj.getQueueType() != null)
			return this.getQueueType().equals(compareObj.getQueueType());
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
	
		QueuedEventVo clone = new QueuedEventVo();
		
		clone.id = this.id;
		if(this.queuetype == null)
			clone.queuetype = null;
		else
			clone.queuetype = (ims.core.vo.lookups.QueueType)this.queuetype.clone();
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
		if (!(QueuedEventVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A QueuedEventVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		QueuedEventVo compareObj = (QueuedEventVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID() == null && compareObj.getID() != null)
				return -1;
			if(this.getID() != null && compareObj.getID() == null)
				return 1;
			if(this.getID() != null && compareObj.getID() != null)
				retVal = this.getID().compareTo(compareObj.getID());
		}
		if (retVal == 0)
		{
			if(this.getQueueType() == null && compareObj.getQueueType() != null)
				return -1;
			if(this.getQueueType() != null && compareObj.getQueueType() == null)
				return 1;
			if(this.getQueueType() != null && compareObj.getQueueType() != null)
				retVal = this.getQueueType().compareTo(compareObj.getQueueType());
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
		if(this.id != null)
			count++;
		if(this.queuetype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected Integer id;
	protected ims.core.vo.lookups.QueueType queuetype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
