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

package ims.clinicaladmin.forms.cciadmin;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getTaxonomyMapIsNotNull()
		{
			return !cx_CoreTaxonomyMap.getValueIsNull(context);
		}
		public ims.core.vo.TaxonomyMap getTaxonomyMap()
		{
			return (ims.core.vo.TaxonomyMap)cx_CoreTaxonomyMap.getValue(context);
		}
		public void setTaxonomyMap(ims.core.vo.TaxonomyMap value)
		{
			cx_CoreTaxonomyMap.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreTaxonomyMap = new ims.framework.ContextVariable("Core.TaxonomyMap", "_cv_Core.TaxonomyMap");
		public boolean getTaxonomySearchForNameIsNotNull()
		{
			return !cx_CoreTaxonomySearchForName.getValueIsNull(context);
		}
		public String getTaxonomySearchForName()
		{
			return (String)cx_CoreTaxonomySearchForName.getValue(context);
		}
		public void setTaxonomySearchForName(String value)
		{
			cx_CoreTaxonomySearchForName.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreTaxonomySearchForName = new ims.framework.ContextVariable("Core.TaxonomySearchForName", "_cv_Core.TaxonomySearchForName");
		public boolean getYesNoDialogMessageIsNotNull()
		{
			return !cx_CoreYesNoDialogMessage.getValueIsNull(context);
		}
		public String getYesNoDialogMessage()
		{
			return (String)cx_CoreYesNoDialogMessage.getValue(context);
		}
		public void setYesNoDialogMessage(String value)
		{
			cx_CoreYesNoDialogMessage.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreYesNoDialogMessage = new ims.framework.ContextVariable("Core.YesNoDialogMessage", "_cv_Core.YesNoDialogMessage");
		public boolean getGenericItemToDisplayIsNotNull()
		{
			return !cx_CoreGenericItemToDisplay.getValueIsNull(context);
		}
		public ims.vo.interfaces.IGenericItemInfo getGenericItemToDisplay()
		{
			return (ims.vo.interfaces.IGenericItemInfo)cx_CoreGenericItemToDisplay.getValue(context);
		}
		public void setGenericItemToDisplay(ims.vo.interfaces.IGenericItemInfo value)
		{
			cx_CoreGenericItemToDisplay.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreGenericItemToDisplay = new ims.framework.ContextVariable("Core.GenericItemToDisplay", "_cv_Core.GenericItemToDisplay");
		public boolean getSpecialtiesIsNotNull()
		{
			return !cx_CoreSpecialties.getValueIsNull(context);
		}
		public ims.core.vo.lookups.SpecialtyCollection getSpecialties()
		{
			return (ims.core.vo.lookups.SpecialtyCollection)cx_CoreSpecialties.getValue(context);
		}
		public void setSpecialties(ims.core.vo.lookups.SpecialtyCollection value)
		{
			cx_CoreSpecialties.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSpecialties = new ims.framework.ContextVariable("Core.Specialties", "_cv_Core.Specialties");

		private ims.framework.Context context;
	}

	public CoreContext Core;
}
