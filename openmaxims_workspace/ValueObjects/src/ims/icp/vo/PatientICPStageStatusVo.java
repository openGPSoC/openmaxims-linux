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

package ims.icp.vo;

/**
 * Linked to ICPs.Instantiation.PatientICPStageStatus business object (ID: 1100100002).
 */
public class PatientICPStageStatusVo extends ims.icps.instantiation.vo.PatientICPStageStatusRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientICPStageStatusVo()
	{
	}
	public PatientICPStageStatusVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientICPStageStatusVo(ims.icp.vo.beans.PatientICPStageStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.statusdate = bean.getStatusDate() == null ? null : bean.getStatusDate().buildDateTime();
		this.changedby = bean.getChangedBy();
		this.status = bean.getStatus() == null ? null : ims.icp.vo.lookups.ICPStageStatus.buildLookup(bean.getStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.PatientICPStageStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.statusdate = bean.getStatusDate() == null ? null : bean.getStatusDate().buildDateTime();
		this.changedby = bean.getChangedBy();
		this.status = bean.getStatus() == null ? null : ims.icp.vo.lookups.ICPStageStatus.buildLookup(bean.getStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.PatientICPStageStatusVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.PatientICPStageStatusVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.PatientICPStageStatusVoBean();
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
		if(fieldName.equals("STATUSDATE"))
			return getStatusDate();
		if(fieldName.equals("CHANGEDBY"))
			return getChangedBy();
		if(fieldName.equals("STATUS"))
			return getStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStatusDateIsNotNull()
	{
		return this.statusdate != null;
	}
	public ims.framework.utils.DateTime getStatusDate()
	{
		return this.statusdate;
	}
	public void setStatusDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.statusdate = value;
	}
	public boolean getChangedByIsNotNull()
	{
		return this.changedby != null;
	}
	public String getChangedBy()
	{
		return this.changedby;
	}
	public static int getChangedByMaxLength()
	{
		return 125;
	}
	public void setChangedBy(String value)
	{
		this.isValidated = false;
		this.changedby = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.icp.vo.lookups.ICPStageStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.icp.vo.lookups.ICPStageStatus value)
	{
		this.isValidated = false;
		this.status = value;
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
		if(this.statusdate == null)
			listOfErrors.add("StatusDate is mandatory");
		if(this.changedby == null || this.changedby.length() == 0)
			listOfErrors.add("ChangedBy is mandatory");
		else if(this.changedby.length() > 125)
			listOfErrors.add("The length of the field [changedby] in the value object [ims.icp.vo.PatientICPStageStatusVo] is too big. It should be less or equal to 125");
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
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
	
		PatientICPStageStatusVo clone = new PatientICPStageStatusVo(this.id, this.version);
		
		if(this.statusdate == null)
			clone.statusdate = null;
		else
			clone.statusdate = (ims.framework.utils.DateTime)this.statusdate.clone();
		clone.changedby = this.changedby;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.icp.vo.lookups.ICPStageStatus)this.status.clone();
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
		if (!(PatientICPStageStatusVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientICPStageStatusVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientICPStageStatusVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientICPStageStatusVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.statusdate != null)
			count++;
		if(this.changedby != null)
			count++;
		if(this.status != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.framework.utils.DateTime statusdate;
	protected String changedby;
	protected ims.icp.vo.lookups.ICPStageStatus status;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
