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

package ims.racpc.vo;

/**
 * Linked to core.admin.pas.PAS Event business object (ID: 1014100003).
 */
public class PASEventForRACPCReferralVo extends ims.core.admin.pas.vo.PASEventRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PASEventForRACPCReferralVo()
	{
	}
	public PASEventForRACPCReferralVo(Integer id, int version)
	{
		super(id, version);
	}
	public PASEventForRACPCReferralVo(ims.racpc.vo.beans.PASEventForRACPCReferralVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.eventdatetime = bean.getEventDateTime() == null ? null : bean.getEventDateTime().buildDateTime();
		this.sourceofreferral = bean.getSourceOfReferral() == null ? null : ims.core.vo.lookups.SourceOfReferral.buildLookup(bean.getSourceOfReferral());
		this.referringgp = bean.getReferringGP() == null ? null : bean.getReferringGP().buildVo();
		this.eventtype = bean.getEventType() == null ? null : ims.core.vo.lookups.PasEventType.buildLookup(bean.getEventType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.racpc.vo.beans.PASEventForRACPCReferralVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.eventdatetime = bean.getEventDateTime() == null ? null : bean.getEventDateTime().buildDateTime();
		this.sourceofreferral = bean.getSourceOfReferral() == null ? null : ims.core.vo.lookups.SourceOfReferral.buildLookup(bean.getSourceOfReferral());
		this.referringgp = bean.getReferringGP() == null ? null : bean.getReferringGP().buildVo(map);
		this.eventtype = bean.getEventType() == null ? null : ims.core.vo.lookups.PasEventType.buildLookup(bean.getEventType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.racpc.vo.beans.PASEventForRACPCReferralVoBean bean = null;
		if(map != null)
			bean = (ims.racpc.vo.beans.PASEventForRACPCReferralVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.racpc.vo.beans.PASEventForRACPCReferralVoBean();
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
		if(fieldName.equals("EVENTDATETIME"))
			return getEventDateTime();
		if(fieldName.equals("SOURCEOFREFERRAL"))
			return getSourceOfReferral();
		if(fieldName.equals("REFERRINGGP"))
			return getReferringGP();
		if(fieldName.equals("EVENTTYPE"))
			return getEventType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getEventDateTimeIsNotNull()
	{
		return this.eventdatetime != null;
	}
	public ims.framework.utils.DateTime getEventDateTime()
	{
		return this.eventdatetime;
	}
	public void setEventDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.eventdatetime = value;
	}
	public boolean getSourceOfReferralIsNotNull()
	{
		return this.sourceofreferral != null;
	}
	public ims.core.vo.lookups.SourceOfReferral getSourceOfReferral()
	{
		return this.sourceofreferral;
	}
	public void setSourceOfReferral(ims.core.vo.lookups.SourceOfReferral value)
	{
		this.isValidated = false;
		this.sourceofreferral = value;
	}
	public boolean getReferringGPIsNotNull()
	{
		return this.referringgp != null;
	}
	public ims.racpc.vo.GPForRACPCReferralVo getReferringGP()
	{
		return this.referringgp;
	}
	public void setReferringGP(ims.racpc.vo.GPForRACPCReferralVo value)
	{
		this.isValidated = false;
		this.referringgp = value;
	}
	public boolean getEventTypeIsNotNull()
	{
		return this.eventtype != null;
	}
	public ims.core.vo.lookups.PasEventType getEventType()
	{
		return this.eventtype;
	}
	public void setEventType(ims.core.vo.lookups.PasEventType value)
	{
		this.isValidated = false;
		this.eventtype = value;
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
	
		PASEventForRACPCReferralVo clone = new PASEventForRACPCReferralVo(this.id, this.version);
		
		if(this.eventdatetime == null)
			clone.eventdatetime = null;
		else
			clone.eventdatetime = (ims.framework.utils.DateTime)this.eventdatetime.clone();
		if(this.sourceofreferral == null)
			clone.sourceofreferral = null;
		else
			clone.sourceofreferral = (ims.core.vo.lookups.SourceOfReferral)this.sourceofreferral.clone();
		if(this.referringgp == null)
			clone.referringgp = null;
		else
			clone.referringgp = (ims.racpc.vo.GPForRACPCReferralVo)this.referringgp.clone();
		if(this.eventtype == null)
			clone.eventtype = null;
		else
			clone.eventtype = (ims.core.vo.lookups.PasEventType)this.eventtype.clone();
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
		if (!(PASEventForRACPCReferralVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PASEventForRACPCReferralVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PASEventForRACPCReferralVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PASEventForRACPCReferralVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.eventdatetime != null)
			count++;
		if(this.sourceofreferral != null)
			count++;
		if(this.referringgp != null)
			count++;
		if(this.eventtype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.framework.utils.DateTime eventdatetime;
	protected ims.core.vo.lookups.SourceOfReferral sourceofreferral;
	protected ims.racpc.vo.GPForRACPCReferralVo referringgp;
	protected ims.core.vo.lookups.PasEventType eventtype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
