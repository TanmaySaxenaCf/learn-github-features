
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialPerilScoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialPerilScoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LossCostScore" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="PredictedLossCost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialPerilScoreType", propOrder = {
    "lossCostScore",
    "predictedLossCost"
})
@XmlSeeAlso({
    CasualtyCommercialPerilScoreType.class,
    PropertyCommercialPerilScoreType.class
})
public class CommercialPerilScoreType {

    @XmlElement(name = "LossCostScore", required = true)
    protected BigInteger lossCostScore;
    @XmlElement(name = "PredictedLossCost")
    protected Double predictedLossCost;

    /**
     * Gets the value of the lossCostScore property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLossCostScore() {
        return lossCostScore;
    }

    /**
     * Sets the value of the lossCostScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLossCostScore(BigInteger value) {
        this.lossCostScore = value;
    }

    /**
     * Gets the value of the predictedLossCost property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPredictedLossCost() {
        return predictedLossCost;
    }

    /**
     * Sets the value of the predictedLossCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPredictedLossCost(Double value) {
        this.predictedLossCost = value;
    }

}
