
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LightSpeedCommercialConstructionFeaturesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LightSpeedCommercialConstructionFeaturesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BuildingUse" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BuildingUseType" minOccurs="0"/>
 *         &lt;element name="YearBuilt" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="BuildingUpdates" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BuildingUpdatesType" minOccurs="0"/>
 *         &lt;element name="TotalFloorArea" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="TotalFloorAreaUnitOfMeasurement" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}UnitOfAreaType" minOccurs="0"/>
 *         &lt;element name="NumberOfStoreys" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="NumberOfUnits" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="FloorHeight" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="FloorHeightUnitOfMeasurement" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}UnitOfLengthType" minOccurs="0"/>
 *         &lt;element name="ConstructionClass" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ConstructionClassCodeType" minOccurs="0"/>
 *         &lt;element name="CombustibilityClass" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CombustibilityClassCodeType" minOccurs="0"/>
 *         &lt;element name="AboveGradeStructureSupport" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AboveGradeStructureSupportType" minOccurs="0"/>
 *         &lt;element name="ExteriorWallTypes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialExteriorWallFinishType" minOccurs="0"/>
 *         &lt;element name="RoofAttributes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}LightSpeedCommercialRoofAttributesType" minOccurs="0"/>
 *         &lt;element name="FoundationAttributes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}LightSpeedCommercialFoundationAttributesType" minOccurs="0"/>
 *         &lt;element name="ElevatorCount" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="EscalatorCount" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="HeatingFuelType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialHeatingType" minOccurs="0"/>
 *         &lt;element name="Heating" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}LightSpeedCommercialHeatingAndAirType" minOccurs="0"/>
 *         &lt;element name="SecuritySystem" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BooleanWithUnknownType" minOccurs="0"/>
 *         &lt;element name="SprinklerSystem" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BooleanWithUnknownType" minOccurs="0"/>
 *         &lt;element name="FireAlarmSystem" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BooleanWithUnknownType" minOccurs="0"/>
 *         &lt;element name="AdditionalFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}LightSpeedCommercialAdditionalFeaturesType" minOccurs="0"/>
 *         &lt;element name="PlumbingTypes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialPlumbingType" minOccurs="0"/>
 *         &lt;element name="Wiring" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialWiringType" minOccurs="0"/>
 *         &lt;element name="Parking" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialParkingType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LightSpeedCommercialConstructionFeaturesType", propOrder = {
    "buildingUse",
    "yearBuilt",
    "buildingUpdates",
    "totalFloorArea",
    "totalFloorAreaUnitOfMeasurement",
    "numberOfStoreys",
    "numberOfUnits",
    "floorHeight",
    "floorHeightUnitOfMeasurement",
    "constructionClass",
    "combustibilityClass",
    "aboveGradeStructureSupport",
    "exteriorWallTypes",
    "roofAttributes",
    "foundationAttributes",
    "elevatorCount",
    "escalatorCount",
    "heatingFuelType",
    "heating",
    "securitySystem",
    "sprinklerSystem",
    "fireAlarmSystem",
    "additionalFeatures",
    "plumbingTypes",
    "wiring",
    "parking"
})
public class LightSpeedCommercialConstructionFeaturesType {

    @XmlElement(name = "BuildingUse")
    @XmlSchemaType(name = "string")
    protected BuildingUseType buildingUse;
    @XmlElement(name = "YearBuilt")
    protected BigInteger yearBuilt;
    @XmlElement(name = "BuildingUpdates")
    protected BuildingUpdatesType buildingUpdates;
    @XmlElement(name = "TotalFloorArea")
    protected BigInteger totalFloorArea;
    @XmlElement(name = "TotalFloorAreaUnitOfMeasurement")
    @XmlSchemaType(name = "string")
    protected UnitOfAreaType totalFloorAreaUnitOfMeasurement;
    @XmlElement(name = "NumberOfStoreys")
    protected BigInteger numberOfStoreys;
    @XmlElement(name = "NumberOfUnits")
    protected BigInteger numberOfUnits;
    @XmlElement(name = "FloorHeight")
    protected BigInteger floorHeight;
    @XmlElement(name = "FloorHeightUnitOfMeasurement")
    @XmlSchemaType(name = "string")
    protected UnitOfLengthType floorHeightUnitOfMeasurement;
    @XmlElement(name = "ConstructionClass")
    protected String constructionClass;
    @XmlElement(name = "CombustibilityClass")
    @XmlSchemaType(name = "string")
    protected CombustibilityClassCodeType combustibilityClass;
    @XmlElement(name = "AboveGradeStructureSupport")
    @XmlSchemaType(name = "string")
    protected AboveGradeStructureSupportType aboveGradeStructureSupport;
    @XmlElement(name = "ExteriorWallTypes")
    @XmlSchemaType(name = "string")
    protected CommercialExteriorWallFinishType exteriorWallTypes;
    @XmlElement(name = "RoofAttributes")
    protected LightSpeedCommercialRoofAttributesType roofAttributes;
    @XmlElement(name = "FoundationAttributes")
    protected LightSpeedCommercialFoundationAttributesType foundationAttributes;
    @XmlElement(name = "ElevatorCount")
    protected BigInteger elevatorCount;
    @XmlElement(name = "EscalatorCount")
    protected BigInteger escalatorCount;
    @XmlElement(name = "HeatingFuelType")
    protected CommercialHeatingType heatingFuelType;
    @XmlElement(name = "Heating")
    protected LightSpeedCommercialHeatingAndAirType heating;
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
    protected LightSpeedCommercialAdditionalFeaturesType additionalFeatures;
    @XmlElement(name = "PlumbingTypes")
    protected CommercialPlumbingType plumbingTypes;
    @XmlElement(name = "Wiring")
    protected CommercialWiringType wiring;
    @XmlElement(name = "Parking")
    protected CommercialParkingType parking;

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
     * Gets the value of the buildingUpdates property.
     * 
     * @return
     *     possible object is
     *     {@link BuildingUpdatesType }
     *     
     */
    public BuildingUpdatesType getBuildingUpdates() {
        return buildingUpdates;
    }

