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

import ims.core.resource.place.domain.objects.Location;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.framework.interfaces.ILocation;
import ims.ocrr.domain.NewResultsAllTabComponent;
import ims.ocrr.domain.base.impl.BaseNewResultsInpatientTabComponentImpl;

public class NewResultsInpatientTabComponentImpl extends BaseNewResultsInpatientTabComponentImpl
{
	private static final long serialVersionUID = 1L;

	public ims.core.vo.LocationLiteVoCollection listHospitals()
	{
		NewResultsAllTabComponent newResultsAllImpl = (NewResultsAllTabComponent) getDomainImpl(NewResultsAllTabComponentImpl.class);
		return newResultsAllImpl.listHospitals();
	}

	public ims.core.vo.HcpLiteVoCollection listReviewingHCP(String name)
	{
		NewResultsAllTabComponent newResultsAllImpl = (NewResultsAllTabComponent) getDomainImpl(NewResultsAllTabComponentImpl.class);
		return newResultsAllImpl.listReviewingHCP(name);
	}

	public ims.core.vo.LocationLiteVoCollection listWards(String name, ims.core.resource.place.vo.LocationRefVo voLocRef)
	{
		NewResultsAllTabComponent newResultsAllImpl = (NewResultsAllTabComponent) getDomainImpl(NewResultsAllTabComponentImpl.class);
		return newResultsAllImpl.listWards(name, voLocRef);
	}
	
	//WDEV-17494
	public LocationLiteVo getCurrentHospital(ILocation currentLocation) 
	{
		if(currentLocation == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		Location currentHospital = getHospital((Location) factory.getDomainObject(Location.class, currentLocation.getID()));
		
		if(currentHospital instanceof Location)
			return LocationLiteVoAssembler.create((Location) currentHospital);
		
		return null;
	}
	
	private Location getHospital(Location doLocation)
	{
		if(doLocation == null)
			return null;
		
		if(doLocation instanceof Location && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
			return doLocation;
	
		while(doLocation.getParentLocation() != null) 
		{
			doLocation = doLocation.getParentLocation();
			if(doLocation instanceof Location && doLocation.getType().equals(getDomLookup(LocationType.HOSP)))
				return doLocation;
		}
		
		return null;
	}
}
