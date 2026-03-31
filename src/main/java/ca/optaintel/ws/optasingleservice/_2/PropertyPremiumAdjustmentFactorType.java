
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyPremiumAdjustmentFactorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyPremiumAdjustmentFactorType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PremiumAdjustmentFactorType">
 *       &lt;sequence>
 *         &lt;element name="Risk" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertyCommercialPerilType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyPremiumAdjustmentFactorType", propOrder = {
    "risk"
})
public class PropertyPremiumAdjustmentFactorType
    extends PremiumAdjustmentFactorType
{

    @XmlElement(name = "Risk")
    @XmlSchemaType(name = "string")
    protected PropertyCommercialPerilType risk;

    /**
     * Gets the value of the risk property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyCommercialPerilType }
     *     
     */
    public PropertyCommercialPerilType getRisk() {
        return risk;
    }

    /**
     * Sets the value of the risk property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyCommercialPerilType }
     *     
     */
    public void setRisk(PropertyCommercialPerilType value) {
        this.risk = value;
    }

}
