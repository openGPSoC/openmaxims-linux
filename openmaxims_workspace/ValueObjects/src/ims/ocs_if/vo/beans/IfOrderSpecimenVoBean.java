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

package ims.ocs_if.vo.beans;

public class IfOrderSpecimenVoBean extends ims.vo.ValueObjectBean
{
	public IfOrderSpecimenVoBean()
	{
	}
	public IfOrderSpecimenVoBean(ims.ocs_if.vo.IfOrderSpecimenVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.colldatetimeplacer = vo.getCollDateTimePlacer() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCollDateTimePlacer().getBean();
		this.colldatetimefiller = vo.getCollDateTimeFiller() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCollDateTimeFiller().getBean();
		this.coltimefillersupplied = vo.getColTimeFillerSupplied();
		this.collenddatetimeplacer = vo.getCollEndDateTimePlacer() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCollEndDateTimePlacer().getBean();
		this.collenddatetimefiller = vo.getCollEndDateTimeFiller() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCollEndDateTimeFiller().getBean();
		this.sitetext = vo.getSiteText();
		this.specimensource = vo.getSpecimenSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenSource().getBean();
		this.discipline = vo.getDiscipline() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getDiscipline().getBean();
		this.collectingmos = vo.getCollectingMos() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getCollectingMos().getBean();
		this.ispatientcollect = vo.getIsPatientCollect();
		this.isawaitingcollection = vo.getIsAwaitingCollection();
		this.receiveddatetime = vo.getReceivedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReceivedDateTime().getBean();
		this.receivedtimesupplied = vo.getReceivedTimeSupplied();
		this.fillerordnum = vo.getFillerOrdNum();
		this.collectorcomment = vo.getCollectorComment();
		this.sitecd = vo.getSiteCd() == null ? null : (ims.vo.LookupInstanceBean)vo.getSiteCd().getBean();
		this.wasprocessed = vo.getWasProcessed();
		this.placerordnum = vo.getPlacerOrdNum();
		this.dftspecimenresulted = vo.getDftSpecimenResulted() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDftSpecimenResulted().getBean();
		this.dftspecimenresultedtimesupplied = vo.getDftSpecimenResultedTimeSupplied();
		this.investigations = vo.getInvestigations() == null ? null : vo.getInvestigations().getBeanCollection();
		this.order = vo.getOrder() == null ? null : new ims.vo.RefVoBean(vo.getOrder().getBoId(), vo.getOrder().getBoVersion());
		this.pathresult = vo.getPathResult() == null ? null : vo.getPathResult().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocs_if.vo.IfOrderSpecimenVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.colldatetimeplacer = vo.getCollDateTimePlacer() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCollDateTimePlacer().getBean();
		this.colldatetimefiller = vo.getCollDateTimeFiller() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCollDateTimeFiller().getBean();
		this.coltimefillersupplied = vo.getColTimeFillerSupplied();
		this.collenddatetimeplacer = vo.getCollEndDateTimePlacer() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCollEndDateTimePlacer().getBean();
		this.collenddatetimefiller = vo.getCollEndDateTimeFiller() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCollEndDateTimeFiller().getBean();
		this.sitetext = vo.getSiteText();
		this.specimensource = vo.getSpecimenSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenSource().getBean();
		this.discipline = vo.getDiscipline() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getDiscipline().getBean(map);
		this.collectingmos = vo.getCollectingMos() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getCollectingMos().getBean(map);
		this.ispatientcollect = vo.getIsPatientCollect();
		this.isawaitingcollection = vo.getIsAwaitingCollection();
		this.receiveddatetime = vo.getReceivedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReceivedDateTime().getBean();
		this.receivedtimesupplied = vo.getReceivedTimeSupplied();
		this.fillerordnum = vo.getFillerOrdNum();
		this.collectorcomment = vo.getCollectorComment();
		this.sitecd = vo.getSiteCd() == null ? null : (ims.vo.LookupInstanceBean)vo.getSiteCd().getBean();
		this.wasprocessed = vo.getWasProcessed();
		this.placerordnum = vo.getPlacerOrdNum();
		this.dftspecimenresulted = vo.getDftSpecimenResulted() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDftSpecimenResulted().getBean();
		this.dftspecimenresultedtimesupplied = vo.getDftSpecimenResultedTimeSupplied();
		this.investigations = vo.getInvestigations() == null ? null : vo.getInvestigations().getBeanCollection();
		this.order = vo.getOrder() == null ? null : new ims.vo.RefVoBean(vo.getOrder().getBoId(), vo.getOrder().getBoVersion());
		this.pathresult = vo.getPathResult() == null ? null : vo.getPathResult().getBeanCollection();
	}

