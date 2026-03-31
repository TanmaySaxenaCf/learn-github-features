
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseCondoTenantPerilScoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseCondoTenantPerilScoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PerilScoreTotal" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="PerilScoreWater" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="PerilScoreFire" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="PerilScoreWindHail" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="PerilScoreCrime" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="PerilScoreSewer" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="PerilScoreOther" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseCondoTenantPerilScoreType", propOrder = {
    "perilScoreTotal",
    "perilScoreWater",
    "perilScoreFire",
    "perilScoreWindHail",
    "perilScoreCrime",
    "perilScoreSewer",
    "perilScoreOther"
})
public class ResponseCondoTenantPerilScoreType {

    @XmlElement(name = "PerilScoreTotal", required = true)
    protected BigInteger perilScoreTotal;
    @XmlElement(name = "PerilScoreWater", required = true)
    protected BigInteger perilScoreWater;
    @XmlElement(name = "PerilScoreFire", required = true)
    protected BigInteger perilScoreFire;
    @XmlElement(name = "PerilScoreWindHail", required = true)
    protected BigInteger perilScoreWindHail;
    @XmlElement(name = "PerilScoreCrime", required = true)
    protected BigInteger perilScoreCrime;
    @XmlElement(name = "PerilScoreSewer", required = true)
    protected BigInteger perilScoreSewer;
    @XmlElement(name = "PerilScoreOther", required = true)
    protected BigInteger perilScoreOther;

    /**
     * Gets the value of the perilScoreTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPerilScoreTotal() {
        return perilScoreTotal;
    }

    /**
     * Sets the value of the perilScoreTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPerilScoreTotal(BigInteger value) {
        this.perilScoreTotal = value;
    }

    /**
     * Gets the value of the perilScoreWater property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPerilScoreWater() {
        return perilScoreWater;
    }

    /**
     * Sets the value of the perilScoreWater property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPerilScoreWater(BigInteger value) {
        this.perilScoreWater = value;
    }

    /**
     * Gets the value of the perilScoreFire property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPerilScoreFire() {
        return perilScoreFire;
    }

    /**
     * Sets the value of the perilScoreFire property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPerilScoreFire(BigInteger value) {
        this.perilScoreFire = value;
    }

    /**
     * Gets the value of the perilScoreWindHail property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPerilScoreWindHail() {
        return perilScoreWindHail;
    }

    /**
     * Sets the value of the perilScoreWindHail property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPerilScoreWindHail(BigInteger value) {
        this.perilScoreWindHail = value;
    }

    /**
     * Gets the value of the perilScoreCrime property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPerilScoreCrime() {
        return perilScoreCrime;
    }

    /**
     * Sets the value of the perilScoreCrime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPerilScoreCrime(BigInteger value) {
        this.perilScoreCrime = value;
    }

    /**
     * Gets the value of the perilScoreSewer property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPerilScoreSewer() {
        return perilScoreSewer;
    }

    /**
     * Sets the value of the perilScoreSewer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPerilScoreSewer(BigInteger value) {
        this.perilScoreSewer = value;
    }

    /**
     * Gets the value of the perilScoreOther property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPerilScoreOther() {
        return perilScoreOther;
    }

    /**
     * Sets the value of the perilScoreOther property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPerilScoreOther(BigInteger value) {
        this.perilScoreOther = value;
    }

}
