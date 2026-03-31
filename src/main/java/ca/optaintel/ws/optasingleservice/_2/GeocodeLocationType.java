
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeocodeLocationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GeocodeLocationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Roof Top"/>
 *     &lt;enumeration value="Street Level"/>
 *     &lt;enumeration value="Neighbourhood"/>
 *     &lt;enumeration value="Municipal"/>
 *     &lt;enumeration value="Regional"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GeocodeLocationType")
@XmlEnum
public enum GeocodeLocationType {

    @XmlEnumValue("Roof Top")
    ROOF_TOP("Roof Top"),
    @XmlEnumValue("Street Level")
    STREET_LEVEL("Street Level"),
    @XmlEnumValue("Neighbourhood")
    NEIGHBOURHOOD("Neighbourhood"),
    @XmlEnumValue("Municipal")
    MUNICIPAL("Municipal"),
    @XmlEnumValue("Regional")
    REGIONAL("Regional");
    private final String value;

    GeocodeLocationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GeocodeLocationType fromValue(String v) {
        for (GeocodeLocationType c: GeocodeLocationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
