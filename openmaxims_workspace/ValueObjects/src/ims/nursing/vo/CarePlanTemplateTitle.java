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

package ims.nursing.vo;

/**
 * Linked to nursing.care plans.Care Plan Template business object (ID: 1010100000).
 */
public class CarePlanTemplateTitle extends ims.nursing.careplans.vo.CarePlanTemplateRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CarePlanTemplateTitle()
	{
	}
	public CarePlanTemplateTitle(Integer id, int version)
	{
		super(id, version);
	}
	public CarePlanTemplateTitle(ims.nursing.vo.beans.CarePlanTemplateTitleBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.creationdate = bean.getCreationDate() == null ? null : bean.getCreationDate().buildDate();
		this.assessmentcomponent = bean.getAssessmentComponent() == null ? null : ims.nursing.vo.lookups.AssessmentComponentType.buildLookup(bean.getAssessmentComponent());
		this.title = bean.getTitle();
		this.active = bean.getActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.CarePlanTemplateTitleBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.creationdate = bean.getCreationDate() == null ? null : bean.getCreationDate().buildDate();
		this.assessmentcomponent = bean.getAssessmentComponent() == null ? null : ims.nursing.vo.lookups.AssessmentComponentType.buildLookup(bean.getAssessmentComponent());
		this.title = bean.getTitle();
		this.active = bean.getActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.CarePlanTemplateTitleBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.CarePlanTemplateTitleBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.CarePlanTemplateTitleBean();
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
		if(fieldName.equals("CREATIONDATE"))
			return getCreationDate();
		if(fieldName.equals("ASSESSMENTCOMPONENT"))
			return getAssessmentComponent();
		if(fieldName.equals("TITLE"))
			return getTitle();
		if(fieldName.equals("ACTIVE"))
			return getActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCreationDateIsNotNull()
	{
		return this.creationdate != null;
	}
	public ims.framework.utils.Date getCreationDate()
	{
		return this.creationdate;
	}
	public void setCreationDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.creationdate = value;
	}
	public boolean getAssessmentComponentIsNotNull()
	{
		return this.assessmentcomponent != null;
	}
	public ims.nursing.vo.lookups.AssessmentComponentType getAssessmentComponent()
	{
		return this.assessmentcomponent;
	}
	public void setAssessmentComponent(ims.nursing.vo.lookups.AssessmentComponentType value)
	{
		this.isValidated = false;
		this.assessmentcomponent = value;
	}
	public boolean getTitleIsNotNull()
	{
		return this.title != null;
	}
	public String getTitle()
	{
		return this.title;
	}
	public static int getTitleMaxLength()
	{
		return 255;
	}
	public void setTitle(String value)
	{
		this.isValidated = false;
		this.title = value;
	}
	public boolean getActiveIsNotNull()
	{
		return this.active != null;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.isValidated = false;
		this.active = value;
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(this.id);
		return sb.toString();
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
		if(this.creationdate == null)
			listOfErrors.add("Creation Date is a mandatory field");
		if(this.title == null || this.title.length() == 0)
			listOfErrors.add("Title is a mandatory field");
		else if(this.title.length() > 255)
			listOfErrors.add("The length of the field [title] in the value object [ims.nursing.vo.CarePlanTemplateTitle] is too big. It should be less or equal to 255");
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
	
		CarePlanTemplateTitle clone = new CarePlanTemplateTitle(this.id, this.version);
		
		if(this.creationdate == null)
			clone.creationdate = null;
		else
			clone.creationdate = (ims.framework.utils.Date)this.creationdate.clone();
		if(this.assessmentcomponent == null)
			clone.assessmentcomponent = null;
		else
			clone.assessmentcomponent = (ims.nursing.vo.lookups.AssessmentComponentType)this.assessmentcomponent.clone();
		clone.title = this.title;
		clone.active = this.active;
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
		if (!(CarePlanTemplateTitle.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CarePlanTemplateTitle object cannot be compared an Object of type " + obj.getClass().getName());
		}
		CarePlanTemplateTitle compareObj = (CarePlanTemplateTitle)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getAssessmentComponent() == null && compareObj.getAssessmentComponent() != null)
				return -1;
			if(this.getAssessmentComponent() != null && compareObj.getAssessmentComponent() == null)
				return 1;
			if(this.getAssessmentComponent() != null && compareObj.getAssessmentComponent() != null)
				retVal = this.getAssessmentComponent().compareTo(compareObj.getAssessmentComponent());
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
		if(this.creationdate != null)
			count++;
		if(this.assessmentcomponent != null)
			count++;
		if(this.title != null)
			count++;
		if(this.active != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.framework.utils.Date creationdate;
	protected ims.nursing.vo.lookups.AssessmentComponentType assessmentcomponent;
	protected String title;
	protected Boolean active;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
