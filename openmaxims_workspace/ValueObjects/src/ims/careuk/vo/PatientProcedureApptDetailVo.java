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
 * Linked to core.clinical.PatientProcedure business object (ID: 1003100017).
 */
public class PatientProcedureApptDetailVo extends ims.careuk.vo.PatientProcedureForClinicalNotesVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IClinicalCodingValue
{
	private static final long serialVersionUID = 1L;

	public PatientProcedureApptDetailVo()
	{
	}
	public PatientProcedureApptDetailVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientProcedureApptDetailVo(ims.careuk.vo.beans.PatientProcedureApptDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo();
		this.proceduredescription = bean.getProcedureDescription();
		this.infosource = bean.getInfoSource() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getInfoSource());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.procdate = bean.getProcDate() == null ? null : bean.getProcDate().buildPartialDate();
		this.procedurestatus = bean.getProcedureStatus() == null ? null : ims.core.vo.lookups.PatientProcedureStatus.buildLookup(bean.getProcedureStatus());
		this.incompletereason = bean.getIncompleteReason() == null ? null : ims.core.vo.lookups.ProcedureIncompleteReason.buildLookup(bean.getIncompleteReason());
		this.appointment = bean.getAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getAppointment().getId()), bean.getAppointment().getVersion());
		this.isprimaryprocedure = bean.getIsPrimaryProcedure();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.PatientProcedureApptDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo(map);
		this.proceduredescription = bean.getProcedureDescription();
		this.infosource = bean.getInfoSource() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getInfoSource());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.procdate = bean.getProcDate() == null ? null : bean.getProcDate().buildPartialDate();
		this.procedurestatus = bean.getProcedureStatus() == null ? null : ims.core.vo.lookups.PatientProcedureStatus.buildLookup(bean.getProcedureStatus());
		this.incompletereason = bean.getIncompleteReason() == null ? null : ims.core.vo.lookups.ProcedureIncompleteReason.buildLookup(bean.getIncompleteReason());
		this.appointment = bean.getAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getAppointment().getId()), bean.getAppointment().getVersion());
		this.isprimaryprocedure = bean.getIsPrimaryProcedure();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.PatientProcedureApptDetailVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.PatientProcedureApptDetailVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.PatientProcedureApptDetailVoBean();
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
		if(fieldName.equals("APPOINTMENT"))
			return getAppointment();
		if(fieldName.equals("ISPRIMARYPROCEDURE"))
			return getIsPrimaryProcedure();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAppointmentIsNotNull()
	{
		return this.appointment != null;
	}
	public ims.scheduling.vo.Booking_AppointmentRefVo getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(ims.scheduling.vo.Booking_AppointmentRefVo value)
	{
		this.isValidated = false;
		this.appointment = value;
	}
	public boolean getIsPrimaryProcedureIsNotNull()
	{
		return this.isprimaryprocedure != null;
	}
	public Boolean getIsPrimaryProcedure()
	{
		return this.isprimaryprocedure;
	}
	public void setIsPrimaryProcedure(Boolean value)
	{
		this.isValidated = false;
		this.isprimaryprocedure = value;
	}
	/**
	* IClinicalCoding methods
	*/
	public ims.vo.ValueObject getIClinicalCodingValue() 
	{
		return this.procedure;
	}
	public void setIClinicalCodingValue(ims.vo.ValueObject vo) 
	{
		this.procedure = (ims.core.vo.ProcedureLiteVo)vo;
	}
	public String getIClinicalCodingValueDescription() 
	{
		return this.proceduredescription;
	}
	public void setIClinicalCodingValueDescription(String value) 
	{
		this.proceduredescription = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
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
		if(this.proceduredescription == null || this.proceduredescription.length() == 0)
			listOfErrors.add("ProcedureDescription is mandatory");
		else if(this.proceduredescription.length() > 255)
			listOfErrors.add("The length of the field [proceduredescription] in the value object [ims.careuk.vo.PatientProcedureApptDetailVo] is too big. It should be less or equal to 255");
		if(this.infosource == null)
			listOfErrors.add("InfoSource is mandatory");
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
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
	
		PatientProcedureApptDetailVo clone = new PatientProcedureApptDetailVo(this.id, this.version);
		
		if(this.procedure == null)
			clone.procedure = null;
		else
			clone.procedure = (ims.core.vo.ProcedureLiteVo)this.procedure.clone();
		clone.proceduredescription = this.proceduredescription;
		if(this.infosource == null)
			clone.infosource = null;
		else
			clone.infosource = (ims.core.vo.lookups.SourceofInformation)this.infosource.clone();
		clone.carecontext = this.carecontext;
		clone.episodeofcare = this.episodeofcare;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.procdate == null)
			clone.procdate = null;
		else
			clone.procdate = (ims.framework.utils.PartialDate)this.procdate.clone();
		if(this.procedurestatus == null)
			clone.procedurestatus = null;
		else
			clone.procedurestatus = (ims.core.vo.lookups.PatientProcedureStatus)this.procedurestatus.clone();
		if(this.incompletereason == null)
			clone.incompletereason = null;
		else
			clone.incompletereason = (ims.core.vo.lookups.ProcedureIncompleteReason)this.incompletereason.clone();
		clone.appointment = this.appointment;
		clone.isprimaryprocedure = this.isprimaryprocedure;
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
		if (!(PatientProcedureApptDetailVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientProcedureApptDetailVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientProcedureApptDetailVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientProcedureApptDetailVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.appointment != null)
			count++;
		if(this.isprimaryprocedure != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 2;
	}
	protected ims.scheduling.vo.Booking_AppointmentRefVo appointment;
	protected Boolean isprimaryprocedure;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
