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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.65 build 3187.17423)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.patientdocumentsview;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.enums.DocumentViewLevel;
import ims.core.vo.enums.UploadDocumentStoreLevel;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{	
	private static final long serialVersionUID = 1L;

	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{	
		UploadDocumentStoreLevel storeLevel = null;//WDEV-14160
		
		//WDEV-14160
		if(args != null && args.length > 0)
		{
			if(args[0] instanceof UploadDocumentStoreLevel)
			{
				storeLevel = (UploadDocumentStoreLevel) args[0];
			}
		}
		
		form.getLocalContext().setSelectedRecord(null);
		form.ccListDocuments().initialize(null, (storeLevel != null ? storeLevel : getMinContextForScanImport()), getDocumentViewLevel());//WDEV-14160
		form.ccListDocuments().setMode(FormMode.EDIT);
			
				
	}

	private DocumentViewLevel getDocumentViewLevel()
	{
		String value = ConfigFlag.GEN.DOCUMENT_VIEW_LEVEL.getValue();
		if (value == null)
			return null;
		if (value.equals(DocumentViewLevel.CARECONTEXT.getText()))
			return DocumentViewLevel.CARECONTEXT;
		if (value.equals(DocumentViewLevel.PATIENT.getText()))
			return DocumentViewLevel.PATIENT;
		if (value.equals(DocumentViewLevel.REFERRAL.getText()))
			return DocumentViewLevel.REFERRAL;
		return null;
	}
	
	private UploadDocumentStoreLevel getMinContextForScanImport()
	{
		String value = ConfigFlag.GEN.MINIMUM_CONTEXT_REQUIRED_TO_SCAN_OR_IMPORT.getValue();
		if (value == null)
			return UploadDocumentStoreLevel.NONE;
		if (value.equals(UploadDocumentStoreLevel.CARECONTEXT.getText()))
			return UploadDocumentStoreLevel.CARECONTEXT;
		if (value.equals(UploadDocumentStoreLevel.EPISODEOFCARE.getText()))
			return UploadDocumentStoreLevel.EPISODEOFCARE;
		if (value.equals(UploadDocumentStoreLevel.PATIENT.getText()))
			return UploadDocumentStoreLevel.PATIENT;
		if (value.equals(UploadDocumentStoreLevel.REFERRAL.getText()))
			return UploadDocumentStoreLevel.REFERRAL;
		return UploadDocumentStoreLevel.NONE;
	}

	

	@Override
	protected void onCcListDocumentsValueChanged() throws PresentationLogicException 
	{
		form.getLocalContext().setSelectedRecord(form.ccListDocuments().getSelectedRecord());		
	}

	@Override
	protected void onRIEDialogOpened() throws PresentationLogicException 
	{
		form.ccListDocuments().hideHtmlControl();		
	}

	@Override
	protected void onRIEDialogClosed(DialogResult result) throws PresentationLogicException 
	{
		form.ccListDocuments().showHtmlControl();				
	}
}
