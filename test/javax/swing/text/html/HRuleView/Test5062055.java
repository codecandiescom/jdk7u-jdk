/*
 * Copyright 2007 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

/* @test
   @bug 5062055
   @summary Tests parsing of incorrect HR attributes
   @author Peter Zhelezniakov
   @run main Test5062055
*/

import java.awt.Dimension;
import javax.swing.*;

public class Test5062055 implements Runnable
{
    public static void main(String argv[]) {
        SwingUtilities.invokeLater(new Test5062055());
        // give HTML time to be parsed
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new Error("Wait interrupted");
        }
    }

    public void run() {
        JEditorPane jep = new JEditorPane();
        jep.setContentType("text/html");
        jep.setEditable(false);
        jep.setText("<HTML><BODY><HR size='5px'></BODY></HTML>");
        jep.setPreferredSize(new Dimension(640,480));
    }
}