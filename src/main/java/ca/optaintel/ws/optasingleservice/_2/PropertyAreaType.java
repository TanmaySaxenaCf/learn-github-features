
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyAreaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyAreaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TotalFloorAreaType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TotalFloorAreaMetric" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="TotalFloorAreaImperial" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="SiteAreaMetric" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="SiteAreaImperial" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="GradeAreaMetric" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="GradeAreaImperial" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="EffectiveAreaMetric" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="EffectiveAreaImperial" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyAreaType", propOrder = {
    "totalFloorAreaType",
    "totalFloorAreaMetric",
    "totalFloorAreaImperial",
    "siteAreaMetric",
    "siteAreaImperial",
    "gradeAreaMetric",
    "gradeAreaImperial",
    "effectiveAreaMetric",
    "effectiveAreaImperial"
})
public class PropertyAreaType {

    @XmlElement(name = "TotalFloorAreaType")
    protected String totalFloorAreaType;
    @XmlElement(name = "TotalFloorAreaMetric")
    protected Float totalFloorAreaMetric;
    @XmlElement(name = "TotalFloorAreaImperial")
    protected Float totalFloorAreaImperial;
    @XmlElement(name = "SiteAreaMetric")
    protected Float siteAreaMetric;
    @XmlElement(name = "SiteAreaImperial")
    protected Float siteAreaImperial;
    @XmlElement(name = "GradeAreaMetric")
    protected Float gradeAreaMetric;
    @XmlElement(name = "GradeAreaImperial")
    protected Float gradeAreaImperial;
    @XmlElement(name = "EffectiveAreaMetric")
    protected Float effectiveAreaMetric;
    @XmlElement(name = "EffectiveAreaImperial")
    protected Float effectiveAreaImperial;

    /**
     * Gets the value of the totalFloorAreaType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalFloorAreaType() {
        return totalFloorAreaType;
    }

    /**
     * Sets the value of the totalFloorAreaType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalFloorAreaType(String value) {
        this.totalFloorAreaType = value;
    }

    /**
     * Gets the value of the totalFloorAreaMetric property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTotalFloorAreaMetric() {
        return totalFloorAreaMetric;
    }

    /**
     * Sets the value of the totalFloorAreaMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTotalFloorAreaMetric(Float value) {
        this.totalFloorAreaMetric = value;
    }

    /**
     * Gets the value of the totalFloorAreaImperial property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTotalFloorAreaImperial() {
        return totalFloorAreaImperial;
    }

    /**
     * Sets the value of the totalFloorAreaImperial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTotalFloorAreaImperial(Float value) {
        this.totalFloorAreaImperial = value;
    }

    /**
     * Gets the value of the siteAreaMetric property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSiteAreaMetric() {
        return siteAreaMetric;
    }

    /**
     * Sets the value of the siteAreaMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSiteAreaMetric(Float value) {
        this.siteAreaMetric = value;
    }

    /**
     * Gets the value of the siteAreaImperial property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSiteAreaImperial() {
        return siteAreaImperial;
    }

    /**
     * Sets the value of the siteAreaImperial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSiteAreaImperial(Float value) {
        this.siteAreaImperial = value;
    }

    /**
     * Gets the value of the gradeAreaMetric property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getGradeAreaMetric() {
        return gradeAreaMetric;
    }

    /**
     * Sets the value of the gradeAreaMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setGradeAreaMetric(Float value) {
        this.gradeAreaMetric = value;
    }

    /**
     * Gets the value of the gradeAreaImperial property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getGradeAreaImperial() {
        return gradeAreaImperial;
    }

    /**
     * Sets the value of the gradeAreaImperial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setGradeAreaImperial(Float value) {
        this.gradeAreaImperial = value;
    }

    /**
     * Gets the value of the effectiveAreaMetric property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getEffectiveAreaMetric() {
        return effectiveAreaMetric;
    }

    /**
     * Sets the value of the effectiveAreaMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setEffectiveAreaMetric(Float value) {
        this.effectiveAreaMetric = value;
    }

    /**
     * Gets the value of the effectiveAreaImperial property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getEffectiveAreaImperial() {
        return effectiveAreaImperial;
    }

    /**
     * Sets the value of the effectiveAreaImperial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setEffectiveAreaImperial(Float value) {
        this.effectiveAreaImperial = value;
    }

}
