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

public class OrderSpecimenLabSpecCommentsVoBean extends ims.vo.ValueObjectBean
{
	public OrderSpecimenLabSpecCommentsVoBean()
	{
	}
	public OrderSpecimenLabSpecCommentsVoBean(ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.specimensource = vo.getSpecimenSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenSource().getBean();
		this.labspeccomments = vo.getLabSpecComments() == null ? null : vo.getLabSpecComments().getBeanCollection();
		this.colldatetimefiller = vo.getCollDateTimeFiller() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCollDateTimeFiller().getBean();
		this.coltimefillersupplied = vo.getColTimeFillerSupplied();
		this.receiveddatetime = vo.getReceivedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReceivedDateTime().getBean();
		this.receivedtimesupplied = vo.getReceivedTimeSupplied();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.specimensource = vo.getSpecimenSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenSource().getBean();
		this.labspeccomments = vo.getLabSpecComments() == null ? null : vo.getLabSpecComments().getBeanCollection();
		this.colldatetimefiller = vo.getCollDateTimeFiller() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCollDateTimeFiller().getBean();
		this.coltimefillersupplied = vo.getColTimeFillerSupplied();
		this.receiveddatetime = vo.getReceivedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReceivedDateTime().getBean();
		this.receivedtimesupplied = vo.getReceivedTimeSupplied();
	}

	public ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.OrderSpecimenLabSpecCommentsVo();
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
	public ims.vo.LookupInstanceBean getSpecimenSource()
	{
		return this.specimensource;
	}
	public void setSpecimenSource(ims.vo.LookupInstanceBean value)
	{
		this.specimensource = value;
	}
	public ims.ocrr.vo.beans.ResultComponentCommentsVoBean[] getLabSpecComments()
	{
		return this.labspeccomments;
	}
	public void setLabSpecComments(ims.ocrr.vo.beans.ResultComponentCommentsVoBean[] value)
	{
		this.labspeccomments = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCollDateTimeFiller()
	{
		return this.colldatetimefiller;
	}
	public void setCollDateTimeFiller(ims.framework.utils.beans.DateTimeBean value)
	{
		this.colldatetimefiller = value;
	}
	public Boolean getColTimeFillerSupplied()
	{
		return this.coltimefillersupplied;
	}
	public void setColTimeFillerSupplied(Boolean value)
	{
		this.coltimefillersupplied = value;
	}
	public ims.framework.utils.beans.DateTimeBean getReceivedDateTime()
	{
		return this.receiveddatetime;
	}
	public void setReceivedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.receiveddatetime = value;
	}
	public Boolean getReceivedTimeSupplied()
	{
		return this.receivedtimesupplied;
	}
	public void setReceivedTimeSupplied(Boolean value)
	{
		this.receivedtimesupplied = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean specimensource;
	private ims.ocrr.vo.beans.ResultComponentCommentsVoBean[] labspeccomments;
	private ims.framework.utils.beans.DateTimeBean colldatetimefiller;
	private Boolean coltimefillersupplied;
	private ims.framework.utils.beans.DateTimeBean receiveddatetime;
	private Boolean receivedtimesupplied;
}
