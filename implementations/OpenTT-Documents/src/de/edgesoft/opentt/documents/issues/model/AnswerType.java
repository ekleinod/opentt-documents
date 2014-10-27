
package de.edgesoft.opentt.documents.issues.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AnswerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnswerType">
 *   &lt;complexContent>
 *     &lt;extension base="{}ParasType">
 *       &lt;attribute name="correct" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnswerType")
public class AnswerType
    extends ParasType
{

    @XmlAttribute(name = "correct")
    protected Boolean correct;

    /**
     * Gets the value of the correct property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCorrect() {
        return correct;
    }

    /**
     * Sets the value of the correct property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCorrect(Boolean value) {
        this.correct = value;
    }

}
