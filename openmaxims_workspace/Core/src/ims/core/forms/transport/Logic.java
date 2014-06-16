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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.65 build 3225.30788)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.transport;

import ims.core.forms.transport.GenForm.grdSearchResultsRow;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.scheduling.vo.Booking_AppointmentTransportVo;
import ims.scheduling.vo.Booking_AppointmentTransportVoCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	//----------------------------------------------------------------------------------------------------
	//												Events
	//----------------------------------------------------------------------------------------------------
	
	/**
	 *	This event occurs when the form is entered for the first time
	 *	Do not put code to initialize controls or to provide default data
	 *	to display to the form. Use initialize() and open() functions instead
	 */
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	
	/**
	 *	This event occurs when the form mode is changed
	 */
	@Override
	protected void onFormModeChanged()
	{
		// Update instance controls state
		updateControlsState();
	}

	/**
	 * 
	 */
	@Override
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		// Refresh the screen
		performSearch();
	}
	
	/**
	 *  This event occurs when image button Search is clicked
	 *  If possible, avoid to add code to the event. Use searchAppointments()
	 *  function instead
	 */
	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		performSearch();
	}

	private void performSearch()
	{
		// Validate dates
		if (!validateDates()) // WDEV-15212
			return;

		// Search and list appointments
		listAppointments(form.dteAppoinmentTo().getValue(), form.dteAppoinmentFrom().getValue(), form.chkDisplayBooked().getValue());

		// Update controls state
		updateControlsState();
	}
	
	private boolean validateDates()
	{
		if (form.dteAppoinmentFrom().getValue() != null && form.dteAppoinmentTo().getValue() != null && form.dteAppoinmentFrom().getValue().isGreaterThan(form.dteAppoinmentTo().getValue()))
		{
			engine.showMessage(" Date To should be greater than Date From .", "Warning", MessageButtons.OK, MessageIcon.WARNING);
			return false;
		}
		
		return true;
	}

	/**
	 *	This event occurs when image button Clear is clicked
	 */
	@Override
	protected void onImbClearClick() throws PresentationLogicException
	{
		// Clear instance controls
		clearInstanceControls();
		
		// Update controls state
		updateControlsState();
	}
	
	/**
	 *	This event occurs when selecting a row in results grid
	 *	Remember to always update the controls state after changing grid selection
	 */
	@Override
	protected void onGrdSearchResultsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.grdSearchResults().getSelectedRow()!=null)
			if (form.grdSearchResults().getSelectedRow().getValue()!=null)
				form.getLocalContext().setReportContext(form.grdSearchResults().getSelectedRow().getValue());
		
		form.getGlobalContext().Core.setPatientShort(form.grdSearchResults().getSelectedRow() != null ? domain.getPatient(form.grdSearchResults().getSelectedRow().getValue().getPatient()) : null);
		form.getGlobalContext().Core.setCurrentCareContext(form.grdSearchResults().getSelectedRow() != null ? domain.getCareContext(form.grdSearchResults().getSelectedRow().getValue().getCareContext()): null);

		updateControlsState();
	}
	
	/**
	 *	This event occurs when de selecting a row in results grid
	 *	Remember to always update the controls state after changing grid selection 
	 */
	@Override
	protected void onGrdSearchResultsSelectionCleared() throws ims.framework.exceptions.PresentationLogicException
	{
		// Clear patient and care context global contexts
		form.getGlobalContext().Core.setPatientShort(null);
		form.getGlobalContext().Core.setCurrentCareContext(null);
		
		updateControlsState();
	}
	
	/**
	 *	This event is related to context menu options
	 *	Remember to always update the controls state after using the context menu
	 */
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.CAREUKNamespace.Tansport.Edit:
				editTransportDetails(form.grdSearchResults().getValue());
				break;
		}
		
		// Update controls state
		updateControlsState();
	}
	
	
	//----------------------------------------------------------------------------------------------------
	//										Form Presentation Logic
	//----------------------------------------------------------------------------------------------------

	/**
	 *	Override initialize() function from BaseLogic.java
	 *	In addition, this function will initialize the context menu. 
	 */
	public void initialize() throws FormOpenException
	{
		// Default to current date
		form.dteAppoinmentFrom().setValue(new Date());
		
		// Clear patient and care context selection
		form.getGlobalContext().Core.setPatientShort(null);
		form.getGlobalContext().Core.setCurrentCareContext(null);
		
		// Initialize the context menu
		form.getContextMenus().CAREUK.getTansportEditItem().setEnabled(true);
		form.getContextMenus().CAREUK.getTansportEditItem().setVisible(false);
	}
	
	/**
	 *	This function will call the function to clear the instance controls.
	 *	Doesn't have any default data to be filled in the form controls
	 */
	public void open() throws ims.framework.exceptions.PresentationLogicException
	{
		// Set VIEW mode
		form.setMode(FormMode.VIEW);
	}
	
	/**
	 *	This function will clear the following instance controls:
	 *	Date From, Date To, Grid Search Results
	 */
	public void clearInstanceControls()
	{
		// Clear date controls
		form.dteAppoinmentFrom().setValue(null);
		form.dteAppoinmentTo().setValue(null);
		
		// Clear patient and cancer care global context
		form.getGlobalContext().Core.setPatientShort(null);
		form.getGlobalContext().Core.setCurrentCareContext(null);
		
		form.chkDisplayBooked().setValue(null);
		
		// Clear grid results
		form.grdSearchResults().getRows().clear();
	}
	
	/**
	 *	This function will update the state of instance controls
	 */
	public void updateControlsState()
	{
		// Context menu state update - if need be, extract a local function
		form.getContextMenus().CAREUK.getTansportEditItem().setVisible(form.grdSearchResults().getValue() != null);
	}

	
	//----------------------------------------------------------------------------------------------------
	//									Events functions and additional logic
	//----------------------------------------------------------------------------------------------------


	private void listAppointments(Date endDate, Date startDate, boolean listBookedAppointments)
	{
		try
		{
			// Perform domain search
			Booking_AppointmentTransportVoCollection appointments = domain.listAppoinments(startDate, endDate, listBookedAppointments);
			
			// Show message for no results found
			if (appointments == null || appointments.size() == 0)
			{
				engine.showMessage("No results were found.");
			}
			
			// Show the search results
			setSearchResultsGrid(appointments);
		}
		catch (DomainInterfaceException e)
		{
			// Show errors message for exceptions
			engine.showMessage(e.getMessage(), "Error");
		}
	}
	
	
	/**
	 * 
	 * @param gridSearchResults
	 * @param listAppoinments
	 */
	private void setSearchResultsGrid(Booking_AppointmentTransportVoCollection listAppoinments)
	{
		// Clear the previous results
		form.grdSearchResults().getRows().clear();
		
		// Clear patient and care context global context
		form.getGlobalContext().Core.setPatientShort(null);
		form.getGlobalContext().Core.setCurrentCareContext(null);
		
		// Test the results for null
		if (listAppoinments == null)
			return;
		
		// Add each result to grid
		for (int i = 0; i < listAppoinments.size(); i++)
		{
			Booking_AppointmentTransportVo appointment = listAppoinments.get(i);

			// Skip null results
			if (appointment != null)
			{
				grdSearchResultsRow row = form.grdSearchResults().getRows().newRow();

				// Set up row display
				row.setcolAppointmentDate(appointment.getAppointmentDate());
				row.setcolAppointmentPatient(appointment.getPatient() == null ? "" : appointment.getPatient().getName() == null ? "" : appointment.getPatient().getName().toShortForm());
				row.setcolAppointmentClinic(appointment.getSession() == null ? "" : appointment.getSession().getSchLocation() == null ? "" : appointment.getSession().getSchLocation().getName());
				row.setcolAppointmentStartTime(appointment.getApptStartTime());
				row.setcolAppointmentEndTime(appointment.getApptEndTime());
				
				// Set up row value
				row.setValue(appointment);
			}
		}
	}
	

	/**
	 * 
	 * @param booking_AppointmentTransportVo 
	 */
	private void editTransportDetails(Booking_AppointmentTransportVo appointment)
	{
		if (appointment == null)
			throw new CodingRuntimeException("Illegal Argument - appointment can't be null");
		
		try
		{
			appointment = domain.getTransportBooking(appointment);
			
			// TODO Should test if the appointment was cancelled ?
			
			engine.open(form.getForms().Core.TransportBooking, new Object[] { appointment.getCareContext() });
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage(), "Error");
		}
	}
}
