
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AerialImageryRoofShapeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AerialImageryRoofShapeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FlatPercent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Value" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryRoofShapeValueType" minOccurs="0"/>
 *         &lt;element name="Score" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AerialImageryRoofShapeType", propOrder = {
    "flatPercent",
    "value",
    "score"
})
public class AerialImageryRoofShapeType {

    @XmlElement(name = "FlatPercent")
    protected Double flatPercent;
    @XmlElement(name = "Value")
    @XmlSchemaType(name = "string")
    protected AerialImageryRoofShapeValueType value;
    @XmlElement(name = "Score")
    protected Double score;

    /**
     * Gets the value of the flatPercent property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFlatPercent() {
        return flatPercent;
    }

    /**
     * Sets the value of the flatPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFlatPercent(Double value) {
        this.flatPercent = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryRoofShapeValueType }
     *     
     */
    public AerialImageryRoofShapeValueType getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryRoofShapeValueType }
     *     
     */
    public void setValue(AerialImageryRoofShapeValueType value) {
        this.value = value;
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

}
