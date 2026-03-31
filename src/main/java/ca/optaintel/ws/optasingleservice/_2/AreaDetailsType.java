
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AreaDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AreaDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AreaType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FloorLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AreaEstimated" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TotalAreaMetric" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="TotalAreaImperial" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="MezzanineHeightMetric" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="MezzanineHeightImperial" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AreaDetailsType", propOrder = {
    "areaType",
    "floorLevel",
    "areaEstimated",
    "totalAreaMetric",
    "totalAreaImperial",
    "mezzanineHeightMetric",
    "mezzanineHeightImperial"
})
public class AreaDetailsType {

    @XmlElement(name = "AreaType")
    protected String areaType;
    @XmlElement(name = "FloorLevel")
    protected String floorLevel;
    @XmlElement(name = "AreaEstimated")
    protected String areaEstimated;
    @XmlElement(name = "TotalAreaMetric")
    protected Float totalAreaMetric;
    @XmlElement(name = "TotalAreaImperial")
    protected Float totalAreaImperial;
    @XmlElement(name = "MezzanineHeightMetric")
    protected Float mezzanineHeightMetric;
    @XmlElement(name = "MezzanineHeightImperial")
    protected Float mezzanineHeightImperial;

    /**
     * Gets the value of the areaType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaType() {
        return areaType;
    }

    /**
     * Sets the value of the areaType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaType(String value) {
        this.areaType = value;
    }

    /**
     * Gets the value of the floorLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFloorLevel() {
        return floorLevel;
    }

    /**
     * Sets the value of the floorLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFloorLevel(String value) {
        this.floorLevel = value;
    }

    /**
     * Gets the value of the areaEstimated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaEstimated() {
        return areaEstimated;
    }

    /**
     * Sets the value of the areaEstimated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaEstimated(String value) {
        this.areaEstimated = value;
    }

    /**
     * Gets the value of the totalAreaMetric property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTotalAreaMetric() {
        return totalAreaMetric;
    }

    /**
     * Sets the value of the totalAreaMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTotalAreaMetric(Float value) {
        this.totalAreaMetric = value;
    }

    /**
     * Gets the value of the totalAreaImperial property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTotalAreaImperial() {
        return totalAreaImperial;
    }

    /**
     * Sets the value of the totalAreaImperial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTotalAreaImperial(Float value) {
        this.totalAreaImperial = value;
    }

    /**
     * Gets the value of the mezzanineHeightMetric property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMezzanineHeightMetric() {
        return mezzanineHeightMetric;
    }

    /**
     * Sets the value of the mezzanineHeightMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMezzanineHeightMetric(Float value) {
        this.mezzanineHeightMetric = value;
    }

    /**
     * Gets the value of the mezzanineHeightImperial property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMezzanineHeightImperial() {
        return mezzanineHeightImperial;
    }

    /**
     * Sets the value of the mezzanineHeightImperial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMezzanineHeightImperial(Float value) {
        this.mezzanineHeightImperial = value;
    }

}
