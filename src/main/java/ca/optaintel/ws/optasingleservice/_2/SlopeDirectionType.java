
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SlopeDirectionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SlopeDirectionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="North"/>
 *     &lt;enumeration value="Northeast"/>
 *     &lt;enumeration value="East"/>
 *     &lt;enumeration value="Southeast"/>
 *     &lt;enumeration value="South"/>
 *     &lt;enumeration value="Southwest"/>
 *     &lt;enumeration value="West"/>
 *     &lt;enumeration value="Northwest"/>
 *     &lt;enumeration value="No Slope Detected"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SlopeDirectionType")
@XmlEnum
public enum SlopeDirectionType {

    @XmlEnumValue("North")
    NORTH("North"),
    @XmlEnumValue("Northeast")
    NORTHEAST("Northeast"),
    @XmlEnumValue("East")
    EAST("East"),
    @XmlEnumValue("Southeast")
    SOUTHEAST("Southeast"),
    @XmlEnumValue("South")
    SOUTH("South"),
    @XmlEnumValue("Southwest")
    SOUTHWEST("Southwest"),
    @XmlEnumValue("West")
    WEST("West"),
    @XmlEnumValue("Northwest")
    NORTHWEST("Northwest"),
    @XmlEnumValue("No Slope Detected")
    NO_SLOPE_DETECTED("No Slope Detected");
    private final String value;

    SlopeDirectionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SlopeDirectionType fromValue(String v) {
        for (SlopeDirectionType c: SlopeDirectionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
