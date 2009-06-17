package org.eclipse.e4.ui.css.swt.properties.css2;

import org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyMarginHandler;
import org.eclipse.e4.ui.css.core.dom.properties.css2.ICSSPropertyMarginHandler;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.swt.CSSSWTConstants;
import org.eclipse.e4.ui.css.swt.helpers.SWTElementHelpers;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.w3c.css.sac.CSSException;
import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.CSSValueList;

public class CSSPropertyMarginSWTHandler extends
		AbstractCSSPropertyMarginHandler {

	public final static ICSSPropertyMarginHandler INSTANCE = new CSSPropertyMarginSWTHandler();
	
	private final static int TOP = 0;
	private final static int RIGHT = 1;
	private final static int BOTTOM = 2;
	private final static int LEFT = 3;

	public boolean applyCSSProperty(Object element, String property,
			CSSValue value, String pseudo, CSSEngine engine) throws Exception {
		Control control = SWTElementHelpers.getControl(element);
		if (control == null)
			return false;
		
		Composite parent = control.getParent();
		if (parent == null)
			return true;
		
		super.applyCSSProperty(element, property, value, pseudo, engine);
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.e4.ui.css.core.dom.properties.css2.AbstractCSSPropertyMarginHandler#applyCSSPropertyMargin(java.lang.Object, org.w3c.dom.css.CSSValue, java.lang.String, org.eclipse.e4.ui.css.core.engine.CSSEngine)
	 * If single value then assigned to all four margins
	 * If four values then assigned top/right/bottom/left
	 * If three values then assigned top=v1, left=v2, right=v2, bottom=v3
	 * If two values then assigned top/bottom=v1, left/right=v2
	 */
	public void applyCSSPropertyMargin(Object element, CSSValue value,
			String pseudo, CSSEngine engine) throws Exception {
		
		// If single value then assigned to all four margins
		if(value.getCssValueType() == CSSValue.CSS_PRIMITIVE_VALUE) {
			setMargin(element, TOP, value);
			setMargin(element, RIGHT, value);
			setMargin(element, BOTTOM, value);
			setMargin(element, LEFT, value);
			return;
		}
		
		if(value.getCssValueType() == CSSValue.CSS_VALUE_LIST) {
			CSSValueList valueList = (CSSValueList) value;
			int length = valueList.getLength();

			if(length < 2 || length > 4)
				throw new CSSException("Invalid margin property list length");
			
			switch (length) {
			case 4:
				// If four values then assigned top/right/bottom/left
				setMargin(element, TOP, valueList.item(0));
				setMargin(element, RIGHT, valueList.item(1));
				setMargin(element, BOTTOM, valueList.item(2));
				setMargin(element, LEFT, valueList.item(3));				
				break;
			case 3:
				// If three values then assigned top=v1, left=v2, right=v2, bottom=v3
				setMargin(element, TOP, valueList.item(0));
				setMargin(element, RIGHT, valueList.item(1));
				setMargin(element, BOTTOM, valueList.item(2));
				setMargin(element, LEFT, valueList.item(1));
			case 2:
				// If two values then assigned top/bottom=v1, left/right=v2
				setMargin(element, TOP, valueList.item(0));
				setMargin(element, RIGHT, valueList.item(1));
				setMargin(element, BOTTOM, valueList.item(0));
				setMargin(element, LEFT, valueList.item(1));
			}
		} else {
			throw new CSSException("Invalid margin property value");
		}
	}

	public void applyCSSPropertyMarginTop(Object element, CSSValue value,
			String pseudo, CSSEngine engine) throws Exception {
		setMargin(element, TOP, value);
	}

	public void applyCSSPropertyMarginRight(Object element, CSSValue value,
			String pseudo, CSSEngine engine) throws Exception {
		setMargin(element, RIGHT, value);
	}

	public void applyCSSPropertyMarginBottom(Object element, CSSValue value,
			String pseudo, CSSEngine engine) throws Exception {
		setMargin(element, BOTTOM, value);
	}

	public void applyCSSPropertyMarginLeft(Object element, CSSValue value,
			String pseudo, CSSEngine engine) throws Exception {
		setMargin(element, LEFT, value);
	}

	public String retrieveCSSPropertyMargin(Object element, String pseudo,
			CSSEngine engine) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String retrieveCSSPropertyMarginTop(Object element, String pseudo,
			CSSEngine engine) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String retrieveCSSPropertyMarginRight(Object element, String pseudo,
			CSSEngine engine) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String retrieveCSSPropertyMarginBottom(Object element,
			String pseudo, CSSEngine engine) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String retrieveCSSPropertyMarginLeft(Object element, String pseudo,
			CSSEngine engine) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	private GridLayout getLayout(Object element) {
		Control control = SWTElementHelpers.getControl(element);
		if (control == null)
			return null;
		Composite parent = control.getParent();
		if (parent == null)
			return null;
		if(parent.getData(CSSSWTConstants.MARGIN_WRAPPER_KEY) == null)
			return null;
		
		Layout layout = parent.getLayout();
		if (layout == null || ! (layout instanceof GridLayout))
			return null;
		return (GridLayout) layout;
	}
	
	private void setMargin(Object element, int side, CSSValue value) {
		GridLayout layout = getLayout(element);
		if(layout == null)
			return;
		if(value.getCssValueType() != CSSValue.CSS_PRIMITIVE_VALUE)
			return;
		int pixelValue = (int) ((CSSPrimitiveValue) value).getFloatValue(CSSPrimitiveValue.CSS_PX);
		switch (side) {
		case TOP:
			layout.marginTop = pixelValue;
			break;
		case RIGHT:
			layout.marginRight = pixelValue;
			break;
		case BOTTOM:
			layout.marginBottom = pixelValue;			
			break;
		case LEFT:
			layout.marginLeft = pixelValue;
			break;
		}
	}
}
