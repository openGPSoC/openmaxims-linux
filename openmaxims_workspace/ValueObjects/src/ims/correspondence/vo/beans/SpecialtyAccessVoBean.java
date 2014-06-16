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

package ims.correspondence.vo.beans;

public class SpecialtyAccessVoBean extends ims.vo.ValueObjectBean
{
	public SpecialtyAccessVoBean()
	{
	}
	public SpecialtyAccessVoBean(ims.correspondence.vo.SpecialtyAccessVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.accessright = vo.getAccessRight() == null ? null : (ims.vo.LookupInstanceBean)vo.getAccessRight().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.correspondence.vo.SpecialtyAccessVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.accessright = vo.getAccessRight() == null ? null : (ims.vo.LookupInstanceBean)vo.getAccessRight().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
	}

	public ims.correspondence.vo.SpecialtyAccessVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.correspondence.vo.SpecialtyAccessVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.correspondence.vo.SpecialtyAccessVo vo = null;
		if(map != null)
			vo = (ims.correspondence.vo.SpecialtyAccessVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.correspondence.vo.SpecialtyAccessVo();
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
	public ims.vo.LookupInstanceBean getAccessRight()
	{
		return this.accessright;
	}
	public void setAccessRight(ims.vo.LookupInstanceBean value)
	{
		this.accessright = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean accessright;
	private ims.vo.LookupInstanceBean specialty;
}
