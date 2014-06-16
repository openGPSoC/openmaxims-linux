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

package ims.core.vo.beans;

public class PatientProcedureWebServiceListVoBean extends ims.vo.ValueObjectBean
{
	public PatientProcedureWebServiceListVoBean()
	{
	}
	public PatientProcedureWebServiceListVoBean(ims.core.vo.PatientProcedureWebServiceListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.ProcedureLiteVoBean)vo.getProcedure().getBean();
		this.proceduredescription = vo.getProcedureDescription();
		this.procedurestatus = vo.getProcedureStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureStatus().getBean();
		this.dateplanned = vo.getDatePlanned() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDatePlanned().getBean();
		this.procedureurgency = vo.getProcedureUrgency() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureUrgency().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientProcedureWebServiceListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.ProcedureLiteVoBean)vo.getProcedure().getBean(map);
		this.proceduredescription = vo.getProcedureDescription();
		this.procedurestatus = vo.getProcedureStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureStatus().getBean();
		this.dateplanned = vo.getDatePlanned() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDatePlanned().getBean();
		this.procedureurgency = vo.getProcedureUrgency() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureUrgency().getBean();
	}

	public ims.core.vo.PatientProcedureWebServiceListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientProcedureWebServiceListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientProcedureWebServiceListVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientProcedureWebServiceListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientProcedureWebServiceListVo();
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
	public ims.core.vo.beans.ProcedureLiteVoBean getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.beans.ProcedureLiteVoBean value)
	{
		this.procedure = value;
	}
	public String getProcedureDescription()
	{
		return this.proceduredescription;
	}
	public void setProcedureDescription(String value)
	{
		this.proceduredescription = value;
	}
	public ims.vo.LookupInstanceBean getProcedureStatus()
	{
		return this.procedurestatus;
	}
	public void setProcedureStatus(ims.vo.LookupInstanceBean value)
	{
		this.procedurestatus = value;
	}
	public ims.framework.utils.beans.PartialDateBean getDatePlanned()
	{
		return this.dateplanned;
	}
	public void setDatePlanned(ims.framework.utils.beans.PartialDateBean value)
	{
		this.dateplanned = value;
	}
	public ims.vo.LookupInstanceBean getProcedureUrgency()
	{
		return this.procedureurgency;
	}
	public void setProcedureUrgency(ims.vo.LookupInstanceBean value)
	{
		this.procedureurgency = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.ProcedureLiteVoBean procedure;
	private String proceduredescription;
	private ims.vo.LookupInstanceBean procedurestatus;
	private ims.framework.utils.beans.PartialDateBean dateplanned;
	private ims.vo.LookupInstanceBean procedureurgency;
}
