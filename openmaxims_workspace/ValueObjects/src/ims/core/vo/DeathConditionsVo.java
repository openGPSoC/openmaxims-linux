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
 * Linked to core.clinical.DeathConditions business object (ID: 1003100079).
 */
public class DeathConditionsVo extends ims.core.clinical.vo.DeathConditionsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DeathConditionsVo()
	{
	}
	public DeathConditionsVo(Integer id, int version)
	{
		super(id, version);
	}
	public DeathConditionsVo(ims.core.vo.beans.DeathConditionsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.diagnosis = bean.getDiagnosis() == null ? null : bean.getDiagnosis().buildVo();
		this.causeofdeath = bean.getCauseofDeath() == null ? null : ims.core.vo.lookups.CauseofDeath.buildLookup(bean.getCauseofDeath());
		this.patientdiagnosis = bean.getPatientDiagnosis() == null ? null : bean.getPatientDiagnosis().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.DeathConditionsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.diagnosis = bean.getDiagnosis() == null ? null : bean.getDiagnosis().buildVo(map);
		this.causeofdeath = bean.getCauseofDeath() == null ? null : ims.core.vo.lookups.CauseofDeath.buildLookup(bean.getCauseofDeath());
		this.patientdiagnosis = bean.getPatientDiagnosis() == null ? null : bean.getPatientDiagnosis().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.DeathConditionsVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.DeathConditionsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.DeathConditionsVoBean();
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
		if(fieldName.equals("DIAGNOSIS"))
			return getDiagnosis();
		if(fieldName.equals("CAUSEOFDEATH"))
			return getCauseofDeath();
		if(fieldName.equals("PATIENTDIAGNOSIS"))
			return getPatientDiagnosis();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDiagnosisIsNotNull()
	{
		return this.diagnosis != null;
	}
	public ims.core.vo.DiagLiteVo getDiagnosis()
	{
		return this.diagnosis;
	}
	public void setDiagnosis(ims.core.vo.DiagLiteVo value)
	{
		this.isValidated = false;
		this.diagnosis = value;
	}
	public boolean getCauseofDeathIsNotNull()
	{
		return this.causeofdeath != null;
	}
	public ims.core.vo.lookups.CauseofDeath getCauseofDeath()
	{
		return this.causeofdeath;
	}
	public void setCauseofDeath(ims.core.vo.lookups.CauseofDeath value)
	{
		this.isValidated = false;
		this.causeofdeath = value;
	}
	public boolean getPatientDiagnosisIsNotNull()
	{
		return this.patientdiagnosis != null;
	}
	public ims.core.vo.PatientDiagnosisListVo getPatientDiagnosis()
	{
		return this.patientdiagnosis;
	}
	public void setPatientDiagnosis(ims.core.vo.PatientDiagnosisListVo value)
	{
		this.isValidated = false;
		this.patientdiagnosis = value;
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
		if(this.diagnosis != null)
		{
			if(!this.diagnosis.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.patientdiagnosis != null)
		{
			if(!this.patientdiagnosis.isValidated())
			{
				this.isBusy = false;
				return false;
			}
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
		if(this.diagnosis != null)
		{
			String[] listOfOtherErrors = this.diagnosis.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.patientdiagnosis != null)
		{
			String[] listOfOtherErrors = this.patientdiagnosis.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
	
		DeathConditionsVo clone = new DeathConditionsVo(this.id, this.version);
		
		if(this.diagnosis == null)
			clone.diagnosis = null;
		else
			clone.diagnosis = (ims.core.vo.DiagLiteVo)this.diagnosis.clone();
		if(this.causeofdeath == null)
			clone.causeofdeath = null;
		else
			clone.causeofdeath = (ims.core.vo.lookups.CauseofDeath)this.causeofdeath.clone();
		if(this.patientdiagnosis == null)
			clone.patientdiagnosis = null;
		else
			clone.patientdiagnosis = (ims.core.vo.PatientDiagnosisListVo)this.patientdiagnosis.clone();
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
		if (!(DeathConditionsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DeathConditionsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DeathConditionsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DeathConditionsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.diagnosis != null)
			count++;
		if(this.causeofdeath != null)
			count++;
		if(this.patientdiagnosis != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.DiagLiteVo diagnosis;
	protected ims.core.vo.lookups.CauseofDeath causeofdeath;
	protected ims.core.vo.PatientDiagnosisListVo patientdiagnosis;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
