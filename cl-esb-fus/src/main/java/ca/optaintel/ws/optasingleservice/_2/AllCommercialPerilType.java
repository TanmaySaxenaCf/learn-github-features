
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AllCommercialPerilType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AllCommercialPerilType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="All"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AllCommercialPerilType")
@XmlEnum
public enum AllCommercialPerilType {

    @XmlEnumValue("All")
    ALL("All");
    private final String value;

    AllCommercialPerilType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AllCommercialPerilType fromValue(String v) {
        for (AllCommercialPerilType c: AllCommercialPerilType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
