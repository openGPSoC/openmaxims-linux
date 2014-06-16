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

package ims.core.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class SECSTypes extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public SECSTypes()
	{
		super();
	}
	public SECSTypes(int id)
	{
		super(id, "", true);
	}
	public SECSTypes(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public SECSTypes(int id, String text, boolean active, SECSTypes parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public SECSTypes(int id, String text, boolean active, SECSTypes parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public SECSTypes(int id, String text, boolean active, SECSTypes parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static SECSTypes buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new SECSTypes(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (SECSTypes)super.getParentInstance();
	}
	public SECSTypes getParent()
	{
		return (SECSTypes)super.getParentInstance();
	}
	public void setParent(SECSTypes parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		SECSTypes[] typedChildren = new SECSTypes[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (SECSTypes)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof SECSTypes)
		{
			super.addChild((SECSTypes)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof SECSTypes)
		{
			super.removeChild((SECSTypes)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		SECSTypesCollection result = new SECSTypesCollection();
		result.add(SYSTOLICBP);
		result.add(RESPIRATORYRATE);
		result.add(PULSE);
		result.add(OXYGENSATS);
		result.add(TEMPERATURE);
		result.add(CONSCIOUS_LEVEL);
		result.add(URINE_OUTPUT);
		result.add(PATIENT_CONCERN);
		return result;
	}
	public static SECSTypes[] getNegativeInstances()
	{
		SECSTypes[] instances = new SECSTypes[8];
		instances[0] = SYSTOLICBP;
		instances[1] = RESPIRATORYRATE;
		instances[2] = PULSE;
		instances[3] = OXYGENSATS;
		instances[4] = TEMPERATURE;
		instances[5] = CONSCIOUS_LEVEL;
		instances[6] = URINE_OUTPUT;
		instances[7] = PATIENT_CONCERN;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[8];
		negativeInstances[0] = "SYSTOLICBP";
		negativeInstances[1] = "RESPIRATORYRATE";
		negativeInstances[2] = "PULSE";
		negativeInstances[3] = "OXYGENSATS";
		negativeInstances[4] = "TEMPERATURE";
		negativeInstances[5] = "CONSCIOUS_LEVEL";
		negativeInstances[6] = "URINE_OUTPUT";
		negativeInstances[7] = "PATIENT_CONCERN";
		return negativeInstances;
	}
	public static SECSTypes getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static SECSTypes getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		SECSTypes[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1021178;
	public static final SECSTypes SYSTOLICBP = new SECSTypes(-987, "Systolic BP", true, null, null, Color.Default);
	public static final SECSTypes RESPIRATORYRATE = new SECSTypes(-988, "Respiratory Rate", true, null, null, Color.Default);
	public static final SECSTypes PULSE = new SECSTypes(-989, "Pulse", true, null, null, Color.Default);
	public static final SECSTypes OXYGENSATS = new SECSTypes(-990, "Oxygen Sats", true, null, null, Color.Default);
	public static final SECSTypes TEMPERATURE = new SECSTypes(-1272, "Temperature", true, null, null, Color.Default);
	public static final SECSTypes CONSCIOUS_LEVEL = new SECSTypes(-1273, "Conscious Level", true, null, null, Color.Default);
	public static final SECSTypes URINE_OUTPUT = new SECSTypes(-1274, "Urine Output", true, null, null, Color.Default);
	public static final SECSTypes PATIENT_CONCERN = new SECSTypes(-1275, "Patient Causing Concern", true, null, null, Color.Default);
}
