
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AerialImageryPropertyFeaturesPoolTypesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AerialImageryPropertyFeaturesPoolTypesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AboveGround" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesPoolTypeItemType" minOccurs="0"/>
 *         &lt;element name="HotTub" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesPoolTypeItemType" minOccurs="0"/>
 *         &lt;element name="InGround" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesPoolTypeItemType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AerialImageryPropertyFeaturesPoolTypesType", propOrder = {
    "aboveGround",
    "hotTub",
    "inGround"
})
public class AerialImageryPropertyFeaturesPoolTypesType {

    @XmlElement(name = "AboveGround")
    protected AerialImageryPropertyFeaturesPoolTypeItemType aboveGround;
    @XmlElement(name = "HotTub")
    protected AerialImageryPropertyFeaturesPoolTypeItemType hotTub;
    @XmlElement(name = "InGround")
    protected AerialImageryPropertyFeaturesPoolTypeItemType inGround;

    /**
     * Gets the value of the aboveGround property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesPoolTypeItemType }
     *     
     */
    public AerialImageryPropertyFeaturesPoolTypeItemType getAboveGround() {
        return aboveGround;
    }

    /**
     * Sets the value of the aboveGround property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesPoolTypeItemType }
     *     
     */
    public void setAboveGround(AerialImageryPropertyFeaturesPoolTypeItemType value) {
        this.aboveGround = value;
    }

    /**
     * Gets the value of the hotTub property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesPoolTypeItemType }
     *     
     */
    public AerialImageryPropertyFeaturesPoolTypeItemType getHotTub() {
        return hotTub;
    }

    /**
     * Sets the value of the hotTub property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesPoolTypeItemType }
     *     
     */
    public void setHotTub(AerialImageryPropertyFeaturesPoolTypeItemType value) {
        this.hotTub = value;
    }

    /**
     * Gets the value of the inGround property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesPoolTypeItemType }
     *     
     */
    public AerialImageryPropertyFeaturesPoolTypeItemType getInGround() {
        return inGround;
    }

    /**
     * Sets the value of the inGround property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesPoolTypeItemType }
     *     
     */
    public void setInGround(AerialImageryPropertyFeaturesPoolTypeItemType value) {
        this.inGround = value;
    }

}
