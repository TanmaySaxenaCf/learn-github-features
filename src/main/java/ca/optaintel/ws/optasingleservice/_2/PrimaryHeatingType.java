
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrimaryHeatingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PrimaryHeatingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Geothermal"/>
 *     &lt;enumeration value="Radiant"/>
 *     &lt;enumeration value="Electric"/>
 *     &lt;enumeration value="Natural Gas Forced Air"/>
 *     &lt;enumeration value="Oil"/>
 *     &lt;enumeration value="Water"/>
 *     &lt;enumeration value="Wood"/>
 *     &lt;enumeration value="Heat Pump"/>
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PrimaryHeatingType")
@XmlEnum
public enum PrimaryHeatingType {

    @XmlEnumValue("Geothermal")
    GEOTHERMAL("Geothermal"),
    @XmlEnumValue("Radiant")
    RADIANT("Radiant"),
    @XmlEnumValue("Electric")
    ELECTRIC("Electric"),
    @XmlEnumValue("Natural Gas Forced Air")
    NATURAL_GAS_FORCED_AIR("Natural Gas Forced Air"),
    @XmlEnumValue("Oil")
    OIL("Oil"),
    @XmlEnumValue("Water")
    WATER("Water"),
    @XmlEnumValue("Wood")
    WOOD("Wood"),
    @XmlEnumValue("Heat Pump")
    HEAT_PUMP("Heat Pump"),
    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    PrimaryHeatingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PrimaryHeatingType fromValue(String v) {
        for (PrimaryHeatingType c: PrimaryHeatingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
