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

package ims.careuk.vo;

/**
 * Linked to CAREUK.ProviderCancellation business object (ID: 1096100016).
 */
public class ProviderCancellationVo extends ims.careuk.vo.ProviderCancellationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ProviderCancellationVo()
	{
	}
	public ProviderCancellationVo(Integer id, int version)
	{
		super(id, version);
	}
	public ProviderCancellationVo(ims.careuk.vo.beans.ProviderCancellationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.reason = bean.getReason() == null ? null : ims.careuk.vo.lookups.ProviderCancellationReason.buildLookup(bean.getReason());
		this.comments = bean.getComments();
		this.cancellationdatetime = bean.getCancellationDateTime() == null ? null : bean.getCancellationDateTime().buildDateTime();
		this.wasgpinformed = bean.getWasGPInformed();
		this.waspatientinformed = bean.getWasPatientInformed();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.ProviderCancellationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.reason = bean.getReason() == null ? null : ims.careuk.vo.lookups.ProviderCancellationReason.buildLookup(bean.getReason());
		this.comments = bean.getComments();
		this.cancellationdatetime = bean.getCancellationDateTime() == null ? null : bean.getCancellationDateTime().buildDateTime();
		this.wasgpinformed = bean.getWasGPInformed();
		this.waspatientinformed = bean.getWasPatientInformed();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.ProviderCancellationVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.ProviderCancellationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.ProviderCancellationVoBean();
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
		if(fieldName.equals("REASON"))
			return getReason();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("CANCELLATIONDATETIME"))
			return getCancellationDateTime();
		if(fieldName.equals("WASGPINFORMED"))
			return getWasGPInformed();
		if(fieldName.equals("WASPATIENTINFORMED"))
			return getWasPatientInformed();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getReasonIsNotNull()
	{
		return this.reason != null;
	}
	public ims.careuk.vo.lookups.ProviderCancellationReason getReason()
	{
		return this.reason;
	}
	public void setReason(ims.careuk.vo.lookups.ProviderCancellationReason value)
	{
		this.isValidated = false;
		this.reason = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 1000;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getCancellationDateTimeIsNotNull()
	{
		return this.cancellationdatetime != null;
	}
	public ims.framework.utils.DateTime getCancellationDateTime()
	{
		return this.cancellationdatetime;
	}
	public void setCancellationDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.cancellationdatetime = value;
	}
	public boolean getWasGPInformedIsNotNull()
	{
		return this.wasgpinformed != null;
	}
	public Boolean getWasGPInformed()
	{
		return this.wasgpinformed;
	}
	public void setWasGPInformed(Boolean value)
	{
		this.isValidated = false;
		this.wasgpinformed = value;
	}
	public boolean getWasPatientInformedIsNotNull()
	{
		return this.waspatientinformed != null;
	}
	public Boolean getWasPatientInformed()
	{
		return this.waspatientinformed;
	}
	public void setWasPatientInformed(Boolean value)
	{
		this.isValidated = false;
		this.waspatientinformed = value;
	}
	public boolean getSysInfoIsNotNull()
	{
		return this.sysinfo != null;
	}
	public ims.vo.SystemInformation getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinfo = value;
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
		if(this.reason == null)
			listOfErrors.add("Reason is mandatory");
		if(this.comments != null)
			if(this.comments.length() > 1000)
				listOfErrors.add("The length of the field [comments] in the value object [ims.careuk.vo.ProviderCancellationVo] is too big. It should be less or equal to 1000");
		if(this.cancellationdatetime == null)
			listOfErrors.add("CancellationDateTime is mandatory");
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
	
		ProviderCancellationVo clone = new ProviderCancellationVo(this.id, this.version);
		
		if(this.reason == null)
			clone.reason = null;
		else
			clone.reason = (ims.careuk.vo.lookups.ProviderCancellationReason)this.reason.clone();
		clone.comments = this.comments;
		if(this.cancellationdatetime == null)
			clone.cancellationdatetime = null;
		else
			clone.cancellationdatetime = (ims.framework.utils.DateTime)this.cancellationdatetime.clone();
		clone.wasgpinformed = this.wasgpinformed;
		clone.waspatientinformed = this.waspatientinformed;
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
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
		if (!(ProviderCancellationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ProviderCancellationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ProviderCancellationVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ProviderCancellationVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.reason != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.cancellationdatetime != null)
			count++;
		if(this.wasgpinformed != null)
			count++;
		if(this.waspatientinformed != null)
			count++;
		if(this.sysinfo != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.careuk.vo.lookups.ProviderCancellationReason reason;
	protected String comments;
	protected ims.framework.utils.DateTime cancellationdatetime;
	protected Boolean wasgpinformed;
	protected Boolean waspatientinformed;
	protected ims.vo.SystemInformation sysinfo;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
