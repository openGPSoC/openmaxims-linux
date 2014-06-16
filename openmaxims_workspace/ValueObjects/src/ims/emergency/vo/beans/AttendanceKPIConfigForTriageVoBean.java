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

public class AttendanceKPIConfigForTriageVoBean extends ims.vo.ValueObjectBean
{
	public AttendanceKPIConfigForTriageVoBean()
	{
	}
	public AttendanceKPIConfigForTriageVoBean(ims.emergency.vo.AttendanceKPIConfigForTriageVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.awaitingtriagebreachwarningkpi = vo.getAwaitingTriageBreachWarningKPI();
		this.awaitingtriagebreachedkpi = vo.getAwaitingTriageBreachedKPI();
		this.edlocation = vo.getEDLocation() == null ? null : new ims.vo.RefVoBean(vo.getEDLocation().getBoId(), vo.getEDLocation().getBoVersion());
		this.triageprioritykpis = vo.getTriagePriorityKPIs() == null ? null : vo.getTriagePriorityKPIs().getBeanCollection();
		this.awaitingtriagebreachwarningkpiflashingtext = vo.getAwaitingTriageBreachWarningKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getAwaitingTriageBreachWarningKPIFlashingText().getBean();
		this.awaitingtriagebreachwarningkpiflashingtextcolour = vo.getAwaitingTriageBreachWarningKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachWarningKPIFlashingTextColour().getBean();
		this.awaitingtriagebreachwarningkpibackgroundcolour = vo.getAwaitingTriageBreachWarningKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachWarningKPIBackgroundColour().getBean();
		this.awaitingtriagebreachkpiflashingtext = vo.getAwaitingTriageBreachKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getAwaitingTriageBreachKPIFlashingText().getBean();
		this.awaitingtriagebreachkpiflashingtextcolour = vo.getAwaitingTriageBreachKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachKPIFlashingTextColour().getBean();
		this.awaitingtriagebreachkpibackgroundcolour = vo.getAwaitingTriageBreachKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachKPIBackgroundColour().getBean();
		this.awaitingtriagebreachwarningkpitextcolour = vo.getAwaitingTriageBreachWarningKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachWarningKPITextColour().getBean();
		this.awaitingtriagebreachkpitextcolour = vo.getAwaitingTriageBreachKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachKPITextColour().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.AttendanceKPIConfigForTriageVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.awaitingtriagebreachwarningkpi = vo.getAwaitingTriageBreachWarningKPI();
		this.awaitingtriagebreachedkpi = vo.getAwaitingTriageBreachedKPI();
		this.edlocation = vo.getEDLocation() == null ? null : new ims.vo.RefVoBean(vo.getEDLocation().getBoId(), vo.getEDLocation().getBoVersion());
		this.triageprioritykpis = vo.getTriagePriorityKPIs() == null ? null : vo.getTriagePriorityKPIs().getBeanCollection();
		this.awaitingtriagebreachwarningkpiflashingtext = vo.getAwaitingTriageBreachWarningKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getAwaitingTriageBreachWarningKPIFlashingText().getBean();
		this.awaitingtriagebreachwarningkpiflashingtextcolour = vo.getAwaitingTriageBreachWarningKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachWarningKPIFlashingTextColour().getBean();
		this.awaitingtriagebreachwarningkpibackgroundcolour = vo.getAwaitingTriageBreachWarningKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachWarningKPIBackgroundColour().getBean();
		this.awaitingtriagebreachkpiflashingtext = vo.getAwaitingTriageBreachKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getAwaitingTriageBreachKPIFlashingText().getBean();
		this.awaitingtriagebreachkpiflashingtextcolour = vo.getAwaitingTriageBreachKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachKPIFlashingTextColour().getBean();
		this.awaitingtriagebreachkpibackgroundcolour = vo.getAwaitingTriageBreachKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachKPIBackgroundColour().getBean();
		this.awaitingtriagebreachwarningkpitextcolour = vo.getAwaitingTriageBreachWarningKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachWarningKPITextColour().getBean();
		this.awaitingtriagebreachkpitextcolour = vo.getAwaitingTriageBreachKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getAwaitingTriageBreachKPITextColour().getBean();
	}

