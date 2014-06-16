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

package ims.admin.forms.pacsconfig;

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

			CentricityWebPACS = new CentricityWebPACSContext(context);
		}
		public final class CentricityWebPACSContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private CentricityWebPACSContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getAccessionNumberIsNotNull()
			{
				return !cx_OCRRCentricityWebPACSAccessionNumber.getValueIsNull(context);
			}
			public String getAccessionNumber()
			{
				return (String)cx_OCRRCentricityWebPACSAccessionNumber.getValue(context);
			}
		public void setAccessionNumber(String value)
		{
				cx_OCRRCentricityWebPACSAccessionNumber.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_OCRRCentricityWebPACSAccessionNumber = new ims.framework.ContextVariable("OCRR.CentricityWebPACS.AccessionNumber", "_cv_OCRR.CentricityWebPACS.AccessionNumber");
			private ims.framework.Context context;
		}


		public CentricityWebPACSContext CentricityWebPACS;
		private ims.framework.Context context;
	}

	public OCRRContext OCRR;
}
