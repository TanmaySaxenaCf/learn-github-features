
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HydrantCountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HydrantCountType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RadiusMetres" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}HydrantRadiusMetresType"/>
 *         &lt;element name="NumberOfHydrants" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="Ownership" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}HydrantOwnershipType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HydrantCountType", propOrder = {
    "radiusMetres",
    "numberOfHydrants",
    "ownership"
})
public class HydrantCountType {

    @XmlElement(name = "RadiusMetres", required = true)
    protected BigInteger radiusMetres;
    @XmlElement(name = "NumberOfHydrants", required = true)
    protected BigInteger numberOfHydrants;
    @XmlElement(name = "Ownership", required = true)
    @XmlSchemaType(name = "string")
    protected HydrantOwnershipType ownership;

    /**
     * Gets the value of the radiusMetres property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRadiusMetres() {
        return radiusMetres;
    }

    /**
     * Sets the value of the radiusMetres property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRadiusMetres(BigInteger value) {
        this.radiusMetres = value;
    }

    /**
     * Gets the value of the numberOfHydrants property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfHydrants() {
        return numberOfHydrants;
    }

    /**
     * Sets the value of the numberOfHydrants property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfHydrants(BigInteger value) {
        this.numberOfHydrants = value;
    }

    /**
     * Gets the value of the ownership property.
     * 
     * @return
     *     possible object is
     *     {@link HydrantOwnershipType }
     *     
     */
    public HydrantOwnershipType getOwnership() {
        return ownership;
    }

    /**
     * Sets the value of the ownership property.
     * 
     * @param value
     *     allowed object is
     *     {@link HydrantOwnershipType }
     *     
     */
    public void setOwnership(HydrantOwnershipType value) {
        this.ownership = value;
    }

}
