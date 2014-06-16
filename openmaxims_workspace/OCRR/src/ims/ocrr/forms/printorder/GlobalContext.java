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

package ims.ocrr.forms.printorder;

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

			PathologyResults = new PathologyResultsContext(context);
			PrintOrder = new PrintOrderContext(context);
		}
		public final class PathologyResultsContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private PathologyResultsContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getOrderIsNotNull()
			{
				return !cx_OCRRPathologyResultsOrder.getValueIsNull(context);
			}
			public ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo getOrder()
			{
				return (ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo)cx_OCRRPathologyResultsOrder.getValue(context);
			}

			private ims.framework.ContextVariable cx_OCRRPathologyResultsOrder = new ims.framework.ContextVariable("OCRR.PathologyResults.Order", "_cv_OCRR.PathologyResults.Order");
			private ims.framework.Context context;
		}
		public final class PrintOrderContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private PrintOrderContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getNotLocalInvestigationsIsNotNull()
			{
				return !cx_OCRRPrintOrderNotLocalInvestigations.getValueIsNull(context);
			}
			public ims.ocrr.configuration.vo.InvestigationIndexRefVoCollection getNotLocalInvestigations()
			{
				return (ims.ocrr.configuration.vo.InvestigationIndexRefVoCollection)cx_OCRRPrintOrderNotLocalInvestigations.getValue(context);
			}
		public void setNotLocalInvestigations(ims.ocrr.configuration.vo.InvestigationIndexRefVoCollection value)
		{
				cx_OCRRPrintOrderNotLocalInvestigations.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_OCRRPrintOrderNotLocalInvestigations = new ims.framework.ContextVariable("OCRR.PrintOrder.NotLocalInvestigations", "_cv_OCRR.PrintOrder.NotLocalInvestigations");
			public boolean getExecuteAutomaticPrintIsNotNull()
			{
				return !cx_OCRRPrintOrderExecuteAutomaticPrint.getValueIsNull(context);
			}
			public Boolean getExecuteAutomaticPrint()
			{
				return (Boolean)cx_OCRRPrintOrderExecuteAutomaticPrint.getValue(context);
			}
		public void setExecuteAutomaticPrint(Boolean value)
		{
				cx_OCRRPrintOrderExecuteAutomaticPrint.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_OCRRPrintOrderExecuteAutomaticPrint = new ims.framework.ContextVariable("OCRR.PrintOrder.ExecuteAutomaticPrint", "_cv_OCRR.PrintOrder.ExecuteAutomaticPrint");
			private ims.framework.Context context;
		}

		public boolean getPatientOrNowOnlyIsNotNull()
		{
			return !cx_OCRRPatientOrNowOnly.getValueIsNull(context);
		}
		public Boolean getPatientOrNowOnly()
		{
			return (Boolean)cx_OCRRPatientOrNowOnly.getValue(context);
		}
		public void setPatientOrNowOnly(Boolean value)
		{
			cx_OCRRPatientOrNowOnly.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRPatientOrNowOnly = new ims.framework.ContextVariable("OCRR.PatientOrNowOnly", "_cv_OCRR.PatientOrNowOnly");

		public PathologyResultsContext PathologyResults;
		public PrintOrderContext PrintOrder;
		private ims.framework.Context context;
	}

	public OCRRContext OCRR;
}
