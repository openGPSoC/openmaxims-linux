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

/**
 * Linked to core.patient.Patient business object (ID: 1001100000).
 */
public class PatientShortCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<PatientShort>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PatientShort> col = new ArrayList<PatientShort>();
	public String getBoClassName()
	{
		return "ims.core.patient.domain.objects.Patient";
	}
	public boolean add(PatientShort value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PatientShort value)
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
	public int indexOf(PatientShort instance)
	{
		return col.indexOf(instance);
	}
	public PatientShort get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PatientShort value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PatientShort instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PatientShort instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PatientShortCollection clone = new PatientShortCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PatientShort)this.col.get(x).clone());
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
	public PatientShortCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PatientShortCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public PatientShortCollection sort(SortOrder order)
	{
		return sort(new PatientShortComparator(order));
	}
	public PatientShortCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new PatientShortComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public PatientShortCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.patient.vo.PatientRefVoCollection toRefVoCollection()
	{
		ims.core.patient.vo.PatientRefVoCollection result = new ims.core.patient.vo.PatientRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public PatientShort[] toArray()
	{
		PatientShort[] arr = new PatientShort[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ims.framework.interfaces.ISelectedPatient[] toISelectedPatientArray()
	{
		ims.framework.interfaces.ISelectedPatient[] arr = new ims.framework.interfaces.ISelectedPatient[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<PatientShort> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PatientShortComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public PatientShortComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PatientShortComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public PatientShortComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			PatientShort voObj1 = (PatientShort)obj1;
			PatientShort voObj2 = (PatientShort)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.core.vo.beans.PatientShortBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.core.vo.beans.PatientShortBean[] getBeanCollectionArray()
	{
		ims.core.vo.beans.PatientShortBean[] result = new ims.core.vo.beans.PatientShortBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			PatientShort vo = ((PatientShort)col.get(i));
			result[i] = (ims.core.vo.beans.PatientShortBean)vo.getBean();
		}
		return result;
	}
	public static PatientShortCollection buildFromBeanCollection(java.util.Collection beans)
	{
		PatientShortCollection coll = new PatientShortCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.core.vo.beans.PatientShortBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static PatientShortCollection buildFromBeanCollection(ims.core.vo.beans.PatientShortBean[] beans)
	{
		PatientShortCollection coll = new PatientShortCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
