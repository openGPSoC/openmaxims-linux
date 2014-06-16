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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.45 build 2426.28575)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.fluidbalancedetails;

import ims.clinicaladmin.helper.DailyPatternAndShiftsHelper;
import ims.clinicaladmin.vo.DailyPatternConfigVo;
import ims.clinicaladmin.vo.SignatoryPeriodConfigVo;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.DailyFluidBalanceVo;
import ims.core.vo.FluidBalanceDetailsVo;
import ims.core.vo.FluidBalanceDetailsVoCollection;
import ims.core.vo.FluidBalanceInstanceVo;
import ims.core.vo.FluidBalanceInstanceVoCollection;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.ShiftDetailsVo;
import ims.core.vo.SignatoryShiftDetailsVo;
import ims.core.vo.SignatoryShiftDetailsVoCollection;
import ims.core.vo.lookups.DailyTimePeriods;
import ims.core.vo.lookups.DailyTimePeriodsCollection;
import ims.core.vo.lookups.FluidBalanceType;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;
import ims.utils.textile.Textile;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			engine.close(DialogResult.OK);
	}

	private boolean save()
	{

		if (form.cmbTime().getValue() == null)
		{
			engine.showMessage("Please select a Time and save again.");
			return false;
		}
		populateDataFromScreen();

		DailyFluidBalanceVo voBalanace = form.getLocalContext().getCurrentDailyFluidBalanceVo();

		String[] errors = voBalanace.validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return false;
		}

		try
		{
			voBalanace = domain.saveDailyFluidBalance(voBalanace);
		}
		catch (StaleObjectException sox)
		{
			form.getGlobalContext().Core.setYesNoDialogMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.open(form.getForms().Core.OkDialog, "Data Warning");

			return false;
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}

		form.getGlobalContext().Core.setCurrentDailyFluidBalanceVo(voBalanace);
		form.getGlobalContext().Core.setCurrentDailyFluidBalanceInstanceVo(form.getLocalContext().getCurrentFluidBalanceInstanceVo());

		return true;
	}

	private Time getPatternEndTime()
	{
		if (form.getLocalContext().getSavedDailyPatternConfigIsNotNull())
		{
			if (form.getLocalContext().getSavedDailyPatternConfig().getSignatoryPeriodIsNotNull())
			{
				SignatoryPeriodConfigVo voPeriod = form.getLocalContext().getSavedDailyPatternConfig().getSignatoryPeriod().get(form.getLocalContext().getSavedDailyPatternConfig().getSignatoryPeriod().size() - 1);
				if (voPeriod.getTimePeriodsIsNotNull())
				{
					if (form.getLocalContext().getDailyTimePeriods().size() > 0)
					{
						for (int i = 0; i < form.getLocalContext().getDailyTimePeriods().size(); i++)
						{
							if (form.getLocalContext().getDailyTimePeriods().get(i).equals(voPeriod.getTimePeriods().get(voPeriod.getTimePeriods().size() - 1)))
								return new Time(form.getLocalContext().getDailyTimePeriods().get(i).toString().substring(0, 2) + ":59:00");
						}
					}
				}
			}
		}
		return null;
	}

	private DailyTimePeriods getDailyTimePeriodEndTime(DailyTimePeriods value, DailyPatternConfigVo voConfiguredPattern)
	{
		if (voConfiguredPattern.getSignatoryPeriodIsNotNull() && voConfiguredPattern.getSignatoryPeriod().size() > 0)
		{
			for (int i = 0; i < voConfiguredPattern.getSignatoryPeriod().size(); i++)
			{
				if (voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriodsIsNotNull() && voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().size() > 0)
				{
					for (int j = 0; j < voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().size(); j++)
					{
						// Correct time found in shift, return the EndTime of
						// shift
						if (voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().get(j).equals(value))
							return voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().get(voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().size() - 1);
					}
				}
			}
		}
		return null;
	}

	private Time getShiftEndTime(DailyTimePeriods value, DailyPatternConfigVo voConfiguredPattern)
	{
		if (voConfiguredPattern.getSignatoryPeriodIsNotNull() && voConfiguredPattern.getSignatoryPeriod().size() > 0)
		{
			for (int i = 0; i < voConfiguredPattern.getSignatoryPeriod().size(); i++)
			{
				if (voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriodsIsNotNull() && voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().size() > 0)
				{
					for (int j = 0; j < voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().size(); j++)
					{
						// Correct time found in shift, return the EndTime of
						// shift
						if (voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().get(j).equals(value))
						{
							if (form.getLocalContext().getDailyTimePeriods().size() > 0)
							{
								for (int k = 0; k < form.getLocalContext().getDailyTimePeriods().size(); k++)
								{
									if (form.getLocalContext().getDailyTimePeriods().get(k).equals(voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().get(voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().size() - 1)))
										return new Time(form.getLocalContext().getDailyTimePeriods().get(k).toString().substring(0, 2) + ":00:00");
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	private DailyTimePeriods getDailyTimePeriodStartTime(DailyTimePeriods value, DailyPatternConfigVo voConfiguredPattern)
	{
		if (voConfiguredPattern.getSignatoryPeriodIsNotNull() && voConfiguredPattern.getSignatoryPeriod().size() > 0)
		{
			for (int i = 0; i < voConfiguredPattern.getSignatoryPeriod().size(); i++)
			{
				if (voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriodsIsNotNull() && voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().size() > 0)
				{
					for (int j = 0; j < voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().size(); j++)
					{
						if (voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().get(j).equals(value))
						{
							// Correct time found in shift, return the EndTime
							// of shift
							return voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().get(0);
						}
					}
				}
			}
		}
		return null;
	}

	private Time getShiftStartTime(DailyTimePeriods value, DailyPatternConfigVo voConfiguredPattern)
	{
		if (voConfiguredPattern.getSignatoryPeriodIsNotNull() && voConfiguredPattern.getSignatoryPeriod().size() > 0)
		{
			for (int i = 0; i < voConfiguredPattern.getSignatoryPeriod().size(); i++)
			{
				if (voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriodsIsNotNull() && voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().size() > 0)
				{
					for (int j = 0; j < voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().size(); j++)
					{
						if (voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().get(j).equals(value))
						{
							if (form.getLocalContext().getDailyTimePeriods().size() > 0)
							{
								for (int k = 0; k < form.getLocalContext().getDailyTimePeriods().size(); k++)
								{
									if (form.getLocalContext().getDailyTimePeriods().get(k).equals(voConfiguredPattern.getSignatoryPeriod().get(i).getTimePeriods().get(0)))
										return new Time(form.getLocalContext().getDailyTimePeriods().get(k).toString().substring(0, 2) + ":00:00");
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	private SignatoryShiftDetailsVo findIfShiftDetailsAlreadyRecorded(DailyTimePeriods value, SignatoryShiftDetailsVoCollection signatoryShifts)
	{
		// See if this time period is in a configured shift which has already
		// been instansiated......
		DailyTimePeriods timStartTimeTofind = getDailyTimePeriodStartTime(value, form.getLocalContext().getSavedDailyPatternConfig());

		if (signatoryShifts != null && signatoryShifts.size() > 0)
		{
			for (int i = 0; i < signatoryShifts.size(); i++)
			{
				if (signatoryShifts.get(i).getStartTimeIsNotNull() && signatoryShifts.get(i).getStartTime().equals(timStartTimeTofind))
					return signatoryShifts.get(i);
			}
		}
		return null;
	}

	private void populateScreenFromData()
	{
		form.getLocalContext().setCurrentDailyFluidBalanceVo(form.getGlobalContext().Core.getCurrentDailyFluidBalanceVo());
		form.getLocalContext().setCurrentFluidBalanceInstanceVo(form.getGlobalContext().Core.getCurrentDailyFluidBalanceInstanceVo());

		FluidBalanceInstanceVo voFluid = form.getGlobalContext().Core.getCurrentDailyFluidBalanceInstanceVo();
		if (voFluid != null)
		{
			GenForm.grdIntakeRow rowIN;
			int intake = 0;
			if (voFluid.getFluidIntakeIsNotNull())
			{
				for (int j = 0; j < voFluid.getFluidIntake().size(); j++)
				{
					FluidBalanceDetailsVo inFluidVo = voFluid.getFluidIntake().get(j);
					int i = 0;
					for (i = 0; i < form.grdIntake().getRows().size(); i++)
					{
						rowIN = form.grdIntake().getRows().get(i);
						if (rowIN.getColType().getValue().equals(inFluidVo.getType()))
						{
							rowIN.setColValue(inFluidVo.getValue());
							rowIN.setValue(inFluidVo);
							intake += inFluidVo.getValue().intValue();
							break;
						}
					}
					if (i == form.grdIntake().getRows().size())
					{
						rowIN = form.grdIntake().getRows().newRow();
						rowIN.getColType().newRow(inFluidVo.getType(), inFluidVo.getType().getText());
						rowIN.getColType().setValue(inFluidVo.getType());
						rowIN.setColValue(inFluidVo.getValue());
						rowIN.setValue(inFluidVo);
						intake += inFluidVo.getValue().intValue();
					}
				}
			}
			StringBuffer footerIn = new StringBuffer();
			footerIn.append("<align=RIGHT>Total: ");
			footerIn.append(intake);
			String html = new Textile().process(footerIn.toString());
			form.grdIntake().setFooterValue(html);

			GenForm.grdOutputRow rowOUT;
			int output = 0;
			if (voFluid.getFluidOutputIsNotNull())
			{
				for (int j = 0; j < voFluid.getFluidOutput().size(); j++)
				{
					FluidBalanceDetailsVo outFluidVo = voFluid.getFluidOutput().get(j);
					int i = 0;
					for (i = 0; i < form.grdOutput().getRows().size(); i++)
					{
						rowOUT = form.grdOutput().getRows().get(i);
						if (rowOUT.getColType().getValue().equals(outFluidVo.getType()))
						{
							rowOUT.setColValue(outFluidVo.getValue());
							rowOUT.setValue(outFluidVo);
							output += outFluidVo.getValue().intValue();
							break;
						}
					}
					if (i == form.grdOutput().getRows().size())
					{
						rowOUT = form.grdOutput().getRows().newRow();
						rowOUT.getColType().newRow(outFluidVo.getType(), outFluidVo.getType().getText());
						rowOUT.getColType().setValue(outFluidVo.getType());
						rowOUT.setColValue(outFluidVo.getValue());
						rowOUT.setValue(outFluidVo);
						output += outFluidVo.getValue().intValue();
					}
				}
			}

			StringBuffer footerOut = new StringBuffer();
			footerOut.append("<align=RIGHT> Total: ");
			footerOut.append(output);
			form.grdOutput().setFooterValue(new Textile().process(footerOut.toString()));

			voFluid.setBalance(new Integer(intake - output));

			form.dteFluidBalance().setValue(voFluid.getFluidBalanceDate());

			addConfiguredTimePeriods();
			form.cmbTime().setValue(voFluid.getTimePeriod());

			form.customControlAuthoring().setValue(voFluid.getAuthoringInformation());

			form.intIrrigIn().setValue(voFluid.getIrrigationIn());
			form.intIrrigOut().setValue(voFluid.getIrrigationOut());
			form.txtComments().setValue(voFluid.getComments());

			form.dteFluidBalance().setEnabled(false);
			form.cmbTime().setEnabled(false);
		}
		else
		// WDEV-1741
		{
			form.dteFluidBalance().setValue(new Date());
			dateValueChanged();
		}
	}

	private void populateDataFromScreen()
	{
		SignatoryShiftDetailsVo voSignatoryShiftDetails = null;

		Time timStart = form.getLocalContext().getSavedDailyPatternConfig().getStartTime();
		timStart.setSecond(0);
		DailyFluidBalanceVo voDFB = domain.getDailyFluidBalanceDetailsByContextDateAndTimePeriod((CareContextRefVo) form.getGlobalContext().Core.getCurrentCareContext(), new ims.framework.utils.DateTime(form.dteFluidBalance().getValue(), timStart), new ims.framework.utils.DateTime(getShiftEndDate(), getPatternEndTime()));

		if (voDFB == null)
		{
			voDFB = new DailyFluidBalanceVo();

			voDFB.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			voDFB.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());

			ShiftDetailsVo voShiftDetails = new ShiftDetailsVo();

			voShiftDetails.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			voShiftDetails.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
			DateTime dtStart = new DateTime(form.dteFluidBalance().getValue(), form.getLocalContext().getSavedDailyPatternConfig().getStartTime());
			voShiftDetails.setStartDateTime(dtStart); // Configured Start time
			// for Fluid Balance
			voShiftDetails.setEndDateTime(new DateTime(getShiftEndDate(), getPatternEndTime()));

			voDFB.setShiftDetails(voShiftDetails);
		}

		if (voDFB.getShiftDetails().getSignatoryShifts() == null)
			voDFB.getShiftDetails().setSignatoryShifts(new SignatoryShiftDetailsVoCollection());

		voSignatoryShiftDetails = findIfShiftDetailsAlreadyRecorded(form.cmbTime().getValue(), voDFB.getShiftDetails().getSignatoryShifts());
		if (voSignatoryShiftDetails == null)
			voSignatoryShiftDetails = new SignatoryShiftDetailsVo();

		voSignatoryShiftDetails.setStartTime(getDailyTimePeriodStartTime(form.cmbTime().getValue(), form.getLocalContext().getSavedDailyPatternConfig()));// Configured shift Start time
		// for Fluid Balance
		voSignatoryShiftDetails.setEndTime(getDailyTimePeriodEndTime(form.cmbTime().getValue(), form.getLocalContext().getSavedDailyPatternConfig()));// Configured shift end time for
		// Fluid Balance
		DateTime dtStart = new DateTime(form.dteFluidBalance().getValue(), getShiftStartTime(form.cmbTime().getValue(), form.getLocalContext().getSavedDailyPatternConfig()));
		voSignatoryShiftDetails.setShiftStartDateTime(dtStart);
		voSignatoryShiftDetails.setShiftEndDateTime(new DateTime(getShiftEndDate(), getShiftEndTime(form.cmbTime().getValue(), form.getLocalContext().getSavedDailyPatternConfig())));

		populateFluidBalanceInstanceVo();

		FluidBalanceInstanceVo voFluid = form.getLocalContext().getCurrentFluidBalanceInstanceVo();
		voFluid.setSignatoryShift(voSignatoryShiftDetails);

		if (voDFB.getFluidBalanceInstances() == null)
			voDFB.setFluidBalanceInstances(new FluidBalanceInstanceVoCollection());

		if (voFluid.getID_FluidBalanceInstance() == null)
			voDFB.getFluidBalanceInstances().add(voFluid);
		else
		{
			if (voDFB.getFluidBalanceInstances().size() > 0)
			{
				for (int i = 0; i < voDFB.getFluidBalanceInstances().size(); i++)
				{
					if (form.getLocalContext().getCurrentFluidBalanceInstanceVo().equals(voDFB.getFluidBalanceInstances().get(i)))
						voDFB.getFluidBalanceInstances().set(i, voFluid);
				}
			}
		}

		// Add or replace the SignatoryShiftDetails in the ShiftDetails
		if (voSignatoryShiftDetails.getID_SignatoryShiftDetails() == null)
			voDFB.getShiftDetails().getSignatoryShifts().add(voSignatoryShiftDetails);
		else
		{
			if (voDFB.getShiftDetails().getSignatoryShiftsIsNotNull() && voDFB.getShiftDetails().getSignatoryShifts().size() > 0)
			{
				for (int j = 0; j < voDFB.getShiftDetails().getSignatoryShifts().size(); j++)
				{
					if (voSignatoryShiftDetails.equals(voDFB.getShiftDetails().getSignatoryShifts().get(j)))
						voDFB.getShiftDetails().getSignatoryShifts().set(j, voSignatoryShiftDetails);
				}
			}
		}

		/*
		 * //Now Check to see if a Signatory shift needs to be removed for (int j = 0 ; j < voDFB.getShiftDetails().getSignatoryShifts().size() ; j++) { boolean bRemoveSignatoryShift = true; if (voDFB.getFluidBalanceInstancesIsNotNull()) { for (int k = 0 ; k < voDFB.getFluidBalanceInstances().size() ; k++) { if (voDFB.getFluidBalanceInstances().get(k).getSignatoryShiftIsNotNull() && voDFB.getFluidBalanceInstances().get(k).getSignatoryShift().getID_SignatoryShiftDetailsIsNotNull() && voDFB.getShiftDetails().getSignatoryShifts().get(j).getID_SignatoryShiftDetailsIsNotNull() && voDFB.getFluidBalanceInstances().get(k).getSignatoryShift().getID_SignatoryShiftDetails().equals(voDFB.getShiftDetails().getSignatoryShifts().get(j).getID_SignatoryShiftDetails()) ) bRemoveSignatoryShift = false; } } if (bRemoveSignatoryShift) { voDFB.getShiftDetails().getSignatoryShifts().remove(j); break; } }
		 */
		form.getLocalContext().setCurrentDailyFluidBalanceVo(voDFB);
		form.getLocalContext().setCurrentFluidBalanceInstanceVo(voFluid);
	}

	private Date getShiftEndDate()
	{
		int nStartHour = form.getLocalContext().getSavedDailyPatternConfig().getStartTime().getHour();
		if (nStartHour == 0)
			return form.dteFluidBalance().getValue();
		else
		{
			if (form.dteFluidBalance().getValue() != null)
			{
				Date dtFluidBalance = (Date) form.dteFluidBalance().getValue().clone();
				dtFluidBalance.addDay(1);
				return new Date(dtFluidBalance);
			}
			return null;
		}
	}

	private void populateFluidBalanceInstanceVo()
	{
		FluidBalanceInstanceVo voFluid = form.getLocalContext().getCurrentFluidBalanceInstanceVo();
		if (voFluid == null)
			voFluid = new FluidBalanceInstanceVo();

		voFluid.setFluidIntake(new FluidBalanceDetailsVoCollection());

		voFluid.setFluidOutput(new FluidBalanceDetailsVoCollection());

		FluidBalanceDetailsVo voFBD = null;
		int intake = 0;
		for (int in = 0; in < form.grdIntake().getRows().size(); in++)
		{
			if (form.grdIntake().getRows().get(in).getColValue() != null)
			{
				voFBD = form.grdIntake().getRows().get(in).getValue();
				if (voFBD == null)
					voFBD = new FluidBalanceDetailsVo();
				voFBD.setType((FluidBalanceType) form.grdIntake().getRows().get(in).getColType().getValue());
				voFBD.setValue(form.grdIntake().getRows().get(in).getColValue());

				intake += form.grdIntake().getRows().get(in).getColValue().intValue();

				voFluid.getFluidIntake().add(voFBD);
			}
		}
		voFluid.setTotalIntake(new Integer(intake));

		int output = 0;
		for (int in = 0; in < form.grdOutput().getRows().size(); in++)
		{
			if (form.grdOutput().getRows().get(in).getColValue() != null)
			{
				voFBD = form.grdOutput().getRows().get(in).getValue();
				if (voFBD == null)
					voFBD = new FluidBalanceDetailsVo();
				voFBD.setType((FluidBalanceType) form.grdOutput().getRows().get(in).getColType().getValue());
				voFBD.setValue(form.grdOutput().getRows().get(in).getColValue());

				output += form.grdOutput().getRows().get(in).getColValue().intValue();

				voFluid.getFluidOutput().add(voFBD);
			}
		}
		voFluid.setTotalOutput(new Integer(output));

		voFluid.setBalance(new Integer(intake - output));

		voFluid.setFluidBalanceDate(form.dteFluidBalance().getValue());
		voFluid.setStartTime(new Time(form.cmbTime().getValue().toString().substring(0, 3) + "00"));
		voFluid.setEndTime(new Time(form.cmbTime().getValue().toString().substring(0, 3) + "59"));
		//WDEV-7311 
		if (form.customControlAuthoring().getValue() != null)
		{
			if (form.customControlAuthoring().getValue().getAuthoringDateTimeIsNotNull() && form.customControlAuthoring().getValue().getAuthoringHcpIsNotNull())
				voFluid.setAuthoringInformation(form.customControlAuthoring().getValue());
			else
				voFluid.setAuthoringInformation(null);
		}
		else
			voFluid.setAuthoringInformation(null);
		voFluid.setComments(form.txtComments().getValue());
		voFluid.setIrrigationIn(form.intIrrigIn().getValue());
		voFluid.setIrrigationOut(form.intIrrigOut().getValue());
		voFluid.setTimePeriod(form.cmbTime().getValue());

		form.getLocalContext().setCurrentFluidBalanceInstanceVo(voFluid);
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	protected void onFormOpen() throws PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		initialize();

		updateControlsState();
		setDefaultValuesToControls();
		open();

	}

	private void open()
	{
		populateScreenFromData();
	}

	private void setDefaultValuesToControls()
	{
		AuthoringInformationVo voAuthoring = new AuthoringInformationVo();
		voAuthoring.setAuthoringDateTime(new DateTime());
		voAuthoring.setAuthoringHcp((HcpLiteVo) domain.getHcpLiteUser());
		form.customControlAuthoring().setValue(voAuthoring);
	}

	private void initialize()
	{
		//Added for WDEV-7311
		form.customControlAuthoring().setIsRequiredPropertyToControls(true);
		form.getLocalContext().setFluidBalanceType(ims.core.vo.lookups.LookupHelper.getFluidBalanceType(domain.getLookupService()));
		addActiveIntakeRows();
		addActiveOutputRows();
	}

	private void updateControlsState()
	{
	}

	private void addActiveOutputRows()
	{
		if (form.getLocalContext().getFluidBalanceTypeIsNotNull())
		{
			for (int i = 0; i < form.getLocalContext().getFluidBalanceType().size(); i++)
			{
				if (form.getLocalContext().getFluidBalanceType().get(i).getParent() != null && form.getLocalContext().getFluidBalanceType().get(i).getParent().equals(FluidBalanceType.OUTPUT) && form.getLocalContext().getFluidBalanceType().get(i).isActive())
				{
					GenForm.grdOutputRow row = form.grdOutput().getRows().newRow();
					row.getColType().newRow(form.getLocalContext().getFluidBalanceType().get(i), form.getLocalContext().getFluidBalanceType().get(i).getText());
					row.getColType().setValue(form.getLocalContext().getFluidBalanceType().get(i));
				}
			}
		}
	}

	private void addActiveIntakeRows()
	{
		if (form.getLocalContext().getFluidBalanceTypeIsNotNull())
		{
			for (int i = 0; i < form.getLocalContext().getFluidBalanceType().size(); i++)
			{
				if (form.getLocalContext().getFluidBalanceType().get(i).getParent() != null && form.getLocalContext().getFluidBalanceType().get(i).getParent().equals(FluidBalanceType.INTAKE) && form.getLocalContext().getFluidBalanceType().get(i).isActive())
				{
					GenForm.grdIntakeRow row = form.grdIntake().getRows().newRow();
					row.getColType().newRow(form.getLocalContext().getFluidBalanceType().get(i), form.getLocalContext().getFluidBalanceType().get(i).getText());
					row.getColType().setValue(form.getLocalContext().getFluidBalanceType().get(i));
				}
			}
		}
	}

	protected void onDteFluidBalanceValueChanged() throws PresentationLogicException
	{
		if (form.dteFluidBalance().getValue() != null)
			dateValueChanged();
		else
			form.cmbTime().setValue(null);
	}

	private void dateValueChanged()
	{
		// Check to see if  a DailyFluidBalance already exists for this date,
		// CareContext and ClinicalContact.......if so dont allow another
		// only display in the Time combo the time slots that are not already
		// configured for the chosen date.
		form.getLocalContext().setCurrentDailyFluidBalanceVo(null);

		DailyTimePeriodsCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getDailyTimePeriods(domain.getLookupService());
		DailyPatternAndShiftsHelper helper = new DailyPatternAndShiftsHelper();
		DailyPatternConfigVo configVo = form.getGlobalContext().Core.getCurrentDailyPatternConfigVo();
		if (configVo.getStartTime() != null)
		{
			lookupCollection = helper.configureCustomTimePeriods(configVo.getStartTime(), lookupCollection);
			form.getLocalContext().setDailyTimePeriods(lookupCollection);
			form.getLocalContext().setSavedDailyPatternConfig(configVo);
		}

		Time timStart = form.getLocalContext().getSavedDailyPatternConfig().getStartTime();
		timStart.setSecond(00);
		FluidBalanceInstanceVoCollection voFBIColl = domain.getFluidBalanceInstancesForContextAndDate((CareContextRefVo) form.getGlobalContext().Core.getCurrentCareContext(), new ims.framework.utils.DateTime(form.dteFluidBalance().getValue(), timStart), new ims.framework.utils.DateTime(getShiftEndDate(), getPatternEndTime()));

		// Now see if any have been configured yet and only add ones that have
		// not been
		if (lookupCollection != null)
		{
			form.cmbTime().clear();
			int nStartHour = configVo.getStartTime().getHour();
			for (int j = 24 - nStartHour; j < lookupCollection.size(); j++)
			{
				boolean bFound = false;
				if (voFBIColl != null)
				{
					for (int k = 0; k < voFBIColl.size(); k++)
					{
						if (lookupCollection.get(j).getId() == voFBIColl.get(k).getTimePeriod().getId())
							bFound = true;
					}
				}
				if (!bFound)
					form.cmbTime().newRow(lookupCollection.get(j), lookupCollection.get(j).getText());
			}
			if (nStartHour >= 0)
			{
				for (int j = 0; j < 24 - nStartHour; j++)
				{
					boolean bFound = false;
					if (voFBIColl != null)
					{
						for (int k = 0; k < voFBIColl.size(); k++)
						{
							if (lookupCollection.get(j).getId() == voFBIColl.get(k).getTimePeriod().getId())
								bFound = true;
						}
					}
					if (!bFound)
						form.cmbTime().newRow(lookupCollection.get(j), lookupCollection.get(j).getText());
				}
			}
		}
	}

	private void addConfiguredTimePeriods()
	{
		DailyPatternConfigVo configVo = form.getGlobalContext().Core.getCurrentDailyPatternConfigVo();

		if (configVo != null)
		{
			DailyTimePeriodsCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getDailyTimePeriods(domain.getLookupService());
			DailyPatternAndShiftsHelper helper = new DailyPatternAndShiftsHelper();
			if (configVo.getStartTime() != null)
			{
				lookupCollection = helper.configureCustomTimePeriods(configVo.getStartTime(), lookupCollection);
				form.getLocalContext().setDailyTimePeriods(lookupCollection);
				form.getLocalContext().setSavedDailyPatternConfig(configVo);

				if (lookupCollection != null)
				{
					int nStartHour = configVo.getStartTime().getHour();
					for (int j = 24 - nStartHour; j < lookupCollection.size(); j++)
						form.cmbTime().newRow(lookupCollection.get(j), lookupCollection.get(j).getText());

					if (nStartHour >= 0)
					{
						for (int j = 0; j < 24 - nStartHour; j++)
							form.cmbTime().newRow(lookupCollection.get(j), lookupCollection.get(j).getText());
					}
				}
			}
		}

	}

	protected void onGrdOutputSelectionChanged() throws PresentationLogicException
	{
		// TODO Auto-generated method stub

	}

	protected void onGrdIntakeSelectionChanged() throws PresentationLogicException
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (formName.equals(form.getForms().Core.OkDialog))
			engine.close(DialogResult.OK);
	}

}
