
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for RequestConsentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestConsentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConsentReceived" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ConsentType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ConsentType" minOccurs="0"/>
 *         &lt;element name="ConsentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestConsentType", propOrder = {
    "consentReceived",
    "consentType",
    "consentDate"
})
public class RequestConsentType {

    @XmlElement(name = "ConsentReceived")
    protected Boolean consentReceived;
    @XmlElement(name = "ConsentType")
    @XmlSchemaType(name = "string")
    protected ConsentType consentType;
    @XmlElement(name = "ConsentDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar consentDate;

    /**
     * Gets the value of the consentReceived property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConsentReceived() {
        return consentReceived;
    }

    /**
     * Sets the value of the consentReceived property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConsentReceived(Boolean value) {
        this.consentReceived = value;
    }

    /**
     * Gets the value of the consentType property.
     * 
     * @return
     *     possible object is
     *     {@link ConsentType }
     *     
     */
    public ConsentType getConsentType() {
        return consentType;
    }

    /**
     * Sets the value of the consentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsentType }
     *     
     */
    public void setConsentType(ConsentType value) {
        this.consentType = value;
    }

    /**
     * Gets the value of the consentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getConsentDate() {
        return consentDate;
    }

    /**
     * Sets the value of the consentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setConsentDate(XMLGregorianCalendar value) {
        this.consentDate = value;
    }

}
