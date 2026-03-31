
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyCommercialPerilType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PropertyCommercialPerilType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AllProperty"/>
 *     &lt;enumeration value="Water"/>
 *     &lt;enumeration value="Fire"/>
 *     &lt;enumeration value="WindHail"/>
 *     &lt;enumeration value="Wind"/>
 *     &lt;enumeration value="Crime"/>
 *     &lt;enumeration value="OtherBusinessInterruption"/>
 *     &lt;enumeration value="VehicleImpact"/>
 *     &lt;enumeration value="OtherProperty"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PropertyCommercialPerilType")
@XmlEnum
public enum PropertyCommercialPerilType {

    @XmlEnumValue("AllProperty")
    ALL_PROPERTY("AllProperty"),
    @XmlEnumValue("Water")
    WATER("Water"),
    @XmlEnumValue("Fire")
    FIRE("Fire"),
    @XmlEnumValue("WindHail")
    WIND_HAIL("WindHail"),
    @XmlEnumValue("Wind")
    WIND("Wind"),
    @XmlEnumValue("Crime")
    CRIME("Crime"),
    @XmlEnumValue("OtherBusinessInterruption")
    OTHER_BUSINESS_INTERRUPTION("OtherBusinessInterruption"),
    @XmlEnumValue("VehicleImpact")
    VEHICLE_IMPACT("VehicleImpact"),
    @XmlEnumValue("OtherProperty")
    OTHER_PROPERTY("OtherProperty");
    private final String value;

    PropertyCommercialPerilType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PropertyCommercialPerilType fromValue(String v) {
        for (PropertyCommercialPerilType c: PropertyCommercialPerilType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
