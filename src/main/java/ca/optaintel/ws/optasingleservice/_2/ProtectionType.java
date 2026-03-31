
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProtectionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProtectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SprinklerPresent" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BooleanWithUnknownType" minOccurs="0"/>
 *         &lt;element name="SprinklerTypeCode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}SprinklerProtectionType" minOccurs="0"/>
 *         &lt;element name="FireAlarmPresent" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BooleanWithUnknownType" minOccurs="0"/>
 *         &lt;element name="FireAlarmType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FireAndSecurityAlarmType" minOccurs="0"/>
 *         &lt;element name="SecurityAlarmPresent" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BooleanWithUnknownType" minOccurs="0"/>
 *         &lt;element name="SecurityAlarmType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FireAndSecurityAlarmType" minOccurs="0"/>
 *         &lt;element name="PhysicalSecurityPresent" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BooleanWithUnknownType" minOccurs="0"/>
 *         &lt;element name="PhysicalSecurityTypes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PhysicalSecurityType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProtectionType", propOrder = {
    "sprinklerPresent",
    "sprinklerTypeCode",
    "fireAlarmPresent",
    "fireAlarmType",
    "securityAlarmPresent",
    "securityAlarmType",
    "physicalSecurityPresent",
    "physicalSecurityTypes"
})
public class ProtectionType {

    @XmlElement(name = "SprinklerPresent")
    @XmlSchemaType(name = "string")
    protected BooleanWithUnknownType sprinklerPresent;
    @XmlElement(name = "SprinklerTypeCode")
    @XmlSchemaType(name = "string")
    protected SprinklerProtectionType sprinklerTypeCode;
    @XmlElement(name = "FireAlarmPresent")
    @XmlSchemaType(name = "string")
    protected BooleanWithUnknownType fireAlarmPresent;
    @XmlElement(name = "FireAlarmType")
    @XmlSchemaType(name = "string")
    protected FireAndSecurityAlarmType fireAlarmType;
    @XmlElement(name = "SecurityAlarmPresent")
    @XmlSchemaType(name = "string")
    protected BooleanWithUnknownType securityAlarmPresent;
    @XmlElement(name = "SecurityAlarmType")
    @XmlSchemaType(name = "string")
    protected FireAndSecurityAlarmType securityAlarmType;
    @XmlElement(name = "PhysicalSecurityPresent")
    @XmlSchemaType(name = "string")
    protected BooleanWithUnknownType physicalSecurityPresent;
    @XmlElement(name = "PhysicalSecurityTypes")
    protected PhysicalSecurityType physicalSecurityTypes;

    /**
     * Gets the value of the sprinklerPresent property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public BooleanWithUnknownType getSprinklerPresent() {
        return sprinklerPresent;
    }

    /**
     * Sets the value of the sprinklerPresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public void setSprinklerPresent(BooleanWithUnknownType value) {
        this.sprinklerPresent = value;
    }

    /**
     * Gets the value of the sprinklerTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link SprinklerProtectionType }
     *     
     */
    public SprinklerProtectionType getSprinklerTypeCode() {
        return sprinklerTypeCode;
    }

    /**
     * Sets the value of the sprinklerTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link SprinklerProtectionType }
     *     
     */
    public void setSprinklerTypeCode(SprinklerProtectionType value) {
        this.sprinklerTypeCode = value;
    }

    /**
     * Gets the value of the fireAlarmPresent property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public BooleanWithUnknownType getFireAlarmPresent() {
        return fireAlarmPresent;
    }

    /**
     * Sets the value of the fireAlarmPresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public void setFireAlarmPresent(BooleanWithUnknownType value) {
        this.fireAlarmPresent = value;
    }

    /**
     * Gets the value of the fireAlarmType property.
     * 
     * @return
     *     possible object is
     *     {@link FireAndSecurityAlarmType }
     *     
     */
    public FireAndSecurityAlarmType getFireAlarmType() {
        return fireAlarmType;
    }

    /**
     * Sets the value of the fireAlarmType property.
     * 
     * @param value
     *     allowed object is
     *     {@link FireAndSecurityAlarmType }
     *     
     */
    public void setFireAlarmType(FireAndSecurityAlarmType value) {
        this.fireAlarmType = value;
    }

    /**
     * Gets the value of the securityAlarmPresent property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public BooleanWithUnknownType getSecurityAlarmPresent() {
        return securityAlarmPresent;
    }

    /**
     * Sets the value of the securityAlarmPresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public void setSecurityAlarmPresent(BooleanWithUnknownType value) {
        this.securityAlarmPresent = value;
    }

    /**
     * Gets the value of the securityAlarmType property.
     * 
     * @return
     *     possible object is
     *     {@link FireAndSecurityAlarmType }
     *     
     */
    public FireAndSecurityAlarmType getSecurityAlarmType() {
        return securityAlarmType;
    }

    /**
     * Sets the value of the securityAlarmType property.
     * 
     * @param value
     *     allowed object is
     *     {@link FireAndSecurityAlarmType }
     *     
     */
    public void setSecurityAlarmType(FireAndSecurityAlarmType value) {
        this.securityAlarmType = value;
    }

    /**
     * Gets the value of the physicalSecurityPresent property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public BooleanWithUnknownType getPhysicalSecurityPresent() {
        return physicalSecurityPresent;
    }

    /**
     * Sets the value of the physicalSecurityPresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public void setPhysicalSecurityPresent(BooleanWithUnknownType value) {
        this.physicalSecurityPresent = value;
    }

    /**
     * Gets the value of the physicalSecurityTypes property.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalSecurityType }
     *     
     */
    public PhysicalSecurityType getPhysicalSecurityTypes() {
        return physicalSecurityTypes;
    }

    /**
     * Sets the value of the physicalSecurityTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalSecurityType }
     *     
     */
    public void setPhysicalSecurityTypes(PhysicalSecurityType value) {
        this.physicalSecurityTypes = value;
    }

}
