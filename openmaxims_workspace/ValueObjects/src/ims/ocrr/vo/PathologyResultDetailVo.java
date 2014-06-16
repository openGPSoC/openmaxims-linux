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
 * Linked to OCRR.OrderingResults.PathResultDetails business object (ID: 1070100003).
 */
public class PathologyResultDetailVo extends ims.ocrr.orderingresults.vo.PathResultDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PathologyResultDetailVo()
	{
	}
	public PathologyResultDetailVo(Integer id, int version)
	{
		super(id, version);
	}
	public PathologyResultDetailVo(ims.ocrr.vo.beans.PathologyResultDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.isabnormal = bean.getIsAbnormal();
		this.resultcomponents = ims.ocrr.vo.PathologyResultComponentVoCollection.buildFromBeanCollection(bean.getResultComponents());
		this.resultcomments = ims.ocrr.vo.ResultComponentCommentsVoCollection.buildFromBeanCollection(bean.getResultComments());
		this.orderspecimen = bean.getOrderSpecimen() == null ? null : bean.getOrderSpecimen().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.PathologyResultDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.isabnormal = bean.getIsAbnormal();
		this.resultcomponents = ims.ocrr.vo.PathologyResultComponentVoCollection.buildFromBeanCollection(bean.getResultComponents());
		this.resultcomments = ims.ocrr.vo.ResultComponentCommentsVoCollection.buildFromBeanCollection(bean.getResultComments());
		this.orderspecimen = bean.getOrderSpecimen() == null ? null : bean.getOrderSpecimen().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.PathologyResultDetailVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.PathologyResultDetailVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.PathologyResultDetailVoBean();
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
		if(fieldName.equals("ISABNORMAL"))
			return getIsAbnormal();
		if(fieldName.equals("RESULTCOMPONENTS"))
			return getResultComponents();
		if(fieldName.equals("RESULTCOMMENTS"))
			return getResultComments();
		if(fieldName.equals("ORDERSPECIMEN"))
			return getOrderSpecimen();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getIsAbnormalIsNotNull()
	{
		return this.isabnormal != null;
	}
	public Boolean getIsAbnormal()
	{
		return this.isabnormal;
	}
	public void setIsAbnormal(Boolean value)
	{
		this.isValidated = false;
		this.isabnormal = value;
	}
	public boolean getResultComponentsIsNotNull()
	{
		return this.resultcomponents != null;
	}
	public ims.ocrr.vo.PathologyResultComponentVoCollection getResultComponents()
	{
		return this.resultcomponents;
	}
	public void setResultComponents(ims.ocrr.vo.PathologyResultComponentVoCollection value)
	{
		this.isValidated = false;
		this.resultcomponents = value;
	}
	public boolean getResultCommentsIsNotNull()
	{
		return this.resultcomments != null;
	}
	public ims.ocrr.vo.ResultComponentCommentsVoCollection getResultComments()
	{
		return this.resultcomments;
	}
	public void setResultComments(ims.ocrr.vo.ResultComponentCommentsVoCollection value)
	{
		this.isValidated = false;
		this.resultcomments = value;
	}
	public boolean getOrderSpecimenIsNotNull()
	{
		return this.orderspecimen != null;
	}
	public ims.ocrr.vo.SpecimenNameVo getOrderSpecimen()
	{
		return this.orderspecimen;
	}
	public void setOrderSpecimen(ims.ocrr.vo.SpecimenNameVo value)
	{
		this.isValidated = false;
		this.orderspecimen = value;
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
		if(this.resultcomponents != null)
		{
			if(!this.resultcomponents.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.resultcomments != null)
		{
			if(!this.resultcomments.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.orderspecimen != null)
		{
			if(!this.orderspecimen.isValidated())
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
		if(this.isabnormal == null)
			listOfErrors.add("isAbnormal is mandatory");
		if(this.resultcomponents != null)
		{
			String[] listOfOtherErrors = this.resultcomponents.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.resultcomments != null)
		{
			String[] listOfOtherErrors = this.resultcomments.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.orderspecimen != null)
		{
			String[] listOfOtherErrors = this.orderspecimen.validate();
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
	
		PathologyResultDetailVo clone = new PathologyResultDetailVo(this.id, this.version);
		
		clone.isabnormal = this.isabnormal;
		if(this.resultcomponents == null)
			clone.resultcomponents = null;
		else
			clone.resultcomponents = (ims.ocrr.vo.PathologyResultComponentVoCollection)this.resultcomponents.clone();
		if(this.resultcomments == null)
			clone.resultcomments = null;
		else
			clone.resultcomments = (ims.ocrr.vo.ResultComponentCommentsVoCollection)this.resultcomments.clone();
		if(this.orderspecimen == null)
			clone.orderspecimen = null;
		else
			clone.orderspecimen = (ims.ocrr.vo.SpecimenNameVo)this.orderspecimen.clone();
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
		if (!(PathologyResultDetailVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PathologyResultDetailVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PathologyResultDetailVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PathologyResultDetailVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.isabnormal != null)
			count++;
		if(this.resultcomponents != null)
			count++;
		if(this.resultcomments != null)
			count++;
		if(this.orderspecimen != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected Boolean isabnormal;
	protected ims.ocrr.vo.PathologyResultComponentVoCollection resultcomponents;
	protected ims.ocrr.vo.ResultComponentCommentsVoCollection resultcomments;
	protected ims.ocrr.vo.SpecimenNameVo orderspecimen;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
