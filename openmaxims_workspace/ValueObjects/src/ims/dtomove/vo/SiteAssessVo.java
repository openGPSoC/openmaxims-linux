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

package ims.dtomove.vo;

/**
 * Linked to dto_move.SiteAssess business object (ID: 1105100044).
 */
public class SiteAssessVo extends ims.dto_move.vo.SiteAssessRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SiteAssessVo()
	{
	}
	public SiteAssessVo(Integer id, int version)
	{
		super(id, version);
	}
	public SiteAssessVo(ims.dtomove.vo.beans.SiteAssessVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pkey = bean.getPkey();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.assessname = bean.getAssessName();
		this.assessspecialty = bean.getAssessSpecialty();
		this.creationdate = bean.getCreationDate() == null ? null : bean.getCreationDate().buildDate();
		this.creationtime = bean.getCreationTime() == null ? null : bean.getCreationTime().buildTime();
		this.assessdataitems = ims.dtomove.vo.SiteAssessItemVoCollection.buildFromBeanCollection(bean.getAssessDataItems());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.dtomove.vo.beans.SiteAssessVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pkey = bean.getPkey();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.assessname = bean.getAssessName();
		this.assessspecialty = bean.getAssessSpecialty();
		this.creationdate = bean.getCreationDate() == null ? null : bean.getCreationDate().buildDate();
		this.creationtime = bean.getCreationTime() == null ? null : bean.getCreationTime().buildTime();
		this.assessdataitems = ims.dtomove.vo.SiteAssessItemVoCollection.buildFromBeanCollection(bean.getAssessDataItems());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.dtomove.vo.beans.SiteAssessVoBean bean = null;
		if(map != null)
			bean = (ims.dtomove.vo.beans.SiteAssessVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.dtomove.vo.beans.SiteAssessVoBean();
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
		if(fieldName.equals("PKEY"))
			return getPkey();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("EPISODE"))
			return getEpisode();
		if(fieldName.equals("ASSESSNAME"))
			return getAssessName();
		if(fieldName.equals("ASSESSSPECIALTY"))
			return getAssessSpecialty();
		if(fieldName.equals("CREATIONDATE"))
			return getCreationDate();
		if(fieldName.equals("CREATIONTIME"))
			return getCreationTime();
		if(fieldName.equals("ASSESSDATAITEMS"))
			return getAssessDataItems();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPkeyIsNotNull()
	{
		return this.pkey != null;
	}
	public Integer getPkey()
	{
		return this.pkey;
	}
	public void setPkey(Integer value)
	{
		this.isValidated = false;
		this.pkey = value;
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
	public boolean getEpisodeIsNotNull()
	{
		return this.episode != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episode = value;
	}
	public boolean getAssessNameIsNotNull()
	{
		return this.assessname != null;
	}
	public String getAssessName()
	{
		return this.assessname;
	}
	public static int getAssessNameMaxLength()
	{
		return 50;
	}
	public void setAssessName(String value)
	{
		this.isValidated = false;
		this.assessname = value;
	}
	public boolean getAssessSpecialtyIsNotNull()
	{
		return this.assessspecialty != null;
	}
	public String getAssessSpecialty()
	{
		return this.assessspecialty;
	}
	public static int getAssessSpecialtyMaxLength()
	{
		return 70;
	}
	public void setAssessSpecialty(String value)
	{
		this.isValidated = false;
		this.assessspecialty = value;
	}
	public boolean getCreationDateIsNotNull()
	{
		return this.creationdate != null;
	}
	public ims.framework.utils.Date getCreationDate()
	{
		return this.creationdate;
	}
	public void setCreationDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.creationdate = value;
	}
	public boolean getCreationTimeIsNotNull()
	{
		return this.creationtime != null;
	}
	public ims.framework.utils.Time getCreationTime()
	{
		return this.creationtime;
	}
	public void setCreationTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.creationtime = value;
	}
	public boolean getAssessDataItemsIsNotNull()
	{
		return this.assessdataitems != null;
	}
	public ims.dtomove.vo.SiteAssessItemVoCollection getAssessDataItems()
	{
		return this.assessdataitems;
	}
	public void setAssessDataItems(ims.dtomove.vo.SiteAssessItemVoCollection value)
	{
		this.isValidated = false;
		this.assessdataitems = value;
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
		if(this.assessname != null)
			if(this.assessname.length() > 50)
				listOfErrors.add("The length of the field [assessname] in the value object [ims.dtomove.vo.SiteAssessVo] is too big. It should be less or equal to 50");
		if(this.assessspecialty != null)
			if(this.assessspecialty.length() > 70)
				listOfErrors.add("The length of the field [assessspecialty] in the value object [ims.dtomove.vo.SiteAssessVo] is too big. It should be less or equal to 70");
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
	
		SiteAssessVo clone = new SiteAssessVo(this.id, this.version);
		
		clone.pkey = this.pkey;
		clone.patient = this.patient;
		clone.episode = this.episode;
		clone.assessname = this.assessname;
		clone.assessspecialty = this.assessspecialty;
		if(this.creationdate == null)
			clone.creationdate = null;
		else
			clone.creationdate = (ims.framework.utils.Date)this.creationdate.clone();
		if(this.creationtime == null)
			clone.creationtime = null;
		else
			clone.creationtime = (ims.framework.utils.Time)this.creationtime.clone();
		if(this.assessdataitems == null)
			clone.assessdataitems = null;
		else
			clone.assessdataitems = (ims.dtomove.vo.SiteAssessItemVoCollection)this.assessdataitems.clone();
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
		if (!(SiteAssessVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SiteAssessVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SiteAssessVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SiteAssessVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.pkey != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.episode != null)
			count++;
		if(this.assessname != null)
			count++;
		if(this.assessspecialty != null)
			count++;
		if(this.creationdate != null)
			count++;
		if(this.creationtime != null)
			count++;
		if(this.assessdataitems != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected Integer pkey;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episode;
	protected String assessname;
	protected String assessspecialty;
	protected ims.framework.utils.Date creationdate;
	protected ims.framework.utils.Time creationtime;
	protected ims.dtomove.vo.SiteAssessItemVoCollection assessdataitems;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
