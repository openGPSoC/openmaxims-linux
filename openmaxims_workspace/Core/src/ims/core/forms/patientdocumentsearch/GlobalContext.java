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

package ims.core.forms.patientdocumentsearch;

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

		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getPatientDocumentIsNotNull()
		{
			return !cx_CorePatientDocument.getValueIsNull(context);
		}
		public ims.core.vo.PatientDocumentVo getPatientDocument()
		{
			return (ims.core.vo.PatientDocumentVo)cx_CorePatientDocument.getValue(context);
		}
		public void setPatientDocument(ims.core.vo.PatientDocumentVo value)
		{
			cx_CorePatientDocument.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientDocument = new ims.framework.ContextVariable("Core.PatientDocument", "_cv_Core.PatientDocument");
		public boolean getPatientCorrespondenceIsNotNull()
		{
			return !cx_CorePatientCorrespondence.getValueIsNull(context);
		}
		public ims.core.vo.PatientDocumentVo getPatientCorrespondence()
		{
			return (ims.core.vo.PatientDocumentVo)cx_CorePatientCorrespondence.getValue(context);
		}
		public void setPatientCorrespondence(ims.core.vo.PatientDocumentVo value)
		{
			cx_CorePatientCorrespondence.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientCorrespondence = new ims.framework.ContextVariable("Core.PatientCorrespondence", "_cv_Core.PatientCorrespondence");
		public boolean getPatientDocumentSearchFilterIsNotNull()
		{
			return !cx_CorePatientDocumentSearchFilter.getValueIsNull(context);
		}
		public ims.core.vo.PatientDocumentSearchFilterVo getPatientDocumentSearchFilter()
		{
			return (ims.core.vo.PatientDocumentSearchFilterVo)cx_CorePatientDocumentSearchFilter.getValue(context);
		}
		public void setPatientDocumentSearchFilter(ims.core.vo.PatientDocumentSearchFilterVo value)
		{
			cx_CorePatientDocumentSearchFilter.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientDocumentSearchFilter = new ims.framework.ContextVariable("Core.PatientDocumentSearchFilter", "_cvp_Core.PatientDocumentSearchFilter");

		private ims.framework.Context context;
	}

	public CoreContext Core;
}
