
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StructureDimensionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StructureDimensionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NumberOfStoreys" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="StoreyHeightMetric" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="StoreyHeightImperial" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="PerimeterMetric" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="PerimeterImperial" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StructureDimensionType", propOrder = {
    "numberOfStoreys",
    "storeyHeightMetric",
    "storeyHeightImperial",
    "perimeterMetric",
    "perimeterImperial"
})
public class StructureDimensionType {

    @XmlElement(name = "NumberOfStoreys")
    protected Float numberOfStoreys;
    @XmlElement(name = "StoreyHeightMetric")
    protected Float storeyHeightMetric;
    @XmlElement(name = "StoreyHeightImperial")
    protected Float storeyHeightImperial;
    @XmlElement(name = "PerimeterMetric")
    protected Float perimeterMetric;
    @XmlElement(name = "PerimeterImperial")
    protected Float perimeterImperial;

    /**
     * Gets the value of the numberOfStoreys property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getNumberOfStoreys() {
        return numberOfStoreys;
    }

    /**
     * Sets the value of the numberOfStoreys property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setNumberOfStoreys(Float value) {
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
     * Gets the value of the perimeterMetric property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPerimeterMetric() {
        return perimeterMetric;
    }

    /**
     * Sets the value of the perimeterMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPerimeterMetric(Float value) {
        this.perimeterMetric = value;
    }

    /**
     * Gets the value of the perimeterImperial property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPerimeterImperial() {
        return perimeterImperial;
    }

    /**
     * Sets the value of the perimeterImperial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPerimeterImperial(Float value) {
        this.perimeterImperial = value;
    }

}
