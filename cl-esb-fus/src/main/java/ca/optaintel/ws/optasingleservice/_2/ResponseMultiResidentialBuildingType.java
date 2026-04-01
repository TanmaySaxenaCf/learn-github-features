
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseMultiResidentialBuildingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseMultiResidentialBuildingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BuildingFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseBuildingFeaturesType" minOccurs="0"/>
 *         &lt;element name="UnitFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseUnitFeaturesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseMultiResidentialBuildingType", propOrder = {
    "buildingFeatures",
    "unitFeatures"
})
public class ResponseMultiResidentialBuildingType {

    @XmlElement(name = "BuildingFeatures")
    protected ResponseBuildingFeaturesType buildingFeatures;
    @XmlElement(name = "UnitFeatures")
    protected ResponseUnitFeaturesType unitFeatures;

    /**
     * Gets the value of the buildingFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseBuildingFeaturesType }
     *     
     */
    public ResponseBuildingFeaturesType getBuildingFeatures() {
        return buildingFeatures;
    }

    /**
     * Sets the value of the buildingFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseBuildingFeaturesType }
     *     
     */
    public void setBuildingFeatures(ResponseBuildingFeaturesType value) {
        this.buildingFeatures = value;
    }

    /**
     * Gets the value of the unitFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseUnitFeaturesType }
     *     
     */
    public ResponseUnitFeaturesType getUnitFeatures() {
        return unitFeatures;
    }

    /**
     * Sets the value of the unitFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseUnitFeaturesType }
     *     
     */
    public void setUnitFeatures(ResponseUnitFeaturesType value) {
        this.unitFeatures = value;
    }

}