    /**
     * Sets the value of the buildingUpdates property.
     * 
     * @param value
     *     allowed object is
     *     {@link BuildingUpdatesType }
     *     
     */
    public void setBuildingUpdates(BuildingUpdatesType value) {
        this.buildingUpdates = value;
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
     * Gets the value of the numberOfUnits property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfUnits() {
        return numberOfUnits;
    }

    /**
     * Sets the value of the numberOfUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfUnits(BigInteger value) {
        this.numberOfUnits = value;
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
     * Gets the value of the combustibilityClass property.
     * 
     * @return
     *     possible object is
     *     {@link CombustibilityClassCodeType }
     *     
     */
    public CombustibilityClassCodeType getCombustibilityClass() {
        return combustibilityClass;
    }

    /**
     * Sets the value of the combustibilityClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link CombustibilityClassCodeType }
     *     
     */
    public void setCombustibilityClass(CombustibilityClassCodeType value) {
        this.combustibilityClass = value;
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
     *     {@link LightSpeedCommercialRoofAttributesType }
     *     
     */
    public LightSpeedCommercialRoofAttributesType getRoofAttributes() {
        return roofAttributes;
    }

    /**
     * Sets the value of the roofAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link LightSpeedCommercialRoofAttributesType }
     *     
     */
    public void setRoofAttributes(LightSpeedCommercialRoofAttributesType value) {
        this.roofAttributes = value;
    }

    /**
     * Gets the value of the foundationAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link LightSpeedCommercialFoundationAttributesType }
     *     
     */
    public LightSpeedCommercialFoundationAttributesType getFoundationAttributes() {
        return foundationAttributes;
    }

    /**
     * Sets the value of the foundationAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link LightSpeedCommercialFoundationAttributesType }
     *     
     */
    public void setFoundationAttributes(LightSpeedCommercialFoundationAttributesType value) {
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
     * Gets the value of the heatingFuelType property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialHeatingType }
     *     
     */
    public CommercialHeatingType getHeatingFuelType() {
        return heatingFuelType;
    }

    /**
     * Sets the value of the heatingFuelType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialHeatingType }
     *     
     */
    public void setHeatingFuelType(CommercialHeatingType value) {
        this.heatingFuelType = value;
    }

    /**
     * Gets the value of the heating property.
     * 
     * @return
     *     possible object is
     *     {@link LightSpeedCommercialHeatingAndAirType }
     *     
     */
    public LightSpeedCommercialHeatingAndAirType getHeating() {
        return heating;
    }

    /**
     * Sets the value of the heating property.
     * 
     * @param value
     *     allowed object is
     *     {@link LightSpeedCommercialHeatingAndAirType }
     *     
     */
    public void setHeating(LightSpeedCommercialHeatingAndAirType value) {
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
     *     {@link LightSpeedCommercialAdditionalFeaturesType }
     *     
     */
    public LightSpeedCommercialAdditionalFeaturesType getAdditionalFeatures() {
        return additionalFeatures;
    }

    /**
     * Sets the value of the additionalFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link LightSpeedCommercialAdditionalFeaturesType }
     *     
     */
    public void setAdditionalFeatures(LightSpeedCommercialAdditionalFeaturesType value) {
        this.additionalFeatures = value;
    }

    /**
     * Gets the value of the plumbingTypes property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialPlumbingType }
     *     
     */
    public CommercialPlumbingType getPlumbingTypes() {
        return plumbingTypes;
    }

    /**
     * Sets the value of the plumbingTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialPlumbingType }
     *     
     */
    public void setPlumbingTypes(CommercialPlumbingType value) {
        this.plumbingTypes = value;
    }

    /**
     * Gets the value of the wiring property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialWiringType }
     *     
     */
    public CommercialWiringType getWiring() {
        return wiring;
    }

    /**
     * Sets the value of the wiring property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialWiringType }
     *     
     */
    public void setWiring(CommercialWiringType value) {
        this.wiring = value;
    }

    /**
     * Gets the value of the parking property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialParkingType }
     *     
     */
    public CommercialParkingType getParking() {
        return parking;
    }

    /**
     * Sets the value of the parking property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialParkingType }
     *     
     */
    public void setParking(CommercialParkingType value) {
        this.parking = value;
    }

}
