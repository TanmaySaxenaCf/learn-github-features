
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RiskSCORDetailType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RiskSCORDetailType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RiskSCOR" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="Type" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RiskSCORType" minOccurs="0"/>
 *         &lt;element name="Adjustment" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RiskSCORAdjustmentType" maxOccurs="2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RiskSCORDetailType", propOrder = {
    "riskSCOR",
    "type",
    "adjustment"
})
public class RiskSCORDetailType {

    @XmlElement(name = "RiskSCOR", required = true)
    protected BigInteger riskSCOR;
    @XmlElement(name = "Type")
    @XmlSchemaType(name = "string")
    protected RiskSCORType type;
    @XmlElement(name = "Adjustment")
    protected List<RiskSCORAdjustmentType> adjustment;

    /**
     * Gets the value of the riskSCOR property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRiskSCOR() {
        return riskSCOR;
    }

    /**
     * Sets the value of the riskSCOR property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRiskSCOR(BigInteger value) {
        this.riskSCOR = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link RiskSCORType }
     *     
     */
    public RiskSCORType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link RiskSCORType }
     *     
     */
    public void setType(RiskSCORType value) {
        this.type = value;
    }

    /**
     * Gets the value of the adjustment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adjustment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdjustment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RiskSCORAdjustmentType }
     * 
     * 
     */
    public List<RiskSCORAdjustmentType> getAdjustment() {
        if (adjustment == null) {
            adjustment = new ArrayList<RiskSCORAdjustmentType>();
        }
        return this.adjustment;
    }

}
