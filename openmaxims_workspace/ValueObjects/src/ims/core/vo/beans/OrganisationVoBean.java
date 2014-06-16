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

public class OrganisationVoBean extends ims.vo.ValueObjectBean
{
	public OrganisationVoBean()
	{
	}
	public OrganisationVoBean(ims.core.vo.OrganisationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.address = vo.getAddress() == null ? null : (ims.core.vo.beans.PersonAddressBean)vo.getAddress().getBean();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.isactive = vo.getIsActive();
		this.comment = vo.getComment();
		this.codemappings = vo.getCodeMappings() == null ? null : vo.getCodeMappings().getBeanCollection();
		this.commchannels = vo.getCommChannels() == null ? null : vo.getCommChannels().getBeanCollection();
		this.locationsites = vo.getLocationSites() == null ? null : vo.getLocationSites().getBeanCollection();
		this.pctcode = vo.getPctCode();
		this.relatedorganisations = vo.getRelatedOrganisations() == null ? null : vo.getRelatedOrganisations().getBeanCollection();
		this.parentorganisation = vo.getParentOrganisation() == null ? null : (ims.core.vo.beans.OrganisationVoBean)vo.getParentOrganisation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.OrganisationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.address = vo.getAddress() == null ? null : (ims.core.vo.beans.PersonAddressBean)vo.getAddress().getBean(map);
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.isactive = vo.getIsActive();
		this.comment = vo.getComment();
		this.codemappings = vo.getCodeMappings() == null ? null : vo.getCodeMappings().getBeanCollection();
		this.commchannels = vo.getCommChannels() == null ? null : vo.getCommChannels().getBeanCollection();
		this.locationsites = vo.getLocationSites() == null ? null : vo.getLocationSites().getBeanCollection();
		this.pctcode = vo.getPctCode();
		this.relatedorganisations = vo.getRelatedOrganisations() == null ? null : vo.getRelatedOrganisations().getBeanCollection();
		this.parentorganisation = vo.getParentOrganisation() == null ? null : (ims.core.vo.beans.OrganisationVoBean)vo.getParentOrganisation().getBean(map);
	}

	public ims.core.vo.OrganisationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.OrganisationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.OrganisationVo vo = null;
		if(map != null)
			vo = (ims.core.vo.OrganisationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.OrganisationVo();
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
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public ims.core.vo.beans.PersonAddressBean getAddress()
	{
		return this.address;
	}
	public void setAddress(ims.core.vo.beans.PersonAddressBean value)
	{
		this.address = value;
	}
	public ims.vo.LookupInstanceBean getType()
	{
		return this.type;
	}
	public void setType(ims.vo.LookupInstanceBean value)
	{
		this.type = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public String getComment()
	{
		return this.comment;
	}
	public void setComment(String value)
	{
		this.comment = value;
	}
	public ims.core.vo.beans.TaxonomyMapBean[] getCodeMappings()
	{
		return this.codemappings;
	}
	public void setCodeMappings(ims.core.vo.beans.TaxonomyMapBean[] value)
	{
		this.codemappings = value;
	}
	public ims.core.vo.beans.CommChannelVoBean[] getCommChannels()
	{
		return this.commchannels;
	}
	public void setCommChannels(ims.core.vo.beans.CommChannelVoBean[] value)
	{
		this.commchannels = value;
	}
	public ims.core.vo.beans.LocSiteVoBean[] getLocationSites()
	{
		return this.locationsites;
	}
	public void setLocationSites(ims.core.vo.beans.LocSiteVoBean[] value)
	{
		this.locationsites = value;
	}
	public String getPctCode()
	{
		return this.pctcode;
	}
	public void setPctCode(String value)
	{
		this.pctcode = value;
	}
	public ims.core.vo.beans.OrganisationVoBean[] getRelatedOrganisations()
	{
		return this.relatedorganisations;
	}
	public void setRelatedOrganisations(ims.core.vo.beans.OrganisationVoBean[] value)
	{
		this.relatedorganisations = value;
	}
	public ims.core.vo.beans.OrganisationVoBean getParentOrganisation()
	{
		return this.parentorganisation;
	}
	public void setParentOrganisation(ims.core.vo.beans.OrganisationVoBean value)
	{
		this.parentorganisation = value;
	}

	private Integer id;
	private int version;
	private String name;
	private ims.core.vo.beans.PersonAddressBean address;
	private ims.vo.LookupInstanceBean type;
	private Boolean isactive;
	private String comment;
	private ims.core.vo.beans.TaxonomyMapBean[] codemappings;
	private ims.core.vo.beans.CommChannelVoBean[] commchannels;
	private ims.core.vo.beans.LocSiteVoBean[] locationsites;
	private String pctcode;
	private ims.core.vo.beans.OrganisationVoBean[] relatedorganisations;
	private ims.core.vo.beans.OrganisationVoBean parentorganisation;
}
