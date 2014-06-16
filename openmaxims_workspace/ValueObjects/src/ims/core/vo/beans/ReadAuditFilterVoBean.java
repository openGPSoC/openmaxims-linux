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

public class ReadAuditFilterVoBean extends ims.vo.ValueObjectBean
{
	public ReadAuditFilterVoBean()
	{
	}
	public ReadAuditFilterVoBean(ims.core.vo.ReadAuditFilterVo vo)
	{
		this.audituser = vo.getAuditUser();
		this.action = vo.getAction();
		this.hostname = vo.getHostName();
		this.datefrom = vo.getDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateFrom().getBean();
		this.dateto = vo.getDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateTo().getBean();
		this.auditlocation = vo.getAuditLocation() == null ? null : new ims.vo.RefVoBean(vo.getAuditLocation().getBoId(), vo.getAuditLocation().getBoVersion());
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientIdBean)vo.getPatient().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ReadAuditFilterVo vo)
	{
		this.audituser = vo.getAuditUser();
		this.action = vo.getAction();
		this.hostname = vo.getHostName();
		this.datefrom = vo.getDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateFrom().getBean();
		this.dateto = vo.getDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateTo().getBean();
		this.auditlocation = vo.getAuditLocation() == null ? null : new ims.vo.RefVoBean(vo.getAuditLocation().getBoId(), vo.getAuditLocation().getBoVersion());
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientIdBean)vo.getPatient().getBean(map);
	}

	public ims.core.vo.ReadAuditFilterVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ReadAuditFilterVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ReadAuditFilterVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ReadAuditFilterVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ReadAuditFilterVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getAuditUser()
	{
		return this.audituser;
	}
	public void setAuditUser(String value)
	{
		this.audituser = value;
	}
	public String getAction()
	{
		return this.action;
	}
	public void setAction(String value)
	{
		this.action = value;
	}
	public String getHostName()
	{
		return this.hostname;
	}
	public void setHostName(String value)
	{
		this.hostname = value;
	}
	public ims.framework.utils.beans.DateBean getDateFrom()
	{
		return this.datefrom;
	}
	public void setDateFrom(ims.framework.utils.beans.DateBean value)
	{
		this.datefrom = value;
	}
	public ims.framework.utils.beans.DateBean getDateTo()
	{
		return this.dateto;
	}
	public void setDateTo(ims.framework.utils.beans.DateBean value)
	{
		this.dateto = value;
	}
	public ims.vo.RefVoBean getAuditLocation()
	{
		return this.auditlocation;
	}
	public void setAuditLocation(ims.vo.RefVoBean value)
	{
		this.auditlocation = value;
	}
	public ims.core.vo.beans.PatientIdBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientIdBean value)
	{
		this.patient = value;
	}

	private String audituser;
	private String action;
	private String hostname;
	private ims.framework.utils.beans.DateBean datefrom;
	private ims.framework.utils.beans.DateBean dateto;
	private ims.vo.RefVoBean auditlocation;
	private ims.core.vo.beans.PatientIdBean patient;
}
