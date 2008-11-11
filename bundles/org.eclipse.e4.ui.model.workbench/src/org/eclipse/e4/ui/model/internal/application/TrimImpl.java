/**
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      IBM Corporation - initial API and implementation
 *
 * $Id$
 */
package org.eclipse.e4.ui.model.internal.application;

import org.eclipse.e4.ui.model.application.ApplicationPackage;
import org.eclipse.e4.ui.model.application.Part;
import org.eclipse.e4.ui.model.application.Trim;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trim</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.e4.ui.model.internal.application.TrimImpl#getTopTrim <em>Top Trim</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.internal.application.TrimImpl#getLeftTrim <em>Left Trim</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.internal.application.TrimImpl#getRightTrim <em>Right Trim</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.internal.application.TrimImpl#getBottomTrim <em>Bottom Trim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TrimImpl extends ApplicationElementImpl implements Trim {
	/**
	 * The cached value of the '{@link #getTopTrim() <em>Top Trim</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopTrim()
	 * @generated
	 * @ordered
	 */
	protected Part<?> topTrim;

	/**
	 * The cached value of the '{@link #getLeftTrim() <em>Left Trim</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftTrim()
	 * @generated
	 * @ordered
	 */
	protected Part<?> leftTrim;

	/**
	 * The cached value of the '{@link #getRightTrim() <em>Right Trim</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightTrim()
	 * @generated
	 * @ordered
	 */
	protected Part<?> rightTrim;

	/**
	 * The cached value of the '{@link #getBottomTrim() <em>Bottom Trim</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBottomTrim()
	 * @generated
	 * @ordered
	 */
	protected Part<?> bottomTrim;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TrimImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ApplicationPackage.Literals.TRIM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part<?> getTopTrim() {
		return topTrim;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTopTrim(Part<?> newTopTrim, NotificationChain msgs) {
		Part<?> oldTopTrim = topTrim;
		topTrim = newTopTrim;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationPackage.TRIM__TOP_TRIM, oldTopTrim, newTopTrim);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopTrim(Part<?> newTopTrim) {
		if (newTopTrim != topTrim) {
			NotificationChain msgs = null;
			if (topTrim != null)
				msgs = ((InternalEObject)topTrim).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.TRIM__TOP_TRIM, null, msgs);
			if (newTopTrim != null)
				msgs = ((InternalEObject)newTopTrim).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.TRIM__TOP_TRIM, null, msgs);
			msgs = basicSetTopTrim(newTopTrim, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.TRIM__TOP_TRIM, newTopTrim, newTopTrim));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part<?> getLeftTrim() {
		return leftTrim;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftTrim(Part<?> newLeftTrim, NotificationChain msgs) {
		Part<?> oldLeftTrim = leftTrim;
		leftTrim = newLeftTrim;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationPackage.TRIM__LEFT_TRIM, oldLeftTrim, newLeftTrim);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftTrim(Part<?> newLeftTrim) {
		if (newLeftTrim != leftTrim) {
			NotificationChain msgs = null;
			if (leftTrim != null)
				msgs = ((InternalEObject)leftTrim).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.TRIM__LEFT_TRIM, null, msgs);
			if (newLeftTrim != null)
				msgs = ((InternalEObject)newLeftTrim).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.TRIM__LEFT_TRIM, null, msgs);
			msgs = basicSetLeftTrim(newLeftTrim, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.TRIM__LEFT_TRIM, newLeftTrim, newLeftTrim));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part<?> getRightTrim() {
		return rightTrim;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightTrim(Part<?> newRightTrim, NotificationChain msgs) {
		Part<?> oldRightTrim = rightTrim;
		rightTrim = newRightTrim;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationPackage.TRIM__RIGHT_TRIM, oldRightTrim, newRightTrim);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightTrim(Part<?> newRightTrim) {
		if (newRightTrim != rightTrim) {
			NotificationChain msgs = null;
			if (rightTrim != null)
				msgs = ((InternalEObject)rightTrim).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.TRIM__RIGHT_TRIM, null, msgs);
			if (newRightTrim != null)
				msgs = ((InternalEObject)newRightTrim).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.TRIM__RIGHT_TRIM, null, msgs);
			msgs = basicSetRightTrim(newRightTrim, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.TRIM__RIGHT_TRIM, newRightTrim, newRightTrim));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part<?> getBottomTrim() {
		return bottomTrim;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBottomTrim(Part<?> newBottomTrim, NotificationChain msgs) {
		Part<?> oldBottomTrim = bottomTrim;
		bottomTrim = newBottomTrim;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicationPackage.TRIM__BOTTOM_TRIM, oldBottomTrim, newBottomTrim);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBottomTrim(Part<?> newBottomTrim) {
		if (newBottomTrim != bottomTrim) {
			NotificationChain msgs = null;
			if (bottomTrim != null)
				msgs = ((InternalEObject)bottomTrim).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.TRIM__BOTTOM_TRIM, null, msgs);
			if (newBottomTrim != null)
				msgs = ((InternalEObject)newBottomTrim).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicationPackage.TRIM__BOTTOM_TRIM, null, msgs);
			msgs = basicSetBottomTrim(newBottomTrim, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.TRIM__BOTTOM_TRIM, newBottomTrim, newBottomTrim));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ApplicationPackage.TRIM__TOP_TRIM:
				return basicSetTopTrim(null, msgs);
			case ApplicationPackage.TRIM__LEFT_TRIM:
				return basicSetLeftTrim(null, msgs);
			case ApplicationPackage.TRIM__RIGHT_TRIM:
				return basicSetRightTrim(null, msgs);
			case ApplicationPackage.TRIM__BOTTOM_TRIM:
				return basicSetBottomTrim(null, msgs);
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
			case ApplicationPackage.TRIM__TOP_TRIM:
				return getTopTrim();
			case ApplicationPackage.TRIM__LEFT_TRIM:
				return getLeftTrim();
			case ApplicationPackage.TRIM__RIGHT_TRIM:
				return getRightTrim();
			case ApplicationPackage.TRIM__BOTTOM_TRIM:
				return getBottomTrim();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ApplicationPackage.TRIM__TOP_TRIM:
				setTopTrim((Part<?>)newValue);
				return;
			case ApplicationPackage.TRIM__LEFT_TRIM:
				setLeftTrim((Part<?>)newValue);
				return;
			case ApplicationPackage.TRIM__RIGHT_TRIM:
				setRightTrim((Part<?>)newValue);
				return;
			case ApplicationPackage.TRIM__BOTTOM_TRIM:
				setBottomTrim((Part<?>)newValue);
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
			case ApplicationPackage.TRIM__TOP_TRIM:
				setTopTrim((Part<?>)null);
				return;
			case ApplicationPackage.TRIM__LEFT_TRIM:
				setLeftTrim((Part<?>)null);
				return;
			case ApplicationPackage.TRIM__RIGHT_TRIM:
				setRightTrim((Part<?>)null);
				return;
			case ApplicationPackage.TRIM__BOTTOM_TRIM:
				setBottomTrim((Part<?>)null);
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
			case ApplicationPackage.TRIM__TOP_TRIM:
				return topTrim != null;
			case ApplicationPackage.TRIM__LEFT_TRIM:
				return leftTrim != null;
			case ApplicationPackage.TRIM__RIGHT_TRIM:
				return rightTrim != null;
			case ApplicationPackage.TRIM__BOTTOM_TRIM:
				return bottomTrim != null;
		}
		return super.eIsSet(featureID);
	}

} //TrimImpl
