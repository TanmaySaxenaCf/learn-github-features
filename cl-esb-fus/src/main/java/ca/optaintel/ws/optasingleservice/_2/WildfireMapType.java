
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WildfireMapType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WildfireMapType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseImageType">
 *       &lt;sequence>
 *         &lt;element name="WildfireImageryType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResidentialImageryCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WildfireMapType", propOrder = {
    "wildfireImageryType"
})
public class WildfireMapType
    extends BaseImageType
{

    @XmlElement(name = "WildfireImageryType")
    @XmlSchemaType(name = "string")
    protected ResidentialImageryCode wildfireImageryType;

    /**
     * Gets the value of the wildfireImageryType property.
     * 
     * @return
     *     possible object is
     *     {@link ResidentialImageryCode }
     *     
     */
    public ResidentialImageryCode getWildfireImageryType() {
        return wildfireImageryType;
    }

    /**
     * Sets the value of the wildfireImageryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResidentialImageryCode }
     *     
     */
    public void setWildfireImageryType(ResidentialImageryCode value) {
        this.wildfireImageryType = value;
    }

}
