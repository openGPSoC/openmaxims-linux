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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.45 build 2266.23405)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.domain.impl;

import ims.admin.vo.ReportVoCollection;
import ims.core.clinical.domain.objects.PatientNotification;
import ims.core.clinical.domain.objects.PatientOCSNewResults;
import ims.core.clinical.domain.objects.PatientOCSSeenResults;
import ims.core.domain.Reports;
import ims.core.domain.impl.ReportsImpl;
import ims.core.patient.domain.objects.Patient;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.resource.people.domain.objects.MemberOfStaff;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.PatientClericalTaskVo;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.MemberOfStaffLiteVoAssembler;
import ims.core.vo.domain.PatientClericalTaskVoAssembler;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.lookups.LookupInstance;
import ims.framework.exceptions.CodingRuntimeException;
import ims.ocrr.domain.RadiologyOrders;
import ims.ocrr.domain.base.impl.BaseResultDialogImpl;
import ims.ocrr.orderingresults.domain.objects.AllocatedResultReviewDetail;
import ims.ocrr.orderingresults.domain.objects.OrderInvestigation;
import ims.ocrr.orderingresults.domain.objects.OrderSpecimen;
import ims.ocrr.orderingresults.domain.objects.OrderedInvestigationStatus;
import ims.ocrr.orderingresults.vo.OrderInvestigationRefVo;
import ims.ocrr.vo.ClinicalImagingResultVo;
import ims.ocrr.vo.ClinicalResultVo;
import ims.ocrr.vo.NewResultOcsOrderVo;
import ims.ocrr.vo.NewResultOcsOrderVoCollection;
import ims.ocrr.vo.NewResultSpecDocVo;
import ims.ocrr.vo.OcsPathRadResultVo;
import ims.ocrr.vo.OrderInvestigationVo;
import ims.ocrr.vo.OrderInvestigationVoCollection;
import ims.ocrr.vo.PathologySpecimenVo;
import ims.ocrr.vo.domain.ClinicalImagingResultVoAssembler;
import ims.ocrr.vo.domain.ClinicalResultVoAssembler;
import ims.ocrr.vo.domain.NewResultOcsOrderVoAssembler;
import ims.ocrr.vo.domain.NewResultSpecDocVoAssembler;
import ims.ocrr.vo.domain.OrderInvestigationVoAssembler;
import ims.ocrr.vo.domain.PathologySpecimenVoAssembler;
import ims.ocrr.vo.lookups.OrderInvStatus;
import ims.ocrr.vo.lookups.ResultStatus;
import ims.vo.LookupInstVo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PathologyDialogImpl extends BaseResultDialogImpl
{
	private static final long serialVersionUID = 1L;

	public ims.ocrr.vo.PathologySpecimenVo getSpecimen(ims.ocrr.orderingresults.vo.OrderSpecimenRefVo id)
	{
		if(id == null || id.getID_OrderSpecimen() == null)
			throw new DomainRuntimeException("Invalid specimen");
		
		return PathologySpecimenVoAssembler.create((OrderSpecimen)getDomainFactory().getDomainObject(OrderSpecimen.class, id.getID_OrderSpecimen()));		
	}
	/**
	 * wdev-11555(non-Javadoc)
	 * Rewritten in WDEV-13321
	 */
	@SuppressWarnings("unchecked")
	public OrderInvestigationVo updatePathologyResultStatus(OrderInvestigationRefVo ordInvRef, LookupInstVo newStatus, HcpRefVo hcp)  throws StaleObjectException
	{
		if(ordInvRef == null)
			throw new DomainRuntimeException("Specimen must be specified to update status.");
		
		if(newStatus == null)
			throw new DomainRuntimeException("New Status value must be provided in order to update specimen viewing status.");
		
		DomainFactory factory = getDomainFactory();
		OrderInvestigation domOrdInv = (OrderInvestigation)factory.getDomainObject(OrderInvestigation.class, ordInvRef.getID_OrderInvestigation());
		if (domOrdInv.getVersion() != ordInvRef.getVersion_OrderInvestigation())
			throw new StaleObjectException(domOrdInv, "Data has been updated by another user");
		OrderSpecimen domSpec = (OrderSpecimen) domOrdInv.getSpecimen().get(0);
		if (domSpec == null)
			throw new DomainRuntimeException("Specimen for this Pathology OrderInvestigation cannot be null");
		
		Hcp domHcp = null;
		
		// WDEV-14196
		if (hcp != null)
		{
			domHcp = (Hcp) factory.getDomainObject(Hcp.class, hcp.getID_Hcp());
		}

		MemberOfStaff mos = null;
		
		HcpLiteVo hcpUser = (HcpLiteVo) getHcpLiteUser();
		
		Hcp domHcpUser = HcpLiteVoAssembler.extractHcp(factory, hcpUser);
		
		// WDEV-14196
		if (domHcpUser != null)
		{
			mos = MemberOfStaffLiteVoAssembler.extractMemberOfStaff(factory, hcpUser.getMos());
		}
			
		@SuppressWarnings("rawtypes")
		Iterator iter = domSpec.getInvestigations().iterator();
		while (iter.hasNext())
		{
			OrderInvestigation ordInv = (OrderInvestigation)iter.next();
			OrderedInvestigationStatus currStatus = ordInv.getOrdInvCurrentStatus();
			
			if (OrderInvStatus.REVIEW.equals(newStatus))
			{
				// Set Allocated HCP for Review field
				ordInv.setAllocatedHCPforReview(domHcp);
				ordInv.setAllocatedDateForReview(new java.util.Date());
				ordInv.setResultSortDate(new java.util.Date()); //http://jira/browse/WDEV-18025
				ordInv.setForReview(Boolean.TRUE);
				if (mos != null && mos.getName() != null)
					domOrdInv.setReviewRequestedBy(mos.getName().toString().length() > 50 ? mos.getName().toString().substring(0, 50) : mos.getName().toString());
				else
					domOrdInv.setReviewRequestedBy(null);

				
				// Create an history entry
				AllocatedResultReviewDetail historyAllocatedRecord = new AllocatedResultReviewDetail();
				historyAllocatedRecord.setAllocatedHCPforReview(domHcp);
				historyAllocatedRecord.setAllocatedForReviewBy(mos);
				historyAllocatedRecord.setAllocatedOn(new java.util.Date());
				// Add entry to history
				ordInv.getAllocatedForReviewHistory().add(historyAllocatedRecord);
			}
			
			if (OrderInvStatus.SEEN.equals(newStatus) || OrderInvStatus.CHECKED.equals(newStatus))
			{
				if (ordInv.getAllocatedHCPforReview() != null && ordInv.getAllocatedHCPforReview().equals(domHcpUser))
				{
					ordInv.setForReview(Boolean.FALSE);
					ordInv.setReviewRequestedBy(null);
					ordInv.setAllocatedHCPforReview(null);
					ordInv.setAllocatedDateForReview(null);
					ordInv.setResultSortDate(ordInv.getRepDateTime()); //http://jira/browse/WDEV-18025
				}
			}
			
			// WDEV-13685
			// Update status if it is the case
			if (!(isPreResultStatus(currStatus.getOrdInvStatus()) && isViewingStatus(getDomLookup(newStatus))))
			{
				if (!getDomLookup(OrderInvStatus.REVIEW).equals(currStatus.getOrdInvStatus())
						&& !getDomLookup(OrderInvStatus.CHECKED).equals(currStatus.getOrdInvStatus())
						&& !getDomLookup(OrderInvStatus.SEEN).equals(currStatus.getOrdInvStatus()))
				{
	    			// Get Patient OCS Notification
					Patient patient = (Patient) factory.getDomainObject(Patient.class, domOrdInv.getOrderDetails().getPatient().getId());
	    			PatientNotification notification = patient.getOCSNotification();
	    			
	    			if (notification == null)
	    			{
	    				notification = new PatientNotification();
	    				patient.setOCSNotification(notification);
	    				notification.setPatient(domOrdInv.getOrderDetails().getPatient());
	    			}
	    			
	    			if (notification.getNewResults() == null)
	    			{
	    				PatientOCSNewResults newResults = new PatientOCSNewResults();
	    				newResults.setPatient(domOrdInv.getOrderDetails().getPatient());
	    				newResults.setNewCount(0);
	    				notification.setNewResults(newResults);
	    			}
	    			
	    			if (notification.getSeenResults() == null)
	    			{
	    				PatientOCSSeenResults seenResults = new PatientOCSSeenResults();
	    				seenResults.setPatient(domOrdInv.getOrderDetails().getPatient());
	    				seenResults.setSeenCount(0);
	    				notification.setSeenResults(seenResults);
	    			}
	    			
	    			notification.incrementSeenResults();
	    			
	    			factory.save(patient);
				}

				ordInv.getOrdInvStatusHistory().add(currStatus);
				currStatus.setOrdInvStatus(getDomLookup(newStatus));
				currStatus.setChangeDateTime(new java.util.Date());
				currStatus.setProcessedDateTime(new java.util.Date());
				currStatus.setChangeUser(this.getSession().getUser().getUserRealName());
				currStatus.setStatusReason("Status changed by user.");
			}
		}		

		factory.save(domSpec);

		return OrderInvestigationVoAssembler.create(domOrdInv); //wdev-11555
	}

	private boolean isPreResultStatus(LookupInstance ordInvStatus)
	{
		int statusId = ordInvStatus.getId();		
		if (statusId == OrderInvStatus.AWAITING_AUTHORISATION.getId() ||
			statusId == OrderInvStatus.ORDERED.getId() ||
			statusId == OrderInvStatus.SENT.getId() ||
			statusId == OrderInvStatus.RECEIVED.getId() ||
			statusId == OrderInvStatus.REJECTED.getId() ||
			statusId == OrderInvStatus.ACCEPTED.getId() ||
			statusId == OrderInvStatus.CANCEL_REQUEST.getId() ||
			statusId == OrderInvStatus.CANCELLED.getId() ||
			statusId == OrderInvStatus.COMPLETE.getId() ||
			statusId == OrderInvStatus.INPROGRESS.getId() ||
			statusId == OrderInvStatus.INPROGRESS_SCH.getId())
		{
			return true;			
		}
		else
		{
			return false;
		}
	}

	private boolean isViewingStatus(LookupInstance newStatus)
	{
		int statusId = newStatus.getId();		
		if (statusId == OrderInvStatus.REVIEW.getId() ||
			statusId == OrderInvStatus.UNSEEN.getId() ||
			statusId == OrderInvStatus.CHECKED.getId() ||
			statusId == OrderInvStatus.SEEN.getId())
		{
			return true;			
		}
		else
		{
			return false;
		}
	}

	public PathologySpecimenVo getSpecimen(OrderInvestigationRefVo orvInvRef)
	{
		if(orvInvRef == null || orvInvRef.getID_OrderInvestigation() == null)
			throw new DomainRuntimeException("Invalid orderInvestigation");
		
		DomainFactory factory = getDomainFactory();
		OrderInvestigation domOrdInv = (OrderInvestigation)factory.getDomainObject(OrderInvestigation.class, orvInvRef.getID_OrderInvestigation());
		if (domOrdInv == null || domOrdInv.getSpecimen() == null || domOrdInv.getSpecimen().size() == 0)//WDEV-16463
			return null;
		
		return PathologySpecimenVoAssembler.create((OrderSpecimen) domOrdInv.getSpecimen().get(0));		
	}

	public ClinicalImagingResultVo getClinicalImagingResult(OrderInvestigationRefVo resultId)
	{
		if(resultId == null || resultId.getID_OrderInvestigation() == null)
			throw new DomainRuntimeException("Invalid OrderInvestigation id");
		
		return ClinicalImagingResultVoAssembler.create((OrderInvestigation)getDomainFactory().getDomainObject(OrderInvestigation.class, resultId.getID_OrderInvestigation()));		
	}
	/**
	 * wdev-11555
	 * Rewritten in WDEV-13321
	 */
	@SuppressWarnings("unchecked")
	public OrderInvestigationVo updateRadResultStatus(OrderInvestigationRefVo orderInv, LookupInstVo newStatus, HcpRefVo hcp) throws StaleObjectException
	{
		if(orderInv == null)
			throw new DomainRuntimeException("Investigation must be specified to update status.");
		
		if(newStatus == null)
			throw new DomainRuntimeException("New Status value must be provided in order to update specimen viewing status.");
		
		DomainFactory factory = getDomainFactory();
		OrderInvestigation domOrdInv = (OrderInvestigation)factory.getDomainObject(OrderInvestigation.class, orderInv.getID_OrderInvestigation());
		if (domOrdInv.getVersion() != orderInv.getVersion_OrderInvestigation())
			throw new StaleObjectException(domOrdInv, "Data has been updated by another user");
		
		OrderedInvestigationStatus currStatus = domOrdInv.getOrdInvCurrentStatus();
		
		// WDEV-14196
		Hcp domHcp = null;
		if (hcp != null)
		{
			domHcp = (Hcp) factory.getDomainObject(Hcp.class, hcp.getID_Hcp());
		}

		MemberOfStaff mos = null;
		HcpLiteVo hcpUser = (HcpLiteVo) getHcpLiteUser();
		
		Hcp domHcpUser = HcpLiteVoAssembler.extractHcp(factory, hcpUser);
		
		if (domHcpUser != null)
		{
			mos = MemberOfStaffLiteVoAssembler.extractMemberOfStaff(factory, hcpUser.getMos());
		}
		else
		{
			mos = (MemberOfStaff) getMosUser();
		}
		

		if (OrderInvStatus.REVIEW.equals(newStatus))
		{
			// Set Allocated HCP for Review field
			domOrdInv.setAllocatedHCPforReview(domHcp);
			domOrdInv.setAllocatedDateForReview(new java.util.Date());
			domOrdInv.setResultSortDate(new java.util.Date()); //http://jira/browse/WDEV-18025
			domOrdInv.setForReview(Boolean.TRUE);
			if (mos != null && mos.getName() != null)
				domOrdInv.setReviewRequestedBy(mos.getName().toString().length() > 50 ? mos.getName().toString().substring(0, 50) : mos.getName().toString());
			else
				domOrdInv.setReviewRequestedBy(null);
			
			// Create an history entry
			AllocatedResultReviewDetail historyAllocatedRecord = new AllocatedResultReviewDetail();
			historyAllocatedRecord.setAllocatedHCPforReview(domHcp);
			historyAllocatedRecord.setAllocatedForReviewBy(mos);
			historyAllocatedRecord.setAllocatedOn(new java.util.Date());
			
			// Add entry to history
			domOrdInv.getAllocatedForReviewHistory().add(historyAllocatedRecord);
			
			
		}
		
		
		if (OrderInvStatus.SEEN.equals(newStatus) || OrderInvStatus.CHECKED.equals(newStatus))
		{
			if (domOrdInv.getAllocatedHCPforReview() != null && domOrdInv.getAllocatedHCPforReview().equals(domHcpUser))
			{
				domOrdInv.setForReview(Boolean.FALSE);
				domOrdInv.setReviewRequestedBy(null);
				domOrdInv.setAllocatedHCPforReview(null);
				domOrdInv.setAllocatedDateForReview(null);
				domOrdInv.setResultSortDate(domOrdInv.getRepDateTime());//http://jira/browse/WDEV-18025
			}
		}
		

		// WDEV-13685
		// Update the status if it is the case
		if (!(isPreResultStatus(currStatus.getOrdInvStatus()) && isViewingStatus(getDomLookup(newStatus))))
		{
			if (!getDomLookup(OrderInvStatus.REVIEW).equals(currStatus.getOrdInvStatus())
					&& !getDomLookup(OrderInvStatus.CHECKED).equals(currStatus.getOrdInvStatus())
					&& !getDomLookup(OrderInvStatus.SEEN).equals(currStatus.getOrdInvStatus()))
			{
    			// Get Patient OCS Notification
				Patient patient = (Patient) factory.getDomainObject(Patient.class, domOrdInv.getOrderDetails().getPatient().getId());
    			PatientNotification notification = patient.getOCSNotification();
    			
    			if (notification == null)
    			{
    				notification = new PatientNotification();
    				notification.setPatient(domOrdInv.getOrderDetails().getPatient());
    				patient.setOCSNotification(notification);
    			}
    			
    			if (notification.getNewResults() == null)
    			{
    				PatientOCSNewResults newResults = new PatientOCSNewResults();
    				newResults.setPatient(domOrdInv.getOrderDetails().getPatient());
    				newResults.setNewCount(0);
    				notification.setNewResults(newResults);
    			}
    			
    			if (notification.getSeenResults() == null)
    			{
    				PatientOCSSeenResults seenResults = new PatientOCSSeenResults();
    				seenResults.setPatient(domOrdInv.getOrderDetails().getPatient());
    				seenResults.setSeenCount(0);
    				notification.setSeenResults(seenResults);
    			}
    			
    			notification.incrementSeenResults();
    			
    			factory.save(patient);
			}

			domOrdInv.getOrdInvStatusHistory().add(currStatus);
    		currStatus.setOrdInvStatus(getDomLookup(newStatus));
    		currStatus.setChangeDateTime(new java.util.Date());
    		currStatus.setProcessedDateTime(new java.util.Date());
    		currStatus.setChangeUser(this.getSession().getUser().getUserRealName());
    		currStatus.setStatusReason("Status changed by user.");
		}
		
		factory.save(domOrdInv);

		return OrderInvestigationVoAssembler.create(domOrdInv);	//wdev-11555
	}

	/**
	 * WDEV-13321
	 * Function used to reset the Allocated for review HCP
	 */
	public OrderInvestigationVo resetAllocatedReviewHCP(OrderInvestigationRefVo investigation) throws StaleObjectException
	{
		if (investigation == null || !investigation.getID_OrderInvestigationIsNotNull())
			return null;
		
		DomainFactory factory = getDomainFactory();
		
		OrderInvestigation domOrdInv = (OrderInvestigation) factory.getDomainObject(OrderInvestigation.class, investigation.getID_OrderInvestigation());
		
		
		if (domOrdInv == null)
			return null;
		
		if (domOrdInv.getAllocatedHCPforReview() == null)
			return OrderInvestigationVoAssembler.create(domOrdInv);
		
		HcpLiteVo hcpUser = (HcpLiteVo) getHcpLiteUser();
		ims.core.resource.people.domain.objects.Hcp domHcpUser = HcpLiteVoAssembler.extractHcp(factory, hcpUser);
 
		if (domOrdInv.getAllocatedHCPforReview().equals(domHcpUser))
		{
			domOrdInv.setAllocatedHCPforReview(null);
			domOrdInv.setAllocatedDateForReview(null);
			domOrdInv.setResultSortDate(domOrdInv.getRepDateTime());//http://jira/browse/WDEV-18025
			domOrdInv.setForReview(null);							// WDEV-18052
			domOrdInv.setReviewRequestedBy(null);					// WDEV-18052
		}
		
		return OrderInvestigationVoAssembler.create(domOrdInv);
	}


	public ReportVoCollection listAssignedReports(Integer formId)
	{
		Reports impl = (Reports)getDomainImpl(ReportsImpl.class);
		return impl.listAssignedReports(formId);
	}

	public String[] getReportAndTemplate(Integer reportId, Integer templateId) throws DomainInterfaceException
	{
		RadiologyOrders impl = (RadiologyOrders) getDomainImpl(RadiologyOrdersImpl.class);
		return impl.getReportAndTemplate(reportId, templateId);		
	}

	public String[] getSystemReportAndTemplate(Integer imsId)
	{
		String[] result = null;
		
		DomainFactory factory = getDomainFactory();
		
		List<?> lst = factory.find("select r1_1.reportXml, t1_1.templateXml, r1_1.reportName, r1_1.reportDescription, t1_1.name, t1_1.description from ReportBo as r1_1 left join r1_1.templates as t1_1 where (r1_1.imsId= :imsid) order by t1_1.name", new String[] {"imsid"}, new Object[] {imsId});
		
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
			
			result = new String[] {(String)obj[0], (String)obj[1], (String)obj[2], (String)obj[3], (String)obj[4], (String)obj[5]};
		}
		
		return result;
	}

	public NewResultSpecDocVo getOrderInvestigation(OrderInvestigationRefVo refOrderInvestigation) {
		if(refOrderInvestigation == null || refOrderInvestigation.getID_OrderInvestigation() == null)
			throw new DomainRuntimeException("Invalid orderInvestigation");
		
		DomainFactory factory = getDomainFactory();
		OrderInvestigation domOrdInv = (OrderInvestigation)factory.getDomainObject(OrderInvestigation.class, refOrderInvestigation.getID_OrderInvestigation());
		if (domOrdInv == null)
			return null;		
		return NewResultSpecDocVoAssembler.create(domOrdInv);
	}

	
	public NewResultOcsOrderVo getNewResultOcsOrderVo(OrderInvestigationRefVo resultId) 
	{
		if(resultId == null || resultId.getID_OrderInvestigation() == null)
			throw new DomainRuntimeException("Invalid OrderInvestigation id");
		if(resultId != null)
		{
			DomainFactory factory = getDomainFactory();
			StringBuffer hql = new StringBuffer(" select o2_1 from OrderInvestigation as o1_1 left join o1_1.orderDetails as o2_1 where  "); 
			String andStr = " ";
		
			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
		
			hql.append(andStr + " o1_1.id  = :OrderInvId");
 			markers.add("OrderInvId");
			values.add(resultId.getID_OrderInvestigation());
			andStr = " and ";	

			List<?> list = factory.find(hql.toString(), markers,values);
			if(list != null && list.size() > 0)
			{ 
				NewResultOcsOrderVoCollection voColl = NewResultOcsOrderVoAssembler.createNewResultOcsOrderVoCollectionFromOcsOrderSession(list);// 	WDEV-16232
				if(voColl != null && voColl.size() > 0)
					return voColl.get(0);
			}
		}
		return null;
	}

	public String getCentricityPacsAccessionNumber(OrderInvestigationRefVo voOrderInvRefVo) 
	{
		if(voOrderInvRefVo == null || voOrderInvRefVo.getID_OrderInvestigation() == null)
			throw new DomainRuntimeException("Invalid OrderInvestigation id");
		
		if(voOrderInvRefVo != null)
		{
			DomainFactory factory = getDomainFactory();
			StringBuffer hql = new StringBuffer(" select o1_1 from OrderInvestigation as o1_1 where  "); 
			String andStr = " ";
		
			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Serializable> values = new ArrayList<Serializable>();
		
			hql.append(andStr + " o1_1.id  = :OrderInvId");
 			markers.add("OrderInvId");
			values.add(voOrderInvRefVo.getID_OrderInvestigation());
			andStr = " and ";	

			List<?> list = factory.find(hql.toString(), markers,values);
			if(list != null && list.size() > 0)
			{ 
				OrderInvestigationVoCollection voColl = OrderInvestigationVoAssembler.createOrderInvestigationVoCollectionFromOrderInvestigation(list);
				if(voColl != null && voColl.size() > 0)
					return voColl.get(0).getAccessionNumber();
			}
		}
		return null;
	}

	public OcsPathRadResultVo addViewedToStatusHistory(OcsPathRadResultVo voPathRadResult) throws StaleObjectException
	{
		if (voPathRadResult == null)
			throw new CodingRuntimeException("voPathRadResult cannot be null in method addViewedToStatusHistory");
		
		DomainFactory factory = getDomainFactory();
		OrderInvestigation domOrdInv = (OrderInvestigation)factory.getDomainObject(voPathRadResult.getOrderInvestigation());
		if (domOrdInv.getVersion() != voPathRadResult.getOrderInvestigation().getVersion_OrderInvestigation())
			throw new StaleObjectException(domOrdInv, "Data has been updated by another user");
		
		OrderSpecimen domSpec = (domOrdInv!=null && domOrdInv.getSpecimen()!=null && domOrdInv.getSpecimen().size()>0 ? (OrderSpecimen) domOrdInv.getSpecimen().get(0):null); //WDEV-16361
		
		//only pathology will have specimens
		if(domSpec != null)
		{
			@SuppressWarnings("rawtypes")
			Iterator iter = domSpec.getInvestigations().iterator();
			while (iter.hasNext())
			{
				OrderInvestigation ordInv = (OrderInvestigation)iter.next();		
				ordInv = addViewedStatus(ordInv);
			}		
			factory.save(domSpec);		
		}
		else
		{
			domOrdInv = addViewedStatus(domOrdInv);
			factory.save(domOrdInv);	
		}
		
		voPathRadResult.setOrderInvestigation(new OrderInvestigationRefVo (domOrdInv.getId(), domOrdInv.getVersion()));
		
		return voPathRadResult;
	}

	@SuppressWarnings("unchecked")
	private OrderInvestigation addViewedStatus(OrderInvestigation ordInv)
	{
		OrderedInvestigationStatus doStatus = new OrderedInvestigationStatus();
		
		doStatus.setOrdInvStatus(getDomLookup(OrderInvStatus.VIEWED));
		doStatus.setChangeDateTime(new java.util.Date());
		doStatus.setProcessedDateTime(new java.util.Date());
		if(this.getSession().getUser() != null)
			doStatus.setChangeUser(this.getSession().getUser().getUserRealName());
		
		doStatus.setStatusReason("Status changed by user.");			
		
		ordInv.getOrdInvStatusHistory().add(doStatus);
		
		return ordInv;
	}

	//	WDEV-13190
	public Boolean wasSecondaryMatching(OrderInvestigationRefVo orderInvestigation) 
	{
		if(orderInvestigation == null || orderInvestigation.getID_OrderInvestigation() == null)
			throw new CodingRuntimeException("Can not get wasSecondaryMatching value on null OrderInvestigation.");
		
		String query = "select oi.wasSecondaryMatchingUsed from OrderInvestigation as oi where oi.id = :orderId";
		
		DomainFactory factory = getDomainFactory();
		List<?> wasSecondaryMatching = factory.find(query, new String[] {"orderId"}, new Object[] {orderInvestigation.getID_OrderInvestigation()});
		
		if(wasSecondaryMatching != null && wasSecondaryMatching.size() == 1)
		{
			return Boolean.TRUE.equals(wasSecondaryMatching.get(0));
		}
		
		return false;
	}

	//WDEV-13879
	public PatientClericalTaskVo getPatientClericalTask(OrderInvestigationRefVo resultSelected) 
	{
		if(resultSelected == null || resultSelected.getID_OrderInvestigation() == null)
			throw new CodingRuntimeException("Can not get ResultSelected value on null Id.");
		
		StringBuffer hql = new StringBuffer();
		hql.append("select patClericalTask from PatientClericalTask as patClericalTask left join patClericalTask.investigation as orderInvestigation ");
		hql.append("where orderInvestigation.id = :orderId ");
		hql.append("order by patClericalTask.requestedDateTime desc");
		
		DomainFactory factory = getDomainFactory();
		List<?> list = factory.find(hql.toString(), new String[] {"orderId"}, new Object[] {resultSelected.getID_OrderInvestigation()});
		
		if (list!=null && list.size()>0)
		{
			return PatientClericalTaskVoAssembler.createPatientClericalTaskVoCollectionFromPatientClericalTask(list).get(0);
		}
		return null;
		
	}
	
	//WDEV-15783
	public String getMappingForResultStatusLookup(ResultStatus resultStatusInstance, TaxonomyType extSystem) 
	{
		if(resultStatusInstance == null || extSystem == null || extSystem.getText() == null)
			return null;
		
		String query = "select lm.extCode from LookupInstance as li left join li.mappings as lm where (li.id = :ResultStatusId and lm.extSystem = :TaxonomyType) ";
		
		List<?> list = getDomainFactory().find(query, new String[] {"ResultStatusId", "TaxonomyType"}, new Object[] {resultStatusInstance.getID(), extSystem.getText()});
		
		if(list != null && list.size() > 0)
		{
			if(list.get(0) instanceof String)
				return (String) list.get(0);
		}
		
		return null;
	}
	
	// 	WDEV-15894
	public OcsPathRadResultVo refreshCurrentPathRadResult(OcsPathRadResultVo currentPathRadResult) 
	{
		if (currentPathRadResult == null || currentPathRadResult.getOrderInvestigation() == null)
			throw new CodingRuntimeException("voPathRadResult cannot be null ");
		
		DomainFactory factory = getDomainFactory();
		OrderInvestigation domOrdInv = (OrderInvestigation)factory.getDomainObject(currentPathRadResult.getOrderInvestigation());
		
		currentPathRadResult.setOrderInvestigation(new OrderInvestigationRefVo (domOrdInv.getId(), domOrdInv.getVersion()));
		return currentPathRadResult;
	}
	
	//WDEV-16361
	public ClinicalResultVo getClinicalResult(OrderInvestigationRefVo resultId)
	{
		if(resultId == null || resultId.getID_OrderInvestigation() == null)
			throw new DomainRuntimeException("Invalid OrderInvestigation id");
		
		return ClinicalResultVoAssembler.create((OrderInvestigation)getDomainFactory().getDomainObject(OrderInvestigation.class, resultId.getID_OrderInvestigation()));
	}
}
