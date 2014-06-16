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

package ims.admin.vo.beans;

public class ClearSpanAuditVoBean extends ims.vo.ValueObjectBean
{
	public ClearSpanAuditVoBean()
	{
	}
	public ClearSpanAuditVoBean(ims.admin.vo.ClearSpanAuditVo vo)
	{
		this.timegenerated = vo.getTimeGenerated() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTimeGenerated().getBean();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		this.evenlevel = vo.getEvenLevel() == null ? null : (ims.vo.LookupInstanceBean)vo.getEvenLevel().getBean();
		this.sourcename = vo.getSourceName();
		this.message = vo.getMessage();
		this.data = vo.getData();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.ClearSpanAuditVo vo)
	{
		this.timegenerated = vo.getTimeGenerated() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTimeGenerated().getBean();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		this.evenlevel = vo.getEvenLevel() == null ? null : (ims.vo.LookupInstanceBean)vo.getEvenLevel().getBean();
		this.sourcename = vo.getSourceName();
		this.message = vo.getMessage();
		this.data = vo.getData();
	}

	public ims.admin.vo.ClearSpanAuditVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.ClearSpanAuditVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.ClearSpanAuditVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.ClearSpanAuditVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.ClearSpanAuditVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.framework.utils.beans.DateTimeBean getTimeGenerated()
	{
		return this.timegenerated;
	}
	public void setTimeGenerated(ims.framework.utils.beans.DateTimeBean value)
	{
		this.timegenerated = value;
	}
	public ims.vo.LookupInstanceBean getEventType()
	{
		return this.eventtype;
	}
	public void setEventType(ims.vo.LookupInstanceBean value)
	{
		this.eventtype = value;
	}
	public ims.vo.LookupInstanceBean getEvenLevel()
	{
		return this.evenlevel;
	}
	public void setEvenLevel(ims.vo.LookupInstanceBean value)
	{
		this.evenlevel = value;
	}
	public String getSourceName()
	{
		return this.sourcename;
	}
	public void setSourceName(String value)
	{
		this.sourcename = value;
	}
	public String getMessage()
	{
		return this.message;
	}
	public void setMessage(String value)
	{
		this.message = value;
	}
	public String getData()
	{
		return this.data;
	}
	public void setData(String value)
	{
		this.data = value;
	}

	private ims.framework.utils.beans.DateTimeBean timegenerated;
	private ims.vo.LookupInstanceBean eventtype;
	private ims.vo.LookupInstanceBean evenlevel;
	private String sourcename;
	private String message;
	private String data;
}
