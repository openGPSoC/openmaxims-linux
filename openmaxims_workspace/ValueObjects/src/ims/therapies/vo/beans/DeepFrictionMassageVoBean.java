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

package ims.therapies.vo.beans;

public class DeepFrictionMassageVoBean extends ims.vo.ValueObjectBean
{
	public DeepFrictionMassageVoBean()
	{
	}
	public DeepFrictionMassageVoBean(ims.therapies.vo.DeepFrictionMassageVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dfmassagearea = vo.getDFMassageArea() == null ? null : (ims.vo.LookupInstanceBean)vo.getDFMassageArea().getBean();
		this.dfmassagestructure = vo.getDFMassageStructure() == null ? null : (ims.vo.LookupInstanceBean)vo.getDFMassageStructure().getBean();
		this.laterality = vo.getLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getLaterality().getBean();
		this.duration = vo.getDuration();
		this.notes = vo.getNotes();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.DeepFrictionMassageVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dfmassagearea = vo.getDFMassageArea() == null ? null : (ims.vo.LookupInstanceBean)vo.getDFMassageArea().getBean();
		this.dfmassagestructure = vo.getDFMassageStructure() == null ? null : (ims.vo.LookupInstanceBean)vo.getDFMassageStructure().getBean();
		this.laterality = vo.getLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getLaterality().getBean();
		this.duration = vo.getDuration();
		this.notes = vo.getNotes();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean(map);
	}

	public ims.therapies.vo.DeepFrictionMassageVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.DeepFrictionMassageVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.DeepFrictionMassageVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.DeepFrictionMassageVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.DeepFrictionMassageVo();
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
	public ims.vo.LookupInstanceBean getDFMassageArea()
	{
		return this.dfmassagearea;
	}
	public void setDFMassageArea(ims.vo.LookupInstanceBean value)
	{
		this.dfmassagearea = value;
	}
	public ims.vo.LookupInstanceBean getDFMassageStructure()
	{
		return this.dfmassagestructure;
	}
	public void setDFMassageStructure(ims.vo.LookupInstanceBean value)
	{
		this.dfmassagestructure = value;
	}
	public ims.vo.LookupInstanceBean getLaterality()
	{
		return this.laterality;
	}
	public void setLaterality(ims.vo.LookupInstanceBean value)
	{
		this.laterality = value;
	}
	public Integer getDuration()
	{
		return this.duration;
	}
	public void setDuration(Integer value)
	{
		this.duration = value;
	}
	public String getNotes()
	{
		return this.notes;
	}
	public void setNotes(String value)
	{
		this.notes = value;
	}
	public ims.core.vo.beans.ClinicalContactShortVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.clinicalcontact = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean dfmassagearea;
	private ims.vo.LookupInstanceBean dfmassagestructure;
	private ims.vo.LookupInstanceBean laterality;
	private Integer duration;
	private String notes;
	private ims.core.vo.beans.ClinicalContactShortVoBean clinicalcontact;
}
