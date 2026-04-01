
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LightSpeedCommercialProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LightSpeedCommercialProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="Property" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}LightSpeedCommercialPropertyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LightSpeedCommercialProductType", propOrder = {
    "property"
})
public class LightSpeedCommercialProductType
    extends BaseProductType
{

    @XmlElement(name = "Property")
    protected LightSpeedCommercialPropertyType property;

    /**
     * Gets the value of the property property.
     * 
     * @return
     *     possible object is
     *     {@link LightSpeedCommercialPropertyType }
     *     
     */
    public LightSpeedCommercialPropertyType getProperty() {
        return property;
    }

    /**
     * Sets the value of the property property.
     * 
     * @param value
     *     allowed object is
     *     {@link LightSpeedCommercialPropertyType }
     *     
     */
    public void setProperty(LightSpeedCommercialPropertyType value) {
        this.property = value;
    }

}
