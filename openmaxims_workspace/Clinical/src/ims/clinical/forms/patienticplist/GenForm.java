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

package ims.clinical.forms.patienticplist;

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
	public static class grdICPSRow extends GridRowBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected grdICPSRow(GridRow row)
		{
			super(row);
		}
		public void showOpened(int column)
		{
			super.row.showOpened(column);
		}
		public void setcolAdmissionDateReadOnly(boolean value)
		{
			super.row.setReadOnly(0, value);
		}
		public boolean iscolAdmissionDateReadOnly()
		{
			return super.row.isReadOnly(0);
		}
		public void showcolAdmissionDateOpened()
		{
			super.row.showOpened(0);
		}
		public void setTooltipForcolAdmissionDate(String value)
		{
			super.row.setTooltip(0, value);
		}
		public String getcolAdmissionDate()
		{
			return (String)super.row.get(0);
		}
		public void setcolAdmissionDate(String value)
		{
			super.row.set(0, value);
		}
		public void setCellcolAdmissionDateTooltip(String value)
		{
			super.row.setTooltip(0, value);
		}
		public void setcolAuthoringReadOnly(boolean value)
		{
			super.row.setReadOnly(1, value);
		}
		public boolean iscolAuthoringReadOnly()
		{
			return super.row.isReadOnly(1);
		}
		public void showcolAuthoringOpened()
		{
			super.row.showOpened(1);
		}
		public void setTooltipForcolAuthoring(String value)
		{
			super.row.setTooltip(1, value);
		}
		public String getcolAuthoring()
		{
			return (String)super.row.get(1);
		}
		public void setcolAuthoring(String value)
		{
			super.row.set(1, value);
		}
		public void setCellcolAuthoringTooltip(String value)
		{
			super.row.setTooltip(1, value);
		}
		public void setcolICPReadOnly(boolean value)
		{
			super.row.setReadOnly(2, value);
		}
		public boolean iscolICPReadOnly()
		{
			return super.row.isReadOnly(2);
		}
		public void showcolICPOpened()
		{
			super.row.showOpened(2);
		}
		public void setTooltipForcolICP(String value)
		{
			super.row.setTooltip(2, value);
		}
		public String getcolICP()
		{
			return (String)super.row.get(2);
		}
		public void setcolICP(String value)
		{
			super.row.set(2, value);
		}
		public void setCellcolICPTooltip(String value)
		{
			super.row.setTooltip(2, value);
		}
		public void setcolCompletedReadOnly(boolean value)
		{
			super.row.setReadOnly(3, value);
		}
		public boolean iscolCompletedReadOnly()
		{
			return super.row.isReadOnly(3);
		}
		public void showcolCompletedOpened()
		{
			super.row.showOpened(3);
		}
		public void setTooltipForcolCompleted(String value)
		{
			super.row.setTooltip(3, value);
		}
		public String getcolCompleted()
		{
			return (String)super.row.get(3);
		}
		public void setcolCompleted(String value)
		{
			super.row.set(3, value);
		}
		public void setCellcolCompletedTooltip(String value)
		{
			super.row.setTooltip(3, value);
		}
		public void setcolNurseActionReadOnly(boolean value)
		{
			super.row.setReadOnly(4, value);
		}
		public boolean iscolNurseActionReadOnly()
		{
			return super.row.isReadOnly(4);
		}
		public void showcolNurseActionOpened()
		{
			super.row.showOpened(4);
		}
		public void setTooltipForcolNurseAction(String value)
		{
			super.row.setTooltip(4, value);
		}
		public ims.framework.utils.Image getcolNurseAction()
		{
			return (ims.framework.utils.Image)super.row.get(4);
		}
		public void setcolNurseAction(ims.framework.utils.Image value)
		{
			super.row.set(4, value);
		}
		public void setCellcolNurseActionTooltip(String value)
		{
			super.row.setTooltip(4, value);
		}
		public void setcolDoctorActionReadOnly(boolean value)
		{
			super.row.setReadOnly(5, value);
		}
		public boolean iscolDoctorActionReadOnly()
		{
			return super.row.isReadOnly(5);
		}
		public void showcolDoctorActionOpened()
		{
			super.row.showOpened(5);
		}
		public void setTooltipForcolDoctorAction(String value)
		{
			super.row.setTooltip(5, value);
		}
		public ims.framework.utils.Image getcolDoctorAction()
		{
			return (ims.framework.utils.Image)super.row.get(5);
		}
		public void setcolDoctorAction(ims.framework.utils.Image value)
		{
			super.row.set(5, value);
		}
		public void setCellcolDoctorActionTooltip(String value)
		{
			super.row.setTooltip(5, value);
		}
		public void setcolPhysioActionReadOnly(boolean value)
		{
			super.row.setReadOnly(6, value);
		}
		public boolean iscolPhysioActionReadOnly()
		{
			return super.row.isReadOnly(6);
		}
		public void showcolPhysioActionOpened()
		{
			super.row.showOpened(6);
		}
		public void setTooltipForcolPhysioAction(String value)
		{
			super.row.setTooltip(6, value);
		}
		public ims.framework.utils.Image getcolPhysioAction()
		{
			return (ims.framework.utils.Image)super.row.get(6);
		}
		public void setcolPhysioAction(ims.framework.utils.Image value)
		{
			super.row.set(6, value);
		}
		public void setCellcolPhysioActionTooltip(String value)
		{
			super.row.setTooltip(6, value);
		}
		public void setcolAdminActionReadOnly(boolean value)
		{
			super.row.setReadOnly(7, value);
		}
		public boolean iscolAdminActionReadOnly()
		{
			return super.row.isReadOnly(7);
		}
		public void showcolAdminActionOpened()
		{
			super.row.showOpened(7);
		}
		public void setTooltipForcolAdminAction(String value)
		{
			super.row.setTooltip(7, value);
		}
		public ims.framework.utils.Image getcolAdminAction()
		{
			return (ims.framework.utils.Image)super.row.get(7);
		}
		public void setcolAdminAction(ims.framework.utils.Image value)
		{
			super.row.set(7, value);
		}
		public void setCellcolAdminActionTooltip(String value)
		{
			super.row.setTooltip(7, value);
		}
		public ims.icp.vo.PatientICPMediumVo getValue()
		{
			return (ims.icp.vo.PatientICPMediumVo)super.row.getValue();
		}
		public void setValue(ims.icp.vo.PatientICPMediumVo value)
		{
			super.row.setValue(value);
		}
	}
	public static class grdICPSRowCollection extends GridRowCollectionBridge
	{
		private static final long serialVersionUID = 1L;
		
		private grdICPSRowCollection(GridRowCollection collection)
		{
			super(collection);
		}
		public grdICPSRow get(int index)
		{
			return new grdICPSRow(super.collection.get(index));
		}
		public grdICPSRow newRow()
		{
			return new grdICPSRow(super.collection.newRow());
		}
		public grdICPSRow newRow(boolean autoSelect)
		{
			return new grdICPSRow(super.collection.newRow(autoSelect));
		}
		public grdICPSRow newRowAt(int index)
		{
			return new grdICPSRow(super.collection.newRowAt(index));
		}
		public grdICPSRow newRowAt(int index, boolean autoSelect)
		{
			return new grdICPSRow(super.collection.newRowAt(index, autoSelect));
		}
	}
	public static class grdICPSGrid extends GridBridge
	{
		private static final long serialVersionUID = 1L;
		
		private void addStringColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean bold, int sortOrder, int maxLength, boolean canGrow, ims.framework.enumerations.CharacterCasing casing)
		{
			super.grid.addStringColumn(caption, captionAlignment, alignment, width, readOnly, bold, sortOrder, maxLength, canGrow, casing);
		}
		private void addImageColumn(String caption, int captionAlignment, int alignment, int width, boolean canGrow, int sortOrder)
		{
			super.grid.addImageColumn(caption, captionAlignment, alignment, width, canGrow, sortOrder);
		}
		public ims.icp.vo.PatientICPMediumVoCollection getValues()
		{
			ims.icp.vo.PatientICPMediumVoCollection listOfValues = new ims.icp.vo.PatientICPMediumVoCollection();
			for(int x = 0; x < this.getRows().size(); x++)
			{
				listOfValues.add(this.getRows().get(x).getValue());
			}
			return listOfValues;
		}
		public ims.icp.vo.PatientICPMediumVo getValue()
		{
			return (ims.icp.vo.PatientICPMediumVo)super.grid.getValue();
		}
		public void setValue(ims.icp.vo.PatientICPMediumVo value)
		{
			super.grid.setValue(value);
		}
		public grdICPSRow getSelectedRow()
		{
			return super.grid.getSelectedRow() == null ? null : new grdICPSRow(super.grid.getSelectedRow());
		}
		public int getSelectedRowIndex()
		{
			return super.grid.getSelectedRowIndex();
		}
		public grdICPSRowCollection getRows()
		{
			return new grdICPSRowCollection(super.grid.getRows());
		}
		public grdICPSRow getRowByValue(ims.icp.vo.PatientICPMediumVo value)
		{
			GridRow row = super.grid.getRowByValue(value);
			return row == null?null:new grdICPSRow(row);
		}
		public void setcolAdmissionDateHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(0, value);
		}
		public String getcolAdmissionDateHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(0);
		}
		public void setcolAuthoringHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(1, value);
		}
		public String getcolAuthoringHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(1);
		}
		public void setcolICPHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(2, value);
		}
		public String getcolICPHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(2);
		}
		public void setcolCompletedHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(3, value);
		}
		public String getcolCompletedHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(3);
		}
		public void setcolNurseActionHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(4, value);
		}
		public String getcolNurseActionHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(4);
		}
		public void setcolDoctorActionHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(5, value);
		}
		public String getcolDoctorActionHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(5);
		}
		public void setcolPhysioActionHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(6, value);
		}
		public String getcolPhysioActionHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(6);
		}
		public void setcolAdminActionHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(7, value);
		}
		public String getcolAdminActionHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(7);
		}
	}
	private void validateContext(ims.framework.Context context)
	{
		if(context == null)
			return;
		if(!context.isValidContextType(ims.core.vo.PatientShort.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.core.vo.PatientShort' of the global context variable 'Core.PatientShort' is not supported.");
		if(!context.isValidContextType(ims.core.vo.CareContextShortVo.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.core.vo.CareContextShortVo' of the global context variable 'Core.CurrentCareContext' is not supported.");
	}
	private void validateMandatoryContext(Context context)
	{
		if(new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort").getValueIsNull(context))
			throw new ims.framework.exceptions.FormMandatoryContextMissingException("The required context data 'Core.PatientShort' is not available.");
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
			validateMandatoryContext(context);
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
		contextMenus.Clinical.contextMenuPatientICPList = factory.createMenu(startControlID.intValue() + 1);
		contextMenus.Clinical.contextMenuPatientICPListVIEW_EDIT_ICPItem = factory.createMenuItem(startControlID.intValue() + 1, "View/Edit ICP", true, false, new Integer(102150), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(4230001)))
			contextMenus.Clinical.contextMenuPatientICPList.add(contextMenus.Clinical.contextMenuPatientICPListVIEW_EDIT_ICPItem);
		contextMenus.Clinical.contextMenuPatientICPListSET_STATUS_TO_OPENItem = factory.createMenuItem(startControlID.intValue() + 2, "Set ICP status to Open", true, false, new Integer(118129), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(4230002)))
			contextMenus.Clinical.contextMenuPatientICPList.add(contextMenus.Clinical.contextMenuPatientICPListSET_STATUS_TO_OPENItem);
		contextMenus.Clinical.contextMenuPatientICPListSET_STATUS_TO_COMPLETEDItem = factory.createMenuItem(startControlID.intValue() + 3, "Set ICP status to Completed", true, false, new Integer(116128), true, false);
		if(factory.getUIEngine().getLoggedInRole().hasMenuActionRight(appForm, new ims.framework.MenuAction(4230003)))
			contextMenus.Clinical.contextMenuPatientICPList.add(contextMenus.Clinical.contextMenuPatientICPListSET_STATUS_TO_COMPLETEDItem);
		form.registerMenu(contextMenus.Clinical.contextMenuPatientICPList);


		// Grid Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 8, 8, 832, 616, ims.framework.enumerations.ControlAnchoring.ALL);
		Grid m_grdICPSTemp = (Grid)factory.getControl(Grid.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL,Boolean.TRUE, Boolean.FALSE, new Integer(26), Boolean.TRUE, contextMenus.Clinical.contextMenuPatientICPList, Boolean.FALSE, Boolean.FALSE, new Integer(0), null, Boolean.TRUE, Boolean.TRUE});
		addControl(m_grdICPSTemp);
		grdICPSGrid grdICPS = (grdICPSGrid)GridFlyweightFactory.getInstance().createGridBridge(grdICPSGrid.class, m_grdICPSTemp);
		grdICPS.addStringColumn("Start Date/Time", 0, 0, 120, true, false, 2, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdICPS.addStringColumn("Authoring HCP", 0, 0, 150, true, false, 1, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdICPS.addStringColumn("ICP", 0, 0, 270, true, false, 1, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdICPS.addStringColumn("Completed Date/Time", 0, 0, 160, true, false, 1, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdICPS.addImageColumn(" ", 0, 0, 35, true, 2);
		grdICPS.addImageColumn(" ", 0, 0, 35, true, 2);
		grdICPS.addImageColumn(" ", 0, 0, 35, true, 2);
		grdICPS.addImageColumn(" ", 0, 0, -1, true, 2);
		super.addGrid(grdICPS);
	}



	public Forms getForms()
	{
		return (Forms)super.getFormReferences();
	}

	public Images getImages()
	{
		return (Images)super.getImageReferences();
	}
	public grdICPSGrid grdICPS()
	{
		return (grdICPSGrid)super.getGrid(0);
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
			ICP = new ICPForms();
		}
		public final class ICPForms implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private ICPForms()
			{
				PatientICP = new LocalFormName(118100);
			}
			public final FormName PatientICP;
		}

		public ICPForms ICP;
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
			ICP = new ICPImages();
			Admin = new AdminImages();
		}
		public final class ICPImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private ICPImages()
			{
				ICP = new ImageHelper(118104, "Images/ICP/ICP.gif", new Integer(16), new Integer(16));
			}
			public final ims.framework.utils.Image ICP;
		}
		public final class AdminImages implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			private AdminImages()
			{
				Nurse24 = new ImageHelper(103208, "Images/Admin/nurse_24.png", new Integer(24), new Integer(24));
				Stethoscope24 = new ImageHelper(103210, "Images/Admin/stethoscope_24.png", new Integer(24), new Integer(24));
				Doctor24 = new ImageHelper(103209, "Images/Admin/doctor_24.png", new Integer(24), new Integer(24));
				AdminAction24 = new ImageHelper(103211, "Images/Admin/patient_information_24.png", new Integer(24), new Integer(24));
			}
			public final ims.framework.utils.Image Nurse24;
			public final ims.framework.utils.Image Stethoscope24;
			public final ims.framework.utils.Image Doctor24;
			public final ims.framework.utils.Image AdminAction24;
		}
		public final ICPImages ICP;
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
			cxl_SortOrder = new ims.framework.ContextVariable("SortOrder", prefix + "_lv_Clinical.PatientICPList.__internal_x_context__SortOrder_" + componentIdentifier + "");
			cxl_PatientICPsCol = new ims.framework.ContextVariable("PatientICPsCol", prefix + "_lv_Clinical.PatientICPList.__internal_x_context__PatientICPsCol_" + componentIdentifier + "");
		}
		
		public boolean getSortOrderIsNotNull()
		{
			return !cxl_SortOrder.getValueIsNull(context);
		}
		public ims.framework.enumerations.SortOrder getSortOrder()
		{
			return (ims.framework.enumerations.SortOrder)cxl_SortOrder.getValue(context);
		}
		public void setSortOrder(ims.framework.enumerations.SortOrder value)
		{
			cxl_SortOrder.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_SortOrder = null;
		public boolean getPatientICPsColIsNotNull()
		{
			return !cxl_PatientICPsCol.getValueIsNull(context);
		}
		public ims.icp.vo.PatientICPMediumVoCollection getPatientICPsCol()
		{
			return (ims.icp.vo.PatientICPMediumVoCollection)cxl_PatientICPsCol.getValue(context);
		}
		public void setPatientICPsCol(ims.icp.vo.PatientICPMediumVoCollection value)
		{
			cxl_PatientICPsCol.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_PatientICPsCol = null;
	}

	public final class ContextMenus implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public ClinicalNamespace Clinical = new ClinicalNamespace();
		public final class ClinicalNamespace implements java.io.Serializable
		{
			private static final long serialVersionUID = 1L;
			public final class PatientICPList implements java.io.Serializable
			{
				private static final long serialVersionUID = 1L;
				public static final int VIEW_EDIT_ICP = 1;
				public static final int SET_STATUS_TO_OPEN = 2;
				public static final int SET_STATUS_TO_COMPLETED = 3;
			}
			public void disableAllPatientICPListMenuItems()
			{
				this.contextMenuPatientICPListVIEW_EDIT_ICPItem.setEnabled(false);
				this.contextMenuPatientICPListSET_STATUS_TO_OPENItem.setEnabled(false);
				this.contextMenuPatientICPListSET_STATUS_TO_COMPLETEDItem.setEnabled(false);
			}
			public void hideAllPatientICPListMenuItems()
			{
				this.contextMenuPatientICPListVIEW_EDIT_ICPItem.setVisible(false);
				this.contextMenuPatientICPListSET_STATUS_TO_OPENItem.setVisible(false);
				this.contextMenuPatientICPListSET_STATUS_TO_COMPLETEDItem.setVisible(false);
			}
			private Menu contextMenuPatientICPList;
			public ReadOnlyMenuItem getPatientICPListVIEW_EDIT_ICPItem()
			{
				return this.contextMenuPatientICPListVIEW_EDIT_ICPItem;
			}
			private MenuItem contextMenuPatientICPListVIEW_EDIT_ICPItem;
			public ReadOnlyMenuItem getPatientICPListSET_STATUS_TO_OPENItem()
			{
				return this.contextMenuPatientICPListSET_STATUS_TO_OPENItem;
			}
			private MenuItem contextMenuPatientICPListSET_STATUS_TO_OPENItem;
			public ReadOnlyMenuItem getPatientICPListSET_STATUS_TO_COMPLETEDItem()
			{
				return this.contextMenuPatientICPListSET_STATUS_TO_COMPLETEDItem;
			}
			private MenuItem contextMenuPatientICPListSET_STATUS_TO_COMPLETEDItem;
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
			IReportField[] fields = new IReportField[72];
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
			fields[71] = new ims.framework.ReportField(this.context, "_cv_ICP.PatientICPRecord", "BO-1100100000-ID", "ID_PatientICP");
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
