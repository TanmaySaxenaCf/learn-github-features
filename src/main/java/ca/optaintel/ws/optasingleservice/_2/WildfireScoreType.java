
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WildfireScoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WildfireScoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ScoreType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ScoreTypeType"/>
 *         &lt;element name="Class" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="ScoreSeverity" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}WildfireSeverityType" minOccurs="0"/>
 *         &lt;element name="Score" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WildfireScoreType", propOrder = {
    "scoreType",
    "clazz",
    "scoreSeverity",
    "score"
})
public class WildfireScoreType {

    @XmlElement(name = "ScoreType", required = true)
    @XmlSchemaType(name = "string")
    protected ScoreTypeType scoreType;
    @XmlElement(name = "Class")
    protected BigInteger clazz;
    @XmlElement(name = "ScoreSeverity")
    @XmlSchemaType(name = "string")
    protected WildfireSeverityType scoreSeverity;
    @XmlElement(name = "Score")
    protected String score;

    /**
     * Gets the value of the scoreType property.
     * 
     * @return
     *     possible object is
     *     {@link ScoreTypeType }
     *     
     */
    public ScoreTypeType getScoreType() {
        return scoreType;
    }

    /**
     * Sets the value of the scoreType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScoreTypeType }
     *     
     */
    public void setScoreType(ScoreTypeType value) {
        this.scoreType = value;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setClazz(BigInteger value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the scoreSeverity property.
     * 
     * @return
     *     possible object is
     *     {@link WildfireSeverityType }
     *     
     */
    public WildfireSeverityType getScoreSeverity() {
        return scoreSeverity;
    }

    /**
     * Sets the value of the scoreSeverity property.
     * 
     * @param value
     *     allowed object is
     *     {@link WildfireSeverityType }
     *     
     */
    public void setScoreSeverity(WildfireSeverityType value) {
        this.scoreSeverity = value;
    }

    /**
     * Gets the value of the score property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScore() {
        return score;
    }

    /**
     * Sets the value of the score property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScore(String value) {
        this.score = value;
    }

}
