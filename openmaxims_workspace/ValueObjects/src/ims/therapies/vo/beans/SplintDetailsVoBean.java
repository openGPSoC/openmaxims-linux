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

package ims.therapies.vo.beans;

public class SplintDetailsVoBean extends ims.vo.ValueObjectBean
{
	public SplintDetailsVoBean()
	{
	}
	public SplintDetailsVoBean(ims.therapies.vo.SplintDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringCP().getBean();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.area = vo.getArea() == null ? null : (ims.vo.LookupInstanceBean)vo.getArea().getBean();
		this.splintcategory = vo.getSplintCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getSplintCategory().getBean();
		this.material = vo.getMaterial() == null ? null : (ims.vo.LookupInstanceBean)vo.getMaterial().getBean();
		this.product = vo.getProduct() == null ? null : (ims.vo.LookupInstanceBean)vo.getProduct().getBean();
		this.laterality = vo.getLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getLaterality().getBean();
		this.splinttype = vo.getSplintType() == null ? null : (ims.vo.LookupInstanceBean)vo.getSplintType().getBean();
		this.splintbase = vo.getSplintBase() == null ? null : (ims.vo.LookupInstanceBean)vo.getSplintBase().getBean();
		this.splintsize = vo.getSplintSize() == null ? null : (ims.vo.LookupInstanceBean)vo.getSplintSize().getBean();
		this.splintswearregime = vo.getSplintsWearRegime() == null ? null : vo.getSplintsWearRegime().getBeanCollection();
		this.splintinstructions = vo.getSplintInstructions() == null ? null : vo.getSplintInstructions().getBeanCollection();
		this.splintadditionalfeatures = vo.getSplintAdditionalFeatures() == null ? null : vo.getSplintAdditionalFeatures().getBeanCollection();
		this.consentgiven = vo.getConsentGiven() == null ? null : (ims.core.vo.beans.ConsentGivenVoBean)vo.getConsentGiven().getBean();
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.SplintDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean(map);
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringCP().getBean(map);
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.area = vo.getArea() == null ? null : (ims.vo.LookupInstanceBean)vo.getArea().getBean();
		this.splintcategory = vo.getSplintCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getSplintCategory().getBean();
		this.material = vo.getMaterial() == null ? null : (ims.vo.LookupInstanceBean)vo.getMaterial().getBean();
		this.product = vo.getProduct() == null ? null : (ims.vo.LookupInstanceBean)vo.getProduct().getBean();
		this.laterality = vo.getLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getLaterality().getBean();
		this.splinttype = vo.getSplintType() == null ? null : (ims.vo.LookupInstanceBean)vo.getSplintType().getBean();
		this.splintbase = vo.getSplintBase() == null ? null : (ims.vo.LookupInstanceBean)vo.getSplintBase().getBean();
		this.splintsize = vo.getSplintSize() == null ? null : (ims.vo.LookupInstanceBean)vo.getSplintSize().getBean();
		this.splintswearregime = vo.getSplintsWearRegime() == null ? null : vo.getSplintsWearRegime().getBeanCollection();
		this.splintinstructions = vo.getSplintInstructions() == null ? null : vo.getSplintInstructions().getBeanCollection();
		this.splintadditionalfeatures = vo.getSplintAdditionalFeatures() == null ? null : vo.getSplintAdditionalFeatures().getBeanCollection();
		this.consentgiven = vo.getConsentGiven() == null ? null : (ims.core.vo.beans.ConsentGivenVoBean)vo.getConsentGiven().getBean(map);
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
	}

