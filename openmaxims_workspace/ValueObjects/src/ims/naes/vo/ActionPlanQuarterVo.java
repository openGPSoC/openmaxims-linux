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

package ims.naes.vo;

/**
 * Linked to NAES.ActionPlanQuarter business object (ID: 1097100007).
 */
public class ActionPlanQuarterVo extends ims.naes.vo.ActionPlanQuarterRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ActionPlanQuarterVo()
	{
	}
	public ActionPlanQuarterVo(Integer id, int version)
	{
		super(id, version);
	}
	public ActionPlanQuarterVo(ims.naes.vo.beans.ActionPlanQuarterVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datetime = bean.getDateTime() == null ? null : bean.getDateTime().buildDateTime();
		this.responsiblemos = bean.getResponsibleMos() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getResponsibleMos().getId()), bean.getResponsibleMos().getVersion());
		this.quarter = bean.getQuarter();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.naes.vo.beans.ActionPlanQuarterVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datetime = bean.getDateTime() == null ? null : bean.getDateTime().buildDateTime();
		this.responsiblemos = bean.getResponsibleMos() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getResponsibleMos().getId()), bean.getResponsibleMos().getVersion());
		this.quarter = bean.getQuarter();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.naes.vo.beans.ActionPlanQuarterVoBean bean = null;
		if(map != null)
			bean = (ims.naes.vo.beans.ActionPlanQuarterVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.naes.vo.beans.ActionPlanQuarterVoBean();
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
		if(fieldName.equals("DATETIME"))
			return getDateTime();
		if(fieldName.equals("RESPONSIBLEMOS"))
			return getResponsibleMos();
		if(fieldName.equals("QUARTER"))
			return getQuarter();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDateTimeIsNotNull()
	{
		return this.datetime != null;
	}
	public ims.framework.utils.DateTime getDateTime()
	{
		return this.datetime;
	}
	public void setDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.datetime = value;
	}
	public boolean getResponsibleMosIsNotNull()
	{
		return this.responsiblemos != null;
	}
	public ims.core.resource.people.vo.MemberOfStaffRefVo getResponsibleMos()
	{
		return this.responsiblemos;
	}
	public void setResponsibleMos(ims.core.resource.people.vo.MemberOfStaffRefVo value)
	{
		this.isValidated = false;
		this.responsiblemos = value;
	}
	public boolean getQuarterIsNotNull()
	{
		return this.quarter != null;
	}
	public Integer getQuarter()
	{
		return this.quarter;
	}
	public void setQuarter(Integer value)
	{
		this.isValidated = false;
		this.quarter = value;
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
	
		ActionPlanQuarterVo clone = new ActionPlanQuarterVo(this.id, this.version);
		
		if(this.datetime == null)
			clone.datetime = null;
		else
			clone.datetime = (ims.framework.utils.DateTime)this.datetime.clone();
		clone.responsiblemos = this.responsiblemos;
		clone.quarter = this.quarter;
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
		if (!(ActionPlanQuarterVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ActionPlanQuarterVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ActionPlanQuarterVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ActionPlanQuarterVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.datetime != null)
			count++;
		if(this.responsiblemos != null)
			count++;
		if(this.quarter != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.framework.utils.DateTime datetime;
	protected ims.core.resource.people.vo.MemberOfStaffRefVo responsiblemos;
	protected Integer quarter;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
