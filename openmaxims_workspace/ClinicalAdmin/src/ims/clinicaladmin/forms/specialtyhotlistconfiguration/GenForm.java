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

package ims.clinicaladmin.forms.specialtyhotlistconfiguration;

import ims.framework.*;
import ims.framework.controls.*;
import ims.framework.enumerations.*;
import ims.framework.utils.RuntimeAnchoring;

public class GenForm extends FormBridge
{
	private static final long serialVersionUID = 1L;

	public boolean canProvideData(IReportSeed[] reportSeeds)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields()).canProvideData();
	}
	public boolean hasData(IReportSeed[] reportSeeds)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields()).hasData();
	}
	public IReportField[] getData(IReportSeed[] reportSeeds)
	{
		return getData(reportSeeds, false);
	}
	public IReportField[] getData(IReportSeed[] reportSeeds, boolean excludeNulls)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields(), excludeNulls).getData();
	}

	public static class rdoGrpRadioButton extends RadioButtonBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected void setContext(Integer startTabIndex, ims.framework.utils.SizeInfo designSize, ims.framework.utils.SizeInfo runtimeSize)
		{
			if(startTabIndex == null)
				throw new RuntimeException("Invalid startTabIndex ");
			RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 368, 13, 144, 16, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
			control.addButton(0, anchoringHelper1.getX(), anchoringHelper1.getY(), anchoringHelper1.getWidth(), "View Cancer Imaging", startTabIndex.intValue() + 5);
			RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 240, 13, 112, 16, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
			control.addButton(1, anchoringHelper2.getX(), anchoringHelper2.getY(), anchoringHelper2.getWidth(), "View Procedures", startTabIndex.intValue() + 3);
			RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 128, 13, 96, 16, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
			control.addButton(2, anchoringHelper3.getX(), anchoringHelper3.getY(), anchoringHelper3.getWidth(), "View Problems", startTabIndex.intValue() + 2);
			RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 16, 13, 96, 16, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
			control.addButton(3, anchoringHelper4.getX(), anchoringHelper4.getY(), anchoringHelper4.getWidth(), "View Diagnoses", startTabIndex.intValue() + 1);
		}
		public void setText(rdoGrpEnumeration option, String value)
		{
			if(option != null && option.id >= 0 && value != null)
				control.setText(option.id, value);
		}
		public rdoGrpEnumeration getValue()
		{
			switch (super.control.getValue())
			{
				case -1: return rdoGrpEnumeration.None;
				case 0: return rdoGrpEnumeration.rdoCancerImaging;
				case 1: return rdoGrpEnumeration.rdoProcedures;
				case 2: return rdoGrpEnumeration.rdoProblems;
				case 3: return rdoGrpEnumeration.rdoDiagnosis;
			}
			return null;
		}
		public void setValue(rdoGrpEnumeration value)
		{
			if(value != null)
				super.control.setValue(value.id);
			else
				super.control.setValue(rdoGrpEnumeration.None.id);
		}
		public boolean isEnabled(rdoGrpEnumeration option)
		{
			return super.control.isEnabled(option.id);
		}
		public void setEnabled(rdoGrpEnumeration option, boolean value)
		{
			super.control.setEnabled(option.id, value);
		}
		public boolean isVisible(rdoGrpEnumeration option)
		{
			return super.control.isVisible(option.id);
		}
		public void setVisible(rdoGrpEnumeration option, boolean value)
		{
			super.control.setVisible(option.id, value);
		}
		public void setVisible(boolean value)
		{
			super.control.setVisible(value);
		}
		public void setEnabled(boolean value)
		{
			super.control.setEnabled(value);
		}
	}
	public static class rdoGrpEnumeration implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public static rdoGrpEnumeration None = new rdoGrpEnumeration(-1);
		public static rdoGrpEnumeration rdoCancerImaging = new rdoGrpEnumeration(0);
		public static rdoGrpEnumeration rdoProcedures = new rdoGrpEnumeration(1);
		public static rdoGrpEnumeration rdoProblems = new rdoGrpEnumeration(2);
		public static rdoGrpEnumeration rdoDiagnosis = new rdoGrpEnumeration(3);
		private rdoGrpEnumeration(int id)
		{
			this.id = id;
		}
		public boolean equals(Object o)
		{
			return this.id == ((rdoGrpEnumeration)o).id;
		}
		private int id;
	}
	private void validateContext(ims.framework.Context context)
	{
		if(context == null)
			return;
	}
	public boolean supportsRecordedInError()
	{
		return false;
	}
	public ims.vo.ValueObject getRecordedInErrorVo()
	{
		return null;
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, Context context) throws Exception
	{
		setContext(loader, form, appForm, factory, context, Boolean.FALSE, new Integer(0), null, null, new Integer(0));
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, Context context, Boolean skipContextValidation) throws Exception
	{
		setContext(loader, form, appForm, factory, context, skipContextValidation, new Integer(0), null, null, new Integer(0));
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, ims.framework.Context context, Boolean skipContextValidation, Integer startControlID, ims.framework.utils.SizeInfo runtimeSize, ims.framework.Control control, Integer startTabIndex) throws Exception
	{
		if(loader == null); // this is to avoid eclipse warning only.
		if(factory == null); // this is to avoid eclipse warning only.
		if(runtimeSize == null); // this is to avoid eclipse warning only.
		if(appForm == null)
			throw new RuntimeException("Invalid application form");
		if(startControlID == null)
			throw new RuntimeException("Invalid startControlID");
		if(control == null); // this is to avoid eclipse warning only.
		if(startTabIndex == null)
			throw new RuntimeException("Invalid startTabIndex");
		this.context = context;
		this.componentIdentifier = startControlID.toString();
		this.formInfo = form.getFormInfo();
		this.globalContext = new GlobalContext(context);
	
		if(skipContextValidation == null || !skipContextValidation.booleanValue())
		{
			validateContext(context);
		}
	
		super.setContext(form);

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(848, 632);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setFormReferences(FormReferencesFlyweightFactory.getInstance().create(Forms.class));
		super.setImageReferences(ImageReferencesFlyweightFactory.getInstance().create(Images.class));
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));
		super.setLocalContext(new LocalContext(context, form.getFormInfo(), componentIdentifier));

		// Context Menus
		contextMenus = new ContextMenus();
		contextMenus.contextMenuSpecialtyHotlistConfiguration = factory.createMenu(startControlID.intValue() + 1);
		contextMenus.contextMenuSpecialtyHotlistConfigurationCONFIGUREItem = factory.createMenuItem(startControlID.intValue() + 1, "Configure Procedures for ", true, false, new Integer(103108), true, false);
		contextMenus.contextMenuSpecialtyHotlistConfiguration.add(contextMenus.contextMenuSpecialtyHotlistConfigurationCONFIGUREItem);
		contextMenus.contextMenuSpecialtyHotlistConfigurationMOVEUPItem = factory.createMenuItem(startControlID.intValue() + 2, "Move UP", true, false, new Integer(102197), true, false);
		contextMenus.contextMenuSpecialtyHotlistConfiguration.add(contextMenus.contextMenuSpecialtyHotlistConfigurationMOVEUPItem);
		contextMenus.contextMenuSpecialtyHotlistConfigurationMOVEDOWNItem = factory.createMenuItem(startControlID.intValue() + 3, "Move Down", true, false, new Integer(102198), true, false);
		contextMenus.contextMenuSpecialtyHotlistConfiguration.add(contextMenus.contextMenuSpecialtyHotlistConfigurationMOVEDOWNItem);
		contextMenus.contextMenuSpecialtyHotlistConfigurationREMOVEItem = factory.createMenuItem(startControlID.intValue() + 4, "Remove", true, false, new Integer(102148), false, false);
		contextMenus.contextMenuSpecialtyHotlistConfiguration.add(contextMenus.contextMenuSpecialtyHotlistConfigurationREMOVEItem);
		form.registerMenu(contextMenus.contextMenuSpecialtyHotlistConfiguration);


		// Tree Controls
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 16, 40, 816, 576, ims.framework.enumerations.ControlAnchoring.ALL);
		super.addControl(factory.getControl(TreeView.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), new Integer(startTabIndex.intValue() + 4), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL,Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, contextMenus.contextMenuSpecialtyHotlistConfiguration, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE}));

		// RadioButton Controls
		RadioButton tmprdoGrp = (RadioButton)factory.getControl(RadioButton.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(0), ControlState.ENABLED, ControlState.DISABLED, ims.framework.enumerations.ControlAnchoring.TOPLEFT,Boolean.TRUE});
		super.addControl(tmprdoGrp);
		rdoGrpRadioButton rdoGrp = (rdoGrpRadioButton)RadioButtonBridgeFlyweightFactory.getInstance().createRadioButtonBridge(rdoGrpRadioButton.class, tmprdoGrp);
		rdoGrp.setContext(startTabIndex, designSize, runtimeSize);
		super.addRadioButton(rdoGrp);
	}



	public Forms getForms()
	{
		return (Forms)super.getFormReferences();
	}

	public Images getImages()
	{
		return (Images)super.getImageReferences();
	}
	public TreeView treConfig()
	{
		return (TreeView)super.getControl(0);
	}
	public rdoGrpRadioButton rdoGrp()
	{
		return (rdoGrpRadioButton)super.getRadioButton(0);
	}

	public static class Forms implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		protected final class LocalFormName extends FormName
		{
			private static final long serialVersionUID = 1L;
		
			private LocalFormName(int name)
			{
				super(name);
			}
		}

		private Forms()
		{
			Core = new CoreForms();
			ClinicalAdmin = new ClinicalAdminForms();
		}
		public final class CoreForms implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private CoreForms()
			{
				SpecialtyHotlistConfigurationDlg = new LocalFormName(102223);
			}
			public final FormName SpecialtyHotlistConfigurationDlg;
		}
		public final class ClinicalAdminForms implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private ClinicalAdminForms()
			{
				DiagnosisSpecialtyHotlistConfiguration = new LocalFormName(104114);
				ProblemSpecialtyHotlistConfiguration = new LocalFormName(104113);
				SpecialtyHotlistConfiguration = new LocalFormName(104111);
				CancerImagingSpecialtyHotlistConfiguration = new LocalFormName(104127);
			}
			public final FormName DiagnosisSpecialtyHotlistConfiguration;
			public final FormName ProblemSpecialtyHotlistConfiguration;
			public final FormName SpecialtyHotlistConfiguration;
			public final FormName CancerImagingSpecialtyHotlistConfiguration;
		}

		public CoreForms Core;
		public ClinicalAdminForms ClinicalAdmin;
	}


	public static class Images implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		private final class ImageHelper extends ims.framework.utils.ImagePath
		{
			private static final long serialVersionUID = 1L;
			
			private ImageHelper(int id, String path, Integer width, Integer height)
			{
				super(id, path, width, height);
			}
		}
		private Images()
		{
			Core = new CoreImages();
			Admin = new AdminImages();
		}
		public final class CoreImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private CoreImages()
			{
				BlueSquare = new ImageHelper(102121, "Images/Core/circle_blue.png", new Integer(16), new Integer(16));
				RedSqaure = new ImageHelper(102122, "Images/Core/circle_red.png", new Integer(16), new Integer(16));
				GreenSquare = new ImageHelper(102124, "Images/Core/circle_green.png", new Integer(16), new Integer(16));
			}
			public final ims.framework.utils.Image BlueSquare;
			public final ims.framework.utils.Image RedSqaure;
			public final ims.framework.utils.Image GreenSquare;
		}
		public final class AdminImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private AdminImages()
			{
				Function = new ImageHelper(103109, "Images/Admin/Function.gif", new Integer(16), new Integer(16));
				Service = new ImageHelper(103110, "Images/Admin/clinical_service.png", new Integer(16), new Integer(16));
			}
			public final ims.framework.utils.Image Function;
			public final ims.framework.utils.Image Service;
		}
		public final CoreImages Core;
		public final AdminImages Admin;
	}
	public GlobalContext getGlobalContext()
	{
		return this.globalContext;
	}
	public static class GlobalContextBridge extends ContextBridge
	{
		private static final long serialVersionUID = 1L;
	}
	public LocalContext getLocalContext()
	{
		return (LocalContext)super.getLocalCtx();
	}
	public class LocalContext extends ContextBridge
	{
		private static final long serialVersionUID = 1L;
		
		public LocalContext(Context context, ims.framework.FormInfo formInfo, String componentIdentifier)
		{
			super.setContext(context);
			String prefix = formInfo.getLocalVariablesPrefix();
			cxl_SelectedHotlist = new ims.framework.ContextVariable("SelectedHotlist", prefix + "_lv_ClinicalAdmin.SpecialtyHotlistConfiguration.__internal_x_context__SelectedHotlist_" + componentIdentifier + "");
			cxl_ConfiguredSpecialties = new ims.framework.ContextVariable("ConfiguredSpecialties", prefix + "_lv_ClinicalAdmin.SpecialtyHotlistConfiguration.__internal_x_context__ConfiguredSpecialties_" + componentIdentifier + "");
			cxl_SpecialtyLookup = new ims.framework.ContextVariable("SpecialtyLookup", prefix + "_lv_ClinicalAdmin.SpecialtyHotlistConfiguration.__internal_x_context__SpecialtyLookup_" + componentIdentifier + "");
			cxl_currentCciType = new ims.framework.ContextVariable("currentCciType", prefix + "_lv_ClinicalAdmin.SpecialtyHotlistConfiguration.__internal_x_context__currentCciType_" + componentIdentifier + "");
		}
		
		public boolean getSelectedHotlistIsNotNull()
		{
			return !cxl_SelectedHotlist.getValueIsNull(context);
		}
		public ims.vo.interfaces.IHotlist getSelectedHotlist()
		{
			return (ims.vo.interfaces.IHotlist)cxl_SelectedHotlist.getValue(context);
		}
		public void setSelectedHotlist(ims.vo.interfaces.IHotlist value)
		{
			cxl_SelectedHotlist.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SelectedHotlist = null;
		public boolean getConfiguredSpecialtiesIsNotNull()
		{
			return !cxl_ConfiguredSpecialties.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.ProcedureHotlistShortVoCollection getConfiguredSpecialties()
		{
			return (ims.clinicaladmin.vo.ProcedureHotlistShortVoCollection)cxl_ConfiguredSpecialties.getValue(context);
		}
		public void setConfiguredSpecialties(ims.clinicaladmin.vo.ProcedureHotlistShortVoCollection value)
		{
			cxl_ConfiguredSpecialties.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_ConfiguredSpecialties = null;
		public boolean getSpecialtyLookupIsNotNull()
		{
			return !cxl_SpecialtyLookup.getValueIsNull(context);
		}
		public ims.core.vo.lookups.SpecialtyCollection getSpecialtyLookup()
		{
			return (ims.core.vo.lookups.SpecialtyCollection)cxl_SpecialtyLookup.getValue(context);
		}
		public void setSpecialtyLookup(ims.core.vo.lookups.SpecialtyCollection value)
		{
			cxl_SpecialtyLookup.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SpecialtyLookup = null;
		public boolean getcurrentCciTypeIsNotNull()
		{
			return !cxl_currentCciType.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.enums.CciType getcurrentCciType()
		{
			return (ims.clinicaladmin.vo.enums.CciType)cxl_currentCciType.getValue(context);
		}
		public void setcurrentCciType(ims.clinicaladmin.vo.enums.CciType value)
		{
			cxl_currentCciType.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_currentCciType = null;
	}

	public final class ContextMenus implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public final class SpecialtyHotlistConfiguration implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			public static final int CONFIGURE = 1;
			public static final int MOVEUP = 2;
			public static final int MOVEDOWN = 3;
			public static final int REMOVE = 4;
		}
		public void disableAllSpecialtyHotlistConfigurationMenuItems()
		{
			this.contextMenuSpecialtyHotlistConfigurationCONFIGUREItem.setEnabled(false);
			this.contextMenuSpecialtyHotlistConfigurationMOVEUPItem.setEnabled(false);
			this.contextMenuSpecialtyHotlistConfigurationMOVEDOWNItem.setEnabled(false);
			this.contextMenuSpecialtyHotlistConfigurationREMOVEItem.setEnabled(false);
		}
		public void hideAllSpecialtyHotlistConfigurationMenuItems()
		{
			this.contextMenuSpecialtyHotlistConfigurationCONFIGUREItem.setVisible(false);
			this.contextMenuSpecialtyHotlistConfigurationMOVEUPItem.setVisible(false);
			this.contextMenuSpecialtyHotlistConfigurationMOVEDOWNItem.setVisible(false);
			this.contextMenuSpecialtyHotlistConfigurationREMOVEItem.setVisible(false);
		}
		private Menu contextMenuSpecialtyHotlistConfiguration;
		public MenuItem getSpecialtyHotlistConfigurationCONFIGUREItem()
		{
			return this.contextMenuSpecialtyHotlistConfigurationCONFIGUREItem;
		}
		private MenuItem contextMenuSpecialtyHotlistConfigurationCONFIGUREItem;
		public MenuItem getSpecialtyHotlistConfigurationMOVEUPItem()
		{
			return this.contextMenuSpecialtyHotlistConfigurationMOVEUPItem;
		}
		private MenuItem contextMenuSpecialtyHotlistConfigurationMOVEUPItem;
		public MenuItem getSpecialtyHotlistConfigurationMOVEDOWNItem()
		{
			return this.contextMenuSpecialtyHotlistConfigurationMOVEDOWNItem;
		}
		private MenuItem contextMenuSpecialtyHotlistConfigurationMOVEDOWNItem;
		public MenuItem getSpecialtyHotlistConfigurationREMOVEItem()
		{
			return this.contextMenuSpecialtyHotlistConfigurationREMOVEItem;
		}
		private MenuItem contextMenuSpecialtyHotlistConfigurationREMOVEItem;
	}

	private ContextMenus contextMenus;
	public ContextMenus getContextMenus()
	{
		return this.contextMenus;
	}

	private IReportField[] getFormReportFields()
	{
		if(this.context == null)
			return null;
		if(this.reportFields == null)
			this.reportFields = new ReportFields(this.context, this.formInfo, this.componentIdentifier).getReportFields();
		return this.reportFields;
	}
	private class ReportFields
	{
		public ReportFields(Context context, ims.framework.FormInfo formInfo, String componentIdentifier)
		{
			this.context = context;
			this.formInfo = formInfo;
			this.componentIdentifier = componentIdentifier;
		}
		public IReportField[] getReportFields()
		{
			String prefix = formInfo.getLocalVariablesPrefix();
			IReportField[] fields = new IReportField[71];
			fields[0] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ID", "ID_Patient");
			fields[1] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SEX", "Sex");
			fields[2] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DOB", "Dob");
			fields[3] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DOD", "Dod");
			fields[4] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-RELIGION", "Religion");
			fields[5] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ISACTIVE", "IsActive");
			fields[6] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ETHNICORIGIN", "EthnicOrigin");
			fields[7] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-MARITALSTATUS", "MaritalStatus");
			fields[8] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SCN", "SCN");
			fields[9] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SOURCEOFINFORMATION", "SourceOfInformation");
			fields[10] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-TIMEOFDEATH", "TimeOfDeath");
			fields[11] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ISQUICKREGISTRATIONPATIENT", "IsQuickRegistrationPatient");
			fields[12] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-CURRENTRESPONSIBLECONSULTANT", "CurrentResponsibleConsultant");
			fields[13] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-ID", "ID_Patient");
			fields[14] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-SEX", "Sex");
			fields[15] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-DOB", "Dob");
			fields[16] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ID", "ID_ClinicalContact");
			fields[17] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-SPECIALTY", "Specialty");
			fields[18] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CONTACTTYPE", "ContactType");
			fields[19] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-STARTDATETIME", "StartDateTime");
			fields[20] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ENDDATETIME", "EndDateTime");
			fields[21] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CARECONTEXT", "CareContext");
			fields[22] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ISCLINICALNOTECREATED", "IsClinicalNoteCreated");
			fields[23] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ID", "ID_Hcp");
			fields[24] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-HCPTYPE", "HcpType");
			fields[25] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISACTIVE", "IsActive");
			fields[26] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISHCPARESPONSIBLEHCP", "IsHCPaResponsibleHCP");
			fields[27] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISARESPONSIBLEEDCLINICIAN", "IsAResponsibleEDClinician");
			fields[28] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ID", "ID_CareContext");
			fields[29] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-CONTEXT", "Context");
			fields[30] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ORDERINGHOSPITAL", "OrderingHospital");
			fields[31] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ESTIMATEDDISCHARGEDATE", "EstimatedDischargeDate");
			fields[32] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-STARTDATETIME", "StartDateTime");
			fields[33] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ENDDATETIME", "EndDateTime");
			fields[34] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-LOCATIONTYPE", "LocationType");
			fields[35] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-RESPONSIBLEHCP", "ResponsibleHCP");
			fields[36] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ID", "ID_EpisodeOfCare");
			fields[37] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-CARESPELL", "CareSpell");
			fields[38] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-SPECIALTY", "Specialty");
			fields[39] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-RELATIONSHIP", "Relationship");
			fields[40] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-STARTDATE", "StartDate");
			fields[41] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ENDDATE", "EndDate");
			fields[42] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[43] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALNOTE", "ClinicalNote");
			fields[44] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTETYPE", "NoteType");
			fields[45] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-DISCIPLINE", "Discipline");
			fields[46] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALCONTACT", "ClinicalContact");
			fields[47] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISDERIVEDNOTE", "IsDerivedNote");
			fields[48] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEW", "ForReview");
			fields[49] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[50] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-REVIEWINGDATETIME", "ReviewingDateTime");
			fields[51] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISCORRECTED", "IsCorrected");
			fields[52] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISTRANSCRIBED", "IsTranscribed");
			fields[53] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-SOURCEOFNOTE", "SourceOfNote");
			fields[54] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-RECORDINGDATETIME", "RecordingDateTime");
			fields[55] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-INHOSPITALREPORT", "InHospitalReport");
			fields[56] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[57] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[58] = new ims.framework.ReportField(this.context, "_cvp_STHK.AvailableBedsListFilter", "BO-1014100009-ID", "ID_BedSpaceState");
			fields[59] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ID", "ID_PendingEmergencyAdmission");
			fields[60] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ADMISSIONSTATUS", "AdmissionStatus");
			fields[61] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ID", "ID_InpatientEpisode");
			fields[62] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ESTDISCHARGEDATE", "EstDischargeDate");
			fields[63] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[64] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEW", "ForReview");
			fields[65] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[66] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[67] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[68] = new ims.framework.ReportField(this.context, "_cvp_Core.PasEvent", "BO-1014100003-ID", "ID_PASEvent");
			fields[69] = new ims.framework.ReportField(this.context, "_cvp_Correspondence.CorrespondenceDetails", "BO-1052100001-ID", "ID_CorrespondenceDetails");
			fields[70] = new ims.framework.ReportField(this.context, "_cvp_CareUk.CatsReferral", "BO-1004100035-ID", "ID_CatsReferral");
			return fields;
		}
		protected Context context = null;
		protected ims.framework.FormInfo formInfo;
		protected String componentIdentifier;
	}
	public String getUniqueIdentifier()
	{
		return null;
	}
	private Context context = null;
	private ims.framework.FormInfo formInfo = null;
	private String componentIdentifier;
	private GlobalContext globalContext = null;
	private IReportField[] reportFields = null;
}