	public ims.therapies.vo.SplintDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.SplintDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.SplintDetailsVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.SplintDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.SplintDetailsVo();
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
	public ims.core.vo.beans.ClinicalContactShortVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}
	public ims.core.vo.beans.HcpBean getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.beans.HcpBean value)
	{
		this.authoringcp = value;
	}
	public ims.framework.utils.beans.DateBean getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.startdate = value;
	}
	public ims.vo.LookupInstanceBean getArea()
	{
		return this.area;
	}
	public void setArea(ims.vo.LookupInstanceBean value)
	{
		this.area = value;
	}
	public ims.vo.LookupInstanceBean getSplintCategory()
	{
		return this.splintcategory;
	}
	public void setSplintCategory(ims.vo.LookupInstanceBean value)
	{
		this.splintcategory = value;
	}
	public ims.vo.LookupInstanceBean getMaterial()
	{
		return this.material;
	}
	public void setMaterial(ims.vo.LookupInstanceBean value)
	{
		this.material = value;
	}
	public ims.vo.LookupInstanceBean getProduct()
	{
		return this.product;
	}
	public void setProduct(ims.vo.LookupInstanceBean value)
	{
		this.product = value;
	}
	public ims.vo.LookupInstanceBean getLaterality()
	{
		return this.laterality;
	}
	public void setLaterality(ims.vo.LookupInstanceBean value)
	{
		this.laterality = value;
	}
	public ims.vo.LookupInstanceBean getSplintType()
	{
		return this.splinttype;
	}
	public void setSplintType(ims.vo.LookupInstanceBean value)
	{
		this.splinttype = value;
	}
	public ims.vo.LookupInstanceBean getSplintBase()
	{
		return this.splintbase;
	}
	public void setSplintBase(ims.vo.LookupInstanceBean value)
	{
		this.splintbase = value;
	}
	public ims.vo.LookupInstanceBean getSplintSize()
	{
		return this.splintsize;
	}
	public void setSplintSize(ims.vo.LookupInstanceBean value)
	{
		this.splintsize = value;
	}
	public ims.therapies.vo.beans.SplintsWearRegimeVoBean[] getSplintsWearRegime()
	{
		return this.splintswearregime;
	}
	public void setSplintsWearRegime(ims.therapies.vo.beans.SplintsWearRegimeVoBean[] value)
	{
		this.splintswearregime = value;
	}
	public ims.therapies.vo.beans.SplintsInstructionDetailsVoBean[] getSplintInstructions()
	{
		return this.splintinstructions;
	}
	public void setSplintInstructions(ims.therapies.vo.beans.SplintsInstructionDetailsVoBean[] value)
	{
		this.splintinstructions = value;
	}
	public ims.therapies.vo.beans.SplintAdditionalFeaturesVoBean[] getSplintAdditionalFeatures()
	{
		return this.splintadditionalfeatures;
	}
	public void setSplintAdditionalFeatures(ims.therapies.vo.beans.SplintAdditionalFeaturesVoBean[] value)
	{
		this.splintadditionalfeatures = value;
	}
	public ims.core.vo.beans.ConsentGivenVoBean getConsentGiven()
	{
		return this.consentgiven;
	}
	public void setConsentGiven(ims.core.vo.beans.ConsentGivenVoBean value)
	{
		this.consentgiven = value;
	}
	public ims.framework.utils.beans.DateBean getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.beans.DateBean value)
	{
		this.enddate = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.ClinicalContactShortVoBean clinicalcontact;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private ims.core.vo.beans.HcpBean authoringcp;
	private ims.framework.utils.beans.DateBean startdate;
	private ims.vo.LookupInstanceBean area;
	private ims.vo.LookupInstanceBean splintcategory;
	private ims.vo.LookupInstanceBean material;
	private ims.vo.LookupInstanceBean product;
	private ims.vo.LookupInstanceBean laterality;
	private ims.vo.LookupInstanceBean splinttype;
	private ims.vo.LookupInstanceBean splintbase;
	private ims.vo.LookupInstanceBean splintsize;
	private ims.therapies.vo.beans.SplintsWearRegimeVoBean[] splintswearregime;
	private ims.therapies.vo.beans.SplintsInstructionDetailsVoBean[] splintinstructions;
	private ims.therapies.vo.beans.SplintAdditionalFeaturesVoBean[] splintadditionalfeatures;
	private ims.core.vo.beans.ConsentGivenVoBean consentgiven;
	private ims.framework.utils.beans.DateBean enddate;
}
