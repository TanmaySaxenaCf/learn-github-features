
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActualCashValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActualCashValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ActualCashValue" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActualCashValueType", propOrder = {
    "actualCashValue"
})
public class ActualCashValueType {

    @XmlElement(name = "ActualCashValue")
    protected Float actualCashValue;

    /**
     * Gets the value of the actualCashValue property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getActualCashValue() {
        return actualCashValue;
    }

    /**
     * Sets the value of the actualCashValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setActualCashValue(Float value) {
        this.actualCashValue = value;
    }

}
