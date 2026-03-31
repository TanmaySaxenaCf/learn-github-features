
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BusinessNameDetailsProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BusinessNameDetailsProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="Business" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseDetailsBusinessType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessNameDetailsProductType", propOrder = {
    "business"
})
public class BusinessNameDetailsProductType
    extends BaseProductType
{

    @XmlElement(name = "Business")
    protected ResponseDetailsBusinessType business;

    /**
     * Gets the value of the business property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseDetailsBusinessType }
     *     
     */
    public ResponseDetailsBusinessType getBusiness() {
        return business;
    }

    /**
     * Sets the value of the business property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseDetailsBusinessType }
     *     
     */
    public void setBusiness(ResponseDetailsBusinessType value) {
        this.business = value;
    }

}
