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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;


public class IfLookupVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<IfLookupVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<IfLookupVo> col = new ArrayList<IfLookupVo>();
	public String getBoClassName()
	{
		return null;
	}
	public boolean add(IfLookupVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, IfLookupVo value)
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
	public int indexOf(IfLookupVo instance)
	{
		return col.indexOf(instance);
	}
	public IfLookupVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, IfLookupVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(IfLookupVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(IfLookupVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		IfLookupVoCollection clone = new IfLookupVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((IfLookupVo)this.col.get(x).clone());
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
	public IfLookupVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public IfLookupVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public IfLookupVoCollection sort(SortOrder order)
	{
		return sort(new IfLookupVoComparator(order));
	}
	public IfLookupVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new IfLookupVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public IfLookupVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public IfLookupVo[] toArray()
	{
		IfLookupVo[] arr = new IfLookupVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<IfLookupVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class IfLookupVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public IfLookupVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public IfLookupVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public IfLookupVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			IfLookupVo voObj1 = (IfLookupVo)obj1;
			IfLookupVo voObj2 = (IfLookupVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.core.vo.beans.IfLookupVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.core.vo.beans.IfLookupVoBean[] getBeanCollectionArray()
	{
		ims.core.vo.beans.IfLookupVoBean[] result = new ims.core.vo.beans.IfLookupVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			IfLookupVo vo = ((IfLookupVo)col.get(i));
			result[i] = (ims.core.vo.beans.IfLookupVoBean)vo.getBean();
		}
		return result;
	}
	public static IfLookupVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		IfLookupVoCollection coll = new IfLookupVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.core.vo.beans.IfLookupVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static IfLookupVoCollection buildFromBeanCollection(ims.core.vo.beans.IfLookupVoBean[] beans)
	{
		IfLookupVoCollection coll = new IfLookupVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
