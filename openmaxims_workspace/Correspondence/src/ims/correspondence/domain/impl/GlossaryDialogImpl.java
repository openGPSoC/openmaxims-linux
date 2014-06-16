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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.25 build 1955.27417)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.domain.impl;


import java.util.ArrayList;


import ims.core.admin.pas.vo.PASEventRefVo;
import ims.core.domain.ADT;
import ims.core.domain.impl.ADTImpl;
import ims.core.vo.PasEventVo;
import ims.correspondence.vo.GlossaryVoCollection;
import ims.correspondence.vo.domain.GlossaryVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.impl.DomainImpl;
import ims.framework.exceptions.CodingRuntimeException;
import ims.vo.interfaces.ICspTypeSpecifier;

public class GlossaryDialogImpl extends DomainImpl implements ims.correspondence.domain.GlossaryDialog, ims.domain.impl.Transactional
{
	

	public GlossaryVoCollection listDistinctGlossariesForProfileTypes(ICspTypeSpecifier[] cspTypeSpecifiers) 
	{
		if (cspTypeSpecifiers == null || cspTypeSpecifiers.length <= 0)
			throw new CodingRuntimeException("Invalid Argument: No Specifier Type supplied");
		
		DomainFactory factory = getDomainFactory();
		
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		StringBuffer hql = new StringBuffer();
		hql.append("select gl from Glossary gl where gl.id in  (select distinct gloss.glossaries.id from GlossaryProfile gloss where ");
		
		for (int i = 0; i < cspTypeSpecifiers.length; i++)
		{
			String strIDMarker = "specifierID" + i;
			String strTypeMarker = "specifierType" + i;
			
			ICspTypeSpecifier specifier = cspTypeSpecifiers[i];
			hql.append("(gloss.specifierID = :" + strIDMarker + "");
			names.add(strIDMarker);
			values.add(specifier.getIGenericItemInfoID());	
			
			hql.append(" and "); 
			hql.append("gloss.specifierType = :" + strTypeMarker + ")");
			names.add(strTypeMarker);
			values.add(getDomLookup(specifier.getSpecifierType()));
			
			if (i < cspTypeSpecifiers.length - 1)
				hql.append(" or ");
			else
				hql.append(")");
			
		}
	
		java.util.List glossaryList = factory.find(hql.toString(), names, values);
	
		
		return GlossaryVoAssembler.createGlossaryVoCollectionFromGlossary(glossaryList);
	}

	public PasEventVo getPasEvent(PASEventRefVo pasEventRefVo) 
	{
		if (pasEventRefVo == null)
			throw new CodingRuntimeException("Mandatory Argument - PAS Event Required");
		
		ADT impl = (ADT)getDomainImpl(ADTImpl.class);
		return impl.getPasEvent(pasEventRefVo);
	}


}
