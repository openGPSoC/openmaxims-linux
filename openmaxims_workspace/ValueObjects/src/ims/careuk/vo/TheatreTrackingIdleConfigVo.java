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
 * Linked to CAREUK.TheatreTrackingIdleConfig business object (ID: 1096100056).
 */
public class TheatreTrackingIdleConfigVo extends ims.careuk.vo.TheatreTrackingIdleConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TheatreTrackingIdleConfigVo()
	{
	}
	public TheatreTrackingIdleConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public TheatreTrackingIdleConfigVo(ims.careuk.vo.beans.TheatreTrackingIdleConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.timeofarrivalidlemin = bean.getTimeOfArrivalIdleMin();
		this.timeintopacuidlemin = bean.getTimeIntoPACUIdleMin();
		this.timetotheatreidlemin = bean.getTimeToTheatreIdleMin();
		this.timeofarrivalidlecolour = bean.getTimeOfArrivalIdleColour() == null ? null : bean.getTimeOfArrivalIdleColour().buildColor();
		this.timeintopacuidlecolour = bean.getTimeIntoPACUIdleColour() == null ? null : bean.getTimeIntoPACUIdleColour().buildColor();
		this.timetotheatreidlecolour = bean.getTimeToTheatreIdleColour() == null ? null : bean.getTimeToTheatreIdleColour().buildColor();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.TheatreTrackingIdleConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.timeofarrivalidlemin = bean.getTimeOfArrivalIdleMin();
		this.timeintopacuidlemin = bean.getTimeIntoPACUIdleMin();
		this.timetotheatreidlemin = bean.getTimeToTheatreIdleMin();
		this.timeofarrivalidlecolour = bean.getTimeOfArrivalIdleColour() == null ? null : bean.getTimeOfArrivalIdleColour().buildColor();
		this.timeintopacuidlecolour = bean.getTimeIntoPACUIdleColour() == null ? null : bean.getTimeIntoPACUIdleColour().buildColor();
		this.timetotheatreidlecolour = bean.getTimeToTheatreIdleColour() == null ? null : bean.getTimeToTheatreIdleColour().buildColor();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.TheatreTrackingIdleConfigVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.TheatreTrackingIdleConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.TheatreTrackingIdleConfigVoBean();
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
		if(fieldName.equals("TIMEOFARRIVALIDLEMIN"))
			return getTimeOfArrivalIdleMin();
		if(fieldName.equals("TIMEINTOPACUIDLEMIN"))
			return getTimeIntoPACUIdleMin();
		if(fieldName.equals("TIMETOTHEATREIDLEMIN"))
			return getTimeToTheatreIdleMin();
		if(fieldName.equals("TIMEOFARRIVALIDLECOLOUR"))
			return getTimeOfArrivalIdleColour();
		if(fieldName.equals("TIMEINTOPACUIDLECOLOUR"))
			return getTimeIntoPACUIdleColour();
		if(fieldName.equals("TIMETOTHEATREIDLECOLOUR"))
			return getTimeToTheatreIdleColour();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTimeOfArrivalIdleMinIsNotNull()
	{
		return this.timeofarrivalidlemin != null;
	}
	public Integer getTimeOfArrivalIdleMin()
	{
		return this.timeofarrivalidlemin;
	}
	public void setTimeOfArrivalIdleMin(Integer value)
	{
		this.isValidated = false;
		this.timeofarrivalidlemin = value;
	}
	public boolean getTimeIntoPACUIdleMinIsNotNull()
	{
		return this.timeintopacuidlemin != null;
	}
	public Integer getTimeIntoPACUIdleMin()
	{
		return this.timeintopacuidlemin;
	}
	public void setTimeIntoPACUIdleMin(Integer value)
	{
		this.isValidated = false;
		this.timeintopacuidlemin = value;
	}
	public boolean getTimeToTheatreIdleMinIsNotNull()
	{
		return this.timetotheatreidlemin != null;
	}
	public Integer getTimeToTheatreIdleMin()
	{
		return this.timetotheatreidlemin;
	}
	public void setTimeToTheatreIdleMin(Integer value)
	{
		this.isValidated = false;
		this.timetotheatreidlemin = value;
	}
	public boolean getTimeOfArrivalIdleColourIsNotNull()
	{
		return this.timeofarrivalidlecolour != null;
	}
	public ims.framework.utils.Color getTimeOfArrivalIdleColour()
	{
		return this.timeofarrivalidlecolour;
	}
	public void setTimeOfArrivalIdleColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.timeofarrivalidlecolour = value;
	}
	public boolean getTimeIntoPACUIdleColourIsNotNull()
	{
		return this.timeintopacuidlecolour != null;
	}
	public ims.framework.utils.Color getTimeIntoPACUIdleColour()
	{
		return this.timeintopacuidlecolour;
	}
	public void setTimeIntoPACUIdleColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.timeintopacuidlecolour = value;
	}
	public boolean getTimeToTheatreIdleColourIsNotNull()
	{
		return this.timetotheatreidlecolour != null;
	}
	public ims.framework.utils.Color getTimeToTheatreIdleColour()
	{
		return this.timetotheatreidlecolour;
	}
	public void setTimeToTheatreIdleColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.timetotheatreidlecolour = value;
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
	
		TheatreTrackingIdleConfigVo clone = new TheatreTrackingIdleConfigVo(this.id, this.version);
		
		clone.timeofarrivalidlemin = this.timeofarrivalidlemin;
		clone.timeintopacuidlemin = this.timeintopacuidlemin;
		clone.timetotheatreidlemin = this.timetotheatreidlemin;
		if(this.timeofarrivalidlecolour == null)
			clone.timeofarrivalidlecolour = null;
		else
			clone.timeofarrivalidlecolour = (ims.framework.utils.Color)this.timeofarrivalidlecolour.clone();
		if(this.timeintopacuidlecolour == null)
			clone.timeintopacuidlecolour = null;
		else
			clone.timeintopacuidlecolour = (ims.framework.utils.Color)this.timeintopacuidlecolour.clone();
		if(this.timetotheatreidlecolour == null)
			clone.timetotheatreidlecolour = null;
		else
			clone.timetotheatreidlecolour = (ims.framework.utils.Color)this.timetotheatreidlecolour.clone();
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
		if (!(TheatreTrackingIdleConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TheatreTrackingIdleConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TheatreTrackingIdleConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TheatreTrackingIdleConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.timeofarrivalidlemin != null)
			count++;
		if(this.timeintopacuidlemin != null)
			count++;
		if(this.timetotheatreidlemin != null)
			count++;
		if(this.timeofarrivalidlecolour != null)
			count++;
		if(this.timeintopacuidlecolour != null)
			count++;
		if(this.timetotheatreidlecolour != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected Integer timeofarrivalidlemin;
	protected Integer timeintopacuidlemin;
	protected Integer timetotheatreidlemin;
	protected ims.framework.utils.Color timeofarrivalidlecolour;
	protected ims.framework.utils.Color timeintopacuidlecolour;
	protected ims.framework.utils.Color timetotheatreidlecolour;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
