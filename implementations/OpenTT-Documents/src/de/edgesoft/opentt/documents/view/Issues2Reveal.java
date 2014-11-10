package de.edgesoft.opentt.documents.view;

import de.edgesoft.edgeutils.reveal.RevealMarkup;
import de.edgesoft.opentt.documents.DocumentsException;
import de.edgesoft.opentt.documents.issues.model.AnswerType;
import de.edgesoft.opentt.documents.issues.model.IssueContentType;
import de.edgesoft.opentt.documents.issues.model.IssueDocumentType;
import de.edgesoft.opentt.documents.issues.model.IssueType;
import de.edgesoft.opentt.documents.issues.model.TextWithLinksType;
import de.edgesoft.opentt.documents.issues.model.additional.TextWithLinksTypeHC;

/**
 * Converts issues to reveal slides.
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
public class Issues2Reveal {
	
	/**
	 * Converts issue document to slides.
	 * 
	 * @param theIssueDocumentType issue document
	 * @param theLanguage language to use
	 * @return slides
	 * 
	 * @throws DocumentsException if an error occurred during execution
	 * 
	 * @version 0.2
	 * @since 0.2
	 */
	public static String issues2Reveal(IssueDocumentType theIssueDocumentType, String theLanguage) throws DocumentsException {
		
		StringBuilder sbReturn = new StringBuilder();
		
		for (IssueType theIssueType : theIssueDocumentType.getIssue()) {
			
			// enclosing slide: issue
			sbReturn.append(RevealMarkup.SLIDE_START);
			
			// first slide: question
			sbReturn.append(RevealMarkup.SLIDE_START);
			for (IssueContentType theIssueContentType : theIssueType.getIssuecontent()) {
				if (theIssueContentType.getLang().equals(theLanguage)) {
					sbReturn.append(String.format(RevealMarkup.getHeadingToken(2), theIssueContentType.getTitle()));
					
					for (TextWithLinksType theText: theIssueContentType.getQuery().getPara()) {
						sbReturn.append(String.format(RevealMarkup.PARAGRAPH, "opentt-query", TextWithLinksTypeHC.content2String(theText.getContent())));
					}
					
					for (TextWithLinksType theText: theIssueContentType.getQna().getQuestion().getPara()) {
						sbReturn.append(String.format(RevealMarkup.PARAGRAPH, "opentt-question", 
								TextWithLinksTypeHC.content2String(theText.getContent())));
					}
					
					sbReturn.append(String.format(RevealMarkup.LIST_START, "opentt-answer"));
					for (AnswerType theAnswer: theIssueContentType.getQna().getAnswer()) {
						sbReturn.append(String.format(RevealMarkup.LIST_ITEM_START, ((theAnswer.isCorrect() != null) && theAnswer.isCorrect()) ? "fragment highlight-green" : ""));
						for (TextWithLinksType theText: theAnswer.getPara()) {
							sbReturn.append(String.format(RevealMarkup.PARAGRAPH, "", 
									TextWithLinksTypeHC.content2String(theText.getContent())));
						}
						sbReturn.append(RevealMarkup.LIST_ITEM_END);
					}
					sbReturn.append(RevealMarkup.LIST_END);
					
				}
			}
			sbReturn.append(RevealMarkup.SLIDE_END);
			
			// enclosing slide: issue
			sbReturn.append(RevealMarkup.SLIDE_END);
			
		}
		
		return sbReturn.toString();
	}

}

/* EOF */
