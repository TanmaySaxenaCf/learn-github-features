
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialOccupancyCreditType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialOccupancyCreditType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CreditDelinquencyScore" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="BusinessFailureRiskScore" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="PaymentIndexScore" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialOccupancyCreditType", propOrder = {
    "creditDelinquencyScore",
    "businessFailureRiskScore",
    "paymentIndexScore"
})
public class CommercialOccupancyCreditType {

    @XmlElement(name = "CreditDelinquencyScore")
    protected BigInteger creditDelinquencyScore;
    @XmlElement(name = "BusinessFailureRiskScore")
    protected BigInteger businessFailureRiskScore;
    @XmlElement(name = "PaymentIndexScore")
    protected BigInteger paymentIndexScore;

    /**
     * Gets the value of the creditDelinquencyScore property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCreditDelinquencyScore() {
        return creditDelinquencyScore;
    }

    /**
     * Sets the value of the creditDelinquencyScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCreditDelinquencyScore(BigInteger value) {
        this.creditDelinquencyScore = value;
    }

    /**
     * Gets the value of the businessFailureRiskScore property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBusinessFailureRiskScore() {
        return businessFailureRiskScore;
    }

    /**
     * Sets the value of the businessFailureRiskScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBusinessFailureRiskScore(BigInteger value) {
        this.businessFailureRiskScore = value;
    }

    /**
     * Gets the value of the paymentIndexScore property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPaymentIndexScore() {
        return paymentIndexScore;
    }

    /**
     * Sets the value of the paymentIndexScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPaymentIndexScore(BigInteger value) {
        this.paymentIndexScore = value;
    }

}
