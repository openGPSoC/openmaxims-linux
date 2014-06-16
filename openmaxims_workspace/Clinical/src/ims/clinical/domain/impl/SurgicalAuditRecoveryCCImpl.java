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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4535.14223)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.base.impl.BaseSurgicalAuditRecoveryCCImpl;
import ims.clinical.domain.objects.SurgicalAuditOperationDetail;
import ims.clinical.domain.objects.SurgicalAuditRecovery;
import ims.clinical.helper.IESurgicalAuditHelper;
import ims.clinical.helper.SurgicalAuditHelper;
import ims.clinical.vo.SurgicalAuditOperationDetailRefVo;
import ims.clinical.vo.SurgicalAuditOperationDetailVo;
import ims.clinical.vo.SurgicalAuditRecoveryVo;
import ims.clinical.vo.domain.SurgicalAuditOperationDetailVoAssembler;
import ims.clinical.vo.domain.SurgicalAuditRecoveryVoAssembler;
import ims.core.resource.place.vo.LocSiteRefVo;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;

public class SurgicalAuditRecoveryCCImpl extends BaseSurgicalAuditRecoveryCCImpl
{

	private static final long serialVersionUID = 1L;

	public LocationLiteVoCollection listActiveLocationsAtTheSameLevelWithLocation(LocationRefVo locationRef)
	{
		IESurgicalAuditHelper impl = (IESurgicalAuditHelper)getDomainImpl(SurgicalAuditHelper.class);
		return impl.listActiveLocationsAtTheSameLevelWithLocation(locationRef);	
	}

	public LocationLiteVoCollection listLocationsByParentLocation(LocationRefVo locationRef)
	{
		IESurgicalAuditHelper impl = (IESurgicalAuditHelper)getDomainImpl(SurgicalAuditHelper.class);
		return impl.listLocationsByParentLocation(locationRef);
	}

	public SurgicalAuditOperationDetailVo save(SurgicalAuditOperationDetailVo surgicalAuditDetailToSave) throws StaleObjectException, UniqueKeyViolationException
	{
		IESurgicalAuditHelper impl = (IESurgicalAuditHelper)getDomainImpl(SurgicalAuditHelper.class);
		return impl.saveSurgicalAuditOperationDetail(surgicalAuditDetailToSave);
	}

	public SurgicalAuditOperationDetailVo getSurgicalAuditOperationDetail(SurgicalAuditOperationDetailRefVo surgicalAuditOpRef)
	{
		IESurgicalAuditHelper impl = (IESurgicalAuditHelper)getDomainImpl(SurgicalAuditHelper.class);
		return impl.getSurgicalAuditOperationDetail(surgicalAuditOpRef);
	}

	public Boolean isStale(SurgicalAuditOperationDetailVo surgAudit)
	{
		IESurgicalAuditHelper impl = (IESurgicalAuditHelper)getDomainImpl(SurgicalAuditHelper.class);
		return impl.isStale(surgAudit);	
	}

	public LocationLiteVo getLocationLiteVo(LocSiteRefVo locSiteRef)
	{
		IESurgicalAuditHelper impl = (IESurgicalAuditHelper)getDomainImpl(SurgicalAuditHelper.class);
		return impl.getLocationLiteVo(locSiteRef);
	}

	public Boolean isStaleSurgicalAuditRecovery(SurgicalAuditRecoveryVo surgAuditRecoveryToSave)
	{
		if (surgAuditRecoveryToSave == null || surgAuditRecoveryToSave.getID_SurgicalAuditRecovery() == null)
		{
			throw new CodingRuntimeException("Cannot get SurgicalAuditRecoveryVo on null Id ");
		}
				
		DomainFactory factory = getDomainFactory();
		 SurgicalAuditRecovery domainSurgAuditRecovery = (SurgicalAuditRecovery) factory.getDomainObject(SurgicalAuditOperationDetail.class, surgAuditRecoveryToSave.getID_SurgicalAuditRecovery());
		
		if(domainSurgAuditRecovery==null)
		{
			return true;
		}
		
		if (domainSurgAuditRecovery.getVersion() > surgAuditRecoveryToSave.getVersion_SurgicalAuditRecovery())
		{
			return true;
		}
		
		return false;
	}

	public SurgicalAuditRecoveryVo saveSurgicalAuditRecovery(SurgicalAuditRecoveryVo surgicalAuditRecoveryToSave) throws StaleObjectException
	{
		if (surgicalAuditRecoveryToSave == null )
		{
			throw new CodingRuntimeException("Cannot get SurgicalAuditRecoveryVo on null Id ");
		}

		DomainFactory factory = getDomainFactory();
		
		SurgicalAuditRecovery domainSurgicalAuditRecovery = SurgicalAuditRecoveryVoAssembler.extractSurgicalAuditRecovery(factory, surgicalAuditRecoveryToSave);
		factory.save(domainSurgicalAuditRecovery);
		return SurgicalAuditRecoveryVoAssembler.create(domainSurgicalAuditRecovery);
	}

}
