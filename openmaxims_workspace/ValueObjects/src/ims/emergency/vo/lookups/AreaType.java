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

package ims.emergency.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class AreaType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public AreaType()
	{
		super();
	}
	public AreaType(int id)
	{
		super(id, "", true);
	}
	public AreaType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public AreaType(int id, String text, boolean active, AreaType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public AreaType(int id, String text, boolean active, AreaType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public AreaType(int id, String text, boolean active, AreaType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static AreaType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new AreaType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (AreaType)super.getParentInstance();
	}
	public AreaType getParent()
	{
		return (AreaType)super.getParentInstance();
	}
	public void setParent(AreaType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		AreaType[] typedChildren = new AreaType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (AreaType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof AreaType)
		{
			super.addChild((AreaType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof AreaType)
		{
			super.removeChild((AreaType)child);
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
		AreaTypeCollection result = new AreaTypeCollection();
		result.add(ADULT_ONLY);
		result.add(PAEDIATRIC_ONLY);
		return result;
	}
	public static AreaType[] getNegativeInstances()
	{
		AreaType[] instances = new AreaType[2];
		instances[0] = ADULT_ONLY;
		instances[1] = PAEDIATRIC_ONLY;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "ADULT_ONLY";
		negativeInstances[1] = "PAEDIATRIC_ONLY";
		return negativeInstances;
	}
	public static AreaType getNegativeInstance(String name)
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
	public static AreaType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		AreaType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1291035;
	public static final AreaType ADULT_ONLY = new AreaType(-2430, "Adult only", true, null, null, Color.Default);
	public static final AreaType PAEDIATRIC_ONLY = new AreaType(-2431, "Paediatric only", true, null, null, Color.Default);
}
