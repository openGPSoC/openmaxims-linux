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

public class VentilationTracheostomyVoBean extends ims.vo.ValueObjectBean
{
	public VentilationTracheostomyVoBean()
	{
	}
	public VentilationTracheostomyVoBean(ims.core.vo.VentilationTracheostomyVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.breathsspontaneously = vo.getBreathsSpontaneously() == null ? null : (ims.vo.LookupInstanceBean)vo.getBreathsSpontaneously().getBean();
		this.patientintubated = vo.getPatientIntubated() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientIntubated().getBean();
		this.intubationmethod = vo.getIntubationMethod();
		this.patientventilated = vo.getPatientVentilated() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientVentilated().getBean();
		this.typeofventilator = vo.getTypeOfVentilator() == null ? null : (ims.vo.LookupInstanceBean)vo.getTypeOfVentilator().getBean();
		this.modeofventilation = vo.getModeOfVentilation() == null ? null : (ims.vo.LookupInstanceBean)vo.getModeOfVentilation().getBean();
		this.requiresatracheostomy = vo.getRequiresATracheostomy() == null ? null : (ims.vo.LookupInstanceBean)vo.getRequiresATracheostomy().getBean();
		this.tracheostomytype = vo.getTracheostomyType() == null ? null : (ims.vo.LookupInstanceBean)vo.getTracheostomyType().getBean();
		this.tracheostomyaccessories = vo.getTracheostomyAccessories() == null ? null : (ims.vo.LookupInstanceBean)vo.getTracheostomyAccessories().getBean();
		this.sizecpapvalve = vo.getSizeCPAPValve();
		this.sizeoftracheostomy = vo.getSizeOfTracheostomy();
		this.dateinserted = vo.getDateInserted() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateInserted().getBean();
		this.datelastchange = vo.getDateLastChange() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateLastChange().getBean();
		this.datenextchange = vo.getDateNextChange() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateNextChange().getBean();
		this.dateremoved = vo.getDateRemoved() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateRemoved().getBean();
		this.notes = vo.getNotes();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.VentilationTracheostomyVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.breathsspontaneously = vo.getBreathsSpontaneously() == null ? null : (ims.vo.LookupInstanceBean)vo.getBreathsSpontaneously().getBean();
		this.patientintubated = vo.getPatientIntubated() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientIntubated().getBean();
		this.intubationmethod = vo.getIntubationMethod();
		this.patientventilated = vo.getPatientVentilated() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientVentilated().getBean();
		this.typeofventilator = vo.getTypeOfVentilator() == null ? null : (ims.vo.LookupInstanceBean)vo.getTypeOfVentilator().getBean();
		this.modeofventilation = vo.getModeOfVentilation() == null ? null : (ims.vo.LookupInstanceBean)vo.getModeOfVentilation().getBean();
		this.requiresatracheostomy = vo.getRequiresATracheostomy() == null ? null : (ims.vo.LookupInstanceBean)vo.getRequiresATracheostomy().getBean();
		this.tracheostomytype = vo.getTracheostomyType() == null ? null : (ims.vo.LookupInstanceBean)vo.getTracheostomyType().getBean();
		this.tracheostomyaccessories = vo.getTracheostomyAccessories() == null ? null : (ims.vo.LookupInstanceBean)vo.getTracheostomyAccessories().getBean();
		this.sizecpapvalve = vo.getSizeCPAPValve();
		this.sizeoftracheostomy = vo.getSizeOfTracheostomy();
		this.dateinserted = vo.getDateInserted() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateInserted().getBean();
		this.datelastchange = vo.getDateLastChange() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateLastChange().getBean();
		this.datenextchange = vo.getDateNextChange() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateNextChange().getBean();
		this.dateremoved = vo.getDateRemoved() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateRemoved().getBean();
		this.notes = vo.getNotes();
	}

