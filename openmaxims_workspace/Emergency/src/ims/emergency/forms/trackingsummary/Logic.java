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
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.54 build 2685.26610)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.emergency.forms.trackingsummary;

import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.utils.Color;




public class Logic extends BaseLogic
{
	private static final Integer COL_INFO = new Integer(1);
	private static final Integer COL_OVERALL = new Integer(8);
	private static final Integer COL_WAITING = new Integer(2);
	private static final Integer COL_TRIAGE = new Integer(3);
	private static final Integer COL_ZONE1 = new Integer(4);
	private static final Integer COL_ZONE2 = new Integer(5);
	private static final Integer COL_ZONE3 = new Integer(6);	
	private static final Integer COL_RESUS = new Integer(7);
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	private void open()
	{
		populateResourceGridData();
		populateSummaryGridData();
		
	}
	private void populateSummaryGridData()
	{
		form.dyngrd1().clear();
		
		form.dyngrd1().setSelectable(false);
		form.dyngrd1().setReadOnly(false);
		
		DynamicGridColumn column = form.dyngrd1().getColumns().newColumn(" ");
		column.setIdentifier(COL_INFO);
		column.setWidth(150);
		column.setBackColor(Color.LightSteelBlue);

		
		
		column = form.dyngrd1().getColumns().newColumn("Waiting");
		column.setIdentifier(COL_WAITING);
		column.setWidth(90);
		
		column = form.dyngrd1().getColumns().newColumn("Triage");
		column.setIdentifier(COL_TRIAGE);
		column.setWidth(90);

		column = form.dyngrd1().getColumns().newColumn("Zone 1");
		column.setIdentifier(COL_ZONE1);
		column.setWidth(90);

		column = form.dyngrd1().getColumns().newColumn("Zone 2");
		column.setIdentifier(COL_ZONE2);
		column.setWidth(90);

		column = form.dyngrd1().getColumns().newColumn("Zone 3");
		column.setIdentifier(COL_ZONE3);
		column.setWidth(90);

		column = form.dyngrd1().getColumns().newColumn("Resus");
		column.setIdentifier(COL_RESUS);
		column.setWidth(90);
		
		column = form.dyngrd1().getColumns().newColumn("Overall");
		column.setIdentifier(COL_OVERALL);
		column.setWidth(90);
		column.setBackColor(Color.LightSeaGreen);

		populateSummaryRows();

				
	}
	private void populateSummaryRows()
	{
		DynamicGridRow row = form.dyngrd1().getRows().newRow();
		//row.setBackColor(Color.Bisque);
		//row.setBold(true);
	
		DynamicGridCell cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_INFO), DynamicCellType.STRING);
		cell.setWidth(150);
		cell.setValue("Awaiting Triage");
		cell.setBackColor(Color.LightSteelBlue);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_WAITING), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("5");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_TRIAGE), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("10");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE1), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE2), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE3), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_RESUS), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_OVERALL), DynamicCellType.HTMLVIEW);
		cell.setWidth(90);
		cell.setValue("<b>15</B>");
		cell.setBackColor(Color.Bisque);
		
		
		row = form.dyngrd1().getRows().newRow();
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_INFO), DynamicCellType.STRING);
		cell.setWidth(150);
		cell.setValue("Priority 1");
		cell.setBackColor(Color.LightSteelBlue);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_WAITING), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_TRIAGE), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE1), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("2");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE2), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE3), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_RESUS), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("1");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_OVERALL), DynamicCellType.HTMLVIEW);
		cell.setWidth(90);
		cell.setValue("<b>3</b>");
		cell.setBackColor(Color.Bisque);
		
		
		row = form.dyngrd1().getRows().newRow();
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_INFO), DynamicCellType.STRING);
		cell.setWidth(150);
		cell.setValue("Priority 2");
		cell.setBackColor(Color.LightSteelBlue);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_WAITING), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_TRIAGE), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE1), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("3");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE2), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("2");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE3), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_RESUS), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("1");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_OVERALL), DynamicCellType.HTMLVIEW);
		cell.setWidth(90);
		cell.setValue("<b>6</b>");
		cell.setBackColor(Color.Bisque);
		
		
		
		
		
		row = form.dyngrd1().getRows().newRow();
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_INFO), DynamicCellType.STRING);
		cell.setWidth(150);
		cell.setValue("Priority 3");
		cell.setBackColor(Color.LightSteelBlue);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_WAITING), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_TRIAGE), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE1), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("4");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE2), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("3");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE3), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("5");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_RESUS), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_OVERALL), DynamicCellType.HTMLVIEW);
		cell.setWidth(90);
		cell.setValue("<b>12</B>");
		cell.setBackColor(Color.Bisque);
		
		
		
		row = form.dyngrd1().getRows().newRow();
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_INFO), DynamicCellType.STRING);
		cell.setWidth(150);
		cell.setValue("Priority 4");
		cell.setBackColor(Color.LightSteelBlue);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_WAITING), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_TRIAGE), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE1), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("1");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE2), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("3");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE3), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("10");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_RESUS), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_OVERALL), DynamicCellType.HTMLVIEW);
		cell.setWidth(90);
		cell.setValue("<b>14</B>");
		cell.setBackColor(Color.Bisque);
		
		
		
		
		
		
		
		
		row = form.dyngrd1().getRows().newRow();
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_INFO), DynamicCellType.STRING);
		cell.setWidth(150);
		cell.setValue("Priority 5");
		cell.setBackColor(Color.LightSteelBlue);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_WAITING), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_TRIAGE), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE1), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("4");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE2), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("3");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE3), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("2");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_RESUS), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_OVERALL), DynamicCellType.HTMLVIEW);
		cell.setWidth(90);
		cell.setValue("<b>2</B>");
		cell.setBackColor(Color.Bisque);
		
	
		
		
	
		
		
		
		row = form.dyngrd1().getRows().newRow();
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_INFO), DynamicCellType.STRING);
		cell.setWidth(150);
		cell.setValue("Unallocated");
		cell.setBackColor(Color.LightSteelBlue);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_WAITING), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("4");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_TRIAGE), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("4");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE1), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("1");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE2), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE3), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("10");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_RESUS), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_OVERALL), DynamicCellType.HTMLVIEW);
		cell.setWidth(90);
		cell.setValue("<b>19</b>");
		cell.setBackColor(Color.Bisque);
		
		row = form.dyngrd1().getRows().newRow();
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_INFO), DynamicCellType.STRING);
		cell.setWidth(150);
		cell.setValue("Allocated");
		cell.setBackColor(Color.LightSteelBlue);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_WAITING), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("1");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_TRIAGE), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("6");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE1), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("9");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE2), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("8");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE3), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("7");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_RESUS), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("2");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_OVERALL), DynamicCellType.HTMLVIEW);
		cell.setWidth(90);
		cell.setValue("<b>33</b>");
		cell.setBackColor(Color.Bisque);

		row = form.dyngrd1().getRows().newRow();
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_INFO), DynamicCellType.STRING);
		cell.setWidth(150);
		cell.setValue("Sent to X-Ray");
		cell.setBackColor(Color.LightSteelBlue);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_WAITING), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_TRIAGE), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE1), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("2");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE2), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE3), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("4");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_RESUS), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_OVERALL), DynamicCellType.HTMLVIEW);
		cell.setWidth(90);
		cell.setValue("<b>6</b>");
		cell.setBackColor(Color.Bisque);

		
		row = form.dyngrd1().getRows().newRow();
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_INFO), DynamicCellType.STRING);
		cell.setWidth(150);
		cell.setValue("Awaiting X-Ray Result");
		cell.setBackColor(Color.LightSteelBlue);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_WAITING), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_TRIAGE), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("1");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE1), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("1");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE2), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("1");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE3), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("3");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_RESUS), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("1");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_OVERALL), DynamicCellType.HTMLVIEW);
		cell.setWidth(90);
		cell.setValue("<b>7</b>");
		cell.setBackColor(Color.Bisque);
		
		row = form.dyngrd1().getRows().newRow();
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_INFO), DynamicCellType.STRING);
		cell.setWidth(150);
		cell.setValue("Awaiting Lab Result");
		cell.setBackColor(Color.LightSteelBlue);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_WAITING), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_TRIAGE), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE1), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("5");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE2), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("2");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE3), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("8");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_RESUS), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("2");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_OVERALL), DynamicCellType.HTMLVIEW);
		cell.setWidth(90);
		cell.setValue("<b>17</b>");
		cell.setBackColor(Color.Bisque);
		
		
		
		row = form.dyngrd1().getRows().newRow();
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_INFO), DynamicCellType.STRING);
		cell.setWidth(150);
		cell.setValue("<15 mins to Breach");
		cell.setBackColor(Color.LightSteelBlue);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_WAITING), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_TRIAGE), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE1), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("4");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE2), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("3");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE3), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("5");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_RESUS), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("-");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_OVERALL), DynamicCellType.HTMLVIEW);
		cell.setWidth(90);
		cell.setValue("<b>12</b>");
		cell.setBackColor(Color.Bisque);
		
		
		row = form.dyngrd1().getRows().newRow();
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_INFO), DynamicCellType.STRING);
		cell.setWidth(150);
		cell.setValue("Average Length of Stay");
		cell.setBackColor(Color.LightSteelBlue);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_WAITING), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("1hr 10m 15s");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_TRIAGE), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("2hr 01m 05s");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE1), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("3hr 05m 55s");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE2), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("2hr 55m 15s");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE3), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("1hr 12m 15s");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_RESUS), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("1hr 10m 15s");
		
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_OVERALL), DynamicCellType.HTMLVIEW);
		cell.setWidth(90);
		cell.setValue("<b>1hr 55m 55s</b>");
		cell.setBackColor(Color.Bisque);
		
		row = form.dyngrd1().getRows().newRow();
		row.setBold(true);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_INFO), DynamicCellType.STRING);
		cell.setWidth(150);
		cell.setValue("Total No. Patients");
		cell.setBackColor(Color.Black);
		cell.setTextColor(Color.White);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_WAITING), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("5");
		cell.setBackColor(Color.Black);
		cell.setTextColor(Color.White);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_TRIAGE), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("10");
		cell.setBackColor(Color.Black);
		cell.setTextColor(Color.White);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE1), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("10");
		cell.setBackColor(Color.Black);
		cell.setTextColor(Color.White);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE2), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("8");
		cell.setBackColor(Color.Black);
		cell.setTextColor(Color.White);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_ZONE3), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("17");
		cell.setBackColor(Color.Black);
		cell.setTextColor(Color.White);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_RESUS), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("2");
		cell.setBackColor(Color.Black);
		cell.setTextColor(Color.White);
		
		cell = row.getCells().newCell(form.dyngrd1().getColumns().getByIdentifier(COL_OVERALL), DynamicCellType.STRING);
		cell.setWidth(90);
		cell.setValue("52");
		cell.setBackColor(Color.Black);
		cell.setTextColor(Color.White);
		
	}
	private void populateResourceGridData()
	{
		form.grdSummary().getRows().clear();
		
		GenForm.grdSummaryRow row = null;
		
		row = form.grdSummary().getRows().newRow();
		row.setcolMOS("Mr. John Ryan");
		row.setcolImage(form.getImages().Emergency.DoctorEnabled16);
		row.setcolAllocated("10");
		row.setcolSeen("5");
		row.setcolToBeSeen("5");
				
		row = form.grdSummary().getRows().newRow();
		row.setcolMOS("Dr. Orla Fitzpatrick");
		row.setcolImage(form.getImages().Emergency.DoctorEnabled16);
		row.setcolAllocated("4");
		row.setcolSeen("4");
		row.setcolToBeSeen("-");
		
		row = form.grdSummary().getRows().newRow();
		row.setcolMOS("Dr. James Murphy");
		row.setcolImage(form.getImages().Emergency.DoctorEnabled16);
		row.setcolAllocated("2");
		row.setcolSeen("-");
		row.setcolToBeSeen("2");

		
		row = form.grdSummary().getRows().newRow();
		row.setcolMOS("Mr. Sean Power");
		row.setcolImage(form.getImages().Emergency.DoctorEnabled16);
		row.setcolAllocated("3");
		row.setcolSeen("1");
		row.setcolToBeSeen("2");

		
		row = form.grdSummary().getRows().newRow();
		row.setcolMOS("Dr. Helen Smith");
		row.setcolImage(form.getImages().Emergency.DoctorEnabled16);
		row.setcolAllocated("2");
		row.setcolSeen("1");
		row.setcolToBeSeen("1");

		
		row = form.grdSummary().getRows().newRow();
		row.setcolMOS("Sharon Thomas");
		row.setcolImage(form.getImages().Emergency.NurseEnabled16);
		row.setcolAllocated("4");
		row.setcolSeen("1");
		row.setcolToBeSeen("3");
		
		row = form.grdSummary().getRows().newRow();
		row.setcolMOS("Lucy Walshe");
		row.setcolImage(form.getImages().Emergency.NurseEnabled16);
		row.setcolAllocated("5");
		row.setcolSeen("2");
		row.setcolToBeSeen("3");		
		
		row = form.grdSummary().getRows().newRow();
		row.setcolMOS("Margaret Callaghan");
		row.setcolImage(form.getImages().Emergency.NurseEnabled16);
		row.setcolAllocated("3");
		row.setcolSeen("-");
		row.setcolToBeSeen("3");		
		
		
		
	}
	private void initialize()
	{
		// TODO Auto-generated method stub
		
	}
	
}
