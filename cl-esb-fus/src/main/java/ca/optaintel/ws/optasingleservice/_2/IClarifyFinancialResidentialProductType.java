
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for iClarifyFinancialResidentialProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="iClarifyFinancialResidentialProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="Property" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}iClarifyFinancialResidentialPropertyType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iClarifyFinancialResidentialProductType", propOrder = {
    "property"
})
public class IClarifyFinancialResidentialProductType
    extends BaseProductType
{

    @XmlElement(name = "Property", required = true)
    protected IClarifyFinancialResidentialPropertyType property;

    /**
     * Gets the value of the property property.
     * 
     * @return
     *     possible object is
     *     {@link IClarifyFinancialResidentialPropertyType }
     *     
     */
    public IClarifyFinancialResidentialPropertyType getProperty() {
        return property;
    }

    /**
     * Sets the value of the property property.
     * 
     * @param value
     *     allowed object is
     *     {@link IClarifyFinancialResidentialPropertyType }
     *     
     */
    public void setProperty(IClarifyFinancialResidentialPropertyType value) {
        this.property = value;
    }

}
