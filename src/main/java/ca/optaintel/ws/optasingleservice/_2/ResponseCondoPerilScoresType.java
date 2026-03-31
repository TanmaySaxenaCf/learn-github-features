
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseCondoPerilScoresType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseCondoPerilScoresType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PerilType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PredictedLossCost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="LossCostScore" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseCondoPerilScoresType", propOrder = {
    "perilType",
    "predictedLossCost",
    "lossCostScore"
})
public class ResponseCondoPerilScoresType {

    @XmlElement(name = "PerilType")
    protected String perilType;
    @XmlElement(name = "PredictedLossCost")
    protected Double predictedLossCost;
    @XmlElement(name = "LossCostScore")
    protected BigInteger lossCostScore;

    /**
     * Gets the value of the perilType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPerilType() {
        return perilType;
    }

    /**
     * Sets the value of the perilType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPerilType(String value) {
        this.perilType = value;
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

}
