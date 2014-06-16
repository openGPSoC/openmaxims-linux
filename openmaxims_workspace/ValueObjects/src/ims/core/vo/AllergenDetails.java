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
 * Linked to core.clinical.Allergen business object (ID: 1003100018).
 */
public class AllergenDetails extends ims.core.vo.AllergenVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.ICciFull
{
	private static final long serialVersionUID = 1L;

	public AllergenDetails()
	{
	}
	public AllergenDetails(Integer id, int version)
	{
		super(id, version);
	}
	public AllergenDetails(ims.core.vo.beans.AllergenDetailsBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.allergenname = bean.getAllergenName();
		this.allergentype = bean.getAllergenType() == null ? null : ims.core.vo.lookups.AllergenType.buildLookup(bean.getAllergenType());
		this.isactive = bean.getIsActive();
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
		this.keywords = ims.core.vo.KeywordVoCollection.buildFromBeanCollection(bean.getKeywords());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.AllergenDetailsBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.allergenname = bean.getAllergenName();
		this.allergentype = bean.getAllergenType() == null ? null : ims.core.vo.lookups.AllergenType.buildLookup(bean.getAllergenType());
		this.isactive = bean.getIsActive();
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
		this.keywords = ims.core.vo.KeywordVoCollection.buildFromBeanCollection(bean.getKeywords());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.AllergenDetailsBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.AllergenDetailsBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.AllergenDetailsBean();
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
		if(fieldName.equals("KEYWORDS"))
			return getKeywords();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getKeywordsIsNotNull()
	{
		return this.keywords != null;
	}
	public ims.core.vo.KeywordVoCollection getKeywords()
	{
		return this.keywords;
	}
	public void setKeywords(ims.core.vo.KeywordVoCollection value)
	{
		this.isValidated = false;
		this.keywords = value;
	}
	/**
	* CCI Interface methods
	*/
	public ims.core.vo.TaxonomyMapCollection getCciMappings()
	{
		return getTaxonomyMap();
	}
	
	public void setCciMappings(ims.core.vo.TaxonomyMapCollection cciMappings)
	{
		setTaxonomyMap(cciMappings);
	}
	
	public ims.core.vo.KeywordVoCollection getCciKeywords()
	{
		return getKeywords();
	}
	
	public void setCciKeywords(ims.core.vo.KeywordVoCollection cciKeywords)
	{
		setKeywords(cciKeywords);
	}
	
	public Integer getCciId()
	{
		return this.getID_Allergen();
	}
	
	public void setCciAllergenType(ims.core.vo.lookups.AllergenType type)
	{
		setAllergenType(type);
	}
	
	public ims.core.vo.lookups.AllergenType getCciAllergenType()
	{
		return this.getAllergenType();
	}
	
	public Integer getCciProcedureDuration()
	{
		return null; // this function is only for the procedure vo.
	}
		
	public void setCciProcedureDuration(Integer duration)
	{
		// this function is only for the procedure vo. 
	}
	
	public Integer getCciProcedureLOS()
	{
		return null; // this function is only for the procedure vo.
	}
		
	public void setCciProcedureLOS(Integer intLOS)
	{
		// this function is only for the procedure vo. 
	}
	
	public Integer getCciTCILagTime()
	{
		return null; // this function is only for the procedure vo.
	}
	
	public void setCciTCILagTime(Integer tciLagTime)
	{
		// this function is only for the procedure vo. 		
	}
	public String[] validateCci()
	{
		return this.validate();
	}
		
	public Boolean isValidatedCci()
	{
		return Boolean.valueOf(this.isValidated());
	}
	public void setCciTreatmentInterventionType(ims.clinical.vo.lookups.TreatmentInterventionType type)
	{
		// this function is only for the TreatmentIntervention vo
	}
	
	public ims.clinical.vo.lookups.TreatmentInterventionType getCciTreatmentInterventionType()
	{
		return null; // this function is only for the TreatmentIntervention vo
	}
	
	public ims.clinicaladmin.vo.lookups.CaseTypeProcedure getSurgeonCategory()
	{
		return null;  // used for procedurevo only
	}
	
	public void setSurgeonCategory(ims.clinicaladmin.vo.lookups.CaseTypeProcedure category)
	{
	// used for procedurevo only
	}
	
	public ims.clinicaladmin.vo.lookups.CaseTypeProcedure getAnaesthetistCategory()
	{
		return null;  // used for procedurevo only
	}
	
	public void setAnaesthetistCategory(ims.clinicaladmin.vo.lookups.CaseTypeProcedure category)
	{
	// used for procedurevo only
	}
	
	public ims.clinicaladmin.vo.lookups.CaseTypeProcedure getHospitalCategory()
	{
		return null;  // used for procedurevo only
	}
	
	public void setHospitalCategory(ims.clinicaladmin.vo.lookups.CaseTypeProcedure category)
	{
	// used for procedurevo only
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
		if(this.taxonomymap != null)
		{
			if(!this.taxonomymap.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.keywords != null)
		{
			if(!this.keywords.isValidated())
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
		if(this.allergenname == null || this.allergenname.length() == 0)
			listOfErrors.add("Allergen is a mandatory field");
		else if(this.allergenname.length() > 255)
			listOfErrors.add("The length of the field [allergenname] in the value object [ims.core.vo.AllergenDetails] is too big. It should be less or equal to 255");
		if(this.taxonomymap != null)
		{
			String[] listOfOtherErrors = this.taxonomymap.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.keywords != null)
		{
			String[] listOfOtherErrors = this.keywords.validate();
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
	
		AllergenDetails clone = new AllergenDetails(this.id, this.version);
		
		clone.allergenname = this.allergenname;
		if(this.allergentype == null)
			clone.allergentype = null;
		else
			clone.allergentype = (ims.core.vo.lookups.AllergenType)this.allergentype.clone();
		clone.isactive = this.isactive;
		if(this.taxonomymap == null)
			clone.taxonomymap = null;
		else
			clone.taxonomymap = (ims.core.vo.TaxonomyMapCollection)this.taxonomymap.clone();
		if(this.keywords == null)
			clone.keywords = null;
		else
			clone.keywords = (ims.core.vo.KeywordVoCollection)this.keywords.clone();
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
		if (!(AllergenDetails.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AllergenDetails object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AllergenDetails compareObj = (AllergenDetails)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getAllergenName() == null && compareObj.getAllergenName() != null)
				return -1;
			if(this.getAllergenName() != null && compareObj.getAllergenName() == null)
				return 1;
			if(this.getAllergenName() != null && compareObj.getAllergenName() != null)
			{
				if(caseInsensitive)
					retVal = this.getAllergenName().toLowerCase().compareTo(compareObj.getAllergenName().toLowerCase());
				else
					retVal = this.getAllergenName().compareTo(compareObj.getAllergenName());
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
		if(this.keywords != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 1;
	}
	protected ims.core.vo.KeywordVoCollection keywords;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
