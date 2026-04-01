
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MultiResidentialStyleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MultiResidentialStyleType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="High Rise"/>
 *     &lt;enumeration value="Low Rise"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MultiResidentialStyleType")
@XmlEnum
public enum MultiResidentialStyleType {

    @XmlEnumValue("High Rise")
    HIGH_RISE("High Rise"),
    @XmlEnumValue("Low Rise")
    LOW_RISE("Low Rise"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    MultiResidentialStyleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MultiResidentialStyleType fromValue(String v) {
        for (MultiResidentialStyleType c: MultiResidentialStyleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
