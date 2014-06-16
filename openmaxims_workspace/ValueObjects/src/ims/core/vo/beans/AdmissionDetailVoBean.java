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

package ims.core.vo.beans;

public class AdmissionDetailVoBean extends ims.vo.ValueObjectBean
{
	public AdmissionDetailVoBean()
	{
	}
	public AdmissionDetailVoBean(ims.core.vo.AdmissionDetailVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventAdmitVoBean)vo.getPasEvent().getBean();
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getWard().getBean();
		this.bed = vo.getBed() == null ? null : new ims.vo.RefVoBean(vo.getBed().getBoId(), vo.getBed().getBoVersion());
		// Interface field type not supported.
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.wardtype = vo.getWardType() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardType().getBean();
		this.methodofadmission = vo.getMethodOfAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getMethodOfAdmission().getBean();
		this.sourceofadmission = vo.getSourceOfAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfAdmission().getBean();
		this.reasonforadmission = vo.getReasonForAdmission();
		this.estdischargedate = vo.getEstDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEstDischargeDate().getBean();
		this.ischaplainrequired = vo.getIsChaplainRequired();
		// Interface field type not supported.
		this.patientstatus = vo.getPatientStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientStatus().getBean();
		this.updatecfl = vo.getUpdateCFL();
		this.anticipatedstay = vo.getAnticipatedStay();
		this.casefoldercomments = vo.getCaseFolderComments();
		this.admissionepisode = vo.getAdmissionEpisode() == null ? null : (ims.core.vo.beans.EpisodeOfCareWithPrimaryDiagnosisVoBean)vo.getAdmissionEpisode().getBean();
		this.extendeddetails = vo.getExtendedDetails() == null ? null : (ims.core.vo.beans.ExtendedAdmissionDetailVoBean)vo.getExtendedDetails().getBean();
		this.transferhistory = vo.getTransferHistory() == null ? null : vo.getTransferHistory().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.AdmissionDetailVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventAdmitVoBean)vo.getPasEvent().getBean(map);
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getWard().getBean(map);
		this.bed = vo.getBed() == null ? null : new ims.vo.RefVoBean(vo.getBed().getBoId(), vo.getBed().getBoVersion());
		// Interface field type not supported.
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.wardtype = vo.getWardType() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardType().getBean();
		this.methodofadmission = vo.getMethodOfAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getMethodOfAdmission().getBean();
		this.sourceofadmission = vo.getSourceOfAdmission() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfAdmission().getBean();
		this.reasonforadmission = vo.getReasonForAdmission();
		this.estdischargedate = vo.getEstDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEstDischargeDate().getBean();
		this.ischaplainrequired = vo.getIsChaplainRequired();
		// Interface field type not supported.
		this.patientstatus = vo.getPatientStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientStatus().getBean();
		this.updatecfl = vo.getUpdateCFL();
		this.anticipatedstay = vo.getAnticipatedStay();
		this.casefoldercomments = vo.getCaseFolderComments();
		this.admissionepisode = vo.getAdmissionEpisode() == null ? null : (ims.core.vo.beans.EpisodeOfCareWithPrimaryDiagnosisVoBean)vo.getAdmissionEpisode().getBean(map);
		this.extendeddetails = vo.getExtendedDetails() == null ? null : (ims.core.vo.beans.ExtendedAdmissionDetailVoBean)vo.getExtendedDetails().getBean(map);
		this.transferhistory = vo.getTransferHistory() == null ? null : vo.getTransferHistory().getBeanCollection();
	}

	public ims.core.vo.AdmissionDetailVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.AdmissionDetailVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.AdmissionDetailVo vo = null;
		if(map != null)
			vo = (ims.core.vo.AdmissionDetailVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.AdmissionDetailVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.core.vo.beans.PasEventAdmitVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.beans.PasEventAdmitVoBean value)
	{
		this.pasevent = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAdmissionDateTime()
	{
		return this.admissiondatetime;
	}
	public void setAdmissionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.admissiondatetime = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.ward = value;
	}
	public ims.vo.RefVoBean getBed()
	{
		return this.bed;
	}
	public void setBed(ims.vo.RefVoBean value)
	{
		this.bed = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.vo.LookupInstanceBean getWardType()
	{
		return this.wardtype;
	}
	public void setWardType(ims.vo.LookupInstanceBean value)
	{
		this.wardtype = value;
	}
	public ims.vo.LookupInstanceBean getMethodOfAdmission()
	{
		return this.methodofadmission;
	}
	public void setMethodOfAdmission(ims.vo.LookupInstanceBean value)
	{
		this.methodofadmission = value;
	}
	public ims.vo.LookupInstanceBean getSourceOfAdmission()
	{
		return this.sourceofadmission;
	}
	public void setSourceOfAdmission(ims.vo.LookupInstanceBean value)
	{
		this.sourceofadmission = value;
	}
	public String getReasonForAdmission()
	{
		return this.reasonforadmission;
	}
	public void setReasonForAdmission(String value)
	{
		this.reasonforadmission = value;
	}
	public ims.framework.utils.beans.DateBean getEstDischargeDate()
	{
		return this.estdischargedate;
	}
	public void setEstDischargeDate(ims.framework.utils.beans.DateBean value)
	{
		this.estdischargedate = value;
	}
	public Boolean getIsChaplainRequired()
	{
		return this.ischaplainrequired;
	}
	public void setIsChaplainRequired(Boolean value)
	{
		this.ischaplainrequired = value;
	}
	public ims.vo.LookupInstanceBean getPatientStatus()
	{
		return this.patientstatus;
	}
	public void setPatientStatus(ims.vo.LookupInstanceBean value)
	{
		this.patientstatus = value;
	}
	public Boolean getUpdateCFL()
	{
		return this.updatecfl;
	}
	public void setUpdateCFL(Boolean value)
	{
		this.updatecfl = value;
	}
	public Integer getAnticipatedStay()
	{
		return this.anticipatedstay;
	}
	public void setAnticipatedStay(Integer value)
	{
		this.anticipatedstay = value;
	}
	public String getCaseFolderComments()
	{
		return this.casefoldercomments;
	}
	public void setCaseFolderComments(String value)
	{
		this.casefoldercomments = value;
	}
	public ims.core.vo.beans.EpisodeOfCareWithPrimaryDiagnosisVoBean getAdmissionEpisode()
	{
		return this.admissionepisode;
	}
	public void setAdmissionEpisode(ims.core.vo.beans.EpisodeOfCareWithPrimaryDiagnosisVoBean value)
	{
		this.admissionepisode = value;
	}
	public ims.core.vo.beans.ExtendedAdmissionDetailVoBean getExtendedDetails()
	{
		return this.extendeddetails;
	}
	public void setExtendedDetails(ims.core.vo.beans.ExtendedAdmissionDetailVoBean value)
	{
		this.extendeddetails = value;
	}
	public ims.core.vo.beans.TransferHistoryVoBean[] getTransferHistory()
	{
		return this.transferhistory;
	}
	public void setTransferHistory(ims.core.vo.beans.TransferHistoryVoBean[] value)
	{
		this.transferhistory = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PasEventAdmitVoBean pasevent;
	private ims.framework.utils.beans.DateTimeBean admissiondatetime;
	private ims.core.vo.beans.LocationLiteVoBean ward;
	private ims.vo.RefVoBean bed;
	private ims.vo.LookupInstanceBean specialty;
	private ims.vo.LookupInstanceBean wardtype;
	private ims.vo.LookupInstanceBean methodofadmission;
	private ims.vo.LookupInstanceBean sourceofadmission;
	private String reasonforadmission;
	private ims.framework.utils.beans.DateBean estdischargedate;
	private Boolean ischaplainrequired;
	private ims.vo.LookupInstanceBean patientstatus;
	private Boolean updatecfl;
	private Integer anticipatedstay;
	private String casefoldercomments;
	private ims.core.vo.beans.EpisodeOfCareWithPrimaryDiagnosisVoBean admissionepisode;
	private ims.core.vo.beans.ExtendedAdmissionDetailVoBean extendeddetails;
	private ims.core.vo.beans.TransferHistoryVoBean[] transferhistory;
}
