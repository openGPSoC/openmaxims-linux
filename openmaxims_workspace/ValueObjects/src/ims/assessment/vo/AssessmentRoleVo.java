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
 * Linked to Assessment.Configuration.AssessmentRole business object (ID: 1083100000).
 */
public class AssessmentRoleVo extends ims.assessment.configuration.vo.AssessmentRoleRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AssessmentRoleVo()
	{
	}
	public AssessmentRoleVo(Integer id, int version)
	{
		super(id, version);
	}
	public AssessmentRoleVo(ims.assessment.vo.beans.AssessmentRoleVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.answerall = bean.getAnswerAll();
		this.approle = bean.getAppRole() == null ? null : bean.getAppRole().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.AssessmentRoleVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.answerall = bean.getAnswerAll();
		this.approle = bean.getAppRole() == null ? null : bean.getAppRole().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.AssessmentRoleVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.AssessmentRoleVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.AssessmentRoleVoBean();
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
		if(fieldName.equals("ANSWERALL"))
			return getAnswerAll();
		if(fieldName.equals("APPROLE"))
			return getAppRole();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAnswerAllIsNotNull()
	{
		return this.answerall != null;
	}
	public Boolean getAnswerAll()
	{
		return this.answerall;
	}
	public void setAnswerAll(Boolean value)
	{
		this.isValidated = false;
		this.answerall = value;
	}
	public boolean getAppRoleIsNotNull()
	{
		return this.approle != null;
	}
	public ims.admin.vo.AppRoleShortVo getAppRole()
	{
		return this.approle;
	}
	public void setAppRole(ims.admin.vo.AppRoleShortVo value)
	{
		this.isValidated = false;
		this.approle = value;
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
		if(this.approle != null)
		{
			if(!this.approle.isValidated())
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
		if(this.approle != null)
		{
			String[] listOfOtherErrors = this.approle.validate();
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
	
		AssessmentRoleVo clone = new AssessmentRoleVo(this.id, this.version);
		
		clone.answerall = this.answerall;
		if(this.approle == null)
			clone.approle = null;
		else
			clone.approle = (ims.admin.vo.AppRoleShortVo)this.approle.clone();
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
		if (!(AssessmentRoleVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AssessmentRoleVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AssessmentRoleVo compareObj = (AssessmentRoleVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_AssessmentRole() == null && compareObj.getID_AssessmentRole() != null)
				return -1;
			if(this.getID_AssessmentRole() != null && compareObj.getID_AssessmentRole() == null)
				return 1;
			if(this.getID_AssessmentRole() != null && compareObj.getID_AssessmentRole() != null)
				retVal = this.getID_AssessmentRole().compareTo(compareObj.getID_AssessmentRole());
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
		if(this.answerall != null)
			count++;
		if(this.approle != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected Boolean answerall;
	protected ims.admin.vo.AppRoleShortVo approle;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
