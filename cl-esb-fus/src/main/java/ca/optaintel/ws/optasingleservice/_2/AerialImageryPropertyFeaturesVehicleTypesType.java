
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AerialImageryPropertyFeaturesVehicleTypesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AerialImageryPropertyFeaturesVehicleTypesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Automobile" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesVehicleItemType" minOccurs="0"/>
 *         &lt;element name="Boat" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesVehicleItemType" minOccurs="0"/>
 *         &lt;element name="RV" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesVehicleItemType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AerialImageryPropertyFeaturesVehicleTypesType", propOrder = {
    "automobile",
    "boat",
    "rv"
})
public class AerialImageryPropertyFeaturesVehicleTypesType {

    @XmlElement(name = "Automobile")
    protected AerialImageryPropertyFeaturesVehicleItemType automobile;
    @XmlElement(name = "Boat")
    protected AerialImageryPropertyFeaturesVehicleItemType boat;
    @XmlElement(name = "RV")
    protected AerialImageryPropertyFeaturesVehicleItemType rv;

    /**
     * Gets the value of the automobile property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesVehicleItemType }
     *     
     */
    public AerialImageryPropertyFeaturesVehicleItemType getAutomobile() {
        return automobile;
    }

    /**
     * Sets the value of the automobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesVehicleItemType }
     *     
     */
    public void setAutomobile(AerialImageryPropertyFeaturesVehicleItemType value) {
        this.automobile = value;
    }

    /**
     * Gets the value of the boat property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesVehicleItemType }
     *     
     */
    public AerialImageryPropertyFeaturesVehicleItemType getBoat() {
        return boat;
    }

    /**
     * Sets the value of the boat property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesVehicleItemType }
     *     
     */
    public void setBoat(AerialImageryPropertyFeaturesVehicleItemType value) {
        this.boat = value;
    }

    /**
     * Gets the value of the rv property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesVehicleItemType }
     *     
     */
    public AerialImageryPropertyFeaturesVehicleItemType getRV() {
        return rv;
    }

    /**
     * Sets the value of the rv property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesVehicleItemType }
     *     
     */
    public void setRV(AerialImageryPropertyFeaturesVehicleItemType value) {
        this.rv = value;
    }

}
