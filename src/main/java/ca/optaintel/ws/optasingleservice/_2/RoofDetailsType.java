
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoofDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoofDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoofType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoofSurface" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoofConstruction" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RoofConstructionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoofDetailsType", propOrder = {
    "roofType",
    "roofSurface",
    "roofConstruction"
})
public class RoofDetailsType {

    @XmlElement(name = "RoofType")
    protected String roofType;
    @XmlElement(name = "RoofSurface")
    protected String roofSurface;
    @XmlElement(name = "RoofConstruction", required = true)
    protected RoofConstructionType roofConstruction;

    /**
     * Gets the value of the roofType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoofType() {
        return roofType;
    }

    /**
     * Sets the value of the roofType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoofType(String value) {
        this.roofType = value;
    }

    /**
     * Gets the value of the roofSurface property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoofSurface() {
        return roofSurface;
    }

    /**
     * Sets the value of the roofSurface property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoofSurface(String value) {
        this.roofSurface = value;
    }

    /**
     * Gets the value of the roofConstruction property.
     * 
     * @return
     *     possible object is
     *     {@link RoofConstructionType }
     *     
     */
    public RoofConstructionType getRoofConstruction() {
        return roofConstruction;
    }

    /**
     * Sets the value of the roofConstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoofConstructionType }
     *     
     */
    public void setRoofConstruction(RoofConstructionType value) {
        this.roofConstruction = value;
    }

}
