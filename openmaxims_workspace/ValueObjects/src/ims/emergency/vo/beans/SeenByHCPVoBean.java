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

public class SeenByHCPVoBean extends ims.vo.ValueObjectBean
{
	public SeenByHCPVoBean()
	{
	}
	public SeenByHCPVoBean(ims.emergency.vo.SeenByHCPVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : new ims.vo.RefVoBean(vo.getEpisode().getBoId(), vo.getEpisode().getBoVersion());
		this.attendance = vo.getAttendance() == null ? null : new ims.vo.RefVoBean(vo.getAttendance().getBoId(), vo.getAttendance().getBoVersion());
		this.trackingarea = vo.getTrackingArea() == null ? null : new ims.vo.RefVoBean(vo.getTrackingArea().getBoId(), vo.getTrackingArea().getBoVersion());
		this.allocateddatetime = vo.getAllocatedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAllocatedDateTime().getBean();
		this.allocatedmedic = vo.getAllocatedMedic() == null ? null : (ims.core.vo.beans.MedicVoBean)vo.getAllocatedMedic().getBean();
		this.allocatednurse = vo.getAllocatedNurse() == null ? null : (ims.core.vo.beans.NurseVoBean)vo.getAllocatedNurse().getBean();
		this.seendatetime = vo.getSeenDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getSeenDateTime().getBean();
		this.completeddatetime = vo.getCompletedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedDateTime().getBean();
		this.seenbyhcpnotes = vo.getSeenByHCPNotes() == null ? null : vo.getSeenByHCPNotes().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.SeenByHCPVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.episode = vo.getEpisode() == null ? null : new ims.vo.RefVoBean(vo.getEpisode().getBoId(), vo.getEpisode().getBoVersion());
		this.attendance = vo.getAttendance() == null ? null : new ims.vo.RefVoBean(vo.getAttendance().getBoId(), vo.getAttendance().getBoVersion());
		this.trackingarea = vo.getTrackingArea() == null ? null : new ims.vo.RefVoBean(vo.getTrackingArea().getBoId(), vo.getTrackingArea().getBoVersion());
		this.allocateddatetime = vo.getAllocatedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAllocatedDateTime().getBean();
		this.allocatedmedic = vo.getAllocatedMedic() == null ? null : (ims.core.vo.beans.MedicVoBean)vo.getAllocatedMedic().getBean(map);
		this.allocatednurse = vo.getAllocatedNurse() == null ? null : (ims.core.vo.beans.NurseVoBean)vo.getAllocatedNurse().getBean(map);
		this.seendatetime = vo.getSeenDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getSeenDateTime().getBean();
		this.completeddatetime = vo.getCompletedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedDateTime().getBean();
		this.seenbyhcpnotes = vo.getSeenByHCPNotes() == null ? null : vo.getSeenByHCPNotes().getBeanCollection();
	}

	public ims.emergency.vo.SeenByHCPVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.SeenByHCPVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.SeenByHCPVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.SeenByHCPVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.SeenByHCPVo();
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
	public ims.framework.utils.beans.DateTimeBean getAllocatedDateTime()
	{
		return this.allocateddatetime;
	}
	public void setAllocatedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.allocateddatetime = value;
	}
	public ims.core.vo.beans.MedicVoBean getAllocatedMedic()
	{
		return this.allocatedmedic;
	}
	public void setAllocatedMedic(ims.core.vo.beans.MedicVoBean value)
	{
		this.allocatedmedic = value;
	}
	public ims.core.vo.beans.NurseVoBean getAllocatedNurse()
	{
		return this.allocatednurse;
	}
	public void setAllocatedNurse(ims.core.vo.beans.NurseVoBean value)
	{
		this.allocatednurse = value;
	}
	public ims.framework.utils.beans.DateTimeBean getSeenDateTime()
	{
		return this.seendatetime;
	}
	public void setSeenDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.seendatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCompletedDateTime()
	{
		return this.completeddatetime;
	}
	public void setCompletedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.completeddatetime = value;
	}
	public ims.emergency.vo.beans.AttendanceClinicalNotesVoBean[] getSeenByHCPNotes()
	{
		return this.seenbyhcpnotes;
	}
	public void setSeenByHCPNotes(ims.emergency.vo.beans.AttendanceClinicalNotesVoBean[] value)
	{
		this.seenbyhcpnotes = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.vo.RefVoBean episode;
	private ims.vo.RefVoBean attendance;
	private ims.vo.RefVoBean trackingarea;
	private ims.framework.utils.beans.DateTimeBean allocateddatetime;
	private ims.core.vo.beans.MedicVoBean allocatedmedic;
	private ims.core.vo.beans.NurseVoBean allocatednurse;
	private ims.framework.utils.beans.DateTimeBean seendatetime;
	private ims.framework.utils.beans.DateTimeBean completeddatetime;
	private ims.emergency.vo.beans.AttendanceClinicalNotesVoBean[] seenbyhcpnotes;
}
