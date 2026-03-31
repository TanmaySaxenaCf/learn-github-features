
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LightSpeedCommercialBuildingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LightSpeedCommercialBuildingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StructureID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Industry" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BusinessIndustryType" minOccurs="0"/>
 *         &lt;element name="ConstructionFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}LightSpeedCommercialConstructionFeaturesType" minOccurs="0"/>
 *         &lt;element name="Valuation" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}LightSpeedCommercialValuationType" minOccurs="0"/>
 *         &lt;element name="Protection" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ProtectionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LightSpeedCommercialBuildingType", propOrder = {
    "structureID",
    "industry",
    "constructionFeatures",
    "valuation",
    "protection"
})
public class LightSpeedCommercialBuildingType {

    @XmlElement(name = "StructureID")
    protected String structureID;
    @XmlElement(name = "Industry")
    protected BusinessIndustryType industry;
    @XmlElement(name = "ConstructionFeatures")
    protected LightSpeedCommercialConstructionFeaturesType constructionFeatures;
    @XmlElement(name = "Valuation")
    protected LightSpeedCommercialValuationType valuation;
    @XmlElement(name = "Protection")
    protected ProtectionType protection;

    /**
     * Gets the value of the structureID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStructureID() {
        return structureID;
    }

    /**
     * Sets the value of the structureID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStructureID(String value) {
        this.structureID = value;
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
     * Gets the value of the constructionFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link LightSpeedCommercialConstructionFeaturesType }
     *     
     */
    public LightSpeedCommercialConstructionFeaturesType getConstructionFeatures() {
        return constructionFeatures;
    }

    /**
     * Sets the value of the constructionFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link LightSpeedCommercialConstructionFeaturesType }
     *     
     */
    public void setConstructionFeatures(LightSpeedCommercialConstructionFeaturesType value) {
        this.constructionFeatures = value;
    }

    /**
     * Gets the value of the valuation property.
     * 
     * @return
     *     possible object is
     *     {@link LightSpeedCommercialValuationType }
     *     
     */
    public LightSpeedCommercialValuationType getValuation() {
        return valuation;
    }

    /**
     * Sets the value of the valuation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LightSpeedCommercialValuationType }
     *     
     */
    public void setValuation(LightSpeedCommercialValuationType value) {
        this.valuation = value;
    }

    /**
     * Gets the value of the protection property.
     * 
     * @return
     *     possible object is
     *     {@link ProtectionType }
     *     
     */
    public ProtectionType getProtection() {
        return protection;
    }

    /**
     * Sets the value of the protection property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProtectionType }
     *     
     */
    public void setProtection(ProtectionType value) {
        this.protection = value;
    }

}
