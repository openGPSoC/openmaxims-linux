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

package ims.emergency.vo;

/**
 * Linked to emergency.Configuration.AttendanceReqContractSettings business object (ID: 1087100017).
 */
public class AttendanceReqContractSettingsVo extends ims.emergency.configuration.vo.AttendanceReqContractSettingsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AttendanceReqContractSettingsVo()
	{
	}
	public AttendanceReqContractSettingsVo(Integer id, int version)
	{
		super(id, version);
	}
	public AttendanceReqContractSettingsVo(ims.emergency.vo.beans.AttendanceReqContractSettingsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.fromdate = bean.getFromDate() == null ? null : bean.getFromDate().buildDateTime();
		this.todate = bean.getToDate() == null ? null : bean.getToDate().buildDateTime();
		this.configuredjob = bean.getConfiguredJob() == null ? null : new ims.core.configuration.vo.ConfiguredJobRefVo(new Integer(bean.getConfiguredJob().getId()), bean.getConfiguredJob().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.AttendanceReqContractSettingsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.fromdate = bean.getFromDate() == null ? null : bean.getFromDate().buildDateTime();
		this.todate = bean.getToDate() == null ? null : bean.getToDate().buildDateTime();
		this.configuredjob = bean.getConfiguredJob() == null ? null : new ims.core.configuration.vo.ConfiguredJobRefVo(new Integer(bean.getConfiguredJob().getId()), bean.getConfiguredJob().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.AttendanceReqContractSettingsVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.AttendanceReqContractSettingsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.AttendanceReqContractSettingsVoBean();
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
		if(fieldName.equals("FROMDATE"))
			return getFromDate();
		if(fieldName.equals("TODATE"))
			return getToDate();
		if(fieldName.equals("CONFIGUREDJOB"))
			return getConfiguredJob();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getFromDateIsNotNull()
	{
		return this.fromdate != null;
	}
	public ims.framework.utils.DateTime getFromDate()
	{
		return this.fromdate;
	}
	public void setFromDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.fromdate = value;
	}
	public boolean getToDateIsNotNull()
	{
		return this.todate != null;
	}
	public ims.framework.utils.DateTime getToDate()
	{
		return this.todate;
	}
	public void setToDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.todate = value;
	}
	public boolean getConfiguredJobIsNotNull()
	{
		return this.configuredjob != null;
	}
	public ims.core.configuration.vo.ConfiguredJobRefVo getConfiguredJob()
	{
		return this.configuredjob;
	}
	public void setConfiguredJob(ims.core.configuration.vo.ConfiguredJobRefVo value)
	{
		this.isValidated = false;
		this.configuredjob = value;
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
		if(this.fromdate == null)
			listOfErrors.add("From Date/Time is mandatory!");
		if(this.todate == null)
			listOfErrors.add("To Date/Time is mandatory!");
		if(this.configuredjob == null)
			listOfErrors.add("ConfiguredJob is mandatory");
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
	
		AttendanceReqContractSettingsVo clone = new AttendanceReqContractSettingsVo(this.id, this.version);
		
		if(this.fromdate == null)
			clone.fromdate = null;
		else
			clone.fromdate = (ims.framework.utils.DateTime)this.fromdate.clone();
		if(this.todate == null)
			clone.todate = null;
		else
			clone.todate = (ims.framework.utils.DateTime)this.todate.clone();
		clone.configuredjob = this.configuredjob;
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
		if (!(AttendanceReqContractSettingsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AttendanceReqContractSettingsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AttendanceReqContractSettingsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AttendanceReqContractSettingsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.fromdate != null)
			count++;
		if(this.todate != null)
			count++;
		if(this.configuredjob != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.framework.utils.DateTime fromdate;
	protected ims.framework.utils.DateTime todate;
	protected ims.core.configuration.vo.ConfiguredJobRefVo configuredjob;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
