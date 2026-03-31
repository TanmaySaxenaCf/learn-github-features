
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FloodScoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FloodScoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Zone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Premium" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FloodValueType" minOccurs="0"/>
 *         &lt;element name="Limit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Deductible" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="FloodScore" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="AverageAnnualLossScore" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="AverageAnnualLossValues" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FloodValueType" minOccurs="0"/>
 *         &lt;element name="RateFactor" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Default" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="ResidentialModifiers" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResidentialConstructionFeaturesType"/>
 *           &lt;element name="MultiResidentialModifiers" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}MultiResidentialConstructionFeaturesType"/>
 *         &lt;/choice>
 *         &lt;element name="AdditionalDetails" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FloodDetailType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FloodScoreType", propOrder = {
    "zone",
    "premium",
    "limit",
    "deductible",
    "floodScore",
    "averageAnnualLossScore",
    "averageAnnualLossValues",
    "rateFactor",
    "_default",
    "residentialModifiers",
    "multiResidentialModifiers",
    "additionalDetails"
})
public class FloodScoreType {

    @XmlElement(name = "Zone")
    protected String zone;
    @XmlElement(name = "Premium")
    protected FloodValueType premium;
    @XmlElement(name = "Limit")
    protected Double limit;
    @XmlElement(name = "Deductible")
    protected Double deductible;
    @XmlElement(name = "FloodScore")
    protected BigInteger floodScore;
    @XmlElement(name = "AverageAnnualLossScore")
    protected BigInteger averageAnnualLossScore;
    @XmlElement(name = "AverageAnnualLossValues")
    protected FloodValueType averageAnnualLossValues;
    @XmlElement(name = "RateFactor")
    protected Float rateFactor;
    @XmlElement(name = "Default", defaultValue = "false")
    protected Boolean _default;
    @XmlElement(name = "ResidentialModifiers")
    protected ResidentialConstructionFeaturesType residentialModifiers;
    @XmlElement(name = "MultiResidentialModifiers")
    protected MultiResidentialConstructionFeaturesType multiResidentialModifiers;
    @XmlElement(name = "AdditionalDetails")
    protected List<FloodDetailType> additionalDetails;

    /**
     * Gets the value of the zone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZone() {
        return zone;
    }

    /**
     * Sets the value of the zone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZone(String value) {
        this.zone = value;
    }

    /**
     * Gets the value of the premium property.
     * 
     * @return
     *     possible object is
     *     {@link FloodValueType }
     *     
     */
    public FloodValueType getPremium() {
        return premium;
    }

    /**
     * Sets the value of the premium property.
     * 
     * @param value
     *     allowed object is
     *     {@link FloodValueType }
     *     
     */
    public void setPremium(FloodValueType value) {
        this.premium = value;
    }

    /**
     * Gets the value of the limit property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLimit() {
        return limit;
    }

    /**
     * Sets the value of the limit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLimit(Double value) {
        this.limit = value;
    }

    /**
     * Gets the value of the deductible property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDeductible() {
        return deductible;
    }

    /**
     * Sets the value of the deductible property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDeductible(Double value) {
        this.deductible = value;
    }

    /**
     * Gets the value of the floodScore property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFloodScore() {
        return floodScore;
    }

    /**
     * Sets the value of the floodScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFloodScore(BigInteger value) {
        this.floodScore = value;
    }

    /**
     * Gets the value of the averageAnnualLossScore property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAverageAnnualLossScore() {
        return averageAnnualLossScore;
    }

    /**
     * Sets the value of the averageAnnualLossScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAverageAnnualLossScore(BigInteger value) {
        this.averageAnnualLossScore = value;
    }

    /**
     * Gets the value of the averageAnnualLossValues property.
     * 
     * @return
     *     possible object is
     *     {@link FloodValueType }
     *     
     */
    public FloodValueType getAverageAnnualLossValues() {
        return averageAnnualLossValues;
    }

    /**
     * Sets the value of the averageAnnualLossValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link FloodValueType }
     *     
     */
    public void setAverageAnnualLossValues(FloodValueType value) {
        this.averageAnnualLossValues = value;
    }

    /**
     * Gets the value of the rateFactor property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getRateFactor() {
        return rateFactor;
    }

    /**
     * Sets the value of the rateFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setRateFactor(Float value) {
        this.rateFactor = value;
    }

    /**
     * Gets the value of the default property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDefault() {
        return _default;
    }

    /**
     * Sets the value of the default property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDefault(Boolean value) {
        this._default = value;
    }

    /**
     * Gets the value of the residentialModifiers property.
     * 
     * @return
     *     possible object is
     *     {@link ResidentialConstructionFeaturesType }
     *     
     */
    public ResidentialConstructionFeaturesType getResidentialModifiers() {
        return residentialModifiers;
    }

    /**
     * Sets the value of the residentialModifiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResidentialConstructionFeaturesType }
     *     
     */
    public void setResidentialModifiers(ResidentialConstructionFeaturesType value) {
        this.residentialModifiers = value;
    }

    /**
     * Gets the value of the multiResidentialModifiers property.
     * 
     * @return
     *     possible object is
     *     {@link MultiResidentialConstructionFeaturesType }
     *     
     */
    public MultiResidentialConstructionFeaturesType getMultiResidentialModifiers() {
        return multiResidentialModifiers;
    }

    /**
     * Sets the value of the multiResidentialModifiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiResidentialConstructionFeaturesType }
     *     
     */
    public void setMultiResidentialModifiers(MultiResidentialConstructionFeaturesType value) {
        this.multiResidentialModifiers = value;
    }

    /**
     * Gets the value of the additionalDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FloodDetailType }
     * 
     * 
     */
    public List<FloodDetailType> getAdditionalDetails() {
        if (additionalDetails == null) {
            additionalDetails = new ArrayList<FloodDetailType>();
        }
        return this.additionalDetails;
    }

}
