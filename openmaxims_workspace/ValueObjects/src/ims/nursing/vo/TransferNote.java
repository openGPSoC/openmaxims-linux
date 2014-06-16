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
 * Linked to nursing.TransferNote business object (ID: 1011100003).
 */
public class TransferNote extends ims.nursing.vo.TransferNoteRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TransferNote()
	{
	}
	public TransferNote(Integer id, int version)
	{
		super(id, version);
	}
	public TransferNote(ims.nursing.vo.beans.TransferNoteBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.transfernote = bean.getTransferNote();
		this.transferdate = bean.getTransferDate() == null ? null : bean.getTransferDate().buildDateTime();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.authoringcp = bean.getAuthoringCP() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getAuthoringCP().getId()), bean.getAuthoringCP().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.TransferNoteBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.transfernote = bean.getTransferNote();
		this.transferdate = bean.getTransferDate() == null ? null : bean.getTransferDate().buildDateTime();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.authoringcp = bean.getAuthoringCP() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getAuthoringCP().getId()), bean.getAuthoringCP().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.TransferNoteBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.TransferNoteBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.TransferNoteBean();
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
		if(fieldName.equals("TRANSFERNOTE"))
			return getTransferNote();
		if(fieldName.equals("TRANSFERDATE"))
			return getTransferDate();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("AUTHORINGCP"))
			return getAuthoringCP();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTransferNoteIsNotNull()
	{
		return this.transfernote != null;
	}
	public String getTransferNote()
	{
		return this.transfernote;
	}
	public static int getTransferNoteMaxLength()
	{
		return 1500;
	}
	public void setTransferNote(String value)
	{
		this.isValidated = false;
		this.transfernote = value;
	}
	public boolean getTransferDateIsNotNull()
	{
		return this.transferdate != null;
	}
	public ims.framework.utils.DateTime getTransferDate()
	{
		return this.transferdate;
	}
	public void setTransferDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.transferdate = value;
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.vo.ClinicalContactShortVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.ClinicalContactShortVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
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
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.vo.CareContextShortVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.CareContextShortVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getAuthoringCPIsNotNull()
	{
		return this.authoringcp != null;
	}
	public ims.core.resource.people.vo.HcpRefVo getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.resource.people.vo.HcpRefVo value)
	{
		this.isValidated = false;
		this.authoringcp = value;
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
		if(this.carecontext != null)
		{
			if(!this.carecontext.isValidated())
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
		if(this.transfernote != null)
			if(this.transfernote.length() > 1500)
				listOfErrors.add("The length of the field [transfernote] in the value object [ims.nursing.vo.TransferNote] is too big. It should be less or equal to 1500");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.carecontext != null)
		{
			String[] listOfOtherErrors = this.carecontext.validate();
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
	
		TransferNote clone = new TransferNote(this.id, this.version);
		
		clone.transfernote = this.transfernote;
		if(this.transferdate == null)
			clone.transferdate = null;
		else
			clone.transferdate = (ims.framework.utils.DateTime)this.transferdate.clone();
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextShortVo)this.carecontext.clone();
		clone.authoringcp = this.authoringcp;
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
		if (!(TransferNote.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TransferNote object cannot be compared an Object of type " + obj.getClass().getName());
		}
		TransferNote compareObj = (TransferNote)obj;
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
		if(this.transfernote != null)
			count++;
		if(this.transferdate != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.authoringcp != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected String transfernote;
	protected ims.framework.utils.DateTime transferdate;
	protected ims.core.vo.ClinicalContactShortVo clinicalcontact;
	protected ims.vo.SystemInformation sysinfo;
	protected ims.core.vo.CareContextShortVo carecontext;
	protected ims.core.resource.people.vo.HcpRefVo authoringcp;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
