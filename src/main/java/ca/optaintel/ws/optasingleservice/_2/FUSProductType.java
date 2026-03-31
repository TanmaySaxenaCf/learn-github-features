
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FUSProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FUSProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="Dwelling" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FUSProductDwellingType"/>
 *         &lt;element name="Commercial" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FUSProductCommercialType"/>
 *         &lt;element name="EarthquakeCodes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}EarthquakeCodesType"/>
 *         &lt;element name="HydrantCounts" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}HydrantCountsType"/>
 *         &lt;element name="FusMaps" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FusMapsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FUSProductType", propOrder = {
    "dwelling",
    "commercial",
    "earthquakeCodes",
    "hydrantCounts",
    "fusMaps"
})
public class FUSProductType
    extends BaseProductType
{

    @XmlElement(name = "Dwelling", required = true)
    protected FUSProductDwellingType dwelling;
    @XmlElement(name = "Commercial", required = true)
    protected FUSProductCommercialType commercial;
    @XmlElement(name = "EarthquakeCodes", required = true)
    protected EarthquakeCodesType earthquakeCodes;
    @XmlElement(name = "HydrantCounts", required = true)
    protected HydrantCountsType hydrantCounts;
    @XmlElement(name = "FusMaps")
    protected FusMapsType fusMaps;

    /**
     * Gets the value of the dwelling property.
     * 
     * @return
     *     possible object is
     *     {@link FUSProductDwellingType }
     *     
     */
    public FUSProductDwellingType getDwelling() {
        return dwelling;
    }

    /**
     * Sets the value of the dwelling property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUSProductDwellingType }
     *     
     */
    public void setDwelling(FUSProductDwellingType value) {
        this.dwelling = value;
    }

    /**
     * Gets the value of the commercial property.
     * 
     * @return
     *     possible object is
     *     {@link FUSProductCommercialType }
     *     
     */
    public FUSProductCommercialType getCommercial() {
        return commercial;
    }

    /**
     * Sets the value of the commercial property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUSProductCommercialType }
     *     
     */
    public void setCommercial(FUSProductCommercialType value) {
        this.commercial = value;
    }

    /**
     * Gets the value of the earthquakeCodes property.
     * 
     * @return
     *     possible object is
     *     {@link EarthquakeCodesType }
     *     
     */
    public EarthquakeCodesType getEarthquakeCodes() {
        return earthquakeCodes;
    }

    /**
     * Sets the value of the earthquakeCodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link EarthquakeCodesType }
     *     
     */
    public void setEarthquakeCodes(EarthquakeCodesType value) {
        this.earthquakeCodes = value;
    }

    /**
     * Gets the value of the hydrantCounts property.
     * 
     * @return
     *     possible object is
     *     {@link HydrantCountsType }
     *     
     */
    public HydrantCountsType getHydrantCounts() {
        return hydrantCounts;
    }

    /**
     * Sets the value of the hydrantCounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link HydrantCountsType }
     *     
     */
    public void setHydrantCounts(HydrantCountsType value) {
        this.hydrantCounts = value;
    }

    /**
     * Gets the value of the fusMaps property.
     * 
     * @return
     *     possible object is
     *     {@link FusMapsType }
     *     
     */
    public FusMapsType getFusMaps() {
        return fusMaps;
    }

    /**
     * Sets the value of the fusMaps property.
     * 
     * @param value
     *     allowed object is
     *     {@link FusMapsType }
     *     
     */
    public void setFusMaps(FusMapsType value) {
        this.fusMaps = value;
    }

}
