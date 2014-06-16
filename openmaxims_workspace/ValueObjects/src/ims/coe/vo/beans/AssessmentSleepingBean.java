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

package ims.coe.vo.beans;

public class AssessmentSleepingBean extends ims.vo.ValueObjectBean
{
	public AssessmentSleepingBean()
	{
	}
	public AssessmentSleepingBean(ims.coe.vo.AssessmentSleeping vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.iscomplete = vo.getIsComplete();
		this.assessmentinfo = vo.getAssessmentInfo() == null ? null : vo.getAssessmentInfo().getBeanCollection();
		this.copy = vo.getCopy();
		this.componenttype = vo.getComponentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getComponentType().getBean();
		this.lastassessmentinfo = vo.getLastAssessmentInfo() == null ? null : (ims.nursing.vo.beans.AssessmentInfoBean)vo.getLastAssessmentInfo().getBean();
		this.careplantemplate = vo.getCarePlanTemplate() == null ? null : vo.getCarePlanTemplate().getBeanCollection();
		this.careplans = vo.getCarePlans() == null ? null : vo.getCarePlans().getBeanCollection();
		this.timepatientgotobed = vo.getTimePatientGoToBed() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTimePatientGoToBed().getBean();
		this.timepatientgetup = vo.getTimePatientGetUp() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTimePatientGetUp().getBean();
		this.howmanyblankets = vo.getHowManyBlankets();
		this.howmanypillows = vo.getHowManyPillows();
		this.patternofsleep = vo.getPatternOfSleep();
		this.patienthavedifficultyinsleeping = vo.getPatientHaveDifficultyInSleeping() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientHaveDifficultyInSleeping().getBean();
		this.sleepingaids = vo.getSleepingAids() == null ? null : (ims.coe.vo.beans.SleepingAidsVoBean)vo.getSleepingAids().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.AssessmentSleeping vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.iscomplete = vo.getIsComplete();
		this.assessmentinfo = vo.getAssessmentInfo() == null ? null : vo.getAssessmentInfo().getBeanCollection();
		this.copy = vo.getCopy();
		this.componenttype = vo.getComponentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getComponentType().getBean();
		this.lastassessmentinfo = vo.getLastAssessmentInfo() == null ? null : (ims.nursing.vo.beans.AssessmentInfoBean)vo.getLastAssessmentInfo().getBean(map);
		this.careplantemplate = vo.getCarePlanTemplate() == null ? null : vo.getCarePlanTemplate().getBeanCollection();
		this.careplans = vo.getCarePlans() == null ? null : vo.getCarePlans().getBeanCollection();
		this.timepatientgotobed = vo.getTimePatientGoToBed() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTimePatientGoToBed().getBean();
		this.timepatientgetup = vo.getTimePatientGetUp() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTimePatientGetUp().getBean();
		this.howmanyblankets = vo.getHowManyBlankets();
		this.howmanypillows = vo.getHowManyPillows();
		this.patternofsleep = vo.getPatternOfSleep();
		this.patienthavedifficultyinsleeping = vo.getPatientHaveDifficultyInSleeping() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientHaveDifficultyInSleeping().getBean();
		this.sleepingaids = vo.getSleepingAids() == null ? null : (ims.coe.vo.beans.SleepingAidsVoBean)vo.getSleepingAids().getBean(map);
	}

