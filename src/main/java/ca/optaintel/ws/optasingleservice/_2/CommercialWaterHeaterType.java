
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialWaterHeaterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialWaterHeaterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WaterHeaterType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialWaterHeaterTypeType" minOccurs="0"/>
 *         &lt;element name="WaterHeaterFuelType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialFuelSourceType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialWaterHeaterType", propOrder = {
    "waterHeaterType",
    "waterHeaterFuelType"
})
public class CommercialWaterHeaterType {

    @XmlElement(name = "WaterHeaterType")
    @XmlSchemaType(name = "string")
    protected CommercialWaterHeaterTypeType waterHeaterType;
    @XmlElement(name = "WaterHeaterFuelType")
    @XmlSchemaType(name = "string")
    protected CommercialFuelSourceType waterHeaterFuelType;

    /**
     * Gets the value of the waterHeaterType property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialWaterHeaterTypeType }
     *     
     */
    public CommercialWaterHeaterTypeType getWaterHeaterType() {
        return waterHeaterType;
    }

    /**
     * Sets the value of the waterHeaterType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialWaterHeaterTypeType }
     *     
     */
    public void setWaterHeaterType(CommercialWaterHeaterTypeType value) {
        this.waterHeaterType = value;
    }

    /**
     * Gets the value of the waterHeaterFuelType property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialFuelSourceType }
     *     
     */
    public CommercialFuelSourceType getWaterHeaterFuelType() {
        return waterHeaterFuelType;
    }

    /**
     * Sets the value of the waterHeaterFuelType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialFuelSourceType }
     *     
     */
    public void setWaterHeaterFuelType(CommercialFuelSourceType value) {
        this.waterHeaterFuelType = value;
    }

}
