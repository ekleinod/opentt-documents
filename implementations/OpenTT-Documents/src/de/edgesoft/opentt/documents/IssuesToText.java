package de.edgesoft.opentt.documents;

import java.io.File;
import java.text.MessageFormat;

import de.edgesoft.edgeutils.Messages;
import de.edgesoft.edgeutils.commandline.AbstractMainClass;
import de.edgesoft.edgeutils.commandline.CommandOption;
import de.edgesoft.edgeutils.files.JAXBFiles;
import de.edgesoft.opentt.documents.issues.model.IssueDocumentType;
import de.edgesoft.opentt.documents.issues.model.ObjectFactory;
import de.edgesoft.opentt.documents.view.OutputTypes;

/**
 * Conversion of issues documents to several text formats.
 * 
 * ## Legal stuff
 * 
 * Copyright 2014 Ekkart Kleinod <ekleinod@edgesoft.de>
 * 
 * This file is part of OpenTT-Documents.
 * 
 * OpenTT-Documents is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * OpenTT-Documents is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with OpenTT-Documents.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Ekkart Kleinod
 * @version 0.1
 * @since 0.1
 */
public class IssuesToText extends AbstractMainClass {
	
	/** Argument input file. */
	private final static CommandOption OPT_INFILE = new CommandOption("i", "input", true, "input issues xml file", true);
	
	/** Argument output type. */
	private final static CommandOption OPT_TYPE = new CommandOption("t", "type", true, "output type (reveal; default: reveal)", false);
	
	/** Argument output path. */
	private final static CommandOption OPT_OUTPATH = new CommandOption("o", "output", true, "output path", true);
	
	/**
	 * Main method, called from command line.
	 * 
	 * @param args command line arguments
	 * 
	 * @version 0.1
	 * @since 0.1
	 */
	public static void main(String[] args) {
		
		Messages.printMessage("start.");
		
		if (!executeOperation(args)) {
			Messages.printError("Fehler.");
			System.exit(1);
		}

		Messages.printMessage("Fertig.");
		
	}
	
	/**
	 * Executes the operation.
	 * 
	 * This method enables other classes to call this method with command line parameters.
	 * 
	 * @param args command line arguments
	 * 
	 * @version 0.1
	 * @since 0.1
	 */
	public static boolean executeOperation(String[] args) {
		
		addCommandOption(OPT_INFILE);
		addCommandOption(OPT_TYPE);
		addCommandOption(OPT_OUTPATH);
		
		init(args, IssuesToText.class);
		
		try {
			String sInFile = getOptionValue(OPT_INFILE);
			OutputTypes tpeInType = (getOptionValue(OPT_TYPE) == null) ? OutputTypes.REVEAL : OutputTypes.fromString(getOptionValue(OPT_TYPE));
			String sOutPath = getOptionValue(OPT_OUTPATH);
			
			Messages.printMessage(MessageFormat.format("Processing file ''{0}''", sInFile));
			Messages.printMessage(MessageFormat.format("Output type ''{0}''", tpeInType.toString()));
			Messages.printMessage(MessageFormat.format("Output path ''{0}''", sOutPath));
			
			processIssues(sInFile, tpeInType, sOutPath);
			
		} catch (Exception e) {
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * Converts an issue xml file to the requested output file.
	 * 
	 * @param theInFile input file
	 * @param theOutputType output type
	 * @param theOutPath output path
	 * 
	 * @throws DocumentsException if an error occurred during execution
	 * 
	 * @version 0.1
	 * @since 0.1
	 */
	public static void processIssues(String theInFile, OutputTypes theOutputType, String theOutPath) throws DocumentsException {
		
		try {
			// read issues xml
			IssueDocumentType theIssueDocumentType = JAXBFiles.unmarshalInclude(theInFile, IssueDocumentType.class);
			
			// output issue xml (for test only)
			JAXBFiles.marshal(new ObjectFactory().createIssuedocument(theIssueDocumentType), new File(theOutPath, new File(theInFile).getName()).getAbsolutePath(), null);
					
		} catch (Exception e) {
			Messages.printError(e);
			throw new DocumentsException(e.getLocalizedMessage());
		}
		
	}

}

/* EOF */
