
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BuildingFeaturesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BuildingFeaturesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BuildingUse" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BuildingUseType" minOccurs="0"/>
 *         &lt;element name="YearBuilt" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="MultiResidentialStyleType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}MultiResidentialStyleType" minOccurs="0"/>
 *         &lt;element name="NumberOfStoreys" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="ExteriorWallType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialExteriorWallType" minOccurs="0"/>
 *         &lt;element name="RoofSurface" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialRoofSurfaceType" minOccurs="0"/>
 *         &lt;element name="HeatingTypes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialHeatingTypeType" minOccurs="0"/>
 *         &lt;element name="PlumbingType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialPlumbingTypeType" minOccurs="0"/>
 *         &lt;element name="ParkingType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialParkingTypeType" minOccurs="0"/>
 *         &lt;element name="SewageType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}SewageType" minOccurs="0"/>
 *         &lt;element name="WaterType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}WaterType" minOccurs="0"/>
 *         &lt;element name="PropertyType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}MultiResidentialPropertyType" minOccurs="0"/>
 *         &lt;element name="RoofType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RoofType" minOccurs="0"/>
 *         &lt;element name="HeatingType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PrimaryHeatingType" minOccurs="0"/>
 *         &lt;element name="ConstructionType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ConstructionType" minOccurs="0"/>
 *         &lt;element name="StructureType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialStructureStyleType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BuildingFeaturesType", propOrder = {
    "buildingUse",
    "yearBuilt",
    "multiResidentialStyleType",
    "numberOfStoreys",
    "exteriorWallType",
    "roofSurface",
    "heatingTypes",
    "plumbingType",
    "parkingType",
    "sewageType",
    "waterType",
    "propertyType",
    "roofType",
    "heatingType",
    "constructionType",
    "structureType"
})
public class BuildingFeaturesType {

    @XmlElement(name = "BuildingUse")
    @XmlSchemaType(name = "string")
    protected BuildingUseType buildingUse;
    @XmlElement(name = "YearBuilt")
    protected BigInteger yearBuilt;
    @XmlElement(name = "MultiResidentialStyleType")
    @XmlSchemaType(name = "string")
    protected MultiResidentialStyleType multiResidentialStyleType;
    @XmlElement(name = "NumberOfStoreys")
    protected BigInteger numberOfStoreys;
    @XmlElement(name = "ExteriorWallType")
    @XmlSchemaType(name = "string")
    protected CommercialExteriorWallType exteriorWallType;
    @XmlElement(name = "RoofSurface")
    @XmlSchemaType(name = "string")
    protected CommercialRoofSurfaceType roofSurface;
    @XmlElement(name = "HeatingTypes")
    @XmlSchemaType(name = "string")
    protected CommercialHeatingTypeType heatingTypes;
    @XmlElement(name = "PlumbingType")
    @XmlSchemaType(name = "string")
    protected CommercialPlumbingTypeType plumbingType;
    @XmlElement(name = "ParkingType")
    @XmlSchemaType(name = "string")
    protected CommercialParkingTypeType parkingType;
    @XmlElement(name = "SewageType")
    @XmlSchemaType(name = "string")
    protected SewageType sewageType;
    @XmlElement(name = "WaterType")
    @XmlSchemaType(name = "string")
    protected WaterType waterType;
    @XmlElement(name = "PropertyType")
    @XmlSchemaType(name = "string")
    protected MultiResidentialPropertyType propertyType;
    @XmlElement(name = "RoofType")
    @XmlSchemaType(name = "string")
    protected RoofType roofType;
    @XmlElement(name = "HeatingType")
    @XmlSchemaType(name = "string")
    protected PrimaryHeatingType heatingType;
    @XmlElement(name = "ConstructionType")
    @XmlSchemaType(name = "string")
    protected ConstructionType constructionType;
    @XmlElement(name = "StructureType")
    @XmlSchemaType(name = "string")
    protected CommercialStructureStyleType structureType;

    /**
     * Gets the value of the buildingUse property.
     * 
     * @return
     *     possible object is
     *     {@link BuildingUseType }
     *     
     */
    public BuildingUseType getBuildingUse() {
        return buildingUse;
    }

    /**
     * Sets the value of the buildingUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BuildingUseType }
     *     
     */
    public void setBuildingUse(BuildingUseType value) {
        this.buildingUse = value;
    }

    /**
     * Gets the value of the yearBuilt property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getYearBuilt() {
        return yearBuilt;
    }

    /**
     * Sets the value of the yearBuilt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setYearBuilt(BigInteger value) {
        this.yearBuilt = value;
    }

    /**
     * Gets the value of the multiResidentialStyleType property.
     * 
     * @return
     *     possible object is
     *     {@link MultiResidentialStyleType }
     *     
     */
    public MultiResidentialStyleType getMultiResidentialStyleType() {
        return multiResidentialStyleType;
    }

