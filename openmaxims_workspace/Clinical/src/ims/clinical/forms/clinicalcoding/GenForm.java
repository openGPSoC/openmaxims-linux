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

package ims.clinical.forms.clinicalcoding;

import ims.framework.*;
import ims.framework.controls.*;
import ims.framework.enumerations.*;
import ims.framework.utils.RuntimeAnchoring;

public class GenForm extends FormBridge
{
	private static final long serialVersionUID = 1L;

	protected void fireCustomControlValueChanged()
	{
		super.fireValueChanged();
	}
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
	public static class qmbCodingItemComboBox extends ComboBoxBridge
	{
		private static final long serialVersionUID = 1L;
		
		public void newRow(ims.vo.ValueObject value, String text)
		{
			super.control.newRow(value, text);
		}
		public void newRow(ims.vo.ValueObject value, String text, ims.framework.utils.Image image)
		{
			super.control.newRow(value, text, image);
		}
		public void newRow(ims.vo.ValueObject value, String text, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, textColor);
		}
		public void newRow(ims.vo.ValueObject value, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, image, textColor);
		}
		public boolean removeRow(ims.vo.ValueObject value)
		{
			return super.control.removeRow(value);
		}
		public ims.vo.ValueObject getValue()
		{
			return (ims.vo.ValueObject)super.control.getValue();
		}
		public void setValue(ims.vo.ValueObject value)
		{
			super.control.setValue(value);
		}
		public void setEditedText(String text)
		{
			super.control.setEditedText(text);
		}
		public String getEditedText()
		{
			return super.control.getEditedText();
		}
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

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(368, 64);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setFormReferences(FormReferencesFlyweightFactory.getInstance().create(Forms.class));
		super.setImageReferences(ImageReferencesFlyweightFactory.getInstance().create(Images.class));
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));
		super.setLocalContext(new LocalContext(context, form.getFormInfo(), componentIdentifier));


		// Label Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 8, 7, 82, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), ControlState.DISABLED, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Clinical Term:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 8, 34, 73, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), ControlState.DISABLED, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Description:", new Integer(1), null, new Integer(0)}));

		// TextBox Controls
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 112, 35, 240, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT);
		super.addControl(factory.getControl(TextBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), new Integer(startTabIndex.intValue() + 4), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT,Boolean.FALSE, new Integer(255), Boolean.TRUE, Boolean.FALSE, null, null, Boolean.FALSE, ims.framework.enumerations.CharacterCasing.NORMAL, ims.framework.enumerations.TextTrimming.NONE, "", ""}));

		// Query ComboBox Controls
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 112, 8, 192, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT);
		ComboBox m_qmbCodingItemTemp = (ComboBox)factory.getControl(ComboBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT,Boolean.TRUE, Boolean.TRUE, SortOrder.NONE, Boolean.TRUE, new Integer(1), null, Boolean.FALSE, new Integer(-1), Boolean.FALSE});
		addControl(m_qmbCodingItemTemp);
		qmbCodingItemComboBox qmbCodingItem = (qmbCodingItemComboBox)ComboBoxFlyweightFactory.getInstance().createComboBoxBridge(qmbCodingItemComboBox.class, m_qmbCodingItemTemp);
		super.addComboBox(qmbCodingItem);

		// Image Buttons Controls
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 324, 2, 28, 28, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		super.addControl(factory.getControl(ImageButton.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPRIGHT, this.getImages().Core.ZoomEnabled24, this.getImages().Core.ZoomDisabled24, "Search Taxonomy", Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null}));
	}



	public Forms getForms()
	{
		return (Forms)super.getFormReferences();
	}

	public Images getImages()
	{
		return (Images)super.getImageReferences();
	}
	public Label lblClinicaTerm()
	{
		return (Label)super.getControl(0);
	}
	public Label lblDescription()
	{
		return (Label)super.getControl(1);
	}
	public TextBox txtDescription()
	{
		return (TextBox)super.getControl(2);
	}
	public qmbCodingItemComboBox qmbCodingItem()
	{
		return (qmbCodingItemComboBox)super.getComboBox(0);
	}
	public ImageButton imbSearch()
	{
		return (ImageButton)super.getControl(4);
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
		}
		public final class CoreForms implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private CoreForms()
			{
				TaxonomySearch = new LocalFormName(104102);
			}
			public final FormName TaxonomySearch;
		}

		public CoreForms Core;
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
		}
		public final class CoreImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private CoreImages()
			{
				Search = new ImageHelper(102120, "Images/Core/bin.gif", new Integer(15), new Integer(15));
				ZoomDisabled24 = new ImageHelper(102516, "Images/Core/zoom_disabled_24.png", new Integer(24), new Integer(24));
				ZoomEnabled24 = new ImageHelper(102515, "Images/Core/zoom_enabled_24.png", new Integer(24), new Integer(24));
			}
			public final ims.framework.utils.Image Search;
			public final ims.framework.utils.Image ZoomDisabled24;
			public final ims.framework.utils.Image ZoomEnabled24;
		}
		public final CoreImages Core;
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
			cxl_CodingLookupType = new ims.framework.ContextVariable("CodingLookupType", prefix + "_lv_Clinical.ClinicalCoding.__internal_x_context__CodingLookupType_" + componentIdentifier + "");
			cxl_boolHotlist = new ims.framework.ContextVariable("boolHotlist", prefix + "_lv_Clinical.ClinicalCoding.__internal_x_context__boolHotlist_" + componentIdentifier + "");
			cxl_Specialty = new ims.framework.ContextVariable("Specialty", prefix + "_lv_Clinical.ClinicalCoding.__internal_x_context__Specialty_" + componentIdentifier + "");
			cxl_CodingItemTextSubmitted = new ims.framework.ContextVariable("CodingItemTextSubmitted", prefix + "_lv_Clinical.ClinicalCoding.__internal_x_context__CodingItemTextSubmitted_" + componentIdentifier + "");
			cxl_ParentEditing = new ims.framework.ContextVariable("ParentEditing", prefix + "_lv_Clinical.ClinicalCoding.__internal_x_context__ParentEditing_" + componentIdentifier + "");
			cxl_boolSearchAllSelected = new ims.framework.ContextVariable("boolSearchAllSelected", prefix + "_lv_Clinical.ClinicalCoding.__internal_x_context__boolSearchAllSelected_" + componentIdentifier + "");
			cxl_TaxonomyRestricted = new ims.framework.ContextVariable("TaxonomyRestricted", prefix + "_lv_Clinical.ClinicalCoding.__internal_x_context__TaxonomyRestricted_" + componentIdentifier + "");
			cxl_DisableNoTermFoundItem = new ims.framework.ContextVariable("DisableNoTermFoundItem", prefix + "_lv_Clinical.ClinicalCoding.__internal_x_context__DisableNoTermFoundItem_" + componentIdentifier + "");
			cxl_NoValueFound = new ims.framework.ContextVariable("NoValueFound", prefix + "_lv_Clinical.ClinicalCoding.__internal_x_context__NoValueFound_" + componentIdentifier + "");
			cxl_EnableDescriptionField = new ims.framework.ContextVariable("EnableDescriptionField", prefix + "_lv_Clinical.ClinicalCoding.__internal_x_context__EnableDescriptionField_" + componentIdentifier + "");
			cxl_CustomSearchProvider = new ims.framework.ContextVariable("CustomSearchProvider", prefix + "_lv_Clinical.ClinicalCoding.__internal_x_context__CustomSearchProvider_" + componentIdentifier + "");
		}
		
		public boolean getCodingLookupTypeIsNotNull()
		{
			return !cxl_CodingLookupType.getValueIsNull(context);
		}
		public ims.clinical.vo.lookups.CodingItemType getCodingLookupType()
		{
			return (ims.clinical.vo.lookups.CodingItemType)cxl_CodingLookupType.getValue(context);
		}
		public void setCodingLookupType(ims.clinical.vo.lookups.CodingItemType value)
		{
			cxl_CodingLookupType.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_CodingLookupType = null;
		public boolean getboolHotlistIsNotNull()
		{
			return !cxl_boolHotlist.getValueIsNull(context);
		}
		public Boolean getboolHotlist()
		{
			return (Boolean)cxl_boolHotlist.getValue(context);
		}
		public void setboolHotlist(Boolean value)
		{
			cxl_boolHotlist.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_boolHotlist = null;
		public boolean getSpecialtyIsNotNull()
		{
			return !cxl_Specialty.getValueIsNull(context);
		}
		public ims.core.vo.lookups.Specialty getSpecialty()
		{
			return (ims.core.vo.lookups.Specialty)cxl_Specialty.getValue(context);
		}
		public void setSpecialty(ims.core.vo.lookups.Specialty value)
		{
			cxl_Specialty.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_Specialty = null;
		public boolean getCodingItemTextSubmittedIsNotNull()
		{
			return !cxl_CodingItemTextSubmitted.getValueIsNull(context);
		}
		public String getCodingItemTextSubmitted()
		{
			return (String)cxl_CodingItemTextSubmitted.getValue(context);
		}
		public void setCodingItemTextSubmitted(String value)
		{
			cxl_CodingItemTextSubmitted.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_CodingItemTextSubmitted = null;
		public boolean getParentEditingIsNotNull()
		{
			return !cxl_ParentEditing.getValueIsNull(context);
		}
		public Boolean getParentEditing()
		{
			return (Boolean)cxl_ParentEditing.getValue(context);
		}
		public void setParentEditing(Boolean value)
		{
			cxl_ParentEditing.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_ParentEditing = null;
		public boolean getboolSearchAllSelectedIsNotNull()
		{
			return !cxl_boolSearchAllSelected.getValueIsNull(context);
		}
		public Boolean getboolSearchAllSelected()
		{
			return (Boolean)cxl_boolSearchAllSelected.getValue(context);
		}
		public void setboolSearchAllSelected(Boolean value)
		{
			cxl_boolSearchAllSelected.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_boolSearchAllSelected = null;
		public boolean getTaxonomyRestrictedIsNotNull()
		{
			return !cxl_TaxonomyRestricted.getValueIsNull(context);
		}
		public Boolean getTaxonomyRestricted()
		{
			return (Boolean)cxl_TaxonomyRestricted.getValue(context);
		}
		public void setTaxonomyRestricted(Boolean value)
		{
			cxl_TaxonomyRestricted.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_TaxonomyRestricted = null;
		public boolean getDisableNoTermFoundItemIsNotNull()
		{
			return !cxl_DisableNoTermFoundItem.getValueIsNull(context);
		}
		public Boolean getDisableNoTermFoundItem()
		{
			return (Boolean)cxl_DisableNoTermFoundItem.getValue(context);
		}
		public void setDisableNoTermFoundItem(Boolean value)
		{
			cxl_DisableNoTermFoundItem.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_DisableNoTermFoundItem = null;
		public boolean getNoValueFoundIsNotNull()
		{
			return !cxl_NoValueFound.getValueIsNull(context);
		}
		public Boolean getNoValueFound()
		{
			return (Boolean)cxl_NoValueFound.getValue(context);
		}
		public void setNoValueFound(Boolean value)
		{
			cxl_NoValueFound.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_NoValueFound = null;
		public boolean getEnableDescriptionFieldIsNotNull()
		{
			return !cxl_EnableDescriptionField.getValueIsNull(context);
		}
		public Boolean getEnableDescriptionField()
		{
			return (Boolean)cxl_EnableDescriptionField.getValue(context);
		}
		public void setEnableDescriptionField(Boolean value)
		{
			cxl_EnableDescriptionField.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_EnableDescriptionField = null;
		public boolean getCustomSearchProviderIsNotNull()
		{
			return !cxl_CustomSearchProvider.getValueIsNull(context);
		}
		public ims.clinical.forms.clinicalcoding.Logic.IClinicalCodingCustomHotlistProvider getCustomSearchProvider()
		{
			return (ims.clinical.forms.clinicalcoding.Logic.IClinicalCodingCustomHotlistProvider)cxl_CustomSearchProvider.getValue(context);
		}
		public void setCustomSearchProvider(ims.clinical.forms.clinicalcoding.Logic.IClinicalCodingCustomHotlistProvider value)
		{
			cxl_CustomSearchProvider.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_CustomSearchProvider = null;
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
			IReportField[] fields = new IReportField[74];
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
			fields[71] = new ims.framework.ReportField(this.context, "_cv_Core.TaxonomyMap", "BO-1003100010-ID", "ID_TaxonomyMap");
			fields[72] = new ims.framework.ReportField(this.context, "_cv_Core.TaxonomyMap", "BO-1003100010-TAXONOMYNAME", "TaxonomyName");
			fields[73] = new ims.framework.ReportField(this.context, "_cv_Core.TaxonomyMap", "BO-1003100010-TAXONOMYCODE", "TaxonomyCode");
			return fields;
		}
		protected Context context = null;
		protected ims.framework.FormInfo formInfo;
		protected String componentIdentifier;
	}
	public String getUniqueIdentifier()
	{
		return formInfo.getLocalVariablesPrefix() + formInfo.getNamespaceName() + formInfo.getFormName() + formInfo.getFormId() + "_" + this.componentIdentifier;
	}
	private Context context = null;
	private ims.framework.FormInfo formInfo = null;
	private String componentIdentifier;
	private GlobalContext globalContext = null;
	private IReportField[] reportFields = null;
}
