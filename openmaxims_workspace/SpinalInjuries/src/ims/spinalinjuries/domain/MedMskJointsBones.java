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

package ims.spinalinjuries.domain;

// Generated from form domain impl
public interface MedMskJointsBones extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* get the Joints & Bones
	*/
	public ims.generalmedical.vo.MskBoneJointVo getBoneJointsRecords(ims.core.vo.ClinicalContactShortVo contact, ims.generalmedical.vo.MskBoneJointShortVo voBoneJointShort);

	// Generated from form domain interface definition
	/**
	* saves the Bone and Joints
	*/
	public ims.generalmedical.vo.MskBoneJointVo saveBoneJointsRecord(ims.generalmedical.vo.MskBoneJointVo boneJointVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* List the groups
	*/
	public ims.core.vo.MskGroupVoCollection listMskGroup(Boolean activeOnly);

	// Generated from form domain interface definition
	/**
	* list all Bone/Joint records for record browser
	*/
	public ims.generalmedical.vo.MskBoneJointShortVoCollection listByCareContext(ims.core.vo.CareContextLiteVo voCareContext);

	// Generated from form domain interface definition
	public ims.generalmedical.vo.MskBoneJointVo getBoneJointByCareContext(ims.core.vo.CareContextLiteVo voCareContext, ims.generalmedical.vo.MskBoneJointShortVo voBoneJointShort);

	// Generated from form domain interface definition
	/**
	* checks if there is a Clinical Contact of type SpinalMedicalAdission that has a joint bone within the CareContext, if so it will be displayed
	*/
	public ims.generalmedical.vo.MskBoneJointVo getMedicalAdmissionJointByCareContext(ims.core.admin.vo.CareContextRefVo voCareContextRef);

	// Generated from form domain interface definition
	/**
	* list By Episode Of Care used for the dialog off the OPD notes screen
	*/
	public ims.generalmedical.vo.MskBoneJointShortVoCollection listByEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo voEpisodeOfCareRef);

	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVoCollection listHcpLiteByName(String hcpName);
}
