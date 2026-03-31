
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RequestMultiResidentialBuildingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestMultiResidentialBuildingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BuildingFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BuildingFeaturesType" minOccurs="0"/>
 *         &lt;element name="UnitFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}UnitFeaturesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestMultiResidentialBuildingType", propOrder = {
    "buildingFeatures",
    "unitFeatures"
})
public class RequestMultiResidentialBuildingType {

    @XmlElement(name = "BuildingFeatures")
    protected BuildingFeaturesType buildingFeatures;
    @XmlElement(name = "UnitFeatures")
    protected UnitFeaturesType unitFeatures;

    /**
     * Gets the value of the buildingFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link BuildingFeaturesType }
     *     
     */
    public BuildingFeaturesType getBuildingFeatures() {
        return buildingFeatures;
    }

    /**
     * Sets the value of the buildingFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link BuildingFeaturesType }
     *     
     */
    public void setBuildingFeatures(BuildingFeaturesType value) {
        this.buildingFeatures = value;
    }

    /**
     * Gets the value of the unitFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link UnitFeaturesType }
     *     
     */
    public UnitFeaturesType getUnitFeatures() {
        return unitFeatures;
    }

    /**
     * Sets the value of the unitFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitFeaturesType }
     *     
     */
    public void setUnitFeatures(UnitFeaturesType value) {
        this.unitFeatures = value;
    }

}
