
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CurrentInsuranceDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CurrentInsuranceDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CurrentInsuranceCoverage" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="InsuranceRenewalDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrentInsuranceDetailsType", propOrder = {
    "currentInsuranceCoverage",
    "insuranceRenewalDate"
})
public class CurrentInsuranceDetailsType {

    @XmlElement(name = "CurrentInsuranceCoverage")
    protected Boolean currentInsuranceCoverage;
    @XmlElement(name = "InsuranceRenewalDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar insuranceRenewalDate;

    /**
     * Gets the value of the currentInsuranceCoverage property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCurrentInsuranceCoverage() {
        return currentInsuranceCoverage;
    }

    /**
     * Sets the value of the currentInsuranceCoverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCurrentInsuranceCoverage(Boolean value) {
        this.currentInsuranceCoverage = value;
    }

    /**
     * Gets the value of the insuranceRenewalDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInsuranceRenewalDate() {
        return insuranceRenewalDate;
    }

    /**
     * Sets the value of the insuranceRenewalDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInsuranceRenewalDate(XMLGregorianCalendar value) {
        this.insuranceRenewalDate = value;
    }

}
