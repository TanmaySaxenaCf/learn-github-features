
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BooleanWithUnknownType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BooleanWithUnknownType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="true"/>
 *     &lt;enumeration value="false"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BooleanWithUnknownType")
@XmlEnum
public enum BooleanWithUnknownType {

    @XmlEnumValue("true")
    TRUE("true"),
    @XmlEnumValue("false")
    FALSE("false"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    BooleanWithUnknownType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BooleanWithUnknownType fromValue(String v) {
        for (BooleanWithUnknownType c: BooleanWithUnknownType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
