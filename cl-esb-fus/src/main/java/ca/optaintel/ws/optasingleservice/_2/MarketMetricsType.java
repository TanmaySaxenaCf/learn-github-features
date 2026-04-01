
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MarketMetricsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MarketMetricsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AverageListPrice" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="AverageSalePrice" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="SoldOverAsking" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="MarketTemperature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ListingTrend" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SalesTrend" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PriceTrend" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MarketMetricsType", propOrder = {
    "averageListPrice",
    "averageSalePrice",
    "soldOverAsking",
    "marketTemperature",
    "listingTrend",
    "salesTrend",
    "priceTrend"
})
public class MarketMetricsType {

    @XmlElement(name = "AverageListPrice")
    protected Float averageListPrice;
    @XmlElement(name = "AverageSalePrice")
    protected Float averageSalePrice;
    @XmlElement(name = "SoldOverAsking")
    protected Float soldOverAsking;
    @XmlElement(name = "MarketTemperature")
    protected String marketTemperature;
    @XmlElement(name = "ListingTrend")
    protected String listingTrend;
    @XmlElement(name = "SalesTrend")
    protected String salesTrend;
    @XmlElement(name = "PriceTrend")
    protected String priceTrend;

    /**
     * Gets the value of the averageListPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getAverageListPrice() {
        return averageListPrice;
    }

    /**
     * Sets the value of the averageListPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setAverageListPrice(Float value) {
        this.averageListPrice = value;
    }

    /**
     * Gets the value of the averageSalePrice property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getAverageSalePrice() {
        return averageSalePrice;
    }

    /**
     * Sets the value of the averageSalePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setAverageSalePrice(Float value) {
        this.averageSalePrice = value;
    }

    /**
     * Gets the value of the soldOverAsking property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSoldOverAsking() {
        return soldOverAsking;
    }

    /**
     * Sets the value of the soldOverAsking property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSoldOverAsking(Float value) {
        this.soldOverAsking = value;
    }

    /**
     * Gets the value of the marketTemperature property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarketTemperature() {
        return marketTemperature;
    }

    /**
     * Sets the value of the marketTemperature property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarketTemperature(String value) {
        this.marketTemperature = value;
    }

    /**
     * Gets the value of the listingTrend property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListingTrend() {
        return listingTrend;
    }

    /**
     * Sets the value of the listingTrend property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListingTrend(String value) {
        this.listingTrend = value;
    }

    /**
     * Gets the value of the salesTrend property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalesTrend() {
        return salesTrend;
    }

    /**
     * Sets the value of the salesTrend property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesTrend(String value) {
        this.salesTrend = value;
    }

    /**
     * Gets the value of the priceTrend property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriceTrend() {
        return priceTrend;
    }

    /**
     * Sets the value of the priceTrend property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriceTrend(String value) {
        this.priceTrend = value;
    }

}
