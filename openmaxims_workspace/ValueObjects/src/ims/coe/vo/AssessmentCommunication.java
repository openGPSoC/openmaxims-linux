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

package ims.coe.vo;

/**
 * Linked to nursing.assessment.Assessment Component business object (ID: 1015100001).
 */
public class AssessmentCommunication extends ims.nursing.vo.AssessmentComponent implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AssessmentCommunication()
	{
	}
	public AssessmentCommunication(Integer id, int version)
	{
		super(id, version);
	}
	public AssessmentCommunication(ims.coe.vo.beans.AssessmentCommunicationBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.iscomplete = bean.getIsComplete();
		this.assessmentinfo = ims.nursing.vo.AssessmentInfoCollection.buildFromBeanCollection(bean.getAssessmentInfo());
		this.copy = bean.getCopy();
		this.componenttype = bean.getComponentType() == null ? null : ims.nursing.vo.lookups.AssessmentComponentType.buildLookup(bean.getComponentType());
		this.lastassessmentinfo = bean.getLastAssessmentInfo() == null ? null : bean.getLastAssessmentInfo().buildVo();
		this.careplantemplate = ims.nursing.vo.CarePlanTemplateCollection.buildFromBeanCollection(bean.getCarePlanTemplate());
		this.careplans = ims.nursing.vo.CarePlanCollection.buildFromBeanCollection(bean.getCarePlans());
		this.difficultyincommunication = bean.getDifficultyInCommunication() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getDifficultyInCommunication());
		this.speechandlanguage = bean.getSpeechAndLanguage() == null ? null : bean.getSpeechAndLanguage().buildVo();
		this.vision = bean.getVision() == null ? null : bean.getVision().buildVo();
		this.hearing = bean.getHearing() == null ? null : bean.getHearing().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.beans.AssessmentCommunicationBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.iscomplete = bean.getIsComplete();
		this.assessmentinfo = ims.nursing.vo.AssessmentInfoCollection.buildFromBeanCollection(bean.getAssessmentInfo());
		this.copy = bean.getCopy();
		this.componenttype = bean.getComponentType() == null ? null : ims.nursing.vo.lookups.AssessmentComponentType.buildLookup(bean.getComponentType());
		this.lastassessmentinfo = bean.getLastAssessmentInfo() == null ? null : bean.getLastAssessmentInfo().buildVo(map);
		this.careplantemplate = ims.nursing.vo.CarePlanTemplateCollection.buildFromBeanCollection(bean.getCarePlanTemplate());
		this.careplans = ims.nursing.vo.CarePlanCollection.buildFromBeanCollection(bean.getCarePlans());
		this.difficultyincommunication = bean.getDifficultyInCommunication() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getDifficultyInCommunication());
		this.speechandlanguage = bean.getSpeechAndLanguage() == null ? null : bean.getSpeechAndLanguage().buildVo(map);
		this.vision = bean.getVision() == null ? null : bean.getVision().buildVo(map);
		this.hearing = bean.getHearing() == null ? null : bean.getHearing().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.beans.AssessmentCommunicationBean bean = null;
		if(map != null)
			bean = (ims.coe.vo.beans.AssessmentCommunicationBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.coe.vo.beans.AssessmentCommunicationBean();
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
		if(fieldName.equals("DIFFICULTYINCOMMUNICATION"))
			return getDifficultyInCommunication();
		if(fieldName.equals("SPEECHANDLANGUAGE"))
			return getSpeechAndLanguage();
		if(fieldName.equals("VISION"))
			return getVision();
		if(fieldName.equals("HEARING"))
			return getHearing();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDifficultyInCommunicationIsNotNull()
	{
		return this.difficultyincommunication != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getDifficultyInCommunication()
	{
		return this.difficultyincommunication;
	}
	public void setDifficultyInCommunication(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.difficultyincommunication = value;
	}
	public boolean getSpeechAndLanguageIsNotNull()
	{
		return this.speechandlanguage != null;
	}
	public ims.coe.vo.CommunicationSpeechAndLanguageVo getSpeechAndLanguage()
	{
		return this.speechandlanguage;
	}
	public void setSpeechAndLanguage(ims.coe.vo.CommunicationSpeechAndLanguageVo value)
	{
		this.isValidated = false;
		this.speechandlanguage = value;
	}
	public boolean getVisionIsNotNull()
	{
		return this.vision != null;
	}
	public ims.coe.vo.CommunicationVisionVo getVision()
	{
		return this.vision;
	}
	public void setVision(ims.coe.vo.CommunicationVisionVo value)
	{
		this.isValidated = false;
		this.vision = value;
	}
	public boolean getHearingIsNotNull()
	{
		return this.hearing != null;
	}
	public ims.coe.vo.CommunicationHearingVo getHearing()
	{
		return this.hearing;
	}
	public void setHearing(ims.coe.vo.CommunicationHearingVo value)
	{
		this.isValidated = false;
		this.hearing = value;
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
		if(this.assessmentinfo != null)
		{
			if(!this.assessmentinfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.lastassessmentinfo != null)
		{
			if(!this.lastassessmentinfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.careplantemplate != null)
		{
			if(!this.careplantemplate.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.careplans != null)
		{
			if(!this.careplans.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.speechandlanguage != null)
		{
			if(!this.speechandlanguage.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.vision != null)
		{
			if(!this.vision.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.hearing != null)
		{
			if(!this.hearing.isValidated())
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
		if(this.assessmentinfo != null)
		{
			String[] listOfOtherErrors = this.assessmentinfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.lastassessmentinfo != null)
		{
			String[] listOfOtherErrors = this.lastassessmentinfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.careplantemplate != null)
		{
			String[] listOfOtherErrors = this.careplantemplate.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.careplans != null)
		{
			String[] listOfOtherErrors = this.careplans.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.speechandlanguage != null)
		{
			String[] listOfOtherErrors = this.speechandlanguage.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.vision != null)
		{
			String[] listOfOtherErrors = this.vision.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.hearing != null)
		{
			String[] listOfOtherErrors = this.hearing.validate();
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
	
		AssessmentCommunication clone = new AssessmentCommunication(this.id, this.version);
		
		clone.iscomplete = this.iscomplete;
		if(this.assessmentinfo == null)
			clone.assessmentinfo = null;
		else
			clone.assessmentinfo = (ims.nursing.vo.AssessmentInfoCollection)this.assessmentinfo.clone();
		clone.copy = this.copy;
		if(this.componenttype == null)
			clone.componenttype = null;
		else
			clone.componenttype = (ims.nursing.vo.lookups.AssessmentComponentType)this.componenttype.clone();
		if(this.lastassessmentinfo == null)
			clone.lastassessmentinfo = null;
		else
			clone.lastassessmentinfo = (ims.nursing.vo.AssessmentInfo)this.lastassessmentinfo.clone();
		if(this.careplantemplate == null)
			clone.careplantemplate = null;
		else
			clone.careplantemplate = (ims.nursing.vo.CarePlanTemplateCollection)this.careplantemplate.clone();
		if(this.careplans == null)
			clone.careplans = null;
		else
			clone.careplans = (ims.nursing.vo.CarePlanCollection)this.careplans.clone();
		if(this.difficultyincommunication == null)
			clone.difficultyincommunication = null;
		else
			clone.difficultyincommunication = (ims.core.vo.lookups.YesNoUnknown)this.difficultyincommunication.clone();
		if(this.speechandlanguage == null)
			clone.speechandlanguage = null;
		else
			clone.speechandlanguage = (ims.coe.vo.CommunicationSpeechAndLanguageVo)this.speechandlanguage.clone();
		if(this.vision == null)
			clone.vision = null;
		else
			clone.vision = (ims.coe.vo.CommunicationVisionVo)this.vision.clone();
		if(this.hearing == null)
			clone.hearing = null;
		else
			clone.hearing = (ims.coe.vo.CommunicationHearingVo)this.hearing.clone();
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
		if (!(AssessmentCommunication.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AssessmentCommunication object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AssessmentCommunication)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AssessmentCommunication)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.difficultyincommunication != null)
			count++;
		if(this.speechandlanguage != null)
			count++;
		if(this.vision != null)
			count++;
		if(this.hearing != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 4;
	}
	protected ims.core.vo.lookups.YesNoUnknown difficultyincommunication;
	protected ims.coe.vo.CommunicationSpeechAndLanguageVo speechandlanguage;
	protected ims.coe.vo.CommunicationVisionVo vision;
	protected ims.coe.vo.CommunicationHearingVo hearing;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