    /**
     * Sets the value of the multiResidentialStyleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiResidentialStyleType }
     *     
     */
    public void setMultiResidentialStyleType(MultiResidentialStyleType value) {
        this.multiResidentialStyleType = value;
    }

    /**
     * Gets the value of the numberOfStoreys property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfStoreys() {
        return numberOfStoreys;
    }

    /**
     * Sets the value of the numberOfStoreys property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfStoreys(BigInteger value) {
        this.numberOfStoreys = value;
    }

    /**
     * Gets the value of the exteriorWallType property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialExteriorWallType }
     *     
     */
    public CommercialExteriorWallType getExteriorWallType() {
        return exteriorWallType;
    }

    /**
     * Sets the value of the exteriorWallType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialExteriorWallType }
     *     
     */
    public void setExteriorWallType(CommercialExteriorWallType value) {
        this.exteriorWallType = value;
    }

    /**
     * Gets the value of the roofSurface property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialRoofSurfaceType }
     *     
     */
    public CommercialRoofSurfaceType getRoofSurface() {
        return roofSurface;
    }

    /**
     * Sets the value of the roofSurface property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialRoofSurfaceType }
     *     
     */
    public void setRoofSurface(CommercialRoofSurfaceType value) {
        this.roofSurface = value;
    }

    /**
     * Gets the value of the heatingTypes property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialHeatingTypeType }
     *     
     */
    public CommercialHeatingTypeType getHeatingTypes() {
        return heatingTypes;
    }

    /**
     * Sets the value of the heatingTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialHeatingTypeType }
     *     
     */
    public void setHeatingTypes(CommercialHeatingTypeType value) {
        this.heatingTypes = value;
    }

    /**
     * Gets the value of the plumbingType property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialPlumbingTypeType }
     *     
     */
    public CommercialPlumbingTypeType getPlumbingType() {
        return plumbingType;
    }

    /**
     * Sets the value of the plumbingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialPlumbingTypeType }
     *     
     */
    public void setPlumbingType(CommercialPlumbingTypeType value) {
        this.plumbingType = value;
    }

    /**
     * Gets the value of the parkingType property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialParkingTypeType }
     *     
     */
    public CommercialParkingTypeType getParkingType() {
        return parkingType;
    }

    /**
     * Sets the value of the parkingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialParkingTypeType }
     *     
     */
    public void setParkingType(CommercialParkingTypeType value) {
        this.parkingType = value;
    }

    /**
     * Gets the value of the sewageType property.
     * 
     * @return
     *     possible object is
     *     {@link SewageType }
     *     
     */
    public SewageType getSewageType() {
        return sewageType;
    }

    /**
     * Sets the value of the sewageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SewageType }
     *     
     */
    public void setSewageType(SewageType value) {
        this.sewageType = value;
    }

    /**
     * Gets the value of the waterType property.
     * 
     * @return
     *     possible object is
     *     {@link WaterType }
     *     
     */
    public WaterType getWaterType() {
        return waterType;
    }

    /**
     * Sets the value of the waterType property.
     * 
     * @param value
     *     allowed object is
     *     {@link WaterType }
     *     
     */
    public void setWaterType(WaterType value) {
        this.waterType = value;
    }

    /**
     * Gets the value of the propertyType property.
     * 
     * @return
     *     possible object is
     *     {@link MultiResidentialPropertyType }
     *     
     */
    public MultiResidentialPropertyType getPropertyType() {
        return propertyType;
    }

    /**
     * Sets the value of the propertyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiResidentialPropertyType }
     *     
     */
    public void setPropertyType(MultiResidentialPropertyType value) {
        this.propertyType = value;
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
     * Gets the value of the heatingType property.
     * 
     * @return
     *     possible object is
     *     {@link PrimaryHeatingType }
     *     
     */
    public PrimaryHeatingType getHeatingType() {
        return heatingType;
    }

    /**
     * Sets the value of the heatingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrimaryHeatingType }
     *     
     */
    public void setHeatingType(PrimaryHeatingType value) {
        this.heatingType = value;
    }

    /**
     * Gets the value of the constructionType property.
     * 
     * @return
     *     possible object is
     *     {@link ConstructionType }
     *     
     */
    public ConstructionType getConstructionType() {
        return constructionType;
    }

    /**
     * Sets the value of the constructionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConstructionType }
     *     
     */
    public void setConstructionType(ConstructionType value) {
        this.constructionType = value;
    }

    /**
     * Gets the value of the structureType property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialStructureStyleType }
     *     
     */
    public CommercialStructureStyleType getStructureType() {
        return structureType;
    }

    /**
     * Sets the value of the structureType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialStructureStyleType }
     *     
     */
    public void setStructureType(CommercialStructureStyleType value) {
        this.structureType = value;
    }

}
