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
package org.eclipse.e4.ui.model.application.impl;

import java.util.Collection;

import org.eclipse.e4.ui.model.application.MApplicationPackage;
import org.eclipse.e4.ui.model.application.MElementContainer;
import org.eclipse.e4.ui.model.application.MUIElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.e4.ui.model.application.impl.ElementContainerImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.application.impl.ElementContainerImpl#getSelectedElement <em>Selected Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ElementContainerImpl<T extends MUIElement> extends UIElementImpl implements MElementContainer<T> {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<T> children;

	/**
	 * The cached value of the '{@link #getSelectedElement() <em>Selected Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectedElement()
	 * @generated
	 * @ordered
	 */
	protected T selectedElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MApplicationPackage.Literals.ELEMENT_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<T> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<T>(MUIElement.class, this, MApplicationPackage.ELEMENT_CONTAINER__CHILDREN, MApplicationPackage.UI_ELEMENT__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public T getSelectedElement() {
		if (selectedElement != null && ((EObject)selectedElement).eIsProxy()) {
			InternalEObject oldSelectedElement = (InternalEObject)selectedElement;
			selectedElement = (T)eResolveProxy(oldSelectedElement);
			if (selectedElement != oldSelectedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MApplicationPackage.ELEMENT_CONTAINER__SELECTED_ELEMENT, oldSelectedElement, selectedElement));
			}
		}
		return selectedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public T basicGetSelectedElement() {
		return selectedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectedElement(T newSelectedElement) {
		T oldSelectedElement = selectedElement;
		selectedElement = newSelectedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MApplicationPackage.ELEMENT_CONTAINER__SELECTED_ELEMENT, oldSelectedElement, selectedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MApplicationPackage.ELEMENT_CONTAINER__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MApplicationPackage.ELEMENT_CONTAINER__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MApplicationPackage.ELEMENT_CONTAINER__CHILDREN:
				return getChildren();
			case MApplicationPackage.ELEMENT_CONTAINER__SELECTED_ELEMENT:
				if (resolve) return getSelectedElement();
				return basicGetSelectedElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MApplicationPackage.ELEMENT_CONTAINER__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends T>)newValue);
				return;
			case MApplicationPackage.ELEMENT_CONTAINER__SELECTED_ELEMENT:
				setSelectedElement((T)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MApplicationPackage.ELEMENT_CONTAINER__CHILDREN:
				getChildren().clear();
				return;
			case MApplicationPackage.ELEMENT_CONTAINER__SELECTED_ELEMENT:
				setSelectedElement((T)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MApplicationPackage.ELEMENT_CONTAINER__CHILDREN:
				return children != null && !children.isEmpty();
			case MApplicationPackage.ELEMENT_CONTAINER__SELECTED_ELEMENT:
				return selectedElement != null;
		}
		return super.eIsSet(featureID);
	}

} //ElementContainerImpl
