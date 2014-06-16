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

public class HandJaymarFindingsVoBean extends ims.vo.ValueObjectBean
{
	public HandJaymarFindingsVoBean()
	{
	}
	public HandJaymarFindingsVoBean(ims.therapies.vo.HandJaymarFindingsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.laterality = vo.getLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getLaterality().getBean();
		this.test1 = vo.getTest1();
		this.test2 = vo.getTest2();
		this.test3 = vo.getTest3();
		this.levelaverage = vo.getLevelAverage();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.HandJaymarFindingsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.laterality = vo.getLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getLaterality().getBean();
		this.test1 = vo.getTest1();
		this.test2 = vo.getTest2();
		this.test3 = vo.getTest3();
		this.levelaverage = vo.getLevelAverage();
	}

	public ims.therapies.vo.HandJaymarFindingsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.HandJaymarFindingsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.HandJaymarFindingsVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.HandJaymarFindingsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.HandJaymarFindingsVo();
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
	public ims.vo.LookupInstanceBean getLaterality()
	{
		return this.laterality;
	}
	public void setLaterality(ims.vo.LookupInstanceBean value)
	{
		this.laterality = value;
	}
	public Float getTest1()
	{
		return this.test1;
	}
	public void setTest1(Float value)
	{
		this.test1 = value;
	}
	public Float getTest2()
	{
		return this.test2;
	}
	public void setTest2(Float value)
	{
		this.test2 = value;
	}
	public Float getTest3()
	{
		return this.test3;
	}
	public void setTest3(Float value)
	{
		this.test3 = value;
	}
	public Float getLevelAverage()
	{
		return this.levelaverage;
	}
	public void setLevelAverage(Float value)
	{
		this.levelaverage = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean laterality;
	private Float test1;
	private Float test2;
	private Float test3;
	private Float levelaverage;
}
