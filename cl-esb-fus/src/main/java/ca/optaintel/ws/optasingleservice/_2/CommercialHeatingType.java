
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialHeatingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialHeatingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HeatingTypes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialHeatingTypesType" minOccurs="0"/>
 *         &lt;element name="HeatingFuelSources" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialHeatingFuelSourcesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialHeatingType", propOrder = {
    "heatingTypes",
    "heatingFuelSources"
})
public class CommercialHeatingType {

    @XmlElement(name = "HeatingTypes")
    protected CommercialHeatingTypesType heatingTypes;
    @XmlElement(name = "HeatingFuelSources")
    protected CommercialHeatingFuelSourcesType heatingFuelSources;

    /**
     * Gets the value of the heatingTypes property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialHeatingTypesType }
     *     
     */
    public CommercialHeatingTypesType getHeatingTypes() {
        return heatingTypes;
    }

    /**
     * Sets the value of the heatingTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialHeatingTypesType }
     *     
     */
    public void setHeatingTypes(CommercialHeatingTypesType value) {
        this.heatingTypes = value;
    }

    /**
     * Gets the value of the heatingFuelSources property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialHeatingFuelSourcesType }
     *     
     */
    public CommercialHeatingFuelSourcesType getHeatingFuelSources() {
        return heatingFuelSources;
    }

    /**
     * Sets the value of the heatingFuelSources property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialHeatingFuelSourcesType }
     *     
     */
    public void setHeatingFuelSources(CommercialHeatingFuelSourcesType value) {
        this.heatingFuelSources = value;
    }

}
