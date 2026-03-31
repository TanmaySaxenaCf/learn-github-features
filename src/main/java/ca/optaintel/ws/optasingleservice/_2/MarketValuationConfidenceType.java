
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MarketValuationConfidenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MarketValuationConfidenceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConfidenceRating" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ConfidenceRatingType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MarketValuationConfidenceType", propOrder = {
    "confidenceRating"
})
public class MarketValuationConfidenceType {

    @XmlElement(name = "ConfidenceRating")
    @XmlSchemaType(name = "string")
    protected ConfidenceRatingType confidenceRating;

    /**
     * Gets the value of the confidenceRating property.
     * 
     * @return
     *     possible object is
     *     {@link ConfidenceRatingType }
     *     
     */
    public ConfidenceRatingType getConfidenceRating() {
        return confidenceRating;
    }

    /**
     * Sets the value of the confidenceRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfidenceRatingType }
     *     
     */
    public void setConfidenceRating(ConfidenceRatingType value) {
        this.confidenceRating = value;
    }

}
