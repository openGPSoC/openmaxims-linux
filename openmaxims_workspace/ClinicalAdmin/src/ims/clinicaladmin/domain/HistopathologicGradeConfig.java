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

package ims.clinicaladmin.domain;

// Generated from form domain impl
public interface HistopathologicGradeConfig extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Lists Histopathological Grade records
	*/
	public ims.clinicaladmin.vo.HistopathologicGradeVoCollection listHistopathologicGrade();

	// Generated from form domain interface definition
	/**
	* Returns Histopathologic Grade record or null if none is found.
	*/
	public ims.clinicaladmin.vo.HistopathologicGradeVo getHistopathologicGrade(ims.oncology.configuration.vo.HistopathologicGradeRefVo histopathologicGrade);

	// Generated from form domain interface definition
	/**
	* Save a Histopathologic Grade record
	*/
	public ims.clinicaladmin.vo.HistopathologicGradeVo saveHistopathologicGrade(ims.clinicaladmin.vo.HistopathologicGradeVo histopathologicGrade) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException, ims.domain.exceptions.UniqueKeyViolationException;
}
