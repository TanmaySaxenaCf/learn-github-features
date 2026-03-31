
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyHeightType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyHeightType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NumberOfStoreys" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="StoreyHeightMetric" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="StoreyHeightImperial" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="BuildingHeightMetric" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="BuildingHeightImperial" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyHeightType", propOrder = {
    "numberOfStoreys",
    "storeyHeightMetric",
    "storeyHeightImperial",
    "buildingHeightMetric",
    "buildingHeightImperial"
})
public class PropertyHeightType {

    @XmlElement(name = "NumberOfStoreys")
    protected float numberOfStoreys;
    @XmlElement(name = "StoreyHeightMetric")
    protected Float storeyHeightMetric;
    @XmlElement(name = "StoreyHeightImperial")
    protected Float storeyHeightImperial;
    @XmlElement(name = "BuildingHeightMetric")
    protected Float buildingHeightMetric;
    @XmlElement(name = "BuildingHeightImperial")
    protected Float buildingHeightImperial;

    /**
     * Gets the value of the numberOfStoreys property.
     * 
     */
    public float getNumberOfStoreys() {
        return numberOfStoreys;
    }

    /**
     * Sets the value of the numberOfStoreys property.
     * 
     */
    public void setNumberOfStoreys(float value) {
        this.numberOfStoreys = value;
    }

    /**
     * Gets the value of the storeyHeightMetric property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getStoreyHeightMetric() {
        return storeyHeightMetric;
    }

    /**
     * Sets the value of the storeyHeightMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setStoreyHeightMetric(Float value) {
        this.storeyHeightMetric = value;
    }

    /**
     * Gets the value of the storeyHeightImperial property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getStoreyHeightImperial() {
        return storeyHeightImperial;
    }

    /**
     * Sets the value of the storeyHeightImperial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setStoreyHeightImperial(Float value) {
        this.storeyHeightImperial = value;
    }

    /**
     * Gets the value of the buildingHeightMetric property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getBuildingHeightMetric() {
        return buildingHeightMetric;
    }

    /**
     * Sets the value of the buildingHeightMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setBuildingHeightMetric(Float value) {
        this.buildingHeightMetric = value;
    }

    /**
     * Gets the value of the buildingHeightImperial property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getBuildingHeightImperial() {
        return buildingHeightImperial;
    }

    /**
     * Sets the value of the buildingHeightImperial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setBuildingHeightImperial(Float value) {
        this.buildingHeightImperial = value;
    }

}
