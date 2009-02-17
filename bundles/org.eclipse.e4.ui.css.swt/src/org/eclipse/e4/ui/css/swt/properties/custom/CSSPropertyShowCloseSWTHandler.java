package org.eclipse.e4.ui.css.swt.properties.custom;

import org.eclipse.e4.ui.css.core.dom.properties.ICSSPropertyHandler;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.swt.properties.AbstractCSSPropertySWTHandler;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Control;
import org.w3c.dom.css.CSSValue;

public class CSSPropertyShowCloseSWTHandler extends AbstractCSSPropertySWTHandler{

	public static final ICSSPropertyHandler INSTANCE = new CSSPropertyShowCloseSWTHandler();
	
	public void applyCSSProperty(Control control, String property,
		    CSSValue value, String pseudo, CSSEngine engine) throws Exception {
		boolean isShowClose = (Boolean)engine.convert(value, Boolean.class, null);
		if (control instanceof CTabFolder) {
			CTabFolder folder = (CTabFolder) control;
			CTabItem[] itemList = folder.getItems();
			for(CTabItem item: itemList){
				item.setShowClose(isShowClose);
			}
		}
	}

	public String retrieveCSSProperty(Control control, String property,
			String pseudo, CSSEngine engine) throws Exception {
		return null;
	}
}
