
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FireAndSecurityAlarmType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FireAndSecurityAlarmType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Local"/>
 *     &lt;enumeration value="Central"/>
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FireAndSecurityAlarmType")
@XmlEnum
public enum FireAndSecurityAlarmType {

    @XmlEnumValue("Local")
    LOCAL("Local"),
    @XmlEnumValue("Central")
    CENTRAL("Central"),
    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    FireAndSecurityAlarmType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FireAndSecurityAlarmType fromValue(String v) {
        for (FireAndSecurityAlarmType c: FireAndSecurityAlarmType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
