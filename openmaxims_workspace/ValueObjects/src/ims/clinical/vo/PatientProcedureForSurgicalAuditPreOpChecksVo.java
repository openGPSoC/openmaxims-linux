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

package ims.clinical.vo;

/**
 * Linked to core.clinical.PatientProcedure business object (ID: 1003100017).
 */
public class PatientProcedureForSurgicalAuditPreOpChecksVo extends ims.core.clinical.vo.PatientProcedureRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IClinicalCodingValue
{
	private static final long serialVersionUID = 1L;

	public PatientProcedureForSurgicalAuditPreOpChecksVo()
	{
	}
	public PatientProcedureForSurgicalAuditPreOpChecksVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientProcedureForSurgicalAuditPreOpChecksVo(ims.clinical.vo.beans.PatientProcedureForSurgicalAuditPreOpChecksVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.proceduredescription = bean.getProcedureDescription();
		this.infosource = bean.getInfoSource() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getInfoSource());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.isprimary = bean.getIsPrimary();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo();
		this.procedurestatus = bean.getProcedureStatus() == null ? null : ims.core.vo.lookups.PatientProcedureStatus.buildLookup(bean.getProcedureStatus());
		this.procedureoutcome = bean.getProcedureOutcome() == null ? null : ims.clinical.vo.lookups.PatientProcedureOutcome.buildLookup(bean.getProcedureOutcome());
		this.cancelleddate = bean.getCancelledDate() == null ? null : bean.getCancelledDate().buildDate();
		this.peformedby = bean.getPeformedBy() == null ? null : bean.getPeformedBy().buildVo();
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo();
		this.issaved = bean.getIsSaved();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.PatientProcedureForSurgicalAuditPreOpChecksVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.proceduredescription = bean.getProcedureDescription();
		this.infosource = bean.getInfoSource() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getInfoSource());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.isprimary = bean.getIsPrimary();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo(map);
		this.procedurestatus = bean.getProcedureStatus() == null ? null : ims.core.vo.lookups.PatientProcedureStatus.buildLookup(bean.getProcedureStatus());
		this.procedureoutcome = bean.getProcedureOutcome() == null ? null : ims.clinical.vo.lookups.PatientProcedureOutcome.buildLookup(bean.getProcedureOutcome());
		this.cancelleddate = bean.getCancelledDate() == null ? null : bean.getCancelledDate().buildDate();
		this.peformedby = bean.getPeformedBy() == null ? null : bean.getPeformedBy().buildVo(map);
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo(map);
		this.issaved = bean.getIsSaved();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.PatientProcedureForSurgicalAuditPreOpChecksVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.PatientProcedureForSurgicalAuditPreOpChecksVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.PatientProcedureForSurgicalAuditPreOpChecksVoBean();
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
		if(fieldName.equals("PROCEDUREDESCRIPTION"))
			return getProcedureDescription();
		if(fieldName.equals("INFOSOURCE"))
			return getInfoSource();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		if(fieldName.equals("ISPRIMARY"))
			return getIsPrimary();
		if(fieldName.equals("PROCEDURE"))
			return getProcedure();
		if(fieldName.equals("PROCEDURESTATUS"))
			return getProcedureStatus();
		if(fieldName.equals("PROCEDUREOUTCOME"))
			return getProcedureOutcome();
		if(fieldName.equals("CANCELLEDDATE"))
			return getCancelledDate();
		if(fieldName.equals("PEFORMEDBY"))
			return getPeformedBy();
		if(fieldName.equals("CONSULTANT"))
			return getConsultant();
		if(fieldName.equals("ISSAVED"))
			return getIsSaved();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getProcedureDescriptionIsNotNull()
	{
		return this.proceduredescription != null;
	}
	public String getProcedureDescription()
	{
		return this.proceduredescription;
	}
	public static int getProcedureDescriptionMaxLength()
	{
		return 255;
	}
	public void setProcedureDescription(String value)
	{
		this.isValidated = false;
		this.proceduredescription = value;
	}
	public boolean getInfoSourceIsNotNull()
	{
		return this.infosource != null;
	}
	public ims.core.vo.lookups.SourceofInformation getInfoSource()
	{
		return this.infosource;
	}
	public void setInfoSource(ims.core.vo.lookups.SourceofInformation value)
	{
		this.isValidated = false;
		this.infosource = value;
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
	public boolean getEpisodeOfCareIsNotNull()
	{
		return this.episodeofcare != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episodeofcare = value;
	}
	public boolean getIsPrimaryIsNotNull()
	{
		return this.isprimary != null;
	}
	public Boolean getIsPrimary()
	{
		return this.isprimary;
	}
	public void setIsPrimary(Boolean value)
	{
		this.isValidated = false;
		this.isprimary = value;
	}
	public boolean getProcedureIsNotNull()
	{
		return this.procedure != null;
	}
	public ims.core.vo.ProcedureLiteVo getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.ProcedureLiteVo value)
	{
		this.isValidated = false;
		this.procedure = value;
	}
	public boolean getProcedureStatusIsNotNull()
	{
		return this.procedurestatus != null;
	}
	public ims.core.vo.lookups.PatientProcedureStatus getProcedureStatus()
	{
		return this.procedurestatus;
	}
	public void setProcedureStatus(ims.core.vo.lookups.PatientProcedureStatus value)
	{
		this.isValidated = false;
		this.procedurestatus = value;
	}
	public boolean getProcedureOutcomeIsNotNull()
	{
		return this.procedureoutcome != null;
	}
	public ims.clinical.vo.lookups.PatientProcedureOutcome getProcedureOutcome()
	{
		return this.procedureoutcome;
	}
	public void setProcedureOutcome(ims.clinical.vo.lookups.PatientProcedureOutcome value)
	{
		this.isValidated = false;
		this.procedureoutcome = value;
	}
	public boolean getCancelledDateIsNotNull()
	{
		return this.cancelleddate != null;
	}
	public ims.framework.utils.Date getCancelledDate()
	{
		return this.cancelleddate;
	}
	public void setCancelledDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.cancelleddate = value;
	}
	public boolean getPeformedByIsNotNull()
	{
		return this.peformedby != null;
	}
	public ims.core.vo.HcpLiteVo getPeformedBy()
	{
		return this.peformedby;
	}
	public void setPeformedBy(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.peformedby = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.vo.HcpLiteVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.consultant = value;
	}
	public boolean getIsSavedIsNotNull()
	{
		return this.issaved != null;
	}
	public Boolean getIsSaved()
	{
		return this.issaved;
	}
	public void setIsSaved(Boolean value)
	{
		this.isValidated = false;
		this.issaved = value;
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
		if(this.procedure != null)
		{
			if(!this.procedure.isValidated())
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
			listOfErrors.add("The length of the field [proceduredescription] in the value object [ims.clinical.vo.PatientProcedureForSurgicalAuditPreOpChecksVo] is too big. It should be less or equal to 255");
		if(this.infosource == null)
			listOfErrors.add("InfoSource is mandatory");
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
		if(this.procedure != null)
		{
			String[] listOfOtherErrors = this.procedure.validate();
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
	
		PatientProcedureForSurgicalAuditPreOpChecksVo clone = new PatientProcedureForSurgicalAuditPreOpChecksVo(this.id, this.version);
		
		clone.proceduredescription = this.proceduredescription;
		if(this.infosource == null)
			clone.infosource = null;
		else
			clone.infosource = (ims.core.vo.lookups.SourceofInformation)this.infosource.clone();
		clone.carecontext = this.carecontext;
		clone.episodeofcare = this.episodeofcare;
		clone.isprimary = this.isprimary;
		if(this.procedure == null)
			clone.procedure = null;
		else
			clone.procedure = (ims.core.vo.ProcedureLiteVo)this.procedure.clone();
		if(this.procedurestatus == null)
			clone.procedurestatus = null;
		else
			clone.procedurestatus = (ims.core.vo.lookups.PatientProcedureStatus)this.procedurestatus.clone();
		if(this.procedureoutcome == null)
			clone.procedureoutcome = null;
		else
			clone.procedureoutcome = (ims.clinical.vo.lookups.PatientProcedureOutcome)this.procedureoutcome.clone();
		if(this.cancelleddate == null)
			clone.cancelleddate = null;
		else
			clone.cancelleddate = (ims.framework.utils.Date)this.cancelleddate.clone();
		if(this.peformedby == null)
			clone.peformedby = null;
		else
			clone.peformedby = (ims.core.vo.HcpLiteVo)this.peformedby.clone();
		if(this.consultant == null)
			clone.consultant = null;
		else
			clone.consultant = (ims.core.vo.HcpLiteVo)this.consultant.clone();
		clone.issaved = this.issaved;
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
		if (!(PatientProcedureForSurgicalAuditPreOpChecksVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientProcedureForSurgicalAuditPreOpChecksVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientProcedureForSurgicalAuditPreOpChecksVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientProcedureForSurgicalAuditPreOpChecksVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.proceduredescription != null)
			count++;
		if(this.infosource != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.episodeofcare != null)
			count++;
		if(this.isprimary != null)
			count++;
		if(this.procedure != null)
			count++;
		if(this.procedurestatus != null)
			count++;
		if(this.procedureoutcome != null)
			count++;
		if(this.cancelleddate != null)
			count++;
		if(this.peformedby != null)
			count++;
		if(this.consultant != null)
			count++;
		if(this.issaved != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected String proceduredescription;
	protected ims.core.vo.lookups.SourceofInformation infosource;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episodeofcare;
	protected Boolean isprimary;
	protected ims.core.vo.ProcedureLiteVo procedure;
	protected ims.core.vo.lookups.PatientProcedureStatus procedurestatus;
	protected ims.clinical.vo.lookups.PatientProcedureOutcome procedureoutcome;
	protected ims.framework.utils.Date cancelleddate;
	protected ims.core.vo.HcpLiteVo peformedby;
	protected ims.core.vo.HcpLiteVo consultant;
	protected Boolean issaved;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
