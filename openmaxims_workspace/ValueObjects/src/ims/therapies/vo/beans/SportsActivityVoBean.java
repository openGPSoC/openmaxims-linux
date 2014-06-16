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

package ims.therapies.vo.beans;

public class SportsActivityVoBean extends ims.vo.ValueObjectBean
{
	public SportsActivityVoBean()
	{
	}
	public SportsActivityVoBean(ims.therapies.vo.SportsActivityVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.sportsactivity = vo.getSportsActivity() == null ? null : (ims.vo.LookupInstanceBean)vo.getSportsActivity().getBean();
		this.select = vo.getSelect() == null ? null : (ims.vo.LookupInstanceBean)vo.getSelect().getBean();
		this.comments = vo.getComments();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.SportsActivityVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.sportsactivity = vo.getSportsActivity() == null ? null : (ims.vo.LookupInstanceBean)vo.getSportsActivity().getBean();
		this.select = vo.getSelect() == null ? null : (ims.vo.LookupInstanceBean)vo.getSelect().getBean();
		this.comments = vo.getComments();
	}

	public ims.therapies.vo.SportsActivityVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.SportsActivityVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.SportsActivityVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.SportsActivityVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.SportsActivityVo();
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
	public ims.vo.LookupInstanceBean getSportsActivity()
	{
		return this.sportsactivity;
	}
	public void setSportsActivity(ims.vo.LookupInstanceBean value)
	{
		this.sportsactivity = value;
	}
	public ims.vo.LookupInstanceBean getSelect()
	{
		return this.select;
	}
	public void setSelect(ims.vo.LookupInstanceBean value)
	{
		this.select = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean sportsactivity;
	private ims.vo.LookupInstanceBean select;
	private String comments;
}
