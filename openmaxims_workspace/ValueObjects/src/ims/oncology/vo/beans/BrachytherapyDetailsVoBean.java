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

package ims.oncology.vo.beans;

public class BrachytherapyDetailsVoBean extends ims.vo.ValueObjectBean
{
	public BrachytherapyDetailsVoBean()
	{
	}
	public BrachytherapyDetailsVoBean(ims.oncology.vo.BrachytherapyDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.actualdoserate = vo.getActualDoseRate() == null ? null : (ims.vo.LookupInstanceBean)vo.getActualDoseRate().getBean();
		this.brachytherapyisotopetype = vo.getBrachyTherapyIsotopeType() == null ? null : (ims.vo.LookupInstanceBean)vo.getBrachyTherapyIsotopeType().getBean();
		this.brachytherapyunsealedsourcetype = vo.getBrachyTherapyUnsealedSourceType() == null ? null : (ims.vo.LookupInstanceBean)vo.getBrachyTherapyUnsealedSourceType().getBean();
		this.brachydeliverytype = vo.getBrachyDeliveryType() == null ? null : (ims.vo.LookupInstanceBean)vo.getBrachyDeliveryType().getBean();
		this.patienttype = vo.getPatientType() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientType().getBean();
		this.brachytherapytype = vo.getBrachytherapyType() == null ? null : (ims.vo.LookupInstanceBean)vo.getBrachytherapyType().getBean();
		this.prescriptionpoint = vo.getPrescriptionPoint() == null ? null : (ims.vo.LookupInstanceBean)vo.getPrescriptionPoint().getBean();
		this.unit = vo.getUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getUnit().getBean();
		this.treatmentdetails = vo.getTreatmentDetails() == null ? null : vo.getTreatmentDetails().getBeanCollection();
		this.actualnrtreatments = vo.getActualNrTreatments();
		this.treatmentlength = vo.getTreatmentLength();
		this.totaldose = vo.getTotalDose();
		this.actualduration = vo.getActualDuration();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.BrachytherapyDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.actualdoserate = vo.getActualDoseRate() == null ? null : (ims.vo.LookupInstanceBean)vo.getActualDoseRate().getBean();
		this.brachytherapyisotopetype = vo.getBrachyTherapyIsotopeType() == null ? null : (ims.vo.LookupInstanceBean)vo.getBrachyTherapyIsotopeType().getBean();
		this.brachytherapyunsealedsourcetype = vo.getBrachyTherapyUnsealedSourceType() == null ? null : (ims.vo.LookupInstanceBean)vo.getBrachyTherapyUnsealedSourceType().getBean();
		this.brachydeliverytype = vo.getBrachyDeliveryType() == null ? null : (ims.vo.LookupInstanceBean)vo.getBrachyDeliveryType().getBean();
		this.patienttype = vo.getPatientType() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientType().getBean();
		this.brachytherapytype = vo.getBrachytherapyType() == null ? null : (ims.vo.LookupInstanceBean)vo.getBrachytherapyType().getBean();
		this.prescriptionpoint = vo.getPrescriptionPoint() == null ? null : (ims.vo.LookupInstanceBean)vo.getPrescriptionPoint().getBean();
		this.unit = vo.getUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getUnit().getBean();
		this.treatmentdetails = vo.getTreatmentDetails() == null ? null : vo.getTreatmentDetails().getBeanCollection();
		this.actualnrtreatments = vo.getActualNrTreatments();
		this.treatmentlength = vo.getTreatmentLength();
		this.totaldose = vo.getTotalDose();
		this.actualduration = vo.getActualDuration();
	}

	public ims.oncology.vo.BrachytherapyDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.oncology.vo.BrachytherapyDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.BrachytherapyDetailsVo vo = null;
		if(map != null)
			vo = (ims.oncology.vo.BrachytherapyDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.oncology.vo.BrachytherapyDetailsVo();
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
	public ims.vo.LookupInstanceBean getActualDoseRate()
	{
		return this.actualdoserate;
	}
	public void setActualDoseRate(ims.vo.LookupInstanceBean value)
	{
		this.actualdoserate = value;
	}
	public ims.vo.LookupInstanceBean getBrachyTherapyIsotopeType()
	{
		return this.brachytherapyisotopetype;
	}
	public void setBrachyTherapyIsotopeType(ims.vo.LookupInstanceBean value)
	{
		this.brachytherapyisotopetype = value;
	}
	public ims.vo.LookupInstanceBean getBrachyTherapyUnsealedSourceType()
	{
		return this.brachytherapyunsealedsourcetype;
	}
	public void setBrachyTherapyUnsealedSourceType(ims.vo.LookupInstanceBean value)
	{
		this.brachytherapyunsealedsourcetype = value;
	}
	public ims.vo.LookupInstanceBean getBrachyDeliveryType()
	{
		return this.brachydeliverytype;
	}
	public void setBrachyDeliveryType(ims.vo.LookupInstanceBean value)
	{
		this.brachydeliverytype = value;
	}
	public ims.vo.LookupInstanceBean getPatientType()
	{
		return this.patienttype;
	}
	public void setPatientType(ims.vo.LookupInstanceBean value)
	{
		this.patienttype = value;
	}
	public ims.vo.LookupInstanceBean getBrachytherapyType()
	{
		return this.brachytherapytype;
	}
	public void setBrachytherapyType(ims.vo.LookupInstanceBean value)
	{
		this.brachytherapytype = value;
	}
	public ims.vo.LookupInstanceBean getPrescriptionPoint()
	{
		return this.prescriptionpoint;
	}
	public void setPrescriptionPoint(ims.vo.LookupInstanceBean value)
	{
		this.prescriptionpoint = value;
	}
	public ims.vo.LookupInstanceBean getUnit()
	{
		return this.unit;
	}
	public void setUnit(ims.vo.LookupInstanceBean value)
	{
		this.unit = value;
	}
	public ims.oncology.vo.beans.BrachyTxTreatmentDetailsVoBean[] getTreatmentDetails()
	{
		return this.treatmentdetails;
	}
	public void setTreatmentDetails(ims.oncology.vo.beans.BrachyTxTreatmentDetailsVoBean[] value)
	{
		this.treatmentdetails = value;
	}
	public Integer getActualNrTreatments()
	{
		return this.actualnrtreatments;
	}
	public void setActualNrTreatments(Integer value)
	{
		this.actualnrtreatments = value;
	}
	public Integer getTreatmentLength()
	{
		return this.treatmentlength;
	}
	public void setTreatmentLength(Integer value)
	{
		this.treatmentlength = value;
	}
	public Float getTotalDose()
	{
		return this.totaldose;
	}
	public void setTotalDose(Float value)
	{
		this.totaldose = value;
	}
	public Integer getActualDuration()
	{
		return this.actualduration;
	}
	public void setActualDuration(Integer value)
	{
		this.actualduration = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean actualdoserate;
	private ims.vo.LookupInstanceBean brachytherapyisotopetype;
	private ims.vo.LookupInstanceBean brachytherapyunsealedsourcetype;
	private ims.vo.LookupInstanceBean brachydeliverytype;
	private ims.vo.LookupInstanceBean patienttype;
	private ims.vo.LookupInstanceBean brachytherapytype;
	private ims.vo.LookupInstanceBean prescriptionpoint;
	private ims.vo.LookupInstanceBean unit;
	private ims.oncology.vo.beans.BrachyTxTreatmentDetailsVoBean[] treatmentdetails;
	private Integer actualnrtreatments;
	private Integer treatmentlength;
	private Float totaldose;
	private Integer actualduration;
}
