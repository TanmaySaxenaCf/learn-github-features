
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PerilScorePerilType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PerilScorePerilType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PerilDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FrequencyScore" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="SeverityScore" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="LossCostScore" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="PredictedFrequency" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="PredictedSeverity" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
@XmlType(name = "PerilScorePerilType", propOrder = {
    "perilDescription",
    "frequencyScore",
    "severityScore",
    "lossCostScore",
    "predictedFrequency",
    "predictedSeverity",
    "predictedLossCost"
})
public class PerilScorePerilType {

    @XmlElement(name = "PerilDescription", required = true)
    protected String perilDescription;
    @XmlElement(name = "FrequencyScore")
    protected BigInteger frequencyScore;
    @XmlElement(name = "SeverityScore")
    protected BigInteger severityScore;
    @XmlElement(name = "LossCostScore")
    protected BigInteger lossCostScore;
    @XmlElement(name = "PredictedFrequency")
    protected Double predictedFrequency;
    @XmlElement(name = "PredictedSeverity")
    protected Double predictedSeverity;
    @XmlElement(name = "PredictedLossCost")
    protected Double predictedLossCost;

    /**
     * Gets the value of the perilDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPerilDescription() {
        return perilDescription;
    }

    /**
     * Sets the value of the perilDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPerilDescription(String value) {
        this.perilDescription = value;
    }

    /**
     * Gets the value of the frequencyScore property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFrequencyScore() {
        return frequencyScore;
    }

    /**
     * Sets the value of the frequencyScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFrequencyScore(BigInteger value) {
        this.frequencyScore = value;
    }

    /**
     * Gets the value of the severityScore property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSeverityScore() {
        return severityScore;
    }

    /**
     * Sets the value of the severityScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSeverityScore(BigInteger value) {
        this.severityScore = value;
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

    /**
     * Gets the value of the predictedFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPredictedFrequency() {
        return predictedFrequency;
    }

    /**
     * Sets the value of the predictedFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPredictedFrequency(Double value) {
        this.predictedFrequency = value;
    }

    /**
     * Gets the value of the predictedSeverity property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPredictedSeverity() {
        return predictedSeverity;
    }

    /**
     * Sets the value of the predictedSeverity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPredictedSeverity(Double value) {
        this.predictedSeverity = value;
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
