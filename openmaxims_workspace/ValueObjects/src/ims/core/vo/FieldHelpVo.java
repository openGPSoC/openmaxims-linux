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

package ims.core.vo;

/**
 * Linked to core.admin.FieldHelpText business object (ID: 1004100039).
 */
public class FieldHelpVo extends ims.core.admin.vo.FieldHelpTextRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public FieldHelpVo()
	{
	}
	public FieldHelpVo(Integer id, int version)
	{
		super(id, version);
	}
	public FieldHelpVo(ims.core.vo.beans.FieldHelpVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.field = bean.getField() == null ? null : ims.clinicaladmin.vo.lookups.EDischargeHINT.buildLookup(bean.getField());
		this.helptext = bean.getHelpText();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.FieldHelpVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.field = bean.getField() == null ? null : ims.clinicaladmin.vo.lookups.EDischargeHINT.buildLookup(bean.getField());
		this.helptext = bean.getHelpText();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.FieldHelpVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.FieldHelpVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.FieldHelpVoBean();
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
		if(fieldName.equals("FIELD"))
			return getField();
		if(fieldName.equals("HELPTEXT"))
			return getHelpText();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getFieldIsNotNull()
	{
		return this.field != null;
	}
	public ims.clinicaladmin.vo.lookups.EDischargeHINT getField()
	{
		return this.field;
	}
	public void setField(ims.clinicaladmin.vo.lookups.EDischargeHINT value)
	{
		this.isValidated = false;
		this.field = value;
	}
	public boolean getHelpTextIsNotNull()
	{
		return this.helptext != null;
	}
	public String getHelpText()
	{
		return this.helptext;
	}
	public static int getHelpTextMaxLength()
	{
		return 3500;
	}
	public void setHelpText(String value)
	{
		this.isValidated = false;
		this.helptext = value;
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
		if(this.field == null)
			listOfErrors.add("Field is mandatory");
		if(this.helptext == null || this.helptext.length() == 0)
			listOfErrors.add("HelpText is mandatory");
		else if(this.helptext.length() > 3500)
			listOfErrors.add("The length of the field [helptext] in the value object [ims.core.vo.FieldHelpVo] is too big. It should be less or equal to 3500");
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
	
		FieldHelpVo clone = new FieldHelpVo(this.id, this.version);
		
		if(this.field == null)
			clone.field = null;
		else
			clone.field = (ims.clinicaladmin.vo.lookups.EDischargeHINT)this.field.clone();
		clone.helptext = this.helptext;
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
		if (!(FieldHelpVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A FieldHelpVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((FieldHelpVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((FieldHelpVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.field != null)
			count++;
		if(this.helptext != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.clinicaladmin.vo.lookups.EDischargeHINT field;
	protected String helptext;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
