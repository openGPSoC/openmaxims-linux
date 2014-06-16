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

package ims.emergency.forms.specialinterest;

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
	public static class ctnDetailsContainer extends ContainerBridge
	{
		private static final long serialVersionUID = 1L;
		public static class cmbSpecialInterestCategoryComboBox extends ComboBoxBridge
		{
			private static final long serialVersionUID = 1L;
			
			public void newRow(ims.correspondence.vo.lookups.SpecialInterestType value, String text)
			{
				super.control.newRow(value, text);
			}
			public void newRow(ims.correspondence.vo.lookups.SpecialInterestType value, String text, ims.framework.utils.Image image)
			{
				super.control.newRow(value, text, image);
			}
			public void newRow(ims.correspondence.vo.lookups.SpecialInterestType value, String text, ims.framework.utils.Color textColor)
			{
				super.control.newRow(value, text, textColor);
			}
			public void newRow(ims.correspondence.vo.lookups.SpecialInterestType value, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
			{
				super.control.newRow(value, text, image, textColor);
			}
			public boolean removeRow(ims.correspondence.vo.lookups.SpecialInterestType value)
			{
				return super.control.removeRow(value);
			}
			public ims.correspondence.vo.lookups.SpecialInterestType getValue()
			{
				return (ims.correspondence.vo.lookups.SpecialInterestType)super.control.getValue();
			}
			public void setValue(ims.correspondence.vo.lookups.SpecialInterestType value)
			{
				super.control.setValue(value);
			}
		}
		protected void setContext(Form form, ims.framework.interfaces.IAppForm appForm, Control control, FormLoader loader, Images form_images_local, ContextMenus contextMenus, Integer startControlID, ims.framework.utils.SizeInfo designSize, ims.framework.utils.SizeInfo runtimeSize, Integer startTabIndex, boolean skipContextValidation) throws Exception
		{
			if(form == null)
				throw new RuntimeException("Invalid form");
			if(appForm == null)
				throw new RuntimeException("Invalid application form");
			if(control == null); // this is to avoid eclipse warning only.
			if(loader == null); // this is to avoid eclipse warning only.
			if(form_images_local == null); // this is to avoid eclipse warning only.
			if(contextMenus == null); // this is to avoid eclipse warning only.
			if(startControlID == null)
				throw new RuntimeException("Invalid startControlID");
			if(designSize == null); // this is to avoid eclipse warning only.
			if(runtimeSize == null); // this is to avoid eclipse warning only.
			if(startTabIndex == null)
				throw new RuntimeException("Invalid startTabIndex");
	
	
			// Label Controls
			RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 12, 59, 60, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
			super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "End Date:", new Integer(1), null, new Integer(0)}));
			RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 12, 34, 67, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
			super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Start Date:", new Integer(1), null, new Integer(0)}));
			RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 12, 10, 153, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
			super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Special Interest Category:", new Integer(1), null, new Integer(0)}));
	
			// Date Time Controls
			RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 169, 57, 264, 20, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT);
			super.addControl(factory.getControl(DateTimeControl.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), new Integer(startTabIndex.intValue() + 5), ControlState.DISABLED, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT,Boolean.TRUE, null, Boolean.FALSE, null, Boolean.FALSE, null}));
			RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 169, 32, 264, 20, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT);
			super.addControl(factory.getControl(DateTimeControl.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), new Integer(startTabIndex.intValue() + 4), ControlState.DISABLED, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT,Boolean.TRUE, null, Boolean.FALSE, null, Boolean.TRUE, null}));
	
			// ComboBox Controls
			RuntimeAnchoring anchoringHelper6 = new RuntimeAnchoring(designSize, runtimeSize, 169, 8, 264, 21, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT);
			ComboBox m_cmbSpecialInterestCategoryTemp = (ComboBox)factory.getControl(ComboBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1005), new Integer(anchoringHelper6.getX()), new Integer(anchoringHelper6.getY()), new Integer(anchoringHelper6.getWidth()), new Integer(anchoringHelper6.getHeight()), new Integer(startTabIndex.intValue() + 3), ControlState.DISABLED, ControlState.ENABLED,ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT ,Boolean.TRUE, Boolean.FALSE, SortOrder.NONE, Boolean.FALSE, new Integer(1), null, Boolean.FALSE, new Integer(-1)});
			addControl(m_cmbSpecialInterestCategoryTemp);
			cmbSpecialInterestCategoryComboBox cmbSpecialInterestCategory = (cmbSpecialInterestCategoryComboBox)ComboBoxFlyweightFactory.getInstance().createComboBoxBridge(cmbSpecialInterestCategoryComboBox.class, m_cmbSpecialInterestCategoryTemp);
			super.addComboBox(cmbSpecialInterestCategory);
		}
		protected void setCollapsed(boolean value)
		{
			super.container.setCollapsed(value);
		}
		//protected boolean isCollapsed()
		//{
			//return super.container.isCollapsed();
		//}
		protected void setCaption(String value)
		{
			super.container.setCaption(value);
		}
		public DateTimeControl dtimEndDate()
		{
			return (DateTimeControl)super.getControl(3);
		}
		public DateTimeControl dtimStartDate()
		{
			return (DateTimeControl)super.getControl(4);
		}
		public cmbSpecialInterestCategoryComboBox cmbSpecialInterestCategory()
		{
			return (cmbSpecialInterestCategoryComboBox)super.getComboBox(0);
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

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(480, 408);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setImageReferences(ImageReferencesFlyweightFactory.getInstance().create(Images.class));
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));
		super.setLocalContext(new LocalContext(context, form.getFormInfo(), componentIdentifier));

		// Context Menus
		contextMenus = new ContextMenus();
		contextMenus.Emergency.contextMenuSpecialInterest = factory.createMenu(startControlID.intValue() + 1);
		contextMenus.Emergency.contextMenuSpecialInterestADDItem = factory.createMenuItem(startControlID.intValue() + 1, "New", true, false, new Integer(102179), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(4620001)))
			contextMenus.Emergency.contextMenuSpecialInterest.add(contextMenus.Emergency.contextMenuSpecialInterestADDItem);
		contextMenus.Emergency.contextMenuSpecialInterestEDITItem = factory.createMenuItem(startControlID.intValue() + 2, "Edit", true, false, new Integer(102150), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(4620002)))
			contextMenus.Emergency.contextMenuSpecialInterest.add(contextMenus.Emergency.contextMenuSpecialInterestEDITItem);
		contextMenus.Emergency.contextMenuSpecialInterestREMOVEItem = factory.createMenuItem(startControlID.intValue() + 3, "Remove", true, false, new Integer(102148), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(4620003)))
			contextMenus.Emergency.contextMenuSpecialInterest.add(contextMenus.Emergency.contextMenuSpecialInterestREMOVEItem);
		form.registerMenu(contextMenus.Emergency.contextMenuSpecialInterest);


		// Container Clasess
		RuntimeAnchoring anchoringHelper7 = new RuntimeAnchoring(designSize, runtimeSize, 8, 264, 464, 104, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT);
		Container m_ctnDetails = (Container)factory.getControl(Container.class, new Object[] { control, new Integer(startControlID.intValue() + 1006), new Integer(anchoringHelper7.getX()), new Integer(anchoringHelper7.getY()), new Integer(anchoringHelper7.getWidth()), new Integer(anchoringHelper7.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT, "Special Interest Details", new Boolean(true)});
		addControl(m_ctnDetails);
		ctnDetailsContainer ctnDetails = (ctnDetailsContainer)ContainerBridgeFlyweightFactory.getInstance().createContainerBridge(ctnDetailsContainer.class, m_ctnDetails, factory);
		ims.framework.utils.SizeInfo m_ctnDetailsDesignSize = new ims.framework.utils.SizeInfo(464, 104);
		ims.framework.utils.SizeInfo m_ctnDetailsRuntimeSize = new ims.framework.utils.SizeInfo(anchoringHelper7.getWidth(), anchoringHelper7.getHeight());
		ctnDetails.setContext(form, appForm, m_ctnDetails, loader, this.getImages(), contextMenus, startControlID, m_ctnDetailsDesignSize, m_ctnDetailsRuntimeSize, startTabIndex, skipContextValidation);
		super.addContainer(ctnDetails);

		// Button Controls
		RuntimeAnchoring anchoringHelper8 = new RuntimeAnchoring(designSize, runtimeSize, 392, 376, 80, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1007), new Integer(anchoringHelper8.getX()), new Integer(anchoringHelper8.getY()), new Integer(anchoringHelper8.getWidth()), new Integer(anchoringHelper8.getHeight()), new Integer(startTabIndex.intValue() + 13), ControlState.ENABLED, ControlState.HIDDEN, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Close", Boolean.FALSE, null, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper9 = new RuntimeAnchoring(designSize, runtimeSize, 392, 376, 80, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1008), new Integer(anchoringHelper9.getX()), new Integer(anchoringHelper9.getY()), new Integer(anchoringHelper9.getWidth()), new Integer(anchoringHelper9.getHeight()), new Integer(startTabIndex.intValue() + 12), ControlState.HIDDEN, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Cancel", Boolean.FALSE, null, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper10 = new RuntimeAnchoring(designSize, runtimeSize, 311, 376, 80, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1009), new Integer(anchoringHelper10.getX()), new Integer(anchoringHelper10.getY()), new Integer(anchoringHelper10.getWidth()), new Integer(anchoringHelper10.getHeight()), new Integer(startTabIndex.intValue() + 10), ControlState.HIDDEN, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "OK", Boolean.TRUE, null, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper11 = new RuntimeAnchoring(designSize, runtimeSize, 8, 376, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1010), new Integer(anchoringHelper11.getX()), new Integer(anchoringHelper11.getY()), new Integer(anchoringHelper11.getWidth()), new Integer(anchoringHelper11.getHeight()), new Integer(startTabIndex.intValue() + 6), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT, "New", Boolean.TRUE, null, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper12 = new RuntimeAnchoring(designSize, runtimeSize, 88, 376, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1011), new Integer(anchoringHelper12.getX()), new Integer(anchoringHelper12.getY()), new Integer(anchoringHelper12.getWidth()), new Integer(anchoringHelper12.getHeight()), new Integer(startTabIndex.intValue() + 8), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT, "Edit", Boolean.TRUE, null, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// Dynamic Grid Controls
		RuntimeAnchoring anchoringHelper13 = new RuntimeAnchoring(designSize, runtimeSize, 8, 8, 432, 248, ims.framework.enumerations.ControlAnchoring.ALL);
		super.addControl(factory.getControl(DynamicGrid.class, new Object[] { control, new Integer(startControlID.intValue() + 1012), new Integer(anchoringHelper13.getX()), new Integer(anchoringHelper13.getY()), new Integer(anchoringHelper13.getWidth()), new Integer(anchoringHelper13.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.READONLY, ControlState.DISABLED, ims.framework.enumerations.ControlAnchoring.ALL, contextMenus.Emergency.contextMenuSpecialInterest, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE}));

		// Image Buttons Controls
		RuntimeAnchoring anchoringHelper14 = new RuntimeAnchoring(designSize, runtimeSize, 444, 8, 28, 28, ims.framework.enumerations.ControlAnchoring.TOPRIGHT);
		super.addControl(factory.getControl(ImageButton.class, new Object[] { control, new Integer(startControlID.intValue() + 1013), new Integer(anchoringHelper14.getX()), new Integer(anchoringHelper14.getY()), new Integer(anchoringHelper14.getWidth()), new Integer(anchoringHelper14.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPRIGHT, this.getImages().Core.Delete, this.getImages().Core.DeleteDisabled, "Remove Special Interest", Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null}));
	}



	public Images getImages()
	{
		return (Images)super.getImageReferences();
	}
	public ctnDetailsContainer ctnDetails()
	{
		return (ctnDetailsContainer)super.getContainer(0);
	}
	public Button btnClose()
	{
		return (Button)super.getControl(1);
	}
	public Button btnCancel()
	{
		return (Button)super.getControl(2);
	}
	public Button btnSave()
	{
		return (Button)super.getControl(3);
	}
	public Button btnNew()
	{
		return (Button)super.getControl(4);
	}
	public Button btnEdit()
	{
		return (Button)super.getControl(5);
	}
	public DynamicGrid dyngrdSpecialInterest()
	{
		return (DynamicGrid)super.getControl(6);
	}
	public ImageButton imbRemove()
	{
		return (ImageButton)super.getControl(7);
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
				AddFile16 = new ImageHelper(102330, "Images/Core/add-file_16x16.png", new Integer(16), new Integer(16));
				AddFile16Disable = new ImageHelper(102565, "Images/Core/add-fileDisable_16x16.png", new Integer(16), new Integer(16));
				Delete = new ImageHelper(102148, "Images/Core/delete.png", new Integer(16), new Integer(16));
				DeleteDisabled = new ImageHelper(102177, "Images/Core/delete_dis.png", new Integer(16), new Integer(16));
				Edit = new ImageHelper(102150, "Images/Core/Edit16.gif", new Integer(16), new Integer(16));
				EditDisabled = new ImageHelper(102178, "Images/Core/EditDisabled16.gif", new Integer(16), new Integer(16));
			}
			public final ims.framework.utils.Image AddFile16;
			public final ims.framework.utils.Image AddFile16Disable;
			public final ims.framework.utils.Image Delete;
			public final ims.framework.utils.Image DeleteDisabled;
			public final ims.framework.utils.Image Edit;
			public final ims.framework.utils.Image EditDisabled;
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
			cxl_SelectedSpecialInterest = new ims.framework.ContextVariable("SelectedSpecialInterest", prefix + "_lv_Emergency.SpecialInterest.__internal_x_context__SelectedSpecialInterest_" + componentIdentifier + "");
			cxl_FormIsReadOnly = new ims.framework.ContextVariable("FormIsReadOnly", prefix + "_lv_Emergency.SpecialInterest.__internal_x_context__FormIsReadOnly_" + componentIdentifier + "");
		}
		
		public boolean getSelectedSpecialInterestIsNotNull()
		{
			return !cxl_SelectedSpecialInterest.getValueIsNull(context);
		}
		public ims.emergency.vo.SpecialInterestDetailsVo getSelectedSpecialInterest()
		{
			return (ims.emergency.vo.SpecialInterestDetailsVo)cxl_SelectedSpecialInterest.getValue(context);
		}
		public void setSelectedSpecialInterest(ims.emergency.vo.SpecialInterestDetailsVo value)
		{
			cxl_SelectedSpecialInterest.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SelectedSpecialInterest = null;
		public boolean getFormIsReadOnlyIsNotNull()
		{
			return !cxl_FormIsReadOnly.getValueIsNull(context);
		}
		public Boolean getFormIsReadOnly()
		{
			return (Boolean)cxl_FormIsReadOnly.getValue(context);
		}
		public void setFormIsReadOnly(Boolean value)
		{
			cxl_FormIsReadOnly.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_FormIsReadOnly = null;
	}

	public final class ContextMenus implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public EmergencyNamespace Emergency = new EmergencyNamespace();
		public final class EmergencyNamespace implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			public final class SpecialInterest implements java.io.Serializable
			{
				private static final long serialVersionUID = 1L;
				public static final int ADD = 1;
				public static final int EDIT = 2;
				public static final int REMOVE = 3;
			}
			public void disableAllSpecialInterestMenuItems()
			{
				this.contextMenuSpecialInterestADDItem.setEnabled(false);
				this.contextMenuSpecialInterestEDITItem.setEnabled(false);
				this.contextMenuSpecialInterestREMOVEItem.setEnabled(false);
			}
			public void hideAllSpecialInterestMenuItems()
			{
				this.contextMenuSpecialInterestADDItem.setVisible(false);
				this.contextMenuSpecialInterestEDITItem.setVisible(false);
				this.contextMenuSpecialInterestREMOVEItem.setVisible(false);
			}
			private Menu contextMenuSpecialInterest;
			public ReadOnlyMenuItem getSpecialInterestADDItem()
			{
				return this.contextMenuSpecialInterestADDItem;
			}
			private MenuItem contextMenuSpecialInterestADDItem;
			public ReadOnlyMenuItem getSpecialInterestEDITItem()
			{
				return this.contextMenuSpecialInterestEDITItem;
			}
			private MenuItem contextMenuSpecialInterestEDITItem;
			public ReadOnlyMenuItem getSpecialInterestREMOVEItem()
			{
				return this.contextMenuSpecialInterestREMOVEItem;
			}
			private MenuItem contextMenuSpecialInterestREMOVEItem;
		}
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
			IReportField[] fields = new IReportField[78];
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
			fields[71] = new ims.framework.ReportField(this.context, prefix + "_lv_Emergency.SpecialInterest.__internal_x_context__SelectedSpecialInterest_" + componentIdentifier, "BO-1086100024-ID", "ID_SpecialInterestDetail");
			fields[72] = new ims.framework.ReportField(this.context, prefix + "_lv_Emergency.SpecialInterest.__internal_x_context__SelectedSpecialInterest_" + componentIdentifier, "BO-1086100024-PATIENT", "Patient");
			fields[73] = new ims.framework.ReportField(this.context, prefix + "_lv_Emergency.SpecialInterest.__internal_x_context__SelectedSpecialInterest_" + componentIdentifier, "BO-1086100024-EPISODE", "Episode");
			fields[74] = new ims.framework.ReportField(this.context, prefix + "_lv_Emergency.SpecialInterest.__internal_x_context__SelectedSpecialInterest_" + componentIdentifier, "BO-1086100024-ATTENDANCE", "Attendance");
			fields[75] = new ims.framework.ReportField(this.context, prefix + "_lv_Emergency.SpecialInterest.__internal_x_context__SelectedSpecialInterest_" + componentIdentifier, "BO-1086100024-STARTDATETIME", "StartDateTime");
			fields[76] = new ims.framework.ReportField(this.context, prefix + "_lv_Emergency.SpecialInterest.__internal_x_context__SelectedSpecialInterest_" + componentIdentifier, "BO-1086100024-COMPLETEDDATETIME", "CompletedDateTime");
			fields[77] = new ims.framework.ReportField(this.context, prefix + "_lv_Emergency.SpecialInterest.__internal_x_context__SelectedSpecialInterest_" + componentIdentifier, "BO-1086100024-SPECIALINTERESTCATEGORY", "SpecialInterestCategory");
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
