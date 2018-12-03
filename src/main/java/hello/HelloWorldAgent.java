/**
 * ***************************************************************
 * JADE - Java Agent DEvelopment Framework is a framework to develop
 * multi-agent systems in compliance with the FIPA specifications.
 * Copyright (C) 2000 CSELT S.p.A.
 * <p>
 * GNU Lesser General Public License
 * <p>
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation,
 * version 2.1 of the License.
 * <p>
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA.
 * **************************************************************
 */
package hello;

import jade.core.Agent;
import jade.core.Location;

/**
 * This example shows a minimal agent that just prints "Hallo World!"
 * and then terminates.
 *
 * @author Giovanni Caire - TILAB
 */
public class HelloWorldAgent extends Agent {

    protected void setup() {
        System.out.println("Hello World! My name is " + getLocalName());
        System.out.println("Hello World!");
        System.out.println("-----About Me:-----");
        System.out.println("My local name is:" + getAID().getLocalName());//由于本地agent,getAID()此时也可以省略
        System.out.println("My globally unique name is:" + getName());
        System.out.println("-----About Here:-----");
        Location l = here();//主容器信息
        System.out.println("I am running in a location called:"+l.getName());
        System.out.println("Which is identified uniquely as:"+l.getID());
        System.out.println("And is contactable at:"+l.getAddress()); System.out.println("Using the protocol:"+l.getProtocol());

        // Make this agent terminate
        doDelete();
    }
}

