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
 * Linked to core.clinical.PatientDiagnosis business object (ID: 1003100016).
 */
public class PatientDiagnosisListVo extends ims.core.vo.PatientDiagnosisShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientDiagnosisListVo()
	{
	}
	public PatientDiagnosisListVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientDiagnosisListVo(ims.core.vo.beans.PatientDiagnosisListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.diagnosisdescription = bean.getDiagnosisDescription();
		this.diagnoseddate = bean.getDiagnosedDate() == null ? null : bean.getDiagnosedDate().buildPartialDate();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.sourceofinformation = bean.getSourceofInformation() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getSourceofInformation());
		this.diagnosis = bean.getDiagnosis() == null ? null : bean.getDiagnosis().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.iscomorbidity = bean.getIsComorbidity();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.iscomplication = bean.getIsComplication();
		this.dateresolved = bean.getDateResolved() == null ? null : bean.getDateResolved().buildDate();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.dateonset = bean.getDateOnset() == null ? null : bean.getDateOnset().buildDate();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.diaglaterality = bean.getDiagLaterality() == null ? null : ims.core.vo.lookups.LateralityLRB.buildLookup(bean.getDiagLaterality());
		this.sitetext = bean.getSiteText();
		this.ispmh = bean.getIsPMH();
		this.iscancerdiagnosis = bean.getIsCancerDiagnosis();
		this.authoringinfo = bean.getAuthoringInfo() == null ? null : bean.getAuthoringInfo().buildVo();
		this.primaryforcarespells = ims.core.vo.CSPrimaryDiagnosisVoCollection.buildFromBeanCollection(bean.getPrimaryForCareSpells());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientDiagnosisListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.diagnosisdescription = bean.getDiagnosisDescription();
		this.diagnoseddate = bean.getDiagnosedDate() == null ? null : bean.getDiagnosedDate().buildPartialDate();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.sourceofinformation = bean.getSourceofInformation() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getSourceofInformation());
		this.diagnosis = bean.getDiagnosis() == null ? null : bean.getDiagnosis().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.iscomorbidity = bean.getIsComorbidity();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.iscomplication = bean.getIsComplication();
		this.dateresolved = bean.getDateResolved() == null ? null : bean.getDateResolved().buildDate();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.dateonset = bean.getDateOnset() == null ? null : bean.getDateOnset().buildDate();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.diaglaterality = bean.getDiagLaterality() == null ? null : ims.core.vo.lookups.LateralityLRB.buildLookup(bean.getDiagLaterality());
		this.sitetext = bean.getSiteText();
		this.ispmh = bean.getIsPMH();
		this.iscancerdiagnosis = bean.getIsCancerDiagnosis();
		this.authoringinfo = bean.getAuthoringInfo() == null ? null : bean.getAuthoringInfo().buildVo(map);
		this.primaryforcarespells = ims.core.vo.CSPrimaryDiagnosisVoCollection.buildFromBeanCollection(bean.getPrimaryForCareSpells());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientDiagnosisListVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientDiagnosisListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientDiagnosisListVoBean();
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
		if(fieldName.equals("PRIMARYFORCARESPELLS"))
			return getPrimaryForCareSpells();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPrimaryForCareSpellsIsNotNull()
	{
		return this.primaryforcarespells != null;
	}
	public ims.core.vo.CSPrimaryDiagnosisVoCollection getPrimaryForCareSpells()
	{
		return this.primaryforcarespells;
	}
	public void setPrimaryForCareSpells(ims.core.vo.CSPrimaryDiagnosisVoCollection value)
	{
		this.isValidated = false;
		this.primaryforcarespells = value;
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
		if(this.currentstatus != null)
		{
			if(!this.currentstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.diagnosis != null)
		{
			if(!this.diagnosis.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringinfo != null)
		{
			if(!this.authoringinfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.primaryforcarespells != null)
		{
			if(!this.primaryforcarespells.isValidated())
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
		if(this.diagnosisdescription == null || this.diagnosisdescription.length() == 0)
			listOfErrors.add("DiagnosisDescription is mandatory");
		else if(this.diagnosisdescription.length() > 255)
			listOfErrors.add("The length of the field [diagnosisdescription] in the value object [ims.core.vo.PatientDiagnosisListVo] is too big. It should be less or equal to 255");
		if(this.currentstatus != null)
		{
			String[] listOfOtherErrors = this.currentstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.sourceofinformation == null)
			listOfErrors.add("SourceofInformation is mandatory");
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
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
		if(this.sitetext != null)
			if(this.sitetext.length() > 255)
				listOfErrors.add("The length of the field [sitetext] in the value object [ims.core.vo.PatientDiagnosisListVo] is too big. It should be less or equal to 255");
		if(this.authoringinfo == null)
			listOfErrors.add("Authoring HCP and Date/Time are mandatory ");
		if(this.authoringinfo != null)
		{
			String[] listOfOtherErrors = this.authoringinfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.primaryforcarespells != null)
		{
			String[] listOfOtherErrors = this.primaryforcarespells.validate();
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
	
		PatientDiagnosisListVo clone = new PatientDiagnosisListVo(this.id, this.version);
		
		clone.diagnosisdescription = this.diagnosisdescription;
		if(this.diagnoseddate == null)
			clone.diagnoseddate = null;
		else
			clone.diagnoseddate = (ims.framework.utils.PartialDate)this.diagnoseddate.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.clinical.vo.PatientDiagnosisStatusVo)this.currentstatus.clone();
		if(this.sourceofinformation == null)
			clone.sourceofinformation = null;
		else
			clone.sourceofinformation = (ims.core.vo.lookups.SourceofInformation)this.sourceofinformation.clone();
		if(this.diagnosis == null)
			clone.diagnosis = null;
		else
			clone.diagnosis = (ims.core.vo.DiagLiteVo)this.diagnosis.clone();
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextLiteVo)this.carecontext.clone();
		clone.iscomorbidity = this.iscomorbidity;
		clone.episodeofcare = this.episodeofcare;
		clone.iscomplication = this.iscomplication;
		if(this.dateresolved == null)
			clone.dateresolved = null;
		else
			clone.dateresolved = (ims.framework.utils.Date)this.dateresolved.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		if(this.dateonset == null)
			clone.dateonset = null;
		else
			clone.dateonset = (ims.framework.utils.Date)this.dateonset.clone();
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		if(this.diaglaterality == null)
			clone.diaglaterality = null;
		else
			clone.diaglaterality = (ims.core.vo.lookups.LateralityLRB)this.diaglaterality.clone();
		clone.sitetext = this.sitetext;
		clone.ispmh = this.ispmh;
		clone.iscancerdiagnosis = this.iscancerdiagnosis;
		if(this.authoringinfo == null)
			clone.authoringinfo = null;
		else
			clone.authoringinfo = (ims.core.vo.AuthoringInformationVo)this.authoringinfo.clone();
		if(this.primaryforcarespells == null)
			clone.primaryforcarespells = null;
		else
			clone.primaryforcarespells = (ims.core.vo.CSPrimaryDiagnosisVoCollection)this.primaryforcarespells.clone();
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
		if (!(PatientDiagnosisListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientDiagnosisListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientDiagnosisListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientDiagnosisListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.primaryforcarespells != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 1;
	}
	protected ims.core.vo.CSPrimaryDiagnosisVoCollection primaryforcarespells;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
