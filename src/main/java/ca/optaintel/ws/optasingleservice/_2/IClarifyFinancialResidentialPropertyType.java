
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for iClarifyFinancialResidentialPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="iClarifyFinancialResidentialPropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PropertyType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertyType"/>
 *         &lt;choice>
 *           &lt;element name="ResidentialBuilding" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseFinancialResidentialConstructionFeaturesType"/>
 *           &lt;element name="MultiResidentialBuilding" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseFinancialCondoConstructionFeaturesType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iClarifyFinancialResidentialPropertyType", propOrder = {
    "propertyType",
    "residentialBuilding",
    "multiResidentialBuilding"
})
public class IClarifyFinancialResidentialPropertyType {

    @XmlElement(name = "PropertyType", required = true)
    @XmlSchemaType(name = "string")
    protected PropertyType propertyType;
    @XmlElement(name = "ResidentialBuilding")
    protected ResponseFinancialResidentialConstructionFeaturesType residentialBuilding;
    @XmlElement(name = "MultiResidentialBuilding")
    protected ResponseFinancialCondoConstructionFeaturesType multiResidentialBuilding;

    /**
     * Gets the value of the propertyType property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyType }
     *     
     */
    public PropertyType getPropertyType() {
        return propertyType;
    }

    /**
     * Sets the value of the propertyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyType }
     *     
     */
    public void setPropertyType(PropertyType value) {
        this.propertyType = value;
    }

    /**
     * Gets the value of the residentialBuilding property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseFinancialResidentialConstructionFeaturesType }
     *     
     */
    public ResponseFinancialResidentialConstructionFeaturesType getResidentialBuilding() {
        return residentialBuilding;
    }

    /**
     * Sets the value of the residentialBuilding property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseFinancialResidentialConstructionFeaturesType }
     *     
     */
    public void setResidentialBuilding(ResponseFinancialResidentialConstructionFeaturesType value) {
        this.residentialBuilding = value;
    }

    /**
     * Gets the value of the multiResidentialBuilding property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseFinancialCondoConstructionFeaturesType }
     *     
     */
    public ResponseFinancialCondoConstructionFeaturesType getMultiResidentialBuilding() {
        return multiResidentialBuilding;
    }

    /**
     * Sets the value of the multiResidentialBuilding property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseFinancialCondoConstructionFeaturesType }
     *     
     */
    public void setMultiResidentialBuilding(ResponseFinancialCondoConstructionFeaturesType value) {
        this.multiResidentialBuilding = value;
    }

}
