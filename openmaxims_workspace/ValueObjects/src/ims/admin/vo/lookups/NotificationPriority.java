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

package ims.admin.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class NotificationPriority extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public NotificationPriority()
	{
		super();
	}
	public NotificationPriority(int id)
	{
		super(id, "", true);
	}
	public NotificationPriority(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public NotificationPriority(int id, String text, boolean active, NotificationPriority parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public NotificationPriority(int id, String text, boolean active, NotificationPriority parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public NotificationPriority(int id, String text, boolean active, NotificationPriority parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static NotificationPriority buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new NotificationPriority(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (NotificationPriority)super.getParentInstance();
	}
	public NotificationPriority getParent()
	{
		return (NotificationPriority)super.getParentInstance();
	}
	public void setParent(NotificationPriority parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		NotificationPriority[] typedChildren = new NotificationPriority[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (NotificationPriority)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof NotificationPriority)
		{
			super.addChild((NotificationPriority)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof NotificationPriority)
		{
			super.removeChild((NotificationPriority)child);
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
		NotificationPriorityCollection result = new NotificationPriorityCollection();
		result.add(CRITICAL);
		result.add(HIGH);
		result.add(NORMAL);
		result.add(LOW);
		return result;
	}
	public static NotificationPriority[] getNegativeInstances()
	{
		NotificationPriority[] instances = new NotificationPriority[4];
		instances[0] = CRITICAL;
		instances[1] = HIGH;
		instances[2] = NORMAL;
		instances[3] = LOW;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "CRITICAL";
		negativeInstances[1] = "HIGH";
		negativeInstances[2] = "NORMAL";
		negativeInstances[3] = "LOW";
		return negativeInstances;
	}
	public static NotificationPriority getNegativeInstance(String name)
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
	public static NotificationPriority getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		NotificationPriority[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1031020;
	public static final NotificationPriority CRITICAL = new NotificationPriority(-2103, "Critical", true, null, null, Color.Default);
	public static final NotificationPriority HIGH = new NotificationPriority(-2104, "High", true, null, null, Color.Default);
	public static final NotificationPriority NORMAL = new NotificationPriority(-2105, "Normal", true, null, null, Color.Default);
	public static final NotificationPriority LOW = new NotificationPriority(-2106, "Low", true, null, null, Color.Default);
}
