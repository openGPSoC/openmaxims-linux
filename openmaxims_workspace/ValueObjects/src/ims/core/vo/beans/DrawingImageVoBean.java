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

public class DrawingImageVoBean extends ims.vo.ValueObjectBean
{
	public DrawingImageVoBean()
	{
	}
	public DrawingImageVoBean(ims.core.vo.DrawingImageVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.imagename = vo.getImageName();
		this.image = vo.getImage() == null ? null : (ims.admin.vo.beans.AppImageVoBean)vo.getImage().getBean();
		this.rootgroup = vo.getRootGroup() == null ? null : (ims.core.vo.beans.DrawingGroupVoBean)vo.getRootGroup().getBean();
		this.versionnumber = vo.getVersionNumber();
		this.imagestatus = vo.getImageStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getImageStatus().getBean();
		this.questions = vo.getQuestions() == null ? null : vo.getQuestions().getBeanCollection();
		this.assocfindings = vo.getAssocFindings() == null ? null : vo.getAssocFindings().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.DrawingImageVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.imagename = vo.getImageName();
		this.image = vo.getImage() == null ? null : (ims.admin.vo.beans.AppImageVoBean)vo.getImage().getBean(map);
		this.rootgroup = vo.getRootGroup() == null ? null : (ims.core.vo.beans.DrawingGroupVoBean)vo.getRootGroup().getBean(map);
		this.versionnumber = vo.getVersionNumber();
		this.imagestatus = vo.getImageStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getImageStatus().getBean();
		this.questions = vo.getQuestions() == null ? null : vo.getQuestions().getBeanCollection();
		this.assocfindings = vo.getAssocFindings() == null ? null : vo.getAssocFindings().getBeanCollection();
	}

	public ims.core.vo.DrawingImageVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.DrawingImageVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.DrawingImageVo vo = null;
		if(map != null)
			vo = (ims.core.vo.DrawingImageVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.DrawingImageVo();
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
	public ims.vo.LookupInstanceBean getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.vo.LookupInstanceBean value)
	{
		this.category = value;
	}
	public ims.vo.LookupInstanceBean getType()
	{
		return this.type;
	}
	public void setType(ims.vo.LookupInstanceBean value)
	{
		this.type = value;
	}
	public String getImageName()
	{
		return this.imagename;
	}
	public void setImageName(String value)
	{
		this.imagename = value;
	}
	public ims.admin.vo.beans.AppImageVoBean getImage()
	{
		return this.image;
	}
	public void setImage(ims.admin.vo.beans.AppImageVoBean value)
	{
		this.image = value;
	}
	public ims.core.vo.beans.DrawingGroupVoBean getRootGroup()
	{
		return this.rootgroup;
	}
	public void setRootGroup(ims.core.vo.beans.DrawingGroupVoBean value)
	{
		this.rootgroup = value;
	}
	public Integer getVersionNumber()
	{
		return this.versionnumber;
	}
	public void setVersionNumber(Integer value)
	{
		this.versionnumber = value;
	}
	public ims.vo.LookupInstanceBean getImageStatus()
	{
		return this.imagestatus;
	}
	public void setImageStatus(ims.vo.LookupInstanceBean value)
	{
		this.imagestatus = value;
	}
	public ims.assessment.vo.beans.ImageFindingQuestionVoBean[] getQuestions()
	{
		return this.questions;
	}
	public void setQuestions(ims.assessment.vo.beans.ImageFindingQuestionVoBean[] value)
	{
		this.questions = value;
	}
	public ims.assessment.vo.beans.ImageFindingVoBean[] getAssocFindings()
	{
		return this.assocfindings;
	}
	public void setAssocFindings(ims.assessment.vo.beans.ImageFindingVoBean[] value)
	{
		this.assocfindings = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean category;
	private ims.vo.LookupInstanceBean type;
	private String imagename;
	private ims.admin.vo.beans.AppImageVoBean image;
	private ims.core.vo.beans.DrawingGroupVoBean rootgroup;
	private Integer versionnumber;
	private ims.vo.LookupInstanceBean imagestatus;
	private ims.assessment.vo.beans.ImageFindingQuestionVoBean[] questions;
	private ims.assessment.vo.beans.ImageFindingVoBean[] assocfindings;
}
