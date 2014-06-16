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
 * Linked to Hl7ADTOut.PatientDocumentMessageQueue business object (ID: 1103100001).
 */
public class PatientDocumentMessageQueueVo extends ims.hl7adtout.vo.PatientDocumentMessageQueueRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientDocumentMessageQueueVo()
	{
	}
	public PatientDocumentMessageQueueVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientDocumentMessageQueueVo(ims.core.vo.beans.PatientDocumentMessageQueueVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.wasprocessed = bean.getWasProcessed();
		this.wasdiscarded = bean.getWasDiscarded();
		this.msgtext = bean.getMsgText();
		this.acktext = bean.getAckText();
		this.failuremsg = bean.getFailureMsg();
		this.messagestatus = bean.getMessageStatus() == null ? null : ims.ocrr.vo.lookups.OrderMessageStatus.buildLookup(bean.getMessageStatus());
		this.msgtype = bean.getMsgType() == null ? null : ims.core.vo.lookups.MsgEventType.buildLookup(bean.getMsgType());
		this.queuetype = bean.getQueueType() == null ? null : ims.core.vo.lookups.QueueType.buildLookup(bean.getQueueType());
		this.providersystem = bean.getProviderSystem() == null ? null : new ims.core.admin.vo.ProviderSystemRefVo(new Integer(bean.getProviderSystem().getId()), bean.getProviderSystem().getVersion());
		this.patientdocument = bean.getPatientDocument() == null ? null : new ims.core.documents.vo.PatientDocumentRefVo(new Integer(bean.getPatientDocument().getId()), bean.getPatientDocument().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientDocumentMessageQueueVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.wasprocessed = bean.getWasProcessed();
		this.wasdiscarded = bean.getWasDiscarded();
		this.msgtext = bean.getMsgText();
		this.acktext = bean.getAckText();
		this.failuremsg = bean.getFailureMsg();
		this.messagestatus = bean.getMessageStatus() == null ? null : ims.ocrr.vo.lookups.OrderMessageStatus.buildLookup(bean.getMessageStatus());
		this.msgtype = bean.getMsgType() == null ? null : ims.core.vo.lookups.MsgEventType.buildLookup(bean.getMsgType());
		this.queuetype = bean.getQueueType() == null ? null : ims.core.vo.lookups.QueueType.buildLookup(bean.getQueueType());
		this.providersystem = bean.getProviderSystem() == null ? null : new ims.core.admin.vo.ProviderSystemRefVo(new Integer(bean.getProviderSystem().getId()), bean.getProviderSystem().getVersion());
		this.patientdocument = bean.getPatientDocument() == null ? null : new ims.core.documents.vo.PatientDocumentRefVo(new Integer(bean.getPatientDocument().getId()), bean.getPatientDocument().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientDocumentMessageQueueVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientDocumentMessageQueueVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientDocumentMessageQueueVoBean();
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
		if(fieldName.equals("WASPROCESSED"))
			return getWasProcessed();
		if(fieldName.equals("WASDISCARDED"))
			return getWasDiscarded();
		if(fieldName.equals("MSGTEXT"))
			return getMsgText();
		if(fieldName.equals("ACKTEXT"))
			return getAckText();
		if(fieldName.equals("FAILUREMSG"))
			return getFailureMsg();
		if(fieldName.equals("MESSAGESTATUS"))
			return getMessageStatus();
		if(fieldName.equals("MSGTYPE"))
			return getMsgType();
		if(fieldName.equals("QUEUETYPE"))
			return getQueueType();
		if(fieldName.equals("PROVIDERSYSTEM"))
			return getProviderSystem();
		if(fieldName.equals("PATIENTDOCUMENT"))
			return getPatientDocument();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getWasProcessedIsNotNull()
	{
		return this.wasprocessed != null;
	}
	public Boolean getWasProcessed()
	{
		return this.wasprocessed;
	}
	public void setWasProcessed(Boolean value)
	{
		this.isValidated = false;
		this.wasprocessed = value;
	}
	public boolean getWasDiscardedIsNotNull()
	{
		return this.wasdiscarded != null;
	}
	public Boolean getWasDiscarded()
	{
		return this.wasdiscarded;
	}
	public void setWasDiscarded(Boolean value)
	{
		this.isValidated = false;
		this.wasdiscarded = value;
	}
	public boolean getMsgTextIsNotNull()
	{
		return this.msgtext != null;
	}
	public String getMsgText()
	{
		return this.msgtext;
	}
	public static int getMsgTextMaxLength()
	{
		return 4000;
	}
	public void setMsgText(String value)
	{
		this.isValidated = false;
		this.msgtext = value;
	}
	public boolean getAckTextIsNotNull()
	{
		return this.acktext != null;
	}
	public String getAckText()
	{
		return this.acktext;
	}
	public static int getAckTextMaxLength()
	{
		return 1000;
	}
	public void setAckText(String value)
	{
		this.isValidated = false;
		this.acktext = value;
	}
	public boolean getFailureMsgIsNotNull()
	{
		return this.failuremsg != null;
	}
	public String getFailureMsg()
	{
		return this.failuremsg;
	}
	public static int getFailureMsgMaxLength()
	{
		return 1000;
	}
	public void setFailureMsg(String value)
	{
		this.isValidated = false;
		this.failuremsg = value;
	}
	public boolean getMessageStatusIsNotNull()
	{
		return this.messagestatus != null;
	}
	public ims.ocrr.vo.lookups.OrderMessageStatus getMessageStatus()
	{
		return this.messagestatus;
	}
	public void setMessageStatus(ims.ocrr.vo.lookups.OrderMessageStatus value)
	{
		this.isValidated = false;
		this.messagestatus = value;
	}
	public boolean getMsgTypeIsNotNull()
	{
		return this.msgtype != null;
	}
	public ims.core.vo.lookups.MsgEventType getMsgType()
	{
		return this.msgtype;
	}
	public void setMsgType(ims.core.vo.lookups.MsgEventType value)
	{
		this.isValidated = false;
		this.msgtype = value;
	}
	public boolean getQueueTypeIsNotNull()
	{
		return this.queuetype != null;
	}
	public ims.core.vo.lookups.QueueType getQueueType()
	{
		return this.queuetype;
	}
	public void setQueueType(ims.core.vo.lookups.QueueType value)
	{
		this.isValidated = false;
		this.queuetype = value;
	}
	public boolean getProviderSystemIsNotNull()
	{
		return this.providersystem != null;
	}
	public ims.core.admin.vo.ProviderSystemRefVo getProviderSystem()
	{
		return this.providersystem;
	}
	public void setProviderSystem(ims.core.admin.vo.ProviderSystemRefVo value)
	{
		this.isValidated = false;
		this.providersystem = value;
	}
	public boolean getPatientDocumentIsNotNull()
	{
		return this.patientdocument != null;
	}
	public ims.core.documents.vo.PatientDocumentRefVo getPatientDocument()
	{
		return this.patientdocument;
	}
	public void setPatientDocument(ims.core.documents.vo.PatientDocumentRefVo value)
	{
		this.isValidated = false;
		this.patientdocument = value;
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
		if(this.acktext != null)
			if(this.acktext.length() > 1000)
				listOfErrors.add("The length of the field [acktext] in the value object [ims.core.vo.PatientDocumentMessageQueueVo] is too big. It should be less or equal to 1000");
		if(this.failuremsg != null)
			if(this.failuremsg.length() > 1000)
				listOfErrors.add("The length of the field [failuremsg] in the value object [ims.core.vo.PatientDocumentMessageQueueVo] is too big. It should be less or equal to 1000");
		if(this.msgtype == null)
			listOfErrors.add("msgType is mandatory");
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
	
		PatientDocumentMessageQueueVo clone = new PatientDocumentMessageQueueVo(this.id, this.version);
		
		clone.wasprocessed = this.wasprocessed;
		clone.wasdiscarded = this.wasdiscarded;
		clone.msgtext = this.msgtext;
		clone.acktext = this.acktext;
		clone.failuremsg = this.failuremsg;
		if(this.messagestatus == null)
			clone.messagestatus = null;
		else
			clone.messagestatus = (ims.ocrr.vo.lookups.OrderMessageStatus)this.messagestatus.clone();
		if(this.msgtype == null)
			clone.msgtype = null;
		else
			clone.msgtype = (ims.core.vo.lookups.MsgEventType)this.msgtype.clone();
		if(this.queuetype == null)
			clone.queuetype = null;
		else
			clone.queuetype = (ims.core.vo.lookups.QueueType)this.queuetype.clone();
		clone.providersystem = this.providersystem;
		clone.patientdocument = this.patientdocument;
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
		if (!(PatientDocumentMessageQueueVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientDocumentMessageQueueVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientDocumentMessageQueueVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientDocumentMessageQueueVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.wasprocessed != null)
			count++;
		if(this.wasdiscarded != null)
			count++;
		if(this.msgtext != null)
			count++;
		if(this.acktext != null)
			count++;
		if(this.failuremsg != null)
			count++;
		if(this.messagestatus != null)
			count++;
		if(this.msgtype != null)
			count++;
		if(this.queuetype != null)
			count++;
		if(this.providersystem != null)
			count++;
		if(this.patientdocument != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected Boolean wasprocessed;
	protected Boolean wasdiscarded;
	protected String msgtext;
	protected String acktext;
	protected String failuremsg;
	protected ims.ocrr.vo.lookups.OrderMessageStatus messagestatus;
	protected ims.core.vo.lookups.MsgEventType msgtype;
	protected ims.core.vo.lookups.QueueType queuetype;
	protected ims.core.admin.vo.ProviderSystemRefVo providersystem;
	protected ims.core.documents.vo.PatientDocumentRefVo patientdocument;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
