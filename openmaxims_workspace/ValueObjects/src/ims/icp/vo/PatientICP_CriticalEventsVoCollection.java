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

package ims.icp.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to ICPs.Instantiation.PatientICP business object (ID: 1100100000).
 */
public class PatientICP_CriticalEventsVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<PatientICP_CriticalEventsVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PatientICP_CriticalEventsVo> col = new ArrayList<PatientICP_CriticalEventsVo>();
	public String getBoClassName()
	{
		return "ims.icps.instantiation.domain.objects.PatientICP";
	}
	public boolean add(PatientICP_CriticalEventsVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PatientICP_CriticalEventsVo value)
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
	public int indexOf(PatientICP_CriticalEventsVo instance)
	{
		return col.indexOf(instance);
	}
	public PatientICP_CriticalEventsVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PatientICP_CriticalEventsVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PatientICP_CriticalEventsVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PatientICP_CriticalEventsVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PatientICP_CriticalEventsVoCollection clone = new PatientICP_CriticalEventsVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PatientICP_CriticalEventsVo)this.col.get(x).clone());
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
	public PatientICP_CriticalEventsVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PatientICP_CriticalEventsVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public PatientICP_CriticalEventsVoCollection sort(SortOrder order)
	{
		return sort(new PatientICP_CriticalEventsVoComparator(order));
	}
	public PatientICP_CriticalEventsVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new PatientICP_CriticalEventsVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public PatientICP_CriticalEventsVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.icps.instantiation.vo.PatientICPRefVoCollection toRefVoCollection()
	{
		ims.icps.instantiation.vo.PatientICPRefVoCollection result = new ims.icps.instantiation.vo.PatientICPRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public PatientICP_CriticalEventsVo[] toArray()
	{
		PatientICP_CriticalEventsVo[] arr = new PatientICP_CriticalEventsVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<PatientICP_CriticalEventsVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PatientICP_CriticalEventsVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public PatientICP_CriticalEventsVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PatientICP_CriticalEventsVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public PatientICP_CriticalEventsVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			PatientICP_CriticalEventsVo voObj1 = (PatientICP_CriticalEventsVo)obj1;
			PatientICP_CriticalEventsVo voObj2 = (PatientICP_CriticalEventsVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.icp.vo.beans.PatientICP_CriticalEventsVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.icp.vo.beans.PatientICP_CriticalEventsVoBean[] getBeanCollectionArray()
	{
		ims.icp.vo.beans.PatientICP_CriticalEventsVoBean[] result = new ims.icp.vo.beans.PatientICP_CriticalEventsVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			PatientICP_CriticalEventsVo vo = ((PatientICP_CriticalEventsVo)col.get(i));
			result[i] = (ims.icp.vo.beans.PatientICP_CriticalEventsVoBean)vo.getBean();
		}
		return result;
	}
	public static PatientICP_CriticalEventsVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		PatientICP_CriticalEventsVoCollection coll = new PatientICP_CriticalEventsVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.icp.vo.beans.PatientICP_CriticalEventsVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static PatientICP_CriticalEventsVoCollection buildFromBeanCollection(ims.icp.vo.beans.PatientICP_CriticalEventsVoBean[] beans)
	{
		PatientICP_CriticalEventsVoCollection coll = new PatientICP_CriticalEventsVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
