
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyOccupancyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PropertyOccupancyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Owner Occupied"/>
 *     &lt;enumeration value="Rental"/>
 *     &lt;enumeration value="Vacant"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PropertyOccupancyType")
@XmlEnum
public enum PropertyOccupancyType {

    @XmlEnumValue("Owner Occupied")
    OWNER_OCCUPIED("Owner Occupied"),
    @XmlEnumValue("Rental")
    RENTAL("Rental"),
    @XmlEnumValue("Vacant")
    VACANT("Vacant"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    PropertyOccupancyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PropertyOccupancyType fromValue(String v) {
        for (PropertyOccupancyType c: PropertyOccupancyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
