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

package ims.core.resource.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.resource.ExternalResource business object (ID: 1005100008).
 */
public class ExternalResourceRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<ExternalResourceRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ExternalResourceRefVo> col = new ArrayList<ExternalResourceRefVo>();
	public final String getBoClassName()
	{
		return "ims.core.resource.domain.objects.ExternalResource";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(ExternalResourceRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ExternalResourceRefVo value)
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
	public int indexOf(ExternalResourceRefVo instance)
	{
		return col.indexOf(instance);
	}
	public ExternalResourceRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ExternalResourceRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ExternalResourceRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ExternalResourceRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ExternalResourceRefVoCollection clone = new ExternalResourceRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ExternalResourceRefVo)this.col.get(x).clone());
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
	public ExternalResourceRefVo[] toArray()
	{
		ExternalResourceRefVo[] arr = new ExternalResourceRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ExternalResourceRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ExternalResourceRefVoCollection sort(SortOrder order)
	{
		return sort(new ExternalResourceRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public ExternalResourceRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<ExternalResourceRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ExternalResourceRefVoComparator implements Comparator
	{
		private int direction = 1;
		public ExternalResourceRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ExternalResourceRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			ExternalResourceRefVo voObj1 = (ExternalResourceRefVo)obj1;
			ExternalResourceRefVo voObj2 = (ExternalResourceRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
