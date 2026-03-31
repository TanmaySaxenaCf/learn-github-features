
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LightSpeedCommercialRoofAttributesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LightSpeedCommercialRoofAttributesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Structure" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialRoofStructureType" minOccurs="0"/>
 *         &lt;element name="Material" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialRoofMaterialType" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialRoofType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LightSpeedCommercialRoofAttributesType", propOrder = {
    "structure",
    "material",
    "type"
})
public class LightSpeedCommercialRoofAttributesType {

    @XmlElement(name = "Structure")
    @XmlSchemaType(name = "string")
    protected CommercialRoofStructureType structure;
    @XmlElement(name = "Material")
    @XmlSchemaType(name = "string")
    protected CommercialRoofMaterialType material;
    @XmlElement(name = "Type")
    @XmlSchemaType(name = "string")
    protected CommercialRoofType type;

    /**
     * Gets the value of the structure property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialRoofStructureType }
     *     
     */
    public CommercialRoofStructureType getStructure() {
        return structure;
    }

    /**
     * Sets the value of the structure property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialRoofStructureType }
     *     
     */
    public void setStructure(CommercialRoofStructureType value) {
        this.structure = value;
    }

    /**
     * Gets the value of the material property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialRoofMaterialType }
     *     
     */
    public CommercialRoofMaterialType getMaterial() {
        return material;
    }

    /**
     * Sets the value of the material property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialRoofMaterialType }
     *     
     */
    public void setMaterial(CommercialRoofMaterialType value) {
        this.material = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialRoofType }
     *     
     */
    public CommercialRoofType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialRoofType }
     *     
     */
    public void setType(CommercialRoofType value) {
        this.type = value;
    }

}
