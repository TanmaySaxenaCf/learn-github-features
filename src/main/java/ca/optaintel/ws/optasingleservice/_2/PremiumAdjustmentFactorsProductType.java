
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PremiumAdjustmentFactorsProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PremiumAdjustmentFactorsProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="AllPremiumAdjustmentFactor" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PremiumAdjustmentFactorType" minOccurs="0"/>
 *         &lt;element name="PropertyAdjustmentFactors" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertyPremiumAdjustmentFactorsType" minOccurs="0"/>
 *         &lt;element name="CasualtyAdjustmentFactors" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CasualtyPremiumAdjustmentFactorsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PremiumAdjustmentFactorsProductType", propOrder = {
    "allPremiumAdjustmentFactor",
    "propertyAdjustmentFactors",
    "casualtyAdjustmentFactors"
})
public class PremiumAdjustmentFactorsProductType
    extends BaseProductType
{

    @XmlElement(name = "AllPremiumAdjustmentFactor")
    protected PremiumAdjustmentFactorType allPremiumAdjustmentFactor;
    @XmlElement(name = "PropertyAdjustmentFactors")
    protected PropertyPremiumAdjustmentFactorsType propertyAdjustmentFactors;
    @XmlElement(name = "CasualtyAdjustmentFactors")
    protected CasualtyPremiumAdjustmentFactorsType casualtyAdjustmentFactors;

    /**
     * Gets the value of the allPremiumAdjustmentFactor property.
     * 
     * @return
     *     possible object is
     *     {@link PremiumAdjustmentFactorType }
     *     
     */
    public PremiumAdjustmentFactorType getAllPremiumAdjustmentFactor() {
        return allPremiumAdjustmentFactor;
    }

    /**
     * Sets the value of the allPremiumAdjustmentFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link PremiumAdjustmentFactorType }
     *     
     */
    public void setAllPremiumAdjustmentFactor(PremiumAdjustmentFactorType value) {
        this.allPremiumAdjustmentFactor = value;
    }

    /**
     * Gets the value of the propertyAdjustmentFactors property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyPremiumAdjustmentFactorsType }
     *     
     */
    public PropertyPremiumAdjustmentFactorsType getPropertyAdjustmentFactors() {
        return propertyAdjustmentFactors;
    }

    /**
     * Sets the value of the propertyAdjustmentFactors property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyPremiumAdjustmentFactorsType }
     *     
     */
    public void setPropertyAdjustmentFactors(PropertyPremiumAdjustmentFactorsType value) {
        this.propertyAdjustmentFactors = value;
    }

    /**
     * Gets the value of the casualtyAdjustmentFactors property.
     * 
     * @return
     *     possible object is
     *     {@link CasualtyPremiumAdjustmentFactorsType }
     *     
     */
    public CasualtyPremiumAdjustmentFactorsType getCasualtyAdjustmentFactors() {
        return casualtyAdjustmentFactors;
    }

    /**
     * Sets the value of the casualtyAdjustmentFactors property.
     * 
     * @param value
     *     allowed object is
     *     {@link CasualtyPremiumAdjustmentFactorsType }
     *     
     */
    public void setCasualtyAdjustmentFactors(CasualtyPremiumAdjustmentFactorsType value) {
        this.casualtyAdjustmentFactors = value;
    }

}
