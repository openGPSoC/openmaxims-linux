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

package ims.careuk.vo;

/**
 * Linked to CAREUK.InterpreterDetails business object (ID: 1096100025).
 */
public class InterpreterDetailsVo extends ims.careuk.vo.InterpreterDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InterpreterDetailsVo()
	{
	}
	public InterpreterDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public InterpreterDetailsVo(ims.careuk.vo.beans.InterpreterDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.bookingdate = bean.getBookingDate() == null ? null : bean.getBookingDate().buildDate();
		this.bookingrefno = bean.getBookingRefNo();
		// Interface field type not supported.
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.InterpreterDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.bookingdate = bean.getBookingDate() == null ? null : bean.getBookingDate().buildDate();
		this.bookingrefno = bean.getBookingRefNo();
		// Interface field type not supported.
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.careuk.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.InterpreterDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.InterpreterDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.InterpreterDetailsVoBean();
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
		if(fieldName.equals("BOOKINGDATE"))
			return getBookingDate();
		if(fieldName.equals("BOOKINGREFNO"))
			return getBookingRefNo();
		if(fieldName.equals("BOOKINGUSER"))
			return getBookingUser();
		if(fieldName.equals("CATSREFERRAL"))
			return getCatsReferral();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getBookingDateIsNotNull()
	{
		return this.bookingdate != null;
	}
	public ims.framework.utils.Date getBookingDate()
	{
		return this.bookingdate;
	}
	public void setBookingDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.bookingdate = value;
	}
	public boolean getBookingRefNoIsNotNull()
	{
		return this.bookingrefno != null;
	}
	public String getBookingRefNo()
	{
		return this.bookingrefno;
	}
	public static int getBookingRefNoMaxLength()
	{
		return 25;
	}
	public void setBookingRefNo(String value)
	{
		this.isValidated = false;
		this.bookingrefno = value;
	}
	public boolean getBookingUserIsNotNull()
	{
		return this.bookinguser != null;
	}
	public ims.vo.interfaces.IMos getBookingUser()
	{
		return this.bookinguser;
	}
	public void setBookingUser(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.bookinguser = (ims.core.vo.MemberOfStaffLiteVo)value;
	}
	public boolean getCatsReferralIsNotNull()
	{
		return this.catsreferral != null;
	}
	public ims.careuk.vo.CatsReferralRefVo getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.careuk.vo.CatsReferralRefVo value)
	{
		this.isValidated = false;
		this.catsreferral = value;
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
		if(this.bookingdate == null)
			listOfErrors.add("BookingDate is mandatory");
		if(this.bookingrefno == null || this.bookingrefno.length() == 0)
			listOfErrors.add("BookingRefNo is mandatory");
		else if(this.bookingrefno.length() > 25)
			listOfErrors.add("The length of the field [bookingrefno] in the value object [ims.careuk.vo.InterpreterDetailsVo] is too big. It should be less or equal to 25");
		if(this.bookinguser == null)
			listOfErrors.add("BookingUser is mandatory");
		if(this.catsreferral == null)
			listOfErrors.add("CatsReferral is mandatory");
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
	
		InterpreterDetailsVo clone = new InterpreterDetailsVo(this.id, this.version);
		
		if(this.bookingdate == null)
			clone.bookingdate = null;
		else
			clone.bookingdate = (ims.framework.utils.Date)this.bookingdate.clone();
		clone.bookingrefno = this.bookingrefno;
		clone.bookinguser = this.bookinguser;
		clone.catsreferral = this.catsreferral;
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
		if (!(InterpreterDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InterpreterDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((InterpreterDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((InterpreterDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.bookingdate != null)
			count++;
		if(this.bookingrefno != null)
			count++;
		if(this.bookinguser != null)
			count++;
		if(this.catsreferral != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.framework.utils.Date bookingdate;
	protected String bookingrefno;
	protected ims.core.vo.MemberOfStaffLiteVo bookinguser;
	protected ims.careuk.vo.CatsReferralRefVo catsreferral;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
