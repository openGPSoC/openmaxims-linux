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

package ims.clinicaladmin.forms.tumoursiteoverallstaging;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		ClinicalAdmin = new ClinicalAdminContext(context);
		Oncology = new OncologyContext(context);
	}
	public final class ClinicalAdminContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalAdminContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getTumourSiteIsNotNull()
		{
			return !cx_ClinicalAdminTumourSite.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.TumourSiteVo getTumourSite()
		{
			return (ims.clinicaladmin.vo.TumourSiteVo)cx_ClinicalAdminTumourSite.getValue(context);
		}

		private ims.framework.ContextVariable cx_ClinicalAdminTumourSite = new ims.framework.ContextVariable("ClinicalAdmin.TumourSite", "_cv_ClinicalAdmin.TumourSite");
		public boolean getTumourGroupIsNotNull()
		{
			return !cx_ClinicalAdminTumourGroup.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.TumourGroupVo getTumourGroup()
		{
			return (ims.clinicaladmin.vo.TumourGroupVo)cx_ClinicalAdminTumourGroup.getValue(context);
		}

		private ims.framework.ContextVariable cx_ClinicalAdminTumourGroup = new ims.framework.ContextVariable("ClinicalAdmin.TumourGroup", "_cv_ClinicalAdmin.TumourGroup");

		private ims.framework.Context context;
	}
	public final class OncologyContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OncologyContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedRecordForOverallDialogIsNotNull()
		{
			return !cx_OncologySelectedRecordForOverallDialog.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.SelectedRecordForOverallStagingDialogVo getSelectedRecordForOverallDialog()
		{
			return (ims.clinicaladmin.vo.SelectedRecordForOverallStagingDialogVo)cx_OncologySelectedRecordForOverallDialog.getValue(context);
		}
		public void setSelectedRecordForOverallDialog(ims.clinicaladmin.vo.SelectedRecordForOverallStagingDialogVo value)
		{
			cx_OncologySelectedRecordForOverallDialog.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OncologySelectedRecordForOverallDialog = new ims.framework.ContextVariable("Oncology.SelectedRecordForOverallDialog", "_cv_Oncology.SelectedRecordForOverallDialog");
		public boolean getOverallStagingDynamicGridCollectionIsNotNull()
		{
			return !cx_OncologyOverallStagingDynamicGridCollection.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.TumourGroupSiteOverallStagingVoCollection getOverallStagingDynamicGridCollection()
		{
			return (ims.clinicaladmin.vo.TumourGroupSiteOverallStagingVoCollection)cx_OncologyOverallStagingDynamicGridCollection.getValue(context);
		}
		public void setOverallStagingDynamicGridCollection(ims.clinicaladmin.vo.TumourGroupSiteOverallStagingVoCollection value)
		{
			cx_OncologyOverallStagingDynamicGridCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OncologyOverallStagingDynamicGridCollection = new ims.framework.ContextVariable("Oncology.OverallStagingDynamicGridCollection", "_cv_Oncology.OverallStagingDynamicGridCollection");

		private ims.framework.Context context;
	}

	public ClinicalAdminContext ClinicalAdmin;
	public OncologyContext Oncology;
}
