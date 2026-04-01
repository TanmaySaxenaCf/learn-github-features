
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyPremiumAdjustmentFactorsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyPremiumAdjustmentFactorsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PropertyPremiumAdjustmentFactor" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertyPremiumAdjustmentFactorType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyPremiumAdjustmentFactorsType", propOrder = {
    "propertyPremiumAdjustmentFactor"
})
public class PropertyPremiumAdjustmentFactorsType {

    @XmlElement(name = "PropertyPremiumAdjustmentFactor")
    protected List<PropertyPremiumAdjustmentFactorType> propertyPremiumAdjustmentFactor;

    /**
     * Gets the value of the propertyPremiumAdjustmentFactor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertyPremiumAdjustmentFactor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertyPremiumAdjustmentFactor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyPremiumAdjustmentFactorType }
     * 
     * 
     */
    public List<PropertyPremiumAdjustmentFactorType> getPropertyPremiumAdjustmentFactor() {
        if (propertyPremiumAdjustmentFactor == null) {
            propertyPremiumAdjustmentFactor = new ArrayList<PropertyPremiumAdjustmentFactorType>();
        }
        return this.propertyPremiumAdjustmentFactor;
    }

}
