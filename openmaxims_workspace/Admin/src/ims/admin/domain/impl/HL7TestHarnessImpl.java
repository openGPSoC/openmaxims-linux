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
// This code was generated by John MacEnri using IMS Development Environment (version 1.43 build 2230.19282)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import ca.uhn.hl7v2.llp.HL7Reader;
import ca.uhn.hl7v2.llp.HL7Writer;
import ca.uhn.hl7v2.llp.MinLLPReader;
import ca.uhn.hl7v2.llp.MinLLPWriter;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.PipeParser;
import ims.admin.domain.base.impl.BaseHL7TestHarnessImpl;
import ims.domain.exceptions.DomainInterfaceException;

public class HL7TestHarnessImpl extends BaseHL7TestHarnessImpl
{
	public String validateMessage(String msgTxt) throws ims.domain.exceptions.DomainInterfaceException
	{
		PipeParser parser = new PipeParser();
		Message msg;
		try
		{
			msgTxt = msgTxt.replaceAll("\n", "\r");
			msg = parser.parse(msgTxt);
		}
		catch (Exception e)
		{
			throw new DomainInterfaceException(e.getClass().getName() + " occurred. Exception message was " + e.getMessage(),e);
		}
		return "Message parsed successfully as " + msg.getName();
	}

	public String sendMessage(String host, Integer port, String msgTxt) throws ims.domain.exceptions.DomainInterfaceException
	{
		try
		{
			Socket sock = new Socket(host, port.intValue());
			//TODO make the timeout configurable
			sock.setSoTimeout(200000);

			msgTxt = msgTxt.replaceAll("\n", "\r");

			HL7Writer writer = new MinLLPWriter(sock.getOutputStream());
			writer.writeMessage(msgTxt);

			HL7Reader reader = new MinLLPReader(sock.getInputStream());
			String retMsg = reader.getMessage();

			sock.close();
			return retMsg;
		}
		catch (Exception e)
		{
			throw new DomainInterfaceException(e.getClass().getName() + " occurred. Exception message was " + e.getMessage(),e);
		}
	}

	public void testConnection(String host, Integer port) throws DomainInterfaceException
	{
		try
		{
			Socket sock = new Socket(host, port.intValue());
			sock.close();
		}
		catch (UnknownHostException e)
		{
			throw new DomainInterfaceException(e);
		}
		catch (IllegalArgumentException e)
		{
			throw new DomainInterfaceException(e);
		}
		catch (IOException e)
		{
			throw new DomainInterfaceException(e);
		}
	}
}
