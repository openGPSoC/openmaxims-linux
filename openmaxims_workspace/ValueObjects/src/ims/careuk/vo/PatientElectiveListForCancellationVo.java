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
 * Linked to CAREUK.PatientElectiveList business object (ID: 1014100020).
 */
public class PatientElectiveListForCancellationVo extends ims.careuk.vo.PatientElectiveListRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientElectiveListForCancellationVo()
	{
	}
	public PatientElectiveListForCancellationVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientElectiveListForCancellationVo(ims.careuk.vo.beans.PatientElectiveListForCancellationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.electiveliststatus = bean.getElectiveListStatus() == null ? null : bean.getElectiveListStatus().buildVo();
		this.electiveliststatushistory = ims.careuk.vo.ElectiveListStatusVoCollection.buildFromBeanCollection(bean.getElectiveListStatusHistory());
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.referral = bean.getReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getReferral().getId()), bean.getReferral().getVersion());
		this.tcidetails = bean.getTCIDetails() == null ? null : bean.getTCIDetails().buildVo();
		this.tcihistory = ims.careuk.vo.PatientElectiveListTCIForCancelationVoCollection.buildFromBeanCollection(bean.getTCIHistory());
		this.erod = bean.getEROD() == null ? null : bean.getEROD().buildVo();
		this.erodhistory = ims.careuk.vo.ReferralErodForCancellationVoCollection.buildFromBeanCollection(bean.getERODHistory());
		this.patientstatus = bean.getPatientStatus() == null ? null : ims.careuk.vo.lookups.CatsReferralCategory.buildLookup(bean.getPatientStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.PatientElectiveListForCancellationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.electiveliststatus = bean.getElectiveListStatus() == null ? null : bean.getElectiveListStatus().buildVo(map);
		this.electiveliststatushistory = ims.careuk.vo.ElectiveListStatusVoCollection.buildFromBeanCollection(bean.getElectiveListStatusHistory());
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.referral = bean.getReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getReferral().getId()), bean.getReferral().getVersion());
		this.tcidetails = bean.getTCIDetails() == null ? null : bean.getTCIDetails().buildVo(map);
		this.tcihistory = ims.careuk.vo.PatientElectiveListTCIForCancelationVoCollection.buildFromBeanCollection(bean.getTCIHistory());
		this.erod = bean.getEROD() == null ? null : bean.getEROD().buildVo(map);
		this.erodhistory = ims.careuk.vo.ReferralErodForCancellationVoCollection.buildFromBeanCollection(bean.getERODHistory());
		this.patientstatus = bean.getPatientStatus() == null ? null : ims.careuk.vo.lookups.CatsReferralCategory.buildLookup(bean.getPatientStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.PatientElectiveListForCancellationVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.PatientElectiveListForCancellationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.PatientElectiveListForCancellationVoBean();
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
		if(fieldName.equals("ELECTIVELISTSTATUS"))
			return getElectiveListStatus();
		if(fieldName.equals("ELECTIVELISTSTATUSHISTORY"))
			return getElectiveListStatusHistory();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("REFERRAL"))
			return getReferral();
		if(fieldName.equals("TCIDETAILS"))
			return getTCIDetails();
		if(fieldName.equals("TCIHISTORY"))
			return getTCIHistory();
		if(fieldName.equals("EROD"))
			return getEROD();
		if(fieldName.equals("ERODHISTORY"))
			return getERODHistory();
		if(fieldName.equals("PATIENTSTATUS"))
			return getPatientStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getElectiveListStatusIsNotNull()
	{
		return this.electiveliststatus != null;
	}
	public ims.careuk.vo.ElectiveListStatusVo getElectiveListStatus()
	{
		return this.electiveliststatus;
	}
	public void setElectiveListStatus(ims.careuk.vo.ElectiveListStatusVo value)
	{
		this.isValidated = false;
		this.electiveliststatus = value;
	}
	public boolean getElectiveListStatusHistoryIsNotNull()
	{
		return this.electiveliststatushistory != null;
	}
	public ims.careuk.vo.ElectiveListStatusVoCollection getElectiveListStatusHistory()
	{
		return this.electiveliststatushistory;
	}
	public void setElectiveListStatusHistory(ims.careuk.vo.ElectiveListStatusVoCollection value)
	{
		this.isValidated = false;
		this.electiveliststatushistory = value;
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
	public boolean getReferralIsNotNull()
	{
		return this.referral != null;
	}
	public ims.careuk.vo.CatsReferralRefVo getReferral()
	{
		return this.referral;
	}
	public void setReferral(ims.careuk.vo.CatsReferralRefVo value)
	{
		this.isValidated = false;
		this.referral = value;
	}
	public boolean getTCIDetailsIsNotNull()
	{
		return this.tcidetails != null;
	}
	public ims.careuk.vo.PatientElectiveListTCIForCancelationVo getTCIDetails()
	{
		return this.tcidetails;
	}
	public void setTCIDetails(ims.careuk.vo.PatientElectiveListTCIForCancelationVo value)
	{
		this.isValidated = false;
		this.tcidetails = value;
	}
	public boolean getTCIHistoryIsNotNull()
	{
		return this.tcihistory != null;
	}
	public ims.careuk.vo.PatientElectiveListTCIForCancelationVoCollection getTCIHistory()
	{
		return this.tcihistory;
	}
	public void setTCIHistory(ims.careuk.vo.PatientElectiveListTCIForCancelationVoCollection value)
	{
		this.isValidated = false;
		this.tcihistory = value;
	}
	public boolean getERODIsNotNull()
	{
		return this.erod != null;
	}
	public ims.careuk.vo.ReferralErodForCancellationVo getEROD()
	{
		return this.erod;
	}
	public void setEROD(ims.careuk.vo.ReferralErodForCancellationVo value)
	{
		this.isValidated = false;
		this.erod = value;
	}
	public boolean getERODHistoryIsNotNull()
	{
		return this.erodhistory != null;
	}
	public ims.careuk.vo.ReferralErodForCancellationVoCollection getERODHistory()
	{
		return this.erodhistory;
	}
	public void setERODHistory(ims.careuk.vo.ReferralErodForCancellationVoCollection value)
	{
		this.isValidated = false;
		this.erodhistory = value;
	}
	public boolean getPatientStatusIsNotNull()
	{
		return this.patientstatus != null;
	}
	public ims.careuk.vo.lookups.CatsReferralCategory getPatientStatus()
	{
		return this.patientstatus;
	}
	public void setPatientStatus(ims.careuk.vo.lookups.CatsReferralCategory value)
	{
		this.isValidated = false;
		this.patientstatus = value;
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
		if(this.electiveliststatus != null)
		{
			if(!this.electiveliststatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.electiveliststatushistory != null)
		{
			if(!this.electiveliststatushistory.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.tcidetails != null)
		{
			if(!this.tcidetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.tcihistory != null)
		{
			if(!this.tcihistory.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.erod != null)
		{
			if(!this.erod.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.erodhistory != null)
		{
			if(!this.erodhistory.isValidated())
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
		if(this.electiveliststatus == null)
			listOfErrors.add("ElectiveListStatus is mandatory");
		if(this.electiveliststatus != null)
		{
			String[] listOfOtherErrors = this.electiveliststatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.electiveliststatushistory != null)
		{
			String[] listOfOtherErrors = this.electiveliststatushistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.referral == null)
			listOfErrors.add("Referral is mandatory");
		if(this.tcidetails != null)
		{
			String[] listOfOtherErrors = this.tcidetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.tcihistory != null)
		{
			String[] listOfOtherErrors = this.tcihistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.erod != null)
		{
			String[] listOfOtherErrors = this.erod.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.erodhistory != null)
		{
			String[] listOfOtherErrors = this.erodhistory.validate();
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
	
		PatientElectiveListForCancellationVo clone = new PatientElectiveListForCancellationVo(this.id, this.version);
		
		if(this.electiveliststatus == null)
			clone.electiveliststatus = null;
		else
			clone.electiveliststatus = (ims.careuk.vo.ElectiveListStatusVo)this.electiveliststatus.clone();
		if(this.electiveliststatushistory == null)
			clone.electiveliststatushistory = null;
		else
			clone.electiveliststatushistory = (ims.careuk.vo.ElectiveListStatusVoCollection)this.electiveliststatushistory.clone();
		clone.patient = this.patient;
		clone.referral = this.referral;
		if(this.tcidetails == null)
			clone.tcidetails = null;
		else
			clone.tcidetails = (ims.careuk.vo.PatientElectiveListTCIForCancelationVo)this.tcidetails.clone();
		if(this.tcihistory == null)
			clone.tcihistory = null;
		else
			clone.tcihistory = (ims.careuk.vo.PatientElectiveListTCIForCancelationVoCollection)this.tcihistory.clone();
		if(this.erod == null)
			clone.erod = null;
		else
			clone.erod = (ims.careuk.vo.ReferralErodForCancellationVo)this.erod.clone();
		if(this.erodhistory == null)
			clone.erodhistory = null;
		else
			clone.erodhistory = (ims.careuk.vo.ReferralErodForCancellationVoCollection)this.erodhistory.clone();
		if(this.patientstatus == null)
			clone.patientstatus = null;
		else
			clone.patientstatus = (ims.careuk.vo.lookups.CatsReferralCategory)this.patientstatus.clone();
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
		if (!(PatientElectiveListForCancellationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientElectiveListForCancellationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientElectiveListForCancellationVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientElectiveListForCancellationVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.electiveliststatus != null)
			count++;
		if(this.electiveliststatushistory != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.referral != null)
			count++;
		if(this.tcidetails != null)
			count++;
		if(this.tcihistory != null)
			count++;
		if(this.erod != null)
			count++;
		if(this.erodhistory != null)
			count++;
		if(this.patientstatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.careuk.vo.ElectiveListStatusVo electiveliststatus;
	protected ims.careuk.vo.ElectiveListStatusVoCollection electiveliststatushistory;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.careuk.vo.CatsReferralRefVo referral;
	protected ims.careuk.vo.PatientElectiveListTCIForCancelationVo tcidetails;
	protected ims.careuk.vo.PatientElectiveListTCIForCancelationVoCollection tcihistory;
	protected ims.careuk.vo.ReferralErodForCancellationVo erod;
	protected ims.careuk.vo.ReferralErodForCancellationVoCollection erodhistory;
	protected ims.careuk.vo.lookups.CatsReferralCategory patientstatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
