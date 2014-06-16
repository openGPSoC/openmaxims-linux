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

package ims.hl7.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to hl7.HL7Outbound business object (ID: 1106100001).
 */
public class HL7OutboundSaveVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<HL7OutboundSaveVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<HL7OutboundSaveVo> col = new ArrayList<HL7OutboundSaveVo>();
	public String getBoClassName()
	{
		return "ims.hl7.domain.objects.HL7Outbound";
	}
	public boolean add(HL7OutboundSaveVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, HL7OutboundSaveVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			this.col.add(index, value);
			return true;
		}
		return false;
	}
	public void clear()
	{
		this.col.clear();
	}
	public void remove(int index)
	{
		this.col.remove(index);
	}
	public int size()
	{
		return this.col.size();
	}
	public int indexOf(HL7OutboundSaveVo instance)
	{
		return col.indexOf(instance);
	}
	public HL7OutboundSaveVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, HL7OutboundSaveVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(HL7OutboundSaveVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(HL7OutboundSaveVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		HL7OutboundSaveVoCollection clone = new HL7OutboundSaveVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((HL7OutboundSaveVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		
		return clone;
	}
	public boolean isValidated()
	{
		for(int x = 0; x < col.size(); x++)
			if(!this.col.get(x).isValidated())
				return false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(col.size() == 0)
			return null;
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		for(int x = 0; x < col.size(); x++)
		{
			String[] listOfOtherErrors = this.col.get(x).validate();
			if(listOfOtherErrors != null)
			{
				for(int y = 0; y < listOfOtherErrors.length; y++)
				{
					listOfErrors.add(listOfOtherErrors[y]);
				}
			}
		}
		
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
			return null;
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		return result;
	}
	public HL7OutboundSaveVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public HL7OutboundSaveVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public HL7OutboundSaveVoCollection sort(SortOrder order)
	{
		return sort(new HL7OutboundSaveVoComparator(order));
	}
	public HL7OutboundSaveVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new HL7OutboundSaveVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public HL7OutboundSaveVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.hl7.vo.HL7OutboundRefVoCollection toRefVoCollection()
	{
		ims.hl7.vo.HL7OutboundRefVoCollection result = new ims.hl7.vo.HL7OutboundRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public HL7OutboundSaveVo[] toArray()
	{
		HL7OutboundSaveVo[] arr = new HL7OutboundSaveVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<HL7OutboundSaveVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class HL7OutboundSaveVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public HL7OutboundSaveVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public HL7OutboundSaveVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public HL7OutboundSaveVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			HL7OutboundSaveVo voObj1 = (HL7OutboundSaveVo)obj1;
			HL7OutboundSaveVo voObj2 = (HL7OutboundSaveVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.hl7.vo.beans.HL7OutboundSaveVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.hl7.vo.beans.HL7OutboundSaveVoBean[] getBeanCollectionArray()
	{
		ims.hl7.vo.beans.HL7OutboundSaveVoBean[] result = new ims.hl7.vo.beans.HL7OutboundSaveVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			HL7OutboundSaveVo vo = ((HL7OutboundSaveVo)col.get(i));
			result[i] = (ims.hl7.vo.beans.HL7OutboundSaveVoBean)vo.getBean();
		}
		return result;
	}
	public static HL7OutboundSaveVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		HL7OutboundSaveVoCollection coll = new HL7OutboundSaveVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.hl7.vo.beans.HL7OutboundSaveVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static HL7OutboundSaveVoCollection buildFromBeanCollection(ims.hl7.vo.beans.HL7OutboundSaveVoBean[] beans)
	{
		HL7OutboundSaveVoCollection coll = new HL7OutboundSaveVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
