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

public class Question_AnswerTypeVoBean extends ims.vo.ValueObjectBean
{
	public Question_AnswerTypeVoBean()
	{
	}
	public Question_AnswerTypeVoBean(ims.assessment.vo.Question_AnswerTypeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.answertype = vo.getAnswerType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnswerType().getBean();
		this.activestatus = vo.getActiveStatus();
		this.answerwidth = vo.getAnswerWidth();
		this.separatortext = vo.getSeparatorText();
		this.maxmultiselectallowed = vo.getMaxMultiselectAllowed();
		this.options = vo.getOptions() == null ? null : vo.getOptions().getBeanCollection();
		this.ismandatory = vo.getIsMandatory();
		this.mandatoryvalmessage = vo.getMandatoryValMessage();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.Question_AnswerTypeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.answertype = vo.getAnswerType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnswerType().getBean();
		this.activestatus = vo.getActiveStatus();
		this.answerwidth = vo.getAnswerWidth();
		this.separatortext = vo.getSeparatorText();
		this.maxmultiselectallowed = vo.getMaxMultiselectAllowed();
		this.options = vo.getOptions() == null ? null : vo.getOptions().getBeanCollection();
		this.ismandatory = vo.getIsMandatory();
		this.mandatoryvalmessage = vo.getMandatoryValMessage();
	}

	public ims.assessment.vo.Question_AnswerTypeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.Question_AnswerTypeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.Question_AnswerTypeVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.Question_AnswerTypeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.Question_AnswerTypeVo();
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
	public ims.vo.LookupInstanceBean getAnswerType()
	{
		return this.answertype;
	}
	public void setAnswerType(ims.vo.LookupInstanceBean value)
	{
		this.answertype = value;
	}
	public Boolean getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(Boolean value)
	{
		this.activestatus = value;
	}
	public Integer getAnswerWidth()
	{
		return this.answerwidth;
	}
	public void setAnswerWidth(Integer value)
	{
		this.answerwidth = value;
	}
	public String getSeparatorText()
	{
		return this.separatortext;
	}
	public void setSeparatorText(String value)
	{
		this.separatortext = value;
	}
	public Integer getMaxMultiselectAllowed()
	{
		return this.maxmultiselectallowed;
	}
	public void setMaxMultiselectAllowed(Integer value)
	{
		this.maxmultiselectallowed = value;
	}
	public ims.assessment.vo.beans.Answer_OptionVoBean[] getOptions()
	{
		return this.options;
	}
	public void setOptions(ims.assessment.vo.beans.Answer_OptionVoBean[] value)
	{
		this.options = value;
	}
	public Boolean getIsMandatory()
	{
		return this.ismandatory;
	}
	public void setIsMandatory(Boolean value)
	{
		this.ismandatory = value;
	}
	public String getMandatoryValMessage()
	{
		return this.mandatoryvalmessage;
	}
	public void setMandatoryValMessage(String value)
	{
		this.mandatoryvalmessage = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean answertype;
	private Boolean activestatus;
	private Integer answerwidth;
	private String separatortext;
	private Integer maxmultiselectallowed;
	private ims.assessment.vo.beans.Answer_OptionVoBean[] options;
	private Boolean ismandatory;
	private String mandatoryvalmessage;
}