	public ims.ocs_if.vo.IfOrderSpecimenVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocs_if.vo.IfOrderSpecimenVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocs_if.vo.IfOrderSpecimenVo vo = null;
		if(map != null)
			vo = (ims.ocs_if.vo.IfOrderSpecimenVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocs_if.vo.IfOrderSpecimenVo();
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
	public ims.framework.utils.beans.DateTimeBean getCollDateTimePlacer()
	{
		return this.colldatetimeplacer;
	}
	public void setCollDateTimePlacer(ims.framework.utils.beans.DateTimeBean value)
	{
		this.colldatetimeplacer = value;
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
	public ims.framework.utils.beans.DateTimeBean getCollEndDateTimePlacer()
	{
		return this.collenddatetimeplacer;
	}
	public void setCollEndDateTimePlacer(ims.framework.utils.beans.DateTimeBean value)
	{
		this.collenddatetimeplacer = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCollEndDateTimeFiller()
	{
		return this.collenddatetimefiller;
	}
	public void setCollEndDateTimeFiller(ims.framework.utils.beans.DateTimeBean value)
	{
		this.collenddatetimefiller = value;
	}
	public String getSiteText()
	{
		return this.sitetext;
	}
	public void setSiteText(String value)
	{
		this.sitetext = value;
	}
	public ims.vo.LookupInstanceBean getSpecimenSource()
	{
		return this.specimensource;
	}
	public void setSpecimenSource(ims.vo.LookupInstanceBean value)
	{
		this.specimensource = value;
	}
	public ims.core.vo.beans.ServiceLiteVoBean getDiscipline()
	{
		return this.discipline;
	}
	public void setDiscipline(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.discipline = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getCollectingMos()
	{
		return this.collectingmos;
	}
	public void setCollectingMos(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.collectingmos = value;
	}
	public Boolean getIsPatientCollect()
	{
		return this.ispatientcollect;
	}
	public void setIsPatientCollect(Boolean value)
	{
		this.ispatientcollect = value;
	}
	public Boolean getIsAwaitingCollection()
	{
		return this.isawaitingcollection;
	}
	public void setIsAwaitingCollection(Boolean value)
	{
		this.isawaitingcollection = value;
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
	public String getFillerOrdNum()
	{
		return this.fillerordnum;
	}
	public void setFillerOrdNum(String value)
	{
		this.fillerordnum = value;
	}
	public String getCollectorComment()
	{
		return this.collectorcomment;
	}
	public void setCollectorComment(String value)
	{
		this.collectorcomment = value;
	}
	public ims.vo.LookupInstanceBean getSiteCd()
	{
		return this.sitecd;
	}
	public void setSiteCd(ims.vo.LookupInstanceBean value)
	{
		this.sitecd = value;
	}
	public Boolean getWasProcessed()
	{
		return this.wasprocessed;
	}
	public void setWasProcessed(Boolean value)
	{
		this.wasprocessed = value;
	}
	public String getPlacerOrdNum()
	{
		return this.placerordnum;
	}
	public void setPlacerOrdNum(String value)
	{
		this.placerordnum = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDftSpecimenResulted()
	{
		return this.dftspecimenresulted;
	}
	public void setDftSpecimenResulted(ims.framework.utils.beans.DateTimeBean value)
	{
		this.dftspecimenresulted = value;
	}
	public Boolean getDftSpecimenResultedTimeSupplied()
	{
		return this.dftspecimenresultedtimesupplied;
	}
	public void setDftSpecimenResultedTimeSupplied(Boolean value)
	{
		this.dftspecimenresultedtimesupplied = value;
	}
	public ims.ocs_if.vo.beans.IfOrderInvestigationVoBean[] getInvestigations()
	{
		return this.investigations;
	}
	public void setInvestigations(ims.ocs_if.vo.beans.IfOrderInvestigationVoBean[] value)
	{
		this.investigations = value;
	}
	public ims.vo.RefVoBean getOrder()
	{
		return this.order;
	}
	public void setOrder(ims.vo.RefVoBean value)
	{
		this.order = value;
	}
	public ims.ocs_if.vo.beans.IfOcsPathResultVoBean[] getPathResult()
	{
		return this.pathresult;
	}
	public void setPathResult(ims.ocs_if.vo.beans.IfOcsPathResultVoBean[] value)
	{
		this.pathresult = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean colldatetimeplacer;
	private ims.framework.utils.beans.DateTimeBean colldatetimefiller;
	private Boolean coltimefillersupplied;
	private ims.framework.utils.beans.DateTimeBean collenddatetimeplacer;
	private ims.framework.utils.beans.DateTimeBean collenddatetimefiller;
	private String sitetext;
	private ims.vo.LookupInstanceBean specimensource;
	private ims.core.vo.beans.ServiceLiteVoBean discipline;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean collectingmos;
	private Boolean ispatientcollect;
	private Boolean isawaitingcollection;
	private ims.framework.utils.beans.DateTimeBean receiveddatetime;
	private Boolean receivedtimesupplied;
	private String fillerordnum;
	private String collectorcomment;
	private ims.vo.LookupInstanceBean sitecd;
	private Boolean wasprocessed;
	private String placerordnum;
	private ims.framework.utils.beans.DateTimeBean dftspecimenresulted;
	private Boolean dftspecimenresultedtimesupplied;
	private ims.ocs_if.vo.beans.IfOrderInvestigationVoBean[] investigations;
	private ims.vo.RefVoBean order;
	private ims.ocs_if.vo.beans.IfOcsPathResultVoBean[] pathresult;
}
