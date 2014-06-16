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

package ims.ocrr.vo.beans;

public class InvestigationIndexSelectOrderVoBean extends ims.vo.ValueObjectBean
{
	public InvestigationIndexSelectOrderVoBean()
	{
	}
	public InvestigationIndexSelectOrderVoBean(ims.ocrr.vo.InvestigationIndexSelectOrderVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigations = vo.getInvestigations() == null ? null : vo.getInvestigations().getBeanCollection();
		this.isprofile = vo.getIsProfile();
		this.name = vo.getName();
		this.description = vo.getDescription();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.genderspecific = vo.getGenderSpecific() == null ? null : (ims.vo.LookupInstanceBean)vo.getGenderSpecific().getBean();
		this.phlebmaycollect = vo.getPhlebMayCollect();
		this.requiressitespecifier = vo.getRequiresSiteSpecifier();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.InvestigationIndexSelectOrderVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigations = vo.getInvestigations() == null ? null : vo.getInvestigations().getBeanCollection();
		this.isprofile = vo.getIsProfile();
		this.name = vo.getName();
		this.description = vo.getDescription();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.genderspecific = vo.getGenderSpecific() == null ? null : (ims.vo.LookupInstanceBean)vo.getGenderSpecific().getBean();
		this.phlebmaycollect = vo.getPhlebMayCollect();
		this.requiressitespecifier = vo.getRequiresSiteSpecifier();
	}

	public ims.ocrr.vo.InvestigationIndexSelectOrderVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.InvestigationIndexSelectOrderVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.InvestigationIndexSelectOrderVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.InvestigationIndexSelectOrderVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.InvestigationIndexSelectOrderVo();
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
	public ims.ocrr.vo.beans.InvestigationSelectOrderVoBean[] getInvestigations()
	{
		return this.investigations;
	}
	public void setInvestigations(ims.ocrr.vo.beans.InvestigationSelectOrderVoBean[] value)
	{
		this.investigations = value;
	}
	public Boolean getIsProfile()
	{
		return this.isprofile;
	}
	public void setIsProfile(Boolean value)
	{
		this.isprofile = value;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String value)
	{
		this.description = value;
	}
	public ims.vo.LookupInstanceBean getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.vo.LookupInstanceBean value)
	{
		this.category = value;
	}
	public ims.vo.LookupInstanceBean getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.vo.LookupInstanceBean value)
	{
		this.activestatus = value;
	}
	public ims.vo.LookupInstanceBean getGenderSpecific()
	{
		return this.genderspecific;
	}
	public void setGenderSpecific(ims.vo.LookupInstanceBean value)
	{
		this.genderspecific = value;
	}
	public Boolean getPhlebMayCollect()
	{
		return this.phlebmaycollect;
	}
	public void setPhlebMayCollect(Boolean value)
	{
		this.phlebmaycollect = value;
	}
	public Boolean getRequiresSiteSpecifier()
	{
		return this.requiressitespecifier;
	}
	public void setRequiresSiteSpecifier(Boolean value)
	{
		this.requiressitespecifier = value;
	}

	private Integer id;
	private int version;
	private ims.ocrr.vo.beans.InvestigationSelectOrderVoBean[] investigations;
	private Boolean isprofile;
	private String name;
	private String description;
	private ims.vo.LookupInstanceBean category;
	private ims.vo.LookupInstanceBean activestatus;
	private ims.vo.LookupInstanceBean genderspecific;
	private Boolean phlebmaycollect;
	private Boolean requiressitespecifier;
}
