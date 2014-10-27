
package de.edgesoft.opentt.documents.issues.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentType">
 *   &lt;complexContent>
 *     &lt;extension base="{}IDType">
 *       &lt;sequence>
 *         &lt;element name="documentcontent" type="{}DocumentContentType" maxOccurs="unbounded"/>
 *         &lt;element name="authorref" type="{}RefType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentType", propOrder = {
    "documentcontent",
    "authorref"
})
public class DocumentType
    extends IDType
{

    @XmlElement(required = true)
    protected List<DocumentContentType> documentcontent;
    protected List<RefType> authorref;

    /**
     * Gets the value of the documentcontent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentcontent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentcontent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentContentType }
     * 
     * 
     */
    public List<DocumentContentType> getDocumentcontent() {
        if (documentcontent == null) {
            documentcontent = new ArrayList<DocumentContentType>();
        }
        return this.documentcontent;
    }

    /**
     * Gets the value of the authorref property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authorref property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthorref().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefType }
     * 
     * 
     */
    public List<RefType> getAuthorref() {
        if (authorref == null) {
            authorref = new ArrayList<RefType>();
        }
        return this.authorref;
    }

}
