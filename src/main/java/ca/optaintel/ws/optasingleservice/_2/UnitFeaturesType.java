
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnitFeaturesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnitFeaturesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TotalFloorArea" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="FloorLevel" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="NumberOfKitchens" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResidentialKitchenCountType" minOccurs="0"/>
 *         &lt;element name="NumberOfBathrooms" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResidentialBathroomCountType" minOccurs="0"/>
 *         &lt;element name="NumberOfBedrooms" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="NumberOfDens" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="GarageNumberOfCars" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}GarageNumberOfCarsType" minOccurs="0"/>
 *         &lt;element name="CommercialIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="View" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ViewType" minOccurs="0"/>
 *         &lt;element name="Locker" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BooleanWithUnknownType" minOccurs="0"/>
 *         &lt;element name="Balcony" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BooleanWithUnknownType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnitFeaturesType", propOrder = {
    "totalFloorArea",
    "floorLevel",
    "numberOfKitchens",
    "numberOfBathrooms",
    "numberOfBedrooms",
    "numberOfDens",
    "garageNumberOfCars",
    "commercialIndicator",
    "view",
    "locker",
    "balcony"
})
public class UnitFeaturesType {

    @XmlElement(name = "TotalFloorArea")
    protected BigInteger totalFloorArea;
    @XmlElement(name = "FloorLevel")
    protected BigInteger floorLevel;
    @XmlElement(name = "NumberOfKitchens")
    protected String numberOfKitchens;
    @XmlElement(name = "NumberOfBathrooms")
    protected String numberOfBathrooms;
    @XmlElement(name = "NumberOfBedrooms")
    protected BigInteger numberOfBedrooms;
    @XmlElement(name = "NumberOfDens")
    protected BigInteger numberOfDens;
    @XmlElement(name = "GarageNumberOfCars")
    protected BigInteger garageNumberOfCars;
    @XmlElement(name = "CommercialIndicator")
    protected Boolean commercialIndicator;
    @XmlElement(name = "View")
    @XmlSchemaType(name = "string")
    protected ViewType view;
    @XmlElement(name = "Locker")
    @XmlSchemaType(name = "string")
    protected BooleanWithUnknownType locker;
    @XmlElement(name = "Balcony")
    @XmlSchemaType(name = "string")
    protected BooleanWithUnknownType balcony;

    /**
     * Gets the value of the totalFloorArea property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalFloorArea() {
        return totalFloorArea;
    }

    /**
     * Sets the value of the totalFloorArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalFloorArea(BigInteger value) {
        this.totalFloorArea = value;
    }

    /**
     * Gets the value of the floorLevel property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFloorLevel() {
        return floorLevel;
    }

    /**
     * Sets the value of the floorLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFloorLevel(BigInteger value) {
        this.floorLevel = value;
    }

    /**
     * Gets the value of the numberOfKitchens property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfKitchens() {
        return numberOfKitchens;
    }

    /**
     * Sets the value of the numberOfKitchens property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfKitchens(String value) {
        this.numberOfKitchens = value;
    }

    /**
     * Gets the value of the numberOfBathrooms property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    /**
     * Sets the value of the numberOfBathrooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfBathrooms(String value) {
        this.numberOfBathrooms = value;
    }

    /**
     * Gets the value of the numberOfBedrooms property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    /**
     * Sets the value of the numberOfBedrooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfBedrooms(BigInteger value) {
        this.numberOfBedrooms = value;
    }

    /**
     * Gets the value of the numberOfDens property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfDens() {
        return numberOfDens;
    }

    /**
     * Sets the value of the numberOfDens property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfDens(BigInteger value) {
        this.numberOfDens = value;
    }

    /**
     * Gets the value of the garageNumberOfCars property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGarageNumberOfCars() {
        return garageNumberOfCars;
    }

    /**
     * Sets the value of the garageNumberOfCars property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGarageNumberOfCars(BigInteger value) {
        this.garageNumberOfCars = value;
    }

    /**
     * Gets the value of the commercialIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCommercialIndicator() {
        return commercialIndicator;
    }

    /**
     * Sets the value of the commercialIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCommercialIndicator(Boolean value) {
        this.commercialIndicator = value;
    }

    /**
     * Gets the value of the view property.
     * 
     * @return
     *     possible object is
     *     {@link ViewType }
     *     
     */
    public ViewType getView() {
        return view;
    }

    /**
     * Sets the value of the view property.
     * 
     * @param value
     *     allowed object is
     *     {@link ViewType }
     *     
     */
    public void setView(ViewType value) {
        this.view = value;
    }

    /**
     * Gets the value of the locker property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public BooleanWithUnknownType getLocker() {
        return locker;
    }

    /**
     * Sets the value of the locker property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public void setLocker(BooleanWithUnknownType value) {
        this.locker = value;
    }

    /**
     * Gets the value of the balcony property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public BooleanWithUnknownType getBalcony() {
        return balcony;
    }

    /**
     * Sets the value of the balcony property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public void setBalcony(BooleanWithUnknownType value) {
        this.balcony = value;
    }

}
