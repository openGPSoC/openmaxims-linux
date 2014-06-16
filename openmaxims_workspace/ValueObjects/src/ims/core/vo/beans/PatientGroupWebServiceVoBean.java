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

public class PatientGroupWebServiceVoBean extends ims.vo.ValueObjectBean
{
	public PatientGroupWebServiceVoBean()
	{
	}
	public PatientGroupWebServiceVoBean(ims.core.vo.PatientGroupWebServiceVo vo)
	{
		this.name = vo.getName();
		this.patients = vo.getPatients() == null ? null : vo.getPatients().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientGroupWebServiceVo vo)
	{
		this.name = vo.getName();
		this.patients = vo.getPatients() == null ? null : vo.getPatients().getBeanCollection();
	}

	public ims.core.vo.PatientGroupWebServiceVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientGroupWebServiceVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientGroupWebServiceVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientGroupWebServiceVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientGroupWebServiceVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public ims.core.vo.beans.PatientShortBean[] getPatients()
	{
		return this.patients;
	}
	public void setPatients(ims.core.vo.beans.PatientShortBean[] value)
	{
		this.patients = value;
	}

	private String name;
	private ims.core.vo.beans.PatientShortBean[] patients;
}
