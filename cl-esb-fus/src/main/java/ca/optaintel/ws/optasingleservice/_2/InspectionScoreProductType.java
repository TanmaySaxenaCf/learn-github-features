
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InspectionScoreProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InspectionScoreProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="Score" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="NationalScore" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="ProvincialScore" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InspectionScoreProductType", propOrder = {
    "score",
    "nationalScore",
    "provincialScore"
})
public class InspectionScoreProductType
    extends BaseProductType
{

    @XmlElement(name = "Score")
    protected BigInteger score;
    @XmlElement(name = "NationalScore")
    protected BigInteger nationalScore;
    @XmlElement(name = "ProvincialScore")
    protected BigInteger provincialScore;

    /**
     * Gets the value of the score property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getScore() {
        return score;
    }

    /**
     * Sets the value of the score property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setScore(BigInteger value) {
        this.score = value;
    }

    /**
     * Gets the value of the nationalScore property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNationalScore() {
        return nationalScore;
    }

    /**
     * Sets the value of the nationalScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNationalScore(BigInteger value) {
        this.nationalScore = value;
    }

    /**
     * Gets the value of the provincialScore property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getProvincialScore() {
        return provincialScore;
    }

    /**
     * Sets the value of the provincialScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setProvincialScore(BigInteger value) {
        this.provincialScore = value;
    }

}
