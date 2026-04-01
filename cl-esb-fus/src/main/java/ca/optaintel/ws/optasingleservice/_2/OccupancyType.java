
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OccupancyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OccupancyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Primary"/>
 *     &lt;enumeration value="SecondarySeasonal"/>
 *     &lt;enumeration value="SecondaryNonSeasonal"/>
 *     &lt;enumeration value="Rental"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OccupancyType")
@XmlEnum
public enum OccupancyType {

    @XmlEnumValue("Primary")
    PRIMARY("Primary"),
    @XmlEnumValue("SecondarySeasonal")
    SECONDARY_SEASONAL("SecondarySeasonal"),
    @XmlEnumValue("SecondaryNonSeasonal")
    SECONDARY_NON_SEASONAL("SecondaryNonSeasonal"),
    @XmlEnumValue("Rental")
    RENTAL("Rental");
    private final String value;

    OccupancyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OccupancyType fromValue(String v) {
        for (OccupancyType c: OccupancyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
