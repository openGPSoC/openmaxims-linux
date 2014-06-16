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

package ims.hl7.vo.beans;

public class HL7InboundSaveVoBean extends ims.vo.ValueObjectBean
{
	public HL7InboundSaveVoBean()
	{
	}
	public HL7InboundSaveVoBean(ims.hl7.vo.HL7InboundSaveVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hl7message = vo.getHL7Message();
		this.failuremessage = vo.getFailureMessage();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.providersystem = vo.getProviderSystem() == null ? null : new ims.vo.RefVoBean(vo.getProviderSystem().getBoId(), vo.getProviderSystem().getBoVersion());
		this.messagetype = vo.getMessageType() == null ? null : (ims.vo.LookupInstanceBean)vo.getMessageType().getBean();
		this.messagecategory = vo.getMessageCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getMessageCategory().getBean();
		this.messagedatetime = vo.getMessageDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getMessageDateTime().getBean();
		this.successfuloutcome = vo.getSuccessfulOutcome();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.hl7.vo.HL7InboundSaveVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hl7message = vo.getHL7Message();
		this.failuremessage = vo.getFailureMessage();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.providersystem = vo.getProviderSystem() == null ? null : new ims.vo.RefVoBean(vo.getProviderSystem().getBoId(), vo.getProviderSystem().getBoVersion());
		this.messagetype = vo.getMessageType() == null ? null : (ims.vo.LookupInstanceBean)vo.getMessageType().getBean();
		this.messagecategory = vo.getMessageCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getMessageCategory().getBean();
		this.messagedatetime = vo.getMessageDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getMessageDateTime().getBean();
		this.successfuloutcome = vo.getSuccessfulOutcome();
	}

	public ims.hl7.vo.HL7InboundSaveVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.hl7.vo.HL7InboundSaveVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.hl7.vo.HL7InboundSaveVo vo = null;
		if(map != null)
			vo = (ims.hl7.vo.HL7InboundSaveVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.hl7.vo.HL7InboundSaveVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public String getHL7Message()
	{
		return this.hl7message;
	}
	public void setHL7Message(String value)
	{
		this.hl7message = value;
	}
	public String getFailureMessage()
	{
		return this.failuremessage;
	}
	public void setFailureMessage(String value)
	{
		this.failuremessage = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getProviderSystem()
	{
		return this.providersystem;
	}
	public void setProviderSystem(ims.vo.RefVoBean value)
	{
		this.providersystem = value;
	}
	public ims.vo.LookupInstanceBean getMessageType()
	{
		return this.messagetype;
	}
	public void setMessageType(ims.vo.LookupInstanceBean value)
	{
		this.messagetype = value;
	}
	public ims.vo.LookupInstanceBean getMessageCategory()
	{
		return this.messagecategory;
	}
	public void setMessageCategory(ims.vo.LookupInstanceBean value)
	{
		this.messagecategory = value;
	}
	public ims.framework.utils.beans.DateTimeBean getMessageDateTime()
	{
		return this.messagedatetime;
	}
	public void setMessageDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.messagedatetime = value;
	}
	public Boolean getSuccessfulOutcome()
	{
		return this.successfuloutcome;
	}
	public void setSuccessfulOutcome(Boolean value)
	{
		this.successfuloutcome = value;
	}

	private Integer id;
	private int version;
	private String hl7message;
	private String failuremessage;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean providersystem;
	private ims.vo.LookupInstanceBean messagetype;
	private ims.vo.LookupInstanceBean messagecategory;
	private ims.framework.utils.beans.DateTimeBean messagedatetime;
	private Boolean successfuloutcome;
}
