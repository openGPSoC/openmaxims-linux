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
 * Linked to core.admin.Notifications business object (ID: 1004100043).
 */
public class NotificationVo extends ims.core.admin.vo.NotificationsRefVo implements ims.vo.ImsCloneable, Comparable, ims.framework.interfaces.IUINotification, ims.framework.interfaces.INotification
{
	private static final long serialVersionUID = 1L;

	public NotificationVo()
	{
	}
	public NotificationVo(Integer id, int version)
	{
		super(id, version);
	}
	public NotificationVo(ims.core.vo.beans.NotificationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.user = bean.getUser() == null ? null : bean.getUser().buildVo();
		this.datetime = bean.getDateTime() == null ? null : bean.getDateTime().buildDateTime();
		this.message = bean.getMessage();
		this.notificationpriority = bean.getNotificationPriority();
		this.entitytype = bean.getEntityType();
		this.entityid = bean.getEntityId();
		this.seen = bean.getSeen();
		this.seenat = bean.getSeenAt() == null ? null : bean.getSeenAt().buildDateTime();
		this.source = bean.getSource();
		this.usernotified = bean.getUserNotified();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.NotificationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.user = bean.getUser() == null ? null : bean.getUser().buildVo(map);
		this.datetime = bean.getDateTime() == null ? null : bean.getDateTime().buildDateTime();
		this.message = bean.getMessage();
		this.notificationpriority = bean.getNotificationPriority();
		this.entitytype = bean.getEntityType();
		this.entityid = bean.getEntityId();
		this.seen = bean.getSeen();
		this.seenat = bean.getSeenAt() == null ? null : bean.getSeenAt().buildDateTime();
		this.source = bean.getSource();
		this.usernotified = bean.getUserNotified();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.NotificationVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.NotificationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.NotificationVoBean();
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
		if(fieldName.equals("USER"))
			return getUser();
		if(fieldName.equals("DATETIME"))
			return getDateTime();
		if(fieldName.equals("MESSAGE"))
			return getMessage();
		if(fieldName.equals("NOTIFICATIONPRIORITY"))
			return getNotificationPriority();
		if(fieldName.equals("ENTITYTYPE"))
			return getEntityType();
		if(fieldName.equals("ENTITYID"))
			return getEntityId();
		if(fieldName.equals("SEEN"))
			return getSeen();
		if(fieldName.equals("SEENAT"))
			return getSeenAt();
		if(fieldName.equals("SOURCE"))
			return getSource();
		if(fieldName.equals("USERNOTIFIED"))
			return getUserNotified();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getUserIsNotNull()
	{
		return this.user != null;
	}
	public ims.admin.vo.AppUserNotificationVo getUser()
	{
		return this.user;
	}
	public void setUser(ims.admin.vo.AppUserNotificationVo value)
	{
		this.isValidated = false;
		this.user = value;
	}
	public boolean getDateTimeIsNotNull()
	{
		return this.datetime != null;
	}
	public ims.framework.utils.DateTime getDateTime()
	{
		return this.datetime;
	}
	public void setDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.datetime = value;
	}
	public boolean getMessageIsNotNull()
	{
		return this.message != null;
	}
	public String getMessage()
	{
		return this.message;
	}
	public static int getMessageMaxLength()
	{
		return 10000;
	}
	public void setMessage(String value)
	{
		this.isValidated = false;
		this.message = value;
	}
	public boolean getNotificationPriorityIsNotNull()
	{
		return this.notificationpriority != null;
	}
	public Integer getNotificationPriority()
	{
		return this.notificationpriority;
	}
	public void setNotificationPriority(Integer value)
	{
		this.isValidated = false;
		this.notificationpriority = value;
	}
	public boolean getEntityTypeIsNotNull()
	{
		return this.entitytype != null;
	}
	public String getEntityType()
	{
		return this.entitytype;
	}
	public static int getEntityTypeMaxLength()
	{
		return 500;
	}
	public void setEntityType(String value)
	{
		this.isValidated = false;
		this.entitytype = value;
	}
	public boolean getEntityIdIsNotNull()
	{
		return this.entityid != null;
	}
	public Integer getEntityId()
	{
		return this.entityid;
	}
	public void setEntityId(Integer value)
	{
		this.isValidated = false;
		this.entityid = value;
	}
	public boolean getSeenIsNotNull()
	{
		return this.seen != null;
	}
	public Boolean getSeen()
	{
		return this.seen;
	}
	public void setSeen(Boolean value)
	{
		this.isValidated = false;
		this.seen = value;
	}
	public boolean getSeenAtIsNotNull()
	{
		return this.seenat != null;
	}
	public ims.framework.utils.DateTime getSeenAt()
	{
		return this.seenat;
	}
	public void setSeenAt(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.seenat = value;
	}
	public boolean getSourceIsNotNull()
	{
		return this.source != null;
	}
	public String getSource()
	{
		return this.source;
	}
	public static int getSourceMaxLength()
	{
		return 255;
	}
	public void setSource(String value)
	{
		this.isValidated = false;
		this.source = value;
	}
	public boolean getUserNotifiedIsNotNull()
	{
		return this.usernotified != null;
	}
	public Boolean getUserNotified()
	{
		return this.usernotified;
	}
	public void setUserNotified(Boolean value)
	{
		this.isValidated = false;
		this.usernotified = value;
	}
	/**
	* IUINotification
	*/
		public ims.framework.utils.DateTime getIUINotificationSeenDateTime() 
		{
			return seenat;
		}
		public boolean wasIUINotificationSeen() 
		{
			return seen == null ? false : seen;
		}
		public ims.framework.utils.DateTime getINotificationDateTime() 
		{
			return datetime;
		}
		public Integer getINotificationEntityId() 
		{
			return entityid;
		}
		public String getINotificationEntityType() 
		{
			return entitytype;
		}
		public int getINotificationId() 
		{
			return id == null ? 0 : id; 
		}
		public String getINotificationMessage() 
		{
			return message;
		}
		public ims.framework.enumerations.NotificationPriority getINotificationPriority()
		{
			if(notificationpriority == null)
				return ims.framework.enumerations.NotificationPriority.NORMAL;
			return ims.framework.enumerations.NotificationPriority.parse(notificationpriority);
		}
		public String getINotificationSource() 
		{
			return source;
		}
		public int getINotificationUserId() 
		{
			if( user == null || user.getID_AppUser() == null)
				return 0;
			return user.getID_AppUser().intValue();
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
		if(this.user == null)
			listOfErrors.add("User is mandatory");
		if(this.datetime == null)
			listOfErrors.add("DateTime is mandatory");
		if(this.message == null || this.message.length() == 0)
			listOfErrors.add("Message is mandatory");
		if(this.notificationpriority == null)
			listOfErrors.add("Priority is mandatory");
		if(this.entitytype != null)
			if(this.entitytype.length() > 500)
				listOfErrors.add("The length of the field [entitytype] in the value object [ims.core.vo.NotificationVo] is too big. It should be less or equal to 500");
		if(this.seen == null)
			listOfErrors.add("Seen is mandatory");
		if(this.source != null)
			if(this.source.length() > 255)
				listOfErrors.add("The length of the field [source] in the value object [ims.core.vo.NotificationVo] is too big. It should be less or equal to 255");
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
	
		NotificationVo clone = new NotificationVo(this.id, this.version);
		
		if(this.user == null)
			clone.user = null;
		else
			clone.user = (ims.admin.vo.AppUserNotificationVo)this.user.clone();
		if(this.datetime == null)
			clone.datetime = null;
		else
			clone.datetime = (ims.framework.utils.DateTime)this.datetime.clone();
		clone.message = this.message;
		clone.notificationpriority = this.notificationpriority;
		clone.entitytype = this.entitytype;
		clone.entityid = this.entityid;
		clone.seen = this.seen;
		if(this.seenat == null)
			clone.seenat = null;
		else
			clone.seenat = (ims.framework.utils.DateTime)this.seenat.clone();
		clone.source = this.source;
		clone.usernotified = this.usernotified;
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
		if (!(NotificationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NotificationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((NotificationVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((NotificationVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.user != null)
			count++;
		if(this.datetime != null)
			count++;
		if(this.message != null)
			count++;
		if(this.notificationpriority != null)
			count++;
		if(this.entitytype != null)
			count++;
		if(this.entityid != null)
			count++;
		if(this.seen != null)
			count++;
		if(this.seenat != null)
			count++;
		if(this.source != null)
			count++;
		if(this.usernotified != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.admin.vo.AppUserNotificationVo user;
	protected ims.framework.utils.DateTime datetime;
	protected String message;
	protected Integer notificationpriority;
	protected String entitytype;
	protected Integer entityid;
	protected Boolean seen;
	protected ims.framework.utils.DateTime seenat;
	protected String source;
	protected Boolean usernotified;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
