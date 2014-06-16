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

package ims.emergency.vo.beans;

public class SentToXrayVoBean extends ims.vo.ValueObjectBean
{
	public SentToXrayVoBean()
	{
	}
	public SentToXrayVoBean(ims.emergency.vo.SentToXrayVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : new ims.vo.RefVoBean(vo.getEpisode().getBoId(), vo.getEpisode().getBoVersion());
		this.attendance = vo.getAttendance() == null ? null : new ims.vo.RefVoBean(vo.getAttendance().getBoId(), vo.getAttendance().getBoVersion());
		this.trackingarea = vo.getTrackingArea() == null ? null : new ims.vo.RefVoBean(vo.getTrackingArea().getBoId(), vo.getTrackingArea().getBoVersion());
		this.sentdatetime = vo.getSentDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getSentDateTime().getBean();
		this.sentby = vo.getSentBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getSentBy().getBean();
		this.returneddatetime = vo.getReturnedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReturnedDateTime().getBean();
		this.systeminformation = vo.getSystemInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInformation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.SentToXrayVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : new ims.vo.RefVoBean(vo.getEpisode().getBoId(), vo.getEpisode().getBoVersion());
		this.attendance = vo.getAttendance() == null ? null : new ims.vo.RefVoBean(vo.getAttendance().getBoId(), vo.getAttendance().getBoVersion());
		this.trackingarea = vo.getTrackingArea() == null ? null : new ims.vo.RefVoBean(vo.getTrackingArea().getBoId(), vo.getTrackingArea().getBoVersion());
		this.sentdatetime = vo.getSentDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getSentDateTime().getBean();
		this.sentby = vo.getSentBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getSentBy().getBean(map);
		this.returneddatetime = vo.getReturnedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReturnedDateTime().getBean();
		this.systeminformation = vo.getSystemInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInformation().getBean();
	}

	public ims.emergency.vo.SentToXrayVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.SentToXrayVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.SentToXrayVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.SentToXrayVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.SentToXrayVo();
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
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.vo.RefVoBean getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.vo.RefVoBean value)
	{
		this.episode = value;
	}
	public ims.vo.RefVoBean getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.vo.RefVoBean value)
	{
		this.attendance = value;
	}
	public ims.vo.RefVoBean getTrackingArea()
	{
		return this.trackingarea;
	}
	public void setTrackingArea(ims.vo.RefVoBean value)
	{
		this.trackingarea = value;
	}
	public ims.framework.utils.beans.DateTimeBean getSentDateTime()
	{
		return this.sentdatetime;
	}
	public void setSentDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.sentdatetime = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getSentBy()
	{
		return this.sentby;
	}
	public void setSentBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.sentby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getReturnedDateTime()
	{
		return this.returneddatetime;
	}
	public void setReturnedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.returneddatetime = value;
	}
	public ims.vo.SysInfoBean getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SysInfoBean value)
	{
		this.systeminformation = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean episode;
	private ims.vo.RefVoBean attendance;
	private ims.vo.RefVoBean trackingarea;
	private ims.framework.utils.beans.DateTimeBean sentdatetime;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean sentby;
	private ims.framework.utils.beans.DateTimeBean returneddatetime;
	private ims.vo.SysInfoBean systeminformation;
}
