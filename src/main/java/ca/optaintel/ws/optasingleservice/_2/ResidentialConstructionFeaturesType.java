
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResidentialConstructionFeaturesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResidentialConstructionFeaturesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="YearBuilt" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}YearBuiltType" minOccurs="0"/>
 *         &lt;element name="SquareFootage" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}SquareFootageType" minOccurs="0"/>
 *         &lt;element name="FoundationType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FoundationType" minOccurs="0"/>
 *         &lt;element name="ArchitecturalStyleType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ArchitecturalStyleType" minOccurs="0"/>
 *         &lt;element name="StoreyCount" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResidentialStoreyCountType" minOccurs="0"/>
 *         &lt;element name="KitchenCount" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResidentialKitchenCountType" minOccurs="0"/>
 *         &lt;element name="BathroomCount" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResidentialBathroomCountType" minOccurs="0"/>
 *         &lt;element name="ExteriorWallType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ExteriorWallType" minOccurs="0"/>
 *         &lt;element name="RoofType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RoofType" minOccurs="0"/>
 *         &lt;element name="FinishedBasement" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FinishedBasementType" minOccurs="0"/>
 *         &lt;element name="GarageType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}GarageType" minOccurs="0"/>
 *         &lt;element name="GarageNumberOfCars" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}GarageNumberOfCarsType" minOccurs="0"/>
 *         &lt;element name="SwimmingPoolType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}SwimmingPoolType" minOccurs="0"/>
 *         &lt;element name="PrimaryHeatingType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PrimaryHeatingType" minOccurs="0"/>
 *         &lt;element name="AuxiliaryHeatingType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AuxiliaryHeatingType" minOccurs="0"/>
 *         &lt;element name="PlumbingType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PlumbingType" minOccurs="0"/>
 *         &lt;element name="CommercialIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OutbuildingPresent" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BooleanWithUnknownType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResidentialConstructionFeaturesType", propOrder = {
    "yearBuilt",
    "squareFootage",
    "foundationType",
    "architecturalStyleType",
    "storeyCount",
    "kitchenCount",
    "bathroomCount",
    "exteriorWallType",
    "roofType",
    "finishedBasement",
    "garageType",
    "garageNumberOfCars",
    "swimmingPoolType",
    "primaryHeatingType",
    "auxiliaryHeatingType",
    "plumbingType",
    "commercialIndicator",
    "outbuildingPresent"
})
public class ResidentialConstructionFeaturesType {

    @XmlElement(name = "YearBuilt")
    protected String yearBuilt;
    @XmlElement(name = "SquareFootage")
    protected BigInteger squareFootage;
    @XmlElement(name = "FoundationType")
    @XmlSchemaType(name = "string")
    protected FoundationType foundationType;
    @XmlElement(name = "ArchitecturalStyleType")
    @XmlSchemaType(name = "string")
    protected ArchitecturalStyleType architecturalStyleType;
    @XmlElement(name = "StoreyCount")
    protected String storeyCount;
    @XmlElement(name = "KitchenCount")
    protected String kitchenCount;
    @XmlElement(name = "BathroomCount")
    protected String bathroomCount;
    @XmlElement(name = "ExteriorWallType")
    @XmlSchemaType(name = "string")
    protected ExteriorWallType exteriorWallType;
    @XmlElement(name = "RoofType")
    @XmlSchemaType(name = "string")
    protected RoofType roofType;
    @XmlElement(name = "FinishedBasement")
    protected Boolean finishedBasement;
    @XmlElement(name = "GarageType")
    @XmlSchemaType(name = "string")
    protected GarageType garageType;
    @XmlElement(name = "GarageNumberOfCars")
    protected BigInteger garageNumberOfCars;
    @XmlElement(name = "SwimmingPoolType")
    @XmlSchemaType(name = "string")
    protected SwimmingPoolType swimmingPoolType;
    @XmlElement(name = "PrimaryHeatingType")
    @XmlSchemaType(name = "string")
    protected PrimaryHeatingType primaryHeatingType;
    @XmlElement(name = "AuxiliaryHeatingType")
    @XmlSchemaType(name = "string")
    protected AuxiliaryHeatingType auxiliaryHeatingType;
    @XmlElement(name = "PlumbingType")
    @XmlSchemaType(name = "string")
    protected PlumbingType plumbingType;
    @XmlElement(name = "CommercialIndicator")
    protected Boolean commercialIndicator;
    @XmlElement(name = "OutbuildingPresent")
    @XmlSchemaType(name = "string")
    protected BooleanWithUnknownType outbuildingPresent;

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
     * Gets the value of the foundationType property.
     * 
     * @return
     *     possible object is
     *     {@link FoundationType }
     *     
     */
    public FoundationType getFoundationType() {
        return foundationType;
    }

    /**
     * Sets the value of the foundationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link FoundationType }
     *     
     */
    public void setFoundationType(FoundationType value) {
        this.foundationType = value;
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
     * Gets the value of the kitchenCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKitchenCount() {
        return kitchenCount;
    }

    /**
     * Sets the value of the kitchenCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKitchenCount(String value) {
        this.kitchenCount = value;
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
     * Gets the value of the roofType property.
     * 
     * @return
     *     possible object is
     *     {@link RoofType }
     *     
     */
    public RoofType getRoofType() {
        return roofType;
    }

    /**
     * Sets the value of the roofType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoofType }
     *     
     */
    public void setRoofType(RoofType value) {
        this.roofType = value;
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
     * Gets the value of the swimmingPoolType property.
     * 
     * @return
     *     possible object is
     *     {@link SwimmingPoolType }
     *     
     */
    public SwimmingPoolType getSwimmingPoolType() {
        return swimmingPoolType;
    }

    /**
     * Sets the value of the swimmingPoolType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SwimmingPoolType }
     *     
     */
    public void setSwimmingPoolType(SwimmingPoolType value) {
        this.swimmingPoolType = value;
    }

    /**
     * Gets the value of the primaryHeatingType property.
     * 
     * @return
     *     possible object is
     *     {@link PrimaryHeatingType }
     *     
     */
    public PrimaryHeatingType getPrimaryHeatingType() {
        return primaryHeatingType;
    }

    /**
     * Sets the value of the primaryHeatingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrimaryHeatingType }
     *     
     */
    public void setPrimaryHeatingType(PrimaryHeatingType value) {
        this.primaryHeatingType = value;
    }

    /**
     * Gets the value of the auxiliaryHeatingType property.
     * 
     * @return
     *     possible object is
     *     {@link AuxiliaryHeatingType }
     *     
     */
    public AuxiliaryHeatingType getAuxiliaryHeatingType() {
        return auxiliaryHeatingType;
    }

    /**
     * Sets the value of the auxiliaryHeatingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuxiliaryHeatingType }
     *     
     */
    public void setAuxiliaryHeatingType(AuxiliaryHeatingType value) {
        this.auxiliaryHeatingType = value;
    }

    /**
     * Gets the value of the plumbingType property.
     * 
     * @return
     *     possible object is
     *     {@link PlumbingType }
     *     
     */
    public PlumbingType getPlumbingType() {
        return plumbingType;
    }

    /**
     * Sets the value of the plumbingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlumbingType }
     *     
     */
    public void setPlumbingType(PlumbingType value) {
        this.plumbingType = value;
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
     * Gets the value of the outbuildingPresent property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public BooleanWithUnknownType getOutbuildingPresent() {
        return outbuildingPresent;
    }

    /**
     * Sets the value of the outbuildingPresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public void setOutbuildingPresent(BooleanWithUnknownType value) {
        this.outbuildingPresent = value;
    }

}