	public ims.emergency.vo.AttendanceKPIConfigForTriageVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.AttendanceKPIConfigForTriageVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.AttendanceKPIConfigForTriageVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.AttendanceKPIConfigForTriageVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.AttendanceKPIConfigForTriageVo();
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
	public Integer getAwaitingTriageBreachWarningKPI()
	{
		return this.awaitingtriagebreachwarningkpi;
	}
	public void setAwaitingTriageBreachWarningKPI(Integer value)
	{
		this.awaitingtriagebreachwarningkpi = value;
	}
	public Integer getAwaitingTriageBreachedKPI()
	{
		return this.awaitingtriagebreachedkpi;
	}
	public void setAwaitingTriageBreachedKPI(Integer value)
	{
		this.awaitingtriagebreachedkpi = value;
	}
	public ims.vo.RefVoBean getEDLocation()
	{
		return this.edlocation;
	}
	public void setEDLocation(ims.vo.RefVoBean value)
	{
		this.edlocation = value;
	}
	public ims.emergency.vo.beans.TriagePriorityKpConfigVoBean[] getTriagePriorityKPIs()
	{
		return this.triageprioritykpis;
	}
	public void setTriagePriorityKPIs(ims.emergency.vo.beans.TriagePriorityKpConfigVoBean[] value)
	{
		this.triageprioritykpis = value;
	}
	public ims.vo.LookupInstanceBean getAwaitingTriageBreachWarningKPIFlashingText()
	{
		return this.awaitingtriagebreachwarningkpiflashingtext;
	}
	public void setAwaitingTriageBreachWarningKPIFlashingText(ims.vo.LookupInstanceBean value)
	{
		this.awaitingtriagebreachwarningkpiflashingtext = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingTriageBreachWarningKPIFlashingTextColour()
	{
		return this.awaitingtriagebreachwarningkpiflashingtextcolour;
	}
	public void setAwaitingTriageBreachWarningKPIFlashingTextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingtriagebreachwarningkpiflashingtextcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingTriageBreachWarningKPIBackgroundColour()
	{
		return this.awaitingtriagebreachwarningkpibackgroundcolour;
	}
	public void setAwaitingTriageBreachWarningKPIBackgroundColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingtriagebreachwarningkpibackgroundcolour = value;
	}
	public ims.vo.LookupInstanceBean getAwaitingTriageBreachKPIFlashingText()
	{
		return this.awaitingtriagebreachkpiflashingtext;
	}
	public void setAwaitingTriageBreachKPIFlashingText(ims.vo.LookupInstanceBean value)
	{
		this.awaitingtriagebreachkpiflashingtext = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingTriageBreachKPIFlashingTextColour()
	{
		return this.awaitingtriagebreachkpiflashingtextcolour;
	}
	public void setAwaitingTriageBreachKPIFlashingTextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingtriagebreachkpiflashingtextcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingTriageBreachKPIBackgroundColour()
	{
		return this.awaitingtriagebreachkpibackgroundcolour;
	}
	public void setAwaitingTriageBreachKPIBackgroundColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingtriagebreachkpibackgroundcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingTriageBreachWarningKPITextColour()
	{
		return this.awaitingtriagebreachwarningkpitextcolour;
	}
	public void setAwaitingTriageBreachWarningKPITextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingtriagebreachwarningkpitextcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getAwaitingTriageBreachKPITextColour()
	{
		return this.awaitingtriagebreachkpitextcolour;
	}
	public void setAwaitingTriageBreachKPITextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.awaitingtriagebreachkpitextcolour = value;
	}

	private Integer id;
	private int version;
	private Integer awaitingtriagebreachwarningkpi;
	private Integer awaitingtriagebreachedkpi;
	private ims.vo.RefVoBean edlocation;
	private ims.emergency.vo.beans.TriagePriorityKpConfigVoBean[] triageprioritykpis;
	private ims.vo.LookupInstanceBean awaitingtriagebreachwarningkpiflashingtext;
	private ims.framework.utils.beans.ColorBean awaitingtriagebreachwarningkpiflashingtextcolour;
	private ims.framework.utils.beans.ColorBean awaitingtriagebreachwarningkpibackgroundcolour;
	private ims.vo.LookupInstanceBean awaitingtriagebreachkpiflashingtext;
	private ims.framework.utils.beans.ColorBean awaitingtriagebreachkpiflashingtextcolour;
	private ims.framework.utils.beans.ColorBean awaitingtriagebreachkpibackgroundcolour;
	private ims.framework.utils.beans.ColorBean awaitingtriagebreachwarningkpitextcolour;
	private ims.framework.utils.beans.ColorBean awaitingtriagebreachkpitextcolour;
}
