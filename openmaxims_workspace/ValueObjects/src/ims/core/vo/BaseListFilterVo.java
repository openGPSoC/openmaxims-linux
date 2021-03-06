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


public class BaseListFilterVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public BaseListFilterVo()
	{
	}
	public BaseListFilterVo(ims.core.vo.beans.BaseListFilterVoBean bean)
	{
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.hospnum = bean.getHospNum();
		this.ward = bean.getWard() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getWard().getId()), bean.getWard().getVersion());
		this.consultant = bean.getConsultant() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getConsultant().getId()), bean.getConsultant().getVersion());
		this.alert = bean.getAlert() == null ? null : ims.core.vo.lookups.AlertType.buildLookup(bean.getAlert());
		this.hospital = bean.getHospital() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getHospital().getId()), bean.getHospital().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.BaseListFilterVoBean bean)
	{
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.hospnum = bean.getHospNum();
		this.ward = bean.getWard() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getWard().getId()), bean.getWard().getVersion());
		this.consultant = bean.getConsultant() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getConsultant().getId()), bean.getConsultant().getVersion());
		this.alert = bean.getAlert() == null ? null : ims.core.vo.lookups.AlertType.buildLookup(bean.getAlert());
		this.hospital = bean.getHospital() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getHospital().getId()), bean.getHospital().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.BaseListFilterVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.BaseListFilterVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.BaseListFilterVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getSurnameIsNotNull()
	{
		return this.surname != null;
	}
	public String getSurname()
	{
		return this.surname;
	}
	public static int getSurnameMaxLength()
	{
		return 255;
	}
	public void setSurname(String value)
	{
		this.isValidated = false;
		this.surname = value;
	}
	public boolean getForenameIsNotNull()
	{
		return this.forename != null;
	}
	public String getForename()
	{
		return this.forename;
	}
	public static int getForenameMaxLength()
	{
		return 255;
	}
	public void setForename(String value)
	{
		this.isValidated = false;
		this.forename = value;
	}
	public boolean getHospNumIsNotNull()
	{
		return this.hospnum != null;
	}
	public String getHospNum()
	{
		return this.hospnum;
	}
	public static int getHospNumMaxLength()
	{
		return 255;
	}
	public void setHospNum(String value)
	{
		this.isValidated = false;
		this.hospnum = value;
	}
	public boolean getWardIsNotNull()
	{
		return this.ward != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.ward = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.resource.people.vo.HcpRefVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.resource.people.vo.HcpRefVo value)
	{
		this.isValidated = false;
		this.consultant = value;
	}
	public boolean getAlertIsNotNull()
	{
		return this.alert != null;
	}
	public ims.core.vo.lookups.AlertType getAlert()
	{
		return this.alert;
	}
	public void setAlert(ims.core.vo.lookups.AlertType value)
	{
		this.isValidated = false;
		this.alert = value;
	}
	public boolean getHospitalIsNotNull()
	{
		return this.hospital != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.hospital = value;
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
		if(!(obj instanceof BaseListFilterVo))
			return false;
		BaseListFilterVo compareObj = (BaseListFilterVo)obj;
		if(this.getHospNum() == null && compareObj.getHospNum() != null)
			return false;
		if(this.getHospNum() != null && compareObj.getHospNum() == null)
			return false;
		if(this.getHospNum() != null && compareObj.getHospNum() != null)
			return this.getHospNum().equals(compareObj.getHospNum());
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
	
		BaseListFilterVo clone = new BaseListFilterVo();
		
		clone.surname = this.surname;
		clone.forename = this.forename;
		clone.hospnum = this.hospnum;
		clone.ward = this.ward;
		clone.consultant = this.consultant;
		if(this.alert == null)
			clone.alert = null;
		else
			clone.alert = (ims.core.vo.lookups.AlertType)this.alert.clone();
		clone.hospital = this.hospital;
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
		if (!(BaseListFilterVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A BaseListFilterVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		BaseListFilterVo compareObj = (BaseListFilterVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getHospNum() == null && compareObj.getHospNum() != null)
				return -1;
			if(this.getHospNum() != null && compareObj.getHospNum() == null)
				return 1;
			if(this.getHospNum() != null && compareObj.getHospNum() != null)
			{
				if(caseInsensitive)
					retVal = this.getHospNum().toLowerCase().compareTo(compareObj.getHospNum().toLowerCase());
				else
					retVal = this.getHospNum().compareTo(compareObj.getHospNum());
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
		if(this.surname != null)
			count++;
		if(this.forename != null)
			count++;
		if(this.hospnum != null)
			count++;
		if(this.ward != null)
			count++;
		if(this.consultant != null)
			count++;
		if(this.alert != null)
			count++;
		if(this.hospital != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected String surname;
	protected String forename;
	protected String hospnum;
	protected ims.core.resource.place.vo.LocationRefVo ward;
	protected ims.core.resource.people.vo.HcpRefVo consultant;
	protected ims.core.vo.lookups.AlertType alert;
	protected ims.core.resource.place.vo.LocationRefVo hospital;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
