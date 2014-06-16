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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4694.23489)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import java.util.List;

import ims.admin.domain.base.impl.BaseDementiaConfigurationImpl;
import ims.admin.vo.DementiaConfigurationVo;
import ims.admin.vo.domain.DementiaConfigurationVoAssembler;
import ims.core.admin.domain.objects.DementiaConfiguration;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.framework.exceptions.CodingRuntimeException;

public class DementiaConfigurationImpl extends BaseDementiaConfigurationImpl
{

	private static final long serialVersionUID = 1L;

	public DementiaConfigurationVo save(DementiaConfigurationVo dementiaConfigToSave) throws ims.domain.exceptions.StaleObjectException
	{
		if (dementiaConfigToSave == null)
			throw new CodingRuntimeException("Cannot save null DementiaConfiguration ");

		if (!dementiaConfigToSave.isValidated())
			throw new DomainRuntimeException("DementiaConfiguration Not Validated.");

		DomainFactory factory = getDomainFactory();
		DementiaConfiguration domainDementiaConfig = DementiaConfigurationVoAssembler.extractDementiaConfiguration(factory, dementiaConfigToSave);

		factory.save(domainDementiaConfig);

		return DementiaConfigurationVoAssembler.create(domainDementiaConfig);
	}

	public ims.admin.vo.DementiaConfigurationVo getDementiaConfig()
	{
		DomainFactory factory = getDomainFactory();

		StringBuffer hql = new StringBuffer();
		hql.append("from DementiaConfiguration as dementiaConfig");

		List<?> list = factory.find(hql.toString());

		if (list == null || list.size() == 0)
			return null;

		return DementiaConfigurationVoAssembler.create((DementiaConfiguration) list.get(0));
	}
}
