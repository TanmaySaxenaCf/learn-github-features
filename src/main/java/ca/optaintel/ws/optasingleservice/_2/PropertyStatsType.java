
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyStatsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyStatsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PropertyOccupancy" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertyOccupancyType" minOccurs="0"/>
 *         &lt;element name="Tenure" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}TenureType" minOccurs="0"/>
 *         &lt;element name="ZoningDescription" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ZoningDescriptionType" minOccurs="0"/>
 *         &lt;element name="RentalActivity" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyStatsType", propOrder = {
    "propertyOccupancy",
    "tenure",
    "zoningDescription",
    "rentalActivity"
})
public class PropertyStatsType {

    @XmlElement(name = "PropertyOccupancy")
    @XmlSchemaType(name = "string")
    protected PropertyOccupancyType propertyOccupancy;
    @XmlElement(name = "Tenure")
    @XmlSchemaType(name = "string")
    protected TenureType tenure;
    @XmlElement(name = "ZoningDescription")
    @XmlSchemaType(name = "string")
    protected ZoningDescriptionType zoningDescription;
    @XmlElement(name = "RentalActivity")
    protected Boolean rentalActivity;

    /**
     * Gets the value of the propertyOccupancy property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyOccupancyType }
     *     
     */
    public PropertyOccupancyType getPropertyOccupancy() {
        return propertyOccupancy;
    }

    /**
     * Sets the value of the propertyOccupancy property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyOccupancyType }
     *     
     */
    public void setPropertyOccupancy(PropertyOccupancyType value) {
        this.propertyOccupancy = value;
    }

    /**
     * Gets the value of the tenure property.
     * 
     * @return
     *     possible object is
     *     {@link TenureType }
     *     
     */
    public TenureType getTenure() {
        return tenure;
    }

    /**
     * Sets the value of the tenure property.
     * 
     * @param value
     *     allowed object is
     *     {@link TenureType }
     *     
     */
    public void setTenure(TenureType value) {
        this.tenure = value;
    }

    /**
     * Gets the value of the zoningDescription property.
     * 
     * @return
     *     possible object is
     *     {@link ZoningDescriptionType }
     *     
     */
    public ZoningDescriptionType getZoningDescription() {
        return zoningDescription;
    }

    /**
     * Sets the value of the zoningDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZoningDescriptionType }
     *     
     */
    public void setZoningDescription(ZoningDescriptionType value) {
        this.zoningDescription = value;
    }

    /**
     * Gets the value of the rentalActivity property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRentalActivity() {
        return rentalActivity;
    }

    /**
     * Sets the value of the rentalActivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRentalActivity(Boolean value) {
        this.rentalActivity = value;
    }

}
