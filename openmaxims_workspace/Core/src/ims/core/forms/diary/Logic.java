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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.60 build 2882.23380)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.diary;

import ims.framework.controls.DiaryEvent;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
	
	}
	/**
	* addEntry -  add an item that implements IDiaryEntry
	*/
	public void addEntry(ims.vo.interfaces.IDiaryEntry item)
	{
		if(item != null)
		{
			DiaryEvent diaryEvent = form.diary().getEvents().newEvent(item.getIDiaryEntryDateTime(), item.getIDiaryEntryText());
			diaryEvent.setImage(item.getIDiaryEntryImage());
			diaryEvent.setTooltip(item.getIDiaryEntryTooltip());
		}
	}

	/**
	* addEntries
	*/
	public void addEntries(ims.vo.interfaces.IDiaryEntry[] items)
	{
		if(items != null)
		{
			for (int i = 0; i < items.length; i++)
			{
				addEntry(items[i]);
			}
		}
	}

	/**
	* setTitle
	*/
	public void setTitle(String title)
	{
		form.diary().setTitle(title);
	}

	public void clear()
	{
		form.diary().getEvents().clear();
	}
}
