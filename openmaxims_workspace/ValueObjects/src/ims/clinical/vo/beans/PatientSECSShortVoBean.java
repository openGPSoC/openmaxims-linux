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

public class PatientSECSShortVoBean extends ims.vo.ValueObjectBean
{
	public PatientSECSShortVoBean()
	{
	}
	public PatientSECSShortVoBean(ims.clinical.vo.PatientSECSShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.escalated = vo.getEscalated();
		this.secsscore = vo.getSECSScore();
		this.actiontaken = vo.getActionTaken();
		this.scoredetails = vo.getScoreDetails();
		this.recordinginformation = vo.getRecordingInformation() == null ? null : (ims.core.vo.beans.RecordingUserInformationVoBean)vo.getRecordingInformation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.PatientSECSShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.escalated = vo.getEscalated();
		this.secsscore = vo.getSECSScore();
		this.actiontaken = vo.getActionTaken();
		this.scoredetails = vo.getScoreDetails();
		this.recordinginformation = vo.getRecordingInformation() == null ? null : (ims.core.vo.beans.RecordingUserInformationVoBean)vo.getRecordingInformation().getBean(map);
	}

	public ims.clinical.vo.PatientSECSShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.PatientSECSShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.PatientSECSShortVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.PatientSECSShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.PatientSECSShortVo();
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
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public Boolean getEscalated()
	{
		return this.escalated;
	}
	public void setEscalated(Boolean value)
	{
		this.escalated = value;
	}
	public Integer getSECSScore()
	{
		return this.secsscore;
	}
	public void setSECSScore(Integer value)
	{
		this.secsscore = value;
	}
	public String getActionTaken()
	{
		return this.actiontaken;
	}
	public void setActionTaken(String value)
	{
		this.actiontaken = value;
	}
	public String getScoreDetails()
	{
		return this.scoredetails;
	}
	public void setScoreDetails(String value)
	{
		this.scoredetails = value;
	}
	public ims.core.vo.beans.RecordingUserInformationVoBean getRecordingInformation()
	{
		return this.recordinginformation;
	}
	public void setRecordingInformation(ims.core.vo.beans.RecordingUserInformationVoBean value)
	{
		this.recordinginformation = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private Boolean escalated;
	private Integer secsscore;
	private String actiontaken;
	private String scoredetails;
	private ims.core.vo.beans.RecordingUserInformationVoBean recordinginformation;
}
