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

package ims.emergency.vo.beans;

public class EDTransferVoBean extends ims.vo.ValueObjectBean
{
	public EDTransferVoBean()
	{
	}
	public EDTransferVoBean(ims.emergency.vo.EDTransferVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.referreddatetime = vo.getReferredDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReferredDateTime().getBean();
		this.accepteddatetime = vo.getAcceptedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAcceptedDateTime().getBean();
		this.tohospital = vo.getToHospital() == null ? null : (ims.vo.LookupInstanceBean)vo.getToHospital().getBean();
		this.otherhospital = vo.getOtherHospital();
		this.transfermode = vo.getTransferMode() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransferMode().getBean();
		this.transferescort = vo.getTransferEscort() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransferEscort().getBean();
		this.comment = vo.getComment();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.EDTransferVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.referreddatetime = vo.getReferredDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReferredDateTime().getBean();
		this.accepteddatetime = vo.getAcceptedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAcceptedDateTime().getBean();
		this.tohospital = vo.getToHospital() == null ? null : (ims.vo.LookupInstanceBean)vo.getToHospital().getBean();
		this.otherhospital = vo.getOtherHospital();
		this.transfermode = vo.getTransferMode() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransferMode().getBean();
		this.transferescort = vo.getTransferEscort() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransferEscort().getBean();
		this.comment = vo.getComment();
	}

	public ims.emergency.vo.EDTransferVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.EDTransferVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.EDTransferVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.EDTransferVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.EDTransferVo();
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
	public ims.framework.utils.beans.DateTimeBean getReferredDateTime()
	{
		return this.referreddatetime;
	}
	public void setReferredDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.referreddatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAcceptedDateTime()
	{
		return this.accepteddatetime;
	}
	public void setAcceptedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.accepteddatetime = value;
	}
	public ims.vo.LookupInstanceBean getToHospital()
	{
		return this.tohospital;
	}
	public void setToHospital(ims.vo.LookupInstanceBean value)
	{
		this.tohospital = value;
	}
	public String getOtherHospital()
	{
		return this.otherhospital;
	}
	public void setOtherHospital(String value)
	{
		this.otherhospital = value;
	}
	public ims.vo.LookupInstanceBean getTransferMode()
	{
		return this.transfermode;
	}
	public void setTransferMode(ims.vo.LookupInstanceBean value)
	{
		this.transfermode = value;
	}
	public ims.vo.LookupInstanceBean getTransferEscort()
	{
		return this.transferescort;
	}
	public void setTransferEscort(ims.vo.LookupInstanceBean value)
	{
		this.transferescort = value;
	}
	public String getComment()
	{
		return this.comment;
	}
	public void setComment(String value)
	{
		this.comment = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean referreddatetime;
	private ims.framework.utils.beans.DateTimeBean accepteddatetime;
	private ims.vo.LookupInstanceBean tohospital;
	private String otherhospital;
	private ims.vo.LookupInstanceBean transfermode;
	private ims.vo.LookupInstanceBean transferescort;
	private String comment;
}
