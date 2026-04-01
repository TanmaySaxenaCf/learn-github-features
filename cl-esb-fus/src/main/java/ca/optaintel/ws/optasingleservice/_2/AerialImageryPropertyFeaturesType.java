
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AerialImageryPropertyFeaturesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AerialImageryPropertyFeaturesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Deck" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesItemType" minOccurs="0"/>
 *         &lt;element name="DivingBoard" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesItemType" minOccurs="0"/>
 *         &lt;element name="Enclosure" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesItemType" minOccurs="0"/>
 *         &lt;element name="Hardscapes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesItemType" minOccurs="0"/>
 *         &lt;element name="Pool" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesPoolType" minOccurs="0"/>
 *         &lt;element name="Playground" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesItemType" minOccurs="0"/>
 *         &lt;element name="SportCourt" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesItemType" minOccurs="0"/>
 *         &lt;element name="Trampoline" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesItemType" minOccurs="0"/>
 *         &lt;element name="Vehicle" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesVehicleType" minOccurs="0"/>
 *         &lt;element name="Waterslide" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesItemType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AerialImageryPropertyFeaturesType", propOrder = {
    "deck",
    "divingBoard",
    "enclosure",
    "hardscapes",
    "pool",
    "playground",
    "sportCourt",
    "trampoline",
    "vehicle",
    "waterslide"
})
public class AerialImageryPropertyFeaturesType {

    @XmlElement(name = "Deck")
    protected AerialImageryPropertyFeaturesItemType deck;
    @XmlElement(name = "DivingBoard")
    protected AerialImageryPropertyFeaturesItemType divingBoard;
    @XmlElement(name = "Enclosure")
    protected AerialImageryPropertyFeaturesItemType enclosure;
    @XmlElement(name = "Hardscapes")
    protected AerialImageryPropertyFeaturesItemType hardscapes;
    @XmlElement(name = "Pool")
    protected AerialImageryPropertyFeaturesPoolType pool;
    @XmlElement(name = "Playground")
    protected AerialImageryPropertyFeaturesItemType playground;
    @XmlElement(name = "SportCourt")
    protected AerialImageryPropertyFeaturesItemType sportCourt;
    @XmlElement(name = "Trampoline")
    protected AerialImageryPropertyFeaturesItemType trampoline;
    @XmlElement(name = "Vehicle")
    protected AerialImageryPropertyFeaturesVehicleType vehicle;
    @XmlElement(name = "Waterslide")
    protected AerialImageryPropertyFeaturesItemType waterslide;

    /**
     * Gets the value of the deck property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesItemType }
     *     
     */
    public AerialImageryPropertyFeaturesItemType getDeck() {
        return deck;
    }

    /**
     * Sets the value of the deck property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesItemType }
     *     
     */
    public void setDeck(AerialImageryPropertyFeaturesItemType value) {
        this.deck = value;
    }

    /**
     * Gets the value of the divingBoard property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesItemType }
     *     
     */
    public AerialImageryPropertyFeaturesItemType getDivingBoard() {
        return divingBoard;
    }

    /**
     * Sets the value of the divingBoard property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesItemType }
     *     
     */
    public void setDivingBoard(AerialImageryPropertyFeaturesItemType value) {
        this.divingBoard = value;
    }

    /**
     * Gets the value of the enclosure property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesItemType }
     *     
     */
    public AerialImageryPropertyFeaturesItemType getEnclosure() {
        return enclosure;
    }

    /**
     * Sets the value of the enclosure property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesItemType }
     *     
     */
    public void setEnclosure(AerialImageryPropertyFeaturesItemType value) {
        this.enclosure = value;
    }

    /**
     * Gets the value of the hardscapes property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesItemType }
     *     
     */
    public AerialImageryPropertyFeaturesItemType getHardscapes() {
        return hardscapes;
    }

    /**
     * Sets the value of the hardscapes property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesItemType }
     *     
     */
    public void setHardscapes(AerialImageryPropertyFeaturesItemType value) {
        this.hardscapes = value;
    }

    /**
     * Gets the value of the pool property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesPoolType }
     *     
     */
    public AerialImageryPropertyFeaturesPoolType getPool() {
        return pool;
    }

    /**
     * Sets the value of the pool property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesPoolType }
     *     
     */
    public void setPool(AerialImageryPropertyFeaturesPoolType value) {
        this.pool = value;
    }

    /**
     * Gets the value of the playground property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesItemType }
     *     
     */
    public AerialImageryPropertyFeaturesItemType getPlayground() {
        return playground;
    }

    /**
     * Sets the value of the playground property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesItemType }
     *     
     */
    public void setPlayground(AerialImageryPropertyFeaturesItemType value) {
        this.playground = value;
    }

    /**
     * Gets the value of the sportCourt property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesItemType }
     *     
     */
    public AerialImageryPropertyFeaturesItemType getSportCourt() {
        return sportCourt;
    }

    /**
     * Sets the value of the sportCourt property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesItemType }
     *     
     */
    public void setSportCourt(AerialImageryPropertyFeaturesItemType value) {
        this.sportCourt = value;
    }

    /**
     * Gets the value of the trampoline property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesItemType }
     *     
     */
    public AerialImageryPropertyFeaturesItemType getTrampoline() {
        return trampoline;
    }

    /**
     * Sets the value of the trampoline property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesItemType }
     *     
     */
    public void setTrampoline(AerialImageryPropertyFeaturesItemType value) {
        this.trampoline = value;
    }

    /**
     * Gets the value of the vehicle property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesVehicleType }
     *     
     */
    public AerialImageryPropertyFeaturesVehicleType getVehicle() {
        return vehicle;
    }

    /**
     * Sets the value of the vehicle property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesVehicleType }
     *     
     */
    public void setVehicle(AerialImageryPropertyFeaturesVehicleType value) {
        this.vehicle = value;
    }

    /**
     * Gets the value of the waterslide property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesItemType }
     *     
     */
    public AerialImageryPropertyFeaturesItemType getWaterslide() {
        return waterslide;
    }

    /**
     * Sets the value of the waterslide property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesItemType }
     *     
     */
    public void setWaterslide(AerialImageryPropertyFeaturesItemType value) {
        this.waterslide = value;
    }

}