	public ims.coe.vo.AssessmentSleeping buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.coe.vo.AssessmentSleeping buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.AssessmentSleeping vo = null;
		if(map != null)
			vo = (ims.coe.vo.AssessmentSleeping)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.coe.vo.AssessmentSleeping();
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
	public Boolean getIsComplete()
	{
		return this.iscomplete;
	}
	public void setIsComplete(Boolean value)
	{
		this.iscomplete = value;
	}
	public ims.nursing.vo.beans.AssessmentInfoBean[] getAssessmentInfo()
	{
		return this.assessmentinfo;
	}
	public void setAssessmentInfo(ims.nursing.vo.beans.AssessmentInfoBean[] value)
	{
		this.assessmentinfo = value;
	}
	public Boolean getCopy()
	{
		return this.copy;
	}
	public void setCopy(Boolean value)
	{
		this.copy = value;
	}
	public ims.vo.LookupInstanceBean getComponentType()
	{
		return this.componenttype;
	}
	public void setComponentType(ims.vo.LookupInstanceBean value)
	{
		this.componenttype = value;
	}
	public ims.nursing.vo.beans.AssessmentInfoBean getLastAssessmentInfo()
	{
		return this.lastassessmentinfo;
	}
	public void setLastAssessmentInfo(ims.nursing.vo.beans.AssessmentInfoBean value)
	{
		this.lastassessmentinfo = value;
	}
	public ims.nursing.vo.beans.CarePlanTemplateBean[] getCarePlanTemplate()
	{
		return this.careplantemplate;
	}
	public void setCarePlanTemplate(ims.nursing.vo.beans.CarePlanTemplateBean[] value)
	{
		this.careplantemplate = value;
	}
	public ims.nursing.vo.beans.CarePlanBean[] getCarePlans()
	{
		return this.careplans;
	}
	public void setCarePlans(ims.nursing.vo.beans.CarePlanBean[] value)
	{
		this.careplans = value;
	}
	public ims.framework.utils.beans.TimeBean getTimePatientGoToBed()
	{
		return this.timepatientgotobed;
	}
	public void setTimePatientGoToBed(ims.framework.utils.beans.TimeBean value)
	{
		this.timepatientgotobed = value;
	}
	public ims.framework.utils.beans.TimeBean getTimePatientGetUp()
	{
		return this.timepatientgetup;
	}
	public void setTimePatientGetUp(ims.framework.utils.beans.TimeBean value)
	{
		this.timepatientgetup = value;
	}
	public Integer getHowManyBlankets()
	{
		return this.howmanyblankets;
	}
	public void setHowManyBlankets(Integer value)
	{
		this.howmanyblankets = value;
	}
	public Integer getHowManyPillows()
	{
		return this.howmanypillows;
	}
	public void setHowManyPillows(Integer value)
	{
		this.howmanypillows = value;
	}
	public String getPatternOfSleep()
	{
		return this.patternofsleep;
	}
	public void setPatternOfSleep(String value)
	{
		this.patternofsleep = value;
	}
	public ims.vo.LookupInstanceBean getPatientHaveDifficultyInSleeping()
	{
		return this.patienthavedifficultyinsleeping;
	}
	public void setPatientHaveDifficultyInSleeping(ims.vo.LookupInstanceBean value)
	{
		this.patienthavedifficultyinsleeping = value;
	}
	public ims.coe.vo.beans.SleepingAidsVoBean getSleepingAids()
	{
		return this.sleepingaids;
	}
	public void setSleepingAids(ims.coe.vo.beans.SleepingAidsVoBean value)
	{
		this.sleepingaids = value;
	}

	private Integer id;
	private int version;
	private Boolean iscomplete;
	private ims.nursing.vo.beans.AssessmentInfoBean[] assessmentinfo;
	private Boolean copy;
	private ims.vo.LookupInstanceBean componenttype;
	private ims.nursing.vo.beans.AssessmentInfoBean lastassessmentinfo;
	private ims.nursing.vo.beans.CarePlanTemplateBean[] careplantemplate;
	private ims.nursing.vo.beans.CarePlanBean[] careplans;
	private ims.framework.utils.beans.TimeBean timepatientgotobed;
	private ims.framework.utils.beans.TimeBean timepatientgetup;
	private Integer howmanyblankets;
	private Integer howmanypillows;
	private String patternofsleep;
	private ims.vo.LookupInstanceBean patienthavedifficultyinsleeping;
	private ims.coe.vo.beans.SleepingAidsVoBean sleepingaids;
}
