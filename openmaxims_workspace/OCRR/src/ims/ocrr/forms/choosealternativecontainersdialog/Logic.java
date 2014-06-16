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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.80 build 3995.22787)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.ocrr.forms.choosealternativecontainersdialog;

import ims.configuration.gen.ConfigFlag;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.CodingRuntimeException;
import ims.ocrr.forms.choosealternativecontainersdialog.GenForm.grdItemsRow;
import ims.ocrr.orderingresults.vo.OrderInvestigationRefVo;
import ims.ocrr.orderingresults.vo.OrderInvestigationRefVoCollection;
import ims.ocrr.vo.OrderInvestigationVo;
import ims.ocrr.vo.OrderInvestigationVoCollection;
import ims.ocrr.vo.OrderSpecimenVo;
import ims.ocrr.vo.OrderSpecimenVoCollection;
import ims.ocrr.vo.PathInvDetailsVo;
import ims.ocrr.vo.PathSpecimenContainerDetailVo;
import ims.ocrr.vo.SpecimenContainerVo;
import ims.ocrr.vo.SpecimenVo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;


public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;


	//--------------------------------------------------------------------------------------------------------------------------------------------------
	//	Event handlers region
	//--------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}

	@Override
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		boolean atLeastOneContainerNotSelected = false;
		
		//collect choices made and then repopulate back to the original investigations config and run the container calculation again
		OrderInvestigationVoCollection voCollRewrittenConfig = new OrderInvestigationVoCollection();
		for(int i=0; i<form.grdItems().getRows().size(); i++)
		{
			grdItemsRow row = form.grdItems().getRows().get(i);
			
			for(int p=0;p<row.getRows().size(); p++)
			{
				grdItemsRow cRow = row.getRows().get(p);
				
				OrderInvestigationVo voOrderInv = cRow.getValue(); 
				PathInvDetailsVo pathInvDetails1 = null;
				if(voOrderInv.getInvestigation().getParentInvestigationPathDetailsIsNotNull())
					pathInvDetails1  = voOrderInv.getInvestigation().getParentInvestigationPathDetails();
				else
					pathInvDetails1 = voOrderInv.getInvestigation().getPathInvDetails();
				
				boolean isPaed = isUsePaedContainer();
				if(isPaed)
					voOrderInv.setChosenContainer((SpecimenContainerVo) cRow.getColContainer().getValue());
//					pathInvDetails1.getSpecimens().get(0).getPaediatricContainers().get(0).setSpecContainer((PathSpecimenContainerDetailVo) cRow.getColContainer().getValue());
//				else - There are no more alternative containers to the adult
//					pathInvDetails1.getSpecimens().get(0).getAdultContainers().get(0).setSpecContainer((PathSpecimenContainerDetailVo) cRow.getColContainer().getValue());
				
				//WDEV-11730
				if (cRow.getColContainer().getValue() == null)
				{
					atLeastOneContainerNotSelected = true;
				}
				
				//modifying the config here
				if(voOrderInv.getInvestigation().getParentInvestigationPathDetailsIsNotNull())
					voOrderInv.getInvestigation().setParentInvestigationPathDetails(pathInvDetails1);
				else
					voOrderInv.getInvestigation().setPathInvDetails(pathInvDetails1);
				
				voCollRewrittenConfig.add(voOrderInv);
			}
		}
		
		//WDEV-11730
		if (atLeastOneContainerNotSelected)
		{
			engine.showMessage("Please select Alternative Containers for all Investigations");
			return;
		}
		
		form.getGlobalContext().OCRR.setReWrittenOrderInvestigations(voCollRewrittenConfig);
		engine.close(DialogResult.OK);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}


	//--------------------------------------------------------------------------------------------------------------------------------------------------
	//	Form presentation functions
	//--------------------------------------------------------------------------------------------------------------------------------------------------
	
	private void open()
	{
		OrderSpecimenVoCollection potentialSpecimens = form.getGlobalContext().OCRR.getMyOrderPotentialSpecimens();
		// Sort potential specimens
		potentialSpecimens.sort();
		
		// Build alternative containers hash map
		HashMap<OrderSpecimenVo, HashMap<PathSpecimenContainerDetailVo, OrderInvestigationVoCollection>> alternativeContainers = buildHashMapOfAlternativeContainers(potentialSpecimens);
		
		// Check for alternative options
		if (!choicesAvailable(alternativeContainers))
		{
			engine.close(DialogResult.CANCEL);
			return;
		}
		
		populateSpecimensWithAlternateContainers(potentialSpecimens, alternativeContainers);
	}


	//--------------------------------------------------------------------------------------------------------------------------------------------------
	//	Functions used to populate data to screen
	//--------------------------------------------------------------------------------------------------------------------------------------------------

	private void populateSpecimensWithAlternateContainers(OrderSpecimenVoCollection potentialSpecimens, HashMap<OrderSpecimenVo, HashMap<PathSpecimenContainerDetailVo, OrderInvestigationVoCollection>> alternativeContainers)
	{
		// Clear grid
		form.grdItems().getRows().clear();
		
		if (potentialSpecimens == null)
			return;

		for (OrderSpecimenVo specimen : potentialSpecimens)
		{
			HashMap<PathSpecimenContainerDetailVo, OrderInvestigationVoCollection> specimenAlternateContainers = alternativeContainers.get(specimen);
			
			if (specimenHasOptions(specimenAlternateContainers))
			{
				// Create Specimen parent row
				grdItemsRow specimenRow = form.grdItems().getRows().newRow();

				// Add investigation rows
				float totalRequiredVolume = addInvestigationsWithAlternates(specimen.getInvestigations(), specimenRow, specimenAlternateContainers);

				// Set specimen text
				specimenRow.setColText(getSpecimenDisplayText(specimen, totalRequiredVolume));
				// Expand Specimen parent row
				specimenRow.setExpanded(true);
			}
		}
	}

	
	private float addInvestigationsWithAlternates(OrderInvestigationRefVoCollection investigations, grdItemsRow specimenRow, HashMap<PathSpecimenContainerDetailVo, OrderInvestigationVoCollection> alternativeContainers)
	{
		if (investigations == null || investigations.size() == 0)
			throw new CodingRuntimeException("Logical Error - can't choose alternative containers for specimens without investigations");
		
		float totalRequiedVolume = 0;
		
		for (OrderInvestigationRefVo investigationRef : investigations)
		{
		 	// Upcast - possible error, but done due to performance consideration
			OrderInvestigationVo investigation = (OrderInvestigationVo) investigationRef;

			// Get investigation pathology details
			// Favor parent investigation Pathology Details - this might indicate an add-on investigation
			PathInvDetailsVo pathologyDetails = null;
			if (investigation.getInvestigation().getParentInvestigationPathDetails() != null)
			{
				pathologyDetails = investigation.getInvestigation().getParentInvestigationPathDetails();
			}
			else
			{
				pathologyDetails = investigation.getInvestigation().getPathInvDetails();
			}
			
			
			// Create child row for OrderInvestigationVo
			grdItemsRow investigationRow = specimenRow.getRows().newRow();

			// Set investigation name and value to row
			investigationRow.setColText(getInvestigationDisplayText(investigation, pathologyDetails));
			investigationRow.setValue(investigation);
			
			boolean isPaed = isUsePaedContainer();
			
			if (isPaed)
			{
				// Get specimen from pathology details - implementation only for Simple Investigation
				// Revise code when implementing Complex investigations
				SpecimenVo specimen = pathologyDetails.getSpecimens().get(0);
				// Pediatric container - alternate containers can only be configured for investigations with
				// only one pediatric container; any investigation must contain at least one pediatric container
				SpecimenContainerVo paediatricContainer = specimen.getPaediatricContainers().get(0);
				
				investigationRow.getColContainer().newRow(paediatricContainer, paediatricContainer.getSpecContainer().getName());
				investigationRow.getColContainer().setValue(paediatricContainer);
				
				totalRequiedVolume += pathologyDetails.getSpecimens().get(0).getPaediatricContainers().get(0).getVolume();


				if (specimen.getAlternativePaediatricContainers() != null)
				{
					int addedAlternatives = 0;
					
					for (SpecimenContainerVo alternatePaedContainer : specimen.getAlternativePaediatricContainers())
					{
						OrderInvestigationVoCollection orderInvestigations = alternativeContainers.get(alternatePaedContainer.getSpecContainer());
						
						if (orderInvestigations != null && orderInvestigations.size() > 1 && orderInvestigations.contains(investigation))
						{
							alternatePaedContainer.getSpecContainer().setAlternativeVol(alternatePaedContainer.getVolume());
							investigationRow.getColContainer().newRow(alternatePaedContainer, alternatePaedContainer.getSpecContainer().getName());
							
							addedAlternatives++;
						}
					}
					
					investigationRow.setColContainerReadOnly(addedAlternatives == 0);
				}
			}
		}
		
		return totalRequiedVolume;
	}

	

	//--------------------------------------------------------------------------------------------------------------------------------------------------
	//	Functions auxiliary & logical screen 
	//--------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Build a hash map with OderSpecimen as key, configured SpecimenContainer as secondary key, and OrderInvestigation collection as values
	 * 
	 * Instead of comparing every specimen container from every investigation with every specimen from other investigations, build a hash map with OrderSpecimen primary key,
	 * SpecimenContainer secondary key and add all investigations from an OrderSpecimen that have SpecimenContainer configured. If there are more than one investigation
	 * in the collection, then that SpecimenContainer is common to more than one investigation for the OrderSpecimen  
	 */
	private HashMap<OrderSpecimenVo, HashMap<PathSpecimenContainerDetailVo, OrderInvestigationVoCollection>> buildHashMapOfAlternativeContainers(OrderSpecimenVoCollection myOrderPotentialSpecimens)
	{
		if (myOrderPotentialSpecimens == null || myOrderPotentialSpecimens.size() == 0)
			return null;
		
		HashMap<OrderSpecimenVo, HashMap<PathSpecimenContainerDetailVo, OrderInvestigationVoCollection>> generalAlternativeContainers = new HashMap<OrderSpecimenVo, HashMap<PathSpecimenContainerDetailVo,OrderInvestigationVoCollection>>();
		
		for (OrderSpecimenVo specimen : myOrderPotentialSpecimens)
		{
			HashMap<PathSpecimenContainerDetailVo, OrderInvestigationVoCollection> specimenAlternativeContainers = new HashMap<PathSpecimenContainerDetailVo, OrderInvestigationVoCollection>();
			
			for (int i = 0; i < specimen.getInvestigations().size(); i++)
			{
				OrderInvestigationVo investigation = (OrderInvestigationVo) specimen.getInvestigations().get(i);				// Unsafe upcast due to performance reasons
				PathInvDetailsVo pathologyDetails = null;
				
				if (investigation.getInvestigation().getParentInvestigationPathDetails() != null)
				{
					pathologyDetails = investigation.getInvestigation().getParentInvestigationPathDetails();
				}
				else
				{
					pathologyDetails = investigation.getInvestigation().getPathInvDetails();
				}
				
				SpecimenVo specimenVo = pathologyDetails.getSpecimens().get(0);
				
				PathSpecimenContainerDetailVo pediatricContainer = specimenVo.getPaediatricContainers().get(0).getSpecContainer();
				addSpecimenInvestigationToMap(specimenAlternativeContainers, investigation, pediatricContainer);
				
				for (SpecimenContainerVo containers : specimenVo.getAlternativePaediatricContainers())
				{
					addSpecimenInvestigationToMap(specimenAlternativeContainers, investigation, containers.getSpecContainer());
				}
			}
			
			generalAlternativeContainers.put(specimen, specimenAlternativeContainers);
		}
		
		return generalAlternativeContainers;
	}

	private void addSpecimenInvestigationToMap(HashMap<PathSpecimenContainerDetailVo, OrderInvestigationVoCollection> specimenAlternativeContainers, OrderInvestigationVo investigation, PathSpecimenContainerDetailVo pediatricContainer)
	{
		OrderInvestigationVoCollection investigations = specimenAlternativeContainers.get(pediatricContainer);
		
		if (investigations != null)
		{
			investigations.add(investigation);
		}
		else
		{
			investigations = new OrderInvestigationVoCollection();
			investigations.add(investigation);
			specimenAlternativeContainers.put(pediatricContainer, investigations);
		}
	}

	
	private String getInvestigationDisplayText(OrderInvestigationVo investigation, PathInvDetailsVo pathologyDetails)
	{
		if (investigation == null || pathologyDetails == null)
			throw new CodingRuntimeException("Logical error - parameters can't be null");
		
		StringBuilder displayString = new StringBuilder();
		
		displayString.append(investigation.getInvestigation().getInvestigationIndex().getName());
		displayString.append(" - ");
		displayString.append(pathologyDetails.getSpecimens().get(0).getPaediatricContainers().get(0).getSpecContainer().getName());
		displayString.append(" (").append(pathologyDetails.getSpecimens().get(0).getPaediatricContainers().get(0).getVolume());
		displayString.append(" mls)");

		return displayString.toString();
	}

	private String getSpecimenDisplayText(OrderSpecimenVo specimen, float totalRequiredVolume)
	{
		// If the specimen doesn't have any investigations then display nothing
		if (specimen == null || specimen.getInvestigations() == null || specimen.getInvestigations().size() == 0)
			return "";
		
		StringBuilder displayText = new StringBuilder();
		
		// Get the first investigation
		OrderInvestigationVo firstInvestigation = (OrderInvestigationVo) specimen.getInvestigations().get(0);
		// Display the service name from first investigation
		displayText.append(firstInvestigation.getInvestigation().getProviderService().getLocationService().getService().getServiceName());
		// Display specimen type
		displayText.append(" (").append(firstInvestigation.getInvestigation().getPathInvDetails().getSpecimens().get(0).getType().getText()).append(") ");
		
		if (specimen.getSiteCd() != null)
		{
			displayText.append(specimen.getSiteCd().getText());
		}
		
		displayText.append(" - ").append(String.valueOf(totalRequiredVolume)).append(" mls");

		return displayText.toString();
	}


	private boolean choicesAvailable(HashMap<OrderSpecimenVo, HashMap<PathSpecimenContainerDetailVo, OrderInvestigationVoCollection>> alternativeContainers)
	{
		Collection<HashMap<PathSpecimenContainerDetailVo, OrderInvestigationVoCollection>> specimenMaps = alternativeContainers.values();
		
		for (HashMap<PathSpecimenContainerDetailVo, OrderInvestigationVoCollection> specimenMap : specimenMaps)
		{
			if (specimenHasOptions(specimenMap))
				return true;
		}

		return false;
	}
	
	private boolean specimenHasOptions(HashMap<PathSpecimenContainerDetailVo, OrderInvestigationVoCollection> specimenAlternateContainers)
	{
		Set<PathSpecimenContainerDetailVo> keys = specimenAlternateContainers.keySet();
		
		for (PathSpecimenContainerDetailVo specimenContainer : keys)
		{
			OrderInvestigationVoCollection values = specimenAlternateContainers.get(specimenContainer);
			
			if (values != null && values.size() > 1)
			{
				for (OrderInvestigationVo investigation : values)
				{
					PathInvDetailsVo pathologyDetails = null;
					
					if (investigation.getInvestigation().getParentInvestigationPathDetails() != null)
					{
						pathologyDetails = investigation.getInvestigation().getParentInvestigationPathDetails();
					}
					else
					{
						pathologyDetails = investigation.getInvestigation().getPathInvDetails();
					}
					
					SpecimenVo specimenVo = pathologyDetails.getSpecimens().get(0);
					
					if (specimenVo.getAlternativePaediatricContainers() != null)
					{
						for (SpecimenContainerVo container : specimenVo.getAlternativePaediatricContainers())
						{
							if (container.getSpecContainer().equals(specimenContainer))
								return true;
						}
					}
				}
			}
		}

		return false;
	}


	private boolean isUsePaedContainer()
	{
		int cfgAge = ConfigFlag.GEN.PAEDIATRIC_AGE.getValue();
		int patAge = -1;

		Integer iAge = form.getGlobalContext().Core.getPatientShort().calculateAge();
		if (iAge != null)
			patAge = form.getGlobalContext().Core.getPatientShort().calculateAge().intValue();

		if (patAge > cfgAge || patAge == -1)
			return false;

		return true;
	}
}
