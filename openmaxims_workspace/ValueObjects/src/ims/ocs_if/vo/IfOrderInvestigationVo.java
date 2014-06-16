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

package ims.ocs_if.vo;

/**
 * Linked to OCRR.OrderingResults.OrderInvestigation business object (ID: 1070100002).
 */
public class IfOrderInvestigationVo extends ims.ocrr.orderingresults.vo.OrderInvestigationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public IfOrderInvestigationVo()
	{
	}
	public IfOrderInvestigationVo(Integer id, int version)
	{
		super(id, version);
	}
	public IfOrderInvestigationVo(ims.ocs_if.vo.beans.IfOrderInvestigationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.orderpriority = bean.getOrderPriority() == null ? null : ims.ocrr.vo.lookups.OrderPriority.buildLookup(bean.getOrderPriority());
		this.repdatetime = bean.getRepDateTime() == null ? null : bean.getRepDateTime().buildDateTime();
		this.reptimesupplied = bean.getRepTimeSupplied();
		this.displaydatetime = bean.getDisplayDateTime() == null ? null : bean.getDisplayDateTime().buildDateTime();
		this.displayflag = bean.getDisplayFlag() == null ? null : ims.ocrr.vo.lookups.OcsDisplayFlag.buildLookup(bean.getDisplayFlag());
		this.wasordered = bean.getWasOrdered();
		this.resultstatus = bean.getResultStatus() == null ? null : ims.ocrr.vo.lookups.ResultStatus.buildLookup(bean.getResultStatus());
		this.ordinvcurrentstatus = bean.getOrdInvCurrentStatus() == null ? null : bean.getOrdInvCurrentStatus().buildVo();
		this.fillerordnum = bean.getFillerOrdNum();
		this.specimen = ims.ocs_if.vo.IfOrderSpecimenVoCollection.buildFromBeanCollection(bean.getSpecimen());
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDateTime();
		this.reasonforstudy = bean.getReasonForStudy();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo();
		this.orderdetails = bean.getOrderDetails() == null ? null : new ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo(new Integer(bean.getOrderDetails().getId()), bean.getOrderDetails().getVersion());
		this.displaytimesupplied = bean.getDisplayTimeSupplied();
		this.ordinvseq = bean.getOrdInvSeq();
		this.examreqonafterdate = bean.getExamReqOnAfterDate() == null ? null : bean.getExamReqOnAfterDate().buildDate();
		this.entertheatredate = bean.getEnterTheatreDate() == null ? null : bean.getEnterTheatreDate().buildDateTime();
		this.startproceduredate = bean.getStartProcedureDate() == null ? null : bean.getStartProcedureDate().buildDateTime();
		this.endproceduredate = bean.getEndProcedureDate() == null ? null : bean.getEndProcedureDate().buildDateTime();
		this.leaverecoverydate = bean.getLeaveRecoveryDate() == null ? null : bean.getLeaveRecoveryDate().buildDateTime();
		this.accessionnumber = bean.getAccessionNumber();
		this.wassecondarymatchingused = bean.getWasSecondaryMatchingUsed();
		this.resultspecimentype = bean.getResultSpecimenType() == null ? null : bean.getResultSpecimenType().buildLookupInstVo();
		this.resultdemographics = bean.getResultDemographics() == null ? null : bean.getResultDemographics().buildVo();
		this.resultdetails = bean.getResultDetails() == null ? null : bean.getResultDetails().buildVo();
		this.expecteddatetime = bean.getExpectedDateTime() == null ? null : bean.getExpectedDateTime().buildDateTime();
		this.reorderreason = bean.getReorderReason();
		this.resultsortdate = bean.getResultSortDate() == null ? null : bean.getResultSortDate().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocs_if.vo.beans.IfOrderInvestigationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.orderpriority = bean.getOrderPriority() == null ? null : ims.ocrr.vo.lookups.OrderPriority.buildLookup(bean.getOrderPriority());
		this.repdatetime = bean.getRepDateTime() == null ? null : bean.getRepDateTime().buildDateTime();
		this.reptimesupplied = bean.getRepTimeSupplied();
		this.displaydatetime = bean.getDisplayDateTime() == null ? null : bean.getDisplayDateTime().buildDateTime();
		this.displayflag = bean.getDisplayFlag() == null ? null : ims.ocrr.vo.lookups.OcsDisplayFlag.buildLookup(bean.getDisplayFlag());
		this.wasordered = bean.getWasOrdered();
		this.resultstatus = bean.getResultStatus() == null ? null : ims.ocrr.vo.lookups.ResultStatus.buildLookup(bean.getResultStatus());
		this.ordinvcurrentstatus = bean.getOrdInvCurrentStatus() == null ? null : bean.getOrdInvCurrentStatus().buildVo(map);
		this.fillerordnum = bean.getFillerOrdNum();
		this.specimen = ims.ocs_if.vo.IfOrderSpecimenVoCollection.buildFromBeanCollection(bean.getSpecimen());
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDateTime();
		this.reasonforstudy = bean.getReasonForStudy();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo(map);
		this.orderdetails = bean.getOrderDetails() == null ? null : new ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo(new Integer(bean.getOrderDetails().getId()), bean.getOrderDetails().getVersion());
		this.displaytimesupplied = bean.getDisplayTimeSupplied();
		this.ordinvseq = bean.getOrdInvSeq();
		this.examreqonafterdate = bean.getExamReqOnAfterDate() == null ? null : bean.getExamReqOnAfterDate().buildDate();
		this.entertheatredate = bean.getEnterTheatreDate() == null ? null : bean.getEnterTheatreDate().buildDateTime();
		this.startproceduredate = bean.getStartProcedureDate() == null ? null : bean.getStartProcedureDate().buildDateTime();
		this.endproceduredate = bean.getEndProcedureDate() == null ? null : bean.getEndProcedureDate().buildDateTime();
		this.leaverecoverydate = bean.getLeaveRecoveryDate() == null ? null : bean.getLeaveRecoveryDate().buildDateTime();
		this.accessionnumber = bean.getAccessionNumber();
		this.wassecondarymatchingused = bean.getWasSecondaryMatchingUsed();
		this.resultspecimentype = bean.getResultSpecimenType() == null ? null : bean.getResultSpecimenType().buildLookupInstVo();
		this.resultdemographics = bean.getResultDemographics() == null ? null : bean.getResultDemographics().buildVo(map);
		this.resultdetails = bean.getResultDetails() == null ? null : bean.getResultDetails().buildVo(map);
		this.expecteddatetime = bean.getExpectedDateTime() == null ? null : bean.getExpectedDateTime().buildDateTime();
		this.reorderreason = bean.getReorderReason();
		this.resultsortdate = bean.getResultSortDate() == null ? null : bean.getResultSortDate().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocs_if.vo.beans.IfOrderInvestigationVoBean bean = null;
		if(map != null)
			bean = (ims.ocs_if.vo.beans.IfOrderInvestigationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocs_if.vo.beans.IfOrderInvestigationVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("ORDERPRIORITY"))
			return getOrderPriority();
		if(fieldName.equals("REPDATETIME"))
			return getRepDateTime();
		if(fieldName.equals("REPTIMESUPPLIED"))
			return getRepTimeSupplied();
		if(fieldName.equals("DISPLAYDATETIME"))
			return getDisplayDateTime();
		if(fieldName.equals("DISPLAYFLAG"))
			return getDisplayFlag();
		if(fieldName.equals("WASORDERED"))
			return getWasOrdered();
		if(fieldName.equals("RESULTSTATUS"))
			return getResultStatus();
		if(fieldName.equals("ORDINVCURRENTSTATUS"))
			return getOrdInvCurrentStatus();
		if(fieldName.equals("FILLERORDNUM"))
			return getFillerOrdNum();
		if(fieldName.equals("SPECIMEN"))
			return getSpecimen();
		if(fieldName.equals("APPOINTMENTDATE"))
			return getAppointmentDate();
		if(fieldName.equals("REASONFORSTUDY"))
			return getReasonForStudy();
		if(fieldName.equals("INVESTIGATION"))
			return getInvestigation();
		if(fieldName.equals("ORDERDETAILS"))
			return getOrderDetails();
		if(fieldName.equals("DISPLAYTIMESUPPLIED"))
			return getDisplayTimeSupplied();
		if(fieldName.equals("ORDINVSEQ"))
			return getOrdInvSeq();
		if(fieldName.equals("EXAMREQONAFTERDATE"))
			return getExamReqOnAfterDate();
		if(fieldName.equals("ENTERTHEATREDATE"))
			return getEnterTheatreDate();
		if(fieldName.equals("STARTPROCEDUREDATE"))
			return getStartProcedureDate();
		if(fieldName.equals("ENDPROCEDUREDATE"))
			return getEndProcedureDate();
		if(fieldName.equals("LEAVERECOVERYDATE"))
			return getLeaveRecoveryDate();
		if(fieldName.equals("ACCESSIONNUMBER"))
			return getAccessionNumber();
		if(fieldName.equals("WASSECONDARYMATCHINGUSED"))
			return getWasSecondaryMatchingUsed();
		if(fieldName.equals("RESULTSPECIMENTYPE"))
			return getResultSpecimenType();
		if(fieldName.equals("RESULTDEMOGRAPHICS"))
			return getResultDemographics();
		if(fieldName.equals("RESULTDETAILS"))
			return getResultDetails();
		if(fieldName.equals("EXPECTEDDATETIME"))
			return getExpectedDateTime();
		if(fieldName.equals("REORDERREASON"))
			return getReorderReason();
		if(fieldName.equals("RESULTSORTDATE"))
			return getResultSortDate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getOrderPriorityIsNotNull()
	{
		return this.orderpriority != null;
	}
	public ims.ocrr.vo.lookups.OrderPriority getOrderPriority()
	{
		return this.orderpriority;
	}
	public void setOrderPriority(ims.ocrr.vo.lookups.OrderPriority value)
	{
		this.isValidated = false;
		this.orderpriority = value;
	}
	public boolean getRepDateTimeIsNotNull()
	{
		return this.repdatetime != null;
	}
	public ims.framework.utils.DateTime getRepDateTime()
	{
		return this.repdatetime;
	}
	public void setRepDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.repdatetime = value;
	}
	public boolean getRepTimeSuppliedIsNotNull()
	{
		return this.reptimesupplied != null;
	}
	public Boolean getRepTimeSupplied()
	{
		return this.reptimesupplied;
	}
	public void setRepTimeSupplied(Boolean value)
	{
		this.isValidated = false;
		this.reptimesupplied = value;
	}
	public boolean getDisplayDateTimeIsNotNull()
	{
		return this.displaydatetime != null;
	}
	public ims.framework.utils.DateTime getDisplayDateTime()
	{
		return this.displaydatetime;
	}
	public void setDisplayDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.displaydatetime = value;
	}
	public boolean getDisplayFlagIsNotNull()
	{
		return this.displayflag != null;
	}
	public ims.ocrr.vo.lookups.OcsDisplayFlag getDisplayFlag()
	{
		return this.displayflag;
	}
	public void setDisplayFlag(ims.ocrr.vo.lookups.OcsDisplayFlag value)
	{
		this.isValidated = false;
		this.displayflag = value;
	}
	public boolean getWasOrderedIsNotNull()
	{
		return this.wasordered != null;
	}
	public Boolean getWasOrdered()
	{
		return this.wasordered;
	}
	public void setWasOrdered(Boolean value)
	{
		this.isValidated = false;
		this.wasordered = value;
	}
	public boolean getResultStatusIsNotNull()
	{
		return this.resultstatus != null;
	}
	public ims.ocrr.vo.lookups.ResultStatus getResultStatus()
	{
		return this.resultstatus;
	}
	public void setResultStatus(ims.ocrr.vo.lookups.ResultStatus value)
	{
		this.isValidated = false;
		this.resultstatus = value;
	}
	public boolean getOrdInvCurrentStatusIsNotNull()
	{
		return this.ordinvcurrentstatus != null;
	}
	public ims.ocs_if.vo.IfOrderInvCurrentStatusVo getOrdInvCurrentStatus()
	{
		return this.ordinvcurrentstatus;
	}
	public void setOrdInvCurrentStatus(ims.ocs_if.vo.IfOrderInvCurrentStatusVo value)
	{
		this.isValidated = false;
		this.ordinvcurrentstatus = value;
	}
	public boolean getFillerOrdNumIsNotNull()
	{
		return this.fillerordnum != null;
	}
	public String getFillerOrdNum()
	{
		return this.fillerordnum;
	}
	public static int getFillerOrdNumMaxLength()
	{
		return 20;
	}
	public void setFillerOrdNum(String value)
	{
		this.isValidated = false;
		this.fillerordnum = value;
	}
	public boolean getSpecimenIsNotNull()
	{
		return this.specimen != null;
	}
	public ims.ocs_if.vo.IfOrderSpecimenVoCollection getSpecimen()
	{
		return this.specimen;
	}
	public void setSpecimen(ims.ocs_if.vo.IfOrderSpecimenVoCollection value)
	{
		this.isValidated = false;
		this.specimen = value;
	}
	public boolean getAppointmentDateIsNotNull()
	{
		return this.appointmentdate != null;
	}
	public ims.framework.utils.DateTime getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.appointmentdate = value;
	}
	public boolean getReasonForStudyIsNotNull()
	{
		return this.reasonforstudy != null;
	}
	public String getReasonForStudy()
	{
		return this.reasonforstudy;
	}
	public static int getReasonForStudyMaxLength()
	{
		return 150;
	}
	public void setReasonForStudy(String value)
	{
		this.isValidated = false;
		this.reasonforstudy = value;
	}
	public boolean getInvestigationIsNotNull()
	{
		return this.investigation != null;
	}
	public ims.ocs_if.vo.IfInvestigationLiteVo getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocs_if.vo.IfInvestigationLiteVo value)
	{
		this.isValidated = false;
		this.investigation = value;
	}
	public boolean getOrderDetailsIsNotNull()
	{
		return this.orderdetails != null;
	}
	public ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo getOrderDetails()
	{
		return this.orderdetails;
	}
	public void setOrderDetails(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo value)
	{
		this.isValidated = false;
		this.orderdetails = value;
	}
	public boolean getDisplayTimeSuppliedIsNotNull()
	{
		return this.displaytimesupplied != null;
	}
	public Boolean getDisplayTimeSupplied()
	{
		return this.displaytimesupplied;
	}
	public void setDisplayTimeSupplied(Boolean value)
	{
		this.isValidated = false;
		this.displaytimesupplied = value;
	}
	public boolean getOrdInvSeqIsNotNull()
	{
		return this.ordinvseq != null;
	}
	public Integer getOrdInvSeq()
	{
		return this.ordinvseq;
	}
	public void setOrdInvSeq(Integer value)
	{
		this.isValidated = false;
		this.ordinvseq = value;
	}
	public boolean getExamReqOnAfterDateIsNotNull()
	{
		return this.examreqonafterdate != null;
	}
	public ims.framework.utils.Date getExamReqOnAfterDate()
	{
		return this.examreqonafterdate;
	}
	public void setExamReqOnAfterDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.examreqonafterdate = value;
	}
	public boolean getEnterTheatreDateIsNotNull()
	{
		return this.entertheatredate != null;
	}
	public ims.framework.utils.DateTime getEnterTheatreDate()
	{
		return this.entertheatredate;
	}
	public void setEnterTheatreDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.entertheatredate = value;
	}
	public boolean getStartProcedureDateIsNotNull()
	{
		return this.startproceduredate != null;
	}
	public ims.framework.utils.DateTime getStartProcedureDate()
	{
		return this.startproceduredate;
	}
	public void setStartProcedureDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.startproceduredate = value;
	}
	public boolean getEndProcedureDateIsNotNull()
	{
		return this.endproceduredate != null;
	}
	public ims.framework.utils.DateTime getEndProcedureDate()
	{
		return this.endproceduredate;
	}
	public void setEndProcedureDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.endproceduredate = value;
	}
	public boolean getLeaveRecoveryDateIsNotNull()
	{
		return this.leaverecoverydate != null;
	}
	public ims.framework.utils.DateTime getLeaveRecoveryDate()
	{
		return this.leaverecoverydate;
	}
	public void setLeaveRecoveryDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.leaverecoverydate = value;
	}
	public boolean getAccessionNumberIsNotNull()
	{
		return this.accessionnumber != null;
	}
	public String getAccessionNumber()
	{
		return this.accessionnumber;
	}
	public static int getAccessionNumberMaxLength()
	{
		return 200;
	}
	public void setAccessionNumber(String value)
	{
		this.isValidated = false;
		this.accessionnumber = value;
	}
	public boolean getWasSecondaryMatchingUsedIsNotNull()
	{
		return this.wassecondarymatchingused != null;
	}
	public Boolean getWasSecondaryMatchingUsed()
	{
		return this.wassecondarymatchingused;
	}
	public void setWasSecondaryMatchingUsed(Boolean value)
	{
		this.isValidated = false;
		this.wassecondarymatchingused = value;
	}
	public boolean getResultSpecimenTypeIsNotNull()
	{
		return this.resultspecimentype != null;
	}
	public ims.vo.LookupInstVo getResultSpecimenType()
	{
		return this.resultspecimentype;
	}
	public void setResultSpecimenType(ims.vo.LookupInstVo value)
	{
		this.isValidated = false;
		this.resultspecimentype = value;
	}
	public boolean getResultDemographicsIsNotNull()
	{
		return this.resultdemographics != null;
	}
	public ims.ocrr.vo.ResultDemographicsVo getResultDemographics()
	{
		return this.resultdemographics;
	}
	public void setResultDemographics(ims.ocrr.vo.ResultDemographicsVo value)
	{
		this.isValidated = false;
		this.resultdemographics = value;
	}
	public boolean getResultDetailsIsNotNull()
	{
		return this.resultdetails != null;
	}
	public ims.ocs_if.vo.IfResultDetailsVo getResultDetails()
	{
		return this.resultdetails;
	}
	public void setResultDetails(ims.ocs_if.vo.IfResultDetailsVo value)
	{
		this.isValidated = false;
		this.resultdetails = value;
	}
	public boolean getExpectedDateTimeIsNotNull()
	{
		return this.expecteddatetime != null;
	}
	public ims.framework.utils.DateTime getExpectedDateTime()
	{
		return this.expecteddatetime;
	}
	public void setExpectedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.expecteddatetime = value;
	}
	public boolean getReorderReasonIsNotNull()
	{
		return this.reorderreason != null;
	}
	public String getReorderReason()
	{
		return this.reorderreason;
	}
	public static int getReorderReasonMaxLength()
	{
		return 255;
	}
	public void setReorderReason(String value)
	{
		this.isValidated = false;
		this.reorderreason = value;
	}
	public boolean getResultSortDateIsNotNull()
	{
		return this.resultsortdate != null;
	}
	public ims.framework.utils.DateTime getResultSortDate()
	{
		return this.resultsortdate;
	}
	public void setResultSortDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.resultsortdate = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.ordinvcurrentstatus != null)
		{
			if(!this.ordinvcurrentstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.specimen != null)
		{
			if(!this.specimen.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.investigation != null)
		{
			if(!this.investigation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.resultdemographics != null)
		{
			if(!this.resultdemographics.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.resultdetails != null)
		{
			if(!this.resultdetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.displaydatetime == null)
			listOfErrors.add("DisplayDateTime is mandatory");
		if(this.displayflag == null)
			listOfErrors.add("DisplayFlag is mandatory");
		if(this.wasordered == null)
			listOfErrors.add("wasOrdered is mandatory");
		if(this.ordinvcurrentstatus == null)
			listOfErrors.add("OrdInvCurrentStatus is mandatory");
		if(this.ordinvcurrentstatus != null)
		{
			String[] listOfOtherErrors = this.ordinvcurrentstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.fillerordnum != null)
			if(this.fillerordnum.length() > 20)
				listOfErrors.add("The length of the field [fillerordnum] in the value object [ims.ocs_if.vo.IfOrderInvestigationVo] is too big. It should be less or equal to 20");
		if(this.specimen != null)
		{
			String[] listOfOtherErrors = this.specimen.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.reasonforstudy != null)
			if(this.reasonforstudy.length() > 150)
				listOfErrors.add("The length of the field [reasonforstudy] in the value object [ims.ocs_if.vo.IfOrderInvestigationVo] is too big. It should be less or equal to 150");
		if(this.investigation == null)
			listOfErrors.add("Investigation is mandatory");
		if(this.investigation != null)
		{
			String[] listOfOtherErrors = this.investigation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.orderdetails == null)
			listOfErrors.add("OrderDetails is mandatory");
		if(this.displaytimesupplied == null)
			listOfErrors.add("DisplayTimeSupplied is mandatory");
		if(this.ordinvseq == null)
			listOfErrors.add("ordInvSeq is mandatory");
		if(this.accessionnumber != null)
			if(this.accessionnumber.length() > 200)
				listOfErrors.add("The length of the field [accessionnumber] in the value object [ims.ocs_if.vo.IfOrderInvestigationVo] is too big. It should be less or equal to 200");
		if(this.resultdemographics != null)
		{
			String[] listOfOtherErrors = this.resultdemographics.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.resultdetails != null)
		{
			String[] listOfOtherErrors = this.resultdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.reorderreason != null)
			if(this.reorderreason.length() > 255)
				listOfErrors.add("The length of the field [reorderreason] in the value object [ims.ocs_if.vo.IfOrderInvestigationVo] is too big. It should be less or equal to 255");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		IfOrderInvestigationVo clone = new IfOrderInvestigationVo(this.id, this.version);
		
		if(this.orderpriority == null)
			clone.orderpriority = null;
		else
			clone.orderpriority = (ims.ocrr.vo.lookups.OrderPriority)this.orderpriority.clone();
		if(this.repdatetime == null)
			clone.repdatetime = null;
		else
			clone.repdatetime = (ims.framework.utils.DateTime)this.repdatetime.clone();
		clone.reptimesupplied = this.reptimesupplied;
		if(this.displaydatetime == null)
			clone.displaydatetime = null;
		else
			clone.displaydatetime = (ims.framework.utils.DateTime)this.displaydatetime.clone();
		if(this.displayflag == null)
			clone.displayflag = null;
		else
			clone.displayflag = (ims.ocrr.vo.lookups.OcsDisplayFlag)this.displayflag.clone();
		clone.wasordered = this.wasordered;
		if(this.resultstatus == null)
			clone.resultstatus = null;
		else
			clone.resultstatus = (ims.ocrr.vo.lookups.ResultStatus)this.resultstatus.clone();
		if(this.ordinvcurrentstatus == null)
			clone.ordinvcurrentstatus = null;
		else
			clone.ordinvcurrentstatus = (ims.ocs_if.vo.IfOrderInvCurrentStatusVo)this.ordinvcurrentstatus.clone();
		clone.fillerordnum = this.fillerordnum;
		if(this.specimen == null)
			clone.specimen = null;
		else
			clone.specimen = (ims.ocs_if.vo.IfOrderSpecimenVoCollection)this.specimen.clone();
		if(this.appointmentdate == null)
			clone.appointmentdate = null;
		else
			clone.appointmentdate = (ims.framework.utils.DateTime)this.appointmentdate.clone();
		clone.reasonforstudy = this.reasonforstudy;
		if(this.investigation == null)
			clone.investigation = null;
		else
			clone.investigation = (ims.ocs_if.vo.IfInvestigationLiteVo)this.investigation.clone();
		clone.orderdetails = this.orderdetails;
		clone.displaytimesupplied = this.displaytimesupplied;
		clone.ordinvseq = this.ordinvseq;
		if(this.examreqonafterdate == null)
			clone.examreqonafterdate = null;
		else
			clone.examreqonafterdate = (ims.framework.utils.Date)this.examreqonafterdate.clone();
		if(this.entertheatredate == null)
			clone.entertheatredate = null;
		else
			clone.entertheatredate = (ims.framework.utils.DateTime)this.entertheatredate.clone();
		if(this.startproceduredate == null)
			clone.startproceduredate = null;
		else
			clone.startproceduredate = (ims.framework.utils.DateTime)this.startproceduredate.clone();
		if(this.endproceduredate == null)
			clone.endproceduredate = null;
		else
			clone.endproceduredate = (ims.framework.utils.DateTime)this.endproceduredate.clone();
		if(this.leaverecoverydate == null)
			clone.leaverecoverydate = null;
		else
			clone.leaverecoverydate = (ims.framework.utils.DateTime)this.leaverecoverydate.clone();
		clone.accessionnumber = this.accessionnumber;
		clone.wassecondarymatchingused = this.wassecondarymatchingused;
		clone.resultspecimentype = this.resultspecimentype;
		if(this.resultdemographics == null)
			clone.resultdemographics = null;
		else
			clone.resultdemographics = (ims.ocrr.vo.ResultDemographicsVo)this.resultdemographics.clone();
		if(this.resultdetails == null)
			clone.resultdetails = null;
		else
			clone.resultdetails = (ims.ocs_if.vo.IfResultDetailsVo)this.resultdetails.clone();
		if(this.expecteddatetime == null)
			clone.expecteddatetime = null;
		else
			clone.expecteddatetime = (ims.framework.utils.DateTime)this.expecteddatetime.clone();
		clone.reorderreason = this.reorderreason;
		if(this.resultsortdate == null)
			clone.resultsortdate = null;
		else
			clone.resultsortdate = (ims.framework.utils.DateTime)this.resultsortdate.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(IfOrderInvestigationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A IfOrderInvestigationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		IfOrderInvestigationVo compareObj = (IfOrderInvestigationVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getOrdInvSeq() == null && compareObj.getOrdInvSeq() != null)
				return -1;
			if(this.getOrdInvSeq() != null && compareObj.getOrdInvSeq() == null)
				return 1;
			if(this.getOrdInvSeq() != null && compareObj.getOrdInvSeq() != null)
				retVal = this.getOrdInvSeq().compareTo(compareObj.getOrdInvSeq());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.orderpriority != null)
			count++;
		if(this.repdatetime != null)
			count++;
		if(this.reptimesupplied != null)
			count++;
		if(this.displaydatetime != null)
			count++;
		if(this.displayflag != null)
			count++;
		if(this.wasordered != null)
			count++;
		if(this.resultstatus != null)
			count++;
		if(this.ordinvcurrentstatus != null)
			count++;
		if(this.fillerordnum != null)
			count++;
		if(this.specimen != null)
			count++;
		if(this.appointmentdate != null)
			count++;
		if(this.reasonforstudy != null)
			count++;
		if(this.investigation != null)
			count++;
		if(this.orderdetails != null)
			count++;
		if(this.displaytimesupplied != null)
			count++;
		if(this.ordinvseq != null)
			count++;
		if(this.examreqonafterdate != null)
			count++;
		if(this.entertheatredate != null)
			count++;
		if(this.startproceduredate != null)
			count++;
		if(this.endproceduredate != null)
			count++;
		if(this.leaverecoverydate != null)
			count++;
		if(this.accessionnumber != null)
			count++;
		if(this.wassecondarymatchingused != null)
			count++;
		if(this.resultspecimentype != null)
			count++;
		if(this.resultdemographics != null)
			count++;
		if(this.resultdetails != null)
			count++;
		if(this.expecteddatetime != null)
			count++;
		if(this.reorderreason != null)
			count++;
		if(this.resultsortdate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 29;
	}
	protected ims.ocrr.vo.lookups.OrderPriority orderpriority;
	protected ims.framework.utils.DateTime repdatetime;
	protected Boolean reptimesupplied;
	protected ims.framework.utils.DateTime displaydatetime;
	protected ims.ocrr.vo.lookups.OcsDisplayFlag displayflag;
	protected Boolean wasordered;
	protected ims.ocrr.vo.lookups.ResultStatus resultstatus;
	protected ims.ocs_if.vo.IfOrderInvCurrentStatusVo ordinvcurrentstatus;
	protected String fillerordnum;
	protected ims.ocs_if.vo.IfOrderSpecimenVoCollection specimen;
	protected ims.framework.utils.DateTime appointmentdate;
	protected String reasonforstudy;
	protected ims.ocs_if.vo.IfInvestigationLiteVo investigation;
	protected ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo orderdetails;
	protected Boolean displaytimesupplied;
	protected Integer ordinvseq;
	protected ims.framework.utils.Date examreqonafterdate;
	protected ims.framework.utils.DateTime entertheatredate;
	protected ims.framework.utils.DateTime startproceduredate;
	protected ims.framework.utils.DateTime endproceduredate;
	protected ims.framework.utils.DateTime leaverecoverydate;
	protected String accessionnumber;
	protected Boolean wassecondarymatchingused;
	protected ims.vo.LookupInstVo resultspecimentype;
	protected ims.ocrr.vo.ResultDemographicsVo resultdemographics;
	protected ims.ocs_if.vo.IfResultDetailsVo resultdetails;
	protected ims.framework.utils.DateTime expecteddatetime;
	protected String reorderreason;
	protected ims.framework.utils.DateTime resultsortdate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
