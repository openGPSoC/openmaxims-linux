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

package ims.clinical.vo.beans;

public class InpatientEpisodeWithCareContextVoBean extends ims.vo.ValueObjectBean
{
	public InpatientEpisodeWithCareContextVoBean()
	{
	}
	public InpatientEpisodeWithCareContextVoBean(ims.clinical.vo.InpatientEpisodeWithCareContextVo vo)
	{
		this.inpatientepisode = vo.getInpatientEpisode() == null ? null : (ims.clinical.vo.beans.InpatientEpisodeForHospitalAtNightVoBean)vo.getInpatientEpisode().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.InpatientEpisodeWithCareContextVo vo)
	{
		this.inpatientepisode = vo.getInpatientEpisode() == null ? null : (ims.clinical.vo.beans.InpatientEpisodeForHospitalAtNightVoBean)vo.getInpatientEpisode().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
	}

	public ims.clinical.vo.InpatientEpisodeWithCareContextVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.InpatientEpisodeWithCareContextVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.InpatientEpisodeWithCareContextVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.InpatientEpisodeWithCareContextVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.InpatientEpisodeWithCareContextVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.clinical.vo.beans.InpatientEpisodeForHospitalAtNightVoBean getInpatientEpisode()
	{
		return this.inpatientepisode;
	}
	public void setInpatientEpisode(ims.clinical.vo.beans.InpatientEpisodeForHospitalAtNightVoBean value)
	{
		this.inpatientepisode = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}

	private ims.clinical.vo.beans.InpatientEpisodeForHospitalAtNightVoBean inpatientepisode;
	private ims.vo.RefVoBean carecontext;
}
