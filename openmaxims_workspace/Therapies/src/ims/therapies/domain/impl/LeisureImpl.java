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
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.45 build 2250.23637)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.therapies.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.therapies.domain.base.impl.BaseLeisureImpl;
import ims.therapies.vo.LeisureActivitiesVo;
import ims.therapies.vo.LeisureActivitiesVoCollection;
import ims.therapies.vo.domain.LeisureActivitiesVoAssembler;
import ims.therapies.workleisuredriving.domain.objects.LeisureActivities;

public class LeisureImpl extends BaseLeisureImpl
{
	/**
	* list Medics
	*/
	public ims.core.vo.HcpCollection listMedics(ims.core.vo.HcpFilter voHcpFilter)
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHCPs(voHcpFilter);
	}

	public void save(LeisureActivitiesVo voLeisureActivities) throws StaleObjectException, UniqueKeyViolationException
	{
		if(!voLeisureActivities.isValidated())
			throw new DomainRuntimeException("This Leisure Activity has not been validated");
	
		if(voLeisureActivities.getID_LeisureActivities() == null)
		{
			if(voLeisureActivities.getCareContextIsNotNull())
			{
				LeisureActivitiesVoCollection coll = getLeisureActivitiesVoByCareContext(voLeisureActivities.getCareContext());
				if(coll != null && coll.size()>0)
					throw new DomainRuntimeException("A Leisure record already exists for this CareContext. ");
			}
		}
		DomainFactory factory = getDomainFactory();
		LeisureActivities doLeisureActivities = LeisureActivitiesVoAssembler.extractLeisureActivities(factory, voLeisureActivities);
		factory.save(doLeisureActivities);
	}

	public LeisureActivitiesVoCollection getLeisureActivitiesVoByCareContext(CareContextRefVo voCareContext)
	{
		String hql = new String("from LeisureActivities l where l.careContext.id = :CARECONTEXT_ID order by l.systemInformation.creationDateTime desc ");

		java.util.List list = getDomainFactory().find(hql, "CARECONTEXT_ID", voCareContext.getID_CareContext());

		return LeisureActivitiesVoAssembler.createLeisureActivitiesVoCollectionFromLeisureActivities(list);
	}

}
