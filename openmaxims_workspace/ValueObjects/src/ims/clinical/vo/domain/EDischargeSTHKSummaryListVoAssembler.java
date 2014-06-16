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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 16/04/2014, 12:31
 *
 */
package ims.clinical.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Rory Fitzpatrick
 */
public class EDischargeSTHKSummaryListVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.clinical.vo.EDischargeSTHKSummaryListVo copy(ims.clinical.vo.EDischargeSTHKSummaryListVo valueObjectDest, ims.clinical.vo.EDischargeSTHKSummaryListVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_Summary(valueObjectSrc.getID_Summary());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// CareContext
		valueObjectDest.setCareContext(valueObjectSrc.getCareContext());
		// DischargeLetterStatus
		valueObjectDest.setDischargeLetterStatus(valueObjectSrc.getDischargeLetterStatus());
		// SummaryDetails
		valueObjectDest.setSummaryDetails(valueObjectSrc.getSummaryDetails());
		// DischargeDetails
		valueObjectDest.setDischargeDetails(valueObjectSrc.getDischargeDetails());
		// TTAStatus
		valueObjectDest.setTTAStatus(valueObjectSrc.getTTAStatus());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createEDischargeSTHKSummaryListVoCollectionFromSummary(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.edischarge.domain.objects.Summary objects.
	 */
	public static ims.clinical.vo.EDischargeSTHKSummaryListVoCollection createEDischargeSTHKSummaryListVoCollectionFromSummary(java.util.Set domainObjectSet)	
	{
		return createEDischargeSTHKSummaryListVoCollectionFromSummary(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.edischarge.domain.objects.Summary objects.
	 */
	public static ims.clinical.vo.EDischargeSTHKSummaryListVoCollection createEDischargeSTHKSummaryListVoCollectionFromSummary(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.clinical.vo.EDischargeSTHKSummaryListVoCollection voList = new ims.clinical.vo.EDischargeSTHKSummaryListVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.edischarge.domain.objects.Summary domainObject = (ims.edischarge.domain.objects.Summary) iterator.next();
			ims.clinical.vo.EDischargeSTHKSummaryListVo vo = create(map, domainObject);
			
			if (vo != null)
				voList.add(vo);
				
			if (domainObject != null)
			{				
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param domainObjectList - List of ims.edischarge.domain.objects.Summary objects.
	 */
	public static ims.clinical.vo.EDischargeSTHKSummaryListVoCollection createEDischargeSTHKSummaryListVoCollectionFromSummary(java.util.List domainObjectList) 
	{
		return createEDischargeSTHKSummaryListVoCollectionFromSummary(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.edischarge.domain.objects.Summary objects.
	 */
	public static ims.clinical.vo.EDischargeSTHKSummaryListVoCollection createEDischargeSTHKSummaryListVoCollectionFromSummary(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.clinical.vo.EDischargeSTHKSummaryListVoCollection voList = new ims.clinical.vo.EDischargeSTHKSummaryListVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.edischarge.domain.objects.Summary domainObject = (ims.edischarge.domain.objects.Summary) domainObjectList.get(i);
			ims.clinical.vo.EDischargeSTHKSummaryListVo vo = create(map, domainObject);

			if (vo != null)
				voList.add(vo);
			
			if (domainObject != null)
			{
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ims.edischarge.domain.objects.Summary set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractSummarySet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.EDischargeSTHKSummaryListVoCollection voCollection) 
	 {
	 	return extractSummarySet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractSummarySet(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.EDischargeSTHKSummaryListVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.clinical.vo.EDischargeSTHKSummaryListVo vo = voCollection.get(i);
			ims.edischarge.domain.objects.Summary domainObject = EDischargeSTHKSummaryListVoAssembler.extractSummary(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainObjectSet.contains(domainObject)) domainObjectSet.add(domainObject);
			newSet.add(domainObject);			
		}
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = domainObjectSet.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			domainObjectSet.remove(iter.next());
		}
		return domainObjectSet;	 
	 }


	/**
	 * Create the ims.edischarge.domain.objects.Summary list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractSummaryList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.EDischargeSTHKSummaryListVoCollection voCollection) 
	 {
	 	return extractSummaryList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractSummaryList(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.EDischargeSTHKSummaryListVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.clinical.vo.EDischargeSTHKSummaryListVo vo = voCollection.get(i);
			ims.edischarge.domain.objects.Summary domainObject = EDischargeSTHKSummaryListVoAssembler.extractSummary(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}

			int domIdx = domainObjectList.indexOf(domainObject);
			if (domIdx == -1)
			{
				domainObjectList.add(i, domainObject);
			}
			else if (i != domIdx && i < domainObjectList.size())
			{
				Object tmp = domainObjectList.get(i);
				domainObjectList.set(i, domainObjectList.get(domIdx));
				domainObjectList.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=domainObjectList.size();
		while (i1 > size)
		{
			domainObjectList.remove(i1-1);
			i1=domainObjectList.size();
		}
		return domainObjectList;	 
	 }

 

	/**
	 * Create the ValueObject from the ims.edischarge.domain.objects.Summary object.
	 * @param domainObject ims.edischarge.domain.objects.Summary
	 */
	 public static ims.clinical.vo.EDischargeSTHKSummaryListVo create(ims.edischarge.domain.objects.Summary domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.edischarge.domain.objects.Summary object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.clinical.vo.EDischargeSTHKSummaryListVo create(DomainObjectMap map, ims.edischarge.domain.objects.Summary domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.clinical.vo.EDischargeSTHKSummaryListVo valueObject = (ims.clinical.vo.EDischargeSTHKSummaryListVo) map.getValueObject(domainObject, ims.clinical.vo.EDischargeSTHKSummaryListVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.clinical.vo.EDischargeSTHKSummaryListVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.edischarge.domain.objects.Summary
	 */
	 public static ims.clinical.vo.EDischargeSTHKSummaryListVo insert(ims.clinical.vo.EDischargeSTHKSummaryListVo valueObject, ims.edischarge.domain.objects.Summary domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
		DomainObjectMap map = new DomainObjectMap();
		return insert(map, valueObject, domainObject);
	 }
	 
	/**
	 * Update the ValueObject with the Domain Object.
	 * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	 * @param valueObject to be updated
	 * @param domainObject ims.edischarge.domain.objects.Summary
	 */
	 public static ims.clinical.vo.EDischargeSTHKSummaryListVo insert(DomainObjectMap map, ims.clinical.vo.EDischargeSTHKSummaryListVo valueObject, ims.edischarge.domain.objects.Summary domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_Summary(domainObject.getId());
		valueObject.setIsRIE(domainObject.getIsRIE());
		
		// If this is a recordedInError record, and the domainObject
		// value isIncludeRecord has not been set, then we return null and
		// not the value object
		if (valueObject.getIsRIE() != null && valueObject.getIsRIE().booleanValue() == true && !domainObject.isIncludeRecord())
			return null;
			
		// If this is not a recordedInError record, and the domainObject
		// value isIncludeRecord has been set, then we return null and
		// not the value object
		if ((valueObject.getIsRIE() == null || valueObject.getIsRIE().booleanValue() == false) && domainObject.isIncludeRecord())
			return null;
			
		// CareContext
		valueObject.setCareContext(ims.core.vo.domain.CareContextEdischargeListVoAssembler.create(map, domainObject.getCareContext()) );
		// DischargeLetterStatus
		ims.domain.lookups.LookupInstance instance2 = domainObject.getDischargeLetterStatus();
		if ( null != instance2 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance2.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance2.getImage().getImageId(), instance2.getImage().getImagePath());
			}
			color = instance2.getColor();
			if (color != null) 
				color.getValue();

			ims.clinical.vo.lookups.DischargeLetterStatus voLookup2 = new ims.clinical.vo.lookups.DischargeLetterStatus(instance2.getId(),instance2.getText(), instance2.isActive(), null, img, color);
			ims.clinical.vo.lookups.DischargeLetterStatus parentVoLookup2 = voLookup2;
			ims.domain.lookups.LookupInstance parent2 = instance2.getParent();
			while (parent2 != null)
			{
				if (parent2.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent2.getImage().getImageId(), parent2.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent2.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup2.setParent(new ims.clinical.vo.lookups.DischargeLetterStatus(parent2.getId(),parent2.getText(), parent2.isActive(), null, img, color));
				parentVoLookup2 = parentVoLookup2.getParent();
								parent2 = parent2.getParent();
			}			
			valueObject.setDischargeLetterStatus(voLookup2);
		}
				// SummaryDetails
		valueObject.setSummaryDetails(ims.clinical.vo.domain.EDischargeSTHKSummaryDetailVoAssembler.createEDischargeSTHKSummaryDetailVoCollectionFromSummaryDetail(map, domainObject.getSummaryDetails()) );
		// DischargeDetails
		valueObject.setDischargeDetails(ims.clinical.vo.domain.DischargeDetailsListVoAssembler.create(map, domainObject.getDischargeDetails()) );
		// TTAStatus
		ims.domain.lookups.LookupInstance instance5 = domainObject.getTTAStatus();
		if ( null != instance5 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance5.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance5.getImage().getImageId(), instance5.getImage().getImagePath());
			}
			color = instance5.getColor();
			if (color != null) 
				color.getValue();

			ims.clinical.vo.lookups.TTAStatus voLookup5 = new ims.clinical.vo.lookups.TTAStatus(instance5.getId(),instance5.getText(), instance5.isActive(), null, img, color);
			ims.clinical.vo.lookups.TTAStatus parentVoLookup5 = voLookup5;
			ims.domain.lookups.LookupInstance parent5 = instance5.getParent();
			while (parent5 != null)
			{
				if (parent5.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent5.getImage().getImageId(), parent5.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent5.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup5.setParent(new ims.clinical.vo.lookups.TTAStatus(parent5.getId(),parent5.getText(), parent5.isActive(), null, img, color));
				parentVoLookup5 = parentVoLookup5.getParent();
								parent5 = parent5.getParent();
			}			
			valueObject.setTTAStatus(voLookup5);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.edischarge.domain.objects.Summary extractSummary(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.EDischargeSTHKSummaryListVo valueObject) 
	{
		return 	extractSummary(domainFactory, valueObject, new HashMap());
	}

	public static ims.edischarge.domain.objects.Summary extractSummary(ims.domain.ILightweightDomainFactory domainFactory, ims.clinical.vo.EDischargeSTHKSummaryListVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_Summary();
		ims.edischarge.domain.objects.Summary domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.edischarge.domain.objects.Summary)domMap.get(valueObject);
			}
			// ims.clinical.vo.EDischargeSTHKSummaryListVo ID_Summary field is unknown
			domainObject = new ims.edischarge.domain.objects.Summary();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_Summary());
			if (domMap.get(key) != null)
			{
				return (ims.edischarge.domain.objects.Summary)domMap.get(key);
			}
			domainObject = (ims.edischarge.domain.objects.Summary) domainFactory.getDomainObject(ims.edischarge.domain.objects.Summary.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_Summary());

		domainObject.setCareContext(ims.core.vo.domain.CareContextEdischargeListVoAssembler.extractCareContext(domainFactory, valueObject.getCareContext(), domMap));
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value2 = null;
		if ( null != valueObject.getDischargeLetterStatus() ) 
		{
			value2 =
				domainFactory.getLookupInstance(valueObject.getDischargeLetterStatus().getID());
		}
		domainObject.setDischargeLetterStatus(value2);

		// SaveAsRefVO treated as RefValueObject
		ims.edischarge.vo.SummaryDetailRefVoCollection refCollection3 = new ims.edischarge.vo.SummaryDetailRefVoCollection();
		if (valueObject.getSummaryDetails() != null)
		{
			for (int i3=0; i3<valueObject.getSummaryDetails().size(); i3++)
			{
				ims.edischarge.vo.SummaryDetailRefVo ref3 = (ims.edischarge.vo.SummaryDetailRefVo)valueObject.getSummaryDetails().get(i3);
				refCollection3.add(ref3);
			}
		}
		int size3 = (null == refCollection3) ? 0 : refCollection3.size();		
		java.util.List domainSummaryDetails3 = domainObject.getSummaryDetails();
		if (domainSummaryDetails3 == null)
		{
			domainSummaryDetails3 = new java.util.ArrayList();
		}
		for(int i=0; i < size3; i++) 
		{
			ims.edischarge.vo.SummaryDetailRefVo vo = refCollection3.get(i);			
			ims.edischarge.domain.objects.SummaryDetail dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.edischarge.domain.objects.SummaryDetail)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.edischarge.domain.objects.SummaryDetail)domainFactory.getDomainObject( ims.edischarge.domain.objects.SummaryDetail.class, vo.getBoId());
				}
			}

			int domIdx = domainSummaryDetails3.indexOf(dom);
			if (domIdx == -1)
			{
				domainSummaryDetails3.add(i, dom);
			}
			else if (i != domIdx && i < domainSummaryDetails3.size())
			{
				Object tmp = domainSummaryDetails3.get(i);
				domainSummaryDetails3.set(i, domainSummaryDetails3.get(domIdx));
				domainSummaryDetails3.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i3 = domainSummaryDetails3.size();
		while (i3 > size3)
		{
			domainSummaryDetails3.remove(i3-1);
			i3 = domainSummaryDetails3.size();
		}
		
		domainObject.setSummaryDetails(domainSummaryDetails3);		
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.edischarge.domain.objects.DischargeDetails value4 = null;
		if ( null != valueObject.getDischargeDetails() ) 
		{
			if (valueObject.getDischargeDetails().getBoId() == null)
			{
				if (domMap.get(valueObject.getDischargeDetails()) != null)
				{
					value4 = (ims.edischarge.domain.objects.DischargeDetails)domMap.get(valueObject.getDischargeDetails());
				}
			}
			else
			{
				value4 = (ims.edischarge.domain.objects.DischargeDetails)domainFactory.getDomainObject(ims.edischarge.domain.objects.DischargeDetails.class, valueObject.getDischargeDetails().getBoId());
			}
		}
		domainObject.setDischargeDetails(value4);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value5 = null;
		if ( null != valueObject.getTTAStatus() ) 
		{
			value5 =
				domainFactory.getLookupInstance(valueObject.getTTAStatus().getID());
		}
		domainObject.setTTAStatus(value5);

		return domainObject;
	}

}
