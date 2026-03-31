
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActualCashValueValuationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActualCashValueValuationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Valuation" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ActualCashValueType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActualCashValueValuationType", propOrder = {
    "valuation"
})
public class ActualCashValueValuationType {

    @XmlElement(name = "Valuation")
    protected ActualCashValueType valuation;

    /**
     * Gets the value of the valuation property.
     * 
     * @return
     *     possible object is
     *     {@link ActualCashValueType }
     *     
     */
    public ActualCashValueType getValuation() {
        return valuation;
    }

    /**
     * Sets the value of the valuation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActualCashValueType }
     *     
     */
    public void setValuation(ActualCashValueType value) {
        this.valuation = value;
    }

}
