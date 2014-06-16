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

package ims.clinical.forms.surgicalauditprocedurestaffdialog;

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
	public static class grdSelectedTestsRow extends GridRowBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected grdSelectedTestsRow(GridRow row)
		{
			super(row);
		}
		public void showOpened(int column)
		{
			super.row.showOpened(column);
		}
		public void setcolSelectedReadOnly(boolean value)
		{
			super.row.setReadOnly(0, value);
		}
		public boolean iscolSelectedReadOnly()
		{
			return super.row.isReadOnly(0);
		}
		public void showcolSelectedOpened()
		{
			super.row.showOpened(0);
		}
		public boolean getcolSelected()
		{
			return ((Boolean)super.row.get(0)).booleanValue();
		}
		public void setcolSelected(boolean value)
		{
			super.row.set(0, new Boolean(value));
		}
		public void setCellcolSelectedTooltip(String value)
		{
			super.row.setTooltip(0, value);
		}
		public void setcolImageReadOnly(boolean value)
		{
			super.row.setReadOnly(1, value);
		}
		public boolean iscolImageReadOnly()
		{
			return super.row.isReadOnly(1);
		}
		public void showcolImageOpened()
		{
			super.row.showOpened(1);
		}
		public ims.framework.utils.Image getcolImage()
		{
			return (ims.framework.utils.Image)super.row.get(1);
		}
		public void setcolImage(ims.framework.utils.Image value)
		{
			super.row.set(1, value);
		}
		public void setCellcolImageTooltip(String value)
		{
			super.row.setTooltip(1, value);
		}
		public void setcolNameReadOnly(boolean value)
		{
			super.row.setReadOnly(2, value);
		}
		public boolean iscolNameReadOnly()
		{
			return super.row.isReadOnly(2);
		}
		public void showcolNameOpened()
		{
			super.row.showOpened(2);
		}
		public String getcolName()
		{
			return (String)super.row.get(2);
		}
		public void setcolName(String value)
		{
			super.row.set(2, value);
		}
		public void setCellcolNameTooltip(String value)
		{
			super.row.setTooltip(2, value);
		}
		public Object getValue()
		{
			return super.row.getValue();
		}
		public void setValue(Object value)
		{
			super.row.setValue(value);
		}
	}
	public static class grdSelectedTestsRowCollection extends GridRowCollectionBridge
	{
		private static final long serialVersionUID = 1L;
		
		private grdSelectedTestsRowCollection(GridRowCollection collection)
		{
			super(collection);
		}
		public grdSelectedTestsRow get(int index)
		{
			return new grdSelectedTestsRow(super.collection.get(index));
		}
		public grdSelectedTestsRow newRow()
		{
			return new grdSelectedTestsRow(super.collection.newRow());
		}
		public grdSelectedTestsRow newRow(boolean autoSelect)
		{
			return new grdSelectedTestsRow(super.collection.newRow(autoSelect));
		}
		public grdSelectedTestsRow newRowAt(int index)
		{
			return new grdSelectedTestsRow(super.collection.newRowAt(index));
		}
		public grdSelectedTestsRow newRowAt(int index, boolean autoSelect)
		{
			return new grdSelectedTestsRow(super.collection.newRowAt(index, autoSelect));
		}
	}
	public static class grdSelectedTestsGrid extends GridBridge
	{
		private static final long serialVersionUID = 1L;
		
		private void addBoolColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean autoPostBack, int sortOrder, boolean canGrow)
		{
			super.grid.addBoolColumn(caption, captionAlignment, alignment, width, readOnly, autoPostBack, sortOrder, canGrow);
		}
		private void addImageColumn(String caption, int captionAlignment, int alignment, int width, boolean canGrow, int sortOrder)
		{
			super.grid.addImageColumn(caption, captionAlignment, alignment, width, canGrow, sortOrder);
		}
		private void addStringColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean bold, int sortOrder, int maxLength, boolean canGrow, ims.framework.enumerations.CharacterCasing casing)
		{
			super.grid.addStringColumn(caption, captionAlignment, alignment, width, readOnly, bold, sortOrder, maxLength, canGrow, casing);
		}
		public Object[] getValues()
		{
			Object[] listOfValues = new Object[this.getRows().size()];
			for(int x = 0; x < this.getRows().size(); x++)
			{
				listOfValues[x] = this.getRows().get(x).getValue();
			}
			return listOfValues;
		}
		public Object getValue()
		{
			return super.grid.getValue();
		}
		public void setValue(Object value)
		{
			super.grid.setValue(value);
		}
		public grdSelectedTestsRow getSelectedRow()
		{
			return super.grid.getSelectedRow() == null ? null : new grdSelectedTestsRow(super.grid.getSelectedRow());
		}
		public int getSelectedRowIndex()
		{
			return super.grid.getSelectedRowIndex();
		}
		public grdSelectedTestsRowCollection getRows()
		{
			return new grdSelectedTestsRowCollection(super.grid.getRows());
		}
		public grdSelectedTestsRow getRowByValue(Object value)
		{
			GridRow row = super.grid.getRowByValue(value);
			return row == null?null:new grdSelectedTestsRow(row);
		}
		public void setcolSelectedHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(0, value);
		}
		public String getcolSelectedHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(0);
		}
		public void setcolImageHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(1, value);
		}
		public String getcolImageHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(1);
		}
		public void setcolNameHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(2, value);
		}
		public String getcolNameHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(2);
		}
	}
	public static class grdListedTestsRow extends GridRowBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected grdListedTestsRow(GridRow row)
		{
			super(row);
		}
		public void showOpened(int column)
		{
			super.row.showOpened(column);
		}
		public void setcolSelectedReadOnly(boolean value)
		{
			super.row.setReadOnly(0, value);
		}
		public boolean iscolSelectedReadOnly()
		{
			return super.row.isReadOnly(0);
		}
		public void showcolSelectedOpened()
		{
			super.row.showOpened(0);
		}
		public boolean getcolSelected()
		{
			return ((Boolean)super.row.get(0)).booleanValue();
		}
		public void setcolSelected(boolean value)
		{
			super.row.set(0, new Boolean(value));
		}
		public void setCellcolSelectedTooltip(String value)
		{
			super.row.setTooltip(0, value);
		}
		public void setcolImageReadOnly(boolean value)
		{
			super.row.setReadOnly(1, value);
		}
		public boolean iscolImageReadOnly()
		{
			return super.row.isReadOnly(1);
		}
		public void showcolImageOpened()
		{
			super.row.showOpened(1);
		}
		public ims.framework.utils.Image getcolImage()
		{
			return (ims.framework.utils.Image)super.row.get(1);
		}
		public void setcolImage(ims.framework.utils.Image value)
		{
			super.row.set(1, value);
		}
		public void setCellcolImageTooltip(String value)
		{
			super.row.setTooltip(1, value);
		}
		public void setcolNameReadOnly(boolean value)
		{
			super.row.setReadOnly(2, value);
		}
		public boolean iscolNameReadOnly()
		{
			return super.row.isReadOnly(2);
		}
		public void showcolNameOpened()
		{
			super.row.showOpened(2);
		}
		public String getcolName()
		{
			return (String)super.row.get(2);
		}
		public void setcolName(String value)
		{
			super.row.set(2, value);
		}
		public void setCellcolNameTooltip(String value)
		{
			super.row.setTooltip(2, value);
		}
		public Object getValue()
		{
			return super.row.getValue();
		}
		public void setValue(Object value)
		{
			super.row.setValue(value);
		}
	}
	public static class grdListedTestsRowCollection extends GridRowCollectionBridge
	{
		private static final long serialVersionUID = 1L;
		
		private grdListedTestsRowCollection(GridRowCollection collection)
		{
			super(collection);
		}
		public grdListedTestsRow get(int index)
		{
			return new grdListedTestsRow(super.collection.get(index));
		}
		public grdListedTestsRow newRow()
		{
			return new grdListedTestsRow(super.collection.newRow());
		}
		public grdListedTestsRow newRow(boolean autoSelect)
		{
			return new grdListedTestsRow(super.collection.newRow(autoSelect));
		}
		public grdListedTestsRow newRowAt(int index)
		{
			return new grdListedTestsRow(super.collection.newRowAt(index));
		}
		public grdListedTestsRow newRowAt(int index, boolean autoSelect)
		{
			return new grdListedTestsRow(super.collection.newRowAt(index, autoSelect));
		}
	}
	public static class grdListedTestsGrid extends GridBridge
	{
		private static final long serialVersionUID = 1L;
		
		private void addBoolColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean autoPostBack, int sortOrder, boolean canGrow)
		{
			super.grid.addBoolColumn(caption, captionAlignment, alignment, width, readOnly, autoPostBack, sortOrder, canGrow);
		}
		private void addImageColumn(String caption, int captionAlignment, int alignment, int width, boolean canGrow, int sortOrder)
		{
			super.grid.addImageColumn(caption, captionAlignment, alignment, width, canGrow, sortOrder);
		}
		private void addStringColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean bold, int sortOrder, int maxLength, boolean canGrow, ims.framework.enumerations.CharacterCasing casing)
		{
			super.grid.addStringColumn(caption, captionAlignment, alignment, width, readOnly, bold, sortOrder, maxLength, canGrow, casing);
		}
		public Object[] getValues()
		{
			Object[] listOfValues = new Object[this.getRows().size()];
			for(int x = 0; x < this.getRows().size(); x++)
			{
				listOfValues[x] = this.getRows().get(x).getValue();
			}
			return listOfValues;
		}
		public Object getValue()
		{
			return super.grid.getValue();
		}
		public void setValue(Object value)
		{
			super.grid.setValue(value);
		}
		public grdListedTestsRow getSelectedRow()
		{
			return super.grid.getSelectedRow() == null ? null : new grdListedTestsRow(super.grid.getSelectedRow());
		}
		public int getSelectedRowIndex()
		{
			return super.grid.getSelectedRowIndex();
		}
		public grdListedTestsRowCollection getRows()
		{
			return new grdListedTestsRowCollection(super.grid.getRows());
		}
		public grdListedTestsRow getRowByValue(Object value)
		{
			GridRow row = super.grid.getRowByValue(value);
			return row == null?null:new grdListedTestsRow(row);
		}
		public void setcolSelectedHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(0, value);
		}
		public String getcolSelectedHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(0);
		}
		public void setcolImageHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(1, value);
		}
		public String getcolImageHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(1);
		}
		public void setcolNameHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(2, value);
		}
		public String getcolNameHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(2);
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

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(720, 536);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setImageReferences(ImageReferencesFlyweightFactory.getInstance().create(Images.class));
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));


		// Label Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 384, 19, 53, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Selected", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 8, 19, 56, 17, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Available", new Integer(1), null, new Integer(0)}));

		// Button Controls
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 637, 504, 75, 23, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), new Integer(startTabIndex.intValue() + 7), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "Cancel", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 555, 504, 75, 23, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1003), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), new Integer(startTabIndex.intValue() + 6), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, "OK", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// Grid Controls
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 384, 40, 328, 456, ims.framework.enumerations.ControlAnchoring.ALL);
		Grid m_grdSelectedTestsTemp = (Grid)factory.getControl(Grid.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), new Integer(startTabIndex.intValue() + 5), ControlState.EDITABLE, ControlState.EDITABLE, ims.framework.enumerations.ControlAnchoring.ALL,Boolean.FALSE, Boolean.FALSE, new Integer(24), Boolean.TRUE, null, Boolean.FALSE, Boolean.FALSE, new Integer(0), null, Boolean.FALSE, Boolean.TRUE});
		addControl(m_grdSelectedTestsTemp);
		grdSelectedTestsGrid grdSelectedTests = (grdSelectedTestsGrid)GridFlyweightFactory.getInstance().createGridBridge(grdSelectedTestsGrid.class, m_grdSelectedTestsTemp);
		grdSelectedTests.addBoolColumn("Select", 0, 0, 45, false, false, 0, false);
		grdSelectedTests.addImageColumn(" ", 0, 0, 24, false, 0);
		grdSelectedTests.addStringColumn("Name", 0, 0, -1, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		super.addGrid(grdSelectedTests);
		RuntimeAnchoring anchoringHelper6 = new RuntimeAnchoring(designSize, runtimeSize, 8, 40, 328, 456, ims.framework.enumerations.ControlAnchoring.TOPBOTTOMLEFT);
		Grid m_grdListedTestsTemp = (Grid)factory.getControl(Grid.class, new Object[] { control, new Integer(startControlID.intValue() + 1005), new Integer(anchoringHelper6.getX()), new Integer(anchoringHelper6.getY()), new Integer(anchoringHelper6.getWidth()), new Integer(anchoringHelper6.getHeight()), new Integer(startTabIndex.intValue() + 2), ControlState.EDITABLE, ControlState.EDITABLE, ims.framework.enumerations.ControlAnchoring.TOPBOTTOMLEFT,Boolean.FALSE, Boolean.FALSE, new Integer(24), Boolean.TRUE, null, Boolean.FALSE, Boolean.FALSE, new Integer(0), null, Boolean.FALSE, Boolean.TRUE});
		addControl(m_grdListedTestsTemp);
		grdListedTestsGrid grdListedTests = (grdListedTestsGrid)GridFlyweightFactory.getInstance().createGridBridge(grdListedTestsGrid.class, m_grdListedTestsTemp);
		grdListedTests.addBoolColumn("Select", 0, 0, 45, false, false, 0, false);
		grdListedTests.addImageColumn(" ", 0, 0, 24, false, 0);
		grdListedTests.addStringColumn("Name", 0, 0, -1, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		super.addGrid(grdListedTests);

		// Image Buttons Controls
		RuntimeAnchoring anchoringHelper7 = new RuntimeAnchoring(designSize, runtimeSize, 346, 270, 28, 28, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(ImageButton.class, new Object[] { control, new Integer(startControlID.intValue() + 1006), new Integer(anchoringHelper7.getX()), new Integer(anchoringHelper7.getY()), new Integer(anchoringHelper7.getWidth()), new Integer(anchoringHelper7.getHeight()), new Integer(startTabIndex.intValue() + 4), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, this.getImages().Admin.CloseEnabled24, this.getImages().Admin.CloseDisabled24, "Remove from Selected grid", Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null}));
		RuntimeAnchoring anchoringHelper8 = new RuntimeAnchoring(designSize, runtimeSize, 346, 238, 28, 28, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(ImageButton.class, new Object[] { control, new Integer(startControlID.intValue() + 1007), new Integer(anchoringHelper8.getX()), new Integer(anchoringHelper8.getY()), new Integer(anchoringHelper8.getWidth()), new Integer(anchoringHelper8.getHeight()), new Integer(startTabIndex.intValue() + 3), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFT, this.getImages().Admin.RightArrowEnabled24, this.getImages().Admin.RightArrowDisabled24, "Select from Available grid", Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null}));
	}



	public Images getImages()
	{
		return (Images)super.getImageReferences();
	}
	public Button btnCancel()
	{
		return (Button)super.getControl(2);
	}
	public Button btnOK()
	{
		return (Button)super.getControl(3);
	}
	public grdSelectedTestsGrid grdSelectedTests()
	{
		return (grdSelectedTestsGrid)super.getGrid(0);
	}
	public grdListedTestsGrid grdListedTests()
	{
		return (grdListedTestsGrid)super.getGrid(1);
	}
	public ImageButton imbRemoveFromList()
	{
		return (ImageButton)super.getControl(6);
	}
	public ImageButton imbAddToList()
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
			Admin = new AdminImages();
		}
		public final class AdminImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private AdminImages()
			{
				RightArrowDisabled24 = new ImageHelper(103363, "Images/Admin/arrow_right_disabled_24.png", new Integer(24), new Integer(24));
				RightArrowEnabled24 = new ImageHelper(103362, "Images/Admin/arrow_right_enabled_24.png", new Integer(24), new Integer(24));
				CloseDisabled24 = new ImageHelper(103375, "Images/Admin/close_a_disabled_24.png", new Integer(24), new Integer(24));
				CloseEnabled24 = new ImageHelper(103374, "Images/Admin/close_a_enabled_24.png", new Integer(24), new Integer(24));
			}
			public final ims.framework.utils.Image RightArrowDisabled24;
			public final ims.framework.utils.Image RightArrowEnabled24;
			public final ims.framework.utils.Image CloseDisabled24;
			public final ims.framework.utils.Image CloseEnabled24;
		}
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
