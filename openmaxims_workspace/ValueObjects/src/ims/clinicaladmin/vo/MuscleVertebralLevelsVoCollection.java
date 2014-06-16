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

package ims.clinicaladmin.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to therapies.MuscleVertebralLevel business object (ID: 1030100006).
 */
public class MuscleVertebralLevelsVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<MuscleVertebralLevelsVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<MuscleVertebralLevelsVo> col = new ArrayList<MuscleVertebralLevelsVo>();
	public String getBoClassName()
	{
		return "ims.therapies.domain.objects.MuscleVertebralLevel";
	}
	public boolean add(MuscleVertebralLevelsVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, MuscleVertebralLevelsVo value)
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
	public int indexOf(MuscleVertebralLevelsVo instance)
	{
		return col.indexOf(instance);
	}
	public MuscleVertebralLevelsVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, MuscleVertebralLevelsVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(MuscleVertebralLevelsVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(MuscleVertebralLevelsVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		MuscleVertebralLevelsVoCollection clone = new MuscleVertebralLevelsVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((MuscleVertebralLevelsVo)this.col.get(x).clone());
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
	public MuscleVertebralLevelsVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public MuscleVertebralLevelsVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public MuscleVertebralLevelsVoCollection sort(SortOrder order)
	{
		return sort(new MuscleVertebralLevelsVoComparator(order));
	}
	public MuscleVertebralLevelsVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new MuscleVertebralLevelsVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public MuscleVertebralLevelsVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.therapies.vo.MuscleVertebralLevelRefVoCollection toRefVoCollection()
	{
		ims.therapies.vo.MuscleVertebralLevelRefVoCollection result = new ims.therapies.vo.MuscleVertebralLevelRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public MuscleVertebralLevelsVo[] toArray()
	{
		MuscleVertebralLevelsVo[] arr = new MuscleVertebralLevelsVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<MuscleVertebralLevelsVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class MuscleVertebralLevelsVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public MuscleVertebralLevelsVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public MuscleVertebralLevelsVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public MuscleVertebralLevelsVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			MuscleVertebralLevelsVo voObj1 = (MuscleVertebralLevelsVo)obj1;
			MuscleVertebralLevelsVo voObj2 = (MuscleVertebralLevelsVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.clinicaladmin.vo.beans.MuscleVertebralLevelsVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.clinicaladmin.vo.beans.MuscleVertebralLevelsVoBean[] getBeanCollectionArray()
	{
		ims.clinicaladmin.vo.beans.MuscleVertebralLevelsVoBean[] result = new ims.clinicaladmin.vo.beans.MuscleVertebralLevelsVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			MuscleVertebralLevelsVo vo = ((MuscleVertebralLevelsVo)col.get(i));
			result[i] = (ims.clinicaladmin.vo.beans.MuscleVertebralLevelsVoBean)vo.getBean();
		}
		return result;
	}
	public static MuscleVertebralLevelsVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		MuscleVertebralLevelsVoCollection coll = new MuscleVertebralLevelsVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.clinicaladmin.vo.beans.MuscleVertebralLevelsVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static MuscleVertebralLevelsVoCollection buildFromBeanCollection(ims.clinicaladmin.vo.beans.MuscleVertebralLevelsVoBean[] beans)
	{
		MuscleVertebralLevelsVoCollection coll = new MuscleVertebralLevelsVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
