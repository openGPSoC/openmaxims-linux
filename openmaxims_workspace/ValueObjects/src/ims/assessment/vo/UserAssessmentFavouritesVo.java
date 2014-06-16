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

package ims.assessment.vo;

/**
 * Linked to Assessment.Configuration.UserAssessFavourites business object (ID: 1028100018).
 */
public class UserAssessmentFavouritesVo extends ims.assessment.configuration.vo.UserAssessFavouritesRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public UserAssessmentFavouritesVo()
	{
	}
	public UserAssessmentFavouritesVo(Integer id, int version)
	{
		super(id, version);
	}
	public UserAssessmentFavouritesVo(ims.assessment.vo.beans.UserAssessmentFavouritesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo();
		this.assessmentfolder = ims.core.vo.AssessmentFolderVoCollection.buildFromBeanCollection(bean.getAssessmentFolder());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.UserAssessmentFavouritesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo(map);
		this.assessmentfolder = ims.core.vo.AssessmentFolderVoCollection.buildFromBeanCollection(bean.getAssessmentFolder());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.UserAssessmentFavouritesVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.UserAssessmentFavouritesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.UserAssessmentFavouritesVoBean();
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
		if(fieldName.equals("AUTHORINGHCP"))
			return getAuthoringHCP();
		if(fieldName.equals("ASSESSMENTFOLDER"))
			return getAssessmentFolder();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAuthoringHCPIsNotNull()
	{
		return this.authoringhcp != null;
	}
	public ims.core.vo.Hcp getAuthoringHCP()
	{
		return this.authoringhcp;
	}
	public void setAuthoringHCP(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.authoringhcp = value;
	}
	public boolean getAssessmentFolderIsNotNull()
	{
		return this.assessmentfolder != null;
	}
	public ims.core.vo.AssessmentFolderVoCollection getAssessmentFolder()
	{
		return this.assessmentfolder;
	}
	public void setAssessmentFolder(ims.core.vo.AssessmentFolderVoCollection value)
	{
		this.isValidated = false;
		this.assessmentfolder = value;
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
		if(this.authoringhcp != null)
		{
			if(!this.authoringhcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.assessmentfolder != null)
		{
			if(!this.assessmentfolder.isValidated())
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
		if(this.authoringhcp != null)
		{
			String[] listOfOtherErrors = this.authoringhcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.assessmentfolder != null)
		{
			String[] listOfOtherErrors = this.assessmentfolder.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
	
		UserAssessmentFavouritesVo clone = new UserAssessmentFavouritesVo(this.id, this.version);
		
		if(this.authoringhcp == null)
			clone.authoringhcp = null;
		else
			clone.authoringhcp = (ims.core.vo.Hcp)this.authoringhcp.clone();
		if(this.assessmentfolder == null)
			clone.assessmentfolder = null;
		else
			clone.assessmentfolder = (ims.core.vo.AssessmentFolderVoCollection)this.assessmentfolder.clone();
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
		if (!(UserAssessmentFavouritesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A UserAssessmentFavouritesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((UserAssessmentFavouritesVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((UserAssessmentFavouritesVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.authoringhcp != null)
			count++;
		if(this.assessmentfolder != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.vo.Hcp authoringhcp;
	protected ims.core.vo.AssessmentFolderVoCollection assessmentfolder;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
