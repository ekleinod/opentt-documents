
package de.edgesoft.opentt.documents.issues.model;

import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for InfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="creation" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="lastchange" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="version" type="{}VersionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfoType", propOrder = {
    "creation",
    "lastchange",
    "version"
})
public class InfoType {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar creation;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar lastchange;
    @XmlElement(required = true)
    protected VersionType version;

    /**
     * Gets the value of the creation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getCreation() {
        return creation;
    }

    /**
     * Sets the value of the creation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreation(Calendar value) {
        this.creation = value;
    }

    /**
     * Gets the value of the lastchange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getLastchange() {
        return lastchange;
    }

    /**
     * Sets the value of the lastchange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastchange(Calendar value) {
        this.lastchange = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link VersionType }
     *     
     */
    public VersionType getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionType }
     *     
     */
    public void setVersion(VersionType value) {
        this.version = value;
    }

}
