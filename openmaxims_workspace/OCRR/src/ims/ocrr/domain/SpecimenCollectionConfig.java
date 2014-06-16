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

package ims.ocrr.domain;

// Generated from form domain impl
public interface SpecimenCollectionConfig extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Get the cllection of all the public holidays
	*/
	public ims.core.vo.PublicHolidaysVoCollection getPublicHolidays();

	// Generated from form domain interface definition
	/**
	* save a public holiday record
	*/
	public ims.core.vo.PublicHolidaysVo savePublicHolidays(ims.core.vo.PublicHolidaysVo voPublicHolidays) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.ocrr.vo.SpecimenCollectionListConfigVo getSpecimenCollectionConfig(ims.ocrr.vo.lookups.SpecimenCollectionMethod lookUpId);

	// Generated from form domain interface definition
	/**
	* save Specimen Collection Config
	*/
	public ims.ocrr.vo.SpecimenCollectionListConfigVo saveSpecimenCollectionConfig(ims.ocrr.vo.SpecimenCollectionListConfigVo specimenCollectionConfig) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* List the details for a collection method and a dayofWeek (passing date and then calculatiing day of week lookup instance)
	*/
	public ims.ocrr.vo.SpecimenCollectionListConfigDetailsVoCollection listSpecimenCollectionDetails(ims.ocrr.vo.lookups.SpecimenCollectionMethod type, ims.framework.utils.Date date);
}
