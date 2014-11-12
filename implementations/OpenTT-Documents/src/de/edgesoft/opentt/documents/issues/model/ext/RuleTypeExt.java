package de.edgesoft.opentt.documents.issues.model.ext;

import java.util.List;

import de.edgesoft.opentt.documents.issues.model.RuleContentType;
import de.edgesoft.opentt.documents.issues.model.RuleType;
import de.edgesoft.opentt.documents.issues.model.RulesType;


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
	
	/** Parent rule. */
	private RuleTypeExt rtParent = null;
	
	/** 
	 * Sets parent rule.
	 *
	 * @param theParent new parent
	 * 
	 * @version 0.2
	 * @since 0.2
	 */
	public void setParent(RuleTypeExt theParent) {
		rtParent = theParent;
	}
	
	/** 
	 * Sets parents for all rules.
	 *
	 * @version 0.2
	 * @since 0.2
	 */
	public void setParents() {
		for (RuleType theRuleType : getRule()) {
			((RuleTypeExt) theRuleType).setParent(this);
			((RuleTypeExt) theRuleType).setParents();
		}
	}
	
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
	 * Returns the combined text id for a rule, i.e. concatenated from parent text ids.
	 * 
	 * I can't figure out, how to set the parent at add time of the rules,
	 * because there is no add method but the getList.add approach.
	 * 
	 * Thus, I have to use the rules here to first set all parents
	 * and then use them. I choose the parent approach in case there
	 * is another possibility to set the parent, so the code has not
	 * to be changed that much.
	 * 
	 * @param theLanguage language to use
	 * @param theRules all rules
	 * @return combined text id
	 * 
	 * @version 0.2
	 * @since 0.2
	 */
	public String getCombinedTextID(String theLanguage, List<RulesType> theRules) {
		for (RulesType theRulesType : theRules) {
			for (RuleType theRuleType : theRulesType.getRule()) {
				((RuleTypeExt) theRuleType).setParents();
			}
		}
		return getCombinedTextID(theLanguage);
	}
	
	/**
	 * Returns the combined text id for a rule, i.e. concatenated from parent text ids.
	 * 
	 * Parent has to be set correctly before using this method.
	 * 
	 * @param theLanguage language to use
	 * @return combined text id
	 * 
	 * @version 0.2
	 * @since 0.2
	 */
	private String getCombinedTextID(String theLanguage) {
		
		StringBuilder sbReturn = new StringBuilder();
		
		if (rtParent != null) {
			sbReturn.append(rtParent.getCombinedTextID(theLanguage));
		}
		
		RuleContentType theContentType = getContentType(theLanguage);
		
		if ((theContentType != null) && (theContentType.getTextid() != null) && (!theContentType.getTextid().isEmpty())) {
			if (sbReturn.length() > 0) {
				sbReturn.append(".");
			}
			sbReturn.append(theContentType.getTextid());
		}
		
		return sbReturn.toString();
		
	}
	
	/**
	 * Returns the combined title for a rule, i.e. the title of the rule or the first title of a parent.
	 * 
	 * See {@link #getCombinedTextID(String, List)} for explanation.
	 * 
	 * @param theLanguage language to use
	 * @param theRules all rules
	 * @return combined title
	 * 
	 * @version 0.2
	 * @since 0.2
	 */
	public String getCombinedTitle(String theLanguage, List<RulesType> theRules) {
		for (RulesType theRulesType : theRules) {
			for (RuleType theRuleType : theRulesType.getRule()) {
				((RuleTypeExt) theRuleType).setParents();
			}
		}
		return getCombinedTitle(theLanguage);
	}
	
	/**
	 * Returns the combined title for a rule, i.e. the title of the rule or the first title of a parent.
	 * 
	 * Parent has to be set correctly before using this method.
	 * 
	 * @param theLanguage language to use
	 * @return combined title
	 * 
	 * @version 0.2
	 * @since 0.2
	 */
	private String getCombinedTitle(String theLanguage) {

		RuleContentType theContentType = getContentType(theLanguage);
		
		if ((theContentType != null) && (theContentType.getTitle() != null) && (!theContentType.getTitle().isEmpty())) {
			return theContentType.getTitle();
		}
		
		if (rtParent == null) {
			return null;
		}
		
		return rtParent.getCombinedTitle(theLanguage);
		
	}
	
}

/* EOF */
