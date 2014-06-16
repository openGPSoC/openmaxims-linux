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

package ims.correspondence.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class AssociationSpecifier extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public AssociationSpecifier()
	{
		super();
	}
	public AssociationSpecifier(int id)
	{
		super(id, "", true);
	}
	public AssociationSpecifier(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public AssociationSpecifier(int id, String text, boolean active, AssociationSpecifier parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public AssociationSpecifier(int id, String text, boolean active, AssociationSpecifier parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public AssociationSpecifier(int id, String text, boolean active, AssociationSpecifier parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static AssociationSpecifier buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new AssociationSpecifier(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (AssociationSpecifier)super.getParentInstance();
	}
	public AssociationSpecifier getParent()
	{
		return (AssociationSpecifier)super.getParentInstance();
	}
	public void setParent(AssociationSpecifier parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		AssociationSpecifier[] typedChildren = new AssociationSpecifier[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (AssociationSpecifier)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof AssociationSpecifier)
		{
			super.addChild((AssociationSpecifier)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof AssociationSpecifier)
		{
			super.removeChild((AssociationSpecifier)child);
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
		AssociationSpecifierCollection result = new AssociationSpecifierCollection();
		result.add(CONSULTANT);
		result.add(SERVICE);
		result.add(CLINIC);
		result.add(SPECIALTY);
		return result;
	}
	public static AssociationSpecifier[] getNegativeInstances()
	{
		AssociationSpecifier[] instances = new AssociationSpecifier[4];
		instances[0] = CONSULTANT;
		instances[1] = SERVICE;
		instances[2] = CLINIC;
		instances[3] = SPECIALTY;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "CONSULTANT";
		negativeInstances[1] = "SERVICE";
		negativeInstances[2] = "CLINIC";
		negativeInstances[3] = "SPECIALTY";
		return negativeInstances;
	}
	public static AssociationSpecifier getNegativeInstance(String name)
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
	public static AssociationSpecifier getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		AssociationSpecifier[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1111009;
	public static final AssociationSpecifier CONSULTANT = new AssociationSpecifier(-552, "Consultant", true, null, null, Color.Default);
	public static final AssociationSpecifier SERVICE = new AssociationSpecifier(-553, "Specialty", true, null, null, Color.Default);
	public static final AssociationSpecifier CLINIC = new AssociationSpecifier(-554, "Clinic", true, null, null, Color.Default);
	public static final AssociationSpecifier SPECIALTY = new AssociationSpecifier(-623, "Specilaty", true, null, null, Color.Default);
}
