
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CasualtyCommercialPerilType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CasualtyCommercialPerilType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AllCasualty"/>
 *     &lt;enumeration value="OtherCasualty"/>
 *     &lt;enumeration value="ProductsCompletedOperations"/>
 *     &lt;enumeration value="PremisesOperations"/>
 *     &lt;enumeration value="Automobile"/>
 *     &lt;enumeration value="Employers"/>
 *     &lt;enumeration value="Professional"/>
 *     &lt;enumeration value="Pollution"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CasualtyCommercialPerilType")
@XmlEnum
public enum CasualtyCommercialPerilType {

    @XmlEnumValue("AllCasualty")
    ALL_CASUALTY("AllCasualty"),
    @XmlEnumValue("OtherCasualty")
    OTHER_CASUALTY("OtherCasualty"),
    @XmlEnumValue("ProductsCompletedOperations")
    PRODUCTS_COMPLETED_OPERATIONS("ProductsCompletedOperations"),
    @XmlEnumValue("PremisesOperations")
    PREMISES_OPERATIONS("PremisesOperations"),
    @XmlEnumValue("Automobile")
    AUTOMOBILE("Automobile"),
    @XmlEnumValue("Employers")
    EMPLOYERS("Employers"),
    @XmlEnumValue("Professional")
    PROFESSIONAL("Professional"),
    @XmlEnumValue("Pollution")
    POLLUTION("Pollution");
    private final String value;

    CasualtyCommercialPerilType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CasualtyCommercialPerilType fromValue(String v) {
        for (CasualtyCommercialPerilType c: CasualtyCommercialPerilType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
