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
package org.eclipse.e4.ui.model.application.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.e4.ui.model.application.util.ApplicationAdapterFactory;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ApplicationItemProviderAdapterFactory extends ApplicationAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MItem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ItemItemProvider itemItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createItemAdapter() {
		if (itemItemProvider == null) {
			itemItemProvider = new ItemItemProvider(this);
		}

		return itemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MMenuItem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuItemItemProvider menuItemItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MMenuItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMenuItemAdapter() {
		if (menuItemItemProvider == null) {
			menuItemItemProvider = new MenuItemItemProvider(this);
		}

		return menuItemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MDirectMenuItem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DirectMenuItemItemProvider directMenuItemItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MDirectMenuItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDirectMenuItemAdapter() {
		if (directMenuItemItemProvider == null) {
			directMenuItemItemProvider = new DirectMenuItemItemProvider(this);
		}

		return directMenuItemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MMenu} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuItemProvider menuItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MMenu}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMenuAdapter() {
		if (menuItemProvider == null) {
			menuItemProvider = new MenuItemProvider(this);
		}

		return menuItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MToolItem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolItemItemProvider toolItemItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MToolItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createToolItemAdapter() {
		if (toolItemItemProvider == null) {
			toolItemItemProvider = new ToolItemItemProvider(this);
		}

		return toolItemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MDirectToolItem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DirectToolItemItemProvider directToolItemItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MDirectToolItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDirectToolItemAdapter() {
		if (directToolItemItemProvider == null) {
			directToolItemItemProvider = new DirectToolItemItemProvider(this);
		}

		return directToolItemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MToolBar} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolBarItemProvider toolBarItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MToolBar}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createToolBarAdapter() {
		if (toolBarItemProvider == null) {
			toolBarItemProvider = new ToolBarItemProvider(this);
		}

		return toolBarItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MApplication} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationItemProvider applicationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MApplication}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createApplicationAdapter() {
		if (applicationItemProvider == null) {
			applicationItemProvider = new ApplicationItemProvider(this);
		}

		return applicationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MPart} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartItemProvider partItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MPart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPartAdapter() {
		if (partItemProvider == null) {
			partItemProvider = new PartItemProvider(this);
		}

		return partItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MPartDescriptor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartDescriptorItemProvider partDescriptorItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MPartDescriptor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPartDescriptorAdapter() {
		if (partDescriptorItemProvider == null) {
			partDescriptorItemProvider = new PartDescriptorItemProvider(this);
		}

		return partDescriptorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MPartDescriptorContainer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartDescriptorContainerItemProvider partDescriptorContainerItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MPartDescriptorContainer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPartDescriptorContainerAdapter() {
		if (partDescriptorContainerItemProvider == null) {
			partDescriptorContainerItemProvider = new PartDescriptorContainerItemProvider(this);
		}

		return partDescriptorContainerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MSaveablePart} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaveablePartItemProvider saveablePartItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MSaveablePart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSaveablePartAdapter() {
		if (saveablePartItemProvider == null) {
			saveablePartItemProvider = new SaveablePartItemProvider(this);
		}

		return saveablePartItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MPartStack} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartStackItemProvider partStackItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MPartStack}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPartStackAdapter() {
		if (partStackItemProvider == null) {
			partStackItemProvider = new PartStackItemProvider(this);
		}

		return partStackItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MPartSashContainer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartSashContainerItemProvider partSashContainerItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MPartSashContainer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPartSashContainerAdapter() {
		if (partSashContainerItemProvider == null) {
			partSashContainerItemProvider = new PartSashContainerItemProvider(this);
		}

		return partSashContainerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MWindow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WindowItemProvider windowItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MWindow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWindowAdapter() {
		if (windowItemProvider == null) {
			windowItemProvider = new WindowItemProvider(this);
		}

		return windowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MModelComponents} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelComponentsItemProvider modelComponentsItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MModelComponents}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModelComponentsAdapter() {
		if (modelComponentsItemProvider == null) {
			modelComponentsItemProvider = new ModelComponentsItemProvider(this);
		}

		return modelComponentsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MModelComponent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelComponentItemProvider modelComponentItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MModelComponent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModelComponentAdapter() {
		if (modelComponentItemProvider == null) {
			modelComponentItemProvider = new ModelComponentItemProvider(this);
		}

		return modelComponentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MCommand} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommandItemProvider commandItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCommandAdapter() {
		if (commandItemProvider == null) {
			commandItemProvider = new CommandItemProvider(this);
		}

		return commandItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MCommandParameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommandParameterItemProvider commandParameterItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MCommandParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCommandParameterAdapter() {
		if (commandParameterItemProvider == null) {
			commandParameterItemProvider = new CommandParameterItemProvider(this);
		}

		return commandParameterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MHandler} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HandlerItemProvider handlerItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MHandler}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHandlerAdapter() {
		if (handlerItemProvider == null) {
			handlerItemProvider = new HandlerItemProvider(this);
		}

		return handlerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MHandledItem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HandledItemItemProvider handledItemItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MHandledItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHandledItemAdapter() {
		if (handledItemItemProvider == null) {
			handledItemItemProvider = new HandledItemItemProvider(this);
		}

		return handledItemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MHandledMenuItem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HandledMenuItemItemProvider handledMenuItemItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MHandledMenuItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHandledMenuItemAdapter() {
		if (handledMenuItemItemProvider == null) {
			handledMenuItemItemProvider = new HandledMenuItemItemProvider(this);
		}

		return handledMenuItemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MHandledToolItem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HandledToolItemItemProvider handledToolItemItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MHandledToolItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHandledToolItemAdapter() {
		if (handledToolItemItemProvider == null) {
			handledToolItemItemProvider = new HandledToolItemItemProvider(this);
		}

		return handledToolItemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MKeyBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KeyBindingItemProvider keyBindingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MKeyBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createKeyBindingAdapter() {
		if (keyBindingItemProvider == null) {
			keyBindingItemProvider = new KeyBindingItemProvider(this);
		}

		return keyBindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MParameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterItemProvider parameterItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createParameterAdapter() {
		if (parameterItemProvider == null) {
			parameterItemProvider = new ParameterItemProvider(this);
		}

		return parameterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MWindowTrim} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WindowTrimItemProvider windowTrimItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MWindowTrim}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWindowTrimAdapter() {
		if (windowTrimItemProvider == null) {
			windowTrimItemProvider = new WindowTrimItemProvider(this);
		}

		return windowTrimItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MEditor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EditorItemProvider editorItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MEditor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEditorAdapter() {
		if (editorItemProvider == null) {
			editorItemProvider = new EditorItemProvider(this);
		}

		return editorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MPlaceholder} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaceholderItemProvider placeholderItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MPlaceholder}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPlaceholderAdapter() {
		if (placeholderItemProvider == null) {
			placeholderItemProvider = new PlaceholderItemProvider(this);
		}

		return placeholderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MPerspective} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PerspectiveItemProvider perspectiveItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MPerspective}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPerspectiveAdapter() {
		if (perspectiveItemProvider == null) {
			perspectiveItemProvider = new PerspectiveItemProvider(this);
		}

		return perspectiveItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MPerspectiveStack} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PerspectiveStackItemProvider perspectiveStackItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MPerspectiveStack}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPerspectiveStackAdapter() {
		if (perspectiveStackItemProvider == null) {
			perspectiveStackItemProvider = new PerspectiveStackItemProvider(this);
		}

		return perspectiveStackItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.e4.ui.model.application.MTestHarness} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestHarnessItemProvider testHarnessItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.e4.ui.model.application.MTestHarness}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTestHarnessAdapter() {
		if (testHarnessItemProvider == null) {
			testHarnessItemProvider = new TestHarnessItemProvider(this);
		}

		return testHarnessItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (itemItemProvider != null) itemItemProvider.dispose();
		if (menuItemItemProvider != null) menuItemItemProvider.dispose();
		if (directMenuItemItemProvider != null) directMenuItemItemProvider.dispose();
		if (menuItemProvider != null) menuItemProvider.dispose();
		if (toolItemItemProvider != null) toolItemItemProvider.dispose();
		if (directToolItemItemProvider != null) directToolItemItemProvider.dispose();
		if (toolBarItemProvider != null) toolBarItemProvider.dispose();
		if (applicationItemProvider != null) applicationItemProvider.dispose();
		if (partItemProvider != null) partItemProvider.dispose();
		if (partDescriptorItemProvider != null) partDescriptorItemProvider.dispose();
		if (partDescriptorContainerItemProvider != null) partDescriptorContainerItemProvider.dispose();
		if (saveablePartItemProvider != null) saveablePartItemProvider.dispose();
		if (partStackItemProvider != null) partStackItemProvider.dispose();
		if (partSashContainerItemProvider != null) partSashContainerItemProvider.dispose();
		if (windowItemProvider != null) windowItemProvider.dispose();
		if (modelComponentsItemProvider != null) modelComponentsItemProvider.dispose();
		if (modelComponentItemProvider != null) modelComponentItemProvider.dispose();
		if (commandItemProvider != null) commandItemProvider.dispose();
		if (commandParameterItemProvider != null) commandParameterItemProvider.dispose();
		if (handlerItemProvider != null) handlerItemProvider.dispose();
		if (handledItemItemProvider != null) handledItemItemProvider.dispose();
		if (handledMenuItemItemProvider != null) handledMenuItemItemProvider.dispose();
		if (handledToolItemItemProvider != null) handledToolItemItemProvider.dispose();
		if (keyBindingItemProvider != null) keyBindingItemProvider.dispose();
		if (parameterItemProvider != null) parameterItemProvider.dispose();
		if (windowTrimItemProvider != null) windowTrimItemProvider.dispose();
		if (editorItemProvider != null) editorItemProvider.dispose();
		if (placeholderItemProvider != null) placeholderItemProvider.dispose();
		if (perspectiveItemProvider != null) perspectiveItemProvider.dispose();
		if (perspectiveStackItemProvider != null) perspectiveStackItemProvider.dispose();
		if (testHarnessItemProvider != null) testHarnessItemProvider.dispose();
	}

}
