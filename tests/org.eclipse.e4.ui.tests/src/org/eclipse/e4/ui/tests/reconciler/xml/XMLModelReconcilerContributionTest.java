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

import org.eclipse.e4.ui.tests.reconciler.ModelReconcilerContributionTest;
import org.eclipse.e4.workbench.modeling.ModelReconciler;
import org.eclipse.e4.workbench.ui.internal.XMLModelReconciler;

public class XMLModelReconcilerContributionTest extends
		ModelReconcilerContributionTest {

	@Override
	protected ModelReconciler createModelReconciler() {
		return new XMLModelReconciler();
	}

}