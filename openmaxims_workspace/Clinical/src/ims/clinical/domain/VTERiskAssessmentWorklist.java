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

package ims.clinical.domain;

// Generated from form domain impl
public interface VTERiskAssessmentWorklist extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.LocSiteLiteVoCollection listHospitals();

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection listWards(ims.core.resource.place.vo.LocationRefVo hospital, String wardName);

	// Generated from form domain interface definition
	public java.util.List<ims.vo.interfaces.IVTERiskAssessment> listPatients(ims.clinical.vo.VTERiskAssessmentWorklistCriteriaVo criteria);

	// Generated from form domain interface definition
	public ims.core.vo.LocSiteLiteVo getCurrentHospital(ims.framework.interfaces.ILocation location);

	// Generated from form domain interface definition
	public ims.clinical.vo.WasVTERiskAssessmentStatusChangedVo wasStatusChanged(ims.vo.interfaces.IVTERiskAssessment episode, ims.clinical.vo.lookups.VTEAsessmentStatus currentStatus);

	// Generated from form domain interface definition
	public ims.vo.interfaces.IVTERiskAssessment saveEpisode(ims.vo.interfaces.IVTERiskAssessment vteRiskAssessment) throws ims.domain.exceptions.StaleObjectException;
}
