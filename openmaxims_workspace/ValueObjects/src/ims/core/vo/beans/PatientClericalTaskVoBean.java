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

public class PatientClericalTaskVoBean extends ims.vo.ValueObjectBean
{
	public PatientClericalTaskVoBean()
	{
	}
	public PatientClericalTaskVoBean(ims.core.vo.PatientClericalTaskVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientListVoBean)vo.getPatient().getBean();
		this.investigation = vo.getInvestigation() == null ? null : new ims.vo.RefVoBean(vo.getInvestigation().getBoId(), vo.getInvestigation().getBoVersion());
		this.requestor = vo.getRequestor() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getRequestor().getBean();
		this.requesteddatetime = vo.getRequestedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRequestedDateTime().getBean();
		this.allocatedto = vo.getAllocatedTo() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAllocatedTo().getBean();
		this.comment = vo.getComment();
		this.completedby = vo.getCompletedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getCompletedBy().getBean();
		this.completeddatetime = vo.getCompletedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedDateTime().getBean();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientClericalTaskVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientListVoBean)vo.getPatient().getBean(map);
		this.investigation = vo.getInvestigation() == null ? null : new ims.vo.RefVoBean(vo.getInvestigation().getBoId(), vo.getInvestigation().getBoVersion());
		this.requestor = vo.getRequestor() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getRequestor().getBean(map);
		this.requesteddatetime = vo.getRequestedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRequestedDateTime().getBean();
		this.allocatedto = vo.getAllocatedTo() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAllocatedTo().getBean(map);
		this.comment = vo.getComment();
		this.completedby = vo.getCompletedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getCompletedBy().getBean(map);
		this.completeddatetime = vo.getCompletedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedDateTime().getBean();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
	}

	public ims.core.vo.PatientClericalTaskVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientClericalTaskVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientClericalTaskVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientClericalTaskVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientClericalTaskVo();
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
	public ims.core.vo.beans.PatientListVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientListVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.vo.RefVoBean value)
	{
		this.investigation = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getRequestor()
	{
		return this.requestor;
	}
	public void setRequestor(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.requestor = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRequestedDateTime()
	{
		return this.requesteddatetime;
	}
	public void setRequestedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.requesteddatetime = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getAllocatedTo()
	{
		return this.allocatedto;
	}
	public void setAllocatedTo(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.allocatedto = value;
	}
	public String getComment()
	{
		return this.comment;
	}
	public void setComment(String value)
	{
		this.comment = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getCompletedBy()
	{
		return this.completedby;
	}
	public void setCompletedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.completedby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCompletedDateTime()
	{
		return this.completeddatetime;
	}
	public void setCompletedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.completeddatetime = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientListVoBean patient;
	private ims.vo.RefVoBean investigation;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean requestor;
	private ims.framework.utils.beans.DateTimeBean requesteddatetime;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean allocatedto;
	private String comment;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean completedby;
	private ims.framework.utils.beans.DateTimeBean completeddatetime;
	private ims.vo.LookupInstanceBean status;
}
