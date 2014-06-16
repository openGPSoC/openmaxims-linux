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

package ims.nursing.vo;

/**
 * Linked to nursing.care plans.Care Plan business object (ID: 1010100003).
 */
public class CarePlanForCopyCarePlansVo extends ims.nursing.careplans.vo.CarePlanRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CarePlanForCopyCarePlansVo()
	{
	}
	public CarePlanForCopyCarePlansVo(Integer id, int version)
	{
		super(id, version);
	}
	public CarePlanForCopyCarePlansVo(ims.nursing.vo.beans.CarePlanForCopyCarePlansVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.title = bean.getTitle();
		this.objective = bean.getObjective();
		this.interventions = ims.nursing.vo.CarePlanInterventionsCollection.buildFromBeanCollection(bean.getInterventions());
		this.nextevaluationdate = bean.getNextEvaluationDate() == null ? null : bean.getNextEvaluationDate().buildDate();
		this.nextevaluationtime = bean.getNextEvaluationTime() == null ? null : bean.getNextEvaluationTime().buildTime();
		this.template = bean.getTemplate() == null ? null : bean.getTemplate().buildVo();
		this.careplanstatus = ims.nursing.vo.CarePlanStatusCollection.buildFromBeanCollection(bean.getCarePlanStatus());
		this.currentcareplanstatus = bean.getCurrentCarePlanStatus() == null ? null : bean.getCurrentCarePlanStatus().buildVo();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.CarePlanForCopyCarePlansVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.title = bean.getTitle();
		this.objective = bean.getObjective();
		this.interventions = ims.nursing.vo.CarePlanInterventionsCollection.buildFromBeanCollection(bean.getInterventions());
		this.nextevaluationdate = bean.getNextEvaluationDate() == null ? null : bean.getNextEvaluationDate().buildDate();
		this.nextevaluationtime = bean.getNextEvaluationTime() == null ? null : bean.getNextEvaluationTime().buildTime();
		this.template = bean.getTemplate() == null ? null : bean.getTemplate().buildVo(map);
		this.careplanstatus = ims.nursing.vo.CarePlanStatusCollection.buildFromBeanCollection(bean.getCarePlanStatus());
		this.currentcareplanstatus = bean.getCurrentCarePlanStatus() == null ? null : bean.getCurrentCarePlanStatus().buildVo(map);
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.CarePlanForCopyCarePlansVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.CarePlanForCopyCarePlansVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.CarePlanForCopyCarePlansVoBean();
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
		if(fieldName.equals("TITLE"))
			return getTitle();
		if(fieldName.equals("OBJECTIVE"))
			return getObjective();
		if(fieldName.equals("INTERVENTIONS"))
			return getInterventions();
		if(fieldName.equals("NEXTEVALUATIONDATE"))
			return getNextEvaluationDate();
		if(fieldName.equals("NEXTEVALUATIONTIME"))
			return getNextEvaluationTime();
		if(fieldName.equals("TEMPLATE"))
			return getTemplate();
		if(fieldName.equals("CAREPLANSTATUS"))
			return getCarePlanStatus();
		if(fieldName.equals("CURRENTCAREPLANSTATUS"))
			return getCurrentCarePlanStatus();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("RECORDINGINFORMATION"))
			return getRecordingInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTitleIsNotNull()
	{
		return this.title != null;
	}
	public String getTitle()
	{
		return this.title;
	}
	public static int getTitleMaxLength()
	{
		return 255;
	}
	public void setTitle(String value)
	{
		this.isValidated = false;
		this.title = value;
	}
	public boolean getObjectiveIsNotNull()
	{
		return this.objective != null;
	}
	public String getObjective()
	{
		return this.objective;
	}
	public static int getObjectiveMaxLength()
	{
		return 500;
	}
	public void setObjective(String value)
	{
		this.isValidated = false;
		this.objective = value;
	}
	public boolean getInterventionsIsNotNull()
	{
		return this.interventions != null;
	}
	public ims.nursing.vo.CarePlanInterventionsCollection getInterventions()
	{
		return this.interventions;
	}
	public void setInterventions(ims.nursing.vo.CarePlanInterventionsCollection value)
	{
		this.isValidated = false;
		this.interventions = value;
	}
	public boolean getNextEvaluationDateIsNotNull()
	{
		return this.nextevaluationdate != null;
	}
	public ims.framework.utils.Date getNextEvaluationDate()
	{
		return this.nextevaluationdate;
	}
	public void setNextEvaluationDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.nextevaluationdate = value;
	}
	public boolean getNextEvaluationTimeIsNotNull()
	{
		return this.nextevaluationtime != null;
	}
	public ims.framework.utils.Time getNextEvaluationTime()
	{
		return this.nextevaluationtime;
	}
	public void setNextEvaluationTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.nextevaluationtime = value;
	}
	public boolean getTemplateIsNotNull()
	{
		return this.template != null;
	}
	public ims.nursing.vo.CarePlanTemplate getTemplate()
	{
		return this.template;
	}
	public void setTemplate(ims.nursing.vo.CarePlanTemplate value)
	{
		this.isValidated = false;
		this.template = value;
	}
	public boolean getCarePlanStatusIsNotNull()
	{
		return this.careplanstatus != null;
	}
	public ims.nursing.vo.CarePlanStatusCollection getCarePlanStatus()
	{
		return this.careplanstatus;
	}
	public void setCarePlanStatus(ims.nursing.vo.CarePlanStatusCollection value)
	{
		this.isValidated = false;
		this.careplanstatus = value;
	}
	public boolean getCurrentCarePlanStatusIsNotNull()
	{
		return this.currentcareplanstatus != null;
	}
	public ims.nursing.vo.CarePlanStatus getCurrentCarePlanStatus()
	{
		return this.currentcareplanstatus;
	}
	public void setCurrentCarePlanStatus(ims.nursing.vo.CarePlanStatus value)
	{
		this.isValidated = false;
		this.currentcareplanstatus = value;
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.admin.vo.ClinicalContactRefVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.admin.vo.ClinicalContactRefVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
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
		if(this.interventions != null)
		{
			if(!this.interventions.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.template != null)
		{
			if(!this.template.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.careplanstatus != null)
		{
			if(!this.careplanstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentcareplanstatus != null)
		{
			if(!this.currentcareplanstatus.isValidated())
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
		if(this.title != null)
			if(this.title.length() > 255)
				listOfErrors.add("The length of the field [title] in the value object [ims.nursing.vo.CarePlanForCopyCarePlansVo] is too big. It should be less or equal to 255");
		if(this.objective != null)
			if(this.objective.length() > 500)
				listOfErrors.add("The length of the field [objective] in the value object [ims.nursing.vo.CarePlanForCopyCarePlansVo] is too big. It should be less or equal to 500");
		if(this.interventions != null)
		{
			String[] listOfOtherErrors = this.interventions.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.template != null)
		{
			String[] listOfOtherErrors = this.template.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.careplanstatus != null)
		{
			String[] listOfOtherErrors = this.careplanstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.currentcareplanstatus != null)
		{
			String[] listOfOtherErrors = this.currentcareplanstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
	
		CarePlanForCopyCarePlansVo clone = new CarePlanForCopyCarePlansVo(this.id, this.version);
		
		clone.title = this.title;
		clone.objective = this.objective;
		if(this.interventions == null)
			clone.interventions = null;
		else
			clone.interventions = (ims.nursing.vo.CarePlanInterventionsCollection)this.interventions.clone();
		if(this.nextevaluationdate == null)
			clone.nextevaluationdate = null;
		else
			clone.nextevaluationdate = (ims.framework.utils.Date)this.nextevaluationdate.clone();
		if(this.nextevaluationtime == null)
			clone.nextevaluationtime = null;
		else
			clone.nextevaluationtime = (ims.framework.utils.Time)this.nextevaluationtime.clone();
		if(this.template == null)
			clone.template = null;
		else
			clone.template = (ims.nursing.vo.CarePlanTemplate)this.template.clone();
		if(this.careplanstatus == null)
			clone.careplanstatus = null;
		else
			clone.careplanstatus = (ims.nursing.vo.CarePlanStatusCollection)this.careplanstatus.clone();
		if(this.currentcareplanstatus == null)
			clone.currentcareplanstatus = null;
		else
			clone.currentcareplanstatus = (ims.nursing.vo.CarePlanStatus)this.currentcareplanstatus.clone();
		clone.clinicalcontact = this.clinicalcontact;
		clone.carecontext = this.carecontext;
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
		if (!(CarePlanForCopyCarePlansVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CarePlanForCopyCarePlansVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CarePlanForCopyCarePlansVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CarePlanForCopyCarePlansVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.title != null)
			count++;
		if(this.objective != null)
			count++;
		if(this.interventions != null)
			count++;
		if(this.nextevaluationdate != null)
			count++;
		if(this.nextevaluationtime != null)
			count++;
		if(this.template != null)
			count++;
		if(this.careplanstatus != null)
			count++;
		if(this.currentcareplanstatus != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.recordinginformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected String title;
	protected String objective;
	protected ims.nursing.vo.CarePlanInterventionsCollection interventions;
	protected ims.framework.utils.Date nextevaluationdate;
	protected ims.framework.utils.Time nextevaluationtime;
	protected ims.nursing.vo.CarePlanTemplate template;
	protected ims.nursing.vo.CarePlanStatusCollection careplanstatus;
	protected ims.nursing.vo.CarePlanStatus currentcareplanstatus;
	protected ims.core.admin.vo.ClinicalContactRefVo clinicalcontact;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.vo.RecordingUserInformationVo recordinginformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
