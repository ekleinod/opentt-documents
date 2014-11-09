package de.edgesoft.opentt.documents;

/**
 * Special exception (good coding style, I presume).
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
public class DocumentsException extends Exception {
	
	/** Default serial id. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor with message.
	 * 
	 * @param theErrorMessage error message
	 * 
	 * @version 0.2
	 * @since 0.2
	 */
	public DocumentsException(String theErrorMessage) {
		super(theErrorMessage);
	}

}

/* EOF */
