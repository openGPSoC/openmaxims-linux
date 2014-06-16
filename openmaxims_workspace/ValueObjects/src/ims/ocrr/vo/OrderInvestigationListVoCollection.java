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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to OCRR.OrderingResults.OrderInvestigation business object (ID: 1070100002).
 */
public class OrderInvestigationListVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<OrderInvestigationListVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<OrderInvestigationListVo> col = new ArrayList<OrderInvestigationListVo>();
	public String getBoClassName()
	{
		return "ims.ocrr.orderingresults.domain.objects.OrderInvestigation";
	}
	public boolean add(OrderInvestigationListVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, OrderInvestigationListVo value)
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
	public int indexOf(OrderInvestigationListVo instance)
	{
		return col.indexOf(instance);
	}
	public OrderInvestigationListVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, OrderInvestigationListVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(OrderInvestigationListVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(OrderInvestigationListVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		OrderInvestigationListVoCollection clone = new OrderInvestigationListVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((OrderInvestigationListVo)this.col.get(x).clone());
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
	public OrderInvestigationListVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public OrderInvestigationListVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public OrderInvestigationListVoCollection sort(SortOrder order)
	{
		return sort(new OrderInvestigationListVoComparator(order));
	}
	public OrderInvestigationListVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new OrderInvestigationListVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public OrderInvestigationListVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.ocrr.orderingresults.vo.OrderInvestigationRefVoCollection toRefVoCollection()
	{
		ims.ocrr.orderingresults.vo.OrderInvestigationRefVoCollection result = new ims.ocrr.orderingresults.vo.OrderInvestigationRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public OrderInvestigationListVo[] toArray()
	{
		OrderInvestigationListVo[] arr = new OrderInvestigationListVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ims.vo.interfaces.IGenericItemType[] toIGenericItemTypeArray()
	{
		ims.vo.interfaces.IGenericItemType[] arr = new ims.vo.interfaces.IGenericItemType[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<OrderInvestigationListVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class OrderInvestigationListVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public OrderInvestigationListVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public OrderInvestigationListVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public OrderInvestigationListVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			OrderInvestigationListVo voObj1 = (OrderInvestigationListVo)obj1;
			OrderInvestigationListVo voObj2 = (OrderInvestigationListVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.ocrr.vo.beans.OrderInvestigationListVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.ocrr.vo.beans.OrderInvestigationListVoBean[] getBeanCollectionArray()
	{
		ims.ocrr.vo.beans.OrderInvestigationListVoBean[] result = new ims.ocrr.vo.beans.OrderInvestigationListVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			OrderInvestigationListVo vo = ((OrderInvestigationListVo)col.get(i));
			result[i] = (ims.ocrr.vo.beans.OrderInvestigationListVoBean)vo.getBean();
		}
		return result;
	}
	public static OrderInvestigationListVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		OrderInvestigationListVoCollection coll = new OrderInvestigationListVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.ocrr.vo.beans.OrderInvestigationListVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static OrderInvestigationListVoCollection buildFromBeanCollection(ims.ocrr.vo.beans.OrderInvestigationListVoBean[] beans)
	{
		OrderInvestigationListVoCollection coll = new OrderInvestigationListVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
