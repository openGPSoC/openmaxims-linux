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

package ims.emergency.vo;

/**
 * Linked to emergency.Configuration.ManchesterTriageProtocolConfiguration business object (ID: 1087100010).
 */
public class ManchesterTriageProtocolConfigVo extends ims.emergency.vo.ManchesterTriageProtocolConfigLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ManchesterTriageProtocolConfigVo()
	{
	}
	public ManchesterTriageProtocolConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public ManchesterTriageProtocolConfigVo(ims.emergency.vo.beans.ManchesterTriageProtocolConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.protocolname = bean.getProtocolName();
		this.protocoldescription = bean.getProtocolDescription();
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.problem = bean.getProblem() == null ? null : bean.getProblem().buildVo();
		this.defaultpriority = bean.getDefaultPriority() == null ? null : ims.emergency.vo.lookups.TriagePriority.buildLookup(bean.getDefaultPriority());
		this.discriminators = ims.emergency.vo.ProtocolDiscriminatorVoCollection.buildFromBeanCollection(bean.getDiscriminators());
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.ManchesterTriageProtocolConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.protocolname = bean.getProtocolName();
		this.protocoldescription = bean.getProtocolDescription();
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.problem = bean.getProblem() == null ? null : bean.getProblem().buildVo(map);
		this.defaultpriority = bean.getDefaultPriority() == null ? null : ims.emergency.vo.lookups.TriagePriority.buildLookup(bean.getDefaultPriority());
		this.discriminators = ims.emergency.vo.ProtocolDiscriminatorVoCollection.buildFromBeanCollection(bean.getDiscriminators());
		this.taxonomymap = ims.core.vo.TaxonomyMapCollection.buildFromBeanCollection(bean.getTaxonomyMap());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.ManchesterTriageProtocolConfigVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.ManchesterTriageProtocolConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.ManchesterTriageProtocolConfigVoBean();
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
		if(fieldName.equals("DEFAULTPRIORITY"))
			return getDefaultPriority();
		if(fieldName.equals("DISCRIMINATORS"))
			return getDiscriminators();
		if(fieldName.equals("TAXONOMYMAP"))
			return getTaxonomyMap();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDefaultPriorityIsNotNull()
	{
		return this.defaultpriority != null;
	}
	public ims.emergency.vo.lookups.TriagePriority getDefaultPriority()
	{
		return this.defaultpriority;
	}
	public void setDefaultPriority(ims.emergency.vo.lookups.TriagePriority value)
	{
		this.isValidated = false;
		this.defaultpriority = value;
	}
	public boolean getDiscriminatorsIsNotNull()
	{
		return this.discriminators != null;
	}
	public ims.emergency.vo.ProtocolDiscriminatorVoCollection getDiscriminators()
	{
		return this.discriminators;
	}
	public void setDiscriminators(ims.emergency.vo.ProtocolDiscriminatorVoCollection value)
	{
		this.isValidated = false;
		this.discriminators = value;
	}
	public boolean getTaxonomyMapIsNotNull()
	{
		return this.taxonomymap != null;
	}
	public ims.core.vo.TaxonomyMapCollection getTaxonomyMap()
	{
		return this.taxonomymap;
	}
	public void setTaxonomyMap(ims.core.vo.TaxonomyMapCollection value)
	{
		this.isValidated = false;
		this.taxonomymap = value;
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
		if(this.discriminators != null)
		{
			if(!this.discriminators.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.taxonomymap != null)
		{
			if(!this.taxonomymap.isValidated())
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
		if(this.protocolname == null || this.protocolname.length() == 0)
			listOfErrors.add("ProtocolName is mandatory");
		else if(this.protocolname.length() > 100)
			listOfErrors.add("The length of the field [protocolname] in the value object [ims.emergency.vo.ManchesterTriageProtocolConfigVo] is too big. It should be less or equal to 100");
		if(this.protocoldescription == null || this.protocoldescription.length() == 0)
			listOfErrors.add("ProtocolDescription is mandatory");
		else if(this.protocoldescription.length() > 500)
			listOfErrors.add("The length of the field [protocoldescription] in the value object [ims.emergency.vo.ManchesterTriageProtocolConfigVo] is too big. It should be less or equal to 500");
		if(this.activestatus == null)
			listOfErrors.add("ActiveStatus is mandatory");
		if(this.problem == null)
			listOfErrors.add("Problem is mandatory");
		if(this.defaultpriority == null)
			listOfErrors.add("DefaultPriority is mandatory");
		if(this.discriminators != null)
		{
			String[] listOfOtherErrors = this.discriminators.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
	
		ManchesterTriageProtocolConfigVo clone = new ManchesterTriageProtocolConfigVo(this.id, this.version);
		
		clone.protocolname = this.protocolname;
		clone.protocoldescription = this.protocoldescription;
		if(this.activestatus == null)
			clone.activestatus = null;
		else
			clone.activestatus = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.activestatus.clone();
		if(this.problem == null)
			clone.problem = null;
		else
			clone.problem = (ims.clinical.vo.ClinicalProblemShortVo)this.problem.clone();
		if(this.defaultpriority == null)
			clone.defaultpriority = null;
		else
			clone.defaultpriority = (ims.emergency.vo.lookups.TriagePriority)this.defaultpriority.clone();
		if(this.discriminators == null)
			clone.discriminators = null;
		else
			clone.discriminators = (ims.emergency.vo.ProtocolDiscriminatorVoCollection)this.discriminators.clone();
		if(this.taxonomymap == null)
			clone.taxonomymap = null;
		else
			clone.taxonomymap = (ims.core.vo.TaxonomyMapCollection)this.taxonomymap.clone();
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
		if (!(ManchesterTriageProtocolConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ManchesterTriageProtocolConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ManchesterTriageProtocolConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ManchesterTriageProtocolConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.defaultpriority != null)
			count++;
		if(this.discriminators != null)
			count++;
		if(this.taxonomymap != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 3;
	}
	protected ims.emergency.vo.lookups.TriagePriority defaultpriority;
	protected ims.emergency.vo.ProtocolDiscriminatorVoCollection discriminators;
	protected ims.core.vo.TaxonomyMapCollection taxonomymap;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
