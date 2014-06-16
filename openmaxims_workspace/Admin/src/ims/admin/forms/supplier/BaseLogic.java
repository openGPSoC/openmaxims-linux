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

package ims.admin.forms.supplier;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.admin.domain.Supplier.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.admin.domain.Supplier domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void bindgrdMappingscolExtCodeTypeLookup()
	{
		this.form.lyr1().tabOrg().grdMappings().colExtCodeTypeComboBox().clear();
		ims.core.vo.lookups.TaxonomyTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getTaxonomyType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyr1().tabOrg().grdMappings().colExtCodeTypeComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void oncmbOrgCountyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyr1().tabOrg().cmbOrgCounty().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ntpf.vo.lookups.County existingInstance = (ims.ntpf.vo.lookups.County)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbOrgCountyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ntpf.vo.lookups.County)
		{
			ims.ntpf.vo.lookups.County instance = (ims.ntpf.vo.lookups.County)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbOrgCountyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ntpf.vo.lookups.County existingInstance = (ims.ntpf.vo.lookups.County)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyr1().tabOrg().cmbOrgCounty().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbOrgCountyLookup()
	{
		this.form.lyr1().tabOrg().cmbOrgCounty().clear();
		ims.ntpf.vo.lookups.CountyCollection lookupCollection = ims.ntpf.vo.lookups.LookupHelper.getCounty(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyr1().tabOrg().cmbOrgCounty().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbOrgCountyLookupValue(int id)
	{
		ims.ntpf.vo.lookups.County instance = ims.ntpf.vo.lookups.LookupHelper.getCountyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyr1().tabOrg().cmbOrgCounty().setValue(instance);
	}
	protected final void defaultcmbOrgCountyLookupValue()
	{
		this.form.lyr1().tabOrg().cmbOrgCounty().setValue((ims.ntpf.vo.lookups.County)domain.getLookupService().getDefaultInstance(ims.ntpf.vo.lookups.County.class, engine.getFormName().getID(), ims.ntpf.vo.lookups.County.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.admin.domain.Supplier domain;
}
