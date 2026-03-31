
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BuildingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BuildingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StructureID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConstructionFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialConstructionFeaturesType" minOccurs="0"/>
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
@XmlType(name = "BuildingType", propOrder = {
    "structureID",
    "constructionFeatures",
    "protection"
})
public class BuildingType {

    @XmlElement(name = "StructureID")
    protected String structureID;
    @XmlElement(name = "ConstructionFeatures")
    protected CommercialConstructionFeaturesType constructionFeatures;
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
