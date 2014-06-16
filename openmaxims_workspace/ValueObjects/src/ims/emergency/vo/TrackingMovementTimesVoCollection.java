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

package ims.emergency.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to emergency.TrackingMovementTimes business object (ID: 1086100009).
 */
public class TrackingMovementTimesVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<TrackingMovementTimesVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<TrackingMovementTimesVo> col = new ArrayList<TrackingMovementTimesVo>();
	public String getBoClassName()
	{
		return "ims.emergency.domain.objects.TrackingMovementTimes";
	}
	public boolean add(TrackingMovementTimesVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, TrackingMovementTimesVo value)
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
	public int indexOf(TrackingMovementTimesVo instance)
	{
		return col.indexOf(instance);
	}
	public TrackingMovementTimesVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, TrackingMovementTimesVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(TrackingMovementTimesVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(TrackingMovementTimesVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		TrackingMovementTimesVoCollection clone = new TrackingMovementTimesVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((TrackingMovementTimesVo)this.col.get(x).clone());
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
	public TrackingMovementTimesVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public TrackingMovementTimesVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public TrackingMovementTimesVoCollection sort(SortOrder order)
	{
		return sort(new TrackingMovementTimesVoComparator(order));
	}
	public TrackingMovementTimesVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new TrackingMovementTimesVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public TrackingMovementTimesVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.emergency.vo.TrackingMovementTimesRefVoCollection toRefVoCollection()
	{
		ims.emergency.vo.TrackingMovementTimesRefVoCollection result = new ims.emergency.vo.TrackingMovementTimesRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public TrackingMovementTimesVo[] toArray()
	{
		TrackingMovementTimesVo[] arr = new TrackingMovementTimesVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<TrackingMovementTimesVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class TrackingMovementTimesVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public TrackingMovementTimesVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public TrackingMovementTimesVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public TrackingMovementTimesVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			TrackingMovementTimesVo voObj1 = (TrackingMovementTimesVo)obj1;
			TrackingMovementTimesVo voObj2 = (TrackingMovementTimesVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.emergency.vo.beans.TrackingMovementTimesVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.emergency.vo.beans.TrackingMovementTimesVoBean[] getBeanCollectionArray()
	{
		ims.emergency.vo.beans.TrackingMovementTimesVoBean[] result = new ims.emergency.vo.beans.TrackingMovementTimesVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			TrackingMovementTimesVo vo = ((TrackingMovementTimesVo)col.get(i));
			result[i] = (ims.emergency.vo.beans.TrackingMovementTimesVoBean)vo.getBean();
		}
		return result;
	}
	public static TrackingMovementTimesVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		TrackingMovementTimesVoCollection coll = new TrackingMovementTimesVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.emergency.vo.beans.TrackingMovementTimesVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static TrackingMovementTimesVoCollection buildFromBeanCollection(ims.emergency.vo.beans.TrackingMovementTimesVoBean[] beans)
	{
		TrackingMovementTimesVoCollection coll = new TrackingMovementTimesVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
