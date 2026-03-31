
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RequestContactInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestContactInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ContactType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ContactType"/>
 *         &lt;element name="PhoneNumbers" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PhoneNumbersType"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreferredContactMethod" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PreferredContactMethodType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestContactInformationType", propOrder = {
    "name",
    "contactType",
    "phoneNumbers",
    "email",
    "preferredContactMethod"
})
public class RequestContactInformationType {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "ContactType", required = true)
    @XmlSchemaType(name = "string")
    protected ContactType contactType;
    @XmlElement(name = "PhoneNumbers", required = true)
    protected PhoneNumbersType phoneNumbers;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "PreferredContactMethod", required = true)
    @XmlSchemaType(name = "string")
    protected PreferredContactMethodType preferredContactMethod;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the contactType property.
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getContactType() {
        return contactType;
    }

    /**
     * Sets the value of the contactType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setContactType(ContactType value) {
        this.contactType = value;
    }

    /**
     * Gets the value of the phoneNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link PhoneNumbersType }
     *     
     */
    public PhoneNumbersType getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * Sets the value of the phoneNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhoneNumbersType }
     *     
     */
    public void setPhoneNumbers(PhoneNumbersType value) {
        this.phoneNumbers = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the preferredContactMethod property.
     * 
     * @return
     *     possible object is
     *     {@link PreferredContactMethodType }
     *     
     */
    public PreferredContactMethodType getPreferredContactMethod() {
        return preferredContactMethod;
    }

    /**
     * Sets the value of the preferredContactMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreferredContactMethodType }
     *     
     */
    public void setPreferredContactMethod(PreferredContactMethodType value) {
        this.preferredContactMethod = value;
    }

}
