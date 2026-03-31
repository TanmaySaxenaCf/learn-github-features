
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LightSpeedCommercialHeatingAndAirType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LightSpeedCommercialHeatingAndAirType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HeatingAndAirConditioningType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialHeatingAndAirConditioningType" minOccurs="0"/>
 *         &lt;element name="NumberOfUnits" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LightSpeedCommercialHeatingAndAirType", propOrder = {
    "heatingAndAirConditioningType",
    "numberOfUnits"
})
public class LightSpeedCommercialHeatingAndAirType {

    @XmlElement(name = "HeatingAndAirConditioningType")
    @XmlSchemaType(name = "string")
    protected CommercialHeatingAndAirConditioningType heatingAndAirConditioningType;
    @XmlElement(name = "NumberOfUnits")
    protected BigInteger numberOfUnits;

    /**
     * Gets the value of the heatingAndAirConditioningType property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialHeatingAndAirConditioningType }
     *     
     */
    public CommercialHeatingAndAirConditioningType getHeatingAndAirConditioningType() {
        return heatingAndAirConditioningType;
    }

    /**
     * Sets the value of the heatingAndAirConditioningType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialHeatingAndAirConditioningType }
     *     
     */
    public void setHeatingAndAirConditioningType(CommercialHeatingAndAirConditioningType value) {
        this.heatingAndAirConditioningType = value;
    }

    /**
     * Gets the value of the numberOfUnits property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfUnits() {
        return numberOfUnits;
    }

    /**
     * Sets the value of the numberOfUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfUnits(BigInteger value) {
        this.numberOfUnits = value;
    }

}
