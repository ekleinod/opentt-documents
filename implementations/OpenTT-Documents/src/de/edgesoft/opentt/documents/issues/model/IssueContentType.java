
package de.edgesoft.opentt.documents.issues.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IssueContentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IssueContentType">
 *   &lt;complexContent>
 *     &lt;extension base="{}LangType">
 *       &lt;sequence>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="query" type="{}ParasType" minOccurs="0"/>
 *         &lt;element name="longanswer" type="{}ParasType" minOccurs="0"/>
 *         &lt;element name="origin" type="{}ParasType" minOccurs="0"/>
 *         &lt;element name="qna" type="{}QNAType" minOccurs="0"/>
 *         &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IssueContentType", propOrder = {
    "title",
    "query",
    "longanswer",
    "origin",
    "qna",
    "tag"
})
public class IssueContentType
    extends LangType
{

    @XmlElement(required = true)
    protected String title;
    protected ParasType query;
    protected ParasType longanswer;
    protected ParasType origin;
    protected QNAType qna;
    protected List<String> tag;

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
     * Gets the value of the query property.
     * 
     * @return
     *     possible object is
     *     {@link ParasType }
     *     
     */
    public ParasType getQuery() {
        return query;
    }

    /**
     * Sets the value of the query property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParasType }
     *     
     */
    public void setQuery(ParasType value) {
        this.query = value;
    }

    /**
     * Gets the value of the longanswer property.
     * 
     * @return
     *     possible object is
     *     {@link ParasType }
     *     
     */
    public ParasType getLonganswer() {
        return longanswer;
    }

    /**
     * Sets the value of the longanswer property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParasType }
     *     
     */
    public void setLonganswer(ParasType value) {
        this.longanswer = value;
    }

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link ParasType }
     *     
     */
    public ParasType getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParasType }
     *     
     */
    public void setOrigin(ParasType value) {
        this.origin = value;
    }

    /**
     * Gets the value of the qna property.
     * 
     * @return
     *     possible object is
     *     {@link QNAType }
     *     
     */
    public QNAType getQna() {
        return qna;
    }

    /**
     * Sets the value of the qna property.
     * 
     * @param value
     *     allowed object is
     *     {@link QNAType }
     *     
     */
    public void setQna(QNAType value) {
        this.qna = value;
    }

    /**
     * Gets the value of the tag property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tag property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTag().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTag() {
        if (tag == null) {
            tag = new ArrayList<String>();
        }
        return this.tag;
    }

}