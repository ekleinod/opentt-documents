package de.edgesoft.opentt.documents;

import java.text.MessageFormat;

import de.edgesoft.edgeutils.Messages;
import de.edgesoft.edgeutils.commandline.AbstractMainClass;
import de.edgesoft.edgeutils.commandline.CommandOption;
import de.edgesoft.edgeutils.files.JAXBFiles;
import de.edgesoft.opentt.documents.issues.model.IssueDocumentType;
import de.edgesoft.opentt.documents.issues.model.ObjectFactory;

/**
 * Reads an issue documents and stores it in an xml file.
 * 
 * This class is for testing rather than concrete use.
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
 * @version 0.2
 * @since 0.2
 */
public class IssuesToXML extends AbstractMainClass {
	
	/** Argument input file. */
	private final static CommandOption OPT_INFILE = new CommandOption("i", "input", true, "input issues xml file", true);
	
	/** Argument xml schema. */
	private final static CommandOption OPT_SCHEMA = new CommandOption("x", "xmlschema", true, "xml schema", false);
	
	/** Argument output path. */
	private final static CommandOption OPT_OUTPATH = new CommandOption("o", "output", true, "output file", true);
	
	/**
	 * Main method, called from command line.
	 * 
	 * @param args command line arguments
	 * 
	 * @version 0.2
	 * @since 0.2
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
	 * @version 0.2
	 * @since 0.2
	 */
	public static boolean executeOperation(String[] args) {
		
		addCommandOption(OPT_INFILE);
		addCommandOption(OPT_SCHEMA);
		addCommandOption(OPT_OUTPATH);
		
		init(args, IssuesToXML.class);
		
		try {
			String sInFile = getOptionValue(OPT_INFILE);
			String sSchema = getOptionValue(OPT_SCHEMA);
			String sOutPath = getOptionValue(OPT_OUTPATH);
			
			Messages.printMessage(MessageFormat.format("Processing file ''{0}''", sInFile));
			Messages.printMessage(MessageFormat.format("XML schema ''{0}''", sSchema));
			Messages.printMessage(MessageFormat.format("Output path ''{0}''", sOutPath));
			
			processIssues(sInFile, sSchema, sOutPath);
			
		} catch (Exception e) {
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * Converts an issue xml file to an xml file.
	 * 
	 * @param theInFile input file
	 * @param theXMLSchema xml schema
	 * @param theOutFile output file
	 * 
	 * @throws DocumentsException if an error occurred during execution
	 * 
	 * @version 0.2
	 * @since 0.2
	 */
	public static void processIssues(String theInFile, String theXMLSchema, String theOutFile) throws DocumentsException {
		
		try {
			// read issues xml
			IssueDocumentType theIssueDocumentType = JAXBFiles.unmarshalInclude(theInFile, IssueDocumentType.class);
			
			// output issue xml
			JAXBFiles.marshal(new ObjectFactory().createIssuedocument(theIssueDocumentType), theOutFile, theXMLSchema);
					
		} catch (Exception e) {
			Messages.printError(e);
			throw new DocumentsException(e.getLocalizedMessage());
		}
		
	}

}

/* EOF */
