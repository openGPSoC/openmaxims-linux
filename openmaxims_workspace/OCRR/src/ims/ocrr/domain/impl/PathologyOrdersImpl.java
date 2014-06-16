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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.53 build 2641.19803)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.domain.impl;

import ims.careuk.vo.CatsReferralListVo;
import ims.core.clinical.vo.ServiceRefVo;
import ims.core.domain.Reports;
import ims.core.domain.impl.ReportsImpl;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.ServiceLiteVoCollection;
import ims.core.vo.lookups.ServiceCategory;
import ims.framework.interfaces.IAppRole;
import ims.framework.utils.Date;
import ims.framework.utils.Time;
import ims.ocrr.domain.RadiologyOrders;
import ims.ocrr.domain.SelectandOrder;
import ims.ocrr.domain.base.impl.BasePathologyOrdersImpl;
import ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo;
import ims.ocrr.vo.PathologyOrderVoCollection;
import ims.ocrr.vo.RoleDisciplineSecurityLevelLiteGCVo;
import ims.ocrr.vo.domain.PathologyOrderVoAssembler;
import ims.ocrr.vo.lookups.Category;
import ims.ocrr.vo.lookups.OrderInvStatus;

import java.util.ArrayList;
import java.util.List;

public class PathologyOrdersImpl extends BasePathologyOrdersImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* List Location
	*/
	public ims.core.vo.LocationLiteVoCollection listLocation(ims.core.vo.lookups.LocationType type, Boolean active)
	{
		RadiologyOrders impl = (RadiologyOrders) getDomainImpl(RadiologyOrdersImpl.class);
		return impl.listLocation(type, active);		
	}

	
	/**
	* getReportAndTemplate	*/
	public String[] getReportAndTemplate(Integer reportId, Integer templateId) throws ims.domain.exceptions.DomainInterfaceException
	{
		RadiologyOrders impl = (RadiologyOrders) getDomainImpl(RadiologyOrdersImpl.class);
		return impl.getReportAndTemplate(reportId, templateId);		
	}

	/**
	* listAssignedReports
	*/
	public ims.admin.vo.ReportVoCollection listAssignedReports(Integer formId)
	{
		Reports impl = (Reports)getDomainImpl(ReportsImpl.class);
		return impl.listAssignedReports(formId);
	}

	public PathologyOrderVoCollection listOrderInvestigation(ServiceRefVo serviceRefVo, Category category) 
	{
		RadiologyOrders impl = (RadiologyOrders) getDomainImpl(RadiologyOrdersImpl.class);
		return impl.listPathOrderInvestigation(serviceRefVo, category);		
	}

	public ServiceLiteVoCollection listService(LocationRefVo locationRefVo, ServiceCategory serviceCategory) 
	{
		RadiologyOrders impl = (RadiologyOrders) getDomainImpl(RadiologyOrdersImpl.class);
		return impl.listService(locationRefVo, serviceCategory);		
	}

	public RoleDisciplineSecurityLevelLiteGCVo getRoleDisciplineSecurityLevels(IAppRole role)
	{
		SelectandOrder impl = (SelectandOrder)getDomainImpl(SelectandOrderImpl.class);
		return impl.getRoleDisciplineSecurityLevels(role);
	}

	/**
	 * Cats not implemented in this Project
	 */
	public CatsReferralListVo getCatsReferralByOrder(OcsOrderSessionRefVo voOcsOrder)// 	WDEV-16232
	{
		return null;
	}


	//wdev-11986
	// WDEV-12692
	public PathologyOrderVoCollection listPathologyOrderInvestigation(ServiceRefVo serviceRefVo, LocationRefVo locationRefVo, Category category, Date fromDate, Date toDate) 
	{
		List list = listOrderInvestigation(serviceRefVo, locationRefVo, new OrderInvStatus[]{OrderInvStatus.SENT, OrderInvStatus.ACCEPTED, OrderInvStatus.ORDERED}, category, fromDate, toDate);
		return PathologyOrderVoAssembler.createPathologyOrderVoCollectionFromOrderInvestigation(list);
	}
	
	// WDEV-12692
	private List listOrderInvestigation(ServiceRefVo serviceRefVo, LocationRefVo locationRefVo, OrderInvStatus[] orderInvStatus, Category category, Date fromDate, Date toDate)
	{
		StringBuffer query = new StringBuffer("from OrderInvestigation as o1_1");
		String clause = " where";

		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();

		if (orderInvStatus != null && orderInvStatus.length > 0)
		{
			query.append(clause);
			if (orderInvStatus.length == 1)
			{
				query.append(" o1_1.ordInvCurrentStatus.ordInvStatus = " +  orderInvStatus[0].getId());
			}
			else
			{
				query.append(" o1_1.ordInvCurrentStatus.ordInvStatus in ( ");
				String comma = " ";
				for (int i = 0; i < orderInvStatus.length; i++)
				{
					query.append(comma + orderInvStatus[i].getId());
					comma = ", ";					
				}
				query.append(")");
			}
			clause = " and";
		}

		if (serviceRefVo != null)
		{
			query.append(clause);
			String paramName = "SERVICE_ID";
			query.append(" o1_1.investigation.providerService.locationService.service.id = :" + paramName);
			paramNames.add(paramName);
			paramValues.add(serviceRefVo.getID_Service());
			clause = " and";
		}
		
		
		if(locationRefVo != null && category != null)
		{
			query.append(clause);
			String paramName = "LOCATION_ID";
			query.append(" o1_1.investigation.providerService.locationService.location.id = :" + paramName);
			paramNames.add(paramName);
			paramValues.add(locationRefVo.getID_Location());
			clause = " and";
		}

		if (category != null)
		{
			query.append(clause);
			String paramName = "CATEGORY";
			query.append(" o1_1.investigation.investigationIndex.category = :" + paramName);
			paramNames.add(paramName);
			paramValues.add(getDomLookup(category));
			clause = " and";
		}
		
		
		if (fromDate != null)
		{
			query.append(clause);
			String paramName = "FROM_DATE";
			query.append(" o1_1.displayDateTime >= :" + paramName);
			paramNames.add(paramName);
			paramValues.add(fromDate.getDate());
			clause = " and";
		}
		
		
		if (toDate != null)
		{
			query.append(clause);
			String paramName = "TO_DATE";
			query.append(" o1_1.displayDateTime <= :" + paramName);
			paramNames.add(paramName);
			paramValues.add(new ims.framework.utils.DateTime(toDate, new Time(23, 59, 59)).getJavaDate());  //WDEV-11787
			clause = " and";
		}
		

		query.append(" order by o1_1.orderDetails.systemInformation.creationDateTime, o1_1.orderDetails.patient.name.upperSurname asc,  o1_1.orderDetails.patient.name.upperForename asc");

		List list = getDomainFactory().find(query.toString(), paramNames, paramValues);
		return list;
	}
	//----------------
}
