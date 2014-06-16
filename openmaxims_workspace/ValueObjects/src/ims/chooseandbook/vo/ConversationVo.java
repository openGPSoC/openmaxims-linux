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

package ims.chooseandbook.vo;

/**
 * Linked to choose_book.Conversation business object (ID: 1069100004).
 */
public class ConversationVo extends ims.choose_book.vo.ConversationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ConversationVo()
	{
	}
	public ConversationVo(Integer id, int version)
	{
		super(id, version);
	}
	public ConversationVo(ims.chooseandbook.vo.beans.ConversationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.cid = bean.getCid() == null ? null : bean.getCid().buildVo();
		this.current = bean.getCurrent() == null ? null : bean.getCurrent().buildVo();
		this.points = ims.chooseandbook.vo.ConvPointVoCollection.buildFromBeanCollection(bean.getPoints());
		this.msguids = ims.chooseandbook.vo.ConvUidVoCollection.buildFromBeanCollection(bean.getMsgUids());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.chooseandbook.vo.beans.ConversationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.cid = bean.getCid() == null ? null : bean.getCid().buildVo(map);
		this.current = bean.getCurrent() == null ? null : bean.getCurrent().buildVo(map);
		this.points = ims.chooseandbook.vo.ConvPointVoCollection.buildFromBeanCollection(bean.getPoints());
		this.msguids = ims.chooseandbook.vo.ConvUidVoCollection.buildFromBeanCollection(bean.getMsgUids());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.chooseandbook.vo.beans.ConversationVoBean bean = null;
		if(map != null)
			bean = (ims.chooseandbook.vo.beans.ConversationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.chooseandbook.vo.beans.ConversationVoBean();
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
		if(fieldName.equals("CID"))
			return getCid();
		if(fieldName.equals("CURRENT"))
			return getCurrent();
		if(fieldName.equals("POINTS"))
			return getPoints();
		if(fieldName.equals("MSGUIDS"))
			return getMsgUids();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCidIsNotNull()
	{
		return this.cid != null;
	}
	public ims.chooseandbook.vo.ConvIdVo getCid()
	{
		return this.cid;
	}
	public void setCid(ims.chooseandbook.vo.ConvIdVo value)
	{
		this.isValidated = false;
		this.cid = value;
	}
	public boolean getCurrentIsNotNull()
	{
		return this.current != null;
	}
	public ims.chooseandbook.vo.SeqPointVo getCurrent()
	{
		return this.current;
	}
	public void setCurrent(ims.chooseandbook.vo.SeqPointVo value)
	{
		this.isValidated = false;
		this.current = value;
	}
	public boolean getPointsIsNotNull()
	{
		return this.points != null;
	}
	public ims.chooseandbook.vo.ConvPointVoCollection getPoints()
	{
		return this.points;
	}
	public void setPoints(ims.chooseandbook.vo.ConvPointVoCollection value)
	{
		this.isValidated = false;
		this.points = value;
	}
	public boolean getMsgUidsIsNotNull()
	{
		return this.msguids != null;
	}
	public ims.chooseandbook.vo.ConvUidVoCollection getMsgUids()
	{
		return this.msguids;
	}
	public void setMsgUids(ims.chooseandbook.vo.ConvUidVoCollection value)
	{
		this.isValidated = false;
		this.msguids = value;
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
		if(this.cid != null)
		{
			if(!this.cid.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.points != null)
		{
			if(!this.points.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.msguids != null)
		{
			if(!this.msguids.isValidated())
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
		if(this.cid == null)
			listOfErrors.add("cid is mandatory");
		if(this.cid != null)
		{
			String[] listOfOtherErrors = this.cid.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.points != null)
		{
			String[] listOfOtherErrors = this.points.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.msguids != null)
		{
			String[] listOfOtherErrors = this.msguids.validate();
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
	
		ConversationVo clone = new ConversationVo(this.id, this.version);
		
		if(this.cid == null)
			clone.cid = null;
		else
			clone.cid = (ims.chooseandbook.vo.ConvIdVo)this.cid.clone();
		if(this.current == null)
			clone.current = null;
		else
			clone.current = (ims.chooseandbook.vo.SeqPointVo)this.current.clone();
		if(this.points == null)
			clone.points = null;
		else
			clone.points = (ims.chooseandbook.vo.ConvPointVoCollection)this.points.clone();
		if(this.msguids == null)
			clone.msguids = null;
		else
			clone.msguids = (ims.chooseandbook.vo.ConvUidVoCollection)this.msguids.clone();
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
		if (!(ConversationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ConversationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ConversationVo compareObj = (ConversationVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_Conversation() == null && compareObj.getID_Conversation() != null)
				return -1;
			if(this.getID_Conversation() != null && compareObj.getID_Conversation() == null)
				return 1;
			if(this.getID_Conversation() != null && compareObj.getID_Conversation() != null)
				retVal = this.getID_Conversation().compareTo(compareObj.getID_Conversation());
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
		if(this.cid != null)
			count++;
		if(this.current != null)
			count++;
		if(this.points != null)
			count++;
		if(this.msguids != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.chooseandbook.vo.ConvIdVo cid;
	protected ims.chooseandbook.vo.SeqPointVo current;
	protected ims.chooseandbook.vo.ConvPointVoCollection points;
	protected ims.chooseandbook.vo.ConvUidVoCollection msguids;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
