
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActiveFireType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActiveFireType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Present" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Radius" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="UnitOfLength" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}UnitOfLengthType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActiveFireType", propOrder = {
    "present",
    "radius",
    "unitOfLength"
})
public class ActiveFireType {

    @XmlElement(name = "Present")
    protected String present;
    @XmlElement(name = "Radius")
    protected BigInteger radius;
    @XmlElement(name = "UnitOfLength")
    @XmlSchemaType(name = "string")
    protected UnitOfLengthType unitOfLength;

    /**
     * Gets the value of the present property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPresent() {
        return present;
    }

    /**
     * Sets the value of the present property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPresent(String value) {
        this.present = value;
    }

    /**
     * Gets the value of the radius property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRadius() {
        return radius;
    }

    /**
     * Sets the value of the radius property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRadius(BigInteger value) {
        this.radius = value;
    }

    /**
     * Gets the value of the unitOfLength property.
     * 
     * @return
     *     possible object is
     *     {@link UnitOfLengthType }
     *     
     */
    public UnitOfLengthType getUnitOfLength() {
        return unitOfLength;
    }

    /**
     * Sets the value of the unitOfLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitOfLengthType }
     *     
     */
    public void setUnitOfLength(UnitOfLengthType value) {
        this.unitOfLength = value;
    }

}
