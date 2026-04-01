
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyLocationProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyLocationProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="Geocode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}GeocodeType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyLocationProductType", propOrder = {
    "geocode"
})
public class PropertyLocationProductType
    extends BaseProductType
{

    @XmlElement(name = "Geocode", required = true)
    protected GeocodeType geocode;

    /**
     * Gets the value of the geocode property.
     * 
     * @return
     *     possible object is
     *     {@link GeocodeType }
     *     
     */
    public GeocodeType getGeocode() {
        return geocode;
    }

    /**
     * Sets the value of the geocode property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeocodeType }
     *     
     */
    public void setGeocode(GeocodeType value) {
        this.geocode = value;
    }

}
