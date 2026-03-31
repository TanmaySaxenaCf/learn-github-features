
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialBasementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialBasementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BasementPresent" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BooleanWithUnknownType" minOccurs="0"/>
 *         &lt;element name="BasementArea" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="BasementAreaUnitOfMeasurement" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}UnitOfAreaType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialBasementType", propOrder = {
    "basementPresent",
    "basementArea",
    "basementAreaUnitOfMeasurement"
})
public class CommercialBasementType {

    @XmlElement(name = "BasementPresent")
    @XmlSchemaType(name = "string")
    protected BooleanWithUnknownType basementPresent;
    @XmlElement(name = "BasementArea")
    protected BigInteger basementArea;
    @XmlElement(name = "BasementAreaUnitOfMeasurement")
    @XmlSchemaType(name = "string")
    protected UnitOfAreaType basementAreaUnitOfMeasurement;

    /**
     * Gets the value of the basementPresent property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public BooleanWithUnknownType getBasementPresent() {
        return basementPresent;
    }

    /**
     * Sets the value of the basementPresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public void setBasementPresent(BooleanWithUnknownType value) {
        this.basementPresent = value;
    }

    /**
     * Gets the value of the basementArea property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBasementArea() {
        return basementArea;
    }

    /**
     * Sets the value of the basementArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBasementArea(BigInteger value) {
        this.basementArea = value;
    }

    /**
     * Gets the value of the basementAreaUnitOfMeasurement property.
     * 
     * @return
     *     possible object is
     *     {@link UnitOfAreaType }
     *     
     */
    public UnitOfAreaType getBasementAreaUnitOfMeasurement() {
        return basementAreaUnitOfMeasurement;
    }

    /**
     * Sets the value of the basementAreaUnitOfMeasurement property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitOfAreaType }
     *     
     */
    public void setBasementAreaUnitOfMeasurement(UnitOfAreaType value) {
        this.basementAreaUnitOfMeasurement = value;
    }

}
