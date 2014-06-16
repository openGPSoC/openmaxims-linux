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

package ims.emergency.vo;

/**
 * Linked to core.admin.EmergencyAttendance business object (ID: 1004100025).
 */
public class EmergencyAttendanceForTriageVo extends ims.emergency.vo.EmergencyAttendanceForTriageLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EmergencyAttendanceForTriageVo()
	{
	}
	public EmergencyAttendanceForTriageVo(Integer id, int version)
	{
		super(id, version);
	}
	public EmergencyAttendanceForTriageVo(ims.emergency.vo.beans.EmergencyAttendanceForTriageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.registrationdatetime = bean.getRegistrationDateTime() == null ? null : bean.getRegistrationDateTime().buildDateTime();
		this.ageatattendance = bean.getAgeAtAttendance();
		this.arrivaldatetime = bean.getArrivalDateTime() == null ? null : bean.getArrivalDateTime().buildDateTime();
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.urgencylevel = bean.getUrgencyLevel() == null ? null : ims.emergency.vo.lookups.UrgencyLevel.buildLookup(bean.getUrgencyLevel());
		this.conclusiondatetime = bean.getConclusionDateTime() == null ? null : bean.getConclusionDateTime().buildDateTime();
		this.bedtyperequested = bean.getBedTypeRequested() == null ? null : ims.core.vo.lookups.BedTypeRequested.buildLookup(bean.getBedTypeRequested());
		this.mc = bean.getMC();
		this.cota = bean.getCOTA();
		this.pcg1 = bean.getPCG1();
		this.pcg2 = bean.getPCG2();
		this.har = bean.getHAR();
		this.purchaser = bean.getPurchaser();
		this.sequencenumber = bean.getSequenceNumber();
		this.registrationlocation = bean.getRegistrationLocation() == null ? null : bean.getRegistrationLocation().buildVo();
		this.outcome = bean.getOutcome() == null ? null : ims.emergency.vo.lookups.AttendanceOutcome.buildLookup(bean.getOutcome());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.EmergencyAttendanceForTriageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.registrationdatetime = bean.getRegistrationDateTime() == null ? null : bean.getRegistrationDateTime().buildDateTime();
		this.ageatattendance = bean.getAgeAtAttendance();
		this.arrivaldatetime = bean.getArrivalDateTime() == null ? null : bean.getArrivalDateTime().buildDateTime();
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.urgencylevel = bean.getUrgencyLevel() == null ? null : ims.emergency.vo.lookups.UrgencyLevel.buildLookup(bean.getUrgencyLevel());
		this.conclusiondatetime = bean.getConclusionDateTime() == null ? null : bean.getConclusionDateTime().buildDateTime();
		this.bedtyperequested = bean.getBedTypeRequested() == null ? null : ims.core.vo.lookups.BedTypeRequested.buildLookup(bean.getBedTypeRequested());
		this.mc = bean.getMC();
		this.cota = bean.getCOTA();
		this.pcg1 = bean.getPCG1();
		this.pcg2 = bean.getPCG2();
		this.har = bean.getHAR();
		this.purchaser = bean.getPurchaser();
		this.sequencenumber = bean.getSequenceNumber();
		this.registrationlocation = bean.getRegistrationLocation() == null ? null : bean.getRegistrationLocation().buildVo(map);
		this.outcome = bean.getOutcome() == null ? null : ims.emergency.vo.lookups.AttendanceOutcome.buildLookup(bean.getOutcome());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.EmergencyAttendanceForTriageVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.EmergencyAttendanceForTriageVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.EmergencyAttendanceForTriageVoBean();
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
		if(fieldName.equals("REGISTRATIONLOCATION"))
			return getRegistrationLocation();
		if(fieldName.equals("OUTCOME"))
			return getOutcome();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getRegistrationLocationIsNotNull()
	{
		return this.registrationlocation != null;
	}
	public ims.core.vo.LocationLiteVo getRegistrationLocation()
	{
		return this.registrationlocation;
	}
	public void setRegistrationLocation(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.registrationlocation = value;
	}
	public boolean getOutcomeIsNotNull()
	{
		return this.outcome != null;
	}
	public ims.emergency.vo.lookups.AttendanceOutcome getOutcome()
	{
		return this.outcome;
	}
	public void setOutcome(ims.emergency.vo.lookups.AttendanceOutcome value)
	{
		this.isValidated = false;
		this.outcome = value;
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
		if(this.registrationdatetime == null)
			listOfErrors.add("RegistrationDateTime is mandatory");
		if(this.arrivaldatetime == null)
			listOfErrors.add("ArrivalDateTime is mandatory");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.mc != null)
			if(this.mc.length() > 5)
				listOfErrors.add("The length of the field [mc] in the value object [ims.emergency.vo.EmergencyAttendanceForTriageVo] is too big. It should be less or equal to 5");
		if(this.cota != null)
			if(this.cota.length() > 5)
				listOfErrors.add("The length of the field [cota] in the value object [ims.emergency.vo.EmergencyAttendanceForTriageVo] is too big. It should be less or equal to 5");
		if(this.pcg1 != null)
			if(this.pcg1.length() > 5)
				listOfErrors.add("The length of the field [pcg1] in the value object [ims.emergency.vo.EmergencyAttendanceForTriageVo] is too big. It should be less or equal to 5");
		if(this.pcg2 != null)
			if(this.pcg2.length() > 5)
				listOfErrors.add("The length of the field [pcg2] in the value object [ims.emergency.vo.EmergencyAttendanceForTriageVo] is too big. It should be less or equal to 5");
		if(this.har != null)
			if(this.har.length() > 5)
				listOfErrors.add("The length of the field [har] in the value object [ims.emergency.vo.EmergencyAttendanceForTriageVo] is too big. It should be less or equal to 5");
		if(this.purchaser != null)
			if(this.purchaser.length() > 5)
				listOfErrors.add("The length of the field [purchaser] in the value object [ims.emergency.vo.EmergencyAttendanceForTriageVo] is too big. It should be less or equal to 5");
		if(this.sequencenumber != null)
			if(this.sequencenumber.length() > 6)
				listOfErrors.add("The length of the field [sequencenumber] in the value object [ims.emergency.vo.EmergencyAttendanceForTriageVo] is too big. It should be less or equal to 6");
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
	
		EmergencyAttendanceForTriageVo clone = new EmergencyAttendanceForTriageVo(this.id, this.version);
		
		if(this.registrationdatetime == null)
			clone.registrationdatetime = null;
		else
			clone.registrationdatetime = (ims.framework.utils.DateTime)this.registrationdatetime.clone();
		clone.ageatattendance = this.ageatattendance;
		if(this.arrivaldatetime == null)
			clone.arrivaldatetime = null;
		else
			clone.arrivaldatetime = (ims.framework.utils.DateTime)this.arrivaldatetime.clone();
		if(this.dischargedatetime == null)
			clone.dischargedatetime = null;
		else
			clone.dischargedatetime = (ims.framework.utils.DateTime)this.dischargedatetime.clone();
		clone.carecontext = this.carecontext;
		if(this.urgencylevel == null)
			clone.urgencylevel = null;
		else
			clone.urgencylevel = (ims.emergency.vo.lookups.UrgencyLevel)this.urgencylevel.clone();
		if(this.conclusiondatetime == null)
			clone.conclusiondatetime = null;
		else
			clone.conclusiondatetime = (ims.framework.utils.DateTime)this.conclusiondatetime.clone();
		if(this.bedtyperequested == null)
			clone.bedtyperequested = null;
		else
			clone.bedtyperequested = (ims.core.vo.lookups.BedTypeRequested)this.bedtyperequested.clone();
		clone.mc = this.mc;
		clone.cota = this.cota;
		clone.pcg1 = this.pcg1;
		clone.pcg2 = this.pcg2;
		clone.har = this.har;
		clone.purchaser = this.purchaser;
		clone.sequencenumber = this.sequencenumber;
		if(this.registrationlocation == null)
			clone.registrationlocation = null;
		else
			clone.registrationlocation = (ims.core.vo.LocationLiteVo)this.registrationlocation.clone();
		if(this.outcome == null)
			clone.outcome = null;
		else
			clone.outcome = (ims.emergency.vo.lookups.AttendanceOutcome)this.outcome.clone();
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
		if (!(EmergencyAttendanceForTriageVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EmergencyAttendanceForTriageVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EmergencyAttendanceForTriageVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EmergencyAttendanceForTriageVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.registrationlocation != null)
			count++;
		if(this.outcome != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 2;
	}
	protected ims.core.vo.LocationLiteVo registrationlocation;
	protected ims.emergency.vo.lookups.AttendanceOutcome outcome;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
