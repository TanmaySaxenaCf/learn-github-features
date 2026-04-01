
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResidentialMarketValuationsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResidentialMarketValuationsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConfidenceRating" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ConfidenceRatingType" minOccurs="0"/>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ValueDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResidentialMarketValuationsType", propOrder = {
    "confidenceRating",
    "value",
    "date",
    "valueDescription"
})
public class ResidentialMarketValuationsType {

    @XmlElement(name = "ConfidenceRating")
    @XmlSchemaType(name = "string")
    protected ConfidenceRatingType confidenceRating;
    @XmlElement(name = "Value")
    protected BigInteger value;
    @XmlElement(name = "Date")
    protected String date;
    @XmlElement(name = "ValueDescription")
    protected String valueDescription;

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

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValue(BigInteger value) {
        this.value = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the valueDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValueDescription() {
        return valueDescription;
    }

    /**
     * Sets the value of the valueDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValueDescription(String value) {
        this.valueDescription = value;
    }

}
