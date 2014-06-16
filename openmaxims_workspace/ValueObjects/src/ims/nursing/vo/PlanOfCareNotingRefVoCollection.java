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

package ims.nursing.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to nursing.PlanOfCareNoting business object (ID: 1009100014).
 */
public class PlanOfCareNotingRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<PlanOfCareNotingRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PlanOfCareNotingRefVo> col = new ArrayList<PlanOfCareNotingRefVo>();
	public final String getBoClassName()
	{
		return "ims.nursing.domain.objects.PlanOfCareNoting";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(PlanOfCareNotingRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PlanOfCareNotingRefVo value)
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
	public int indexOf(PlanOfCareNotingRefVo instance)
	{
		return col.indexOf(instance);
	}
	public PlanOfCareNotingRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PlanOfCareNotingRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PlanOfCareNotingRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PlanOfCareNotingRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PlanOfCareNotingRefVoCollection clone = new PlanOfCareNotingRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PlanOfCareNotingRefVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		return clone;
	}
	public boolean isValidated()
	{
		return true;
	}
	public String[] validate()
	{
		return null;
	}
	public PlanOfCareNotingRefVo[] toArray()
	{
		PlanOfCareNotingRefVo[] arr = new PlanOfCareNotingRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public PlanOfCareNotingRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PlanOfCareNotingRefVoCollection sort(SortOrder order)
	{
		return sort(new PlanOfCareNotingRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public PlanOfCareNotingRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<PlanOfCareNotingRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PlanOfCareNotingRefVoComparator implements Comparator
	{
		private int direction = 1;
		public PlanOfCareNotingRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PlanOfCareNotingRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			PlanOfCareNotingRefVo voObj1 = (PlanOfCareNotingRefVo)obj1;
			PlanOfCareNotingRefVo voObj2 = (PlanOfCareNotingRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
