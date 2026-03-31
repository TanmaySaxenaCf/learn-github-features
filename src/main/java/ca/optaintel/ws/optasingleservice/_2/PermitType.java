
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PermitType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PermitType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PermitNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateIssued" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ExpiryDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="WorkDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PermitStatus" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PermitStatusType" minOccurs="0"/>
 *         &lt;element name="PermitType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PermitType", propOrder = {
    "permitNumber",
    "dateIssued",
    "expiryDate",
    "workDescription",
    "permitStatus",
    "permitType",
    "value"
})
public class PermitType {

    @XmlElement(name = "PermitNumber")
    protected String permitNumber;
    @XmlElement(name = "DateIssued")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateIssued;
    @XmlElement(name = "ExpiryDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar expiryDate;
    @XmlElement(name = "WorkDescription")
    protected String workDescription;
    @XmlElement(name = "PermitStatus")
    @XmlSchemaType(name = "string")
    protected PermitStatusType permitStatus;
    @XmlElement(name = "PermitType")
    protected String permitType;
    @XmlElement(name = "Value")
    protected Double value;

    /**
     * Gets the value of the permitNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermitNumber() {
        return permitNumber;
    }

    /**
     * Sets the value of the permitNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermitNumber(String value) {
        this.permitNumber = value;
    }

    /**
     * Gets the value of the dateIssued property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateIssued() {
        return dateIssued;
    }

    /**
     * Sets the value of the dateIssued property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateIssued(XMLGregorianCalendar value) {
        this.dateIssued = value;
    }

    /**
     * Gets the value of the expiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpiryDate(XMLGregorianCalendar value) {
        this.expiryDate = value;
    }

    /**
     * Gets the value of the workDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkDescription() {
        return workDescription;
    }

    /**
     * Sets the value of the workDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkDescription(String value) {
        this.workDescription = value;
    }

    /**
     * Gets the value of the permitStatus property.
     * 
     * @return
     *     possible object is
     *     {@link PermitStatusType }
     *     
     */
    public PermitStatusType getPermitStatus() {
        return permitStatus;
    }

    /**
     * Sets the value of the permitStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link PermitStatusType }
     *     
     */
    public void setPermitStatus(PermitStatusType value) {
        this.permitStatus = value;
    }

    /**
     * Gets the value of the permitType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermitType() {
        return permitType;
    }

    /**
     * Sets the value of the permitType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermitType(String value) {
        this.permitType = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setValue(Double value) {
        this.value = value;
    }

}
