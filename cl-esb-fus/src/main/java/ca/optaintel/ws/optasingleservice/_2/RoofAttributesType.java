
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoofAttributesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoofAttributesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoofConstructions" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialRoofConstructionsType" minOccurs="0"/>
 *         &lt;element name="RoofSurfaces" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialRoofSurfacesType" minOccurs="0"/>
 *         &lt;element name="RoofTypes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialRoofTypesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoofAttributesType", propOrder = {
    "roofConstructions",
    "roofSurfaces",
    "roofTypes"
})
public class RoofAttributesType {

    @XmlElement(name = "RoofConstructions")
    protected CommercialRoofConstructionsType roofConstructions;
    @XmlElement(name = "RoofSurfaces")
    protected CommercialRoofSurfacesType roofSurfaces;
    @XmlElement(name = "RoofTypes")
    protected CommercialRoofTypesType roofTypes;

    /**
     * Gets the value of the roofConstructions property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialRoofConstructionsType }
     *     
     */
    public CommercialRoofConstructionsType getRoofConstructions() {
        return roofConstructions;
    }

    /**
     * Sets the value of the roofConstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialRoofConstructionsType }
     *     
     */
    public void setRoofConstructions(CommercialRoofConstructionsType value) {
        this.roofConstructions = value;
    }

    /**
     * Gets the value of the roofSurfaces property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialRoofSurfacesType }
     *     
     */
    public CommercialRoofSurfacesType getRoofSurfaces() {
        return roofSurfaces;
    }

    /**
     * Sets the value of the roofSurfaces property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialRoofSurfacesType }
     *     
     */
    public void setRoofSurfaces(CommercialRoofSurfacesType value) {
        this.roofSurfaces = value;
    }

    /**
     * Gets the value of the roofTypes property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialRoofTypesType }
     *     
     */
    public CommercialRoofTypesType getRoofTypes() {
        return roofTypes;
    }

    /**
     * Sets the value of the roofTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialRoofTypesType }
     *     
     */
    public void setRoofTypes(CommercialRoofTypesType value) {
        this.roofTypes = value;
    }

}
