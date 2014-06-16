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

package ims.nursing.vo.beans;

public class InterventionChartDetailsVoBean extends ims.vo.ValueObjectBean
{
	public InterventionChartDetailsVoBean()
	{
	}
	public InterventionChartDetailsVoBean(ims.nursing.vo.InterventionChartDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.timeofintervention = vo.getTimeOfIntervention() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTimeOfIntervention().getBean();
		this.lengthoftime = vo.getLengthOfTime();
		this.details = vo.getDetails();
		this.assistancerequired = vo.getAssistanceRequired() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssistanceRequired().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.InterventionChartDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.timeofintervention = vo.getTimeOfIntervention() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTimeOfIntervention().getBean();
		this.lengthoftime = vo.getLengthOfTime();
		this.details = vo.getDetails();
		this.assistancerequired = vo.getAssistanceRequired() == null ? null : (ims.vo.LookupInstanceBean)vo.getAssistanceRequired().getBean();
	}

	public ims.nursing.vo.InterventionChartDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.InterventionChartDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.InterventionChartDetailsVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.InterventionChartDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.InterventionChartDetailsVo();
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
	public ims.framework.utils.beans.TimeBean getTimeOfIntervention()
	{
		return this.timeofintervention;
	}
	public void setTimeOfIntervention(ims.framework.utils.beans.TimeBean value)
	{
		this.timeofintervention = value;
	}
	public String getLengthOfTime()
	{
		return this.lengthoftime;
	}
	public void setLengthOfTime(String value)
	{
		this.lengthoftime = value;
	}
	public String getDetails()
	{
		return this.details;
	}
	public void setDetails(String value)
	{
		this.details = value;
	}
	public ims.vo.LookupInstanceBean getAssistanceRequired()
	{
		return this.assistancerequired;
	}
	public void setAssistanceRequired(ims.vo.LookupInstanceBean value)
	{
		this.assistancerequired = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.TimeBean timeofintervention;
	private String lengthoftime;
	private String details;
	private ims.vo.LookupInstanceBean assistancerequired;
}
