
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FireDangerRatingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FireDangerRatingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NIL"/>
 *     &lt;enumeration value="Low"/>
 *     &lt;enumeration value="Moderate"/>
 *     &lt;enumeration value="High"/>
 *     &lt;enumeration value="Very High"/>
 *     &lt;enumeration value="Extreme"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FireDangerRatingType")
@XmlEnum
public enum FireDangerRatingType {

    NIL("NIL"),
    @XmlEnumValue("Low")
    LOW("Low"),
    @XmlEnumValue("Moderate")
    MODERATE("Moderate"),
    @XmlEnumValue("High")
    HIGH("High"),
    @XmlEnumValue("Very High")
    VERY_HIGH("Very High"),
    @XmlEnumValue("Extreme")
    EXTREME("Extreme");
    private final String value;

    FireDangerRatingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FireDangerRatingType fromValue(String v) {
        for (FireDangerRatingType c: FireDangerRatingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
