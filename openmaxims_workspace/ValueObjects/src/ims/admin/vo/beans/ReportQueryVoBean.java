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

public class ReportQueryVoBean extends ims.vo.ValueObjectBean
{
	public ReportQueryVoBean()
	{
	}
	public ReportQueryVoBean(ims.admin.vo.ReportQueryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.description = vo.getDescription();
		this.queryxml = vo.getQueryXML();
		if(vo.getSeeds() != null)
		{
			this.seeds = new ims.vo.RefVoBean[vo.getSeeds().size()];
			for(int seeds_i = 0; seeds_i < vo.getSeeds().size(); seeds_i++)
			{
				this.seeds[seeds_i] = new ims.vo.RefVoBean(vo.getSeeds().get(seeds_i).getBoId(),vo.getSeeds().get(seeds_i).getBoVersion());
			}
		}
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.ReportQueryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.description = vo.getDescription();
		this.queryxml = vo.getQueryXML();
		if(vo.getSeeds() != null)
		{
			this.seeds = new ims.vo.RefVoBean[vo.getSeeds().size()];
			for(int seeds_i = 0; seeds_i < vo.getSeeds().size(); seeds_i++)
			{
				this.seeds[seeds_i] = new ims.vo.RefVoBean(vo.getSeeds().get(seeds_i).getBoId(),vo.getSeeds().get(seeds_i).getBoVersion());
			}
		}
	}

	public ims.admin.vo.ReportQueryVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.ReportQueryVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.ReportQueryVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.ReportQueryVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.ReportQueryVo();
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
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String value)
	{
		this.description = value;
	}
	public String getQueryXML()
	{
		return this.queryxml;
	}
	public void setQueryXML(String value)
	{
		this.queryxml = value;
	}
	public ims.vo.RefVoBean[] getSeeds()
	{
		return this.seeds;
	}
	public void setSeeds(ims.vo.RefVoBean[] value)
	{
		this.seeds = value;
	}

	private Integer id;
	private int version;
	private String name;
	private String description;
	private String queryxml;
	private ims.vo.RefVoBean[] seeds;
}
