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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.22 build 41105.1730)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.supportnetworkservicesdialog;

import ims.core.vo.CareContextShortVo;
import ims.core.vo.CareContextShortVoCollection;
import ims.core.vo.SupportNetworkServicesVo;
import ims.core.vo.SupportNetworkServicesVoCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.utils.DateFormat;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		CareContextShortVoCollection careContextColl = form.getGlobalContext().Core.getSupportNetworkPreviousCareContexts();
		
		
		for (int i=0; i<careContextColl.size(); i++)
		{
			CareContextShortVo vo = careContextColl.get(i);
			if (form.getGlobalContext().Core.getCurrentCareContextIsNotNull() &&
					!form.getGlobalContext().Core.getCurrentCareContext().equals(vo))
			{
				StringBuffer detail = new StringBuffer();
				if (vo.getStartDateTimeIsNotNull())
					detail.append(vo.getStartDateTime().getDate().toString(DateFormat.STANDARD));
				if (vo.getEpisodeOfCare().getResponsibleHCPIsNotNull())
					detail.append(" - " + vo.getEpisodeOfCare().getResponsibleHCP().toString());//WDEV-17267
				form.cmbEpisode().newRow(vo, detail.toString());
			}
		}
	/*	ClinicalContactShortVo voClinicalContactShort = null;
		for(int i = 0 ; i < voColl.size() ; i++)
		{
			voClinicalContactShort = voColl.get(i);
			if (form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
			{
				if(!voClinicalContactShort.equals(form.getGlobalContext().Core.getCurrentClinicalContact()))
				{
					StringBuffer detail = new StringBuffer();
					if (voClinicalContactShort.getStartDateTimeIsNotNull())
						detail.append(voClinicalContactShort.getStartDateTime().getDate().toString(DateFormat.STANDARD) + " - ");
										
					if (voClinicalContactShort.getSeenByIsNotNull())
						detail.append(voClinicalContactShort.getSeenBy().toString());
	
					form.cmbEpisode().newRow(voClinicalContactShort, detail.toString());
				}
			}
		}*/
	}
	
	protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.cmbEpisode().getValues().size() < 1)
		{
			engine.showMessage("No previous episodes to copy from.");
			engine.close(DialogResult.CANCEL);
			return;
		}

		SupportNetworkServicesVoCollection voColl = new SupportNetworkServicesVoCollection();
		if(form.grdServices().getRows() != null)
		{
			GenForm.grdServicesRow row = null;
			for(int i=0;i<form.grdServices().getRows().size();i++)
			{
				row = form.grdServices().getRows().get(i);
				if(row.getSelect() == true)
				{
					voColl.add(row.getValue());
				}
			}	
		}

		if(voColl.size() > 0)
		{
			form.getGlobalContext().COE.setSupportNetworkServiceCollection(voColl);
			engine.close(DialogResult.OK);
		}
		else
			engine.showMessage("Please select at least one service.");		
	}
	protected void onCmbEpisodeValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.grdServices().getRows().clear();
		//09/09/2005 - check for null
		CareContextShortVo voCareContext = form.cmbEpisode().getValue();
		if(voCareContext == null)
			return;
		
		SupportNetworkServicesVoCollection voColl = domain.listSupportNetworkServiceByCareContext(voCareContext, Boolean.TRUE);
		
		SupportNetworkServicesVo voService = null;
		GenForm.grdServicesRow row = null;


		if(voColl == null)
			return;

		for(int i=0;i<voColl.size();i++)
		{
			voService = voColl.get(i);
			row = form.grdServices().getRows().newRow();
			if(voService.getLocationService() != null)
			{
				if(voService.getLocationService().getService() != null)
					row.setServiceType(voService.getLocationService().getService().getServiceName());

				if(voService.getLocationService().getContact() != null)
				{
					row.setPhone(voService.getLocationService().getContact().getContactNumber());
					if(voService.getLocationService().getContact().getName() != null)
					{
						row.setContact(voService.getLocationService().getContact().getName().toString());
					}	
				}
			}
			row.setFrequency(voService.getFrequencyOfService());
			
			row.setSelect(true);
			row.setValue(voService);
		}					
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
}
