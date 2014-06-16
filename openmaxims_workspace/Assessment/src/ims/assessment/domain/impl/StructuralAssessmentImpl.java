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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.53 build 2511.27271)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.assessment.domain.impl;

import ims.assessment.configuration.domain.objects.UserDefinedObjectComponent;
import ims.assessment.domain.base.impl.BaseStructuralAssessmentImpl;
import ims.assessment.vo.domain.UserDefinedObjectComponentVoAssembler;
import ims.domain.exceptions.DomainRuntimeException;

public class StructuralAssessmentImpl extends BaseStructuralAssessmentImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* getComponent
	*/
	public ims.assessment.vo.UserDefinedObjectComponentVo getComponent(ims.assessment.configuration.vo.UserDefinedObjectComponentRefVo ref)
	{
		if(ref == null || ref.getID_UserDefinedObjectComponent() == null)
			throw new DomainRuntimeException("Invalid component");
				
		return UserDefinedObjectComponentVoAssembler.create((UserDefinedObjectComponent)getDomainFactory().getDomainObject(UserDefinedObjectComponent.class, ref.getID_UserDefinedObjectComponent().intValue()));
	}
}
