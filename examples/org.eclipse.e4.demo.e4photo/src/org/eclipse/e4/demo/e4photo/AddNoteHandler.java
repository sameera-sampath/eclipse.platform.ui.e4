/*******************************************************************************
 * Copyright (c) 2009, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.e4.demo.e4photo;

import javax.inject.Named;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.e4.ui.model.application.MApplicationFactory;
import org.eclipse.e4.ui.model.application.MEditor;
import org.eclipse.e4.ui.model.application.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.workbench.modeling.EPartService;
import org.eclipse.e4.workbench.ui.IWorkbench;

public class AddNoteHandler {
	
	// TBD this is an illustration of the problem with duplicate IDs. Editors have the same ID and that
	// causes rendering engine to "reuse" the same part.
	static int editors = 0;
	
	public void execute(IWorkbench workbench, @Named(IServiceConstants.SELECTION) IResource selection, EPartService partService) {
		System.out.println("AddNoteHandler called " + selection.toString());
		// add an editor next to the Exif tab
		MPart exifPart = partService.findPart("e4.photo.demo.exif");
		MEditor editor = MApplicationFactory.eINSTANCE.createEditor();
		editor.setLabel("Note");
		editor.setURI("platform:/plugin/org.eclipse.e4.demo.e4photo/org.eclipse.e4.demo.e4photo.NoteEditor");
		editor.setId("org.eclipse.e4.demo.e4photo.noteEditor" + editors);
		editors++;
		
		IPath path = selection.getLocation();
		
		if ("txt".equalsIgnoreCase(path.getFileExtension()))
				return; // this is already a note
		
		// TBD add code to activate existing editor if it is already there
		
		path = path.removeFileExtension();
		path = path.addFileExtension("txt");
		editor.setInputURI(path.toString());
		
		exifPart.getParent().getChildren().add(editor);
	}
}
