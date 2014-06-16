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

package ims.vo.interfaces;

/*
 * Returns a chart value set - this includes everthing needed for the charting custom control.
 */
public interface IChartValueSet extends Comparable
{
	/*
	 * returns a collection of value groups for the chart dataset
	 */
	 ims.vo.interfaces.IChartValueGroup[] getIChartValueSetGroups();
	/*
	 * getIChartValueSetMaxFactor
	 */
	 Integer getIChartValueSetMaxFactor();
	/*
	 * getIChartValueSetMinFactor
	 */
	 Integer getIChartValueSetMinFactor();
	/*
	 * getIChartValueSetBelowBandPercent
	 */
	 Integer getIChartValueSetBelowBandPercent();
	/*
	 * getIChartValueSetAboveBandPercent
	 */
	 Integer getIChartValueSetAboveBandPercent();
	/*
	 * getIChartValueSetTitle
	 */
	 String getIChartValueSetTitle();
	/*
	 * getIChartValueSetSubTitle
	 */
	 String getIChartValueSetSubTitle();
	/*
	 * getIChartValueSetNormalBandColor
	 */
	 ims.framework.utils.Color getIChartValueSetNormalBandColor();
	/*
	 * getIChartValueSetDescription
	 */
	 String getIChartValueSetDescription();
	/*
	 * getIChartValueSetBackgroundColor
	 */
	 ims.framework.utils.Color getIChartValueSetBackgroundColor();
	/*
	 * getIChartValueSetForegroundColor
	 */
	 ims.framework.utils.Color getIChartValueSetForegroundColor();
	/*
	 * setIChartValueSetGroups
	 */
	 void setIChartValueSetGroups(ims.vo.interfaces.IChartValueGroup[] group);
}
