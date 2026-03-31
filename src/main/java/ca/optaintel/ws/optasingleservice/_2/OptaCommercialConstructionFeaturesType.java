
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OptaCommercialConstructionFeaturesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OptaCommercialConstructionFeaturesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BuildingUse" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BuildingUseType" minOccurs="0"/>
 *         &lt;element name="YearBuilt" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="TotalFloorArea" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="TotalFloorAreaUnitOfMeasurement" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}UnitOfAreaType" minOccurs="0"/>
 *         &lt;element name="NumberOfStoreys" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="FloorHeight" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="FloorHeightUnitOfMeasurement" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}UnitOfLengthType" minOccurs="0"/>
 *         &lt;element name="ConstructionClass" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ConstructionClassCodeType" minOccurs="0"/>
 *         &lt;element name="AboveGradeStructureSupport" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AboveGradeStructureSupportType" minOccurs="0"/>
 *         &lt;element name="ExteriorWallTypes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialExteriorWallFinishType" minOccurs="0"/>
 *         &lt;element name="RoofAttributes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialRoofAttributesType" minOccurs="0"/>
 *         &lt;element name="FoundationAttributes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialFoundationAttributesType" minOccurs="0"/>
 *         &lt;element name="ElevatorCount" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="EscalatorCount" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Heating" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialHeatingAndAirType" minOccurs="0"/>
 *         &lt;element name="SecuritySystem" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BooleanWithUnknownType" minOccurs="0"/>
 *         &lt;element name="SprinklerSystem" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BooleanWithUnknownType" minOccurs="0"/>
 *         &lt;element name="FireAlarmSystem" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BooleanWithUnknownType" minOccurs="0"/>
 *         &lt;element name="AdditionalFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AdditionalFeaturesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OptaCommercialConstructionFeaturesType", propOrder = {
    "buildingUse",
    "yearBuilt",
    "totalFloorArea",
    "totalFloorAreaUnitOfMeasurement",
    "numberOfStoreys",
    "floorHeight",
    "floorHeightUnitOfMeasurement",
    "constructionClass",
    "aboveGradeStructureSupport",
    "exteriorWallTypes",
    "roofAttributes",
    "foundationAttributes",
    "elevatorCount",
    "escalatorCount",
    "heating",
    "securitySystem",
    "sprinklerSystem",
    "fireAlarmSystem",
    "additionalFeatures"
})
public class OptaCommercialConstructionFeaturesType {

    @XmlElement(name = "BuildingUse")
    @XmlSchemaType(name = "string")
    protected BuildingUseType buildingUse;
    @XmlElement(name = "YearBuilt")
    protected BigInteger yearBuilt;
    @XmlElement(name = "TotalFloorArea")
    protected BigInteger totalFloorArea;
    @XmlElement(name = "TotalFloorAreaUnitOfMeasurement")
    @XmlSchemaType(name = "string")
    protected UnitOfAreaType totalFloorAreaUnitOfMeasurement;
    @XmlElement(name = "NumberOfStoreys")
    protected BigInteger numberOfStoreys;
    @XmlElement(name = "FloorHeight")
    protected BigInteger floorHeight;
    @XmlElement(name = "FloorHeightUnitOfMeasurement")
    @XmlSchemaType(name = "string")
    protected UnitOfLengthType floorHeightUnitOfMeasurement;
    @XmlElement(name = "ConstructionClass")
    protected String constructionClass;
    @XmlElement(name = "AboveGradeStructureSupport")
    @XmlSchemaType(name = "string")
    protected AboveGradeStructureSupportType aboveGradeStructureSupport;
    @XmlElement(name = "ExteriorWallTypes")
    @XmlSchemaType(name = "string")
    protected CommercialExteriorWallFinishType exteriorWallTypes;
    @XmlElement(name = "RoofAttributes")
    protected CommercialRoofAttributesType roofAttributes;
    @XmlElement(name = "FoundationAttributes")
    protected CommercialFoundationAttributesType foundationAttributes;
    @XmlElement(name = "ElevatorCount")
    protected BigInteger elevatorCount;
    @XmlElement(name = "EscalatorCount")
    protected BigInteger escalatorCount;
    @XmlElement(name = "Heating")
    protected CommercialHeatingAndAirType heating;
    @XmlElement(name = "SecuritySystem")
    @XmlSchemaType(name = "string")
    protected BooleanWithUnknownType securitySystem;
    @XmlElement(name = "SprinklerSystem")
    @XmlSchemaType(name = "string")
    protected BooleanWithUnknownType sprinklerSystem;
    @XmlElement(name = "FireAlarmSystem")
    @XmlSchemaType(name = "string")
    protected BooleanWithUnknownType fireAlarmSystem;
    @XmlElement(name = "AdditionalFeatures")
    protected AdditionalFeaturesType additionalFeatures;

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
     * Gets the value of the totalFloorAreaUnitOfMeasurement property.
     * 
     * @return
     *     possible object is
     *     {@link UnitOfAreaType }
     *     
     */
    public UnitOfAreaType getTotalFloorAreaUnitOfMeasurement() {
        return totalFloorAreaUnitOfMeasurement;
    }

