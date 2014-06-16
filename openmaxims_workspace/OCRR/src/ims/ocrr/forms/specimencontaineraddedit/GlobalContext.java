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

package ims.ocrr.forms.specimencontaineraddedit;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Admin = new AdminContext(context);
		OCRR = new OCRRContext(context);
		Core = new CoreContext(context);
	}
	public final class AdminContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private AdminContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getColourChosenIsNotNull()
		{
			return !cx_AdminColourChosen.getValueIsNull(context);
		}
		public ims.framework.utils.Color getColourChosen()
		{
			return (ims.framework.utils.Color)cx_AdminColourChosen.getValue(context);
		}
		public void setColourChosen(ims.framework.utils.Color value)
		{
			cx_AdminColourChosen.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminColourChosen = new ims.framework.ContextVariable("Admin.ColourChosen", "_cv_Admin.ColourChosen");

		private ims.framework.Context context;
	}
	public final class OCRRContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OCRRContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getUpdatePathSpecimenContainerIsNotNull()
		{
			return !cx_OCRRUpdatePathSpecimenContainer.getValueIsNull(context);
		}
		public Boolean getUpdatePathSpecimenContainer()
		{
			return (Boolean)cx_OCRRUpdatePathSpecimenContainer.getValue(context);
		}
		public void setUpdatePathSpecimenContainer(Boolean value)
		{
			cx_OCRRUpdatePathSpecimenContainer.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRUpdatePathSpecimenContainer = new ims.framework.ContextVariable("OCRR.UpdatePathSpecimenContainer", "_cv_OCRR.UpdatePathSpecimenContainer");
		public boolean getPathSpecimenContainerVoIsNotNull()
		{
			return !cx_OCRRPathSpecimenContainerVo.getValueIsNull(context);
		}
		public ims.ocrr.vo.PathSpecimenContainerVo getPathSpecimenContainerVo()
		{
			return (ims.ocrr.vo.PathSpecimenContainerVo)cx_OCRRPathSpecimenContainerVo.getValue(context);
		}
		public void setPathSpecimenContainerVo(ims.ocrr.vo.PathSpecimenContainerVo value)
		{
			cx_OCRRPathSpecimenContainerVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRPathSpecimenContainerVo = new ims.framework.ContextVariable("OCRR.PathSpecimenContainerVo", "_cv_OCRR.PathSpecimenContainerVo");

		private ims.framework.Context context;
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

		private ims.framework.Context context;
	}

	public AdminContext Admin;
	public OCRRContext OCRR;
	public CoreContext Core;
}
