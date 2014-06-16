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

package ims.nursing.vo.beans;

public class PropertyChecklistVoBean extends ims.vo.ValueObjectBean
{
	public PropertyChecklistVoBean()
	{
	}
	public PropertyChecklistVoBean(ims.nursing.vo.PropertyChecklistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.movementtype = vo.getMovementType() == null ? null : (ims.vo.LookupInstanceBean)vo.getMovementType().getBean();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringhcp = vo.getAuthoringHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAuthoringHCP().getBean();
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocShortVoBean)vo.getWard().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.itemsretained = vo.getItemsRetained() == null ? null : vo.getItemsRetained().getBeanCollection();
		this.destinationward = vo.getDestinationWard() == null ? null : (ims.core.vo.beans.LocShortVoBean)vo.getDestinationWard().getBean();
		this.confirminghcp = vo.getConfirmingHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getConfirmingHCP().getBean();
		this.confirmingdatetime = vo.getConfirmingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConfirmingDateTime().getBean();
		this.valuables = vo.getValuables() == null ? null : vo.getValuables().getBeanCollection();
		this.othervaluables = vo.getOtherValuables();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.PropertyChecklistVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.movementtype = vo.getMovementType() == null ? null : (ims.vo.LookupInstanceBean)vo.getMovementType().getBean();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringhcp = vo.getAuthoringHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAuthoringHCP().getBean(map);
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocShortVoBean)vo.getWard().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.itemsretained = vo.getItemsRetained() == null ? null : vo.getItemsRetained().getBeanCollection();
		this.destinationward = vo.getDestinationWard() == null ? null : (ims.core.vo.beans.LocShortVoBean)vo.getDestinationWard().getBean(map);
		this.confirminghcp = vo.getConfirmingHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getConfirmingHCP().getBean(map);
		this.confirmingdatetime = vo.getConfirmingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConfirmingDateTime().getBean();
		this.valuables = vo.getValuables() == null ? null : vo.getValuables().getBeanCollection();
		this.othervaluables = vo.getOtherValuables();
	}

	public ims.nursing.vo.PropertyChecklistVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.PropertyChecklistVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.PropertyChecklistVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.PropertyChecklistVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.PropertyChecklistVo();
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
	public ims.vo.LookupInstanceBean getMovementType()
	{
		return this.movementtype;
	}
	public void setMovementType(ims.vo.LookupInstanceBean value)
	{
		this.movementtype = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getAuthoringHCP()
	{
		return this.authoringhcp;
	}
	public void setAuthoringHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.authoringhcp = value;
	}
	public ims.core.vo.beans.LocShortVoBean getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.beans.LocShortVoBean value)
	{
		this.ward = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.nursing.vo.beans.PropertyItemVoBean[] getItemsRetained()
	{
		return this.itemsretained;
	}
	public void setItemsRetained(ims.nursing.vo.beans.PropertyItemVoBean[] value)
	{
		this.itemsretained = value;
	}
	public ims.core.vo.beans.LocShortVoBean getDestinationWard()
	{
		return this.destinationward;
	}
	public void setDestinationWard(ims.core.vo.beans.LocShortVoBean value)
	{
		this.destinationward = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getConfirmingHCP()
	{
		return this.confirminghcp;
	}
	public void setConfirmingHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.confirminghcp = value;
	}
	public ims.framework.utils.beans.DateTimeBean getConfirmingDateTime()
	{
		return this.confirmingdatetime;
	}
	public void setConfirmingDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.confirmingdatetime = value;
	}
	public ims.nursing.vo.beans.ValuableVoBean[] getValuables()
	{
		return this.valuables;
	}
	public void setValuables(ims.nursing.vo.beans.ValuableVoBean[] value)
	{
		this.valuables = value;
	}
	public String getOtherValuables()
	{
		return this.othervaluables;
	}
	public void setOtherValuables(String value)
	{
		this.othervaluables = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean movementtype;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private ims.core.vo.beans.HcpLiteVoBean authoringhcp;
	private ims.core.vo.beans.LocShortVoBean ward;
	private ims.vo.RefVoBean carecontext;
	private ims.nursing.vo.beans.PropertyItemVoBean[] itemsretained;
	private ims.core.vo.beans.LocShortVoBean destinationward;
	private ims.core.vo.beans.HcpLiteVoBean confirminghcp;
	private ims.framework.utils.beans.DateTimeBean confirmingdatetime;
	private ims.nursing.vo.beans.ValuableVoBean[] valuables;
	private String othervaluables;
}
