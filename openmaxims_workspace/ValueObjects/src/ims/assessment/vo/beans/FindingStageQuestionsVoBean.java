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

public class FindingStageQuestionsVoBean extends ims.vo.ValueObjectBean
{
	public FindingStageQuestionsVoBean()
	{
	}
	public FindingStageQuestionsVoBean(ims.assessment.vo.FindingStageQuestionsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.assessmentstage = vo.getAssessmentStage() == null ? null : (ims.assessment.vo.beans.GraphicAssessmentStageVoBean)vo.getAssessmentStage().getBean();
		this.associatedquestions = vo.getAssociatedQuestions() == null ? null : vo.getAssociatedQuestions().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.FindingStageQuestionsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.assessmentstage = vo.getAssessmentStage() == null ? null : (ims.assessment.vo.beans.GraphicAssessmentStageVoBean)vo.getAssessmentStage().getBean(map);
		this.associatedquestions = vo.getAssociatedQuestions() == null ? null : vo.getAssociatedQuestions().getBeanCollection();
	}

	public ims.assessment.vo.FindingStageQuestionsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.FindingStageQuestionsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.FindingStageQuestionsVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.FindingStageQuestionsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.FindingStageQuestionsVo();
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
	public ims.assessment.vo.beans.GraphicAssessmentStageVoBean getAssessmentStage()
	{
		return this.assessmentstage;
	}
	public void setAssessmentStage(ims.assessment.vo.beans.GraphicAssessmentStageVoBean value)
	{
		this.assessmentstage = value;
	}
	public ims.assessment.vo.beans.GraphicAssessmentFindingQuestionVoBean[] getAssociatedQuestions()
	{
		return this.associatedquestions;
	}
	public void setAssociatedQuestions(ims.assessment.vo.beans.GraphicAssessmentFindingQuestionVoBean[] value)
	{
		this.associatedquestions = value;
	}

	private Integer id;
	private int version;
	private ims.assessment.vo.beans.GraphicAssessmentStageVoBean assessmentstage;
	private ims.assessment.vo.beans.GraphicAssessmentFindingQuestionVoBean[] associatedquestions;
}
