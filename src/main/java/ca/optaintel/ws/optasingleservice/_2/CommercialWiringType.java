
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialWiringType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialWiringType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WiringTypes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialWiringTypesType" minOccurs="0"/>
 *         &lt;element name="WiringPanelTypes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialWiringPanelTypesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialWiringType", propOrder = {
    "wiringTypes",
    "wiringPanelTypes"
})
public class CommercialWiringType {

    @XmlElement(name = "WiringTypes")
    protected CommercialWiringTypesType wiringTypes;
    @XmlElement(name = "WiringPanelTypes")
    protected CommercialWiringPanelTypesType wiringPanelTypes;

    /**
     * Gets the value of the wiringTypes property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialWiringTypesType }
     *     
     */
    public CommercialWiringTypesType getWiringTypes() {
        return wiringTypes;
    }

    /**
     * Sets the value of the wiringTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialWiringTypesType }
     *     
     */
    public void setWiringTypes(CommercialWiringTypesType value) {
        this.wiringTypes = value;
    }

    /**
     * Gets the value of the wiringPanelTypes property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialWiringPanelTypesType }
     *     
     */
    public CommercialWiringPanelTypesType getWiringPanelTypes() {
        return wiringPanelTypes;
    }

    /**
     * Sets the value of the wiringPanelTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialWiringPanelTypesType }
     *     
     */
    public void setWiringPanelTypes(CommercialWiringPanelTypesType value) {
        this.wiringPanelTypes = value;
    }

}
