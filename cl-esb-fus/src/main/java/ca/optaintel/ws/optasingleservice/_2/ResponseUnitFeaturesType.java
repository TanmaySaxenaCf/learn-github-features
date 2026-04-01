
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseUnitFeaturesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseUnitFeaturesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FloorLevel" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="TotalFloorArea" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="NumberOfBedrooms" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumberOfBathrooms" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResidentialBathroomCountType" minOccurs="0"/>
 *         &lt;element name="ConstructionFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseResidentialConstructionFeaturesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseUnitFeaturesType", propOrder = {
    "floorLevel",
    "totalFloorArea",
    "numberOfBedrooms",
    "numberOfBathrooms",
    "constructionFeatures"
})
public class ResponseUnitFeaturesType {

    @XmlElement(name = "FloorLevel")
    protected BigInteger floorLevel;
    @XmlElement(name = "TotalFloorArea")
    protected BigInteger totalFloorArea;
    @XmlElement(name = "NumberOfBedrooms")
    protected String numberOfBedrooms;
    @XmlElement(name = "NumberOfBathrooms")
    protected String numberOfBathrooms;
    @XmlElement(name = "ConstructionFeatures")
    protected ResponseResidentialConstructionFeaturesType constructionFeatures;

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
     * Gets the value of the numberOfBedrooms property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    /**
     * Sets the value of the numberOfBedrooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfBedrooms(String value) {
        this.numberOfBedrooms = value;
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
     * Gets the value of the constructionFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseResidentialConstructionFeaturesType }
     *     
     */
    public ResponseResidentialConstructionFeaturesType getConstructionFeatures() {
        return constructionFeatures;
    }

    /**
     * Sets the value of the constructionFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseResidentialConstructionFeaturesType }
     *     
     */
    public void setConstructionFeatures(ResponseResidentialConstructionFeaturesType value) {
        this.constructionFeatures = value;
    }

}
