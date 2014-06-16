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

package ims.core.clinical.vo;

/**
 * Linked to core.clinical.SocialHistory business object (ID: 1003100026).
 */
public class SocialHistoryRefVo extends ims.vo.ValueObjectRef implements ims.domain.IDomainGetter
{
	private static final long serialVersionUID = 1L;

	public SocialHistoryRefVo()
	{
	}
	public SocialHistoryRefVo(Integer id, int version)
	{
		super(id, version);
	}
	public final boolean getID_SocialHistoryIsNotNull()
	{
		return this.id != null;
	}
	public final Integer getID_SocialHistory()
	{
		return this.id;
	}
	public final void setID_SocialHistory(Integer value)
	{
		this.id = value;
	}
	public final int getVersion_SocialHistory()
	{
		return this.version;
	}
	public Object clone()
	{
		return new SocialHistoryRefVo(this.id, this.version);
	}
	public final SocialHistoryRefVo toSocialHistoryRefVo()
	{
		if(this.id == null)
			return this;
		return new SocialHistoryRefVo(this.id, this.version);
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof SocialHistoryRefVo))
			return false;
		SocialHistoryRefVo compareObj = (SocialHistoryRefVo)obj;
		if(this.id != null && compareObj.getBoId() != null)
			return this.id.equals(compareObj.getBoId());
		if(this.id != null && compareObj.getBoId() == null)
			return false;
		if(this.id == null && compareObj.getBoId() != null)
			return false;
		return super.equals(obj);
	}
	public int hashCode()
	{
		if(this.id != null)
			return this.id.intValue();
		return super.hashCode();
	}
	public boolean isValidated()
	{
		return true;
	}
	public String[] validate()
	{
		return null;
	}
	public String getBoClassName()
	{
		return "ims.core.clinical.domain.objects.SocialHistory";
	}
	public Class getDomainClass()
	{
		return ims.core.clinical.domain.objects.SocialHistory.class;
	}
	public String getIItemText()
	{
		return toString();
	}
	public String toString()
	{
		return this.getClass().toString() + " (ID: " + (this.id == null ? "null" : this.id.toString()) + ")";
	}
	public int compareTo(Object obj)
	{
		if (obj == null)
			return -1;
		if (!(obj instanceof SocialHistoryRefVo))
			throw new ClassCastException("A SocialHistoryRefVo object cannot be compared an Object of type " + obj.getClass().getName());
		if (this.id == null)
			return 1;
		if (((SocialHistoryRefVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SocialHistoryRefVo)obj).getBoId());
	}
	// this method is not needed. It is here for compatibility purpose only.
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if(caseInsensitive); // this is to avoid Eclipse warning
		return compareTo(obj);
	}

	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("ID_SOCIALHISTORY"))
			return getID_SocialHistory();
		return super.getFieldValueByFieldName(fieldName);
	}
}
