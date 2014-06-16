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

package ims.core.forms.fluidbalancedetails;

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

		public boolean getCurrentDailyFluidBalanceVoIsNotNull()
		{
			return !cx_CoreCurrentDailyFluidBalanceVo.getValueIsNull(context);
		}
		public ims.core.vo.DailyFluidBalanceVo getCurrentDailyFluidBalanceVo()
		{
			return (ims.core.vo.DailyFluidBalanceVo)cx_CoreCurrentDailyFluidBalanceVo.getValue(context);
		}
		public void setCurrentDailyFluidBalanceVo(ims.core.vo.DailyFluidBalanceVo value)
		{
			cx_CoreCurrentDailyFluidBalanceVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentDailyFluidBalanceVo = new ims.framework.ContextVariable("Core.CurrentDailyFluidBalanceVo", "_cv_Core.CurrentDailyFluidBalanceVo");
		public boolean getCurrentDailyFluidBalanceInstanceVoIsNotNull()
		{
			return !cx_CoreCurrentDailyFluidBalanceInstanceVo.getValueIsNull(context);
		}
		public ims.core.vo.FluidBalanceInstanceVo getCurrentDailyFluidBalanceInstanceVo()
		{
			return (ims.core.vo.FluidBalanceInstanceVo)cx_CoreCurrentDailyFluidBalanceInstanceVo.getValue(context);
		}
		public void setCurrentDailyFluidBalanceInstanceVo(ims.core.vo.FluidBalanceInstanceVo value)
		{
			cx_CoreCurrentDailyFluidBalanceInstanceVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentDailyFluidBalanceInstanceVo = new ims.framework.ContextVariable("Core.CurrentDailyFluidBalanceInstanceVo", "_cv_Core.CurrentDailyFluidBalanceInstanceVo");
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}
		public void setCurrentCareContext(ims.core.vo.CareContextShortVo value)
		{
			cx_CoreCurrentCareContext.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}
		public void setCurrentClinicalContact(ims.core.vo.ClinicalContactShortVo value)
		{
			cx_CoreCurrentClinicalContact.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");
		public boolean getCurrentDailyPatternConfigVoIsNotNull()
		{
			return !cx_CoreCurrentDailyPatternConfigVo.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.DailyPatternConfigVo getCurrentDailyPatternConfigVo()
		{
			return (ims.clinicaladmin.vo.DailyPatternConfigVo)cx_CoreCurrentDailyPatternConfigVo.getValue(context);
		}
		public void setCurrentDailyPatternConfigVo(ims.clinicaladmin.vo.DailyPatternConfigVo value)
		{
			cx_CoreCurrentDailyPatternConfigVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentDailyPatternConfigVo = new ims.framework.ContextVariable("Core.CurrentDailyPatternConfigVo", "_cv_Core.CurrentDailyPatternConfigVo");
		public boolean getYesNoDialogMessageIsNotNull()
		{
			return !cx_CoreYesNoDialogMessage.getValueIsNull(context);
		}
		public String getYesNoDialogMessage()
		{
			return (String)cx_CoreYesNoDialogMessage.getValue(context);
		}
		public void setYesNoDialogMessage(String value)
		{
			cx_CoreYesNoDialogMessage.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreYesNoDialogMessage = new ims.framework.ContextVariable("Core.YesNoDialogMessage", "_cv_Core.YesNoDialogMessage");

		private ims.framework.Context context;
	}

	public CoreContext Core;
}
