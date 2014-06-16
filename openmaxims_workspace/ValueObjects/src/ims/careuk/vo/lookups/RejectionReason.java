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

package ims.careuk.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class RejectionReason extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public RejectionReason()
	{
		super();
	}
	public RejectionReason(int id)
	{
		super(id, "", true);
	}
	public RejectionReason(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public RejectionReason(int id, String text, boolean active, RejectionReason parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public RejectionReason(int id, String text, boolean active, RejectionReason parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public RejectionReason(int id, String text, boolean active, RejectionReason parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static RejectionReason buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new RejectionReason(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (RejectionReason)super.getParentInstance();
	}
	public RejectionReason getParent()
	{
		return (RejectionReason)super.getParentInstance();
	}
	public void setParent(RejectionReason parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		RejectionReason[] typedChildren = new RejectionReason[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (RejectionReason)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof RejectionReason)
		{
			super.addChild((RejectionReason)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof RejectionReason)
		{
			super.removeChild((RejectionReason)child);
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
		RejectionReasonCollection result = new RejectionReasonCollection();
		result.add(DEFAULT);
		return result;
	}
	public static RejectionReason[] getNegativeInstances()
	{
		RejectionReason[] instances = new RejectionReason[1];
		instances[0] = DEFAULT;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[1];
		negativeInstances[0] = "DEFAULT";
		return negativeInstances;
	}
	public static RejectionReason getNegativeInstance(String name)
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
	public static RejectionReason getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		RejectionReason[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1341001;
	public static final RejectionReason DEFAULT = new RejectionReason(-1452, "Default", true, null, null, Color.Default);
}
