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

package ims.ocrr.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class TemplateDividerType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public TemplateDividerType()
	{
		super();
	}
	public TemplateDividerType(int id)
	{
		super(id, "", true);
	}
	public TemplateDividerType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public TemplateDividerType(int id, String text, boolean active, TemplateDividerType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public TemplateDividerType(int id, String text, boolean active, TemplateDividerType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public TemplateDividerType(int id, String text, boolean active, TemplateDividerType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static TemplateDividerType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new TemplateDividerType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (TemplateDividerType)super.getParentInstance();
	}
	public TemplateDividerType getParent()
	{
		return (TemplateDividerType)super.getParentInstance();
	}
	public void setParent(TemplateDividerType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		TemplateDividerType[] typedChildren = new TemplateDividerType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (TemplateDividerType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof TemplateDividerType)
		{
			super.addChild((TemplateDividerType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof TemplateDividerType)
		{
			super.removeChild((TemplateDividerType)child);
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
		TemplateDividerTypeCollection result = new TemplateDividerTypeCollection();
		result.add(COLUMNSEPARATOR);
		result.add(SEPARATOR);
		return result;
	}
	public static TemplateDividerType[] getNegativeInstances()
	{
		TemplateDividerType[] instances = new TemplateDividerType[2];
		instances[0] = COLUMNSEPARATOR;
		instances[1] = SEPARATOR;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "COLUMNSEPARATOR";
		negativeInstances[1] = "SEPARATOR";
		return negativeInstances;
	}
	public static TemplateDividerType getNegativeInstance(String name)
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
	public static TemplateDividerType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		TemplateDividerType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1161019;
	public static final TemplateDividerType COLUMNSEPARATOR = new TemplateDividerType(-610, "Column Separator", true, null, null, Color.Default);
	public static final TemplateDividerType SEPARATOR = new TemplateDividerType(-611, "Separator", true, null, null, Color.Default);
}
