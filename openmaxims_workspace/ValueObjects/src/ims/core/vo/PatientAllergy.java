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
 * Linked to core.clinical.PatientAllergy business object (ID: 1003100008).
 */
public class PatientAllergy extends ims.core.clinical.vo.PatientAllergyRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IClinicalCodingValue
{
	private static final long serialVersionUID = 1L;

	public PatientAllergy()
	{
	}
	public PatientAllergy(Integer id, int version)
	{
		super(id, version);
	}
	public PatientAllergy(ims.core.vo.beans.PatientAllergyBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.allergen = bean.getAllergen() == null ? null : bean.getAllergen().buildVo();
		this.sourceofinformation = bean.getSourceofInformation() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getSourceofInformation());
		this.whenidentified = bean.getWhenIdentified() == null ? null : bean.getWhenIdentified().buildPartialDate();
		this.comments = bean.getComments();
		this.iscurrentlyactiveallergy = bean.getIsCurrentlyActiveAllergy();
		this.reactions = ims.core.vo.PatientAllergyReactionVoCollection.buildFromBeanCollection(bean.getReactions());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.allergendescription = bean.getAllergenDescription();
		this.allergentype = bean.getAllergenType() == null ? null : ims.core.vo.lookups.AllergenType.buildLookup(bean.getAllergenType());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.inactivationauthoringinfo = bean.getInactivationAuthoringInfo() == null ? null : bean.getInactivationAuthoringInfo().buildVo();
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientAllergyBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.allergen = bean.getAllergen() == null ? null : bean.getAllergen().buildVo(map);
		this.sourceofinformation = bean.getSourceofInformation() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getSourceofInformation());
		this.whenidentified = bean.getWhenIdentified() == null ? null : bean.getWhenIdentified().buildPartialDate();
		this.comments = bean.getComments();
		this.iscurrentlyactiveallergy = bean.getIsCurrentlyActiveAllergy();
		this.reactions = ims.core.vo.PatientAllergyReactionVoCollection.buildFromBeanCollection(bean.getReactions());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.allergendescription = bean.getAllergenDescription();
		this.allergentype = bean.getAllergenType() == null ? null : ims.core.vo.lookups.AllergenType.buildLookup(bean.getAllergenType());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.inactivationauthoringinfo = bean.getInactivationAuthoringInfo() == null ? null : bean.getInactivationAuthoringInfo().buildVo(map);
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientAllergyBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientAllergyBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientAllergyBean();
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
		if(fieldName.equals("ALLERGEN"))
			return getAllergen();
		if(fieldName.equals("SOURCEOFINFORMATION"))
			return getSourceofInformation();
		if(fieldName.equals("WHENIDENTIFIED"))
			return getWhenIdentified();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("ISCURRENTLYACTIVEALLERGY"))
			return getIsCurrentlyActiveAllergy();
		if(fieldName.equals("REACTIONS"))
			return getReactions();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("ALLERGENDESCRIPTION"))
			return getAllergenDescription();
		if(fieldName.equals("ALLERGENTYPE"))
			return getAllergenType();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("INACTIVATIONAUTHORINGINFO"))
			return getInactivationAuthoringInfo();
		if(fieldName.equals("RECORDINGINFORMATION"))
			return getRecordingInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAllergenIsNotNull()
	{
		return this.allergen != null;
	}
	public ims.core.vo.AllergenVo getAllergen()
	{
		return this.allergen;
	}
	public void setAllergen(ims.core.vo.AllergenVo value)
	{
		this.isValidated = false;
		this.allergen = value;
	}
	public boolean getSourceofInformationIsNotNull()
	{
		return this.sourceofinformation != null;
	}
	public ims.core.vo.lookups.SourceofInformation getSourceofInformation()
	{
		return this.sourceofinformation;
	}
	public void setSourceofInformation(ims.core.vo.lookups.SourceofInformation value)
	{
		this.isValidated = false;
		this.sourceofinformation = value;
	}
	public boolean getWhenIdentifiedIsNotNull()
	{
		return this.whenidentified != null;
	}
	public ims.framework.utils.PartialDate getWhenIdentified()
	{
		return this.whenidentified;
	}
	public void setWhenIdentified(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.whenidentified = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 255;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getIsCurrentlyActiveAllergyIsNotNull()
	{
		return this.iscurrentlyactiveallergy != null;
	}
	public Boolean getIsCurrentlyActiveAllergy()
	{
		return this.iscurrentlyactiveallergy;
	}
	public void setIsCurrentlyActiveAllergy(Boolean value)
	{
		this.isValidated = false;
		this.iscurrentlyactiveallergy = value;
	}
	public boolean getReactionsIsNotNull()
	{
		return this.reactions != null;
	}
	public ims.core.vo.PatientAllergyReactionVoCollection getReactions()
	{
		return this.reactions;
	}
	public void setReactions(ims.core.vo.PatientAllergyReactionVoCollection value)
	{
		this.isValidated = false;
		this.reactions = value;
	}
	public boolean getSysInfoIsNotNull()
	{
		return this.sysinfo != null;
	}
	public ims.vo.SystemInformation getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinfo = value;
	}
	public boolean getAllergenDescriptionIsNotNull()
	{
		return this.allergendescription != null;
	}
	public String getAllergenDescription()
	{
		return this.allergendescription;
	}
	public static int getAllergenDescriptionMaxLength()
	{
		return 255;
	}
	public void setAllergenDescription(String value)
	{
		this.isValidated = false;
		this.allergendescription = value;
	}
	public boolean getAllergenTypeIsNotNull()
	{
		return this.allergentype != null;
	}
	public ims.core.vo.lookups.AllergenType getAllergenType()
	{
		return this.allergentype;
	}
	public void setAllergenType(ims.core.vo.lookups.AllergenType value)
	{
		this.isValidated = false;
		this.allergentype = value;
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
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
	public boolean getInactivationAuthoringInfoIsNotNull()
	{
		return this.inactivationauthoringinfo != null;
	}
	public ims.core.vo.AuthoringInformationVo getInactivationAuthoringInfo()
	{
		return this.inactivationauthoringinfo;
	}
	public void setInactivationAuthoringInfo(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.inactivationauthoringinfo = value;
	}
	public boolean getRecordingInformationIsNotNull()
	{
		return this.recordinginformation != null;
	}
	public ims.core.vo.RecordingUserInformationVo getRecordingInformation()
	{
		return this.recordinginformation;
	}
	public void setRecordingInformation(ims.core.vo.RecordingUserInformationVo value)
	{
		this.isValidated = false;
		this.recordinginformation = value;
	}
	/**
	* IClinicalCoding methods
	*/
	public ims.vo.ValueObject getIClinicalCodingValue() 
	{
		return this.allergen;
	}
	public void setIClinicalCodingValue(ims.vo.ValueObject vo) 
	{
		this.allergen = (ims.core.vo.AllergenVo)vo;		
	}
	public String getIClinicalCodingValueDescription() 
	{
		return this.allergendescription;
	}
	public void setIClinicalCodingValueDescription(String value) 
	{
		this.allergendescription = value;
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
		if(this.reactions != null)
		{
			if(!this.reactions.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.inactivationauthoringinfo != null)
		{
			if(!this.inactivationauthoringinfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.recordinginformation != null)
		{
			if(!this.recordinginformation.isValidated())
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
		if(this.sourceofinformation == null)
			listOfErrors.add("Source of Information is a mandatory field");
		if(this.comments != null)
			if(this.comments.length() > 255)
				listOfErrors.add("The length of the field [comments] in the value object [ims.core.vo.PatientAllergy] is too big. It should be less or equal to 255");
		if(this.reactions != null)
		{
			String[] listOfOtherErrors = this.reactions.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.allergendescription == null || this.allergendescription.length() == 0)
			listOfErrors.add("AllergenDescription is mandatory");
		else if(this.allergendescription.length() > 255)
			listOfErrors.add("The length of the field [allergendescription] in the value object [ims.core.vo.PatientAllergy] is too big. It should be less or equal to 255");
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.inactivationauthoringinfo != null)
		{
			String[] listOfOtherErrors = this.inactivationauthoringinfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.recordinginformation != null)
		{
			String[] listOfOtherErrors = this.recordinginformation.validate();
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
	
		PatientAllergy clone = new PatientAllergy(this.id, this.version);
		
		if(this.allergen == null)
			clone.allergen = null;
		else
			clone.allergen = (ims.core.vo.AllergenVo)this.allergen.clone();
		if(this.sourceofinformation == null)
			clone.sourceofinformation = null;
		else
			clone.sourceofinformation = (ims.core.vo.lookups.SourceofInformation)this.sourceofinformation.clone();
		if(this.whenidentified == null)
			clone.whenidentified = null;
		else
			clone.whenidentified = (ims.framework.utils.PartialDate)this.whenidentified.clone();
		clone.comments = this.comments;
		clone.iscurrentlyactiveallergy = this.iscurrentlyactiveallergy;
		if(this.reactions == null)
			clone.reactions = null;
		else
			clone.reactions = (ims.core.vo.PatientAllergyReactionVoCollection)this.reactions.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		clone.allergendescription = this.allergendescription;
		if(this.allergentype == null)
			clone.allergentype = null;
		else
			clone.allergentype = (ims.core.vo.lookups.AllergenType)this.allergentype.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		clone.patient = this.patient;
		if(this.inactivationauthoringinfo == null)
			clone.inactivationauthoringinfo = null;
		else
			clone.inactivationauthoringinfo = (ims.core.vo.AuthoringInformationVo)this.inactivationauthoringinfo.clone();
		if(this.recordinginformation == null)
			clone.recordinginformation = null;
		else
			clone.recordinginformation = (ims.core.vo.RecordingUserInformationVo)this.recordinginformation.clone();
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
		if (!(PatientAllergy.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientAllergy object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientAllergy compareObj = (PatientAllergy)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSysInfo() == null && compareObj.getSysInfo() != null)
				return -1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() == null)
				return 1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() != null)
				retVal = this.getSysInfo().compareTo(compareObj.getSysInfo());
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
		if(this.allergen != null)
			count++;
		if(this.sourceofinformation != null)
			count++;
		if(this.whenidentified != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.iscurrentlyactiveallergy != null)
			count++;
		if(this.reactions != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.allergendescription != null)
			count++;
		if(this.allergentype != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.inactivationauthoringinfo != null)
			count++;
		if(this.recordinginformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected ims.core.vo.AllergenVo allergen;
	protected ims.core.vo.lookups.SourceofInformation sourceofinformation;
	protected ims.framework.utils.PartialDate whenidentified;
	protected String comments;
	protected Boolean iscurrentlyactiveallergy;
	protected ims.core.vo.PatientAllergyReactionVoCollection reactions;
	protected ims.vo.SystemInformation sysinfo;
	protected String allergendescription;
	protected ims.core.vo.lookups.AllergenType allergentype;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.vo.AuthoringInformationVo inactivationauthoringinfo;
	protected ims.core.vo.RecordingUserInformationVo recordinginformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
