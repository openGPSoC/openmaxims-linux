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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.45 build 2393.21546)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.clinical.configuration.vo.InvasiveDeviceConfigRefVo;
import ims.clinical.domain.objects.PatientInvasiveDevice;
import ims.clinical.domain.objects.VIPScore;
import ims.clinical.vo.PatientInvasiveDeviceRefVo;
import ims.clinical.vo.VIPScoreRefVo;
import ims.clinicaladmin.domain.InvasiveDeviceConfig;
import ims.clinicaladmin.domain.impl.InvasiveDeviceConfigImpl;
import ims.clinicaladmin.vo.InvasiveDeviceConfigVo;
import ims.clinicaladmin.vo.InvasiveDeviceConfigVoCollection;
import ims.clinicaladmin.vo.domain.InvasiveDeviceConfigVoAssembler;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.nursing.domain.base.impl.BaseInvasiveDeviceImpl;
import ims.nursing.vo.PatientInvasiveDeviceShortVoCollection;
import ims.nursing.vo.PatientInvasiveDeviceVipVo;
import ims.nursing.vo.PatientInvasiveDeviceVo;
import ims.nursing.vo.domain.PatientInvasiveDeviceShortVoAssembler;
import ims.nursing.vo.domain.PatientInvasiveDeviceVipVoAssembler;
import ims.nursing.vo.domain.PatientInvasiveDeviceVoAssembler;

public class InvasiveDeviceImpl extends BaseInvasiveDeviceImpl
{
	private static final long serialVersionUID = 1L;
	
	public PatientInvasiveDeviceShortVoCollection listCurrentPatientInvasiveDevice(CareContextRefVo careContext) 
	{
		return PatientInvasiveDeviceShortVoAssembler.createPatientInvasiveDeviceShortVoCollectionFromPatientInvasiveDevice(
				getDomainFactory().find("from PatientInvasiveDevice dsp where dsp.removalDateTime is null and dsp.careContext.id = :CARE_CONTEXT", new String[] {"CARE_CONTEXT"}, new Object[] {careContext.getID_CareContext()}));
	}

	public PatientInvasiveDeviceShortVoCollection listHistoricPatientInvasiveDevice(CareContextRefVo careContext) 
	{
		return PatientInvasiveDeviceShortVoAssembler.createPatientInvasiveDeviceShortVoCollectionFromPatientInvasiveDevice(
				getDomainFactory().find("from PatientInvasiveDevice dsp where dsp.removalDateTime is not null and dsp.careContext.id = :CARE_CONTEXT", new String[] {"CARE_CONTEXT"}, new Object[] {careContext.getID_CareContext()}));
	}
	
	public PatientInvasiveDeviceVo savePatientInvasiveDevice(PatientInvasiveDeviceVo record) throws StaleObjectException  
	{
		if(record == null)
			throw new DomainRuntimeException("Invalid record");
		if(!record.isValidated())
			throw new CodingRuntimeException("Record not validated");
		
		DomainFactory factory = getDomainFactory();
		ims.clinical.domain.objects.PatientInvasiveDevice domainRecord = PatientInvasiveDeviceVoAssembler.extractPatientInvasiveDevice(factory, record);		
	
		factory.save(domainRecord);
		
		return PatientInvasiveDeviceVoAssembler.create(domainRecord);
	}

	public InvasiveDeviceConfigVoCollection listFull() 
	{
		DomainFactory factory = getDomainFactory();
		String hql = "from InvasiveDeviceConfig dsp where dsp.isActive = 1";
		
		return InvasiveDeviceConfigVoAssembler.createInvasiveDeviceConfigVoCollectionFromInvasiveDeviceConfig(factory.find(hql));
	}

	public HcpLiteVoCollection listHcps(String value) {
		HcpAdmin hcpAdmin = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listHcpLiteByName(value);
	}

	public PatientInvasiveDeviceVo getPatientInvasiveDevice(PatientInvasiveDeviceRefVo id)  
	{	
		if(id == null || id.getID_PatientInvasiveDevice() == null)
			throw new DomainRuntimeException("Invalid record");
		
		DomainFactory factory = getDomainFactory();
		PatientInvasiveDevice domainRecord = (PatientInvasiveDevice)factory.getDomainObject(PatientInvasiveDevice.class, id.getID_PatientInvasiveDevice().intValue());
		return PatientInvasiveDeviceVoAssembler.create(domainRecord);
	}

	public PatientInvasiveDeviceVipVo getPatientInvasiveDeviceVip(VIPScoreRefVo id) 
	{
		if(id == null || id.getID_VIPScore() == null)
			throw new DomainRuntimeException("Invalid record");
		
		DomainFactory factory = getDomainFactory();
		VIPScore domainRecord = (VIPScore)factory.getDomainObject(VIPScore.class, id.getID_VIPScore().intValue());
		return PatientInvasiveDeviceVipVoAssembler.create(domainRecord);
	}

	public InvasiveDeviceConfigVo getInvasiveDeviceConfig(InvasiveDeviceConfigRefVo record) 
	{
		InvasiveDeviceConfig impl = (InvasiveDeviceConfig) getDomainImpl(InvasiveDeviceConfigImpl.class);
		return impl.get(record);
	}


}
