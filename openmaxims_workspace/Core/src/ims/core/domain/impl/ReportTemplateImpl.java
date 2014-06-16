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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.62 build 2980.18138)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.domain.impl;

import ims.admin.vo.ReportListVoCollection;
import ims.admin.vo.ReportsCategoryListVoCollection;
import ims.admin.vo.ReportsCategoryLiteVoCollection;
import ims.core.admin.vo.ReportsCategoryRefVo;
import ims.core.domain.ReportRunner;
import ims.core.domain.base.impl.BaseReportTemplateImpl;

public class ReportTemplateImpl extends BaseReportTemplateImpl
{
	private static final long serialVersionUID = 1L;

	/**
	* List all the Reports that are active
	*/
	public ims.admin.vo.ReportListVoCollection listReports()
	{
		ReportRunner impl = (ReportRunner)getDomainImpl(ReportRunnerImpl.class);
		
		return impl.listReports();
	}

	/**
	* list the categories
	*/
	public ims.admin.vo.ReportsCategoryListVoCollection listCategories()
	{
		ReportRunner impl = (ReportRunner)getDomainImpl(ReportRunnerImpl.class);
		
		return impl.listCategories();
	}

	public ReportsCategoryListVoCollection searchCategories(String reportName, String templateName, ReportsCategoryRefVo categoryRef)
	{
		ReportRunner impl = (ReportRunner)getDomainImpl(ReportRunnerImpl.class);
		
		return impl.searchCategories(reportName, templateName, categoryRef);
	}

	public ReportsCategoryLiteVoCollection searchCategoryByName(String categoryName)
	{
		ReportRunner impl = (ReportRunner)getDomainImpl(ReportRunnerImpl.class);
		return impl.searchCategoryByName(categoryName);
	}

	public ReportListVoCollection searchReports(String reportName, String templateName, ReportsCategoryRefVo categoryRef)
	{
		ReportRunner impl = (ReportRunner)getDomainImpl(ReportRunnerImpl.class);
		return impl.searchReports(reportName, templateName, categoryRef);
	}
}
