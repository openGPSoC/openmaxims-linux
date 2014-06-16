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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.domain.DomainFactory;
import ims.emergency.domain.base.impl.BaseTriageNotesCcImpl;
import ims.emergency.vo.TriageNotesRefVo;
import ims.emergency.vo.domain.TriageNotesVoAssembler;
import ims.framework.exceptions.CodingRuntimeException;

public class TriageNotesCcImpl extends BaseTriageNotesCcImpl
{

	private static final long serialVersionUID = 1L;

	public ims.emergency.vo.TriageNotesVoCollection listNotes(ims.core.patient.vo.PatientRefVo patient, ims.core.admin.vo.EpisodeOfCareRefVo episodeOfCare, ims.core.admin.vo.CareContextRefVo careContext)
	{
		if(patient == null)
			throw new CodingRuntimeException("Cannot list TriageNotes for a null Patient Id.");
		
		String query = "from TriageNotes as tn where ";
		ArrayList<String> paramNames = new ArrayList<String>();
		ArrayList<Object> paramValues = new ArrayList<Object>();
		
		if(careContext != null)
		{
			query += " tn.attendance.id = :CareContextId ";
			paramNames.add("CareContextId");
			paramValues.add(careContext.getID_CareContext());
		}
		else if(episodeOfCare != null)
		{
			query += " tn.episode.id = :EpisodeOfCareId ";
			paramNames.add("EpisodeOfCareId");
			paramValues.add(episodeOfCare.getID_EpisodeOfCare());
		}
		else
		{
			query += " tn.patient.id = :PatientId ";
			paramNames.add("PatientId");
			paramValues.add(patient.getID_Patient());
		}
		
		query += " order by tn.authoringInformation.authoringDateTime asc ";
		
		List<?> notes = getDomainFactory().find(query, paramNames, paramValues);
		
		return TriageNotesVoAssembler.createTriageNotesVoCollectionFromTriageNotes(notes);
	}

	public Boolean isStale(TriageNotesRefVo triageNote) 
	{
		if(triageNote == null)
			return false;
		
		DomainFactory factory = getDomainFactory();
		
		List<?> notes = factory.find("select tr.id from TriageNotes as tr where tr.id = :TriageNoteId and tr.version > :TriageNoteVersion", new String[] {"TriageNoteId", "TriageNoteVersion"}, new Object[] {triageNote.getID_TriageNotes(), triageNote.getVersion_TriageNotes()});
		
		if(notes != null && notes.size() > 0)
			return true;
		
		return false;
	}
}
