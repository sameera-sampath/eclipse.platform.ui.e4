/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/

package org.eclipse.e4.core.commands.internal;

import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.services.context.IEclipseContext;
import org.eclipse.e4.core.services.context.spi.ContextInjectionFactory;

/**
 *
 */
public class HandlerServiceImpl implements EHandlerService {
	static final String METHOD_EXECUTE = "execute"; //$NON-NLS-1$
	static final String METHOD_CAN_EXECUTE = "canExecute"; //$NON-NLS-1$
	final static String H_ID = "handler::"; //$NON-NLS-1$
	final static String PARM_MAP = "parmMap::"; //$NON-NLS-1$
	final static String HANDLER_LOOKUP = "org.eclipse.e4.core.commands.EHandlerLookup"; //$NON-NLS-1$
	final static String LOOKUP_HANDLER = "handler"; //$NON-NLS-1$

	private IEclipseContext context;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.e4.core.commands.EHandlerService#activateHandler(java.lang.String,
	 * java.lang.Object)
	 */
	public void activateHandler(String commandId, Object handler) {
		String handlerId = H_ID + commandId;
		context.set(handlerId, handler);
	}

	/**
	 * @param command
	 */
	private void addParmsToContext(ParameterizedCommand command) {
		final Map parms = command.getParameterMap();
		Iterator i = parms.entrySet().iterator();
		while (i.hasNext()) {
			Map.Entry entry = (Map.Entry) i.next();
			context.set((String) entry.getKey(), entry.getValue());
		}
		context.set(PARM_MAP, parms);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.e4.core.commands.EHandlerService#canExecute(org.eclipse.core.commands.
	 * ParameterizedCommand)
	 */
	public boolean canExecute(ParameterizedCommand command) {
		String commandId = command.getId();
		String handlerId = H_ID + commandId;
		Object handler = context.get(HANDLER_LOOKUP, lookupHandler(handlerId));
		if (handler == null) {
			return false;
		}
		addParmsToContext(command);
		return ((Boolean) ContextInjectionFactory.invoke(handler, METHOD_CAN_EXECUTE, context,
				Boolean.TRUE)).booleanValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.e4.core.commands.EHandlerService#deactivateHandler(java.lang.String,
	 * java.lang.Object)
	 */
	public void deactivateHandler(String commandId, Object handler) {
		context.remove(H_ID + commandId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.e4.core.commands.EHandlerService#executeHandler(org.eclipse.core.commands.
	 * ParameterizedCommand)
	 */
	public Object executeHandler(ParameterizedCommand command) {
		String commandId = command.getId();
		String handlerId = H_ID + commandId;
		Object handler = context.get(HANDLER_LOOKUP, lookupHandler(handlerId));
		if (handler == null) {
			return null;
		}
		addParmsToContext(command);
		Object rc = ContextInjectionFactory.invoke(handler, METHOD_CAN_EXECUTE, context,
				Boolean.TRUE);
		if (Boolean.FALSE.equals(rc)) {
			return null;
		}
		return ContextInjectionFactory.invoke(handler, METHOD_EXECUTE, context, null);
	}

	private Object[] lookupHandler(String handlerId) {
		return new Object[] { handlerId };
	}

	@Inject
	public void setContext(IEclipseContext c) {
		context = c;
	}

	public IEclipseContext getContext() {
		return context;
	}
}