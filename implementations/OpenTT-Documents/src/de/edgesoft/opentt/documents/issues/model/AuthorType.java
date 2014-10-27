
package de.edgesoft.opentt.documents.issues.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthorType">
 *   &lt;complexContent>
 *     &lt;extension base="{}IDType">
 *       &lt;sequence>
 *         &lt;element name="authorcontent" type="{}AuthorContentType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthorType", propOrder = {
    "authorcontent"
})
public class AuthorType
    extends IDType
{

    @XmlElement(required = true)
    protected List<AuthorContentType> authorcontent;

    /**
     * Gets the value of the authorcontent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authorcontent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthorcontent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuthorContentType }
     * 
     * 
     */
    public List<AuthorContentType> getAuthorcontent() {
        if (authorcontent == null) {
            authorcontent = new ArrayList<AuthorContentType>();
        }
        return this.authorcontent;
    }

}
