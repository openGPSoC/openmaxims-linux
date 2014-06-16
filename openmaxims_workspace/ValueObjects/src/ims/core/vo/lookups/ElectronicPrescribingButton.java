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

public class ElectronicPrescribingButton extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ElectronicPrescribingButton()
	{
		super();
	}
	public ElectronicPrescribingButton(int id)
	{
		super(id, "", true);
	}
	public ElectronicPrescribingButton(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ElectronicPrescribingButton(int id, String text, boolean active, ElectronicPrescribingButton parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ElectronicPrescribingButton(int id, String text, boolean active, ElectronicPrescribingButton parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ElectronicPrescribingButton(int id, String text, boolean active, ElectronicPrescribingButton parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ElectronicPrescribingButton buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ElectronicPrescribingButton(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ElectronicPrescribingButton)super.getParentInstance();
	}
	public ElectronicPrescribingButton getParent()
	{
		return (ElectronicPrescribingButton)super.getParentInstance();
	}
	public void setParent(ElectronicPrescribingButton parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ElectronicPrescribingButton[] typedChildren = new ElectronicPrescribingButton[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ElectronicPrescribingButton)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ElectronicPrescribingButton)
		{
			super.addChild((ElectronicPrescribingButton)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ElectronicPrescribingButton)
		{
			super.removeChild((ElectronicPrescribingButton)child);
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
		ElectronicPrescribingButtonCollection result = new ElectronicPrescribingButtonCollection();
		result.add(BUTTONONE);
		result.add(BUTTONTWO);
		result.add(BUTTONTHREE);
		result.add(BUTTONFOUR);
		result.add(BUTTONFIVE);
		result.add(BUTTONSIX);
		result.add(BUTTONSEVEN);
		result.add(BUTTONEIGHT);
		return result;
	}
	public static ElectronicPrescribingButton[] getNegativeInstances()
	{
		ElectronicPrescribingButton[] instances = new ElectronicPrescribingButton[8];
		instances[0] = BUTTONONE;
		instances[1] = BUTTONTWO;
		instances[2] = BUTTONTHREE;
		instances[3] = BUTTONFOUR;
		instances[4] = BUTTONFIVE;
		instances[5] = BUTTONSIX;
		instances[6] = BUTTONSEVEN;
		instances[7] = BUTTONEIGHT;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[8];
		negativeInstances[0] = "BUTTONONE";
		negativeInstances[1] = "BUTTONTWO";
		negativeInstances[2] = "BUTTONTHREE";
		negativeInstances[3] = "BUTTONFOUR";
		negativeInstances[4] = "BUTTONFIVE";
		negativeInstances[5] = "BUTTONSIX";
		negativeInstances[6] = "BUTTONSEVEN";
		negativeInstances[7] = "BUTTONEIGHT";
		return negativeInstances;
	}
	public static ElectronicPrescribingButton getNegativeInstance(String name)
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
	public static ElectronicPrescribingButton getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ElectronicPrescribingButton[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021278;
	public static final ElectronicPrescribingButton BUTTONONE = new ElectronicPrescribingButton(-2245, "Button One", true, null, null, Color.Default);
	public static final ElectronicPrescribingButton BUTTONTWO = new ElectronicPrescribingButton(-2246, "Button Two", true, null, null, Color.Default);
	public static final ElectronicPrescribingButton BUTTONTHREE = new ElectronicPrescribingButton(-2247, "Button Three", true, null, null, Color.Default);
	public static final ElectronicPrescribingButton BUTTONFOUR = new ElectronicPrescribingButton(-2248, "Button Four", true, null, null, Color.Default);
	public static final ElectronicPrescribingButton BUTTONFIVE = new ElectronicPrescribingButton(-2249, "Button Five", true, null, null, Color.Default);
	public static final ElectronicPrescribingButton BUTTONSIX = new ElectronicPrescribingButton(-2250, "Button Six", true, null, null, Color.Default);
	public static final ElectronicPrescribingButton BUTTONSEVEN = new ElectronicPrescribingButton(-2251, "Button Seven", true, null, null, Color.Default);
	public static final ElectronicPrescribingButton BUTTONEIGHT = new ElectronicPrescribingButton(-2252, "Button Eight", true, null, null, Color.Default);
}
