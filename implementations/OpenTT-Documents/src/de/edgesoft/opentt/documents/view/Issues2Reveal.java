package de.edgesoft.opentt.documents.view;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import de.edgesoft.edgeutils.collections.CollectionHelper;
import de.edgesoft.edgeutils.reveal.RevealMarkup;
import de.edgesoft.opentt.documents.DocumentsException;
import de.edgesoft.opentt.documents.issues.model.AnswerType;
import de.edgesoft.opentt.documents.issues.model.DocumentContentType;
import de.edgesoft.opentt.documents.issues.model.DocumentType;
import de.edgesoft.opentt.documents.issues.model.IssueContentType;
import de.edgesoft.opentt.documents.issues.model.IssueDocumentType;
import de.edgesoft.opentt.documents.issues.model.IssueType;
import de.edgesoft.opentt.documents.issues.model.RefType;
import de.edgesoft.opentt.documents.issues.model.RuleContentType;
import de.edgesoft.opentt.documents.issues.model.TextWithLinksType;
import de.edgesoft.opentt.documents.issues.model.ext.RuleTypeExt;
import de.edgesoft.opentt.documents.issues.model.ext.TextWithLinksTypeHelper;

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
					
					if (theIssueContentType.getQuery() != null) {
						for (TextWithLinksType theText: theIssueContentType.getQuery().getPara()) {
							sbReturn.append(String.format(RevealMarkup.PARAGRAPH, "opentt-query", TextWithLinksTypeHelper.content2String(theText.getContent())));
						}
					}
					
					if (theIssueContentType.getQna() != null) {
						
						if (theIssueContentType.getQna().getQuestion() != null) {
							for (TextWithLinksType theText: theIssueContentType.getQna().getQuestion().getPara()) {
								sbReturn.append(String.format(RevealMarkup.PARAGRAPH, "opentt-question", 
										TextWithLinksTypeHelper.content2String(theText.getContent())));
							}
						}
						
						if (!theIssueContentType.getQna().getAnswer().isEmpty()) {
							sbReturn.append(String.format(RevealMarkup.LIST_START, "opentt-answer"));
							for (AnswerType theAnswer: theIssueContentType.getQna().getAnswer()) {
								sbReturn.append(String.format(RevealMarkup.LIST_ITEM_START, ((theAnswer.isCorrect() != null) && theAnswer.isCorrect()) ? "fragment highlight-green" : ""));
								for (TextWithLinksType theText: theAnswer.getPara()) {
									sbReturn.append(String.format(RevealMarkup.PARAGRAPH, "", 
											TextWithLinksTypeHelper.content2String(theText.getContent())));
								}
								sbReturn.append(RevealMarkup.LIST_ITEM_END);
							}
							sbReturn.append(RevealMarkup.LIST_END);
						}
					}
					
				}
			}
			sbReturn.append(RevealMarkup.SLIDE_END);
			
			// second slide: long answer
			sbReturn.append(RevealMarkup.SLIDE_START);
			for (IssueContentType theIssueContentType : theIssueType.getIssuecontent()) {
				if (theIssueContentType.getLang().equals(theLanguage)) {
					sbReturn.append(String.format(RevealMarkup.getHeadingToken(2), theIssueContentType.getTitle()));
					
					if (theIssueContentType.getQuery() != null) {
						for (TextWithLinksType theText: theIssueContentType.getQuery().getPara()) {
							sbReturn.append(String.format(RevealMarkup.PARAGRAPH, "opentt-query", TextWithLinksTypeHelper.content2String(theText.getContent())));
						}
					}
					
					if (theIssueContentType.getLonganswer() != null) {
						sbReturn.append(RevealMarkup.BLOCKQUOTE_START);
						for (TextWithLinksType theText: theIssueContentType.getLonganswer().getPara()) {
							sbReturn.append(String.format(RevealMarkup.PARAGRAPH, "", TextWithLinksTypeHelper.content2String(theText.getContent())));
						}
						sbReturn.append(RevealMarkup.BLOCKQUOTE_END);
					}
					
				}
			}
			
			if (!theIssueType.getDocumentref().isEmpty()) {
				List<String> lstRefs = new ArrayList<>();
				for (RefType theRefType : theIssueType.getDocumentref()) {
					DocumentType theDoc = (DocumentType) theRefType.getIdref();
					for (DocumentContentType theContentType : theDoc.getDocumentcontent()) {
						if (theContentType.getLang().equals(theLanguage)) {
							lstRefs.add(theContentType.getTitle());
						}
					}
				}
				sbReturn.append(String.format(RevealMarkup.PARAGRAPH, "opentt-see",
						MessageFormat.format("Siehe: {0}.", CollectionHelper.toCSVString(lstRefs, ","))));
			}
			
			if (!theIssueType.getRulesref().isEmpty()) {
				List<String> lstRefs = new ArrayList<>();
				for (RefType theRefType : theIssueType.getRulesref()) {
					lstRefs.add(((RuleTypeExt) theRefType.getIdref()).getLongTextID(theLanguage));
				}
				sbReturn.append(String.format(RevealMarkup.PARAGRAPH, "opentt-see",
						MessageFormat.format("Regel{0,choice,1#|1<n}: {1}.", lstRefs.size(), CollectionHelper.toCSVString(lstRefs, ","))));
			}
			
			sbReturn.append(RevealMarkup.SLIDE_END);
			
			// third slide: rules
			if (!theIssueType.getRulesref().isEmpty()) {
				sbReturn.append(RevealMarkup.SLIDE_START);
				
				for (RefType theRefType : theIssueType.getRulesref()) {
					RuleContentType theRuleContentType = ((RuleTypeExt) theRefType.getIdref()).getContentType(theLanguage);
					
					sbReturn.append(String.format(RevealMarkup.getHeadingToken(3), 
							MessageFormat.format("Regel {0}{1}", 
									((RuleTypeExt) theRefType.getIdref()).getLongTextID(theLanguage),
									(theRuleContentType.getTitle() == null) ? "" : MessageFormat.format(": {0}", theRuleContentType.getTitle()))));
				
					for (TextWithLinksType theText: theRuleContentType.getPara()) {
						sbReturn.append(String.format(RevealMarkup.PARAGRAPH, "", 
								TextWithLinksTypeHelper.content2String(theText.getContent())));
					}
					
				}
				
				sbReturn.append(RevealMarkup.SLIDE_END);
			}
			
			// enclosing slide: issue
			sbReturn.append(RevealMarkup.SLIDE_END);
			
		}
		
		return sbReturn.toString();
	}

}

/* EOF */
