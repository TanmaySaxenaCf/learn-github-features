
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OwnershipType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OwnershipType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Owned"/>
 *     &lt;enumeration value="Rented"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OwnershipType")
@XmlEnum
public enum OwnershipType {

    @XmlEnumValue("Owned")
    OWNED("Owned"),
    @XmlEnumValue("Rented")
    RENTED("Rented");
    private final String value;

    OwnershipType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OwnershipType fromValue(String v) {
        for (OwnershipType c: OwnershipType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
