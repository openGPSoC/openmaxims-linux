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

package ims.assessment.vo.beans;

public class Answer_OptionVoBean extends ims.vo.ValueObjectBean
{
	public Answer_OptionVoBean()
	{
	}
	public Answer_OptionVoBean(ims.assessment.vo.Answer_OptionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.optiontext = vo.getOptionText();
		this.optiondescription = vo.getOptionDescription();
		this.colour = vo.getColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getColour().getBean();
		this.score = vo.getScore();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.Answer_OptionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.optiontext = vo.getOptionText();
		this.optiondescription = vo.getOptionDescription();
		this.colour = vo.getColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getColour().getBean();
		this.score = vo.getScore();
	}

	public ims.assessment.vo.Answer_OptionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.Answer_OptionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.Answer_OptionVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.Answer_OptionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.Answer_OptionVo();
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
	public String getOptionText()
	{
		return this.optiontext;
	}
	public void setOptionText(String value)
	{
		this.optiontext = value;
	}
	public String getOptionDescription()
	{
		return this.optiondescription;
	}
	public void setOptionDescription(String value)
	{
		this.optiondescription = value;
	}
	public ims.framework.utils.beans.ColorBean getColour()
	{
		return this.colour;
	}
	public void setColour(ims.framework.utils.beans.ColorBean value)
	{
		this.colour = value;
	}
	public Float getScore()
	{
		return this.score;
	}
	public void setScore(Float value)
	{
		this.score = value;
	}

	private Integer id;
	private int version;
	private String optiontext;
	private String optiondescription;
	private ims.framework.utils.beans.ColorBean colour;
	private Float score;
}
