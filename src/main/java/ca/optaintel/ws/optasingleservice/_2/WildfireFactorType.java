
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WildfireFactorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WildfireFactorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FactorType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FactorTypeType"/>
 *         &lt;element name="FactorSeverity" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}WildfireSeverityType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WildfireFactorType", propOrder = {
    "factorType",
    "factorSeverity"
})
public class WildfireFactorType {

    @XmlElement(name = "FactorType", required = true)
    @XmlSchemaType(name = "string")
    protected FactorTypeType factorType;
    @XmlElement(name = "FactorSeverity", required = true)
    @XmlSchemaType(name = "string")
    protected WildfireSeverityType factorSeverity;

    /**
     * Gets the value of the factorType property.
     * 
     * @return
     *     possible object is
     *     {@link FactorTypeType }
     *     
     */
    public FactorTypeType getFactorType() {
        return factorType;
    }

    /**
     * Sets the value of the factorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link FactorTypeType }
     *     
     */
    public void setFactorType(FactorTypeType value) {
        this.factorType = value;
    }

    /**
     * Gets the value of the factorSeverity property.
     * 
     * @return
     *     possible object is
     *     {@link WildfireSeverityType }
     *     
     */
    public WildfireSeverityType getFactorSeverity() {
        return factorSeverity;
    }

    /**
     * Sets the value of the factorSeverity property.
     * 
     * @param value
     *     allowed object is
     *     {@link WildfireSeverityType }
     *     
     */
    public void setFactorSeverity(WildfireSeverityType value) {
        this.factorSeverity = value;
    }

}
