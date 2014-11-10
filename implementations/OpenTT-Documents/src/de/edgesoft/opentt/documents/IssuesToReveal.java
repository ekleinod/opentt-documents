package de.edgesoft.opentt.documents;

import java.text.MessageFormat;

import de.edgesoft.edgeutils.Messages;
import de.edgesoft.edgeutils.commandline.AbstractMainClass;
import de.edgesoft.edgeutils.commandline.CommandOption;
import de.edgesoft.edgeutils.files.FileAccess;
import de.edgesoft.edgeutils.files.JAXBFiles;
import de.edgesoft.opentt.documents.issues.model.IssueDocumentType;
import de.edgesoft.opentt.documents.view.Issues2Reveal;

/**
 * Reads an issue documents and stores it in a reveal file.
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
public class IssuesToReveal extends AbstractMainClass {
	
	/** Argument input file. */
	private final static CommandOption OPT_INFILE = new CommandOption("i", "input", true, "input issues xml file", true);
	
	/** Argument reveal template. */
	private final static CommandOption OPT_TEMPLATE = new CommandOption("t", "template", true, "reveal template", true);
	
	/** Argument export language. */
	private final static CommandOption OPT_LANG = new CommandOption("l", "language", true, "export language", true);
	
	/** Argument output file. */
	private final static CommandOption OPT_OUTFILE = new CommandOption("o", "output", true, "output file", true);
	
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
		addCommandOption(OPT_TEMPLATE);
		addCommandOption(OPT_LANG);
		addCommandOption(OPT_OUTFILE);
		
		init(args, IssuesToReveal.class);
		
		try {
			String sInFile = getOptionValue(OPT_INFILE);
			String sTemplate = getOptionValue(OPT_TEMPLATE);
			String sLanguage = getOptionValue(OPT_LANG);
			String sOutPath = getOptionValue(OPT_OUTFILE);
			
			Messages.printMessage(MessageFormat.format("Processing file ''{0}''", sInFile));
			Messages.printMessage(MessageFormat.format("Reveal template ''{0}''", sTemplate));
			Messages.printMessage(MessageFormat.format("Export language ''{0}''", sLanguage));
			Messages.printMessage(MessageFormat.format("Output path ''{0}''", sOutPath));
			
			processIssues(sInFile, sTemplate, sLanguage, sOutPath);
			
		} catch (Exception e) {
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * Converts an issue xml file to a reveal file.
	 * 
	 * @param theInFile input file
	 * @param theTemplate reveal template
	 * @param theLanguage language to use
	 * @param theOutFile output file
	 * 
	 * @throws DocumentsException if an error occurred during execution
	 * 
	 * @version 0.2
	 * @since 0.2
	 */
	public static void processIssues(String theInFile, String theTemplate, String theLanguage, String theOutFile) throws DocumentsException {
		
		try {
			// read issues xml
			IssueDocumentType theIssueDocumentType = JAXBFiles.unmarshalInclude(theInFile, IssueDocumentType.class);

			// read template
			Messages.printMessage(MessageFormat.format("Reading template file ''{0}''", theTemplate));
			String sFileContent = FileAccess.readFile(theTemplate).toString();

			// fill template
			sFileContent = sFileContent.replace("**issues**", Issues2Reveal.issues2Reveal(theIssueDocumentType, theLanguage));
			
			// output reveal file
			Messages.printMessage(MessageFormat.format("Writing reveal file ''{0}''", theOutFile));
			FileAccess.writeFile(theOutFile, sFileContent);
					
		} catch (Exception e) {
			Messages.printError(e);
			throw new DocumentsException(e.getMessage());
		}
		
	}

}

/* EOF */
