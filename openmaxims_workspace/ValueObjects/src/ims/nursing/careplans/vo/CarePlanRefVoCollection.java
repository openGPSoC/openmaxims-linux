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

package ims.nursing.careplans.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to nursing.care plans.Care Plan business object (ID: 1010100003).
 */
public class CarePlanRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<CarePlanRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<CarePlanRefVo> col = new ArrayList<CarePlanRefVo>();
	public final String getBoClassName()
	{
		return "ims.nursing.careplans.domain.objects.CarePlan";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(CarePlanRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, CarePlanRefVo value)
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
	public int indexOf(CarePlanRefVo instance)
	{
		return col.indexOf(instance);
	}
	public CarePlanRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, CarePlanRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(CarePlanRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(CarePlanRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		CarePlanRefVoCollection clone = new CarePlanRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((CarePlanRefVo)this.col.get(x).clone());
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
	public CarePlanRefVo[] toArray()
	{
		CarePlanRefVo[] arr = new CarePlanRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public CarePlanRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public CarePlanRefVoCollection sort(SortOrder order)
	{
		return sort(new CarePlanRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public CarePlanRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<CarePlanRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class CarePlanRefVoComparator implements Comparator
	{
		private int direction = 1;
		public CarePlanRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public CarePlanRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			CarePlanRefVo voObj1 = (CarePlanRefVo)obj1;
			CarePlanRefVo voObj2 = (CarePlanRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
