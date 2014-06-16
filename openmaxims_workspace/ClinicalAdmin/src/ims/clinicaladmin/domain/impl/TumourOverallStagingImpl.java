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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.55 build 2741.25619)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.clinicaladmin.domain.impl;

import ims.clinicaladmin.domain.base.impl.BaseTumourOverallStagingImpl;
import ims.clinicaladmin.vo.TumourSiteVo;
import ims.clinicaladmin.vo.domain.TumourGroupSiteForOverallStagingDialogVoAssembler;
import ims.clinicaladmin.vo.domain.TumourGroupSiteTNMValueListVoAssembler;
import ims.clinicaladmin.vo.domain.TumourSiteVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.oncology.configuration.domain.objects.TumourGroup;
import ims.oncology.configuration.domain.objects.TumourSite;
import ims.oncology.configuration.vo.TumourSiteRefVo;

import java.util.List;


public class TumourOverallStagingImpl extends BaseTumourOverallStagingImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* getTNMValueForSite
	*/
	public ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVoCollection getTNMValueForSite(ims.oncology.configuration.vo.TumourSiteRefVo refVo)
	{
		String hql = "select t2_1 from TumourSite as t1_1 join t1_1.tNMValues as t2_1 where t1_1.id = :id ";
		
		String[] strings = new String[] {"id"};
		Object[] objects = new Object[] {refVo.getID_TumourSite()};
		
		List find = getDomainFactory().find(hql, strings, objects);
		return TumourGroupSiteTNMValueListVoAssembler.createTumourGroupSiteTNMValueListVoCollectionFromTumourGroupSiteTNMValue(find);
	}

	/**
	* getGroupForOverallStaging
	*/
	public ims.clinicaladmin.vo.TumourGroupSiteForOverallStagingDialogVo getGroupForOverallStaging(ims.oncology.configuration.vo.TumourGroupRefVo voRef)
	{
		if(voRef == null || voRef.getID_TumourGroup()== null)
			throw new DomainRuntimeException("Invalid group");

	    DomainFactory factory = getDomainFactory();
	    TumourGroup domainObject = (TumourGroup) factory.getDomainObject(voRef);
	    return TumourGroupSiteForOverallStagingDialogVoAssembler.create(domainObject);
	}

	public TumourSiteVo getSiteVo(TumourSiteRefVo voSiteRefVo)
	{
		if (voSiteRefVo == null || voSiteRefVo.getID_TumourSite() == null)
			throw new DomainRuntimeException("Invalid site");

		DomainFactory factory = getDomainFactory();
		TumourSite domainObject = (TumourSite) factory.getDomainObject(voSiteRefVo);
		return TumourSiteVoAssembler.create(domainObject);
	}


}
