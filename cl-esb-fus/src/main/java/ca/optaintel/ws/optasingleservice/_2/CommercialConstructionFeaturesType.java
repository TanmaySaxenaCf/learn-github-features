
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialConstructionFeaturesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialConstructionFeaturesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="YearBuilt" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="BuildingUpdates" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BuildingUpdatesType" minOccurs="0"/>
 *         &lt;element name="TotalFloorArea" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="TotalFloorAreaUnitOfMeasurement" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}UnitOfAreaType" minOccurs="0"/>
 *         &lt;element name="NumberOfStoreys" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="FloorHeight" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="FloorHeightUnitOfMeasurement" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}UnitOfLengthType" minOccurs="0"/>
 *         &lt;element name="ConstructionClass" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ConstructionClassCodeType" minOccurs="0"/>
 *         &lt;element name="CombustibilityClass" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CombustibilityClassCodeType" minOccurs="0"/>
 *         &lt;element name="Basement" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialBasementType" minOccurs="0"/>
 *         &lt;element name="NumberOfUnits" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="ExteriorWallTypes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialExteriorWallTypes" minOccurs="0"/>
 *         &lt;element name="RoofAttributes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RoofAttributesType" minOccurs="0"/>
 *         &lt;element name="PlumbingTypes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialPlumbingType" minOccurs="0"/>
 *         &lt;element name="Heating" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialHeatingType" minOccurs="0"/>
 *         &lt;element name="WaterHeater" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialWaterHeaterType" minOccurs="0"/>
 *         &lt;element name="Wiring" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialWiringType" minOccurs="0"/>
 *         &lt;element name="Elevator" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ElevatorType" minOccurs="0"/>
 *         &lt;element name="Parking" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialParkingType" minOccurs="0"/>
 *         &lt;element name="LoadingDockPresent" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BooleanWithUnknownType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialConstructionFeaturesType", propOrder = {
    "yearBuilt",
    "buildingUpdates",
    "totalFloorArea",
    "totalFloorAreaUnitOfMeasurement",
    "numberOfStoreys",
    "floorHeight",
    "floorHeightUnitOfMeasurement",
    "constructionClass",
    "combustibilityClass",
    "basement",
    "numberOfUnits",
    "exteriorWallTypes",
    "roofAttributes",
    "plumbingTypes",
    "heating",
    "waterHeater",
    "wiring",
    "elevator",
    "parking",
    "loadingDockPresent"
})
public class CommercialConstructionFeaturesType {

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
    @XmlElement(name = "Basement")
    protected CommercialBasementType basement;
    @XmlElement(name = "NumberOfUnits")
    protected BigInteger numberOfUnits;
    @XmlElement(name = "ExteriorWallTypes")
    protected CommercialExteriorWallTypes exteriorWallTypes;
    @XmlElement(name = "RoofAttributes")
    protected RoofAttributesType roofAttributes;
    @XmlElement(name = "PlumbingTypes")
    protected CommercialPlumbingType plumbingTypes;
    @XmlElement(name = "Heating")
    protected CommercialHeatingType heating;
    @XmlElement(name = "WaterHeater")
    protected CommercialWaterHeaterType waterHeater;
    @XmlElement(name = "Wiring")
    protected CommercialWiringType wiring;
    @XmlElement(name = "Elevator")
    protected ElevatorType elevator;
    @XmlElement(name = "Parking")
    protected CommercialParkingType parking;
    @XmlElement(name = "LoadingDockPresent")
    @XmlSchemaType(name = "string")
    protected BooleanWithUnknownType loadingDockPresent;

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
     * Gets the value of the basement property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialBasementType }
     *     
     */
    public CommercialBasementType getBasement() {
        return basement;
    }

    /**
     * Sets the value of the basement property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialBasementType }
     *     
     */
    public void setBasement(CommercialBasementType value) {
        this.basement = value;
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
     * Gets the value of the exteriorWallTypes property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialExteriorWallTypes }
     *     
     */
    public CommercialExteriorWallTypes getExteriorWallTypes() {
        return exteriorWallTypes;
    }

    /**
     * Sets the value of the exteriorWallTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialExteriorWallTypes }
     *     
     */
    public void setExteriorWallTypes(CommercialExteriorWallTypes value) {
        this.exteriorWallTypes = value;
    }

    /**
     * Gets the value of the roofAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link RoofAttributesType }
     *     
     */
    public RoofAttributesType getRoofAttributes() {
        return roofAttributes;
    }

    /**
     * Sets the value of the roofAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoofAttributesType }
     *     
     */
    public void setRoofAttributes(RoofAttributesType value) {
        this.roofAttributes = value;
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
     * Gets the value of the heating property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialHeatingType }
     *     
     */
    public CommercialHeatingType getHeating() {
        return heating;
    }

    /**
     * Sets the value of the heating property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialHeatingType }
     *     
     */
    public void setHeating(CommercialHeatingType value) {
        this.heating = value;
    }

    /**
     * Gets the value of the waterHeater property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialWaterHeaterType }
     *     
     */
    public CommercialWaterHeaterType getWaterHeater() {
        return waterHeater;
    }

    /**
     * Sets the value of the waterHeater property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialWaterHeaterType }
     *     
     */
    public void setWaterHeater(CommercialWaterHeaterType value) {
        this.waterHeater = value;
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
     * Gets the value of the elevator property.
     * 
     * @return
     *     possible object is
     *     {@link ElevatorType }
     *     
     */
    public ElevatorType getElevator() {
        return elevator;
    }

    /**
     * Sets the value of the elevator property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElevatorType }
     *     
     */
    public void setElevator(ElevatorType value) {
        this.elevator = value;
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

    /**
     * Gets the value of the loadingDockPresent property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public BooleanWithUnknownType getLoadingDockPresent() {
        return loadingDockPresent;
    }

    /**
     * Sets the value of the loadingDockPresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public void setLoadingDockPresent(BooleanWithUnknownType value) {
        this.loadingDockPresent = value;
    }

}
