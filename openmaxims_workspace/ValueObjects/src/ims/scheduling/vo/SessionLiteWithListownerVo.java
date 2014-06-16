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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.Sch_Session business object (ID: 1055100010).
 */
public class SessionLiteWithListownerVo extends ims.scheduling.vo.Sch_SessionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SessionLiteWithListownerVo()
	{
	}
	public SessionLiteWithListownerVo(Integer id, int version)
	{
		super(id, version);
	}
	public SessionLiteWithListownerVo(ims.scheduling.vo.beans.SessionLiteWithListownerVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.schlocation = bean.getSchLocation() == null ? null : bean.getSchLocation().buildVo();
		this.listowners = ims.scheduling.vo.Session_ListOwnerVoCollection.buildFromBeanCollection(bean.getListOwners());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.SessionLiteWithListownerVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.schlocation = bean.getSchLocation() == null ? null : bean.getSchLocation().buildVo(map);
		this.listowners = ims.scheduling.vo.Session_ListOwnerVoCollection.buildFromBeanCollection(bean.getListOwners());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.SessionLiteWithListownerVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.SessionLiteWithListownerVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.SessionLiteWithListownerVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("SERVICE"))
			return getService();
		if(fieldName.equals("SCHLOCATION"))
			return getSchLocation();
		if(fieldName.equals("LISTOWNERS"))
			return getListOwners();
		return super.getFieldValueByFieldName(fieldName);
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
		return 100;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceLiteVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceLiteVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getSchLocationIsNotNull()
	{
		return this.schlocation != null;
	}
	public ims.core.vo.LocShortVo getSchLocation()
	{
		return this.schlocation;
	}
	public void setSchLocation(ims.core.vo.LocShortVo value)
	{
		this.isValidated = false;
		this.schlocation = value;
	}
	public boolean getListOwnersIsNotNull()
	{
		return this.listowners != null;
	}
	public ims.scheduling.vo.Session_ListOwnerVoCollection getListOwners()
	{
		return this.listowners;
	}
	public void setListOwners(ims.scheduling.vo.Session_ListOwnerVoCollection value)
	{
		this.isValidated = false;
		this.listowners = value;
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
		if(this.name != null)
			if(this.name.length() > 100)
				listOfErrors.add("The length of the field [name] in the value object [ims.scheduling.vo.SessionLiteWithListownerVo] is too big. It should be less or equal to 100");
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
	
		SessionLiteWithListownerVo clone = new SessionLiteWithListownerVo(this.id, this.version);
		
		clone.name = this.name;
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceLiteVo)this.service.clone();
		if(this.schlocation == null)
			clone.schlocation = null;
		else
			clone.schlocation = (ims.core.vo.LocShortVo)this.schlocation.clone();
		if(this.listowners == null)
			clone.listowners = null;
		else
			clone.listowners = (ims.scheduling.vo.Session_ListOwnerVoCollection)this.listowners.clone();
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
		if (!(SessionLiteWithListownerVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SessionLiteWithListownerVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SessionLiteWithListownerVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SessionLiteWithListownerVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.name != null)
			count++;
		if(this.service != null)
			count++;
		if(this.schlocation != null)
			count++;
		if(this.listowners != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String name;
	protected ims.core.vo.ServiceLiteVo service;
	protected ims.core.vo.LocShortVo schlocation;
	protected ims.scheduling.vo.Session_ListOwnerVoCollection listowners;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
