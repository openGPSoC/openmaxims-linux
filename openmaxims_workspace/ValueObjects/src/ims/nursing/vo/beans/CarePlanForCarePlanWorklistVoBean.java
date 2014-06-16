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

public class CarePlanForCarePlanWorklistVoBean extends ims.vo.ValueObjectBean
{
	public CarePlanForCarePlanWorklistVoBean()
	{
	}
	public CarePlanForCarePlanWorklistVoBean(ims.nursing.vo.CarePlanForCarePlanWorklistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.title = vo.getTitle();
		this.nextevaluationdate = vo.getNextEvaluationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getNextEvaluationDate().getBean();
		this.confirmedby = vo.getConfirmedBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getConfirmedBy().getBean();
		this.currentcareplanstatus = vo.getCurrentCarePlanStatus() == null ? null : (ims.nursing.vo.beans.CarePlanStatusBean)vo.getCurrentCarePlanStatus().getBean();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.CarePlanForCarePlanWorklistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.title = vo.getTitle();
		this.nextevaluationdate = vo.getNextEvaluationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getNextEvaluationDate().getBean();
		this.confirmedby = vo.getConfirmedBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getConfirmedBy().getBean(map);
		this.currentcareplanstatus = vo.getCurrentCarePlanStatus() == null ? null : (ims.nursing.vo.beans.CarePlanStatusBean)vo.getCurrentCarePlanStatus().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean(map);
	}

	public ims.nursing.vo.CarePlanForCarePlanWorklistVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.CarePlanForCarePlanWorklistVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.CarePlanForCarePlanWorklistVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.CarePlanForCarePlanWorklistVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.CarePlanForCarePlanWorklistVo();
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
	public String getTitle()
	{
		return this.title;
	}
	public void setTitle(String value)
	{
		this.title = value;
	}
	public ims.framework.utils.beans.DateBean getNextEvaluationDate()
	{
		return this.nextevaluationdate;
	}
	public void setNextEvaluationDate(ims.framework.utils.beans.DateBean value)
	{
		this.nextevaluationdate = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getConfirmedBy()
	{
		return this.confirmedby;
	}
	public void setConfirmedBy(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.confirmedby = value;
	}
	public ims.nursing.vo.beans.CarePlanStatusBean getCurrentCarePlanStatus()
	{
		return this.currentcareplanstatus;
	}
	public void setCurrentCarePlanStatus(ims.nursing.vo.beans.CarePlanStatusBean value)
	{
		this.currentcareplanstatus = value;
	}
	public ims.core.vo.beans.CareContextShortVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextShortVoBean value)
	{
		this.carecontext = value;
	}

	private Integer id;
	private int version;
	private String title;
	private ims.framework.utils.beans.DateBean nextevaluationdate;
	private ims.core.vo.beans.HcpLiteVoBean confirmedby;
	private ims.nursing.vo.beans.CarePlanStatusBean currentcareplanstatus;
	private ims.core.vo.beans.CareContextShortVoBean carecontext;
}
