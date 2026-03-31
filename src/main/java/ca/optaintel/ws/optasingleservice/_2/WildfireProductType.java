
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WildfireProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WildfireProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="WildfireFactors" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}WildfireFactorsType" minOccurs="0"/>
 *         &lt;element name="WildfireScores" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}WildfireScoresType" minOccurs="0"/>
 *         &lt;element name="WildfireGeospatialData" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}WildfireGeospatialDataType" minOccurs="0"/>
 *         &lt;element name="WildfireMaps" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}WildfireMapsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WildfireProductType", propOrder = {
    "wildfireFactors",
    "wildfireScores",
    "wildfireGeospatialData",
    "wildfireMaps"
})
public class WildfireProductType
    extends BaseProductType
{

    @XmlElement(name = "WildfireFactors")
    protected WildfireFactorsType wildfireFactors;
    @XmlElement(name = "WildfireScores")
    protected WildfireScoresType wildfireScores;
    @XmlElement(name = "WildfireGeospatialData")
    protected WildfireGeospatialDataType wildfireGeospatialData;
    @XmlElement(name = "WildfireMaps")
    protected WildfireMapsType wildfireMaps;

    /**
     * Gets the value of the wildfireFactors property.
     * 
     * @return
     *     possible object is
     *     {@link WildfireFactorsType }
     *     
     */
    public WildfireFactorsType getWildfireFactors() {
        return wildfireFactors;
    }

    /**
     * Sets the value of the wildfireFactors property.
     * 
     * @param value
     *     allowed object is
     *     {@link WildfireFactorsType }
     *     
     */
    public void setWildfireFactors(WildfireFactorsType value) {
        this.wildfireFactors = value;
    }

    /**
     * Gets the value of the wildfireScores property.
     * 
     * @return
     *     possible object is
     *     {@link WildfireScoresType }
     *     
     */
    public WildfireScoresType getWildfireScores() {
        return wildfireScores;
    }

    /**
     * Sets the value of the wildfireScores property.
     * 
     * @param value
     *     allowed object is
     *     {@link WildfireScoresType }
     *     
     */
    public void setWildfireScores(WildfireScoresType value) {
        this.wildfireScores = value;
    }

    /**
     * Gets the value of the wildfireGeospatialData property.
     * 
     * @return
     *     possible object is
     *     {@link WildfireGeospatialDataType }
     *     
     */
    public WildfireGeospatialDataType getWildfireGeospatialData() {
        return wildfireGeospatialData;
    }

    /**
     * Sets the value of the wildfireGeospatialData property.
     * 
     * @param value
     *     allowed object is
     *     {@link WildfireGeospatialDataType }
     *     
     */
    public void setWildfireGeospatialData(WildfireGeospatialDataType value) {
        this.wildfireGeospatialData = value;
    }

    /**
     * Gets the value of the wildfireMaps property.
     * 
     * @return
     *     possible object is
     *     {@link WildfireMapsType }
     *     
     */
    public WildfireMapsType getWildfireMaps() {
        return wildfireMaps;
    }

    /**
     * Sets the value of the wildfireMaps property.
     * 
     * @param value
     *     allowed object is
     *     {@link WildfireMapsType }
     *     
     */
    public void setWildfireMaps(WildfireMapsType value) {
        this.wildfireMaps = value;
    }

}
