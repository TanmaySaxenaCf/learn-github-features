
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialBuildingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialBuildingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StructureID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Industry" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BusinessIndustryType" minOccurs="0"/>
 *         &lt;element name="ConstructionFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}OptaCommercialConstructionFeaturesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialBuildingType", propOrder = {
    "structureID",
    "industry",
    "constructionFeatures"
})
public class CommercialBuildingType {

    @XmlElement(name = "StructureID")
    protected String structureID;
    @XmlElement(name = "Industry")
    protected BusinessIndustryType industry;
    @XmlElement(name = "ConstructionFeatures")
    protected OptaCommercialConstructionFeaturesType constructionFeatures;

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
     *     {@link OptaCommercialConstructionFeaturesType }
     *     
     */
    public OptaCommercialConstructionFeaturesType getConstructionFeatures() {
        return constructionFeatures;
    }

    /**
     * Sets the value of the constructionFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link OptaCommercialConstructionFeaturesType }
     *     
     */
    public void setConstructionFeatures(OptaCommercialConstructionFeaturesType value) {
        this.constructionFeatures = value;
    }

}
