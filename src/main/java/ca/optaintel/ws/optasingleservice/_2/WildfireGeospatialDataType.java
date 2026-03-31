
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WildfireGeospatialDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WildfireGeospatialDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SlopeDirectionCode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}SlopeDirectionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WildfireGeospatialDataType", propOrder = {
    "slopeDirectionCode"
})
public class WildfireGeospatialDataType {

    @XmlElement(name = "SlopeDirectionCode")
    @XmlSchemaType(name = "string")
    protected SlopeDirectionType slopeDirectionCode;

    /**
     * Gets the value of the slopeDirectionCode property.
     * 
     * @return
     *     possible object is
     *     {@link SlopeDirectionType }
     *     
     */
    public SlopeDirectionType getSlopeDirectionCode() {
        return slopeDirectionCode;
    }

    /**
     * Sets the value of the slopeDirectionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link SlopeDirectionType }
     *     
     */
    public void setSlopeDirectionCode(SlopeDirectionType value) {
        this.slopeDirectionCode = value;
    }

}
