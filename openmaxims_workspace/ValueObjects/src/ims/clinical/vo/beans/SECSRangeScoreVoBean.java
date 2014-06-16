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

package ims.clinical.vo.beans;

public class SECSRangeScoreVoBean extends ims.vo.ValueObjectBean
{
	public SECSRangeScoreVoBean()
	{
	}
	public SECSRangeScoreVoBean(ims.clinical.vo.SECSRangeScoreVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.greaterthanintvalue = vo.getGreaterThanIntValue();
		this.lessthanintvalue = vo.getLessThanIntValue();
		this.warningtext = vo.getWarningText();
		this.score = vo.getScore();
		this.greaterthandecvalue = vo.getGreaterThanDecValue();
		this.lessthandecvalue = vo.getLessThanDecValue();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.SECSRangeScoreVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.greaterthanintvalue = vo.getGreaterThanIntValue();
		this.lessthanintvalue = vo.getLessThanIntValue();
		this.warningtext = vo.getWarningText();
		this.score = vo.getScore();
		this.greaterthandecvalue = vo.getGreaterThanDecValue();
		this.lessthandecvalue = vo.getLessThanDecValue();
	}

	public ims.clinical.vo.SECSRangeScoreVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.SECSRangeScoreVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.SECSRangeScoreVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.SECSRangeScoreVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.SECSRangeScoreVo();
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
	public Integer getGreaterThanIntValue()
	{
		return this.greaterthanintvalue;
	}
	public void setGreaterThanIntValue(Integer value)
	{
		this.greaterthanintvalue = value;
	}
	public Integer getLessThanIntValue()
	{
		return this.lessthanintvalue;
	}
	public void setLessThanIntValue(Integer value)
	{
		this.lessthanintvalue = value;
	}
	public String getWarningText()
	{
		return this.warningtext;
	}
	public void setWarningText(String value)
	{
		this.warningtext = value;
	}
	public Integer getScore()
	{
		return this.score;
	}
	public void setScore(Integer value)
	{
		this.score = value;
	}
	public Float getGreaterThanDecValue()
	{
		return this.greaterthandecvalue;
	}
	public void setGreaterThanDecValue(Float value)
	{
		this.greaterthandecvalue = value;
	}
	public Float getLessThanDecValue()
	{
		return this.lessthandecvalue;
	}
	public void setLessThanDecValue(Float value)
	{
		this.lessthandecvalue = value;
	}

	private Integer id;
	private int version;
	private Integer greaterthanintvalue;
	private Integer lessthanintvalue;
	private String warningtext;
	private Integer score;
	private Float greaterthandecvalue;
	private Float lessthandecvalue;
}
