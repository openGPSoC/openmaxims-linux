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

package ims.careuk.vo.beans;

public class ContractConfigVoBean extends ims.vo.ValueObjectBean
{
	public ContractConfigVoBean()
	{
	}
	public ContractConfigVoBean(ims.careuk.vo.ContractConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.contractid = vo.getContractId();
		this.contractname = vo.getContractName();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.contractorganisation = vo.getContractOrganisation() == null ? null : (ims.core.vo.beans.OrganisationLiteVoBean)vo.getContractOrganisation().getBean();
		this.daystorttbreachdate = vo.getDaysToRTTBreachDate();
		this.contracttype = vo.getContractType() == null ? null : (ims.vo.LookupInstanceBean)vo.getContractType().getBean();
		this.daysto1stappt = vo.getDaysTo1stAppt();
		this.contractkpihistory = vo.getContractKPIHistory() == null ? null : vo.getContractKPIHistory().getBeanCollection();
		this.servicelocations = vo.getServiceLocations() == null ? null : vo.getServiceLocations().getBeanCollection();
		this.ccgsforcontract = vo.getCCGsForContract() == null ? null : vo.getCCGsForContract().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.ContractConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.contractid = vo.getContractId();
		this.contractname = vo.getContractName();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.contractorganisation = vo.getContractOrganisation() == null ? null : (ims.core.vo.beans.OrganisationLiteVoBean)vo.getContractOrganisation().getBean(map);
		this.daystorttbreachdate = vo.getDaysToRTTBreachDate();
		this.contracttype = vo.getContractType() == null ? null : (ims.vo.LookupInstanceBean)vo.getContractType().getBean();
		this.daysto1stappt = vo.getDaysTo1stAppt();
		this.contractkpihistory = vo.getContractKPIHistory() == null ? null : vo.getContractKPIHistory().getBeanCollection();
		this.servicelocations = vo.getServiceLocations() == null ? null : vo.getServiceLocations().getBeanCollection();
		this.ccgsforcontract = vo.getCCGsForContract() == null ? null : vo.getCCGsForContract().getBeanCollection();
	}

	public ims.careuk.vo.ContractConfigVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.ContractConfigVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.ContractConfigVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.ContractConfigVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.ContractConfigVo();
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
	public String getContractId()
	{
		return this.contractid;
	}
	public void setContractId(String value)
	{
		this.contractid = value;
	}
	public String getContractName()
	{
		return this.contractname;
	}
	public void setContractName(String value)
	{
		this.contractname = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public ims.core.vo.beans.OrganisationLiteVoBean getContractOrganisation()
	{
		return this.contractorganisation;
	}
	public void setContractOrganisation(ims.core.vo.beans.OrganisationLiteVoBean value)
	{
		this.contractorganisation = value;
	}
	public Integer getDaysToRTTBreachDate()
	{
		return this.daystorttbreachdate;
	}
	public void setDaysToRTTBreachDate(Integer value)
	{
		this.daystorttbreachdate = value;
	}
	public ims.vo.LookupInstanceBean getContractType()
	{
		return this.contracttype;
	}
	public void setContractType(ims.vo.LookupInstanceBean value)
	{
		this.contracttype = value;
	}
	public Integer getDaysTo1stAppt()
	{
		return this.daysto1stappt;
	}
	public void setDaysTo1stAppt(Integer value)
	{
		this.daysto1stappt = value;
	}
	public ims.careuk.vo.beans.ContractConfigKPIHistoryVoBean[] getContractKPIHistory()
	{
		return this.contractkpihistory;
	}
	public void setContractKPIHistory(ims.careuk.vo.beans.ContractConfigKPIHistoryVoBean[] value)
	{
		this.contractkpihistory = value;
	}
	public ims.careuk.vo.beans.ContractServiceLocationsConfigVoBean[] getServiceLocations()
	{
		return this.servicelocations;
	}
	public void setServiceLocations(ims.careuk.vo.beans.ContractServiceLocationsConfigVoBean[] value)
	{
		this.servicelocations = value;
	}
	public ims.careuk.vo.beans.CCGToContractConfigVoBean[] getCCGsForContract()
	{
		return this.ccgsforcontract;
	}
	public void setCCGsForContract(ims.careuk.vo.beans.CCGToContractConfigVoBean[] value)
	{
		this.ccgsforcontract = value;
	}

	private Integer id;
	private int version;
	private String contractid;
	private String contractname;
	private ims.vo.LookupInstanceBean status;
	private ims.core.vo.beans.OrganisationLiteVoBean contractorganisation;
	private Integer daystorttbreachdate;
	private ims.vo.LookupInstanceBean contracttype;
	private Integer daysto1stappt;
	private ims.careuk.vo.beans.ContractConfigKPIHistoryVoBean[] contractkpihistory;
	private ims.careuk.vo.beans.ContractServiceLocationsConfigVoBean[] servicelocations;
	private ims.careuk.vo.beans.CCGToContractConfigVoBean[] ccgsforcontract;
}
