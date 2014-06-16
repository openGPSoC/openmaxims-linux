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
 * Linked to core.admin.pas.DischargedEpisode business object (ID: 1014100006).
 */
public class DischargedEpisodeVo extends ims.core.admin.pas.vo.DischargedEpisodeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DischargedEpisodeVo()
	{
	}
	public DischargedEpisodeVo(Integer id, int version)
	{
		super(id, version);
	}
	public DischargedEpisodeVo(ims.core.vo.beans.DischargedEpisodeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo();
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.isactive = bean.getIsActive();
		this.dischargedestination = bean.getDischargeDestination() == null ? null : ims.coe.vo.lookups.DischargeDestination.buildLookup(bean.getDischargeDestination());
		this.admissiontype = bean.getAdmissionType() == null ? null : ims.core.vo.lookups.AdmissionType.buildLookup(bean.getAdmissionType());
		this.methodofdischarge = bean.getMethodOfDischarge() == null ? null : ims.core.vo.lookups.MethodOfDischarge.buildLookup(bean.getMethodOfDischarge());
		this.admissiondetail = bean.getAdmissionDetail() == null ? null : new ims.core.admin.pas.vo.AdmissionDetailRefVo(new Integer(bean.getAdmissionDetail().getId()), bean.getAdmissionDetail().getVersion());
		this.extendeddetails = bean.getExtendedDetails() == null ? null : bean.getExtendedDetails().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.DischargedEpisodeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo(map);
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.isactive = bean.getIsActive();
		this.dischargedestination = bean.getDischargeDestination() == null ? null : ims.coe.vo.lookups.DischargeDestination.buildLookup(bean.getDischargeDestination());
		this.admissiontype = bean.getAdmissionType() == null ? null : ims.core.vo.lookups.AdmissionType.buildLookup(bean.getAdmissionType());
		this.methodofdischarge = bean.getMethodOfDischarge() == null ? null : ims.core.vo.lookups.MethodOfDischarge.buildLookup(bean.getMethodOfDischarge());
		this.admissiondetail = bean.getAdmissionDetail() == null ? null : new ims.core.admin.pas.vo.AdmissionDetailRefVo(new Integer(bean.getAdmissionDetail().getId()), bean.getAdmissionDetail().getVersion());
		this.extendeddetails = bean.getExtendedDetails() == null ? null : bean.getExtendedDetails().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.DischargedEpisodeVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.DischargedEpisodeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.DischargedEpisodeVoBean();
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
		if(fieldName.equals("PASEVENT"))
			return getPasEvent();
		if(fieldName.equals("DISCHARGEDATETIME"))
			return getDischargeDateTime();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("DISCHARGEDESTINATION"))
			return getDischargeDestination();
		if(fieldName.equals("ADMISSIONTYPE"))
			return getAdmissionType();
		if(fieldName.equals("METHODOFDISCHARGE"))
			return getMethodOfDischarge();
		if(fieldName.equals("ADMISSIONDETAIL"))
			return getAdmissionDetail();
		if(fieldName.equals("EXTENDEDDETAILS"))
			return getExtendedDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPasEventIsNotNull()
	{
		return this.pasevent != null;
	}
	public ims.core.vo.PasEventVo getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.PasEventVo value)
	{
		this.isValidated = false;
		this.pasevent = value;
	}
	public boolean getDischargeDateTimeIsNotNull()
	{
		return this.dischargedatetime != null;
	}
	public ims.framework.utils.DateTime getDischargeDateTime()
	{
		return this.dischargedatetime;
	}
	public void setDischargeDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.dischargedatetime = value;
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
	public boolean getDischargeDestinationIsNotNull()
	{
		return this.dischargedestination != null;
	}
	public ims.coe.vo.lookups.DischargeDestination getDischargeDestination()
	{
		return this.dischargedestination;
	}
	public void setDischargeDestination(ims.coe.vo.lookups.DischargeDestination value)
	{
		this.isValidated = false;
		this.dischargedestination = value;
	}
	public boolean getAdmissionTypeIsNotNull()
	{
		return this.admissiontype != null;
	}
	public ims.core.vo.lookups.AdmissionType getAdmissionType()
	{
		return this.admissiontype;
	}
	public void setAdmissionType(ims.core.vo.lookups.AdmissionType value)
	{
		this.isValidated = false;
		this.admissiontype = value;
	}
	public boolean getMethodOfDischargeIsNotNull()
	{
		return this.methodofdischarge != null;
	}
	public ims.core.vo.lookups.MethodOfDischarge getMethodOfDischarge()
	{
		return this.methodofdischarge;
	}
	public void setMethodOfDischarge(ims.core.vo.lookups.MethodOfDischarge value)
	{
		this.isValidated = false;
		this.methodofdischarge = value;
	}
	public boolean getAdmissionDetailIsNotNull()
	{
		return this.admissiondetail != null;
	}
	public ims.core.admin.pas.vo.AdmissionDetailRefVo getAdmissionDetail()
	{
		return this.admissiondetail;
	}
	public void setAdmissionDetail(ims.core.admin.pas.vo.AdmissionDetailRefVo value)
	{
		this.isValidated = false;
		this.admissiondetail = value;
	}
	public boolean getExtendedDetailsIsNotNull()
	{
		return this.extendeddetails != null;
	}
	public ims.core.vo.ExtendedDischargeDetailVo getExtendedDetails()
	{
		return this.extendeddetails;
	}
	public void setExtendedDetails(ims.core.vo.ExtendedDischargeDetailVo value)
	{
		this.isValidated = false;
		this.extendeddetails = value;
	}
	/**
	* DischargedEpisodeVoDateTimeComparator (class definition)
	*/
	public static class DischargedEpisodeVoDateTimeComparator implements java.util.Comparator
	{
		private int direction = 1;
		public DischargedEpisodeVoDateTimeComparator ()
		{
			this(ims.framework.enumerations.SortOrder.ASCENDING);
		}
		public DischargedEpisodeVoDateTimeComparator (ims.framework.enumerations.SortOrder order)
		{
			if (order == ims.framework.enumerations.SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			DischargedEpisodeVo voObj1 = (DischargedEpisodeVo)obj1;
			DischargedEpisodeVo voObj2 = (DischargedEpisodeVo)obj2;
			if(voObj1.getDischargeDateTimeIsNotNull() && voObj2.getDischargeDateTimeIsNotNull())
				return direction*(voObj1.getDischargeDateTime().compareTo(voObj2.getDischargeDateTime()));
			else
				return direction;
		}
		public boolean equals(Object obj)
		{
			return false;
		}	
	}
	
	/**
	* getDateTimeComparator - retrieves a new instance of static class DischargedEpisodeVoDateTimeComparator
	*/
	public static DischargedEpisodeVoDateTimeComparator getDateTimeComparator(ims.framework.enumerations.SortOrder sortOrder)
	{
		return new DischargedEpisodeVo.DischargedEpisodeVoDateTimeComparator(sortOrder);
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
		if(this.pasevent != null)
		{
			if(!this.pasevent.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.extendeddetails != null)
		{
			if(!this.extendeddetails.isValidated())
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
		if(this.pasevent != null)
		{
			String[] listOfOtherErrors = this.pasevent.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.extendeddetails != null)
		{
			String[] listOfOtherErrors = this.extendeddetails.validate();
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
	
		DischargedEpisodeVo clone = new DischargedEpisodeVo(this.id, this.version);
		
		if(this.pasevent == null)
			clone.pasevent = null;
		else
			clone.pasevent = (ims.core.vo.PasEventVo)this.pasevent.clone();
		if(this.dischargedatetime == null)
			clone.dischargedatetime = null;
		else
			clone.dischargedatetime = (ims.framework.utils.DateTime)this.dischargedatetime.clone();
		clone.isactive = this.isactive;
		if(this.dischargedestination == null)
			clone.dischargedestination = null;
		else
			clone.dischargedestination = (ims.coe.vo.lookups.DischargeDestination)this.dischargedestination.clone();
		if(this.admissiontype == null)
			clone.admissiontype = null;
		else
			clone.admissiontype = (ims.core.vo.lookups.AdmissionType)this.admissiontype.clone();
		if(this.methodofdischarge == null)
			clone.methodofdischarge = null;
		else
			clone.methodofdischarge = (ims.core.vo.lookups.MethodOfDischarge)this.methodofdischarge.clone();
		clone.admissiondetail = this.admissiondetail;
		if(this.extendeddetails == null)
			clone.extendeddetails = null;
		else
			clone.extendeddetails = (ims.core.vo.ExtendedDischargeDetailVo)this.extendeddetails.clone();
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
		if (!(DischargedEpisodeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DischargedEpisodeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		DischargedEpisodeVo compareObj = (DischargedEpisodeVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPasEvent() == null && compareObj.getPasEvent() != null)
				return -1;
			if(this.getPasEvent() != null && compareObj.getPasEvent() == null)
				return 1;
			if(this.getPasEvent() != null && compareObj.getPasEvent() != null)
				retVal = this.getPasEvent().compareTo(compareObj.getPasEvent());
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
		if(this.pasevent != null)
			count++;
		if(this.dischargedatetime != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.dischargedestination != null)
			count++;
		if(this.admissiontype != null)
			count++;
		if(this.methodofdischarge != null)
			count++;
		if(this.admissiondetail != null)
			count++;
		if(this.extendeddetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.vo.PasEventVo pasevent;
	protected ims.framework.utils.DateTime dischargedatetime;
	protected Boolean isactive;
	protected ims.coe.vo.lookups.DischargeDestination dischargedestination;
	protected ims.core.vo.lookups.AdmissionType admissiontype;
	protected ims.core.vo.lookups.MethodOfDischarge methodofdischarge;
	protected ims.core.admin.pas.vo.AdmissionDetailRefVo admissiondetail;
	protected ims.core.vo.ExtendedDischargeDetailVo extendeddetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
