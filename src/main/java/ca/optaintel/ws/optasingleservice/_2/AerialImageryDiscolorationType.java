
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AerialImageryDiscolorationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AerialImageryDiscolorationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryRoofConditionReportItemType">
 *       &lt;sequence>
 *         &lt;element name="Types" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryDiscolorationTypesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AerialImageryDiscolorationType", propOrder = {
    "types"
})
public class AerialImageryDiscolorationType
    extends AerialImageryRoofConditionReportItemType
{

    @XmlElement(name = "Types")
    protected AerialImageryDiscolorationTypesType types;

    /**
     * Gets the value of the types property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryDiscolorationTypesType }
     *     
     */
    public AerialImageryDiscolorationTypesType getTypes() {
        return types;
    }

    /**
     * Sets the value of the types property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryDiscolorationTypesType }
     *     
     */
    public void setTypes(AerialImageryDiscolorationTypesType value) {
        this.types = value;
    }

}
