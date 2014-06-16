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

package ims.generalmedical.vo;

/**
 * Linked to medical.NeuroMotorAreaFinding business object (ID: 1031100012).
 */
public class NeuroMotorAreaFindingVo extends ims.medical.vo.NeuroMotorAreaFindingRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NeuroMotorAreaFindingVo()
	{
	}
	public NeuroMotorAreaFindingVo(Integer id, int version)
	{
		super(id, version);
	}
	public NeuroMotorAreaFindingVo(ims.generalmedical.vo.beans.NeuroMotorAreaFindingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.motorarea = bean.getMotorArea() == null ? null : bean.getMotorArea().buildVo();
		this.rightfinding = bean.getRightFinding();
		this.leftfinding = bean.getLeftFinding();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.beans.NeuroMotorAreaFindingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.motorarea = bean.getMotorArea() == null ? null : bean.getMotorArea().buildVo(map);
		this.rightfinding = bean.getRightFinding();
		this.leftfinding = bean.getLeftFinding();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.beans.NeuroMotorAreaFindingVoBean bean = null;
		if(map != null)
			bean = (ims.generalmedical.vo.beans.NeuroMotorAreaFindingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.generalmedical.vo.beans.NeuroMotorAreaFindingVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("MOTORAREA"))
			return getMotorArea();
		if(fieldName.equals("RIGHTFINDING"))
			return getRightFinding();
		if(fieldName.equals("LEFTFINDING"))
			return getLeftFinding();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMotorAreaIsNotNull()
	{
		return this.motorarea != null;
	}
	public ims.core.vo.MotorChartAreaDetailVo getMotorArea()
	{
		return this.motorarea;
	}
	public void setMotorArea(ims.core.vo.MotorChartAreaDetailVo value)
	{
		this.isValidated = false;
		this.motorarea = value;
	}
	public boolean getRightFindingIsNotNull()
	{
		return this.rightfinding != null;
	}
	public Integer getRightFinding()
	{
		return this.rightfinding;
	}
	public void setRightFinding(Integer value)
	{
		this.isValidated = false;
		this.rightfinding = value;
	}
	public boolean getLeftFindingIsNotNull()
	{
		return this.leftfinding != null;
	}
	public Integer getLeftFinding()
	{
		return this.leftfinding;
	}
	public void setLeftFinding(Integer value)
	{
		this.isValidated = false;
		this.leftfinding = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		NeuroMotorAreaFindingVo clone = new NeuroMotorAreaFindingVo(this.id, this.version);
		
		if(this.motorarea == null)
			clone.motorarea = null;
		else
			clone.motorarea = (ims.core.vo.MotorChartAreaDetailVo)this.motorarea.clone();
		clone.rightfinding = this.rightfinding;
		clone.leftfinding = this.leftfinding;
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(NeuroMotorAreaFindingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NeuroMotorAreaFindingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((NeuroMotorAreaFindingVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((NeuroMotorAreaFindingVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.motorarea != null)
			count++;
		if(this.rightfinding != null)
			count++;
		if(this.leftfinding != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.MotorChartAreaDetailVo motorarea;
	protected Integer rightfinding;
	protected Integer leftfinding;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
