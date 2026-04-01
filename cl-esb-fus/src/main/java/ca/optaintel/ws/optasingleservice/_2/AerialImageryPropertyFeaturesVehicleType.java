
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AerialImageryPropertyFeaturesVehicleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AerialImageryPropertyFeaturesVehicleType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesVehicleItemType">
 *       &lt;sequence>
 *         &lt;element name="Types" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesVehicleTypesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AerialImageryPropertyFeaturesVehicleType", propOrder = {
    "types"
})
public class AerialImageryPropertyFeaturesVehicleType
    extends AerialImageryPropertyFeaturesVehicleItemType
{

    @XmlElement(name = "Types")
    protected AerialImageryPropertyFeaturesVehicleTypesType types;

    /**
     * Gets the value of the types property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesVehicleTypesType }
     *     
     */
    public AerialImageryPropertyFeaturesVehicleTypesType getTypes() {
        return types;
    }

    /**
     * Sets the value of the types property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesVehicleTypesType }
     *     
     */
    public void setTypes(AerialImageryPropertyFeaturesVehicleTypesType value) {
        this.types = value;
    }

}
