
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyProtectionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyProtectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FireAlarm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BurglarAlarm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fencing" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SprinklerProtection" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}SprinklerProtectionType" minOccurs="0"/>
 *         &lt;element name="FireProofing" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FireProofingType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyProtectionType", propOrder = {
    "fireAlarm",
    "burglarAlarm",
    "fencing",
    "sprinklerProtection",
    "fireProofing"
})
public class PropertyProtectionType {

    @XmlElement(name = "FireAlarm")
    protected String fireAlarm;
    @XmlElement(name = "BurglarAlarm")
    protected String burglarAlarm;
    @XmlElement(name = "Fencing")
    protected String fencing;
    @XmlElement(name = "SprinklerProtection")
    protected SprinklerProtectionType sprinklerProtection;
    @XmlElement(name = "FireProofing")
    protected FireProofingType fireProofing;

    /**
     * Gets the value of the fireAlarm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFireAlarm() {
        return fireAlarm;
    }

    /**
     * Sets the value of the fireAlarm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFireAlarm(String value) {
        this.fireAlarm = value;
    }

    /**
     * Gets the value of the burglarAlarm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBurglarAlarm() {
        return burglarAlarm;
    }

    /**
     * Sets the value of the burglarAlarm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBurglarAlarm(String value) {
        this.burglarAlarm = value;
    }

    /**
     * Gets the value of the fencing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFencing() {
        return fencing;
    }

    /**
     * Sets the value of the fencing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFencing(String value) {
        this.fencing = value;
    }

    /**
     * Gets the value of the sprinklerProtection property.
     * 
     * @return
     *     possible object is
     *     {@link SprinklerProtectionType }
     *     
     */
    public SprinklerProtectionType getSprinklerProtection() {
        return sprinklerProtection;
    }

    /**
     * Sets the value of the sprinklerProtection property.
     * 
     * @param value
     *     allowed object is
     *     {@link SprinklerProtectionType }
     *     
     */
    public void setSprinklerProtection(SprinklerProtectionType value) {
        this.sprinklerProtection = value;
    }

    /**
     * Gets the value of the fireProofing property.
     * 
     * @return
     *     possible object is
     *     {@link FireProofingType }
     *     
     */
    public FireProofingType getFireProofing() {
        return fireProofing;
    }

    /**
     * Sets the value of the fireProofing property.
     * 
     * @param value
     *     allowed object is
     *     {@link FireProofingType }
     *     
     */
    public void setFireProofing(FireProofingType value) {
        this.fireProofing = value;
    }

}
