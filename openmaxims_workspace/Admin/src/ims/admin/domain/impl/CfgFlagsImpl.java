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
// This code was generated by John MacEnri using IMS Development Environment (version 1.39 build 2174.26977)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.vo.FlagCategoryVo;
import ims.admin.vo.FlagCategoryVoCollection;
import ims.configuration.CfgFlag;
import ims.configuration.FlagCategory;
import ims.configuration.IFlag;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.impl.DomainImpl;

public class CfgFlagsImpl extends DomainImpl implements ims.admin.domain.ConfigFlags, ims.domain.impl.Transactional
{
	/**
	* Saves a ConfigFlag
	*/
	public String saveConfigFlag(IFlag flag, String flagValue)
	{
		try
		{
			CfgFlag.saveFlag(flag.getName(), flagValue);
		}
		catch (Exception e)
		{
			throw new DomainRuntimeException("Failed to save configuration flag. " + e.getMessage(), e);
		}
		return "";
	}

	public ims.admin.vo.FlagCategoryVoCollection listCategories()
	{
		FlagCategoryVoCollection coll = new FlagCategoryVoCollection();
		FlagCategory[] cats = CfgFlag.listCats();
		for (int i = 0; i < cats.length; i++)
		{
			FlagCategoryVo vo = new FlagCategoryVo();
			vo.setKey(cats[i].getKey());
			vo.setName(cats[i].getName());
			coll.add(vo);
		}
		return coll;
	}

	public IFlag[] listFlags(ims.admin.vo.FlagCategoryVo catVo)
	{
		//FlagCategory cat = CfgFlag.getCat(catVo.getKey());
		//return cat.listFlags();
		return null;
	}

	public IFlag[] listFlags(FlagCategoryVo category, String filter)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
