
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CasualtyPremiumAdjustmentFactorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CasualtyPremiumAdjustmentFactorType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PremiumAdjustmentFactorType">
 *       &lt;sequence>
 *         &lt;element name="Risk" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CasualtyCommercialPerilType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CasualtyPremiumAdjustmentFactorType", propOrder = {
    "risk"
})
public class CasualtyPremiumAdjustmentFactorType
    extends PremiumAdjustmentFactorType
{

    @XmlElement(name = "Risk")
    @XmlSchemaType(name = "string")
    protected CasualtyCommercialPerilType risk;

    /**
     * Gets the value of the risk property.
     * 
     * @return
     *     possible object is
     *     {@link CasualtyCommercialPerilType }
     *     
     */
    public CasualtyCommercialPerilType getRisk() {
        return risk;
    }

    /**
     * Sets the value of the risk property.
     * 
     * @param value
     *     allowed object is
     *     {@link CasualtyCommercialPerilType }
     *     
     */
    public void setRisk(CasualtyCommercialPerilType value) {
        this.risk = value;
    }

}
