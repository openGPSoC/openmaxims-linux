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

package ims.therapies.vo;

/**
 * Linked to therapies.treatment.StretchingDetails business object (ID: 1044100001).
 */
public class StretchingDetailsVo extends ims.therapies.treatment.vo.StretchingDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public StretchingDetailsVo()
	{
	}
	public StretchingDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public StretchingDetailsVo(ims.therapies.vo.beans.StretchingDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.stretchingarea = bean.getStretchingArea() == null ? null : ims.therapies.vo.lookups.StretchingArea.buildLookup(bean.getStretchingArea());
		this.active = bean.getActive();
		this.passive = bean.getPassive();
		this.comment = bean.getComment();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.StretchingDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.stretchingarea = bean.getStretchingArea() == null ? null : ims.therapies.vo.lookups.StretchingArea.buildLookup(bean.getStretchingArea());
		this.active = bean.getActive();
		this.passive = bean.getPassive();
		this.comment = bean.getComment();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.StretchingDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.StretchingDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.StretchingDetailsVoBean();
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
		if(fieldName.equals("STRETCHINGAREA"))
			return getStretchingArea();
		if(fieldName.equals("ACTIVE"))
			return getActive();
		if(fieldName.equals("PASSIVE"))
			return getPassive();
		if(fieldName.equals("COMMENT"))
			return getComment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStretchingAreaIsNotNull()
	{
		return this.stretchingarea != null;
	}
	public ims.therapies.vo.lookups.StretchingArea getStretchingArea()
	{
		return this.stretchingarea;
	}
	public void setStretchingArea(ims.therapies.vo.lookups.StretchingArea value)
	{
		this.isValidated = false;
		this.stretchingarea = value;
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
	public boolean getPassiveIsNotNull()
	{
		return this.passive != null;
	}
	public Boolean getPassive()
	{
		return this.passive;
	}
	public void setPassive(Boolean value)
	{
		this.isValidated = false;
		this.passive = value;
	}
	public boolean getCommentIsNotNull()
	{
		return this.comment != null;
	}
	public String getComment()
	{
		return this.comment;
	}
	public static int getCommentMaxLength()
	{
		return 255;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
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
		if(this.stretchingarea == null)
			listOfErrors.add("StretchingArea is mandatory");
		if(this.comment != null)
			if(this.comment.length() > 255)
				listOfErrors.add("The length of the field [comment] in the value object [ims.therapies.vo.StretchingDetailsVo] is too big. It should be less or equal to 255");
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
	
		StretchingDetailsVo clone = new StretchingDetailsVo(this.id, this.version);
		
		if(this.stretchingarea == null)
			clone.stretchingarea = null;
		else
			clone.stretchingarea = (ims.therapies.vo.lookups.StretchingArea)this.stretchingarea.clone();
		clone.active = this.active;
		clone.passive = this.passive;
		clone.comment = this.comment;
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
		if (!(StretchingDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A StretchingDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		StretchingDetailsVo compareObj = (StretchingDetailsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_StretchingDetails() == null && compareObj.getID_StretchingDetails() != null)
				return -1;
			if(this.getID_StretchingDetails() != null && compareObj.getID_StretchingDetails() == null)
				return 1;
			if(this.getID_StretchingDetails() != null && compareObj.getID_StretchingDetails() != null)
				retVal = this.getID_StretchingDetails().compareTo(compareObj.getID_StretchingDetails());
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
		if(this.stretchingarea != null)
			count++;
		if(this.active != null)
			count++;
		if(this.passive != null)
			count++;
		if(this.comment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.therapies.vo.lookups.StretchingArea stretchingarea;
	protected Boolean active;
	protected Boolean passive;
	protected String comment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
