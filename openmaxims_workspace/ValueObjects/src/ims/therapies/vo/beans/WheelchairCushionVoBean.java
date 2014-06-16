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

public class WheelchairCushionVoBean extends ims.vo.ValueObjectBean
{
	public WheelchairCushionVoBean()
	{
	}
	public WheelchairCushionVoBean(ims.therapies.vo.WheelchairCushionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringCP().getBean();
		this.cushiontype = vo.getCushionType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCushionType().getBean();
		this.cushioncategory = vo.getCushionCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCushionCategory().getBean();
		this.covertype = vo.getCoverType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCoverType().getBean();
		this.cushionsize = vo.getCushionSize() == null ? null : (ims.vo.LookupInstanceBean)vo.getCushionSize().getBean();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
		this.pressurereadingdate = vo.getPressureReadingDate() == null ? null : ims.framework.utils.Date.getBeanArray(vo.getPressureReadingDate());
		this.cushionmodification = vo.getCushionModification() == null ? null : vo.getCushionModification().getBeanCollection();
		this.cushionaccessory = vo.getCushionAccessory() == null ? null : vo.getCushionAccessory().getBeanCollection();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.WheelchairCushionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringCP().getBean(map);
		this.cushiontype = vo.getCushionType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCushionType().getBean();
		this.cushioncategory = vo.getCushionCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCushionCategory().getBean();
		this.covertype = vo.getCoverType() == null ? null : (ims.vo.LookupInstanceBean)vo.getCoverType().getBean();
		this.cushionsize = vo.getCushionSize() == null ? null : (ims.vo.LookupInstanceBean)vo.getCushionSize().getBean();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
		this.pressurereadingdate = vo.getPressureReadingDate() == null ? null : ims.framework.utils.Date.getBeanArray(vo.getPressureReadingDate());
		this.cushionmodification = vo.getCushionModification() == null ? null : vo.getCushionModification().getBeanCollection();
		this.cushionaccessory = vo.getCushionAccessory() == null ? null : vo.getCushionAccessory().getBeanCollection();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public ims.therapies.vo.WheelchairCushionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.WheelchairCushionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.WheelchairCushionVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.WheelchairCushionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.WheelchairCushionVo();
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
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}
	public ims.core.vo.beans.HcpBean getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.beans.HcpBean value)
	{
		this.authoringcp = value;
	}
	public ims.vo.LookupInstanceBean getCushionType()
	{
		return this.cushiontype;
	}
	public void setCushionType(ims.vo.LookupInstanceBean value)
	{
		this.cushiontype = value;
	}
	public ims.vo.LookupInstanceBean getCushionCategory()
	{
		return this.cushioncategory;
	}
	public void setCushionCategory(ims.vo.LookupInstanceBean value)
	{
		this.cushioncategory = value;
	}
	public ims.vo.LookupInstanceBean getCoverType()
	{
		return this.covertype;
	}
	public void setCoverType(ims.vo.LookupInstanceBean value)
	{
		this.covertype = value;
	}
	public ims.vo.LookupInstanceBean getCushionSize()
	{
		return this.cushionsize;
	}
	public void setCushionSize(ims.vo.LookupInstanceBean value)
	{
		this.cushionsize = value;
	}
	public ims.framework.utils.beans.DateBean getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.startdate = value;
	}
	public ims.framework.utils.beans.DateBean getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.beans.DateBean value)
	{
		this.enddate = value;
	}
	public ims.framework.utils.beans.DateBean[] getPressureReadingDate()
	{
		return this.pressurereadingdate;
	}
	public void setPressureReadingDate(ims.framework.utils.beans.DateBean[] value)
	{
		this.pressurereadingdate = value;
	}
	public java.util.Collection getCushionModification()
	{
		return this.cushionmodification;
	}
	public void setCushionModification(java.util.Collection value)
	{
		this.cushionmodification = value;
	}
	public void addCushionModification(java.util.Collection value)
	{
		if(this.cushionmodification == null)
			this.cushionmodification = new java.util.ArrayList();
		this.cushionmodification.add(value);
	}
	public java.util.Collection getCushionAccessory()
	{
		return this.cushionaccessory;
	}
	public void setCushionAccessory(java.util.Collection value)
	{
		this.cushionaccessory = value;
	}
	public void addCushionAccessory(java.util.Collection value)
	{
		if(this.cushionaccessory == null)
			this.cushionaccessory = new java.util.ArrayList();
		this.cushionaccessory.add(value);
	}
	public ims.vo.RefVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.vo.RefVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private ims.core.vo.beans.HcpBean authoringcp;
	private ims.vo.LookupInstanceBean cushiontype;
	private ims.vo.LookupInstanceBean cushioncategory;
	private ims.vo.LookupInstanceBean covertype;
	private ims.vo.LookupInstanceBean cushionsize;
	private ims.framework.utils.beans.DateBean startdate;
	private ims.framework.utils.beans.DateBean enddate;
	private ims.framework.utils.beans.DateBean[] pressurereadingdate;
	private java.util.Collection cushionmodification;
	private java.util.Collection cushionaccessory;
	private ims.vo.RefVoBean clinicalcontact;
	private ims.vo.RefVoBean carecontext;
}
