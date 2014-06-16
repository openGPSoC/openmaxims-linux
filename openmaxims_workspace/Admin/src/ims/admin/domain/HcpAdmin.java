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

package ims.admin.domain;

// Generated from form domain impl
public interface HcpAdmin extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Creates a new HCP or updates if it already exists
	*/
	public ims.core.vo.Hcp saveHCP(ims.core.vo.Hcp hcp) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* List HCP's based on filter HCP passed in
	*/
	public ims.core.vo.HcpCollection listHCPs(ims.core.vo.HcpFilter hcpFilter);

	// Generated from form domain interface definition
	/**
	* Gets a local HCP using the PAS code
	*/
	public ims.core.vo.Hcp getHcpByPasId(String hcpPasCode);

	// Generated from form domain interface definition
	/**
	* Retrieves a list of (PAS) Hcps where thelocal code field is not null
	*/
	public ims.core.vo.HcpCollection listExternalHcps(ims.core.vo.HcpFilter filter);

	// Generated from form domain interface definition
	/**
	* List's Medics only based on search criteria
	*/
	public ims.core.vo.HcpCollection listMedics(ims.core.vo.HcpFilter filter);

	// Generated from form domain interface definition
	/**
	* list Hcps by a HcpFilter and then a subtype(e.g) MedicType - The class will be detemined by the hcptype populated in the HcpFilter
	*/
	public ims.core.vo.HcpCollection listHcps(ims.core.vo.HcpFilter filter, ims.core.vo.lookups.HcpDisType subType);

	// Generated from form domain interface definition
	public ims.core.vo.Hcp getHcp(ims.core.vo.HcpFilter filter);

	// Generated from form domain interface definition
	/**
	* getMedicByNationalCode
	*/
	public ims.core.vo.MedicVo getMedicByNationalCode(String natCode);

	// Generated from form domain interface definition
	/**
	* listActiveMedics
	*/
	public ims.core.vo.MedicLiteVoCollection listActiveMedics(String strMedicName);

	// Generated from form domain interface definition
	public ims.core.vo.MedicWithLocationsVoCollection listMedicsForLocation(ims.core.resource.place.vo.LocationRefVo location);

	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVoCollection listHcpLiteByName(String hcpName);

	// Generated from form domain interface definition
	public ims.core.vo.MedicWithMappingsLiteVo getMedicMedicMappingsByExternalCode(ims.core.vo.lookups.TaxonomyType taxType, String codeVal);

	// Generated from form domain interface definition
	public ims.core.vo.MedicWithMappingsLiteVo getMedicMedicMappingsByPasCode(String pasCode);

	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVoCollection listHcpLiteByNameAndDisciplineType(String hcpName, ims.core.vo.lookups.HcpDisType hcpDisciplineType);

	// Generated from form domain interface definition
	/**
	* list HcpLite By Discipline
	*/
	public ims.core.vo.HcpLiteVoCollection listHcpLiteByDisciplineType(ims.core.vo.lookups.HcpDisType hcpDisciplineType);

	// Generated from form domain interface definition
	/**
	* This method gets the medic based on the external type and code
	*/
	public ims.core.vo.MedicLiteVo getMedicLiteByExternalCode(ims.core.vo.lookups.TaxonomyType externalType, String externalCode);

	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVoCollection listHcpLite(ims.core.vo.HcpFilter filter);

	// Generated from form domain interface definition
	public ims.core.vo.Hcp getHcpByExternalCode(ims.core.vo.lookups.TaxonomyType taxType, String codeVal);

	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVo getHcpLiteByExternalCode(ims.core.vo.lookups.TaxonomyType taxType, String codeVal);

	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVo getHcpLite(ims.core.vo.HcpFilter filter);

	// Generated from form domain interface definition
	/**
	* listHcpLiteByName (with max specifier)
	*/
	public ims.core.vo.HcpLiteVoCollection listHcpLiteByName(String hcpName, Integer max);

	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVoCollection listResponsibleMedics(ims.core.vo.HcpFilter hcpFilter);

	// Generated from form domain interface definition
	public ims.core.vo.MedicWithLocationsVoCollection listMedicsForLocation(ims.core.resource.place.vo.LocationRefVo location, ims.ntpf.vo.lookups.CaseType caseType);

	// Generated from form domain interface definition
	public ims.core.vo.MedicWithLocationsVoCollection listReferringMedicsForLocation(ims.core.resource.place.vo.LocationRefVo location);
}
