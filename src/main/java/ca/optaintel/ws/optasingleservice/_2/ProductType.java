
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ProductType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="iClarifyResidential"/>
 *     &lt;enumeration value="iClarifyCommercialOccupancy"/>
 *     &lt;enumeration value="CommercialPerilScore"/>
 *     &lt;enumeration value="FUS"/>
 *     &lt;enumeration value="WildfireIndex"/>
 *     &lt;enumeration value="ResidentialPerilScore"/>
 *     &lt;enumeration value="FloodScore"/>
 *     &lt;enumeration value="InspectionScore"/>
 *     &lt;enumeration value="Attributes"/>
 *     &lt;enumeration value="iClarifyCondoTenant"/>
 *     &lt;enumeration value="ResidentialMarketValuation"/>
 *     &lt;enumeration value="iClarifyResidentialReport"/>
 *     &lt;enumeration value="iClarifyFinancialResidentialReport"/>
 *     &lt;enumeration value="InspectionOrdering"/>
 *     &lt;enumeration value="iClarifyCommercialConstructionFeatures"/>
 *     &lt;enumeration value="BuildingImagery"/>
 *     &lt;enumeration value="AddressSearch"/>
 *     &lt;enumeration value="iClarifyFinancialResidentialPrefill"/>
 *     &lt;enumeration value="OptaAddressKey"/>
 *     &lt;enumeration value="ResidentialReplacementCost"/>
 *     &lt;enumeration value="EstimatedValueRange"/>
 *     &lt;enumeration value="InsuranceReferral"/>
 *     &lt;enumeration value="PropertyLocation"/>
 *     &lt;enumeration value="MarketValueComparables"/>
 *     &lt;enumeration value="MarketValuationConfidence"/>
 *     &lt;enumeration value="RentalValuation"/>
 *     &lt;enumeration value="PropertySales"/>
 *     &lt;enumeration value="PropertyListings"/>
 *     &lt;enumeration value="PropertyStats"/>
 *     &lt;enumeration value="OptaPermit"/>
 *     &lt;enumeration value="OptaPermitFinancial"/>
 *     &lt;enumeration value="AerialImagery"/>
 *     &lt;enumeration value="AssessmentListings"/>
 *     &lt;enumeration value="RentalListings"/>
 *     &lt;enumeration value="iClarifyCondoTenantPerilScore"/>
 *     &lt;enumeration value="MarketMetrics"/>
 *     &lt;enumeration value="NeighbourhoodName"/>
 *     &lt;enumeration value="iClarifySnapshotReport"/>
 *     &lt;enumeration value="OptaCommercialConstructionFeatures"/>
 *     &lt;enumeration value="iClarifyFinancialPrefillLite"/>
 *     &lt;enumeration value="LightspeedCommercial"/>
 *     &lt;enumeration value="HPIHistorical"/>
 *     &lt;enumeration value="LightspeedRates"/>
 *     &lt;enumeration value="ActiveWildfires"/>
 *     &lt;enumeration value="BusinessNamePrefill"/>
 *     &lt;enumeration value="PremiumAdjustmentFactors"/>
 *     &lt;enumeration value="BusinessNameDetails"/>
 *     &lt;enumeration value="ActualCashValue"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ProductType")
@XmlEnum
public enum ProductType {

