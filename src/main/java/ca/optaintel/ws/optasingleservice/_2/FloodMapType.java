
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FloodMapType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FloodMapType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FloodEvent" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FloodEventType" minOccurs="0"/>
 *         &lt;element name="FloodEventProbability" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="FloodImageryType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResidentialImageryCode" minOccurs="0"/>
 *         &lt;element name="Content" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ContentType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FloodMapType", propOrder = {
    "floodEvent",
    "floodEventProbability",
    "floodImageryType",
    "content"
})
public class FloodMapType {

    @XmlElement(name = "FloodEvent")
    protected BigInteger floodEvent;
    @XmlElement(name = "FloodEventProbability")
    protected Boolean floodEventProbability;
    @XmlElement(name = "FloodImageryType")
    @XmlSchemaType(name = "string")
    protected ResidentialImageryCode floodImageryType;
    @XmlElement(name = "Content")
    protected ContentType content;

    /**
     * Gets the value of the floodEvent property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFloodEvent() {
        return floodEvent;
    }

    /**
     * Sets the value of the floodEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFloodEvent(BigInteger value) {
        this.floodEvent = value;
    }

    /**
     * Gets the value of the floodEventProbability property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFloodEventProbability() {
        return floodEventProbability;
    }

    /**
     * Sets the value of the floodEventProbability property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFloodEventProbability(Boolean value) {
        this.floodEventProbability = value;
    }

    /**
     * Gets the value of the floodImageryType property.
     * 
     * @return
     *     possible object is
     *     {@link ResidentialImageryCode }
     *     
     */
    public ResidentialImageryCode getFloodImageryType() {
        return floodImageryType;
    }

    /**
     * Sets the value of the floodImageryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResidentialImageryCode }
     *     
     */
    public void setFloodImageryType(ResidentialImageryCode value) {
        this.floodImageryType = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link ContentType }
     *     
     */
    public ContentType getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentType }
     *     
     */
    public void setContent(ContentType value) {
        this.content = value;
    }

}
