
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LightSpeedCommercialAdditionalFeaturesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LightSpeedCommercialAdditionalFeaturesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AdditionalFeature" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AdditionalFeatureType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LightSpeedCommercialAdditionalFeaturesType", propOrder = {
    "additionalFeature",
    "amount"
})
public class LightSpeedCommercialAdditionalFeaturesType {

    @XmlElement(name = "AdditionalFeature")
    protected List<AdditionalFeatureType> additionalFeature;
    @XmlElement(name = "Amount")
    protected BigInteger amount;

    /**
     * Gets the value of the additionalFeature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalFeature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalFeature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalFeatureType }
     * 
     * 
     */
    public List<AdditionalFeatureType> getAdditionalFeature() {
        if (additionalFeature == null) {
            additionalFeature = new ArrayList<AdditionalFeatureType>();
        }
        return this.additionalFeature;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAmount(BigInteger value) {
        this.amount = value;
    }

}
