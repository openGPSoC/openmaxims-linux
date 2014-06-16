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

package ims.nursing.vo;

/**
 * Linked to nursing.assessment.Assessment Info business object (ID: 1015100006).
 */
public class AssessmentInfo extends ims.nursing.assessment.vo.AssessmentInfoRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AssessmentInfo()
	{
	}
	public AssessmentInfo(Integer id, int version)
	{
		super(id, version);
	}
	public AssessmentInfo(ims.nursing.vo.beans.AssessmentInfoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datetime = bean.getDateTime() == null ? null : bean.getDateTime().buildDateTime();
		this.hcp = bean.getHCP() == null ? null : bean.getHCP().buildVo();
		this.status = bean.getStatus() == null ? null : ims.nursing.vo.lookups.AssessmentInformationStatus.buildLookup(bean.getStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.AssessmentInfoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datetime = bean.getDateTime() == null ? null : bean.getDateTime().buildDateTime();
		this.hcp = bean.getHCP() == null ? null : bean.getHCP().buildVo(map);
		this.status = bean.getStatus() == null ? null : ims.nursing.vo.lookups.AssessmentInformationStatus.buildLookup(bean.getStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.AssessmentInfoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.AssessmentInfoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.AssessmentInfoBean();
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
		if(fieldName.equals("HCP"))
			return getHCP();
		if(fieldName.equals("STATUS"))
			return getStatus();
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
	public boolean getHCPIsNotNull()
	{
		return this.hcp != null;
	}
	public ims.core.vo.HcpLiteVo getHCP()
	{
		return this.hcp;
	}
	public void setHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.hcp = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.nursing.vo.lookups.AssessmentInformationStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.nursing.vo.lookups.AssessmentInformationStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if(this.datetime != null)
			sb.append(this.datetime);
		return sb.toString();
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
	
		AssessmentInfo clone = new AssessmentInfo(this.id, this.version);
		
		if(this.datetime == null)
			clone.datetime = null;
		else
			clone.datetime = (ims.framework.utils.DateTime)this.datetime.clone();
		if(this.hcp == null)
			clone.hcp = null;
		else
			clone.hcp = (ims.core.vo.HcpLiteVo)this.hcp.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.nursing.vo.lookups.AssessmentInformationStatus)this.status.clone();
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
		if (!(AssessmentInfo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AssessmentInfo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AssessmentInfo compareObj = (AssessmentInfo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getDateTime() == null && compareObj.getDateTime() != null)
				return -1;
			if(this.getDateTime() != null && compareObj.getDateTime() == null)
				return 1;
			if(this.getDateTime() != null && compareObj.getDateTime() != null)
				retVal = this.getDateTime().compareTo(compareObj.getDateTime());
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
		if(this.datetime != null)
			count++;
		if(this.hcp != null)
			count++;
		if(this.status != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.framework.utils.DateTime datetime;
	protected ims.core.vo.HcpLiteVo hcp;
	protected ims.nursing.vo.lookups.AssessmentInformationStatus status;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
