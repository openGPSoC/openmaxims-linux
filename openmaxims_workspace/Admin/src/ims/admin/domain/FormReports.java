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
public interface FormReports extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* List all reports in the system
	*/
	public ims.admin.vo.ReportVoCollection listReports();

	// Generated from form domain interface definition
	/**
	* List reports assigned to a Form
	*/
	public ims.admin.vo.ReportVoCollection listAssignedReports(Integer formId);

	// Generated from form domain interface definition
	/**
	* Saves the collection of reports associated with a form
	*/
	public Integer saveAssignedReports(Integer formId, ims.admin.vo.FormReportVoCollection formRepColl) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException;

	// Generated from form domain interface definition
	public ims.admin.vo.ReportSeedVoCollection getReportSeeds(ims.admin.vo.ReportVo reportVo);

	// Generated from form domain interface definition
	/**
	* Lists all forms for the given name
	*/
	public ims.admin.vo.AppFormVoCollection listFormsByName(String formName);

	// Generated from form domain interface definition
	/**
	* searchCategory by name
	*/
	public ims.admin.vo.ReportsCategoryLiteVoCollection searchCategoryByName(String categoryName);

	// Generated from form domain interface definition
	/**
	* List all the Reports that are active
	*/
	public ims.admin.vo.ReportVoCollection searchReports(String reportName, String templateName, ims.core.admin.vo.ReportsCategoryRefVo categoryRef);

	// Generated from form domain interface definition
	/**
	* list the categories
	*/
	public ims.admin.vo.ReportsCategoryListVoCollection searchCategories(String reportName, String templateName, ims.core.admin.vo.ReportsCategoryRefVo categoryRef);
}
