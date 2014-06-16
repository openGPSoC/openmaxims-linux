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

public class LineColourPointIcon extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public LineColourPointIcon()
	{
		super();
	}
	public LineColourPointIcon(int id)
	{
		super(id, "", true);
	}
	public LineColourPointIcon(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public LineColourPointIcon(int id, String text, boolean active, LineColourPointIcon parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public LineColourPointIcon(int id, String text, boolean active, LineColourPointIcon parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public LineColourPointIcon(int id, String text, boolean active, LineColourPointIcon parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static LineColourPointIcon buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new LineColourPointIcon(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (LineColourPointIcon)super.getParentInstance();
	}
	public LineColourPointIcon getParent()
	{
		return (LineColourPointIcon)super.getParentInstance();
	}
	public void setParent(LineColourPointIcon parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		LineColourPointIcon[] typedChildren = new LineColourPointIcon[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (LineColourPointIcon)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof LineColourPointIcon)
		{
			super.addChild((LineColourPointIcon)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof LineColourPointIcon)
		{
			super.removeChild((LineColourPointIcon)child);
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
		LineColourPointIconCollection result = new LineColourPointIconCollection();
		result.add(RED_TRIANGLE);
		result.add(RED_SQUARE);
		result.add(YELLOW_TRIANGLE);
		result.add(YELLOW_SQUARE);
		result.add(BLUE_SQUARE);
		result.add(BLACK_CIRCLE);
		result.add(GRAY_STAR);
		result.add(ORANGE_STAR);
		result.add(BLACK_TRIANGLE);
		result.add(GREEN_CIRCLE);
		return result;
	}
	public static LineColourPointIcon[] getNegativeInstances()
	{
		LineColourPointIcon[] instances = new LineColourPointIcon[10];
		instances[0] = RED_TRIANGLE;
		instances[1] = RED_SQUARE;
		instances[2] = YELLOW_TRIANGLE;
		instances[3] = YELLOW_SQUARE;
		instances[4] = BLUE_SQUARE;
		instances[5] = BLACK_CIRCLE;
		instances[6] = GRAY_STAR;
		instances[7] = ORANGE_STAR;
		instances[8] = BLACK_TRIANGLE;
		instances[9] = GREEN_CIRCLE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[10];
		negativeInstances[0] = "RED_TRIANGLE";
		negativeInstances[1] = "RED_SQUARE";
		negativeInstances[2] = "YELLOW_TRIANGLE";
		negativeInstances[3] = "YELLOW_SQUARE";
		negativeInstances[4] = "BLUE_SQUARE";
		negativeInstances[5] = "BLACK_CIRCLE";
		negativeInstances[6] = "GRAY_STAR";
		negativeInstances[7] = "ORANGE_STAR";
		negativeInstances[8] = "BLACK_TRIANGLE";
		negativeInstances[9] = "GREEN_CIRCLE";
		return negativeInstances;
	}
	public static LineColourPointIcon getNegativeInstance(String name)
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
	public static LineColourPointIcon getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		LineColourPointIcon[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021175;
	public static final LineColourPointIcon RED_TRIANGLE = new LineColourPointIcon(-996, "Red Triangle", true, null, new ims.framework.utils.ImagePath(102268, "Images/Core/red-triangle.gif"), Color.Red);
	public static final LineColourPointIcon RED_SQUARE = new LineColourPointIcon(-997, "Red Square", true, null, new ims.framework.utils.ImagePath(102122, "Images/Core/circle_red.png"), Color.Red);
	public static final LineColourPointIcon YELLOW_TRIANGLE = new LineColourPointIcon(-998, "Yellow Triangle", true, null, new ims.framework.utils.ImagePath(102269, "Images/Core/yellow-triangle.gif"), Color.Yellow);
	public static final LineColourPointIcon YELLOW_SQUARE = new LineColourPointIcon(-999, "Yellow Square", true, null, new ims.framework.utils.ImagePath(102123, "Images/Core/circle_yellow.png"), Color.Yellow);
	public static final LineColourPointIcon BLUE_SQUARE = new LineColourPointIcon(-1111, "Blue Square", true, null, new ims.framework.utils.ImagePath(102121, "Images/Core/circle_blue.png"), Color.Blue);
	public static final LineColourPointIcon BLACK_CIRCLE = new LineColourPointIcon(-1112, "Black Circle", true, null, new ims.framework.utils.ImagePath(102128, "Images/Core/eye_3x.gif"), Color.Black);
	public static final LineColourPointIcon GRAY_STAR = new LineColourPointIcon(-1113, "Gray Star", true, null, new ims.framework.utils.ImagePath(102276, "Images/Core/gray-star-1.gif"), Color.Gray);
	public static final LineColourPointIcon ORANGE_STAR = new LineColourPointIcon(-1114, "Orange Star", true, null, new ims.framework.utils.ImagePath(102277, "Images/Core/orange-star-1-out.gif"), Color.Orange);
	public static final LineColourPointIcon BLACK_TRIANGLE = new LineColourPointIcon(-1115, "Black Triangle", true, null, new ims.framework.utils.ImagePath(103154, "Images/Admin/black-triangle-down-1.gif"), Color.Black);
	public static final LineColourPointIcon GREEN_CIRCLE = new LineColourPointIcon(-1116, "Green Circle", true, null, new ims.framework.utils.ImagePath(118100, "Images/ICP/property.gif"), Color.DarkGreen);
}
