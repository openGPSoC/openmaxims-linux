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

package ims.generalmedical.vo.beans;

public class NeuroMotorExaminationVoBean extends ims.vo.ValueObjectBean
{
	public NeuroMotorExaminationVoBean()
	{
	}
	public NeuroMotorExaminationVoBean(ims.generalmedical.vo.NeuroMotorExaminationVo vo)
	{
		this.neuromotor = vo.getNeuroMotor() == null ? null : (ims.generalmedical.vo.beans.NeuroMotorFindingsVoBean)vo.getNeuroMotor().getBean();
		this.problem = vo.getProblem() == null ? null : (ims.generalmedical.vo.beans.MedicalProbOnAdmisVoBean)vo.getProblem().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.NeuroMotorExaminationVo vo)
	{
		this.neuromotor = vo.getNeuroMotor() == null ? null : (ims.generalmedical.vo.beans.NeuroMotorFindingsVoBean)vo.getNeuroMotor().getBean(map);
		this.problem = vo.getProblem() == null ? null : (ims.generalmedical.vo.beans.MedicalProbOnAdmisVoBean)vo.getProblem().getBean(map);
	}

	public ims.generalmedical.vo.NeuroMotorExaminationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.generalmedical.vo.NeuroMotorExaminationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.NeuroMotorExaminationVo vo = null;
		if(map != null)
			vo = (ims.generalmedical.vo.NeuroMotorExaminationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.generalmedical.vo.NeuroMotorExaminationVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.generalmedical.vo.beans.NeuroMotorFindingsVoBean getNeuroMotor()
	{
		return this.neuromotor;
	}
	public void setNeuroMotor(ims.generalmedical.vo.beans.NeuroMotorFindingsVoBean value)
	{
		this.neuromotor = value;
	}
	public ims.generalmedical.vo.beans.MedicalProbOnAdmisVoBean getProblem()
	{
		return this.problem;
	}
	public void setProblem(ims.generalmedical.vo.beans.MedicalProbOnAdmisVoBean value)
	{
		this.problem = value;
	}

	private ims.generalmedical.vo.beans.NeuroMotorFindingsVoBean neuromotor;
	private ims.generalmedical.vo.beans.MedicalProbOnAdmisVoBean problem;
}
