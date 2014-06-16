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

package ims.clinical.vo;

/**
 * Linked to eDischarge.TTAMedicationDetail business object (ID: 1099100016).
 */
public class TTAMedicationDetailLiteVo extends ims.edischarge.vo.TTAMedicationDetailRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TTAMedicationDetailLiteVo()
	{
	}
	public TTAMedicationDetailLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public TTAMedicationDetailLiteVo(ims.clinical.vo.beans.TTAMedicationDetailLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.othermedicationtext = bean.getOtherMedicationText();
		this.dosevalue = bean.getDoseValue();
		this.doseunit = bean.getDoseUnit() == null ? null : ims.core.vo.lookups.MedicationDoseUnit.buildLookup(bean.getDoseUnit());
		this.form = bean.getForm() == null ? null : ims.clinical.vo.lookups.DoseFormIndicator.buildLookup(bean.getForm());
		this.route = bean.getRoute() == null ? null : ims.core.vo.lookups.MedicationRoute.buildLookup(bean.getRoute());
		this.frequencyvalue = bean.getFrequencyValue();
		this.frequencyunit = bean.getFrequencyUnit() == null ? null : ims.core.vo.lookups.MedicationFrequency.buildLookup(bean.getFrequencyUnit());
		this.commenceddate = bean.getCommencedDate() == null ? null : bean.getCommencedDate().buildDate();
		this.medication = bean.getMedication() == null ? null : bean.getMedication().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.TTAMedicationDetailLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.othermedicationtext = bean.getOtherMedicationText();
		this.dosevalue = bean.getDoseValue();
		this.doseunit = bean.getDoseUnit() == null ? null : ims.core.vo.lookups.MedicationDoseUnit.buildLookup(bean.getDoseUnit());
		this.form = bean.getForm() == null ? null : ims.clinical.vo.lookups.DoseFormIndicator.buildLookup(bean.getForm());
		this.route = bean.getRoute() == null ? null : ims.core.vo.lookups.MedicationRoute.buildLookup(bean.getRoute());
		this.frequencyvalue = bean.getFrequencyValue();
		this.frequencyunit = bean.getFrequencyUnit() == null ? null : ims.core.vo.lookups.MedicationFrequency.buildLookup(bean.getFrequencyUnit());
		this.commenceddate = bean.getCommencedDate() == null ? null : bean.getCommencedDate().buildDate();
		this.medication = bean.getMedication() == null ? null : bean.getMedication().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.TTAMedicationDetailLiteVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.TTAMedicationDetailLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.TTAMedicationDetailLiteVoBean();
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
		if(fieldName.equals("OTHERMEDICATIONTEXT"))
			return getOtherMedicationText();
		if(fieldName.equals("DOSEVALUE"))
			return getDoseValue();
		if(fieldName.equals("DOSEUNIT"))
			return getDoseUnit();
		if(fieldName.equals("FORM"))
			return getForm();
		if(fieldName.equals("ROUTE"))
			return getRoute();
		if(fieldName.equals("FREQUENCYVALUE"))
			return getFrequencyValue();
		if(fieldName.equals("FREQUENCYUNIT"))
			return getFrequencyUnit();
		if(fieldName.equals("COMMENCEDDATE"))
			return getCommencedDate();
		if(fieldName.equals("MEDICATION"))
			return getMedication();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getOtherMedicationTextIsNotNull()
	{
		return this.othermedicationtext != null;
	}
	public String getOtherMedicationText()
	{
		return this.othermedicationtext;
	}
	public static int getOtherMedicationTextMaxLength()
	{
		return 700;
	}
	public void setOtherMedicationText(String value)
	{
		this.isValidated = false;
		this.othermedicationtext = value;
	}
	public boolean getDoseValueIsNotNull()
	{
		return this.dosevalue != null;
	}
	public Float getDoseValue()
	{
		return this.dosevalue;
	}
	public void setDoseValue(Float value)
	{
		this.isValidated = false;
		this.dosevalue = value;
	}
	public boolean getDoseUnitIsNotNull()
	{
		return this.doseunit != null;
	}
	public ims.core.vo.lookups.MedicationDoseUnit getDoseUnit()
	{
		return this.doseunit;
	}
	public void setDoseUnit(ims.core.vo.lookups.MedicationDoseUnit value)
	{
		this.isValidated = false;
		this.doseunit = value;
	}
	public boolean getFormIsNotNull()
	{
		return this.form != null;
	}
	public ims.clinical.vo.lookups.DoseFormIndicator getForm()
	{
		return this.form;
	}
	public void setForm(ims.clinical.vo.lookups.DoseFormIndicator value)
	{
		this.isValidated = false;
		this.form = value;
	}
	public boolean getRouteIsNotNull()
	{
		return this.route != null;
	}
	public ims.core.vo.lookups.MedicationRoute getRoute()
	{
		return this.route;
	}
	public void setRoute(ims.core.vo.lookups.MedicationRoute value)
	{
		this.isValidated = false;
		this.route = value;
	}
	public boolean getFrequencyValueIsNotNull()
	{
		return this.frequencyvalue != null;
	}
	public Integer getFrequencyValue()
	{
		return this.frequencyvalue;
	}
	public void setFrequencyValue(Integer value)
	{
		this.isValidated = false;
		this.frequencyvalue = value;
	}
	public boolean getFrequencyUnitIsNotNull()
	{
		return this.frequencyunit != null;
	}
	public ims.core.vo.lookups.MedicationFrequency getFrequencyUnit()
	{
		return this.frequencyunit;
	}
	public void setFrequencyUnit(ims.core.vo.lookups.MedicationFrequency value)
	{
		this.isValidated = false;
		this.frequencyunit = value;
	}
	public boolean getCommencedDateIsNotNull()
	{
		return this.commenceddate != null;
	}
	public ims.framework.utils.Date getCommencedDate()
	{
		return this.commenceddate;
	}
	public void setCommencedDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.commenceddate = value;
	}
	public boolean getMedicationIsNotNull()
	{
		return this.medication != null;
	}
	public ims.core.vo.MedicationLiteVo getMedication()
	{
		return this.medication;
	}
	public void setMedication(ims.core.vo.MedicationLiteVo value)
	{
		this.isValidated = false;
		this.medication = value;
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
		if(this.othermedicationtext == null || this.othermedicationtext.length() == 0)
			listOfErrors.add("OtherMedicationText is mandatory");
		else if(this.othermedicationtext.length() > 700)
			listOfErrors.add("The length of the field [othermedicationtext] in the value object [ims.clinical.vo.TTAMedicationDetailLiteVo] is too big. It should be less or equal to 700");
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
	
		TTAMedicationDetailLiteVo clone = new TTAMedicationDetailLiteVo(this.id, this.version);
		
		clone.othermedicationtext = this.othermedicationtext;
		clone.dosevalue = this.dosevalue;
		if(this.doseunit == null)
			clone.doseunit = null;
		else
			clone.doseunit = (ims.core.vo.lookups.MedicationDoseUnit)this.doseunit.clone();
		if(this.form == null)
			clone.form = null;
		else
			clone.form = (ims.clinical.vo.lookups.DoseFormIndicator)this.form.clone();
		if(this.route == null)
			clone.route = null;
		else
			clone.route = (ims.core.vo.lookups.MedicationRoute)this.route.clone();
		clone.frequencyvalue = this.frequencyvalue;
		if(this.frequencyunit == null)
			clone.frequencyunit = null;
		else
			clone.frequencyunit = (ims.core.vo.lookups.MedicationFrequency)this.frequencyunit.clone();
		if(this.commenceddate == null)
			clone.commenceddate = null;
		else
			clone.commenceddate = (ims.framework.utils.Date)this.commenceddate.clone();
		if(this.medication == null)
			clone.medication = null;
		else
			clone.medication = (ims.core.vo.MedicationLiteVo)this.medication.clone();
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
		if (!(TTAMedicationDetailLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TTAMedicationDetailLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TTAMedicationDetailLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TTAMedicationDetailLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.othermedicationtext != null)
			count++;
		if(this.dosevalue != null)
			count++;
		if(this.doseunit != null)
			count++;
		if(this.form != null)
			count++;
		if(this.route != null)
			count++;
		if(this.frequencyvalue != null)
			count++;
		if(this.frequencyunit != null)
			count++;
		if(this.commenceddate != null)
			count++;
		if(this.medication != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected String othermedicationtext;
	protected Float dosevalue;
	protected ims.core.vo.lookups.MedicationDoseUnit doseunit;
	protected ims.clinical.vo.lookups.DoseFormIndicator form;
	protected ims.core.vo.lookups.MedicationRoute route;
	protected Integer frequencyvalue;
	protected ims.core.vo.lookups.MedicationFrequency frequencyunit;
	protected ims.framework.utils.Date commenceddate;
	protected ims.core.vo.MedicationLiteVo medication;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
