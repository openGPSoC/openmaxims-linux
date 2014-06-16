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

package ims.scheduling.vo.beans;

public class Profile_Exc_DateVoBean extends ims.vo.ValueObjectBean
{
	public Profile_Exc_DateVoBean()
	{
	}
	public Profile_Exc_DateVoBean(ims.scheduling.vo.Profile_Exc_DateVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.Profile_Exc_DateVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
	}

	public ims.scheduling.vo.Profile_Exc_DateVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.Profile_Exc_DateVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.Profile_Exc_DateVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.Profile_Exc_DateVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.Profile_Exc_DateVo();
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
	public ims.framework.utils.beans.DateBean getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.startdate = value;
	}
	public ims.framework.utils.beans.DateBean getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.beans.DateBean value)
	{
		this.enddate = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean startdate;
	private ims.framework.utils.beans.DateBean enddate;
}
