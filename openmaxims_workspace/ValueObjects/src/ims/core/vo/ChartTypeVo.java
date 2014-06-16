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
 * Linked to core.charting.ChartType business object (ID: 1081100000).
 */
public class ChartTypeVo extends ims.core.vo.ChartTypeShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ChartTypeVo()
	{
	}
	public ChartTypeVo(Integer id, int version)
	{
		super(id, version);
	}
	public ChartTypeVo(ims.core.vo.beans.ChartTypeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.maxfactor = bean.getMaxFactor();
		this.minfactor = bean.getMinFactor();
		this.belowbandpercent = bean.getBelowBandPercent();
		this.abovebandpercent = bean.getAboveBandPercent();
		this.backgroundcolour = bean.getBackgroundColour() == null ? null : bean.getBackgroundColour().buildColor();
		this.foregroundcolour = bean.getForegroundColour() == null ? null : bean.getForegroundColour().buildColor();
		this.normalbandcolour = bean.getNormalBandColour() == null ? null : bean.getNormalBandColour().buildColor();
		this.isactive = bean.getIsActive();
		this.datasettypes = ims.core.vo.ChartTypeDatasetVoCollection.buildFromBeanCollection(bean.getDatasetTypes());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ChartTypeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.maxfactor = bean.getMaxFactor();
		this.minfactor = bean.getMinFactor();
		this.belowbandpercent = bean.getBelowBandPercent();
		this.abovebandpercent = bean.getAboveBandPercent();
		this.backgroundcolour = bean.getBackgroundColour() == null ? null : bean.getBackgroundColour().buildColor();
		this.foregroundcolour = bean.getForegroundColour() == null ? null : bean.getForegroundColour().buildColor();
		this.normalbandcolour = bean.getNormalBandColour() == null ? null : bean.getNormalBandColour().buildColor();
		this.isactive = bean.getIsActive();
		this.datasettypes = ims.core.vo.ChartTypeDatasetVoCollection.buildFromBeanCollection(bean.getDatasetTypes());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ChartTypeVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ChartTypeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ChartTypeVoBean();
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
		if(fieldName.equals("MAXFACTOR"))
			return getMaxFactor();
		if(fieldName.equals("MINFACTOR"))
			return getMinFactor();
		if(fieldName.equals("BELOWBANDPERCENT"))
			return getBelowBandPercent();
		if(fieldName.equals("ABOVEBANDPERCENT"))
			return getAboveBandPercent();
		if(fieldName.equals("BACKGROUNDCOLOUR"))
			return getBackgroundColour();
		if(fieldName.equals("FOREGROUNDCOLOUR"))
			return getForegroundColour();
		if(fieldName.equals("NORMALBANDCOLOUR"))
			return getNormalBandColour();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("DATASETTYPES"))
			return getDatasetTypes();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMaxFactorIsNotNull()
	{
		return this.maxfactor != null;
	}
	public Integer getMaxFactor()
	{
		return this.maxfactor;
	}
	public void setMaxFactor(Integer value)
	{
		this.isValidated = false;
		this.maxfactor = value;
	}
	public boolean getMinFactorIsNotNull()
	{
		return this.minfactor != null;
	}
	public Integer getMinFactor()
	{
		return this.minfactor;
	}
	public void setMinFactor(Integer value)
	{
		this.isValidated = false;
		this.minfactor = value;
	}
	public boolean getBelowBandPercentIsNotNull()
	{
		return this.belowbandpercent != null;
	}
	public Integer getBelowBandPercent()
	{
		return this.belowbandpercent;
	}
	public void setBelowBandPercent(Integer value)
	{
		this.isValidated = false;
		this.belowbandpercent = value;
	}
	public boolean getAboveBandPercentIsNotNull()
	{
		return this.abovebandpercent != null;
	}
	public Integer getAboveBandPercent()
	{
		return this.abovebandpercent;
	}
	public void setAboveBandPercent(Integer value)
	{
		this.isValidated = false;
		this.abovebandpercent = value;
	}
	public boolean getBackgroundColourIsNotNull()
	{
		return this.backgroundcolour != null;
	}
	public ims.framework.utils.Color getBackgroundColour()
	{
		return this.backgroundcolour;
	}
	public void setBackgroundColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.backgroundcolour = value;
	}
	public boolean getForegroundColourIsNotNull()
	{
		return this.foregroundcolour != null;
	}
	public ims.framework.utils.Color getForegroundColour()
	{
		return this.foregroundcolour;
	}
	public void setForegroundColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.foregroundcolour = value;
	}
	public boolean getNormalBandColourIsNotNull()
	{
		return this.normalbandcolour != null;
	}
	public ims.framework.utils.Color getNormalBandColour()
	{
		return this.normalbandcolour;
	}
	public void setNormalBandColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.normalbandcolour = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getDatasetTypesIsNotNull()
	{
		return this.datasettypes != null;
	}
	public ims.core.vo.ChartTypeDatasetVoCollection getDatasetTypes()
	{
		return this.datasettypes;
	}
	public void setDatasetTypes(ims.core.vo.ChartTypeDatasetVoCollection value)
	{
		this.isValidated = false;
		this.datasettypes = value;
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
		if(this.datasettypes != null)
		{
			if(!this.datasettypes.isValidated())
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 100)
			listOfErrors.add("The length of the field [name] in the value object [ims.core.vo.ChartTypeVo] is too big. It should be less or equal to 100");
		if(this.belowbandpercent == null)
			listOfErrors.add("BelowBandPercent is mandatory");
		if(this.belowbandpercent != null && (this.belowbandpercent.intValue() < 0 || this.belowbandpercent.intValue() > 100))
			listOfErrors.add("Below Band should be between 0 and 100");
		if(this.abovebandpercent == null)
			listOfErrors.add("AboveBandPercent is mandatory");
		if(this.abovebandpercent != null && (this.abovebandpercent.intValue() < 0 || this.abovebandpercent.intValue() > 100))
			listOfErrors.add("Above Band should be between 0 and 100");
		if(this.isactive == null)
			listOfErrors.add("isActive is mandatory");
		if(this.datasettypes != null)
		{
			String[] listOfOtherErrors = this.datasettypes.validate();
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
	
		ChartTypeVo clone = new ChartTypeVo(this.id, this.version);
		
		clone.name = this.name;
		clone.description = this.description;
		clone.maxfactor = this.maxfactor;
		clone.minfactor = this.minfactor;
		clone.belowbandpercent = this.belowbandpercent;
		clone.abovebandpercent = this.abovebandpercent;
		if(this.backgroundcolour == null)
			clone.backgroundcolour = null;
		else
			clone.backgroundcolour = (ims.framework.utils.Color)this.backgroundcolour.clone();
		if(this.foregroundcolour == null)
			clone.foregroundcolour = null;
		else
			clone.foregroundcolour = (ims.framework.utils.Color)this.foregroundcolour.clone();
		if(this.normalbandcolour == null)
			clone.normalbandcolour = null;
		else
			clone.normalbandcolour = (ims.framework.utils.Color)this.normalbandcolour.clone();
		clone.isactive = this.isactive;
		if(this.datasettypes == null)
			clone.datasettypes = null;
		else
			clone.datasettypes = (ims.core.vo.ChartTypeDatasetVoCollection)this.datasettypes.clone();
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
		if (!(ChartTypeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ChartTypeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ChartTypeVo compareObj = (ChartTypeVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getName() == null && compareObj.getName() != null)
				return -1;
			if(this.getName() != null && compareObj.getName() == null)
				return 1;
			if(this.getName() != null && compareObj.getName() != null)
			{
				if(caseInsensitive)
					retVal = this.getName().toLowerCase().compareTo(compareObj.getName().toLowerCase());
				else
					retVal = this.getName().compareTo(compareObj.getName());
			}
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.maxfactor != null)
			count++;
		if(this.minfactor != null)
			count++;
		if(this.belowbandpercent != null)
			count++;
		if(this.abovebandpercent != null)
			count++;
		if(this.backgroundcolour != null)
			count++;
		if(this.foregroundcolour != null)
			count++;
		if(this.normalbandcolour != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.datasettypes != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 9;
	}
	protected Integer maxfactor;
	protected Integer minfactor;
	protected Integer belowbandpercent;
	protected Integer abovebandpercent;
	protected ims.framework.utils.Color backgroundcolour;
	protected ims.framework.utils.Color foregroundcolour;
	protected ims.framework.utils.Color normalbandcolour;
	protected Boolean isactive;
	protected ims.core.vo.ChartTypeDatasetVoCollection datasettypes;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
