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

package ims.clinical.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class PresentAbsentUnknown extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public PresentAbsentUnknown()
	{
		super();
	}
	public PresentAbsentUnknown(int id)
	{
		super(id, "", true);
	}
	public PresentAbsentUnknown(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public PresentAbsentUnknown(int id, String text, boolean active, PresentAbsentUnknown parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public PresentAbsentUnknown(int id, String text, boolean active, PresentAbsentUnknown parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public PresentAbsentUnknown(int id, String text, boolean active, PresentAbsentUnknown parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static PresentAbsentUnknown buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new PresentAbsentUnknown(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (PresentAbsentUnknown)super.getParentInstance();
	}
	public PresentAbsentUnknown getParent()
	{
		return (PresentAbsentUnknown)super.getParentInstance();
	}
	public void setParent(PresentAbsentUnknown parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		PresentAbsentUnknown[] typedChildren = new PresentAbsentUnknown[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (PresentAbsentUnknown)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof PresentAbsentUnknown)
		{
			super.addChild((PresentAbsentUnknown)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof PresentAbsentUnknown)
		{
			super.removeChild((PresentAbsentUnknown)child);
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
		PresentAbsentUnknownCollection result = new PresentAbsentUnknownCollection();
		result.add(PRESENT);
		result.add(ABSENT);
		result.add(UNKNOWN);
		return result;
	}
	public static PresentAbsentUnknown[] getNegativeInstances()
	{
		PresentAbsentUnknown[] instances = new PresentAbsentUnknown[3];
		instances[0] = PRESENT;
		instances[1] = ABSENT;
		instances[2] = UNKNOWN;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "PRESENT";
		negativeInstances[1] = "ABSENT";
		negativeInstances[2] = "UNKNOWN";
		return negativeInstances;
	}
	public static PresentAbsentUnknown getNegativeInstance(String name)
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
	public static PresentAbsentUnknown getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		PresentAbsentUnknown[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1231035;
	public static final PresentAbsentUnknown PRESENT = new PresentAbsentUnknown(-920, "Present", true, null, new ims.framework.utils.ImagePath(102209, "Images/Core/tick.png"), Color.Default);
	public static final PresentAbsentUnknown ABSENT = new PresentAbsentUnknown(-921, "Absent", true, null, new ims.framework.utils.ImagePath(123102, "Images/Clinical/Minus.gif"), Color.Default);
	public static final PresentAbsentUnknown UNKNOWN = new PresentAbsentUnknown(-922, "Unknown", true, null, new ims.framework.utils.ImagePath(102102, "Images/Core/AnswerBox_Unknown.gif"), Color.Default);
}
