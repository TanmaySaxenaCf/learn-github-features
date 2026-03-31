
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SewageType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SewageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Municipal"/>
 *     &lt;enumeration value="Septic System"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SewageType")
@XmlEnum
public enum SewageType {

    @XmlEnumValue("Municipal")
    MUNICIPAL("Municipal"),
    @XmlEnumValue("Septic System")
    SEPTIC_SYSTEM("Septic System"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    SewageType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SewageType fromValue(String v) {
        for (SewageType c: SewageType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
