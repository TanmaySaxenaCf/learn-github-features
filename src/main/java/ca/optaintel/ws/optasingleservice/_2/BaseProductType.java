
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaseProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseProductType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StatusCode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ProductResponseStatusType"/>
 *         &lt;element name="Messages" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}MessagesType" minOccurs="0"/>
 *         &lt;element name="AdditionalDetails" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AdditionalDetailsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseProductType", propOrder = {
    "statusCode",
    "messages",
    "additionalDetails"
})
@XmlSeeAlso({
    RentalValuationProductType.class,
    IClarifyResidentialProductType.class,
    IClarifyCondoTenantProductType.class,
    ActiveWildfiresProductType.class,
    IClarifyFinancialResidentialProductType.class,
    IClarifyResidentialReportProductType.class,
    AerialImageryProductType.class,
    IClarifyCommercialOccupancyProductType.class,
    IClarifySnapshotReportProductType.class,
    HPIHistoricalProductType.class,
    EstimatedValueRangeProductType.class,
    OptaCommercialConstructionFeaturesProductType.class,
    PropertyListingsProductType.class,
    BusinessNamePrefillProductType.class,
    MarketValuationConfidenceProductType.class,
    PerilScoreProductType.class,
    PremiumAdjustmentFactorsProductType.class,
    InspectionAttributesProductType.class,
    PropertyStatsProductType.class,
    IClarifyCommercialConstructionFeaturesProductType.class,
    LightSpeedRatesProductType.class,
    PerilScoresTypes.class,
    MarketMetricsProductType.class,
    OptaAddressKeyProductType.class,
    FloodScoreProductType.class,
    ResidentialMarketValuationProductType.class,
    OptaPermitProductType.class,
    InspectionScoreProductType.class,
    MarketValueComparablesProduct.class,
    WildfireProductType.class,
    AssessmentListingsProductType.class,
    NeighbourhoodNameProductType.class,
    FUSProductType.class,
    PropertySalesProductType.class,
    RentalListingsProductType.class,
    ActualCashValueProductType.class,
    BuildingImageryType.class,
    AddressSearchType.class,
    LightSpeedCommercialProductType.class,
    InsuranceReferralProductType.class,
    PropertyLocationProductType.class,
    BusinessNameDetailsProductType.class
})
public class BaseProductType {

    @XmlElement(name = "StatusCode", required = true)
    @XmlSchemaType(name = "string")
    protected ProductResponseStatusType statusCode;
    @XmlElement(name = "Messages")
    protected MessagesType messages;
    @XmlElement(name = "AdditionalDetails")
    protected AdditionalDetailsType additionalDetails;

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link ProductResponseStatusType }
     *     
     */
    public ProductResponseStatusType getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductResponseStatusType }
     *     
     */
    public void setStatusCode(ProductResponseStatusType value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the messages property.
     * 
     * @return
     *     possible object is
     *     {@link MessagesType }
     *     
     */
    public MessagesType getMessages() {
        return messages;
    }

    /**
     * Sets the value of the messages property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessagesType }
     *     
     */
    public void setMessages(MessagesType value) {
        this.messages = value;
    }

    /**
     * Gets the value of the additionalDetails property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalDetailsType }
     *     
     */
    public AdditionalDetailsType getAdditionalDetails() {
        return additionalDetails;
    }

    /**
     * Sets the value of the additionalDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalDetailsType }
     *     
     */
    public void setAdditionalDetails(AdditionalDetailsType value) {
        this.additionalDetails = value;
    }

}
