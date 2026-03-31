
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BusinessNamePrefillProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BusinessNamePrefillProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="Businesses" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseBusinessesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessNamePrefillProductType", propOrder = {
    "businesses"
})
public class BusinessNamePrefillProductType
    extends BaseProductType
{

    @XmlElement(name = "Businesses")
    protected ResponseBusinessesType businesses;

    /**
     * Gets the value of the businesses property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseBusinessesType }
     *     
     */
    public ResponseBusinessesType getBusinesses() {
        return businesses;
    }

    /**
     * Sets the value of the businesses property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseBusinessesType }
     *     
     */
    public void setBusinesses(ResponseBusinessesType value) {
        this.businesses = value;
    }

}
