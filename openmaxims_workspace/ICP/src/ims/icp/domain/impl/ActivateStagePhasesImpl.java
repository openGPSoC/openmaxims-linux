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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.icp.domain.impl;

import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.icp.domain.base.impl.BaseActivateStagePhasesImpl;
import ims.icp.vo.PatientICPPhase_DisplayVo;
import ims.icp.vo.PatientICPPhase_DisplayVoCollection;
import ims.icp.vo.PatientICPStage_DisplayVo;
import ims.icp.vo.PatientICPStage_DisplayVoCollection;
import ims.icp.vo.PatientICP_DisplayVo;
import ims.icp.vo.domain.PatientICPPhase_DisplayVoAssembler;
import ims.icp.vo.domain.PatientICPStage_DisplayVoAssembler;
import ims.icp.vo.domain.PatientICP_DisplayVoAssembler;
import ims.icp.vo.lookups.ICPPhaseStatus;
import ims.icp.vo.lookups.ICPStageStatus;
import ims.icps.instantiation.domain.objects.PatientICP;
import ims.icps.instantiation.domain.objects.PatientICPPhase;
import ims.icps.instantiation.domain.objects.PatientICPStage;
import ims.icps.instantiation.vo.PatientICPRefVo;
import ims.vo.ValueObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ActivateStagePhasesImpl extends BaseActivateStagePhasesImpl
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public ims.icp.vo.PatientICP_DisplayVo getPatientICP(ims.icps.instantiation.vo.PatientICPRefVo patientICP)
	{
		// Check parameter
		if (patientICP == null || !patientICP.getID_PatientICPIsNotNull())
			return null;
		
		// Build query
		StringBuilder query = new StringBuilder();
		
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		query.append("SELECT patientICP, stage, phase FROM ");
		query.append(" PatientICP AS patientICP LEFT JOIN FETCH patientICP.iCP LEFT JOIN patientICP.stages AS stage LEFT JOIN stage.stagePhases AS phase ");
		query.append(" LEFT JOIN stage.currentStatus AS stageStatus LEFT JOIN phase.currentStatus AS phaseStatus ");
		
		query.append(" WHERE patientICP.id = :ID AND (stageStatus.status.id = :STAGE_NOT_IN_SCOPE OR phaseStatus.status.id = :PHASE_NOT_IN_SCOPE) ");
		
		paramNames.add("ID"); 					paramValues.add(patientICP.getID_PatientICP());
		paramNames.add("STAGE_NOT_IN_SCOPE");	paramValues.add(ICPStageStatus.NOTINSCOPE.getID());
		paramNames.add("PHASE_NOT_IN_SCOPE");	paramValues.add(ICPPhaseStatus.NOTINSCOPE.getID());
		
		query.append("ORDER BY patientICP.id ASC, stage.id ASC, phase.id ASC");
		
		// Execute query
		List results = getDomainFactory().find(query.toString(), paramNames, paramValues);
		
		// Manually assemble result
		Iterator resultsIterator = results.iterator();

		// Safeguards ID
		Integer patientICP_ID = null;
		Integer stageICP_ID = null;
		Integer phaseICP_ID = null;
		
		// VO's to keep the data
		PatientICP_DisplayVo patientICPDisplay = null;
		PatientICPStage_DisplayVo stageICPDisplay = null;
		PatientICPPhase_DisplayVo phaseICPDisplay = null;
		
		while (resultsIterator.hasNext())
		{
			
			Object[] resultsRow = (Object[]) resultsIterator.next();
			
			// Move to first object in result row - the Patient ICP domain object
			PatientICP domainPatientICP = (PatientICP) resultsRow[0];
			
			if (patientICP_ID == null || !patientICP_ID.equals(domainPatientICP.getId()))
			{
				// Populate database mapped fields
				patientICPDisplay = PatientICP_DisplayVoAssembler.create(domainPatientICP);
				// Create stages collection
				patientICPDisplay.setStages(new PatientICPStage_DisplayVoCollection());
				
				patientICP_ID = patientICPDisplay.getID_PatientICP(); 
			}
			
			// Move to second object in result row - the stage
			if (resultsRow[1] instanceof PatientICPStage)
			{
				// Treat second object in results row as a Patient ICP Stage domain object
				PatientICPStage domainStageICP = (PatientICPStage) resultsRow[1];

				if (stageICP_ID == null || !stageICP_ID.equals(domainStageICP.getId()))
				{
					// Populate database mapped fields
					stageICPDisplay = PatientICPStage_DisplayVoAssembler.create(domainStageICP);
					// Create phases collection
					stageICPDisplay.setPhases(new PatientICPPhase_DisplayVoCollection());

					stageICP_ID = stageICPDisplay.getID_PatientICPStage();
				}

				// If we have data in the Stage value object add it to the patient ICP collection
				if (stageICPDisplay != null)
				{
					patientICPDisplay.getStages().add(stageICPDisplay);
				}
			}
			
			// Move to third object in result row - the phase
			if (resultsRow[2] instanceof PatientICPPhase)
			{
				// Treat second object in results row as a Patient ICP Phase domain object
				PatientICPPhase domainPhaseICP = (PatientICPPhase) resultsRow[2];

				if (phaseICP_ID == null || !phaseICP_ID.equals(domainPhaseICP.getId()))
				{
					// Populate database mapped fields
					phaseICPDisplay = PatientICPPhase_DisplayVoAssembler.create(domainPhaseICP);
					
					if (domainPhaseICP.getPhaseActions().size() > 0)
					{
						phaseICPDisplay.setHasActions(Boolean.TRUE);
					}
					else
					{
						phaseICPDisplay.setHasActions(Boolean.FALSE);
					}
					
					phaseICP_ID = phaseICPDisplay.getID_PatientICPPhase();
				}

				// If we have data in the Phase value object add it to the Phase ICP collection
				if (phaseICPDisplay != null)
				{
					stageICPDisplay.getPhases().add(phaseICPDisplay);
				}
			}
		}
		
		// Return result
		return patientICPDisplay;
	}


	public PatientICPRefVo activateStagesPhases(PatientICPRefVo patientICP, ArrayList<ValueObject> stagesPhases) throws DomainInterfaceException, StaleObjectException
	{
		// Check ICP parameter
		if (patientICP == null || !patientICP.getID_PatientICPIsNotNull())
			throw new DomainRuntimeException("Can not bring into scope stages and phases for null Patient ICP record.");
		
		// Check collection not to be null
		if (stagesPhases == null)
			throw new DomainRuntimeException("No stages or phases selected to be brought into scope.");
		
		// Get DomainFactory reference
		DomainFactory factory = getDomainFactory();
		// Get ICP DomainObject
		PatientICP domainPatientICP = (PatientICP) factory.getDomainObject(PatientICP.class, patientICP.getID_PatientICP());
		
		// Check version for stale
		if (patientICP.getVersion_PatientICP() != domainPatientICP.getVersion())
			throw new StaleObjectException(domainPatientICP);
		
		// Execute bring into scope for collection elements
		for (int i = 0; i < stagesPhases.size(); i++)
		{
			ValueObject value = stagesPhases.get(i);
			
			// Bring stage into scope
			if (value instanceof PatientICPStage_DisplayVo)
			{
				domainPatientICP.bringStageIntoScope(factory, null, ((PatientICPStage_DisplayVo)value).getStage().getID_ICPStage().toString());
			}
			
			// Bring phase into scope
			if (value instanceof PatientICPPhase_DisplayVo)
			{
				domainPatientICP.bringPhaseIntoScope(factory, null, ((PatientICPPhase_DisplayVo)value).getPhase().getID_ICPPhase().toString());
			}
		}
		
		// Commit to database
		factory.save(domainPatientICP);
		
		// Return PatientICPRef to update the Global Context
		patientICP = new PatientICPRefVo(domainPatientICP.getId(), domainPatientICP.getVersion());
		
		return patientICP;
	}
}

































