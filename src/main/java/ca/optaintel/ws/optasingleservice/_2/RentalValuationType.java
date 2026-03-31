
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RentalValuationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RentalValuationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentalValue" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="RentalRangeValue" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RentalRangeValueType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RentalValuationType", propOrder = {
    "rentalValue",
    "rentalRangeValue"
})
public class RentalValuationType {

    @XmlElement(name = "RentalValue")
    protected BigInteger rentalValue;
    @XmlElement(name = "RentalRangeValue")
    protected RentalRangeValueType rentalRangeValue;

    /**
     * Gets the value of the rentalValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRentalValue() {
        return rentalValue;
    }

    /**
     * Sets the value of the rentalValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRentalValue(BigInteger value) {
        this.rentalValue = value;
    }

    /**
     * Gets the value of the rentalRangeValue property.
     * 
     * @return
     *     possible object is
     *     {@link RentalRangeValueType }
     *     
     */
    public RentalRangeValueType getRentalRangeValue() {
        return rentalRangeValue;
    }

    /**
     * Sets the value of the rentalRangeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link RentalRangeValueType }
     *     
     */
    public void setRentalRangeValue(RentalRangeValueType value) {
        this.rentalRangeValue = value;
    }

}
