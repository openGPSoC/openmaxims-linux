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
 * Linked to coe.assessment.Bowel Constipation business object (ID: 1012100017).
 */
public class ConstipationVo extends ims.coe.assessment.vo.BowelConstipationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ConstipationVo()
	{
	}
	public ConstipationVo(Integer id, int version)
	{
		super(id, version);
	}
	public ConstipationVo(ims.nursing.vo.beans.ConstipationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pronetoconstipation = bean.getProneToConstipation() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getProneToConstipation());
		this.stainingoffaeces = bean.getStainingOfFaeces() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getStainingOfFaeces());
		this.leakageoffaecesatpresent = bean.getLeakageOfFaecesAtPresent() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getLeakageOfFaecesAtPresent());
		this.leakageoffaecespast = bean.getLeakageOfFaecesPast() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getLeakageOfFaecesPast());
		this.howlongago = bean.getHowLongAgo();
		this.takinglaxatives = bean.getTakingLaxatives() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getTakingLaxatives());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.ConstipationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pronetoconstipation = bean.getProneToConstipation() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getProneToConstipation());
		this.stainingoffaeces = bean.getStainingOfFaeces() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getStainingOfFaeces());
		this.leakageoffaecesatpresent = bean.getLeakageOfFaecesAtPresent() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getLeakageOfFaecesAtPresent());
		this.leakageoffaecespast = bean.getLeakageOfFaecesPast() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getLeakageOfFaecesPast());
		this.howlongago = bean.getHowLongAgo();
		this.takinglaxatives = bean.getTakingLaxatives() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getTakingLaxatives());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.ConstipationVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.ConstipationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.ConstipationVoBean();
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
		if(fieldName.equals("PRONETOCONSTIPATION"))
			return getProneToConstipation();
		if(fieldName.equals("STAININGOFFAECES"))
			return getStainingOfFaeces();
		if(fieldName.equals("LEAKAGEOFFAECESATPRESENT"))
			return getLeakageOfFaecesAtPresent();
		if(fieldName.equals("LEAKAGEOFFAECESPAST"))
			return getLeakageOfFaecesPast();
		if(fieldName.equals("HOWLONGAGO"))
			return getHowLongAgo();
		if(fieldName.equals("TAKINGLAXATIVES"))
			return getTakingLaxatives();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getProneToConstipationIsNotNull()
	{
		return this.pronetoconstipation != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getProneToConstipation()
	{
		return this.pronetoconstipation;
	}
	public void setProneToConstipation(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.pronetoconstipation = value;
	}
	public boolean getStainingOfFaecesIsNotNull()
	{
		return this.stainingoffaeces != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getStainingOfFaeces()
	{
		return this.stainingoffaeces;
	}
	public void setStainingOfFaeces(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.stainingoffaeces = value;
	}
	public boolean getLeakageOfFaecesAtPresentIsNotNull()
	{
		return this.leakageoffaecesatpresent != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getLeakageOfFaecesAtPresent()
	{
		return this.leakageoffaecesatpresent;
	}
	public void setLeakageOfFaecesAtPresent(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.leakageoffaecesatpresent = value;
	}
	public boolean getLeakageOfFaecesPastIsNotNull()
	{
		return this.leakageoffaecespast != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getLeakageOfFaecesPast()
	{
		return this.leakageoffaecespast;
	}
	public void setLeakageOfFaecesPast(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.leakageoffaecespast = value;
	}
	public boolean getHowLongAgoIsNotNull()
	{
		return this.howlongago != null;
	}
	public String getHowLongAgo()
	{
		return this.howlongago;
	}
	public static int getHowLongAgoMaxLength()
	{
		return 255;
	}
	public void setHowLongAgo(String value)
	{
		this.isValidated = false;
		this.howlongago = value;
	}
	public boolean getTakingLaxativesIsNotNull()
	{
		return this.takinglaxatives != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getTakingLaxatives()
	{
		return this.takinglaxatives;
	}
	public void setTakingLaxatives(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.takinglaxatives = value;
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
	
		ConstipationVo clone = new ConstipationVo(this.id, this.version);
		
		if(this.pronetoconstipation == null)
			clone.pronetoconstipation = null;
		else
			clone.pronetoconstipation = (ims.core.vo.lookups.YesNoUnknown)this.pronetoconstipation.clone();
		if(this.stainingoffaeces == null)
			clone.stainingoffaeces = null;
		else
			clone.stainingoffaeces = (ims.core.vo.lookups.YesNoUnknown)this.stainingoffaeces.clone();
		if(this.leakageoffaecesatpresent == null)
			clone.leakageoffaecesatpresent = null;
		else
			clone.leakageoffaecesatpresent = (ims.core.vo.lookups.YesNoUnknown)this.leakageoffaecesatpresent.clone();
		if(this.leakageoffaecespast == null)
			clone.leakageoffaecespast = null;
		else
			clone.leakageoffaecespast = (ims.core.vo.lookups.YesNoUnknown)this.leakageoffaecespast.clone();
		clone.howlongago = this.howlongago;
		if(this.takinglaxatives == null)
			clone.takinglaxatives = null;
		else
			clone.takinglaxatives = (ims.core.vo.lookups.YesNoUnknown)this.takinglaxatives.clone();
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
		if (!(ConstipationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ConstipationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ConstipationVo compareObj = (ConstipationVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_BowelConstipation() == null && compareObj.getID_BowelConstipation() != null)
				return -1;
			if(this.getID_BowelConstipation() != null && compareObj.getID_BowelConstipation() == null)
				return 1;
			if(this.getID_BowelConstipation() != null && compareObj.getID_BowelConstipation() != null)
				retVal = this.getID_BowelConstipation().compareTo(compareObj.getID_BowelConstipation());
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
		if(this.pronetoconstipation != null)
			count++;
		if(this.stainingoffaeces != null)
			count++;
		if(this.leakageoffaecesatpresent != null)
			count++;
		if(this.leakageoffaecespast != null)
			count++;
		if(this.howlongago != null)
			count++;
		if(this.takinglaxatives != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.vo.lookups.YesNoUnknown pronetoconstipation;
	protected ims.core.vo.lookups.YesNoUnknown stainingoffaeces;
	protected ims.core.vo.lookups.YesNoUnknown leakageoffaecesatpresent;
	protected ims.core.vo.lookups.YesNoUnknown leakageoffaecespast;
	protected String howlongago;
	protected ims.core.vo.lookups.YesNoUnknown takinglaxatives;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
