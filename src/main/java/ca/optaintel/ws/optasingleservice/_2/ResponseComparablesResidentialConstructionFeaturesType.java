
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseComparablesResidentialConstructionFeaturesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseComparablesResidentialConstructionFeaturesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="YearBuilt" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}YearBuiltType" minOccurs="0"/>
 *         &lt;element name="SquareFootage" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}SquareFootageType" minOccurs="0"/>
 *         &lt;element name="ArchitecturalStyleType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ArchitecturalStyleType" minOccurs="0"/>
 *         &lt;element name="StoreyCount" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResidentialStoreyCountType" minOccurs="0"/>
 *         &lt;element name="NumberOfBedrooms" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="BathroomCount" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResidentialBathroomCountType" minOccurs="0"/>
 *         &lt;element name="ExteriorWallType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ExteriorWallType" minOccurs="0"/>
 *         &lt;element name="GarageType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}GarageType" minOccurs="0"/>
 *         &lt;element name="GarageNumberOfCars" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}GarageNumberOfCarsType" minOccurs="0"/>
 *         &lt;element name="LotSize" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="FinishedBasement" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FinishedBasementType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseComparablesResidentialConstructionFeaturesType", propOrder = {
    "yearBuilt",
    "squareFootage",
    "architecturalStyleType",
    "storeyCount",
    "numberOfBedrooms",
    "bathroomCount",
    "exteriorWallType",
    "garageType",
    "garageNumberOfCars",
    "lotSize",
    "finishedBasement"
})
public class ResponseComparablesResidentialConstructionFeaturesType {

    @XmlElement(name = "YearBuilt")
    protected String yearBuilt;
    @XmlElement(name = "SquareFootage")
    protected BigInteger squareFootage;
    @XmlElement(name = "ArchitecturalStyleType")
    @XmlSchemaType(name = "string")
    protected ArchitecturalStyleType architecturalStyleType;
    @XmlElement(name = "StoreyCount")
    protected String storeyCount;
    @XmlElement(name = "NumberOfBedrooms")
    protected BigInteger numberOfBedrooms;
    @XmlElement(name = "BathroomCount")
    protected String bathroomCount;
    @XmlElement(name = "ExteriorWallType")
    @XmlSchemaType(name = "string")
    protected ExteriorWallType exteriorWallType;
    @XmlElement(name = "GarageType")
    @XmlSchemaType(name = "string")
    protected GarageType garageType;
    @XmlElement(name = "GarageNumberOfCars")
    protected BigInteger garageNumberOfCars;
    @XmlElement(name = "LotSize")
    protected BigInteger lotSize;
    @XmlElement(name = "FinishedBasement")
    protected Boolean finishedBasement;

    /**
     * Gets the value of the yearBuilt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYearBuilt() {
        return yearBuilt;
    }

    /**
     * Sets the value of the yearBuilt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYearBuilt(String value) {
        this.yearBuilt = value;
    }

    /**
     * Gets the value of the squareFootage property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSquareFootage() {
        return squareFootage;
    }

    /**
     * Sets the value of the squareFootage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSquareFootage(BigInteger value) {
        this.squareFootage = value;
    }

    /**
     * Gets the value of the architecturalStyleType property.
     * 
     * @return
     *     possible object is
     *     {@link ArchitecturalStyleType }
     *     
     */
    public ArchitecturalStyleType getArchitecturalStyleType() {
        return architecturalStyleType;
    }

    /**
     * Sets the value of the architecturalStyleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArchitecturalStyleType }
     *     
     */
    public void setArchitecturalStyleType(ArchitecturalStyleType value) {
        this.architecturalStyleType = value;
    }

    /**
     * Gets the value of the storeyCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStoreyCount() {
        return storeyCount;
    }

    /**
     * Sets the value of the storeyCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStoreyCount(String value) {
        this.storeyCount = value;
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
     * Gets the value of the bathroomCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBathroomCount() {
        return bathroomCount;
    }

    /**
     * Sets the value of the bathroomCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBathroomCount(String value) {
        this.bathroomCount = value;
    }

    /**
     * Gets the value of the exteriorWallType property.
     * 
     * @return
     *     possible object is
     *     {@link ExteriorWallType }
     *     
     */
    public ExteriorWallType getExteriorWallType() {
        return exteriorWallType;
    }

    /**
     * Sets the value of the exteriorWallType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExteriorWallType }
     *     
     */
    public void setExteriorWallType(ExteriorWallType value) {
        this.exteriorWallType = value;
    }

    /**
     * Gets the value of the garageType property.
     * 
     * @return
     *     possible object is
     *     {@link GarageType }
     *     
     */
    public GarageType getGarageType() {
        return garageType;
    }

    /**
     * Sets the value of the garageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GarageType }
     *     
     */
    public void setGarageType(GarageType value) {
        this.garageType = value;
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
     * Gets the value of the finishedBasement property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFinishedBasement() {
        return finishedBasement;
    }

    /**
     * Sets the value of the finishedBasement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFinishedBasement(Boolean value) {
        this.finishedBasement = value;
    }

}
