
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseComparablesCondoConstructionFeaturesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseComparablesCondoConstructionFeaturesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnitFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseComparablesCondoUnitFeaturesType" minOccurs="0"/>
 *         &lt;element name="BuildingFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseComparablesCondoBuildingFeaturesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseComparablesCondoConstructionFeaturesType", propOrder = {
    "unitFeatures",
    "buildingFeatures"
})
public class ResponseComparablesCondoConstructionFeaturesType {

    @XmlElement(name = "UnitFeatures")
    protected ResponseComparablesCondoUnitFeaturesType unitFeatures;
    @XmlElement(name = "BuildingFeatures")
    protected ResponseComparablesCondoBuildingFeaturesType buildingFeatures;

    /**
     * Gets the value of the unitFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseComparablesCondoUnitFeaturesType }
     *     
     */
    public ResponseComparablesCondoUnitFeaturesType getUnitFeatures() {
        return unitFeatures;
    }

    /**
     * Sets the value of the unitFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseComparablesCondoUnitFeaturesType }
     *     
     */
    public void setUnitFeatures(ResponseComparablesCondoUnitFeaturesType value) {
        this.unitFeatures = value;
    }

    /**
     * Gets the value of the buildingFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseComparablesCondoBuildingFeaturesType }
     *     
     */
    public ResponseComparablesCondoBuildingFeaturesType getBuildingFeatures() {
        return buildingFeatures;
    }

    /**
     * Sets the value of the buildingFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseComparablesCondoBuildingFeaturesType }
     *     
     */
    public void setBuildingFeatures(ResponseComparablesCondoBuildingFeaturesType value) {
        this.buildingFeatures = value;
    }

}
