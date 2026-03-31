
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExteriorWallsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExteriorWallsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExteriorWallType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExteriorWallTypePercentage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExteriorWallsType", propOrder = {
    "exteriorWallType",
    "exteriorWallTypePercentage"
})
public class ExteriorWallsType {

    @XmlElement(name = "ExteriorWallType")
    protected String exteriorWallType;
    @XmlElement(name = "ExteriorWallTypePercentage")
    protected String exteriorWallTypePercentage;

    /**
     * Gets the value of the exteriorWallType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExteriorWallType() {
        return exteriorWallType;
    }

    /**
     * Sets the value of the exteriorWallType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExteriorWallType(String value) {
        this.exteriorWallType = value;
    }

    /**
     * Gets the value of the exteriorWallTypePercentage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExteriorWallTypePercentage() {
        return exteriorWallTypePercentage;
    }

    /**
     * Sets the value of the exteriorWallTypePercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExteriorWallTypePercentage(String value) {
        this.exteriorWallTypePercentage = value;
    }

}
