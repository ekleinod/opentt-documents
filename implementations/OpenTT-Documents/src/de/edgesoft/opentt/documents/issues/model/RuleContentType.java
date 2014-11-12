
package de.edgesoft.opentt.documents.issues.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import de.edgesoft.opentt.documents.issues.model.ext.TextWithLinksTypeExt;


/**
 * <p>Java class for RuleContentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RuleContentType">
 *   &lt;complexContent>
 *     &lt;extension base="{}LangType">
 *       &lt;sequence>
 *         &lt;element name="textid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subtitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="para" type="{}TextWithLinksType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RuleContentType", propOrder = {
    "textid",
    "title",
    "subtitle",
    "para"
})
public class RuleContentType
    extends LangType
{

    @XmlElement(required = true)
    protected String textid;
    protected String title;
    protected String subtitle;
    @XmlElement(type = TextWithLinksTypeExt.class)
    protected List<TextWithLinksType> para;

    /**
     * Gets the value of the textid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextid() {
        return textid;
    }

    /**
     * Sets the value of the textid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextid(String value) {
        this.textid = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the subtitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * Sets the value of the subtitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubtitle(String value) {
        this.subtitle = value;
    }

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
