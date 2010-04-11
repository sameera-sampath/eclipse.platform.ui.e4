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
package org.eclipse.e4.ui.model.application.ui.menu;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @generated
 */
public interface MMenuFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MMenuFactory INSTANCE = org.eclipse.e4.ui.model.application.ui.menu.impl.MenuFactoryImpl.eINSTANCE;

	/**
	 * Returns a new object of class '<em>Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Item</em>'.
	 * @generated
	 */
	MItem createItem();

	/**
	 * Returns a new object of class '<em>Menu</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Menu</em>'.
	 * @generated
	 */
	MMenu createMenu();

	/**
	 * Returns a new object of class '<em>Direct Menu Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Direct Menu Item</em>'.
	 * @generated
	 */
	MDirectMenuItem createDirectMenuItem();

	/**
	 * Returns a new object of class '<em>Handled Menu Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Handled Menu Item</em>'.
	 * @generated
	 */
	MHandledMenuItem createHandledMenuItem();

	/**
	 * Returns a new object of class '<em>Direct Tool Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Direct Tool Item</em>'.
	 * @generated
	 */
	MDirectToolItem createDirectToolItem();

	/**
	 * Returns a new object of class '<em>Tool Bar Separator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tool Bar Separator</em>'.
	 * @generated
	 */
	MToolBarSeparator createToolBarSeparator();

	/**
	 * Returns a new object of class '<em>Tool Bar</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tool Bar</em>'.
	 * @generated
	 */
	MToolBar createToolBar();

	/**
	 * Returns a new object of class '<em>Tool Control</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tool Control</em>'.
	 * @generated
	 */
	MToolControl createToolControl();

	/**
	 * Returns a new object of class '<em>Handled Tool Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Handled Tool Item</em>'.
	 * @generated
	 */
	MHandledToolItem createHandledToolItem();

	/**
	 * Returns a new object of class '<em>Handled Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Handled Item</em>'.
	 * @generated
	 */
	MHandledItem createHandledItem();

	/**
	 * Returns a new object of class '<em>Separator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Separator</em>'.
	 * @generated
	 */
	MMenuSeparator createMenuSeparator();

} //MMenuFactory
