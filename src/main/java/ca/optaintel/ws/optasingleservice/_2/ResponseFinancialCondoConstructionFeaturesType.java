
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseFinancialCondoConstructionFeaturesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseFinancialCondoConstructionFeaturesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnitFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseCondoUnitFeaturesType" minOccurs="0"/>
 *         &lt;element name="BuildingFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseCondoBuildingFeaturesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseFinancialCondoConstructionFeaturesType", propOrder = {
    "unitFeatures",
    "buildingFeatures"
})
public class ResponseFinancialCondoConstructionFeaturesType {

    @XmlElement(name = "UnitFeatures")
    protected ResponseCondoUnitFeaturesType unitFeatures;
    @XmlElement(name = "BuildingFeatures")
    protected ResponseCondoBuildingFeaturesType buildingFeatures;

    /**
     * Gets the value of the unitFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCondoUnitFeaturesType }
     *     
     */
    public ResponseCondoUnitFeaturesType getUnitFeatures() {
        return unitFeatures;
    }

    /**
     * Sets the value of the unitFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCondoUnitFeaturesType }
     *     
     */
    public void setUnitFeatures(ResponseCondoUnitFeaturesType value) {
        this.unitFeatures = value;
    }

    /**
     * Gets the value of the buildingFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCondoBuildingFeaturesType }
     *     
     */
    public ResponseCondoBuildingFeaturesType getBuildingFeatures() {
        return buildingFeatures;
    }

    /**
     * Sets the value of the buildingFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCondoBuildingFeaturesType }
     *     
     */
    public void setBuildingFeatures(ResponseCondoBuildingFeaturesType value) {
        this.buildingFeatures = value;
    }

}
