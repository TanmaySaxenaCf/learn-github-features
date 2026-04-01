
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PhoneNumberTypesType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PhoneNumberTypesType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Cellular"/>
 *     &lt;enumeration value="Work"/>
 *     &lt;enumeration value="Home"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PhoneNumberTypesType")
@XmlEnum
public enum PhoneNumberTypesType {

    @XmlEnumValue("Cellular")
    CELLULAR("Cellular"),
    @XmlEnumValue("Work")
    WORK("Work"),
    @XmlEnumValue("Home")
    HOME("Home");
    private final String value;

    PhoneNumberTypesType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PhoneNumberTypesType fromValue(String v) {
        for (PhoneNumberTypesType c: PhoneNumberTypesType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
