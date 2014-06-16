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
 * Generated: 16/04/2014, 12:34
 *
 */
package ims.core.admin.domain.objects;

/**
 * 
 * @author Sean Nesbitt
 * Generated.
 */


public class DateExpressionBo extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1004100000;
	private static final long serialVersionUID = 1004100000L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** expression element for start date */
	private Integer startExprDate;
	/** expression operator */
	private Boolean addOperator;
	/** expression range unit for operator */
	private Integer rangeUnit;
	/** Number of Units to end date range */
	private Integer numberofUnits;
	/** Menu Id for date control */
	private Integer menuId;
	/** User defined name for the date expression */
	private String name;
	/** 
	  * Collection of ims.core.admin.domain.objects.FormDateExpression.
	  */
	private java.util.Set forms;
	/** Active/Inactive expression */
	private Boolean active;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public DateExpressionBo (Integer id, int ver)
    {
    	super(id, ver);
    }
    public DateExpressionBo ()
    {
    	super();
    }
    public DateExpressionBo (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.core.admin.domain.objects.DateExpressionBo.class;
	}


	public Integer getStartExprDate() {
		return startExprDate;
	}
	public void setStartExprDate(Integer startExprDate) {
		this.startExprDate = startExprDate;
	}

	public Boolean isAddOperator() {
		return addOperator;
	}
	public void setAddOperator(Boolean addOperator) {
		this.addOperator = addOperator;
	}

	public Integer getRangeUnit() {
		return rangeUnit;
	}
	public void setRangeUnit(Integer rangeUnit) {
		this.rangeUnit = rangeUnit;
	}

	public Integer getNumberofUnits() {
		return numberofUnits;
	}
	public void setNumberofUnits(Integer numberofUnits) {
		this.numberofUnits = numberofUnits;
	}

	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public java.util.Set getForms() {
		if ( null == forms ) {
			forms = new java.util.HashSet();
		}
		return forms;
	}
	public void setForms(java.util.Set paramValue) {
		this.forms = paramValue;
	}

	public Boolean isActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	public ims.domain.SystemInformation getSystemInformation() {
		if (systemInformation == null) systemInformation = new ims.domain.SystemInformation();
		return systemInformation;
	}


	/**
	 * isConfigurationObject
	 * Taken from the Usage property of the business object, this method will return
	 * a boolean indicating whether this is a configuration object or not
	 * Configuration = true, Instantiation = false
	 */
	public static boolean isConfigurationObject()
	{
		if ( "Instantiation".equals("Configuration") )
			return true;
		else
			return false;
	}





	public int getClassId() {
		return CLASSID;
	}

	public String getClassVersion()
	{
		return CLASSVERSION;
	}

	public String toAuditString()
	{
		StringBuffer auditStr = new StringBuffer();
		
		auditStr.append("\r\n*startExprDate* :");
		auditStr.append(startExprDate);
	    auditStr.append("; ");
		auditStr.append("\r\n*addOperator* :");
		auditStr.append(addOperator);
	    auditStr.append("; ");
		auditStr.append("\r\n*rangeUnit* :");
		auditStr.append(rangeUnit);
	    auditStr.append("; ");
		auditStr.append("\r\n*numberofUnits* :");
		auditStr.append(numberofUnits);
	    auditStr.append("; ");
		auditStr.append("\r\n*menuId* :");
		auditStr.append(menuId);
	    auditStr.append("; ");
		auditStr.append("\r\n*name* :");
		auditStr.append(name);
	    auditStr.append("; ");
		auditStr.append("\r\n*forms* :");
		if (forms != null)
		{
			java.util.Iterator it7 = forms.iterator();
			int i7=0;
			while (it7.hasNext())
			{
				if (i7 > 0)
					auditStr.append(",");
				ims.core.admin.domain.objects.FormDateExpression obj = (ims.core.admin.domain.objects.FormDateExpression)it7.next();
		if (obj != null)
		{
		   if (i7 == 0)
		   {
			auditStr.append(toShortClassName(obj));
			auditStr.append("[");
		   }
		
		   auditStr.append(obj.getId());
		}
			i7++;
		}
		if (i7 > 0)
			auditStr.append("] " + i7);
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*active* :");
		auditStr.append(active);
	    auditStr.append("; ");
		return auditStr.toString();
	}
	
	public String toXMLString()
	{
		return toXMLString(new java.util.HashMap());
	}
	
	public String toXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<class type=\"" + this.getClass().getName() + "\" ");		
		sb.append(" id=\"" + this.getId() + "\""); 
		sb.append(" source=\"" + ims.configuration.EnvironmentConfig.getImportExportSourceName() + "\" ");
		sb.append(" classVersion=\"" + this.getClassVersion() + "\" ");
		sb.append(" component=\"" + this.getIsComponentClass() + "\" >");
		
		if (domMap.get(this) == null)
		{
			domMap.put(this, this);
			sb.append(this.fieldsToXMLString(domMap));
		}
		sb.append("</class>");
		
		String keyClassName = "DateExpressionBo";
		String externalSource = ims.configuration.EnvironmentConfig.getImportExportSourceName();
		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + this.getId());
		if (impObj == null)
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(this.getId());
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(this);
			impObj.setLocalId(this.getId()); 
    		impObj.setClassName(keyClassName); 
			domMap.put(keyClassName + "_" + externalSource + "_" + this.getId(), impObj);
		}
		
		return sb.toString();
	}

	public String fieldsToXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		if (this.getStartExprDate() != null)
		{
			sb.append("<startExprDate>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getStartExprDate().toString()));
			sb.append("</startExprDate>");		
		}
		if (this.isAddOperator() != null)
		{
			sb.append("<addOperator>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.isAddOperator().toString()));
			sb.append("</addOperator>");		
		}
		if (this.getRangeUnit() != null)
		{
			sb.append("<rangeUnit>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getRangeUnit().toString()));
			sb.append("</rangeUnit>");		
		}
		if (this.getNumberofUnits() != null)
		{
			sb.append("<numberofUnits>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getNumberofUnits().toString()));
			sb.append("</numberofUnits>");		
		}
		if (this.getMenuId() != null)
		{
			sb.append("<menuId>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getMenuId().toString()));
			sb.append("</menuId>");		
		}
		if (this.getName() != null)
		{
			sb.append("<name>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getName().toString()));
			sb.append("</name>");		
		}
		if (this.getForms() != null)
		{
			if (this.getForms().size() > 0 )
			{
			sb.append("<forms>");
			sb.append(ims.domain.DomainObject.toXMLString(this.getForms(), domMap));
			sb.append("</forms>");		
			}
		}
		if (this.isActive() != null)
		{
			sb.append("<active>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.isActive().toString()));
			sb.append("</active>");		
		}
		return sb.toString();
	}
		
	public static java.util.List fromListXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.List list, java.util.HashMap domMap) throws Exception
	{
		if (list == null)
		 list = new java.util.ArrayList();
		fillListFromXMLString(list, el, factory, domMap);
		return list;
	}
	
	public static java.util.Set fromSetXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.Set set, java.util.HashMap domMap) throws Exception
	{
		if (set == null)
			 set = new java.util.HashSet();
		fillSetFromXMLString(set, el, factory, domMap);
		return set;
	}
	
	private static void fillSetFromXMLString(java.util.Set set, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			DateExpressionBo domainObject = getDateExpressionBofromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!set.contains(domainObject)) 
				set.add(domainObject);
			newSet.add(domainObject);			
		}
		
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = set.iterator();
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
			set.remove(iter.next());
		}		
	}
	
	private static void fillListFromXMLString(java.util.List list, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			DateExpressionBo domainObject = getDateExpressionBofromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}

			int domIdx = list.indexOf(domainObject);
			if (domIdx == -1)
			{
				list.add(i, domainObject);
			}
			else if (i != domIdx && i < list.size())
			{
				Object tmp = list.get(i);
				list.set(i, list.get(domIdx));
				list.set(domIdx, tmp);
			}
		}		
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=list.size();
		while (i1 > size)
		{
			list.remove(i1-1);
			i1=list.size();
		}
	}
		
	public static DateExpressionBo getDateExpressionBofromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getDateExpressionBofromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static DateExpressionBo getDateExpressionBofromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!DateExpressionBo.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!DateExpressionBo.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the DateExpressionBo class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (DateExpressionBo)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(DateExpressionBo.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		DateExpressionBo ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (DateExpressionBo)factory.getImportedDomainObject(DateExpressionBo.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new DateExpressionBo();
		}
		String keyClassName = "DateExpressionBo";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (DateExpressionBo)impObj.getDomainObject();
		}
		else
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(extId);
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(ret);
			domMap.put(keyClassName + "_" + externalSource + "_" + extId, impObj);
		}
		fillFieldsfromXML(el, factory, ret, domMap);
		return ret;
	}

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, DateExpressionBo obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("startExprDate");
		if(fldEl != null)
		{	
    		obj.setStartExprDate(new Integer(fldEl.getTextTrim()));	
		}
		fldEl = el.element("addOperator");
		if(fldEl != null)
		{	
    		obj.setAddOperator(new Boolean(fldEl.getTextTrim()));	
		}
		fldEl = el.element("rangeUnit");
		if(fldEl != null)
		{	
    		obj.setRangeUnit(new Integer(fldEl.getTextTrim()));	
		}
		fldEl = el.element("numberofUnits");
		if(fldEl != null)
		{	
    		obj.setNumberofUnits(new Integer(fldEl.getTextTrim()));	
		}
		fldEl = el.element("menuId");
		if(fldEl != null)
		{	
    		obj.setMenuId(new Integer(fldEl.getTextTrim()));	
		}
		fldEl = el.element("name");
		if(fldEl != null)
		{	
    		obj.setName(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("forms");
		if(fldEl != null)
		{
			fldEl = fldEl.element("set");	
			obj.setForms(ims.core.admin.domain.objects.FormDateExpression.fromSetXMLString(fldEl, factory, obj.getForms(), domMap));
		}
		fldEl = el.element("active");
		if(fldEl != null)
		{	
    		obj.setActive(new Boolean(fldEl.getTextTrim()));	
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		 "forms"
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String StartExprDate = "startExprDate";
		public static final String AddOperator = "addOperator";
		public static final String RangeUnit = "rangeUnit";
		public static final String NumberofUnits = "numberofUnits";
		public static final String MenuId = "menuId";
		public static final String Name = "name";
		public static final String Forms = "forms";
		public static final String Active = "active";
	}
}

