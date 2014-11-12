package de.edgesoft.opentt.documents.issues.model.ext;

import de.edgesoft.opentt.documents.issues.model.RuleContentType;
import de.edgesoft.opentt.documents.issues.model.RuleType;


/**
 * Extensions of {@link RuleType}.
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
public class RuleTypeExt extends RuleType {
	
	/**
	 * Returns the content type for a language.
	 * 
	 * @param theLanguage language to use
	 * @return content type
	 * 
	 * @version 0.2
	 * @since 0.2
	 */
	public RuleContentType getContentType(String theLanguage) {
		
		for (RuleContentType theContentType : getRulecontent()) {
			if (theContentType.getLang().equals(theLanguage)) {
				return theContentType;
			}
		}
		
		return null;
	}
	
	/**
	 * Returns the long text id for a rule.
	 * 
	 * @param theIssueDocumentType issue document
	 * @return long text id
	 * 
	 * @version 0.2
	 * @since 0.2
	 */
	public String getLongTextID(String theLanguage) {
		
		if (getContentType(theLanguage) != null) {
			return getContentType(theLanguage).getTextid();
		}
		
		return null;
	}
	
}

/* EOF */
