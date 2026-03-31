
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialCoverageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialCoverageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CoverageType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialCoverageTypeType" minOccurs="0"/>
 *         &lt;element name="Deductible" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Limit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="LossCost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Premium" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Occupancy" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialOccupancyType" minOccurs="0"/>
 *         &lt;element name="Subline" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialCoverageType", propOrder = {
    "coverageType",
    "deductible",
    "limit",
    "lossCost",
    "premium",
    "occupancy",
    "subline"
})
public class CommercialCoverageType {

    @XmlElement(name = "CoverageType")
    @XmlSchemaType(name = "string")
    protected CommercialCoverageTypeType coverageType;
    @XmlElement(name = "Deductible")
    protected Double deductible;
    @XmlElement(name = "Limit")
    protected Double limit;
    @XmlElement(name = "LossCost")
    protected Double lossCost;
    @XmlElement(name = "Premium")
    protected Double premium;
    @XmlElement(name = "Occupancy")
    protected String occupancy;
    @XmlElement(name = "Subline", required = true)
    protected String subline;

    /**
     * Gets the value of the coverageType property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialCoverageTypeType }
     *     
     */
    public CommercialCoverageTypeType getCoverageType() {
        return coverageType;
    }

    /**
     * Sets the value of the coverageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialCoverageTypeType }
     *     
     */
    public void setCoverageType(CommercialCoverageTypeType value) {
        this.coverageType = value;
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
     * Gets the value of the lossCost property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLossCost() {
        return lossCost;
    }

    /**
     * Sets the value of the lossCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLossCost(Double value) {
        this.lossCost = value;
    }

    /**
     * Gets the value of the premium property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPremium() {
        return premium;
    }

    /**
     * Sets the value of the premium property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPremium(Double value) {
        this.premium = value;
    }

    /**
     * Gets the value of the occupancy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccupancy() {
        return occupancy;
    }

    /**
     * Sets the value of the occupancy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccupancy(String value) {
        this.occupancy = value;
    }

    /**
     * Gets the value of the subline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubline() {
        return subline;
    }

    /**
     * Sets the value of the subline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubline(String value) {
        this.subline = value;
    }

}
