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

package ims.core.domain;

// Generated from form domain impl
public interface VitalSignsGCS extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Retrieves a list of GCS's for an Episode and date range
	*/
	public ims.core.vo.VitalSignsVoCollection listGCS(ims.framework.utils.Date dateFrom, ims.framework.utils.Date dateTo, ims.core.admin.vo.CareContextRefVo refCareContext);

	// Generated from form domain interface definition
	/**
	* Save a GCS
	*/
	public ims.core.vo.VitalSignsVo modifyGCS(ims.core.vo.VitalSignsVo vitalSign) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Get a GCS
	*/
	public ims.core.vo.VitalSignsVo getGCS(ims.core.vo.VitalSignsVo vitalSign);

	// Generated from form domain interface definition
	/**
	* Retrieves a list of GCS's for an Episode and specific day
	*/
	public ims.core.vo.VitalSignsVoCollection listGCS(ims.framework.utils.Date dateOneDay, ims.core.admin.vo.CareContextRefVo refCareContext);
}
