
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExposureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExposureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExposureDirection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExposureDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExposureType", propOrder = {
    "exposureDirection",
    "exposureDescription"
})
public class ExposureType {

    @XmlElement(name = "ExposureDirection")
    protected String exposureDirection;
    @XmlElement(name = "ExposureDescription")
    protected String exposureDescription;

    /**
     * Gets the value of the exposureDirection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExposureDirection() {
        return exposureDirection;
    }

    /**
     * Sets the value of the exposureDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExposureDirection(String value) {
        this.exposureDirection = value;
    }

    /**
     * Gets the value of the exposureDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExposureDescription() {
        return exposureDescription;
    }

    /**
     * Sets the value of the exposureDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExposureDescription(String value) {
        this.exposureDescription = value;
    }

}
