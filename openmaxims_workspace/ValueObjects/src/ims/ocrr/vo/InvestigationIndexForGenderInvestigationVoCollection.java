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

package ims.ocrr.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to OCRR.Configuration.InvestigationIndex business object (ID: 1061100003).
 */
public class InvestigationIndexForGenderInvestigationVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<InvestigationIndexForGenderInvestigationVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<InvestigationIndexForGenderInvestigationVo> col = new ArrayList<InvestigationIndexForGenderInvestigationVo>();
	public String getBoClassName()
	{
		return "ims.ocrr.configuration.domain.objects.InvestigationIndex";
	}
	public boolean add(InvestigationIndexForGenderInvestigationVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, InvestigationIndexForGenderInvestigationVo value)
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
	public int indexOf(InvestigationIndexForGenderInvestigationVo instance)
	{
		return col.indexOf(instance);
	}
	public InvestigationIndexForGenderInvestigationVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, InvestigationIndexForGenderInvestigationVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(InvestigationIndexForGenderInvestigationVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(InvestigationIndexForGenderInvestigationVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		InvestigationIndexForGenderInvestigationVoCollection clone = new InvestigationIndexForGenderInvestigationVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((InvestigationIndexForGenderInvestigationVo)this.col.get(x).clone());
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
	public InvestigationIndexForGenderInvestigationVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public InvestigationIndexForGenderInvestigationVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public InvestigationIndexForGenderInvestigationVoCollection sort(SortOrder order)
	{
		return sort(new InvestigationIndexForGenderInvestigationVoComparator(order));
	}
	public InvestigationIndexForGenderInvestigationVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new InvestigationIndexForGenderInvestigationVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public InvestigationIndexForGenderInvestigationVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.ocrr.configuration.vo.InvestigationIndexRefVoCollection toRefVoCollection()
	{
		ims.ocrr.configuration.vo.InvestigationIndexRefVoCollection result = new ims.ocrr.configuration.vo.InvestigationIndexRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public InvestigationIndexForGenderInvestigationVo[] toArray()
	{
		InvestigationIndexForGenderInvestigationVo[] arr = new InvestigationIndexForGenderInvestigationVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<InvestigationIndexForGenderInvestigationVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class InvestigationIndexForGenderInvestigationVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public InvestigationIndexForGenderInvestigationVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public InvestigationIndexForGenderInvestigationVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public InvestigationIndexForGenderInvestigationVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			InvestigationIndexForGenderInvestigationVo voObj1 = (InvestigationIndexForGenderInvestigationVo)obj1;
			InvestigationIndexForGenderInvestigationVo voObj2 = (InvestigationIndexForGenderInvestigationVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.ocrr.vo.beans.InvestigationIndexForGenderInvestigationVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.ocrr.vo.beans.InvestigationIndexForGenderInvestigationVoBean[] getBeanCollectionArray()
	{
		ims.ocrr.vo.beans.InvestigationIndexForGenderInvestigationVoBean[] result = new ims.ocrr.vo.beans.InvestigationIndexForGenderInvestigationVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			InvestigationIndexForGenderInvestigationVo vo = ((InvestigationIndexForGenderInvestigationVo)col.get(i));
			result[i] = (ims.ocrr.vo.beans.InvestigationIndexForGenderInvestigationVoBean)vo.getBean();
		}
		return result;
	}
	public static InvestigationIndexForGenderInvestigationVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		InvestigationIndexForGenderInvestigationVoCollection coll = new InvestigationIndexForGenderInvestigationVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.ocrr.vo.beans.InvestigationIndexForGenderInvestigationVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static InvestigationIndexForGenderInvestigationVoCollection buildFromBeanCollection(ims.ocrr.vo.beans.InvestigationIndexForGenderInvestigationVoBean[] beans)
	{
		InvestigationIndexForGenderInvestigationVoCollection coll = new InvestigationIndexForGenderInvestigationVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
