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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.70 build 3420.28895)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.rules.domain.impl;


import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import ims.admin.vo.BusinessRuleVoCollection;
import ims.admin.vo.domain.BusinessRuleVoAssembler;
import ims.configuration.ImportedObject;
import ims.core.admin.domain.objects.BusinessRule;
import ims.domain.DomainFactory;
import ims.domain.DomainObject;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.hibernate3.IMSCriteria;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.CodingRuntimeException;
import ims.rules.domain.base.impl.BaseRulesListImpl;

public class RulesListImpl extends BaseRulesListImpl
{

	private static final long serialVersionUID = 1L;

	public BusinessRuleVoCollection listRules(Boolean activeOnly, String name, String entityID) throws DomainInterfaceException
	{
		DomainFactory factory = getDomainFactory();
		
		IMSCriteria criteria = new IMSCriteria(BusinessRule.class, factory);

		if (activeOnly)
		{
			criteria.equal("this.active", true);
		}
		
		if (name != null && name.length() > 0)
		{
			criteria.like("this.name", "%" + name + "%");
		}
		
		if (entityID != null)
		{
			criteria.equal("this.rootEntity", entityID);
		}
		
		List list = criteria.find();
		Collections.sort(list, new BusinessRuleComparator(SortOrder.DESCENDING));
		
		return BusinessRuleVoAssembler.createBusinessRuleVoCollectionFromBusinessRule(list);
	}

	/**
	 * 
	 * @author gjosan
	 *
	 */
	public class BusinessRuleComparator implements Comparator
	{
		private int direction = 1;
		
		public BusinessRuleComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public BusinessRuleComparator(SortOrder order)
		{
			if (SortOrder.DESCENDING.equals(order))
			{
				direction = -1;
			}
		}
		
		public int compare(Object arg0, Object arg1)
		{
			if (!(arg0 instanceof BusinessRule) || ! (arg1 instanceof BusinessRule))
				throw new CodingRuntimeException("Major Logical Problem - Data type mismatch on BusinessRuleVoComparator");

			BusinessRule ruleVo0 = (BusinessRule) arg0;
			BusinessRule ruleVo1 = (BusinessRule) arg1;
			
			if (ruleVo0.getPriority().compareTo(ruleVo1.getPriority()) == 0)
			{
				return ruleVo0.getName().compareTo(ruleVo1.getName());
			}
			
			return direction * ruleVo0.getPriority().compareTo(ruleVo1.getPriority());
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//	Export Region
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 *	Function used to get XML string for a object
	 */
	public String getObjectXML(String className, Integer objectID) throws StaleObjectException
	{
		// Check the parameters
		if (className == null || className.length() == 0)
			throw new CodingRuntimeException("Invalid Parameters - className can not be null or empty string");
		
		if (objectID == null)
			throw new CodingRuntimeException("Invalid Parameters - objectID can not be null");
		
		DomainFactory factory = getDomainFactory();
		
		try
		{
			// Get the domain object
			Class c = Class.forName(className);
			DomainObject domObject = factory.getDomainObject(c, objectID);
			
			if (domObject != null)
			{
				HashMap domMap = new HashMap(); 
				String xml =  domObject.toXMLString(domMap);
				
				// Loop through DomMap, for all occurrences of ImportedObj, we will want to save it
				Iterator iter = domMap.values().iterator();
				while (iter.hasNext())
				{
					DomainObject importedObj = (DomainObject) iter.next();
					if (importedObj instanceof ImportedObject)
					{
						ImportedObject impObj = (ImportedObject)importedObj;
						factory.saveImport(impObj.getDomainObject(), impObj.getExternalSource(), impObj.getExternalId());
					}
				}
				
				return xml;
			}
			else
				return null;
		}
		catch (ClassNotFoundException e)
		{
			throw new DomainRuntimeException(e);
		}
	}
}
