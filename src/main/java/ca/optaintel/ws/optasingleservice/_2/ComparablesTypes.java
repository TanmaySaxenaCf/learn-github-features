
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComparablesTypes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComparablesTypes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Comparable" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}MarketValueComparablesType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComparablesTypes", propOrder = {
    "comparable"
})
public class ComparablesTypes {

    @XmlElement(name = "Comparable", required = true)
    protected MarketValueComparablesType comparable;

    /**
     * Gets the value of the comparable property.
     * 
     * @return
     *     possible object is
     *     {@link MarketValueComparablesType }
     *     
     */
    public MarketValueComparablesType getComparable() {
        return comparable;
    }

    /**
     * Sets the value of the comparable property.
     * 
     * @param value
     *     allowed object is
     *     {@link MarketValueComparablesType }
     *     
     */
    public void setComparable(MarketValueComparablesType value) {
        this.comparable = value;
    }

}
