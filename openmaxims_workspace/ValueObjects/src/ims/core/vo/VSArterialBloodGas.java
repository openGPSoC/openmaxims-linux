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

package ims.core.vo;

/**
 * Linked to core.vitals.Arterial Blood Gas business object (ID: 1022100014).
 */
public class VSArterialBloodGas extends ims.core.vitals.vo.ArterialBloodGasRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public VSArterialBloodGas()
	{
	}
	public VSArterialBloodGas(Integer id, int version)
	{
		super(id, version);
	}
	public VSArterialBloodGas(ims.core.vo.beans.VSArterialBloodGasBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ph = bean.getPH();
		this.paco2 = bean.getPaCO2();
		this.pao2 = bean.getPaO2();
		this.sbc = bean.getSBC();
		this.baseexcess = bean.getBaseExcess();
		this.ventilationmode = bean.getVentilationMode() == null ? null : ims.core.vo.lookups.VentilationMode.buildLookup(bean.getVentilationMode());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.VSArterialBloodGasBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ph = bean.getPH();
		this.paco2 = bean.getPaCO2();
		this.pao2 = bean.getPaO2();
		this.sbc = bean.getSBC();
		this.baseexcess = bean.getBaseExcess();
		this.ventilationmode = bean.getVentilationMode() == null ? null : ims.core.vo.lookups.VentilationMode.buildLookup(bean.getVentilationMode());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.VSArterialBloodGasBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.VSArterialBloodGasBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.VSArterialBloodGasBean();
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
		if(fieldName.equals("PH"))
			return getPH();
		if(fieldName.equals("PACO2"))
			return getPaCO2();
		if(fieldName.equals("PAO2"))
			return getPaO2();
		if(fieldName.equals("SBC"))
			return getSBC();
		if(fieldName.equals("BASEEXCESS"))
			return getBaseExcess();
		if(fieldName.equals("VENTILATIONMODE"))
			return getVentilationMode();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPHIsNotNull()
	{
		return this.ph != null;
	}
	public Float getPH()
	{
		return this.ph;
	}
	public void setPH(Float value)
	{
		this.isValidated = false;
		this.ph = value;
	}
	public boolean getPaCO2IsNotNull()
	{
		return this.paco2 != null;
	}
	public Float getPaCO2()
	{
		return this.paco2;
	}
	public void setPaCO2(Float value)
	{
		this.isValidated = false;
		this.paco2 = value;
	}
	public boolean getPaO2IsNotNull()
	{
		return this.pao2 != null;
	}
	public Float getPaO2()
	{
		return this.pao2;
	}
	public void setPaO2(Float value)
	{
		this.isValidated = false;
		this.pao2 = value;
	}
	public boolean getSBCIsNotNull()
	{
		return this.sbc != null;
	}
	public Float getSBC()
	{
		return this.sbc;
	}
	public void setSBC(Float value)
	{
		this.isValidated = false;
		this.sbc = value;
	}
	public boolean getBaseExcessIsNotNull()
	{
		return this.baseexcess != null;
	}
	public Float getBaseExcess()
	{
		return this.baseexcess;
	}
	public void setBaseExcess(Float value)
	{
		this.isValidated = false;
		this.baseexcess = value;
	}
	public boolean getVentilationModeIsNotNull()
	{
		return this.ventilationmode != null;
	}
	public ims.core.vo.lookups.VentilationMode getVentilationMode()
	{
		return this.ventilationmode;
	}
	public void setVentilationMode(ims.core.vo.lookups.VentilationMode value)
	{
		this.isValidated = false;
		this.ventilationmode = value;
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
	
		VSArterialBloodGas clone = new VSArterialBloodGas(this.id, this.version);
		
		clone.ph = this.ph;
		clone.paco2 = this.paco2;
		clone.pao2 = this.pao2;
		clone.sbc = this.sbc;
		clone.baseexcess = this.baseexcess;
		if(this.ventilationmode == null)
			clone.ventilationmode = null;
		else
			clone.ventilationmode = (ims.core.vo.lookups.VentilationMode)this.ventilationmode.clone();
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
		if (!(VSArterialBloodGas.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A VSArterialBloodGas object cannot be compared an Object of type " + obj.getClass().getName());
		}
		VSArterialBloodGas compareObj = (VSArterialBloodGas)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_ArterialBloodGas() == null && compareObj.getID_ArterialBloodGas() != null)
				return -1;
			if(this.getID_ArterialBloodGas() != null && compareObj.getID_ArterialBloodGas() == null)
				return 1;
			if(this.getID_ArterialBloodGas() != null && compareObj.getID_ArterialBloodGas() != null)
				retVal = this.getID_ArterialBloodGas().compareTo(compareObj.getID_ArterialBloodGas());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.ph != null)
			count++;
		if(this.paco2 != null)
			count++;
		if(this.pao2 != null)
			count++;
		if(this.sbc != null)
			count++;
		if(this.baseexcess != null)
			count++;
		if(this.ventilationmode != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected Float ph;
	protected Float paco2;
	protected Float pao2;
	protected Float sbc;
	protected Float baseexcess;
	protected ims.core.vo.lookups.VentilationMode ventilationmode;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
