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
 * Linked to core.clinical.PatientCharacteristic business object (ID: 1003100027).
 */
public class PatientCharacteristicVo extends ims.core.clinical.vo.PatientCharacteristicRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientCharacteristicVo()
	{
	}
	public PatientCharacteristicVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientCharacteristicVo(ims.core.vo.beans.PatientCharacteristicVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.characterestictype = bean.getCharacteresticType() == null ? null : ims.core.vo.lookups.PatientCharacteresticType.buildLookup(bean.getCharacteresticType());
		this.implanteddevice = bean.getImplantedDevice();
		this.insertionprocedure = bean.getInsertionProcedure() == null ? null : bean.getInsertionProcedure().buildVo();
		this.removalprocedure = bean.getRemovalProcedure() == null ? null : bean.getRemovalProcedure().buildVo();
		this.isremoved = bean.getIsRemoved();
		this.dateinserted = bean.getDateInserted() == null ? null : bean.getDateInserted().buildDate();
		this.dateremoved = bean.getDateRemoved() == null ? null : bean.getDateRemoved().buildDate();
		this.isactive = bean.getIsActive();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientCharacteristicVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.characterestictype = bean.getCharacteresticType() == null ? null : ims.core.vo.lookups.PatientCharacteresticType.buildLookup(bean.getCharacteresticType());
		this.implanteddevice = bean.getImplantedDevice();
		this.insertionprocedure = bean.getInsertionProcedure() == null ? null : bean.getInsertionProcedure().buildVo(map);
		this.removalprocedure = bean.getRemovalProcedure() == null ? null : bean.getRemovalProcedure().buildVo(map);
		this.isremoved = bean.getIsRemoved();
		this.dateinserted = bean.getDateInserted() == null ? null : bean.getDateInserted().buildDate();
		this.dateremoved = bean.getDateRemoved() == null ? null : bean.getDateRemoved().buildDate();
		this.isactive = bean.getIsActive();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientCharacteristicVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientCharacteristicVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientCharacteristicVoBean();
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
		if(fieldName.equals("CHARACTERESTICTYPE"))
			return getCharacteresticType();
		if(fieldName.equals("IMPLANTEDDEVICE"))
			return getImplantedDevice();
		if(fieldName.equals("INSERTIONPROCEDURE"))
			return getInsertionProcedure();
		if(fieldName.equals("REMOVALPROCEDURE"))
			return getRemovalProcedure();
		if(fieldName.equals("ISREMOVED"))
			return getIsRemoved();
		if(fieldName.equals("DATEINSERTED"))
			return getDateInserted();
		if(fieldName.equals("DATEREMOVED"))
			return getDateRemoved();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCharacteresticTypeIsNotNull()
	{
		return this.characterestictype != null;
	}
	public ims.core.vo.lookups.PatientCharacteresticType getCharacteresticType()
	{
		return this.characterestictype;
	}
	public void setCharacteresticType(ims.core.vo.lookups.PatientCharacteresticType value)
	{
		this.isValidated = false;
		this.characterestictype = value;
	}
	public boolean getImplantedDeviceIsNotNull()
	{
		return this.implanteddevice != null;
	}
	public String getImplantedDevice()
	{
		return this.implanteddevice;
	}
	public static int getImplantedDeviceMaxLength()
	{
		return 255;
	}
	public void setImplantedDevice(String value)
	{
		this.isValidated = false;
		this.implanteddevice = value;
	}
	public boolean getInsertionProcedureIsNotNull()
	{
		return this.insertionprocedure != null;
	}
	public ims.core.vo.PatientProcedureVo getInsertionProcedure()
	{
		return this.insertionprocedure;
	}
	public void setInsertionProcedure(ims.core.vo.PatientProcedureVo value)
	{
		this.isValidated = false;
		this.insertionprocedure = value;
	}
	public boolean getRemovalProcedureIsNotNull()
	{
		return this.removalprocedure != null;
	}
	public ims.core.vo.PatientProcedureVo getRemovalProcedure()
	{
		return this.removalprocedure;
	}
	public void setRemovalProcedure(ims.core.vo.PatientProcedureVo value)
	{
		this.isValidated = false;
		this.removalprocedure = value;
	}
	public boolean getIsRemovedIsNotNull()
	{
		return this.isremoved != null;
	}
	public Boolean getIsRemoved()
	{
		return this.isremoved;
	}
	public void setIsRemoved(Boolean value)
	{
		this.isValidated = false;
		this.isremoved = value;
	}
	public boolean getDateInsertedIsNotNull()
	{
		return this.dateinserted != null;
	}
	public ims.framework.utils.Date getDateInserted()
	{
		return this.dateinserted;
	}
	public void setDateInserted(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateinserted = value;
	}
	public boolean getDateRemovedIsNotNull()
	{
		return this.dateremoved != null;
	}
	public ims.framework.utils.Date getDateRemoved()
	{
		return this.dateremoved;
	}
	public void setDateRemoved(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateremoved = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getSysInfoIsNotNull()
	{
		return this.sysinfo != null;
	}
	public ims.vo.SystemInformation getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinfo = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
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
		if(this.implanteddevice != null)
			if(this.implanteddevice.length() > 255)
				listOfErrors.add("The length of the field [implanteddevice] in the value object [ims.core.vo.PatientCharacteristicVo] is too big. It should be less or equal to 255");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
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
	
		PatientCharacteristicVo clone = new PatientCharacteristicVo(this.id, this.version);
		
		if(this.characterestictype == null)
			clone.characterestictype = null;
		else
			clone.characterestictype = (ims.core.vo.lookups.PatientCharacteresticType)this.characterestictype.clone();
		clone.implanteddevice = this.implanteddevice;
		if(this.insertionprocedure == null)
			clone.insertionprocedure = null;
		else
			clone.insertionprocedure = (ims.core.vo.PatientProcedureVo)this.insertionprocedure.clone();
		if(this.removalprocedure == null)
			clone.removalprocedure = null;
		else
			clone.removalprocedure = (ims.core.vo.PatientProcedureVo)this.removalprocedure.clone();
		clone.isremoved = this.isremoved;
		if(this.dateinserted == null)
			clone.dateinserted = null;
		else
			clone.dateinserted = (ims.framework.utils.Date)this.dateinserted.clone();
		if(this.dateremoved == null)
			clone.dateremoved = null;
		else
			clone.dateremoved = (ims.framework.utils.Date)this.dateremoved.clone();
		clone.isactive = this.isactive;
		clone.carecontext = this.carecontext;
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		clone.patient = this.patient;
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
		if (!(PatientCharacteristicVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientCharacteristicVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientCharacteristicVo compareObj = (PatientCharacteristicVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSysInfo() == null && compareObj.getSysInfo() != null)
				return -1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() == null)
				return 1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() != null)
				retVal = this.getSysInfo().compareTo(compareObj.getSysInfo());
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
		if(this.characterestictype != null)
			count++;
		if(this.implanteddevice != null)
			count++;
		if(this.insertionprocedure != null)
			count++;
		if(this.removalprocedure != null)
			count++;
		if(this.isremoved != null)
			count++;
		if(this.dateinserted != null)
			count++;
		if(this.dateremoved != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.patient != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected ims.core.vo.lookups.PatientCharacteresticType characterestictype;
	protected String implanteddevice;
	protected ims.core.vo.PatientProcedureVo insertionprocedure;
	protected ims.core.vo.PatientProcedureVo removalprocedure;
	protected Boolean isremoved;
	protected ims.framework.utils.Date dateinserted;
	protected ims.framework.utils.Date dateremoved;
	protected Boolean isactive;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.vo.SystemInformation sysinfo;
	protected ims.core.patient.vo.PatientRefVo patient;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
