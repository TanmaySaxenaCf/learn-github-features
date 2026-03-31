
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AerialImageryPropertyFeaturesPoolType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AerialImageryPropertyFeaturesPoolType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesPoolItemType">
 *       &lt;sequence>
 *         &lt;element name="Types" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesPoolTypesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AerialImageryPropertyFeaturesPoolType", propOrder = {
    "types"
})
public class AerialImageryPropertyFeaturesPoolType
    extends AerialImageryPropertyFeaturesPoolItemType
{

    @XmlElement(name = "Types")
    protected AerialImageryPropertyFeaturesPoolTypesType types;

    /**
     * Gets the value of the types property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesPoolTypesType }
     *     
     */
    public AerialImageryPropertyFeaturesPoolTypesType getTypes() {
        return types;
    }

    /**
     * Sets the value of the types property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesPoolTypesType }
     *     
     */
    public void setTypes(AerialImageryPropertyFeaturesPoolTypesType value) {
        this.types = value;
    }

}
