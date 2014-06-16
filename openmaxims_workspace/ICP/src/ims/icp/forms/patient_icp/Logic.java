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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4091.21781)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.icp.forms.patient_icp;

import ims.framework.LayerBridge;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.icp.forms.patient_icp.GenForm.lyrMainLayer.tabActionDetailsContainer;
import ims.icp.forms.patient_icp.GenForm.lyrMainLayer.tabLinkedActionsContainer;
import ims.icp.vo.PatientICPAction_PresentationVo;
import ims.icp.vo.PatientICPAction_PresentationVoCollection;
import ims.icp.vo.Patient_ICP_LiteVo;
import ims.icp.vo.enums.PresentationActionDetails;
import ims.icp.vo.enums.PresentationEvent;


public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	//---------------------------------------------------------------------------------------------------------------
	//	Events handlers region
	//---------------------------------------------------------------------------------------------------------------
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		// Initialise form data
		initialize();
		// Refresh screen
		open();
	}

	@Override
	protected void onFormModeChanged()
	{
		// Update controls state
		updateControlsState();
	}
	
	@Override
	protected void onLnkReturnClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Open previous form
		engine.open(engine.getPreviousNonDialogFormName());
	}

	@Override
	protected void onlyrMainTabChanged(LayerBridge tab)
	{
		boolean isICPCompleted = form.getLocalContext().getICP() == null || form.getLocalContext().getICP().getCompletedDateTime() != null;
		
		if (tab instanceof tabActionDetailsContainer)
		{
			form.lyrMain().tabActionDetails().ccActionDetails().setValue(form.getLocalContext().getSelectedAction(), !isICPCompleted);
		}
		if (tab instanceof tabLinkedActionsContainer)
		{
			form.lyrMain().tabLinkedActions().ccLinkedActionsDetails().setValue(form.lyrMain().tabLinkedActions().recbrLinkedActions().getValue(), !isICPCompleted);
		}
	}


	@Override
	protected void onCcICPValueChanged() throws PresentationLogicException
	{
		// Get event type
		PresentationEvent eventType = form.lyrMain().tabICP().ccICP().getEvent();
		
		// Treat event depending on type
		if (PresentationEvent.ACTION_DETAILS_VIEW.equals(eventType)
			|| PresentationEvent.SELECTION_CHANGED.equals(eventType))
		{
			PatientICPAction_PresentationVo action = form.lyrMain().tabICP().ccICP().getSelectedAction();
			form.getLocalContext().setSelectedAction(action);

			populateActionDetails(action);
			
			if (PresentationEvent.ACTION_DETAILS_VIEW.equals(eventType))
				form.lyrMain().showtabActionDetails();
		}
		
		updateControlsState();
		
		form.lyrMain().tabICP().ccICP().clearEvent();
	}


	@Override
	protected void onRecbrLinkedActionsValueChanged() throws PresentationLogicException
	{
		boolean isICPCompleted = form.getLocalContext().getICP() == null || form.getLocalContext().getICP().getCompletedDateTime() != null;
		
		form.lyrMain().tabLinkedActions().ccLinkedActionsDetails().setValue(form.lyrMain().tabLinkedActions().recbrLinkedActions().getValue(), !isICPCompleted);
	}

	
	
	//---------------------------------------------------------------------------------------------------------------
	//	Form presentation functions
	//---------------------------------------------------------------------------------------------------------------

	/**
	 *	Function used to initialize the screen
	 */
	public void initialize() throws FormOpenException
	{
		// Initialize custom components
		form.lyrMain().tabICP().ccICP().initialize();
		
		// Set ICP Component to not open Action Details in dialog, but to send an event
		form.lyrMain().tabICP().ccICP().setActionDetailsHandlingMode(PresentationActionDetails.TRIGGER_EVENT);
	}

	/**
	 *	Function used to refresh the screen
	 */
	public void open() throws ims.framework.exceptions.PresentationLogicException
	{
		// Get Patient ICP from domain
		form.getLocalContext().setICP(domain.getPatientICP(form.getGlobalContext().ICP.getPatientICPRecord()));
		
		// Populate Patient ICP to screen
		populateInstanceControls(form.getLocalContext().getICP());
		
		// Set form to VIEW mode
		form.setMode(FormMode.VIEW);
	}
	
	public void updateControlsState()
	{
		form.lyrMain().tabActionDetails().setHeaderVisible(form.getLocalContext().getSelectedAction() != null);
		form.lyrMain().tabLinkedActions().setHeaderVisible(form.getLocalContext().getSelectedAction() != null && Boolean.TRUE.equals(form.getLocalContext().getSelectedAction().getAction().getHasLinkedActions()));
	}


	//---------------------------------------------------------------------------------------------------------------
	//	Data exchange functions
	//---------------------------------------------------------------------------------------------------------------

	/**
	 *	Function used to populate Patient ICP to screen
	 */
	private void populateInstanceControls(Patient_ICP_LiteVo patientICP)
	{
		form.lyrMain().tabICP().setCaption("Stages / Phases / Actions - " + patientICP.getICP().getName());
		
		form.lyrMain().tabICP().ccICP().setValue(patientICP);
	}

	
	private void populateActionDetails(PatientICPAction_PresentationVo action)
	{
		if (action == null)
		{
			form.lyrMain().tabActionDetails().ccActionDetails().setValue(null);
			form.lyrMain().tabLinkedActions().recbrLinkedActions().clear();
			form.lyrMain().tabLinkedActions().ccLinkedActionsDetails().setValue(null);
			
			return;
		}
		
		boolean isICPCompleted = form.getLocalContext().getICP() == null || form.getLocalContext().getICP().getCompletedDateTime() != null; 

		// Set action details value
		form.lyrMain().tabActionDetails().ccActionDetails().setValue(action, !isICPCompleted);
		
		// Set linked details value
		populateLinkedActionsRecordBrowser(action);
	}

	
	/**
	 * Function used to populate the Linked Actions tab
	 */
	private void populateLinkedActionsRecordBrowser(PatientICPAction_PresentationVo action)
	{
		// Clear record browser
		form.lyrMain().tabLinkedActions().recbrLinkedActions().clear();
		
		if (action == null)
		{
			form.lyrMain().tabLinkedActions().ccLinkedActionsDetails().setValue(null);
			return;
		}
		
		// Get linked actions from domain
		PatientICPAction_PresentationVoCollection linkedActions = domain.getLinkedPatientICPActions(action);
		
		// If there are no linked actions then set the value and terminate function
		if (linkedActions == null || linkedActions.size() == 0)
		{
			action.getAction().setHasLinkedActions(Boolean.FALSE);
			return;
		}
		
		action.getAction().setHasLinkedActions(Boolean.TRUE);
		
		// Populate linked actions record browser		
		for (PatientICPAction_PresentationVo linkedAction : linkedActions)
		{
			form.lyrMain().tabLinkedActions().recbrLinkedActions().newRow(linkedAction, linkedAction.getAction().getName());
		}

		form.lyrMain().tabLinkedActions().recbrLinkedActions().setValue(linkedActions.get(0));
	}
}
