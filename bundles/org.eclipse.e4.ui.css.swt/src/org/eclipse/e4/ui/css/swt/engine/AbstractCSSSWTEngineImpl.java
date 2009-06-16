/*******************************************************************************
 * Copyright (c) 2008 Angelo Zerr and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 *     IBM Corporation
 *******************************************************************************/
package org.eclipse.e4.ui.css.swt.engine;

import org.eclipse.e4.ui.css.core.impl.engine.CSSEngineImpl;
import org.eclipse.e4.ui.css.core.resources.IResourcesRegistry;
import org.eclipse.e4.ui.css.swt.dom.SWTElementProvider;
import org.eclipse.e4.ui.css.swt.properties.converters.CSSValueSWTColorConverterImpl;
import org.eclipse.e4.ui.css.swt.properties.converters.CSSValueSWTCursorConverterImpl;
import org.eclipse.e4.ui.css.swt.properties.converters.CSSValueSWTFontConverterImpl;
import org.eclipse.e4.ui.css.swt.properties.converters.CSSValueSWTFontDataConverterImpl;
import org.eclipse.e4.ui.css.swt.properties.converters.CSSValueSWTGradientConverterImpl;
import org.eclipse.e4.ui.css.swt.properties.converters.CSSValueSWTImageConverterImpl;
import org.eclipse.e4.ui.css.swt.properties.converters.CSSValueSWTRGBConverterImpl;
import org.eclipse.e4.ui.css.swt.resources.SWTResourcesRegistry;
import org.eclipse.e4.ui.css.swt.selectors.DynamicPseudoClassesSWTActiveHandler;
import org.eclipse.e4.ui.css.swt.selectors.DynamicPseudoClassesSWTButtonSelectedHandler;
import org.eclipse.e4.ui.css.swt.selectors.DynamicPseudoClassesSWTFocusHandler;
import org.eclipse.e4.ui.css.swt.selectors.DynamicPseudoClassesSWTHoverHandler;
import org.eclipse.swt.widgets.Display;

/**
 * CSS SWT Engine implementation which configure CSSEngineImpl to apply styles
 * to SWT widgets.
 */
public abstract class AbstractCSSSWTEngineImpl extends CSSEngineImpl {

	protected Display display;

	public AbstractCSSSWTEngineImpl(Display display) {
		this(display, false);
	}

	public AbstractCSSSWTEngineImpl(Display display, boolean lazyApplyingStyles) {
		this.display = display;

		// Register SWT Element Provider to retrieve
		// w3c Element SWTElement coming from SWT widget.
		super.setElementProvider(SWTElementProvider.INSTANCE);

		/** Initialize CSS Property Handlers * */

		this.initializeCSSPropertyHandlers();

		/** Initialize Dynamic pseudo classes * */

		// Register SWT Focus Handler
		super.registerDynamicPseudoClassHandler("focus",
				DynamicPseudoClassesSWTFocusHandler.INSTANCE);
		// Register SWT Active Handler
		super.registerDynamicPseudoClassHandler("active",
				DynamicPseudoClassesSWTActiveHandler.INSTANCE);
		// Register SWT Hover Handler
		super.registerDynamicPseudoClassHandler("hover",
				DynamicPseudoClassesSWTHoverHandler.INSTANCE);
		// Register SWT Checked Handler
		super.registerDynamicPseudoClassHandler("selected",
				DynamicPseudoClassesSWTButtonSelectedHandler.INSTANCE);

		/** Initialize SWT CSSValue converter * */

		// Register SWT RGB CSSValue Converter
		super.registerCSSValueConverter(CSSValueSWTRGBConverterImpl.INSTANCE);
		// Register SWT Color CSSValue Converter
		super.registerCSSValueConverter(CSSValueSWTColorConverterImpl.INSTANCE);
		// Register SWT Gradient CSSValue Converter
		super
				.registerCSSValueConverter(CSSValueSWTGradientConverterImpl.INSTANCE);
		// Register SWT Cursor CSSValue Converter
		super
				.registerCSSValueConverter(CSSValueSWTCursorConverterImpl.INSTANCE);
		// Register SWT Font CSSValue Converter
		super.registerCSSValueConverter(CSSValueSWTFontConverterImpl.INSTANCE);
		// Register SWT FontData CSSValue Converter
		super
				.registerCSSValueConverter(CSSValueSWTFontDataConverterImpl.INSTANCE);
		// Register SWT Image CSSValue Converter
		super.registerCSSValueConverter(CSSValueSWTImageConverterImpl.INSTANCE);

		if (lazyApplyingStyles) {
			new CSSSWTApplyStylesListener(display, this);
		}
	}

	protected abstract void initializeCSSPropertyHandlers();

	public IResourcesRegistry getResourcesRegistry() {
		IResourcesRegistry resourcesRegistry = super.getResourcesRegistry();
		if (resourcesRegistry == null) {
			super.setResourcesRegistry(new SWTResourcesRegistry(display));
		}
		return super.getResourcesRegistry();
	}
}
