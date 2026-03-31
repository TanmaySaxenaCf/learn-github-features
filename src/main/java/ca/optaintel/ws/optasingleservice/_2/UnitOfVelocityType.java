
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnitOfVelocityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UnitOfVelocityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="KilometresPerHour"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UnitOfVelocityType")
@XmlEnum
public enum UnitOfVelocityType {

    @XmlEnumValue("KilometresPerHour")
    KILOMETRES_PER_HOUR("KilometresPerHour");
    private final String value;

    UnitOfVelocityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UnitOfVelocityType fromValue(String v) {
        for (UnitOfVelocityType c: UnitOfVelocityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
