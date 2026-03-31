
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PreferredContactMethodType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PreferredContactMethodType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Email"/>
 *     &lt;enumeration value="Cellular"/>
 *     &lt;enumeration value="Work"/>
 *     &lt;enumeration value="Home"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PreferredContactMethodType")
@XmlEnum
public enum PreferredContactMethodType {

    @XmlEnumValue("Email")
    EMAIL("Email"),
    @XmlEnumValue("Cellular")
    CELLULAR("Cellular"),
    @XmlEnumValue("Work")
    WORK("Work"),
    @XmlEnumValue("Home")
    HOME("Home");
    private final String value;

    PreferredContactMethodType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PreferredContactMethodType fromValue(String v) {
        for (PreferredContactMethodType c: PreferredContactMethodType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
