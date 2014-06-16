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

package ims.emergency.domain;

// Generated from form domain impl
public interface QuickRegistration extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public void save(ims.core.vo.PatientLiteVo patient, ims.core.vo.CareSpellVo careSpell, ims.emergency.vo.EmergencyEpisodeForQuickRegistrationVo emergencyEpisode, ims.emergency.vo.TrackingForQuickRegistrationVo tracking, ims.core.vo.CareContextVo careContext, ims.emergency.vo.EmergencyAttendanceForQuickRegistrationVo emergencyAttendanceToSave) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.LocSiteShortVo getTypeOfLocSite(ims.core.resource.place.vo.LocationRefVo locRef);

	// Generated from form domain interface definition
	public ims.core.vo.PatientLiteVo getPatient(ims.core.patient.vo.PatientRefVo patientRef);

	// Generated from form domain interface definition
	public Boolean checkIsAlreadyAdmitted(Integer patientId);
}
