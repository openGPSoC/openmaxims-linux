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

package ims.core.forms.authoringinfosingleline;

import ims.framework.enumerations.FormMode;

public interface IComponent
{
	public void setMode(FormMode mode);
	public FormMode getMode();
	/**
	* Sets the default values to controls:
	* 1. Authoring HCP = (Hcp) domain.getHcpUser() 
	* 2. Authoring Date/Time = new DateTime()
	*/
	public void initializeComponent();

	/**
	* If 'ignoreClinicalContact=true' sets the default values to controls:
	* 1. Authoring HCP = (Hcp) domain.getHcpUser() 
	* 2. Authoring Date/Time = new DateTime()
	* Else just calls initializeComponent()
	*/
	public void initializeComponent(Boolean ignoreClinicalContact);

	/**
	* Sets the default values to controls and the discipline type used for searching HCP
	* 1. Authoring HCP = (Hcp) domain.getHcpUser() 
	* 2. Authoring Date/Time = new DateTime()
	*/
	public void initializeComponent(ims.core.vo.lookups.HcpDisType hcpType);

	/**
	* Creates and returns a AuthoringInformationVo
	* 
	*/
	public ims.core.vo.AuthoringInformationVo getValue();

	/**
	* Sets values to controls 
	* 
	*/
	public void setValue(ims.core.vo.AuthoringInformationVo voAuthoringInformation);

	/**
	* Sets HcpType (of type ims.core.vo.lookups.HcpDisType) - 
	* MEDICAL, NURSING, DENTAL, etc
	*/
	public void setHcpType(ims.core.vo.lookups.HcpDisType hcpDisType);

	/**
	* Enables/Disables AuthoringHCP control
	*/
	public void setEnabledAuthoringHCP(Boolean value);

	/**
	* Enables/Disables DateTime control
	*/
	public void setEnabledDateTime(Boolean value);

	/**
	* setIsRequiredPropertyToControls- sets IsRequired property of the controls with the value passed as a parameter (red star)
	*/
	public void setIsRequiredPropertyToControls(Boolean value);

	/**
	* Sets labels to:
	* - Vaildated Date/Time:
	* - Validated By:
	*/
	public void setLabelsToValidatedBy();

	/**
	* Sets labels to:
	* - Transcribed Date/Time:
	* - Transcribed By:
	*/
	public void setLabelsToTranscribedBy();

	/**
	* Sets the labels as defined in Core.AuthoringLabelType enumeration
	*/
	public void setLabels(ims.core.vo.enums.AuthoringLabelType labelType);

	/**
	* ignore the value of <b>AUTHORING_INFO_COMPONENT_ISREADONLY</b> system flag
	*/
	public void ignoreComponentReadonlyFlag(Boolean value);

	/**
	* when the "Required" property is  set to true then it returns a formatted message like:
	* "Authoring HCP is mandatory"
	* "Authoring Date/Time is mandatory"
	* 
	* where Authoring HCP and Authoting Date/Time are the labels set to the control
	*/
	public String getErrors();

	/**
	* Sets labels to:
	* - Recording Date/Time:
	* - Recording By:
	*/
	public void setLabelsToRecordingBy();
}
