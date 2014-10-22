package de.edgesoft.opentt.documents.view;


/**
 * All available output types.
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
public enum OutputTypes {
	
	REVEAL;

	/**
	 * Returns string representation (lowercase).
	 * 
	 * @return string representation
	 * 
	 * @version 0.1
	 * @since 0.1
	 */
	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}

	/**
	 * Returns object depending on string representation.
	 * 
	 * @param theString string representation
	 * @return object
	 *  @retval null if no object could be found
	 * 
	 * @version 0.1
	 * @since 0.1
	 */
	public static OutputTypes fromString(String theString) {
		for (OutputTypes theObject : OutputTypes.values()) {
			if (theObject.toString().equalsIgnoreCase(theString)) {
				return theObject;
			}
		}
		return null;
	}

}

/* EOF */
