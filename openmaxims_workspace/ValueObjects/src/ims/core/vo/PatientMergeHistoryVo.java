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
 * Linked to core.patient.PatientMergeHistory business object (ID: 1001100008).
 */
public class PatientMergeHistoryVo extends ims.core.patient.vo.PatientMergeHistoryRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientMergeHistoryVo()
	{
	}
	public PatientMergeHistoryVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientMergeHistoryVo(ims.core.vo.beans.PatientMergeHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.sourcepatid = bean.getSourcePatId();
		this.destinationpatid = bean.getDestinationPatId();
		this.requestedby = bean.getRequestedBy() == null ? null : bean.getRequestedBy().buildVo();
		this.creationdatetime = bean.getCreationDateTime() == null ? null : bean.getCreationDateTime().buildDateTime();
		this.comment = bean.getComment();
		this.patientids = ims.core.vo.PatientIdCollection.buildFromBeanCollection(bean.getPatientIds());
		this.databasename = bean.getDatabaseName();
		this.items = ims.core.vo.MergedTablesVoCollection.buildFromBeanCollection(bean.getItems());
		this.hostname = bean.getHostname();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientMergeHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.sourcepatid = bean.getSourcePatId();
		this.destinationpatid = bean.getDestinationPatId();
		this.requestedby = bean.getRequestedBy() == null ? null : bean.getRequestedBy().buildVo(map);
		this.creationdatetime = bean.getCreationDateTime() == null ? null : bean.getCreationDateTime().buildDateTime();
		this.comment = bean.getComment();
		this.patientids = ims.core.vo.PatientIdCollection.buildFromBeanCollection(bean.getPatientIds());
		this.databasename = bean.getDatabaseName();
		this.items = ims.core.vo.MergedTablesVoCollection.buildFromBeanCollection(bean.getItems());
		this.hostname = bean.getHostname();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientMergeHistoryVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientMergeHistoryVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientMergeHistoryVoBean();
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
		if(fieldName.equals("SOURCEPATID"))
			return getSourcePatId();
		if(fieldName.equals("DESTINATIONPATID"))
			return getDestinationPatId();
		if(fieldName.equals("REQUESTEDBY"))
			return getRequestedBy();
		if(fieldName.equals("CREATIONDATETIME"))
			return getCreationDateTime();
		if(fieldName.equals("COMMENT"))
			return getComment();
		if(fieldName.equals("PATIENTIDS"))
			return getPatientIds();
		if(fieldName.equals("DATABASENAME"))
			return getDatabaseName();
		if(fieldName.equals("ITEMS"))
			return getItems();
		if(fieldName.equals("HOSTNAME"))
			return getHostname();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSourcePatIdIsNotNull()
	{
		return this.sourcepatid != null;
	}
	public Integer getSourcePatId()
	{
		return this.sourcepatid;
	}
	public void setSourcePatId(Integer value)
	{
		this.isValidated = false;
		this.sourcepatid = value;
	}
	public boolean getDestinationPatIdIsNotNull()
	{
		return this.destinationpatid != null;
	}
	public Integer getDestinationPatId()
	{
		return this.destinationpatid;
	}
	public void setDestinationPatId(Integer value)
	{
		this.isValidated = false;
		this.destinationpatid = value;
	}
	public boolean getRequestedByIsNotNull()
	{
		return this.requestedby != null;
	}
	public ims.core.vo.MemberOfStaffVo getRequestedBy()
	{
		return this.requestedby;
	}
	public void setRequestedBy(ims.core.vo.MemberOfStaffVo value)
	{
		this.isValidated = false;
		this.requestedby = value;
	}
	public boolean getCreationDateTimeIsNotNull()
	{
		return this.creationdatetime != null;
	}
	public ims.framework.utils.DateTime getCreationDateTime()
	{
		return this.creationdatetime;
	}
	public void setCreationDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.creationdatetime = value;
	}
	public boolean getCommentIsNotNull()
	{
		return this.comment != null;
	}
	public String getComment()
	{
		return this.comment;
	}
	public static int getCommentMaxLength()
	{
		return 255;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
	}
	public boolean getPatientIdsIsNotNull()
	{
		return this.patientids != null;
	}
	public ims.core.vo.PatientIdCollection getPatientIds()
	{
		return this.patientids;
	}
	public void setPatientIds(ims.core.vo.PatientIdCollection value)
	{
		this.isValidated = false;
		this.patientids = value;
	}
	public boolean getDatabaseNameIsNotNull()
	{
		return this.databasename != null;
	}
	public String getDatabaseName()
	{
		return this.databasename;
	}
	public static int getDatabaseNameMaxLength()
	{
		return 50;
	}
	public void setDatabaseName(String value)
	{
		this.isValidated = false;
		this.databasename = value;
	}
	public boolean getItemsIsNotNull()
	{
		return this.items != null;
	}
	public ims.core.vo.MergedTablesVoCollection getItems()
	{
		return this.items;
	}
	public void setItems(ims.core.vo.MergedTablesVoCollection value)
	{
		this.isValidated = false;
		this.items = value;
	}
	public boolean getHostnameIsNotNull()
	{
		return this.hostname != null;
	}
	public String getHostname()
	{
		return this.hostname;
	}
	public static int getHostnameMaxLength()
	{
		return 100;
	}
	public void setHostname(String value)
	{
		this.isValidated = false;
		this.hostname = value;
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
		if(this.requestedby != null)
		{
			if(!this.requestedby.isValidated())
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
		if(this.requestedby != null)
		{
			String[] listOfOtherErrors = this.requestedby.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.comment != null)
			if(this.comment.length() > 255)
				listOfErrors.add("The length of the field [comment] in the value object [ims.core.vo.PatientMergeHistoryVo] is too big. It should be less or equal to 255");
		if(this.databasename != null)
			if(this.databasename.length() > 50)
				listOfErrors.add("The length of the field [databasename] in the value object [ims.core.vo.PatientMergeHistoryVo] is too big. It should be less or equal to 50");
		if(this.hostname != null)
			if(this.hostname.length() > 100)
				listOfErrors.add("The length of the field [hostname] in the value object [ims.core.vo.PatientMergeHistoryVo] is too big. It should be less or equal to 100");
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
	
		PatientMergeHistoryVo clone = new PatientMergeHistoryVo(this.id, this.version);
		
		clone.sourcepatid = this.sourcepatid;
		clone.destinationpatid = this.destinationpatid;
		if(this.requestedby == null)
			clone.requestedby = null;
		else
			clone.requestedby = (ims.core.vo.MemberOfStaffVo)this.requestedby.clone();
		if(this.creationdatetime == null)
			clone.creationdatetime = null;
		else
			clone.creationdatetime = (ims.framework.utils.DateTime)this.creationdatetime.clone();
		clone.comment = this.comment;
		if(this.patientids == null)
			clone.patientids = null;
		else
			clone.patientids = (ims.core.vo.PatientIdCollection)this.patientids.clone();
		clone.databasename = this.databasename;
		if(this.items == null)
			clone.items = null;
		else
			clone.items = (ims.core.vo.MergedTablesVoCollection)this.items.clone();
		clone.hostname = this.hostname;
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
		if (!(PatientMergeHistoryVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientMergeHistoryVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientMergeHistoryVo compareObj = (PatientMergeHistoryVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getCreationDateTime() == null && compareObj.getCreationDateTime() != null)
				return -1;
			if(this.getCreationDateTime() != null && compareObj.getCreationDateTime() == null)
				return 1;
			if(this.getCreationDateTime() != null && compareObj.getCreationDateTime() != null)
				retVal = this.getCreationDateTime().compareTo(compareObj.getCreationDateTime());
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
		if(this.sourcepatid != null)
			count++;
		if(this.destinationpatid != null)
			count++;
		if(this.requestedby != null)
			count++;
		if(this.creationdatetime != null)
			count++;
		if(this.comment != null)
			count++;
		if(this.patientids != null)
			count++;
		if(this.databasename != null)
			count++;
		if(this.items != null)
			count++;
		if(this.hostname != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected Integer sourcepatid;
	protected Integer destinationpatid;
	protected ims.core.vo.MemberOfStaffVo requestedby;
	protected ims.framework.utils.DateTime creationdatetime;
	protected String comment;
	protected ims.core.vo.PatientIdCollection patientids;
	protected String databasename;
	protected ims.core.vo.MergedTablesVoCollection items;
	protected String hostname;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
