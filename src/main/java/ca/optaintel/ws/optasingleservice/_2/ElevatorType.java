
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ElevatorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ElevatorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ElevatorCount" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="ElevatorPresent" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BooleanWithUnknownType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElevatorType", propOrder = {
    "elevatorCount",
    "elevatorPresent"
})
public class ElevatorType {

    @XmlElement(name = "ElevatorCount")
    protected BigInteger elevatorCount;
    @XmlElement(name = "ElevatorPresent")
    @XmlSchemaType(name = "string")
    protected BooleanWithUnknownType elevatorPresent;

    /**
     * Gets the value of the elevatorCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getElevatorCount() {
        return elevatorCount;
    }

    /**
     * Sets the value of the elevatorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setElevatorCount(BigInteger value) {
        this.elevatorCount = value;
    }

    /**
     * Gets the value of the elevatorPresent property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public BooleanWithUnknownType getElevatorPresent() {
        return elevatorPresent;
    }

    /**
     * Sets the value of the elevatorPresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public void setElevatorPresent(BooleanWithUnknownType value) {
        this.elevatorPresent = value;
    }

}
