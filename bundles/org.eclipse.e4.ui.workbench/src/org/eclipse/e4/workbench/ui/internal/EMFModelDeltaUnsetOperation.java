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

package org.eclipse.e4.workbench.ui.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.workbench.modeling.ModelDeltaOperation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public final class EMFModelDeltaUnsetOperation extends ModelDeltaOperation {

	private final EStructuralFeature feature;

	public EMFModelDeltaUnsetOperation(EObject eObject, EStructuralFeature feature) {
		super(eObject, null);
		this.feature = feature;
	}

	public IStatus apply() {
		EObject eObject = (EObject) getObject();
		eObject.eUnset(feature);
		return Status.OK_STATUS;
	}

}