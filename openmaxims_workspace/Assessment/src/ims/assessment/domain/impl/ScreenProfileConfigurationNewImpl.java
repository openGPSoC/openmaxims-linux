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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.62 build 3023.13950)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.assessment.domain.impl;

import java.util.List;

import ims.assessment.configuration.domain.objects.ScreeningProfile;
import ims.assessment.domain.base.impl.BaseScreenProfileConfigurationNewImpl;
import ims.assessment.vo.domain.ScreeningProfileVoAssembler;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;

public class ScreenProfileConfigurationNewImpl extends BaseScreenProfileConfigurationNewImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* saveProfile
	*/
	public ims.assessment.vo.ScreeningProfileVo saveProfile(ims.assessment.vo.ScreeningProfileVo profile) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException
	{
		if(profile == null)
			throw new RuntimeException("Cannot save null value for ScreeningProfileVo");
		if(profile.isValidated() == false)
			throw new CodingRuntimeException("ScreeningProfileVo has not been validated");
		
		DomainFactory factory = getDomainFactory();
		
		if(PreActiveActiveInactiveStatus.ACTIVE.equals(profile.getActiveStatus()))
		{
			StringBuffer sb = new StringBuffer();
			sb.append("select count (s1_1.id) from ScreeningProfile as s1_1 where s1_1.activeStatus.id = -617 and s1_1.contextType.id = :CONTEXT_ID and 1 = 1");
			List list = null;
			
			if(profile.getID_ScreeningProfileIsNotNull())
			{
				sb.append(" and s1_1.id <> :ID");
				list = factory.find(sb.toString(), new String[] {"CONTEXT_ID", "ID"}, new Object[] {new Integer(profile.getContextType().getID()), profile.getID_ScreeningProfile()});
			}
			else
			{
				list = factory.find(sb.toString(), new String[] {"CONTEXT_ID"}, new Object[] {new Integer(profile.getContextType().getID())});	
			}
			
			if(!"0".equals(list.get(0).toString()))
				throw new ims.domain.exceptions.DomainInterfaceException("There is an active record saved against the current context type !");	
		}
		
		ScreeningProfile doScreeningProfile = ScreeningProfileVoAssembler.extractScreeningProfile(factory, profile);
		factory.save(doScreeningProfile);
		
		return ScreeningProfileVoAssembler.create(doScreeningProfile);
	}

	/**
	* getProfile
	*/
	public ims.assessment.vo.ScreeningProfileVo getProfile(ims.assessment.configuration.vo.ScreeningProfileRefVo profileRef)
	{
		if(profileRef == null || profileRef.getID_ScreeningProfile() == null)
			throw new CodingRuntimeException("Cannot get ScreeningProfileVo for null id");
		
		DomainFactory factory = getDomainFactory();
		return ScreeningProfileVoAssembler.create((ScreeningProfile)factory.getDomainObject(ScreeningProfile.class, profileRef.getID_ScreeningProfile()));
	}
}
