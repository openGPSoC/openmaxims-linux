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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.admin.forms.servicemultipleselectdialog;

import ims.admin.forms.locationmultipleselectdialog.GenForm.grdSearchLocationRow;
import ims.admin.forms.servicemultipleselectdialog.GenForm.grdSearchServiceRow;
import ims.admin.forms.servicemultipleselectdialog.GenForm.grdSelectedServicesRow;
import ims.admin.vo.ServiceVoLiteVo;
import ims.admin.vo.ServiceVoLiteVoCollection;
import ims.careuk.vo.ContractConfigShortVo;
import ims.careuk.vo.ContractServiceLocationsConfigVoCollection;
import ims.core.vo.QuestionInformationShortVoCollection;
import ims.core.vo.lookups.ReferralManagementContractType;
import ims.framework.enumerations.DialogResult;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		
		
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException
	{
		ServiceVoLiteVoCollection tempColl = new ServiceVoLiteVoCollection();
		for(int i = 0;i < form.grdSelectedServices().getRows().size();i++)
		{
			if(form.grdSelectedServices().getRows().get(i).getColumnSelect())
				tempColl.add(form.grdSelectedServices().getRows().get(i).getValue());
		}
		if(tempColl.size() < 1)
		{
			engine.showMessage("Select at least one Service");
			return;
		}
		
		form.getGlobalContext().CareUk.setServiceContrat(tempColl);
		engine.close(DialogResult.OK);
		
		
		
	}
	/*private boolean checkIfServiceWasInactivated(ServiceVoLiteVo service,ContractServiceLocationsConfigVoCollection existColl)
	{
		boolean flag = true;
		if(service != null || service.getID_ServiceIsNotNull())
		{
			for(int j = 0; j < existColl.size();j++)
			{
				if(service.getID_Service().equals(existColl.get(j).getService().getID_Service()))
					flag = false;
			}
			if(flag == true)
				return false;
		}
		
		
		flag = true;
	
		if(service != null || service.getID_ServiceIsNotNull())
		{
			
			for(int i = 0; i < existColl.size();i++)
			{
				if(service.getID_Service().equals(existColl.get(i).getService().getID_Service()))
				{	
					if(Boolean.TRUE.equals(existColl.get(i).getIsActive()))
						flag = false;
				}
					
			}
		}
		else
			flag = false;
		
		return flag;
		
		
	}*/
	
	protected void onBtnAddToListClick() throws ims.framework.exceptions.PresentationLogicException
	{
		ServiceVoLiteVoCollection voColl = new ServiceVoLiteVoCollection();
		boolean deleted = true;
		while(deleted)
		{
			
			deleted = false;
			for (int i = 0; i < form.grdSearchService().getRows().size(); i++)
			{
				if(form.grdSearchService().getRows().get(i) == null)
					continue;
				
				if (form.grdSearchService().getRows().get(i).getColumnSelect())
				{
					if(checkIfServiceIsInServiceSelectedGrid(form.grdSearchService().getRows().get(i).getValue()))
					{
						engine.showMessage("The Service "+ form.grdSearchService().getRows().get(i).getValue().getServiceName()+ " is already in Selected Services Grid");
						return;
					}
					voColl.add(form.grdSearchService().getRows().get(i).getValue());
					form.grdSearchService().getRows().remove(i);
					deleted = true;
					break;
					
					
				}
			}
		}
		if(voColl == null || voColl.size() == 0)
		{
			engine.showMessage("Select at least one Service");
			return;
		}
		populateSelectedServiceGrid(voColl);
		

	}
	private boolean checkIfServiceIsInServiceSelectedGrid(ServiceVoLiteVo  service)
	{
		if(service == null)
			return false;
		
		for(int i = 0;i < form.grdSelectedServices().getRows().size();i++)
		{
			ServiceVoLiteVo tempVo = form.grdSelectedServices().getRows().get(i).getValue();
			if(service.getID_ServiceIsNotNull() && service.getID_Service().equals(tempVo.getID_Service()))
				return true;
		}
		return false;
		
	}
	
	protected void onBtnDeselectAllClick() throws ims.framework.exceptions.PresentationLogicException
	{
		selectSearchServices(false);
	}
	
	protected void onBtnSelectAllClick() throws ims.framework.exceptions.PresentationLogicException
	{
		selectSearchServices(true);
	}
	
	protected void onBtnSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.grdSearchService().getRows().clear();
		if(form.txtServiceName().getValue() == null || form.txtServiceName().getValue().length() == 0 || checkCharacter(form.txtServiceName().getValue()))
		{
			engine.showMessage("Please enter a Service Name search string");
			return;
		}
		ServiceVoLiteVoCollection serviceColl = domain.getServices(form.txtServiceName().getValue().trim(), form.cmbServiceCategory().getValue());
		populateSearchServiceGrid(serviceColl);
	}
	private boolean checkCharacter(String name)
	{
		boolean flag = true;
		if(name == null || name.length() == 0)
			return true;
		for(int i = 0;i< name.length();i++)
		{
			if(name.charAt(i) != ' ' )
				flag = false;
		}
		return flag;
	}
	private void populateSearchServiceGrid(ServiceVoLiteVoCollection serviceColl)
	{
		form.grdSearchService().getRows().clear();
		if(serviceColl == null || serviceColl.size() < 1)
			return;
		for(int i = 0; i < serviceColl.size();i++)
		{
			ServiceVoLiteVo record = serviceColl.get(i);
			if (record == null)
				continue;
			grdSearchServiceRow newRow = form.grdSearchService().getRows().newRow();
			newRow.setColumnServiceName(record.getServiceName());
			newRow.setColumnSelect(Boolean.FALSE);
			newRow.setValue(record);
		}
	}
	private void selectSearchServices(boolean select)
	{
		for (int i = 0; i < form.grdSearchService().getRows().size(); i++)
		{
			form.grdSearchService().getRows().get(i).setColumnSelect(select);
		}
	}
	private void populateSelectedServiceGrid(ServiceVoLiteVoCollection serviceColl)
	{
		
		if(serviceColl == null || serviceColl.size() < 1)
			return;
		for(int i = 0; i < serviceColl.size();i++)
		{
			ServiceVoLiteVo record = serviceColl.get(i);
			if (record == null)
				continue;
			grdSelectedServicesRow newRow = form.grdSelectedServices().getRows().newRow();
			newRow.setColumnServiceName(record.getServiceName());
			newRow.setColumnSelect(Boolean.TRUE);
			newRow.setValue(record);
		}
	}

}
