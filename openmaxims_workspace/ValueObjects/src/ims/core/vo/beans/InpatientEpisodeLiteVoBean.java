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

package ims.core.vo.beans;

public class InpatientEpisodeLiteVoBean extends ims.vo.ValueObjectBean
{
	public InpatientEpisodeLiteVoBean()
	{
	}
	public InpatientEpisodeLiteVoBean(ims.core.vo.InpatientEpisodeLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventADTVoBean)vo.getPasEvent().getBean();
		this.estdischargedate = vo.getEstDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEstDischargeDate().getBean();
		this.isconfirmeddischarge = vo.getIsConfirmedDischarge();
		if(vo.getWardStays() != null)
		{
			this.wardstays = new ims.vo.RefVoBean[vo.getWardStays().size()];
			for(int wardstays_i = 0; wardstays_i < vo.getWardStays().size(); wardstays_i++)
			{
				this.wardstays[wardstays_i] = new ims.vo.RefVoBean(vo.getWardStays().get(wardstays_i).getBoId(),vo.getWardStays().get(wardstays_i).getBoVersion());
			}
		}
		if(vo.getConsultantStays() != null)
		{
			this.consultantstays = new ims.vo.RefVoBean[vo.getConsultantStays().size()];
			for(int consultantstays_i = 0; consultantstays_i < vo.getConsultantStays().size(); consultantstays_i++)
			{
				this.consultantstays[consultantstays_i] = new ims.vo.RefVoBean(vo.getConsultantStays().get(consultantstays_i).getBoId(),vo.getConsultantStays().get(consultantstays_i).getBoVersion());
			}
		}
		this.confirmeddischargedatetime = vo.getConfirmedDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConfirmedDischargeDateTime().getBean();
		this.ismaternityinpatient = vo.getIsMaternityInpatient();
		this.bed = vo.getBed() == null ? null : (ims.core.vo.beans.BedSpaceStateBayOnlyVoBean)vo.getBed().getBean();
		this.dischargereadydate = vo.getDischargeReadyDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeReadyDate().getBean();
		this.isonhomeleave = vo.getIsOnHomeLeave();
		this.expecteddateofreturn = vo.getExpectedDateOfReturn() == null ? null : (ims.framework.utils.beans.DateBean)vo.getExpectedDateOfReturn().getBean();
		this.expectedtimeofreturn = vo.getExpectedTimeOfReturn() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getExpectedTimeOfReturn().getBean();
		this.vacatedbednumber = vo.getVacatedBedNumber();
		this.dateonhomeleave = vo.getDateOnHomeLeave() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOnHomeLeave().getBean();
		this.vteassessmentstatus = vo.getVTEAssessmentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getVTEAssessmentStatus().getBean();
		this.vteriskassessment = vo.getVTERiskAssessment() == null ? null : new ims.vo.RefVoBean(vo.getVTERiskAssessment().getBoId(), vo.getVTERiskAssessment().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.InpatientEpisodeLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.core.vo.beans.PasEventADTVoBean)vo.getPasEvent().getBean(map);
		this.estdischargedate = vo.getEstDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEstDischargeDate().getBean();
		this.isconfirmeddischarge = vo.getIsConfirmedDischarge();
		if(vo.getWardStays() != null)
		{
			this.wardstays = new ims.vo.RefVoBean[vo.getWardStays().size()];
			for(int wardstays_i = 0; wardstays_i < vo.getWardStays().size(); wardstays_i++)
			{
				this.wardstays[wardstays_i] = new ims.vo.RefVoBean(vo.getWardStays().get(wardstays_i).getBoId(),vo.getWardStays().get(wardstays_i).getBoVersion());
			}
		}
		if(vo.getConsultantStays() != null)
		{
			this.consultantstays = new ims.vo.RefVoBean[vo.getConsultantStays().size()];
			for(int consultantstays_i = 0; consultantstays_i < vo.getConsultantStays().size(); consultantstays_i++)
			{
				this.consultantstays[consultantstays_i] = new ims.vo.RefVoBean(vo.getConsultantStays().get(consultantstays_i).getBoId(),vo.getConsultantStays().get(consultantstays_i).getBoVersion());
			}
		}
		this.confirmeddischargedatetime = vo.getConfirmedDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConfirmedDischargeDateTime().getBean();
		this.ismaternityinpatient = vo.getIsMaternityInpatient();
		this.bed = vo.getBed() == null ? null : (ims.core.vo.beans.BedSpaceStateBayOnlyVoBean)vo.getBed().getBean(map);
		this.dischargereadydate = vo.getDischargeReadyDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeReadyDate().getBean();
		this.isonhomeleave = vo.getIsOnHomeLeave();
		this.expecteddateofreturn = vo.getExpectedDateOfReturn() == null ? null : (ims.framework.utils.beans.DateBean)vo.getExpectedDateOfReturn().getBean();
		this.expectedtimeofreturn = vo.getExpectedTimeOfReturn() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getExpectedTimeOfReturn().getBean();
		this.vacatedbednumber = vo.getVacatedBedNumber();
		this.dateonhomeleave = vo.getDateOnHomeLeave() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOnHomeLeave().getBean();
		this.vteassessmentstatus = vo.getVTEAssessmentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getVTEAssessmentStatus().getBean();
		this.vteriskassessment = vo.getVTERiskAssessment() == null ? null : new ims.vo.RefVoBean(vo.getVTERiskAssessment().getBoId(), vo.getVTERiskAssessment().getBoVersion());
	}

	public ims.core.vo.InpatientEpisodeLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.InpatientEpisodeLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.InpatientEpisodeLiteVo vo = null;
		if(map != null)
			vo = (ims.core.vo.InpatientEpisodeLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.InpatientEpisodeLiteVo();
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
	public ims.core.vo.beans.PasEventADTVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.beans.PasEventADTVoBean value)
	{
		this.pasevent = value;
	}
	public ims.framework.utils.beans.DateBean getEstDischargeDate()
	{
		return this.estdischargedate;
	}
	public void setEstDischargeDate(ims.framework.utils.beans.DateBean value)
	{
		this.estdischargedate = value;
	}
	public Boolean getIsConfirmedDischarge()
	{
		return this.isconfirmeddischarge;
	}
	public void setIsConfirmedDischarge(Boolean value)
	{
		this.isconfirmeddischarge = value;
	}
	public ims.vo.RefVoBean[] getWardStays()
	{
		return this.wardstays;
	}
	public void setWardStays(ims.vo.RefVoBean[] value)
	{
		this.wardstays = value;
	}
	public ims.vo.RefVoBean[] getConsultantStays()
	{
		return this.consultantstays;
	}
	public void setConsultantStays(ims.vo.RefVoBean[] value)
	{
		this.consultantstays = value;
	}
	public ims.framework.utils.beans.DateTimeBean getConfirmedDischargeDateTime()
	{
		return this.confirmeddischargedatetime;
	}
	public void setConfirmedDischargeDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.confirmeddischargedatetime = value;
	}
	public Boolean getIsMaternityInpatient()
	{
		return this.ismaternityinpatient;
	}
	public void setIsMaternityInpatient(Boolean value)
	{
		this.ismaternityinpatient = value;
	}
	public ims.core.vo.beans.BedSpaceStateBayOnlyVoBean getBed()
	{
		return this.bed;
	}
	public void setBed(ims.core.vo.beans.BedSpaceStateBayOnlyVoBean value)
	{
		this.bed = value;
	}
	public ims.framework.utils.beans.DateBean getDischargeReadyDate()
	{
		return this.dischargereadydate;
	}
	public void setDischargeReadyDate(ims.framework.utils.beans.DateBean value)
	{
		this.dischargereadydate = value;
	}
	public Boolean getIsOnHomeLeave()
	{
		return this.isonhomeleave;
	}
	public void setIsOnHomeLeave(Boolean value)
	{
		this.isonhomeleave = value;
	}
	public ims.framework.utils.beans.DateBean getExpectedDateOfReturn()
	{
		return this.expecteddateofreturn;
	}
	public void setExpectedDateOfReturn(ims.framework.utils.beans.DateBean value)
	{
		this.expecteddateofreturn = value;
	}
	public ims.framework.utils.beans.TimeBean getExpectedTimeOfReturn()
	{
		return this.expectedtimeofreturn;
	}
	public void setExpectedTimeOfReturn(ims.framework.utils.beans.TimeBean value)
	{
		this.expectedtimeofreturn = value;
	}
	public String getVacatedBedNumber()
	{
		return this.vacatedbednumber;
	}
	public void setVacatedBedNumber(String value)
	{
		this.vacatedbednumber = value;
	}
	public ims.framework.utils.beans.DateBean getDateOnHomeLeave()
	{
		return this.dateonhomeleave;
	}
	public void setDateOnHomeLeave(ims.framework.utils.beans.DateBean value)
	{
		this.dateonhomeleave = value;
	}
	public ims.vo.LookupInstanceBean getVTEAssessmentStatus()
	{
		return this.vteassessmentstatus;
	}
	public void setVTEAssessmentStatus(ims.vo.LookupInstanceBean value)
	{
		this.vteassessmentstatus = value;
	}
	public ims.vo.RefVoBean getVTERiskAssessment()
	{
		return this.vteriskassessment;
	}
	public void setVTERiskAssessment(ims.vo.RefVoBean value)
	{
		this.vteriskassessment = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PasEventADTVoBean pasevent;
	private ims.framework.utils.beans.DateBean estdischargedate;
	private Boolean isconfirmeddischarge;
	private ims.vo.RefVoBean[] wardstays;
	private ims.vo.RefVoBean[] consultantstays;
	private ims.framework.utils.beans.DateTimeBean confirmeddischargedatetime;
	private Boolean ismaternityinpatient;
	private ims.core.vo.beans.BedSpaceStateBayOnlyVoBean bed;
	private ims.framework.utils.beans.DateBean dischargereadydate;
	private Boolean isonhomeleave;
	private ims.framework.utils.beans.DateBean expecteddateofreturn;
	private ims.framework.utils.beans.TimeBean expectedtimeofreturn;
	private String vacatedbednumber;
	private ims.framework.utils.beans.DateBean dateonhomeleave;
	private ims.vo.LookupInstanceBean vteassessmentstatus;
	private ims.vo.RefVoBean vteriskassessment;
}
