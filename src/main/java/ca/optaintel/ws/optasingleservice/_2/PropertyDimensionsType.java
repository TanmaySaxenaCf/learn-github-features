
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyDimensionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyDimensionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PropertyArea" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertyAreaType" minOccurs="0"/>
 *         &lt;element name="PropertyHeight" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertyHeightType" minOccurs="0"/>
 *         &lt;element name="Basement" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BasementType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyDimensionsType", propOrder = {
    "propertyArea",
    "propertyHeight",
    "basement"
})
public class PropertyDimensionsType {

    @XmlElement(name = "PropertyArea")
    protected PropertyAreaType propertyArea;
    @XmlElement(name = "PropertyHeight")
    protected PropertyHeightType propertyHeight;
    @XmlElement(name = "Basement")
    protected BasementType basement;

    /**
     * Gets the value of the propertyArea property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyAreaType }
     *     
     */
    public PropertyAreaType getPropertyArea() {
        return propertyArea;
    }

    /**
     * Sets the value of the propertyArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyAreaType }
     *     
     */
    public void setPropertyArea(PropertyAreaType value) {
        this.propertyArea = value;
    }

    /**
     * Gets the value of the propertyHeight property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyHeightType }
     *     
     */
    public PropertyHeightType getPropertyHeight() {
        return propertyHeight;
    }

    /**
     * Sets the value of the propertyHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyHeightType }
     *     
     */
    public void setPropertyHeight(PropertyHeightType value) {
        this.propertyHeight = value;
    }

    /**
     * Gets the value of the basement property.
     * 
     * @return
     *     possible object is
     *     {@link BasementType }
     *     
     */
    public BasementType getBasement() {
        return basement;
    }

    /**
     * Sets the value of the basement property.
     * 
     * @param value
     *     allowed object is
     *     {@link BasementType }
     *     
     */
    public void setBasement(BasementType value) {
        this.basement = value;
    }

}
