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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.SessionTheatreProceduresRemanining business object (ID: 1090100009).
 */
public class SessionTheatreProceduresRemainingVo extends ims.scheduling.vo.SessionTheatreProceduresRemaniningRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SessionTheatreProceduresRemainingVo()
	{
	}
	public SessionTheatreProceduresRemainingVo(Integer id, int version)
	{
		super(id, version);
	}
	public SessionTheatreProceduresRemainingVo(ims.scheduling.vo.beans.SessionTheatreProceduresRemainingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.remainingtimeinmins = bean.getRemainingTimeInMins();
		this.proceduredetails = ims.scheduling.vo.TheatreProcedureLiteVoCollection.buildFromBeanCollection(bean.getProcedureDetails());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.SessionTheatreProceduresRemainingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.remainingtimeinmins = bean.getRemainingTimeInMins();
		this.proceduredetails = ims.scheduling.vo.TheatreProcedureLiteVoCollection.buildFromBeanCollection(bean.getProcedureDetails());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.SessionTheatreProceduresRemainingVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.SessionTheatreProceduresRemainingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.SessionTheatreProceduresRemainingVoBean();
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
		if(fieldName.equals("REMAININGTIMEINMINS"))
			return getRemainingTimeInMins();
		if(fieldName.equals("PROCEDUREDETAILS"))
			return getProcedureDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getRemainingTimeInMinsIsNotNull()
	{
		return this.remainingtimeinmins != null;
	}
	public Integer getRemainingTimeInMins()
	{
		return this.remainingtimeinmins;
	}
	public void setRemainingTimeInMins(Integer value)
	{
		this.isValidated = false;
		this.remainingtimeinmins = value;
	}
	public boolean getProcedureDetailsIsNotNull()
	{
		return this.proceduredetails != null;
	}
	public ims.scheduling.vo.TheatreProcedureLiteVoCollection getProcedureDetails()
	{
		return this.proceduredetails;
	}
	public void setProcedureDetails(ims.scheduling.vo.TheatreProcedureLiteVoCollection value)
	{
		this.isValidated = false;
		this.proceduredetails = value;
	}
	/**
	* formatTimeRemaining
	*/
		//WDEV-7524
		public String formatTimeRemaining()
		{
			String formattedTime = "";
			if(remainingtimeinmins != null)
			{
				int totalmins = remainingtimeinmins.intValue();
				int hrs = totalmins/60;
				int mins = totalmins%60;
				
				if(hrs > 9)
					formattedTime += String.valueOf(hrs) + "hrs ";
				else if(hrs >= 1)
					formattedTime += "0" + String.valueOf(hrs) + "hrs ";
				else
					formattedTime += "00hrs ";
				
				if(mins > 9)
					formattedTime += String.valueOf(mins) + "mins ";
				else if(mins >= 1)
					formattedTime += "0" + String.valueOf(mins) + "mins";
				else
					formattedTime += "00mins ";
			}
			
			return formattedTime;
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
		if(this.proceduredetails != null)
		{
			if(!this.proceduredetails.isValidated())
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
		if(this.remainingtimeinmins == null)
			listOfErrors.add("RemainingTimeInMins is mandatory");
		if(this.proceduredetails == null || this.proceduredetails.size() == 0)
			listOfErrors.add("Theatre Procedures are mandatory");
		if(this.proceduredetails != null)
		{
			String[] listOfOtherErrors = this.proceduredetails.validate();
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
	
		SessionTheatreProceduresRemainingVo clone = new SessionTheatreProceduresRemainingVo(this.id, this.version);
		
		clone.remainingtimeinmins = this.remainingtimeinmins;
		if(this.proceduredetails == null)
			clone.proceduredetails = null;
		else
			clone.proceduredetails = (ims.scheduling.vo.TheatreProcedureLiteVoCollection)this.proceduredetails.clone();
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
		if (!(SessionTheatreProceduresRemainingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SessionTheatreProceduresRemainingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SessionTheatreProceduresRemainingVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SessionTheatreProceduresRemainingVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.remainingtimeinmins != null)
			count++;
		if(this.proceduredetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected Integer remainingtimeinmins;
	protected ims.scheduling.vo.TheatreProcedureLiteVoCollection proceduredetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
