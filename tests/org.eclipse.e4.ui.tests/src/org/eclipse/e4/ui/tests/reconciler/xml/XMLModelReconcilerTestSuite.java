/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/

package org.eclipse.e4.ui.tests.reconciler.xml;

import junit.framework.Test;
import junit.framework.TestSuite;

public class XMLModelReconcilerTestSuite extends TestSuite {

	public static Test suite() {
		return new XMLModelReconcilerTestSuite();
	}

	public XMLModelReconcilerTestSuite() {
		addTestSuite(XMLModelReconcilerApplicationTest.class);
		addTestSuite(XMLModelReconcilerBindingContainerTest.class);
		addTestSuite(XMLModelReconcilerCommandTest.class);
		addTestSuite(XMLModelReconcilerContributionTest.class);
		addTestSuite(XMLModelReconcilerElementContainerTest.class);
		addTestSuite(XMLModelReconcilerGenericTileTest.class);
		addTestSuite(XMLModelReconcilerHandlerContainerTest.class);
		addTestSuite(XMLModelReconcilerHandlerTest.class);
		addTestSuite(XMLModelReconcilerHandledItemTest.class);
		addTestSuite(XMLModelReconcilerItemTest.class);
		addTestSuite(XMLModelReconcilerKeyBindingTest.class);
		addTestSuite(XMLModelReconcilerKeySequenceTest.class);
		addTestSuite(XMLModelReconcilerPartTest.class);
		addTestSuite(XMLModelReconcilerTrimContainerTest.class);
		addTestSuite(XMLModelReconcilerViewSashContainerTest.class);
		addTestSuite(XMLModelReconcilerViewStackTest.class);
		addTestSuite(XMLModelReconcilerUIElementTest.class);
		addTestSuite(XMLModelReconcilerUIItemTest.class);
		addTestSuite(XMLModelReconcilerWindowTest.class);

		addTestSuite(XMLModelReconcilerScenarioTest.class);
	}

}