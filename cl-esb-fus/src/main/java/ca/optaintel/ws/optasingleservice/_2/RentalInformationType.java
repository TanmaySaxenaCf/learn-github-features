
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RentalInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RentalInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentalUnitType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RentalUnitType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RentalInformationType", propOrder = {
    "rentalUnitType"
})
public class RentalInformationType {

    @XmlElement(name = "RentalUnitType")
    @XmlSchemaType(name = "string")
    protected RentalUnitType rentalUnitType;

    /**
     * Gets the value of the rentalUnitType property.
     * 
     * @return
     *     possible object is
     *     {@link RentalUnitType }
     *     
     */
    public RentalUnitType getRentalUnitType() {
        return rentalUnitType;
    }

    /**
     * Sets the value of the rentalUnitType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RentalUnitType }
     *     
     */
    public void setRentalUnitType(RentalUnitType value) {
        this.rentalUnitType = value;
    }

}
