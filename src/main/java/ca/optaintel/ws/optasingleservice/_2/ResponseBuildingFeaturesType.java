
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseBuildingFeaturesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseBuildingFeaturesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PropertyType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}MultiResidentialPropertyType" minOccurs="0"/>
 *         &lt;element name="YearBuilt" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="NumberOfStoreys" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="ConstructionType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ConstructionType" minOccurs="0"/>
 *         &lt;element name="RoofType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RoofType" minOccurs="0"/>
 *         &lt;element name="HeatingType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PrimaryHeatingType" minOccurs="0"/>
 *         &lt;element name="StructureType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialStructureStyleType" minOccurs="0"/>
 *         &lt;element name="UnitCounts" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}UnitCountsType" minOccurs="0"/>
 *         &lt;element name="ConstructionFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialConstructionFeaturesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseBuildingFeaturesType", propOrder = {
    "propertyType",
    "yearBuilt",
    "numberOfStoreys",
    "constructionType",
    "roofType",
    "heatingType",
    "structureType",
    "unitCounts",
    "constructionFeatures"
})
public class ResponseBuildingFeaturesType {

    @XmlElement(name = "PropertyType")
    @XmlSchemaType(name = "string")
    protected MultiResidentialPropertyType propertyType;
    @XmlElement(name = "YearBuilt")
    protected BigInteger yearBuilt;
    @XmlElement(name = "NumberOfStoreys")
    protected BigInteger numberOfStoreys;
    @XmlElement(name = "ConstructionType")
    @XmlSchemaType(name = "string")
    protected ConstructionType constructionType;
    @XmlElement(name = "RoofType")
    @XmlSchemaType(name = "string")
    protected RoofType roofType;
    @XmlElement(name = "HeatingType")
    @XmlSchemaType(name = "string")
    protected PrimaryHeatingType heatingType;
    @XmlElement(name = "StructureType")
    @XmlSchemaType(name = "string")
    protected CommercialStructureStyleType structureType;
    @XmlElement(name = "UnitCounts")
    protected UnitCountsType unitCounts;
    @XmlElement(name = "ConstructionFeatures")
    protected CommercialConstructionFeaturesType constructionFeatures;

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

    /**
     * Gets the value of the unitCounts property.
     * 
     * @return
     *     possible object is
     *     {@link UnitCountsType }
     *     
     */
    public UnitCountsType getUnitCounts() {
        return unitCounts;
    }

    /**
     * Sets the value of the unitCounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitCountsType }
     *     
     */
    public void setUnitCounts(UnitCountsType value) {
        this.unitCounts = value;
    }

    /**
     * Gets the value of the constructionFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialConstructionFeaturesType }
     *     
     */
    public CommercialConstructionFeaturesType getConstructionFeatures() {
        return constructionFeatures;
    }

    /**
     * Sets the value of the constructionFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialConstructionFeaturesType }
     *     
     */
    public void setConstructionFeatures(CommercialConstructionFeaturesType value) {
        this.constructionFeatures = value;
    }

}
