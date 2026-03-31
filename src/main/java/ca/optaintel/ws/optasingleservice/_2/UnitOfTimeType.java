
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnitOfTimeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UnitOfTimeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Years"/>
 *     &lt;enumeration value="Months"/>
 *     &lt;enumeration value="Weeks"/>
 *     &lt;enumeration value="Days"/>
 *     &lt;enumeration value="Hours"/>
 *     &lt;enumeration value="Minutes"/>
 *     &lt;enumeration value="Seconds"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UnitOfTimeType")
@XmlEnum
public enum UnitOfTimeType {

    @XmlEnumValue("Years")
    YEARS("Years"),
    @XmlEnumValue("Months")
    MONTHS("Months"),
    @XmlEnumValue("Weeks")
    WEEKS("Weeks"),
    @XmlEnumValue("Days")
    DAYS("Days"),
    @XmlEnumValue("Hours")
    HOURS("Hours"),
    @XmlEnumValue("Minutes")
    MINUTES("Minutes"),
    @XmlEnumValue("Seconds")
    SECONDS("Seconds");
    private final String value;

    UnitOfTimeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UnitOfTimeType fromValue(String v) {
        for (UnitOfTimeType c: UnitOfTimeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
