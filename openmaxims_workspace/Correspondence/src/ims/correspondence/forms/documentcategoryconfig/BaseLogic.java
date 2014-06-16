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

package ims.correspondence.forms.documentcategoryconfig;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.correspondence.domain.DocumentCategoryConfig.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.correspondence.domain.DocumentCategoryConfig domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbDocCatValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrMain().tabByTemplate().cmbDocCat().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.DocumentCategory existingInstance = (ims.core.vo.lookups.DocumentCategory)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDocCatLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.DocumentCategory)
		{
			ims.core.vo.lookups.DocumentCategory instance = (ims.core.vo.lookups.DocumentCategory)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDocCatLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.DocumentCategory existingInstance = (ims.core.vo.lookups.DocumentCategory)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrMain().tabByTemplate().cmbDocCat().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDocCatLookup()
	{
		this.form.lyrMain().tabByTemplate().cmbDocCat().clear();
		ims.core.vo.lookups.DocumentCategoryCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getDocumentCategory(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrMain().tabByTemplate().cmbDocCat().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDocCatLookupValue(int id)
	{
		ims.core.vo.lookups.DocumentCategory instance = ims.core.vo.lookups.LookupHelper.getDocumentCategoryInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrMain().tabByTemplate().cmbDocCat().setValue(instance);
	}
	protected final void defaultcmbDocCatLookupValue()
	{
		this.form.lyrMain().tabByTemplate().cmbDocCat().setValue((ims.core.vo.lookups.DocumentCategory)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.DocumentCategory.class, engine.getFormName().getID(), ims.core.vo.lookups.DocumentCategory.TYPE_ID));
	}
	public void initialize() throws ims.framework.exceptions.FormOpenException
	{
	}
	public boolean allowNew()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public boolean allowUpdate()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public String[] validateUIRules()
	{
		return null;
	}
	public void clear()
	{
	}
	public void search()
	{
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.correspondence.domain.DocumentCategoryConfig domain;
}
