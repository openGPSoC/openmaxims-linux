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

package ims.pathways.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to Pathways.Configuration.EventTarget business object (ID: 1089100006).
 */
public class EventTargetVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<EventTargetVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<EventTargetVo> col = new ArrayList<EventTargetVo>();
	public String getBoClassName()
	{
		return "ims.pathways.configuration.domain.objects.EventTarget";
	}
	public boolean add(EventTargetVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, EventTargetVo value)
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
	public int indexOf(EventTargetVo instance)
	{
		return col.indexOf(instance);
	}
	public EventTargetVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, EventTargetVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(EventTargetVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(EventTargetVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		EventTargetVoCollection clone = new EventTargetVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((EventTargetVo)this.col.get(x).clone());
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
	public EventTargetVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public EventTargetVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public EventTargetVoCollection sort(SortOrder order)
	{
		return sort(new EventTargetVoComparator(order));
	}
	public EventTargetVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new EventTargetVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public EventTargetVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.pathways.configuration.vo.EventTargetRefVoCollection toRefVoCollection()
	{
		ims.pathways.configuration.vo.EventTargetRefVoCollection result = new ims.pathways.configuration.vo.EventTargetRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public EventTargetVo[] toArray()
	{
		EventTargetVo[] arr = new EventTargetVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ims.framework.interfaces.IRecordStatusTree[] toIRecordStatusTreeArray()
	{
		ims.framework.interfaces.IRecordStatusTree[] arr = new ims.framework.interfaces.IRecordStatusTree[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<EventTargetVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class EventTargetVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public EventTargetVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public EventTargetVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public EventTargetVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			EventTargetVo voObj1 = (EventTargetVo)obj1;
			EventTargetVo voObj2 = (EventTargetVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.pathways.vo.beans.EventTargetVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.pathways.vo.beans.EventTargetVoBean[] getBeanCollectionArray()
	{
		ims.pathways.vo.beans.EventTargetVoBean[] result = new ims.pathways.vo.beans.EventTargetVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			EventTargetVo vo = ((EventTargetVo)col.get(i));
			result[i] = (ims.pathways.vo.beans.EventTargetVoBean)vo.getBean();
		}
		return result;
	}
	public static EventTargetVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		EventTargetVoCollection coll = new EventTargetVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.pathways.vo.beans.EventTargetVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static EventTargetVoCollection buildFromBeanCollection(ims.pathways.vo.beans.EventTargetVoBean[] beans)
	{
		EventTargetVoCollection coll = new EventTargetVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
