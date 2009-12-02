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

package org.eclipse.e4.ui.tests.reconciler;

import java.io.StringWriter;
import java.util.Collection;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import junit.framework.TestCase;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.MApplicationFactory;
import org.eclipse.e4.ui.model.application.MWindow;
import org.eclipse.e4.workbench.modeling.ModelDeltaOperation;
import org.eclipse.e4.workbench.modeling.ModelReconciler;
import org.w3c.dom.Node;

public abstract class ModelReconcilerTest extends TestCase {

	protected abstract ModelReconciler createModelReconciler();

	protected Collection<ModelDeltaOperation> applyDeltas(Object object,
			Object serializedState) {
		return applyDeltas(createModelReconciler(), object, serializedState);
	}

	protected Collection<ModelDeltaOperation> applyDeltas(
			ModelReconciler reconciler, Object object, Object serializedState) {
		return reconciler.applyDeltas(object, serializedState);
	}

	protected String createId() {
		return null;
	}

	protected void applyAll(Collection<ModelDeltaOperation> operations) {
		for (ModelDeltaOperation operation : operations) {
			IStatus status = operation.apply();
			assertNotNull(status);
			assertEquals(IStatus.OK, status.getCode());
		}
	}

	protected MApplication createApplication() {
		MApplication application = MApplicationFactory.eINSTANCE
				.createApplication();
		return application;
	}

	protected MWindow createWindow(MApplication application) {
		MWindow window = MApplicationFactory.eINSTANCE.createWindow();
		application.getChildren().add(window);
		return window;
	}

	protected static void print(Object serializedState) {
		print((Node) serializedState);
	}

	protected static void print(Node serializedState) {
		try {
			TransformerFactory transfac = TransformerFactory.newInstance();
			Transformer trans = transfac.newTransformer();
			trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			trans.setOutputProperty(OutputKeys.INDENT, "yes");

			// create string from xml tree
			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(serializedState);
			trans.transform(source, result);
			String xmlString = sw.toString();

			// print xml
			System.out.println(xmlString);
			System.out.println();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}