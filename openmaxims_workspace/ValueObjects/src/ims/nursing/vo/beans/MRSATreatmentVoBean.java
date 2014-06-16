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

public class MRSATreatmentVoBean extends ims.vo.ValueObjectBean
{
	public MRSATreatmentVoBean()
	{
	}
	public MRSATreatmentVoBean(ims.nursing.vo.MRSATreatmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.rescreendate = vo.getRescreenDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getRescreenDate().getBean();
		this.treatmentnumber = vo.getTreatmentNumber();
		this.treatmentdetails = vo.getTreatmentDetails() == null ? null : vo.getTreatmentDetails().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.MRSATreatmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.rescreendate = vo.getRescreenDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getRescreenDate().getBean();
		this.treatmentnumber = vo.getTreatmentNumber();
		this.treatmentdetails = vo.getTreatmentDetails() == null ? null : vo.getTreatmentDetails().getBeanCollection();
	}

	public ims.nursing.vo.MRSATreatmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.MRSATreatmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.MRSATreatmentVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.MRSATreatmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.MRSATreatmentVo();
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
	public ims.framework.utils.beans.DateBean getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.startdate = value;
	}
	public ims.framework.utils.beans.DateBean getRescreenDate()
	{
		return this.rescreendate;
	}
	public void setRescreenDate(ims.framework.utils.beans.DateBean value)
	{
		this.rescreendate = value;
	}
	public Integer getTreatmentNumber()
	{
		return this.treatmentnumber;
	}
	public void setTreatmentNumber(Integer value)
	{
		this.treatmentnumber = value;
	}
	public ims.nursing.vo.beans.MRSATreatmentDetailsVoBean[] getTreatmentDetails()
	{
		return this.treatmentdetails;
	}
	public void setTreatmentDetails(ims.nursing.vo.beans.MRSATreatmentDetailsVoBean[] value)
	{
		this.treatmentdetails = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean startdate;
	private ims.framework.utils.beans.DateBean rescreendate;
	private Integer treatmentnumber;
	private ims.nursing.vo.beans.MRSATreatmentDetailsVoBean[] treatmentdetails;
}
