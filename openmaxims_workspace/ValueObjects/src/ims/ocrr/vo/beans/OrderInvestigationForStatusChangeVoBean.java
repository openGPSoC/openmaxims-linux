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

public class OrderInvestigationForStatusChangeVoBean extends ims.vo.ValueObjectBean
{
	public OrderInvestigationForStatusChangeVoBean()
	{
	}
	public OrderInvestigationForStatusChangeVoBean(ims.ocrr.vo.OrderInvestigationForStatusChangeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.ordinvcurrentstatus = vo.getOrdInvCurrentStatus() == null ? null : (ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean)vo.getOrdInvCurrentStatus().getBean();
		this.ordinvstatushistory = vo.getOrdInvStatusHistory() == null ? null : vo.getOrdInvStatusHistory().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.OrderInvestigationForStatusChangeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.ordinvcurrentstatus = vo.getOrdInvCurrentStatus() == null ? null : (ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean)vo.getOrdInvCurrentStatus().getBean(map);
		this.ordinvstatushistory = vo.getOrdInvStatusHistory() == null ? null : vo.getOrdInvStatusHistory().getBeanCollection();
	}

	public ims.ocrr.vo.OrderInvestigationForStatusChangeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.OrderInvestigationForStatusChangeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.OrderInvestigationForStatusChangeVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.OrderInvestigationForStatusChangeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.OrderInvestigationForStatusChangeVo();
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
	public ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean getOrdInvCurrentStatus()
	{
		return this.ordinvcurrentstatus;
	}
	public void setOrdInvCurrentStatus(ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean value)
	{
		this.ordinvcurrentstatus = value;
	}
	public ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean[] getOrdInvStatusHistory()
	{
		return this.ordinvstatushistory;
	}
	public void setOrdInvStatusHistory(ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean[] value)
	{
		this.ordinvstatushistory = value;
	}

	private Integer id;
	private int version;
	private ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean ordinvcurrentstatus;
	private ims.ocrr.vo.beans.OrderedInvestigationStatusVoBean[] ordinvstatushistory;
}
