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

public class TrackingForClinicianWorklistVoBean extends ims.vo.ValueObjectBean
{
	public TrackingForClinicianWorklistVoBean()
	{
	}
	public TrackingForClinicianWorklistVoBean(ims.emergency.vo.TrackingForClinicianWorklistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.attendance = vo.getAttendance() == null ? null : (ims.emergency.vo.beans.EmergencyAttendanceForTriageLiteVoBean)vo.getAttendance().getBean();
		this.episode = vo.getEpisode() == null ? null : (ims.emergency.vo.beans.EmergencyEpisodeForTriageLiteVoBean)vo.getEpisode().getBean();
		this.triagedetails = vo.getTriageDetails() == null ? null : (ims.emergency.vo.beans.TriageForClinicianWorklistVoBean)vo.getTriageDetails().getBean();
		this.currentarea = vo.getCurrentArea() == null ? null : new ims.vo.RefVoBean(vo.getCurrentArea().getBoId(), vo.getCurrentArea().getBoVersion());
		this.patient = vo.getPatient() == null ? null : (ims.emergency.vo.beans.PatientForTriageVoBean)vo.getPatient().getBean();
		this.isdischarged = vo.getIsDischarged();
		this.seenby = vo.getSeenBy() == null ? null : new ims.vo.RefVoBean(vo.getSeenBy().getBoId(), vo.getSeenBy().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.TrackingForClinicianWorklistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.attendance = vo.getAttendance() == null ? null : (ims.emergency.vo.beans.EmergencyAttendanceForTriageLiteVoBean)vo.getAttendance().getBean(map);
		this.episode = vo.getEpisode() == null ? null : (ims.emergency.vo.beans.EmergencyEpisodeForTriageLiteVoBean)vo.getEpisode().getBean(map);
		this.triagedetails = vo.getTriageDetails() == null ? null : (ims.emergency.vo.beans.TriageForClinicianWorklistVoBean)vo.getTriageDetails().getBean(map);
		this.currentarea = vo.getCurrentArea() == null ? null : new ims.vo.RefVoBean(vo.getCurrentArea().getBoId(), vo.getCurrentArea().getBoVersion());
		this.patient = vo.getPatient() == null ? null : (ims.emergency.vo.beans.PatientForTriageVoBean)vo.getPatient().getBean(map);
		this.isdischarged = vo.getIsDischarged();
		this.seenby = vo.getSeenBy() == null ? null : new ims.vo.RefVoBean(vo.getSeenBy().getBoId(), vo.getSeenBy().getBoVersion());
	}

	public ims.emergency.vo.TrackingForClinicianWorklistVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.TrackingForClinicianWorklistVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.TrackingForClinicianWorklistVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.TrackingForClinicianWorklistVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.TrackingForClinicianWorklistVo();
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
	public ims.emergency.vo.beans.EmergencyAttendanceForTriageLiteVoBean getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.emergency.vo.beans.EmergencyAttendanceForTriageLiteVoBean value)
	{
		this.attendance = value;
	}
	public ims.emergency.vo.beans.EmergencyEpisodeForTriageLiteVoBean getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.emergency.vo.beans.EmergencyEpisodeForTriageLiteVoBean value)
	{
		this.episode = value;
	}
	public ims.emergency.vo.beans.TriageForClinicianWorklistVoBean getTriageDetails()
	{
		return this.triagedetails;
	}
	public void setTriageDetails(ims.emergency.vo.beans.TriageForClinicianWorklistVoBean value)
	{
		this.triagedetails = value;
	}
	public ims.vo.RefVoBean getCurrentArea()
	{
		return this.currentarea;
	}
	public void setCurrentArea(ims.vo.RefVoBean value)
	{
		this.currentarea = value;
	}
	public ims.emergency.vo.beans.PatientForTriageVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.emergency.vo.beans.PatientForTriageVoBean value)
	{
		this.patient = value;
	}
	public Boolean getIsDischarged()
	{
		return this.isdischarged;
	}
	public void setIsDischarged(Boolean value)
	{
		this.isdischarged = value;
	}
	public ims.vo.RefVoBean getSeenBy()
	{
		return this.seenby;
	}
	public void setSeenBy(ims.vo.RefVoBean value)
	{
		this.seenby = value;
	}

	private Integer id;
	private int version;
	private ims.emergency.vo.beans.EmergencyAttendanceForTriageLiteVoBean attendance;
	private ims.emergency.vo.beans.EmergencyEpisodeForTriageLiteVoBean episode;
	private ims.emergency.vo.beans.TriageForClinicianWorklistVoBean triagedetails;
	private ims.vo.RefVoBean currentarea;
	private ims.emergency.vo.beans.PatientForTriageVoBean patient;
	private Boolean isdischarged;
	private ims.vo.RefVoBean seenby;
}
