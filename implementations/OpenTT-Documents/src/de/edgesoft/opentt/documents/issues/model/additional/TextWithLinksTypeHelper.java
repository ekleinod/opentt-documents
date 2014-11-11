package de.edgesoft.opentt.documents.issues.model.additional;

import java.io.Serializable;
import java.util.List;

import de.edgesoft.opentt.documents.DocumentsException;
import de.edgesoft.opentt.documents.issues.model.TextWithLinksType;

/**
 * Additional methods for {@link TextWithLinksType}.
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
public class TextWithLinksTypeHelper {
	
	/**
	 * Converts content to string.
	 * 
	 * @param theContent content
	 * @return string
	 * 
	 * @throws DocumentsException if an error occurred during execution
	 * 
	 * @version 0.2
	 * @since 0.2
	 */
	public static String content2String(List<Serializable> theContent) throws DocumentsException {
		
		StringBuilder sbReturn = new StringBuilder();
		
		for (Serializable theSerializable : theContent) {
			sbReturn.append(theSerializable.toString());
			sbReturn.append(" ");
		}
		
		return sbReturn.toString();
	}

}

/* EOF */
