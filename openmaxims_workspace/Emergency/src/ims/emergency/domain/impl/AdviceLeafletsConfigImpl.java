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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.core.admin.vo.TemplateBoRefVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.configuration.domain.objects.AdviceLeafletsConfig;
import ims.emergency.configuration.vo.AdviceLeafletsConfigRefVo;
import ims.emergency.domain.base.impl.BaseAdviceLeafletsConfigImpl;
import ims.emergency.vo.AdviceLeafletsForPresentingProblemConfigVo;
import ims.emergency.vo.AdviceLeafletsForPresentingProblemConfigVoCollection;
import ims.emergency.vo.domain.AdviceLeafletsForPresentingProblemConfigVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class AdviceLeafletsConfigImpl extends BaseAdviceLeafletsConfigImpl
{

	private static final long serialVersionUID = 1L;

	public AdviceLeafletsForPresentingProblemConfigVo getAdviceLeafletByTemplate(TemplateBoRefVo templateRef)
	{
		if (templateRef == null || templateRef.getID_TemplateBo() == null)
		{
			throw new CodingRuntimeException("Cannot get AdviceLeafletsForPresentingProblemConfigVo on null Id for Template ");
		}

		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();
		hql.append("select advice from AdviceLeafletsConfig as advice where advice.template.id = :templID ");

		List<?> list = factory.find(hql.toString(), new String[] { "templID" }, new Object[] { templateRef.getID_TemplateBo() });
		
		AdviceLeafletsForPresentingProblemConfigVoCollection listAdvice = AdviceLeafletsForPresentingProblemConfigVoAssembler.createAdviceLeafletsForPresentingProblemConfigVoCollectionFromAdviceLeafletsConfig(list);
		
		if (listAdvice!=null && listAdvice.size()>0)
		{
			return listAdvice.get(0);
		}
		
		return null;
	}

	public AdviceLeafletsForPresentingProblemConfigVo save(AdviceLeafletsForPresentingProblemConfigVo adviceLeafletToSave) throws StaleObjectException
	{
		if (adviceLeafletToSave == null)
			throw new CodingRuntimeException("Cannot save null AdviceLeafletsForPresentingProblemConfigVo ");

		if (!adviceLeafletToSave.isValidated())
			throw new DomainRuntimeException("AdviceLeafletsForPresentingProblemConfigVo Not Validated.");

		DomainFactory factory = getDomainFactory();
		 AdviceLeafletsConfig domainAdviceLeaflet = AdviceLeafletsForPresentingProblemConfigVoAssembler.extractAdviceLeafletsConfig(factory, adviceLeafletToSave);

		factory.save(domainAdviceLeaflet);

		return AdviceLeafletsForPresentingProblemConfigVoAssembler.create(domainAdviceLeaflet);
	}

	public Boolean isStale(AdviceLeafletsForPresentingProblemConfigVo adviceLeafletToSave)
	{
		if (adviceLeafletToSave == null || adviceLeafletToSave.getID_AdviceLeafletsConfig() == null)
		{
			throw new CodingRuntimeException("Cannot get AdviceLeafletsForPresentingProblemConfigVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();
		AdviceLeafletsConfig domainAdviceLeaflet = (AdviceLeafletsConfig) factory.getDomainObject(AdviceLeafletsConfig.class, adviceLeafletToSave.getID_AdviceLeafletsConfig());

		if (domainAdviceLeaflet == null)
		{
			return true;
		}

		if (domainAdviceLeaflet.getVersion() > adviceLeafletToSave.getVersion_AdviceLeafletsConfig())
		{
			return true;
		}

		return false;
	}

	public AdviceLeafletsForPresentingProblemConfigVo getAdviceLeaflet(AdviceLeafletsConfigRefVo adviceLeaflet)
	{
		if (adviceLeaflet == null || adviceLeaflet.getID_AdviceLeafletsConfig() == null)
		{
			throw new CodingRuntimeException("Cannot get AdviceLeafletsForPresentingProblemConfigVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();

		AdviceLeafletsConfig domainAdviceLeaflet = (AdviceLeafletsConfig) factory.getDomainObject(AdviceLeafletsConfig.class, adviceLeaflet.getID_AdviceLeafletsConfig());

		return AdviceLeafletsForPresentingProblemConfigVoAssembler.create(domainAdviceLeaflet);
	}

}
