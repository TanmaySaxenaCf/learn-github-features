
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoofConstructionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoofConstructionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoofDeck" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoofDeckPercentage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoofConstructionType", propOrder = {
    "roofDeck",
    "roofDeckPercentage"
})
public class RoofConstructionType {

    @XmlElement(name = "RoofDeck")
    protected String roofDeck;
    @XmlElement(name = "RoofDeckPercentage")
    protected String roofDeckPercentage;

    /**
     * Gets the value of the roofDeck property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoofDeck() {
        return roofDeck;
    }

    /**
     * Sets the value of the roofDeck property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoofDeck(String value) {
        this.roofDeck = value;
    }

    /**
     * Gets the value of the roofDeckPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoofDeckPercentage() {
        return roofDeckPercentage;
    }

    /**
     * Sets the value of the roofDeckPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoofDeckPercentage(String value) {
        this.roofDeckPercentage = value;
    }

}
