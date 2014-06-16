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

package ims.ocrr.vo.beans;

public class InvestigationQuestionAnswerVoBean extends ims.vo.ValueObjectBean
{
	public InvestigationQuestionAnswerVoBean()
	{
	}
	public InvestigationQuestionAnswerVoBean(ims.ocrr.vo.InvestigationQuestionAnswerVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigation = vo.getInvestigation() == null ? null : (ims.ocrr.vo.beans.InvestigationLiteVoBean)vo.getInvestigation().getBean();
		this.investigationquestionanswers = vo.getInvestigationQuestionAnswers() == null ? null : vo.getInvestigationQuestionAnswers().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.InvestigationQuestionAnswerVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigation = vo.getInvestigation() == null ? null : (ims.ocrr.vo.beans.InvestigationLiteVoBean)vo.getInvestigation().getBean(map);
		this.investigationquestionanswers = vo.getInvestigationQuestionAnswers() == null ? null : vo.getInvestigationQuestionAnswers().getBeanCollection();
	}

	public ims.ocrr.vo.InvestigationQuestionAnswerVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.InvestigationQuestionAnswerVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.InvestigationQuestionAnswerVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.InvestigationQuestionAnswerVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.InvestigationQuestionAnswerVo();
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
	public ims.ocrr.vo.beans.InvestigationLiteVoBean getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.beans.InvestigationLiteVoBean value)
	{
		this.investigation = value;
	}
	public ims.core.vo.beans.GeneralQuestionAnswerVoBean[] getInvestigationQuestionAnswers()
	{
		return this.investigationquestionanswers;
	}
	public void setInvestigationQuestionAnswers(ims.core.vo.beans.GeneralQuestionAnswerVoBean[] value)
	{
		this.investigationquestionanswers = value;
	}

	private Integer id;
	private int version;
	private ims.ocrr.vo.beans.InvestigationLiteVoBean investigation;
	private ims.core.vo.beans.GeneralQuestionAnswerVoBean[] investigationquestionanswers;
}
