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

package ims.spinalinjuries.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class InjuryAssociatedFactor extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public InjuryAssociatedFactor()
	{
		super();
	}
	public InjuryAssociatedFactor(int id)
	{
		super(id, "", true);
	}
	public InjuryAssociatedFactor(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public InjuryAssociatedFactor(int id, String text, boolean active, InjuryAssociatedFactor parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public InjuryAssociatedFactor(int id, String text, boolean active, InjuryAssociatedFactor parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public InjuryAssociatedFactor(int id, String text, boolean active, InjuryAssociatedFactor parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static InjuryAssociatedFactor buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new InjuryAssociatedFactor(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (InjuryAssociatedFactor)super.getParentInstance();
	}
	public InjuryAssociatedFactor getParent()
	{
		return (InjuryAssociatedFactor)super.getParentInstance();
	}
	public void setParent(InjuryAssociatedFactor parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		InjuryAssociatedFactor[] typedChildren = new InjuryAssociatedFactor[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (InjuryAssociatedFactor)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof InjuryAssociatedFactor)
		{
			super.addChild((InjuryAssociatedFactor)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof InjuryAssociatedFactor)
		{
			super.removeChild((InjuryAssociatedFactor)child);
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
		InjuryAssociatedFactorCollection result = new InjuryAssociatedFactorCollection();
		result.add(FACTOR1);
		result.add(FACTOR2);
		return result;
	}
	public static InjuryAssociatedFactor[] getNegativeInstances()
	{
		InjuryAssociatedFactor[] instances = new InjuryAssociatedFactor[2];
		instances[0] = FACTOR1;
		instances[1] = FACTOR2;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "FACTOR1";
		negativeInstances[1] = "FACTOR2";
		return negativeInstances;
	}
	public static InjuryAssociatedFactor getNegativeInstance(String name)
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
	public static InjuryAssociatedFactor getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		InjuryAssociatedFactor[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1051102;
	public static final InjuryAssociatedFactor FACTOR1 = new InjuryAssociatedFactor(-199, "Factor1", true, null, null, Color.Default);
	public static final InjuryAssociatedFactor FACTOR2 = new InjuryAssociatedFactor(-200, "factor2", true, null, null, Color.Default);
}
