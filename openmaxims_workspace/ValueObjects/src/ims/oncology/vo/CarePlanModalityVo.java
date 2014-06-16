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

package ims.oncology.vo;

/**
 * Linked to Oncology.CarePlanModality business object (ID: 1074100018).
 */
public class CarePlanModalityVo extends ims.oncology.vo.CarePlanModalityRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CarePlanModalityVo()
	{
	}
	public CarePlanModalityVo(Integer id, int version)
	{
		super(id, version);
	}
	public CarePlanModalityVo(ims.oncology.vo.beans.CarePlanModalityVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatmentmodality = bean.getTreatmentModality() == null ? null : ims.oncology.vo.lookups.CarePlanTreatmentModality.buildLookup(bean.getTreatmentModality());
		this.ismdtmodality = bean.getIsMDTModality();
		this.mdtsequence = bean.getMDTSequence();
		this.patientsequence = bean.getPatientSequence();
		this.modalitystatus = bean.getModalityStatus() == null ? null : ims.oncology.vo.lookups.CarePlanModalityStatus.buildLookup(bean.getModalityStatus());
		this.completeddate = bean.getCompletedDate() == null ? null : bean.getCompletedDate().buildDate();
		this.iscommenced = bean.getIsCommenced();
		this.patientagreed = bean.getPatientAgreed() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getPatientAgreed());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.CarePlanModalityVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatmentmodality = bean.getTreatmentModality() == null ? null : ims.oncology.vo.lookups.CarePlanTreatmentModality.buildLookup(bean.getTreatmentModality());
		this.ismdtmodality = bean.getIsMDTModality();
		this.mdtsequence = bean.getMDTSequence();
		this.patientsequence = bean.getPatientSequence();
		this.modalitystatus = bean.getModalityStatus() == null ? null : ims.oncology.vo.lookups.CarePlanModalityStatus.buildLookup(bean.getModalityStatus());
		this.completeddate = bean.getCompletedDate() == null ? null : bean.getCompletedDate().buildDate();
		this.iscommenced = bean.getIsCommenced();
		this.patientagreed = bean.getPatientAgreed() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getPatientAgreed());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.CarePlanModalityVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.CarePlanModalityVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.CarePlanModalityVoBean();
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
		if(fieldName.equals("TREATMENTMODALITY"))
			return getTreatmentModality();
		if(fieldName.equals("ISMDTMODALITY"))
			return getIsMDTModality();
		if(fieldName.equals("MDTSEQUENCE"))
			return getMDTSequence();
		if(fieldName.equals("PATIENTSEQUENCE"))
			return getPatientSequence();
		if(fieldName.equals("MODALITYSTATUS"))
			return getModalityStatus();
		if(fieldName.equals("COMPLETEDDATE"))
			return getCompletedDate();
		if(fieldName.equals("ISCOMMENCED"))
			return getIsCommenced();
		if(fieldName.equals("PATIENTAGREED"))
			return getPatientAgreed();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTreatmentModalityIsNotNull()
	{
		return this.treatmentmodality != null;
	}
	public ims.oncology.vo.lookups.CarePlanTreatmentModality getTreatmentModality()
	{
		return this.treatmentmodality;
	}
	public void setTreatmentModality(ims.oncology.vo.lookups.CarePlanTreatmentModality value)
	{
		this.isValidated = false;
		this.treatmentmodality = value;
	}
	public boolean getIsMDTModalityIsNotNull()
	{
		return this.ismdtmodality != null;
	}
	public Boolean getIsMDTModality()
	{
		return this.ismdtmodality;
	}
	public void setIsMDTModality(Boolean value)
	{
		this.isValidated = false;
		this.ismdtmodality = value;
	}
	public boolean getMDTSequenceIsNotNull()
	{
		return this.mdtsequence != null;
	}
	public Integer getMDTSequence()
	{
		return this.mdtsequence;
	}
	public void setMDTSequence(Integer value)
	{
		this.isValidated = false;
		this.mdtsequence = value;
	}
	public boolean getPatientSequenceIsNotNull()
	{
		return this.patientsequence != null;
	}
	public Integer getPatientSequence()
	{
		return this.patientsequence;
	}
	public void setPatientSequence(Integer value)
	{
		this.isValidated = false;
		this.patientsequence = value;
	}
	public boolean getModalityStatusIsNotNull()
	{
		return this.modalitystatus != null;
	}
	public ims.oncology.vo.lookups.CarePlanModalityStatus getModalityStatus()
	{
		return this.modalitystatus;
	}
	public void setModalityStatus(ims.oncology.vo.lookups.CarePlanModalityStatus value)
	{
		this.isValidated = false;
		this.modalitystatus = value;
	}
	public boolean getCompletedDateIsNotNull()
	{
		return this.completeddate != null;
	}
	public ims.framework.utils.Date getCompletedDate()
	{
		return this.completeddate;
	}
	public void setCompletedDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.completeddate = value;
	}
	public boolean getIsCommencedIsNotNull()
	{
		return this.iscommenced != null;
	}
	public Boolean getIsCommenced()
	{
		return this.iscommenced;
	}
	public void setIsCommenced(Boolean value)
	{
		this.isValidated = false;
		this.iscommenced = value;
	}
	public boolean getPatientAgreedIsNotNull()
	{
		return this.patientagreed != null;
	}
	public ims.core.vo.lookups.YesNo getPatientAgreed()
	{
		return this.patientagreed;
	}
	public void setPatientAgreed(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.patientagreed = value;
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
		if(this.treatmentmodality == null)
			listOfErrors.add("TreatmentModality is mandatory");
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
	
		CarePlanModalityVo clone = new CarePlanModalityVo(this.id, this.version);
		
		if(this.treatmentmodality == null)
			clone.treatmentmodality = null;
		else
			clone.treatmentmodality = (ims.oncology.vo.lookups.CarePlanTreatmentModality)this.treatmentmodality.clone();
		clone.ismdtmodality = this.ismdtmodality;
		clone.mdtsequence = this.mdtsequence;
		clone.patientsequence = this.patientsequence;
		if(this.modalitystatus == null)
			clone.modalitystatus = null;
		else
			clone.modalitystatus = (ims.oncology.vo.lookups.CarePlanModalityStatus)this.modalitystatus.clone();
		if(this.completeddate == null)
			clone.completeddate = null;
		else
			clone.completeddate = (ims.framework.utils.Date)this.completeddate.clone();
		clone.iscommenced = this.iscommenced;
		if(this.patientagreed == null)
			clone.patientagreed = null;
		else
			clone.patientagreed = (ims.core.vo.lookups.YesNo)this.patientagreed.clone();
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
		if (!(CarePlanModalityVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CarePlanModalityVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CarePlanModalityVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CarePlanModalityVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.treatmentmodality != null)
			count++;
		if(this.ismdtmodality != null)
			count++;
		if(this.mdtsequence != null)
			count++;
		if(this.patientsequence != null)
			count++;
		if(this.modalitystatus != null)
			count++;
		if(this.completeddate != null)
			count++;
		if(this.iscommenced != null)
			count++;
		if(this.patientagreed != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.oncology.vo.lookups.CarePlanTreatmentModality treatmentmodality;
	protected Boolean ismdtmodality;
	protected Integer mdtsequence;
	protected Integer patientsequence;
	protected ims.oncology.vo.lookups.CarePlanModalityStatus modalitystatus;
	protected ims.framework.utils.Date completeddate;
	protected Boolean iscommenced;
	protected ims.core.vo.lookups.YesNo patientagreed;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
