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

package ims.clinical.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseClinicalCodingImpl extends DomainImpl implements ims.clinical.domain.ClinicalCoding, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistConfiguredProblemsShort(String pcName, Boolean isActive)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHotlistProblemsShort(String pcName, ims.core.vo.lookups.Specialty specialty)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHotlistProcedureShort(String procedureName, ims.core.vo.lookups.Specialty specialty)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistProcLiteVo(String filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistDiagnosisLiteVo(String filter)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHotListDiagnosis(String name, ims.core.vo.lookups.Specialty specialty)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistAllergens(String voAllergen)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistMedications(String filterMedication)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveProcedureVo(ims.core.vo.ProcedureVo voProcedureVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveDiagnosisVo(ims.core.vo.DiagnosisVo voDiagnosisVo)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveConfigVo(ims.clinical.vo.ProblemConfigVo voPatientConfig)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveConfigVo(ims.core.vo.MedicationVo voMedicationConfig)
	{
	}

	@SuppressWarnings("unused")
	public void validategetDiagnosisByName(String strDiagnosisName)
	{
	}

	@SuppressWarnings("unused")
	public void validategetMedicationByName(String strName)
	{
	}

	@SuppressWarnings("unused")
	public void validategetProcedureByName(String strName)
	{
	}

	@SuppressWarnings("unused")
	public void validategetProblemByName(String strName)
	{
	}

	@SuppressWarnings("unused")
	public void validategetAllergenByName(String strName)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveAllergenVo(ims.core.vo.AllergenVo voAllergen)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveCancerImagingEventVo(ims.core.vo.CancerImagingEventVo voImagingEvent)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHotlistImagingEventsLite(String name, ims.core.vo.lookups.Specialty specialty)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistImagingEventsLite(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validategetImagingEventByName(String name)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistHotlistMedication(String name, ims.core.vo.lookups.Specialty specialty)
	{
	}
}
