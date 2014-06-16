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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4785.23502)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.ocrr.domain.impl;

import ims.core.vo.domain.ServiceLiteVoAssembler;
import ims.core.vo.lookups.ServiceCategory;
import ims.ocrr.domain.base.impl.BaseSearchDisciplinesImpl;

import java.util.ArrayList;

public class SearchDisciplinesImpl extends BaseSearchDisciplinesImpl
{
	private static final long serialVersionUID = 1L;

	public ims.core.vo.ServiceLiteVoCollection listDiscipline() throws ims.domain.exceptions.DomainInterfaceException
	{
		StringBuilder query = new StringBuilder();
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		query.append("select srv from Service as srv left join srv.serviceCategory as srvCat where srv.isActive = 1 and srv.serviceCategory.id in ( " + getIdStringForPathRad() + " ) ");
		query.append(" order by UPPER(srvCat.text) asc, UPPER(srv.serviceName) asc");
		
		return ServiceLiteVoAssembler.createServiceLiteVoCollectionFromService(getDomainFactory().find(query.toString(), paramNames, paramValues)); 
	}
	
	private String getIdStringForPathRad() 
	{	
		String ids = "";
		ids += ServiceCategory.PATHOLOGY_DISCIPLINE.getID();
		ids += "," + ServiceCategory.RADIOLOGY_MODALITY.getID();
		
		return ids;
	}
}
