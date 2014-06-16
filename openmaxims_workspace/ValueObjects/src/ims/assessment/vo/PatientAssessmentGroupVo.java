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

package ims.assessment.vo;

/**
 * Linked to Assessment.Instantiation.PatientAssessmentGroup business object (ID: 1003100059).
 */
public class PatientAssessmentGroupVo extends ims.assessment.instantiation.vo.PatientAssessmentGroupRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientAssessmentGroupVo()
	{
	}
	public PatientAssessmentGroupVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientAssessmentGroupVo(ims.assessment.vo.beans.PatientAssessmentGroupVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.assessmentquestiongroup = bean.getAssessmentQuestionGroup() == null ? null : bean.getAssessmentQuestionGroup().buildVo();
		this.currentscore = bean.getCurrentScore();
		this.assessmentanswers = ims.assessment.vo.PatientAssessmentQuestionVoCollection.buildFromBeanCollection(bean.getAssessmentAnswers());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.PatientAssessmentGroupVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.assessmentquestiongroup = bean.getAssessmentQuestionGroup() == null ? null : bean.getAssessmentQuestionGroup().buildVo(map);
		this.currentscore = bean.getCurrentScore();
		this.assessmentanswers = ims.assessment.vo.PatientAssessmentQuestionVoCollection.buildFromBeanCollection(bean.getAssessmentAnswers());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.PatientAssessmentGroupVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.PatientAssessmentGroupVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.PatientAssessmentGroupVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("ASSESSMENTQUESTIONGROUP"))
			return getAssessmentQuestionGroup();
		if(fieldName.equals("CURRENTSCORE"))
			return getCurrentScore();
		if(fieldName.equals("ASSESSMENTANSWERS"))
			return getAssessmentAnswers();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAssessmentQuestionGroupIsNotNull()
	{
		return this.assessmentquestiongroup != null;
	}
	public ims.core.vo.AssessmentQuestionGroupVo getAssessmentQuestionGroup()
	{
		return this.assessmentquestiongroup;
	}
	public void setAssessmentQuestionGroup(ims.core.vo.AssessmentQuestionGroupVo value)
	{
		this.isValidated = false;
		this.assessmentquestiongroup = value;
	}
	public boolean getCurrentScoreIsNotNull()
	{
		return this.currentscore != null;
	}
	public Float getCurrentScore()
	{
		return this.currentscore;
	}
	public void setCurrentScore(Float value)
	{
		this.isValidated = false;
		this.currentscore = value;
	}
	public boolean getAssessmentAnswersIsNotNull()
	{
		return this.assessmentanswers != null;
	}
	public ims.assessment.vo.PatientAssessmentQuestionVoCollection getAssessmentAnswers()
	{
		return this.assessmentanswers;
	}
	public void setAssessmentAnswers(ims.assessment.vo.PatientAssessmentQuestionVoCollection value)
	{
		this.isValidated = false;
		this.assessmentanswers = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.assessmentanswers != null)
		{
			if(!this.assessmentanswers.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.assessmentquestiongroup == null)
			listOfErrors.add("AssessmentQuestionGroup is mandatory");
		if(this.assessmentanswers == null || this.assessmentanswers.size() == 0)
			listOfErrors.add("AssessmentAnswers are mandatory");
		if(this.assessmentanswers != null)
		{
			String[] listOfOtherErrors = this.assessmentanswers.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		PatientAssessmentGroupVo clone = new PatientAssessmentGroupVo(this.id, this.version);
		
		if(this.assessmentquestiongroup == null)
			clone.assessmentquestiongroup = null;
		else
			clone.assessmentquestiongroup = (ims.core.vo.AssessmentQuestionGroupVo)this.assessmentquestiongroup.clone();
		clone.currentscore = this.currentscore;
		if(this.assessmentanswers == null)
			clone.assessmentanswers = null;
		else
			clone.assessmentanswers = (ims.assessment.vo.PatientAssessmentQuestionVoCollection)this.assessmentanswers.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(PatientAssessmentGroupVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientAssessmentGroupVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientAssessmentGroupVo compareObj = (PatientAssessmentGroupVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_PatientAssessmentGroup() == null && compareObj.getID_PatientAssessmentGroup() != null)
				return -1;
			if(this.getID_PatientAssessmentGroup() != null && compareObj.getID_PatientAssessmentGroup() == null)
				return 1;
			if(this.getID_PatientAssessmentGroup() != null && compareObj.getID_PatientAssessmentGroup() != null)
				retVal = this.getID_PatientAssessmentGroup().compareTo(compareObj.getID_PatientAssessmentGroup());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.assessmentquestiongroup != null)
			count++;
		if(this.currentscore != null)
			count++;
		if(this.assessmentanswers != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.AssessmentQuestionGroupVo assessmentquestiongroup;
	protected Float currentscore;
	protected ims.assessment.vo.PatientAssessmentQuestionVoCollection assessmentanswers;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
