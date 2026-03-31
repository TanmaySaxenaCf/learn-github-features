
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActualCashValueProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActualCashValueProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="Property" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ActualCashValuePropertyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActualCashValueProductType", propOrder = {
    "property"
})
public class ActualCashValueProductType
    extends BaseProductType
{

    @XmlElement(name = "Property")
    protected ActualCashValuePropertyType property;

    /**
     * Gets the value of the property property.
     * 
     * @return
     *     possible object is
     *     {@link ActualCashValuePropertyType }
     *     
     */
    public ActualCashValuePropertyType getProperty() {
        return property;
    }

    /**
     * Sets the value of the property property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActualCashValuePropertyType }
     *     
     */
    public void setProperty(ActualCashValuePropertyType value) {
        this.property = value;
    }

}
