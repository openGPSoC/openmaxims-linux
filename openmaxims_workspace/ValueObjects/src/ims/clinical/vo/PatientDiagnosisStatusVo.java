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

package ims.clinical.vo;

/**
 * Linked to core.clinical.PatientDiagnosisStatus business object (ID: 1003100067).
 */
public class PatientDiagnosisStatusVo extends ims.core.clinical.vo.PatientDiagnosisStatusRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientDiagnosisStatusVo()
	{
	}
	public PatientDiagnosisStatusVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientDiagnosisStatusVo(ims.clinical.vo.beans.PatientDiagnosisStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.DiagnosisStatus.buildLookup(bean.getStatus());
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.PatientDiagnosisStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.DiagnosisStatus.buildLookup(bean.getStatus());
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo(map);
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.PatientDiagnosisStatusVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.PatientDiagnosisStatusVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.PatientDiagnosisStatusVoBean();
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
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("AUTHORINGHCP"))
			return getAuthoringHCP();
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.DiagnosisStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.DiagnosisStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getAuthoringHCPIsNotNull()
	{
		return this.authoringhcp != null;
	}
	public ims.core.vo.HcpLiteVo getAuthoringHCP()
	{
		return this.authoringhcp;
	}
	public void setAuthoringHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.authoringhcp = value;
	}
	public boolean getAuthoringDateTimeIsNotNull()
	{
		return this.authoringdatetime != null;
	}
	public ims.framework.utils.DateTime getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.authoringdatetime = value;
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
		if(this.authoringhcp != null)
		{
			if(!this.authoringhcp.isValidated())
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
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
		if(this.authoringhcp == null)
			listOfErrors.add("AuthoringHCP is mandatory");
		if(this.authoringhcp != null)
		{
			String[] listOfOtherErrors = this.authoringhcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.authoringdatetime == null)
			listOfErrors.add("AuthoringDateTime is mandatory");
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
	
		PatientDiagnosisStatusVo clone = new PatientDiagnosisStatusVo(this.id, this.version);
		
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.DiagnosisStatus)this.status.clone();
		if(this.authoringhcp == null)
			clone.authoringhcp = null;
		else
			clone.authoringhcp = (ims.core.vo.HcpLiteVo)this.authoringhcp.clone();
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
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
		if (!(PatientDiagnosisStatusVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientDiagnosisStatusVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientDiagnosisStatusVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientDiagnosisStatusVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.status != null)
			count++;
		if(this.authoringhcp != null)
			count++;
		if(this.authoringdatetime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.lookups.DiagnosisStatus status;
	protected ims.core.vo.HcpLiteVo authoringhcp;
	protected ims.framework.utils.DateTime authoringdatetime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