    @XmlEnumValue("iClarifyResidential")
    I_CLARIFY_RESIDENTIAL("iClarifyResidential"),
    @XmlEnumValue("iClarifyCommercialOccupancy")
    I_CLARIFY_COMMERCIAL_OCCUPANCY("iClarifyCommercialOccupancy"),
    @XmlEnumValue("CommercialPerilScore")
    COMMERCIAL_PERIL_SCORE("CommercialPerilScore"),
    FUS("FUS"),
    @XmlEnumValue("WildfireIndex")
    WILDFIRE_INDEX("WildfireIndex"),
    @XmlEnumValue("ResidentialPerilScore")
    RESIDENTIAL_PERIL_SCORE("ResidentialPerilScore"),
    @XmlEnumValue("FloodScore")
    FLOOD_SCORE("FloodScore"),
    @XmlEnumValue("InspectionScore")
    INSPECTION_SCORE("InspectionScore"),
    @XmlEnumValue("Attributes")
    ATTRIBUTES("Attributes"),
    @XmlEnumValue("iClarifyCondoTenant")
    I_CLARIFY_CONDO_TENANT("iClarifyCondoTenant"),
    @XmlEnumValue("ResidentialMarketValuation")
    RESIDENTIAL_MARKET_VALUATION("ResidentialMarketValuation"),
    @XmlEnumValue("iClarifyResidentialReport")
    I_CLARIFY_RESIDENTIAL_REPORT("iClarifyResidentialReport"),
    @XmlEnumValue("iClarifyFinancialResidentialReport")
    I_CLARIFY_FINANCIAL_RESIDENTIAL_REPORT("iClarifyFinancialResidentialReport"),
    @XmlEnumValue("InspectionOrdering")
    INSPECTION_ORDERING("InspectionOrdering"),
    @XmlEnumValue("iClarifyCommercialConstructionFeatures")
    I_CLARIFY_COMMERCIAL_CONSTRUCTION_FEATURES("iClarifyCommercialConstructionFeatures"),
    @XmlEnumValue("BuildingImagery")
    BUILDING_IMAGERY("BuildingImagery"),
    @XmlEnumValue("AddressSearch")
    ADDRESS_SEARCH("AddressSearch"),
    @XmlEnumValue("iClarifyFinancialResidentialPrefill")
    I_CLARIFY_FINANCIAL_RESIDENTIAL_PREFILL("iClarifyFinancialResidentialPrefill"),
    @XmlEnumValue("OptaAddressKey")
    OPTA_ADDRESS_KEY("OptaAddressKey"),
    @XmlEnumValue("ResidentialReplacementCost")
    RESIDENTIAL_REPLACEMENT_COST("ResidentialReplacementCost"),
    @XmlEnumValue("EstimatedValueRange")
    ESTIMATED_VALUE_RANGE("EstimatedValueRange"),
    @XmlEnumValue("InsuranceReferral")
    INSURANCE_REFERRAL("InsuranceReferral"),
    @XmlEnumValue("PropertyLocation")
    PROPERTY_LOCATION("PropertyLocation"),
    @XmlEnumValue("MarketValueComparables")
    MARKET_VALUE_COMPARABLES("MarketValueComparables"),
    @XmlEnumValue("MarketValuationConfidence")
    MARKET_VALUATION_CONFIDENCE("MarketValuationConfidence"),
    @XmlEnumValue("RentalValuation")
    RENTAL_VALUATION("RentalValuation"),
    @XmlEnumValue("PropertySales")
    PROPERTY_SALES("PropertySales"),
    @XmlEnumValue("PropertyListings")
    PROPERTY_LISTINGS("PropertyListings"),
    @XmlEnumValue("PropertyStats")
    PROPERTY_STATS("PropertyStats"),
    @XmlEnumValue("OptaPermit")
    OPTA_PERMIT("OptaPermit"),
    @XmlEnumValue("OptaPermitFinancial")
    OPTA_PERMIT_FINANCIAL("OptaPermitFinancial"),
    @XmlEnumValue("AerialImagery")
    AERIAL_IMAGERY("AerialImagery"),
    @XmlEnumValue("AssessmentListings")
    ASSESSMENT_LISTINGS("AssessmentListings"),
    @XmlEnumValue("RentalListings")
    RENTAL_LISTINGS("RentalListings"),
    @XmlEnumValue("iClarifyCondoTenantPerilScore")
    I_CLARIFY_CONDO_TENANT_PERIL_SCORE("iClarifyCondoTenantPerilScore"),
    @XmlEnumValue("MarketMetrics")
    MARKET_METRICS("MarketMetrics"),
    @XmlEnumValue("NeighbourhoodName")
    NEIGHBOURHOOD_NAME("NeighbourhoodName"),
    @XmlEnumValue("iClarifySnapshotReport")
    I_CLARIFY_SNAPSHOT_REPORT("iClarifySnapshotReport"),
    @XmlEnumValue("OptaCommercialConstructionFeatures")
    OPTA_COMMERCIAL_CONSTRUCTION_FEATURES("OptaCommercialConstructionFeatures"),
    @XmlEnumValue("iClarifyFinancialPrefillLite")
    I_CLARIFY_FINANCIAL_PREFILL_LITE("iClarifyFinancialPrefillLite"),
    @XmlEnumValue("LightspeedCommercial")
    LIGHTSPEED_COMMERCIAL("LightspeedCommercial"),
    @XmlEnumValue("HPIHistorical")
    HPI_HISTORICAL("HPIHistorical"),
    @XmlEnumValue("LightspeedRates")
    LIGHTSPEED_RATES("LightspeedRates"),
    @XmlEnumValue("ActiveWildfires")
    ACTIVE_WILDFIRES("ActiveWildfires"),
    @XmlEnumValue("BusinessNamePrefill")
    BUSINESS_NAME_PREFILL("BusinessNamePrefill"),
    @XmlEnumValue("PremiumAdjustmentFactors")
    PREMIUM_ADJUSTMENT_FACTORS("PremiumAdjustmentFactors"),
    @XmlEnumValue("BusinessNameDetails")
    BUSINESS_NAME_DETAILS("BusinessNameDetails"),
    @XmlEnumValue("ActualCashValue")
    ACTUAL_CASH_VALUE("ActualCashValue");
    private final String value;

    ProductType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProductType fromValue(String v) {
        for (ProductType c: ProductType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
