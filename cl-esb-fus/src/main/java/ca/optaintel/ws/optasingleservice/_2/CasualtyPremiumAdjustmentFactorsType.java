
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CasualtyPremiumAdjustmentFactorsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CasualtyPremiumAdjustmentFactorsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CasualtyPremiumAdjustmentFactor" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CasualtyPremiumAdjustmentFactorType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CasualtyPremiumAdjustmentFactorsType", propOrder = {
    "casualtyPremiumAdjustmentFactor"
})
public class CasualtyPremiumAdjustmentFactorsType {

    @XmlElement(name = "CasualtyPremiumAdjustmentFactor")
    protected List<CasualtyPremiumAdjustmentFactorType> casualtyPremiumAdjustmentFactor;

    /**
     * Gets the value of the casualtyPremiumAdjustmentFactor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the casualtyPremiumAdjustmentFactor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCasualtyPremiumAdjustmentFactor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CasualtyPremiumAdjustmentFactorType }
     * 
     * 
     */
    public List<CasualtyPremiumAdjustmentFactorType> getCasualtyPremiumAdjustmentFactor() {
        if (casualtyPremiumAdjustmentFactor == null) {
            casualtyPremiumAdjustmentFactor = new ArrayList<CasualtyPremiumAdjustmentFactorType>();
        }
        return this.casualtyPremiumAdjustmentFactor;
    }

}
