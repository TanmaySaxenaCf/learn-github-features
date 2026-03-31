
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InspectionAttributesScore complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InspectionAttributesScore">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InspectionRecommendationType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}InspectionRecommendationType"/>
 *         &lt;element name="Score" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="NationalScore" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="ProvincialScore" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
@XmlType(name = "InspectionAttributesScore", propOrder = {
    "inspectionRecommendationType",
    "score",
    "nationalScore",
    "provincialScore",
    "predictedLossCost"
})
public class InspectionAttributesScore {

    @XmlElement(name = "InspectionRecommendationType", required = true)
    @XmlSchemaType(name = "string")
    protected InspectionRecommendationType inspectionRecommendationType;
    @XmlElement(name = "Score")
    protected Double score;
    @XmlElement(name = "NationalScore")
    protected Double nationalScore;
    @XmlElement(name = "ProvincialScore")
    protected Double provincialScore;
    @XmlElement(name = "PredictedLossCost")
    protected Double predictedLossCost;

    /**
     * Gets the value of the inspectionRecommendationType property.
     * 
     * @return
     *     possible object is
     *     {@link InspectionRecommendationType }
     *     
     */
    public InspectionRecommendationType getInspectionRecommendationType() {
        return inspectionRecommendationType;
    }

    /**
     * Sets the value of the inspectionRecommendationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link InspectionRecommendationType }
     *     
     */
    public void setInspectionRecommendationType(InspectionRecommendationType value) {
        this.inspectionRecommendationType = value;
    }

    /**
     * Gets the value of the score property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getScore() {
        return score;
    }

    /**
     * Sets the value of the score property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setScore(Double value) {
        this.score = value;
    }

    /**
     * Gets the value of the nationalScore property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getNationalScore() {
        return nationalScore;
    }

    /**
     * Sets the value of the nationalScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setNationalScore(Double value) {
        this.nationalScore = value;
    }

    /**
     * Gets the value of the provincialScore property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getProvincialScore() {
        return provincialScore;
    }

    /**
     * Sets the value of the provincialScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setProvincialScore(Double value) {
        this.provincialScore = value;
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
