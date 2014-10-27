
package de.edgesoft.opentt.documents.issues.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParasType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParasType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="para" type="{}TextWithLinksType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParasType", propOrder = {
    "para"
})
@XmlSeeAlso({
    AnswerType.class
})
public class ParasType {

    protected List<TextWithLinksType> para;

    /**
     * Gets the value of the para property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the para property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPara().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextWithLinksType }
     * 
     * 
     */
    public List<TextWithLinksType> getPara() {
        if (para == null) {
            para = new ArrayList<TextWithLinksType>();
        }
        return this.para;
    }

}
