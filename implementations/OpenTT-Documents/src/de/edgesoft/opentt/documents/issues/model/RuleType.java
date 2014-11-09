
package de.edgesoft.opentt.documents.issues.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RuleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RuleType">
 *   &lt;complexContent>
 *     &lt;extension base="{}IDType">
 *       &lt;sequence>
 *         &lt;element name="rulecontent" type="{}RuleContentType" maxOccurs="unbounded"/>
 *         &lt;element name="rule" type="{}RuleType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RuleType", propOrder = {
    "rulecontent",
    "rule"
})
public class RuleType
    extends IDType
{

    @XmlElement(required = true)
    protected List<RuleContentType> rulecontent;
    protected List<RuleType> rule;

    /**
     * Gets the value of the rulecontent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rulecontent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRulecontent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RuleContentType }
     * 
     * 
     */
    public List<RuleContentType> getRulecontent() {
        if (rulecontent == null) {
            rulecontent = new ArrayList<RuleContentType>();
        }
        return this.rulecontent;
    }

    /**
     * Gets the value of the rule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RuleType }
     * 
     * 
     */
    public List<RuleType> getRule() {
        if (rule == null) {
            rule = new ArrayList<RuleType>();
        }
        return this.rule;
    }

}