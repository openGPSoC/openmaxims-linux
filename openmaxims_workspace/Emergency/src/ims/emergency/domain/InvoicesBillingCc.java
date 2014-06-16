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
public interface InvoicesBillingCc extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.emergency.vo.EmergencyAttendanceBillingVo save(ims.emergency.vo.EmergencyAttendanceBillingVo attendanceBillingToSave) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.emergency.vo.EmergencyAttendanceBillingVo getAttendanceBilling(ims.core.admin.vo.EmergencyAttendanceBillingRefVo attendanceBillingRef);

	// Generated from form domain interface definition
	public ims.admin.vo.EDAttendanceControlsConfigVoCollection getEDAttendanceControlsConfig(ims.admin.vo.lookups.EDAttendenceControlType controlType);

	// Generated from form domain interface definition
	public ims.emergency.vo.EmergencyAttendanceBillingVo getAttendanceBillingByEmergencyAttendance(ims.core.admin.vo.EmergencyAttendanceRefVo emergencyAttendanceRef);

	// Generated from form domain interface definition
	public ims.emergency.vo.AttendanceDetailsVo getAttendanceDetails(ims.core.admin.vo.EmergencyAttendanceRefVo attendanceDetailsRef);
}
