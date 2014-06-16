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

package ims.icp.vo;

/**
 * Linked to ICPs.Instantiation.PatientICPPhase business object (ID: 1100100003).
 */
public class PatientICPPhaseViewVo extends ims.icps.instantiation.vo.PatientICPPhaseRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IInstantiationICPStagePhaseAction
{
	private static final long serialVersionUID = 1L;

	public PatientICPPhaseViewVo()
	{
	}
	public PatientICPPhaseViewVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientICPPhaseViewVo(ims.icp.vo.beans.PatientICPPhaseViewVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.phase = bean.getPhase() == null ? null : bean.getPhase().buildVo();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.phaseactions = ims.icp.vo.PatientICPActionViewVoCollection.buildFromBeanCollection(bean.getPhaseActions());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.PatientICPPhaseViewVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.phase = bean.getPhase() == null ? null : bean.getPhase().buildVo(map);
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.phaseactions = ims.icp.vo.PatientICPActionViewVoCollection.buildFromBeanCollection(bean.getPhaseActions());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.PatientICPPhaseViewVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.PatientICPPhaseViewVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.PatientICPPhaseViewVoBean();
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
		if(fieldName.equals("PHASE"))
			return getPhase();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("PHASEACTIONS"))
			return getPhaseActions();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPhaseIsNotNull()
	{
		return this.phase != null;
	}
	public ims.icp.vo.ICPPhaseViewVo getPhase()
	{
		return this.phase;
	}
	public void setPhase(ims.icp.vo.ICPPhaseViewVo value)
	{
		this.isValidated = false;
		this.phase = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.icp.vo.PatientICPPhaseStatusVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.icp.vo.PatientICPPhaseStatusVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getPhaseActionsIsNotNull()
	{
		return this.phaseactions != null;
	}
	public ims.icp.vo.PatientICPActionViewVoCollection getPhaseActions()
	{
		return this.phaseactions;
	}
	public void setPhaseActions(ims.icp.vo.PatientICPActionViewVoCollection value)
	{
		this.isValidated = false;
		this.phaseactions = value;
	}
	/**
	* IInstantiationICPStagePhaseAction methods
	*/
	public String getHelpURL()
	{
		if (this.phase == null)
			return null;
			
		return this.phase.helpurl;
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
		if(this.phase == null)
			listOfErrors.add("Phase is mandatory");
		if(this.currentstatus == null)
			listOfErrors.add("CurrentStatus is mandatory");
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
	
		PatientICPPhaseViewVo clone = new PatientICPPhaseViewVo(this.id, this.version);
		
		if(this.phase == null)
			clone.phase = null;
		else
			clone.phase = (ims.icp.vo.ICPPhaseViewVo)this.phase.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.icp.vo.PatientICPPhaseStatusVo)this.currentstatus.clone();
		if(this.phaseactions == null)
			clone.phaseactions = null;
		else
			clone.phaseactions = (ims.icp.vo.PatientICPActionViewVoCollection)this.phaseactions.clone();
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
		if (!(PatientICPPhaseViewVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientICPPhaseViewVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientICPPhaseViewVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientICPPhaseViewVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.phase != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.phaseactions != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.icp.vo.ICPPhaseViewVo phase;
	protected ims.icp.vo.PatientICPPhaseStatusVo currentstatus;
	protected ims.icp.vo.PatientICPActionViewVoCollection phaseactions;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
