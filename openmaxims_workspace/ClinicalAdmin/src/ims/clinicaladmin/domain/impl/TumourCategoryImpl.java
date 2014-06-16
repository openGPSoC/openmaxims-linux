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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.53 build 2651.24225)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.clinicaladmin.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.clinicaladmin.domain.base.impl.BaseTumourCategoryImpl;
import ims.clinicaladmin.vo.TumourCategoryListVoCollection;
import ims.clinicaladmin.vo.TumourCategoryVersionGroupsLiteVoCollection;
import ims.clinicaladmin.vo.TumourGroupListVoCollection;
import ims.clinicaladmin.vo.TumourSiteListVoCollection;
import ims.clinicaladmin.vo.domain.TumourCategoryListVoAssembler;
import ims.clinicaladmin.vo.domain.TumourCategoryVersionGroupsLiteVoAssembler;
import ims.clinicaladmin.vo.domain.TumourGroupListVoAssembler;
import ims.clinicaladmin.vo.domain.TumourSiteListVoAssembler;
import ims.domain.DomainFactory;
import ims.oncology.configuration.vo.TumourCategoryRefVo;
import ims.oncology.configuration.vo.TumourCategoryVersionGroupsRefVo;
import ims.oncology.configuration.vo.TumourGroupRefVo;

public class TumourCategoryImpl extends BaseTumourCategoryImpl
{
	private static final long serialVersionUID = 1L;
	
	public TumourCategoryListVoCollection listCategorys() 
	{
		DomainFactory factory = getDomainFactory();
		String hqlString = "from TumourCategory";
		List collection = factory.find(hqlString);
		return TumourCategoryListVoAssembler.createTumourCategoryListVoCollectionFromTumourCategory(collection);
	}

	public TumourCategoryVersionGroupsLiteVoCollection listVersions(TumourCategoryRefVo category)
	{
		if (category == null || !category.getID_TumourCategoryIsNotNull())
			return null;
		
		String query = "select versions from TumourCategory as category left join category.versionGroups as versions where category.id = :CAT_ID";
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("CAT_ID");
		paramValues.add(category.getID_TumourCategory());		
		
		return TumourCategoryVersionGroupsLiteVoAssembler.createTumourCategoryVersionGroupsLiteVoCollectionFromTumourCategoryVersionGroups
		(getDomainFactory().find(query, paramNames, paramValues));
	}

	public TumourGroupListVoCollection listGroups(TumourCategoryVersionGroupsRefVo version)
	{
		if (version == null || !version.getID_TumourCategoryVersionGroupsIsNotNull())
			return null;

		String query = "select groups from TumourCategoryVersionGroups as versions left join versions.groups as groups where versions.id = :VER_ID";
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		paramNames.add("VER_ID");
		paramValues.add(version.getID_TumourCategoryVersionGroups());
		
		return TumourGroupListVoAssembler.createTumourGroupListVoCollectionFromTumourGroup(getDomainFactory().find(query, paramNames, paramValues));
	}
	
	public TumourSiteListVoCollection listSites(TumourGroupRefVo group)
	{
		List find = getDomainFactory().find("select t2_1 from TumourGroup as t1_1 join t1_1.sites as t2_1 where t1_1.id = :id", new String[] {"id"}, new Object[] {group.getID_TumourGroup()});
		return TumourSiteListVoAssembler.createTumourSiteListVoCollectionFromTumourSite(
				find);
	}
}
