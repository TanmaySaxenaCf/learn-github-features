
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PremiumAdjustmentFactorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PremiumAdjustmentFactorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Factor" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PremiumAdjustmentFactorType", propOrder = {
    "factor"
})
@XmlSeeAlso({
    PropertyPremiumAdjustmentFactorType.class,
    CasualtyPremiumAdjustmentFactorType.class
})
public class PremiumAdjustmentFactorType {

    @XmlElement(name = "Factor")
    protected Float factor;

    /**
     * Gets the value of the factor property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFactor() {
        return factor;
    }

    /**
     * Sets the value of the factor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFactor(Float value) {
        this.factor = value;
    }

}
