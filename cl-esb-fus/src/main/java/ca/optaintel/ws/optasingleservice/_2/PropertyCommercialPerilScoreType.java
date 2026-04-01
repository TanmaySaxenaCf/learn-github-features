
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyCommercialPerilScoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyCommercialPerilScoreType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialPerilScoreType">
 *       &lt;sequence>
 *         &lt;element name="PerilType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertyCommercialPerilType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyCommercialPerilScoreType", propOrder = {
    "perilType"
})
public class PropertyCommercialPerilScoreType
    extends CommercialPerilScoreType
{

    @XmlElement(name = "PerilType", required = true)
    @XmlSchemaType(name = "string")
    protected PropertyCommercialPerilType perilType;

    /**
     * Gets the value of the perilType property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyCommercialPerilType }
     *     
     */
    public PropertyCommercialPerilType getPerilType() {
        return perilType;
    }

    /**
     * Sets the value of the perilType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyCommercialPerilType }
     *     
     */
    public void setPerilType(PropertyCommercialPerilType value) {
        this.perilType = value;
    }

}
