/**
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      IBM Corporation - initial API and implementation
 */
package org.eclipse.e4.ui.model.application;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.e4.ui.model.application.MInput#getInputURI <em>Input URI</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.application.MInput#isDirty <em>Dirty</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.e4.ui.model.application.MApplicationPackage#getInput()
 * @model
 * @generated
 */
public interface MInput {
	/**
	 * Returns the value of the '<em><b>Input URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input URI</em>' attribute.
	 * @see #setInputURI(String)
	 * @see org.eclipse.e4.ui.model.application.MApplicationPackage#getInput_InputURI()
	 * @model
	 * @generated
	 */
	String getInputURI();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.ui.model.application.MInput#getInputURI <em>Input URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input URI</em>' attribute.
	 * @see #getInputURI()
	 * @generated
	 */
	void setInputURI(String value);

	/**
	 * Returns the value of the '<em><b>Dirty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dirty</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dirty</em>' attribute.
	 * @see #setDirty(boolean)
	 * @see org.eclipse.e4.ui.model.application.MApplicationPackage#getInput_Dirty()
	 * @model
	 * @generated
	 */
	boolean isDirty();

	/**
	 * Sets the value of the '{@link org.eclipse.e4.ui.model.application.MInput#isDirty <em>Dirty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dirty</em>' attribute.
	 * @see #isDirty()
	 * @generated
	 */
	void setDirty(boolean value);

} // MInput
