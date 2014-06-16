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

package ims.ocrr.vo;

/**
 * Linked to OCRR.Configuration.Specimen business object (ID: 1061100026).
 */
public class SpecimenVo extends ims.ocrr.configuration.vo.SpecimenRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SpecimenVo()
	{
	}
	public SpecimenVo(Integer id, int version)
	{
		super(id, version);
	}
	public SpecimenVo(ims.ocrr.vo.beans.SpecimenVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.type = bean.getType() == null ? null : ims.ocrr.vo.lookups.SpecimenType.buildLookup(bean.getType());
		this.adultcontainers = ims.ocrr.vo.SpecimenContainerVoCollection.buildFromBeanCollection(bean.getAdultContainers());
		this.paediatriccontainers = ims.ocrr.vo.SpecimenContainerVoCollection.buildFromBeanCollection(bean.getPaediatricContainers());
		this.alternativepaediatriccontainers = ims.ocrr.vo.SpecimenContainerVoCollection.buildFromBeanCollection(bean.getAlternativePaediatricContainers());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.SpecimenVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.type = bean.getType() == null ? null : ims.ocrr.vo.lookups.SpecimenType.buildLookup(bean.getType());
		this.adultcontainers = ims.ocrr.vo.SpecimenContainerVoCollection.buildFromBeanCollection(bean.getAdultContainers());
		this.paediatriccontainers = ims.ocrr.vo.SpecimenContainerVoCollection.buildFromBeanCollection(bean.getPaediatricContainers());
		this.alternativepaediatriccontainers = ims.ocrr.vo.SpecimenContainerVoCollection.buildFromBeanCollection(bean.getAlternativePaediatricContainers());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.SpecimenVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.SpecimenVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.SpecimenVoBean();
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
		if(fieldName.equals("TYPE"))
			return getType();
		if(fieldName.equals("ADULTCONTAINERS"))
			return getAdultContainers();
		if(fieldName.equals("PAEDIATRICCONTAINERS"))
			return getPaediatricContainers();
		if(fieldName.equals("ALTERNATIVEPAEDIATRICCONTAINERS"))
			return getAlternativePaediatricContainers();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTypeIsNotNull()
	{
		return this.type != null;
	}
	public ims.ocrr.vo.lookups.SpecimenType getType()
	{
		return this.type;
	}
	public void setType(ims.ocrr.vo.lookups.SpecimenType value)
	{
		this.isValidated = false;
		this.type = value;
	}
	public boolean getAdultContainersIsNotNull()
	{
		return this.adultcontainers != null;
	}
	public ims.ocrr.vo.SpecimenContainerVoCollection getAdultContainers()
	{
		return this.adultcontainers;
	}
	public void setAdultContainers(ims.ocrr.vo.SpecimenContainerVoCollection value)
	{
		this.isValidated = false;
		this.adultcontainers = value;
	}
	public boolean getPaediatricContainersIsNotNull()
	{
		return this.paediatriccontainers != null;
	}
	public ims.ocrr.vo.SpecimenContainerVoCollection getPaediatricContainers()
	{
		return this.paediatriccontainers;
	}
	public void setPaediatricContainers(ims.ocrr.vo.SpecimenContainerVoCollection value)
	{
		this.isValidated = false;
		this.paediatriccontainers = value;
	}
	public boolean getAlternativePaediatricContainersIsNotNull()
	{
		return this.alternativepaediatriccontainers != null;
	}
	public ims.ocrr.vo.SpecimenContainerVoCollection getAlternativePaediatricContainers()
	{
		return this.alternativepaediatriccontainers;
	}
	public void setAlternativePaediatricContainers(ims.ocrr.vo.SpecimenContainerVoCollection value)
	{
		this.isValidated = false;
		this.alternativepaediatriccontainers = value;
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
		if(this.adultcontainers != null)
		{
			if(!this.adultcontainers.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.paediatriccontainers != null)
		{
			if(!this.paediatriccontainers.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.alternativepaediatriccontainers != null)
		{
			if(!this.alternativepaediatriccontainers.isValidated())
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
		if(this.type == null)
			listOfErrors.add("Specimen Type is mandatory");
		if(this.adultcontainers != null)
		{
			String[] listOfOtherErrors = this.adultcontainers.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.paediatriccontainers != null)
		{
			String[] listOfOtherErrors = this.paediatriccontainers.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.alternativepaediatriccontainers != null)
		{
			String[] listOfOtherErrors = this.alternativepaediatriccontainers.validate();
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
	
		SpecimenVo clone = new SpecimenVo(this.id, this.version);
		
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.ocrr.vo.lookups.SpecimenType)this.type.clone();
		if(this.adultcontainers == null)
			clone.adultcontainers = null;
		else
			clone.adultcontainers = (ims.ocrr.vo.SpecimenContainerVoCollection)this.adultcontainers.clone();
		if(this.paediatriccontainers == null)
			clone.paediatriccontainers = null;
		else
			clone.paediatriccontainers = (ims.ocrr.vo.SpecimenContainerVoCollection)this.paediatriccontainers.clone();
		if(this.alternativepaediatriccontainers == null)
			clone.alternativepaediatriccontainers = null;
		else
			clone.alternativepaediatriccontainers = (ims.ocrr.vo.SpecimenContainerVoCollection)this.alternativepaediatriccontainers.clone();
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
		if (!(SpecimenVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SpecimenVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SpecimenVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SpecimenVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.type != null)
			count++;
		if(this.adultcontainers != null)
			count++;
		if(this.paediatriccontainers != null)
			count++;
		if(this.alternativepaediatriccontainers != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.ocrr.vo.lookups.SpecimenType type;
	protected ims.ocrr.vo.SpecimenContainerVoCollection adultcontainers;
	protected ims.ocrr.vo.SpecimenContainerVoCollection paediatriccontainers;
	protected ims.ocrr.vo.SpecimenContainerVoCollection alternativepaediatriccontainers;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
