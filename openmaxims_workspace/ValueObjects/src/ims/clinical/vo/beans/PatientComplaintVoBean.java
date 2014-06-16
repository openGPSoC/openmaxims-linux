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

package ims.clinical.vo.beans;

public class PatientComplaintVoBean extends ims.vo.ValueObjectBean
{
	public PatientComplaintVoBean()
	{
	}
	public PatientComplaintVoBean(ims.clinical.vo.PatientComplaintVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.complaint = vo.getComplaint() == null ? null : (ims.clinical.vo.beans.PresentingComplaintVoBean)vo.getComplaint().getBean();
		this.isactive = vo.getIsActive();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.PatientComplaintVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.complaint = vo.getComplaint() == null ? null : (ims.clinical.vo.beans.PresentingComplaintVoBean)vo.getComplaint().getBean(map);
		this.isactive = vo.getIsActive();
	}

	public ims.clinical.vo.PatientComplaintVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.PatientComplaintVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.PatientComplaintVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.PatientComplaintVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.PatientComplaintVo();
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
	public ims.clinical.vo.beans.PresentingComplaintVoBean getComplaint()
	{
		return this.complaint;
	}
	public void setComplaint(ims.clinical.vo.beans.PresentingComplaintVoBean value)
	{
		this.complaint = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}

	private Integer id;
	private int version;
	private ims.clinical.vo.beans.PresentingComplaintVoBean complaint;
	private Boolean isactive;
}
