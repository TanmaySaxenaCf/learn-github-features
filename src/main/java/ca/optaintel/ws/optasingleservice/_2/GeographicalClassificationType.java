
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeographicalClassificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeographicalClassificationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClassificationType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ClassificationTypeTypes" minOccurs="0"/>
 *         &lt;element name="ClassificationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClassificationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeographicalClassificationType", propOrder = {
    "classificationType",
    "classificationID",
    "classificationName"
})
public class GeographicalClassificationType {

    @XmlElement(name = "ClassificationType")
    @XmlSchemaType(name = "string")
    protected ClassificationTypeTypes classificationType;
    @XmlElement(name = "ClassificationID")
    protected String classificationID;
    @XmlElement(name = "ClassificationName")
    protected String classificationName;

    /**
     * Gets the value of the classificationType property.
     * 
     * @return
     *     possible object is
     *     {@link ClassificationTypeTypes }
     *     
     */
    public ClassificationTypeTypes getClassificationType() {
        return classificationType;
    }

    /**
     * Sets the value of the classificationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassificationTypeTypes }
     *     
     */
    public void setClassificationType(ClassificationTypeTypes value) {
        this.classificationType = value;
    }

    /**
     * Gets the value of the classificationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassificationID() {
        return classificationID;
    }

    /**
     * Sets the value of the classificationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassificationID(String value) {
        this.classificationID = value;
    }

    /**
     * Gets the value of the classificationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassificationName() {
        return classificationName;
    }

    /**
     * Sets the value of the classificationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassificationName(String value) {
        this.classificationName = value;
    }

}
