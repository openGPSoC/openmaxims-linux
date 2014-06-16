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

/**
 * Linked to core.configuration.LocalSettings business object (ID: 1028100058).
 */
public class LocalSettingsVo extends ims.core.configuration.vo.LocalSettingsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public LocalSettingsVo()
	{
	}
	public LocalSettingsVo(Integer id, int version)
	{
		super(id, version);
	}
	public LocalSettingsVo(ims.admin.vo.beans.LocalSettingsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.instanceidentifier = bean.getInstanceIdentifier();
		this.settingtype = bean.getSettingType();
		this.values = bean.getValues();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.LocalSettingsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.instanceidentifier = bean.getInstanceIdentifier();
		this.settingtype = bean.getSettingType();
		this.values = bean.getValues();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.LocalSettingsVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.LocalSettingsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.LocalSettingsVoBean();
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
		if(fieldName.equals("INSTANCEIDENTIFIER"))
			return getInstanceIdentifier();
		if(fieldName.equals("SETTINGTYPE"))
			return getSettingType();
		if(fieldName.equals("VALUES"))
			return getValues();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInstanceIdentifierIsNotNull()
	{
		return this.instanceidentifier != null;
	}
	public String getInstanceIdentifier()
	{
		return this.instanceidentifier;
	}
	public static int getInstanceIdentifierMaxLength()
	{
		return 255;
	}
	public void setInstanceIdentifier(String value)
	{
		this.isValidated = false;
		this.instanceidentifier = value;
	}
	public boolean getSettingTypeIsNotNull()
	{
		return this.settingtype != null;
	}
	public Integer getSettingType()
	{
		return this.settingtype;
	}
	public void setSettingType(Integer value)
	{
		this.isValidated = false;
		this.settingtype = value;
	}
	public boolean getValuesIsNotNull()
	{
		return this.values != null;
	}
	public String getValues()
	{
		return this.values;
	}
	public static int getValuesMaxLength()
	{
		return 10000;
	}
	public void setValues(String value)
	{
		this.isValidated = false;
		this.values = value;
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
		if(this.instanceidentifier == null || this.instanceidentifier.length() == 0)
			listOfErrors.add("InstanceIdentifier is mandatory");
		else if(this.instanceidentifier.length() > 255)
			listOfErrors.add("The length of the field [instanceidentifier] in the value object [ims.admin.vo.LocalSettingsVo] is too big. It should be less or equal to 255");
		if(this.settingtype == null)
			listOfErrors.add("SettingType is mandatory");
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
	
		LocalSettingsVo clone = new LocalSettingsVo(this.id, this.version);
		
		clone.instanceidentifier = this.instanceidentifier;
		clone.settingtype = this.settingtype;
		clone.values = this.values;
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
		if (!(LocalSettingsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A LocalSettingsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((LocalSettingsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((LocalSettingsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.instanceidentifier != null)
			count++;
		if(this.settingtype != null)
			count++;
		if(this.values != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected String instanceidentifier;
	protected Integer settingtype;
	protected String values;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
