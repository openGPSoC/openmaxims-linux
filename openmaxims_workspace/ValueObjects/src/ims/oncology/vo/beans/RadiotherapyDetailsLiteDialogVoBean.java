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

package ims.oncology.vo.beans;

public class RadiotherapyDetailsLiteDialogVoBean extends ims.vo.ValueObjectBean
{
	public RadiotherapyDetailsLiteDialogVoBean()
	{
	}
	public RadiotherapyDetailsLiteDialogVoBean(ims.oncology.vo.RadiotherapyDetailsLiteDialogVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.associatedtreatmentplanaction = vo.getAssociatedTreatmentPlanAction() == null ? null : new ims.vo.RefVoBean(vo.getAssociatedTreatmentPlanAction().getBoId(), vo.getAssociatedTreatmentPlanAction().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.RadiotherapyDetailsLiteDialogVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.associatedtreatmentplanaction = vo.getAssociatedTreatmentPlanAction() == null ? null : new ims.vo.RefVoBean(vo.getAssociatedTreatmentPlanAction().getBoId(), vo.getAssociatedTreatmentPlanAction().getBoVersion());
	}

	public ims.oncology.vo.RadiotherapyDetailsLiteDialogVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.oncology.vo.RadiotherapyDetailsLiteDialogVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.RadiotherapyDetailsLiteDialogVo vo = null;
		if(map != null)
			vo = (ims.oncology.vo.RadiotherapyDetailsLiteDialogVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.oncology.vo.RadiotherapyDetailsLiteDialogVo();
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
	public ims.vo.RefVoBean getAssociatedTreatmentPlanAction()
	{
		return this.associatedtreatmentplanaction;
	}
	public void setAssociatedTreatmentPlanAction(ims.vo.RefVoBean value)
	{
		this.associatedtreatmentplanaction = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean associatedtreatmentplanaction;
}
