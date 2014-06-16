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

package ims.coe.vo.beans;

public class BowelMedicationBean extends ims.vo.ValueObjectBean
{
	public BowelMedicationBean()
	{
	}
	public BowelMedicationBean(ims.coe.vo.BowelMedication vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.medication = vo.getMedication() == null ? null : (ims.vo.LookupInstanceBean)vo.getMedication().getBean();
		this.other = vo.getOther();
		this.route = vo.getRoute() == null ? null : (ims.vo.LookupInstanceBean)vo.getRoute().getBean();
		this.dose = vo.getDose();
		this.frequency = vo.getFrequency() == null ? null : (ims.vo.LookupInstanceBean)vo.getFrequency().getBean();
		this.iscurrentlyactive = vo.getIsCurrentlyActive();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.BowelMedication vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.medication = vo.getMedication() == null ? null : (ims.vo.LookupInstanceBean)vo.getMedication().getBean();
		this.other = vo.getOther();
		this.route = vo.getRoute() == null ? null : (ims.vo.LookupInstanceBean)vo.getRoute().getBean();
		this.dose = vo.getDose();
		this.frequency = vo.getFrequency() == null ? null : (ims.vo.LookupInstanceBean)vo.getFrequency().getBean();
		this.iscurrentlyactive = vo.getIsCurrentlyActive();
	}

	public ims.coe.vo.BowelMedication buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.coe.vo.BowelMedication buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.BowelMedication vo = null;
		if(map != null)
			vo = (ims.coe.vo.BowelMedication)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.coe.vo.BowelMedication();
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
	public ims.vo.LookupInstanceBean getMedication()
	{
		return this.medication;
	}
	public void setMedication(ims.vo.LookupInstanceBean value)
	{
		this.medication = value;
	}
	public String getOther()
	{
		return this.other;
	}
	public void setOther(String value)
	{
		this.other = value;
	}
	public ims.vo.LookupInstanceBean getRoute()
	{
		return this.route;
	}
	public void setRoute(ims.vo.LookupInstanceBean value)
	{
		this.route = value;
	}
	public String getDose()
	{
		return this.dose;
	}
	public void setDose(String value)
	{
		this.dose = value;
	}
	public ims.vo.LookupInstanceBean getFrequency()
	{
		return this.frequency;
	}
	public void setFrequency(ims.vo.LookupInstanceBean value)
	{
		this.frequency = value;
	}
	public Boolean getIsCurrentlyActive()
	{
		return this.iscurrentlyactive;
	}
	public void setIsCurrentlyActive(Boolean value)
	{
		this.iscurrentlyactive = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean medication;
	private String other;
	private ims.vo.LookupInstanceBean route;
	private String dose;
	private ims.vo.LookupInstanceBean frequency;
	private Boolean iscurrentlyactive;
}
