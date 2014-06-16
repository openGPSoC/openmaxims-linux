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

package ims.ocrr.vo;

/**
 * Linked to OCRR.Configuration.LocSvcProviderSys business object (ID: 1061100013).
 */
public class NewResultProvidorServiceVo extends ims.ocrr.configuration.vo.LocSvcProviderSysRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NewResultProvidorServiceVo()
	{
	}
	public NewResultProvidorServiceVo(Integer id, int version)
	{
		super(id, version);
	}
	public NewResultProvidorServiceVo(ims.ocrr.vo.beans.NewResultProvidorServiceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.locationservice = bean.getLocationService() == null ? null : bean.getLocationService().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.NewResultProvidorServiceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.locationservice = bean.getLocationService() == null ? null : bean.getLocationService().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.NewResultProvidorServiceVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.NewResultProvidorServiceVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.NewResultProvidorServiceVoBean();
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
		if(fieldName.equals("LOCATIONSERVICE"))
			return getLocationService();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getLocationServiceIsNotNull()
	{
		return this.locationservice != null;
	}
	public ims.core.vo.NewResultLocationServiceVo getLocationService()
	{
		return this.locationservice;
	}
	public void setLocationService(ims.core.vo.NewResultLocationServiceVo value)
	{
		this.isValidated = false;
		this.locationservice = value;
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
		if(this.locationservice != null)
		{
			if(!this.locationservice.isValidated())
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
		if(this.locationservice != null)
		{
			String[] listOfOtherErrors = this.locationservice.validate();
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
	
		NewResultProvidorServiceVo clone = new NewResultProvidorServiceVo(this.id, this.version);
		
		if(this.locationservice == null)
			clone.locationservice = null;
		else
			clone.locationservice = (ims.core.vo.NewResultLocationServiceVo)this.locationservice.clone();
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
		if (!(NewResultProvidorServiceVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NewResultProvidorServiceVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((NewResultProvidorServiceVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((NewResultProvidorServiceVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.locationservice != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 1;
	}
	protected ims.core.vo.NewResultLocationServiceVo locationservice;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
