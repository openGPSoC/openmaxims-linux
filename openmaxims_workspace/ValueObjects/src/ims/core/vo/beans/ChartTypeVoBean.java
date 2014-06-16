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

public class ChartTypeVoBean extends ims.vo.ValueObjectBean
{
	public ChartTypeVoBean()
	{
	}
	public ChartTypeVoBean(ims.core.vo.ChartTypeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.description = vo.getDescription();
		this.maxfactor = vo.getMaxFactor();
		this.minfactor = vo.getMinFactor();
		this.belowbandpercent = vo.getBelowBandPercent();
		this.abovebandpercent = vo.getAboveBandPercent();
		this.backgroundcolour = vo.getBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getBackgroundColour().getBean();
		this.foregroundcolour = vo.getForegroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getForegroundColour().getBean();
		this.normalbandcolour = vo.getNormalBandColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getNormalBandColour().getBean();
		this.isactive = vo.getIsActive();
		this.datasettypes = vo.getDatasetTypes() == null ? null : vo.getDatasetTypes().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ChartTypeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.description = vo.getDescription();
		this.maxfactor = vo.getMaxFactor();
		this.minfactor = vo.getMinFactor();
		this.belowbandpercent = vo.getBelowBandPercent();
		this.abovebandpercent = vo.getAboveBandPercent();
		this.backgroundcolour = vo.getBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getBackgroundColour().getBean();
		this.foregroundcolour = vo.getForegroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getForegroundColour().getBean();
		this.normalbandcolour = vo.getNormalBandColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getNormalBandColour().getBean();
		this.isactive = vo.getIsActive();
		this.datasettypes = vo.getDatasetTypes() == null ? null : vo.getDatasetTypes().getBeanCollection();
	}

	public ims.core.vo.ChartTypeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ChartTypeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ChartTypeVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ChartTypeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ChartTypeVo();
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
	public Integer getMaxFactor()
	{
		return this.maxfactor;
	}
	public void setMaxFactor(Integer value)
	{
		this.maxfactor = value;
	}
	public Integer getMinFactor()
	{
		return this.minfactor;
	}
	public void setMinFactor(Integer value)
	{
		this.minfactor = value;
	}
	public Integer getBelowBandPercent()
	{
		return this.belowbandpercent;
	}
	public void setBelowBandPercent(Integer value)
	{
		this.belowbandpercent = value;
	}
	public Integer getAboveBandPercent()
	{
		return this.abovebandpercent;
	}
	public void setAboveBandPercent(Integer value)
	{
		this.abovebandpercent = value;
	}
	public ims.framework.utils.beans.ColorBean getBackgroundColour()
	{
		return this.backgroundcolour;
	}
	public void setBackgroundColour(ims.framework.utils.beans.ColorBean value)
	{
		this.backgroundcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getForegroundColour()
	{
		return this.foregroundcolour;
	}
	public void setForegroundColour(ims.framework.utils.beans.ColorBean value)
	{
		this.foregroundcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getNormalBandColour()
	{
		return this.normalbandcolour;
	}
	public void setNormalBandColour(ims.framework.utils.beans.ColorBean value)
	{
		this.normalbandcolour = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.core.vo.beans.ChartTypeDatasetVoBean[] getDatasetTypes()
	{
		return this.datasettypes;
	}
	public void setDatasetTypes(ims.core.vo.beans.ChartTypeDatasetVoBean[] value)
	{
		this.datasettypes = value;
	}

	private Integer id;
	private int version;
	private String name;
	private String description;
	private Integer maxfactor;
	private Integer minfactor;
	private Integer belowbandpercent;
	private Integer abovebandpercent;
	private ims.framework.utils.beans.ColorBean backgroundcolour;
	private ims.framework.utils.beans.ColorBean foregroundcolour;
	private ims.framework.utils.beans.ColorBean normalbandcolour;
	private Boolean isactive;
	private ims.core.vo.beans.ChartTypeDatasetVoBean[] datasettypes;
}
