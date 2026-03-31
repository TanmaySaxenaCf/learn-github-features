
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialPropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PropertyType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertyType" minOccurs="0"/>
 *         &lt;element name="Industry" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BusinessIndustryType" minOccurs="0"/>
 *         &lt;element name="LotSize" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="LotSizeUnitOfMeasurement" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}UnitOfAreaType" minOccurs="0"/>
 *         &lt;element name="Buildings" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BuildingsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialPropertyType", propOrder = {
    "propertyType",
    "industry",
    "lotSize",
    "lotSizeUnitOfMeasurement",
    "buildings"
})
public class CommercialPropertyType {

    @XmlElement(name = "PropertyType")
    @XmlSchemaType(name = "string")
    protected PropertyType propertyType;
    @XmlElement(name = "Industry")
    protected BusinessIndustryType industry;
    @XmlElement(name = "LotSize")
    protected BigInteger lotSize;
    @XmlElement(name = "LotSizeUnitOfMeasurement")
    @XmlSchemaType(name = "string")
    protected UnitOfAreaType lotSizeUnitOfMeasurement;
    @XmlElement(name = "Buildings")
    protected BuildingsType buildings;

    /**
     * Gets the value of the propertyType property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyType }
     *     
     */
    public PropertyType getPropertyType() {
        return propertyType;
    }

    /**
     * Sets the value of the propertyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyType }
     *     
     */
    public void setPropertyType(PropertyType value) {
        this.propertyType = value;
    }

    /**
     * Gets the value of the industry property.
     * 
     * @return
     *     possible object is
     *     {@link BusinessIndustryType }
     *     
     */
    public BusinessIndustryType getIndustry() {
        return industry;
    }

    /**
     * Sets the value of the industry property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessIndustryType }
     *     
     */
    public void setIndustry(BusinessIndustryType value) {
        this.industry = value;
    }

    /**
     * Gets the value of the lotSize property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLotSize() {
        return lotSize;
    }

    /**
     * Sets the value of the lotSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLotSize(BigInteger value) {
        this.lotSize = value;
    }

    /**
     * Gets the value of the lotSizeUnitOfMeasurement property.
     * 
     * @return
     *     possible object is
     *     {@link UnitOfAreaType }
     *     
     */
    public UnitOfAreaType getLotSizeUnitOfMeasurement() {
        return lotSizeUnitOfMeasurement;
    }

    /**
     * Sets the value of the lotSizeUnitOfMeasurement property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitOfAreaType }
     *     
     */
    public void setLotSizeUnitOfMeasurement(UnitOfAreaType value) {
        this.lotSizeUnitOfMeasurement = value;
    }

    /**
     * Gets the value of the buildings property.
     * 
     * @return
     *     possible object is
     *     {@link BuildingsType }
     *     
     */
    public BuildingsType getBuildings() {
        return buildings;
    }

    /**
     * Sets the value of the buildings property.
     * 
     * @param value
     *     allowed object is
     *     {@link BuildingsType }
     *     
     */
    public void setBuildings(BuildingsType value) {
        this.buildings = value;
    }

}
