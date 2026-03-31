
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductResultsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductResultsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="iClarifyResidentialProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}iClarifyResidentialProductType"/>
 *         &lt;element name="CommercialPerilScoreProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PerilScoresTypes"/>
 *         &lt;element name="iClarifyCommercialOccupancyProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}iClarifyCommercialOccupancyProductType"/>
 *         &lt;element name="FUSProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FUSProductType"/>
 *         &lt;element name="WildfireProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}WildfireProductType"/>
 *         &lt;element name="ActiveWildfiresProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ActiveWildfiresProductType"/>
 *         &lt;element name="PerilScoreProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PerilScoreProductType"/>
 *         &lt;element name="FloodScoreProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FloodScoreProductType"/>
 *         &lt;element name="InspectionScoreProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}InspectionScoreProductType"/>
 *         &lt;element name="InspectionAttributesProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}InspectionAttributesProductType"/>
 *         &lt;element name="iClarifyCondoTenantProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}iClarifyCondoTenantProductType"/>
 *         &lt;element name="ResidentialMarketValuationProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResidentialMarketValuationProductType"/>
 *         &lt;element name="iClarifyResidentialReportProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}iClarifyResidentialReportProductType"/>
 *         &lt;element name="InspectionOrder" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType"/>
 *         &lt;element name="iClarifyCommercialConstructionFeaturesProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}iClarifyCommercialConstructionFeaturesProductType"/>
 *         &lt;element name="BuildingImagery" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BuildingImageryType"/>
 *         &lt;element name="AddressSearch" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AddressSearchType"/>
 *         &lt;element name="iClarifyFinancialResidentialProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}iClarifyFinancialResidentialProductType"/>
 *         &lt;element name="OptaAddressKeyProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}OptaAddressKeyProductType"/>
 *         &lt;element name="EstimatedValueRangeProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}EstimatedValueRangeProductType"/>
 *         &lt;element name="PropertyLocationProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertyLocationProductType"/>
 *         &lt;element name="InsuranceReferralProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}InsuranceReferralProductType"/>
 *         &lt;element name="MarketValueComparablesProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}MarketValueComparablesProduct"/>
 *         &lt;element name="MarketValuationConfidenceProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}MarketValuationConfidenceProductType"/>
 *         &lt;element name="RentalValuationProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RentalValuationProductType"/>
 *         &lt;element name="PropertySalesProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertySalesProductType"/>
 *         &lt;element name="PropertyListingsProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertyListingsProductType"/>
 *         &lt;element name="PropertyStatsProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertyStatsProductType"/>
 *         &lt;element name="OptaPermitProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}OptaPermitProductType"/>
 *         &lt;element name="OptaPermitFinancialProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}OptaPermitProductType"/>
 *         &lt;element name="AssessmentListingsProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AssessmentListingsProductType"/>
 *         &lt;element name="RentalListingsProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RentalListingsProductType"/>
 *         &lt;element name="MarketMetricsProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}MarketMetricsProductType"/>
 *         &lt;element name="NeighbourhoodNameProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}NeighbourhoodNameProductType"/>
 *         &lt;element name="AerialImageryProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryProductType"/>
 *         &lt;element name="iClarifySnapshotReportProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}iClarifySnapshotReportProductType"/>
 *         &lt;element name="OptaCommercialConstructionFeaturesProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}OptaCommercialConstructionFeaturesProductType"/>
 *         &lt;element name="iClarifyFinancialPrefillLiteProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}iClarifyFinancialResidentialProductType"/>
 *         &lt;element name="LightSpeedCommercial" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}LightSpeedCommercialProductType"/>
 *         &lt;element name="HPIHistoricalProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}HPIHistoricalProductType"/>
 *         &lt;element name="LightspeedRates" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}LightSpeedRatesProductType"/>
 *         &lt;element name="BusinessNamePrefillProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BusinessNamePrefillProductType"/>
 *         &lt;element name="PremiumAdjustmentFactorsProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PremiumAdjustmentFactorsProductType"/>
 *         &lt;element name="BusinessNameDetailsProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BusinessNameDetailsProductType"/>
 *         &lt;element name="ActualCashValueProduct" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ActualCashValueProductType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductResultsType", propOrder = {
    "iClarifyResidentialProductOrCommercialPerilScoreProductOrIClarifyCommercialOccupancyProduct"
})
public class ProductResultsType {

