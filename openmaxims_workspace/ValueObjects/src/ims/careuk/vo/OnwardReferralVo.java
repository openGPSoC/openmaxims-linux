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
 * Linked to CAREUK.OnwardReferral business object (ID: 1096100020).
 */
public class OnwardReferralVo extends ims.careuk.vo.OnwardReferralRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OnwardReferralVo()
	{
	}
	public OnwardReferralVo(Integer id, int version)
	{
		super(id, version);
	}
	public OnwardReferralVo(ims.careuk.vo.beans.OnwardReferralVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.dischargedate = bean.getDischargeDate() == null ? null : bean.getDischargeDate().buildDate();
		this.onwardreferralorg = bean.getOnwardReferralOrg() == null ? null : bean.getOnwardReferralOrg().buildVo();
		this.onwardreferral = bean.getOnwardReferral();
		this.rejecteddate = bean.getRejectedDate() == null ? null : bean.getRejectedDate().buildDate();
		this.rejectionreason = bean.getRejectionReason();
		this.rejectedby = bean.getRejectedBy() == null ? null : ims.careuk.vo.lookups.OnwardReferralRejectedBy.buildLookup(bean.getRejectedBy());
		this.onwardreferralreason = bean.getOnwardReferralReason() == null ? null : ims.careuk.vo.lookups.OnwardReferralReason.buildLookup(bean.getOnwardReferralReason());
		this.copytogp = bean.getCopyToGP();
		this.copytopatient = bean.getCopyToPatient();
		this.copytosecondarycare = bean.getCopyToSecondaryCare();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.OnwardReferralVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.dischargedate = bean.getDischargeDate() == null ? null : bean.getDischargeDate().buildDate();
		this.onwardreferralorg = bean.getOnwardReferralOrg() == null ? null : bean.getOnwardReferralOrg().buildVo(map);
		this.onwardreferral = bean.getOnwardReferral();
		this.rejecteddate = bean.getRejectedDate() == null ? null : bean.getRejectedDate().buildDate();
		this.rejectionreason = bean.getRejectionReason();
		this.rejectedby = bean.getRejectedBy() == null ? null : ims.careuk.vo.lookups.OnwardReferralRejectedBy.buildLookup(bean.getRejectedBy());
		this.onwardreferralreason = bean.getOnwardReferralReason() == null ? null : ims.careuk.vo.lookups.OnwardReferralReason.buildLookup(bean.getOnwardReferralReason());
		this.copytogp = bean.getCopyToGP();
		this.copytopatient = bean.getCopyToPatient();
		this.copytosecondarycare = bean.getCopyToSecondaryCare();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.OnwardReferralVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.OnwardReferralVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.OnwardReferralVoBean();
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
		if(fieldName.equals("DISCHARGEDATE"))
			return getDischargeDate();
		if(fieldName.equals("ONWARDREFERRALORG"))
			return getOnwardReferralOrg();
		if(fieldName.equals("ONWARDREFERRAL"))
			return getOnwardReferral();
		if(fieldName.equals("REJECTEDDATE"))
			return getRejectedDate();
		if(fieldName.equals("REJECTIONREASON"))
			return getRejectionReason();
		if(fieldName.equals("REJECTEDBY"))
			return getRejectedBy();
		if(fieldName.equals("ONWARDREFERRALREASON"))
			return getOnwardReferralReason();
		if(fieldName.equals("COPYTOGP"))
			return getCopyToGP();
		if(fieldName.equals("COPYTOPATIENT"))
			return getCopyToPatient();
		if(fieldName.equals("COPYTOSECONDARYCARE"))
			return getCopyToSecondaryCare();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDischargeDateIsNotNull()
	{
		return this.dischargedate != null;
	}
	public ims.framework.utils.Date getDischargeDate()
	{
		return this.dischargedate;
	}
	public void setDischargeDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dischargedate = value;
	}
	public boolean getOnwardReferralOrgIsNotNull()
	{
		return this.onwardreferralorg != null;
	}
	public ims.core.vo.OrgLiteVo getOnwardReferralOrg()
	{
		return this.onwardreferralorg;
	}
	public void setOnwardReferralOrg(ims.core.vo.OrgLiteVo value)
	{
		this.isValidated = false;
		this.onwardreferralorg = value;
	}
	public boolean getOnwardReferralIsNotNull()
	{
		return this.onwardreferral != null;
	}
	public String getOnwardReferral()
	{
		return this.onwardreferral;
	}
	public static int getOnwardReferralMaxLength()
	{
		return 3000;
	}
	public void setOnwardReferral(String value)
	{
		this.isValidated = false;
		this.onwardreferral = value;
	}
	public boolean getRejectedDateIsNotNull()
	{
		return this.rejecteddate != null;
	}
	public ims.framework.utils.Date getRejectedDate()
	{
		return this.rejecteddate;
	}
	public void setRejectedDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.rejecteddate = value;
	}
	public boolean getRejectionReasonIsNotNull()
	{
		return this.rejectionreason != null;
	}
	public String getRejectionReason()
	{
		return this.rejectionreason;
	}
	public static int getRejectionReasonMaxLength()
	{
		return 500;
	}
	public void setRejectionReason(String value)
	{
		this.isValidated = false;
		this.rejectionreason = value;
	}
	public boolean getRejectedByIsNotNull()
	{
		return this.rejectedby != null;
	}
	public ims.careuk.vo.lookups.OnwardReferralRejectedBy getRejectedBy()
	{
		return this.rejectedby;
	}
	public void setRejectedBy(ims.careuk.vo.lookups.OnwardReferralRejectedBy value)
	{
		this.isValidated = false;
		this.rejectedby = value;
	}
	public boolean getOnwardReferralReasonIsNotNull()
	{
		return this.onwardreferralreason != null;
	}
	public ims.careuk.vo.lookups.OnwardReferralReason getOnwardReferralReason()
	{
		return this.onwardreferralreason;
	}
	public void setOnwardReferralReason(ims.careuk.vo.lookups.OnwardReferralReason value)
	{
		this.isValidated = false;
		this.onwardreferralreason = value;
	}
	public boolean getCopyToGPIsNotNull()
	{
		return this.copytogp != null;
	}
	public Boolean getCopyToGP()
	{
		return this.copytogp;
	}
	public void setCopyToGP(Boolean value)
	{
		this.isValidated = false;
		this.copytogp = value;
	}
	public boolean getCopyToPatientIsNotNull()
	{
		return this.copytopatient != null;
	}
	public Boolean getCopyToPatient()
	{
		return this.copytopatient;
	}
	public void setCopyToPatient(Boolean value)
	{
		this.isValidated = false;
		this.copytopatient = value;
	}
	public boolean getCopyToSecondaryCareIsNotNull()
	{
		return this.copytosecondarycare != null;
	}
	public Boolean getCopyToSecondaryCare()
	{
		return this.copytosecondarycare;
	}
	public void setCopyToSecondaryCare(Boolean value)
	{
		this.isValidated = false;
		this.copytosecondarycare = value;
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
		if(this.dischargedate == null)
			listOfErrors.add("Discharge Date is mandatory");
		if(this.onwardreferral != null)
			if(this.onwardreferral.length() > 3000)
				listOfErrors.add("The length of the field [onwardreferral] in the value object [ims.careuk.vo.OnwardReferralVo] is too big. It should be less or equal to 3000");
		if(this.rejectionreason != null)
			if(this.rejectionreason.length() > 500)
				listOfErrors.add("The length of the field [rejectionreason] in the value object [ims.careuk.vo.OnwardReferralVo] is too big. It should be less or equal to 500");
		if(this.onwardreferralreason == null)
			listOfErrors.add("Onward Referral Reason is mandatory");
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
	
		OnwardReferralVo clone = new OnwardReferralVo(this.id, this.version);
		
		if(this.dischargedate == null)
			clone.dischargedate = null;
		else
			clone.dischargedate = (ims.framework.utils.Date)this.dischargedate.clone();
		if(this.onwardreferralorg == null)
			clone.onwardreferralorg = null;
		else
			clone.onwardreferralorg = (ims.core.vo.OrgLiteVo)this.onwardreferralorg.clone();
		clone.onwardreferral = this.onwardreferral;
		if(this.rejecteddate == null)
			clone.rejecteddate = null;
		else
			clone.rejecteddate = (ims.framework.utils.Date)this.rejecteddate.clone();
		clone.rejectionreason = this.rejectionreason;
		if(this.rejectedby == null)
			clone.rejectedby = null;
		else
			clone.rejectedby = (ims.careuk.vo.lookups.OnwardReferralRejectedBy)this.rejectedby.clone();
		if(this.onwardreferralreason == null)
			clone.onwardreferralreason = null;
		else
			clone.onwardreferralreason = (ims.careuk.vo.lookups.OnwardReferralReason)this.onwardreferralreason.clone();
		clone.copytogp = this.copytogp;
		clone.copytopatient = this.copytopatient;
		clone.copytosecondarycare = this.copytosecondarycare;
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
		if (!(OnwardReferralVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OnwardReferralVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((OnwardReferralVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((OnwardReferralVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.dischargedate != null)
			count++;
		if(this.onwardreferralorg != null)
			count++;
		if(this.onwardreferral != null)
			count++;
		if(this.rejecteddate != null)
			count++;
		if(this.rejectionreason != null)
			count++;
		if(this.rejectedby != null)
			count++;
		if(this.onwardreferralreason != null)
			count++;
		if(this.copytogp != null)
			count++;
		if(this.copytopatient != null)
			count++;
		if(this.copytosecondarycare != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.framework.utils.Date dischargedate;
	protected ims.core.vo.OrgLiteVo onwardreferralorg;
	protected String onwardreferral;
	protected ims.framework.utils.Date rejecteddate;
	protected String rejectionreason;
	protected ims.careuk.vo.lookups.OnwardReferralRejectedBy rejectedby;
	protected ims.careuk.vo.lookups.OnwardReferralReason onwardreferralreason;
	protected Boolean copytogp;
	protected Boolean copytopatient;
	protected Boolean copytosecondarycare;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
