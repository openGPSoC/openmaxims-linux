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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.pathways.domain;

// Generated from form domain impl
public interface CreateNewEvent extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listEventTargetsByTypesAndTargets
	*/
	public ims.pathways.vo.EventTargetLiteVoCollection listEventTargetsByTypesAndTargets(ims.pathways.vo.lookups.EventCreationTypeCollection eventTypes, ims.pathways.configuration.vo.TargetRefVoCollection targets);

	// Generated from form domain interface definition
	public ims.pathways.vo.PatientEventVo savePatientEvent(ims.pathways.vo.PatientEventVo event) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.pathways.vo.PatientJourneyTargetVo getPatientJourneyTarget(ims.pathways.vo.PatientPathwayJourneyRefVo pathway, ims.pathways.configuration.vo.TargetRefVo target);

	// Generated from form domain interface definition
	public ims.pathways.vo.PatientJourneyTargetVoCollection listCurrentPathwayJourneyTargets(ims.pathways.vo.PatientPathwayJourneyRefVo journey, ims.pathways.configuration.vo.PathwayRefVo pathway);
}