    /**
     * Sets the value of the totalFloorAreaUnitOfMeasurement property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitOfAreaType }
     *     
     */
    public void setTotalFloorAreaUnitOfMeasurement(UnitOfAreaType value) {
        this.totalFloorAreaUnitOfMeasurement = value;
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
     * Gets the value of the floorHeight property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFloorHeight() {
        return floorHeight;
    }

    /**
     * Sets the value of the floorHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFloorHeight(BigInteger value) {
        this.floorHeight = value;
    }

    /**
     * Gets the value of the floorHeightUnitOfMeasurement property.
     * 
     * @return
     *     possible object is
     *     {@link UnitOfLengthType }
     *     
     */
    public UnitOfLengthType getFloorHeightUnitOfMeasurement() {
        return floorHeightUnitOfMeasurement;
    }

    /**
     * Sets the value of the floorHeightUnitOfMeasurement property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitOfLengthType }
     *     
     */
    public void setFloorHeightUnitOfMeasurement(UnitOfLengthType value) {
        this.floorHeightUnitOfMeasurement = value;
    }

    /**
     * Gets the value of the constructionClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConstructionClass() {
        return constructionClass;
    }

    /**
     * Sets the value of the constructionClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConstructionClass(String value) {
        this.constructionClass = value;
    }

    /**
     * Gets the value of the aboveGradeStructureSupport property.
     * 
     * @return
     *     possible object is
     *     {@link AboveGradeStructureSupportType }
     *     
     */
    public AboveGradeStructureSupportType getAboveGradeStructureSupport() {
        return aboveGradeStructureSupport;
    }

    /**
     * Sets the value of the aboveGradeStructureSupport property.
     * 
     * @param value
     *     allowed object is
     *     {@link AboveGradeStructureSupportType }
     *     
     */
    public void setAboveGradeStructureSupport(AboveGradeStructureSupportType value) {
        this.aboveGradeStructureSupport = value;
    }

    /**
     * Gets the value of the exteriorWallTypes property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialExteriorWallFinishType }
     *     
     */
    public CommercialExteriorWallFinishType getExteriorWallTypes() {
        return exteriorWallTypes;
    }

    /**
     * Sets the value of the exteriorWallTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialExteriorWallFinishType }
     *     
     */
    public void setExteriorWallTypes(CommercialExteriorWallFinishType value) {
        this.exteriorWallTypes = value;
    }

    /**
     * Gets the value of the roofAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialRoofAttributesType }
     *     
     */
    public CommercialRoofAttributesType getRoofAttributes() {
        return roofAttributes;
    }

    /**
     * Sets the value of the roofAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialRoofAttributesType }
     *     
     */
    public void setRoofAttributes(CommercialRoofAttributesType value) {
        this.roofAttributes = value;
    }

    /**
     * Gets the value of the foundationAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialFoundationAttributesType }
     *     
     */
    public CommercialFoundationAttributesType getFoundationAttributes() {
        return foundationAttributes;
    }

    /**
     * Sets the value of the foundationAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialFoundationAttributesType }
     *     
     */
    public void setFoundationAttributes(CommercialFoundationAttributesType value) {
        this.foundationAttributes = value;
    }

    /**
     * Gets the value of the elevatorCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getElevatorCount() {
        return elevatorCount;
    }

    /**
     * Sets the value of the elevatorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setElevatorCount(BigInteger value) {
        this.elevatorCount = value;
    }

    /**
     * Gets the value of the escalatorCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEscalatorCount() {
        return escalatorCount;
    }

    /**
     * Sets the value of the escalatorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEscalatorCount(BigInteger value) {
        this.escalatorCount = value;
    }

    /**
     * Gets the value of the heating property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialHeatingAndAirType }
     *     
     */
    public CommercialHeatingAndAirType getHeating() {
        return heating;
    }

    /**
     * Sets the value of the heating property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialHeatingAndAirType }
     *     
     */
    public void setHeating(CommercialHeatingAndAirType value) {
        this.heating = value;
    }

    /**
     * Gets the value of the securitySystem property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public BooleanWithUnknownType getSecuritySystem() {
        return securitySystem;
    }

    /**
     * Sets the value of the securitySystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public void setSecuritySystem(BooleanWithUnknownType value) {
        this.securitySystem = value;
    }

    /**
     * Gets the value of the sprinklerSystem property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public BooleanWithUnknownType getSprinklerSystem() {
        return sprinklerSystem;
    }

    /**
     * Sets the value of the sprinklerSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public void setSprinklerSystem(BooleanWithUnknownType value) {
        this.sprinklerSystem = value;
    }

    /**
     * Gets the value of the fireAlarmSystem property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public BooleanWithUnknownType getFireAlarmSystem() {
        return fireAlarmSystem;
    }

    /**
     * Sets the value of the fireAlarmSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public void setFireAlarmSystem(BooleanWithUnknownType value) {
        this.fireAlarmSystem = value;
    }

    /**
     * Gets the value of the additionalFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalFeaturesType }
     *     
     */
    public AdditionalFeaturesType getAdditionalFeatures() {
        return additionalFeatures;
    }

    /**
     * Sets the value of the additionalFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalFeaturesType }
     *     
     */
    public void setAdditionalFeatures(AdditionalFeaturesType value) {
        this.additionalFeatures = value;
    }

}
