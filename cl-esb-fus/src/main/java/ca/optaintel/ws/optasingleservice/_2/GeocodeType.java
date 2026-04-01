
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeocodeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeocodeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Longitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="LocationType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}GeocodeLocationType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeocodeType", propOrder = {
    "latitude",
    "longitude",
    "locationType"
})
public class GeocodeType {

    @XmlElement(name = "Latitude")
    protected double latitude;
    @XmlElement(name = "Longitude")
    protected double longitude;
    @XmlElement(name = "LocationType", required = true)
    @XmlSchemaType(name = "string")
    protected GeocodeLocationType locationType;

    /**
     * Gets the value of the latitude property.
     * 
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     */
    public void setLatitude(double value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the longitude property.
     * 
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     * 
     */
    public void setLongitude(double value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the locationType property.
     * 
     * @return
     *     possible object is
     *     {@link GeocodeLocationType }
     *     
     */
    public GeocodeLocationType getLocationType() {
        return locationType;
    }

    /**
     * Sets the value of the locationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeocodeLocationType }
     *     
     */
    public void setLocationType(GeocodeLocationType value) {
        this.locationType = value;
    }

}
