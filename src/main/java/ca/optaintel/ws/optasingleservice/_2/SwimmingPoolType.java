
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SwimmingPoolType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SwimmingPoolType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Inground Concrete"/>
 *     &lt;enumeration value="Inground Fibre Glass"/>
 *     &lt;enumeration value="Inground Vinyl"/>
 *     &lt;enumeration value="Above Ground"/>
 *     &lt;enumeration value="Above Ground Fibre Glass"/>
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SwimmingPoolType")
@XmlEnum
public enum SwimmingPoolType {

    @XmlEnumValue("Inground Concrete")
    INGROUND_CONCRETE("Inground Concrete"),
    @XmlEnumValue("Inground Fibre Glass")
    INGROUND_FIBRE_GLASS("Inground Fibre Glass"),
    @XmlEnumValue("Inground Vinyl")
    INGROUND_VINYL("Inground Vinyl"),
    @XmlEnumValue("Above Ground")
    ABOVE_GROUND("Above Ground"),
    @XmlEnumValue("Above Ground Fibre Glass")
    ABOVE_GROUND_FIBRE_GLASS("Above Ground Fibre Glass"),
    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    SwimmingPoolType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SwimmingPoolType fromValue(String v) {
        for (SwimmingPoolType c: SwimmingPoolType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