	public ims.core.vo.VentilationTracheostomyVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.VentilationTracheostomyVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.VentilationTracheostomyVo vo = null;
		if(map != null)
			vo = (ims.core.vo.VentilationTracheostomyVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.VentilationTracheostomyVo();
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
	public ims.vo.LookupInstanceBean getBreathsSpontaneously()
	{
		return this.breathsspontaneously;
	}
	public void setBreathsSpontaneously(ims.vo.LookupInstanceBean value)
	{
		this.breathsspontaneously = value;
	}
	public ims.vo.LookupInstanceBean getPatientIntubated()
	{
		return this.patientintubated;
	}
	public void setPatientIntubated(ims.vo.LookupInstanceBean value)
	{
		this.patientintubated = value;
	}
	public String getIntubationMethod()
	{
		return this.intubationmethod;
	}
	public void setIntubationMethod(String value)
	{
		this.intubationmethod = value;
	}
	public ims.vo.LookupInstanceBean getPatientVentilated()
	{
		return this.patientventilated;
	}
	public void setPatientVentilated(ims.vo.LookupInstanceBean value)
	{
		this.patientventilated = value;
	}
	public ims.vo.LookupInstanceBean getTypeOfVentilator()
	{
		return this.typeofventilator;
	}
	public void setTypeOfVentilator(ims.vo.LookupInstanceBean value)
	{
		this.typeofventilator = value;
	}
	public ims.vo.LookupInstanceBean getModeOfVentilation()
	{
		return this.modeofventilation;
	}
	public void setModeOfVentilation(ims.vo.LookupInstanceBean value)
	{
		this.modeofventilation = value;
	}
	public ims.vo.LookupInstanceBean getRequiresATracheostomy()
	{
		return this.requiresatracheostomy;
	}
	public void setRequiresATracheostomy(ims.vo.LookupInstanceBean value)
	{
		this.requiresatracheostomy = value;
	}
	public ims.vo.LookupInstanceBean getTracheostomyType()
	{
		return this.tracheostomytype;
	}
	public void setTracheostomyType(ims.vo.LookupInstanceBean value)
	{
		this.tracheostomytype = value;
	}
	public ims.vo.LookupInstanceBean getTracheostomyAccessories()
	{
		return this.tracheostomyaccessories;
	}
	public void setTracheostomyAccessories(ims.vo.LookupInstanceBean value)
	{
		this.tracheostomyaccessories = value;
	}
	public String getSizeCPAPValve()
	{
		return this.sizecpapvalve;
	}
	public void setSizeCPAPValve(String value)
	{
		this.sizecpapvalve = value;
	}
	public String getSizeOfTracheostomy()
	{
		return this.sizeoftracheostomy;
	}
	public void setSizeOfTracheostomy(String value)
	{
		this.sizeoftracheostomy = value;
	}
	public ims.framework.utils.beans.DateBean getDateInserted()
	{
		return this.dateinserted;
	}
	public void setDateInserted(ims.framework.utils.beans.DateBean value)
	{
		this.dateinserted = value;
	}
	public ims.framework.utils.beans.DateBean getDateLastChange()
	{
		return this.datelastchange;
	}
	public void setDateLastChange(ims.framework.utils.beans.DateBean value)
	{
		this.datelastchange = value;
	}
	public ims.framework.utils.beans.DateBean getDateNextChange()
	{
		return this.datenextchange;
	}
	public void setDateNextChange(ims.framework.utils.beans.DateBean value)
	{
		this.datenextchange = value;
	}
	public ims.framework.utils.beans.DateBean getDateRemoved()
	{
		return this.dateremoved;
	}
	public void setDateRemoved(ims.framework.utils.beans.DateBean value)
	{
		this.dateremoved = value;
	}
	public String getNotes()
	{
		return this.notes;
	}
	public void setNotes(String value)
	{
		this.notes = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean breathsspontaneously;
	private ims.vo.LookupInstanceBean patientintubated;
	private String intubationmethod;
	private ims.vo.LookupInstanceBean patientventilated;
	private ims.vo.LookupInstanceBean typeofventilator;
	private ims.vo.LookupInstanceBean modeofventilation;
	private ims.vo.LookupInstanceBean requiresatracheostomy;
	private ims.vo.LookupInstanceBean tracheostomytype;
	private ims.vo.LookupInstanceBean tracheostomyaccessories;
	private String sizecpapvalve;
	private String sizeoftracheostomy;
	private ims.framework.utils.beans.DateBean dateinserted;
	private ims.framework.utils.beans.DateBean datelastchange;
	private ims.framework.utils.beans.DateBean datenextchange;
	private ims.framework.utils.beans.DateBean dateremoved;
	private String notes;
}
