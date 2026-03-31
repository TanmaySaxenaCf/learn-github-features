
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SprinklerProtectionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SprinklerProtectionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Full"/>
 *     &lt;enumeration value="Partial"/>
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SprinklerProtectionType")
@XmlEnum
public enum SprinklerProtectionType {

    @XmlEnumValue("Full")
    FULL("Full"),
    @XmlEnumValue("Partial")
    PARTIAL("Partial"),
    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    SprinklerProtectionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SprinklerProtectionType fromValue(String v) {
        for (SprinklerProtectionType c: SprinklerProtectionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
