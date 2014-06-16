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

public class PatientAssessmentQuestionVoBean extends ims.vo.ValueObjectBean
{
	public PatientAssessmentQuestionVoBean()
	{
	}
	public PatientAssessmentQuestionVoBean(ims.assessment.vo.PatientAssessmentQuestionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.isanswered = vo.getIsAnswered() == null ? null : (ims.vo.LookupInstanceBean)vo.getIsAnswered().getBean();
		this.assessmentquestion = vo.getAssessmentQuestion() == null ? null : (ims.core.vo.beans.AssessmentQuestionVoBean)vo.getAssessmentQuestion().getBean();
		this.patientanswers = vo.getPatientAnswers() == null ? null : vo.getPatientAnswers().getBeanCollection();
		this.ismandatory = vo.getIsMandatory();
		this.allowsmultipleanswers = vo.getAllowsMultipleAnswers();
		this.sequence = vo.getSequence();
		this.ispoc = vo.getIsPoc();
		this.isrolereadonly = vo.getIsRoleReadOnly();
		this.isconfirmed = vo.getIsConfirmed();
		this.ispocsaved = vo.getIsPocSaved();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.PatientAssessmentQuestionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.isanswered = vo.getIsAnswered() == null ? null : (ims.vo.LookupInstanceBean)vo.getIsAnswered().getBean();
		this.assessmentquestion = vo.getAssessmentQuestion() == null ? null : (ims.core.vo.beans.AssessmentQuestionVoBean)vo.getAssessmentQuestion().getBean(map);
		this.patientanswers = vo.getPatientAnswers() == null ? null : vo.getPatientAnswers().getBeanCollection();
		this.ismandatory = vo.getIsMandatory();
		this.allowsmultipleanswers = vo.getAllowsMultipleAnswers();
		this.sequence = vo.getSequence();
		this.ispoc = vo.getIsPoc();
		this.isrolereadonly = vo.getIsRoleReadOnly();
		this.isconfirmed = vo.getIsConfirmed();
		this.ispocsaved = vo.getIsPocSaved();
	}

	public ims.assessment.vo.PatientAssessmentQuestionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.PatientAssessmentQuestionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.PatientAssessmentQuestionVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.PatientAssessmentQuestionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.PatientAssessmentQuestionVo();
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
	public ims.vo.LookupInstanceBean getIsAnswered()
	{
		return this.isanswered;
	}
	public void setIsAnswered(ims.vo.LookupInstanceBean value)
	{
		this.isanswered = value;
	}
	public ims.core.vo.beans.AssessmentQuestionVoBean getAssessmentQuestion()
	{
		return this.assessmentquestion;
	}
	public void setAssessmentQuestion(ims.core.vo.beans.AssessmentQuestionVoBean value)
	{
		this.assessmentquestion = value;
	}
	public ims.assessment.vo.beans.PatientAssessmentAnswerVoBean[] getPatientAnswers()
	{
		return this.patientanswers;
	}
	public void setPatientAnswers(ims.assessment.vo.beans.PatientAssessmentAnswerVoBean[] value)
	{
		this.patientanswers = value;
	}
	public Boolean getIsMandatory()
	{
		return this.ismandatory;
	}
	public void setIsMandatory(Boolean value)
	{
		this.ismandatory = value;
	}
	public Boolean getAllowsMultipleAnswers()
	{
		return this.allowsmultipleanswers;
	}
	public void setAllowsMultipleAnswers(Boolean value)
	{
		this.allowsmultipleanswers = value;
	}
	public Integer getSequence()
	{
		return this.sequence;
	}
	public void setSequence(Integer value)
	{
		this.sequence = value;
	}
	public Boolean getIsPoc()
	{
		return this.ispoc;
	}
	public void setIsPoc(Boolean value)
	{
		this.ispoc = value;
	}
	public Boolean getIsRoleReadOnly()
	{
		return this.isrolereadonly;
	}
	public void setIsRoleReadOnly(Boolean value)
	{
		this.isrolereadonly = value;
	}
	public Boolean getIsConfirmed()
	{
		return this.isconfirmed;
	}
	public void setIsConfirmed(Boolean value)
	{
		this.isconfirmed = value;
	}
	public Boolean getIsPocSaved()
	{
		return this.ispocsaved;
	}
	public void setIsPocSaved(Boolean value)
	{
		this.ispocsaved = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean isanswered;
	private ims.core.vo.beans.AssessmentQuestionVoBean assessmentquestion;
	private ims.assessment.vo.beans.PatientAssessmentAnswerVoBean[] patientanswers;
	private Boolean ismandatory;
	private Boolean allowsmultipleanswers;
	private Integer sequence;
	private Boolean ispoc;
	private Boolean isrolereadonly;
	private Boolean isconfirmed;
	private Boolean ispocsaved;
}
