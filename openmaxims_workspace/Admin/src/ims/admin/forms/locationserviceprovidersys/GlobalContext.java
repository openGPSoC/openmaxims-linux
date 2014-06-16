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

package ims.admin.forms.locationserviceprovidersys;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		OCRR = new OCRRContext(context);
	}
	public final class OCRRContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OCRRContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getProviderSystemFormModeIsNotNull()
		{
			return !cx_OCRRProviderSystemFormMode.getValueIsNull(context);
		}
		public ims.framework.enumerations.FormMode getProviderSystemFormMode()
		{
			return (ims.framework.enumerations.FormMode)cx_OCRRProviderSystemFormMode.getValue(context);
		}
		public void setProviderSystemFormMode(ims.framework.enumerations.FormMode value)
		{
			cx_OCRRProviderSystemFormMode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRProviderSystemFormMode = new ims.framework.ContextVariable("OCRR.ProviderSystemFormMode", "_cv_OCRR.ProviderSystemFormMode");
		public boolean getProviderSystemIsNotNull()
		{
			return !cx_OCRRProviderSystem.getValueIsNull(context);
		}
		public ims.ocrr.vo.ProviderSystemVo getProviderSystem()
		{
			return (ims.ocrr.vo.ProviderSystemVo)cx_OCRRProviderSystem.getValue(context);
		}
		public void setProviderSystem(ims.ocrr.vo.ProviderSystemVo value)
		{
			cx_OCRRProviderSystem.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRProviderSystem = new ims.framework.ContextVariable("OCRR.ProviderSystem", "_cv_OCRR.ProviderSystem");
		public boolean getProviderSystemCollIsNotNull()
		{
			return !cx_OCRRProviderSystemColl.getValueIsNull(context);
		}
		public ims.ocrr.vo.ProviderSystemVoCollection getProviderSystemColl()
		{
			return (ims.ocrr.vo.ProviderSystemVoCollection)cx_OCRRProviderSystemColl.getValue(context);
		}
		public void setProviderSystemColl(ims.ocrr.vo.ProviderSystemVoCollection value)
		{
			cx_OCRRProviderSystemColl.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRProviderSystemColl = new ims.framework.ContextVariable("OCRR.ProviderSystemColl", "_cv_OCRR.ProviderSystemColl");

		private ims.framework.Context context;
	}

	public OCRRContext OCRR;
}
