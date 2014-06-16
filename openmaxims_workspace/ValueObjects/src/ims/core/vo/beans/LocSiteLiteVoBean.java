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

public class LocSiteLiteVoBean extends ims.vo.ValueObjectBean
{
	public LocSiteLiteVoBean()
	{
	}
	public LocSiteLiteVoBean(ims.core.vo.LocSiteLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.isactive = vo.getIsActive();
		this.isvirtual = vo.getIsVirtual();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.LocSiteLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.isactive = vo.getIsActive();
		this.isvirtual = vo.getIsVirtual();
	}

	public ims.core.vo.LocSiteLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.LocSiteLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.LocSiteLiteVo vo = null;
		if(map != null)
			vo = (ims.core.vo.LocSiteLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.LocSiteLiteVo();
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
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public Boolean getIsVirtual()
	{
		return this.isvirtual;
	}
	public void setIsVirtual(Boolean value)
	{
		this.isvirtual = value;
	}

	private Integer id;
	private int version;
	private String name;
	private Boolean isactive;
	private Boolean isvirtual;
}