    @XmlElementRefs({
        @XmlElementRef(name = "ActiveWildfiresProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "iClarifyResidentialReportProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "PropertySalesProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "OptaPermitFinancialProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "iClarifyCommercialOccupancyProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "iClarifyFinancialResidentialProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "RentalListingsProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "LightspeedRates", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "HPIHistoricalProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "ActualCashValueProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "OptaPermitProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "NeighbourhoodNameProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "FUSProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "PremiumAdjustmentFactorsProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "iClarifySnapshotReportProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "LightSpeedCommercial", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "PropertyListingsProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "AerialImageryProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "AddressSearch", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "WildfireProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "CommercialPerilScoreProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "FloodScoreProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "MarketMetricsProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "PropertyStatsProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "ResidentialMarketValuationProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "InsuranceReferralProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "AssessmentListingsProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "InspectionOrder", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "EstimatedValueRangeProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "OptaCommercialConstructionFeaturesProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "InspectionScoreProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "BuildingImagery", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "iClarifyFinancialPrefillLiteProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "BusinessNameDetailsProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "BusinessNamePrefillProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "iClarifyResidentialProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "PropertyLocationProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "PerilScoreProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "MarketValuationConfidenceProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "RentalValuationProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "iClarifyCondoTenantProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "OptaAddressKeyProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "iClarifyCommercialConstructionFeaturesProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "MarketValueComparablesProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class),
        @XmlElementRef(name = "InspectionAttributesProduct", namespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", type = JAXBElement.class)
    })
    protected List<JAXBElement<? extends BaseProductType>> iClarifyResidentialProductOrCommercialPerilScoreProductOrIClarifyCommercialOccupancyProduct;

    /**
     * Gets the value of the iClarifyResidentialProductOrCommercialPerilScoreProductOrIClarifyCommercialOccupancyProduct property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the iClarifyResidentialProductOrCommercialPerilScoreProductOrIClarifyCommercialOccupancyProduct property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIClarifyResidentialProductOrCommercialPerilScoreProductOrIClarifyCommercialOccupancyProduct().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ActiveWildfiresProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link IClarifyResidentialReportProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link PropertySalesProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link OptaPermitProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link IClarifyCommercialOccupancyProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link IClarifyFinancialResidentialProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link RentalListingsProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link LightSpeedRatesProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link HPIHistoricalProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link ActualCashValueProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link OptaPermitProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link NeighbourhoodNameProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link FUSProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link PremiumAdjustmentFactorsProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link IClarifySnapshotReportProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link LightSpeedCommercialProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link PropertyListingsProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link AerialImageryProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link AddressSearchType }{@code >}
     * {@link JAXBElement }{@code <}{@link WildfireProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link PerilScoresTypes }{@code >}
     * {@link JAXBElement }{@code <}{@link FloodScoreProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link MarketMetricsProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link PropertyStatsProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link ResidentialMarketValuationProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link InsuranceReferralProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link AssessmentListingsProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link BaseProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link EstimatedValueRangeProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link OptaCommercialConstructionFeaturesProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link InspectionScoreProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link BuildingImageryType }{@code >}
     * {@link JAXBElement }{@code <}{@link IClarifyFinancialResidentialProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link BusinessNameDetailsProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link BusinessNamePrefillProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link IClarifyResidentialProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link PropertyLocationProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link PerilScoreProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link MarketValuationConfidenceProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link RentalValuationProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link IClarifyCondoTenantProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link OptaAddressKeyProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link IClarifyCommercialConstructionFeaturesProductType }{@code >}
     * {@link JAXBElement }{@code <}{@link MarketValueComparablesProduct }{@code >}
     * {@link JAXBElement }{@code <}{@link InspectionAttributesProductType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends BaseProductType>> getIClarifyResidentialProductOrCommercialPerilScoreProductOrIClarifyCommercialOccupancyProduct() {
        if (iClarifyResidentialProductOrCommercialPerilScoreProductOrIClarifyCommercialOccupancyProduct == null) {
            iClarifyResidentialProductOrCommercialPerilScoreProductOrIClarifyCommercialOccupancyProduct = new ArrayList<JAXBElement<? extends BaseProductType>>();
        }
        return this.iClarifyResidentialProductOrCommercialPerilScoreProductOrIClarifyCommercialOccupancyProduct;
    }

}
