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

package ims.clinicaladmin.forms.selectprognosticriskassessment;

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
	public static class ctn1Container extends ContainerBridge
	{
		private static final long serialVersionUID = 1L;
		protected void setContext(Form form, ims.framework.interfaces.IAppForm appForm, Control control, FormLoader loader, ContextMenus contextMenus, Integer startControlID, ims.framework.utils.SizeInfo designSize, ims.framework.utils.SizeInfo runtimeSize, Integer startTabIndex, boolean skipContextValidation) throws Exception
		{
			if(form == null)
				throw new RuntimeException("Invalid form");
			if(appForm == null)
				throw new RuntimeException("Invalid application form");
			if(control == null); // this is to avoid eclipse warning only.
			if(loader == null); // this is to avoid eclipse warning only.
			if(contextMenus == null); // this is to avoid eclipse warning only.
			if(startControlID == null)
				throw new RuntimeException("Invalid startControlID");
			if(designSize == null); // this is to avoid eclipse warning only.
			if(runtimeSize == null); // this is to avoid eclipse warning only.
			if(startTabIndex == null)
				throw new RuntimeException("Invalid startTabIndex");
	
	
			// Label Controls
			RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 16, 40, 73, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
			super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Description:", new Integer(1), null, new Integer(0)}));
			RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 16, 16, 40, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
			super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Value:", new Integer(1), null, new Integer(0)}));
	
			// TextBox Controls
			RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 96, 40, 560, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
			super.addControl(factory.getControl(TextBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), new Integer(startTabIndex.intValue() + 3), ControlState.DISABLED, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.TOPLEFT,Boolean.FALSE, new Integer(100), Boolean.TRUE, Boolean.FALSE, null, null, Boolean.TRUE, ims.framework.enumerations.CharacterCasing.NORMAL, ims.framework.enumerations.TextTrimming.NONE, "", ""}));
			RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 96, 16, 560, 21, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
			super.addControl(factory.getControl(TextBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.DISABLED, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.TOPLEFT,Boolean.FALSE, new Integer(30), Boolean.TRUE, Boolean.FALSE, null, null, Boolean.TRUE, ims.framework.enumerations.CharacterCasing.NORMAL, ims.framework.enumerations.TextTrimming.NONE, "", ""}));
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
		public TextBox txtDescription()
		{
			return (TextBox)super.getControl(2);
		}
		public TextBox txtValue()
		{
			return (TextBox)super.getControl(3);
		}
	}
	public static class grdRecordsRow extends GridRowBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected grdRecordsRow(GridRow row)
		{
			super(row);
		}
		public void showOpened(int column)
		{
			super.row.showOpened(column);
		}
		public void setCoValueReadOnly(boolean value)
		{
			super.row.setReadOnly(0, value);
		}
		public boolean isCoValueReadOnly()
		{
			return super.row.isReadOnly(0);
		}
		public void showCoValueOpened()
		{
			super.row.showOpened(0);
		}
		public String getCoValue()
		{
			return (String)super.row.get(0);
		}
		public void setCoValue(String value)
		{
			super.row.set(0, value);
		}
		public void setCellCoValueTooltip(String value)
		{
			super.row.setTooltip(0, value);
		}
		public void setColDescriptionReadOnly(boolean value)
		{
			super.row.setReadOnly(1, value);
		}
		public boolean isColDescriptionReadOnly()
		{
			return super.row.isReadOnly(1);
		}
		public void showColDescriptionOpened()
		{
			super.row.showOpened(1);
		}
		public String getColDescription()
		{
			return (String)super.row.get(1);
		}
		public void setColDescription(String value)
		{
			super.row.set(1, value);
		}
		public void setCellColDescriptionTooltip(String value)
		{
			super.row.setTooltip(1, value);
		}
		public ims.clinicaladmin.vo.PrognosticRiskConfigVo getValue()
		{
			return (ims.clinicaladmin.vo.PrognosticRiskConfigVo)super.row.getValue();
		}
		public void setValue(ims.clinicaladmin.vo.PrognosticRiskConfigVo value)
		{
			super.row.setValue(value);
		}
	}
	public static class grdRecordsRowCollection extends GridRowCollectionBridge
	{
		private static final long serialVersionUID = 1L;
		
		private grdRecordsRowCollection(GridRowCollection collection)
		{
			super(collection);
		}
		public grdRecordsRow get(int index)
		{
			return new grdRecordsRow(super.collection.get(index));
		}
		public grdRecordsRow newRow()
		{
			return new grdRecordsRow(super.collection.newRow());
		}
		public grdRecordsRow newRow(boolean autoSelect)
		{
			return new grdRecordsRow(super.collection.newRow(autoSelect));
		}
		public grdRecordsRow newRowAt(int index)
		{
			return new grdRecordsRow(super.collection.newRowAt(index));
		}
		public grdRecordsRow newRowAt(int index, boolean autoSelect)
		{
			return new grdRecordsRow(super.collection.newRowAt(index, autoSelect));
		}
	}
	public static class grdRecordsGrid extends GridBridge
	{
		private static final long serialVersionUID = 1L;
		
		private void addStringColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean bold, int sortOrder, int maxLength, boolean canGrow, ims.framework.enumerations.CharacterCasing casing)
		{
			super.grid.addStringColumn(caption, captionAlignment, alignment, width, readOnly, bold, sortOrder, maxLength, canGrow, casing);
		}
		public ims.clinicaladmin.vo.PrognosticRiskConfigVoCollection getValues()
		{
			ims.clinicaladmin.vo.PrognosticRiskConfigVoCollection listOfValues = new ims.clinicaladmin.vo.PrognosticRiskConfigVoCollection();
			for(int x = 0; x < this.getRows().size(); x++)
			{
				listOfValues.add(this.getRows().get(x).getValue());
			}
			return listOfValues;
		}
		public ims.clinicaladmin.vo.PrognosticRiskConfigVo getValue()
		{
			return (ims.clinicaladmin.vo.PrognosticRiskConfigVo)super.grid.getValue();
		}
		public void setValue(ims.clinicaladmin.vo.PrognosticRiskConfigVo value)
		{
			super.grid.setValue(value);
		}
		public grdRecordsRow getSelectedRow()
		{
			return super.grid.getSelectedRow() == null ? null : new grdRecordsRow(super.grid.getSelectedRow());
		}
		public int getSelectedRowIndex()
		{
			return super.grid.getSelectedRowIndex();
		}
		public grdRecordsRowCollection getRows()
		{
			return new grdRecordsRowCollection(super.grid.getRows());
		}
		public grdRecordsRow getRowByValue(ims.clinicaladmin.vo.PrognosticRiskConfigVo value)
		{
			GridRow row = super.grid.getRowByValue(value);
			return row == null?null:new grdRecordsRow(row);
		}
		public void setCoValueHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(0, value);
		}
		public String getCoValueHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(0);
		}
		public void setColDescriptionHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(1, value);
		}
		public String getColDescriptionHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(1);
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

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(688, 488);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));
		super.setLocalContext(new LocalContext(context, form.getFormInfo(), componentIdentifier));

		// Context Menus
		contextMenus = new ContextMenus();
		contextMenus.contextMenuGenericGrid = factory.createMenu(startControlID.intValue() + 1);
		contextMenus.contextMenuGenericGridAddItem = factory.createMenuItem(startControlID.intValue() + 1, "New", true, false, new Integer(102179), true, false);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridAddItem);
		contextMenus.contextMenuGenericGridUpdateItem = factory.createMenuItem(startControlID.intValue() + 2, "Edit", true, false, new Integer(102150), true, false);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridUpdateItem);
		contextMenus.contextMenuGenericGridRemoveItem = factory.createMenuItem(startControlID.intValue() + 3, "Remove", true, false, new Integer(102148), true, false);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridRemoveItem);
		contextMenus.contextMenuGenericGridViewItem = factory.createMenuItem(startControlID.intValue() + 4, "View", true, false, new Integer(102223), false, true);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridViewItem);
		contextMenus.contextMenuGenericGridMoveUpItem = factory.createMenuItem(startControlID.intValue() + 5, "Move Up", true, false, new Integer(102197), true, true);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridMoveUpItem);
		contextMenus.contextMenuGenericGridMoveDownItem = factory.createMenuItem(startControlID.intValue() + 6, "Move Down", true, false, new Integer(102198), true, false);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridMoveDownItem);
		contextMenus.contextMenuGenericGridReplaceItem = factory.createMenuItem(startControlID.intValue() + 7, "Replace", true, false, new Integer(102255), true, true);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridReplaceItem);
		contextMenus.contextMenuGenericGridConfirmItem = factory.createMenuItem(startControlID.intValue() + 8, "Confirm", true, false, new Integer(102209), true, false);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridConfirmItem);
		contextMenus.contextMenuGenericGridEDIT_VIEW_ICP_ACTIONSItem = factory.createMenuItem(startControlID.intValue() + 9, "Edit/View ICP action(s)", true, false, new Integer(118107), true, false);
		contextMenus.contextMenuGenericGrid.add(contextMenus.contextMenuGenericGridEDIT_VIEW_ICP_ACTIONSItem);
		form.registerMenu(contextMenus.contextMenuGenericGrid);


		// Container Clasess
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 8, 360, 672, 88, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT);
		Container m_ctn1 = (Container)factory.getControl(Container.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT, "Details", new Boolean(true)});
		addControl(m_ctn1);
		ctn1Container ctn1 = (ctn1Container)ContainerBridgeFlyweightFactory.getInstance().createContainerBridge(ctn1Container.class, m_ctn1, factory);
		ims.framework.utils.SizeInfo m_ctn1DesignSize = new ims.framework.utils.SizeInfo(672, 88);
		ims.framework.utils.SizeInfo m_ctn1RuntimeSize = new ims.framework.utils.SizeInfo(anchoringHelper5.getWidth(), anchoringHelper5.getHeight());
		ctn1.setContext(form, appForm, m_ctn1, loader, contextMenus, startControlID, m_ctn1DesignSize, m_ctn1RuntimeSize, startTabIndex, skipContextValidation);
		super.addContainer(ctn1);

		// Button Controls
		RuntimeAnchoring anchoringHelper6 = new RuntimeAnchoring(designSize, runtimeSize, 608, 456, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1005), new Integer(anchoringHelper6.getX()), new Integer(anchoringHelper6.getY()), new Integer(anchoringHelper6.getWidth()), new Integer(anchoringHelper6.getHeight()), new Integer(startTabIndex.intValue() + 8), ControlState.HIDDEN, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Cancel", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper7 = new RuntimeAnchoring(designSize, runtimeSize, 528, 456, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1006), new Integer(anchoringHelper7.getX()), new Integer(anchoringHelper7.getY()), new Integer(anchoringHelper7.getWidth()), new Integer(anchoringHelper7.getHeight()), new Integer(startTabIndex.intValue() + 6), ControlState.HIDDEN, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Save", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper8 = new RuntimeAnchoring(designSize, runtimeSize, 8, 456, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1007), new Integer(anchoringHelper8.getX()), new Integer(anchoringHelper8.getY()), new Integer(anchoringHelper8.getWidth()), new Integer(anchoringHelper8.getHeight()), new Integer(startTabIndex.intValue() + 4), ControlState.UNKNOWN, ControlState.HIDDEN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT, "Select", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// Grid Controls
		RuntimeAnchoring anchoringHelper9 = new RuntimeAnchoring(designSize, runtimeSize, 8, 8, 672, 344, ims.framework.enumerations.ControlAnchoring.ALL);
		Grid m_grdRecordsTemp = (Grid)factory.getControl(Grid.class, new Object[] { control, new Integer(startControlID.intValue() + 1008), new Integer(anchoringHelper9.getX()), new Integer(anchoringHelper9.getY()), new Integer(anchoringHelper9.getWidth()), new Integer(anchoringHelper9.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.READONLY, ControlState.DISABLED, ims.framework.enumerations.ControlAnchoring.ALL,Boolean.TRUE, Boolean.TRUE, new Integer(24), Boolean.TRUE, contextMenus.contextMenuGenericGrid, Boolean.FALSE, Boolean.FALSE, new Integer(0), null, Boolean.FALSE, Boolean.TRUE});
		addControl(m_grdRecordsTemp);
		grdRecordsGrid grdRecords = (grdRecordsGrid)GridFlyweightFactory.getInstance().createGridBridge(grdRecordsGrid.class, m_grdRecordsTemp);
		grdRecords.addStringColumn("Value", 0, 0, 200, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdRecords.addStringColumn("Description", 0, 0, -1, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		super.addGrid(grdRecords);
	}


	public ctn1Container ctn1()
	{
		return (ctn1Container)super.getContainer(0);
	}
	public Button btnCancel()
	{
		return (Button)super.getControl(1);
	}
	public Button btnSave()
	{
		return (Button)super.getControl(2);
	}
	public Button btnSelect()
	{
		return (Button)super.getControl(3);
	}
	public grdRecordsGrid grdRecords()
	{
		return (grdRecordsGrid)super.getGrid(0);
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
			cxl_SelectedRecord = new ims.framework.ContextVariable("SelectedRecord", prefix + "_lv_ClinicalAdmin.SelectPrognosticRiskAssessment.__internal_x_context__SelectedRecord_" + componentIdentifier + "");
		}
		
		public boolean getSelectedRecordIsNotNull()
		{
			return !cxl_SelectedRecord.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.PrognosticRiskConfigVo getSelectedRecord()
		{
			return (ims.clinicaladmin.vo.PrognosticRiskConfigVo)cxl_SelectedRecord.getValue(context);
		}
		public void setSelectedRecord(ims.clinicaladmin.vo.PrognosticRiskConfigVo value)
		{
			cxl_SelectedRecord.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SelectedRecord = null;
	}

	public final class ContextMenus implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public final class GenericGrid implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			public static final int Add = 1;
			public static final int Update = 2;
			public static final int Remove = 3;
			public static final int View = 4;
			public static final int MoveUp = 5;
			public static final int MoveDown = 6;
			public static final int Replace = 7;
			public static final int Confirm = 8;
			public static final int EDIT_VIEW_ICP_ACTIONS = 9;
		}
		public void disableAllGenericGridMenuItems()
		{
			this.contextMenuGenericGridAddItem.setEnabled(false);
			this.contextMenuGenericGridUpdateItem.setEnabled(false);
			this.contextMenuGenericGridRemoveItem.setEnabled(false);
			this.contextMenuGenericGridViewItem.setEnabled(false);
			this.contextMenuGenericGridMoveUpItem.setEnabled(false);
			this.contextMenuGenericGridMoveDownItem.setEnabled(false);
			this.contextMenuGenericGridReplaceItem.setEnabled(false);
			this.contextMenuGenericGridConfirmItem.setEnabled(false);
			this.contextMenuGenericGridEDIT_VIEW_ICP_ACTIONSItem.setEnabled(false);
		}
		public void hideAllGenericGridMenuItems()
		{
			this.contextMenuGenericGridAddItem.setVisible(false);
			this.contextMenuGenericGridUpdateItem.setVisible(false);
			this.contextMenuGenericGridRemoveItem.setVisible(false);
			this.contextMenuGenericGridViewItem.setVisible(false);
			this.contextMenuGenericGridMoveUpItem.setVisible(false);
			this.contextMenuGenericGridMoveDownItem.setVisible(false);
			this.contextMenuGenericGridReplaceItem.setVisible(false);
			this.contextMenuGenericGridConfirmItem.setVisible(false);
			this.contextMenuGenericGridEDIT_VIEW_ICP_ACTIONSItem.setVisible(false);
		}
		private Menu contextMenuGenericGrid;
		public MenuItem getGenericGridAddItem()
		{
			return this.contextMenuGenericGridAddItem;
		}
		private MenuItem contextMenuGenericGridAddItem;
		public MenuItem getGenericGridUpdateItem()
		{
			return this.contextMenuGenericGridUpdateItem;
		}
		private MenuItem contextMenuGenericGridUpdateItem;
		public MenuItem getGenericGridRemoveItem()
		{
			return this.contextMenuGenericGridRemoveItem;
		}
		private MenuItem contextMenuGenericGridRemoveItem;
		public MenuItem getGenericGridViewItem()
		{
			return this.contextMenuGenericGridViewItem;
		}
		private MenuItem contextMenuGenericGridViewItem;
		public MenuItem getGenericGridMoveUpItem()
		{
			return this.contextMenuGenericGridMoveUpItem;
		}
		private MenuItem contextMenuGenericGridMoveUpItem;
		public MenuItem getGenericGridMoveDownItem()
		{
			return this.contextMenuGenericGridMoveDownItem;
		}
		private MenuItem contextMenuGenericGridMoveDownItem;
		public MenuItem getGenericGridReplaceItem()
		{
			return this.contextMenuGenericGridReplaceItem;
		}
		private MenuItem contextMenuGenericGridReplaceItem;
		public MenuItem getGenericGridConfirmItem()
		{
			return this.contextMenuGenericGridConfirmItem;
		}
		private MenuItem contextMenuGenericGridConfirmItem;
		public MenuItem getGenericGridEDIT_VIEW_ICP_ACTIONSItem()
		{
			return this.contextMenuGenericGridEDIT_VIEW_ICP_ACTIONSItem;
		}
		private MenuItem contextMenuGenericGridEDIT_VIEW_ICP_ACTIONSItem;
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
			IReportField[] fields = new IReportField[79];
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
			fields[71] = new ims.framework.ReportField(this.context, "_cv_ClinicalAdmin.SelectedPrognosticRiskAssessment", "BO-1075100018-ID", "ID_PrognosticRiskConfiguration");
			fields[72] = new ims.framework.ReportField(this.context, "_cv_ClinicalAdmin.SelectedPrognosticRiskAssessment", "BO-1075100018-RISKNAME", "RiskName");
			fields[73] = new ims.framework.ReportField(this.context, "_cv_ClinicalAdmin.SelectedPrognosticRiskAssessment", "BO-1075100018-RISKDESCRIPTION", "RiskDescription");
			fields[74] = new ims.framework.ReportField(this.context, "_cv_ClinicalAdmin.SelectedPrognosticRiskAssessment", "BO-1075100018-ISACTIVE", "IsActive");
			fields[75] = new ims.framework.ReportField(this.context, prefix + "_lv_ClinicalAdmin.SelectPrognosticRiskAssessment.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1075100018-ID", "ID_PrognosticRiskConfiguration");
			fields[76] = new ims.framework.ReportField(this.context, prefix + "_lv_ClinicalAdmin.SelectPrognosticRiskAssessment.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1075100018-RISKNAME", "RiskName");
			fields[77] = new ims.framework.ReportField(this.context, prefix + "_lv_ClinicalAdmin.SelectPrognosticRiskAssessment.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1075100018-RISKDESCRIPTION", "RiskDescription");
			fields[78] = new ims.framework.ReportField(this.context, prefix + "_lv_ClinicalAdmin.SelectPrognosticRiskAssessment.__internal_x_context__SelectedRecord_" + componentIdentifier, "BO-1075100018-ISACTIVE", "IsActive");
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
