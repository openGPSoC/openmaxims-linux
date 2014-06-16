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

public class DischargeClinicalInformationVoBean extends ims.vo.ValueObjectBean
{
	public DischargeClinicalInformationVoBean()
	{
	}
	public DischargeClinicalInformationVoBean(ims.core.vo.DischargeClinicalInformationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.presentingcomplaints = vo.getPresentingComplaints();
		this.summaryofadmission = vo.getSummaryOfAdmission();
		this.investigationcomments = vo.getInvestigationComments();
		this.relevanttreatments = vo.getRelevantTreatments();
		this.additionalcomments = vo.getAdditionalComments();
		this.results = vo.getResults() == null ? null : vo.getResults().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.DischargeClinicalInformationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.presentingcomplaints = vo.getPresentingComplaints();
		this.summaryofadmission = vo.getSummaryOfAdmission();
		this.investigationcomments = vo.getInvestigationComments();
		this.relevanttreatments = vo.getRelevantTreatments();
		this.additionalcomments = vo.getAdditionalComments();
		this.results = vo.getResults() == null ? null : vo.getResults().getBeanCollection();
	}

	public ims.core.vo.DischargeClinicalInformationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.DischargeClinicalInformationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.DischargeClinicalInformationVo vo = null;
		if(map != null)
			vo = (ims.core.vo.DischargeClinicalInformationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.DischargeClinicalInformationVo();
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
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public String getPresentingComplaints()
	{
		return this.presentingcomplaints;
	}
	public void setPresentingComplaints(String value)
	{
		this.presentingcomplaints = value;
	}
	public String getSummaryOfAdmission()
	{
		return this.summaryofadmission;
	}
	public void setSummaryOfAdmission(String value)
	{
		this.summaryofadmission = value;
	}
	public String getInvestigationComments()
	{
		return this.investigationcomments;
	}
	public void setInvestigationComments(String value)
	{
		this.investigationcomments = value;
	}
	public String getRelevantTreatments()
	{
		return this.relevanttreatments;
	}
	public void setRelevantTreatments(String value)
	{
		this.relevanttreatments = value;
	}
	public String getAdditionalComments()
	{
		return this.additionalcomments;
	}
	public void setAdditionalComments(String value)
	{
		this.additionalcomments = value;
	}
	public ims.ocrr.vo.beans.OrderInvestigationBookingVoBean[] getResults()
	{
		return this.results;
	}
	public void setResults(ims.ocrr.vo.beans.OrderInvestigationBookingVoBean[] value)
	{
		this.results = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean carecontext;
	private String presentingcomplaints;
	private String summaryofadmission;
	private String investigationcomments;
	private String relevanttreatments;
	private String additionalcomments;
	private ims.ocrr.vo.beans.OrderInvestigationBookingVoBean[] results;
}
