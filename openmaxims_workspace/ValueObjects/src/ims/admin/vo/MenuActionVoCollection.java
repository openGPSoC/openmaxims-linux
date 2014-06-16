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

package ims.admin.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.configuration.MenuAction business object (ID: 1028100039).
 */
public class MenuActionVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<MenuActionVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<MenuActionVo> col = new ArrayList<MenuActionVo>();
	public String getBoClassName()
	{
		return "ims.core.configuration.domain.objects.MenuAction";
	}
	public boolean add(MenuActionVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, MenuActionVo value)
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
	public int indexOf(MenuActionVo instance)
	{
		return col.indexOf(instance);
	}
	public MenuActionVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, MenuActionVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(MenuActionVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(MenuActionVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		MenuActionVoCollection clone = new MenuActionVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((MenuActionVo)this.col.get(x).clone());
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
	public MenuActionVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public MenuActionVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public MenuActionVoCollection sort(SortOrder order)
	{
		return sort(new MenuActionVoComparator(order));
	}
	public MenuActionVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new MenuActionVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public MenuActionVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.configuration.vo.MenuActionRefVoCollection toRefVoCollection()
	{
		ims.core.configuration.vo.MenuActionRefVoCollection result = new ims.core.configuration.vo.MenuActionRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public MenuActionVo[] toArray()
	{
		MenuActionVo[] arr = new MenuActionVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ims.framework.interfaces.IMenuAction[] toIMenuActionArray()
	{
		ims.framework.interfaces.IMenuAction[] arr = new ims.framework.interfaces.IMenuAction[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<MenuActionVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class MenuActionVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public MenuActionVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public MenuActionVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public MenuActionVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			MenuActionVo voObj1 = (MenuActionVo)obj1;
			MenuActionVo voObj2 = (MenuActionVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.admin.vo.beans.MenuActionVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.admin.vo.beans.MenuActionVoBean[] getBeanCollectionArray()
	{
		ims.admin.vo.beans.MenuActionVoBean[] result = new ims.admin.vo.beans.MenuActionVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			MenuActionVo vo = ((MenuActionVo)col.get(i));
			result[i] = (ims.admin.vo.beans.MenuActionVoBean)vo.getBean();
		}
		return result;
	}
	public static MenuActionVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		MenuActionVoCollection coll = new MenuActionVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.admin.vo.beans.MenuActionVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static MenuActionVoCollection buildFromBeanCollection(ims.admin.vo.beans.MenuActionVoBean[] beans)
	{
		MenuActionVoCollection coll = new MenuActionVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
