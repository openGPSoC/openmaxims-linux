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

package ims.correspondence.vo.beans;

public class DocReportVoBean extends ims.vo.ValueObjectBean
{
	public DocReportVoBean()
	{
	}
	public DocReportVoBean(ims.correspondence.vo.DocReportVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.reportname = vo.getReportName();
		this.reportdescription = vo.getReportDescription();
		this.isactive = vo.getIsActive();
		this.reportxml = vo.getReportXml();
		this.templates = vo.getTemplates() == null ? null : vo.getTemplates().getBeanCollection();
		this.seeds = vo.getSeeds() == null ? null : vo.getSeeds().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.correspondence.vo.DocReportVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.reportname = vo.getReportName();
		this.reportdescription = vo.getReportDescription();
		this.isactive = vo.getIsActive();
		this.reportxml = vo.getReportXml();
		this.templates = vo.getTemplates() == null ? null : vo.getTemplates().getBeanCollection();
		this.seeds = vo.getSeeds() == null ? null : vo.getSeeds().getBeanCollection();
	}

	public ims.correspondence.vo.DocReportVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.correspondence.vo.DocReportVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.correspondence.vo.DocReportVo vo = null;
		if(map != null)
			vo = (ims.correspondence.vo.DocReportVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.correspondence.vo.DocReportVo();
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
	public String getReportName()
	{
		return this.reportname;
	}
	public void setReportName(String value)
	{
		this.reportname = value;
	}
	public String getReportDescription()
	{
		return this.reportdescription;
	}
	public void setReportDescription(String value)
	{
		this.reportdescription = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public String getReportXml()
	{
		return this.reportxml;
	}
	public void setReportXml(String value)
	{
		this.reportxml = value;
	}
	public ims.correspondence.vo.beans.DischargeDocTemplateVoBean[] getTemplates()
	{
		return this.templates;
	}
	public void setTemplates(ims.correspondence.vo.beans.DischargeDocTemplateVoBean[] value)
	{
		this.templates = value;
	}
	public ims.correspondence.vo.beans.DischargeReportSeedVoBean[] getSeeds()
	{
		return this.seeds;
	}
	public void setSeeds(ims.correspondence.vo.beans.DischargeReportSeedVoBean[] value)
	{
		this.seeds = value;
	}

	private Integer id;
	private int version;
	private String reportname;
	private String reportdescription;
	private Boolean isactive;
	private String reportxml;
	private ims.correspondence.vo.beans.DischargeDocTemplateVoBean[] templates;
	private ims.correspondence.vo.beans.DischargeReportSeedVoBean[] seeds;
}
