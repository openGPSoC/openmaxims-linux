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

public class TriageForRelvantPMHVoBean extends ims.vo.ValueObjectBean
{
	public TriageForRelvantPMHVoBean()
	{
	}
	public TriageForRelvantPMHVoBean(ims.emergency.vo.TriageForRelvantPMHVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.attendance = vo.getAttendance() == null ? null : (ims.emergency.vo.beans.CareContextForRelevantPMHVoBean)vo.getAttendance().getBean();
		this.mainpresentingproblem = vo.getMainPresentingProblem() == null ? null : (ims.emergency.vo.beans.PatientProblemForRelevantPMHVoBean)vo.getMainPresentingProblem().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.TriageForRelvantPMHVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.attendance = vo.getAttendance() == null ? null : (ims.emergency.vo.beans.CareContextForRelevantPMHVoBean)vo.getAttendance().getBean(map);
		this.mainpresentingproblem = vo.getMainPresentingProblem() == null ? null : (ims.emergency.vo.beans.PatientProblemForRelevantPMHVoBean)vo.getMainPresentingProblem().getBean(map);
	}

	public ims.emergency.vo.TriageForRelvantPMHVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.TriageForRelvantPMHVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.TriageForRelvantPMHVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.TriageForRelvantPMHVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.TriageForRelvantPMHVo();
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
	public ims.emergency.vo.beans.CareContextForRelevantPMHVoBean getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.emergency.vo.beans.CareContextForRelevantPMHVoBean value)
	{
		this.attendance = value;
	}
	public ims.emergency.vo.beans.PatientProblemForRelevantPMHVoBean getMainPresentingProblem()
	{
		return this.mainpresentingproblem;
	}
	public void setMainPresentingProblem(ims.emergency.vo.beans.PatientProblemForRelevantPMHVoBean value)
	{
		this.mainpresentingproblem = value;
	}

	private Integer id;
	private int version;
	private ims.emergency.vo.beans.CareContextForRelevantPMHVoBean attendance;
	private ims.emergency.vo.beans.PatientProblemForRelevantPMHVoBean mainpresentingproblem;
}
