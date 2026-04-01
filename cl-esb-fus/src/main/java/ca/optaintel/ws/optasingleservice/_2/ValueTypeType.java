
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValueTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ValueTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MarketValuation"/>
 *     &lt;enumeration value="SoldPrice"/>
 *     &lt;enumeration value="ListingPrice"/>
 *     &lt;enumeration value="AssessmentListings"/>
 *     &lt;enumeration value="RentalListings"/>
 *     &lt;enumeration value="HistoricalIndex"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ValueTypeType")
@XmlEnum
public enum ValueTypeType {

    @XmlEnumValue("MarketValuation")
    MARKET_VALUATION("MarketValuation"),
    @XmlEnumValue("SoldPrice")
    SOLD_PRICE("SoldPrice"),
    @XmlEnumValue("ListingPrice")
    LISTING_PRICE("ListingPrice"),
    @XmlEnumValue("AssessmentListings")
    ASSESSMENT_LISTINGS("AssessmentListings"),
    @XmlEnumValue("RentalListings")
    RENTAL_LISTINGS("RentalListings"),
    @XmlEnumValue("HistoricalIndex")
    HISTORICAL_INDEX("HistoricalIndex");
    private final String value;

    ValueTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ValueTypeType fromValue(String v) {
        for (ValueTypeType c: ValueTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
