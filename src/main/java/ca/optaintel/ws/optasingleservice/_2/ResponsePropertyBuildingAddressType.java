
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponsePropertyBuildingAddressType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponsePropertyBuildingAddressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConstructionFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}OptaCommercialConstructionFeaturesType" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseAddressType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponsePropertyBuildingAddressType", propOrder = {
    "constructionFeatures",
    "address"
})
public class ResponsePropertyBuildingAddressType {

    @XmlElement(name = "ConstructionFeatures")
    protected OptaCommercialConstructionFeaturesType constructionFeatures;
    @XmlElement(name = "Address")
    protected ResponseAddressType address;

    /**
     * Gets the value of the constructionFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link OptaCommercialConstructionFeaturesType }
     *     
     */
    public OptaCommercialConstructionFeaturesType getConstructionFeatures() {
        return constructionFeatures;
    }

    /**
     * Sets the value of the constructionFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link OptaCommercialConstructionFeaturesType }
     *     
     */
    public void setConstructionFeatures(OptaCommercialConstructionFeaturesType value) {
        this.constructionFeatures = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseAddressType }
     *     
     */
    public ResponseAddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseAddressType }
     *     
     */
    public void setAddress(ResponseAddressType value) {
        this.address = value;
    }

}
