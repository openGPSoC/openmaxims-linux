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
 * Linked to CAREUK.ReferralOutcome business object (ID: 1096100005).
 */
public class ReferralOutcomeLiteVo extends ims.careuk.vo.ReferralOutcomeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReferralOutcomeLiteVo()
	{
	}
	public ReferralOutcomeLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public ReferralOutcomeLiteVo(ims.careuk.vo.beans.ReferralOutcomeLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.ReferralOutcomeLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.ReferralOutcomeLiteVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.ReferralOutcomeLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.ReferralOutcomeLiteVoBean();
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
		if(fieldName.equals("CATSREFERRAL"))
			return getCatsReferral();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCatsReferralIsNotNull()
	{
		return this.catsreferral != null;
	}
	public ims.careuk.vo.CatsReferralRefVo getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.careuk.vo.CatsReferralRefVo value)
	{
		this.isValidated = false;
		this.catsreferral = value;
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
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
		if(this.catsreferral == null)
			listOfErrors.add("CatsReferral is mandatory");
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
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
	
		ReferralOutcomeLiteVo clone = new ReferralOutcomeLiteVo(this.id, this.version);
		
		clone.catsreferral = this.catsreferral;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
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
		if (!(ReferralOutcomeLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReferralOutcomeLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ReferralOutcomeLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ReferralOutcomeLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.catsreferral != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.sysinfo != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.careuk.vo.CatsReferralRefVo catsreferral;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.vo.SystemInformation sysinfo;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
