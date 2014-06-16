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

package ims.nursing.vo.beans;

public class BradenScaleBean extends ims.vo.ValueObjectBean
{
	public BradenScaleBean()
	{
	}
	public BradenScaleBean(ims.nursing.vo.BradenScale vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hcpinitiated = vo.getHcpInitiated() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHcpInitiated().getBean();
		this.datetimeinitiated = vo.getDateTimeInitiated() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeInitiated().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.assessmentdetails = vo.getAssessmentDetails() == null ? null : vo.getAssessmentDetails().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.BradenScale vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hcpinitiated = vo.getHcpInitiated() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getHcpInitiated().getBean(map);
		this.datetimeinitiated = vo.getDateTimeInitiated() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDateTimeInitiated().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.assessmentdetails = vo.getAssessmentDetails() == null ? null : vo.getAssessmentDetails().getBeanCollection();
	}

	public ims.nursing.vo.BradenScale buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.BradenScale buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.BradenScale vo = null;
		if(map != null)
			vo = (ims.nursing.vo.BradenScale)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.BradenScale();
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
	public ims.core.vo.beans.HcpLiteVoBean getHcpInitiated()
	{
		return this.hcpinitiated;
	}
	public void setHcpInitiated(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.hcpinitiated = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDateTimeInitiated()
	{
		return this.datetimeinitiated;
	}
	public void setDateTimeInitiated(ims.framework.utils.beans.DateTimeBean value)
	{
		this.datetimeinitiated = value;
	}
	public ims.vo.RefVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.vo.RefVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.nursing.vo.beans.BradenScaleDetailsBean[] getAssessmentDetails()
	{
		return this.assessmentdetails;
	}
	public void setAssessmentDetails(ims.nursing.vo.beans.BradenScaleDetailsBean[] value)
	{
		this.assessmentdetails = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.HcpLiteVoBean hcpinitiated;
	private ims.framework.utils.beans.DateTimeBean datetimeinitiated;
	private ims.vo.RefVoBean clinicalcontact;
	private ims.vo.RefVoBean carecontext;
	private ims.nursing.vo.beans.BradenScaleDetailsBean[] assessmentdetails;
}
