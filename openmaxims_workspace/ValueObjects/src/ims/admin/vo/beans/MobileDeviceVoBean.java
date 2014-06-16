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

package ims.admin.vo.beans;

public class MobileDeviceVoBean extends ims.vo.ValueObjectBean
{
	public MobileDeviceVoBean()
	{
	}
	public MobileDeviceVoBean(ims.admin.vo.MobileDeviceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.uniqueid = vo.getUniqueId();
		this.tokenid = vo.getTokenId();
		this.name = vo.getName();
		this.model = vo.getModel();
		this.systemname = vo.getSystemName();
		this.systemversion = vo.getSystemVersion();
		this.active = vo.getActive();
		this.applicationinfo = vo.getApplicationInfo();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.MobileDeviceVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.uniqueid = vo.getUniqueId();
		this.tokenid = vo.getTokenId();
		this.name = vo.getName();
		this.model = vo.getModel();
		this.systemname = vo.getSystemName();
		this.systemversion = vo.getSystemVersion();
		this.active = vo.getActive();
		this.applicationinfo = vo.getApplicationInfo();
	}

	public ims.admin.vo.MobileDeviceVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.MobileDeviceVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.MobileDeviceVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.MobileDeviceVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.MobileDeviceVo();
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
	public String getUniqueId()
	{
		return this.uniqueid;
	}
	public void setUniqueId(String value)
	{
		this.uniqueid = value;
	}
	public String getTokenId()
	{
		return this.tokenid;
	}
	public void setTokenId(String value)
	{
		this.tokenid = value;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public String getModel()
	{
		return this.model;
	}
	public void setModel(String value)
	{
		this.model = value;
	}
	public String getSystemName()
	{
		return this.systemname;
	}
	public void setSystemName(String value)
	{
		this.systemname = value;
	}
	public String getSystemVersion()
	{
		return this.systemversion;
	}
	public void setSystemVersion(String value)
	{
		this.systemversion = value;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.active = value;
	}
	public String getApplicationInfo()
	{
		return this.applicationinfo;
	}
	public void setApplicationInfo(String value)
	{
		this.applicationinfo = value;
	}

	private Integer id;
	private int version;
	private String uniqueid;
	private String tokenid;
	private String name;
	private String model;
	private String systemname;
	private String systemversion;
	private Boolean active;
	private String applicationinfo;
}
