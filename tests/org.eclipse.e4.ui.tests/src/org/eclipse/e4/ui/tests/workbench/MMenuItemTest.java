/*******************************************************************************
 * Copyright (c) 2009, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/

package org.eclipse.e4.ui.tests.workbench;

import junit.framework.TestCase;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.internal.workbench.swt.AbstractPartRenderer;
import org.eclipse.e4.ui.internal.workbench.swt.E4Application;
import org.eclipse.e4.ui.internal.workbench.swt.PartRenderingEngine;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.impl.CommandsFactoryImpl;
import org.eclipse.e4.ui.model.application.impl.ApplicationFactoryImpl;
import org.eclipse.e4.ui.model.application.ui.MCoreExpression;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.basic.impl.BasicFactoryImpl;
import org.eclipse.e4.ui.model.application.ui.impl.UiFactoryImpl;
import org.eclipse.e4.ui.model.application.ui.menu.ItemType;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuContribution;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuSeparator;
import org.eclipse.e4.ui.model.application.ui.menu.impl.MenuFactoryImpl;
import org.eclipse.e4.ui.workbench.renderers.swt.MenuRenderer;
import org.eclipse.e4.ui.workbench.swt.factories.IRendererFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.MenuItem;

public class MMenuItemTest extends TestCase {
	protected IEclipseContext appContext;
	protected E4Workbench wb;

	@Override
	protected void setUp() throws Exception {
		appContext = E4Application.createDefaultContext();
		appContext.set(E4Workbench.PRESENTATION_URI_ARG,
				PartRenderingEngine.engineURI);
	}

	@Override
	protected void tearDown() throws Exception {
		if (wb != null) {
			wb.close();
		}
		appContext.dispose();
	}

	private void testMMenuItem_Text(String before, String beforeExpected,
			String after, String afterExpected) {
		MWindow window = BasicFactoryImpl.eINSTANCE.createWindow();
		MMenu menu = MenuFactoryImpl.eINSTANCE.createMenu();
		MMenuItem menuItem = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();

		menuItem.setLabel(before);

		window.setMainMenu(menu);
		menu.getChildren().add(menuItem);

		MApplication application = ApplicationFactoryImpl.eINSTANCE
				.createApplication();
		application.getChildren().add(window);
		application.setContext(appContext);
		appContext.set(MApplication.class.getName(), application);

		wb = new E4Workbench(window, appContext);
		wb.createAndRunUI(window);

		Object widget = menuItem.getWidget();
		assertNotNull(widget);
		assertTrue(widget instanceof MenuItem);

		MenuItem menuItemWidget = (MenuItem) widget;

		assertEquals(beforeExpected, menuItemWidget.getText());

		menuItem.setLabel(after);

		assertEquals(afterExpected, menuItemWidget.getText());
	}

	public void testMMenuItem_Text_NullNull() {
		testMMenuItem_Text(null, "", null, "");
	}

	public void testMMenuItem_Text_NullEmpty() {
		testMMenuItem_Text(null, "", "", "");
	}

	public void testMMenuItem_Text_NullString() {
		testMMenuItem_Text(null, "", "label", "label");
	}

	public void testMMenuItem_Text_EmptyNull() {
		testMMenuItem_Text("", "", null, "");
	}

	public void testMMenuItem_Text_EmptyEmpty() {
		testMMenuItem_Text("", "", "", "");
	}

	public void testMMenuItem_Text_EmptyString() {
		testMMenuItem_Text("", "", "label", "label");
	}

	public void testMMenuItem_Text_StringNull() {
		testMMenuItem_Text("label", "label", null, "");
	}

	public void testMMenuItem_Text_StringEmpty() {
		testMMenuItem_Text("label", "label", "", "");
	}

	public void testMMenuItem_Text_StringStringUnchanged() {
		testMMenuItem_Text("label", "label", "label", "label");
	}

	public void testMMenuItem_Text_StringStringChanged() {
		testMMenuItem_Text("label", "label", "label2", "label2");
	}

	public void testMMenuItem_RadioItems() {
		MWindow window = BasicFactoryImpl.eINSTANCE.createWindow();
		MMenu menu = MenuFactoryImpl.eINSTANCE.createMenu();
		MMenuItem menuItem1 = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();
		MMenuItem menuItem2 = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();

		menuItem1.setType(ItemType.RADIO);
		menuItem2.setType(ItemType.RADIO);

		menu.getChildren().add(menuItem1);
		menu.getChildren().add(menuItem2);
		window.setMainMenu(menu);

		MApplication application = ApplicationFactoryImpl.eINSTANCE
				.createApplication();
		application.getChildren().add(window);
		application.setContext(appContext);
		appContext.set(MApplication.class.getName(), application);

		wb = new E4Workbench(window, appContext);
		wb.createAndRunUI(window);

		Object widget1 = menuItem1.getWidget();
		assertNotNull(widget1);
		assertTrue(widget1 instanceof MenuItem);

		Object widget2 = menuItem2.getWidget();
		assertNotNull(widget2);
		assertTrue(widget2 instanceof MenuItem);

		MenuItem menuItemWidget1 = (MenuItem) widget1;
		MenuItem menuItemWidget2 = (MenuItem) widget2;

		// test that 'clicking' on the item updates the model
		menuItemWidget1.setSelection(false);
		menuItemWidget2.setSelection(true);
		menuItemWidget1.notifyListeners(SWT.Selection, new Event());
		menuItemWidget2.notifyListeners(SWT.Selection, new Event());

		assertFalse(menuItem1.isSelected());
		assertTrue(menuItem2.isSelected());

		menuItemWidget2.setSelection(false);
		menuItemWidget1.setSelection(true);
		menuItemWidget2.notifyListeners(SWT.Selection, new Event());
		menuItemWidget1.notifyListeners(SWT.Selection, new Event());

		assertTrue(menuItem1.isSelected());
		assertFalse(menuItem2.isSelected());

		// Check that model changes are reflected in the items
		menuItem1.setSelected(false);
		assertFalse(menuItemWidget1.getSelection());
		menuItem2.setSelected(true);
		assertTrue(menuItemWidget2.getSelection());
	}

	public void testMDirectMenuItem_Check_Bug316752() {
		MWindow window = BasicFactoryImpl.eINSTANCE.createWindow();
		MMenu menu = MenuFactoryImpl.eINSTANCE.createMenu();
		MMenuItem menuItem = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();

		menuItem.setType(ItemType.CHECK);
		menuItem.setSelected(true);

		menu.getChildren().add(menuItem);
		window.setMainMenu(menu);

		MApplication application = ApplicationFactoryImpl.eINSTANCE
				.createApplication();
		application.getChildren().add(window);
		application.setContext(appContext);
		appContext.set(MApplication.class.getName(), application);

		wb = new E4Workbench(window, appContext);
		wb.createAndRunUI(window);

		Object widget1 = menuItem.getWidget();
		assertNotNull(widget1);
		assertTrue(widget1 instanceof MenuItem);

		MenuItem menuItemWidget = (MenuItem) widget1;
		assertTrue(menuItemWidget.getSelection());
	}

	public void testMHandledMenuItem_Check_Bug316752() {
		MWindow window = BasicFactoryImpl.eINSTANCE.createWindow();
		MMenu menu = MenuFactoryImpl.eINSTANCE.createMenu();
		MHandledMenuItem menuItem = MenuFactoryImpl.eINSTANCE
				.createHandledMenuItem();
		MCommand command = CommandsFactoryImpl.eINSTANCE.createCommand();

		command.setElementId("commandId");
		command.setCommandName("CommandForTest");

		menuItem.setCommand(command);
		menuItem.setType(ItemType.CHECK);
		menuItem.setSelected(true);

		menu.getChildren().add(menuItem);
		window.setMainMenu(menu);

		MApplication application = ApplicationFactoryImpl.eINSTANCE
				.createApplication();
		application.getChildren().add(window);
		application.getCommands().add(command);
		application.setContext(appContext);
		appContext.set(MApplication.class.getName(), application);

		wb = new E4Workbench(window, appContext);
		wb.createAndRunUI(window);

		Object widget1 = menuItem.getWidget();
		assertNotNull(widget1);
		assertTrue(widget1 instanceof MenuItem);

		MenuItem menuItemWidget = (MenuItem) widget1;
		assertTrue(menuItemWidget.getSelection());
	}

	public void XXXtestSubMenuCreation() throws Exception {
		MWindow window = BasicFactoryImpl.eINSTANCE.createWindow();
		MMenu menuBar = MenuFactoryImpl.eINSTANCE.createMenu();
		menuBar.setElementId("org.eclipse.ui.main.menu");
		window.setMainMenu(menuBar);

		MMenu fileMenu = MenuFactoryImpl.eINSTANCE.createMenu();
		fileMenu.setElementId("file");
		fileMenu.setLabel("File");
		menuBar.getChildren().add(fileMenu);

		MMenuItem item1 = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();
		item1.setElementId("item1");
		item1.setLabel("item1");
		fileMenu.getChildren().add(item1);

		MMenuSeparator sep = MenuFactoryImpl.eINSTANCE.createMenuSeparator();
		sep.setElementId("group1");
		fileMenu.getChildren().add(sep);

		MMenuItem item2 = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();
		item2.setElementId("item2");
		item2.setLabel("item2");
		fileMenu.getChildren().add(item2);

		MApplication application = ApplicationFactoryImpl.eINSTANCE
				.createApplication();
		application.getChildren().add(window);
		application.setContext(appContext);
		appContext.set(MApplication.class.getName(), application);

		wb = new E4Workbench(window, appContext);
		wb.createAndRunUI(window);

	}

	public void XXXtestTbrItem() throws Exception {
		MWindow window = BasicFactoryImpl.eINSTANCE.createWindow();
		MMenu menuBar = MenuFactoryImpl.eINSTANCE.createMenu();
		menuBar.setElementId("org.eclipse.ui.main.menu");
		window.setMainMenu(menuBar);

		MMenu fileMenu = MenuFactoryImpl.eINSTANCE.createMenu();
		fileMenu.setElementId("file");
		fileMenu.setLabel("File");
		menuBar.getChildren().add(fileMenu);

		MMenuItem item1 = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();
		item1.setElementId("item1");
		item1.setLabel("item1");
		fileMenu.getChildren().add(item1);

		MMenuSeparator sep = MenuFactoryImpl.eINSTANCE.createMenuSeparator();
		sep.setElementId("group1");
		fileMenu.getChildren().add(sep);

		MMenuItem item2 = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();
		item2.setElementId("item2");
		item2.setLabel("item2");
		fileMenu.getChildren().add(item2);
		item2.setToBeRendered(false);

		MApplication application = ApplicationFactoryImpl.eINSTANCE
				.createApplication();
		application.getChildren().add(window);
		application.setContext(appContext);
		appContext.set(MApplication.class.getName(), application);

		wb = new E4Workbench(window, appContext);
		wb.createAndRunUI(window);

		// MenuRenderer renderer = getRenderer(appContext, menuBar);

	}

	public void XXXtestInvisibleItem() throws Exception {
		MWindow window = BasicFactoryImpl.eINSTANCE.createWindow();
		MMenu menuBar = MenuFactoryImpl.eINSTANCE.createMenu();
		menuBar.setElementId("org.eclipse.ui.main.menu");
		window.setMainMenu(menuBar);

		MMenu fileMenu = MenuFactoryImpl.eINSTANCE.createMenu();
		fileMenu.setElementId("file");
		fileMenu.setLabel("File");
		menuBar.getChildren().add(fileMenu);

		MMenuItem item1 = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();
		item1.setElementId("item1");
		item1.setLabel("item1");
		fileMenu.getChildren().add(item1);

		MMenuSeparator sep = MenuFactoryImpl.eINSTANCE.createMenuSeparator();
		sep.setElementId("group1");
		fileMenu.getChildren().add(sep);

		MMenuItem item2 = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();
		item2.setElementId("item2");
		item2.setLabel("item2");
		fileMenu.getChildren().add(item2);
		item2.setVisible(false);

		MApplication application = ApplicationFactoryImpl.eINSTANCE
				.createApplication();
		application.getChildren().add(window);
		application.setContext(appContext);
		appContext.set(MApplication.class.getName(), application);

		wb = new E4Workbench(window, appContext);
		wb.createAndRunUI(window);

		// MenuRenderer renderer = getRenderer(appContext, menuBar);

	}

	public void XXXtestMenuContribution() throws Exception {
		MWindow window = BasicFactoryImpl.eINSTANCE.createWindow();
		MMenu menuBar = MenuFactoryImpl.eINSTANCE.createMenu();
		menuBar.setElementId("org.eclipse.ui.main.menu");
		window.setMainMenu(menuBar);

		MMenu fileMenu = MenuFactoryImpl.eINSTANCE.createMenu();
		fileMenu.setElementId("file");
		fileMenu.setLabel("File");
		menuBar.getChildren().add(fileMenu);

		MMenuItem item1 = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();
		item1.setElementId("item1");
		item1.setLabel("item1");
		fileMenu.getChildren().add(item1);

		MMenuSeparator sep = MenuFactoryImpl.eINSTANCE.createMenuSeparator();
		sep.setElementId("group1");
		fileMenu.getChildren().add(sep);

		MMenuItem item2 = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();
		item2.setElementId("item2");
		item2.setLabel("item2");
		fileMenu.getChildren().add(item2);

		MApplication application = ApplicationFactoryImpl.eINSTANCE
				.createApplication();
		application.getChildren().add(window);
		application.setContext(appContext);
		appContext.set(MApplication.class.getName(), application);
		application.getMenuContributions().add(createContribution(false));

		wb = new E4Workbench(window, appContext);
		wb.createAndRunUI(window);

	}

	public void XXXtestWithVisible() throws Exception {
		MWindow window = BasicFactoryImpl.eINSTANCE.createWindow();
		MMenu menuBar = MenuFactoryImpl.eINSTANCE.createMenu();
		menuBar.setElementId("org.eclipse.ui.main.menu");
		window.setMainMenu(menuBar);

		MMenu fileMenu = MenuFactoryImpl.eINSTANCE.createMenu();
		fileMenu.setElementId("file");
		fileMenu.setLabel("File");
		menuBar.getChildren().add(fileMenu);

		MMenuItem item1 = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();
		item1.setElementId("item1");
		item1.setLabel("item1");
		fileMenu.getChildren().add(item1);

		MMenuSeparator sep = MenuFactoryImpl.eINSTANCE.createMenuSeparator();
		sep.setElementId("group1");
		fileMenu.getChildren().add(sep);

		MMenuItem item2 = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();
		item2.setElementId("item2");
		item2.setLabel("item2");
		fileMenu.getChildren().add(item2);

		MApplication application = ApplicationFactoryImpl.eINSTANCE
				.createApplication();
		application.getChildren().add(window);
		application.setContext(appContext);
		appContext.set(MApplication.class.getName(), application);
		application.getMenuContributions().add(createContribution(true));

		wb = new E4Workbench(window, appContext);
		wb.createAndRunUI(window);

	}

	public void XXXtestMenuBarVisibility() throws Exception {
		MWindow window = BasicFactoryImpl.eINSTANCE.createWindow();
		MMenu menuBar = MenuFactoryImpl.eINSTANCE.createMenu();
		menuBar.setElementId("org.eclipse.ui.main.menu");
		window.setMainMenu(menuBar);

		MMenu fileMenu = MenuFactoryImpl.eINSTANCE.createMenu();
		fileMenu.setElementId("file");
		fileMenu.setLabel("File");
		menuBar.getChildren().add(fileMenu);

		MMenuItem item1 = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();
		item1.setElementId("item1");
		item1.setLabel("item1");
		fileMenu.getChildren().add(item1);

		MMenuSeparator sep = MenuFactoryImpl.eINSTANCE.createMenuSeparator();
		sep.setElementId("group1");
		fileMenu.getChildren().add(sep);

		MMenuItem item2 = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();
		item2.setElementId("item2");
		item2.setLabel("item2");
		fileMenu.getChildren().add(item2);

		MApplication application = ApplicationFactoryImpl.eINSTANCE
				.createApplication();
		application.getChildren().add(window);
		application.setContext(appContext);
		appContext.set(MApplication.class.getName(), application);
		createMenuContribution(application);

		wb = new E4Workbench(window, appContext);
		wb.createAndRunUI(window);

	}

	private MMenuContribution createContribution(boolean withVisibleWhen) {
		MMenuContribution mmc = MenuFactoryImpl.eINSTANCE
				.createMenuContribution();
		mmc.setElementId("test.contrib1");
		mmc.setParentId("file");
		mmc.setPositionInParent("after=additions");

		MMenuItem item1 = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();
		item1.setElementId("mmc.item1");
		item1.setLabel("mmc.item1");
		mmc.getChildren().add(item1);

		if (withVisibleWhen) {
			MCoreExpression exp = UiFactoryImpl.eINSTANCE
					.createCoreExpression();
			exp.setCoreExpressionId("org.eclipse.e4.ui.tests.withMmc1");
			mmc.setVisibleWhen(exp);
		}

		return mmc;
	}

	private void createMenuContribution(MApplication application) {
		MMenuContribution mmc = MenuFactoryImpl.eINSTANCE
				.createMenuContribution();
		mmc.setElementId("test.contrib2");
		mmc.setParentId("org.eclipse.ui.main.menu");
		mmc.setPositionInParent("after=additions");

		MMenu menu = MenuFactoryImpl.eINSTANCE.createMenu();
		menu.setElementId("vanish");
		menu.setLabel("Vanish");
		mmc.getChildren().add(menu);

		MCoreExpression exp = UiFactoryImpl.eINSTANCE.createCoreExpression();
		exp.setCoreExpressionId("org.eclipse.e4.ui.tests.withMmc1");
		mmc.setVisibleWhen(exp);

		application.getMenuContributions().add(mmc);

		mmc = MenuFactoryImpl.eINSTANCE.createMenuContribution();
		mmc.setElementId("test.contrib3");
		mmc.setParentId("vanish");
		mmc.setPositionInParent("after=additions");

		MMenuItem item1 = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();
		item1.setElementId("mmc.item2");
		item1.setLabel("mmc.item2");
		mmc.getChildren().add(item1);

		// exp = UiFactoryImpl.eINSTANCE.createCoreExpression();
		// exp.setCoreExpressionId("org.eclipse.e4.ui.tests.withMmc1");
		// mmc.setVisibleWhen(exp);

		application.getMenuContributions().add(mmc);
	}

	MenuRenderer getRenderer(IEclipseContext context, MUIElement element) {
		IRendererFactory rendererFactory = context.get(IRendererFactory.class);
		AbstractPartRenderer renderer = rendererFactory.getRenderer(element,
				null);
		assertEquals(MenuRenderer.class, renderer.getClass());
		return (MenuRenderer) renderer;
	}
}
