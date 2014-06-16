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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4892.20548)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import ims.domain.DomainFactory;
import ims.emergency.domain.base.impl.BaseEDWhiteBoardEditDialogImpl;
import ims.emergency.domain.objects.Tracking;
import ims.emergency.vo.TrackingForClinicianWorklistAndTriageVo;
import ims.emergency.vo.TrackingRefVo;
import ims.emergency.vo.domain.TrackingForClinicianWorklistAndTriageVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class EDWhiteBoardEditDialogImpl extends BaseEDWhiteBoardEditDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ims.emergency.vo.TrackingAreaShortVoCollection listTrackingAreas(ims.framework.interfaces.ILocation edLoc)
	{
		// TODO: Add your code here and change the return value.
		return null;
	}

	public ims.emergency.vo.TrackingForClinicianWorklistAndTriageVoCollection listTrackingPatients(ims.emergency.vo.TrackingAreaShortVo trackingArea, ims.emergency.vo.lookups.TrackingStatus trackingStatus, ims.framework.interfaces.ILocation edLoc)
	{
DomainFactory factory = getDomainFactory();
		
		StringBuilder hqlJoins = new StringBuilder("select tr from Tracking as tr left join tr.patient as p left join tr.attendance as att left join tr.currentArea as ta");
		StringBuilder hqlConditions = new StringBuilder(" where ");
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		String and = " and ";
		
		if( trackingArea != null )
		{
			if (trackingArea.getIsOverallViewIsNotNull() && trackingArea.getIsOverallView().equals(true))
    		{
    			hqlConditions.append(" ta.id is not null ");
    			
    		}
    		else
    		{
    			hqlConditions.append(" ta.id = :TrackingAreaId ");
    			paramNames.add("TrackingAreaId");
    			paramValues.add(trackingArea.getID_TrackingArea());
    		}
		}
		
		if( edLoc != null)
		{
			hqlJoins.append(" left join tr.eDLocation as loc ");
			
			hqlConditions.append(and);
			hqlConditions.append(" loc.id = :locId ");
			paramNames.add("locId");
			paramValues.add(edLoc.getID());
			and = " and ";
		}
		else
		{
			if( trackingArea != null )
			{
				hqlJoins.append(" left join tr.eDLocation as loc ");
				
				hqlConditions.append(and);
				hqlConditions.append(" loc.id = :locId ");
				paramNames.add("locId");
				paramValues.add(trackingArea.getEDLocation().getID_Location());
				and = " and ";
			}
		}
		
		if( trackingStatus != null)
		{
						
			hqlJoins.append(" left join tr.currentStatus as cs left join cs.status as s ");
			
			hqlConditions.append(and);
			hqlConditions.append(" s.id = :statusId ");
			paramNames.add("statusId");
			paramValues.add(trackingStatus.getID());
			and = " and ";
		}
		
		
		
		List<?> patients = factory.find(hqlJoins.append(hqlConditions.toString()).toString(), paramNames, paramValues);
		
		if( patients != null && patients.size() > 0 )
		{
			return TrackingForClinicianWorklistAndTriageVoAssembler.createTrackingForClinicianWorklistAndTriageVoCollectionFromTracking(patients);
		}
		
		return null;
	}

	public TrackingForClinicianWorklistAndTriageVo getTracking(TrackingRefVo trackingRef)
	{
		if (trackingRef == null || trackingRef.getID_Tracking() == null)
		{
			throw new CodingRuntimeException("Cannot get Tracking by null Id ");
		}

		DomainFactory factory = getDomainFactory();

		Tracking domainTracking = (Tracking) factory.getDomainObject(Tracking.class, trackingRef.getID_Tracking());

		return TrackingForClinicianWorklistAndTriageVoAssembler.create(domainTracking);
	}
}
