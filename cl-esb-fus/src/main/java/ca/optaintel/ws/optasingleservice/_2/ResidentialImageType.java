
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResidentialImageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResidentialImageType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseImageType">
 *       &lt;sequence>
 *         &lt;element name="ImageTypeCode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResidentialImageryCode" minOccurs="0"/>
 *         &lt;element name="ProviderCode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResidentialImageryProvider" minOccurs="0"/>
 *         &lt;element name="BestPhoto" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResidentialImageType", propOrder = {
    "imageTypeCode",
    "providerCode",
    "bestPhoto"
})
public class ResidentialImageType
    extends BaseImageType
{

    @XmlElement(name = "ImageTypeCode")
    @XmlSchemaType(name = "string")
    protected ResidentialImageryCode imageTypeCode;
    @XmlElement(name = "ProviderCode")
    @XmlSchemaType(name = "string")
    protected ResidentialImageryProvider providerCode;
    @XmlElement(name = "BestPhoto")
    protected Boolean bestPhoto;

    /**
     * Gets the value of the imageTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link ResidentialImageryCode }
     *     
     */
    public ResidentialImageryCode getImageTypeCode() {
        return imageTypeCode;
    }

    /**
     * Sets the value of the imageTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResidentialImageryCode }
     *     
     */
    public void setImageTypeCode(ResidentialImageryCode value) {
        this.imageTypeCode = value;
    }

    /**
     * Gets the value of the providerCode property.
     * 
     * @return
     *     possible object is
     *     {@link ResidentialImageryProvider }
     *     
     */
    public ResidentialImageryProvider getProviderCode() {
        return providerCode;
    }

    /**
     * Sets the value of the providerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResidentialImageryProvider }
     *     
     */
    public void setProviderCode(ResidentialImageryProvider value) {
        this.providerCode = value;
    }

    /**
     * Gets the value of the bestPhoto property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBestPhoto() {
        return bestPhoto;
    }

    /**
     * Sets the value of the bestPhoto property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBestPhoto(Boolean value) {
        this.bestPhoto = value;
    }

}
