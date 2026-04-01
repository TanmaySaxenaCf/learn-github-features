
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyParkingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyParkingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ParkingType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ParkingCapacity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyParkingType", propOrder = {
    "parkingType",
    "parkingCapacity"
})
public class PropertyParkingType {

    @XmlElement(name = "ParkingType")
    protected String parkingType;
    @XmlElement(name = "ParkingCapacity")
    protected String parkingCapacity;

    /**
     * Gets the value of the parkingType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParkingType() {
        return parkingType;
    }

    /**
     * Sets the value of the parkingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParkingType(String value) {
        this.parkingType = value;
    }

    /**
     * Gets the value of the parkingCapacity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParkingCapacity() {
        return parkingCapacity;
    }

    /**
     * Sets the value of the parkingCapacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParkingCapacity(String value) {
        this.parkingCapacity = value;
    }

}
