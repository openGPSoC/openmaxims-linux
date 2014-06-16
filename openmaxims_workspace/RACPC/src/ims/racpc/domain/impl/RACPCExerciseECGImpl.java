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
// This code was generated by Peter Martin using IMS Development Environment (version 1.71 build 3729.19612)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.racpc.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.clinical.vo.RACPExerciseECGVo;
import ims.clinical.vo.RACPExerciseECGVoCollection;
import ims.clinical.vo.domain.RACPExerciseECGVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.clinical.domain.objects.RACPExerciseECG;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.vo.VitalSignsVo;
import ims.racpc.domain.RACPCPMHExam;
import ims.racpc.domain.RACPCSummary;
import ims.racpc.domain.base.impl.BaseRACPCExerciseECGImpl;

public class RACPCExerciseECGImpl extends BaseRACPCExerciseECGImpl
{	
	private static final long serialVersionUID = 1L;

	public ims.clinical.vo.RACPExerciseECGVo getRACPExerciseECGForrefCareContext(CareContextRefVo refCareContextRefVo)
	{
		if (refCareContextRefVo == null)
			throw new CodingRuntimeException("Cannot get RACPMedicationVo for null ClinicalContactRefVo");
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" from RACPExerciseECG ecg where "); 
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		hql.append(" ecg.careContext.id = :ccId");
		markers.add("ccId");
		values.add(refCareContextRefVo.getID_CareContext());

		List listRACPExerciseECG = factory.find(hql.toString(), markers,values);
		if(listRACPExerciseECG != null && listRACPExerciseECG.size() > 0)
		{ 
			RACPExerciseECGVoCollection voColl = RACPExerciseECGVoAssembler.createRACPExerciseECGVoCollectionFromRACPExerciseECG(listRACPExerciseECG);
			if(voColl != null && voColl.size() > 0)
				return voColl.get(0);
		}
		return null;
	}

	public ims.clinical.vo.RACPExerciseECGVo saveRACPExerciseECGVo(ims.clinical.vo.RACPExerciseECGVo voRACPExerciseECG) throws ims.domain.exceptions.StaleObjectException, UniqueKeyViolationException
	{
		if (voRACPExerciseECG == null  || !voRACPExerciseECG.isValidated())
			throw new CodingRuntimeException("Medication is null or has not been validated");
		
		DomainFactory factory=getDomainFactory();
		
		if(voRACPExerciseECG.getID_RACPExerciseECG() == null)
		{
			if(voRACPExerciseECG.getCareContextIsNotNull())
			{
				RACPExerciseECGVo vo = getRACPExerciseECGForrefCareContext(voRACPExerciseECG.getCareContext());
				if(vo != null)
					throw new UniqueKeyViolationException("An Exercise ECG record already exists for this Care Context. ");
			}
		}
		
		RACPExerciseECG doRACPExerciseECG = RACPExerciseECGVoAssembler.extractRACPExerciseECG(factory, voRACPExerciseECG);
		factory.save(doRACPExerciseECG);
		return RACPExerciseECGVoAssembler.create(doRACPExerciseECG);
	}

	public VitalSignsVo getVitalSignsForCareContext(CareContextRefVo refVoCareContext) {
		RACPCPMHExam impl = (RACPCPMHExam)getDomainImpl(RACPCPMHExamImpl.class);
		return impl.getVitalSignsForCareContext(refVoCareContext);
	}

	//WDEV-13437
	public Boolean isRACPCSummaryComplete(CareContextRefVo careContext) 
	{
		RACPCSummary impl = (RACPCSummary)getDomainImpl(RACPCSummaryImpl.class);
		return impl.isRACPCSummaryComplete(careContext);
	}
}
