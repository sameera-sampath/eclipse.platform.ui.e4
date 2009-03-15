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
 * $Id: MContributedPartImpl.java,v 1.1 2009/02/03 14:25:36 emoffatt Exp $
 */
package org.eclipse.e4.ui.model.internal.application;

import org.eclipse.e4.ui.model.application.ApplicationPackage;
import org.eclipse.e4.ui.model.application.MContributedPart;
import org.eclipse.e4.ui.model.application.MContribution;
import org.eclipse.e4.ui.model.application.MPart;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MContributed Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.e4.ui.model.internal.application.MContributedPartImpl#getURI <em>URI</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.internal.application.MContributedPartImpl#getObject <em>Object</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.internal.application.MContributedPartImpl#getPersistedState <em>Persisted State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MContributedPartImpl<P extends MPart<?>> extends MItemPartImpl<P> implements MContributedPart<P> {
	/**
	 * The default value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getObject() <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected static final Object OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected Object object = OBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPersistedState() <em>Persisted State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistedState()
	 * @generated
	 * @ordered
	 */
	protected static final String PERSISTED_STATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPersistedState() <em>Persisted State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistedState()
	 * @generated
	 * @ordered
	 */
	protected String persistedState = PERSISTED_STATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MContributedPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ApplicationPackage.Literals.MCONTRIBUTED_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getURI() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setURI(String newURI) {
		String oldURI = uri;
		uri = newURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.MCONTRIBUTED_PART__URI, oldURI, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObject(Object newObject) {
		Object oldObject = object;
		object = newObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.MCONTRIBUTED_PART__OBJECT, oldObject, object));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPersistedState() {
		return persistedState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersistedState(String newPersistedState) {
		String oldPersistedState = persistedState;
		persistedState = newPersistedState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicationPackage.MCONTRIBUTED_PART__PERSISTED_STATE, oldPersistedState, persistedState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ApplicationPackage.MCONTRIBUTED_PART__URI:
				return getURI();
			case ApplicationPackage.MCONTRIBUTED_PART__OBJECT:
				return getObject();
			case ApplicationPackage.MCONTRIBUTED_PART__PERSISTED_STATE:
				return getPersistedState();
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
			case ApplicationPackage.MCONTRIBUTED_PART__URI:
				setURI((String)newValue);
				return;
			case ApplicationPackage.MCONTRIBUTED_PART__OBJECT:
				setObject(newValue);
				return;
			case ApplicationPackage.MCONTRIBUTED_PART__PERSISTED_STATE:
				setPersistedState((String)newValue);
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
			case ApplicationPackage.MCONTRIBUTED_PART__URI:
				setURI(URI_EDEFAULT);
				return;
			case ApplicationPackage.MCONTRIBUTED_PART__OBJECT:
				setObject(OBJECT_EDEFAULT);
				return;
			case ApplicationPackage.MCONTRIBUTED_PART__PERSISTED_STATE:
				setPersistedState(PERSISTED_STATE_EDEFAULT);
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
			case ApplicationPackage.MCONTRIBUTED_PART__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case ApplicationPackage.MCONTRIBUTED_PART__OBJECT:
				return OBJECT_EDEFAULT == null ? object != null : !OBJECT_EDEFAULT.equals(object);
			case ApplicationPackage.MCONTRIBUTED_PART__PERSISTED_STATE:
				return PERSISTED_STATE_EDEFAULT == null ? persistedState != null : !PERSISTED_STATE_EDEFAULT.equals(persistedState);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == MContribution.class) {
			switch (derivedFeatureID) {
				case ApplicationPackage.MCONTRIBUTED_PART__URI: return ApplicationPackage.MCONTRIBUTION__URI;
				case ApplicationPackage.MCONTRIBUTED_PART__OBJECT: return ApplicationPackage.MCONTRIBUTION__OBJECT;
				case ApplicationPackage.MCONTRIBUTED_PART__PERSISTED_STATE: return ApplicationPackage.MCONTRIBUTION__PERSISTED_STATE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == MContribution.class) {
			switch (baseFeatureID) {
				case ApplicationPackage.MCONTRIBUTION__URI: return ApplicationPackage.MCONTRIBUTED_PART__URI;
				case ApplicationPackage.MCONTRIBUTION__OBJECT: return ApplicationPackage.MCONTRIBUTED_PART__OBJECT;
				case ApplicationPackage.MCONTRIBUTION__PERSISTED_STATE: return ApplicationPackage.MCONTRIBUTED_PART__PERSISTED_STATE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (URI: "); //$NON-NLS-1$
		result.append(uri);
		result.append(", object: "); //$NON-NLS-1$
		result.append(object);
		result.append(", persistedState: "); //$NON-NLS-1$
		result.append(persistedState);
		result.append(')');
		return result.toString();
	}

} //MContributedPartImpl
