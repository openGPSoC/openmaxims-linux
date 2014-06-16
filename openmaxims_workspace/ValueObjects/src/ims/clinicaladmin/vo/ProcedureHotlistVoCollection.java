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
 * Linked to clinical.configuration.ProcedureHotlist business object (ID: 1073100010).
 */
public class ProcedureHotlistVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<ProcedureHotlistVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ProcedureHotlistVo> col = new ArrayList<ProcedureHotlistVo>();
	public String getBoClassName()
	{
		return "ims.clinical.configuration.domain.objects.ProcedureHotlist";
	}
	public boolean add(ProcedureHotlistVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ProcedureHotlistVo value)
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
	public int indexOf(ProcedureHotlistVo instance)
	{
		return col.indexOf(instance);
	}
	public ProcedureHotlistVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ProcedureHotlistVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ProcedureHotlistVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ProcedureHotlistVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ProcedureHotlistVoCollection clone = new ProcedureHotlistVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ProcedureHotlistVo)this.col.get(x).clone());
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
	public ProcedureHotlistVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ProcedureHotlistVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public ProcedureHotlistVoCollection sort(SortOrder order)
	{
		return sort(new ProcedureHotlistVoComparator(order));
	}
	public ProcedureHotlistVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new ProcedureHotlistVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public ProcedureHotlistVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.clinical.configuration.vo.ProcedureHotlistRefVoCollection toRefVoCollection()
	{
		ims.clinical.configuration.vo.ProcedureHotlistRefVoCollection result = new ims.clinical.configuration.vo.ProcedureHotlistRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public ProcedureHotlistVo[] toArray()
	{
		ProcedureHotlistVo[] arr = new ProcedureHotlistVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ims.vo.interfaces.IHotlist[] toIHotlistArray()
	{
		ims.vo.interfaces.IHotlist[] arr = new ims.vo.interfaces.IHotlist[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<ProcedureHotlistVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ProcedureHotlistVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public ProcedureHotlistVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ProcedureHotlistVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public ProcedureHotlistVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			ProcedureHotlistVo voObj1 = (ProcedureHotlistVo)obj1;
			ProcedureHotlistVo voObj2 = (ProcedureHotlistVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.clinicaladmin.vo.beans.ProcedureHotlistVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.clinicaladmin.vo.beans.ProcedureHotlistVoBean[] getBeanCollectionArray()
	{
		ims.clinicaladmin.vo.beans.ProcedureHotlistVoBean[] result = new ims.clinicaladmin.vo.beans.ProcedureHotlistVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			ProcedureHotlistVo vo = ((ProcedureHotlistVo)col.get(i));
			result[i] = (ims.clinicaladmin.vo.beans.ProcedureHotlistVoBean)vo.getBean();
		}
		return result;
	}
	public static ProcedureHotlistVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ProcedureHotlistVoCollection coll = new ProcedureHotlistVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.clinicaladmin.vo.beans.ProcedureHotlistVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static ProcedureHotlistVoCollection buildFromBeanCollection(ims.clinicaladmin.vo.beans.ProcedureHotlistVoBean[] beans)
	{
		ProcedureHotlistVoCollection coll = new ProcedureHotlistVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
