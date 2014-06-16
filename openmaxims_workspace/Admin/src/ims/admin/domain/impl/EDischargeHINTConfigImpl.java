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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.70 build 3341.28572)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.base.impl.BaseEDischargeHINTConfigImpl;
import ims.clinicaladmin.vo.lookups.EDischargeHINT;
import ims.core.admin.domain.objects.FieldHelpText;
import ims.core.admin.vo.FieldHelpTextRefVo;
import ims.core.vo.FieldHelpVo;
import ims.core.vo.domain.FieldHelpVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class EDischargeHINTConfigImpl extends BaseEDischargeHINTConfigImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* list all hints
	*/
	public ims.core.vo.FieldHelpVoCollection listHINTs()
	{
		return FieldHelpVoAssembler.createFieldHelpVoCollectionFromFieldHelpText(getDomainFactory().find(" from FieldHelpText ")).sort();
	}

	public FieldHelpVo getHINT(FieldHelpTextRefVo voHistRef) 
	{
		if(voHistRef == null)
			throw new CodingRuntimeException("FieldHelpVo is null");
		
		DomainFactory factory = getDomainFactory();
		return FieldHelpVoAssembler.create((FieldHelpText)factory.getDomainObject(FieldHelpText.class, voHistRef.getID_FieldHelpText()));

	}

	public FieldHelpVo saveHINT(FieldHelpVo voHelpText) throws DomainInterfaceException, StaleObjectException 
	{
		if(voHelpText == null)
			throw new CodingRuntimeException("FieldHelpVo is null");
		
		if(!voHelpText.isValidated())
			throw new CodingRuntimeException("FieldHelpVo Value Object has not been validated");

		DomainFactory factory = getDomainFactory();
		FieldHelpText doHelp = FieldHelpVoAssembler.extractFieldHelpText(factory, voHelpText);

		factory.save(doHelp);
		return FieldHelpVoAssembler.create(doHelp);
	}

	public FieldHelpVo getHintByLookupID(EDischargeHINT voLookup) 
	{
		if(voLookup == null)
			throw new CodingRuntimeException("EDischargeHINT is null");

		DomainFactory factory = getDomainFactory();
		String hql = " from FieldHelpText fht " +
		" where fht.field = :fld "; 

		List list = factory.find(hql,new String[]{"fld"}, new Object[]{getDomLookup(voLookup)});

		if (list != null && list.size() > 0)
		{
			FieldHelpText doFHT = (FieldHelpText)list.get(0);
			return FieldHelpVoAssembler.create(doFHT);
		}
		return null;
	}
}
