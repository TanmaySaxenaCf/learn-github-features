
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LightSpeedCommercialValuationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LightSpeedCommercialValuationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReplacementCost" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Coverages" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialCoveragesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LightSpeedCommercialValuationType", propOrder = {
    "replacementCost",
    "coverages"
})
public class LightSpeedCommercialValuationType {

    @XmlElement(name = "ReplacementCost")
    protected BigInteger replacementCost;
    @XmlElement(name = "Coverages")
    protected CommercialCoveragesType coverages;

    /**
     * Gets the value of the replacementCost property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getReplacementCost() {
        return replacementCost;
    }

    /**
     * Sets the value of the replacementCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setReplacementCost(BigInteger value) {
        this.replacementCost = value;
    }

    /**
     * Gets the value of the coverages property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialCoveragesType }
     *     
     */
    public CommercialCoveragesType getCoverages() {
        return coverages;
    }

    /**
     * Sets the value of the coverages property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialCoveragesType }
     *     
     */
    public void setCoverages(CommercialCoveragesType value) {
        this.coverages = value;
    }

}
