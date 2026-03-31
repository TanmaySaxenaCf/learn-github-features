
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LightSpeedCommercialFoundationAttributesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LightSpeedCommercialFoundationAttributesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Material" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialFoundationMaterial" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialFoundationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LightSpeedCommercialFoundationAttributesType", propOrder = {
    "material",
    "type"
})
public class LightSpeedCommercialFoundationAttributesType {

    @XmlElement(name = "Material")
    @XmlSchemaType(name = "string")
    protected CommercialFoundationMaterial material;
    @XmlElement(name = "Type")
    @XmlSchemaType(name = "string")
    protected CommercialFoundationType type;

    /**
     * Gets the value of the material property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialFoundationMaterial }
     *     
     */
    public CommercialFoundationMaterial getMaterial() {
        return material;
    }

    /**
     * Sets the value of the material property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialFoundationMaterial }
     *     
     */
    public void setMaterial(CommercialFoundationMaterial value) {
        this.material = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialFoundationType }
     *     
     */
    public CommercialFoundationType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialFoundationType }
     *     
     */
    public void setType(CommercialFoundationType value) {
        this.type = value;
    }

}
