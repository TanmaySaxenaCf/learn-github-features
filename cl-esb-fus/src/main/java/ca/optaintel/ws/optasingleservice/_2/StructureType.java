
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StructureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StructureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StructureIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnitLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StructureDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StructureParkName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StructureUse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RiskCondition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConstructureClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StructureAge" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}StructureAgeType" minOccurs="0"/>
 *         &lt;element name="StructureDimensions" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}StructureDimensionType" minOccurs="0"/>
 *         &lt;element name="AreaDetails" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AreaDetailsType" minOccurs="0"/>
 *         &lt;element name="SuiteMix" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}SuiteMixType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StructureType", propOrder = {
    "structureIdentifier",
    "unitLocation",
    "structureDescription",
    "structureParkName",
    "structureUse",
    "riskCondition",
    "constructureClass",
    "structureAge",
    "structureDimensions",
    "areaDetails",
    "suiteMix"
})
public class StructureType {

    @XmlElement(name = "StructureIdentifier")
    protected String structureIdentifier;
    @XmlElement(name = "UnitLocation")
    protected String unitLocation;
    @XmlElement(name = "StructureDescription")
    protected String structureDescription;
    @XmlElement(name = "StructureParkName")
    protected String structureParkName;
    @XmlElement(name = "StructureUse")
    protected String structureUse;
    @XmlElement(name = "RiskCondition")
    protected String riskCondition;
    @XmlElement(name = "ConstructureClass")
    protected String constructureClass;
    @XmlElement(name = "StructureAge")
    protected StructureAgeType structureAge;
    @XmlElement(name = "StructureDimensions")
    protected StructureDimensionType structureDimensions;
    @XmlElement(name = "AreaDetails")
    protected AreaDetailsType areaDetails;
    @XmlElement(name = "SuiteMix")
    protected SuiteMixType suiteMix;

    /**
     * Gets the value of the structureIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStructureIdentifier() {
        return structureIdentifier;
    }

    /**
     * Sets the value of the structureIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStructureIdentifier(String value) {
        this.structureIdentifier = value;
    }

    /**
     * Gets the value of the unitLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitLocation() {
        return unitLocation;
    }

    /**
     * Sets the value of the unitLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitLocation(String value) {
        this.unitLocation = value;
    }

    /**
     * Gets the value of the structureDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStructureDescription() {
        return structureDescription;
    }

    /**
     * Sets the value of the structureDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStructureDescription(String value) {
        this.structureDescription = value;
    }

    /**
     * Gets the value of the structureParkName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStructureParkName() {
        return structureParkName;
    }

    /**
     * Sets the value of the structureParkName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStructureParkName(String value) {
        this.structureParkName = value;
    }

    /**
     * Gets the value of the structureUse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStructureUse() {
        return structureUse;
    }

    /**
     * Sets the value of the structureUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStructureUse(String value) {
        this.structureUse = value;
    }

    /**
     * Gets the value of the riskCondition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRiskCondition() {
        return riskCondition;
    }

    /**
     * Sets the value of the riskCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRiskCondition(String value) {
        this.riskCondition = value;
    }

    /**
     * Gets the value of the constructureClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConstructureClass() {
        return constructureClass;
    }

    /**
     * Sets the value of the constructureClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConstructureClass(String value) {
        this.constructureClass = value;
    }

    /**
     * Gets the value of the structureAge property.
     * 
     * @return
     *     possible object is
     *     {@link StructureAgeType }
     *     
     */
    public StructureAgeType getStructureAge() {
        return structureAge;
    }

    /**
     * Sets the value of the structureAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link StructureAgeType }
     *     
     */
    public void setStructureAge(StructureAgeType value) {
        this.structureAge = value;
    }

    /**
     * Gets the value of the structureDimensions property.
     * 
     * @return
     *     possible object is
     *     {@link StructureDimensionType }
     *     
     */
    public StructureDimensionType getStructureDimensions() {
        return structureDimensions;
    }

    /**
     * Sets the value of the structureDimensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link StructureDimensionType }
     *     
     */
    public void setStructureDimensions(StructureDimensionType value) {
        this.structureDimensions = value;
    }

    /**
     * Gets the value of the areaDetails property.
     * 
     * @return
     *     possible object is
     *     {@link AreaDetailsType }
     *     
     */
    public AreaDetailsType getAreaDetails() {
        return areaDetails;
    }

    /**
     * Sets the value of the areaDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link AreaDetailsType }
     *     
     */
    public void setAreaDetails(AreaDetailsType value) {
        this.areaDetails = value;
    }

    /**
     * Gets the value of the suiteMix property.
     * 
     * @return
     *     possible object is
     *     {@link SuiteMixType }
     *     
     */
    public SuiteMixType getSuiteMix() {
        return suiteMix;
    }

    /**
     * Sets the value of the suiteMix property.
     * 
     * @param value
     *     allowed object is
     *     {@link SuiteMixType }
     *     
     */
    public void setSuiteMix(SuiteMixType value) {
        this.suiteMix = value;
    }

}
