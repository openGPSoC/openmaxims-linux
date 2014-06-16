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

package ims.careuk.vo;

/**
 * Linked to CAREUK.CatsReferral business object (ID: 1004100035).
 */
public class CatsReferralForClinicalNotesVo extends ims.careuk.vo.CatsReferralRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CatsReferralForClinicalNotesVo()
	{
	}
	public CatsReferralForClinicalNotesVo(Integer id, int version)
	{
		super(id, version);
	}
	public CatsReferralForClinicalNotesVo(ims.careuk.vo.beans.CatsReferralForClinicalNotesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.referraldetails = bean.getReferralDetails() == null ? null : bean.getReferralDetails().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.CatsReferralForClinicalNotesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.referraldetails = bean.getReferralDetails() == null ? null : bean.getReferralDetails().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.CatsReferralForClinicalNotesVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.CatsReferralForClinicalNotesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.CatsReferralForClinicalNotesVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("REFERRALDETAILS"))
			return getReferralDetails();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.careuk.vo.CareContextForClinicalNotesVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.careuk.vo.CareContextForClinicalNotesVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getReferralDetailsIsNotNull()
	{
		return this.referraldetails != null;
	}
	public ims.careuk.vo.ReferralLetterDetailsForClinicalNotesVo getReferralDetails()
	{
		return this.referraldetails;
	}
	public void setReferralDetails(ims.careuk.vo.ReferralLetterDetailsForClinicalNotesVo value)
	{
		this.isValidated = false;
		this.referraldetails = value;
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
	
		CatsReferralForClinicalNotesVo clone = new CatsReferralForClinicalNotesVo(this.id, this.version);
		
		clone.patient = this.patient;
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.careuk.vo.CareContextForClinicalNotesVo)this.carecontext.clone();
		if(this.referraldetails == null)
			clone.referraldetails = null;
		else
			clone.referraldetails = (ims.careuk.vo.ReferralLetterDetailsForClinicalNotesVo)this.referraldetails.clone();
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
		if (!(CatsReferralForClinicalNotesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CatsReferralForClinicalNotesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CatsReferralForClinicalNotesVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CatsReferralForClinicalNotesVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.referraldetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.careuk.vo.CareContextForClinicalNotesVo carecontext;
	protected ims.careuk.vo.ReferralLetterDetailsForClinicalNotesVo referraldetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
