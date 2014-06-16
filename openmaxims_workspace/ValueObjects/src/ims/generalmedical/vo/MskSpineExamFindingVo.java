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

package ims.generalmedical.vo;

/**
 * Linked to medical.MskSpineExamFinding business object (ID: 1023100023).
 */
public class MskSpineExamFindingVo extends ims.medical.vo.MskSpineExamFindingRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MskSpineExamFindingVo()
	{
	}
	public MskSpineExamFindingVo(Integer id, int version)
	{
		super(id, version);
	}
	public MskSpineExamFindingVo(ims.generalmedical.vo.beans.MskSpineExamFindingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.spinesitename = bean.getSpineSiteName();
		this.spinesitedetails = bean.getSpineSiteDetails();
		this.spinefindinterpretation = bean.getSpineFindInterpretation();
		this.isproblem = bean.getIsProblem();
		this.findingtype = bean.getFindingType() == null ? null : ims.spinalinjuries.vo.lookups.SpineExaminationFinding.buildLookup(bean.getFindingType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.beans.MskSpineExamFindingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.spinesitename = bean.getSpineSiteName();
		this.spinesitedetails = bean.getSpineSiteDetails();
		this.spinefindinterpretation = bean.getSpineFindInterpretation();
		this.isproblem = bean.getIsProblem();
		this.findingtype = bean.getFindingType() == null ? null : ims.spinalinjuries.vo.lookups.SpineExaminationFinding.buildLookup(bean.getFindingType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.beans.MskSpineExamFindingVoBean bean = null;
		if(map != null)
			bean = (ims.generalmedical.vo.beans.MskSpineExamFindingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.generalmedical.vo.beans.MskSpineExamFindingVoBean();
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
		if(fieldName.equals("SPINESITENAME"))
			return getSpineSiteName();
		if(fieldName.equals("SPINESITEDETAILS"))
			return getSpineSiteDetails();
		if(fieldName.equals("SPINEFINDINTERPRETATION"))
			return getSpineFindInterpretation();
		if(fieldName.equals("ISPROBLEM"))
			return getIsProblem();
		if(fieldName.equals("FINDINGTYPE"))
			return getFindingType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSpineSiteNameIsNotNull()
	{
		return this.spinesitename != null;
	}
	public String getSpineSiteName()
	{
		return this.spinesitename;
	}
	public static int getSpineSiteNameMaxLength()
	{
		return 100;
	}
	public void setSpineSiteName(String value)
	{
		this.isValidated = false;
		this.spinesitename = value;
	}
	public boolean getSpineSiteDetailsIsNotNull()
	{
		return this.spinesitedetails != null;
	}
	public String getSpineSiteDetails()
	{
		return this.spinesitedetails;
	}
	public static int getSpineSiteDetailsMaxLength()
	{
		return 4000;
	}
	public void setSpineSiteDetails(String value)
	{
		this.isValidated = false;
		this.spinesitedetails = value;
	}
	public boolean getSpineFindInterpretationIsNotNull()
	{
		return this.spinefindinterpretation != null;
	}
	public String getSpineFindInterpretation()
	{
		return this.spinefindinterpretation;
	}
	public static int getSpineFindInterpretationMaxLength()
	{
		return 500;
	}
	public void setSpineFindInterpretation(String value)
	{
		this.isValidated = false;
		this.spinefindinterpretation = value;
	}
	public boolean getIsProblemIsNotNull()
	{
		return this.isproblem != null;
	}
	public Boolean getIsProblem()
	{
		return this.isproblem;
	}
	public void setIsProblem(Boolean value)
	{
		this.isValidated = false;
		this.isproblem = value;
	}
	public boolean getFindingTypeIsNotNull()
	{
		return this.findingtype != null;
	}
	public ims.spinalinjuries.vo.lookups.SpineExaminationFinding getFindingType()
	{
		return this.findingtype;
	}
	public void setFindingType(ims.spinalinjuries.vo.lookups.SpineExaminationFinding value)
	{
		this.isValidated = false;
		this.findingtype = value;
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
		if(this.spinesitename != null)
			if(this.spinesitename.length() > 100)
				listOfErrors.add("The length of the field [spinesitename] in the value object [ims.generalmedical.vo.MskSpineExamFindingVo] is too big. It should be less or equal to 100");
		if(this.spinefindinterpretation != null)
			if(this.spinefindinterpretation.length() > 500)
				listOfErrors.add("The length of the field [spinefindinterpretation] in the value object [ims.generalmedical.vo.MskSpineExamFindingVo] is too big. It should be less or equal to 500");
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
	
		MskSpineExamFindingVo clone = new MskSpineExamFindingVo(this.id, this.version);
		
		clone.spinesitename = this.spinesitename;
		clone.spinesitedetails = this.spinesitedetails;
		clone.spinefindinterpretation = this.spinefindinterpretation;
		clone.isproblem = this.isproblem;
		if(this.findingtype == null)
			clone.findingtype = null;
		else
			clone.findingtype = (ims.spinalinjuries.vo.lookups.SpineExaminationFinding)this.findingtype.clone();
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
		if (!(MskSpineExamFindingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MskSpineExamFindingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MskSpineExamFindingVo compareObj = (MskSpineExamFindingVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_MskSpineExamFinding() == null && compareObj.getID_MskSpineExamFinding() != null)
				return -1;
			if(this.getID_MskSpineExamFinding() != null && compareObj.getID_MskSpineExamFinding() == null)
				return 1;
			if(this.getID_MskSpineExamFinding() != null && compareObj.getID_MskSpineExamFinding() != null)
				retVal = this.getID_MskSpineExamFinding().compareTo(compareObj.getID_MskSpineExamFinding());
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
		if(this.spinesitename != null)
			count++;
		if(this.spinesitedetails != null)
			count++;
		if(this.spinefindinterpretation != null)
			count++;
		if(this.isproblem != null)
			count++;
		if(this.findingtype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected String spinesitename;
	protected String spinesitedetails;
	protected String spinefindinterpretation;
	protected Boolean isproblem;
	protected ims.spinalinjuries.vo.lookups.SpineExaminationFinding findingtype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
