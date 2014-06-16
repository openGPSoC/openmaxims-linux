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

public class AdviceLeafletsForSelectAndPrinterVoBean extends ims.vo.ValueObjectBean
{
	public AdviceLeafletsForSelectAndPrinterVoBean()
	{
	}
	public AdviceLeafletsForSelectAndPrinterVoBean(ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.adviceleaflet = vo.getAdviceLeaflet() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdviceLeaflet().getBean();
		this.template = vo.getTemplate() == null ? null : new ims.vo.RefVoBean(vo.getTemplate().getBoId(), vo.getTemplate().getBoVersion());
		this.dategiven = vo.getDateGiven() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateGiven().getBean();
		this.givento = vo.getGivenTo() == null ? null : (ims.vo.LookupInstanceBean)vo.getGivenTo().getBean();
		this.giventoname = vo.getGivenToName();
		this.leafletversion = vo.getLeafletVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringhcp = vo.getAuthoringHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAuthoringHCP().getBean();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.adviceleaflet = vo.getAdviceLeaflet() == null ? null : (ims.vo.LookupInstanceBean)vo.getAdviceLeaflet().getBean();
		this.template = vo.getTemplate() == null ? null : new ims.vo.RefVoBean(vo.getTemplate().getBoId(), vo.getTemplate().getBoVersion());
		this.dategiven = vo.getDateGiven() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateGiven().getBean();
		this.givento = vo.getGivenTo() == null ? null : (ims.vo.LookupInstanceBean)vo.getGivenTo().getBean();
		this.giventoname = vo.getGivenToName();
		this.leafletversion = vo.getLeafletVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringhcp = vo.getAuthoringHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAuthoringHCP().getBean(map);
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
	}

	public ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.AdviceLeafletsForSelectAndPrinterVo();
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
	public ims.vo.LookupInstanceBean getAdviceLeaflet()
	{
		return this.adviceleaflet;
	}
	public void setAdviceLeaflet(ims.vo.LookupInstanceBean value)
	{
		this.adviceleaflet = value;
	}
	public ims.vo.RefVoBean getTemplate()
	{
		return this.template;
	}
	public void setTemplate(ims.vo.RefVoBean value)
	{
		this.template = value;
	}
	public ims.framework.utils.beans.DateBean getDateGiven()
	{
		return this.dategiven;
	}
	public void setDateGiven(ims.framework.utils.beans.DateBean value)
	{
		this.dategiven = value;
	}
	public ims.vo.LookupInstanceBean getGivenTo()
	{
		return this.givento;
	}
	public void setGivenTo(ims.vo.LookupInstanceBean value)
	{
		this.givento = value;
	}
	public String getGivenToName()
	{
		return this.giventoname;
	}
	public void setGivenToName(String value)
	{
		this.giventoname = value;
	}
	public String getLeafletVersion()
	{
		return this.leafletversion;
	}
	public void setLeafletVersion(String value)
	{
		this.leafletversion = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getAuthoringHCP()
	{
		return this.authoringhcp;
	}
	public void setAuthoringHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.authoringhcp = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean adviceleaflet;
	private ims.vo.RefVoBean template;
	private ims.framework.utils.beans.DateBean dategiven;
	private ims.vo.LookupInstanceBean givento;
	private String giventoname;
	private String leafletversion;
	private ims.vo.RefVoBean carecontext;
	private ims.core.vo.beans.HcpLiteVoBean authoringhcp;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
}
